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
<script type="text/javascript" src="../../study/jquery-1.6.1.js"></script>
<link href = "../../study/exer.css" rel="styleSheet" type="text/css" />
<body>
	<!-- 获取测试科目名称 -->
	<%!
		String arrs[] = null;
	%>
	<%
		Map<Integer,String> exerMaps = (Map<Integer,String>)request.getAttribute("exerMap");
		exercises = exerMaps.get(1);
		arrs = exercises.split("@@");
	%>
	<div id="background">
		<div id="max">
			<div id="top"><%=arrs[4] %>测试</div>
			<div id="left">
				<div class="easy"><a href="../../ExercisesController/ExerRest/${course}" class="course_son">初级测试</a></div>
				<div class="middle"><a href="#" class="course_son">中级测试</a></div>
				<div class="height"><a href="#" class="course_son">高级测试</a></div>
			</div>
			<div id="right" style="color: white;">
				<%!
					String exercises = "";
					String arr1[] = null;
					String arr2[] = null;
					String array1[] = null;
					String array2[] = null;
				%>
				<%
					Map<Integer,String> exerMap = (Map<Integer,String>)request.getAttribute("exerMap");
					exercises = exerMap.get(1);
					arr1 = exercises.split("@@");
					%>
						<div class="test" id="test1">
							<br/>
							第 1 题：
							<%=arr1[1] %>
							<br/>
							<br/>
							<%
								array1 = arr1[2].split("#");
								for(int j = 0; j<array1.length; j++){
									%>
										&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="radio" value="<%=1 %>-<%=j %>" class="radio" message="<%=array1[j] %>" /><%=array1[j] %>&nbsp;&nbsp;&nbsp;
									<%
								}
							%>
							<div class="yesOrNo<%=1 %>" style="float: right; margin-right: 590px; margin-top: -65px; width: 50px; height: 50px;"></div>
							<div class="yesResult<%=1 %>" style="float: right; margin-right: 290px; margin-top: 70px; width: 300px; height: 30px; "></div>
							<div class="explanation<%=1 %>" style="display:none; float:right; width: 300px; height: 70px; margin-right: 290px; "></div>
						</div>
					<%
					for(int i = 2; i<=exerMap.size(); i++){
					exercises = exerMap.get(i);
					arr2 = exercises.split("@@");
						%>
							<div id="test<%=i %>" class="test" style="display: none;">
							<br/>
							第 <%=i%> 题：
							<%=arr2[1] %>
							<br/>
							<br/>
							<%
								array2 = arr2[2].split("#");
								for(int j = 0; j<array2.length; j++){
									%>
										&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="radio" value="<%=i %>-<%=j %>" class="radio" message="<%=array2[j] %>" /><%=array2[j] %>&nbsp;&nbsp;&nbsp;
									<%
								}
							%>
							<div class="yesOrNo<%=i %>" style="float: right; margin-right: 590px; margin-top: -65px; width: 50px; height: 50px;"></div>
							<div class="yesResult<%=i %>" style="float: right; margin-right: 290px; margin-top: 70px; width: 300px; height: 30px; "></div>
							<div class="explanation<%=i %>" style="display:none; float:right; width: 300px; height: 70px; margin-right: 290px; "></div>
							</div>
						<%
					}
				%>
				<button id="next" style="float: right; margin-right: 70px; margin-top: -60px; width: 80px; height: 40px;">下一题</button>
				<button id="before" style="float: right; margin-right: 170px; margin-top: -60px; width: 80px; height: 40px;">上一题</button>
				<input type="hidden" id="hiddenResult" value="${resultList }" />
				<input type="hidden" id="hiddenExplanation" value="${explanationList }" />
				<input type="hidden" id="course" value="${course }" />
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var flag = 1;
	//测试科目
	var course = $("#course").val();
	//保存题目难度等级
	var difficulty = "初级";
	$(".easy").click(function(){
		$(".middle").css("display","none");
		$(".height").css("display","none");
	})
	$(".middle").click(function(){
		$(".easy").css("display","none");
		$(".height").css("display","none");
		difficulty = "中级";
		//发送ajax请求到后台获取“中级难度”的题目
		console.log("difficulty==="+difficulty);
		$.ajax({
			url:"../../ExercisesController/ExerRest/2/"+course,
			type:"GET",
			data:{
				difficulty:difficulty
			},
			success:function(result){
				console.log("中級result="+result);
			}
		})
	})
	$(".height").click(function(){
		$(".middle").css("display","none");
		$(".easy").css("display","none");
		difficulty = "高级";
		//发送ajax请求到后台获取“高级难度”的题目
		console.log("difficulty==="+difficulty);
		$.ajax({
			url:"../../ExercisesController/ExerRest/3/"+course,
			type:"GET",
			data:{
				difficulty:difficulty
			},
			success:function(result){
				console.log("高級result="+result.length);
				console.log($(result));
				for(var x = 0; x<result.length; x++){
					console.log("......"+result[x].key+"......"+result[x].value);
					var resultValue = result[x].value.split("@@");
					console.log("i===="+i);
					console.log("x===="+x);
					$("#test"+flag).html("<br/>第"+flag+"题："+resultValue[1]+"<br/><br/>");
					$("#test"+flag).css("display","block");
				}
			}
		})
	})
	
	//获取学生测试的答案的序号
	var stuAnswer = ",";
	$(".radio").click(function(){
		stuAnswer += $(this).val()+",";
	})
	
	//获取学生测试答案的内容
	var stuAnswerMessage = ",";
	$(".radio").click(function(){
		var stuAnswer = ($(this).val()).split("-")[0];
		stuAnswerMessage += (stuAnswer+"-"+$(this).attr("message")+",");
	})
	
	
	//下一题
	var i = 1;
	$("#next").click(function(){
		var nowTestNum = i;
		i += 1;
		var testNum = i;
		console.log("i="+i);
		//判断i>返回数据的length显示“看看对错”
		if(i > 5){
			i = 5;
			$("#test"+nowTestNum).css("display","none");
			$("#test"+5).css("display","block");
			$("#next").text("看看对错");
			//提交学生所选的全部答案，判断对错，并且返回正确答案
			$.ajax({
				url:"../../AnswerController/AnswerRest/"+stuAnswerMessage,
				type:"POST",
				data:{
					_method:"PUT"
				},
				dataType:"json",
				success:function(result){
					//先判断所有题目是否做答完成
					if(result.length >= 5){//完成
						//提交答案后不可修改单选框选项
						$(':radio:not(:checked)').attr('disabled', true);
						
						for(var k = 0; k<result.length; k++){
							//拿正确的答案
							var array = $("#hiddenResult").val().split(",");
							//拿题目说明
							var explanationTrim = $.trim($("#hiddenExplanation").val().replace(/\ +/g,""));
							var array2 = explanationTrim.split("##");
							if(k==0){
								var firstArray = array[k].split("[");
								if(result[k].value == firstArray[1]){
									$(".yesOrNo"+(k+1)).text("✔");
									$(".yesOrNo"+(k+1)).css("color","#7FFF00");
									$(".explanation"+(k+1)).text("题目解析："+array2[k]);
									$(".explanation"+(k+1)).css("display","block");
									$(".yesResult"+(k+1)).text("正确答案："+firstArray[1]);
									$(".yesResult"+(k+1)).css("display","block");
								}else {
									$(".yesOrNo"+(k+1)).text("✖");
									$(".yesOrNo"+(k+1)).css("color","red");
									$(".explanation"+(k+1)).text("题目解析："+array2[k]);
									$(".explanation"+(k+1)).css("display","block");
									$(".yesResult"+(k+1)).text("正确答案："+firstArray[1]);
									$(".yesResult"+(k+1)).css("display","block");
								}
							}else if(k == result.length-1){
								var firstArray = array[k].split("]");
								var trim = $.trim(firstArray[0]);
								if(result[k].value == trim){
									$(".yesOrNo"+(k+1)).text("✔");
									$(".yesOrNo"+(k+1)).css("color","#7FFF00");
									$(".explanation"+(k+1)).text("题目解析："+array2[k]);
									$(".explanation"+(k+1)).css("display","block");
									$(".yesResult"+(k+1)).text("正确答案："+trim);
									$(".yesResult"+(k+1)).css("display","block");
								}else {
									$(".yesOrNo"+(k+1)).text("✖");
									$(".yesOrNo"+(k+1)).css("color","red");
									$(".explanation"+(k+1)).text("题目解析："+array2[k]);
									$(".explanation"+(k+1)).css("display","block");
									$(".yesResult"+(k+1)).text("正确答案："+trim);
									$(".yesResult"+(k+1)).css("display","block");
								}
							}else {
								var trim = $.trim(array[k]);
								if(result[k].value == trim){
									$(".yesOrNo"+(k+1)).text("✔");
									$(".yesOrNo"+(k+1)).css("color","#7FFF00");
									$(".explanation"+(k+1)).text("题目解析："+array2[k]);
									$(".explanation"+(k+1)).css("display","block");
									$(".yesResult"+(k+1)).text("正确答案："+trim);
									$(".yesResult"+(k+1)).css("display","block");
								}else {
									$(".yesOrNo"+(k+1)).text("✖");
									$(".yesOrNo"+(k+1)).css("color","red");
									$(".explanation"+(k+1)).text("题目解析："+array2[k]);
									$(".explanation"+(k+1)).css("display","block");
									$(".yesResult"+(k+1)).text("正确答案："+trim);
									$(".yesResult"+(k+1)).css("display","block");
								}
							}
						}
					}else {//未完成
						alert("请将答案填写完整！");
					}
				}
			})
		}else {
			$("#test"+nowTestNum).css("display","none");
			$("#test"+testNum).css("display","block");
			$("#next").text("下一题");
			console.log("下一题-stuAnswer="+stuAnswer);
			//点击下一题将用户选择的答案显示
			$.ajax({
				type:"GET",
				url:"../../AnswerController/AnswerRest/"+stuAnswer,
				data:{
					num:i
				},
				success:function(result){
					$("input[value="+i+"-"+result+"]").attr("checked","checked");
				}
			})
		}
	})
	
	//上一题
	$("#before").click(function(){
		var nowTestNum = i;
		i -= 1;
		var testNum = i;
		if(i <= 0){
			i = 1;
			$("#test"+1).css("display","block");
		}else {
			$("#test"+nowTestNum).css("display","none");
			$("#test"+testNum).css("display","block");
			$("#next").text("下一题");
			//点击上一题将用户选择的答案显示
			$.ajax({
				type:"GET",
				url:"../../AnswerController/AnswerRest/"+stuAnswer,
				data:{
					num:i
				},
				success:function(result){
					console.log("下一题："+result);
					$("input[value="+i+"-"+result+"]").attr("checked","checked");
				}
			})
		}
	})
</script>
</html>