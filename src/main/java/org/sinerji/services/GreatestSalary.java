package org.sinerji.services;

import org.sinerji.enums.Office;
import org.sinerji.models.Employee;
import org.sinerji.models.Sale;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;

public class GreatestSalary implements ReceivedMore {
    @Override
    public String getEmployeeWithGreaterSalaryOfMonth(List<Employee> employees, YearMonth yearMonth) {

        String employeeOfMonth = null;
        BigDecimal greaterSalary = BigDecimal.ZERO;

        List<Employee> managers = getAllManagers(employees, yearMonth);
        List<Employee> secretaries = getAllSecretaries(employees, yearMonth);
        List<Employee> sellers = getAllSellers(employees, yearMonth);

        employeeOfMonth = assignCalculationSecretary(secretaries, greaterSalary, employeeOfMonth);
        employeeOfMonth = assignCalculationSellers(yearMonth, sellers, greaterSalary, employeeOfMonth);
        employeeOfMonth = assignCalculationManager(managers, greaterSalary, employeeOfMonth);

        return employeeOfMonth;
    }

    private static String assignCalculationSellers(YearMonth yearMonth, List<Employee> sellers, BigDecimal greaterSalary, String employeeOfMonth) {
        for (Employee seller : sellers) {
            if (seller.getOffice().equals(Office.SELLER))
                for (Sale sale : seller.getSales()) {
                    if (sale.isYearAndMonth(yearMonth))
                        if (seller.getSalaryDescription().getValue()
                                .add((sale.getValue().multiply(seller.getSalaryDescription().getBenefit())))
                                .compareTo(greaterSalary) > 0) {

                            greaterSalary = greaterSalary.add(seller.getSalaryDescription().getValue()
                                    .add((sale.getValue().multiply(seller.getSalaryDescription().getBenefit()))));
                            employeeOfMonth = seller.getName();
                        }
                }

        }
        return employeeOfMonth;
    }

    private static String assignCalculationSecretary(List<Employee> secretaries, BigDecimal greaterSalary, String employeeOfMonth) {
        for (Employee secretary : secretaries) {
            if (secretary.getOffice().equals(Office.SECRETARY))
                if (secretary.getSalaryDescription().getValue()
                        .multiply(BigDecimal.ONE.add(secretary.getSalaryDescription().getBenefit()))
                        .compareTo(greaterSalary) > 0) {

                    greaterSalary = greaterSalary.add(secretary.getSalaryDescription().getValue()
                            .multiply(BigDecimal.ONE.add(secretary.getSalaryDescription().getBenefit())));
                    employeeOfMonth = secretary.getName();
                }
        }
        return employeeOfMonth;

    }

    private static String assignCalculationManager(List<Employee> managers, BigDecimal greaterSalary, String employeeOfMonth) {
        for (Employee manager : managers) {
            if (manager.getOffice().equals(Office.MANAGER))
                if (manager.getSalaryDescription().getValue().compareTo(greaterSalary) > 0) {
                    greaterSalary = greaterSalary.add(manager.getSalaryDescription().getValue());
                    employeeOfMonth = manager.getName();
                }
        }

        return employeeOfMonth;
    }

    private static List<Employee> getAllSellers(List<Employee> employees, YearMonth yearMonth) {
        return employees.stream()
                .filter(employee -> employee.getOffice().equals(Office.SELLER))
                .filter(employee -> employee.getSalaryPayments().stream().anyMatch(payment -> payment.isYearAndMonth(yearMonth))).toList();

    }

    private static List<Employee> getAllSecretaries(List<Employee> employees, YearMonth yearMonth) {
        return employees.stream()
                .filter(employee -> employee.getOffice().equals(Office.SECRETARY))
                .filter(employee -> employee.getSalaryPayments().stream().anyMatch(payment -> payment.isYearAndMonth(yearMonth))).toList();

    }

    private static List<Employee> getAllManagers(List<Employee> employees, YearMonth yearMonth) {
        return employees.stream()
                .filter(employee -> employee.getOffice().equals(Office.MANAGER))
                .filter(employee -> employee.getSalaryPayments().stream().anyMatch(payment -> payment.isYearAndMonth(yearMonth))).toList();
    }


}
