public class employeeWageComp {
    private static final int FULL_TIME = 1;
    private static final int PART_TIME = 2;
    private static final int HOURLY_WAGE = 20;
    private static final int FULL_TIME_HOURS = 8;
    private static final int PART_TIME_HOURS = 4;

    /**
     * @name: calculateDailyWage
     * @i/p: hoursWorked - the number of hours worked by the employee
     * @return/ o/p: the calculated daily wage
     */
    private static double calculateDailyWage(int hoursWorked) {
        
        return hoursWorked * HOURLY_WAGE;
    }

    /**
     * @name: generateAttendance
     * @return/ o/p: the attendance status (FULL_TIME, PART_TIME, or ABSENT)
     */
    private static int generateAttendance() {

        return (int) (Math.random() * 3) + 1;

    }

    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation Program");

        int attendanceStatus = generateAttendance();
        int hoursWorked = 0;

        if (attendanceStatus == FULL_TIME) {

            System.out.println("Employee is Present - Full Time");

            hoursWorked = FULL_TIME_HOURS;
            double dailyWage = calculateDailyWage(hoursWorked);

            System.out.println("Daily Employee Wage: " + dailyWage);

        } else if (attendanceStatus == PART_TIME) {

            System.out.println("Employee is Present - Part Time");

            hoursWorked = PART_TIME_HOURS;
            double dailyWage = calculateDailyWage(hoursWorked);

            System.out.println("Daily Employee Wage: " + dailyWage);

        } else {
            System.out.println("Employee is Absent");
        }

    }
    }
