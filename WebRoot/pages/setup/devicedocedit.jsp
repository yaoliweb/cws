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
		<title><h:outputText value="�༭�豸"></h:outputText>
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
																		<h:outputText value="�༭�豸" styleClass="panel-title" />
																	</td>
																</tr>
															</table>
														</h:panelGroup>
													</f:facet>
													<!-- �������� -->
															<table>
															<tr>
																<td >
																	<h:outputText value="����������"></h:outputText>
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
														<!--���-->
														<tr>
															<td>
																<h:outputText value="��ţ�"></h:outputText>
															</td>
															<td>
																<h:inputText id="newNumber" 
																	value="#{DeviceBean.newNumber}">
																</h:inputText>
															</td>
														</tr>
														<!-- �豸���� -->
														<tr>
															<td>
																<h:outputText value="�豸���ƣ�"></h:outputText>
															</td>
															<td>
																<h:inputText id="newDeviceName" readonly="true"
																	value="#{DeviceBean.newDeviceName}">
																	<f:validateLength minimum="1"></f:validateLength>
																</h:inputText>
															</td>
														</tr>
														<!-- �豸���Ͳ���-->
														<tr>
															<td>
																<h:outputText value="�豸���Ͳ�����"></h:outputText>
															</td>
															<td>
																<h:inputText id="newDeviceType" readonly="true"
																value="#{DeviceBean.newDeviceType}">
																</h:inputText>
															</td>
														</tr>
														<!-- ��װʱ��-->
														<tr>
															<td>
																<h:outputText value="��װʱ�䣺"></h:outputText>
															</td>
															<td>
																<h:outputText id="newSetupTime" value="#{DeviceBean.newSetupTime}">
																<f:convertDateTime pattern="yyyy-MM-dd HH:mm:ss" />
																</h:outputText>
															</td>
														</tr>
														<!-- �ϴα���ʱ��-->
														<tr>
															<td>
																<h:outputText value="�ϴα���ʱ�䣺"></h:outputText>
															</td>
															<td>
																<h:outputText id="newLastRepairTime" value="#{DeviceBean.newLastRepairTime}" >
																<f:convertDateTime pattern="yyyy-MM-dd HH:mm:ss" />
																</h:outputText>
															</td>
														</tr>
														<!-- ��������-->
														<tr>
															<td>
																<h:outputText value="��������(��)��"></h:outputText>
															</td>
															<td>
																<h:inputText id="newRepairCycle" value="#{DeviceBean.newRepairCycle}">
																</h:inputText>
															</td>
														</tr>
														<!-- ʹ������-->
														<tr>
															<td>
																<h:outputText value="ʹ������(��)��"></h:outputText>
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
													<h:commandButton value="ɾ��"
															action="#{DeviceBean.DeviceDocDelSuccessAction}" 
															style="height: 25px; width: 40px" />
														<h:commandButton value="#{msgs.submit}"
															action="#{DeviceBean.DeviceDocEditSuccessAction}" 
															style="height: 25px; width: 40px" />
														<input type="button" value="����"
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