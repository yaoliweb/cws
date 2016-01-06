<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.text.*"%>	
<%
	//设定初始数据
	String d1;
	double d2 = 0;
	double d3 = 0;
	double d4 = 0;
	double d5 = 0;
	double d6 = 0;
	
	//数字输出格式
	NumberFormat nf = new java.text.DecimalFormat("0.00");
	
	String str = (String) session.getAttribute("str");
	//StringBuffer result = new StringBuffer("{results:");
	StringBuffer result = new StringBuffer("{datalist:[");
	Connection con = null;
	ResultSet rs = null;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat formatter1 = new SimpleDateFormat("HH:00");
	String now = formatter.format(new java.util.Date());
	
	try {
		// 加载JDBC驱动器类
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// 建立到TestDB的数据库连接
		con = DriverManager
				.getConnection(
						"jdbc:sqlserver://localhost:1433;DatabaseName=CS",
						"sa", "123");
		//查询数据
		String strQuery = "select A.testingtime,A.detection1,A.detection2,A.detection3,A.detection4,A.detection5" 
			+ " from detection_data A,sewage B where A.sewageID = B.sewageID and B.short_title ='"
			+ str + "' and convert(varchar(10), testingtime, 120) = '" + now + "' and"
			+ " substring(convert(varchar(100),testingtime,120),15,2)='00'"
			+ " order by testingtime";

		Statement stmtQuery = con.createStatement();
		rs = stmtQuery.executeQuery(strQuery);
		
		//result.append(rs.getFetchSize() + ",datalist:[");
		
		while (rs.next()) {
			d1 = formatter1.format(new java.util.Date(rs.getTimestamp(1).getTime()));
			d2 = rs.getFloat(2);
			d3 = rs.getFloat(3);
			d4 = rs.getFloat(4);
			d5 = rs.getFloat(5);
			d6 = rs.getFloat(6);
	
			
			result.append("{'time':'" + d1 + "'");
			result.append(",'T':'" + nf.format(d2) + "'");
			result.append(",'PH':'" + nf.format(d3) + "'");
			result.append(",'ORP':'" + nf.format(d4) + "'");
			result.append(",'LS':'" + nf.format(d5) + "'");
			result.append(",'DO':'" + nf.format(d6) + "'},");
			
		}
		rs.close();
		stmtQuery.close();
	} catch (SQLException sqle) {
		out.println(sqle.getMessage());
	} catch (Exception e) {
		out.println(e.getMessage());
	} finally {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException sqle) {
			out.println(sqle.getMessage());
		}
	}
	
	if (result.charAt(result.length()-1)==',') {
	
		result.deleteCharAt(result.length()-1);
	}
	
	result.append("]}");
	//System.out.println(result);		
	out.println(result.toString()); //将结果写入响应体
%>