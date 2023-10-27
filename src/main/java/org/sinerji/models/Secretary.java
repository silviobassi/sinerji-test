package org.sinerji.models;

import org.sinerji.enums.BenefitType;
import org.sinerji.enums.Office;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Optional;
import java.util.Set;

public class  Secretary extends Employee {

    public final static BigDecimal BENEFIT = BigDecimal.valueOf(0.20);


    public Secretary(String name, YearMonth yearMonthHiring, SalaryDescription salaryDescription) {
        super(name, yearMonthHiring);
        this.salaryDescription = salaryDescription;
        this.salaryDescription.setBenefitType(BenefitType.ABOUT_SALARY);
        this.office = Office.SECRETARY;
    }

    public Secretary() {
    }
    @Override
    public String toString() {
        return "Secretary{" +
                "office=" + office +
                ", salaryDescription=" + salaryDescription +
                '}';
    }

    public Optional<BigDecimal> sumSalaryAndBenefit(Employee employee){
        return Optional.of(sumSalary(employee).orElse(BigDecimal.ZERO).multiply(BigDecimal.ONE.add(BENEFIT)));
    }

    public Optional<BigDecimal> sumBenefit(Employee employee) {
        return Optional.of(sumSalary(employee).orElse(BigDecimal.ZERO).multiply(BENEFIT));
    }
}
