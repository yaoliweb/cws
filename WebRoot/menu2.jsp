<%@ page language="java" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<div
	style="overfolw: auto; width: 200px; height: 860px; OVERFLOW-y: auto; OVERFLOW-x: auto">
	<rich:panel>
		<f:facet name="header">
			<h:panelGroup>
				<table>
					<tr>
						<td>
							<h:outputText value="#{msgs.menu}"
								style="color: #0080C0; font-weight: bold"></h:outputText>
						</td>
					</tr>
				</table>
			</h:panelGroup>
		</f:facet>
		<rich:tree value="#{menuBean.menuTreeNode}"
			style="width:150px;height:548px;"
			nodeSelectListener="#{menuBean.processSelection}" switchType="client"
			var="item" toggleOnClick="true">
			<rich:treeNode icon="/images/treeNode.png"
				iconLeaf="/images/treeLeaf.png" iconExpanded="/images/nolines_minus.gif" iconCollapsed="/images/nolines_plus.gif">
				<h:commandLink action="#{menuBean.nodeSelectAction}"
					styleClass="A:link;" disabled="#{item.filename == null}">
					<h:outputText value="#{item.name}" />
					<f:param name="contenturl" value="#{item.filename}"></f:param>
				</h:commandLink>
			</rich:treeNode>
		</rich:tree>
	</rich:panel>
</div>
