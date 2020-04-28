package Main;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import bean.Sales;
import bean.Stock;
import bean.salesReport;
import sales.StockDao;
import sales.saleDao;
import service.Admin;

public class MainClass {

	public static void main(String[] args) throws ParseException, SQLException {
		Admin ad=new Admin();
		Scanner s=new Scanner(System.in);
		// TODO Auto-generated method stub
//Sales sa= new Sales();
//sa.setProductID("12");
//sa.setSaleID("256");

//String DOB = "";
//System.out.println("Eneter DATE dd-MM-YYyy format");
//DOB = s.next();
//SimpleDateFormat dsf = new SimpleDateFormat("dd-MM-yy");
//java.util.Date udob=dsf.parse(DOB);
//java.sql.Date sqdob = new java.sql.Date(udob.getTime());

//sa.setSaleDate(sqdob);

//	sa.setSalePricePerUnit(100);
//	sa.setQuantitySold(20);
//	saleDao ds = new saleDao();
//	ds.insertStock(sa);
//ArrayList<salesReport> li = new ArrayList<>();
//saleDao sd = new saleDao();
//li=sd.getsaleReport();
//System.out.print(li);
//************************************************************
//	Checking insert stckDao
		Stock st =new Stock();
//	st.setProductId("12");
//	st.setProductName("xyz");
//	st.setQuantityOnHand(300);
//	st.setProductUnitPrice(125.45);
//	st.setRecordLevel(20);
//StockDao sd=new StockDao();
//System.out.print(sd.getStock("PA1003"));
//	}
	//sd.deleteStock("256");	
	
	
	
int ch=0;
do {
	System.out.println("\n1.Insert Stock\n2.Delete Stock \n3.Insert Sales \n4.View Sales Report");
	System.out.println("\n Eneter choice");
	ch=s.nextInt();
	switch(ch) {
	case 1:// for entering into sales
		Stock st1 = new Stock();
		System.out.println("Eneter Product ID");
		String pid = s.next();
		st.setProductId(pid);
		System.out.println("Enter Product Name");
		String Pname = s.next();
		st.setProductName(Pname);
		System.out.println("Enter Quantity in hand");
		int qtInhd =s.nextInt();
		st.setQuantityOnHand(qtInhd);
		System.out.println("Enter product Unit Price");
		double ppup = s.nextDouble();
		st.setProductUnitPrice(ppup);
		System.out.println("Enter Record level");
		int recordLev =s.nextInt();
		st.setQuantityOnHand(recordLev);
		ad.insertStock(st);
		break;
	case 2:// for removing
		System.out.println("Eneter the Item to be Delete From the LIST");
		String rId = s.next();
		ad.deleteStock(rId);
		if(ad.deleteStock(rId)==null) {
			System.out.println("Data Delete Sucess Fully");
		}
		break;
	case 3:
		Sales sal = new Sales();
		System.out.println("Eneter SaleId");
		String salId = s.next();
		sal.setSaleID(salId);
		String DOB="";
		System.out.println("Enter saleDate only in DD-MM-YYYY  format ");
		DOB=s.next();
		SimpleDateFormat dsf = new SimpleDateFormat("dd-mm-yy");
		java.util.Date udob=dsf.parse(DOB);
		java.sql.Date sqdob = new java.sql.Date(udob.getTime());

		sal.setSaleDate(sqdob);

		System.out.println("Eneter Product Id");
		String proId = s.next();
		sal.setProductID(proId);
		

		System.out.println("Enter Quantity Sold in integer format");
		int qtySold = s.nextInt();
		sal.setQuantitySold(qtySold);

		System.out.println("Eneter Sale Per Unit Price");
		int salePerUt = s.nextInt();
		sal.setSalePricePerUnit(salePerUt);
		ad.insertSale(sal);
		
		break;
	case 4:
		ad.getSalesReport();
	break;
	}
}while(ch!=5);
	
	}
}
