package bean;

import java.util.Date;

public class salesReport {
	private String salesId;
	private Date salesDate;
	private String productID;
	private String productName;
	private int quantitySold;
	private double productUnitPrice;
	private double salePricePerUnit;
	private double profitAmount;
	public String getSalesId() {
		return salesId;
	}
	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}
	public Date getSalesDate() {
		return salesDate;
	}
	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}
	public double getProductUnitPrice() {
		return productUnitPrice;
	}
	public void setProductUnitPrice(double productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}
	public double getSalePricePerUnit() {
		return salePricePerUnit;
	}
	public void setSalePricePerUnit(double salePricePerUnit) {
		this.salePricePerUnit = salePricePerUnit;
	}
	public double getProfitAmount() {
		return profitAmount;
	}
	public void setProfitAmount(double profitAmount) {
		this.profitAmount = profitAmount;
	}
}
