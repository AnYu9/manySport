<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>测试题</title>
</head>
<script type="text/javascript" src="jquery-1.6.1.js"></script>
<link href = "exer.css" rel="styleSheet" type="text/css" />
<body>
	<%
		String course = request.getParameter("course");
	%>

	<div id="background">
		<div id="max">
			<a href="course_knowledge.jsp" style="color: white; margin-top: 35px; margin-left: 30px; float: left;">返回首页</a>
			<div id="top"><%=course %>测试</div>
			<div id="left">
				<div class="easy"><a href="#" class="course_son">初级测试</a></div>
				<div class="middle"><a href="#" class="course_son">中级测试</a></div>
				<div class="height"><a href="#" class="course_son">高级测试</a></div>
			</div>
			<div id="right" style="color: white; font-size:22px;">
				<h2 style="line-height: 9; padding-left: 300px;">好好学习，天天向上</h2>
				<button id="next" style="display:none; float: right; margin-right: 70px; margin-top: 200px; width: 80px; height: 40px;">下一题</button>
				<button id="before" style="display:none; float: right; margin-right: 50px; margin-top: 200px; width: 80px; height: 40px;">上一题</button>
				<button id="next1" style="display:none; float: right; margin-right: 70px; margin-top: 200px; width: 80px; height: 40px;">下一题</button>
				<button id="before1" style="display:none; float: right; margin-right: 50px; margin-top: 200px; width: 80px; height: 40px;">上一题</button>
				<button id="next2" style="display:none; float: right; margin-right: 70px; margin-top: 200px; width: 80px; height: 40px;">下一题</button>
				<button id="before2" style="display:none; float: right; margin-right: 50px; margin-top: 200px; width: 80px; height: 40px;">上一题</button>
			</div>
		</div>
	</div>
	<input type="hidden" id="course" value="<%=course %>" />
</body>

