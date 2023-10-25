package org.sinerji.services;

import org.sinerji.models.Employee;
import org.sinerji.utils.calculate.CalculatePaymentService;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ReceivedProcessed {

    public static Set<Employee> setEmployeeTheMost(ReceivedService received, YearMonth yearMonth,
                                                   Employee employee, BigDecimal updateValue,
                                                   Set<Employee> employeeFeatured){
        return received.receivedTheMost(yearMonth, employee, updateValue, employeeFeatured);

    }
}
