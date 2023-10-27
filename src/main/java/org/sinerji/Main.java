package org.sinerji;

import org.sinerji.enums.AllowanceType;
import org.sinerji.models.*;
import org.sinerji.services.Payment;
import org.sinerji.services.FindEmployee;
import org.sinerji.services.impl.*;

import java.math.BigDecimal;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Sellers List
        List<Sale> anaSilvaSaleList = List.of(
                new Sale(YearMonth.of(2021, Month.DECEMBER), BigDecimal.valueOf(5200)),
                new Sale(YearMonth.of(2022, Month.JANUARY), BigDecimal.valueOf(4000)),
                new Sale(YearMonth.of(2022, Month.FEBRUARY), BigDecimal.valueOf(4200)),
                new Sale(YearMonth.of(2022, Month.MARCH), BigDecimal.valueOf(5850)),
                new Sale(YearMonth.of(2022, Month.APRIL), BigDecimal.valueOf(7000))
        );

        List<Sale> joaoMendesSaleList = List.of(
                new Sale(YearMonth.of(2021, Month.DECEMBER), BigDecimal.valueOf(3400)),
                new Sale(YearMonth.of(2022, Month.JANUARY), BigDecimal.valueOf(7700)),
                new Sale(YearMonth.of(2022, Month.FEBRUARY), BigDecimal.valueOf(5000)),
                new Sale(YearMonth.of(2022, Month.MARCH), BigDecimal.valueOf(5900)),
                new Sale(YearMonth.of(2022, Month.APRIL), BigDecimal.valueOf(6500))
        );


        // Salary Register
        SalaryDescription salaryDescriptionSecretary = new SalaryDescription(BigDecimal.valueOf(7000), BigDecimal.valueOf(1000),
                AllowanceType.YEARLY);
        SalaryDescription salaryDescriptionSeller = new SalaryDescription(BigDecimal.valueOf(12000), BigDecimal.valueOf(1800),
                AllowanceType.YEARLY);
        SalaryDescription salaryDescriptionSManager = new SalaryDescription(BigDecimal.valueOf(20000), BigDecimal.valueOf(3000),
                AllowanceType.YEARLY);

        //Employee Register
        Secretary secretaryJorge = new Secretary("Jorge Carvalho", YearMonth.of(2018, Month.JANUARY), salaryDescriptionSecretary);
        secretaryJorge.setYearsMonthsPayment(List.of(YearMonth.of(2018, Month.JANUARY), YearMonth.of(2018, Month.FEBRUARY),
                YearMonth.of(2018, Month.MARCH), YearMonth.of(2022, Month.APRIL)));

       Secretary secretaryMaria = new Secretary("Maria Souza", YearMonth.of(2015, Month.DECEMBER), salaryDescriptionSecretary);
        secretaryMaria.setYearsMonthsPayment(List.of(YearMonth.of(2015, Month.JANUARY), YearMonth.of(2015, Month.FEBRUARY),
                YearMonth.of(2018, Month.MARCH), YearMonth.of(2022, Month.APRIL), YearMonth.of(2018, Month.MAY),
                YearMonth.of(2018, Month.JUNE)));

        Seller sellerAna = new Seller("Ana Silva", YearMonth.of(2021, Month.DECEMBER), salaryDescriptionSeller);
        sellerAna.setYearsMonthsPayment(List.of(YearMonth.of(2022, Month.JANUARY), YearMonth.of(2022, Month.FEBRUARY),
                YearMonth.of(2022, Month.MARCH), YearMonth.of(2022, Month.APRIL)));
        sellerAna.setSales(anaSilvaSaleList);

        Seller sellerJoao= new Seller("João Mendes", YearMonth.of(2021, Month.DECEMBER), salaryDescriptionSeller);
        sellerJoao.setYearsMonthsPayment(List.of(YearMonth.of(2022, Month.JANUARY), YearMonth.of(2022, Month.FEBRUARY),
                YearMonth.of(2022, Month.MARCH), YearMonth.of(2022, Month.APRIL)));
        sellerJoao.setSales(joaoMendesSaleList);

        Manager managerJuliana = new Manager("Juliana Alves", YearMonth.of(2017, Month.JULY), salaryDescriptionSManager);
        managerJuliana.setYearsMonthsPayment(List.of(YearMonth.of(2017, Month.JULY), YearMonth.of(2017, Month.AUGUST),
                YearMonth.of(2022, Month.MARCH), YearMonth.of(2022, Month.APRIL), YearMonth.of(2018, Month.MAY),
                YearMonth.of(2018, Month.JUNE)));

        Manager managerBento = new Manager("Bento Albino", YearMonth.of(2014, Month.MARCH), salaryDescriptionSManager);
        managerBento.setYearsMonthsPayment(List.of(YearMonth.of(2014, Month.MARCH),
                YearMonth.of(2022, Month.APRIL), YearMonth.of(2018, Month.MAY),
                YearMonth.of(2018, Month.JUNE)));

        List<Employee> employees = List.of(secretaryJorge, secretaryMaria, sellerAna, sellerJoao, managerJuliana, managerBento);

        List<Seller> sellers = List.of(sellerAna, sellerJoao);

       System.out.println("Total de Salário e Benefícios do mês: " + Payment.getPayment(
                new TotalSalaryBenefitImpl(), employees, YearMonth.of(2022, Month.APRIL)));
        System.out.println("----------------------------------------------------------------");
        System.out.println("Total de do mês: " + Payment.getPayment(
                new TotalJustSalaryImpl(), employees, YearMonth.of(2022, Month.APRIL)));
        System.out.println("----------------------------------------------------------------");
        System.out.println("Total somente de benefícios do mês: " + Payment.getPayment(
                new TotalJustBenefitImpl(), employees, YearMonth.of(2022, Month.APRIL)));
        System.out.println("----------------------------------------------------------------");


        System.out.println("Funcionários que receberam o valor mais alto do mês: "
                + FindEmployee.whoWonTheMost(new WhoReceivedHighestSalaryBenefitsImpl(), YearMonth.of(2022, Month.APRIL), employees));
        System.out.println("----------------------------------------------------------------");

        System.out.println("Funcionários que receberam o benefício mais alto do mês: "
                + FindEmployee.whoWonTheMost(new WhoReceivedBiggestBenefitImpl(), YearMonth.of(2022, Month.APRIL), employees));
        System.out.println("----------------------------------------------------------------");

        System.out.println("Vendedor que mais vendeu no mês: "
                + FindEmployee.whoSoldTheMost(new WhoSoldTheMostImpl(), YearMonth.of(2022, Month.APRIL), sellers));
        System.out.println("----------------------------------------------------------------");
    }
}