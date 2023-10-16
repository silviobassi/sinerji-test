package org.sinerji.services;

import org.sinerji.models.Employee;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public interface Payment {

    Optional<BigDecimal> getTotalPayment(List<Employee> employees, YearMonth yearMonth);

}
