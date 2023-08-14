
public class Pet{
	
	
//	public enum Pettype {
//		DOG,
//	    CAT,
//	    BIRD,
//	    FISH,
//   }
//	public enum Breed {
//		LABRADOR,
//	    PERSIAN,
//	    PARROT,
//	    GOLDFISH,
//
//}
	public String Name;
	public int age;
	public String pettype;
	public String breed;
	public static double price;
	
	public int petid;
	public int getPetid() {
		return petid;
	}
	public void setPetid(int petid) {
		this.petid = petid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPettype() {
		return pettype;
	}
	public void setPettype(String pettype) {
		this.pettype = pettype;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public static double getPrice() {
		return price;
	}
	public static void setPrice(double price) {
		Pet.price = price;
	}


	
	
	
	
}
