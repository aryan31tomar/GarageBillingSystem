import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Customer;
import services.BillingService;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BillingService billingService = new BillingService();
        while(true){
            System.out.println("1.Add Customer with vehicle \n2. Generate Invoice \n3. Show Invoice\n4. Exit");
            int ch=sc.nextInt();
            sc.nextLine(); 
            switch(ch){
                case 1:
                    System.out.print("Customer Name:");
                    String name=sc.nextLine();
                    System.out.print("Phone No:");
                    String phone = sc.nextLine();
                    services.CustomerServices.addCustomer(new Customer(0,name, phone));
                     Customer savedCustomer = services.CustomerServices.getCustomer(phone);

                    if (savedCustomer == null) {
                    System.out.println("Failed to create customer.");
                    break;
                    }

                    System.out.print("Enter Vehicle Number: ");
                    String vehicleNum = sc.nextLine();

                    System.out.print("Enter Vehicle Model: ");
                    String model = sc.nextLine();

                    // Add vehicle linked to customer
                    entity.Vehicle vehicle = new entity.Vehicle(
                         0,
                         vehicleNum,
                          model,
                         savedCustomer.getId()
                        );

                    services.VehicleService.addVehicle(vehicle);

                    System.out.println("Customer Added Successfully!");
                    System.out.println("Customer ID: " + savedCustomer.getId());

                    break;

                case 2:
                    System.out.print("Enter customer id:");
                    int cid=sc.nextInt();
                    System.out.print("Enter vehicle id");
                    int vid=sc.nextInt();
                    System.out.print("Enter no. of services: ");
                    int n= sc.nextInt();
                    List<Integer> sids = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        System.out.print("enter service id:");
                        sids.add(sc.nextInt());
                    }
                    billingService.createInvoice(cid,vid,sids);
                    break;
                case 3:
                    billingService.showAllInvoice();
                    break;
                case 4: 
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not a valid choice") ;
                    break;
            }
        }
    }
}
