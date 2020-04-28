package service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.*;
import bean.Sales;
import bean.Stock;
import sales.StockDao;
import sales.saleDao;
import sales.*;
public class Admin {

	private static StockDao stockDao = new StockDao();
 private static saleDao sd = new saleDao();
	
	public String insertStock(Stock stockObj) throws SQLException {
		int len = stockObj.getProductName().length();
		if(stockObj !=null && len>=2) {
		String ProductName = stockObj.getProductName();
			String productID = stockDao.generateProductID(ProductName);
		stockObj.setProductId(productID);
		if(stockDao.insertStock(stockObj)==1)
			return productID;
		else
			return "No Valid";
		}
		return "Data not valid for Insertion";
		
	}


public String deleteStock(String productID) throws SQLException {
	if(stockDao.deleteStock(productID)==true) {
		return "deleted";
	}else {
		return "Not Deleted";
	}
	

	}


public String insertSale(Sales salObj) throws SQLException {
	
	if(salObj==null)
	return "object not valid for Insertion";
	if(stockDao.getStock(salObj.getProductID())==null)
		return "Unknown Product for Sale";
	
		
	if(salObj.getQuantitySold()>stockDao.getStock(salObj.getProductID()).getQuantityOnHand())
	return "Not enough stock on hand for sales";
	
//	if (salObj.getSaleDate().before(new Date()))
//		return "Invalid date";

if(sd.insertStock(salObj)==1) {
	if(stockDao.updateStock(salObj.getProductID(),salObj.getQuantitySold())==1)
		return "record entered Sucessfully";
	else
		return "error";
}else {
	return "error";
}


}

public void getSalesReport() throws SQLException{
	
	 sd.getsaleReport();
 
	
}
}

