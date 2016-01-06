<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<f:loadBundle basename="cn.zj.sunda.water.bundle.Messages_zh_CN" var="msgs" />
		<link rel="stylesheet" type="text/css" href="/css/water.css">
		<script language="javascript" type="text/javascript"
			src="../../js/My97DatePicker/WdatePicker.js">
		</script>		
	</head>
	<f:view>
		<head>
			<title><h:outputText value="#{msgs.faultedit}" /></title>
		</head>
		<body>
			<center>
				<h:form id="form1">
					<table>
						<tr>
							<c:import url="/top.jsp"></c:import>
						</tr>
						<h:panelGrid columns="2">
							<f:subview id="menu">
								<c:import url="/menu.jsp"></c:import>
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
																<td>
																	<h:outputText value="#{msgs.faultedit}" styleClass="panel-title" />
																</td>
															</tr>
														</table>
													</h:panelGroup>
												</f:facet>
												<table>
													<!-- 地区名称 -->
													<tr height="28">
														<td>
															<h:outputText value="#{msgs.areaname}："/>
														</td>
														<td>
															<h:outputText value="#{bugBean.areaName}"/>
														</td>
													</tr>
													<!-- 污水站名称 -->													
													<tr height="28">
														<td>
															<h:outputText value="#{msgs.sewagestation}："></h:outputText>
														</td>
														<td>
															<h:outputText value="#{bugBean.sewageName}"/>
														</td>
													</tr>
													<!-- 故障设备 -->
													<tr height="28">
														<td>
															<h:outputText value="#{msgs.bugdevice}："></h:outputText>
														</td>
														<td>
															<h:outputText value="曝气机" rendered="#{bugBean.bugEquipment eq 'air'}"></h:outputText>
															<h:outputText value="污水泵" rendered="#{bugBean.bugEquipment eq 'water'}"></h:outputText>
															<h:outputText value="回流泵" rendered="#{bugBean.bugEquipment eq 'mud'}"></h:outputText>
														</td>
													</tr>
													<!-- 故障情况 -->
													<tr height="28">
														<td>
															<h:outputText value="#{msgs.bugcondition}："></h:outputText>
														</td>
														<td>
															<h:inputText value="#{bugBean.bugCondition}" size="40"></h:inputText>
														</td>															
													</tr>
													<!-- 发生时间-->
													<tr height="28">
														<td>
															<h:outputText value="#{msgs.faultocttime}："></h:outputText>
														</td>
														<td>
															<h:inputText id="octime" value="#{bugBean.occurrenceTime}"
																onfocus="new WdatePicker({startDate:'%y-%M-01 00:00:00',
																dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})" size="20">
																<f:convertDateTime pattern="yyyy-MM-dd HH:mm:ss" />
															</h:inputText>
														</td>
													</tr>													
													<!-- 故障状态 -->
													<tr height="28">
														<td>
															<h:outputText value="#{msgs.faultstatus}："></h:outputText>
														</td>
														<td>
															<h:inputText value="#{bugBean.bugState}" size="20"></h:inputText>
															<h:outputText value="(1:待处理，2：已通知，3：处理中)"></h:outputText>
														</td>															
													</tr>
													<!-- 故障原因 -->
													<tr height="28">
														<td>
															<h:outputText value="#{msgs.devrepairfaultcase}："></h:outputText>
														</td>
														<td>
															<h:inputTextarea value="#{bugBean.bugCause}" style="width=480px"></h:inputTextarea>
														</td>															
													</tr>
													<!-- 维修情况 -->
													<tr height="28">
														<td>
															<h:outputText value="#{msgs.devrepairrepairstate}："></h:outputText>
														</td>
														<td>
															<h:inputTextarea value="#{bugBean.repairCondition}" style="width=480px"></h:inputTextarea>
														</td>															
													</tr>
													<!-- 维修费用 -->
													<tr height="28">
														<td>
															<h:outputText value="#{msgs.devrepairrepairprice}："></h:outputText>
														</td>
														<td>
															<h:inputText converter="javax.faces.Float" value="#{bugBean.repairCost}" size="20" id="devreprice" converterMessage="请输入数字" validatorMessage="请输入10位以内的数字">
																<f:validateLength maximum="10"/>
															</h:inputText>
															<h:message for="devreprice" style="color:red"/>
														</td>															
													</tr>
													<!-- 完成时间-->
													<tr height="28">
														<td>
															<h:outputText value="#{msgs.devrepairrepairdate}："></h:outputText>
														</td>
														<td>
															<h:inputText id="repairdate" value="#{bugBean.finishTime}"
																onfocus="new WdatePicker({startDate:'%y-%M-01 00:00:00',
																dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})">
																<f:convertDateTime pattern="yyyy-MM-dd HH:mm:ss" />
															</h:inputText>
														</td>
													</tr>													
													<!-- 维修员 -->
													<tr height="28">
														<td>
															<h:outputText value="#{msgs.devrepairrepairer}："></h:outputText>
														</td>
														<td>
															<!-- 添加汉字验证 -->
															<h:inputText value="#{bugBean.repairr}" size="8" id="failre"/>
															<h:message for="failre" style="color:red"/>
														</td>															
													</tr>
													<!-- 验收员 -->
													<tr height="28">
														<td>
															<h:outputText value="#{msgs.devrepairchecker}："></h:outputText>
														</td>
														<td>
															<!-- 添加汉字验证 -->
															<h:inputText value="#{bugBean.accepter}" size="8" id="failche"/>
															<h:message for="failche" style="color:red"/>
														</td>															
													</tr>
													<!-- 操作员 -->
													<tr height="28">
														<td>
															<h:outputText value="#{msgs.devrepairoperator}："></h:outputText>
														</td>
														<td>
															<!-- 添加汉字验证 -->
															<h:inputText value="#{bugBean.operator}" size="8" id="failope"/>
															<h:message for="failope" style="color:red"/>
														</td>															
													</tr>																																																																																																																											
												</table>
												<br/>
												<div align="left">
													<h:commandButton value="#{msgs.save}"
														action="#{bugBean.saveBug}"
														style="height: 25px; width: 40px" >
													</h:commandButton>
													<input type="button" value="返回"
														style="height: 25px; width: 40px"
														onClick="window:location.href='bugmanager.faces'">
												</div>
											</rich:panel>
										</td>
									</tr>
								</table>
							</f:subview>
						</h:panelGrid>
						<tr>
							<c:import url="/foot.jsp"></c:import>
						</tr>
					</table>
				</h:form>
			</center>
		</body>
	</f:view>
</html>