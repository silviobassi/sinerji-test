package org.sinerji.services;

import org.sinerji.models.Employee;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class Payment {

    public static Optional<BigDecimal>  setPayment(PaymentService paymentService, List<Employee> employees, YearMonth yearMonth){
        return paymentService.getPayment(employees, yearMonth);
    }

}
