public class employeeWageComp {
    private static final int FULL_TIME = 1;
    private static final int PART_TIME = 2;
    private static final int HOURLY_WAGE = 20;
    private static final int FULL_TIME_HOURS = 8;
    private static final int PART_TIME_HOURS = 4;
    private static final int WORKING_DAYS_IN_MONTH = 20;

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

        double totalWage = 0;

        for (int day = 1; day <= WORKING_DAYS_IN_MONTH; day++) {
            int attendanceStatus = generateAttendance();
            int hoursWorked = 0;

            switch (attendanceStatus) {
                case FULL_TIME:
                    System.out.println("Day " + day + ": Employee is Present - Full Time");
                    hoursWorked = FULL_TIME_HOURS;
                    break;
                case PART_TIME:
                    System.out.println("Day " + day + ": Employee is Present - Part Time");
                    hoursWorked = PART_TIME_HOURS;
                    break;
                default:
                    System.out.println("Day " + day + ": Employee is Absent");
            }

            totalWage += calculateDailyWage(hoursWorked);
        }
        System.out.println("Total Monthly Employee Wage: " + totalWage);
    }
    }
