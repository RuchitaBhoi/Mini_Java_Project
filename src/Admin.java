
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

enum PetType {
	DOG, CAT, BIRD, FISH
}

enum PetBreed {
	LABRADOR, PERSIAN, PARROT, GOLDFISH

}

public class Admin {

	static Scanner sc = new Scanner(System.in);

	public static void InsertPet(Pet pet) throws ClassNotFoundException, SQLException {
		Connection connection = MyConnection.getConnection();
			Statement stmt = connection.createStatement();

		// for pet id getting only the interger type id
		boolean isValidPetId = false;
		int petId = 0;
		Scanner scanner = new Scanner(System.in);
		while (!isValidPetId) {
			scanner = new Scanner(System.in);
			System.out.println("Enter an Pet ID: ");
			try {
				petId = Integer.parseInt(scanner.nextLine());
				isValidPetId = true;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter an integer.");
			}
		}

		// for pet name
		System.out.println("Enter the pet name : ");
		String name = sc.next();

		// for pet type
		PetType petType = null;
		String selectedPetType = "";
		boolean isValidPetType = false;
		while (!isValidPetType) {
			System.out.println("Enter a pet type (DOG, CAT, BIRD, FISH): ");
			selectedPetType = scanner.nextLine().trim().toUpperCase();

			try {
				petType = PetType.valueOf(selectedPetType);
				isValidPetType = true;
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid pet type. Please enter a valid pet type from the list.");
			}
		}

		// for pet breed
		PetBreed petBreed = null;
		String selectedPetBreed = "";
		boolean isValidPetBreed = false;
		while (!isValidPetBreed) {
			System.out.println("Enter a pet type (LABRADOR, PERSIAN, PARROT, GOLDFISH): ");
			selectedPetBreed = scanner.nextLine().trim().toUpperCase();

			try {
				petBreed = PetBreed.valueOf(selectedPetBreed);
				isValidPetBreed = true;
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid pet breed. Please enter a valid pet breed from the list.");
			}
		}

		// for pet id getting only the interger type id
		boolean isValidPetAge = false;
		int petAge = 0;
		while (!isValidPetAge) {
			scanner = new Scanner(System.in);
			System.out.println("Enter an Pet age: ");
			try {
				petAge = Integer.parseInt(scanner.nextLine());
				
				if(petAge == 0) {
					System.out.println("Enter valid age of the pet.");
				}else {
					isValidPetAge = true;
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter an integer.");
			}
		}

		System.out.println("Enter the pet price : ");
		double price = sc.nextInt();

		String InsetQuery = "Insert into PET(petid,name,pettype,breed,age,price)" + "Values(" + petId + ",'" + name
				+ "','" + petType + "','" +  petBreed + "'," + petAge + "," + price + ")";
			stmt.executeUpdate(InsetQuery);
			System.out.println("Inserted");	
	}

	public static void DeletePet(int petid) throws ClassNotFoundException, SQLException {
		Connection connection = MyConnection.getConnection();
		Statement stmt = connection.createStatement();
		String DelQuery = "DELETE FROM PET WHERE petid=" + petid + "";
			stmt.execute(DelQuery);
		System.out.println("Deleted");

	}

	public static void UpdatePet(int pid, double price) throws SQLException, ClassNotFoundException {
		Connection connection = MyConnection.getConnection();
		Statement stmt = connection.createStatement();
		int pid1 = sc.nextInt();
		System.out.println("Enter price for update: ");
		String price1 = sc.next();

		String UpdateQuery = "UPDATE PET SET price = " + price1 + " where petid = " + pid1;
		int res = stmt.executeUpdate(UpdateQuery);
		System.out.println("Record updated successfully.");
	}

	public static void DispayAll() throws SQLException, ClassNotFoundException {
		Connection connection = MyConnection.getConnection();
		Statement stmt = connection.createStatement();
		System.out.println("All Pets are : ");
		String Display = "SELECT* FROM PET";
		ResultSet resultset = stmt.executeQuery(Display);
		System.out.println("ID \tName \tPettype \tBreed \tAge \tPrice");
		while (resultset.next()) {
			int petid = resultset.getInt("petid");
			String name = resultset.getString("name");
			String pettype = resultset.getString("pettype");
			String breed = resultset.getString("breed");
			int age = resultset.getInt("age");
			double price = resultset.getDouble("price");
			System.out.println(petid + "\t" + name + "\t" + pettype + "\t" + breed + "\t" + age + "\t" + price);
		}
		resultset.close();
	}

}
