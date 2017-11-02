import java.io.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import javax.swing.table.*;

public class databaseOperation{
	static Connection con;
	static PreparedStatement pstm;
	static String query;
	static Statement stmt;
	public databaseOperation(){
	    try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
			//PreparedStatement pstm = con.prepareStatement("select * from student");
		    //ResultSet rs = pstm.executeQuery();
		   // JTable table = new JTable(databaseOperation.buildModel(rs));
		    //JOptionPane.showMessageDialog(null,new JScrollPane(table));
	
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Error in Connection"+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}
    public static int insertIntoDB(String tableName,Vector keys,Vector values)throws SQLException,Exception{
		try{
			query = "insert into "+tableName;
			/*for(int i=0;i<keys.size();i++){
				if(i!=keys.size()-1)
					query += "\"" +keys.get(i)+ "\",";
				else
					query +="\""+keys.get(i)+"\")";
			}*/
			query +=" VALUES( ";
			if(values.size()>0){
				for(int i=0;i<values.size();i++){
					if(i!=values.size()-1)
						query += "\'" +values.get(i)+ "\',";
					else
						query +="\'"+values.get(i)+"\')";
				}
			}
			System.out.println(query);
			if(query.equals(" ")==false)
				stmt = con.createStatement();
			int numberofRowsInserted = stmt.executeUpdate(query);
			return numberofRowsInserted;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
		//JOptionPane.showMessageDialog(null,new JScrollPane(table));
	}
	public static void deleteFromDB(String tableName,Vector keys,Vector values){
		
	}
	public static void updateFromDB(String tableName,Vector keys,Vector values){
		
	}
	public static void searchFromDB(String tableName,String keys[],String values[]){
		/*String searchString = "";
		for(int i=0;i<keys.length;i++){
			if(i != keys.length-1)
				searchString + = keys[i] + "=" +values[i] + ",";
			else
				searchString + = keys[i] + "=" +values[i]
		}
		System.out.println("select * from "+ tableName +" WHERE "+searchString);
		PreparedStatement pstm = con.prepareStatement("select * from "+ tableName +" WHERE "+searchString);
		ResultSet rs = pstm.executeQuery();
		JTable table = new JTable(databaseOperation.buildModel(rs));
		JOptionPane.showMessageDialog(null,new JScrollPane(table));*/
	}
	public static void displayFromDb(String tableName)throws Exception{
		PreparedStatement pstm = con.prepareStatement("select * from "+tableName);
		ResultSet rs = pstm.executeQuery();
		JTable table = new JTable(databaseOperation.buildModel(rs));
		JOptionPane.showMessageDialog(null,new JScrollPane(table));
		//return table;
	}
	public static DefaultTableModel buildModel(ResultSet rs)throws Exception{
		ResultSetMetaData metaData = rs.getMetaData();
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for(int column=1;column<=columnCount;column++){
			columnNames.add(metaData.getColumnName(column));
		}
		
		Vector<Vector> data = new Vector<Vector>();
		while(rs.next()){
			Vector<Object> Columndata = new Vector<Object>();
			for(int column=1;column<=columnCount;column++){
				Columndata.add(rs.getObject(column));
			}
			data.add(Columndata);
		}
		
		return new DefaultTableModel(data,columnNames);	
	}
	public static void main(String args[]){
		new databaseOperation();
	}
}