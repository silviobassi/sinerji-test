package org.sinerji.services;

import org.sinerji.enums.Office;
import org.sinerji.models.Employee;
import org.sinerji.models.Sale;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;

public class GreatestSale implements ReceivedMore {
    @Override
    public String getEmployeeWithGreaterSalaryOfMonth(List<Employee> employees, YearMonth yearMonth) {

        BigDecimal greaterSale = BigDecimal.ZERO;
        String greaterSeller = null;

        List<Employee> employeeGreaterOfMonth = getAllSellersOfMonth(employees, yearMonth);
        greaterSeller = assignCalculationSellersOfMonth(yearMonth, employeeGreaterOfMonth, greaterSale, greaterSeller);

        return greaterSeller;
    }

    private static String assignCalculationSellersOfMonth(YearMonth yearMonth, List<Employee> employeeGreaterOfMonth, BigDecimal greaterSale, String greaterSeller) {
        for(Employee seller: employeeGreaterOfMonth){
            for(Sale sale: seller.getSales()){
                if(sale.isYearAndMonth(yearMonth)){
                    if(sale.getValue().compareTo(greaterSale) > 0){
                        greaterSale = greaterSale.add(sale.getValue());
                        greaterSeller = seller.getName();
                    }
                }
            }
        }
        return greaterSeller;
    }

    private static List<Employee> getAllSellersOfMonth(List<Employee> employees, YearMonth yearMonth) {
        return employees.stream()
                .filter(employee -> employee.getSalaryPayments().stream().anyMatch(payment -> payment.isYearAndMonth(yearMonth)))
                .filter(employee -> employee.getOffice().equals(Office.SELLER))
                .toList();
    }
}
