public class employeeWageComp {
    /*@desc: Using Random to check if employee is present or absent
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        int attendanceStatus = (int) (Math.random() * 2);
        if (attendanceStatus == 1) {
            System.out.println("Employee is Present");
        } else {
            System.out.println("Employee is Absent");
        }
    }
    }
