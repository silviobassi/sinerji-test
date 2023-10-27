package org.sinerji.services.impl;

import org.sinerji.enums.BenefitType;
import org.sinerji.infra.AssignsEmployeeWhoReceivedMostProcessed;
import org.sinerji.models.*;
import org.sinerji.services.WhoReceivedTheMostService;

import java.time.YearMonth;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WhoReceivedBiggestBenefitImpl implements WhoReceivedTheMostService<Employee> {
    public Set<EmployeeGreater> receivedTheMost(YearMonth yearMonth, List<Employee> employees) {

        Set<EmployeeGreater> employeesGreaterList = new HashSet<>();

        Set<EmployeeGreater> employeeGreats = employees.stream()
                .filter(employee -> employee.getYearsMonthsPayment()
                        .stream().anyMatch(yearMonth1 -> yearMonth1.equals(yearMonth)))
                .filter(employee -> !employee.getSalaryDescription().getBenefitType().equals(BenefitType.NO_BENEFITS))
                .map(employee -> {

                    AssignsEmployeeWhoReceivedMostProcessed.biggestOfficial(new Employee(), employee, employeesGreaterList);
                    AssignsEmployeeWhoReceivedMostProcessed.biggestOfficial(new Employee(), employee, employeesGreaterList, yearMonth);

                    return employeesGreaterList;
                }).flatMap(Set::stream).collect(Collectors.toSet());

        return EmployeeGreater.getWhoWonTheMost(employeeGreats);
    }
}
