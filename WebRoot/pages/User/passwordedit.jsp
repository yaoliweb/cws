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
</script>
	</head>
	<f:view>
		<title><h:outputText value="修改密码"></h:outputText>
		</title>
		<body>
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
																		<h:outputText value="修改密码"
																			styleClass="panel-title" />
																	</td>
																</tr>
															</table>
														</h:panelGroup>
													</f:facet>

													<rich:tabPanel switchType="client"
														style="width: 500px;height: 380px">
														<rich:tab label="修改密码">
															<table>
																
																<!-- 原始密码 -->
																<tr>
																	<td>
																		<h:outputText value="原始密码："></h:outputText>
																	</td>
																	<td>
																		<h:inputSecret value="#{userBean.oldpassword}"></h:inputSecret>
																	</td>
																</tr>
																<!-- 新密码 -->
																<tr>
																	<td>
																		<h:outputText value="输入新密码："></h:outputText>
																	</td>
																	<td>
																		<h:inputSecret value="#{userBean.newpassword}"></h:inputSecret>
																	</td>
																</tr>
																<!-- 再次新密码-->
																<tr>
																	<td>
																		<h:outputText value="再次输入新密码："></h:outputText>
																	</td>
																	<td>
																		<h:inputSecret value="#{userBean.newpasswordagain}"></h:inputSecret>
																	</td>
																</tr>
															</table>
															<h:messages styleClass="error-msg" globalOnly="true" />
														</rich:tab>
														
													
													</rich:tabPanel>
													<br/>
													<div align="left">
														<h:commandButton value="#{msgs.submit}"
															action="#{userBean.changePasswordAction}"
															onclick="return getSelected();"
															style="height: 25px; width: 40px" />
														<input type="button" value="返回"
															style="height: 25px; width: 40px"
															onClick="window:location.href='<%=request.getContextPath()%>/home.faces'">
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