<%@ page language="java"  contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ page import= "java.util.List"%>
<%@ page import= "java.util.Iterator"%>  
<%@ page import= "java.util.Calendar"%>
<%@ page import= "cn.zj.sunda.water.bo.Sewage"%> 
<%@ page import= "cn.zj.sunda.water.bo.statistics"%> 
<%@ page import= "cn.zj.sunda.water.servicelocator.ServiceLocator" %>
<%@ page import= "cn.zj.sunda.water.bean.ServiceLocatorBean" %>
<%@ page import= "cn.zj.sunda.water.bo.DetectionData" %>
<%@ page import= "java.util.Date" %>
<%@ page import= "java.text.SimpleDateFormat" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	ServiceLocator serviceLocator = new ServiceLocatorBean();
	List<Sewage> allsewage = serviceLocator.getSewageService().queryAllSewage();
	session.setAttribute("allsewage", allsewage);
	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
body, html,#map_canvas {width: 100%;height: 100%;overflow: hidden;margin:0;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=sCzKV59ELXQejZ6VgPttyoWZ"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.5.1.js"></script>
<script type="text/javascript">

jQuery.noConflict();
</script>
</head>
	<body>

				<table id="table2" width="800" height="600">
					<tr>
						<td width="800" height="25" background="<%=basePath %>images/background.jpg" >				
							<table width="800" height="25" cellspacing="0" cellpadding="0" border="0" >
								<tr>
									<td align="left">
										<table >
											<tr>
												<td><h:inputText value="#{sewageBean.shortTitle}" id="sewagevalue"/>
										
											</td>
												
									
                                                
                                                
                                                
												<td><h:commandButton value="搜索" action="#{sewageBean.getsewageLatLng}"/></td>
												<td valign="bottom"><h:messages styleClass="error-msg" globalOnly="true" /></td>
										
									            <td><h:selectOneMenu id="area" value="#{sewageBean.areaSelectIndex}"
											     style="width: 150px" >
											     <f:selectItems value="#{sewageBean.areaItem}"  />
											
										       </h:selectOneMenu></td>
										       <td><h:commandButton value="选定" action="#{sewageBean.valuechange_area_focus}"/></td>
												<td><input type="checkbox"  id="show"  onchange="go()"></td>
												
												<td><input type="button" value="图像抓拍" onclick="javascript:window.open('http://115.236.191.50:9090/SWS/pages/Country/Media/atuoLoginPicture.jsp?dbname=SWS_COUNTRY_TEST&username=admin')"/></td>
											<td><h:outputText  value="设备故障率："></h:outputText></td>
											<td><p id="error">0%</td>
											<td><h:outputText  value="水质异常率："></h:outputText></td>
											<td><p id="exception">0%</td>
											
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>							
					<tr>
						<td>
							<div id="map_canvas" style="overfolw: auto; width: 795px; height: 570px; OVERFLOW-y: auto; OVERFLOW-x: auto">正在载入地图，请稍等...</div>
						</td>
					</tr>
				</table>
	</body>

	<script type="text/javascript">

go();
function Percentage(num, total) { 
 return (Math.round(num / total * 10000) / 100.00 + "%");
   
}
	
