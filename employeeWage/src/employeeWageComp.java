import java.util.Random;

/*
    * @name: employeeWageComp
    * @desc: calculates the monthly wage of an employee
*/
public class employeeWageComp {
    private static final int FULL_TIME = 1;
    private static final int PART_TIME = 2;
    private static final int HOURLY_WAGE = 20;
    private static final int FULL_TIME_HOURS = 8;
    private static final int PART_TIME_HOURS = 4;
    private static final int MAX_WORKING_HOURS = 100;
    private static final int MAX_WORKING_DAYS = 20;

    private double totalWage = 0;
    private int totalWorkingHours = 0;
    private int totalWorkingDays = 0;

    /*
     * @name: calculateDailyWage
     * @desc: calculates the daily wage of an employee
     * @i/p: hoursWorked - the number of hours worked by the employee
     * @return/ o/p: the calculated daily wage
     */
    private double calculateDailyWage(int hoursWorked) {
        return hoursWorked * HOURLY_WAGE;
    }

    /*
     * @name: generateAttendance
     * @desc: generates the attendance status of an employee
     * @i/p: none
     * @return/ o/p: the attendance status of an employee (full time : 1, part time: 2, or absent: 0)
     */
    private int generateAttendance() {
        return new Random().nextInt(3) + 1;
    }

    /*
     * @name: computeMonthlyWage
     * @desc: computes the monthly wage of an employee
     * @param: none
     * @return/ o/p: the total monthly wage, working hours, and working days
     */
    public void computeMonthlyWage() {
        while (totalWorkingHours < MAX_WORKING_HOURS && totalWorkingDays < MAX_WORKING_DAYS) {
            int attendanceStatus = generateAttendance();
            int hoursWorked = 0;

            switch (attendanceStatus) {
                case FULL_TIME:
                    System.out.println("Day " + (totalWorkingDays + 1) + ": Employee is Present - Full Time");
                    hoursWorked = FULL_TIME_HOURS;
                    break;
                case PART_TIME:
                    System.out.println("Day " + (totalWorkingDays + 1) + ": Employee is Present - Part Time");
                    hoursWorked = PART_TIME_HOURS;
                    break;
                default:
                    System.out.println("Day " + (totalWorkingDays + 1) + ": Employee is Absent");
            }

            totalWage += calculateDailyWage(hoursWorked);
            totalWorkingHours += hoursWorked;
            totalWorkingDays++;
        }

        // Display the total monthly wage, working hours, and working days
        System.out.println("Total Monthly Employee Wage: " + totalWage);
        System.out.println("Total Working Hours: " + totalWorkingHours);
        System.out.println("Total Working Days: " + totalWorkingDays);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        // Create an object of employeeWageComp class
        employeeWageComp wageCalculator = new employeeWageComp();
        wageCalculator.computeMonthlyWage();
    }
}
