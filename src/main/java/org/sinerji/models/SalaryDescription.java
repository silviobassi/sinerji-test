package org.sinerji.models;

import org.sinerji.enums.AllowanceType;
import org.sinerji.enums.BenefitType;

import java.math.BigDecimal;
import java.util.Objects;

public class SalaryDescription {


    public SalaryDescription(BigDecimal value, BigDecimal allowance, AllowanceType allowanceType, BigDecimal benefit, BenefitType benefitType) {
        this.value = value;
        this.allowance = allowance;
        this.allowanceType = allowanceType;
        this.benefit = benefit;
        this.benefitType = benefitType;
    }

    private BigDecimal value;


    private BigDecimal allowance;

    private AllowanceType allowanceType;
    private BigDecimal benefit;

    private BenefitType benefitType;

    public BigDecimal getValue() {
        return value;
    }

    public BigDecimal getAllowance() {
        return allowance;
    }

    public AllowanceType getAllowanceType() {
        return allowanceType;
    }

    public BigDecimal getBenefit() {
        return benefit;
    }

    public BenefitType getBenefitType() {
        return benefitType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalaryDescription that = (SalaryDescription) o;

        if (!Objects.equals(value, that.value)) return false;
        if (!Objects.equals(allowance, that.allowance)) return false;
        if (allowanceType != that.allowanceType) return false;
        if (!Objects.equals(benefit, that.benefit)) return false;
        return benefitType == that.benefitType;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (allowance != null ? allowance.hashCode() : 0);
        result = 31 * result + (allowanceType != null ? allowanceType.hashCode() : 0);
        result = 31 * result + (benefit != null ? benefit.hashCode() : 0);
        result = 31 * result + (benefitType != null ? benefitType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SalaryDescription{" +
                "value=" + value +
                ", allowance=" + allowance +
                ", allowanceType=" + allowanceType +
                ", benefit=" + benefit +
                ", benefitType=" + benefitType +
                '}';
    }
}