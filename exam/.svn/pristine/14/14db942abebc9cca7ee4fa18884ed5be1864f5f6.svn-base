<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在线学习</title>
<script type="text/javascript" src="jquery-1.6.1.js"></script>
<script src="../js/jquery.min.1.7.js"></script>
   <script type="text/javascript" src="../js/modernizr.2.5.3.min.js"></script>
     <script type="text/javascript" src="../js/turn.js"></script>

<link href="../css/basic.css">

</head>

<style>
	#max {
		margin: 0px auto;
		width: 1400px;
		height: auto;
	}
	
	#top {
		margin: 0px auto;
		width: 1200px;
		height: 60px;
		/* border-bottom: 2px solid #7092be; */
		text-align: center;
	}
	
	#center{
		width:1200px; 
		margin: 0px auto;
	}
	
	.course:first-child{
		margin-top: 25px;
	}
	
	.course{
		background-color: #8baee2;
		font-size:18px;
		color: white;
		width: 106px;
		height: 52px;
		margin-bottom: 30px;
		margin-left: 10px;
		margin-right: 30px;
		line-height: 2.7;
		text-align: center;
		box-shadow: 0 0 0 gray,5px 5px 5px #7092be;
	}
	
	.course_son{
		width: 107px;
		height: 48px;
		border: 1px solid #7092be;
		float: left;
		margin-left: 80px;
		margin-top: 30px;
		border-radius: 15px;
		text-align: center;
		line-height: 3;
		background-color: #c5d2f5;
	}
	
	#center a{
		color: #345a94;
		text-decoration: none;
	}
	
 	#center a:hover {
		color: black;
	}
	
	#bottom{
		width: 1200px;
		margin: 0px auto;
	}
	
	#exercises{
		width: 123px;
		height: 52px;
		background-color: #e09875;
		color: white;
		margin-left:3px;
		margin-right: 20px;
		text-align: center;
		line-height: 3;
		box-shadow: 0 0 0 gray,5px 5px 5px gray;
	}
	
	.test{
		width: 130px;
		height: 60px;
		float: left;
		margin-left: 65px;
		margin-bottom: 42px;
		border-radius: 15px;
		text-align: center;
		line-height: 3;
	}
	
	#bottom a{
		color: #e94405;
		text-decoration: none;
	}
	
	#bottom a:hover {
		color: orange;
	}
	
	#back1{
		width: 1250px;
		float: left;
		background: url("../penImg/sv1.png") 680px -13px no-repeat,
					url("../penImg/sv1.png") 870px -13px no-repeat,
					url("../penImg/sv1.png") 1057px -13px no-repeat;
	}
	
	#back2{
		width: 1250px;
		float: left;
		background: url("../penImg/sv1.png") 870px -13px no-repeat,
			 		url("../penImg/sv1.png") 1060px -13px no-repeat,
					url("../penImg/sv1.png") 305px 68px no-repeat,
					url("../penImg/sv1.png") 495px 68px no-repeat;
	}

	
	
	
	*{
            padding:0px;
            margin:0px;

        }
       
        #iimg{
            position: absolute;
            cursor:pointer;
            left:40px;
            top:300px;
        }
      
        #book2{
            display: none;
            position: absolute;
            right: 0px;
            width: 550px;
            height: 540px;
            
        }
        .flipbook{

         margin-left: 0px !important;

        }
      
        #close1{
            width: 24px;
            height: 25px;
            background: url("../img/bbb.png");
            position: absolute;
            left: 520px;
            z-index: -1;
        }

        input{

            background-color: rgba(0,0,0,0);
            border: 0px;
            font-size: 14px;
            border-bottom: #000 1px solid;
        }
        .books{

            font-size: 10px;

        }
        .text input{
            width: 210px;
            font-size: 12px;
        }
        .text{
            width: 210px;
            position: relative;
            top: 16px;
            left: 15px;
        }
	
