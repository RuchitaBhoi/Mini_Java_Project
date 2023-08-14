public class Purchase {
	
	
	
	public int purchase_id;
	public String user_name;
	public int petid;
	public static int quantity;
	public static Double price;
	
	
	public int getPurchase_id() {
		return purchase_id;
	}
	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getPetid() {
		return petid;
	}
	public void setPetid(int petid) {
		this.petid = petid;
	}
	public static int getQuantity() {
		return quantity;
	}
	public static void setQuantity(int quantity) {
		Purchase.quantity = quantity;
	}
	
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public static Double getPrice() {
		return price;
	}
	
	
    }