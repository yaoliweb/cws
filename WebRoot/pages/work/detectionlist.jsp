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
		<title><h:outputText value="#{msgs.sewagesearch}"></h:outputText>
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
										<h:selectOneMenu id="area" value="#{sewageBean.areaSelectIndex}"
											style="width: 150px">
											<f:selectItems value="#{sewageBean.areaItem}" />
											<a4j:support event="onchange"
												action="#{sewageBean.valuechange_area}" reRender="sewage"></a4j:support>
										</h:selectOneMenu>
										<h:selectOneMenu id="sewage"
											value="#{sewageBean.sewageSelectIndex}" style="width: 150px">
											<f:selectItems value="#{sewageBean.sewageItem}" />
											<a4j:support event="onchange"
												action="#{sewageBean.valuechanged_sewage}"></a4j:support>
										</h:selectOneMenu>
										<h:outputText value="#{msgs.octime1}"></h:outputText>
										<h:inputText id="octime1" value="#{sewageBean.beginDate}"
											onfocus="new WdatePicker({startDate:'%y-%M-01 00:00:00',
																dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})">
											<f:convertDateTime pattern="yyyy-MM-dd HH:mm:ss" />
										</h:inputText>
										<h:outputText value="#{msgs.octime2}"></h:outputText>
										<h:inputText id="octime2" value="#{sewageBean.endDate}"
											onfocus="new WdatePicker({startDate:'%y-%M-01 00:00:00',
																dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})">
											<f:convertDateTime pattern="yyyy-MM-dd HH:mm:ss" />
										</h:inputText>
										<a4j:commandButton value="#{msgs.search}" reRender="showcontent"></a4j:commandButton>
									</rich:panel>
									<rich:panel style="width:800px;height:521px;" id="showcontent">
										<f:facet name="header">
											<h:panelGroup>
												<table>
													<tr>
														<td>
															<h:outputText
																value="#{sewageBean.sewageSelectName}站点检测记录"
																styleClass="panel-title"></h:outputText>
														</td>
													</tr>
												</table>
											</h:panelGroup>
										</f:facet>

										<rich:dataTable id="detectionDataTable"
											value="#{sewageBean.wraplistDataModel_detection}" rows="16"
											var="detectionData" rowClasses="tr-list-kisuu,tr-list-guusuu"
											headerClass="td-list-caption" width="96%" align="center">
											<!--检测时间 -->
											<rich:column>
												<f:facet name="header">
													<h:outputText value="#{msgs.testtime}"></h:outputText>
												</f:facet>
												<h:outputText value="#{detectionData.testingtime}">
													<f:convertDateTime pattern="yyyy-MM-dd HH:mm:ss" />
												</h:outputText>
											</rich:column>
											<!-- 设备运行状态 -->
											<rich:column>
												<f:facet name="header">
													<h:outputText value="#{msgs.temperature}" />
												</f:facet>
												<h:outputText value="#{detectionData.detection1}" />
											</rich:column>
											<rich:column>
												<f:facet name="header">
													<h:outputText value="#{msgs.ph}" />
												</f:facet>
												<h:outputText value="#{detectionData.detection2}" />
											</rich:column>
											<rich:column>
												<f:facet name="header">
													<h:outputText value="#{msgs.orp}" />
												</f:facet>
												<h:outputText value="#{detectionData.detection3}" />
											</rich:column>
											<rich:column>
												<f:facet name="header">
													<h:outputText value="#{msgs.detflow}" />
												</f:facet>
												<h:outputText value="#{detectionData.detection4 eq '1.0'? '高':(detectionData.detection4 eq '0.0' ? '低':'异常')}" />
											</rich:column>
											<rich:column>
												<f:facet name="header">
													<h:outputText value="#{msgs.turbidity}" />
												</f:facet>
												<h:outputText value="#{detectionData.detection5}" />
											</rich:column>
											<rich:column>
												<f:facet name="header">
													<h:outputText value="瞬时流量" />
												</f:facet>
												<h:outputText value="#{detectionData.detection6}" />
											</rich:column>
										</rich:dataTable>
										<br/>
										<table width="96%" align="center" bgcolor="#F0F5FD">
											<tr>
												<td width="6%" align="center">
													<input type="button" value="返回"
														style="height: 25px; width: 40px"
														onClick="window:location.href='<%=request.getContextPath()%>/home.faces'">															
												</td>											
												<!-- 分页组件  -->
												<td width="75%">
										            <rich:datascroller for="detectionDataTable" maxPages="10" align="right">
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