</style>
<body>



<img id="iimg" src="../img/notebook.png" alt="单击拖动，双击进入小本本"/>

    <div id="book2" class="flipbook-viewport" >
        <div class="container" >
            <div id="close1" > </div>
            <div class="flipbook" id="flipbook1">
                <div id = "a1" style="background-image:url(../img/封面.png)"></div>
                <div id = "a2"  style="background-image:url(../img/第二页.png)"></div>
                <div id = "a3"  style="background-image:url(../img/第三页.png)"></div>
                <div id = "a4"  style="background-image:url(../img/无标题.png)"></div>
                <div id = "a5"  style="background-image:url(../img/正页.png)">
                    <div class = "books">
                        <div style=" position: relative; top: 4px; left:127px;">日期：<input style="width: 70px; " size="15"/></div>
                        <div class="text">
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                        </div>
                    </div>
                </div>
                <div id = "a6" class = "books"  class = " " style="background-image:url(../img/反面.png)">
                    <div class = "books" >
                        <div style=" position: relative; top: 4px; left:127px;">日期：<input style="width: 70px; " size="15"/></div>
                        <div class="text">
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                        </div>
                    </div>
                </div>
                <div id = "a7" class = "books" style="background-image:url(../img/正页.png)">
                    <div class = "books">
                        <div style=" position: relative; top: 4px; left:127px;">日期：<input style="width: 70px; " size="15"/></div>
                        <div class="text">
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                        </div>
                    </div>
                </div>
                <div id = "a8" class = "books" style="background-image:url(../img/反面.png)">
                    <div class = "books">
                        <div style=" position: relative; top: 4px; left:127px;">日期：<input style="width: 70px; " size="15"/></div>
                        <div class="text">
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                        </div>
                    </div>
                </div>
                <div id = "a9" class = "books" style="background-image:url(../img/正页.png)">
                    <div class = "books">
                        <div style=" position: relative; top: 4px; left:127px;">日期：<input style="width: 70px; " size="15"/></div>
                        <div class="text">
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                        </div>
                    </div>
                </div>
                <div id = "a10" class = "books" style="background-image:url(../img/反面.png)">
                    <div class = "books">
                        <div style=" position: relative; top: 4px; left:127px;">日期：<input style="width: 70px; " size="15"/></div>
                        <div class="text">
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                            <input /><br>
                        </div>
                    </div>
                </div>
                <div id = "a11" class = "books" style="background-image:url(../img/尾正.png)"></div>
                <div id = "a12"  style="background-image:url(img/尾页.png)"></div>
            </div>

    </div>
