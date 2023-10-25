package org.sinerji.services.impl;

import org.sinerji.models.Employee;
import org.sinerji.models.Sale;
import org.sinerji.models.Seller;
import org.sinerji.services.ReceivedService;
import org.sinerji.services.WhoReceivedTheMostService;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Set;

public class WhoReceivedSellerTheMost implements ReceivedService {

    @Override
    public Set<Employee> receivedTheMost(YearMonth yearMonth, Employee employee, BigDecimal updateValue, Set<Employee> employeeFeatured) {
            if (employee.isSeller()) {
                for (YearMonth yearMonthCurrent : employee.getYearsMonthsPayment()) {
                    if (yearMonthCurrent.equals(yearMonth)) {
                        for (Sale sale : employee.getSales()) {
                            if (sale.isYearAndMonth(yearMonth)) {
                                var salarySecretary = employee.getSalaryDescription().getPayment()
                                        .add(sale.getValue().multiply(Seller.BENEFIT));
                                if (salarySecretary.compareTo(updateValue) > 0) {
                                    updateValue = salarySecretary;
                                    employeeFeatured.clear();
                                    employeeFeatured.add(employee);
                                }
                            }
                        }

                    }
                }
            }
        return employeeFeatured;
    }
}
