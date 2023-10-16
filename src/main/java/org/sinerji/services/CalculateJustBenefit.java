package org.sinerji.services;

import org.sinerji.enums.BenefitType;
import org.sinerji.enums.Office;
import org.sinerji.models.Employee;
import org.sinerji.models.Sale;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class CalculateJustBenefit implements Greater {
    @Override
    public Optional<BigDecimal> payment(List<Employee> employees, YearMonth yearMonth) {
        BigDecimal total = BigDecimal.ZERO;

        List<Employee> sellers = getEmployeesWithBenefits(employees, yearMonth);

        total = getTotalSellerAndSecretary(yearMonth, sellers, total);

        return Optional.of(total);
    }

    private static BigDecimal getTotalSellerAndSecretary(YearMonth yearMonth, List<Employee> sellers, BigDecimal total) {
        for (Employee seller : sellers) {
            total = checkCalculation(yearMonth, total, seller);
        }
        return total;
    }

    private static BigDecimal checkCalculation(YearMonth yearMonth, BigDecimal total, Employee seller) {
        if (seller.getOffice().equals(Office.SELLER)) {
            for (Sale sale : seller.getSales()) {
                if (sale.isYearAndMonth(yearMonth)) {
                    total = total.add(sale.getValue().multiply(seller.getSalaryDescription().getBenefit()));
                }
            }
        } else {
            total = total.add(seller.getSalaryDescription().getValue()
                    .multiply(seller.getSalaryDescription().getBenefit()));
        }
        return total;
    }

    private static List<Employee> getEmployeesWithBenefits(List<Employee> employees, YearMonth yearMonth) {
        return employees.stream()
                .filter(employee -> !employee.getSalaryDescription().getBenefitType().equals(BenefitType.NO_BENEFITS))
                .filter(employee -> employee.getSalaryPayments().stream().anyMatch(
                        payment -> payment.isYearAndMonth(yearMonth))).toList();
    }
}
