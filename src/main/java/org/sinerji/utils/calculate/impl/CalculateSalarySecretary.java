package org.sinerji.utils.calculate.impl;

import org.sinerji.enums.BenefitType;
import org.sinerji.enums.Office;
import org.sinerji.models.Employee;
import org.sinerji.utils.calculate.CalculatePaymentService;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class CalculateSalarySecretary implements CalculatePaymentService {
    @Override
    public Optional<BigDecimal> getTotal(List<Employee> employees, YearMonth yearMonth) {
        return employees.stream()
                .filter(employee -> !employee.getSalaryDescription().getBenefitType().equals(BenefitType.NO_BENEFITS))
                .filter(secretary -> secretary.getOffice().equals(Office.SECRETARY))
                .filter(secretary -> secretary.getYearsMonthsPayment().stream()
                        .anyMatch(yearMonthCurrent -> yearMonthCurrent.equals(yearMonth)))
                .map(seller -> seller.getSalaryDescription().getPayment())
                .reduce(BigDecimal::add);
    }
}
