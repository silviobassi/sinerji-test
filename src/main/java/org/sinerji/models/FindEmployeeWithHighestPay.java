package org.sinerji.models;

import java.time.YearMonth;
import java.util.Set;

public interface FindEmployeeWithHighestPay {

    void toTheEmployee(Employee employee, Set<EmployeeGreater> employeesGreaterList);

    void toTheEmployee(Employee employee, Set<EmployeeGreater> employeesGreaterList, YearMonth yearMonth);
}
