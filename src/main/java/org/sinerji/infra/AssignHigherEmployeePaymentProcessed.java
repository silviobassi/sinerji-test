package org.sinerji.infra;

import org.sinerji.models.Employee;
import org.sinerji.models.EmployeeGreater;

import java.time.YearMonth;
import java.util.Set;

public class AssignHigherEmployeePaymentProcessed {

    public static void biggestOfficial(HigherSalaryAndBenefits higherSalaryAndBenefits, Employee employee, Set<EmployeeGreater> employeesGreaterList){
        higherSalaryAndBenefits.toTheEmployee(employee, employeesGreaterList);
    }

    public static void biggestOfficial(AssignHigherPaymentSeller assignHigherPaymentSeller, Employee employee,
                                       Set<EmployeeGreater> employeesGreaterList, YearMonth yearMonth){
        assignHigherPaymentSeller.toTheEmployee(employee, employeesGreaterList, yearMonth);
    }
}
