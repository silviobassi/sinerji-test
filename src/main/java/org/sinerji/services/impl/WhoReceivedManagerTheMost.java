package org.sinerji.services.impl;

import org.sinerji.models.Employee;
import org.sinerji.services.ReceivedService;
import org.sinerji.services.WhoReceivedTheMostService;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Set;

public class WhoReceivedManagerTheMost implements ReceivedService {

    @Override
    public Set<Employee> receivedTheMost(YearMonth yearMonth, Employee employee,
                                         BigDecimal updateValue, Set<Employee> employeeFeatured) {

            if (employee.isManager()) {
                for (YearMonth yearMonthCurrent : employee.getYearsMonthsPayment()) {
                    if (yearMonthCurrent.equals(yearMonth)) {
                        var salaryManager = employee.getSalaryDescription().getPayment();
                        if (salaryManager.compareTo(updateValue) > 0) {
                            employeeFeatured.clear();
                            updateValue = salaryManager;
                            employeeFeatured.add(employee);
                        }
                    }
                }
            }

        return employeeFeatured;
    }
}
