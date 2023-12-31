package org.sinerji.models;

import org.sinerji.enums.BenefitType;
import org.sinerji.enums.Office;

import java.time.YearMonth;

public class Manager extends Employee {

    public Manager(String name, YearMonth yearMonthHiring, SalaryDescription salaryDescription) {
        super(name, yearMonthHiring);
        this.salaryDescription = salaryDescription;
        this.salaryDescription.setBenefitType(BenefitType.NO_BENEFITS);
        this.office = Office.MANAGER;
    }

    public Manager() {
    }

    @Override
    public String toString() {
        return "Manager{" +
                "office=" + office +
                ", salaryDescription=" + salaryDescription +
                '}';
    }

}
