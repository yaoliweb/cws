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
		<title><h:outputText value="编辑设备"></h:outputText>
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
																		<h:outputText value="编辑设备" styleClass="panel-title" />
																	</td>
																</tr>
															</table>
														</h:panelGroup>
													</f:facet>
													<!-- 所属地区 -->
															<table>
															<tr>
																<td >
																	<h:outputText value="所属地区："></h:outputText>
																</td>
																<td>
																	<h:outputText value="#{DeviceBean.newAreaSelectName}"/>
																</td>
																<td>
																	<h:outputText value="#{DeviceBean.newSewageSelectName}"/>
													            </td>
													            </tr>
													            </table>
														<table >
														<!--编号-->
														<tr>
															<td>
																<h:outputText value="编号："></h:outputText>
															</td>
															<td>
																<h:inputText id="newNumber" 
																	value="#{DeviceBean.newNumber}">
																</h:inputText>
															</td>
														</tr>
														<!-- 设备名称 -->
														<tr>
															<td>
																<h:outputText value="设备名称："></h:outputText>
															</td>
															<td>
																<h:inputText id="newDeviceName" readonly="true"
																	value="#{DeviceBean.newDeviceName}">
																	<f:validateLength minimum="1"></f:validateLength>
																</h:inputText>
															</td>
														</tr>
														<!-- 设备类型参数-->
														<tr>
															<td>
																<h:outputText value="设备类型参数："></h:outputText>
															</td>
															<td>
																<h:inputText id="newDeviceType" readonly="true"
																value="#{DeviceBean.newDeviceType}">
																</h:inputText>
															</td>
														</tr>
														<!-- 安装时间-->
														<tr>
															<td>
																<h:outputText value="安装时间："></h:outputText>
															</td>
															<td>
																<h:outputText id="newSetupTime" value="#{DeviceBean.newSetupTime}">
																<f:convertDateTime pattern="yyyy-MM-dd HH:mm:ss" />
																</h:outputText>
															</td>
														</tr>
														<!-- 上次保养时间-->
														<tr>
															<td>
																<h:outputText value="上次保养时间："></h:outputText>
															</td>
															<td>
																<h:outputText id="newLastRepairTime" value="#{DeviceBean.newLastRepairTime}" >
																<f:convertDateTime pattern="yyyy-MM-dd HH:mm:ss" />
																</h:outputText>
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
															</td>
														</tr>
														<!-- 使用年限-->
														<tr>
															<td>
																<h:outputText value="使用年限(年)："></h:outputText>
															</td>
															<td>
																<h:inputText id="newUseTimeLimit" readonly="true" value="#{DeviceBean.newUseTimeLimit}">
																</h:inputText>
															</td>
														</tr>																																																																																																																								
														<h:messages styleClass="error-msg" globalOnly="true" />
													</table>
													<br/>
													<div align="left">
													<h:commandButton value="删除"
															action="#{DeviceBean.DeviceDocDelSuccessAction}" 
															style="height: 25px; width: 40px" />
														<h:commandButton value="#{msgs.submit}"
															action="#{DeviceBean.DeviceDocEditSuccessAction}" 
															style="height: 25px; width: 40px" />
														<input type="button" value="返回"
															style="height: 25px; width: 40px"
															onClick="window:location.href='<%=request.getContextPath()%>/pages/work/devicedoc.faces'">															
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