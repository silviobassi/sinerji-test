package org.sinerji.services.impl;

import org.sinerji.models.Employee;
import org.sinerji.services.ReceivedProcessed;
import org.sinerji.services.ReceivedService;
import org.sinerji.services.WhoReceivedTheMostService;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WhoReceivedTheMost implements WhoReceivedTheMostService {


    @Override
    public Set<Employee> receivedTheMost(YearMonth yearMonth, List<Employee> employees) {

        BigDecimal updateValue = BigDecimal.ZERO;
        Set<Employee> employeeFeatured = new HashSet<>();

        for(Employee employee: employees){
            ReceivedProcessed.setEmployeeTheMost(
                    new WhoReceivedSecretaryTheMost(), yearMonth, employee, updateValue, employeeFeatured);
            ReceivedProcessed.setEmployeeTheMost(
                    new WhoReceivedSellerTheMost(), yearMonth, employee, updateValue, employeeFeatured);
            ReceivedProcessed.setEmployeeTheMost(
                    new WhoReceivedManagerTheMost(), yearMonth, employee, updateValue, employeeFeatured);
        }

        return employeeFeatured;
    }

}
