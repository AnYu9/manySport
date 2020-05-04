function fun(){
		console.log(getFormParam($("#condition").find("form")));
		$('#dg').datagrid('reload',getFormParam($("#condition").find("form")));
}

$('#dg').datagrid({
	pagination : true,
	striped : true,
	rownumbers : true,
	url : '../conditionFindQuestion',
	columns : [ [ {
		field : '',
		checkbox : true,
		width : 20
	}, {
		field : 'topId',
		title : '试题编号',
		width : 75
	}, {
		field : 'title',
		title : '试题标题',
		width : 150
	}, {
		field : 'a',
		title : 'a选项',
		width : 100
	}, {
		field : 'b',
		title : 'b选项',
		width : 100
	}, {
		field : 'c',
		title : 'c选项',
		width : 100
	}, {
		field : 'd',
		title : 'd选项',
		width : 100
	}, {
		field : 'result',
		title : '答案',
		width : 100
	}, {
		field : 'subjectName',
		title : '所属科目',
		width : 75
	}, {
		field : 'difficulty',
		title : '难度',
		width : 75
	}, {
		field : 'type',
		title : '类型',
		width : 75
	}, {
		field : 'explanation',
		title : '题目解析',
		width : 100
	}, {
		field : 'score',
		title : '试题分数',
		width : 75
	}, ] ],
	onDblClickRow : function(index, row) {
		console.log(row);
		var inputValues = $("#updateInforForm .textbox-value");
		var inputPrompts = $("#updateInforForm .textbox-prompt");
		console.log(inputValues);
		for (var i = 0; i < inputValues.length; i++) {
			var key = inputValues[i].name;
			inputPrompts[i].value = row[key];
			inputValues[i].value = row[key];
		}

		$('#updateDiv').dialog("open", true);
		/*
		 * 如果是选择题，则显示选项填写框
		 */
		var data = getFormParam($('#updateDiv').find("form"));
		console.log(data);
		if(data.type=="选择题" || data.type=="多选题"){
			$("#updateInforForm #select").css("display", "block")
		}else{
			$("#updateInforForm #select input").val("");
			$("#updateInforForm #select").css("display", "none")
		}
		
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
				ids += rows[i].topId + ",";
			}
			if (ids != "") {
				console.log(ids);
				$.ajax({
					url : "../questionDel",
					type : "post",
					data : {
						"questions" : ids
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
	

$("#updateInforForm input[name='type']").combobox({
	onSelect : function(record) {
		$("#updateInforForm #select").css("display", "none")
		$("#updateInforForm #select input").val("");
		alert(record);
		if (record.id == 1) {
			$("#updateInforForm #select").css("display", "block")
		}
	}
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
	width : 500,
	height : 300,
	top : 100,
	closed : true,
	buttons : [ {
		text : "新增",
		width : 50,
		handler : function(result) {
			sendForm("../questionAdd", $("#addDiv"));
			$('#dg').datagrid('reload');
		}
	} ]
});

$('#updateDiv').dialog({
	title : '修改',
	width : 500,
	height : 400,
	top : 100,
	closed : true,
	buttons : [ {
		text : "修改",
		width : 50,
		handler : function() {
			var data = getFormParam($('#updateDiv').find("form"));
			sendForm("../questionUpdate", $("#updateDiv"));
		}
	} ]
});

$('.subject').combobox({
	url : '../findAllSubject',
	valueField : 'subjectId',
	textField : 'subjectName',
	success : function(result) {
		alert("成功");
	}
});

$("#condition input[name='subjectName']").combobox({
	url : '../findAllSubject',
	success : function(result) {
		alert("成功");
	}
});

$('#type').combobox({
	valueField : 'id',
	textField : 'text',
	data : [ {
		"id" : 1,
		"text" : "选择题"
	}, {
		"id" : 2,
		"text" : "填空题"
	}, {
		"id" : 3,
		"text" : "判断题"
	} , {
		"id" : 4,
		"text" : "多选题"
	} ],
	onSelect : function(record) {
		$("#addInforForm #select").css("display", "none")
		$("#select input").val("");
		if (record.text == "选择题" || record.text=="多选题") {
			$("#select").css("display", "block")
		}
	}
});

$('#type').combobox({
	valueField : 'text',
	textField : 'text',
	data : [ {
		"id" : 1,
		"text" : "选择题"
	}, {
		"id" : 2,
		"text" : "填空题"
	}, {
		"id" : 3,
		"text" : "判断题"
	} , {
		"id" : 4,
		"text" : "多选题"
	} ]
});

$('#score').combobox({
	url : '#',
	valueField : 'id',
	textField : 'text',
	data : [ {
		"id" : 2,
		"text" : "2分"
	}, {
		"id" : 5,
		"text" : "5分"
	}, {
		"id" : 10,
		"text" : "10分"
	} ]
});
function sendForm(path, formDiv) {
	var formData = getFormParam($(formDiv).find("form"));
	console.log(formData);
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