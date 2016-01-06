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
		<script type="text/javascript">
			//执行全选的函数
			function setAllChecked() {
				var oTable = document.all['form1:content:sewageTable'];
				var oChkAll = document.all['form1:content:selectall']
				if (oTable != null && oChkAll != null) {
			
					for (j = 1; j < oTable.rows.length; j++) {
			
						oTable.rows(j).cells(0).children.item(0).checked = oChkAll.checked;
					}
				}
			}		
			function getSelected() {
				if (confirm('你确定要执行删除操作吗？')) {
					var theSelected = "";
					var i = 1;
					var arraySelected = new Array();
					var oTable = document.all['form1:content:sewageTable'];
					var oChkAll = document.all['form1:content:selectall']
					if (oTable != null && oChkAll != null) {
						for (j = 1; j < oTable.rows.length; j++) {
		                    if (oTable.rows(j).cells(0).children.item(0).checked
									&& oTable.rows(j).cells(1).innerText != null) {

								theSelected += oTable.rows(j).cells(1).innerText  + '@';
			
							} else {
								i = i + 1;
							}
						}
			
						if (i == j) {
							confirm('没有选择任何记录!');
							return false;
						} else {
							theSelected = theSelected.substr(0, theSelected.length - 1);
							document.getElementById("form1:delDataIDStr").value = theSelected;
						}
					}
				} else {
					return false;
				}
			}
	    </script>
	</head>
	<f:view>
		<head>
			<title><h:outputText value="污水站点水质报警列表" /></title>
		</head>
		<body>
			<center>
				<h:form id="form1">
					<h:inputHidden id="delDataIDStr"
						value="#{sewageBean.delDataIDStr}" />	
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
											<rich:panel style="width:800px;height:60px;">
												<f:facet name="header">
													<h:panelGroup>
														<table >
															<tr>
																<td >
																	<h:outputText value="城市地区列表" styleClass="panel-title"/>
																</td>
															</tr>
														</table>
													</h:panelGroup>
												</f:facet>
												
												<h:selectOneMenu value="#{sewageBean.areaSelectIndex}"
											style="width: 150px">
											<f:selectItems value="#{sewageBean.areaItem}" />
											<a4j:support event="onchange"
												action="#{sewageBean.valuechange_area}" ></a4j:support>
										</h:selectOneMenu>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<a4j:commandButton value="#{msgs.search}"
											reRender="showcontent"></a4j:commandButton>
											
									
										
										</rich:panel>
									<rich:panel style="width:800px;height:521px;" id="showcontent">
										<f:facet name="header">
										
												<table>
													<tr>
														<td>
															<h:outputText value="#{sewageBean.areaSelectName}水质报警列表"
																styleClass="panel-title"></h:outputText>
														</td>
													</tr>
												</table>
										
										</f:facet>
												
												
												
												
												
												
												<rich:dataTable id="sewageTable" rows="16"
													value="#{sewageBean.waterQuality}" var="sewage"
													rowClasses="tr-list-kisuu,tr-list-guusuu"
													headerClass="td-list-caption"
													width="96%" align="center">
		                                    		
		                                    		<!-- 序号 -->
													<rich:column sortBy="#{sewage.number}">
														<f:facet name="header">
														    <h:outputText value="序号"/>
														</f:facet>
													
															<h:outputText value="#{sewage.number}"/>
													
													</rich:column>
													<!-- 名称 -->
													<rich:column >
														<f:facet name="header">
														    <h:outputText value="站点名称"/>
														</f:facet>
													
															<h:outputText value="#{sewage.shortTitle}"/>
													
													</rich:column>				
													<!--运营编号 -->
													<rich:column>
														<f:facet name="header">
														    <h:outputText value="运营编号"/>
														</f:facet>
														<h:outputText value="#{sewage.operationnum}"/>
													</rich:column>
													<!-- 控制id -->
													<rich:column>
														<f:facet name="header">
														    <h:outputText value="控制ID"/>
														</f:facet>
														<h:outputText value="#{sewage.sewageId}"/>
													</rich:column>
													<!-- 最后跟新时间 -->
													<rich:column>
														<f:facet name="header">
														    <h:outputText value="数据更新时间"/>
														</f:facet>
														<h:outputText value="#{sewage.time}"/>
													</rich:column>
													
											<!-- 状态 -->
													<rich:column>
														<f:facet name="header">
														    <h:outputText value="异常参数"/>
														</f:facet>
														<h:outputText value="#{sewage.statement}"/>
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
												            <rich:datascroller for="sewageTable" maxPages="10" align="right">
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
