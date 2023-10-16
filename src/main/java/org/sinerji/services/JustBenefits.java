package org.sinerji.services;

import org.sinerji.models.Employee;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class JustBenefits implements Payment {

    @Override
    public Optional<BigDecimal> getTotalPayment(List<Employee> employees, YearMonth yearMonth) {

        Greater justBenefits = new CalculateJustBenefit();

        Optional<BigDecimal> benefits = justBenefits.payment(employees, yearMonth);
        var benefitsOfMonth = benefits.orElse(BigDecimal.ZERO);
        return Optional.of(benefitsOfMonth);
    }





}
