<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	//设置无缓存
	response.addHeader("Progma","no-cache");
	response.setHeader("Cache-Control","no-cache");
	response.setDateHeader("Expires",0);
	response.setHeader("Pragma", "no-cache");   
response.setHeader("Cache-Control", "no-store");  
response.setHeader("Cache-Control", "must-revalidate");
%>
<!DOCTYPE HTML>
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/water.css">
		<link rel="stylesheet" href="<%=basePath%>jquery/jquery.ui.all.css">
		<link rel="stylesheet" href="jquery/demos.css">
		<script src="<%=basePath%>jquery/jquery-1.5.1.js">
</script>
		<script src="<%=basePath%>jquery/jquery.bgiframe-2.1.2.js">
</script>
		<script src="<%=basePath%>jquery/jquery.ui.core.js">
</script>

		<script src="<%=basePath%>jquery/jquery.ui.widget.js">
</script>
		<script src="<%=basePath%>jquery/jquery.ui.mouse.js">
</script>
		<script src="<%=basePath%>jquery/jquery.ui.button.js">
</script>
		<script src="<%=basePath%>jquery/jquery.ui.draggable.js">
</script>
		<script src="<%=basePath%>jquery/jquery.ui.position.js">
</script>
		<script src="<%=basePath%>jquery/jquery.ui.resizable.js">
</script>

		<script src="<%=basePath%>jquery/jquery.ui.dialog.js">
</script>
		<script src="<%=basePath%>jquery/jquery.effects.core.js">
</script>
		<style>
body {
	font-size: 90%;
	align:center;
}

label,input {
	display: block;
}

input.text {
	margin-bottom: 8px;
	width: 90%;
	padding: .4em;
}

fieldset {
	width:34%;
	height:330px;
	padding-top: 25px;
	padding-left: 25px;
	padding-bottom: 10px;
	border: 1px black;	
	margin-top: 25px;
}

h1 {
	font-size: 1.2em;
	margin: .6em 0;
}

div#dialog-form{
	width:900px;
	height:600px;
	background-image:url(images/7.jpg);
	background-repeat:repeat;
	margin:0 auto;
	padding-top:4cm;
	padding-left:6cm;
}

div#users-contain {
	width: 350px;
	margin: 20px 0;
}

div#users-contain table {
	margin: 1em 0;
	border-collapse: collapse;
	width: 100%;
}

div#users-contain table td,div#users-contain table th {
	border: 1px solid #eee;
	padding: .6em 10px;
	text-align: left;
}

.ui-dialog .ui-state-error {
	padding: .3em;
}

.validateTips {
	border: 1px transparent;
	padding: 0.3em;
}
</style>
<script>
$(function() {
	// a workaround for a flaw in the demo system (http://dev.jqueryui.com/ticket/4375), ignore!
	$("#dialog:ui-dialog").dialog("destroy");

	var name = $("#name"), password = $("#password"), verifyCode = $("#verifyCode"), allFields = $(
			[]).add(name).add(password).add(verifyCode), tips = $(".validateTips");
         
	function updateTips(t) {
		tips.text(t).addClass("ui-state-highlight");
		setTimeout(function() {
			tips.removeClass("ui-state-highlight", 1500);
		}, 500);
	}

	function checkLength(o, n, min, max) {
		if (o.val().length > max || o.val().length < min) {
			o.addClass("ui-state-error");
			updateTips(n + " 长度必须在 " + min + " 到 " + max + "之间");
			return false;
		} else {
			return true;
		}
	}

	function checkNull(o, n) {
		if (o.val().length == 0) {
			o.addClass("ui-state-error");
			updateTips("请输入" + n);
			return false;
		} else {
			return true;
		}

	}

	/*$("#dialog-form").dialog( {
		autoOpen : true,
		height : 550,
		width : 800,
		modal : true,
		buttons : {
		/*"登录": function() {
			$( "#mainform:submit" ).toString();
		},
		取消: function() {
			$( "#dialog-confirm" ).dialog( "open" );
		}*/
		/*},
		close : function() {
			allFields.val("").removeClass("ui-state-error");
			window.close();
		}
	});
    */
	$("#dialog-confirm").dialog( {
		autoOpen : false,
		resizable : false,
		height : 200,
		modal : true,
		buttons : {
			"确定" : function() {
				//window.close();
			$(this).dialog("close");
		},
		取消 : function() {
			$(this).dialog("close");
		}
		}
	});

	$(function() {
		$("#radio").buttonset();
	});

});

