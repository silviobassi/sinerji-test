package org.sinerji.services;

import org.sinerji.models.Employee;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public interface PaymentService {
    Optional<BigDecimal> getPayment(List<Employee> employees, YearMonth yearMonth);
}
