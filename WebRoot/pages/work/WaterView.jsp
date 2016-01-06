<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="/birt.tld" prefix="birt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
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
								<c:import url="/menu.jsp"/>
							</f:subview>
						</h:form>
						<f:subview id="content">											
						<rich:panel style="width:770px;height:600px">												
								<birt:parameterPage
								    id="parameterPage"
								    name="form1"
								    isCustom="true"
								    pattern="frameset"
								    reportDesign="reports/WaterView.rptdesign"
								    target="myiframe"
								    width="770"
								    height="50"
								    format="html"
								    showNavigationBar="true"
								    showTitle="false"
								    forceOverwriteDocument="true">
									<table id="canshu" align="center">
										<tr >
											<td align="center">
												<birt:paramDef id="time" name="time"/><h:outputText value="时间"/>
											</td>
											
											
												<td align="center">
												<h:outputText value="请选择区县"/><birt:paramDef id="area" name="area"/>
											</td>	
												
												
											</td>
												<td align="center">
												<h:outputText value="请选择站点"/><birt:paramDef id="sewagename" name="sewagename"/>
											</td>
										
										
											<td align="center">
												<input type="submit" value="查询">
											</td>
										</tr>
									</table>
								</birt:parameterPage>
								 <iframe name="myiframe" width="770" height="520" ></iframe>
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