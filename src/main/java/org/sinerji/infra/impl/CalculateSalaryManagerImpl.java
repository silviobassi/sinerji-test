package org.sinerji.infra.impl;

import org.sinerji.enums.BenefitType;
import org.sinerji.enums.Office;
import org.sinerji.infra.CalculatePaymentService;
import org.sinerji.models.Employee;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class CalculateSalaryManagerImpl implements CalculatePaymentService {
    @Override
    public Optional<BigDecimal> getTotal(List<Employee> employees, YearMonth yearMonth) {
        return employees.stream()
                .filter(manager -> manager.getSalaryDescription().getBenefitType().equals(BenefitType.NO_BENEFITS))
                .filter(manager -> manager.getOffice().equals(Office.MANAGER))
                .filter(manager -> manager.getYearsMonthsPayment().stream()
                        .anyMatch(yearMonthCurrent -> yearMonthCurrent.equals(yearMonth)))
                .map(manager -> manager.getSalaryDescription().getPayment())
                .reduce(BigDecimal::add);
    }
}
