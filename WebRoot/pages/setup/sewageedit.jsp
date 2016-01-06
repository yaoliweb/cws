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
	</head>
	<f:view>
		<title><h:outputText value="#{msgs.sewageedit}"></h:outputText>
		</title>
		<body>
			<center>
				<h:form id="form1">
					<table id="table1">
						<tr>
							<c:import url="/top.jsp" />
						</tr>
						<tr>
							<h:panelGrid columns="3">
								<f:subview id="menu">
									<c:import url="/menu2.jsp"/>
								</f:subview>
								<f:subview id="content">
									<table id="table2">
										<tr>
											<td>
												<rich:panel style="width:800px;height:860px;">
													<f:facet name="header">
														<h:panelGroup>
															<table>
																<tr>
																	<td width="800px">
																		<h:outputText value="#{msgs.sewageedit}" styleClass="panel-title"/>
																	</td>
																</tr>
															</table>
														</h:panelGroup>
													</f:facet>
													<table width="67%" style="table-layout:fixed;">
														<!-- 所属地区 -->
														<tr>
															<td width=65>
																<h:outputText value="所属地区："></h:outputText>
															</td>
															<td width=300>
																<h:outputText id="showsuperarea" value="#{sewageBean.areaSelectName}" style="width: 50px"/>
																<h:selectOneMenu value="#{sewageBean.areaSelectIndex}"
																	style="width: 100px">
																	<f:selectItems value="#{sewageBean.areaItem}" />
																	<a4j:support event="onchange"
																		action="#{sewageBean.valuechange_area}"
																		reRender="showsuperarea,manager"></a4j:support>
																</h:selectOneMenu>
															</td>

														</tr>
														<!-- 管理员 -->
														<tr>
															<td width=65>
																<h:outputText value="管理员："></h:outputText>
															</td>
															<td width=300>
																<h:outputText id="showmanager" value="#{sewageBean.manageSelectName}" style="width: 50px"/>
																<h:selectOneMenu
																	value="#{sewageBean.managerSelectIndex}" id="manager"
																	style="width: 100px">
																	<f:selectItems value="#{sewageBean.managerItem}" />
																	<a4j:support event="onchange"
																		action="#{sewageBean.valuechange_manager}"
																		reRender="showmanager"></a4j:support>
																</h:selectOneMenu>
															</td>
														</tr>
														<!--站点控制方式 -->
														<tr>
															<td width=65>
																<h:outputText value="控制方式："></h:outputText>
															</td>
															<td width=300>
					                                        &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;
																<h:selectOneMenu
																	value="#{sewageBean.controlMethod}" id="controlMethod"
																	style="width: 100px">
																	<f:selectItems value="#{sewageBean.methodItem}" />
																
																</h:selectOneMenu>
															</td>
														</tr>
														</table>
														<!-- 控制系统ID -->
														<table  width="75%" style="table-layout:fixed;">
														<tr>
															<td width=95>
																<h:outputText value="控制系统ID："></h:outputText>
															</td>
															<td width=180>
																<h:outputText id="controlId" value="#{sewageBean.controlId}">
																</h:outputText>
															</td>
														</tr>
														<!-- 简称 -->
														<tr>
															<td width=200>
																<h:outputText value="简称："></h:outputText>
															</td>
															<td width=300>
																<h:inputText id="shorttitle"
																	value="#{sewageBean.shortTitle}">
																	<f:validateLength minimum="1"></f:validateLength>
																</h:inputText>
																<font color="red">*</font>
															</td>
														
														<!-- 名称-->
														
															<td width=75>
																<h:outputText value="名称："></h:outputText>
															</td>
															<td width=190 align="left">
																<h:inputText id="name" value="#{sewageBean.name}">
																</h:inputText>
															</td>
														</tr>
														<!-- 地址-->
														<tr>
															<td>
																<h:outputText value="地址："></h:outputText>
															</td>
															<td>
																<h:inputText id="address" value="#{sewageBean.address}">
																</h:inputText>
															</td>
															<td>
																<h:outputText value="运营编号："></h:outputText>
															</td>
															<td>
																<h:inputText id="operationnum" value="#{sewageBean.operationnum}">
																</h:inputText>
															</td>
														</tr>
														<!-- X坐标-->
														<tr>
															<td>
																<h:outputText value="#{msgs.latitude}："></h:outputText>
															</td>
															<td>
																<h:inputText id="x" value="#{sewageBean.coordinateX}">
																</h:inputText>
															</td>
														
														<!-- Y坐标-->
														
															<td>
																<h:outputText value="#{msgs.longitude}："></h:outputText>
															</td>
															<td>
																<h:inputText id="y" value="#{sewageBean.coordinateY}">
																</h:inputText>
															</td>
														</tr>
														<!-- 检测一值-->
														<tr>
															<td>
																<h:outputText value="#{msgs.detection1dl}："></h:outputText>
															</td>															
															<td>
																<h:inputText id="detection1dl" value="#{sewageBean.detection1dl}">
																</h:inputText>
															</td>
															<td>
																<h:outputText value="#{msgs.detection1ul}："></h:outputText>
															</td>															
															<td>
																<h:inputText id="detection1ul" value="#{sewageBean.detection1ul}">
																</h:inputText>
															</td>																															
														</tr>
														<!-- 检测二值-->
														<tr>
															<td>
																<h:outputText value="#{msgs.detection2dl}："></h:outputText>
															</td>															
															<td>
																<h:inputText id="detection2dl" value="#{sewageBean.detection2dl}">
																</h:inputText>
															</td>															
															<td>
																<h:outputText value="#{msgs.detection2ul}："></h:outputText>
															</td>															
															<td>
																<h:inputText id="detection2ul" value="#{sewageBean.detection2ul}">
																</h:inputText>
															</td>																															
														</tr>
														<!-- 检测三值-->
														<tr>
															<td>
																<h:outputText value="#{msgs.detection3dl}："></h:outputText>
															</td>															
															<td>
																<h:inputText id="detection3dl" value="#{sewageBean.detection3dl}">
																</h:inputText>
															</td>															
															<td>
																<h:outputText value="#{msgs.detection3ul}："></h:outputText>
															</td>															
															<td>
																<h:inputText id="detection3ul" value="#{sewageBean.detection3ul}">
																</h:inputText>
															</td>																															
														</tr>
														<!-- 检测四值-->
														<tr>
															<td>
																<h:outputText value="#{msgs.detection4dl}："></h:outputText>
															</td>															
															<td>
																<h:inputText id="detection4dl" value="#{sewageBean.detection4dl}">
																</h:inputText>
															</td>															
															<td>
																<h:outputText value="#{msgs.detection4ul}："></h:outputText>
															</td>															
															<td>
																<h:inputText id="detection4ul" value="#{sewageBean.detection4ul}">
																</h:inputText>
															</td>																															
														</tr>
														<!-- 检测五值-->
														<tr>
															<td>
																<h:outputText value="#{msgs.detection5dl}："></h:outputText>
															</td>															
															<td>
																<h:inputText id="detection5dl" value="#{sewageBean.detection5dl}">
																</h:inputText>
															</td>								
															<td>
																<h:outputText value="#{msgs.detection5ul}："></h:outputText>
															</td>															
															<td>
																<h:inputText id="detection5ul" value="#{sewageBean.detection5ul}">
																</h:inputText>
															</td>																															
														</tr>
														<!-- 检测6值-->
														<tr>
															<td>
																<h:outputText value="流量下限："></h:outputText>
															</td>															
															<td>
																<h:inputText id="detection6dl" value="#{sewageBean.detection6dl}">
																</h:inputText>
															</td>								
															<td>
																<h:outputText value="流量上限："></h:outputText>
															</td>															
															<td>
																<h:inputText id="detection6ul" value="#{sewageBean.detection6ul}">
																</h:inputText>
															</td>																															
														</tr>
														<!-- 人工格栅-->
														<tr>
															<td>
																<h:outputText value="#{msgs.geshan}(天)："></h:outputText>
															</td>															
															<td>
																<h:inputText id="gratingDays" value="#{sewageBean.gratingDays}">
																</h:inputText>
															</td>
														</tr>
														<!-- 污水处理-->
														<tr>
															<td>
																<h:outputText value="提升泵流量："></h:outputText>
															</td>															
															<td>
																<h:inputText id="waterflow" value="#{sewageBean.waterflow}">
																</h:inputText>
															</td>
															<td>
																<h:outputText value="消减COD值："></h:outputText>
															</td>															
															<td>
																<h:inputText id="reduceCOD" value="#{sewageBean.reduceCOD}">
																</h:inputText>
															</td>
														</tr>
														<tr>
															<td>
																<h:outputText value=" 消减NH3-N值："></h:outputText>
															</td>															
															<td>
																<h:inputText id="reduceNH3N" value="#{sewageBean.reduceNH3N}">
																</h:inputText>
															</td>
															<td>
																<h:outputText value="消减P值："></h:outputText>
															</td>															
															<td>
																<h:inputText id="reduceP" value="#{sewageBean.reduceP}">
																</h:inputText>
															</td>
														</tr>
														</table>
														<table>
														<tr>
															<td>
																<h:outputText value="曝气机："></h:outputText>
															</td>
															<td>
																<br/>
																<%="控制方式：" %>
																<h:selectOneMenu value="#{sewageBean.control_strategy[0]}">
																	<f:selectItem itemValue="1" itemLabel="手动控制"/>
																	<f:selectItem itemValue="2" itemLabel="时间控制"/>
																	<f:selectItem itemValue="3" itemLabel="溶解氧控制"/>
																</h:selectOneMenu>
																<br/>
																<%="00:00~12:00  " %>
																<h:selectOneMenu value="#{sewageBean.air_sched[0]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.air_sched[1]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.air_sched[2]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.air_sched[3]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.air_sched[4]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.air_sched[5]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.air_sched[6]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.air_sched[7]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.air_sched[8]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.air_sched[9]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.air_sched[10]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.air_sched[11]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<br/>
																<%="12:00~24:00" %>
																<h:selectOneMenu value="#{sewageBean.air_sched[12]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.air_sched[13]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.air_sched[14]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.air_sched[15]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.air_sched[16]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.air_sched[17]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.air_sched[18]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.air_sched[19]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.air_sched[20]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.air_sched[21]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.air_sched[22]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.air_sched[23]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
															</td>
														</tr>
														<tr>
															<td>
																<h:outputText value="污水泵：">
																</h:outputText>
															</td>
															<td>
																<br/>
																<%="控制方式：" %>
																<h:selectOneMenu value="#{sewageBean.control_strategy[1]}">
																	<f:selectItem itemValue="1" itemLabel="手动控制"/>
																	<f:selectItem itemValue="2" itemLabel="自动控制"/>
																</h:selectOneMenu>
																<br/>
															</td>
														</tr>
														<tr>
															<td>
																<h:outputText value="回流泵："></h:outputText>
															</td>
															<td>
																<br/>
																<%="控制方式：" %>
																<h:selectOneMenu value="#{sewageBean.control_strategy[2]}">
																	<f:selectItem itemValue="1" itemLabel="手动控制"/>
																	<f:selectItem itemValue="2" itemLabel="时间控制"/>
																</h:selectOneMenu>
																<br/>
																<%="00:00~12:00  " %>
																<h:selectOneMenu value="#{sewageBean.mud_sched[0]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.mud_sched[1]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.mud_sched[2]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.mud_sched[3]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.mud_sched[4]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.mud_sched[5]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.mud_sched[6]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.mud_sched[7]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.mud_sched[8]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.mud_sched[9]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.mud_sched[10]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.mud_sched[11]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<br/>
																<%="12:00~24:00" %>
																<h:selectOneMenu value="#{sewageBean.mud_sched[12]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.mud_sched[13]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.mud_sched[14]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.mud_sched[15]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.mud_sched[16]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.mud_sched[17]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.mud_sched[18]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.mud_sched[19]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.mud_sched[20]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.mud_sched[21]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.mud_sched[22]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
																<h:selectOneMenu value="#{sewageBean.mud_sched[23]}">
																	<f:selectItem itemValue="1" itemLabel="开"/>
																	<f:selectItem itemValue="2" itemLabel="关"/>
																</h:selectOneMenu>
															</td>
														</tr>
														<h:messages styleClass="error-msg" globalOnly="true" />
													</table>
													<br/>
													<div align="left">													
														<h:commandButton value="#{msgs.submit}"
															action="#{sewageBean.sewageEditSuccessAction}" 
															style="height: 25px; width: 40px"/>
														<input type="button" value="返回"
															style="height: 25px; width: 40px"
															onClick="window:location.href='sewagemanager.faces'">
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