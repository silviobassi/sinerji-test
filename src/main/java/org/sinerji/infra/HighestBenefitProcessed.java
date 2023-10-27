package org.sinerji.infra;

import org.sinerji.models.Employee;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public class HighestBenefitProcessed {

    public static Optional<BigDecimal> setCalculated(CalculateBenefitService calculateBenefitService,
                                                     List<Employee> employees, YearMonth yearMonth){
        return calculateBenefitService.getTotalBenefits(employees, yearMonth);
    }
}
