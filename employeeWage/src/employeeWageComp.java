public class employeeWageComp {
    /**
     * @name: calculateDailyWage
     * @i/p: hoursWorked - the number of hours worked by the employee
     * @return/ o/p: the calculated daily wage
     */
    public static double calculateDailyWage(int hoursWorked, double hourlyRate) {
        return hoursWorked * hourlyRate;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        double hourlyRate = 20.00;
        int hoursWorked = 8;

        int attendanceStatus = (int) (Math.random() * 2);

        if (attendanceStatus == 1) {
            System.out.println("Employee is Present");
            double dailyWage = calculateDailyWage(hoursWorked, hourlyRate);
            System.out.println("Daily Employee Wage: " + dailyWage);
        } else {
            System.out.println("Employee is Absent");
            System.out.println("Daily Employee Wage: 0");
        }
    }
    }
