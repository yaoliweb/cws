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
		<title><h:outputText value="添加设备维护保养单"></h:outputText>
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
																		<h:outputText value="添加设备维护保养单" styleClass="panel-title" />
																	</td>
																</tr>
															</table>
														</h:panelGroup>
													</f:facet>
													<table width="97%" style="table-layout:fixed;">
														<!-- 选择污水站 -->
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
														<!-- 保养单详细内容 -->
													<table>
														<tr>
															<td>
															 <h:outputText value="设备名称："></h:outputText>
															</td>
															<td>
																<h:inputText id="deviceName"
																	value="#{DeviceBean.newDeviceName}">
																</h:inputText>
																<font color="red">(必填，否则记录无法被查询)</font>															
															</td>
														</tr>
													</table>
														<!-- 项目编号-->
													<table>
														<tr>
															<td>
																<h:outputText value="项目编号："></h:outputText>
															</td>
															<td>
																<h:inputText  value="#{DeviceBean.newProjectSerialNumber}">
																</h:inputText>
															</td>
															<td>
																<h:outputText value="项目名称："></h:outputText>
															</td>
															<td>
																<h:inputText  value="#{DeviceBean.newProjectName}">
																</h:inputText>
															</td>
															<td>
																<h:outputText value="地点："></h:outputText>
															</td>
															<td>
																<h:inputText  value="#{DeviceBean.newSite}">
																</h:inputText>
															</td>
														</tr>
														<tr>
															<td>
																<h:outputText value="日期："></h:outputText>
															</td>
															<td>
																<h:inputText  value="#{DeviceBean.newTime}"
																 onfocus="new WdatePicker({startDate:'%y-%M-01 00:00:00',
											                    dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})">
																<f:convertDateTime pattern="yyyy-MM-dd HH:mm:ss" />
																</h:inputText>
															</td>
															<td>
																<h:outputText value="上次保养时间："></h:outputText>
															</td>
															<td>
																<h:inputText  value="#{DeviceBean.newLastRepairTime}"
																onfocus="new WdatePicker({startDate:'%y-%M-01 00:00:00',
																dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})">
																<f:convertDateTime pattern="yyyy-MM-dd HH:mm:ss" />
																</h:inputText>
															</td>
															<td>
																<h:outputText value="保养耗时："></h:outputText>
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
																<h:outputText value="保养原因："></h:outputText>
															</td>
															<td>
																<h:inputTextarea style="width:630px;height:50px"
																	value="#{DeviceBean.newRepairReason}">
																</h:inputTextarea>
															</td>
														</tr>
														<tr>
															<td>
																<h:outputText value="保养内容："></h:outputText>
															</td>
															<td>
																<h:inputTextarea style="width:630px;height:50px" 
																	value="#{DeviceBean.newRepairContent}">
																</h:inputTextarea>
															</td>
														</tr>
														<tr>
															<td>
																<h:outputText value="消耗材料："></h:outputText>
															</td>
															<td>
																<h:inputTextarea style="width:630px;height:50px"
																	value="#{DeviceBean.newConsumeMaterial}">
																</h:inputTextarea>
															</td>
														</tr>
														<tr>
															<td>
																<h:outputText value="意见反馈："></h:outputText>
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
																<h:outputText value="维修人员："></h:outputText>
															</td>
															<td>
																<h:inputText value="#{DeviceBean.newRepairMan}">
																</h:inputText>
															</td>
															<td>
																<h:outputText value="业主确认："></h:outputText>
															</td>
															<td>
																<h:inputText value="#{DeviceBean.newProprietorConfirm}">
																</h:inputText>
															</td>
														</tr>
														<tr>
															<td>
																<h:outputText value="主管签字："></h:outputText>
															</td>
															<td>
																<h:inputText value="#{DeviceBean.newDirectorName}">
																</h:inputText>
															</td>
															<td>
																<h:outputText value="完成时间："></h:outputText>
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
														<input type="button" value="返回"
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