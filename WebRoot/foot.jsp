<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<center>
	<table>
		<tr>
			<td width="1000px"><hr></td>
		</tr>
		<tr>
			<td width="1000px" align="left">
				<table width="25%">
					<tr>
						<td width="50%" height="24" align="left" valign="top"><font face="Arial, Helvetica"><h:outputText value="#{msgs.username}：#{userBean.cname1}"></h:outputText></font></td>
						<td width="50%" height="24" align="left" valign="top"><font face="Arial, Helvetica"><h:outputText value="#{msgs.dept}：#{userBean.dept1}"></h:outputText></font></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>		
</center>