import java.sql.SQLException;
import java.util.Scanner;

public class PetManagement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		int choice,ch1,ch2,ch3;
	    final String ADMIN_PASSWORD = "admin123";
		Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Welcome to the Pet Management System!");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Enter the admin password: ");
                    String password = scanner.next();
                    if (password.equals(ADMIN_PASSWORD)){
                        
                    }else{
                        System.out.println("Incorrect password. Access denied.");
                        System.out.println();
                    }
                System.out.println("===== Administrator Menu =====");
                 do {
                    System.out.println("1.Add the pet");
                    System.out.println("2.Remove a pet");
                    System.out.println("3.Update the information");
                    System.out.println("4.View all pets");
                    System.out.print("Enter your choice: ");
                    ch1 = scanner.nextInt();
                    switch(ch1) {
                    	case 1:
                    		Pet pet = new Pet();
                    		 System.out.println("Enter Pet details: ");
                    		Admin.InsertPet(pet);
                    		break;
                    	case 2:
                    		 Pet pettodelete = new Pet();
                            System.out.println("Enter Pet ID to delete: ");
                            int deleteId = scanner.nextInt();
                            Admin.DeletePet(deleteId);
                            break;
                    	case 3:
                   
                              System.out.println("Enter Id whose u Want to update the details : ");
                          
                              Admin.UpdatePet(0, 0);
                              break;
                    	case 4: 
                    		Pet dispet = new Pet();
                    		Admin.DispayAll();
                    		break;	
                    	default:
                    		System.out.println("Invalid option.");
                            break;
                    		
                    	}
                    	System.out.println("Do you want to continue");
                    	ch2 = scanner.next().charAt(0);
                    	} while (ch2 == 'Y' || ch2== 'y');	
                 break;
                case 2:
                 System.out.println("===== User Menu =====");
                do{	
                System.out.println("1.Choose pet from here");
                System.out.println("2.Add to Cart");
                System.out.println("3.Update Quantity  "); 
                System.out.println("4.Display Cart");
                System.out.println("5.Delete from Cart");
                System.out.print("Enter the option:");
                ch3 = scanner.nextInt();
                switch (ch3) {
                    case 1:
                    
                        System.out.print("Pet info are: ");
                        System.out.println();
                        User.DispayAll();
                        break;
                    case 2:
                        Purchase purchase = new Purchase();
                        System.out.print("Enter into cart: ");
                       User.Insert(purchase);
                        break;
                    case 3: 
                    	Purchase purupdate = new Purchase();
      					int id = 0;
      					User.Update(0, 2);
                        break;
                    case 4:
                    	User.DiplayCart();
                    	break;
                    case 5:
                    	User.Delete(0);
                    	break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            	System.out.println("Do you want to continue");
            	ch2 = scanner.next().charAt(0);
            	} while (ch2 == 'Y' || ch2== 'y');	
            	break;
              case 3:
                System.out.println("Exiting the system... Goodbye!");
                break;

            default:
                System.out.println("Invalid option.");
                break;
        }
    }
	}      
}