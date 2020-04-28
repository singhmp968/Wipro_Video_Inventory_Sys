package bean;

public class Stock {
	private String ProductId;
	private String ProductName;
	private int QuantityOnHand;
	private double ProductUnitPrice;
	private int recordLevel;
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
		ProductId = productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getQuantityOnHand() {
		return QuantityOnHand;
	}
	public void setQuantityOnHand(int quantityOnHand) {
		QuantityOnHand = quantityOnHand;
	}
	public double getProductUnitPrice() {
		return ProductUnitPrice;
	}
	public void setProductUnitPrice(double productUnitPrice) {
		ProductUnitPrice = productUnitPrice;
	}
	public int getRecordLevel() {
		return recordLevel;
	}
	public void setRecordLevel(int recordLevel) {
		this.recordLevel = recordLevel;
	}
}
