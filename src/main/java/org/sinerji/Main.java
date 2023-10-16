package org.sinerji;

import org.sinerji.enums.AllowanceType;
import org.sinerji.enums.BenefitType;
import org.sinerji.enums.Office;
import org.sinerji.models.Employee;
import org.sinerji.models.SalaryDescription;
import org.sinerji.models.SalaryPayment;
import org.sinerji.models.Sale;
import org.sinerji.services.*;

import java.math.BigDecimal;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Cargos e seus respectivos salários
        SalaryDescription secretary = new SalaryDescription(new BigDecimal(7000),
                new BigDecimal(1000), AllowanceType.YEARLY, new BigDecimal("0.20"), BenefitType.ABOUT_SALARY);

        SalaryDescription seller = new SalaryDescription(new BigDecimal(12000),
                new BigDecimal(1800), AllowanceType.YEARLY, new BigDecimal("0.30"), BenefitType.PAST_DUE_AMOUNT);

        SalaryDescription manager = new SalaryDescription(new BigDecimal(20000),
                new BigDecimal(3000), AllowanceType.YEARLY, new BigDecimal(0), BenefitType.NO_BENEFITS);


        // Registro de Pagamento de Salários
        SalaryPayment paymentJanuaryJorge = new SalaryPayment(YearMonth.of(2022, Month.JANUARY));
        SalaryPayment paymentFebruaryJorge = new SalaryPayment(YearMonth.of(2022, Month.FEBRUARY));
        SalaryPayment paymentMarchJorge = new SalaryPayment(YearMonth.of(2022, Month.MARCH));

        SalaryPayment paymentMarchBento= new SalaryPayment(YearMonth.of(2022, Month.FEBRUARY));
        SalaryPayment paymentAprilBento = new SalaryPayment(YearMonth.of(2022, Month.APRIL));
        SalaryPayment paymentMayBento= new SalaryPayment(YearMonth.of(2022, Month.MAY));


        SalaryPayment paymentFebruaryMaria = new SalaryPayment(YearMonth.of(2022, Month.FEBRUARY));
        SalaryPayment paymentMarchMaria = new SalaryPayment(YearMonth.of(2022, Month.MARCH));
        SalaryPayment paymentAprilMaria = new SalaryPayment(YearMonth.of(2022, Month.APRIL));

        SalaryPayment paymentFebruaryAnaSilva = new SalaryPayment(YearMonth.of(2022, Month.FEBRUARY));
        SalaryPayment paymentMarchAnaSilva = new SalaryPayment(YearMonth.of(2022, Month.MARCH));
        SalaryPayment paymentAprilAnaSilva = new SalaryPayment(YearMonth.of(2022, Month.APRIL));

        SalaryPayment paymentFebruaryJoaoMendes = new SalaryPayment(YearMonth.of(2022, Month.FEBRUARY));
        SalaryPayment paymentMarchJoaoMendes = new SalaryPayment(YearMonth.of(2022, Month.MARCH));
        SalaryPayment paymentAprilJoaoMendes = new SalaryPayment(YearMonth.of(2022, Month.APRIL));

        SalaryPayment paymentFebruaryJuliaAlves = new SalaryPayment(YearMonth.of(2022, Month.FEBRUARY));
        SalaryPayment paymentMarchJuliaAlves = new SalaryPayment(YearMonth.of(2022, Month.MARCH));
        SalaryPayment paymentAprilJuliaAlves = new SalaryPayment(YearMonth.of(2022, Month.APRIL));

        List<SalaryPayment> paymentsJorge = Arrays.asList(paymentJanuaryJorge, paymentFebruaryJorge, paymentMarchJorge);
        List<SalaryPayment> paymentsMaria = Arrays.asList(paymentFebruaryMaria, paymentMarchMaria, paymentAprilMaria);
        List<SalaryPayment> paymentsAnaSilva = Arrays.asList(paymentFebruaryAnaSilva, paymentMarchAnaSilva, paymentAprilAnaSilva);
        List<SalaryPayment> paymentsJoaoMendes = Arrays.asList(paymentFebruaryJoaoMendes, paymentMarchJoaoMendes, paymentAprilJoaoMendes);
        List<SalaryPayment> paymentsJulianaAlves = Arrays.asList(paymentFebruaryJuliaAlves, paymentMarchJuliaAlves, paymentAprilJuliaAlves);
        List<SalaryPayment> paymentsBento = Arrays.asList(paymentMarchBento, paymentAprilBento, paymentMayBento);

        Sale ana1 = new Sale(YearMonth.of(2021, Month.DECEMBER), new BigDecimal(5200));
        Sale ana2 = new Sale(YearMonth.of(2022, Month.JANUARY), new BigDecimal(4000));
        Sale ana3 = new Sale(YearMonth.of(2022, Month.FEBRUARY), new BigDecimal(4200));
        Sale ana4 = new Sale(YearMonth.of(2022, Month.MARCH), new BigDecimal(5850));
        Sale ana5 = new Sale(YearMonth.of(2022, Month.APRIL), new BigDecimal(7000));

        Sale mendes1 = new Sale(YearMonth.of(2022, Month.DECEMBER), new BigDecimal(3400));
        Sale mendes2 = new Sale(YearMonth.of(2022, Month.JANUARY), new BigDecimal(7700));
        Sale mendes3 = new Sale(YearMonth.of(2022, Month.FEBRUARY), new BigDecimal(5000));
        Sale mendes4 = new Sale(YearMonth.of(2022, Month.MARCH), new BigDecimal(5900));
        Sale mendes5 = new Sale(YearMonth.of(2022, Month.APRIL), new BigDecimal(6500));

        // Registro de funcionários
        Employee jorgeCarvalho = new Employee(
                "Jorge Carvalho",
                YearMonth.of(2018, Month.JANUARY),
                Office.SECRETARY,
                secretary,
                paymentsJorge
        );

        Employee mariaSouza = new Employee(
                "Maria de Souza",
                YearMonth.of(2015, Month.DECEMBER),
                Office.SECRETARY,
                secretary,
                paymentsMaria
        );

        Employee anaSilva = new Employee(
                "Ana Silva",
                YearMonth.of(2021, Month.DECEMBER),
                Office.SELLER,
                seller,
                paymentsAnaSilva
        );


        Employee joaoMendes = new Employee(
                "João Mendes",
                YearMonth.of(2021, Month.DECEMBER),
                Office.SELLER,
                seller,
                paymentsJoaoMendes
        );

        Employee julianaAlves = new Employee(
                "Juliana Alves",
                YearMonth.of(2017, Month.JULY),
                Office.MANAGER,
                manager,
                paymentsJulianaAlves
        );

        Employee bentoAlbino = new Employee(
                "Bento Albino",
                YearMonth.of(2013, Month.MARCH),
                Office.MANAGER,
                manager,
                paymentsBento
        );

        List<Sale> mendes = new ArrayList<>();
        mendes.add(mendes1);
        mendes.add(mendes2);
        mendes.add(mendes3);
        mendes.add(mendes4);
        mendes.add(mendes5);

        List<Sale> anas = new ArrayList<>();
        anas.add(ana1);
        anas.add(ana2);
        anas.add(ana3);
        anas.add(ana4);
        anas.add(ana5);

        anaSilva.setSales(anas);
        joaoMendes.setSales(mendes);

        List<Employee> employees = Arrays.asList(jorgeCarvalho, mariaSouza, anaSilva, joaoMendes, julianaAlves,bentoAlbino);

        Payment salaryAndBenefits = new SalaryAndBenefits();
        Payment justSalary = new JustSalary();
        Payment justBenefit = new JustBenefits();

        ReceivedMore greatestSalary = new GreatestSalary();
        ReceivedMore greatestBenefit = new GreatestBenefit();
        ReceivedMore greatestSale = new GreatestSale();

        //OK
        System.out.println("Total pago de salário e benefício no mês: "
                + salaryAndBenefits.getTotalPayment(employees, YearMonth.of(2022, Month.FEBRUARY)));

        System.out.println("----------------------------------------------------");

        //OK
        System.out.println("Total pago somente de salário no mês: " +
                justSalary.getTotalPayment(employees, YearMonth.of(2022, Month.FEBRUARY)));

        System.out.println("----------------------------------------------------");

        //OK
        System.out.println("Total pago somente de benefício no mês: " +
                justBenefit.getTotalPayment(employees, YearMonth.of(2022, Month.FEBRUARY)));

        System.out.println("----------------------------------------------------");

        //OK
        System.out.println("Funcionário que mais recebeu no mês: "
                + greatestSalary.getEmployeeWithGreaterSalaryOfMonth(employees, YearMonth.of(2022, Month.FEBRUARY)));

        System.out.println("----------------------------------------------------");

        //OK
        System.out.println("Funcionário que mais recebeu benefício no mês: " +
                greatestBenefit.getEmployeeWithGreaterSalaryOfMonth(employees, YearMonth.of(2022, Month.FEBRUARY)));

        System.out.println("----------------------------------------------------");

        //OK
        System.out.println("Vendedor que mais vendeu no mês: " +
                greatestSale.getEmployeeWithGreaterSalaryOfMonth(employees, YearMonth.of(2022, Month.FEBRUARY)));

    }
}