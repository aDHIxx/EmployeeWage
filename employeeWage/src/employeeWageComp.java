import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*
 *@name: EmpWageInterface
 *@desc: Interface to add companies and compute monthly wage
 */
interface EmpWageInterface {
    /*
     *@name: addCompany
     *@desc: Adds a company to the list of companies
     *@param: companyName - Name of the company
     *        maxWorkingHours - Maximum working hours per month
     *        maxWorkingDays - Maximum working days per month
     *        fullTimeHours - Number of hours considered full time
     *        partTimeHours - Number of hours considered part time
     *        hourlyWage - Hourly wage of the employee
     */
    void addCompany(String companyName, int maxWorkingHours, int maxWorkingDays, int fullTimeHours, int partTimeHours, int hourlyWage);
    void computeMonthlyWage();
    double getTotalWageByCompany(String companyName);
}

class CompanyEmpWage {
    private final String companyName;
    private final int maxWorkingHours;
    private final int maxWorkingDays;
    private final int fullTimeHours;
    private final int partTimeHours;
    private final int hourlyWage;
    private final List<Double> dailyWages;
    private double totalWage;

    public CompanyEmpWage(String companyName, int maxWorkingHours, int maxWorkingDays, int fullTimeHours, int partTimeHours, int hourlyWage) {
        this.companyName = companyName;
        this.maxWorkingHours = maxWorkingHours;
        this.maxWorkingDays = maxWorkingDays;
        this.fullTimeHours = fullTimeHours;
        this.partTimeHours = partTimeHours;
        this.hourlyWage = hourlyWage;
        this.dailyWages = new ArrayList<>();
        this.totalWage = 0;
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
    public List<Double> getDailyWages() {
        return dailyWages;
    }

    public double getTotalWage() {
        return totalWage;
    }

    /*
     *@name: addDailyWage
     *@desc: Adds the daily wage to the list of daily wages
     *@param: wage - Daily wage of the employee
     */
    public void addDailyWage(double wage) {
        dailyWages.add(wage);
        totalWage += wage;
    }
}

class EmpWageBuilder implements EmpWageInterface {
    private final List<CompanyEmpWage> companies;

    public EmpWageBuilder() {
        companies = new ArrayList<>();
    }

    /*
     *@name: addCompany
     *@desc: Adds a company to the list of companies
     *@param: companyName - Name of the company
     *        maxWorkingHours - Maximum working hours per month
     *        maxWorkingDays - Maximum working days per month
     *        fullTimeHours - Number of hours considered full time
     *        partTimeHours - Number of hours considered part time
     *        hourlyWage - Hourly wage of the employee
     */
    public void addCompany(String companyName, int maxWorkingHours, int maxWorkingDays, int fullTimeHours, int partTimeHours, int hourlyWage) {
        companies.add(new CompanyEmpWage(companyName, maxWorkingHours, maxWorkingDays, fullTimeHours, partTimeHours, hourlyWage));
    }

    /*
     *@name: generateAttendance
     *@desc: Generates a random number between 1 and 3
     *       1 - Full Time
     *       2 - Part Time
     *       3 - Absent
     */
    private int generateAttendance() {
        return new Random().nextInt(3) + 1;
    }

    /*
     *@name: calculateDailyWage
     *@desc: Calculates the daily wage of the employee
     *@param: hoursWorked - Number of hours worked
     *        hourlyWage - Hourly wage of the employee
     */
    private double calculateDailyWage(int hoursWorked, int hourlyWage) {
        return hoursWorked * hourlyWage;
    }

    /*
     *@name: computeMonthlyWage
     *@desc: Computes the monthly wage of the employee
     */
    public double getTotalWageByCompany(String companyName) {
        for (CompanyEmpWage company : companies) {
            if (company.getCompanyName().equals(companyName)) {
                // Call computeMonthlyWage with a flag indicating only total wage calculation
                return computeMonthlyWage(true, company);
            }
        }
        return 0; // Return 0 if the company is not found
    }

    public void computeMonthlyWage() {
        for (CompanyEmpWage company : companies) {
            computeMonthlyWage(false, company);
        }
    }

    private double computeMonthlyWage(boolean onlyTotalWage, CompanyEmpWage company) {
        System.out.println("Company: " + company.getCompanyName());
        System.out.println("-------------------------");
        final int FULL_TIME = 1;
        final int PART_TIME = 2;
        double totalWage = 0;
        int totalWorkingHours = 0;
        int totalWorkingDays = 0;

        while (totalWorkingHours < company.getMaxWorkingHours() && totalWorkingDays < company.getMaxWorkingDays()) {
            int attendanceStatus = generateAttendance();
            int hoursWorked = 0;

            switch (attendanceStatus) {
                case FULL_TIME:
                    hoursWorked = company.getFullTimeHours();
                    break;
                case PART_TIME:
                    hoursWorked = company.getPartTimeHours();
                    break;
                default:
                    hoursWorked = 0;
            }

            double dailyWage = calculateDailyWage(hoursWorked, company.getHourlyWage());
            company.addDailyWage(dailyWage);  // Add daily wage to the list

            totalWage += dailyWage;

            totalWorkingHours += hoursWorked;
            totalWorkingDays++;
        }

        if (!onlyTotalWage) {
            System.out.println("Company: " + company.getCompanyName());
            System.out.println("Total Monthly Employee Wage: " + totalWage);
            System.out.println("Total Working Hours: " + totalWorkingHours);
            System.out.println("Total Working Days: " + totalWorkingDays);
            System.out.println("-------------------------");
        }

        return totalWage;
    }

}




public class employeeWageComp {

    public static void main(String[] args) {
        System.out.println("----------------------------------------------");
        System.out.println("Welcome to Employee Wage Computation Program");
        System.out.println("----------------------------------------------");

        EmpWageInterface empWageBuilder = new EmpWageBuilder();
        empWageBuilder.addCompany("Company A", 100, 20, 8, 4, 20);
        empWageBuilder.addCompany("Company B", 120, 25, 9, 5, 25);
        // Add more companies as needed

        double totalWageForCompanyA = empWageBuilder.getTotalWageByCompany("Company A");
        System.out.println("Total Wage for Company A: " + totalWageForCompanyA);
    }
}

