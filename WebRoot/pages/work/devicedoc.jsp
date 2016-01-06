<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/css/water.css">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<f:loadBundle basename="cn.zj.sunda.water.bundle.Messages_zh_CN"
			var="msgs" />
		<script language="javascript" type="text/javascript"
			src="../../js/My97DatePicker/WdatePicker.js">
</script>
	</head>
	<f:view>
		<title><h:outputText value="设备档案"></h:outputText>
		</title>
		<body>
			<center>
				<h:form>
					<table id="table1">
						<tr>
							<c:import url="/top.jsp"></c:import>
						</tr>
						<tr>
							<h:panelGrid columns="2">
								<f:subview id="menu">
									<c:import url="/menu.jsp"></c:import>
								</f:subview>
								<f:subview id="functioncontentpage">
									<rich:panel style="width:800px;height:65px;">
										<f:facet name="header">
											<h:panelGroup>
												<table>
													<tr>
														<td>
															<h:outputText value="#{msgs.sewageselect}"
																styleClass="panel-title"></h:outputText>
														</td>
													</tr>
												</table>
											</h:panelGroup>
										</f:facet>
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
										<a4j:commandButton value="#{msgs.search}"
											reRender="showcontent"></a4j:commandButton>
									</rich:panel>
									<rich:panel style="width:800px;height:521px;" id="showcontent">
										<f:facet name="header">
											<h:panelGroup>
												<table>
													<tr>
														<td>
															<h:outputText value="#{DeviceBean.newSewageSelectName}设备档案"
																styleClass="panel-title"></h:outputText>
														</td>
													</tr>
												</table>
											</h:panelGroup>
										</f:facet>
										<rich:dataTable id="DeviceDocDataTable"
											value="#{DeviceBean.wraplistDataModel_DeviceDoc}" rows="16"
											var="DeviceDocData" rowClasses="tr-list-kisuu,tr-list-guusuu"
											headerClass="td-list-caption" width="96%" align="center">
											<!-- 设备列表 -->
											<rich:column>
												<f:facet name="header">
													<h:outputText value="编号" />
												</f:facet>
												<h:outputText
													value="#{DeviceDocData.number}" />	
											</rich:column>
											<rich:column>
												<f:facet name="header">
													<h:outputText value="设备名称" />
												</f:facet>
												<h:commandLink action="#{DeviceBean.editDeviceContent}">
												<h:outputText value="#{DeviceDocData.deviceName}" />
												    <f:param name="lastrepairtime" value="#{DeviceDocData.lastRepairTime}"></f:param>
													<f:param name="devicetype" value="#{DeviceDocData.deviceType}"></f:param>
													<f:param name="number" value="#{DeviceDocData.number}"/>
													<f:param name="devicename" value="#{DeviceDocData.deviceName}"/>
													<f:param name="repaircycle" value="#{DeviceDocData.repairCycle}"></f:param>
													<f:param name="usetimelimit" value="#{DeviceDocData.useTimeLimit}"></f:param>
													<f:param name="setuptime" value="#{DeviceDocData.setupTime}"></f:param>
													<f:param name="repairrecord" value="#{DeviceDocData.repairRecord}"></f:param>
												</h:commandLink>
												</rich:column>
											<rich:column>
												<f:facet name="header">
													<h:outputText value="设备型号参数" />
												</f:facet>
												<h:outputText
													value="#{DeviceDocData.deviceType}" />
											</rich:column>
											<rich:column>
												<f:facet name="header">
													<h:outputText value="安装时间" />
												</f:facet>
												<h:outputText
													value="#{DeviceDocData.setupTime}" />
											</rich:column>
											<rich:column>
												<f:facet name="header">
													<h:outputText value="上次保养时间" />
												</f:facet>
												<h:outputText
													value="#{DeviceDocData.lastRepairTime}" />
											</rich:column>
											<rich:column>
												<f:facet name="header">
													<h:outputText value="保养周期(天)" />
												</f:facet>
												<h:outputText
													value="#{DeviceDocData.repairCycle}" />
											</rich:column>
											<rich:column>
												<f:facet name="header">
													<h:outputText value="使用年限(年)" />
												</f:facet>
												<h:outputText
													value="#{DeviceDocData.useTimeLimit}" />
											</rich:column>
											<rich:column>
												<f:facet name="header">
													<h:outputText value="维修记录" />
												</f:facet>
												<h:commandLink action="#{DeviceBean.getDeviceContent}">
												<h:outputText
													value="#{DeviceDocData.repairRecord}" />
													<f:param name="devicename" value="#{DeviceDocData.deviceName}"/>
												</h:commandLink>
											</rich:column>
										</rich:dataTable>
										<br/>
										<table width="96%" align="center" bgcolor="#F0F5FD">
											<tr>
											<td width="6%" align="center">
															<h:commandButton value="添加设备" action="#{DeviceBean.deviceDocAddAction}"
																 style="height: 25px; width: 100px">
															</h:commandButton>
														</td>
												<td width="6%" align="center">
													<input type="button" value="返回"
														style="height: 25px; width: 40px"
														onClick="window:location.href='<%=request.getContextPath()%>/home.faces'">															
												</td>												
												<!-- 分页组件  -->
												<td width="75%">
										            <rich:datascroller for="DeviceDocDataTable" maxPages="10" align="right">
												        <f:facet name="first">
												            <h:outputText value="#{msgs.firstPage}" style='font-size: 11px; font-family: SimSun'/>
												        </f:facet>
												        <f:facet name="last">
												            <h:outputText value="#{msgs.lastPage}" style='font-size: 11px; font-family: SimSun'/>
												        </f:facet>
												    </rich:datascroller>
												</td>
											</tr>
										</table>
									</rich:panel>
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