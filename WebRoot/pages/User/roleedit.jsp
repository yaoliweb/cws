<%@ page language="java" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<f:loadBundle basename="cn.zj.sunda.water.bundle.Messages_zh_CN"
			var="msgs" />
		<link rel="stylesheet" type="text/css" href="/css/water.css">

		<script type="text/javascript"
			src="<%=basePath%>jquery/jquery-1.5.1.js">
</script>
		<script type="text/javascript">
jQuery.noConflict();//��JSF������Ҫ��仰����Ȼ���г�ͻ
jQuery(document).ready(function() {
	// Add click event listener to each checkbox in the tree page
		// Note! Using this simple selector assumes that there are no other 
		// checkboxes on the page, if there are other checkboxes then
		// selector should be changed    
		jQuery(":checkbox").click(function() {
			updateChildren(this);

		});
	});
function updateChildren(currentCheckBox) {
	// Get state of current checkbox (true or false)
	var state = currentCheckBox.checked;

	// Get parent TABLE, where current checkbox is places
	var parentTables = jQuery(currentCheckBox).parents("table");
	var parentTable = parentTables[0];

	// Get DIV where child nodes with checkboxes are situated
	// See http://docs.jquery.com/Traversing/ to get better uderstanding of
	// parents() and next()        
	var childDivs = jQuery(parentTable).next("div");
	var childDiv = childDivs[0];

	// Iterate over all child nodes checkboxes and set same state as the 
	// current checkbox state
	jQuery(childDiv).contents().find(":checkbox").each(function() {
		this.checked = state;
	});
}
</script>
	</head>
	<f:view>
		<title><h:outputText value="#{msgs.roleedit}"></h:outputText>
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
									<table id="table2">
										<tr>
											<td>
												<rich:panel style="width:800px;height:600px;">
													<f:facet name="header">
														<h:panelGroup>
															<table>
																<tr>
																	<td width="800px">
																		<h:outputText value="#{msgs.roleedit}"
																			styleClass="panel-title" />
																	</td>
																</tr>
															</table>
														</h:panelGroup>
													</f:facet>
													<table>
														<!-- ��ɫ�� -->
														<tr>
															<td>
																<h:outputText value="#{msgs.rolename}"></h:outputText>
															</td>
															<td>
																<h:inputText id="rolename" value="#{roleBean.name}">
																	<f:validateLength minimum="1"></f:validateLength>
																</h:inputText>
																<font color="red">*</font>
															</td>
														</tr>
														<h:messages styleClass="error-msg" globalOnly="true" />

													</table>

													<rich:panel id="prilivigePanel" style="width:270px;">

														<div
															style="overfolw: auto; width: 300px; height: 450px; OVERFLOW-y: auto; OVERFLOW-x: auto">
															<rich:tree id="privilegetree" switchType="client"
																value="#{menuBean.menuTreeNode}" var="item"
																style="width:120px">
																<rich:treeNode id="tree">
																	<h:selectBooleanCheckbox id="pri"
																		value="#{item.selected}" />
																	<h:outputText value="#{item.name}" />
																</rich:treeNode>
															</rich:tree>
														</div>
													</rich:panel>
													<br/>
													<div align="left">
														<h:commandButton value="#{msgs.submit}"
															action="#{roleBean.editRoleSuccessAction}"
															style="height: 25px; width: 40px" />
														<input type="button" value="����"
															style="height: 25px; width: 40px"
															onClick="window:location.href='rolemanager.faces'">
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