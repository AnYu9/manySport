function fun2(){
		console.log(getFormParam($("#conditionDiv").find("form")));
		$('#dg').datagrid('reload',getFormParam($("#conditionDiv").find("form")));
	}

$("#conditionDiv input[name='subjectName']").combobox({
	url : '../findAllSubject',
	success:function(){
		alert("成功");
	}
});
/*
 * 加载添加试卷题型按钮
 */
	$(function(){
		$.ajax({
			url:"../paper/findTopicType",
			type:"post",
			success:function(result){
				for(var i = 0;i< result.length;i++){
					var j = "<span class='questClass' value='"+result[i].typeId+"' name='questionId' onclick='fun(this)'>"+result[i].type+"</span>";
					$("#topicList").append(j);
				}
			},
			error:function(){
				alert("请求失败了...");
			}
		});
		
	}) ;
	
	function fun(obj){
		var subjectName = $("#topicList>input").val();
		var type= obj.innerText;
		var difficulty=$("#topicList>select").val();
		$('#topics').datagrid('reload',{
			subjectName:subjectName,
			type:type,
			page:1,
			rows:10
		});
	}

	$('#dg').datagrid({
		url : '../paper/queryAll',
		type : 'post',
		columns : [ [ {
			field : 'classChe',
			checkbox : true
		}, {
			field : 'paperId',
			title : '试卷编号',
			width : 100
		}, {
			field : 'paperName',
			title : '试卷名称',
			width : 100
		}, {
			field : 'userName',
			title : '发布试卷的用户',
			width : 100
		}, {
			field : 'testEnd',
			title : '考试结束时间',
			width : 100
		}, {
			field : 'subjectName',
			title : '所属科目',
			width : 100
		}, {
			field : 'testdate',
			title : '考试时长',
			width : 100
		}, {
			field : 'testSource',
			title : '试卷总分',
			width : 100
		} ] ],
		onDblClickRow : function(index, row) {
			console.log(row);
			var inputValues = $("#updateInforForm .textbox-value");
			var inputPrompts = $("#updateInforForm .textbox-prompt");
			console.log(inputValues);
			console.log(inputPrompts);
			for (var i = 0; i < inputValues.length; i++) {
				var key = inputValues[i].name;
				inputPrompts[i].value = row[key];
				inputValues[i].value = row[key];
			}

			$('#updateDiv').dialog("open", true);
		},toolbar : [ {
			iconCls : 'icon-add',
			text : '新增试卷',
			handler : function() {
				/*
				打开新增试卷窗口
				*/
				$('#addDiv').dialog("open", true);
			}
		}, '-', {
			iconCls : 'icon-remove',
			text : '删除试卷',
			handler : function() {
				var rows = $('#dg').datagrid("getSelections");
				console.log(rows);
				var ids = "";
				for (var i = 0; i < rows.length; i++) {
					ids += rows[i].paperId + ",";
				}
				if (ids != "") {
					console.log(ids);
					$.ajax({
						url : "../paper/paperDel",
						type : "post",
						data : {
							"paperIds" : ids
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
		} ],
		pagination : true
	});
	$("#dg").datagrid("getPager").pagination({
		pageSize : 10,// 每页显示的记录条数，默认为10
		pageList : [ 5, 10, 15 ],// 可以设置每页记录条数的列表
		beforePageText : '第',// 页数文本框前显示的汉字
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} 到 {to} 条记录   共 {total} 条记录'
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
				var b = parseInt($("b").text());
				var score = $("input[name='testSource']").val();
				if(score==b){
					sendForm("../paper/paperAdd", $("#addDiv"));
					$('#dg').datagrid('reload');
				}else if(b>score){
					alert("分数超过["+score+"]分了");
				}else  if(b<score){
					alert("分数低于["+score+"]分了");
				}else{
					alert("请选择试题");
				}
			}
		} ]
	});
	
	$('#updateDiv').dialog({
		title : '修改',
		width : 500,
		height : 300,
		top : 150,
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


	$('#btn').linkbutton({
		iconCls : 'icon-add',
		onClick : function() {
			/*
			打开试题列表框
			*/
			$("#topicList").dialog("open", true);
		}
	});
	$('#btn2').linkbutton({
		iconCls : 'icon-reload',
		onClick : function() {
			$("input[name='anwer']").val("");
			$("b").text(0);
			$("i").text(0);
		}
	});
	
	/*
	试题列表框
	*/
	$('#topicList').dialog({
		title : '试题列表',
		width : 800,
		height : 500,
		top : 100,
		closed : true,
		buttons : [ {
			text : "新增",
			width : 50,
			handler : function(result) {
				var rows = $('#topics').datagrid("getSelections");
				var ids = "";
				var score = 0;
				for (var i = 0; i < rows.length; i++) {
					ids += rows[i].topId + ",";
					score+=parseInt(rows[i].score);
				}
				
				var flag = true;
				
				var t1 = splitStrAndSkipEmpty(ids);
				
				var aa = $("input[name='anwer']").val();
				var t2 = splitStrAndSkipEmpty(aa);
				var alread = [];
				for(var i = 0;i<t2.length;i++){
					for(var j = 0;j<t1.length;j++){
						if(t1[j] == t2[i]){
							alread.push(t1[j]);
							flag=false;
						}
					}
				}
				
				if(flag){
					//----已选试题总分----
					var inn = parseInt($("b").text());
					var temp = score+inn;
					$("b").text(temp);
					//-=-=-====已选的题目数量=-=-=
					var inne = parseInt($("i").text());
					var inner= splitStrAndSkipEmpty(ids);
					
					$("i").text(inne+inner.length);
					
					//-=-=-=-=-=隐藏域保存添加的试题编号-=-=-=-=-=-=
					var val = $("input[name='anwer']").val();
					$("input[name='anwer']").val(val+ids);
					
					//已选题目编号
					//alert($("input[name='anwer']").val());
					
					
					$('#topicList').dialog("close",true);
					alert("已增加试题");
				}else{
					alert("以下试题已添加过了"+alread);
				}
			}
		} ]
	});
	
	/*
	试题列表加载
	*/
	$('#topics').datagrid({
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
		}, ] ]
	});
	
	$("#topics").datagrid("getPager").pagination({
		pageSize : 10,// 每页显示的记录条数，默认为10
		pageList : [ 5, 10, 15 ],// 可以设置每页记录条数的列表
		beforePageText : '第',// 页数文本框前显示的汉字
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} 到 {to} 条记录   共 {total} 条记录',
	});
	
	
	
	/*
	 * 科目列表下拉框
	 */
	$('.subjectName').combobox({
		url : '../findAllSubject',
		valueField : 'subjectId',
		textField : 'subjectName'
	});
	$('.conditionSubjectName').combobox({
		url : '../findAllSubject',
		valueField : 'subjectName',
		textField : 'subjectName'
	});

	/*
	分数列表下拉框
	*/
	$("input[name='testSource']").combobox({
		valueField : 'id',
		textField : 'text',
		data : [ {
			"id" : 100,
			"text" : "100分"
		} ]
	});

	/*
	考试时长下拉框
	*/
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

	//-------日历组件数据格式化---------
	function myformatter(date) {
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		var d = date.getDate();
		return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
				+ (d < 10 ? ('0' + d) : d);
	}
	function myparser(s) {
		if (!s)
			return new Date();
		var ss = (s.split('-'));
		var y = parseInt(ss[0], 10);
		var m = parseInt(ss[1], 10);
		var d = parseInt(ss[2], 10);
		if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
			return new Date(y, m - 1, d);
		} else {
			return new Date();
		}
	}

	//--------获取表单、发送数据---------
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
			if(this.value!=""){
				formData[this.name] = this.value;
			}
		});
		return formData;
	}
	/** 
	 * <pre> 
	 * @param str 
	 * @returns {Array} 用逗号,将string进行分割，形成一个数组 
	 * </pre> 
	 */  
	function splitStrAndSkipEmpty(str){  
	    var arr = str.split(',');  
	    return skipEmptyElementForArray(arr);  
	}  
	  
	/** 
	 * <pre> 
	 * @param arr 
	 * @returns {Array} 如果arr中的元素存在空字符串''，则去掉该空字符串 
	 * </pre> 
	 */  
	function skipEmptyElementForArray(arr){  
	    var a = [];  
	    $.each(arr,function(i,v){  
	        var data = $.trim(v);//$.trim()函数来自jQuery  
	        if('' != data){  
	            a.push(data);  
	        }  
	    });  
	    return a;  
	} 
	