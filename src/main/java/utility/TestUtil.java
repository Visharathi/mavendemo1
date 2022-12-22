package utility;
import java.util.ArrayList;



public class TestUtil {
	static Xls_Reader r2= new Xls_Reader("C:\\Users\\Visha\\OneDrive\\Documents\\fbdata.xlsx");
	
	
public static ArrayList<Object[]> getDataFromExcel(){
	ArrayList<Object[]> myData = new ArrayList<Object[]>();
	
		
		int rownum=r2.getRowCount("data");
		for(int i=2;i<=rownum;i++)
		{
			
        	String fname = r2.getCellData("data", 0, i);
        	String sname = r2.getCellData("data", 1, i);
        	String email = r2.getCellData("data", 2, i);
        	String pwd = r2.getCellData("data", 3, i);
        	String date = r2.getCellData("data", 4, i);
        	String month = r2.getCellData("data", 5, i);
        	String year = r2.getCellData("data", 6, i);
        	String gender = r2.getCellData("data", 7, i);
        	Object ob[]= {fname,sname,email,pwd,date,month,year,gender};
        	myData.add(ob);
        	
		}
		return myData;
	}
public static ArrayList<Object[]> getDataFromExcel1(){
	ArrayList<Object[]> myData1 = new ArrayList<Object[]>();
	
		
		int rownum=r2.getRowCount("gmail");
		for(int i=2;i<=rownum;i++)
		{
			
        	String fname = r2.getCellData("gmail", 0, i);
        	
        	Object ob[]= {fname};
        	myData1.add(ob);
        	
		}
		return myData1;
	}
public static ArrayList<Object[]> getDataFromExcel2(){
	ArrayList<Object[]> myData2 = new ArrayList<Object[]>();
	
		
		int rownum=r2.getRowCount("gmail");
		for(int i=2;i<=rownum;i++)
		{
			
        	
        	String sname = r2.getCellData("gmail", 1, i);
        	Object ob[]= {sname};
        	myData2.add(ob);
        	
		}
		return myData2;

	}
}
