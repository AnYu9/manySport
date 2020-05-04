<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>近期考试</title>
<script src="../easyui/jquery.min.js" charset="UTF-8"></script>
<script src="../easyui/jquery.easyui.min.js" charset="UTF-8"></script>
<link rel="stylesheet" href="../easyui/themes/default/easyui.css">
<style>
	#app{
		width:980px;
		height:500px;
		margin:0px auto;
	}
	#main{
		width:100%;
		height:100%;
		
	}
	.go{
		text-decoration: none;
		color:black;
	}
	.panel{
		overflow: visible;
	}
	p span{
		width:20px;
		height:20px;
		border-radius: 3px;
		border:1px red;
	}
</style>
</head>
<body>
	<div id="app">
		<div id="header"></div>
		<div id="main">
		<div id="conditionDiv">
			<form>
			<p>
				科目：<input name="subjectName" value="java"
						style="width: 90px" data-options="limitToList:true,valueField:'subjectName',textField:'subjectName'"> 
				试卷名称：<input name="paperName"
					type="text" class="easyui-validatebox" data-options=""
					style="width: 100px" /> 
				考试时长：<input name="testdate" value="45"
					style="width: 65px"> 
				分数：<input name="testSource" value="100"
					style="width: 60px"> 
				<span onclick="fun2()">查询</span>
				</p>
			</form>
		</div>
			<div id='dg'></div>
		</div>
	</div>
</body>

<script>
function fun2(){
	console.log(getFormParam($("#conditionDiv").find("form")));
	$('#dg').datagrid('reload',getFormParam($("#conditionDiv").find("form")));
}

$("input[name='testdate']").combobox({
	valueField : 'id',
	textField : 'text',
	data : [ {
		"id" : 45,
		"text" : "45分钟"
	}, {
		"id" : 60,
		"text" : "60分钟"
	}, {
		"id" : 120,
		"text" : "120分钟"
	} ]
});

$("#conditionDiv input[name='subjectName']").combobox({
	url : '../findAllSubject',
	success:function(){
	}
});

$("input[name='testSource']").combobox({
	valueField : 'id',
	textField : 'text',
	data : [ {
		"id" : 100,
		"text" : "100分"
	} ]
});

$("#header").load("../header.jsp");
$('#dg').datagrid({
	url : '../paper/queryAll',
	type : 'post',
	columns : [ [{
		field : 'paperName',
		title : '试卷名称',
		align:"center",
		width : 100
	},{
		field : 'userName',
		title : '出题人',
		align:"center",
		width : 100
	}, {
		field : 'testEnd',
		title : '考试结束时间',
		align:"center",
		width : 100
	}, {
		field : 'subjectName',
		title : '科目',
		align:"center",
		width : 100
	}, {
		field : 'testdate',
		title : '考试时长',
		align:"center",
		width : 100
	}, {
		field : 'testSource',
		title : '试卷总分',
		align:"center",
		width : 100
	} , {
		field : 'btn',halign:"center",align:"center",
		title : '考试操作',
		width : 100,
    	formatter: function(value,row,index){
    		var date = new Date();
			var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate();
			var time = y+"-"+m+"-"+d;
			/*
			用试卷日期   判断试卷是否超过有效时间
			*/
			var isTrue = ( (new Date(row.testEnd) > new Date(time)));
			if(isTrue){
				let enableBtn="<a class='go' href='../paper/findById?id="+row.paperId+"' style='color:green'>进入考试</a>";
	    		return enableBtn;
			}else{
				let enableBtn="<a class='go' style='color:red'>考试已结束</a>";
	    		return enableBtn;
			}
    	}
	} ] ],
	pagination : true
});
$("#dg").datagrid("getPager").pagination({
	pageSize : 10,// 每页显示的记录条数，默认为10
	pageList : [ 5, 10, 15 ],// 可以设置每页记录条数的列表
	beforePageText : '第',// 页数文本框前显示的汉字
	afterPageText : '页    共 {pages} 页',
	displayMsg : '当前显示 {from} 到 {to} 条记录   共 {total} 条记录',
});
/**
 * 获取表单数据
 * 
 * @param form
 * @returns
 */
function getFormParam(form) {
	var formData = {};
	var t = $(form).serializeArray();
	$.each(t, function() {
		if(this.value!=""){
			formData[this.name] = this.value;
		}
	});
	return formData;
}
</script>
</html>