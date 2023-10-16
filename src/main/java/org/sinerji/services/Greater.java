package org.sinerji.services;

import org.sinerji.models.Employee;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public interface Greater {
    Optional<BigDecimal> payment(List<Employee> employees, YearMonth yearMonth);
}
