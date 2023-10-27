package org.sinerji.models;

import org.sinerji.enums.BenefitType;
import org.sinerji.enums.Office;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Optional;
import java.util.Set;

public class Seller extends Employee {

    public final static BigDecimal BENEFIT = BigDecimal.valueOf(0.30);

    public Seller(String name, YearMonth yearMonthHiring, SalaryDescription salaryDescription) {
        super(name, yearMonthHiring);
        this.salaryDescription = salaryDescription;
        this.salaryDescription.setBenefitType(BenefitType.PAST_DUE_AMOUNT);
        this.office = Office.SELLER;
    }

    public Seller() {
    }

    @Override
    public String toString() {
        return "Seller{" +
                "office=" + office +
                ", salaryDescription=" + salaryDescription +
                '}';
    }

    public Optional<BigDecimal> sumBenefit(YearMonth yearMonth, Employee employee) {
        return employee.getSales().stream()
                .filter(sale -> sale.isYearAndMonth(yearMonth))
                .map(sale -> sale.getValue().multiply(BENEFIT))
                .reduce(BigDecimal::add);
    }

    public Optional<BigDecimal> sumSales(YearMonth yearMonth, Employee employee) {
        return employee.getSales().stream()
                .filter(sale -> sale.isYearAndMonth(yearMonth))
                .map(Sale::getValue)
                .reduce(BigDecimal::add);
    }

    public static void assignsEmployeeWhoSoldMost(YearMonth yearMonth, Employee employee, Set<EmployeeGreater> employeesGreaterList) {
        if (employee.isSeller()) {
            EmployeeGreater employeeGreater = new EmployeeGreater(
                    employee.getName(),
                    new Seller().sumSales(yearMonth, employee).orElse(BigDecimal.ZERO)

            );
            employeesGreaterList.add(employeeGreater);
        }
    }
}
