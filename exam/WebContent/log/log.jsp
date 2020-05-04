<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="../easyui/jquery.min.js"charset="UTF-8"></script>
	<script src="../easyui/jquery.easyui.min.js"charset="UTF-8"></script>
	<link rel="stylesheet" href="../easyui/themes/default/easyui.css">
	<link rel="stylesheet" href="../easyui/themes/icon.css">
</head>
<body>
	<table id="dg"></table>
	
	
	<script type="text/javascript">
		$('#dg').datagrid({    
		    url:'../log/queryAll',    
		    columns:[[
		    	{field:'classChe',checkbox:true},
		        {field:'logId',title:'编号',width:100},    
		        {field:'logdes',title:'日志详细',width:100},    
		        {field:'userId',title:'操作用户账号',width:100},
		        {field:'userId',title:'操作用户账号',width:100}
		    ]],
		    pagination:true
		});
		$("#dg").datagrid("getPager").pagination({
		    pageSize: 5,//每页显示的记录条数，默认为10
		    pageList: [5, 10, 15],//可以设置每页记录条数的列表
		    beforePageText: '第',//页数文本框前显示的汉字
		    afterPageText: '页    共 {pages} 页',
		    displayMsg: '当前显示 {from} 到 {to} 条记录   共 {total} 条记录',
		});
	</script>
</body>
</html>