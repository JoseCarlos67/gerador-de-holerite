package service.calculations;

import model.entities.Employee;
import model.entities.Payslip;

import java.math.BigDecimal;

public class PayslipGeneratorService {
  private InssCalculationService inssService;
  private IrrfCalculationService irrfService;
  private SalaryService salaryService;

  public PayslipGeneratorService(InssCalculationService inssService, IrrfCalculationService irrfService, SalaryService salaryService) {
    this.inssService = inssService;
    this.irrfService = irrfService;
    this.salaryService = salaryService;
  }

  public Payslip generate (Employee employee) {
    BigDecimal calculatedGrossSalary = salaryService.calculateMonthlyValue(employee);
    BigDecimal inssValue = inssService.calculate(calculatedGrossSalary);
    BigDecimal irrfValue = irrfService.calculate(calculatedGrossSalary.subtract(inssValue));
    BigDecimal netSalary = calculatedGrossSalary.subtract(inssValue).subtract(irrfValue);

    return new Payslip(inssValue, irrfValue, netSalary, employee);
  }
}
