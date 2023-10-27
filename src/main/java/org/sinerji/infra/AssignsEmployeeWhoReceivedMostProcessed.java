package org.sinerji.infra;

import org.sinerji.models.Employee;
import org.sinerji.models.EmployeeGreater;
import org.sinerji.models.FindEmployeeWithHighestPay;

import java.time.YearMonth;
import java.util.Set;

public class AssignsEmployeeWhoReceivedMostProcessed {

    public static void biggestOfficial(FindEmployeeWithHighestPay findEmployeeWithHighestPay, Employee employee, Set<EmployeeGreater> employeesGreaterList){
        findEmployeeWithHighestPay.toTheEmployee(employee, employeesGreaterList);
    }

    public static void biggestOfficial(FindEmployeeWithHighestPay findEmployeeWithHighestPay,
                                       Employee employee, Set<EmployeeGreater> employeesGreaterList, YearMonth yearMonth){
        findEmployeeWithHighestPay.toTheEmployee(employee, employeesGreaterList, yearMonth);
    }
}
