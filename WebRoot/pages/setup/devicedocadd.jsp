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
		<script language="javascript" type="text/javascript"
			src="../../js/My97DatePicker/WdatePicker.js">
</script>
	</head>
	<f:view>
		<title><h:outputText value="添加设备"></h:outputText>
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
																		<h:outputText value="添加设备" styleClass="panel-title" />
																	</td>
																</tr>
															</table>
														</h:panelGroup>
													</f:facet>
													<table width="97%" style="table-layout:fixed;">
														<!-- 所属地区 -->
														<tr>
															<td width=80>
																<h:outputText value="所属地区："></h:outputText>
															</td>
															<td width=300>
																<h:selectOneMenu value="#{DeviceBean.newAreaSelectIndex}"
																	style="width: 150px">
																	<f:selectItems value="#{DeviceBean.newAreaItem}" />
																	<a4j:support event="onchange"
																		action="#{DeviceBean.valuechange_area}" reRender="sewage"></a4j:support>
																</h:selectOneMenu>
																<h:selectOneMenu id="sewage"
																	value="#{DeviceBean.newSewageSelectIndex}" style="width: 150px">
																	<f:selectItems value="#{DeviceBean.newSewageItem}" />
																	<a4j:support event="onchange"
																		action="#{DeviceBean.valuechanged_sewage}"></a4j:support>
																</h:selectOneMenu>
															</td>
														</tr>
														<!--编号-->
														<tr>
															<td>
																<h:outputText value="编号："></h:outputText>
															</td>
															<td>
																<h:inputText id="newNumber"
																	value="#{DeviceBean.newNumber}">
																</h:inputText>
																<font color="red">可更改</font>
															</td>
														</tr>
														<!-- 设备名称 -->
														<tr>
															<td>
																<h:outputText value="设备名称："></h:outputText>
															</td>
															<td>
																<h:inputText id="newDeviceName"
																	value="#{DeviceBean.newDeviceName}">
																	<f:validateLength minimum="1"></f:validateLength>
																</h:inputText>
																<font color="red">不可更改</font>
															</td>
														</tr>
														<!-- 设备类型参数-->
														<tr>
															<td>
																<h:outputText value="设备类型参数："></h:outputText>
															</td>
															<td>
																<h:inputText id="newDeviceType" value="#{DeviceBean.newDeviceType}">
																</h:inputText>
																<font color="red">不可更改</font>
															</td>
														</tr>
														<!-- 安装时间-->
														<tr>
															<td>
																<h:outputText value="安装时间："></h:outputText>
															</td>
															<td>
																<h:inputText id="newSetupTime" value="#{DeviceBean.newSetupTime}"
																onfocus="new WdatePicker({startDate:'%y-%M-01 00:00:00',
																	dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})">
																<f:convertDateTime pattern="yyyy-MM-dd HH:mm:ss" />
																</h:inputText>
																<font color="red">不可更改</font>
															</td>
														</tr>
														<!-- 上次保养时间-->
														<tr>
															<td>
																<h:outputText value="上次保养时间："></h:outputText>
															</td>
															<td>
																<h:inputText id="newLastRepairTime" value="#{DeviceBean.newLastRepairTime}"
																onfocus="new WdatePicker({startDate:'%y-%M-01 00:00:00',
																	dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})">
																<f:convertDateTime pattern="yyyy-MM-dd HH:mm:ss" />
																</h:inputText>
																<font color="red">自动更新</font>
															</td>
														</tr>
														<!-- 保养周期-->
														<tr>
															<td>
																<h:outputText value="保养周期(天)："></h:outputText>
															</td>
															<td>
																<h:inputText id="newRepairCycle" value="#{DeviceBean.newRepairCycle}">
																</h:inputText>
																<font color="red">可更改</font>
															</td>
														</tr>
														<!-- 使用年限-->
														<tr>
															<td>
																<h:outputText value="使用年限(年)："></h:outputText>
															</td>
															<td>
																<h:inputText id="newUseTimeLimit" value="#{DeviceBean.newUseTimeLimit}">
																</h:inputText>
																<font color="red">不可更改</font>
															</td>
														</tr>																																																																																																																								
														<h:messages styleClass="error-msg" globalOnly="true" />
													</table>
													<br/>
													<div align="left">
														<h:commandButton value="#{msgs.submit}"
															action="#{DeviceBean.DeviceDocAddSuccessAction}" 
															style="height: 25px; width: 40px" />
														<input type="button" value="返回"
															style="height: 25px; width: 40px"
															onClick="window:location.href='devicedoc.faces'">															
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