//更换验证码
function changeVerifyCode() {
	//如果用<img>实现，则修改<img src=url>的url
	//如果给url赋相同的值，浏览器不会重新发出请求，因此用js生成一个即时毫秒数做url中的参数
	t = new Date().getTime();
	document.getElementById('verifyCodeImg').src = "<%=basePath%>servlet/verifyCodeServlet.servlet?t="
			+ t;
}
</script>

<f:loadBundle basename="cn.zj.sunda.water.bundle.Messages_zh_CN" var="msgs" />

<script language="javascript">
 function check()
 {

  //keyCode是event事件的属性,对应键盘上的按键,回车键是13,tab键是9,其它的如果不知道 ,查keyCode大全
  if(event.keyCode==13&&(event.srcElement.type=="text"||event.srcElement.type=="password"
                         ||event.srcElement.type=="radio"||event.srcElement.type=="" ))
  {
     //srcElement是触发事件的对象,type意思是什么类型
     event.keyCode=9;
  }
 }
 //document.onkeydown=check;
 function   document.onkeydown()   
{   
var   e=event.srcElement;   
if(event.keyCode==13)   
{   
document.getElementById( "mainform:submit").click();   
return   false;   
}   
}   
</script> 
</head>
<f:view>
		<title><h:outputText value="#{msgs.swslogin}" />
		</title>
		<body>
			<div class="demo">
				<!--  
				<img alt="logo" src="<%=basePath%>images/logo1.jpg">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<img alt="logo" src="<%=basePath%>images/sy_04.jpg">
				-->
				<div id="dialog-form">
					<!--  
					<p class="validateTips">
						<h:outputText value="#{msgs.please}" />
					</p>
					-->
					<h:form id="mainform">
						<fieldset>
						    <legend style="font-weight: bold">用户登录：</legend>
							<br/>
							<h:outputText id="name" value="#{msgs.user}" />
							<h:inputText value="#{userBean.username}" id="username"
								styleClass="text ui-widget-content ui-corner-all"
								required="true" tabindex="1"/>
							<h:message styleClass="errorMessage" for="username" />
							<br/>
							<h:outputText value="#{msgs.password}" />
							<h:inputSecret value="#{userBean.password}" id="password"
								styleClass="text ui-widget-content ui-corner-all"
								required="true" tabindex="2"/>
							<h:message styleClass="errorMessage" for="password" />
							<br/>
							<h:outputText value="#{msgs.validateCode}" />
							<img name="verifyCodeImg" id="verifyCodeImg" alt="verifyCode"
								src="<%=basePath%>servlet/verifyCodeServlet.servlet"
								onclick="changeVerifyCode();" >
							<a href="#" onclick="changeVerifyCode();"><font color="blue">
							<h:outputText value="#{msgs.notClear}" />
							</font>
							</a>
							<h:inputText size="4" id="uservalidate"
								value="#{userBean.validateCode}"
								styleClass="text ui-widget-content ui-corner-all" tabindex="3"/>
							<br />	
							<h:messages styleClass="error-msg" globalOnly="true" />					
							
							<script language="JavaScript">
								for ( var i = 1; i <= 20; i++) {
									document.write("&nbsp;")
								}
							</script>

							<h:commandButton id="submit" value="#{msgs.login}"
								action="#{userBean.loginAction}"
								styleClass="ui-button ui-buttonset" tabindex="4" />
							<h:commandButton id="reset" value="#{msgs.reset}"
								action="#{userBean.clear}" styleClass="ui-button ui-buttonset" />
						</fieldset>
					</h:form>
				</div>
				<div id="dialog-confirm"
					title="<h:outputText value='#{msgs.outtip}'/>">
					<p>
						<span class="ui-icon ui-icon-alert"
							style="float: left; margin: 0 7px 20px 0;"></span>
						<h:outputText value="#{msgs.outconfirm}" />
					</p>
				</div>
			</div>
		</body>
	</f:view>
</html>
