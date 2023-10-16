package org.sinerji.services;

import org.sinerji.enums.Office;
import org.sinerji.models.Employee;
import org.sinerji.models.Sale;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class SellerSalaryAndBenefit implements Greater{
    @Override
    public Optional<BigDecimal> payment(List<Employee> employees, YearMonth yearMonth) {
        BigDecimal total = BigDecimal.ZERO;

        List<Employee> sellers = getAllSellerGreater(employees, yearMonth);

        total = assignCalculationPayment(yearMonth, sellers, total);

        return Optional.of(total);
    }

    private static BigDecimal assignCalculationPayment(YearMonth yearMonth, List<Employee> sellers, BigDecimal total) {
        for(Employee seller: sellers){
            for(Sale sale: seller.getSales()){
                if(sale.isYearAndMonth(yearMonth)){
                    total = total.add(seller.getSalaryDescription().getValue()
                            .add(sale.getValue().multiply(seller.getSalaryDescription().getBenefit())));
                }
            }
        }
        return total;
    }

    private static List<Employee> getAllSellerGreater(List<Employee> employees, YearMonth yearMonth) {
        return employees.stream()
                .filter(employee -> employee.getOffice().equals(Office.SELLER))
                .filter(employee -> employee.getSalaryPayments().stream().anyMatch(
                        payment -> payment.isYearAndMonth(yearMonth))).toList();
    }
}
