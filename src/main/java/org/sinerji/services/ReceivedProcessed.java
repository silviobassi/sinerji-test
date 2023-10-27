package org.sinerji.services;

import org.sinerji.models.Employee;
import org.sinerji.models.EmployeeGreater;
import org.sinerji.models.Seller;

import java.time.YearMonth;
import java.util.List;
import java.util.Set;

public class ReceivedProcessed {

    public static Set<EmployeeGreater> whoSoldTheMost(WhoReceivedTheMostService<Seller> whoReceivedTheMostService,
                                                     YearMonth yearMonth,
                                                     List<Seller> sellers){

        return whoReceivedTheMostService.receivedTheMost(yearMonth, sellers);
    }
    public static Set<EmployeeGreater> whoWonTheMost(WhoReceivedTheMostService<Employee> whoReceivedTheMostService,
                                                     YearMonth yearMonth,
                                                     List<Employee> employees){

        return whoReceivedTheMostService.receivedTheMost(yearMonth, employees);
    }

}
