package org.sinerji.utils.calculate.impl;

import org.sinerji.models.Employee;
import org.sinerji.utils.calculate.BenefitProcessed;
import org.sinerji.utils.calculate.CalculatePaymentService;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class CalculateBenefitEmployee implements CalculatePaymentService {
    @Override
    public Optional<BigDecimal> getTotal(List<Employee> employees, YearMonth yearMonth) {
        BigDecimal totalBenefitsSeller = BenefitProcessed.setCalculated(new CalculateBenefitSeller(), employees, yearMonth)
                .orElse(BigDecimal.ZERO);
        BigDecimal totalBenefitsSecretary = BenefitProcessed.setCalculated(new CalculateBenefitSecretary(), employees, yearMonth)
                .orElse(BigDecimal.ZERO);

        return Optional.of(totalBenefitsSeller.add(totalBenefitsSecretary));
    }

}
