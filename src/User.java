import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class User {

	static Scanner sc = new Scanner(System.in);
	 

	public static void DispayAll() throws SQLException, ClassNotFoundException
	{
		Connection connection = MyConnection.getConnection();
		Statement stmt = connection.createStatement();
		 String Display = "SELECT* FROM PET";
		 ResultSet resultset = stmt.executeQuery(Display);
		 System.out.println("ID\tName\tpettype\tbreed\tAge\tprice");
	        while (resultset.next()) {
	            int petid = resultset.getInt("petid");
	            String name = resultset.getString("name");
	            String pettype = resultset.getString("pettype");
	            String breed = resultset.getString("breed");
	            int age = resultset.getInt("age");
	            double price = resultset.getDouble("price");
	            System.out.println(petid + "\t" + name + "\t" + pettype + "\t" + breed + "\t" + age + "\t" +price);
	        }
	        resultset.close();
	}
	
	
	public static void Insert(Purchase purchase) throws ClassNotFoundException, SQLException
	{
		Connection connection = MyConnection.getConnection();
		 String insertQuery = "INSERT INTO purchase (purchase_id, purchaser, petid, quantity,price) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pstmt = connection.prepareStatement(insertQuery);
			
			boolean isValidPurchaseId = false;
			int purchase_id = 0;
			while (!isValidPurchaseId) {
				sc = new Scanner(System.in);
				System.out.println("Please enter purchace Id: ");
				try {
					purchase_id = Integer.parseInt(sc.nextLine());
					if(purchase_id <= 0){
					System.out.println("Invalid input. Purchase id not be a zero.");
					}else{
						pstmt.setInt(1, purchase_id);
						isValidPurchaseId = true;
					}
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Please enter an integer.");
					isValidPurchaseId = false;
				}
			}

			String purchaser = "";
			System.out.println("Please enter purchacer: ");
			while (purchaser.trim() == ""){
				purchaser = sc.next();
				pstmt.setString(2, purchaser);
			}
			
		
			boolean isValidPetId = false;
			int petId = 0;
			while (!isValidPetId) {
				sc = new Scanner(System.in);
				System.out.println("Enter an Pet ID: ");
				try {
					petId = Integer.parseInt(sc.nextLine());
					if(petId <= 0){
						System.out.println("Invalid input. Pet id not be a zero.");
					}else{
						isValidPetId = true;
						pstmt.setInt(3, petId);
					}					
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Please enter an integer.");
				}
			}
			
			boolean isValidQuantity = false;
			int quantity = 0;
			while (!isValidQuantity) {
				sc = new Scanner(System.in);
				System.out.println("Enter an Pet Quantity: ");
				try {
					quantity = Integer.parseInt(sc.nextLine());
					if(quantity <= 0){
						System.out.println("Invalid input. Quantity not be a zero.");
					}else{
						isValidQuantity = true;
						pstmt.setInt(4, quantity);
					}					
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Please enter an integer.");
				}
			}
			
			double petPrice = 0;
			String getPetPriceQuery = "select price from PET where petid = "+petId+" LIMIT 1";
			try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","123456");
			 	Statement stmt = conn.createStatement();
			 	ResultSet result = stmt.executeQuery(getPetPriceQuery);
		      ) {		      
			 if(result.next()){
			   petPrice = result.getInt("price");
			 }
		      } catch (SQLException e) {
		    	  System.out.println(e.getMessage());
		      } 
			
			petPrice = petPrice * quantity;
			pstmt.setDouble(5, petPrice);
	        System.out.println("Total Price: $" + petPrice);
		   int rowsAffected = pstmt.executeUpdate();  
           if (rowsAffected > 0) {
               System.out.println("Pet purchase successful!");
           } else {
               System.out.println("Failed to purchase the pet. Please try again.");
           }
	}
  	
	
	public static void Delete(int id) throws ClassNotFoundException, SQLException
	{
		Connection connection = MyConnection.getConnection(); 
		PreparedStatement pstmt = connection.prepareStatement("Delete from purchase where purchase_id= ?");
		pstmt.setInt(1,sc.nextInt());
		pstmt.executeUpdate();
		System.out.println("Record deleted successfully."); 
	}
	public static void Update(int pid,int quantity) throws ClassNotFoundException, SQLException
	{
	       Connection con = MyConnection.getConnection();
	       PreparedStatement pstmt=null;
	       String updateQuery="update PURCHASE SET quantity=? where purchase_id=?";
	       pstmt=con.prepareStatement(updateQuery);
	       System.out.print("Enter purchase_id : ");
	       int id1=sc.nextInt();
	       System.out.print("U want to update quantity please enter :");
		   String quantity1 = sc.next();
		     pstmt.setInt(2,id1);
		     pstmt.setString(1, quantity1);

	    
	     /*  System.out.print("Enter what u want to update 1.Name\n 2.breed 3.age 4.quantity  \n");
	       int updateinfo=sc.nextInt();
	       if(updateinfo==1)
	       {
	           System.out.println("U want to update Name please enter name");
	           pstmt.setString(2,sc.next());
	        }
	       else if(updateinfo==2)
	       {
	       System.out.print("U want to update breed so enter breed");
	       pstmt.setString(2, sc.next());
	       }
	       else if(updateinfo==3) 
	       {
	       System.out.print("U want to update age please enter");
	       pstmt.setInt(2, sc.nextInt());
	       }else if(updateinfo==4) 
	       {*/

	          pstmt.executeUpdate();
	            System.out.println("Record updated successfully.");
	       	}


	public static void DiplayCart() throws ClassNotFoundException, SQLException
	{
		Connection connection = MyConnection.getConnection();
		Statement stmt = connection.createStatement();
		 System.out.println("All Pets are : ");
		 String Display = "SELECT* FROM PURCHASE";
		 ResultSet resultset = stmt.executeQuery(Display);
		 System.out.println("purchase_id\tpurchaser\tpetid\tquantity\tprice");
	        while (resultset.next()) {
	           int purchase_id = resultset.getInt("purchase_id");
	            String name = resultset.getString("purchaser");
	            int petid = resultset.getInt("petid");
	            int quantity = resultset.getInt("quantity");
	            int price = resultset.getInt("price");
	            System.out.println(purchase_id + "\t" + name + "\t" + petid + "\t" + quantity + "\t" + price );
	        }
		
	}
	
}
