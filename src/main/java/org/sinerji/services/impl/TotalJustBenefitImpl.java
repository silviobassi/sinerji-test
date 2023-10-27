package org.sinerji.services.impl;

import org.sinerji.models.Employee;
import org.sinerji.infra.impl.CalculateBenefitEmployeeImpl;
import org.sinerji.services.PaymentProcessed;
import org.sinerji.services.TotalPaymentService;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class TotalJustBenefitImpl implements TotalPaymentService {
    @Override
    public Optional<BigDecimal> getPayment(List<Employee> employees, YearMonth yearMonth) {
        return PaymentProcessed.setCalculated(new CalculateBenefitEmployeeImpl(), employees, yearMonth);
    }
}
