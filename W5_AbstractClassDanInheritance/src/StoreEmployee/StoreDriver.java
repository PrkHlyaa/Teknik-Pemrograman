package StoreEmployee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoreDriver {

    public static void main(String[] args) throws FileNotFoundException {

        //1. Declare variables managerCount, salesAssociateCount of type integer and initialize them to 0.
        int managerCount = 0;
        int salesAssociateCount = 0;
        int cashierCount = 0;

        //2. Declare & initialize an object for PrintWriter class and use the file name "outputFile.txt" to write the corresponding data
        PrintWriter pwd = new PrintWriter(new File("outputFile.txt"));
        //3. Declare and initialize a scanner object "scanner" to read from the file "inputFile.txt"
        Scanner sc = new Scanner(new File("inputFile.txt"));
        //4. Declare and initialize a List object of type Manager as "managerList", and initialize the object as an ArrayList. 
        List<Manager> managerList = new ArrayList<Manager>();
        //5. Declare and initialize a List object of type SalesAssociate as "salesAssociateList", and initialize the object as an ArrayList. 
        List<SalesAssociate> SalesAssociateList = new ArrayList<SalesAssociate>();
        //6. While inputFile.txt has more data(While loop starts here) {
        List<Cashier> cashierList = new ArrayList<Cashier>();
        
        while (sc.hasNext()) {
            String employeeType = sc.nextLine();
            String storeDetails = sc.nextLine();
            String empName = sc.nextLine();
            double basePay = sc.nextDouble();
            double numberOfHoursWorked = sc.nextDouble();
            double hourlyRate = sc.nextDouble();
            //   Read in the data, and store them to the respective variables such as,
            //   employeeType, storeDetails, empName variables of type String.
            //   basePay, numberOfHoursWorked and hourlyRate as type double
            // 7. If the employee type in the inputFile is "Manager" , then declare variables currentSales, CurrentStoreSales of type double
            //    and read the data. 
            if (employeeType.equals("Manager")) {
                double currentSales = sc.nextDouble();
                double CurrentStoreSales = sc.nextDouble();
                
             //7a. create an object for Manager named as "manager" 
             //    and initialize the multiple argument constructor with above mentioned variables in (question 6 & 7). 
             //    Then add the manager object to the arrayList of managerList.If the employee type is not manager then 
             //    declare a variable salesRate of type double and scan the element, now create an object for salesAssociate named as "salesAssociate",
             //    initialize the sales associate by invoking the constructor of SalesAssociate class with above mentioned variables (question 6 & 7). 
             //    Then add the salesAssociate object to the arrayList of salesAssociateList
                Manager manager = new Manager(CurrentStoreSales, currentSales, numberOfHoursWorked,
                        hourlyRate, storeDetails, basePay, empName);
                String str = sc.nextLine();
                managerList.add(manager);

            } else if(employeeType.equals("Sales Associate")) {
                double salesRate = sc.nextDouble();
                SalesAssociate salesAssociate = new SalesAssociate(salesRate, numberOfHoursWorked, hourlyRate, storeDetails, empName, basePay);
                SalesAssociateList.add(salesAssociate);
                if (sc.hasNext()) {
                    sc.nextLine();
                }
            } else {
            	double cashierRate = sc.nextDouble();
                Cashier cashier = new Cashier(cashierRate, numberOfHoursWorked, hourlyRate, storeDetails, empName, basePay);
                cashierList.add(cashier);
                if (sc.hasNext()) {
                    sc.nextLine();
                }
            }

        }

        // While Loop ends here
        //8. Print the size of the managerList to the console and outputfile. See the sample output for sample formatting
        System.out.println("******************************************************");
        System.out.println("Number of employees working as MANAGER are: " + managerList.size());
        System.out.println("******************************************************");
        pwd.println("******************************************************");
        pwd.println("Number of employees working as MANAGER are: " + managerList.size());
        pwd.println("******************************************************");
        //9. Use an enhanced for loop and iterate through managerList which is of type Manager and use "manager" as variable.
        //   Increment the count of the managerCount by one every time loop is started. Now test the toString() method of manager class. Also write this output to 
        //   the console & outputFile. Test the salesPercentByManager of manager class and write the output to both console and output file.
        //   Test the calculatePay(), calculateRemainingStoreRevenue(double), and checkPromotionEligibility() method of manager class and write the output to both console and output file. Do the required String formatting by seeing the sample output

        for (Manager manager : managerList) {
            managerCount++;
            System.out.println(managerCount + ". Manager Details:");
            System.out.println(manager);
            pwd.println(managerCount + ". Manager Details:");
            pwd.println(manager);
            System.out.println("Percentage of sales done: " + String.format("%.2f", manager.salesPercentByManager()) + "%");
            pwd.println("Percentage of sales done: " + String.format("%.2f", manager.salesPercentByManager()) + "%");
            System.out.println("Gross Payment: $" + String.format("%.1f", manager.calculatePay()));
            pwd.println("Gross Payment: $" + String.format("%.1f", manager.calculatePay()));
            System.out.println("Annual Wage Supplement: $" + String.format("%.2f", manager.calculateAWS()));
            pwd.println("Annual Wage Supplement: $" + String.format("%.2f", manager.calculateAWS()));
            System.out.println("Remaining store revenue: $" + manager.calculateRemainingStoreRevenue(manager.getTotalStoreSales()));
            pwd.println("Remaining store revenue: $" + manager.calculateRemainingStoreRevenue(manager.getTotalStoreSales()));
            System.out.print("Is " + manager.getEmployeeName() + " eligible for annual leave? ");
            if (manager.checkAnualLeave() == true) {
                System.out.println("Yes, he/she can apply annual Levae");
            } else {
                System.out.println("No, he/she can't apply annual Leave");
            }
            pwd.println("Total Annual Leave: " + String.format("%d", manager.getAnnualLeave()));
            System.out.print("Is " + manager.getEmployeeName() + " eligible for promotion? ");
            if (manager.checkPromotionEligibility() == true) {
                System.out.println("Yes, he is \n");
            } else {
                System.out.println("No, he needs to work harder\n");
            }

        }

        //   For Loop ends here
        //10.Print the size of the salesAssociateList to the console and outputfile. See the sample output for sample formatting
        System.out.println("******************************************************");
        System.out.println("Number of employees working as SALES ASSOCIATES are: " + SalesAssociateList.size());
        System.out.println("******************************************************");
        pwd.println("******************************************************");
        pwd.println("Number of employees working as SALES ASSOCIATES are: " + SalesAssociateList.size());
        pwd.println("******************************************************");

        //11. Use a enhanced for loop and iterate through salesAssociateList which is of type SalesAssociate and use "salesAssociate" as variable.
        //   Increment the count of the salesAssociateCount by one every time loop is started. Now test the toString() method of SalesAssociate class. Also write this output to 
        //   the console & outputFile. 
        //   Test the calculatePay(), calculateCommission(), and checkPromotionEligibility() method of salesAssociate class and write the output to both console and output file. Do the required String formatting by seeing the sample output        
        for (SalesAssociate salesAssociate : SalesAssociateList) {
            salesAssociateCount++;
            System.out.println(salesAssociateCount + ". Sales Associate Details:");
            System.out.println(salesAssociate);
            pwd.println(salesAssociate);
            System.out.println("Total commission: $" + salesAssociate.calculateCommission());
            System.out.println("Gross Payment: $" + salesAssociate.calculatePay());
            pwd.println("Total commission: $" + salesAssociate.calculateCommission());
            pwd.println("Gross Payment: $" + salesAssociate.calculatePay());
            System.out.println("Annual Wage Supplement: $" + String.format("%.2f", salesAssociate.calculateAWS()));
            pwd.println("Annual Wage Supplement: $" + String.format("%.2f", salesAssociate.calculateAWS()));
            System.out.print("Is " + salesAssociate.getEmployeeName() + " eligible for annual leave? ");
            if (salesAssociate.checkAnualLeave() == true) {
                System.out.println("Yes, he/she can apply annual Levae");
            } else {
                System.out.println("No, he/she can't apply annual Leave");
            }
            pwd.println("Total Annual Leave: " + String.format("%d", salesAssociate.getAnnualLeave()));
            System.out.print("Is " + salesAssociate.getEmployeeName() + " eligible for promotion? ");
            if (salesAssociate.checkPromotionEligibility() == true) {
                System.out.println("Yes, he/she is eligible\n");
            } else {
                System.out.println("No, he/she needs to work harder\n");
            }

        }
        
        System.out.println("******************************************************");
        System.out.println("Number of employees working as CASHIER are: " + cashierList.size());
        System.out.println("******************************************************");
        pwd.println("******************************************************");
        pwd.println("Number of employees working as CASHIER are: " + cashierList.size());
        pwd.println("******************************************************");

                
        for (Cashier cashier : cashierList) {
        	cashierCount++;
            System.out.println(cashierCount + ". Sales Associate Details:");
            System.out.println(cashier);
            pwd.println(cashier);
            System.out.println("Total commission: $" + cashier.calculateCommission());
            System.out.println("Gross Payment: $" + cashier.calculatePay());
            pwd.println("Total commission: $" + cashier.calculateCommission());
            pwd.println("Gross Payment: $" + cashier.calculatePay());
            System.out.println("Annual Wage Supplement: $" + String.format("%.2f", cashier.calculateAWS()));
            pwd.println("Annual Wage Supplement: $" + String.format("%.2f", cashier.calculateAWS()));
            System.out.print("Is " + cashier.getEmployeeName() + " eligible for annual leave? ");
            if (cashier.checkAnualLeave() == true) {
                System.out.println("Yes, he/she can apply annual Levae");
            } else {
                System.out.println("No, he/she can't apply annual Leave");
            }
            pwd.println("Total Annual Leave: " + String.format("%d", cashier.getAnnualLeave()));
            System.out.print("Is " + cashier.getEmployeeName() + " eligible for promotion? ");
            if (cashier.checkPromotionEligibility() == true) {
                System.out.println("Yes, he/she is eligible\n");
            } else {
                System.out.println("No, he/she needs to work harder\n");
            }

        }
        
        pwd.close();
        sc.close();
        //   For loop ends after this
    }
}