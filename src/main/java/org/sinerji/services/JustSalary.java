package org.sinerji.services;

import org.sinerji.models.Employee;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class JustSalary implements Payment {

    @Override
    public Optional<BigDecimal> getTotalPayment(List<Employee> employees, YearMonth yearMonth) {

        Greater justSalary = new CalculateJustSalary();
        Optional<BigDecimal> salary = justSalary.payment(employees, yearMonth);
        var salaryOfMonth = salary.orElse(BigDecimal.ZERO);
        return Optional.of(salaryOfMonth);

    }


}
