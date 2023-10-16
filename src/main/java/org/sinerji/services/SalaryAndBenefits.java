package org.sinerji.services;

import org.sinerji.models.Employee;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class SalaryAndBenefits implements Payment{

    @Override
    public Optional<BigDecimal> getTotalPayment(List<Employee> employees, YearMonth yearMonth) {

        Greater secretary = new SecretarySalaryAndBenefit();
        Greater manager = new ManagerSalaryAndBenefit();
        Greater seller = new SellerSalaryAndBenefit();

        Optional<BigDecimal> paymentSecretary = secretary.payment(employees, yearMonth);
        Optional<BigDecimal> paymentManager = manager.payment(employees, yearMonth);
        Optional<BigDecimal> paymentSeller = seller.payment(employees, yearMonth);

        var handleSecretary = paymentSecretary.orElse(BigDecimal.ZERO);
        var handleManager = paymentManager.orElse(BigDecimal.ZERO);
        var handleSeller = paymentSeller.orElse(BigDecimal.ZERO);

        return Optional.of(handleSecretary.add(handleManager.add(handleSeller)));

    }

}