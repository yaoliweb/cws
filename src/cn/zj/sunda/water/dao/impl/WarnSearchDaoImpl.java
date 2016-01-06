package cn.zj.sunda.water.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.SimpleDateFormat;


import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.zj.sunda.water.bo.Sewage;
import cn.zj.sunda.water.bo.WarnSearch;
import cn.zj.sunda.water.dao.warnSearchDao;

public class WarnSearchDaoImpl  implements warnSearchDao {

	public String queryByAreaID(int id,double flagTime) {
		// TODO Auto-generated method stub
		try {
			String state="预警";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager
			.getConnection(
					"jdbc:sqlserver://localhost:1433;DatabaseName=CS",
					"sa", "123");
			String sql = "select testingtime from detection_data where sewageID = ? order by testingtime desc";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet  rs = ps.executeQuery();
			if (rs.next()){
				Date date = rs.getDate("testingtime");
				Time time = rs.getTime("testingtime");
				
				String [] dates1 = (date.toString()).split("-");
				String [] times1 = (time.toString()).split(":");
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			    String [] dates2 = (df.format(new java.util.Date())).split("-");
				df = new SimpleDateFormat("HH:mm:ss");
				String [] times2 =  (df.format(new java.util.Date())).split(":");
			    
				
				double [] ts1 = new double [3];
				double [] ts2 = new double [3];
				
				
				for (int x=0; x < 3; x++){
					ts1[x] = Double.parseDouble(times1[x]);
					ts2[x] = Double.parseDouble(times2[x]);
					
				}
				   
				if ( !dates1[0].equals(dates2[0])){
					state = "预警" ; //1表示站点未连接
					
				}else if (!dates1[1].equals(dates2[1]) ){
					state = "预警" ; //月份不相等
				}else if (!dates1[2].equals(dates2[2])){
					state = "预警"; //不是同一天
				}//else if (ts1[0] != ts2[0]){
					//state = "预警"; //不是同一个小时
				//}
			  //  else if ( (ts2[1] - ts1[1]) > flagTime ){
				//	System.out.println("间隔时间========"+(ts2[1]-ts1[1]));
				//	state = "预警"; //大于了20分钟
				//}
			  else {
		    		state = "正常"; // 1 表示站点未连接
				}
				String result="";
				if(state.equals("预警"))
				{
					result = state+"#"+rs.getTimestamp(1).toString();
					
				}
				
				if (rs != null){
					rs.close();
				}
				if (ps != null){
					ps.close();
				}
				if (con!=null){
					con.close();
				}
				System.out.println(result+"=====");
				return result;
			}else{
				return "预警#999999999";
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("出错啦出错啦");
			e.printStackTrace();
			return null;
		}
		
	}

	public List<Sewage> queryLastUpdate() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager
			.getConnection(
					"jdbc:sqlserver://localhost:1433;DatabaseName=CS",
					"sa", "123");
			String sql = "select sewageId max(testingtime) from detection_data group by sewageID ";
			
			
		
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

}
