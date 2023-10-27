package org.sinerji.infra.impl;

import org.sinerji.enums.BenefitType;
import org.sinerji.enums.Office;
import org.sinerji.infra.CalculateBenefitService;
import org.sinerji.models.Employee;
import org.sinerji.models.Secretary;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class CalculateBenefitSecretaryImpl implements CalculateBenefitService {
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
