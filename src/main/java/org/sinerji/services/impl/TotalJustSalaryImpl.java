package org.sinerji.services.impl;

import org.sinerji.models.Employee;
import org.sinerji.services.PaymentProcessed;
import org.sinerji.services.TotalPaymentService;
import org.sinerji.infra.impl.CalculateSalaryEmployeeImpl;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class TotalJustSalaryImpl implements TotalPaymentService {
    @Override
    public Optional<BigDecimal> getPayment(List<Employee> employees, YearMonth yearMonth) {
        return PaymentProcessed.setCalculated(new CalculateSalaryEmployeeImpl(), employees, yearMonth);
    }
}
