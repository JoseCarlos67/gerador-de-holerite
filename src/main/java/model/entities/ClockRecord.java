package model.entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class ClockRecord {
  private LocalDate date;
  private LocalTime clockIn;
  private LocalTime clockOut;
  private LocalTime lunchBreakStart;
  private LocalTime lunchBreakEnd;

  public ClockRecord(LocalDate date, LocalTime clockIn, LocalTime lunchBreakStart, LocalTime lunchBreakEnd, LocalTime clockOut) {
    this.date = date;
    this.clockIn = clockIn;
    this.clockOut = clockOut;
    this.lunchBreakStart = lunchBreakStart;
    this.lunchBreakEnd = lunchBreakEnd;
  }

  public LocalDate getDate() {
    return date;
  }

  public LocalTime getClockIn() {
    return clockIn;
  }

  public LocalTime getClockOut() {
    return clockOut;
  }

  public LocalTime getLunchBreakStart() {
    return lunchBreakStart;
  }

  public LocalTime getLunchBreakEnd() {
    return lunchBreakEnd;
  }

  @Override
  public String toString() {
    return "ClockRecord{" +
            "date=" + date +
            ", clockIn=" + clockIn +
            ", clockOut=" + clockOut +
            ", lunchBreakStart=" + lunchBreakStart +
            ", lunchBreakEnd=" + lunchBreakEnd +
            '}';
  }
}
