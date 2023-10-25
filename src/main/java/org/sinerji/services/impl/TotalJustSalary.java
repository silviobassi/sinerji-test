package org.sinerji.services.impl;

import org.sinerji.models.Employee;
import org.sinerji.services.PaymentProcessed;
import org.sinerji.services.PaymentService;
import org.sinerji.utils.calculate.impl.CalculateSalaryEmployee;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class TotalJustSalary implements PaymentService {
    @Override
    public Optional<BigDecimal> getPayment(List<Employee> employees, YearMonth yearMonth) {
        return PaymentProcessed.setCalculated(new CalculateSalaryEmployee(), employees, yearMonth);
    }
}
