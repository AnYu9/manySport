<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>科目列表</title>
</head>
<script src="../easyui/jquery.min.js"></script>
<script src="../easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="../easyui/themes/default/easyui.css">
<link rel="stylesheet" href="../easyui/themes/icon.css">
<body>

	<table id="dg"></table>

	<div id="addDiv">
		<form id="addInforForm" method="post">
			<p>
				科目名：<input class="easyui-textbox" name="subjectName"
					data-options="width:50" />
			</p>
		</form>
	</div>

	<div id="updateDiv">
		<form id="updateInforForm" method="post">
			<p>
				科目id：<input class="easyui-textbox" name="subjectId"
					data-options="width:50,readonly:true" />
			</p>
			<p>
				科目名：<input class="easyui-textbox" name="subjectName"
					data-options="width:50" />
			</p>
		</form>
	</div>

</body>
<script src="subjectList.js"></script>
</html>