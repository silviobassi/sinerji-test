package org.sinerji.models;

import org.sinerji.enums.Office;

import java.time.YearMonth;
import java.util.List;
import java.util.Objects;

public class Employee {

    private String name;
    private YearMonth yearMonthHiring;
    private Office office;
    private SalaryDescription salaryDescription;
    private List<SalaryPayment> salaryPayments;
    private List<Sale> sales;

    public Employee() {
    }

    public Employee(String name, YearMonth yearMonthHiring, Office office, SalaryDescription salaryDescription, List<SalaryPayment> salaryPayments) {
        this.name = name;
        this.yearMonthHiring = yearMonthHiring;
        this.office = office;
        this.salaryDescription = salaryDescription;
        this.salaryPayments = salaryPayments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public YearMonth getYearMonthHiring() {
        return yearMonthHiring;
    }

    public void setYearMonthHiring(YearMonth yearMonthHiring) {
        this.yearMonthHiring = yearMonthHiring;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public SalaryDescription getSalaryDescription() {
        return salaryDescription;
    }

    public void setSalaryDescription(SalaryDescription salaryDescription) {
        this.salaryDescription = salaryDescription;
    }

    public List<SalaryPayment> getSalaryPayments() {
        return salaryPayments;
    }

    public void setSalaryPayments(List<SalaryPayment> salaryPayments) {
        this.salaryPayments = salaryPayments;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!Objects.equals(name, employee.name)) return false;
        if (!Objects.equals(yearMonthHiring, employee.yearMonthHiring))
            return false;
        if (office != employee.office) return false;
        if (!Objects.equals(salaryDescription, employee.salaryDescription))
            return false;
        if (!Objects.equals(salaryPayments, employee.salaryPayments))
            return false;
        return Objects.equals(sales, employee.sales);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (yearMonthHiring != null ? yearMonthHiring.hashCode() : 0);
        result = 31 * result + (office != null ? office.hashCode() : 0);
        result = 31 * result + (salaryDescription != null ? salaryDescription.hashCode() : 0);
        result = 31 * result + (salaryPayments != null ? salaryPayments.hashCode() : 0);
        result = 31 * result + (sales != null ? sales.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", yearMonthHiring=" + yearMonthHiring +
                ", office=" + office +
                ", salaryDescription=" + salaryDescription +
                ", salaryPayments=" + salaryPayments +
                ", sales=" + sales +
                '}';
    }

    public boolean isYearAndMonth(YearMonth yearMonth, SalaryPayment salaryPayment) {
        return salaryPayment.getYearMonth().equals(yearMonth);
    }

}