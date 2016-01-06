<%@ page language="java" contentType="text/html;charset=gb2312" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
       String str = new String(request.getParameter("sewagetitle").getBytes("ISO8859_1")); 
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/css/water.css">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<f:loadBundle basename="cn.zj.sunda.water.bundle.Messages_zh_CN"
			var="msgs" />
		<style type="text/css">
/* 页面字体样式 */
body,td,input,textarea {
	
}

/* 表格基本样式 */
table.default {
	border-collapse: collapse;
	border: 1px solid black;
	width: 150px;
	
	position: relative;
	left: 350px;
	top: -70px;
}
table.showtime {
	border-collapse: collapse;
	border: 1px solid black;
	width: 220px;
	
	position: relative;
	left: 530px;
	top: -160px;
}
table.showtitle {
	border: 0px;
	width: 220px;
	position: relative;
	left: 120px;
	top: -260px;	
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
var refreshTime = 1000 * 2; //自动刷新时间间隔，目前为2秒
var isRefreshing = false; //是否处于自动刷新过程中

//用于创建XMLHttpRequest对象
function createXmlHttp() {
	//根据window.XMLHttpRequest对象是否存在使用不同的创建方式
	if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest(); //FireFox、Opera等浏览器支持的创建方式
	} else {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");//IE浏览器支持的创建方式
	}
}

//获取最新价格
function getNewPrice() {
	//如果已在刷新过程中，直接返回，取消操作
	if (isRefreshing) {
		return;
	}
	isRefreshing = true; //设置刷新状态为true
	displayLoading(); //显示“正在加载……”
	createXmlHttp(); //创建XMLHttpRequest对象
	xmlHttp.onreadystatechange = writePrice; //设置回调函数
	xmlHttp.open("GET", "stock.jsp?" + new Date().getTime(), true); //发送GET请求
	xmlHttp.send(null);
}

//将最新价格写入页面
function writePrice() {
    if (xmlHttp.readyState == 4) {
        isRefreshing = false;                       //获取成功，设置刷新状态为false
        hiddenLoading();                            //隐藏“正在加载……”提示

        //将获得的价格遍历写入页面
        var result = eval("(" + xmlHttp.responseText + ")");
        for (var o in result) {
            document.getElementById(o).innerHTML = result[o];
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

//初始化获取最新价格，并设置定时获取函数调用
function init() {
    getNewPrice();
    setInterval("getNewPrice()", refreshTime);
}
</script>
	</head>
	<f:view>
		<title><h:outputText value="站点详情"></h:outputText></title>
		<body onload="init()">
			<center>
				<h:form>
					<table id="table1">
						<tr>
							<c:import url="/top.jsp"></c:import>
						</tr>
						<tr>
							<h:panelGrid columns="2">
								<f:subview id="menu">
									<c:import url="/menu.jsp"></c:import>
								</f:subview>


								<f:subview id="functioncontentpage">

									<rich:panel style="width:800px;height:600px;" id="showcontent">
										<f:facet name="header">
											<h:panelGroup>
												<table>
													<tr>
														<td>
															<h:outputText value="站点详情" styleClass="panel-title"></h:outputText>
														</td>
													</tr>
												</table>
											</h:panelGroup>
										</f:facet>
										
											<table 
											background="<%=basePath%>images/map.jpg">
											<tr height="535px">
												<td width="770px">

													<table class="default">

														<tr >
															<td style="color:#000000;background-color:#00ccff">
																LS
															</td>
															<td id="priceA" style="font-family:Arial;font-size:12px;color:#ffffff;background-color:#000000"></td>
															<td style="color:#000000;background-color:#00ccff">
																m
															</td>
														</tr>
														<tr>
															<td style="color:#000000;background-color:#00ccff">
																PH
															</td>
															<td id="priceB" style="font-family:Arial;font-size:12px;color:#ffffff;background-color:#000000"></td>
															<td style="color:#000000;background-color:#00ccff">
																pH
															</td>
														</tr>
														<tr>
															<td style="color:#000000;background-color:#00ccff">
																ORP
															</td >
															<td id="priceC" style="font-family:Arial;font-size:12px;color:#ffffff;background-color:#000000"></td>
															<td style="color:#000000;background-color:#00ccff">
																mV
															</td>
														</tr>
														<tr>
															<td style="color:#000000;background-color:#00ccff">
																T
															</td>
															<td id="priceD" style="font-family:Arial;font-size:12px;color:#ffffff;background-color:#000000"></td>
															<td style="color:#000000;background-color:#00ccff">
																℃
															</td>
														</tr>
														<tr>
															<td style="color:#000000;background-color:#00ccff">
																DO
															</td>
															<td id="priceE" style="font-family:Arial;font-size:12px;color:#ffffff;background-color:#000000"></td>
															<td style="color:#000000;background-color:#00ccff">
																mg/L
															</td>
														</tr>
														
													</table>
													<table class="showtitle">
													<tr >
														<td style="font-size:48px;font-weight:bold;">
														<%=str %>
														</td>
														</tr>
													</table>
													<table class="showtime">
													<tr >
														<td colspan="3">
														最后更新时间：
														<span id="lastUpdateTime"></span>
														</td>
														</tr>
													</table>
													<div id="loading"></div>

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