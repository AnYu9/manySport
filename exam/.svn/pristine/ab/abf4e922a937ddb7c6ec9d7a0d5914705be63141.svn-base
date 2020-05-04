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
	<div id="dd">
		<form id="from" action="post">
			<p>班级名称：<input id="name" name="className" type="text" style="width:300px"></p>
			<p>班级描述：<input id="des" name="classDes" type="text" style="width:300px"></p>      
		</form>
	</div>
	<div id="updateDiv">
		<form id="updateInforForm" method="post">
			<p>
				班级名称：<input class="easyui-textbox" name="classId"
					data-options="width:50,readonly:true" />
			</p>
			<p>
				班级名称：<input class="easyui-textbox" name="className"
					data-options="width:50" />
			</p>
			<p>
				班级描述：<input class="easyui-textbox" name="classDes"
					data-options="width:50" />
			</p>
			
		</form>
	</div>
</body>
	<script type="text/javascript">
		$('#dd').dialog({    
		    title: 'My Dialog', 
		    width: 400,    
		    height: 200,    
		    closed: true,    
		    cache: true,     
		    modal: true,
		    buttons:[{
				text:'保存',
				handler:function(){
					 $.ajax({
						 type:'post',
						 url:"../grade/save",
						 dataType:'json', 
						 data:$("#from").serialize(),
						 success:function(data){   
							 
						 },
						 error:function() {
							 alert('添加成功')
							 $('#dg').datagrid('reload');
						}
					 })
					 $('#dd').window('close');
				}
			},{
				text:'关闭',
				handler:function(){
					$('#dd').window('close');
				}
			}]
		}); 
		$('#name').textbox({    
		    iconCls:'icon-man', 
		    iconAlign:'left'       
		})
		$('#des').textbox({    
		    iconCls:'icon-man', 
		    iconAlign:'left'       
		})
		$('#dg').datagrid({
		    url:'../grade/queryAll',  
		    type:'post',
		    columns:[[
		    	{field:'classChe',checkbox:true},
		        {field:'classId',title:'班级编号',width:100},    
		        {field:'className',title:'班级名称',width:100},
		        {field:'classDes',title:'班级描述',width:300},
		        {field:'num',title:'班级人数',width:100}
		    ]],
		    toolbar: [{
				iconCls: 'icon-add',
				handler: function(){
					$('#dd').window('open'); 
					
				}
			},'-',{
				iconCls: 'icon-remove',
				handler: function(){
					var rows = $('#dg').datagrid('getSelections');
					var ids = "";
					for (var i = 0; i < rows.length; i++) {
						ids += rows[i].classId + ",";
					}
					$.ajax({
						 type:'post',
						 url:"../grade/remove",
						 dataType:'json', 
						 data:{'classIds':ids},
						 success:function(){      
							 
						 },
						 error:function() {
							 alert("删除成功");
							 $('#dg').datagrid('reload');
						}
					 })
				}
			}],onDblClickRow : function(index, row) {
				var inputValues = $("#updateInforForm .textbox-value");
				console.log(inputValues);
				var inputPrompts = $("#updateInforForm .textbox-prompt");
				console.log(inputPrompts);
				for (var i = 0; i < inputValues.length - 1; i++) {
					var key = inputValues[i].name;
					inputPrompts[i].value = row[key];
					inputValues[i].value = row[key];
				}

				$('#updateDiv').dialog("open", true);
			},
			pagination:true
		});
		$("#dg").datagrid("getPager").pagination({
		    pageSize: 5,//每页显示的记录条数，默认为10
		    pageList: [5, 10, 15],//可以设置每页记录条数的列表
		    beforePageText: '第',//页数文本框前显示的汉字
		    afterPageText: '页    共 {pages} 页',
		    displayMsg: '当前显示 {from} 到 {to} 条记录   共 {total} 条记录',
		});
		$('#updateDiv').dialog({
			title : '修改',
			width : 400,
			height : 200,
			closed : true,
			top : 100,
			buttons : [ {
				text : "提交",
				width : 50,
				handler : function() {
					sendForm("../grade/update", $("#updateDiv"));
				}
			} ]
		});
		function sendForm(path, formDiv) {
			var formData = getFormParam($(formDiv).find("form"));
			$.ajax({
				url : path,
				type : "post",
				data : formData,
				success : function(result) {
					alert(result);
					$('#dg').datagrid('reload');
					$(formDiv).dialog("close", true);
				}
			});
		}
		function getFormParam(form) {
			var formData = {};
			var t = $(form).serializeArray();
			$.each(t, function() {
				formData[this.name] = this.value;
			});
			return formData;
		}
	</script>
</html>