<script type="text/javascript">
	//初级状态
	var chu ="";
	var a = 0;
	//中级状态
	var zhong = "";
	var b = 0;
	//高级状态
	var gao = "";
	var c = 0;

	//获取测试科目名称
	var course = $("#course").val();
	console.log("科目名称=="+course);
	
	//获取本次测试的难度
	var nanDu = "初级";
	
	//记录测试题的个数
	var ExerCount = 0;

	//存放测试选择题序号
	var stuAnswer = ",";
	//存放测试选择题选项内容
	var stuAnswerMessage = ",";
	//存放测试选择题正确答案
	var OkAnswer = ",";
	//存放测试选择题目详解
	var ExerDesc = ",";
	$(".easy").click(function(){
		console.log("进入了初级测试题");
		if(chu == "已完成测试"){
			alert("您以完成初级测试！！！");
		}else {
			console.log("a==="+a);
			if(a != 0){
				
			}else {
				nanDu = "初级";
				a += 1;
				//隐藏其他等级测试的题目
				for(var x = 0; x<5; x++){
					console.log("开始隐藏！！！");
					$(".divsT"+(x+1)).css("display","none");
					$(".divsS"+(x+1)).css("display","none");
				}
				$(".middle").css("display","none");
				$(".height").css("display","none");
				$("h2").css("display","none");
				$("#next, #before").css("display","block");
				$("#next1, #before1").css("display","none");
				$("#next2, #before2").css("display","none");
				$.ajax({
					url:"../ExercisesController/ExerRest/1/"+course,
					type:"GET",
					success:function(result){
						//获取节点
						var $right=$("#right");
						for(var i = 0; i<result.length; i++){
							ExerCount = result.length;
							var resultMessage = result[i].value.split("@@");
							//放入正确答案
							OkAnswer += (resultMessage[3]+",");
							//放入题目详解
							ExerDesc += (resultMessage[6]+",");
							//创建测整个试题节点
							var $divs = $("<div class='divs"+(i+1)+"  '>第"+(i+1)+"题：</div>");
							//插入节点
							$right.append($divs);
							//创建题目节点
							var $divExer = $("<div class='divExer"+(i+1)+"'>"+resultMessage[1]+"</div>");
							//创建题目选项节点
							var $divOptions = $("<div class='divOptions"+(i+1)+"'></div>");
							var optionsArray = resultMessage[2].split("#");
							for(var j = 0; j<optionsArray.length; j++){
								var $divOption = $("<input message="+''+optionsArray[j]+" value="+''+i+'-'+j+" class='radios' type='radio' name='radio' id='divOption"+(j+1)+"'>"+optionsArray[j]+"</input>");
								//将单个选项添加到$divOptions中
								$divOptions.append($divOption);
								//添加css样式
								$("#divOption"+(j+1))
							}
							//创建“对错”节点
							var $yesOrNo = $("<div class='yesOrNo"+i+"'></div>");
							//创建“显示正确答案”节点
							var $yesResult = $("<div class='yesResult"+i+"'></div>");
							//创建“测试题详解”节点
							var $explanation = $("<div class='explanation"+i+"'></div>");
							//添加节点到整个试题节点
							$divs.append($divExer);
							$divs.append($divOptions);
							$divs.append($yesOrNo);
							$divs.append($yesResult);
							$divs.append($explanation);
							//给创建的整个试题节点添加CSS样式和属性
							$(".divs"+1).css("display","block");
							$(".divs"+(i+1)).css("display","none");
						}
						//给单选框添加css样式
						for(var i = 0; i<result.length; i++){
							$(".divOptions"+(i+1)).css({
								"color":"greenyellow",
								"margin-left":"190px"
							});
							$(".divExer"+(i+1)).css("margin-left","190px");
						}
						//获取学生测试的答案的序号
						$(".radios").click(function(){
							stuAnswer += $(this).val()+",";
						})
						//获取学生测试答案的内容
						$(".radios").click(function(){
							var stuAnswer = ($(this).val()).split("-")[0];
							stuAnswerMessage += (stuAnswer+"-"+$(this).attr("message")+",");
						})
					}
				})
				if(nanDu == "初级"){
					console.log("初级初级..........");
					var i = 1;
					$("#next").click(function(){
						console.log("初级next");
						var nowTestNum = i;
						i += 1;
						var testNum = i;
						console.log("i="+i);
						//判断i>返回数据的length显示“看看对错”
						if(i > ExerCount){
							i = ExerCount;
							$(".divs"+nowTestNum).css("display","none");
							$(".divs"+ExerCount).css("display","block");
							$("#next").text("看看对错");
							//提交学生所选的全部答案，判断对错，并且返回正确答案
							$.ajax({
								url:"../AnswerController/AnswerRest/"+stuAnswerMessage+"/"+ExerCount,
								type:"POST",
								data:{
									_method:"PUT"
								},
								dataType:"json",
								success:function(result){
									//先判断所有题目是否做答完成
									if(result.length >= ExerCount){//完成
										//提交答案后不可修改单选框选项
										$(':radio:not(:checked)').attr('disabled', true);
										for(var k = 0; k<result.length; k++){
											//拿正确的答案
											var OkAnswerArray = OkAnswer.split(",");
											//拿题目说明
											var ExerDescArray = ExerDesc.split(",");
											if(result[k].value == OkAnswerArray[k+1]){
												$(".yesOrNo"+(k)).text("✔");
												$(".yesOrNo"+(k)).css("color","#7FFF00");
												$(".explanation"+(k)).text("题目解析："+ExerDescArray[k+1]);
												$(".explanation"+(k)).css("display","block");
												$(".yesResult"+(k)).text("正确答案："+OkAnswerArray[k+1]);
												$(".yesResult"+(k)).css("display","block");
											}else {
												$(".yesOrNo"+(k)).text("✖");
												$(".yesOrNo"+(k)).css("color","red");
												$(".explanation"+(k)).text("题目解析："+ExerDescArray[k+1]);
												$(".explanation"+(k)).css("display","block");
												$(".yesResult"+(k)).text("正确答案："+OkAnswerArray[k+1]);
												$(".yesResult"+(k)).css("display","block");
											}
											chu = "已完成测试";
										}
										//显示其他的测试
										$(".middle").css("display","block");
										$(".height").css("display","block");
									}else {//未完成
										console.log("aaa没有完成");
										alert("请将答案填写完整！");
									}
								}
							})
						}else {
							$(".divs"+nowTestNum).css("display","none");
							$(".divs"+testNum).css("display","block");
							$("#next").text("下一题");
							//点击下一题将用户选择的答案显示
							$.ajax({
								type:"GET",
								url:"../AnswerController/AnswerRest/"+stuAnswer,
								data:{
									num:(i-1)
								},
								success:function(result){
									$("input[value="+(i-1)+"-"+(result)+"]").attr("checked","checked");
								}
							})
						}
					});
	
					//上一题
					$("#before").click(function(){
						var nowTestNum = i;
						i -= 1;
						var testNum = i;
						if(i <= 0){
							i = 1;
							$("#divs"+1).css("display","block");
						}else {
							$(".divs"+nowTestNum).css("display","none");
							$(".divs"+testNum).css("display","block");
							$("#next").text("下一题");
							//点击上一题将用户选择的答案显示
							$.ajax({
								type:"GET",
								url:"../AnswerController/AnswerRest/"+stuAnswer,
								data:{
									num:(i-1)
								},
								success:function(result){
									$("input[value="+(i-1)+"-"+(result)+"]").attr("checked","checked");
								}
							})
						}
					})
				}
			}
		}
	})
	
	//存放测试填空题序号
	var stuAnswer2 = ",";
	//存放测试填空题内容
	var stuAnswerMessage2 = ",";
	//存放测试填空题正确答案
	var OkAnswer2 = ",";
	//存放测试填空题目详解
	var ExerDesc2 = ",";
	var j = 0;
	$(".middle").click(function(){
		if(zhong == "已完成测试"){
			alert("您已完成中级测试！！！");
		}else {
			if(b != 0){
				
			}else {
				b += 1;
				//隐藏其他等级测试的题目
				for(var x = 0; x<5; x++){
					console.log("开始隐藏！！！");
					$(".divs"+(x+1)).css("display","none");
					$(".divsS"+(x+1)).css("display","none");
				}
				nanDu = "中级";
				$(".easy").css("display","none");
				$(".height").css("display","none");
				$("h2").css("display","none");
				$("#next1, #before1").css("display","block");
				$("#next2, #before2").css("display","none");
				$("#next, #before").css("display","none");
				$.ajax({
					url:"../ExercisesController/ExerRest/2/"+course,
					type:"GET",
					success:function(result){
						console.log(result);
						//获取节点
						var $right=$("#right");
						for(var i = 0; i<result.length; i++){
							ExerCount = result.length;
							var resultMessage = result[i].value.split("@@");
							//放入正确答案
							OkAnswer2 += (resultMessage[2]+",");
							//放入题目详解
							ExerDesc2 += (resultMessage[5]+",");
							//创建测整个试题节点
							var $divs = $("<div class='divsT"+(i+1)+" '>第"+(i+1)+"题：</div>");
							//插入节点
							$right.append($divs);
							//创建题目节点
							var $divExer = $("<div class='divExer"+(i+1)+"'>"+resultMessage[1]+"</div>");
							//创建输入框节点
							var $import = $("<input type='text' id='import"+i+"' value='' class='import'></input>");
							//创建“对错”节点
							var $yesOrNo = $("<div class='yesOrNo"+i+"'></div>");
							//创建“显示正确答案”节点
							var $yesResult = $("<div class='yesResult"+i+"'></div>");
							//创建“测试题详解”节点
							var $explanation = $("<div class='explanation"+i+"'></div>");
							//添加节点到整个试题节点
							$divs.append($divExer);
							$divs.append($import);
							$divs.append($yesOrNo);
							$divs.append($yesResult);
							$divs.append($explanation);
							//给创建的整个试题节点添加CSS样式和属性
							$(".divsT"+1).css("display","block");
							$(".divsT"+(i+1)).css("display","none");
							
							//获取学生测试答案的内容
							$("#import"+i).blur(function(){
								console.log("i="+i);
								if($(this).val().length>=1){
									stuAnswerMessage2 += (j+"-"+$(this).val()+",");
									console.log("stuAnswerMessage2="+stuAnswerMessage2);
								}
							})
						}
						//添加css样式
						for(var i = 0; i<result.length; i++){
							$(".divExer"+(i+1)).css("margin-left","190px");
							$("#import"+i).css("margin-left","30px");
						}
					}
				})
				if(nanDu == "中级"){
					var i = 1;
					$("#next1").click(function(){
						console.log("中级next");
						console.log("stuAnswerMessage2===="+stuAnswerMessage2);
						j += 1;
						var nowTestNum = i;
						i += 1;
						var testNum = i;
						//判断i>返回数据的length显示“看看对错”
						if(i > ExerCount){
							i = ExerCount;
							$(".divsT"+nowTestNum).css("display","none");
							$(".divsT"+ExerCount).css("display","block");
							$("#next1").text("看看对错");
							//提交学生所选的全部答案，判断对错，并且返回正确答案
							$.ajax({
								url:"../AnswerController/AnswerRest/"+stuAnswerMessage2+"/"+ExerCount,
								type:"POST",
								data:{
									_method:"PUT"
								},
								dataType:"json",
								success:function(result){
									console.log(result.length);
									//先判断所有题目是否做答完成
									if(result.length >= ExerCount){//完成
										//提交答案后不可修改
										$('input[type="text"]').attr('readonly','true');
										console.log("完成了");
										for(var k = 0; k<result.length; k++){
											//拿正确的答案
											var OkAnswerArray2 = OkAnswer2.split(",");
											//拿题目说明
											var ExerDescArray2 = ExerDesc2.split(",");
											if(result[k].value == OkAnswerArray2[k+1]){
												$(".yesOrNo"+(k)).text("✔");
												$(".yesOrNo"+(k)).css("color","#7FFF00");
												$(".explanation"+(k)).text("题目解析："+ExerDescArray2[k+1]);
												$(".explanation"+(k)).css("display","block");
												$(".yesResult"+(k)).text("正确答案："+OkAnswerArray2[k+1]);
												$(".yesResult"+(k)).css("display","block");
											}else {
												$(".yesOrNo"+(k)).text("✖");
												$(".yesOrNo"+(k)).css("color","red");
												$(".explanation"+(k)).text("题目解析："+ExerDescArray2[k+1]);
												$(".explanation"+(k)).css("display","block");
												$(".yesResult"+(k)).text("正确答案："+OkAnswerArray2[k+1]);
												$(".yesResult"+(k)).css("display","block");
											}
											zhong = "已完成测试";
										}
										//显示其他的测试
										$(".height").css("display","block");
										$(".easy").css("display","block");
									}else {//未完成
										console.log("没有完成");
										alert("请将答案填写完整！");
									}
								}
							})
						}else {
							$(".divsT"+nowTestNum).css("display","none");
							$(".divsT"+testNum).css("display","block");
							$("#next1").text("下一题");
							//点击下一题将用户选择的答案显示
							$.ajax({
								type:"GET",
								url:"../AnswerController/AnswerRest/"+stuAnswer,
								data:{
									num:(i-1)
								},
								success:function(result){
									$("input[value="+(i-1)+"-"+(result)+"]").attr("checked","checked");
								}
							})
						}
					});
	
					//上一题
					$("#before1").click(function(){
						j -= 1;
						var nowTestNum = i;
						i -= 1;
						var testNum = i;
						if(i <= 0){
							i = 1;
							$("#divs"+1).css("display","block");
						}else {
							$(".divsT"+nowTestNum).css("display","none");
							$(".divsT"+testNum).css("display","block");
							$("#next1").text("下一题");
							//点击上一题将用户选择的答案显示
							$.ajax({
								type:"GET",
								url:"../AnswerController/AnswerRest/"+stuAnswer,
								data:{
									num:(i-1)
								},
								success:function(result){
									$("input[value="+(i-1)+"-"+(result)+"]").attr("checked","checked");
								}
							})
						}
					})
				}
			}
		}
	})
	
	$(".height").click(function(){
		if(gao == "已完成测试"){
			alert("您已完成高级测试");
		}else {
			if(c != 0){
				
			}else {
				c += 1;
				//隐藏其他等级测试的题目
				for(var x = 0; x<5; x++){
					console.log("开始隐藏！！！");
					$(".divs"+(x+1)).css("display","none");
					$(".divsT"+(x+1)).css("display","none");
				}
				nanDu = "高级";
				$(".middle").css("display","none");
				$(".easy").css("display","none");
				$("h2").css("display","none");
				$("#next2, #before2").css("display","block");
				$("#next, #before").css("display","none");
				$("#next1, #before1").css("display","none");
				$.ajax({
					url:"../ExercisesController/ExerRest/3/"+course,
					type:"GET",
					success:function(result){
						console.log(result);
						//获取节点
						var $right=$("#right");
						for(var i = 0; i<result.length; i++){
							ExerCount = result.length;
							var resultMessage = result[i].value.split("@@");
							//放入正确答案
							OkAnswer2 += (resultMessage[2]+",");
							//放入题目详解
							ExerDesc2 += (resultMessage[5]+",");
							//创建测整个试题节点
							var $divs = $("<div class='divsS"+(i+1)+"'>第"+(i+1)+"题：</div>");
							//插入节点
							$right.append($divs);
							//创建题目节点
							var $divExer = $("<div class='divExer"+(i+1)+"'>"+resultMessage[1]+"</div>");
							//创建输入框节点
							var $import = $("<input type='text' id='import"+i+"' value='' class='import'></input>");
							//创建“对错”节点
							var $yesOrNo = $("<div class='yesOrNo"+i+"'></div>");
							//创建“显示正确答案”节点
							var $yesResult = $("<div class='yesResult"+i+"'></div>");
							//创建“测试题详解”节点
							var $explanation = $("<div class='explanation"+i+"'></div>");
							//添加节点到整个试题节点
							$divs.append($divExer);
							$divs.append($import);
							$divs.append($yesOrNo);
							$divs.append($yesResult);
							$divs.append($explanation);
							//给创建的整个试题节点添加CSS样式和属性
							$(".divsS"+1).css("display","block");
							$(".divsS"+(i+1)).css("display","none");
							
							//获取学生测试答案的内容
							$("#import"+i).blur(function(){
								console.log("i="+i);
								if($(this).val().length>=1){
									stuAnswerMessage2 += (j+"-"+$(this).val()+",");
									console.log("stuAnswerMessage2="+stuAnswerMessage2);
								}
							})
						}
						//添加css样式
						for(var i = 0; i<result.length; i++){
							$(".divExer"+(i+1)).css("margin-left","190px");
							$("#import"+i).css("margin-left","30px");
						}
					}
				})
				if(nanDu == "高级"){
					var i = 1;
					$("#next2").click(function(){
						console.log("高级next");
						console.log("stuAnswerMessage2===="+stuAnswerMessage2);
						j += 1;
						var nowTestNum = i;
						i += 1;
						var testNum = i;
						//判断i>返回数据的length显示“看看对错”
						if(i > ExerCount){
							i = ExerCount;
							$(".divsS"+nowTestNum).css("display","none");
							$(".divsS"+ExerCount).css("display","block");
							$("#next2").text("看看对错");
							//提交学生所选的全部答案，判断对错，并且返回正确答案
							$.ajax({
								url:"../AnswerController/AnswerRest/"+stuAnswerMessage2+"/"+ExerCount,
								type:"POST",
								data:{
									_method:"PUT"
								},
								dataType:"json",
								success:function(result){
									console.log(result.length);
									//先判断所有题目是否做答完成
									if(result.length >= ExerCount){//完成
										//提交答案后不可修改
										$('input[type="text"]').attr('readonly','true');
										console.log("完成了");
										for(var k = 0; k<result.length; k++){
											//拿正确的答案
											var OkAnswerArray2 = OkAnswer2.split(",");
											//拿题目说明
											var ExerDescArray2 = ExerDesc2.split(",");
											if(result[k].value == OkAnswerArray2[k+1]){
												$(".yesOrNo"+(k)).text("✔");
												$(".yesOrNo"+(k)).css("color","#7FFF00");
												$(".explanation"+(k)).text("题目解析："+ExerDescArray2[k+1]);
												$(".explanation"+(k)).css("display","block");
												$(".yesResult"+(k)).text("正确答案："+OkAnswerArray2[k+1]);
												$(".yesResult"+(k)).css("display","block");
											}else {
												$(".yesOrNo"+(k)).text("✖");
												$(".yesOrNo"+(k)).css("color","red");
												$(".explanation"+(k)).text("题目解析："+ExerDescArray2[k+1]);
												$(".explanation"+(k)).css("display","block");
												$(".yesResult"+(k)).text("正确答案："+OkAnswerArray2[k+1]);
												$(".yesResult"+(k)).css("display","block");
											}
											gao = "已完成测试";
										}
										//显示其他的测试
										$(".middle").css("display","block");
										$(".easy").css("display","block");
									}else {//未完成
										console.log("没有完成");
										alert("请将答案填写完整！");
									}
								}
							})
						}else {
							$(".divsS"+nowTestNum).css("display","none");
							$(".divsS"+testNum).css("display","block");
							$("#next2").text("下一题");
							//点击下一题将用户选择的答案显示
							$.ajax({
								type:"GET",
								url:"../AnswerController/AnswerRest/"+stuAnswer,
								data:{
									num:(i-1)
								},
								success:function(result){
									$("input[value="+(i-1)+"-"+(result)+"]").attr("checked","checked");
								}
							})
						}
					});
	
					//上一题
					$("#before2").click(function(){
						j -= 1;
						var nowTestNum = i;
						i -= 1;
						var testNum = i;
						if(i <= 0){
							i = 1;
							$("#divs"+1).css("display","block");
						}else {
							$(".divsS"+nowTestNum).css("display","none");
							$(".divsS"+testNum).css("display","block");
							$("#next2").text("下一题");
							//点击上一题将用户选择的答案显示
							$.ajax({
								type:"GET",
								url:"../AnswerController/AnswerRest/"+stuAnswer,
								data:{
									num:(i-1)
								},
								success:function(result){
									$("input[value="+(i-1)+"-"+(result)+"]").attr("checked","checked");
								}
							})
						}
					})
				}
			}
		}
	})
</script>
</html>