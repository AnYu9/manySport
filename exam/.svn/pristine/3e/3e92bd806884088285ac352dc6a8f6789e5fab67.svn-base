<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>试卷</title>
<script src="../easyui/jquery.min.js"></script>
<link rel="stylesheet" href="../css/paper.css">
</head>
<body>
	<div id="app">
		<div id="header"></div>
		<div id="main">
			<div id="contains">
				<div id="exam">
					<div id="examHead">
						<div id="examName"><h2>${paper.paperName }</h2></div>
						<div id="eInfo">
							<span>姓名:${user.userName}</span>
							<span id="km">科目:${paper.subjectName }</span>
							<span id="zf">试卷总分:${paper.testSource }分</span>
							<span id="sj">考试时长:${paper.testdate }分钟</span>
						</div>
					</div>
					<div id="examBody">
						<div id="giao">
							<div id="tmTitle">
								<p></p>
							</div>
							<div id="tmBody">
								<div id="tm">
									<p></p>
								</div>
								<div id="options">
									
								</div>
							</div>
						</div>
					</div>
					<div id="tmChoose">
							<button id="prev">上一题</button>
							<button id="next">下一题</button>
							<button id="bug">上报错题</button>
					</div>
				</div>
				<div id="choose">
					<div id="time">
						<span></span>
					</div>
					<div id="flag">
						<span>🔠已答题目</span>
						<span>◻未答题目</span>
					</div>
					<div id="xxl">
						
					</div>
					<div id="anwer">
						<p id="submitExam">提交试卷</p>
					</div>
				</div>
			</div>
		</div>
		<div id="textarea">
			<input type="text" name="des" id="des" placeholder="请输入错误题目的描述！"/><br/>
			<button id="over">取消</button>
			<button id="ok">确认</button>
		</div>
	</div>
	<script>
		let paperName = "";
		paperName+="${paper.paperName}";
		var oBox = $('#time span')[0];
		var maxtime = ${paper.testdate } * 60;
		timer = setInterval("CountDown()", 1000);
	    function CountDown() {
	        if (maxtime >= 0) {
	            minutes = Math.floor(maxtime / 60);
	            seconds = Math.floor(maxtime % 60);
	            msg = "距离考试结束还有" + minutes + "分" + seconds + "秒";
	            oBox.innerHTML = msg;
	            --maxtime;
	            } else{
	                    clearInterval(timer);
	                    $.ajax({
	    					url:'../paper/paperScore',
	    					type:'post',
	    					data:{'answer':JSON.stringify(answer),'paperId':${paper.paperId},'time':(${paper.testdate}*60)-maxtime,'paperName':paperName},
	    					success:function(result){
	    						if(result!=null){
	    							alert("时间到，考试结束!");
	    							location.href="../examWeb/score.jsp";
	    						}
	    					},
	    					error:function(msg){
	    						console.log(msg);
	    					}
	    				});
	            }
	    }        
		let num = 1;
		let option = $('#options');
		let answer = [];
		let lis = [];
		let tmType = $('#tmTitle p');
		$(function(){
			$("#header").load("../header.jsp");
			 $.ajax({
				url:'../paper/querymap',
				type:'post',
				data:{'paperId':${paper.paperId}},
				success:function(result){
					tmType.text("选择题");
					let data = [];
					for(let tm in result){
						for(let i=0;i<result[tm].length;i++){
							data.push(result[tm][i]);
						}
					}
					init(data);
				},
				error:function(msg){
					console.log(msg);
				}
			});
		});
		function init(data){
			data.map(item=>item.result="");
			$('#prev').click(function(e){
				num-=1;
				if(num<=1){
					num=1;
				}
				tmType.text(data[num-1].type);
				createOptions(data[num-1],num);
			});
			$('#next').click(function(e){
				num+=1;
				let arr = Array.from($('#options input'));
				examAnswer(data[num-1-1],arr,data);
				if(num>=data.length){
					num=data.length;
				}
				tmType.text(data[num-1].type);
				createOptions(data[num-1],num);
			});
			$('#submitExam').click(function(e){
				let arr = Array.from($('#options input'));
				examAnswer(data[num-1],arr,data);
				console.log(answer);
				$.ajax({
					url:'../paper/paperScore',
					type:'post',
					data:{'answer':JSON.stringify(answer),'paperId':${paper.paperId},'time':(${paper.testdate}*60)-maxtime,'paperName':paperName},
					success:function(result){
						if(result!=null){
							alert('交卷成功！');
							location.href="../examWeb/score.jsp";
						}
					},
					error:function(msg){
						console.log(msg);
					}
				});
			});
			$('#bug').click(function(e){
				$('#textarea').css({display:'block'});
				$('#over').click(function(e){
					$('#textarea').css({display:'none'});
				});
				$('#ok').click(function(e){
					let des = $('#des').val();
					$.ajax({
						url:'../error/save',
						type:'get',
						data:{'topicId':data[num-1].topId,'paperId':${paper.paperId},'errordes':des},
						success:function(result){
							alert('错题上报成功！');
							$('#textarea').css({display:'none'});
						},
						error:function(msg){
							console.log(msg);
						}
					});
				});
			});
			xzt("选择题",data);
			dxt("多选题",data);
			tkt("填空题",data);
			pdt("判断题",data);
			yyt("应用题",data);
		}
		
		function examAnswer(elem,arr,data){
			if(elem==undefined){
				return;
			}
			let index = data.indexOf(elem);
			
			if(arr.length>1){
				for(let i =0;i<arr.length;i++){
					if(arr[i].checked && elem.type=="多选题"){
						data[index].result+=arr[i].value;
					}else if(arr[i].checked){
						data[index].result=arr[i].value;
						break;
					}
				}
			}else{
				data[index].result=$('#options input').val();
			}
			if(elem.result.trim().length>0){
				for(let i=0;i<answer.length;i++){
					if(elem.topId==answer[i].topId && elem.topId!=undefined){
						delete answer[i];
					}
				}
				answer.push(data[index]);
			}
			if(data[index].result.length>=1){
				$(lis[index]).css({
					background:'rgb(28,128,190)',
					color:'white'
				});
			}else{
				$(lis[index]).css({
					background:'white',
					color:'black'
				});
			}
		}
		
		function xzt(type,arr){
			let s=arr.filter(item=>item.type==type);
			if(s.length<=0){
				return;
			}
			createOptsBar(type);
			let ul = $($('.cLi')[0]);
			createElem(s,ul,arr);
			createOptions(arr[0],1);
		}
		
		function dxt(type,arr){
			let s=arr.filter(item=>item.type==type);
			if(s.length<=0){
				return;
			}
			createOptsBar(type);
			let ul = $($('.cLi')[1]);
			createElem(s,ul,arr);
		}
		function tkt(type,arr){
			let s=arr.filter(item=>item.type==type);
			if(s.length<=0){
				return;
			}
			createOptsBar(type);
			let ul = $($('.cLi')[2]);
			createElem(s,ul,arr);
			num=1;
		}
		
		function pdt(type,arr){
			let s=arr.filter(item=>item.type==type);
			if(s.length<=0){
				return;
			}
			createOptsBar(type);
			let ul = $($('.cLi')[3]);
			createElem(s,ul,arr);
		}
		
		function yyt(type,arr){
			//let ul = $($('.cLi')[4]); 应用题
			
		}
		
		function createOptions(elem,no){
			let title = $($('#tm p')[0]);
			title.text(no+"、"+elem.title);
			$('#options p').remove();
			if(elem.type=="选择题"){
				choose(elem,option);
			}else if(elem.type=="多选题"){
				chooses(elem,option);
			}else if(elem.type=="填空题"){
				topic(elem,option);
			}else if(elem.type=="判断题"){
				tOrf(elem,option);
			}else if(elem.type=="应用题"){
				//
			}
			
		}
		
		function createElem(arr,parent,data){
			for(let i=1;i<=arr.length;i++){
				let li = $('<li></li>').text(num).appendTo(parent).click(function(e){
					let arr = Array.from($('#options input'));
					examAnswer(data[num-1],arr,data);
					num=parseInt($(this).text());
					tmType.text(data[parseInt($(this).text())-1].type);
					createOptions(data[parseInt($(this).text())-1],parseInt($(this).text()));
				});
				lis.push(li);
				num++;
			}
		}
		
		function createOptsBar(type){
			let parent = $('#xxl');
			let tmNo = $('<div class="tmNo"></div>').appendTo(parent);
			let p = $('<p></p>').text(type).appendTo(tmNo);
			let ul = $('<ul class="cLi"></ul>').appendTo(tmNo);
		}
		
		function choose(elem,parent){
			let inputa = "<input type='radio' name='choose' id='oa' value='A'/>";
			let inputb = "<input type='radio' name='choose' id='ob' value='B'/>";
			let inputc = "<input type='radio' name='choose' id='oc' value='C'/>";
			let inputd = "<input type='radio' name='choose' id='od' value='D'/>";
			if(elem.result.length>0){
				if(elem.result=="A"){
					inputa = "<input type='radio' name='choose' id='oa' value='A' checked/>";
				}else if(elem.result=="B"){
					inputb = "<input type='radio' name='choose' id='ob' value='B' checked/>";
				}else if(elem.result=="C"){
					inputc = "<input type='radio' name='choose' id='oc' value='C' checked/>";
				}else if(elem.result=="D"){
					inputd = "<input type='radio' name='choose' id='od' value='D' checked/>";
				}
			}
			let pa = $('<p></p>').appendTo(parent);
			pa.html(inputa);
			let spana = $('<span>A、</span>').appendTo(pa);
			let labela = $('<label for="oa"></label>').text(elem.a).appendTo(spana);
			
			let pb = $('<p></p>').appendTo(parent);
			pb.html(inputb);
			let spanb = $('<span>B、</span>').appendTo(pb);
			let labelb = $('<label for="ob"></label>').text(elem.b).appendTo(spanb);
			
			let pc = $('<p></p>').appendTo(parent);
			pc.html(inputc);
			let spanc = $('<span>C、</span>').appendTo(pc);
			let labelc = $('<label for="oc"></label>').text(elem.c).appendTo(spanc);
			
			let pd = $('<p></p>').appendTo(parent);
			pd.html(inputd);
			let spand = $('<span>D、</span>').appendTo(pd);
			let labeld = $('<label for="od"></label>').text(elem.d).appendTo(spand);
		}
		function chooses(elem,parent){
			let inputa = "<input type='checkbox' name='choose' id='oa' value='A'/>";
			let inputb = "<input type='checkbox' name='choose' id='ob' value='B'/>";
			let inputc = "<input type='checkbox' name='choose' id='oc' value='C'/>";
			let inputd = "<input type='checkbox' name='choose' id='od' value='D'/>";
			if(elem.result.length>0){
				if(elem.result.indexOf("A") != -1){
					inputa = "<input type='checkbox' name='choose' id='ob' value='B' checked/>";
				}
				if(elem.result.indexOf("B") != -1){
					inputb = "<input type='checkbox' name='choose' id='ob' value='B' checked/>";
				}
				if(elem.result.indexOf("C") != -1){
					inputc = "<input type='checkbox' name='choose' id='oc' value='C' checked/>";
				}
				if(elem.result.indexOf("D") != -1){
					inputd = "<input type='checkbox' name='choose' id='od' value='D' checked/>";
				}
			}
			let pa = $('<p></p>').appendTo(parent);
			pa.html(inputa);
			let spana = $('<span>A、</span>').appendTo(pa);
			let labela = $('<label for="oa"></label>').text(elem.a).appendTo(spana);
			
			let pb = $('<p></p>').appendTo(parent);
			pb.html(inputb);
			let spanb = $('<span>B、</span>').appendTo(pb);
			let labelb = $('<label for="ob"></label>').text(elem.b).appendTo(spanb);
			
			let pc = $('<p></p>').appendTo(parent);
			pc.html(inputc);
			let spanc = $('<span>C、</span>').appendTo(pc);
			let labelc = $('<label for="oc"></label>').text(elem.c).appendTo(spanc);
			
			let pd = $('<p></p>').appendTo(parent);
			pd.html(inputd);
			let spand = $('<span>D、</span>').appendTo(pd);
			let labeld = $('<label for="od"></label>').text(elem.d).appendTo(spand);
		}
		function topic(elem,parent){
			let input = "<input type='text' name='choose' placeholder='请在此处填写答案！'/>";
			if(elem.result.trim().length>0){
				input = "<input type='text' name='choose' value="+elem.result+">";
			}
			let pa = $('<p></p>').appendTo(parent);
			pa.html(input);
		}
		function tOrf(elem,parent){
			let pa = $('<p></p>').appendTo(parent);
			let inputa = $('<input type="radio" name="choose" id="oa" value="t"/>').appendTo(pa);
			let spana = $('<span>正确</span>').appendTo(pa);
			let labela = $('<label for="oa"></label>').text(elem.a).appendTo(spana);
			
			let pb = $('<p></p>').appendTo(parent);
			let inputb = $('<input type="radio" name="choose" id="ob" value="f"/>').appendTo(pb);
			let spanb = $('<span>错误</span>').appendTo(pb);
			let labelb = $('<label for="ob"></label>').text(elem.b).appendTo(spanb);
		}
		
	</script>
</body>
</html>