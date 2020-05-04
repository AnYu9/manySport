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
	
	<div id="findDiv">
		<form id="findForm">
			考试用户：<input type="text" name="userId">
			  
			考试时间：<input type="text" name="testTime"> 
			 
			试卷名称：<input type="text" name="paperName">
			
			<span onclick="findQuery()">搜索</span>
		</form>
	</div>
	
	<table id="dg"></table>
	<div id="dd">  
		<input id="des" type="text" name="des" placeholder="请输入对此学生的描述!!">  
	</div>
	<script type="text/javascript">
		$('#dd').dialog({      
		    width: 400,    
		    height: 200,    
		    closed: true,
		    buttons:[{
				text:'发送',
				handler:function(){
					let rows=$('#dg').datagrid("getSelections");
					let des = $('#ids').val();
					 $.ajax({
						ulr:'../records/sendMessage',
						type:'post',
						data:{'paperName':rows.paperName,'userName':rows.userId,'score':rows.score,'des':des},
						success:function(result){
							console.log(result);
						},
						error:function(msg){
							
						}
					}); 
				}
			}]
		});
		$('#dg').datagrid({    
		    url:"../records/findQuery",
		    method:'get',
		    columns:[[
		    	{field:'classChe',checkbox:true},
		        {field:'perId',title:'编号',width:100},    
		        {field:'userId',title:'考试用户',width:100},
		        {field:'score',title:'分数',width:100},
		        {field:'paperId',title:'试卷编号',width:100},
		        {field:'testTime',title:'考试时间',width:100},
		        {field:'paperName',title:'试卷名称',width:100},
		        {field:'btn',title:'操作',width:100,formatter: function(value,row,index){
		        	let disableBtn="<button onclick='send()'>发送成绩</button>";
		    		return disableBtn;
		    	}}
		    ]],
		    pagination:true
		});
		function send(){
			$('#dd').dialog("open",true);
		}
		function findQuery(){
			let data=getFormParam($("#findForm"));
			console.log(data);
			$("#dg").datagrid("load",data);
		}
		
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
</body>
</html>