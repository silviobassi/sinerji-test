package org.sinerji.models;

import org.sinerji.enums.BenefitType;
import org.sinerji.enums.Office;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class Seller extends Employee {

    public final static BigDecimal BENEFIT = BigDecimal.valueOf(0.30);

    public Seller(String name, YearMonth yearMonthHiring, SalaryDescription salaryDescription) {
        super(name, yearMonthHiring);
        this.salaryDescription = salaryDescription;
        this.salaryDescription.setBenefitType(BenefitType.PAST_DUE_AMOUNT);
        this.office = Office.SELLER;
    }


    @Override
    public String toString() {
        return "Seller{" +
                "office=" + office +
                ", salaryDescription=" + salaryDescription +
                '}';
    }

}
