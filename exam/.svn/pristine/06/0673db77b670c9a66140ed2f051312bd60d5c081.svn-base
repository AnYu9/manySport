$("#loginDiv input").on("input",function (){
    $("#errorMessage").text("");
});

function login(){
    var username=$("#userName").val();
    var password=$("#password").val();
    if(userName == ""){
        $("#errorMessage").text("请输入用户名！");
        return;
    }else if(password == ""){
        $("#errorMessage").text("请输入密码！");
        return;
    }
    loginUser(username,password);
    $("#password").val("");
}

function loginUser(userName,password){
    $.ajax({
        url : "user/Login",
        type : "post",
        data:{
            userName:userName,
            password:password
        },
        success : function(result) {
        	if(result == "userDisable"){
        		alert("该用户已被管理员冻结！");
            }else if(result != "" && result != null){
        		window.location.href=result;
            }else{
                $("#errorMessage").text("账号或密码错误！");
            }
        }
    });
}

function loadUserHeadImg(userName){
    $.ajax({
        url : "user/attr/headImg",
        type : "get",
        data:{
            userName:userName
        },
        success : function(result) {
            if(result != "" && result != null){
                var src="img/headImg/"+result;
                $("#headImg").attr("src",src);
            }else{
                $("#headImg").attr("src","img/headImg/default.jpg");
            }
        }
    });
}

$("#submit").click(function (){
	login();
});



window.onkeydown=function (ev){
    if(ev.keyCode==13){
    	login();
    }
}