</div>

	<div id="max">
		<div id="top" style="box-shadow: 0 0 0 gray,5px 5px 5px #7092be">
			<span style="color: gray; font-size: 12px; margin-left: -380px;">学而不思则罔，思而不学则殆 ——老子</span>
			<span style="font-size: 27px; color: #7092be; line-height: 2; margin-left:200px;">
				在线学习小课堂
			</span>
			<span id="returnHome" style="margin-right: 50px; margin-top: 15px; float: right;" title="返回首页"><img alt="返回首页" src="../penImg/sreturn.png" width="30px" height="29px"></span>
		</div>
		<!-- <span style="font-size: 14px; margin-left: 110px; color: red; margin-top: 20px; float: left;">当前学习积分：</span><br/> -->
		<div id="center">
			<!-- <div style="margin-left: 9px; opacity:0.8;"><img src="../penImg/pen15.png"/></div> -->
			<div style="margin-top: 15px;" id="back1">
				<div class="course" style="float: left;">后端技术</div>
				<div class="course_son"><a href="../YouDaoYun/qqD2D49272AACFC668427E83C8BA732091_2020-01-14-15-06/4.JAVA基础/类和对象.pdf">Java</a></div>
				<div class="course_son"><a href="../YouDaoYun/qqD2D49272AACFC668427E83C8BA732091_2020-01-14-15-06/5.数据库/MySQL/一.简单的SQL语句（创建，删除，插入，查看）.pdf">MySQL</a></div>
				<div class="course_son"><a href="#">Python</a></div>
				<div class="course_son"><a href="#">PHP</a></div>
				<div class="course_son"><a href="#">C#</a></div>
			</div>
			<!-- <div style="clear:left; border-top: 1px solid #7092BE; width: auto; margin-left: 200px;"></div> -->
			<div>
				<div class="course" style="clear: both; float: left;">前端技术</div>
				<div class="course_son"><a href="../YouDaoYun/qqD2D49272AACFC668427E83C8BA732091_2020-01-14-15-06/1.HTML/第五章：框架.pdf">HTML</a></div>
				<div class="course_son"><a href="../YouDaoYun/qqD2D49272AACFC668427E83C8BA732091_2020-01-14-15-06/2.CSS/第一章：初识CSS.pdf">CSS</a></div>
				<div class="course_son"><a href="../YouDaoYun/qqD2D49272AACFC668427E83C8BA732091_2020-01-14-15-06/3.JavaScript/Ajax和Json.pdf">JavaScript</a></div>	
			</div>
			<div id="back2">
				<div class="course" style="clear: both; float: left;">框架</div>
				<div class="course_son"><a href="../YouDaoYun/qqD2D49272AACFC668427E83C8BA732091_2020-01-14-15-06/7.jQuery 框架/jQuery选择器、事件.pdf">jQuery</a></div>
				<div class="course_son"><a href="../YouDaoYun/qqD2D49272AACFC668427E83C8BA732091_2020-01-14-15-06/10.Spring 框架/2、控制反转(依赖注入).pdf">Spring</a></div>
				<div class="course_son"><a href="../YouDaoYun/qqD2D49272AACFC668427E83C8BA732091_2020-01-14-15-06/8.Spring MVC 框架/1、环境搭建.pdf">SpringMVC</a></div>
				<div class="course_son"><a href="../YouDaoYun/qqD2D49272AACFC668427E83C8BA732091_2020-01-14-15-06/Spring boot/1、Spring boot.pdf">SpringBoot</a></div>
				<div class="course_son"><a href="../YouDaoYun/qqD2D49272AACFC668427E83C8BA732091_2020-01-14-15-06/Vue 框架/一、模板语法.pdf">Vue</a></div><br/>
				<div class="course_son"><a href="#">Mybatis</a></div>
				<div class="course_son"><a href="../YouDaoYun/qqD2D49272AACFC668427E83C8BA732091_2020-01-14-15-06/Maven/2、使用Maven.pdf">Maven</a></div>
			</div>
			<div>
				<div class="course" style="clear: both; float: left; margin-bottom: 130px;">高考必备</div>
				<div class="course_son"><a href="#">语文</a></div>
				<div class="course_son"><a href="#">数学</a></div>
				<div class="course_son"><a href="#">英语</a></div>
				<div class="course_son"><a href="#">物理</a></div>
				<div class="course_son"><a href="#">化学</a></div>
				<div class="course_son"><a href="#">政治</a></div>
				<div class="course_son"><a href="#">历史</a></div>
			</div>
		</div>
		<div id="bottom">
			<div>
				<div id="exercises" style="clear:both; float: left;">开始测试</div>
				<div class="test"><img src="../penImg/pen001.png" style="display: inline; vertical-align: middle;" width="45px" height="45px" /><a href="exercises2.jsp?course=java">Java测试</a></div>
				<div class="test"><img src="../penImg/pen003.png" style="display: inline; vertical-align: middle;" width="45px" height="45px" /><a href="exercises2.jsp?course=html">HTML测试</a></div>
				<div class="test"><img src="../penImg/pen009.png" style="display: inline; vertical-align: middle;" width="45px" height="45px" /><a href="exercises2.jsp?course=css">CSS测试</a></div>
				<div class="test"><img src="../penImg/pen004.png" style="display: inline; vertical-align: middle;" width="45px" height="45px" /><a href="exercises2.jsp?course=jquery">jQuery测试</a></div>
				<div class="test"><img src="../penImg/pen005.png" style="display: inline; vertical-align: middle;" width="45px" height="45px" /><a href="exercises2.jsp?course=zong">综合练习</a></div>
				<div class="test" style="margin-left: 210px;"><img src="../penImg/pen12.png" style="display: inline; vertical-align: middle;" width="50px" height="50px" /><a href="exercises2.jsp?course=chinese">语文测试</a></div>
				<div class="test"><img src="../penImg/pen13.png" style="display: inline; vertical-align: middle;" width="45px" height="45px" /><a href="exercises2.jsp?course=math">数学测试</a></div>
				<div class="test"><img src="../penImg/pen14.png" style="display: inline; vertical-align: middle;" width="45px" height="45px" /><a href="exercises2.jsp?course=english">英语测试</a></div>
			</div>
			<div id="bookImg" style="float: right; margin-right:80px;"><img src="../penImg/book001.png" /></div>
		</div>
	</div>

	
	
	

	
