package org.sinerji.infra.impl;

import org.sinerji.infra.CalculatePaymentService;
import org.sinerji.infra.HighestBenefitProcessed;
import org.sinerji.models.Employee;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class CalculateBenefitEmployeeImpl implements CalculatePaymentService {
    @Override
    public Optional<BigDecimal> getTotal(List<Employee> employees, YearMonth yearMonth) {
        BigDecimal totalBenefitsSeller = HighestBenefitProcessed.setCalculated(new CalculateBenefitSellerImpl(), employees, yearMonth)
                .orElse(BigDecimal.ZERO);
        BigDecimal totalBenefitsSecretary = HighestBenefitProcessed.setCalculated(new CalculateBenefitSecretaryImpl(), employees, yearMonth)
                .orElse(BigDecimal.ZERO);

        return Optional.of(totalBenefitsSeller.add(totalBenefitsSecretary));
    }

}
