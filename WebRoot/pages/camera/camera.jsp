<%@ page language="java"  contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="/css/water.css">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	        <f:loadBundle basename="cn.zj.sunda.water.bundle.Messages_zh_CN" var="msgs"/>
			<script>
			function login()
			{
				var Netocx = document.getElementById("NetOCX");
				Netocx.Login("172.18.129.254",8000,"admin","12345");
				Netocx.StartRealPlay(0 ,0, 0); 
			}

			</script>
	</head>
<f:view>
	<title>
		<h:outputText value="在线监控"/>
	</title>
	<body onload="login()">
		<center>
		<h:form>
		<table id="table1">
			<tr>
				<c:import url="/top.jsp"></c:import>
			</tr>
			<tr>
				<h:panelGrid columns="2">
					<f:subview id="menu"><c:import url="/menu.jsp"></c:import></f:subview>
					<f:subview id="content3">
					<table id="table2">
						<tr>
							<td>
								<div
								style="overfolw: auto; width: 800px; height: 600px; OVERFLOW-y: auto; OVERFLOW-x: auto">
									<object standby="Waiting..." id="NetOCX"
									classid="clsid:7B43048F-DA7A-458F-AF35-D825BDBB6816" width="800"   type="audio/x-pn-realaudio-plugin"
									height="600" name="ocx"  >
									</object>
									<script language="javascript">								
									var OCXobj = document.getElementById("NetOCX");									 
									OCXobj.SetServerIP("172.18.129.254");									
									if (screen.width<=800) 
									{
									 table.width=1004;									    
									table.height=600;									    
									NetOCX.width=1004;										
									NetOCX.height=600;
									} 									
									else
									{									   
									 table.width=screen.width - 22;									
										table.height=screen.height - 166;									  
									  NetOCX.width=screen.width - 22;										
									NetOCX.height=screen.height - 166;
									}</script>
									
								</div>
							</td>
						</tr>
					</table>
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
