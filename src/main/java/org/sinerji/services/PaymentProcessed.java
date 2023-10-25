package org.sinerji.services;

import org.sinerji.models.Employee;
import org.sinerji.utils.calculate.CalculatePaymentService;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class PaymentProcessed {

    public static Optional<BigDecimal> setCalculated(CalculatePaymentService calculatePaymentService,
                                                     List<Employee> employees, YearMonth yearMonth){
        return calculatePaymentService.getTotal(employees, yearMonth);
    }
}
