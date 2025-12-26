package application;

import model.entities.Employee;
import service.calculations.InssCalculationService;
import service.calculations.SalaryService;
import service.io.CsvReaderService;

import java.math.BigDecimal;

public class Program {
  public static void main(String[] args) {
    CsvReaderService csvReader = new CsvReaderService();
    SalaryService salaryService = new SalaryService();
    Employee employee;
    employee = csvReader.readCsv();

    System.out.println(employee);

    System.out.println(salaryService.calculateMonthlyValue(employee));

  }
}
