<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/base/jquery-1.12.2.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#username").focus();
	});
	function login() {
		var name = $("#username").val();
		if (name.length <= 0) {
			$("#msgName").html("用户名不能用空!");
			return false;
		} else {
			$("#msgName").html("");
		}
		var pass = $(".password").val();
		if (pass.length <= 0) {
			$("#msgPass").html("密码不能为空!");
			return false;
		} else {
			$("#msgPass").html("");
		}

		// 提交到后台进行验证   
		$.ajax({
			type : "POST",
			cache : "false",
			url : "<%=basePath%>user/login.do",
			data : "username=" + name + "&password=" + pass,//发送到服务器的数据   
			dataType : "json",
			error : function() {//请求失败时调用函数。  
				$("#msg").html("请求失败!");
			},
			success : function(data) {
				$("#msg").html(data.message);
			}
		});
		return false;
	};
	
	function look() {
		window.location.href= "<%=basePath%>user/checkResult.do?result=" + $("#msg").text();			
	}
</script>
</head>

<body>
	<table width="488" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="2"><span id="msg" style="color: red"></span></td>
		</tr>
		<tr>
			<td width="92">用户名:</td>
			<td width="280"><input type="text" name="username" id="username">
				<span id="msgName" style="color: red"></span></td>
		</tr>
		<tr>
			<td>密&nbsp;码:</td>
			<td><input type="password" name="password" id="password"
				class="password"> <span id="msgPass" style="color: red"></span>
			</td>
		</tr>
		<tr>
			<td><input type="button" value="登陆" onclick="login();"></td>
			<td id="look" ><input type="button" value="查看" onclick="look();"></td>
		</tr>
	</table>
</body>
</html>
