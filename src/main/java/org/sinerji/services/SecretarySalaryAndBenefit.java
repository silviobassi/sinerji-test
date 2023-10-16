package org.sinerji.services;

import org.sinerji.enums.Office;
import org.sinerji.models.Employee;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class SecretarySalaryAndBenefit implements Greater{
    @Override
    public Optional<BigDecimal> payment(List<Employee> employees, YearMonth yearMonth) {
        return employees.stream()
                .filter(employee -> employee.getOffice().equals(Office.SECRETARY))
                .filter(employee -> employee.getSalaryPayments().stream().anyMatch(payment -> payment.isYearAndMonth(yearMonth)))
                .map(employee -> employee.getSalaryDescription().getValue()
                        .multiply(BigDecimal.ONE.add(employee.getSalaryDescription().getBenefit())))
                .reduce(BigDecimal::add);
    }
}
