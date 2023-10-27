package org.sinerji.services.impl;

import org.sinerji.infra.impl.*;
import org.sinerji.models.Employee;
import org.sinerji.models.Secretary;
import org.sinerji.models.Seller;
import org.sinerji.services.TotalPaymentService;
import org.sinerji.infra.HighestBenefitProcessed;
import org.sinerji.services.PaymentProcessed;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class TotalSalaryBenefitImpl implements TotalPaymentService {
    @Override
    public Optional<BigDecimal> getPayment(List<Employee> employees, YearMonth yearMonth) {
        BigDecimal totalSalaryAndBenefitsAllEmployees = getSumPayment(employees, yearMonth);
        return Optional.of(totalSalaryAndBenefitsAllEmployees);
    }

    private static BigDecimal getSumPayment(List<Employee> employees, YearMonth yearMonth) {
        BigDecimal totalSalaryManager =
                PaymentProcessed.setCalculated(new CalculateSalaryManagerImpl(), employees, yearMonth).orElse(BigDecimal.ZERO);

        BigDecimal totalSalarySecretary =
                PaymentProcessed.setCalculated(new CalculateSalarySecretaryImpl(), employees, yearMonth).orElse(BigDecimal.ZERO);

        BigDecimal totalSalarySeller =
                PaymentProcessed.setCalculated(new CalculateSalarySellerImpl(), employees, yearMonth).orElse(BigDecimal.ZERO);

        BigDecimal totalBenefitsSeller = HighestBenefitProcessed.setCalculated(new CalculateBenefitSellerImpl(), employees, yearMonth)
                .orElse(BigDecimal.ZERO);

        return getTotalSalaryAndBenefits(
                totalSalaryManager, totalSalarySecretary, totalSalarySeller, totalBenefitsSeller);
    }

    private static BigDecimal getTotalSalaryAndBenefits(BigDecimal totalSalaryManager, BigDecimal totalSalarySecretary, BigDecimal totalSalarySeller, BigDecimal totalBenefitsSeller) {
        return totalSalaryManager.add(totalSalarySecretary.multiply(BigDecimal.ONE.add(Secretary.BENEFIT)))
                .add(totalSalarySeller.add(totalBenefitsSeller));
    }

}
