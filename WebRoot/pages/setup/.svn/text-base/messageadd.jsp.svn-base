<%@ page language="java" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<f:loadBundle basename="cn.zj.sunda.water.bundle.Messages_zh_CN"
			var="msgs" />
		<link rel="stylesheet" type="text/css" href="/css/water.css">
	</head>
	<f:view>
		<title><h:outputText value="#{msgs.sendmessage}"></h:outputText>
		</title>
		<body>
			<center>
				<h:form id="form1">
					<table id="table1">
						<tr>
							<c:import url="/top.jsp" />
						</tr>

						<tr>
							<h:panelGrid columns="2">
								<f:subview id="menu">
									<c:import url="/menu.jsp" />
								</f:subview>
								<f:subview id="content">
									<table id="table2">
										<tr>
											<td>
												<rich:panel style="width:800px;height:600px;">
													<f:facet name="header">
														<h:panelGroup>
															<table>
																<tr>
																	<td width="800px">
																		<h:outputText value="#{msgs.sendmessage}" styleClass="panel-title"/>
																	</td>
																</tr>
															</table>
														</h:panelGroup>
													</f:facet>
													<table>
														<!-- 所属地区 -->
														<tr height="28">
															<td>
																<h:outputText value="#{msgs.areaname}:"></h:outputText>
															</td>
															<td>
																<h:selectOneMenu value="#{messageBean.areaSelectIndex}"
																	style="width: 150px">
																	<f:selectItems value="#{messageBean.areaItem}" />
																	<a4j:support event="onchange"
																		action="#{messageBean.valuechange_area}"
																		reRender="manager" />
																</h:selectOneMenu>
															</td>
														</tr>
														<!-- 管理员 -->
														<tr height="28">
															<td>
																<h:outputText value="#{msgs.managertel}:"></h:outputText>
															</td>
															<td>
																<h:selectOneMenu
																	value="#{messageBean.managerSelectIndex}" id="manager"
																	style="width: 150px">
																	<f:selectItems value="#{messageBean.managerItem}" />
																	<a4j:support event="onchange"
																		action="#{messageBean.valuechange_manager}" />
																</h:selectOneMenu>
															</td>
														</tr>
														<!-- 短信内容 -->
														<tr height="28">
															<td>
																<h:outputText value="#{msgs.messagedetail}:"></h:outputText>
															</td>
															<td>
																<h:inputTextarea style="width:500px;height:200px"
																	value="#{messageBean.messagedetail}">
																</h:inputTextarea>
															</td>
														</tr>
														<h:messages styleClass="error-msg" globalOnly="true" />
													</table>
													<br/>
													<div align="left">
														<h:commandButton value="#{msgs.save}"
															action="#{messageBean.saveMessage}" 
															style="height: 25px; width: 40px"/>
														<input type="button" value="返回"
															style="height: 25px; width: 40px"
															onClick="window:location.href='<%=request.getContextPath()%>/home.faces'">															
													</div>
												</rich:panel>
											</td>
										</tr>
									</table>
								</f:subview>
							</h:panelGrid>
						</tr>
						<tr>
							<c:import url="/foot.jsp" />
						</tr>
					</table>
				</h:form>
			</center>
		</body>
	</f:view>
</html>