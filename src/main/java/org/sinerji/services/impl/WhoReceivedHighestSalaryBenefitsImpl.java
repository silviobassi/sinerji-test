package org.sinerji.services.impl;

import org.sinerji.infra.AssignHigherEmployeePaymentProcessed;
import org.sinerji.infra.impl.HighestSalaryAndBenefitSecretaryImpl;
import org.sinerji.infra.impl.HigherSalaryAndBenefitSellerImpl;
import org.sinerji.infra.impl.HighestSalaryAndManagerImpl;
import org.sinerji.models.*;
import org.sinerji.services.WhoReceivedTheMostService;

import java.time.YearMonth;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WhoReceivedHighestSalaryBenefitsImpl implements WhoReceivedTheMostService<Employee> {
    public Set<EmployeeGreater> receivedTheMost(YearMonth yearMonth, List<Employee> employees) {

        Set<EmployeeGreater> employeesGreaterList = new HashSet<>();

        Set<EmployeeGreater> employeeGreats = employees.stream()
                .filter(employee -> employee.getYearsMonthsPayment()
                        .stream().anyMatch(yearMonth1 -> yearMonth1.equals(yearMonth)))
                .map(employee -> {
                    AssignHigherEmployeePaymentProcessed.biggestOfficial
                            (new HighestSalaryAndManagerImpl(), employee, employeesGreaterList);

                   AssignHigherEmployeePaymentProcessed.biggestOfficial(
                           new HighestSalaryAndBenefitSecretaryImpl(), employee, employeesGreaterList);

                    AssignHigherEmployeePaymentProcessed.biggestOfficial(
                            new HigherSalaryAndBenefitSellerImpl(), employee, employeesGreaterList, yearMonth);

                    return employeesGreaterList;
                }).flatMap(Set::stream).collect(Collectors.toSet());

        return EmployeeGreater.getWhoWonTheMost(employeeGreats);

    }

}
