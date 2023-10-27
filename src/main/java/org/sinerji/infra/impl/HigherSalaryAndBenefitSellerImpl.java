package org.sinerji.infra.impl;

import org.sinerji.infra.AssignHigherPaymentSeller;
import org.sinerji.models.Employee;
import org.sinerji.models.EmployeeGreater;
import org.sinerji.models.Seller;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Set;

public class HigherSalaryAndBenefitSellerImpl implements AssignHigherPaymentSeller {

    public void toTheEmployee(Employee employee, Set<EmployeeGreater> employeesGreaterList, YearMonth yearMonth) {
        if (employee.isSeller()) {
            EmployeeGreater employeeGreater = new EmployeeGreater(
                    employee.getName(),
                    employee.sumSalary(employee).orElse(BigDecimal.ZERO).add(
                            new Seller().sumBenefit(yearMonth, employee).orElse(BigDecimal.ZERO)
                    )
            );
            employeesGreaterList.add(employeeGreater);
        }
    }
}
