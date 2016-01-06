<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String str = "";
	if (request.getParameter("sewagetitle") != null) {
		str = new String(request.getParameter("sewagetitle").getBytes(
				"ISO8859_1"));

	} else {
		str = "|";
	}
	session.setAttribute("str", str);

	String sewageid = request.getParameter("sewageid");
	session.setAttribute("sewageid",sewageid); 
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head> 
		<link rel="stylesheet" type="text/css" href="/css/water.css">
		<link rel="stylesheet" type="text/css" href="../../ext3/resources/css/ext-all.css"></link> 
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<f:loadBundle basename="cn.zj.sunda.water.bundle.Messages_zh_CN" var="msgs" />	
		<script type="text/javascript" src="../../ext3/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="../../ext3/ext-all.js"></script> 
		<script type="text/javascript" src="chart.js"></script>
	</head>
	<f:view>
		<title><h:outputText value="#{msgs.home}"></h:outputText>
		</title>
		<body onload="init()">
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

								<f:subview id="sewageinfopage">
									
										<table id="table2" width="800" height="600">
											<tr>
												<td>
													<rich:panel style="width:398px;height:298px;">
														<f:facet name="header">
															<h:panelGroup>
																<table>
																	<tr>
																		<td>
																			<h:outputText value="站点信息显示："
																				styleClass="panel-title"></h:outputText>
																		</td>
																	</tr>
																</table>
															</h:panelGroup>
														</f:facet>
														<table>
															<tr>
																<td align="left">站点名称：</td>
															</tr>
															<tr>
																<td align="left">地址：</td>
															</tr>
															<tr>
																<td align="left">责任人：</td>
															</tr>
															<tr>
																<td align="left">修建时间：</td>
															</tr>
															<tr>
																<td align="left">站点介绍：</td>
															</tr>
															<tr>
																<td align="left">站点现场照片：<h:commandButton value="点击获取"></h:commandButton></td>
															</tr>
															<tr>
																<td align="left">站点运行状态：</td>
															</tr>
														</table>
													</rich:panel>
												</td>
												<td>
													<rich:panel style="width:398px;height:298px;">
														<f:facet name="header">
															<h:panelGroup>
																<table>
																	<tr>
																		<td>
																			<h:outputText value="设备运行状态显示："
																				styleClass="panel-title"></h:outputText>
																		</td>
																	</tr>
																</table>
															</h:panelGroup>
														</f:facet>
														<table>
															
														</table>
													</rich:panel>
												</td>
											</tr>
											<tr>
												<td>
													<rich:panel style="width:398px;height:298px;overfolw:auto;OVERFLOW-y:auto;OVERFLOW-x:auto">
														<f:facet name="header">
															<h:panelGroup>
																<table>
																	<tr>
																		<td>
																			<h:outputText value="水质变化曲线显示："
																				styleClass="panel-title"></h:outputText>
																		</td>
																	</tr>
																</table>
															</h:panelGroup>
														</f:facet>
														<table>
															<tr>
																<td>
																	<div>
																		<div id="container1" style="width:375px;height:250px;float:left"></div>
																		<div id="container2" style="width:375px;height:250px;float:right"></div>
																		<div style="width:750px;height:20px;float:left">
																			<table width="775px">
																				<tr>
																					<td width="50%" align="center">
																						<h:outputText value="-T  " style="color: #6600FF"/>
																						<h:outputText value="-PH  " style="color: #FF3399"/>
																						<h:outputText value="-LS  " style="color: #00BB00"/>
																						<h:outputText value="-DO" style="color: #FF9966"/>
																					</td>
																					<td width="50%" align="center">
																						<h:outputText value="-ORP" style="color: #00CCFF"/>
																					</td>
																				</tr>
																			</table>
																		</div>
																	</div>
																</td>
															</tr>
														</table>
													</rich:panel>
												</td>
												<td>
													<rich:panel style="width:398px;height:298px;">
														<f:facet name="header">
															<h:panelGroup>
																<table>
																	<tr>
																		<td>
																			<h:outputText value="水质监测结果列表："
																				styleClass="panel-title"></h:outputText>
																		</td>
																	</tr>
																</table>
															</h:panelGroup>
														</f:facet>
														<rich:dataTable id="detectionTable" rows="10"
															rowClasses="tr-list-kisuu,tr-list-guusuu"
															headerClass="td-list-caption"
															width="96%" align="center">
														   	<rich:column>
														   		<f:facet name="header">
														   			<h:outputText value="时间" />
														   		</f:facet>
														   	</rich:column>
														   	<rich:column>
														   		<f:facet name="header">
														   			<h:outputText value="T (℃)" />
														   		</f:facet>
														   	</rich:column>
														   	<rich:column>
														   		<f:facet name="header">
														   			<h:outputText value="PH (pH)" />
														   		</f:facet>
														   	</rich:column>
														   	<rich:column>
														   		<f:facet name="header">
														   			<h:outputText value="ORP (mV)" />
														   		</f:facet>
														   	</rich:column>
														   	<rich:column>
														   		<f:facet name="header">
														   			<h:outputText value="LS" />
														   		</f:facet>
														   	</rich:column>
														   	<rich:column>
														   		<f:facet name="header">
														   			<h:outputText value="DO (mg/L)" />
														   		</f:facet>
														   	</rich:column>
														   	<rich:column>
														   		<f:facet name="header">
														   			<h:outputText value="流量" />
														   		</f:facet>
														   	</rich:column>
														
														</rich:dataTable>
														<br/>
														<table>
															<tr>
																<td width="75%">
														            <rich:datascroller for="detectionTable" maxPages="10" align="right">
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