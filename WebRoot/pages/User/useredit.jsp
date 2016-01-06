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
		<script type="text/javascript">
function getSelected() {
	var theSelected = "";
	var i = 1;
	var arraySelected = new Array();
	var oTable = document.all['form1:content:roleTable'];
	if (oTable != null) {
		for (j = 1; j < oTable.rows.length; j++) {
			if (oTable.rows(j).cells(0).children.item(0).checked
					&& oTable.rows(j).cells(1).innerText != null) {

				theSelected += oTable.rows(j).cells(1).innerText + '@';

			} else {
				i = i + 1;
			}
		}

		if (i == j) {
			confirm('没有选择角色!');
			return false;
		} else {
			theSelected = theSelected.substr(0, theSelected.length - 1);
			document.getElementById("form1:content:roleIDStr").value = theSelected;
		}
	}
}
function setSelected() {
	var theSelected = "";
	var i = 1;
	var rolename=document.getElementById("roleName").innerHTML.replace(" ", "");
	//alert(rolename);
	var arraySelected = new Array();
	var oTable = document.all['form1:content:roleTable'];
	if (oTable != null) {
		for (j = 1; j < oTable.rows.length; j++) {
			if (oTable.rows(j).cells(2).innerText==rolename) {
				oTable.rows(j).cells(0).children.item(0).checked=true;

			} 
			
		}
	}
}
</script>
	</head>
	<f:view>
		<title><h:outputText value="#{msgs.useredit}"></h:outputText>
		</title>
		<body onload="setSelected()">
			<center>
				<h:form id="form1">
					<table id="table1">
						<tr>
							<c:import url="/top.jsp" />
						</tr>

						<tr>
							<h:panelGrid columns="2">
								<f:subview id="menu">
									<c:import url="/menu.jsp" />
								</f:subview>
								<f:subview id="content">
									<h:inputHidden id="roleIDStr" value="#{userBean.selectroleIDStr}" />
									<table id="table2">
										<tr>
											<td>
												<rich:panel style="width:800px;height:600px;">
													<f:facet name="header">
														<h:panelGroup>
															<table>
																<tr>
																	<td width="800px">
																		<h:outputText value="#{msgs.useredit}"
																			styleClass="panel-title" />
																	</td>
																</tr>
															</table>
														</h:panelGroup>
													</f:facet>

												
															<table>
																<!-- 登录名 -->
																<tr>
																	<td>
																		<h:outputText value="#{msgs.logid}："></h:outputText>
																	</td>
																	<td>
																		<h:inputText id="logid" readonly="true" value="#{userBean.username}">
																			<f:validateLength minimum="1"></f:validateLength>
																		</h:inputText>
																		<font color="red">*</font>
																		<h:outputText value="#{msgs.thesame}" />
																		<h:message for="logid"></h:message>
																	</td>
																</tr>
																<!-- 姓名 -->
																<tr>
																	<td>
																		<h:outputText value="#{msgs.username}："></h:outputText>
																	</td>
																	<td>
																		<h:inputText value="#{userBean.cname}"></h:inputText>
																	</td>
																</tr>
																<!-- 部门 -->
																<tr>
																	<td>
																		<h:outputText value="#{msgs.dept}："></h:outputText>
																	</td>
																	<td>
																		<h:inputText value="#{userBean.dept}"></h:inputText>
																	</td>
																</tr>
																<!-- 联系电话-->
																<tr>
																	<td>
																		<h:outputText value="#{msgs.tel}："></h:outputText>
																	</td>
																	<td>
																		<h:inputText value="#{userBean.tel}"></h:inputText>
																	</td>
																</tr>
																<!-- 角色-->
																<tr>
																	<td>
																		<h:outputText value="角色："></h:outputText>
																	</td>
																	<td>
																		<h:outputText id="showsuperrole" value="#{userBean.roleSelectName}" style="width: 150px"></h:outputText>
																	</td>
																</tr>
																<tr>
																	<td>
																		<h:outputText value="更改角色：" ></h:outputText>
																	</td>
																	<td colspan="1">
																		<h:selectOneMenu value="#{userBean.roleSelectIndex}"
																			style="width: 150px">
																			<f:selectItems value="#{userBean.roleItem}" />
																			<a4j:support event="onchange"
																				action="#{userBean.valuechange_role}"
																				reRender="showsuperrole"></a4j:support>
																		</h:selectOneMenu>
																	</td>
																</tr>
															</table>
															<h:messages styleClass="error-msg" globalOnly="true" />
														
													<br/>
													<div align="left">
														<h:commandButton value="#{msgs.submit}"
															action="#{userBean.editUserSuccessAction}"
															onclick="return getSelected();"
															style="height: 25px; width: 40px" />
														<input type="button" value="返回"
															style="height: 25px; width: 40px"
															onClick="window:location.href='usermanager.faces'">
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