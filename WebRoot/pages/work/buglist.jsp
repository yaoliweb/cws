<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

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
			<title><h:outputText value="#{msgs.faultlist}" /></title>
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
														<table width="98%">
															<tr>
																<td width="75%">
																	<h:outputText value="#{msgs.faultlist}" styleClass="panel-title"/>
																</td>
															</tr>
														</table>
													</h:panelGroup>
												</f:facet>
												<table>
													<tr height="30">
														<!-- 地区名称 -->
														<td>
															<h:outputText value="#{msgs.areaname}："/>
														</td>
														<td>
															<h:selectOneMenu value="#{bugBean.areaSelectIndex}" 
																style="width: 150px">
																<f:selectItems value="#{bugBean.areaItems}" />
																<a4j:support event="onchange"
																		action="#{bugBean.areaValueChanged}"
																		reRender="sewageMenu"></a4j:support>
															</h:selectOneMenu>
														</td>
														<!-- 污水站名称 -->	
														<td>
															<h:outputText value="#{msgs.sewagestation}："/>
														</td>
														<td>
															<h:selectOneMenu id="sewageMenu" value="#{bugBean.sewageSelectIndex}"
																style="width: 150px">
																<f:selectItems value="#{bugBean.sewageItems}" />
																<a4j:support event="onchange"
																		action="#{bugBean.sewageValueChanged}"
																		reRender="bugTable"></a4j:support>
															</h:selectOneMenu>
														</td>
													</tr>
													<tr height="30">	
														<!-- 起止时间 -->	
														<td>
															<h:outputText value="#{msgs.octime1}"></h:outputText>
														</td>
														<td>
															<h:inputText id="octime1" value="#{bugBean.octime1}"
																onfocus="new WdatePicker({startDate:'%y-%M-01 00:00:00',
																dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})">
																<f:convertDateTime pattern="yyyy-MM-dd HH:mm:ss" />
															</h:inputText>
														</td>
														<td>
															<h:outputText value="#{msgs.octime2}"></h:outputText>
														</td>
														<td>
															<h:inputText id="octime2" value="#{bugBean.octime2}"
																onfocus="new WdatePicker({startDate:'%y-%M-01 00:00:00',
																dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})">
																<f:convertDateTime pattern="yyyy-MM-dd HH:mm:ss" />
															</h:inputText>
														</td>
														<td>
															<h:commandButton value="#{msgs.search}"
																action="#{bugBean.queryBugByCondition}"
																style="height: 25px; width: 40px">
															</h:commandButton>
														</td>														
													</tr>													
												</table>
												<br/>												
												<rich:dataTable id="bugTable" rows="16"
													value="#{bugBean.allBugListModal}" var="bug"
													rowClasses="tr-list-kisuu,tr-list-guusuu"
													headerClass="td-list-caption"
													width="96%" align="center">
													<!-- 故障ID -->
													<rich:column style="display: none;"
														headerClass="td-header">
														<h:outputText value="#{bug.bugId}"/>
													</rich:column>
													<!-- 故障设备 -->
													<rich:column sortBy="#{bug.bugEquipment}">
														<f:facet name="header">
														    <h:outputText value="#{msgs.devicename}"/>
														</f:facet>
														<h:commandLink action="#{bugBean.getBugContent}">
															<h:outputText value="曝气机" rendered="#{bug.bugEquipment eq 'air'}"></h:outputText>
															<h:outputText value="污水泵" rendered="#{bug.bugEquipment eq 'water'}"></h:outputText>
															<h:outputText value="回流泵" rendered="#{bug.bugEquipment eq 'mud'}"></h:outputText>
															<f:param name="bugId" value="#{bug.bugId}"/>
														</h:commandLink>
													</rich:column>																										
													<!-- 故障情況 -->
													<rich:column sortBy="#{bug.bugCondition}">
														<f:facet name="header">
														    <h:outputText value="#{msgs.bugcondition}"/>
														</f:facet>
														<h:outputText value="#{bug.bugCondition}"/>
													</rich:column>
													<!-- 发生时间-->
													<rich:column sortBy="#{bug.occurrenceTime}">
														<f:facet name="header">
															<h:outputText value="#{msgs.faultocttime}"/>
														</f:facet>
														<h:outputText value="#{bug.occurrenceTime}">
															<f:convertDateTime pattern="yyyy-MM-dd HH:mm:ss" />
														</h:outputText>
													</rich:column>
													<!-- 故障状态 -->
													<rich:column sortBy="#{bug.bugState}">
														<f:facet name="header">
														    <h:outputText value="#{msgs.faultstatus}"/>
														</f:facet>
														 
														<h:outputText value="#{bug.bugState eq '1' ? '待处理':(bug.bugState eq '2' ? '已通知':(bug.bugState eq '5' ? '处理中' : (bug.bugState eq '9' ? '已解除' : '')))}"/>
													     
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
												            <rich:datascroller for="bugTable" maxPages="10" align="right">
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
