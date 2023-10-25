package org.sinerji.services;

import org.sinerji.models.Employee;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Set;

public class Received {

    public static Set<Employee> setEmployeeReceived(WhoReceivedTheMostService mostService, YearMonth yearMonth, List<Employee> employees){
        return mostService.receivedTheMost(yearMonth, employees);
    }
}
