<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<link rel="stylesheet" type="text/css" href="<%=basePath %>css/water.css">

<table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="330" valign="top"><img src="<%=basePath %>images/index_02.jpg" alt="" /></td>
    <td width="670" background="<%=basePath %>images/index_04.jpg">
    <table width="628" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="628" height="32" align="right" valign="bottom" background="<%=basePath %>images/index_06.jpg" style="background-position:right; background-repeat:no-repeat;">
        <table width="40%" border="0" cellspacing="0" cellpadding="0">
          <tr>
           <td height="24" width="60%" align="right"><div id="webjx"> </div></td>
          </tr>
        </table>
        </td>
      </tr>
    </table>
    <table width="100%" height="51" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td align="center" valign="middle" style="font-size:18px;align:left;text-shadow:Red;font-family:'黑体';" width="240">
            <h:outputText value="#{msgs.sws1}"></h:outputText>
            <h:outputText value="#{msgs.sws2}"></h:outputText> 
            </td>
            <td align="center" valign="middle">
            <a target="_blank" href="http://www.sunda.zj.cn"><img src="<%=basePath %>images/sdnum_1.jpg" width="95" height="39" border="0" /></a>
            <a href="<%=basePath %>/help.faces"><img src="<%=basePath %>images/sdnum_2.jpg" width="95" height="39" border="0" /></a>
            <a href="<%=basePath %>/contact.faces"><img src="<%=basePath %>images/sdnum_3.jpg" width="95" height="39" border="0" /></a>
            <h:commandButton id="button" action="#{userBean.logoutAction}" image="/images/sdnum_4.jpg" style="height: 39px; width: 95px; vertical-align: top"/>
            </td>
          </tr>
      </table>
      </td>
  </tr>
</table>
<script>setInterval("webjx.innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000); </script>
