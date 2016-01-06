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
		<title><h:outputText value="������ˮվ��"></h:outputText>
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
																		<h:outputText value="������ˮվ��" styleClass="panel-title" />
																	</td>
																</tr>
															</table>
														</h:panelGroup>
													</f:facet>
													<table width="97%" style="table-layout:fixed;">
														<!-- �������� -->
														<tr>
															<td width=90>
																<h:outputText value="����������"></h:outputText>
															</td>
															<td width=300>
																<h:selectOneMenu value="#{sewageBean.areaSelectIndex}"
																	style="width: 150px">
																	<f:selectItems value="#{sewageBean.areaItem}" />
																	<a4j:support event="onchange"
																		action="#{sewageBean.valuechange_area}"
																		reRender="manager"></a4j:support>
																</h:selectOneMenu>
																<font color="red">*</font>
															</td>
														</tr>
														<!-- ����Ա -->
														<tr>
															<td>
																<h:outputText value="����Ա��"></h:outputText>
															</td>
															<td>
																<h:selectOneMenu
																	value="#{sewageBean.managerSelectIndex}" id="manager"
																	style="width: 150px">
																	<f:selectItems value="#{sewageBean.managerItem}" />
																	<a4j:support event="onchange"
																		action="#{sewageBean.valuechange_manager}"
																		reRender="showmanager"></a4j:support>
																</h:selectOneMenu>
																<font color="red">*</font>
															</td>
														</tr>
														<!-- ���Ʒ�ʽ -->
														
														<tr>
															<td>
																<h:outputText value="���Ʒ�ʽ��"></h:outputText>
															</td>
															<td>
																<h:selectOneMenu
																	value="#{sewageBean.controlMethod}" id="controlMethod"
																	style="width: 150px">
																	<f:selectItems value="#{sewageBean.methodItem}" />
																	
																</h:selectOneMenu>
																<font color="red">*</font>
															</td>
														</tr>
														<!-- ����ϵͳID -->
														<tr>
															<td>
																<h:outputText value="����ϵͳID��"></h:outputText>
															</td>
															<td>
																<h:inputText id="controlId"
																	value="#{sewageBean.controlId}">
																</h:inputText>
																<font color="red">*</font>
															</td>
														</tr>
														<!-- ��� -->
														<tr>
															<td>
																<h:outputText value="��ƣ�"></h:outputText>
															</td>
															<td>
																<h:inputText id="shorttitle"
																	value="#{sewageBean.shortTitle}">
																	<f:validateLength minimum="1"></f:validateLength>
																</h:inputText>
																<font color="red">*</font>
															</td>
														</tr>
														<!-- ����-->
														<tr>
															<td>
																<h:outputText value="���ƣ�"></h:outputText>
															</td>
															<td>
																<h:inputText id="name" value="#{sewageBean.name}">
																</h:inputText>
																<font color="red">*</font>
															</td>
															
														</tr>
														<!-- ��Ӫ���-->
														<tr>
															<td>
																<h:outputText value="��Ӫ��ţ�"></h:outputText>
															</td>
															<td>
																<h:inputText id="operactionnum" value="#{sewageBean.operationnum}">
																</h:inputText>
																
															</td>
														</tr>
														<!-- ��ַ-->
														<tr>
															<td>
																<h:outputText value="��ַ��"></h:outputText>
															</td>
															<td>
																<h:inputText id="address" value="#{sewageBean.address}">
																</h:inputText>
																
															</td>
														</tr>
														<!-- X����-->
														<tr>
															<td>
																<h:outputText value="#{msgs.longitude}��"></h:outputText>
															</td>
															<td>
																<h:inputText id="x" value="#{sewageBean.coordinateX}">
																</h:inputText>
															</td>
														</tr>
														<!-- Y����-->
														<tr>
															<td>
																<h:outputText value="#{msgs.latitude}��"></h:outputText>
															</td>
															<td>
																<h:inputText id="y" value="#{sewageBean.coordinateY}">
																</h:inputText>
															</td>
														</tr>
														<!-- ���һֵ-->
														<tr>
															<td>
																<h:outputText value="#{msgs.detection1dl}��"></h:outputText>
															</td>															
															<td>
																<h:inputText id="detection1dl" value="#{sewageBean.detection1dl}">
																</h:inputText>
															</td>															
															<td>
																<h:outputText value="#{msgs.detection1ul}��"></h:outputText>
															</td>															
															<td>
																<h:inputText id="detection1ul" value="#{sewageBean.detection1ul}">
																</h:inputText>
															</td>																															
														</tr>
														<!-- ����ֵ-->
														<tr>
															<td>
																<h:outputText value="#{msgs.detection2dl}��"></h:outputText>
															</td>															
															<td>
																<h:inputText id="detection2dl" value="#{sewageBean.detection2dl}">
																</h:inputText>
															</td>															
															<td>
																<h:outputText value="#{msgs.detection2ul}��"></h:outputText>
															</td>															
															<td>
																<h:inputText id="detection2ul" value="#{sewageBean.detection2ul}">
																</h:inputText>
															</td>																															
														</tr>
														<!-- �����ֵ-->
														<tr>
															<td>
																<h:outputText value="#{msgs.detection3dl}��"></h:outputText>
															</td>															
															<td>
																<h:inputText id="detection3dl" value="#{sewageBean.detection3dl}">
																</h:inputText>
															</td>														
															<td>
																<h:outputText value="#{msgs.detection3ul}��"></h:outputText>
															</td>															
															<td>
																<h:inputText id="detection3ul" value="#{sewageBean.detection3ul}">
																</h:inputText>
															</td>																															
														</tr>
														<!-- �����ֵ-->
														<tr>
															<td>
																<h:outputText value="#{msgs.detection4dl}��"></h:outputText>
															</td>															
															<td>
																<h:inputText id="detection4dl" value="#{sewageBean.detection4dl}">
																</h:inputText>
															</td>															
															<td>
																<h:outputText value="#{msgs.detection4ul}��"></h:outputText>
															</td>															
															<td>
																<h:inputText id="detection4ul" value="#{sewageBean.detection4ul}">
																</h:inputText>
															</td>																															
														</tr>
														<!-- �����ֵ-->
														<tr>
															<td>
																<h:outputText value="#{msgs.detection5dl}��"></h:outputText>
															</td>															
															<td>
																<h:inputText id="detection5dl" value="#{sewageBean.detection5dl}">
																</h:inputText>
															</td>															
															<td>
																<h:outputText value="#{msgs.detection5ul}��"></h:outputText>
															</td>															
															<td>
																<h:inputText id="detection5ul" value="#{sewageBean.detection5ul}">
																</h:inputText>
															</td>																															
														</tr>	
														<tr>
															<td>
																<h:outputText value="������������"></h:outputText>
															</td>															
															<td>
																<h:inputText id="waterflow" value="#{sewageBean.waterflow}">
																</h:inputText>
															</td>															
															<td>
																<h:outputText value="������CODֵ��"></h:outputText>
															</td>															
															<td>
																<h:inputText id="reduceCOD" value="#{sewageBean.reduceCOD}">
																</h:inputText>
															</td>																															
														</tr>	
														<tr>
															<td>
																<h:outputText value="������NH3-Nֵ��"></h:outputText>
															</td>															
															<td>
																<h:inputText id="reduceNH3N" value="#{sewageBean.reduceNH3N}">
																</h:inputText>
															</td>															
															<td>
																<h:outputText value="������Pֵ��"></h:outputText>
															</td>															
															<td>
																<h:inputText id="reduceP" value="#{sewageBean.reduceP}">
																</h:inputText>
															</td>																															
														</tr>																																																																																																																																							
														<h:messages styleClass="error-msg" globalOnly="true" />
													</table>
													<br/>
													<div align="left">
														<h:commandButton value="#{msgs.submit}"
															action="#{sewageBean.sewageAddSuccessAction}" 
															style="height: 25px; width: 40px" />
														<input type="button" value="����"
															style="height: 25px; width: 40px"
															onClick="window:location.href='sewagemanager.faces'">															
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