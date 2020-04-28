package sales;
import java.sql.*;
import DButil.DBUtil;
import bean.Sales;
import bean.Stock;
import bean.salesReport;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class saleDao {

DBUtil db= new DBUtil();
	public int insertStock(Sales sale) throws SQLException {
	Connection conn = null;
	PreparedStatement pstmt =null; 
	conn = db.getConnection();
	String sql = "INSERT INTO TBL_SALES VALUES(?,?,?,?,?)";
	pstmt = conn.prepareStatement(sql);
	
	String saleId = sale.getSaleID();
	Date date = sale.getSaleDate();
	String salPId =sale.getProductID();
	int salQtyOfsold = sale.getQuantitySold();
	int salePricePerUnit = sale.getSalePricePerUnit();
	pstmt.setString(1, saleId);
	pstmt.setDate(2, (java.sql.Date) date);
	pstmt.setString(3,salPId);
	pstmt.setInt(4, salQtyOfsold);
	pstmt.setInt(5, salePricePerUnit);
	if(pstmt.executeUpdate() == 1)
	{	System.out.print("true");
		return 1;}
	else
		System.out.println("false");
		
	return 0;
	
	}
	
	
	public String generateSaleID(java.util.Date saleDate) throws SQLException {
		
		String gensal="";
		String saleId="";
		gensal +=saleDate;
	saleId = gensal.substring(2, 4);
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	conn=db.getConnection();
	pstmt = conn.prepareStatement("select SEQ_SALES_ID.NEXTVAL FROM TBL_SALEs");
	ResultSet rs = pstmt.executeQuery();
	rs.next();
	int seqIs = rs.getInt(1); // for getting value of value od sequence i.e1003
	saleId+=seqIs;
	System.out.println(seqIs);
		System.out.println(saleId);		
		return saleId;
		
	}
	
	public void getsaleReport() throws SQLException
	{
		ArrayList<salesReport> li =new ArrayList<>();
		Connection conn =null;
		PreparedStatement pstmt =null;
		conn=db.getConnection();
		pstmt = conn.prepareStatement("select * from V_SALE_REPORT");
	ResultSet rs =pstmt.executeQuery();
	ResultSetMetaData rsmd = rs.getMetaData();
	salesReport sr = new salesReport();
//	while(rs.next()) {
//		String saleId = rs.getString(1);
//		Date date = rs.getDate(2);
//		String productId = rs.getString(3);
//		int qtySold = rs.getInt(4);
//		double spput = rs.getDouble(5);
//		String productName = rs.getString(6);
//		
//		double proUtprice = rs.getDouble(7);
//		
//		double profit = spput - proUtprice;
//sr.setSalesId(saleId);
//sr.setSalesDate(date);
//sr.setProductID(productId);
//sr.setProductName(productName);
//sr.setQuantitySold(qtySold);
//sr.setProductUnitPrice(proUtprice);
//sr.setSalePricePerUnit(spput);
//sr.setProfitAmount(profit);
//	li.add(sr);
	//}
	//System.out.println(li);
//	Iterator<salesReport> it=li.iterator();
//	while(it.hasNext()) {
//		System.out.print(it.next());
//	}
	while (rs.next()) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			String colName = rsmd.getColumnName(i);
			
			sb.append(rs.getObject(colName));
			if (i != rsmd.getColumnCount()) sb.append(", ");
		}
		
		System.out.println(sb);
	
	}
	

	
	
	}
	
}