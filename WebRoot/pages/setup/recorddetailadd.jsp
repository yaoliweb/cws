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
		<title><h:outputText value="����豸ά��������"></h:outputText>
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
																		<h:outputText value="����豸ά��������" styleClass="panel-title" />
																	</td>
																</tr>
															</table>
														</h:panelGroup>
													</f:facet>
													<table width="97%" style="table-layout:fixed;">
														<!-- ѡ����ˮվ -->
														<tr>
															<td width=160>
																<h:selectOneMenu value="#{DeviceBean.newAreaSelectIndex}"
																	style="width: 150px">
																	<f:selectItems value="#{DeviceBean.newAreaItem}" />
																	<a4j:support event="onchange"
																		action="#{DeviceBean.valuechange_area}"
																		reRender="chagesewage"></a4j:support>
																</h:selectOneMenu>
															</td>
															<td>
																<h:selectOneMenu id="chagesewage"
																	value="#{DeviceBean.newSewageSelectIndex}"
																	style="width: 150px">
																	<f:selectItems value="#{DeviceBean.newSewageItem}" />
																	<a4j:support event="onchange"
																		action="#{DeviceBean.valuechanged_sewage}">
																	</a4j:support>
																</h:selectOneMenu>
															</td>
														</tr>
													</table>
														<!-- ��������ϸ���� -->
													<table>
														<tr>
															<td>
															 <h:outputText value="�豸���ƣ�"></h:outputText>
															</td>
															<td>
																<h:inputText id="deviceName"
																	value="#{DeviceBean.newDeviceName}">
																</h:inputText>
																<font color="red">(��������¼�޷�����ѯ)</font>															
															</td>
														</tr>
													</table>
														<!-- ��Ŀ���-->
													<table>
														<tr>
															<td>
																<h:outputText value="��Ŀ��ţ�"></h:outputText>
															</td>
															<td>
																<h:inputText  value="#{DeviceBean.newProjectSerialNumber}">
																</h:inputText>
															</td>
															<td>
																<h:outputText value="��Ŀ���ƣ�"></h:outputText>
															</td>
															<td>
																<h:inputText  value="#{DeviceBean.newProjectName}">
																</h:inputText>
															</td>
															<td>
																<h:outputText value="�ص㣺"></h:outputText>
															</td>
															<td>
																<h:inputText  value="#{DeviceBean.newSite}">
																</h:inputText>
															</td>
														</tr>
														<tr>
															<td>
																<h:outputText value="���ڣ�"></h:outputText>
															</td>
															<td>
																<h:inputText  value="#{DeviceBean.newTime}"
																 onfocus="new WdatePicker({startDate:'%y-%M-01 00:00:00',
											                    dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})">
																<f:convertDateTime pattern="yyyy-MM-dd HH:mm:ss" />
																</h:inputText>
															</td>
															<td>
																<h:outputText value="�ϴα���ʱ�䣺"></h:outputText>
															</td>
															<td>
																<h:inputText  value="#{DeviceBean.newLastRepairTime}"
																onfocus="new WdatePicker({startDate:'%y-%M-01 00:00:00',
																dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})">
																<f:convertDateTime pattern="yyyy-MM-dd HH:mm:ss" />
																</h:inputText>
															</td>
															<td>
																<h:outputText value="������ʱ��"></h:outputText>
															</td>
															<td>
																<h:inputText  value="#{DeviceBean.newConsumeTime}">
																</h:inputText>
															</td>
														</tr>
													</table>
													<table>
														<tr>
															<td>
																<h:outputText value="����ԭ��"></h:outputText>
															</td>
															<td>
																<h:inputTextarea style="width:630px;height:50px"
																	value="#{DeviceBean.newRepairReason}">
																</h:inputTextarea>
															</td>
														</tr>
														<tr>
															<td>
																<h:outputText value="�������ݣ�"></h:outputText>
															</td>
															<td>
																<h:inputTextarea style="width:630px;height:50px" 
																	value="#{DeviceBean.newRepairContent}">
																</h:inputTextarea>
															</td>
														</tr>
														<tr>
															<td>
																<h:outputText value="���Ĳ��ϣ�"></h:outputText>
															</td>
															<td>
																<h:inputTextarea style="width:630px;height:50px"
																	value="#{DeviceBean.newConsumeMaterial}">
																</h:inputTextarea>
															</td>
														</tr>
														<tr>
															<td>
																<h:outputText value="���������"></h:outputText>
															</td>
															<td>
																<h:inputTextarea style="width:630px;height:50px"
																	value="#{DeviceBean.newFeedBack}">
																</h:inputTextarea>
															</td>
														</tr>
													</table>
													<table>
														<tr>
															<td>
																<h:outputText value="ά����Ա��"></h:outputText>
															</td>
															<td>
																<h:inputText value="#{DeviceBean.newRepairMan}">
																</h:inputText>
															</td>
															<td>
																<h:outputText value="ҵ��ȷ�ϣ�"></h:outputText>
															</td>
															<td>
																<h:inputText value="#{DeviceBean.newProprietorConfirm}">
																</h:inputText>
															</td>
														</tr>
														<tr>
															<td>
																<h:outputText value="����ǩ�֣�"></h:outputText>
															</td>
															<td>
																<h:inputText value="#{DeviceBean.newDirectorName}">
																</h:inputText>
															</td>
															<td>
																<h:outputText value="���ʱ�䣺"></h:outputText>
															</td>
															<td>
																<h:inputText value="#{DeviceBean.newCompleteTime}"
																onfocus="new WdatePicker({startDate:'%y-%M-01 00:00:00',
																	dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})">
																<f:convertDateTime pattern="yyyy-MM-dd HH:mm:ss" />
																</h:inputText>
															</td>
														</tr>
													</table>																																																																																																																										
													
													<div align="left">
														<h:commandButton value="#{msgs.submit}"
															action="#{DeviceBean.RecordDetailAddSuccessAction}" 
															style="height: 25px; width: 40px" />
														<input type="button" value="����"
															style="height: 25px; width: 40px"
															onClick="window:location.href='sewagemanager.faces'">															
													</div>
											</rich:panel>
									     </td>
									</table>
								 </f:subview>
								</h:panelGrid>
							</tr>
						  </table>
						 <tr>
					   <c:import url="/foot.jsp" />
					</tr>
				</h:form>
			</center>
		</body>
	</f:view>
</html>