package org.sinerji.infra.impl;

import org.sinerji.infra.HigherSalaryAndBenefits;
import org.sinerji.models.Employee;
import org.sinerji.models.EmployeeGreater;
import org.sinerji.models.Secretary;

import java.math.BigDecimal;
import java.util.Set;

public class HighestSalaryAndBenefitSecretaryImpl implements HigherSalaryAndBenefits {


    @Override
    public void toTheEmployee(Employee employee, Set<EmployeeGreater> employeesGreaterList) {
        if (employee.isSecretary()) {
            EmployeeGreater employeeGreater = new EmployeeGreater(
                    employee.getName(),
                    new Secretary().sumSalaryAndBenefit(employee).orElse(BigDecimal.ZERO)
            );
            employeesGreaterList.add(employeeGreater);
        }
    }
}
