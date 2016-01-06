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
		<title><h:outputText value="设备维护保养记录"></h:outputText>
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
									<rich:panel style="width:800px;height:601px;" id="showcontent">
										<f:facet name="header">
											<h:panelGroup>
												<table>
													<tr>
														<td>
															<h:outputText value="#{DeviceBean.newSewageSelectName}维修记录列表"
																styleClass="panel-title"></h:outputText>
														</td>
													</tr>
												</table>
											</h:panelGroup>
										</f:facet>
										<rich:dataTable id="EquipRepairRecordTable"
											value="#{DeviceBean.wraplistDataModel_EquipRepairRecord}" rows="16"
											var="EquipRepairRecord" rowClasses="tr-list-kisuu,tr-list-guusuu"
											headerClass="td-list-caption" width="96%" align="center">
											<!-- 记录列表 -->
											<rich:column >
												<f:facet name="header">
													<h:outputText value="编号" />
												</f:facet>
												<h:commandLink action="#{DeviceBean.getEquipRepairRecordContent}">
												<h:outputText
													value="#{EquipRepairRecord.serialNumber}" />
													<f:param name="serialnumber" value="#{EquipRepairRecord.serialNumber}"/>
												</h:commandLink>
											</rich:column>
											<rich:column>
												<f:facet name="header">
													<h:outputText value="项目名称" />
												</f:facet>
												<h:outputText
													value="#{EquipRepairRecord.projectName}" />
											</rich:column>
											<rich:column>
												<f:facet name="header">
													<h:outputText value="保养设备名称" />
												</f:facet>
												<h:outputText value="#{EquipRepairRecord.deviceName}" />
											</rich:column>
											<rich:column>
												<f:facet name="header">
													<h:outputText value="日期" />
												</f:facet>
												<h:outputText
													value="#{EquipRepairRecord.time}" />
											</rich:column>
											<rich:column>
												<f:facet name="header">
													<h:outputText value="完成时间" />
												</f:facet>
												<h:outputText
													value="#{EquipRepairRecord.completeTime}" />
											</rich:column>
										</rich:dataTable>
										<br/>
										<table width="96%" align="center" bgcolor="#F0F5FD">
											<tr>
												<td width="6%" align="center">
													<input type="button" value="返回"
														style="height: 25px; width: 40px"
														onClick="window:location.href='<%=request.getContextPath()%>/pages/work/devicedoc.faces'">															
												</td>												
												<!-- 分页组件  -->
												<td width="75%">
										            <rich:datascroller for="EquipRepairRecordTable" maxPages="10" align="right">
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