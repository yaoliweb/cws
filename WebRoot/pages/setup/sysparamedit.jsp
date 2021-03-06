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
		<title><h:outputText value="编辑系统参数"></h:outputText>
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
																		<h:outputText value="编辑系统参数" styleClass="panel-title" />
																	</td>
																</tr>
															</table>
														</h:panelGroup>
													</f:facet>


													<table>
														<!-- 名称 -->
														<tr>
															<td>
																<h:outputText value="名称："></h:outputText>
															</td>
															<td>
																<h:inputText id="name" value="#{sysparamBean.name}">
																	<f:validateLength minimum="1"></f:validateLength>
																</h:inputText>
																<font color="red">*</font>
															</td>
														</tr>
														<!-- 中文名称 -->
														<tr>
															<td>
																<h:outputText value="中文名称："></h:outputText>
															</td>
															<td>
																<h:inputText id="cname" value="#{sysparamBean.cname}">
																	<f:validateLength minimum="1"></f:validateLength>
																</h:inputText>
																<font color="red">*</font>
															</td>
														</tr>
														<!-- 值 -->
														<tr>
															<td>
																<h:outputText value="值："></h:outputText>
															</td>
															<td>
																<h:inputText id="value" value="#{sysparamBean.value}">
																	<f:validateLength minimum="1"></f:validateLength>
																</h:inputText>
																<font color="red">*</font>
															</td>
														</tr>
														<!-- 简介 -->
														<tr>
															<td>
																<h:outputText value="简介："></h:outputText>
															</td>
															<td>
																<h:inputTextarea id="info" value="#{sysparamBean.note}"
																	style="width:600px;height:400px">
																</h:inputTextarea>
															</td>
														</tr>
														<h:messages styleClass="error-msg" globalOnly="true" />
													</table>
													<div align="left">
														<h:commandButton value="#{msgs.submit}"
															action="#{sysparamBean.sysparamEditSuccessAction}"
															style="height: 25px; width: 40px" />
														<input type="button" value="返回"
															style="height: 25px; width: 40px"
															onClick="window:location.href='sysparammanager.faces'">
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