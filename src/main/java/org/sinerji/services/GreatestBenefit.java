package org.sinerji.services;

import org.sinerji.enums.BenefitType;
import org.sinerji.enums.Office;
import org.sinerji.models.Employee;
import org.sinerji.models.Sale;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;

public class GreatestBenefit implements ReceivedMore {
    @Override
    public String getEmployeeWithGreaterSalaryOfMonth(List<Employee> employees, YearMonth yearMonth) {

        BigDecimal greaterBenefits = BigDecimal.ZERO;
        String employeeBenefits = null;

        List<Employee> employeesJustBenefits = getAllEmployeesWithBenefits(employees);

        List<Employee> secretaries = getAllSecretaries(yearMonth, employeesJustBenefits);

        List<Employee> sellers = getAllSellers(yearMonth, employeesJustBenefits);

        employeeBenefits = assignBenefitsToSeller(secretaries, greaterBenefits, employeeBenefits);

        employeeBenefits = assignBenefitsToSecretary(yearMonth, sellers, greaterBenefits, employeeBenefits);
        return employeeBenefits;
    }

    private static String assignBenefitsToSecretary(YearMonth yearMonth, List<Employee> sellers, BigDecimal greaterBenefits,
                                                    String employeeBenefits) {
        for (Employee seller : sellers) {
            if (seller.getOffice().equals(Office.SELLER))
                for (Sale sale : seller.getSales()) {
                    if (sale.isYearAndMonth(yearMonth))
                        if (sale.getValue().multiply(seller.getSalaryDescription().getBenefit())
                                .compareTo(greaterBenefits) > 0) {

                            greaterBenefits = greaterBenefits.add(sale.getValue()
                                    .multiply(seller.getSalaryDescription().getBenefit()));
                            employeeBenefits = seller.getName();
                        }
                }

        }
        return employeeBenefits;
    }

    private static String assignBenefitsToSeller(List<Employee> secretaries, BigDecimal greaterBenefits, String employeeBenefits) {
        for (Employee secretary : secretaries) {
            if (secretary.getOffice().equals(Office.SECRETARY)) {
                if (secretary.getSalaryDescription().getValue()
                        .multiply(secretary.getSalaryDescription().getBenefit())
                        .compareTo(greaterBenefits) > 0) {

                    greaterBenefits = greaterBenefits.add(secretary.getSalaryDescription().getValue()
                            .multiply(secretary.getSalaryDescription().getBenefit()));
                    employeeBenefits = secretary.getName();
                }
            }
        }
        return employeeBenefits;
    }

    private static List<Employee> getAllSellers(YearMonth yearMonth, List<Employee> employeesJustBenefits) {
        List<Employee> sellers = employeesJustBenefits.stream()
                .filter(employee -> employee.getOffice().equals(Office.SELLER))
                .filter(employee -> employee.getSalaryPayments().stream().anyMatch(payment -> payment.isYearAndMonth(yearMonth)))
                .filter(employee -> employee.getSales().stream().anyMatch(sale -> sale.isYearAndMonth(yearMonth))).toList();
        return sellers;
    }

    private static List<Employee> getAllSecretaries(YearMonth yearMonth, List<Employee> employeesJustBenefits) {
        List<Employee> secretaries = employeesJustBenefits.stream()
                .filter(employee -> employee.getOffice().equals(Office.SECRETARY))
                .filter(employee -> employee.getSalaryPayments().stream().anyMatch(payment -> payment.isYearAndMonth(yearMonth))).toList();
        return secretaries;
    }

    private static List<Employee> getAllEmployeesWithBenefits(List<Employee> employees) {
        List<Employee> employeesJustBenefits = employees.stream().filter(employee ->
                !employee.getSalaryDescription().getBenefitType().equals(BenefitType.NO_BENEFITS)).toList();
        return employeesJustBenefits;
    }

}
