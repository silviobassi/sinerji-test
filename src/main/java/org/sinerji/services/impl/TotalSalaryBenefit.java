package org.sinerji.services.impl;

import org.sinerji.models.Employee;
import org.sinerji.models.Secretary;
import org.sinerji.models.Seller;
import org.sinerji.services.PaymentService;
import org.sinerji.utils.calculate.BenefitProcessed;
import org.sinerji.utils.calculate.impl.CalculateBenefitSeller;
import org.sinerji.utils.calculate.impl.CalculateSalaryManager;
import org.sinerji.services.PaymentProcessed;
import org.sinerji.utils.calculate.impl.CalculateSalarySecretary;
import org.sinerji.utils.calculate.impl.CalculateSalarySeller;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class TotalSalaryBenefit implements PaymentService {
    @Override
    public Optional<BigDecimal> getPayment(List<Employee> employees, YearMonth yearMonth) {
        BigDecimal totalSalaryAndBenefitsAllEmployees = getSumPayment(employees, yearMonth);
        return Optional.of(totalSalaryAndBenefitsAllEmployees);
    }

    private static BigDecimal getSumPayment(List<Employee> employees, YearMonth yearMonth) {
        BigDecimal totalSalaryManager =
                PaymentProcessed.setCalculated(new CalculateSalaryManager(), employees, yearMonth).orElse(BigDecimal.ZERO);

        BigDecimal totalSalarySecretary =
                PaymentProcessed.setCalculated(new CalculateSalarySecretary(), employees, yearMonth).orElse(BigDecimal.ZERO);

        BigDecimal totalSalarySeller =
                PaymentProcessed.setCalculated(new CalculateSalarySeller(), employees, yearMonth).orElse(BigDecimal.ZERO);

        BigDecimal totalBenefitsSeller = BenefitProcessed.setCalculated(new CalculateBenefitSeller(), employees, yearMonth)
                .orElse(BigDecimal.ZERO);


        return totalSalaryManager.add(totalSalarySecretary.multiply(BigDecimal.ONE.add(Secretary.BENEFIT)))
                .add(totalSalarySeller.add(totalBenefitsSeller.multiply(Seller.BENEFIT)));
    }

}
