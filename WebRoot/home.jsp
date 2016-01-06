<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>   
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head> 
		<link rel="stylesheet" type="text/css" href="/css/water.css">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<f:loadBundle basename="cn.zj.sunda.water.bundle.Messages_zh_CN"
			var="msgs" />	
	</head>
	<f:view>
		<title><h:outputText value="#{msgs.home}"></h:outputText>
		</title>
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
									<c:import url="/pages/show/gmap.jsp"></c:import>
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