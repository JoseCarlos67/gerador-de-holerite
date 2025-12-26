package application;

import model.entities.Employee;
import service.calculations.InssCalculationService;
import service.calculations.IrrfCalculationService;
import service.calculations.PayslipGeneratorService;
import service.calculations.SalaryService;
import service.io.CsvReaderService;

import java.math.BigDecimal;

public class Program {
  public static void main(String[] args) {
    CsvReaderService csvReader = new CsvReaderService();
    Employee employee;
    employee = csvReader.readCsv();

    InssCalculationService inssCalculationService = new InssCalculationService();
    IrrfCalculationService irrfCalculationService = new IrrfCalculationService();
    SalaryService salaryService = new SalaryService();

    PayslipGeneratorService payslipGeneratorService = new PayslipGeneratorService(inssCalculationService, irrfCalculationService, salaryService);

    System.out.println(payslipGeneratorService.generate(employee));
  }
}
