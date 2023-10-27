package org.sinerji.infra;

import org.sinerji.models.Employee;
import org.sinerji.models.EmployeeGreater;

import java.util.Set;

public interface HigherSalaryAndBenefits {

    void toTheEmployee(Employee employee, Set<EmployeeGreater> employeesGreaterList);
}
