package org.sinerji.models;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

public record EmployeeGreater(String name, BigDecimal payment) {
    public static Set<EmployeeGreater> getWhoWonTheMost(Set<EmployeeGreater> employeeGreats) {
        return employeeGreats.stream()
                .filter(employeeGreater ->
                        employeeGreater.payment().compareTo(maxValue(employeeGreats)) == 0)
                .collect(Collectors.toSet());
    }

    private static BigDecimal maxValue(Set<EmployeeGreater> employeeGreats) {
        return employeeGreats.stream()
                .map(EmployeeGreater::payment)
                .max(BigDecimal::compareTo).orElse(BigDecimal.ZERO);
    }

}
