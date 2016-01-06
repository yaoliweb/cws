<%@ page language="java" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- f，h 用来引用 JSF 的控件，a4j 和 rich 用来引用 Ajax4JSF 和 RichFaces 控件 -->

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
	var oTable = document.all['form1:content:roleTable']; //document.all[]提供对文档中所有 HTML 元素的访问
	if (oTable != null) {
		for (j = 1; j < oTable.rows.length; j++) {
			if (oTable.rows(j).cells(0).children.item(0).checked      //cells 集合返回表格中所有单元格的一个数组
					&& oTable.rows(j).cells(1).innerText != null) {

				theSelected += oTable.rows(j).cells(1).innerText + '@';

			} else {
				i = i + 1;
			}
		}

		if (i == j) {
			confirm('没有选择角色!');//HTML DOM confirm()方法,用于显示一个带有指定消息和 OK 及取消按钮的对话框
			                        //用户点击确定按钮，则 confirm()返回 true,点击取消按钮，则返回 false
			return false;
		} else {
			theSelected = theSelected.substr(0, theSelected.length - 1);//substr()方法可在字符串中抽取从 start下标开始的指定数目的字符
			document.getElementById("form1:content:roleIDStr").value = theSelected;
		}
	}
}
</script>
	</head>
	<f:view>
		<title><h:outputText value="#{msgs.useradd}"></h:outputText>
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
																		<h:outputText value="#{msgs.useradd}"
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
																		<h:inputText id="logid" value="#{userBean.username}">
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
																<!-- 角色授权 -->
																<tr>
																	<td>
																		<h:outputText value="角色："></h:outputText>
																	</td>
																	<td>
																		<h:selectOneMenu value="#{userBean.roleSelectIndex}"
																			style="width: 150px">
																			<f:selectItems value="#{userBean.roleItem}" />
																			<a4j:support event="onchange"
																				action="#{userBean.valuechange_role}"
																				reRender="showsuperarea"></a4j:support>
																		</h:selectOneMenu>
																	</td>
																</tr>
														</table>
														<h:messages styleClass="error-msg" globalOnly="true" />
													<br/>
													<div align="left">
														<h:commandButton value="#{msgs.submit}"
															action="#{userBean.addUserSuccessAction}"
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