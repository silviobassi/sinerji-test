package org.sinerji.models;

import org.sinerji.enums.Office;

import java.time.YearMonth;
import java.util.List;
import java.util.Objects;

public class Employee{

    private String name;
    private YearMonth yearMonthHiring;
    protected Office office;

    private List<Sale> sales;
    protected SalaryDescription salaryDescription;

    private List<YearMonth> yearsMonthsPayment;

    public Employee(String name, YearMonth yearMonthHiring) {
        this.name = name;
        this.yearMonthHiring = yearMonthHiring;
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

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public SalaryDescription getSalaryDescription() {
        return salaryDescription;
    }

    public void setSalaryDescription(SalaryDescription salaryDescription) {
        this.salaryDescription = salaryDescription;
    }

    public List<YearMonth> getYearsMonthsPayment() {
        return yearsMonthsPayment;
    }

    public void setYearsMonthsPayment(List<YearMonth> yearsMonthsPayment) {
        this.yearsMonthsPayment = yearsMonthsPayment;
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
        if (!Objects.equals(sales, employee.sales)) return false;
        if (!Objects.equals(salaryDescription, employee.salaryDescription))
            return false;
        return Objects.equals(yearsMonthsPayment, employee.yearsMonthsPayment);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (yearMonthHiring != null ? yearMonthHiring.hashCode() : 0);
        result = 31 * result + (office != null ? office.hashCode() : 0);
        result = 31 * result + (sales != null ? sales.hashCode() : 0);
        result = 31 * result + (salaryDescription != null ? salaryDescription.hashCode() : 0);
        result = 31 * result + (yearsMonthsPayment != null ? yearsMonthsPayment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", yearMonthHiring=" + yearMonthHiring +
                ", office=" + office +
                ", sales=" + sales +
                ", salaryDescription=" + salaryDescription +
                ", yearsMonthsPayment=" + yearsMonthsPayment +
                '}';
    }

    public boolean isSeller(){
        return getOffice().equals(Office.SELLER);
    }

    public boolean isSecretary(){
        return getOffice().equals(Office.SECRETARY);
    }

    public boolean isManager(){
        return getOffice().equals(Office.MANAGER);
    }
}