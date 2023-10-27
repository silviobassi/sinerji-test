package org.sinerji.infra;

import org.sinerji.models.Employee;
import org.sinerji.models.EmployeeGreater;

import java.time.YearMonth;
import java.util.Set;

public interface AssignHigherPaymentSeller {

    void toTheEmployee(Employee employee, Set<EmployeeGreater> employeesGreaterList, YearMonth yearMonth);
}
