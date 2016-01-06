<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="/birt.tld" prefix="birt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<f:loadBundle basename="cn.zj.sunda.water.bundle.Messages_zh_CN" var="msgs"/>
	<link rel="stylesheet" type="text/css" href="/css/water.css">
	<script language="javascript" type="text/javascript" 
		src="../../js/My97DatePicker/WdatePicker.js">
	</script>
</head>
 
<f:view>
	<body>
		<center>
			<table>
				<tr>
					<c:import url="/top.jsp"/>
				</tr>
				<tr>
					<h:panelGrid columns="2">
						<h:form> 
							<f:subview id="menu">
								<c:import url="/menu1.jsp"/>
							</f:subview>
						</h:form>
						<f:subview id="content">											
						<rich:panel style="width:770px;height:1205px">												
							<birt:viewer  id="1" 
					             pattern="frameset"     
					             reportDesign="reports/sewageyears.rptdesign" 
					             position="relative" 
					             width="790" 
					             height="1205"  
					             format="html" 
					             showTitle="false"					             
					             svg="false" frameborder="0"> 
							</birt:viewer> 							
							</rich:panel>
						</f:subview>
					</h:panelGrid>
				</tr>
				<tr>
					<c:import url="/foot.jsp"></c:import>
				</tr>				
			</table>
		</center>
	</body>	
</f:view>

</html>