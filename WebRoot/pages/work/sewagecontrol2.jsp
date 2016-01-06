<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ page import= "java.util.List"%> 
<%@ page import= "cn.zj.sunda.water.bo.Sewage"%> 
<%@ page import= "cn.zj.sunda.water.servicelocator.ServiceLocator" %>
<%@ page import= "cn.zj.sunda.water.bean.ServiceLocatorBean"%>
<%
	String path = request.getContextPath();                //返回项目的名字，如果目录项目为根目录，则返回空字符串 
	String basePath = request.getScheme() + "://"          //getScheme()返回的是协议的名称，默认的是http
			+ request.getServerName() + ":" + request.getServerPort()    //分别是返回服务器名称和服务器端口号
			+ path + "/";  
	String str = "";
	if (request.getParameter("sewagetitle") != null) {       //获取gmap.jsp页面跳转传过来的参数
		str = new String(request.getParameter("sewagetitle").getBytes(
				"ISO8859_1"));
                                      //getBytes("ISO8859_1")将一个字符串转化为一个字节数组
	} else {
		str = "|";
	}
	session.setAttribute("str", str); //setAttribute和getAttribute方法传递的参数只会存在于web容器内部，
	                                  //在具有转发关系的Web组件之间共享,仅仅是请求处理阶段
	                                  //getAttribute返回的是对象，getParameter返回的是字符串 
	                                 

	String sewageid = request.getParameter("sewageid");//gmap.jsp页面跳转传递过来的参数
	session.setAttribute("sewageid",sewageid); 
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<f:loadBundle basename="cn.zj.sunda.water.bundle.Messages_zh_CN" var="msgs" />
		<link rel="stylesheet" type="text/css" href="/css/water.css">
		<link rel="stylesheet" type="text/css" href="../../ext3/resources/css/ext-all.css"></link>  
			
		<style type="text/css">
		/* 表格基本样式 */
		table.default {
			border-collapse: collapse;
			border: 1px solid black;
			width: 150px;
			
			position: relative;
			left: 350px;
			top: -45px;
		}
		table.showtime {
			border-collapse: collapse;
			border: 1px solid black;
			width: 220px;
			
			position: relative;
			left: 530px;
			top: -190px;
		}
		table.showtitle {
			border: 0px;
			width: 220px;
			position: relative;
			left: 80px;
			top: -210px;	
			color=#009900;	
		}
		
		/* 表格单元格样式 */
		table.default td {
			border: 1px solid black;
			padding: 3px;
		}
		
		/* 列头样式 */
		table.default td.item {
			background: #006699;
			color: #fff;
			text-align: center;
			height: 25px;
		}
		</style>

		<script type="text/javascript">
		var xmlHttp; //用于保存XMLHttpRequest对象的全局变量
		var refreshTime = 1000; //自动刷新时间间隔，目前为5秒
		var isRefreshing = false; //是否处于自动刷新过程中
		
		//XMLHttpRequest对象用于在后台与服务器交换数据。能够在不重新加载页面的情况下更新网页,在页面已加载后从服务器请求数据 
		//在页面已加载后从服务器接收数据 ,在后台向服务器发送数据
		
		function createXmlHttp() {
			//根据window.XMLHttpRequest对象是否存在使用不同的创建方式
			if (window.XMLHttpRequest) {
				xmlHttp = new XMLHttpRequest(); //FireFox、Opera等浏览器支持的创建方式
			} else {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");//IE浏览器支持的创建方式
			}
		}
		
		//获取最新数据
		function getNewData() {
			//如果已在刷新过程中，直接返回，取消操作
			if (isRefreshing) {
				return;
			}
			isRefreshing = true; //设置刷新状态为true
			displayLoading(); //显示“正在加载……”
			createXmlHttp(); //创建XMLHttpRequest对象
			xmlHttp.onreadystatechange = writeData; //设置回调函数
			xmlHttp.open("GET", "selectdata.jsp?" + new Date().getTime() , true); //初始化 HTTP请求参数,发送GET请求;true表示脚本会在 send()方法之后继续执行，而不等待来自服务器的响应
			xmlHttp.send(null);
		}
		
		//将最新数据写入页面
		function writeData() {
		    if (xmlHttp.readyState == 4) {
		        isRefreshing = false;                       //获取成功，设置刷新状态为false
		        hiddenLoading();                            //隐藏"正在加载……"提示
		       display();
		        //将获得的数据遍历写入页面
		        var result = eval("(" + xmlHttp.responseText + ")");//responseText,用于接收服务端的响应的文本信息
		       			                            //eval()函数可将字符串转换为代码执行，并返回一个或多个值
		        for (var o in result) {
		            document.getElementById(o).innerHTML = result[o];
		         
		            document.getElementById("water").innerHTML=result.water;
		            document.getElementById("cod").innerHTML=result.cod;
		            document.getElementById("nh3n").innerHTML=result.nh3n;
		            document.getElementById("p").innerHTML=result.p;
		            document.getElementById("StationState").innerHTML=result.StationState;
		            document.getElementById("lastUpdateTime").innerHTML=result.lastUpdateTime;
		            document.getElementById("state").innerHTML=result.state;
		       document.getElementById("sewagename").innerHTML=result.sewagename;
		            
		           
		        }
		        
		    }
		}
		
		//显示提示信息
		function displayLoading() {
		    document.getElementById("loading").style.visibility = "visible";
		}
		
		//隐藏提示信息
		function hiddenLoading() {
		    document.getElementById("loading").style.visibility = "hidden";
		}
		function display()
		{
		
		if(document.getElementById("large:functioncontentpage:name1").innerHTML!="风机")
		{document.getElementById("name4").style.display='none';
		document.getElementById("name42").style.display='none';
		document.getElementById("name43").style.display='none';
		document.getElementById("name444").style.display='none';
         }    
            
             
             
		
		}
		//初始化获取最新数据，并设置定时获取函数调用
		function init() {
		    getNewData();
		    display();
		    setInterval("getNewData()", refreshTime);//setInterval()方法可按照指定的周期(以毫秒计)来调用函数或计算表达式
		}
		</script>

		<script type="text/javascript" src="../../ext3/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="../../ext3/ext-all.js"></script> 
		<script type="text/javascript" src="chart.js"></script>
	</head>
	<f:view>
		<head>
			<title>
				<h:outputText value="#{msgs.sewagecontrol}"></h:outputText>
			</title>
		</head>	
		<body onload="init()">
			<center>
				<h:form id="large">
					<table id="table1">
						<tr>
							<c:import url="/top.jsp"></c:import>
						</tr>
						<tr>
							<h:panelGrid columns="3">
								<f:subview id="menu">
									<c:import url="/menu1.jsp"></c:import>
								</f:subview>
								<f:subview id="functioncontentpage">
								
								
									<rich:panel style="width:800px;height:450px;" id="showcontent">
										<%
											if ("|".equals(str)) {
																	str = (String)session.getAttribute("sewageSelectName");
																	//System.out.println(str);
																	if ((str == null)||(str.equals("请选择污水站"))) {
																		str = "";
																	}
																}
																session.setAttribute("str", str);
										%>
										<rich:panel style="width:776px;height:30px;" id="equipmentState">
										<f:facet name="header">
											<h:panelGroup>
												<table>
													<tr>
														<td>
															<h:outputText value="#{msgs.sewageselect}"
																styleClass="panel-title"></h:outputText>
														</td>
													</tr>
												</table>
											</h:panelGroup>
										</f:facet>
										<table>
											<tr>
												<td width="25%">
													<table>
														<tr>
															<td>
																<h:selectOneMenu value="#{sewageBean.areaSelectIndex}"
																	style="width: 150px">
																	<f:selectItems value="#{sewageBean.areaItem}" />
																	<a4j:support event="onchange"
																		action="#{sewageBean.valuechange_area}"
																		reRender="sewage"></a4j:support>
																</h:selectOneMenu>
															</td>
													
														
															<td>
																<h:selectOneMenu id="sewage"
																	value="#{sewageBean.sewageSelectIndex}"
																	style="width: 150px" >
																	<f:selectItems value="#{sewageBean.sewageItem}" />
																	<a4j:support event="onchange"
																		action="#{sewageBean.valuechanged_sewage}"
																		reRender="station_state,show_sewage"></a4j:support>
																</h:selectOneMenu>
															</td>
														</tr>
													</table>
												</td>
												<td align="right" style="font-family: Arial; font-size: 16px; color: #000000; " width=260>运行状态：
												</td>
												<td id=StationState align="left"  style="font-family: Arial; font-size: 16px; color: #ff0000; " width=220>未选择站点</td>
											    <td style="color: #009900;font-size: 15px; font-weight: bold;" width=650 align="left">最后更新时间: 
											    <span id="lastUpdateTime"></span>
												</td> 
											</tr>
											<h:messages styleClass="error-msg" globalOnly="true" />	
										</table>
									</rich:panel>
									
										<table id="showname" background="<%=basePath%>images/map.jpg" cellpadding=0 cellspacing=0>
										
										
											<tr height=100px>
												<td  id="sewagename"  style="color: #ff0000;font-size: 30px; font-weight: bold;" width=200 align="right">
												<h:outputText value="#{sewageBean.sewageSelectName}"></h:outputText>
												</td>
												<td style="color: #009900;font-size: 30px; font-weight: bold;" width=300  align="right">微动力污水处理设</td>
												<td style="color: #009900;font-size: 30px; font-weight: bold;" width=300  align="left">施工艺流程图</td>
											</tr>
											
											
											<tr height="170px">
												<td width=200>
												</td>
											    <td  style="color: #ff0000;font-size: 15px; font-weight: bold;" width=300 align="left">
											    	<table style="border: #000000; border-style: solid; border-width: 0px;background-color:#CAE8EA" cellpadding=1 cellspacing=1>
											    		<tr>
															<td style="color: #000000; background-color: #00ccff" height=30 align="center">
																日处理水量
															</td>
															<td id="water"
																style="font-family: Arial; font-size: 12px; color: #000000; background-color: #00ccff"  width=100 height=30 align="center"></td>
															<td style="color: #000000; background-color: #00ccff"  width=30 align="center">
																m3
															</td>
														</tr>
														<tr>
															<td style="dataA #000000; background-color: #00ccff"  height=30 align="center">
																日消减COD量
															</td>
															<td id="cod"
																style="font-family: Arial; font-size: 12px; color: #000000; background-color: #00ccff" align="center"></td>
															<td style="color: #000000; background-color: #00ccff" align="center">
																g
															</td>
														</tr>
														<tr>
															<td style="color: #000000; background-color: #00ccff"  height=30 align="center">
																日消减NH3-N量
															</td>
															<td id="nh3n"
																style="font-family: Arial; font-size: 12px; color: #000000; background-color: #00ccff" align="center"></td>
															<td style="color: #000000; background-color: #00ccff" align="center">
																g
															</td>
														</tr>
														<tr>
															<td style="color: #000000; background-color: #00ccff"  height=30 align="center">
																日消减总P量
															</td>
															<td id="p"
																style="font-family: Arial; font-size: 12px; color: #000000; background-color: #00ccff" align="center"></td>
															<td style="color: #000000; background-color: #00ccff" align="center">
																g
															</td>
														</tr>
											    	</table>
											    
												</td>
												<td width=140 align="left">
													<table style="border: #000000; border-style: solid; border-width: 0px;background-color:#CAE8EA" cellpadding=1 cellspacing=1>
														<tr>
															<td style="color: #000000; background-color: #00ccff" height=25 width=50 align="center">
																 T
															</td>
															<td id="dataA"
																style="font-family: Arial; font-size: 12px; color: #000000; background-color: #00ccff" width=100 align="center"></td>
															<td style="color: #000000; background-color: #00ccff" align="center">
																℃
															</td>
														</tr>													
														<tr>
															<td style="color: #000000; background-color: #00ccff" height=25 width=50 align="center">
																 PH
															</td>
															<td id="dataB"
																style="font-family: Arial; font-size: 12px; color: #000000; background-color: #00ccff" align="center"></td>
															<td style="color: #000000; background-color: #00ccff" align="center">
																pH
															</td>
														</tr>
														<tr>
															<td style="color: #000000; background-color: #00ccff" height=25 width=50 align="center" align="center">
																 ORP
															</td>
															<td id="dataC"
																style="font-family: Arial; font-size: 12px; color: #000000; background-color: #00ccff" align="center"></td>
															<td style="color: #000000; background-color: #00ccff" align="center">
																mV
															</td>
														</tr>
														<tr>
															<td style="color: #000000; background-color: #00ccff" height=25 width=50 align="center">
																 LS
															</td>
															<td id="dataD"
																style="font-family: Arial; font-size: 12px; color: #000000; background-color: #00ccff" align="center"></td>
															<td style="color: #000000; background-color: #00ccff" align="center">
																LS
															</td>
														</tr>
														<tr>
															<td style="color: #000000; background-color: #00ccff" height=25 width=50 align="center">
																 DO
															</td>
															<td id="dataE"
																style="font-family: Arial; font-size: 12px; color: #000000; background-color: #00ccff" align="center"></td>
															<td style="color: #000000; background-color: #00ccff" align="center">
																mg/L
															</td>
														</tr>
														<tr id="name444">
															<td style="color: #000000; background-color: #00ccff" height=25 width=50 align="center">
																 吸膜泵
															</td>
															<td id="stdetection7"
																style="font-family: Arial; font-size: 12px; color: #000000; background-color: #00ccff" align="center"></td>
															<td style="color: #000000; background-color: #00ccff" align="center">
																state
															</td>
														</tr>
													</table>
													
												
												</td>
											</tr>
											
											
											<tr height=130px>
												<td style="color: #009900;font-size: 34px; font-weight: bold;" width=200 align="right">
												</td>
												<td  width="160px">
												</td>
												<td  width="140px">
												</td>
											</tr>
										</table>
										<div id="loading"></div>
									</rich:panel>
									
									<rich:panel  style="width:800px;height:65px;" id="geshan">
										<table style="border: #000000; border-style: solid; border-width: 0px;background-color:#CAE8EA" cellpadding=0 cellspacing=0
										align="left">
											<tr height=27>
												<td align="center" style="border-bottom:1px solid gray;" width=193 height=25>
													<h:outputText value="#{msgs.geshan}" />
												</td>
												<td align="center" style="border-bottom:1px solid gray;border-right:1px solid gray;border-left:1px solid gray;" width=193 height=25>
													<h:outputText value="上次确认格栅时间" />
												</td>
												<td align="center" style="border-bottom:1px solid gray;border-right:1px solid gray;" width=193 height=25>
													<h:outputText value="当前状态" />
												</td>
												<td align="center" style="border-bottom:1px solid gray;" width=193 height=25>
													<h:outputText value="格栅间隔天数" />
											</tr>
											<tr height=27>
												<td align="center"  width=193>
												<h:commandButton value="解除警报" action="#{sewageBean.confirmGrating}"></h:commandButton>
												</td>
												<td id="confirmGratingTime" align="center" style="border-right:1px solid gray;border-left:1px solid gray;" width=193>未选择
												</td>
												<td  id="state" align="center" style="color: #FF0000;border-right:1px solid gray;" width=193>未选择
												</td>
												<td  id="gratingDays" align="center"  width=193>未选择
												</td>
											</tr>
										</table>
									</rich:panel>
									<rich:panel style="width:800px;height:125px;" id="show_sewage">
										<table style="border: #000000; border-style: solid; border-width: 0px;background-color:#CAE8EA" cellpadding=0 cellspacing=0
										align="left" id="aa">
											<tr height=27>
												<td align="center"  style="border-bottom:1px solid gray;" width=193>设备
												</td>
												<td align="center"  style="border-bottom:1px solid gray;border-left:1px solid gray;" width=193> 设备当前控制方式
												</td>
												<td align="center"  style="border-bottom:1px solid gray;border-left:1px solid gray;" width=193>设备当前状态
												</td>
												<td align="center"  style="border-bottom:1px solid gray;border-left:1px solid gray;" width=193>设备报警操作
												</td>
											</tr>
											<tr height=27>
												<td align="center"  style="border-bottom:1px solid gray;" width=193><h:outputText value="#{sewageBean.name1}" id="name1"></h:outputText>
												</td>
												<td id=airCtlMethod align="center"  style="border-bottom:1px solid gray;border-left:1px solid gray;" width=193>未选择
												</td>
												<td id=airState align="center"  style="color: #FF0000;border-bottom:1px solid gray;border-left:1px solid gray;" width=193>未选择
												</td>
												<td align="center"  style="border-bottom:1px solid gray;border-left:1px solid gray;" width=193>
													<h:commandButton value="解除警报" action="#{sewageBean.releaseAirWarning}"></h:commandButton>
												</td>
											</tr>
											<tr height=27>
												<td align="center"  style="border-bottom:1px solid gray;" width=193><h:outputText value="#{sewageBean.name2}"></h:outputText>
												</td>
												<td id=elevatorCtlMethod align="center"  style="border-bottom:1px solid gray;border-left:1px solid gray;" width=193>未选择
												</td>
												<td id=elevatorState align="center"  style="color: #FF0000;border-bottom:1px solid gray;border-left:1px solid gray;" width=193>未选择
												</td>
												<td align="center"  style="border-bottom:1px solid gray;border-left:1px solid gray;" width=193>
                                                	<h:commandButton value="解除警报" action="#{sewageBean.releaseElevatorWarning}"></h:commandButton>
												</td>
											</tr>
											<tr height=27>
												<td align="center"   width=193><h:outputText value="#{sewageBean.name3}"></h:outputText>
												</td>
												<td id=mudCtlMethod align="center"  style="border-left:1px solid gray;" width=193>未选择
												</td>
												<td id=mudState align="center"  style="color: #FF0000;border-left:1px solid gray;" width=193>未选择
												</td>
												<td align="center"  style="border-left:1px solid gray;" width=193>
													<h:commandButton value="解除警报" action="#{sewageBean.releaseMudWarning}"></h:commandButton>
												</td>
											</tr>
											<tr height=27 id="name43">
												<td align="center"  style="border-bottom:1px solid gray;" width=193><h:outputText value="#{sewageBean.name4}"></h:outputText>
												</td>
												<td id=membraneMethod align="center"  style="border-bottom:1px solid gray;border-left:1px solid gray;" width=193>未选择
												</td>
												<td id=membraneState align="center"  style="color: #FF0000;border-bottom:1px solid gray;border-left:1px solid gray;" width=193>未选择
												</td>
												<td align="center"  style="border-bottom:1px solid gray;border-left:1px solid gray;" width=193>
                                                	<h:commandButton value="解除警报" action="#{sewageBean.releasemembraneWarning}"></h:commandButton>
												</td>
											</tr>
											</table>
									</rich:panel>
									<rich:panel style="width:800px;height:90px;" id="show_value">
										<table style="border: #000000; border-style: solid; border-width: 0px;background-color:#CAE8EA" cellpadding=0 cellspacing=0
										align="left">
											<tr height=30>
												<td align="center"  style="border-bottom:1px solid gray;" width=193>仪表传感器
												</td>
												<td align="center"  style="border-bottom:1px solid gray;border-left:1px solid gray;" width=193>仪表取值范围
												</td>
												<td align="center"  style="border-bottom:1px solid gray;border-left:1px solid gray;" width=193>仪表当前值
												</td>
												<td align="center"  style="border-bottom:1px solid gray;border-left:1px solid gray;" width=193>解除报警操作
												</td>
											</tr>
											<tr height=30>
												<td  align="center"  style="border-bottom:1px solid gray;" width=193>T (℃)
												</td>
												<td  id=T_scale align="center"  style="border-bottom:1px solid gray;border-left:1px solid gray;" width=193>未选择
												</td>
												<td id=T_current_value align="center"  style="color: #FF0000;border-bottom:1px solid gray;border-left:1px solid gray;" width=193>未选择
												</td>
												<td  align="center"  style="border-bottom:1px solid gray;border-left:1px solid gray;" width=193>
                                                	<h:commandButton value="解除警报" action="#{sewageBean.releaseTemWarning}"></h:commandButton>
												</td>
											</tr>
											<tr height=30>
												<td  align="center"  style="border-bottom:1px solid gray;" width=193>PH (pH)
												</td>
												<td  id=PH_scale align="center"  style="border-bottom:1px solid gray;border-left:1px solid gray;" width=193>未选择
												</td>
												<td id=PH_current_value align="center"  style="color: #FF0000;border-bottom:1px solid gray;border-left:1px solid gray;" width=193>未选择
												</td>
												<td  align="center"  style="border-bottom:1px solid gray;border-left:1px solid gray;" width=193>
                                                	<h:commandButton value="解除警报" action="#{sewageBean.releasePHWarning}"></h:commandButton>
												</td>
											</tr>
											<tr height=30>
												<td  align="center"  style="border-bottom:1px solid gray;" width=193>ORP (mV)
												</td>
												<td  id=ORP_scale align="center"  style="border-bottom:1px solid gray;border-left:1px solid gray;" width=193>未选择
												</td>
												<td id=ORP_current_value align="center"  style="color: #FF0000;border-bottom:1px solid gray;border-left:1px solid gray;" width=193>未选择
												</td>
												<td  align="center"  style="border-bottom:1px solid gray;border-left:1px solid gray;" width=193>
                                                	<h:commandButton value="解除警报" action="#{sewageBean.releaseORPWarning}"></h:commandButton>
												</td>
											</tr>
											<tr height=30>
												<td  align="center"  style="border-bottom:1px solid gray;" width=193>LS
												</td>
												<td  id=LS_scale align="center"  style="border-bottom:1px solid gray;border-left:1px solid gray;" width=193>未选择
												</td>
												<td id=LS_current_value align="center"  style="color: #FF0000;border-bottom:1px solid gray;border-left:1px solid gray;" width=193>未选择
												</td>
												<td  align="center"  style="border-bottom:1px solid gray;border-left:1px solid gray;" width=193>
                                                	<h:commandButton value="解除警报" action="#{sewageBean.releaseLSWarning}"></h:commandButton>
												</td>
											</tr>
											<tr height=30>
												<td  align="center" style="border-bottom:1px solid gray;" width=193>DO (mg/L)
												</td>
												<td  id=DO_scale align="center"  style="border-bottom:1px solid gray;border-left:1px solid gray;" width=193>未选择
												</td>
												<td id=DO_current_value align="center"  style="color: #FF0000;border-bottom:1px solid gray;border-left:1px solid gray;" width=193>未选择
												</td>
												<td  align="center"  style="border-bottom:1px solid gray;border-left:1px solid gray;" width=193>
                                                	<h:commandButton value="解除警报" action="#{sewageBean.releaseDOWarning}"></h:commandButton>
												</td>
											</tr>
											<tr height=30>
												<td  align="center"  width=193>流量
												</td>
												<td  id=Flow_scale align="center"  style="border-left:1px solid gray;" width=193>未选择
												</td>
												<td id=Flow_current_value align="center"  style="color: #FF0000;border-left:1px solid gray;" width=193>未选择
												</td>
												<td  align="center"  style="border-left:1px solid gray;" width=193>
                                                	
												</td>
											</tr>
										</table>
									</rich:panel>
									
									<rich:panel style="width:800px;height:299px;" id="container">
										<div>
											<div id="container1" style="width:375px;height:250px;float:left"></div>
											<div id="container2" style="width:375px;height:250px;float:right"></div>
											<div style="width:750px;height:20px;float:left">
												<table width="775px">
													<tr>
														<td width="50%" align="center">
															<h:outputText value="-T  " style="color: #6600FF"/>
															<h:outputText value="-PH  " style="color: #FF3399"/>
															<h:outputText value="-LS  " style="color: #00BB00"/>
															<h:outputText value="-DO" style="color: #FF9966"/>
														</td>
														<td width="50%" align="center">
															<h:outputText value="-ORP" style="color: #00CCFF"/>
														</td>
													</tr>
												</table>
											</div>
										</div>
									</rich:panel>	
									<rich:panel style="width:800px;height:30px;" id="station_state">
										<table style=" border-style: solid; border-width: 0px;" cellpadding=0 cellspacing=0 align="left">
											<tr height=30>	
												<td width="80%">
													<table style="border: #000000; border-style: solid; border-width: 1px" align="left">
														<tr>
															<td align="center" style="border: 1px solid black">
																<h:outputText value="#{sewageBean.name1}" />
															</td>
															<td align="center" style="border: 1px solid black">
																<h:outputText value="#{sewageBean.name2}" />
															</td>
															<td align="center" style="border: 1px solid black">
																<h:outputText value="#{sewageBean.name3}" />
															</td>
																<td align="center" style="border: 1px solid black" id="name4">
																<h:outputText value="#{sewageBean.name4}" />
															</td>
														
															<!--
															<td align="center" style="border: 1px solid black">
																<h:outputText value="#{msgs.back_up}" />
															</td>
															-->
														</tr>
														<tr>
															<td align="center" style="border: 1px solid black" width="116">
																<c:choose>
																	<c:when test="${sewageBean.equipment1state=='3'}">
																		<h:outputText value="#{msgs.eqpfault}" style="color: #FF0000"/>
																	</c:when>
																	<c:when test="${sewageBean.equipment1state=='4'}">
																		<h:outputText value="#{msgs.uninstall}"/>
																	</c:when> 
																	<c:otherwise>
																		<h:selectOneRadio value="#{sewageBean.equipment1state}">
																		    <f:selectItem id="item11" itemValue="1" itemLabel="#{msgs.run}"/>
																		    <f:selectItem id="item12" itemValue="2" itemLabel="#{msgs.stop}"/>
																		</h:selectOneRadio>															
																	</c:otherwise>
																</c:choose>
															</td>
															<td align="center" style="border: 1px solid black" width="116">
																<c:choose>
																	<c:when test="${sewageBean.equipment2state=='3'}">
																		<h:outputText value="#{msgs.eqpfault}" style="color: #FF0000"/>
																	</c:when>
																	<c:when test="${sewageBean.equipment2state=='4'}">
																		<h:outputText value="#{msgs.uninstall}"/>
																	</c:when> 
																	<c:otherwise>
																		<h:selectOneRadio value="#{sewageBean.equipment2state}">
																		    <f:selectItem id="item21" itemValue="1" itemLabel="#{msgs.run}"/>
																		    <f:selectItem id="item22" itemValue="2" itemLabel="#{msgs.stop}"/>
																		</h:selectOneRadio>															
																	</c:otherwise>
																</c:choose>
															</td>
															<td align="center" style="border: 1px solid black" width="116" id="name42">
																<c:choose>
																	<c:when test="${sewageBean.equipment3state=='3'}">
																		<h:outputText value="#{msgs.eqpfault}" style="color: #FF0000"/>
																	</c:when>
																	<c:when test="${sewageBean.equipment3state=='4'}">
																		<h:outputText value="#{msgs.uninstall}"/>
																	</c:when> 
																	<c:otherwise>
																		<h:selectOneRadio value="#{sewageBean.equipment3state}">
																		    <f:selectItem id="item31" itemValue="1" itemLabel="#{msgs.run}"/>
																		    <f:selectItem id="item32" itemValue="2" itemLabel="#{msgs.stop}"/>
																		</h:selectOneRadio>															
																	</c:otherwise>
																</c:choose>
															</td>
															
															<td align="center" style="border: 1px solid black" width="116">
																<c:choose>
																	<c:when test="${sewageBean.equipment4state=='3'}">
																		<h:outputText value="#{msgs.eqpfault}" style="color: #FF0000"/>
																	</c:when>
																	<c:when test="${sewageBean.equipment4state=='4'}">
																		<h:outputText value="#{msgs.uninstall}"/>
																	</c:when> 
																	<c:otherwise>
																		<h:selectOneRadio value="#{sewageBean.equipment4state}">
																		    <f:selectItem id="item41" itemValue="1" itemLabel="#{msgs.run}"/>
																		    <f:selectItem id="item42" itemValue="2" itemLabel="#{msgs.stop}"/>
																		</h:selectOneRadio>															
																	</c:otherwise>
																</c:choose>
															</td>
															
														</tr>
													</table>
												</td>
												<td align="center"> 
													<h:commandButton value="#{msgs.submit}" onclick="a()"
														action="#{sewageBean.updateControlLog}" style="height: 25px; width: 40px">
													</h:commandButton>
												</td>
											</tr>
										</table>
									</rich:panel>				
								</f:subview>
							</h:panelGrid>
						</tr>
						<tr>
							<c:import url="/foot.jsp"></c:import>
						</tr>
					</table>
				</h:form>
			</center>
		</body>
	</f:view>
</html>