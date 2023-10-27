package org.sinerji.infra.impl;

import org.sinerji.infra.HigherSalaryAndBenefits;
import org.sinerji.models.Employee;
import org.sinerji.models.EmployeeGreater;

import java.math.BigDecimal;
import java.util.Set;

public class HighestSalaryAndManagerImpl implements HigherSalaryAndBenefits {
    @Override
    public void toTheEmployee(Employee employee, Set<EmployeeGreater> employeesGreaterList) {
        if (employee.isManager()) {
            EmployeeGreater employeeGreater = new EmployeeGreater(employee.getName(),
                    employee.sumSalary(employee).orElse(BigDecimal.ZERO));
            employeesGreaterList.add(employeeGreater);
        }
    }

}
