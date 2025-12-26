package service.calculations;

import model.entities.ClockRecord;
import model.entities.Employee;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.List;

public class SalaryService {
  public BigDecimal calculateMonthlyValue(Employee employee) {
    List<ClockRecord> employeeClockRecordList = employee.getClockRecordList();
    Duration totalMonthlyHoursWorked = Duration.ZERO;

    for (ClockRecord day : employeeClockRecordList) {
      totalMonthlyHoursWorked = totalMonthlyHoursWorked.plus(calculateDayHours(day));
    }

    Duration monthlyExpectedHours = Duration.ofHours(employee.getClockRecordList().size() * 8);

    Duration balance = totalMonthlyHoursWorked.minus(monthlyExpectedHours);
    long balancetoMinutes = balance.toMinutes();

    BigDecimal hourValue = calculateHourlyValue(employee);
    BigDecimal finalValue = (new BigDecimal(balancetoMinutes).divide(new BigDecimal(60), 2, RoundingMode.HALF_UP)).multiply(hourValue);

    return employee.getGrossSalary().add(finalValue);
  }

  private Duration calculateDayHours(ClockRecord dayWorked) {
    Duration hoursWorkedMorning = Duration.between(dayWorked.getClockIn(), dayWorked.getLunchBreakStart());
    Duration hoursWorkedAfternoon = Duration.between(dayWorked.getLunchBreakEnd(), dayWorked.getClockOut());
    return hoursWorkedMorning.plus(hoursWorkedAfternoon);
  }

  private BigDecimal calculateHourlyValue (Employee employee) {
    return employee.getGrossSalary().divide(new BigDecimal(220), 2, RoundingMode.HALF_UP);
  }
}
