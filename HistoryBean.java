package aFinal;

public class HistoryBean {

	String order;
	String total;
	int orderID;
	
	public HistoryBean() {
		super();
	}
	
	public HistoryBean(String order, String total) {
		super();
		this.order = order;
		this.total = total;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getOrderID() {
		return orderID;
	}

}
