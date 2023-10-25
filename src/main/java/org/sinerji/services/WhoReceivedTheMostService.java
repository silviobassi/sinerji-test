package org.sinerji.services;

import org.sinerji.models.Employee;

import java.time.YearMonth;
import java.util.List;
import java.util.Set;

public interface WhoReceivedTheMostService {

    Set<Employee> receivedTheMost(YearMonth yearMonth, List<Employee> employees);
}
