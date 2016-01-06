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
															<h:outputText value="#{DeviceBean.newSewageSelectName}维修记录单"
																styleClass="panel-title"></h:outputText>
														</td>
													</tr>
												</table>
											</h:panelGroup>
										</f:facet>
										<!-- 记录列表 -->
										<table align="center">
											<tr>
												<td style="color: #000812;font-size: 20px; font-weight: bold;" width=800 align="center">
													<h:outputText  value="设备维护保养记录单详情"/>
												</td>
											</tr>
										</table>
										<table align="center">
											<tr>
												<td style="color: #000812;font-size: 20px;" width=650 align="right">
													<h:outputText  value="编号:"/>
												</td>
												<td style="color: #000812;font-size: 15px;" width=150 align="left">
													<h:outputText  value="#{DeviceBean.serialNumber}"/>
												</td>
											</tr>
										</table>
										<table style="border: #000000; border-style: solid; border-width: 0px;background-color:#CAE8EA;border-collapse:collapse" align="center" cellpadding=0 cellspacing=0>
											<tr>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=65 height=30 align="left">
													<h:outputText  value="项目编号:"/>
												</td>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=186 align="left">
													<h:outputText  value="#{DeviceBean.projectSerialNumber}"/> 
												</td>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=65 height=30 align="left">
													<h:outputText  value="项目名称:"/>
												</td>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=185 align="left">
													<h:outputText  value="#{DeviceBean.projectName}"/>
												</td>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=36 align="left">
													<h:outputText  value="地点:"/>
												</td>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=210 align="left">
													<h:outputText  value="#{DeviceBean.site}"/> 
												</td>
											</tr>
											<tr>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=65 align="left">
													<h:outputText  value="日期:"/>
												</td>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=186 align="left">
													<h:outputText  value="#{DeviceBean.time}"/> 
												</td>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=65 align="right">
													<h:outputText  value="上次保养时间:"/>
												</td>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=185 align="left">
													<h:outputText  value="#{DeviceBean.lastRepairTime}"/> 
												</td>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=36 align="left">
													<h:outputText  value="保养耗时:"/>
												</td>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=210 align="left">
													<h:outputText  value="#{DeviceBean.consumeTime}"/> 
												</td>
											</tr>
										</table>
										<table style="border: #000000; border-style: solid; border-width: 0px;background-color:#CAE8EA;border-collapse:collapse" align="center" cellpadding=0 cellspacing=0>
											<tr>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=65 height=60 align="left">
													<h:outputText  value="保养原因:"/>
												</td>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=686 align="left">
													<h:inputTextarea style="background-color:#CAE8EA;width:686px;height:60px;border:0;" readonly="true"  value="#{DeviceBean.repairReason}"/> 
												</td>
											</tr>
											<tr>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=65 height=60 align="left">
													<h:outputText  value="保养内容:"/>
												</td>
												<td  style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=686 align="left">
													<h:inputTextarea style="background-color:#CAE8EA;width:686px;height:60px;border:0;" readonly="true" value="#{DeviceBean.repairContent}"/> 
												</td>
											</tr>
											<tr>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=65 height=60 align="left">
													<h:outputText  value="消耗材料:"/>
												</td>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=686 align="left">
													<h:inputTextarea style="background-color:#CAE8EA;width:686px;height:60px;border:0;" readonly="true" value="#{DeviceBean.consumeMaterial}"/>
												</td>
											</tr>
											<tr>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=65 height=60 align="left">
													<h:outputText  value="意见反馈:"/>
												</td>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=686 align="left">
													<h:inputTextarea style="background-color:#CAE8EA;width:686px;height:60px;border:0;" readonly="true" value="#{DeviceBean.feedBack}"/>
												</td>
											</tr>
										</table>
										<table style="border: #000000; border-style: solid; border-width: 0px;background-color:#CAE8EA;border-collapse:collapse" align="center" cellpadding=0 cellspacing=0 >
											<tr>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=65 height=30 align="left">
													<h:outputText  value="维修人员:"/>
												</td>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=309 align="left">
													<h:outputText  value="#{DeviceBean.repairMan}"/>
												</td>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=65 height=30 align="left">
													<h:outputText  value="业主确认:"/>
												</td>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=310 align="left">
													<h:outputText  value="#{DeviceBean.proprietorConfirm}"/>
												</td>
											</tr>
											<tr>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=65 height=30 align="left">
													<h:outputText  value="主管签字:"/>
												</td>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=309 align="left">
													<h:outputText  value="#{DeviceBean.directorName}"/>
												</td>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=65  height=30 align="left">
													<h:outputText  value="完成时间:"/>
												</td>
												<td style="color: #000812;font-size: 15px;border-right:1px solid gray;border-bottom:1px solid gray;border-left:1px solid gray;border-top:1px solid gray;" width=310 align="left">
													<h:outputText  value="#{DeviceBean.completeTime}"/>
												</td>
											</tr>
										</table>
										<table width="95%" align="center" bgcolor="#F0F5FD">
											<tr>
												<td width="6%" align="center">
													<input type="button" value="返回"
														style="height: 25px; width: 40px"
														onClick="window:location.href='<%=request.getContextPath()%>/pages/work/devicedoc.faces'">															
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