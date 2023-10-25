package org.sinerji.models;

import org.sinerji.enums.BenefitType;
import org.sinerji.enums.Office;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class Secretary extends Employee{

    public final static BigDecimal BENEFIT = BigDecimal.valueOf(0.20);
    public Secretary(String name, YearMonth yearMonthHiring, SalaryDescription salaryDescription) {
        super(name, yearMonthHiring);
        this.salaryDescription = salaryDescription;
        this.salaryDescription.setBenefitType(BenefitType.ABOUT_SALARY);
        this.office = Office.SECRETARY;
    }

    public BigDecimal getBonus(){
        return BENEFIT.multiply(getSalaryDescription().getPayment());
    }

    @Override
    public String toString() {
        return "Secretary{" +
                "office=" + office +
                ", salaryDescription=" + salaryDescription +
                '}';
    }


}
