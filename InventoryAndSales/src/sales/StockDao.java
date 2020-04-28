package sales;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import DButil.DBUtil;

import bean.Stock;

public class StockDao {

	public int insertStock(Stock stock) throws SQLException {
		Connection conn =null;
		PreparedStatement pstmt =null;
		String sql ="INSERT INTO TBL_STOCK VALUES(?,?,?,?,?)";
		DBUtil db=new DBUtil();
	conn = db.getConnection();
	pstmt = conn.prepareStatement(sql);
	String ProductId=stock.getProductId();
	 String ProductName = stock.getProductName();
	 int QuantityOnHand=stock.getQuantityOnHand();
	 double ProductUnitPrice=stock.getProductUnitPrice();
	 int recordLevel=stock.getRecordLevel();
	 pstmt.setString(1, ProductId);
	 pstmt.setString(2, ProductName);
	 pstmt.setInt(3,QuantityOnHand);
	 pstmt.setDouble(4,ProductUnitPrice);
pstmt.setInt(5,recordLevel);
if(pstmt.executeUpdate()==1) {
	System.out.print("data Enter sucess ful");
	
	return 1;}
else {
	System.out.println("fail");
return 0;}
	}
public String generateProductID(String productName) throws SQLException {
	Connection conn = null;
	PreparedStatement pstmt =null;
	DBUtil db=new DBUtil();
	conn=db.getConnection();
	String ProId =""; 
	ProId +=productName.substring(0, 2);
	String sql = "select SEQ_PRODUCT_ID.NEXTVAL FROM TBL_STOCK";
pstmt = conn.prepareStatement(sql);
	ResultSet rs= pstmt.executeQuery();
rs.next();
int seqIs = rs.getInt(1); 
ProId+=seqIs;
System.out.print(ProId);

return ProId;}
	
public int updateStock(String productID,int soldQty) throws SQLException {
	Connection conn=null;
PreparedStatement pstmt=null;
DBUtil db =new DBUtil();
conn = db.getConnection();
String sql ="UPDATE TBL_STOCK SET QUANTITY_ON_HAND = QUANTITY_ON_HAND - ? WHERE PRODUCT_ID =?";
pstmt = conn.prepareStatement(sql);
pstmt.setInt(1, soldQty);
pstmt.setString(2,productID);
if(pstmt.executeUpdate()==1)
{
	System.out.println("Execured Sucess");
	return 1;
}

return 0;}



public Stock getStock(String productID) throws SQLException {
	Stock st=new Stock();
	DBUtil db=new DBUtil();
	Connection conn =null;
	PreparedStatement pstmt =null;
	conn=db.getConnection();
//*****************************	
	String sql ="select * from TBL_STOCK WHERE PRODUCT_ID =?";
	pstmt =conn.prepareStatement(sql);
	pstmt.setString(1, productID);
	ResultSet rs=pstmt.executeQuery();
	rs.next();
	//*****************************	
//	String ProductId=rs.getString(1);
//	 String ProductName = rs.getString(2);
//	 int QuantityOnHand=rs.getInt(3);
//	 double ProductUnitPrice=rs.getDouble(4);
//	 int recordLevel=rs.getInt(5);
	//*****************************
	 st.setProductId(rs.getString(1));
	st.setProductName(rs.getString(2));
	st.setQuantityOnHand(rs.getInt(3));
st.setProductUnitPrice(rs.getDouble(4));
st.setRecordLevel(rs.getInt(5));
//	ArrayList<Stock> li=new ArrayList<>();
//	li.add(st);
//	
	
return st;
	
}

public boolean deleteStock(String productID) throws SQLException {

	DBUtil db=new DBUtil();
	Connection conn =null;
	PreparedStatement pstmt =null;
	conn=db.getConnection();
//*****************************	

	String sql="DELETE TBL_STOCK WHERE PRODUCT_ID=?";
	pstmt=conn.prepareStatement(sql);
	pstmt.setString(1,productID);
	if(pstmt.executeUpdate()==1)
		return true;
	else
		return true;
}

}

