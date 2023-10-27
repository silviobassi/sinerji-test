package org.sinerji.infra;

import org.sinerji.models.Employee;
import org.sinerji.models.EmployeeGreater;
import org.sinerji.services.WhoReceivedTheMostService;

import java.time.YearMonth;
import java.util.List;
import java.util.Set;

public class TheHigherBenefit {

    public static Set<EmployeeGreater> biggestOfficial(WhoReceivedTheMostService<Employee> whoReceivedTheMostService,
                                       YearMonth yearMonth, List<Employee> employees){
       return whoReceivedTheMostService.receivedTheMost(yearMonth, employees);
    }



}
