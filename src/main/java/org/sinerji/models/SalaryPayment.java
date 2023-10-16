package org.sinerji.models;

import java.time.YearMonth;
import java.util.Objects;

public class SalaryPayment {

    private YearMonth yearMonth;


    public SalaryPayment(YearMonth yearMonth) {
        this.yearMonth = yearMonth;
    }

    public YearMonth getYearMonth() {
        return yearMonth;
    }

    public boolean isYearAndMonth(YearMonth yearMonth){
        return getYearMonth().equals(yearMonth);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalaryPayment that = (SalaryPayment) o;

        return Objects.equals(yearMonth, that.yearMonth);
    }

    @Override
    public int hashCode() {
        return yearMonth != null ? yearMonth.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SalaryPayment{" +
                "yearMonth=" + yearMonth +
                '}';
    }
}
