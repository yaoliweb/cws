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
	</head>
	<f:view>
		<title><h:outputText value="#{msgs.home}"></h:outputText></title>
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
								<rich:panel style="width:800px;height:45px;">
								<f:facet name="header">
								<h:panelGroup>
									<table>
										<tr>
											<td>
												<h:outputText value="选择站点" styleClass="panel-title" ></h:outputText>
											</td>
										</tr>
									</table>
								</h:panelGroup>
							</f:facet>
							
							<h:selectOneMenu value ="#{sewageBean.areaSelectIndex}"
										style="width: 150px">
										<f:selectItems value="#{sewageBean.areaItem}" />
										<a4j:support event="onchange"
										action="#{sewageBean.valuechange_area}"	 reRender="sewage"></a4j:support>
									</h:selectOneMenu>
									<h:selectOneMenu id="sewage" value="#{sewageBean.sewageSelectIndex}"
										style="width: 150px">
										
										<f:selectItems value="#{sewageBean.sewageItem}" />
										<a4j:support event="onchange"
					                    action="#{sewageBean.valuechanged_sewage}"reRender="showcontent"></a4j:support>
									</h:selectOneMenu>
									</rich:panel>
									
									<rich:panel style="width:800px;height:525px;" id ="showcontent">
								<f:facet name="header">
								<h:panelGroup  >
									<table>
										<tr>
											<td>
												<h:outputText value="#{sewageBean.sewageSelectName}站点详情" styleClass="panel-title" ></h:outputText>
											</td>
										</tr>
									</table>
								</h:panelGroup>
							</f:facet>
							
							<table width="700px" border="0" cellpadding="1" cellspacing="1" bgcolor="#000000">
													<tr align="center" bgcolor="#FFFFFF">
													<td bgcolor="#FFFFFF"><h:outputText value='设备一名称'/></td>
													<td bgcolor="#FFFFFF"><h:outputText value="#{sewageBean.equipment1state eq '1' ? '运行':(sewageBean.equipment1state eq '2' ? '停止':(sewageBean.equipment1state eq '3' ? '故障':'未安装'))}"/></td>
													<td bgcolor="#FFFFFF"><h:outputText value='启动/停止'/></td>
													<td bgcolor="#FFFFFF"><h:outputText value='检测一名称'/></td>
													<td bgcolor="#FFFFFF"><h:outputText value="#{sewageBean.detection1}"/></td>
													<td bgcolor="#FFFFFF"><h:outputText value="#{((sewageBean.detection1 < sewageBean.detection1ul) &&(sewageBean.detection1 > sewageBean.detection1dl))?'正常':'超标'}"/></td>
													</tr>
													
													<tr align="center" bgcolor="#FFFFFF">
													<td bgcolor="#FFFFFF"><h:outputText value='设备二名称'/></td>
													<td bgcolor="#FFFFFF"><h:outputText value="#{sewageBean.equipment2state eq '1' ? '运行':(sewageBean.equipment2state eq '2' ? '停止':(sewageBean.equipment2state eq '3' ? '故障':'未安装'))}"/></td>
													<td bgcolor="#FFFFFF"><h:outputText value='启动/停止'/></td>
													<td bgcolor="#FFFFFF"><h:outputText value='检测二名称'/></td>
													<td bgcolor="#FFFFFF"><h:outputText value="#{sewageBean.detection2}"/></td>
													<td bgcolor="#FFFFFF"><h:outputText value="#{((sewageBean.detection2 < sewageBean.detection2ul) &&(sewageBean.detection2 > sewageBean.detection2dl))?'正常':'超标'}"/></td>
													</tr>
													
													<tr align="center" bgcolor="#FFFFFF">
													<td bgcolor="#FFFFFF"><h:outputText value='设备3名称'/></td>
													<td bgcolor="#FFFFFF"><h:outputText value="#{sewageBean.equipment3state eq '1' ? '运行':(sewageBean.equipment3state eq '2' ? '停止':(sewageBean.equipment3state eq '3' ? '故障':'未安装'))}"/></td>
													<td bgcolor="#FFFFFF"><h:outputText value='启动/停止'/></td>
													<td bgcolor="#FFFFFF"><h:outputText value='检测3名称'/></td>
													<td bgcolor="#FFFFFF"><h:outputText value="#{sewageBean.detection3}"/></td>
													<td bgcolor="#FFFFFF"><h:outputText value="#{((sewageBean.detection3 < sewageBean.detection3ul) &&(sewageBean.detection3 > sewageBean.detection3dl))?'正常':'超标'}"/></td>
													</tr>
													
													<tr align="center" bgcolor="#FFFFFF">
													<td bgcolor="#FFFFFF"><h:outputText value='设备4名称'/></td>
													<td bgcolor="#FFFFFF"><h:outputText value="#{sewageBean.equipment4state eq '1' ? '运行':(sewageBean.equipment4state eq '2' ? '停止':(sewageBean.equipment4state eq '3' ? '故障':'未安装'))}"/></td>
													<td bgcolor="#FFFFFF"><h:outputText value='启动/停止'/></td>
													<td bgcolor="#FFFFFF"><h:outputText value='检测4名称'/></td>
													<td bgcolor="#FFFFFF"><h:outputText value="#{sewageBean.detection4}"/></td>
													<td bgcolor="#FFFFFF"><h:outputText value="#{((sewageBean.detection4 < sewageBean.detection4ul) &&(sewageBean.detection4 > sewageBean.detection4dl))?'正常':'超标'}"/></td>
													</tr>
													
													<tr align="center" bgcolor="#FFFFFF">
													<td bgcolor="#FFFFFF"><h:outputText value='设备5名称'/></td>
													<td bgcolor="#FFFFFF"><h:outputText value="#{sewageBean.equipment5state eq '1' ? '运行':(sewageBean.equipment5state eq '2' ? '停止':(sewageBean.equipment5state eq '3' ? '故障':'未安装'))}"/></td>
													<td bgcolor="#FFFFFF"><h:outputText value='启动/停止'/></td>
													<td bgcolor="#FFFFFF"><h:outputText value='检测5名称'/></td>
													<td bgcolor="#FFFFFF"><h:outputText value="#{sewageBean.detection5}"/></td>
													<td bgcolor="#FFFFFF"><h:outputText value="#{((sewageBean.detection5 < sewageBean.detection5ul) &&(sewageBean.detection5 > sewageBean.detection5dl))?'正常':'超标'}"/></td>
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