<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../easyui/jquery.min.js" charset="UTF-8"></script>
<script src="../easyui/jquery.easyui.min.js" charset="UTF-8"></script>
<link rel="stylesheet" href="../easyui/themes/default/easyui.css">
<link rel="stylesheet" href="../easyui/themes/icon.css">
<style>
.questClass {
	display: block;
	float: left;
	text-align: center;
	border-radius: 3px;
	background: green;
	color: white;
	margin: 5px 10px;
	width: 80px;
	line-height: 30px;
}

.questClass:focus {
	background: #00bbee;
}

#conditionDiv span {
	width: 20px;
	height: 20px;
	border: 1px red solid;
}
</style>
</head>
<body>
	<div id="conditionDiv">
		<form>
			科目：<input name="subjectName" value="java"
					style="width: 90px" data-options="limitToList:true,valueField:'subjectName',textField:'subjectName'"> 
			试卷名称：<input name="paperName"
				type="text" class="easyui-validatebox" data-options=""
				style="width: 200px" /> 
			考试时长：<input name="testdate" value="45"
				style="width: 65px"> 
			分数：<input name="testSource" value="100"
				style="width: 50px"> 
			<span onclick="fun2()">查询</span>
		</form>
	</div>
	<table id="dg"></table>
	<div id="addDiv">
		<form id="addInforForm" method="post">
			<div>
				科目：<input class="subjectName" name="subjectName" value="1"
					style="width: 90px"> <br />
				<br /> 
				试卷名称：<input name="paperName" type="text"
					class="easyui-validatebox"
					data-options="required:true,missingMessage:'标题不能为空' "
					style="width: 200px" /> 
				考试截止日期：<input class="easyui-datebox" name="testEnd"
					data-options="formatter:myformatter,parser:myparser,required:true,missingMessage:'日期不能为空'"
					style="width: 100px"> <br />
				<br /> 
				考试时长：<input name="testdate" value="45" style="width: 65px">
				<br />
				<br /> 
				分数：<input name="testSource" value="100" style="width: 50px">

				<br />
				<br /> 
				已选分数：<b style="text-align: center">0</b> <br /> <input
					type="text" name="anwer" style="display: none" /> 
				已选：<i>0</i>题
				 <a id="btn">添加试题</a> <a id="btn2">重新选择</a>
			</div>
		</form>
	</div>

	<div id="updateDiv">
		<form id="updateInforForm" method="post">
			<br />
			<br /> 试卷编号： <input name="paperId" type="text" class="easyui-textbox"
				data-options="readonly:true" style="width: 70px"> <br />
			<br /> 试题标题： <input name="paperName" type="text"
				class="easyui-textbox" style="width: 300px"> <br />
			<br /> 考试截止日期：<input class="easyui-datebox" name="testEnd"
				data-options="formatter:myformatter,parser:myparser"
				style="width: 100px"> 科目：<input class="subjectName"
				name="subjectName" style="width: 90px"> 考试时长：<input
				name="testdate" style="width: 65px">
		</form>
	</div>

	<div id="topicList">
		科目：<input class="conditionSubjectName" name="subjectName" value="java"
			style="width: 90px"> 难度：<select id="difficult"
			class="easyui-combobox" name="difficulty" style="width: 60px;">
			<option value="初级">初级</option>
			<option value="中级">中级</option>
			<option value="高级">高级</option>
		</select>
		<table id="topics"></table>
	</div>
</body>
<script type="text/javascript" src="paper.js">
	
</script>
</html>