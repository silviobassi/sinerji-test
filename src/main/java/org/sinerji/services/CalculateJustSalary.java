package org.sinerji.services;

import org.sinerji.models.Employee;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class CalculateJustSalary implements Greater{
    @Override
    public Optional<BigDecimal> payment(List<Employee> employees, YearMonth yearMonth) {
        return employees.stream()
                .filter(employee -> employee.getSalaryPayments().stream().anyMatch(payment -> payment.isYearAndMonth(yearMonth)))
                .map(employee -> employee.getSalaryDescription().getValue())
                .reduce(BigDecimal::add);
    }
}
