import java.util.Random;
/*
 * @name   : employeeWageComp
 * @desc   : calculate monthly wage of an employee for multiple companies
 */
class CompanyEmpWage {
    private final String companyName;
    private final int maxWorkingHours;
    private final int maxWorkingDays;
    private final int fullTimeHours;
    private final int partTimeHours;
    private final int hourlyWage;
    /*
     * @name   : CompanyEmpWage
     * @desc   : constructor for CompanyEmpWage class
     */
    public CompanyEmpWage(String companyName, int maxWorkingHours, int maxWorkingDays, int fullTimeHours, int partTimeHours, int hourlyWage) {
        this.companyName = companyName;
        this.maxWorkingHours = maxWorkingHours;
        this.maxWorkingDays = maxWorkingDays;
        this.fullTimeHours = fullTimeHours;
        this.partTimeHours = partTimeHours;
        this.hourlyWage = hourlyWage;
    }
    //getters
    public String getCompanyName() {
        return companyName;
    }

    public int getMaxWorkingHours() {
        return maxWorkingHours;
    }

    public int getMaxWorkingDays() {
        return maxWorkingDays;
    }

    public int getFullTimeHours() {
        return fullTimeHours;
    }

    public int getPartTimeHours() {
        return partTimeHours;
    }

    public int getHourlyWage() {
        return hourlyWage;
    }
}
/*
 * @name   : EmpWageBuilder
 * @desc   : class to compute monthly wage of an employee for multiple companies
 */
class EmpWageBuilder {
    private final CompanyEmpWage[] companies;

    public EmpWageBuilder(CompanyEmpWage[] companies) {
        this.companies = companies;
    }
    /*
     * @name   : generateAttendance
     * @desc   : generate random number between 1 and 3
     * @returns: random number
     */
    private int generateAttendance() {
        return new Random().nextInt(3) + 1;
    }
    /*
     * @name   : calculateDailyWage
     * @desc   : calculate daily wage of an employee
     * @params : hoursWorked, hourlyWage
     * @returns: daily wage
     */
    private double calculateDailyWage(int hoursWorked, int hourlyWage) {
        return hoursWorked * hourlyWage;
    }
    /*
     * @name   : computeMonthlyWage
     * @desc   : compute monthly wage of an employee for multiple companies
     */
    public void computeMonthlyWage() {
        for (CompanyEmpWage company : companies) {
            double totalWage = 0;
            int totalWorkingHours = 0;
            int totalWorkingDays = 0;

            System.out.println("Company: " + company.getCompanyName());
            while (totalWorkingHours < company.getMaxWorkingHours() && totalWorkingDays < company.getMaxWorkingDays()) {
                int attendanceStatus = generateAttendance();
                int hoursWorked = 0;

                switch (attendanceStatus) {
                    case 1:
                        System.out.println("Day " + (totalWorkingDays + 1) + ": Employee is Present - Full Time");
                        hoursWorked = company.getFullTimeHours();
                        break;
                    case 2:
                        System.out.println("Day " + (totalWorkingDays + 1) + ": Employee is Present - Part Time");
                        hoursWorked = company.getPartTimeHours();
                        break;
                    default:
                        System.out.println("Day " + (totalWorkingDays + 1) + ": Employee is Absent");
                }

                totalWage += calculateDailyWage(hoursWorked, company.getHourlyWage());
                totalWorkingHours += hoursWorked;
                totalWorkingDays++;
            }

            System.out.println("Total Monthly Employee Wage: " + totalWage);
            System.out.println("Total Working Hours: " + totalWorkingHours);
            System.out.println("Total Working Days: " + totalWorkingDays);
            System.out.println("-------------------------");
        }
    }
}

public class employeeWageComp {

    public static void main(String[] args) {
        System.out.println("----------------------------------------------");
        System.out.println(" Welcome to Employee Wage Computation Program ");
        System.out.println("----------------------------------------------");

        CompanyEmpWage[] companies = {
                new CompanyEmpWage("Company A", 100, 20, 8, 4, 20),
                new CompanyEmpWage("Company B", 120, 25, 9, 5, 25)
                // Add more companies as needed
        };

        EmpWageBuilder empWageBuilder = new EmpWageBuilder(companies);
        empWageBuilder.computeMonthlyWage();
    }
}
