package org.sinerji.services;

import org.sinerji.models.Employee;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Set;

public interface ReceivedService {

    Set<Employee> receivedTheMost(YearMonth yearMonth, Employee employee, BigDecimal updateValue, Set<Employee> employeeFeatured);
}
