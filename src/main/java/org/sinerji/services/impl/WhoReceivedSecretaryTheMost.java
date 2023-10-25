package org.sinerji.services.impl;

import org.sinerji.models.Employee;
import org.sinerji.services.ReceivedProcessed;
import org.sinerji.services.ReceivedService;
import org.sinerji.services.WhoReceivedTheMostService;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Set;

public class WhoReceivedSecretaryTheMost implements ReceivedService {

    @Override
    public Set<Employee> receivedTheMost(YearMonth yearMonth, Employee employee, BigDecimal updateValue, Set<Employee> employeeFeatured) {

            if (employee.isSecretary()) {
                for (YearMonth yearMonthCurrent : employee.getYearsMonthsPayment()) {
                    if (yearMonthCurrent.equals(yearMonth)) {
                        var salarySecretary = employee.getSalaryDescription().getPayment()
                                .multiply(BigDecimal.ONE.add(employee.getSalaryDescription().getPayment()));
                        if (salarySecretary.compareTo(updateValue) > 0) {
                            employeeFeatured.clear();
                            updateValue = salarySecretary;
                            employeeFeatured.add(employee);
                        }
                    }
                }
            }
        return employeeFeatured;
    }
}
