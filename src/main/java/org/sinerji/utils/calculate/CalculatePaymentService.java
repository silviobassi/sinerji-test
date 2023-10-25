package org.sinerji.utils.calculate;

import org.sinerji.models.Employee;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public interface CalculatePaymentService {

    Optional<BigDecimal> getTotal(List<Employee> employees, YearMonth yearMonth);
}
