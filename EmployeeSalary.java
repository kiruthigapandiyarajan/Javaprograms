import java.util.Scanner;

class Employee {
    String empName, empId, designation, address, mailId, mobileNo;
    double basicPay;

    Employee(String name, String id, String desig,
             String addr, String mail, String mobile, double bp) {
        empName = name;
        empId = id;
        designation = desig;
        address = addr;
        mailId = mail;
        mobileNo = mobile;
        basicPay = bp;
    }

    void displayDetails() {
        System.out.println("\n----------- Employee Details -----------");
        System.out.println("Employee Name : " + empName);
        System.out.println("Employee ID   : " + empId);
        System.out.println("Designation   : " + designation);
        System.out.println("Address       : " + address);
        System.out.println("Mail ID       : " + mailId);
        System.out.println("Mobile No     : " + mobileNo);
        System.out.println("Basic Pay     : " + basicPay);
    }
}

// Parent class for salary calculation
class Salary extends Employee {

    double da, hra, pf, staffClub;
    double grossSalary, netSalary;

    Salary(String name, String id, String desig,
           String addr, String mail,
           String mobile, double bp) {
        super(name, id, desig, addr, mail, mobile, bp);
    }

    void calculateSalary(double daPercent,
                         double hraPercent,
                         double pfPercent,
                         double staffClubPercent) {

        da = basicPay * daPercent / 100;
        hra = basicPay * hraPercent / 100;
        pf = basicPay * pfPercent / 100;
        staffClub = basicPay * staffClubPercent / 100;

        grossSalary = basicPay + da + hra;
        netSalary = grossSalary - pf - staffClub;
    }

    void displaySalary() {
        System.out.println("\n----------- Salary Details -----------");
        System.out.println("DA              : " + da);
        System.out.println("HRA             : " + hra);
        System.out.println("PF              : " + pf);
        System.out.println("Staff Club Fund : " + staffClub);
        System.out.println("Gross Salary    : " + grossSalary);
        System.out.println("Net Salary      : " + netSalary);
    }
}

// Programmer
class Programmer extends Salary {

    Programmer(String name, String id, String desig,
               String addr, String mail,
               String mobile, double bp) {
        super(name, id, desig, addr, mail, mobile, bp);
    }

    void calculate() {
        calculateSalary(97, 10, 12, 1);
    }
}

// Assistant Professor
class AssistantProfessor extends Salary {

    AssistantProfessor(String name, String id, String desig,
                       String addr, String mail,
                       String mobile, double bp) {
        super(name, id, desig, addr, mail, mobile, bp);
    }

    void calculate() {
        calculateSalary(110, 20, 12, 5);
    }
}

// Associate Professor
class AssociateProfessor extends Salary {

    AssociateProfessor(String name, String id, String desig,
                       String addr, String mail,
                       String mobile, double bp) {
        super(name, id, desig, addr, mail, mobile, bp);
    }

    void calculate() {
        calculateSalary(130, 30, 12, 10);
    }
}

// Professor
class Professor extends Salary {

    Professor(String name, String id, String desig,
              String addr, String mail,
              String mobile, double bp) {
        super(name, id, desig, addr, mail, mobile, bp);
    }

    void calculate() {
        calculateSalary(140, 40, 12, 15);
    }
}

public class EmployeeSalary {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("========= Employee Salary Calculator =========");

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Designation: ");
        String designation = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter Mail ID: ");
        String mail = sc.nextLine();

        System.out.print("Enter Mobile Number: ");
        String mobile = sc.nextLine();

        System.out.print("Enter Basic Pay: ");
        double basicPay = sc.nextDouble();

        if (designation.equalsIgnoreCase("Programmer")) {

            Programmer p = new Programmer(name, id, designation,
                    address, mail, mobile, basicPay);
            p.displayDetails();
            p.calculate();
            p.displaySalary();

        } else if (designation.equalsIgnoreCase("Assistant Professor")) {

            AssistantProfessor ap = new AssistantProfessor(name, id, designation,
                    address, mail, mobile, basicPay);
            ap.displayDetails();
            ap.calculate();
            ap.displaySalary();

        } else if (designation.equalsIgnoreCase("Associate Professor")) {

            AssociateProfessor asp = new AssociateProfessor(name, id, designation,
                    address, mail, mobile, basicPay);
            asp.displayDetails();
            asp.calculate();
            asp.displaySalary();

        } else if (designation.equalsIgnoreCase("Professor")) {

            Professor prof = new Professor(name, id, designation,
                    address, mail, mobile, basicPay);
            prof.displayDetails();
            prof.calculate();
            prof.displaySalary();

        } else {
            System.out.println("Invalid Designation!");
        }

        sc.close();
    }
}
