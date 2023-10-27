package org.sinerji.models;

import org.sinerji.enums.AllowanceType;
import org.sinerji.enums.BenefitType;

import java.math.BigDecimal;
import java.util.Objects;

public class SalaryDescription {

    private BigDecimal payment;

    private BigDecimal allowance;

    private AllowanceType allowanceType;

    private BenefitType benefitType;

    public SalaryDescription(BigDecimal payment, BigDecimal allowance, AllowanceType allowanceType) {
        this.payment = payment;
        this.allowance = allowance;
        this.allowanceType = allowanceType;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public BigDecimal getAllowance() {
        return allowance;
    }

    public AllowanceType getAllowanceType() {
        return allowanceType;
    }

    public BenefitType getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(BenefitType benefitType) {
        this.benefitType = benefitType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalaryDescription that = (SalaryDescription) o;

        if (!Objects.equals(payment, that.payment)) return false;
        if (!Objects.equals(allowance, that.allowance)) return false;
        if (allowanceType != that.allowanceType) return false;
        return benefitType == that.benefitType;
    }

    @Override
    public int hashCode() {
        int result = payment != null ? payment.hashCode() : 0;
        result = 31 * result + (allowance != null ? allowance.hashCode() : 0);
        result = 31 * result + (allowanceType != null ? allowanceType.hashCode() : 0);
        result = 31 * result + (benefitType != null ? benefitType.hashCode() : 0);
        return result;
    }
}