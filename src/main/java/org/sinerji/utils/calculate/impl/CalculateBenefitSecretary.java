package org.sinerji.utils.calculate.impl;

import org.sinerji.enums.BenefitType;
import org.sinerji.enums.Office;
import org.sinerji.models.Employee;
import org.sinerji.models.Secretary;
import org.sinerji.utils.calculate.CalculateBenefitService;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class CalculateBenefitSecretary implements CalculateBenefitService {
    @Override
    public Optional<BigDecimal> getTotalBenefits(List<Employee> employees, YearMonth yearMonth) {
        return employees.stream()
                .filter(employee -> !employee.getSalaryDescription().getBenefitType().equals(BenefitType.NO_BENEFITS))
                .filter(employee -> employee.getOffice().equals(Office.SECRETARY))
                .filter(employee -> employee.getYearsMonthsPayment().stream()
                        .anyMatch(yearMonthCurrent -> yearMonthCurrent.equals(yearMonth)))
                .map(employee -> employee.getSalaryDescription().getPayment().multiply(Secretary.BENEFIT))
                .reduce(BigDecimal::add);
    }
}
