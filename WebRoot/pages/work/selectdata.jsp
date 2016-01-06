<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="cn.zj.sunda.water.dao.impl.SewageDaoImpl"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.text.*"%>
<%@page import="java.sql.Date"%>
<html>
	<body>
	<%!//按格式获取当前时间
	String getNowDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(new java.util.Date());
	}
     
	Random random = new Random(); //生成随机类

	//获取随机数
	double getRandomNum() {
		//生成随机boolean值决定随机数的正负值
		if (random.nextBoolean()) {
			return random.nextDouble();
		} else {
			return 0 - random.nextDouble();
		}
	}
	
	NumberFormat nf = new java.text.DecimalFormat("0.00");//数字输出格式
	
	//状态标志
	int flag = 0;
	//设定初始数据
	double dataA = 7.3;
	double dataB = 8.5;
	double dataC = 120.2;
	String dataD ="低";
	double dataE = 5.2;
	double water=0;
	double cod=0;
	double nh3n=0;
	double p=0;
	int gratingDays = 0;
	String state="未选择";
	String elevatorCtlMethod="未选择";
	String elevatorState="未选择";
	String airCtlMethod="未选择";
	String airState="未选择";
	String mudCtlMethod="未选择";
	String mudState="未选择";
	String membraneMethod="未选择";
	String membraneState="未选择";
	String ORP_scale="未选择";
	String ORP_current_value="未选择";
	String PH_scale="未选择";
	String PH_current_value="未选择";
	String T_scale="未选择";
	String T_current_value="未选择";
	String DO_scale="未选择";
	String DO_current_value="未选择";
	String Flow_scale="未选择";
	String Flow_current_value="未选择";
	String LS_scale="未选择";
	String LS_current_value="未选择";
	String StationState="未选择";
	String stdetection7="低";
	java.util.Date confirmGratingTime;
	double d1 = 0;
	double d2 = 0;
	double d3 = 0;
	double d4 =0;
	double d5 = 0;
	double flow;
	int d29=0;
	int d6=0;
	java.util.Date d7;
	String d8;
	String d9;
	int d10;
	%>
		<%
		    Calendar c = Calendar.getInstance(); 
		    String year=String.valueOf(c.get(Calendar.YEAR));
		    String month=String.valueOf(c.get(Calendar.MONTH)+1);
		    String day=String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		    if(day.length()==1)
		    day='0'+day;
		    
		    System.out.println(day);
			String str = (String) session.getAttribute("str");
			System.out.println("在selectdata.jsp里开始session为"+str);

			Connection con = null;
			try {
				// 加载JDBC驱动器类
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				// 建立到TestDB的数据库连接
				con = DriverManager
						.getConnection(
								"jdbc:sqlserver://localhost:1433;DatabaseName=CS",
								"sa", "123");
				//查询数据
				String strQuery = "select detection1,detection2,detection3,detection4,detection5,gratingDays,confirmGratingTime,"
				+"device_alert,control_strategy,action,"
				+"equipment1state,equipment2state,equipment3state,"
				+"detection1UL,detection1DL,detection2UL,detection2DL,detection3UL,detection3DL,detection4UL,detection4DL,detection5UL,detection5DL,equipment5state,"
				+"detection6UL,detection6DL,detection6,equipment4state,detection7"
					+ " from sewage where short_title ='"
					+ str + "'";
				String statisticsQuery="select water,cod,nh3n,p from result_statistics where year='"+year+"' and month='"+month+"' and day='"+day+"' and sewageName='"+str+"'";
				String sql = "select testingtime from detection_data where sewageID in (select sewageID from sewage where short_title = ?) order by testingtime desc";
				Statement stmtQuery = con.createStatement();
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,str);
				ResultSet rs = stmtQuery.executeQuery(strQuery);
				
				
				ResultSet newTimeRs = ps.executeQuery();
				
				
				
				if (newTimeRs.next()){
					
					//将testingtime中的数据获取出来
					Date date = newTimeRs.getDate("testingtime");
					Time time = newTimeRs.getTime("testingtime");
					
					String [] dates1 = (date.toString()).split("-");
					String [] times1 = (time.toString()).split(":");
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");//设置日期格式
				    String [] dates2 = (df.format(new java.util.Date())).split("-");
					df = new SimpleDateFormat("HH:mm:ss");
					String [] times2 =  (df.format(new java.util.Date())).split(":");
				    
				    
				    
					
					double [] ts1 = new double [3];
					double [] ts2 = new double [3];
					
					
					for (int x=0; x < 3; x++){
						ts1[x] = Double.parseDouble(times1[x]);
						ts2[x] = Double.parseDouble(times2[x]);
						
					}
					   
					
					if ( dates1[0].equals(dates2[0])){
						flag = 1 ; //1表示站点未连接
						
					}else if (dates1[1].equals(dates2[1]) ){
						flag = 1 ; //月份不相等
						
				}else if (dates1[2].equals(dates2[2])){
						flag = 1 ; //不是同一天
						
				}else if (ts1[0] != ts2[0]){
						flag = 1; //不是同一个小时
						
				}else if ( (ts2[1] - ts1[1]) > 20 ){
						flag = 1; //大于了20分钟
			    }else {
					flag = 0; // 1 表示站点未连接
					
				}
				
				
				
				
					
				
				}
				
				
				
				if (rs != null) {
				d1=d2=d3=d4=d5=d6=d10=0;
				d8=d9="";
					while (rs.next()) {
	
				   
						d1 = rs.getFloat(1);
						d2 = rs.getFloat(2);
						d3 = rs.getFloat(3);
						d4 = rs.getFloat(4);
						d5 = rs.getFloat(5);
						d6 = rs.getInt(6);
						d7 = rs.getTimestamp(7);
						d8 = rs.getString(8);
						d9 = rs.getString(9);
						d10 = rs.getInt(10);
						d29=rs.getInt(29);
						
						flow=rs.getDouble(27);
						if(rs.getString(11).charAt(0)=='1')
						airState="设备正常【运行】";
						if(rs.getString(11).charAt(0)=='2')
						airState="设备正常【停止】";
						else if(rs.getString(11).charAt(0)=='3')
						airState="设备故障";
						else if(rs.getString(11).charAt(0)=='4')
						airState="设备未安装";
						
						if(rs.getString(12).charAt(0)=='1')
						elevatorState="设备正常【运行】";
						if(rs.getString(12).charAt(0)=='2')
						elevatorState="设备正常【停止】";
						else if(rs.getString(12).charAt(0)=='3')
						elevatorState="设备故障";
						else if(rs.getString(12).charAt(0)=='4')
						elevatorState="设备未安装";
						
						if(rs.getString(28).charAt(0)=='1')
						membraneState="设备正常【运行】";
						if(rs.getString(28).charAt(0)=='2')
						membraneState="设备正常【停止】";
						else if(rs.getString(28).charAt(0)=='3')
						membraneState="设备故障";
						else if(rs.getString(28).charAt(0)=='4')
						membraneState="设备未安装";
						
				if(rs.getString(11).charAt(0)=='3'||rs.getString(12).charAt(0)=='3'||rs.getString(13).charAt(0)=='3'||rs.getString(28).charAt(0)=='3')
				{
				StationState="设备故障";
				}
				else
				{
				StationState="运行正常";
				}
				
						if(d4==0)
						dataD="低";
						else if(d4==1)
						dataD="高";
						else 
						dataD="异常";
					
					    if(d29==0)
					    {
					    stdetection7="低";
					    }
					    if(d29==1)
					    {
					    stdetection7="中";
					    }
					    if(d29==2)
					    {
					    stdetection7="高";
					    }
					
						if(rs.getString(13).charAt(0)=='1')
						mudState="设备正常【运行】";
						if(rs.getString(13).charAt(0)=='2')
						mudState="设备正常【停止】";
						else if(rs.getString(13).charAt(0)=='3')
						mudState="设备故障";
						else if(rs.getString(13).charAt(0)=='4')
						mudState="设备未安装";
						T_scale=String.valueOf(rs.getFloat(15))+" ~ "+String.valueOf(rs.getFloat(14));
						PH_scale=String.valueOf(rs.getFloat(17))+" ~ "+String.valueOf(rs.getFloat(16));
						ORP_scale=String.valueOf(rs.getFloat(19))+" ~ "+String.valueOf(rs.getFloat(18));
						LS_scale=String.valueOf(rs.getFloat(21))+" ~ "+String.valueOf(rs.getFloat(20));
						DO_scale=String.valueOf(rs.getFloat(23))+" ~ "+String.valueOf(rs.getFloat(22));
						Flow_scale=String.valueOf(rs.getFloat(26))+" ~ "+String.valueOf(rs.getFloat(25));
					}
					
					
					
				   
				} else
					System.out.println("未查询到结果");
					 rs= stmtQuery.executeQuery(statisticsQuery);
					 if(rs!=null){
					 water=0;
					 cod=0;
					 nh3n=0;
					 p=0;
					 System.out.println("222222222222222");
					 	 while(rs.next()){
					 	  
					 	 	water=rs.getDouble(1);
					 	 	System.out.println("water"+water);
					 	 	cod=rs.getDouble(2);
					 	 	nh3n=rs.getDouble(3);
					 	 	p=rs.getDouble(4);
					 	 }
					 }
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

			//随机为股票增减价格
			/*dataA += getRandomNum();
			dataB += getRandomNum();
			dataC += getRandomNum();
			dataD += getRandomNum();
			dataE += getRandomNum();*/
			dataA = d1;
			dataB = d2;
			dataC = d3;
			//if(d4==0)
			//dataD = "低";
			//else
			//dataD = "高";
			dataE = d5;
			gratingDays = d6;
			confirmGratingTime=d7;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date begin=formatter.parse(this.getNowDate());
            if(d7!=null){
	            java.util.Date end=formatter.parse(formatter.format(d7));
	            long days=(begin.getTime()-end.getTime())/(24*60*60*1000);
	            if(days>(gratingDays+1))
	            	state="报警：超过设定格栅时间"+String.valueOf(days-gratingDays)+"天";
	            if(days<(gratingDays+1))
	            	state="正常";
            }	  
            else{
            DateFormat dd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            	state="未初始化格栅时间";
            	confirmGratingTime=dd.parse("1970-01-01 00:00:00");
            }
            if(d8.charAt(0)=='1')
            T_current_value= nf.format(dataA)+"("+"正常"+")";
            if(d8.charAt(0)=='2')
            T_current_value= nf.format(dataA)+"("+"警告：温度高于设定值"+")";
            if(d8.charAt(0)=='3')
            T_current_value=nf.format(dataA)+"("+"警告：温度低于设定值"+")";
            
            if(d8.charAt(1)=='1')
            PH_current_value= nf.format(dataB)+"("+"正常"+")";
            if(d8.charAt(1)=='2')
            PH_current_value= nf.format(dataB)+"("+"警告：PH高于设定值"+")";
            if(d8.charAt(1)=='3')
            PH_current_value=nf.format(dataB)+"("+"警告：PH低于设定值"+")";
            
            if(d8.charAt(2)=='1')
            ORP_current_value= nf.format(dataC)+"("+"正常"+")";
            if(d8.charAt(2)=='2')
            ORP_current_value= nf.format(dataC)+"("+"警告：ORP高于设定值"+")";
            if(d8.charAt(2)=='3')
            ORP_current_value=nf.format(dataC)+"("+"警告：ORP低于设定值"+")";
            
             if(d8.charAt(4)=='1')
            DO_current_value= nf.format(dataE)+"("+"正常"+")";
            if(d8.charAt(4)=='2')
            DO_current_value= nf.format(dataE)+"("+"警告：DO高于设定值"+")";
            if(d8.charAt(4)=='3')
            DO_current_value=nf.format(dataE)+"("+"警告：DO低于设定值"+")";
            Flow_current_value=nf.format(flow);
            
            if(d8.charAt(0)=='1'&&d8.charAt(1)=='1'&&d8.charAt(2)=='1'&&d8.charAt(3)=='1'&&d8.charAt(4)=='1')
            {
				StationState="运行正常";
		    }
		    else
		    {
		    StationState="水质异常";
		    }
            
            if(d9.charAt(3)=='1')
            membraneMethod="手动控制";
            else if(d9.charAt(3)=='2')
            membraneMethod="时间控制";
            else if(d9.charAt(3)=='3')
            membraneMethod="溶解氧控制";
            
            if(d9.charAt(2)=='1')
            mudCtlMethod="手动控制";
            else if(d9.charAt(2)=='2')
            mudCtlMethod="自动控制";
            
            if(d9.charAt(1)=='1')
            elevatorCtlMethod="手动控制";
            else if(d9.charAt(1)=='2')
            elevatorCtlMethod="时间控制";
            
            if(d9.charAt(0)=='1')
            airCtlMethod="手动控制";
            else if(d9.charAt(0)=='2')
            airCtlMethod="时间控制";
            else if(d9.charAt(0)=='3')
            airCtlMethod="溶解氧控制";
            
      //      if (flag == 0){
       //     	if(d10==1)
      //      		StationState="运行正常";
       //     	else if(d10!=1)
       //     		StationState="报警";
       //     }else {
       //     		StationState= "未连接";
        //    }
            
				
			   
		
			out.clear(); //清空当前的输出内容（空格和换行符）
			//将格式化后的价格以JSON格式输出
			System.out.println("在selectdata.jsp里结束行"+str);
			StringBuffer result = new StringBuffer("{");
			result.append("'dataA':'" + nf.format(dataA) + "'");
			result.append(",'dataB':'" + nf.format(dataB) + "'");
			result.append(",'dataC':'" + nf.format(dataC) + "'");
			result.append(",'dataD':'" +dataD + "'");
			result.append(",'dataE':'" + nf.format(dataE) + "'");
			result.append(",'gratingDays':'" + gratingDays + "'");
			//result.append(",'confirmGratingTime':'" +formatter.format(confirmGratingTime) + "'");
			result.append(",'airCtlMethod':'" +airCtlMethod + "'");
			result.append(",'airState':'" +airState + "'");
			result.append(",'elevatorCtlMethod':'" +elevatorCtlMethod + "'");
			result.append(",'elevatorState':'" +elevatorState + "'");		
			result.append(",'mudCtlMethod':'" +mudCtlMethod + "'");
			result.append(",'mudState':'" +mudState + "'");
			result.append(",'membraneMethod':'" +membraneMethod + "'");
			result.append(",'membraneState':'" +membraneState + "'");
			
			result.append(",'T_scale':'" +T_scale + "'");
			result.append(",'T_current_value':'" +T_current_value + "'");
			result.append(",'PH_scale':'" +PH_scale + "'");
			result.append(",'PH_current_value':'" + PH_current_value + "'");
			result.append(",'ORP_scale':'" +ORP_scale + "'");
			result.append(",'ORP_current_value':'" + ORP_current_value + "'");
			result.append(",'LS_scale':'" +LS_scale + "'");
			result.append(",'LS_current_value':'" + dataD + "'");
			result.append(",'DO_scale':'" +DO_scale + "'");
			result.append(",'DO_current_value':'" + DO_current_value + "'");
			result.append(",'Flow_scale':'" +Flow_scale + "'");
			result.append(",'Flow_current_value':'" + Flow_current_value + "'");
			result.append(",'state':'" +state + "'");
			result.append(",'water':'" +nf.format(water) + "'");
			result.append(",'cod':'" +nf.format(cod) + "'");
			result.append(",'nh3n':'" +nf.format(nh3n) + "'");
			result.append(",'p':'" +nf.format(p) + "'");
			result.append(",'StationState':'" +StationState + "'");
			result.append(",'lastUpdateTime':'" + getNowDate() + "'");
			result.append(",'stdetection7':'" +stdetection7 + "'");
		    result.append(",'sewagename':'" +str + "'");
			result.append("}");
			out.println(result.toString()); //将结果写入响应体
		%>