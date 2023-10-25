package org.sinerji.utils.calculate.impl;

import org.sinerji.enums.BenefitType;
import org.sinerji.enums.Office;
import org.sinerji.models.Employee;
import org.sinerji.models.Seller;
import org.sinerji.utils.calculate.CalculateBenefitService;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class CalculateBenefitSeller implements CalculateBenefitService {


    @Override
    public Optional<BigDecimal> getTotalBenefits(List<Employee> employees, YearMonth yearMonth) {
        return employees.stream()
                .filter(employee -> !employee.getSalaryDescription().getBenefitType().equals(BenefitType.NO_BENEFITS))
                .filter(employee -> employee.getOffice().equals(Office.SELLER))
                .flatMap(employee -> employee.getSales().stream())
                .filter(sale -> sale.isYearAndMonth(yearMonth))
                .map(sale -> sale.getValue().multiply(Seller.BENEFIT))
                .reduce(BigDecimal::add);
    }
}
