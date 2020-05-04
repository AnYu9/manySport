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
</body>
	<script type="text/javascript">
		$('#dg').datagrid({
		    url:'../error/queryAll',
		    type:'post',
		    columns:[[
		    	{field:'classChe',checkbox:true},
		        {field:'errorId',title:'错误编号',width:100},
		        {field:'userId',title:'上报用户',width:100},    
		        {field:'errordes',title:'错误详细',width:300},
		        {field:'paperId',title:'报错试卷编号',width:100},
		        {field:'topicId',title:'报错题目编号',width:100},
		        {field:'status',title:'错误状态',halign:"center",align:"center",resizable:false,
		        	formatter: function(value,row,index){
		        		if (row.status=="未处理"){
		        			var buttonText="";
		        			var approveBtn="<button class='executeBtn' style='background: green;' onclick='approve("+row.errorId+")'>已处理</button>";
		        			var rejectBtn="<button class='executeBtn' onclick='reject("+row.errorId+")'>无效上报</button>";
		        			buttonText+=approveBtn;
		        			buttonText+=rejectBtn;
		        			
		        			row.execute=buttonText;
		        		}
		        		return value;
		        	}
		        },
		    ]],
		    toolbar: [{
				iconCls: 'icon-ok',
				handler: function(){
					$.messager.confirm('确认','您确认已经处理此记录吗？',function(r){    
					    if (r){
					    	var rows = $('#dg').datagrid('getSelections');
					    	var ids = "";
							for (var i = 0; i < rows.length; i++) {
								ids += rows[i].errorId + ",";
							}
					       	$.ajax({
					       		type:'post',
					       		url:"../error/updateStatus",
					       		dataType:'json',
					       		data:{'errorIds':ids},
					       		success:function(){  
					       			
								},
								 error:function() {
									alert("处理成功");
						       		$('#dg').datagrid('reload');
								}
					       	})
					    }    
					}); 
					
				}
			},'-',{
				iconCls: 'icon-cancel',
				handler: function(){
					
				}
			}],
		    pagination:true
		});
		$("#dg").datagrid("getPager").pagination({
		    pageSize: 5,//每页显示的记录条数，默认为10
		    pageList: [5, 10, 15],//可以设置每页记录条数的列表
		    beforePageText: '第',//页数文本框前显示的汉字
		    afterPageText: '页    共 {pages} 页',
		    displayMsg: '当前显示 {from} 到 {to} 条记录   共 {total} 条记录',
		});
		function reject(ids){
			$.ajax({
				url : "../error/updateStatus",
				type : "post",
				data : {
					"errorIds" : ids
				},
				success : function(result) {
					if(result=="1"){
						alert("操作成功");
						$('#showTable').datagrid('reload');
					}else{
						alert("操作失败");
					}
				},
				error : function() {
					alert("操作失败");
				}
			});
		}
	</script>
</html>