package org.sinerji.services;

import org.sinerji.models.EmployeeGreater;

import java.time.YearMonth;
import java.util.List;
import java.util.Set;

public interface WhoReceivedTheMostService<T> {

    Set<EmployeeGreater> receivedTheMost(YearMonth yearMonth, List<T> employees);
}