</body>
<script type="text/javascript">
	$(".course_son").mouseenter(function(){
		$(this).css("background","#7092be");
	})
	$(".course_son").mouseleave(function(){
		$(this).css("background","#c5d2f5");
	})
	$("#returnHome").click(function(){
		//返回主页
		$(location).attr('href','../examWeb/index.jsp');
	})
</script>

<script>


   

</script>

<script>
 var div = $("#iimg");
    var book = $("#book2");
    let close1 = $("#close1");
    addMouse(div);
    $("#book2").mousedown(mouseHandler)


    //添加一个鼠标事件
    function addMouse(elem) {
        elem.mousedown(mouseHandler);
        elem.dblclick(notebook)
    }

    function notebook(e){
        console.log(e);
        console.log(this)
        $(this).hide();
        $("#book2").show();
    }


    function mouseHandler(e) {
        console.log(e.type,"asdsa");
        switch (e.type) {
            case "mousedown":
                e.preventDefault();
                if(e.button ==2){
                    //鼠标移动时还是进入到mouseHandler的mousemove中
                    document.addEventListener("mousemove", mouseHandler);
                    //鼠标释放时还是进入到mouseHandler的mouseup中
                    document.addEventListener("mouseup", mouseHandler);
                    // console.log(this);
                    this.x1 = e.offsetX;//this是div
                    this.y1 = e.offsetY;
                    document.elem = this;
                }else if(e.button ==0){
                    $("#flipbook1")
                }else if(e.button ==1){
                    $(this).hide();
                    $("#iimg").show();
                    
                }

                break;
            case "mousemove":
                $(this).css("cursor","move");
                this.elem.style.left = e.clientX - this.elem.x1 + "px";
                console.log(this.elem.style.left );
                this.elem.style.top = e.clientY - this.elem.y1 + "px";
                this.elem.style.cursor='move';
                break;

            case "mouseup":
                document.removeEventListener("mousemove", mouseHandler);
                document.removeEventListener("mouseup", mouseHandler);
                $(this).css("cursor","pointer");
                this.elem.style.cursor='pointer';
                break;

        }
    }

    function loadApp() {

        // Create the flipbook

        $('.flipbook').turn({
            // Width

            width:500,

            // Height

            height:360,

            // Elevation

            elevation: 50,

            // Enable gradients

            gradients: true,

            // Auto center this flipbook

            autoCenter: true

        });
    }



    yepnope({
        test : Modernizr.csstransforms,
        yep: ['../js/turn.js'],
        nope: ['../js/turn.js'],
        both: ['../css/basic.css'],
        complete: loadApp
    });
</script>


</html>
