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
		<script type="text/javascript">
			//执行全选的函数
			function setAllChecked() {
				var oTable = document.all['form1:content:roleTable'];
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
					var oTable = document.all['form1:content:roleTable'];
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
			<title><h:outputText value="#{msgs.userlist}" /></title>
		</head>
		<body>
			<center>
				<h:form id="form1">
					<h:inputHidden id="delDataIDStr"
						value="#{roleBean.delDataIDStr}" />	
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
																	<h:outputText value="#{msgs.rolelist}" styleClass="panel-title"/>
																</td>
															</tr>
														</table>
													</h:panelGroup>
												</f:facet>
												<rich:dataTable id="roleTable" rows="16"
													value="#{roleBean.listDateModel}" var="role"
													rowClasses="tr-list-kisuu,tr-list-guusuu"
													headerClass="td-list-caption"
													width="96%" align="center">
		                                            <!-- checkbox -->
		                                            <rich:column>
		                                            	<f:facet name="header">
														    <h:outputText />
														</f:facet>
														<h:selectBooleanCheckbox id="checkall" />
													</rich:column>
													
													<!-- 角色名 -->
													<rich:column sortBy="#{role.name}">
														<f:facet name="header">
														    <h:outputText value="#{msgs.rolename}"/>
														</f:facet>
														<h:commandLink action="#{roleBean.editRoleAction}">
															<h:outputText value="#{role.name}"/>
															<f:param name="roleId" value="#{role.roleid}"/>
														</h:commandLink>
													</rich:column>																										
													
												</rich:dataTable>
												<br/>
												<table width="96%" align="center" bgcolor="#F0F5FD">
													<tr>
														<!-- 全选  -->
														<td width="7%" align="center">
															<h:selectBooleanCheckbox id="selectall"
																onclick="setAllChecked()">
															</h:selectBooleanCheckbox>
															<h:outputText value="#{msgs.selectall}" style="text-align: center"></h:outputText>
														</td>
														<td width="6%" align="center">
															<h:commandButton value="#{msgs.delete}"
															    onclick="return getSelected();"
																action="#{roleBean.deleteByIDs}" style="height: 25px; width: 40px">
															</h:commandButton>
														</td>
														<td width="6%" align="center">
															<h:commandButton value="#{msgs.add}"
																action="#{roleBean.addRoleAction}" style="height: 25px; width: 40px">
															</h:commandButton>
														</td>
														<td width="6%" align="center">
															<input type="button" value="返回"
																style="height: 25px; width: 40px"
																onClick="window:location.href='<%=request.getContextPath()%>/home.faces'">															
														</td>														
														<!-- 分页组件  -->
														<td width="75%">
												            <rich:datascroller for="roleTable" maxPages="10" align="right">
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
