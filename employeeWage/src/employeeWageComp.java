import java.util.Random;

/*
    * @name: employeeWageComp
    * @desc: calculates the monthly wage of an employee
*/
public class employeeWageComp {

    /*
     * @name: calculateDailyWage
     * @desc: calculates the daily wage of an employee
     * @i/p: hoursWorked - the number of hours worked by the employee
     *       hourlyWage - the hourly wage for the employee
     * @return/ o/p: the calculated daily wage
     */
    private static double calculateDailyWage(int hoursWorked, int hourlyWage) {
        return hoursWorked * hourlyWage;
    }

    /*
     * @name: generateAttendance
     * @desc: generates the attendance status of an employee
     * @i/p: none
     * @return/ o/p: the attendance status of an employee (full time : 1, part time: 2, or absent: 0)
     */
    private static int generateAttendance() {  //making it static to access it from computeMonthlyWage bcz it is static
        return new Random().nextInt(3) + 1;
    }

    /*
     * @name: computeMonthlyWage
     * @desc: computes the monthly wage of an employee
     * @i/p: maxWorkingHours - the maximum working hours per month
     *       maxWorkingDays - the maximum working days per month
     *       fullTimeHours - the number of hours for full-time work
     *       partTimeHours - the number of hours for part-time work
     *       hourlyWage - the hourly wage for the employee
     * @return/ o/p: none
     */
    private static void computeMonthlyWage(int maxWorkingHours, int maxWorkingDays,
                                           int fullTimeHours, int partTimeHours, int hourlyWage) {
        double totalWage = 0;
        int totalWorkingHours = 0;
        int totalWorkingDays = 0;

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

            totalWage += calculateDailyWage(hoursWorked, hourlyWage);
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
        System.out.println("----------------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("| Monthly Wage Computation for Company A |");
        System.out.println("-----------------------------------------");
        computeMonthlyWage(100, 20, 8, 4, 20);
        System.out.println("-----------------------------------------");
        System.out.println("| Monthly Wage Computation for Company B |");
        System.out.println("-----------------------------------------");
        computeMonthlyWage(120, 25, 9, 5, 25);
    }
}
