import java.util.Scanner;

public class EBBillCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int consumerNo, previous, current, units;
        String name, type;
        double bill = 0;

        System.out.print("Enter Consumer Number: ");
        consumerNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Consumer Name: ");
        name = sc.nextLine();

        System.out.print("Enter Previous Reading: ");
        previous = sc.nextInt();

        System.out.print("Enter Current Reading: ");
        current = sc.nextInt();

        units = current - previous;

        System.out.print("Enter Connection Type (domestic/commercial): ");
        type = sc.next();

        if (type.equalsIgnoreCase("domestic")) {
            if (units <= 100)
                bill = 0;
            else if (units <= 200)
                bill = (units - 100) * 2;
            else if (units <= 500)
                bill = (100 * 2) + (units - 200) * 4;
            else
                bill = (100 * 2) + (300 * 4) + (units - 500) * 6;
        } else if (type.equalsIgnoreCase("commercial")) {
            if (units <= 100)
                bill = units * 2;
            else if (units <= 200)
                bill = (100 * 2) + (units - 100) * 4;
            else if (units <= 500)
                bill = (100 * 2) + (100 * 4) + (units - 200) * 6;
            else
                bill = (100 * 2) + (100 * 4) + (300 * 6) + (units - 500) * 7;
        } else {
            System.out.println("Invalid Connection Type");
            return;
        }

        System.out.println("\nConsumer Number : " + consumerNo);
        System.out.println("Consumer Name   : " + name);
        System.out.println("Units Consumed  : " + units);
        System.out.println("Total Bill      : Rs. " + bill);

        sc.close();
    }
}
