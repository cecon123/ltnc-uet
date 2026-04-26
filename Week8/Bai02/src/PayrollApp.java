
public class PayrollApp {

    private static final double SOCIAL_INSURANCE_RATE = 0.08;
    private static final double HEALTH_INSURANCE_RATE = 0.015;

    private static final double PERSONAL_DEDUCTION = 11_000_000;

    private static final double FIRST_TAX_LEVEL_LIMIT = 5_000_000;
    private static final double SECOND_TAX_LEVEL_LIMIT = 10_000_000;

    private static final double FIRST_TAX_RATE = 0.05;
    private static final double SECOND_TAX_RATE = 0.10;

    private static final double FIRST_TAX_LEVEL_AMOUNT = 250_000;
    private static final double SECOND_TAX_LEVEL_AMOUNT = 750_000;

    public void printPayroll(String name, double baseSalary,
            int workDays, int totalDays,
            double taxRate, double bonus) {
        double actualSalary = calculateActualSalary(baseSalary, workDays, totalDays);
        double insurance = calculateInsurance(actualSalary);
        double tax = calculateTax(actualSalary, insurance, taxRate);
        double netSalary = calculateNetSalary(actualSalary, insurance, tax, bonus);

        printPayrollResult(
                name,
                baseSalary,
                workDays,
                totalDays,
                actualSalary,
                insurance,
                tax,
                bonus,
                netSalary
        );
    }

    private double calculateActualSalary(double baseSalary, int workDays, int totalDays) {
        return baseSalary * workDays / totalDays;
    }

    private double calculateInsurance(double actualSalary) {
        double socialInsurance = actualSalary * SOCIAL_INSURANCE_RATE;
        double healthInsurance = actualSalary * HEALTH_INSURANCE_RATE;

        return socialInsurance + healthInsurance;
    }

    private double calculateTax(double actualSalary, double insurance, double taxRate) {
        double taxableIncome = actualSalary - insurance - PERSONAL_DEDUCTION;

        if (taxableIncome <= 0) {
            return 0;
        }

        if (taxableIncome <= FIRST_TAX_LEVEL_LIMIT) {
            return taxableIncome * FIRST_TAX_RATE;
        }

        if (taxableIncome <= SECOND_TAX_LEVEL_LIMIT) {
            return FIRST_TAX_LEVEL_AMOUNT
                    + (taxableIncome - FIRST_TAX_LEVEL_LIMIT) * SECOND_TAX_RATE;
        }

        return SECOND_TAX_LEVEL_AMOUNT
                + (taxableIncome - SECOND_TAX_LEVEL_LIMIT) * taxRate;
    }

    private double calculateNetSalary(double actualSalary, double insurance,
            double tax, double bonus) {
        return actualSalary - insurance - tax + bonus;
    }

    private void printPayrollResult(String name, double baseSalary,
            int workDays, int totalDays,
            double actualSalary, double insurance,
            double tax, double bonus,
            double netSalary) {
        System.out.println("Nhân viên: " + name);
        System.out.println("Lương cơ bản: " + baseSalary);
        System.out.println("Ngày công: " + workDays + "/" + totalDays);
        System.out.println("Lương thực tế: " + actualSalary);
        System.out.println("Bảo hiểm: " + insurance);
        System.out.println("Thuế TNCN: " + tax);
        System.out.println("Thưởng: " + bonus);
        System.out.println("Thực nhận: " + netSalary);
    }

}
