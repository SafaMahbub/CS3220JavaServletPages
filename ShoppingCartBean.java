package aFinal;

public class ShoppingCartBean {

	OnlineStoreBean item;
	int userQuantity;
	
	
	public ShoppingCartBean(OnlineStoreBean item, int userQuantity) {
		super();
		this.item = item;
		this.userQuantity = userQuantity;
	}
	
	public ShoppingCartBean(OnlineStoreBean item) {
		super();
		this.item = item;
		this.userQuantity = 1;
	}
	
	public OnlineStoreBean getItem() {
		return item;
	}
	public void setItem(OnlineStoreBean item) {
		this.item = item;
	}
	public int getUserQuantity() {
		return userQuantity;
	}
	public void setUserQuantity(int userQuantity) {
		this.userQuantity = userQuantity;
	}
	
	
}
