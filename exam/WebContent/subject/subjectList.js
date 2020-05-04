$('#dg').datagrid({
	pagination : true,
	striped : true,
	sortName : "id",
	sortOrder : "asc",
	rownumbers : true,
	url : '../findSubject',
	columns : [ [ {
		field : '',
		checkbox : true,
		width : 20
	}, {
		field : 'subjectId',
		title : '科目编号',
		width : 100
	}, {
		field : 'subjectName',
		title : '科目名',
		width : 100
	} ] ],
	onDblClickRow : function(index, row) {
		var inputValues = $("#updateInforForm .textbox-value");
		var inputPrompts = $("#updateInforForm .textbox-prompt");
		for (var i = 0; i < inputValues.length - 1; i++) {
			var key = inputValues[i].name;
			inputPrompts[i].value = row[key];
			inputValues[i].value = row[key];
		}

		$('#updateDiv').dialog("open", true);
	},
	toolbar : [ {
		iconCls : 'icon-add',
		text : "添加",
		handler : function() {
			$('#addDiv').dialog("open", true);
		}
	}, '-', {
		iconCls : 'icon-remove',
		text : "删除",
		handler : function() {
			var rows = $('#dg').datagrid("getSelections");
			console.log(rows);
			var ids = "";
			for (var i = 0; i < rows.length; i++) {
				ids += rows[i].subjectId + ",";
			}
			if (ids != "") {
				console.log(ids);
				$.ajax({
					url : "../subjectDel",
					type : "get",
					data : {
						"subjectIds" : ids
					},
					success : function(result) {
						alert("删除成功");
						$('#dg').datagrid('reload');
					},
					error : function() {
						alert("删除失败");
					}
				})
			} else {
				alert("请选择至少一项数据来完成此操作！");
			}
		}
	} ]
});

$("#dg").datagrid("getPager").pagination({
	pageSize : 10,// 每页显示的记录条数，默认为10
	pageList : [ 5, 10, 15 ],// 可以设置每页记录条数的列表
	beforePageText : '第',// 页数文本框前显示的汉字
	afterPageText : '页    共 {pages} 页',
	displayMsg : '当前显示 {from} 到 {to} 条记录   共 {total} 条记录',
});

$('#addDiv').dialog({
	title : '新增',
	width : 400,
	height : 200,
	closed : true,
	buttons : [ {
		text : "提交",
		width : 50,
		handler : function() {
			sendForm("../subjectAdd", $("#addDiv"));
		}
	} ]
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
			sendForm("../subjectUpdate", $("#updateDiv"));
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
		formData[this.name] = this.value;
	});
	return formData;
}