function go(){
		var markers=[];
		var element=document.getElementById("show").getAttribute("checked");
	
		if(element==null)
		{
		document.getElementById("show").setAttribute("checked","checked");
		}
		if(element=="checked")
		{
		document.getElementById("show").removeAttribute("checked");
		}
	
		var points=[];
		var htmls=[];
		var images=[];
		var error=0;
		var exception=0;
	    var total;
	
		var mylat = <%=(Double)session.getAttribute("coordinateX") %>
		var mylng = <%=(Double)session.getAttribute("coordinateY") %>
		if(mylat==null||mylng==null){
				mylat=31.593349;       //纬度
				mylng=120.383333;         //经度
			}
		var map = new BMap.Map("map_canvas");
		var xy = new BMap.Point(mylng,mylat);
		map.centerAndZoom(xy, 11);                 // 初始化地图，设置中心点坐标和地图级别  
        map.enableScrollWheelZoom();
        
        map.addControl(new BMap.NavigationControl());  //添加默认缩放平移控件
        map.addControl(new BMap.NavigationControl({anchor: BMAP_ANCHOR_TOP_RIGHT, type: BMAP_NAVIGATION_CONTROL_SMALL}));  //右上角，仅包含平移和缩放按钮
        map.addControl(new BMap.NavigationControl({anchor: BMAP_ANCHOR_BOTTOM_LEFT, type: BMAP_NAVIGATION_CONTROL_PAN}));  //左下角，仅包含平移按钮
        map.addControl(new BMap.NavigationControl({anchor: BMAP_ANCHOR_BOTTOM_RIGHT, type: BMAP_NAVIGATION_CONTROL_ZOOM}));  //右下角，仅包含缩放按钮
	 
		  
		<% 	
		List<Sewage> sewage=(List<Sewage>)session.getAttribute("listsewage");%>
		  total=<%=sewage.size()%>
<% 
		   for(int i =0;i<sewage.size();i++)
		   {
		       // Integer sewageID=sewage.get(i).getSewageId();
		   		String shorttitle = sewage.get(i).getShortTitle();
		   		String operationnum=sewage.get(i).getOperationnum();
		   	
		   		String equipment1state = sewage.get(i).getEquipment1state();
		   		String equipment2state = sewage.get(i).getEquipment2state();
		   		String equipment3state = sewage.get(i).getEquipment3state();
		   		String equipment4state = sewage.get(i).getEquipment4state();

		   		Float detection1 = sewage.get(i).getDetection1();
		   		Float detection1ul = sewage.get(i).getDetection1ul();
		   		Float detection1dl = sewage.get(i).getDetection1dl();
		   		Float detection2 = sewage.get(i).getDetection2();
		   		Float detection2ul = sewage.get(i).getDetection2ul();
		   		Float detection2dl = sewage.get(i).getDetection2dl();
		   		Float detection3 = sewage.get(i).getDetection3();
		   		Float detection3ul = sewage.get(i).getDetection3ul();
		   		Float detection3dl = sewage.get(i).getDetection3dl();
		   		String detection4 = sewage.get(i).getDetection4().toString();
		   		Float detection4ul = sewage.get(i).getDetection4ul();
		   		Float detection4dl = sewage.get(i).getDetection4dl();
		   		Float detection5 = sewage.get(i).getDetection5();
		   		Float detection5ul = sewage.get(i).getDetection5ul();
		   		Float detection5dl = sewage.get(i).getDetection5dl();
		   		Float detection6 = sewage.get(i).getDetection6();
		   		Float detection6ul = sewage.get(i).getDetection6ul();
		   		Float detection6dl = sewage.get(i).getDetection6dl();
		   		Date sewagetime=null;
		   		try	
		   		{
		   		//DetectionData dt=serviceLocator.getDetectionDataService().queryDetectionDataBySewageId(sewageID).get(0);
		   		 //sewagetime=dt.getTestingtime();
		   		
		   		 sewagetime=sewage.get(i).getUpdatetime();
		   		 
		   		
		   		}catch(Exception e)
		   		{
		   		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   		 sewagetime=df.parse("2000-01-01 00:00:01");
		   		}
		   		Date nowtime=new Date();
		   		String date1=nowtime.toString().substring(8,10);
		   		String date2=sewagetime.toString().substring(8,10);
		   	
		   		
		   		%>
		   		 var image;
		   		 <%if(!date1.equals(date2))  
		   		 {%>
		   		 if(element==null)
		   		 {image = "http://www.google.cn/intl/en_us/mapfiles/ms/micons/green-dot.png";}
		   		 else{
			    image="http://www.google.cn/intl/en_us/mapfiles/ms/micons/blue-dot.png";}
		   		<%
		   		}else
		   		{
		   		if(equipment1state.equals("3")||equipment2state.equals("3")||equipment3state.equals("3")||equipment4state.equals("3"))
		   		{
		   		%>
		  
		   		if(element==null)
		   		{image = "http://www.google.cn/intl/en_us/mapfiles/ms/micons/green-dot.png";}
		   		else{
			    image = "http://www.google.cn/intl/en_us/mapfiles/ms/micons/red-dot.png";
			    error=error+1;}
			    
		   		<%
		   		}
		   		else
		   		{
					if(((detection1>detection1ul)||(detection1<detection1dl)) ||
					((detection2>detection2ul)||(detection2<detection2dl)) ||
					((detection3>detection3ul)||(detection3<detection3dl)) ||
					(detection4=="1") ||
					((detection5>detection5ul)||(detection5<detection5dl)))
			   		{ 
			   		%>
				    image = "http://www.google.cn/intl/en_us/mapfiles/ms/micons/yellow-dot.png";
				    exception=exception+1;
				    
			   		<%
			   		}			   		
			   		else {
			   		%>			   		
				    image = "http://www.google.cn/intl/en_us/mapfiles/ms/micons/green-dot.png";
			   		<%
			   		}
		   		}
		   		}%>
		   		<% 
			   		if(shorttitle.equals(session.getAttribute("shortTitle")) || operationnum.equals(session.getAttribute("shortTitle")))
			   		{
		   		%>
		   			image = "http://www.google.cn/intl/en_us/mapfiles/ms/micons/purple-dot.png";
		   		<%
		   			}
				%>	
		   		
		   
				
			   	document.getElementById("exception").innerHTML=Percentage(exception,total);
                document.getElementById("error").innerHTML=Percentage(error,total); 
             	
				var tmp=<%=sewage.get(i).getUserRole()%>;
				if(tmp==8||tmp==7)
				{
				
				var point = new BMap.Point(<%=sewage.get(i).getCoordinateY()%>, <%=sewage.get(i).getCoordinateX()%>);  // 获取数据库站点坐标点
				
				points.push(point);
				images.push(image);
                var myIcon = new BMap.Icon(image, new BMap.Size(39,32), {      
                    anchor: new BMap.Size(10,30) 
                
                    });  
                var marker = new BMap.Marker(point,{icon:myIcon});    
                markers.push(marker);
                map.addOverlay(marker);  
                if(image =="http://www.google.cn/intl/en_us/mapfiles/ms/micons/purple-dot.png")
                    {
                      marker.setAnimation(BMAP_ANIMATION_BOUNCE); //弹跳动画
                     }

				}
				else
				{
				var point = new BMap.Point(<%=sewage.get(i).getCoordinateY()%>, <%=sewage.get(i).getCoordinateX()%>);  // 获取数据库站点坐标点
				points.push(point);
				images.push(image);
                var myIcon = new BMap.Icon(image, new BMap.Size(39,32), {      
                anchor: new BMap.Size(10,30) 
                });  
                var marker = new BMap.Marker(point,{icon:myIcon});    
                markers.push(marker);
                map.addOverlay(marker);  
                     
                   
      
	
	                var opts = {
                    width : 250, // 信息窗口宽度
                    height: 400, // 信息窗口高度
                     }
                            
               }
               
               
                    	marker.addEventListener("click",function(){
                     	
                     	var url = "${pageContext.request.contextPath}/ajaxServlet?id=<%=sewage.get(i).getSewageId()%>&p=<%=i%>";
      
                        
                        jQuery.get(url,null,function(data){
                        var st = data.split('#');
                        var infoWindow = new BMap.InfoWindow(st[0], opts);
                       
                      	markers[st[1]].openInfoWindow(infoWindow);
                        });
                       
                    });
                    if(image =="http://www.google.cn/intl/en_us/mapfiles/ms/micons/purple-dot.png")
                    {
                    	var url = "${pageContext.request.contextPath}/ajaxServlet?id=<%=sewage.get(i).getSewageId()%>&p=<%=i%>";
      
                        
                        jQuery.get(url,null,function(data){
                        var st = data.split('#');
                        var infoWindow = new BMap.InfoWindow(st[0], opts);
                       
                      	markers[st[1]].openInfoWindow(infoWindow);
                        });
                    }
                    
			
			<%
				}
			%>

		}
	
		</script>
</html>