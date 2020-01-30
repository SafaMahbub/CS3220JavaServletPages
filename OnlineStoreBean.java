package aFinal;

public class OnlineStoreBean {

	static final int count = 0;
	int id = count;
	String name;
	int price;
	String detail;
	int quantity;
	
	public OnlineStoreBean() {
		super();
		this.id = id++;
		this.name = "";
		this.price = 0;
		this.detail = "";
		this.quantity = 0;
	}
	
	public OnlineStoreBean(int id, String name, String detail, int price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.detail = detail;
		this.quantity = quantity;
	}
	
	public OnlineStoreBean(String id, String name, String detail, String price, String quantity) {
		super();
		this.id = Integer.parseInt(id);
		this.name = name;
		this.price = Integer.parseInt(price);
		this.detail = detail;
		this.quantity = Integer.parseInt(quantity);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}