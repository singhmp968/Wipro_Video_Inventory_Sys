package bean;

import java.util.Date;

public class Sales {

	private String saleID;
	private Date saleDate;
	private String productID;
	private int quantitySold;
	private int salePricePerUnit;
	public String getSaleID() {
		return saleID;
	}
	public void setSaleID(String saleID) {
		this.saleID = saleID;
	}
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public int getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}
	public int getSalePricePerUnit() {
		return salePricePerUnit;
	}
	public void setSalePricePerUnit(int salePricePerUnit) {
		this.salePricePerUnit = salePricePerUnit;
	}

	
}
