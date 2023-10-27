package org.sinerji.models;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Objects;

public class Sale {

    private YearMonth yearMonth;

    private BigDecimal value;

    public Sale(YearMonth yearMonth, BigDecimal value) {
        this.yearMonth = yearMonth;
        this.value = value;
    }

    public YearMonth getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(YearMonth yearMonth) {
        this.yearMonth = yearMonth;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sale sale = (Sale) o;

        if (!Objects.equals(yearMonth, sale.yearMonth)) return false;
        return Objects.equals(value, sale.value);
    }

    @Override
    public int hashCode() {
        int result = yearMonth != null ? yearMonth.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String
    toString() {
        return "Sale{" +
                "yearMonth=" + yearMonth +
                ", value=" + value +
                '}';
    }


    public boolean isYearAndMonth(YearMonth yearMonth){
        return getYearMonth().equals(yearMonth);
    }

}
