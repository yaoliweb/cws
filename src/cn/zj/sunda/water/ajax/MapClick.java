package cn.zj.sunda.water.ajax;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.zj.sunda.water.bean.ServiceLocatorBean;
import cn.zj.sunda.water.bo.DetectionData;
import cn.zj.sunda.water.bo.Sewage;
import cn.zj.sunda.water.bo.statistics;
import cn.zj.sunda.water.servicelocator.ServiceLocator;



public class MapClick extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取站点的id号
		int id = Integer.parseInt(request.getParameter("id"));
		int markerP = Integer.parseInt(request.getParameter("p"));

		//获取session
		HttpSession session = request.getSession();
		session.setAttribute("markerP",markerP);
		//获取serviceLocator对象
		ServiceLocator serviceLocator = (ServiceLocatorBean)session.getAttribute("serviceLocator");
		//根据id号查找相关记录
		Sewage sewage = serviceLocator.getSewageService().querySewageById(id);
		
		statistics st=serviceLocator.getStatisticsService().queryBysewageIdTop1(id);
		DetectionData dt=new DetectionData();
		try {
			 dt=serviceLocator.getDetectionDataService().queryDetectionDataBySewageId(id).get(0);
		} catch (Exception e) {
			// TODO: handle exception
			dt.setTestingtime(new Date());
		}
		
		System.out.println(dt.getTestingtime());   
		//获取sewage的各字段的值
		String shorttitle = sewage.getShortTitle();
   		String operationnum=sewage.getOperationnum();
   	
   		String equipment1state = sewage.getEquipment1state();
   		String equipment2state = sewage.getEquipment2state();
   		String equipment3state = sewage.getEquipment3state();
   		String equipment4state = sewage.getEquipment4state();
   		//String equipment5state = sewage.get(i).getEquipment5state();

   		Float detection1 = sewage.getDetection1();
   		Float detection1ul = sewage.getDetection1ul();
   		Float detection1dl = sewage.getDetection1dl();
   		Float detection2 = sewage.getDetection2();
   		Float detection2ul = sewage.getDetection2ul();
   		Float detection2dl = sewage.getDetection2dl();
   		Float detection3 = sewage.getDetection3();
   		Float detection3ul = sewage.getDetection3ul();
   		Float detection3dl = sewage.getDetection3dl();
   		String detection4 = sewage.getDetection4().toString();
   		Float detection4ul = sewage.getDetection4ul();
   		Float detection4dl = sewage.getDetection4dl();
   		Float detection5 = sewage.getDetection5();
   		Float detection5ul = sewage.getDetection5ul();
   		Float detection5dl = sewage.getDetection5dl();
   		Float detection6 = sewage.getDetection6();
   		Float detection6ul = sewage.getDetection6ul();
   		Float detection6dl = sewage.getDetection6dl();	
   		//float water =sewage.getFlow();
   		//float cod=sewage.getCod();
   		//float p=sewage.getP();			 
   		//float nh3n=sewage.getNh3n();	
   		//System.out.println(nh3n);
   	     float water=st.getWater();
   	     float cod=st.getCod();
   	     float p=st.getP();
   	     float nh3n=st.getNh3n();
   		
   			
   			
   		
   		String eqpstate1;
   		String eqpstate2;
   		String eqpstate3;
   		String detvalue1;
   		String detvalue2;
   		String detvalue3;
   		String detvalue4;
   		String detvalue5;
   		String detvalue6;
   		
   		
   		//为文本框添加值
   		if(equipment1state.equals("3"))
		{	
   			eqpstate1 = "<font face='Arial'>"+"<font color='red'>"+"曝气机：故障"+"</font></font><br/>";
   		} else {	
   			eqpstate1 = "<font face='Arial'>"+"曝气机："+(equipment1state.equals("1") ? "运行" : "停止")+"</font>"+"<br/>";		   		
   		} 
   		
		if(equipment2state.equals("3"))
		{
			eqpstate2 = "<font face='Arial'>"+"<font color='red'>"+"污水泵：故障"+"</font>"+"</font>"+"<br/>";
		} else {
  
		    eqpstate2 = "<font face='Arial'>"+"污水泵："+(equipment2state.equals("1") ? "运行" : "停止")+"</font>"+"<br/>";		   		
   		} 
		if(equipment3state.equals("3"))
		{
		    eqpstate3 = "<font face='Arial'>"+"<font color='red'>"+"回流泵：故障"+"</font>"+"</font>"+"<br/>";
		} else {
		    eqpstate3 = "<font face='Arial'>"+"回流泵："+(equipment3state.equals("1")? "运行" : "停止")+"</font>"+"<br/>";
		} 
		if((detection1>detection1ul)||(detection1<detection1dl))
		{	
			detvalue1 = "<font face='Arial'>"+"<font color='orange'>"+"温度："+new java.text.DecimalFormat("0.00").format(detection1)+"</font>"+"</font>"+"<br/>";
   		} else {	
   			detvalue1 = "<font face='Arial'>"+"温度："+new java.text.DecimalFormat("0.00").format(detection1)+"</font>"+"<br/>";
   		} 
		if((detection2>detection2ul)||(detection2<detection2dl))
		{	
			detvalue2 = "<font face='Arial'>"+"<font color='orange'>"+"PH："+new java.text.DecimalFormat("0.00").format(detection2)+"</font>"+"</font>"+"<br/>";
   		} else {
   			detvalue2 = "<font face='Arial'>"+"PH："+new java.text.DecimalFormat("0.00").format(detection2)+"</font>"+"<br/>";
   			} 
		if((detection3>detection3ul)||(detection3<detection3dl))
		{
			detvalue3 = "<font face='Arial'>"+"<font color='orange'>"+"ORP："+new java.text.DecimalFormat("0.00").format(detection3)+"</font>"+"</font>"+"<br/>";
		}else {
			detvalue3 = "<font face='Arial'>"+"ORP："+new java.text.DecimalFormat("0.00").format(detection3)+"</font>"+"<br/>";
		}
		if(detection4.equals("1.0"))
		{	
			detvalue4 = "<font face='Arial'>"+"<font color='orange'>"+"LS：高"+"</font>"+"</font>"+"<br/>";
		}else if(detection4.equals("0.0")){
			detvalue4 = "<font face='Arial'>"+"LS：低"+"</font>"+"<br/>";
		}else{
			detvalue4 = "<font face='Arial'>"+"LS：异常"+"</font>"+"<br/>";
		}
		if((detection5>detection5ul)||(detection5<detection5dl))
		{
			detvalue5 = "<font face='Arial'>"+"<font color='orange'>"+"DO："+new java.text.DecimalFormat("0.00").format(sewage.getDetection5())+"</font>"+"</font>"+"<br/>";
		} else {
			detvalue5 = "<font face='Arial'>"+"DO："+new java.text.DecimalFormat("0.00").format(sewage.getDetection5())+"</font>"+"<br/>";
		}
		if((detection6>detection6ul)||(detection6<detection6dl))
		{
			detvalue6 = "<font face='Arial'>"+"<font color='orange'>"+"流量："+new java.text.DecimalFormat("0.00").format(sewage.getDetection6())+"</font>"+"</font>"+"<br/>";
		}else {
			detvalue6 = "<font face='Arial'>"+"流量："+new java.text.DecimalFormat("0.00").format(sewage.getDetection6())+"</font>"+"<br/>";
		}		
		
		
   	String str1="<font face='Arial'>"+"日处理水量："+new java.text.DecimalFormat("0.00").format(water)+ "立方米"+"</font>" + "<br/>";	
   	String str2="<font face='Arial'>"+"日削减COD量："+new java.text.DecimalFormat("0.00").format(cod)+ "克"+"</font>" + "<br/>";
   	String str3="<font face='Arial'>"+"日削减NH3-N量："+new java.text.DecimalFormat("0.00").format(nh3n)+ "克"+"</font>" + "<br/>";
   	String str4="<font face='Arial'>"+"日削减总P量："+new java.text.DecimalFormat("0.00").format(p)+ "克"+"</font>" + "<br/>";		   				   				   					   		   				   				   	   		
   	
   	
   	
   	
   	String html;//显示在文本框中的值
   	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   	//获取角色值
	int tmp=sewage.getUserRole();
	if(tmp==8||tmp==7)
	{
		String ON= "<font face='Arial'>"+"运营编号："+operationnum +"</font>"+"<br/>";						
		html = "<b><font face='Arial'><a href='/CWS/pages/work/sewagecontrol2.faces?sewageid="+id+"&sewagetitle="+java.net.URLEncoder.encode(sewage.getShortTitle())+"'>"+sewage.getName()+"</a></font></b>"+"<br/>" 
	     	+ ON
	     	+ eqpstate1
	        + eqpstate2
	        + eqpstate3
	        + detvalue1
	        + detvalue2
	        + detvalue3
	        + detvalue4
	        + detvalue5
	        + detvalue6
	        +str1+str2+str3+str4
	        + "<a href='/CWS/pages/work/equipmentlist.faces?sewageid="+id+"'>"+"<font face='Arial'>设备运行记录</font></a>"+ "<br/>"
			+ "<a href='/CWS/pages/work/detectionlist.faces?sewageid="+id+"'>"+"<font face='Arial'>数据检测记录</font></a>";
			
		
		
        } else{
        	html = "<b><font face='Arial'>"+sewage.getName() + "</font></b><br/>"
	     	+ eqpstate1
	        + eqpstate2
	        + eqpstate3
	        + detvalue1
	        + detvalue2
	        + detvalue3
	        + detvalue4
	        + detvalue5
	        +detvalue6
	        +str1+str2+str3+str4
	        + "<a href='/CWS/pages/work/equipmentlist.faces?sewageid="+id+"'><font face='Arial'>设备运行记录</font></a>"+ "<br/>"
			+ "<a href='/CWS/pages/work/detectionlist.faces?sewageid="+id+"'><font face='Arial'>数据检测记录</font></a>";
        	
        
        } 
	
	
	response.setCharacterEncoding("utf-8");
	html = html + "#"+markerP;
	response.getWriter().print(html);
	
	
	
	
	}

}
