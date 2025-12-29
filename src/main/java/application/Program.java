package application;

import model.entities.Employee;
import model.entities.Payslip;
import service.calculations.InssCalculationService;
import service.calculations.IrrfCalculationService;
import service.calculations.PayslipGeneratorService;
import service.calculations.SalaryService;
import service.io.CsvReaderService;
import service.io.CsvWriterService;

import java.io.File;
import java.math.BigDecimal;

public class Program {
  public static void main(String[] args) {
    File filesPath = new File("src/main/java/csvFiles/in/");
    File[] files = filesPath.listFiles();

    CsvReaderService csvReader = new CsvReaderService();
    InssCalculationService inssCalculationService = new InssCalculationService();
    IrrfCalculationService irrfCalculationService = new IrrfCalculationService();
    SalaryService salaryService = new SalaryService();
    CsvWriterService csvWriterService = new CsvWriterService();

    if (files!=null){
      for (File file : files) {
        Employee employee;
        employee = csvReader.readCsv(file.getAbsolutePath());

        PayslipGeneratorService payslipGeneratorService = new PayslipGeneratorService(inssCalculationService, irrfCalculationService, salaryService, employee);

        Payslip payslip = payslipGeneratorService.generate();

        csvWriterService.writerCsv(payslip);
      }
      System.out.printf("Arquivos gerados com sucesso na pasta: " + filesPath.getAbsolutePath());
    } else {
      System.out.printf("ERRO: nenhum arquivo de registro de ponto encontrado!");
    }
  }
}
