import java.util.Random;

/*
 *@description: Employee Wage Computation Program
 */
class EmpWageBuilder {
    private final int maxWorkingHours;
    private final int maxWorkingDays;
    private final int fullTimeHours;
    private final int partTimeHours;
    private final int hourlyWage;
    private double totalWage;
    private int totalWorkingHours;
    private int totalWorkingDays;

    /*
     *@desc: Parameterized Constructor
     *@param: maxWorkingHours, maxWorkingDays, fullTimeHours, partTimeHours, hourlyWage
     */
    public EmpWageBuilder(int maxWorkingHours, int maxWorkingDays, int fullTimeHours, int partTimeHours, int hourlyWage) {
        this.maxWorkingHours = maxWorkingHours;
        this.maxWorkingDays = maxWorkingDays;
        this.fullTimeHours = fullTimeHours;
        this.partTimeHours = partTimeHours;
        this.hourlyWage = hourlyWage;
        this.totalWage = 0;
        this.totalWorkingHours = 0;
        this.totalWorkingDays = 0;
    }
    /*
     *@name: generateAttendance
     *@description: Generates a random number between 1 and 3
     *@return: 1 for Full Time, 2 for Part Time, 3 for Absent
     */
    private int generateAttendance() {
        return new Random().nextInt(3) + 1;
    }
    /*
     *@name: calculateDailyWage
     *@description: Calculates the daily wage of the employee
     *@param: hoursWorked
     *@return: dailyWage
     */
    private double calculateDailyWage(int hoursWorked) {
        return hoursWorked * hourlyWage;
    }
    /*
     *@name: computeMonthlyWage
     *@description: Computes the monthly wage of the employee
     */
    public void computeMonthlyWage() {
        while (totalWorkingHours < maxWorkingHours && totalWorkingDays < maxWorkingDays) {
            int attendanceStatus = generateAttendance();
            int hoursWorked = 0;

            switch (attendanceStatus) {
                case 1:
                    System.out.println("Day " + (totalWorkingDays + 1) + ": Employee is Present - Full Time");
                    hoursWorked = fullTimeHours;
                    break;
                case 2:
                    System.out.println("Day " + (totalWorkingDays + 1) + ": Employee is Present - Part Time");
                    hoursWorked = partTimeHours;
                    break;
                default:
                    System.out.println("Day " + (totalWorkingDays + 1) + ": Employee is Absent");
            }

            totalWage += calculateDailyWage(hoursWorked);
            totalWorkingHours += hoursWorked;
            totalWorkingDays++;
        }

        System.out.println("Total Monthly Employee Wage: " + totalWage);
        System.out.println("Total Working Hours: " + totalWorkingHours);
        System.out.println("Total Working Days: " + totalWorkingDays);
    }
}

public class employeeWageComp {

    public static void main(String[] args) {
        System.out.println("----------------------------------------------");
        System.out.println(" Welcome to Employee Wage Computation Program ");
        System.out.println("----------------------------------------------");

        EmpWageBuilder companyA = new EmpWageBuilder(100, 20, 8, 4, 20);
        System.out.println("-----------------------------------------");
        System.out.println("| Monthly Wage Computation for Company A |");
        System.out.println("-----------------------------------------");
        companyA.computeMonthlyWage();

        EmpWageBuilder companyB = new EmpWageBuilder(120, 25, 9, 5, 25);
        System.out.println("-----------------------------------------");
        System.out.println("| Monthly Wage Computation for Company B |");
        System.out.println("-----------------------------------------");
        companyB.computeMonthlyWage();
    }
}
