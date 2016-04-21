<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		$.ajax({
			type : "POST",
			cache : "false",
			url : "<%=basePath%>user/getAllUsers.do", 		
					dataType : "json",
					error : function() {//请求失败时调用函数。  
						$("#msg").html("请求失败!");
					},
					success : function(data) {
						var html;
						if (data.success) {
							for ( var i in data.message) {
								var user = data.message[i];
								html = html + "<tr><td width='50'>" + user.id
										+ "</td><td width='100'>"
										+ user.username
										+ "</td><td width='100'>"
										+ user.password + "</td></tr>";
							}
						} else {
							html = "用户列表不存在！";
						}
						$("#userlist").html(html);
					}
				});
			});
</script>
</head>

<body>

	<table width="250">
		<tr width="250">
			<td width="50">编号</td>
			<td width="100">用户名</td>
			<td width="100">密码</td>
		</tr>
		<table width="250" id="userlist" style="color: red" />
	</table>
</body>
</html>
