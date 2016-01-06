package cn.zj.sunda.water.bean;
import java.sql.*;
public class testsql {

	double d1 = 0;
	double d2 = 0;
	double d3 = 0;
	double d4 = 0;
	double d5 = 0;
	
	public void getData()
	{
		 Connection con = null;
		 try{
		       // 加载JDBC驱动器类
		       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");                    
		       // 建立到TestDB的数据库连接
		       con = DriverManager.getConnection(
		 "jdbc:sqlserver://E61E39DC8E6D439:1433;DatabaseName=CS", "sa", "123");
		      //查询数据
		      String strQuery = "select detection1,detection2,detection3,detection4,detection5 from sewage where sewageid =4";
		      Statement stmtQuery=con.createStatement();
		          ResultSet rs = stmtQuery.executeQuery(strQuery);
		         if (rs != null)
		         {
		           while (rs.next())
		           {
		              d1 = rs.getDouble(1);
		 			 d2 = rs.getDouble(1);
		 			 d3 = rs.getDouble(2);
		 			 d4 = rs.getDouble(3);
		 			 d5 = rs.getDouble(4);
		 			 System.out.println(d1);
		 			System.out.println(d2);
		 			System.out.println(d3);
		 			System.out.println(d4);
		 			System.out.println(d5);
		           }
		         }
		         else
		         System.out.println("未查询到结果");
		      stmtQuery.close();
		     }
		     catch (SQLException sqle)
		     {
		       System.out.println(sqle.getMessage());
		     }
		     catch (Exception e)
		     {
		    	 System.out.println(e.getMessage());
		     }
		     finally
		     {
		       try
		       {
		         if (con != null)
		         {
		           con.close();
		         }
		       }
		       catch (SQLException sqle)
		       {
		    	   System.out.println(sqle.getMessage());
		       }
		     }
	}
	
	public static void main(String[] args)
	{
		testsql t = new testsql();
		t.getData();
	}
	     
}
