<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="../css/header.css">
</head>
<body>
	<div id="tt">
		<div id="logo">
			<a href="#"> <img src="../img/logo.png" style="height: 45px;" />
			</a>
		</div>
		<ul id="info" style="margin-top: 0px;">
			<li style="margin-top: 12px;">亲爱的 <a href="#"><span
					style="color: rgb(142, 202, 194)">${user.userName}</span></a> 欢迎您！
			</li>
			<li><a href="#"> <img src="../img/headImg/${user.headImg}" width=40
					height=40 style="border-radius: 50%; margin-top: 5px;" />
			</a></li>
			<li style="margin-top: 12px;"><a href="../personalCenter.html">个人中心</a></li>
			<li style="margin-top: 12px;"><a href="../system/logoutUser">注销</a></li>
		</ul>
	</div>
</body>
</html>