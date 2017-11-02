import java.io.*;
import java.util.*;
class CheckDb{
	public static void main(String args[])throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Table name and keys and values");
		String tableName = br.readLine();
		Vector<String> keys = new Vector<String>();
		Vector<String> values = new Vector<String>();
		keys.add("roll");keys.add("name");keys.add("Address");keys.add("standard");
		values.add("100");values.add("Nimbus");values.add("Kuwait");values.add("10th");
		int n = databaseOperation.insertIntoDB(tableName,keys,values);
		System.out.println(n+"Rows inserted Successfully");
	}
}