package org.sinerji.utils.calculate.impl;

import org.sinerji.enums.BenefitType;
import org.sinerji.enums.Office;
import org.sinerji.models.Employee;
import org.sinerji.utils.calculate.CalculatePaymentService;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class CalculateSalarySeller implements CalculatePaymentService {
    @Override
    public Optional<BigDecimal> getTotal(List<Employee> employees, YearMonth yearMonth) {
        return employees.stream()
                .filter(seller -> !seller.getSalaryDescription().getBenefitType().equals(BenefitType.NO_BENEFITS))
                .filter(seller -> seller.getOffice().equals(Office.SELLER))
                .filter(employee -> employee.getYearsMonthsPayment().stream()
                        .anyMatch(yearMonthCurrent -> yearMonthCurrent.equals(yearMonth)))
                .map(employee -> employee.getSalaryDescription().getPayment())
                .reduce(BigDecimal::add);
    }

}
