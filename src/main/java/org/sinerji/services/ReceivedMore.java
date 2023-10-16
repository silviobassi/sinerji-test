package org.sinerji.services;

import org.sinerji.models.Employee;

import java.time.YearMonth;
import java.util.List;

public interface ReceivedMore {

    String getEmployeeWithGreaterSalaryOfMonth(List<Employee> employees, YearMonth yearMonth);
}
