<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>考试成绩</title>
<script src="../easyui/jquery.min.js"></script>
<style>
	#main{
		width:980px;
		height:300px;
		margin:0px auto;
	}
	#tab{
		width:300px;
		height:130px;
		margin:0px auto;
	}
</style>
</head>
<body>
	<div id="app">
		<div id="header"></div>
		<div id="main">
			<div id="tab">
				<h2>成绩信息</h2>
				<p>用户账号：${record.userId }</p>
				<p>试卷名称：${record.paperName }</p>
				<p id="time"></p>
				<p>分数：${record.score }分</p>
			</div>
		</div>
	</div>
	<script>
		$("#header").load("../header.jsp");
        let time = "考试用时："+(Math.floor(${record.testTime} / 60)) + "分" + (${record.testTime}%60) + "秒";
        $('#time').text(time);
	</script>
</body>
</html>