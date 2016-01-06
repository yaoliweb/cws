<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=utf-8"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/css/water.css">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/> 
        <f:loadBundle basename="cn.zj.sunda.water.bundle.Messages_zh_CN" var="msgs"/>
	</head>
	<f:view>
	<title><h:outputText value="#{msgs.contact}"></h:outputText></title>
		<body>
			<center>
				<h:form>
				<table id="table1">
				<tr>
				<c:import url="/top.jsp"></c:import>
				</tr>
				
				<tr>
				<h:panelGrid columns="2">
				<f:subview id="menu"><c:import url="/menu.jsp"></c:import></f:subview>
				<f:subview id="content">
				<table id="table2">
					<tr>
						<td>
							<rich:panel style="width:800px;height:600px;">
								<f:facet name="header">
									<h:panelGroup>
										<table>
											<tr>
												<td>
													<h:outputText value="#{msgs.contact}" styleClass="panel-title"></h:outputText>
												</td>
											</tr>
										</table>
									</h:panelGroup>
								</f:facet>

								<table>
									<tr>
										<td style="Text-Align: left" valign="middle">
											<h3>
												<h:outputText value="#{msgs.address1}"></h:outputText><br/>
												<h:outputText value="#{msgs.address2}"></h:outputText><br/>
												<h:outputText value="#{msgs.address3}"></h:outputText><br/>
												<h:outputText value="#{msgs.address4}"></h:outputText><br/>
												<h:outputText value="#{msgs.address5}"></h:outputText><br/>
											</h3>
										</td>
									</tr>
								</table>
							</rich:panel>
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