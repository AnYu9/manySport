<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<head>
<title>Title</title>
</head>
<script src="../easyui/jquery.min.js"></script>
<script src="../easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="../easyui/themes/default/easyui.css">
<link rel="stylesheet" href="../easyui/themes/icon.css">
<body>
<div id="condition">
	jkldfjlskfjkl
<form method="post">
科目：<input id="subject" name="subjectName" value="java"
					style="width: 90px" data-options="limitToList:true,valueField:'subjectName',textField:'subjectName'">
	难度：<select id="difficult"
			class="easyui-combobox" name="difficulty" style="width: 60px;">
			<option value="初级">初级</option>
			<option value="中级">中级</option>
			<option value="高级">高级</option>
		</select>
	题型：<input id="type" name="type" value="选择题" style="width: 65px">
	试题标题：<input name="title" type="text" class="easyui-validatebox"
					data-options=""
					style="width: 200px" />
<span onclick="fun()">搜索</span>
</form>
</div>
	<table id="dg"></table>

	<div id="addDiv">
		<form id="addInforForm" method="post">
			<div>
				科目：<input class="subject" id="subject" name="subjectName" value="1"
					style="width: 90px"> 难度：<select id="difficult"
					class="easyui-combobox" name="difficulty" style="width: 60px;">
					<option value="初级">初级</option>
					<option value="中级">中级</option>
					<option value="高级">高级</option>
				</select> 题型：<input id="type" name="type" value="1" style="width: 65px">
				分数：<input id="score" name="score" value="2" style="width: 50px">
			</div>
			<div>
				试题标题：<input name="title" type="text" class="easyui-validatebox"
					data-options="required:true,missingMessage:'标题不能为空' "
					style="width: 200px" />
			</div>
			<div id="select" style="display: none">
				<p>
					A选项：<input name="a" type="text" class="easyui-validatebox"
						style="width: 200px" />
				</p>

				<p>
					B选项：<input name="b" type="text" class="easyui-validatebox"
						style="width: 200px" />
				</p>

				<p>
					C选项：<input name="c" type="text" class="easyui-validatebox"
						style="width: 200px" />
				</p>

				<p>
					D选项：<input name="d" type="text" class="easyui-validatebox"
						style="width: 200px" />
				</p>
			</div>
			<div>
				正确答案： <input name="result" type="text" class="easyui-validatebox"
					data-options="required:true,missingMessage:'请输入答案选项'"
					style="width: 200px" />
			</div>
		</form>
	</div>

	<div id="updateDiv">
		<form id="updateInforForm" method="post">
			<div>
				科目编号： <input name="topId" type="text" class="easyui-textbox" data-options="readonly:true"
					style="width: 70px">
				科目： <input class="easyui-combobox" style="width: 60px" name="subjectName"
					data-options="valueField:'subjectId',textField:'subjectName',url:'../findAllSubject'" />
				难度： <input class="easyui-combobox" name="difficulty"
					style="width: 60px"
					data-options="limitToList:true,valueField:'value',textField:'value',data:[{value:'初级'},{value:'中级'},{value:'高级'}]">
				题型： <input class="easyui-combobox" name="type" style="width: 60px"
					data-options="limitToList:true,valueField:'id',textField:'text',data:[{id: 1, text: '选择题'}, {id: 2, text: '填空题'}, {id: 3, text: '判断题'}]">
				分数：<input class="easyui-combobox" name="score" style="width: 60px"
					data-options="limitToList:true,valueField:'id',textField:'text',data:[{id: 2, text: '2分'}, {id: 5, text: '5分'}, {id: 10, text: '10分'}]">
			</div>
			<div>
				试题标题： <input name="title" type="text" class="easyui-textbox"
					style="width: 300px">
			</div>
			<div id="select" style="display: none">
				<p>
					A选项： <input name="a" type="text" class="easyui-textbox"
						style="width: 300px">
				</p>

				<p>
					B选项：<input name="b" type="text" class="easyui-textbox"
						style="width: 300px">
				</p>

				<p>
					C选项：<input name="c" type="text" class="easyui-textbox"
						style="width: 300px">
				</p>

				<p>
					D选项：<input name="d" type="text" class="easyui-textbox"
						style="width: 300px">
				</p>
			</div>
			<div>
				正确答案： <input name="result" type="text" class="easyui-textbox"
					style="width: 300px">
			</div>
		</form>
	</div>

</body>
<script src="topicList.js"></script>

</html>