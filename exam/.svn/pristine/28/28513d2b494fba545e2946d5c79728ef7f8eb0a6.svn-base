var user={headImg:"default.jpg"};
$(function (){
    flushUserInfor();
    documentAction();
});

function flushUserInfor(){
    $.ajax({
        url : "system/loginUser",
        type : "get",
        success : function(result) {
            if(result != null){
                loadUserInformation(user=result);
            }else{
                alert("登录信息已失效，请重新登录！");
                location.href="login.html";
            }
        }
    });
}

function documentAction(){
    $("#headImgInput").hide();
    $("#headImgInput").change(function(){
        let file=$(this)[0].files.item(0);
        let reader = new FileReader();
        let AllowImgFileSize = 2100000; //上传图片最大值(单位字节)（ 2 M = 2097152 B ）超过2M上传失败

        if (file) {
            //将文件以Data URL形式读入页面
            reader.readAsDataURL(file);
            reader.onload = function (e) {
                let imgFileData = reader.result.substring(reader.result.indexOf(",") + 1);//截取base64码部分（可选可不选，需要与后台沟通）
                let fileType=file.type.substring(0,file.type.lastIndexOf("/"));
                let imgType=file.name.substring(file.name.lastIndexOf(".")+1).toLowerCase();

                if(fileType==("image")&&((imgType==("jpeg")&&(imgType="jpg"))||imgType==("jpg")||imgType==("gif")||imgType==("png"))){
                    if (AllowImgFileSize != 0 && AllowImgFileSize < imgFileData.length) {
                        let size=reader.result.length/1048576;
                        alert( "请上传不大于2MB的图片！(当前大小："+size.toFixed(2)+"MB"+")");
                        return;
                    }else{
                        //执行上传操作
                        $.ajax({
                            url:"user/attr/headImg",
                            type:"post",
                            data:{
                                _method:"PUT",
                                userId:user.userId,
                                imgType:imgType,
                                imgFileData:imgFileData
                            },
                            success:function(result){
                                if(result=="true"){
                                    flushUserInfor();
                                }
                            }
                        });
                    }
                }else{
                    alert("请选择正确的文件格式！（jpg/png/gif）")
                }
            }
        }
    });
    $("#changeHeadImg").click(function(){
        $("#headImgInput").trigger("click");
    });

    $(".inputBtn").hide();
    $(".inputBtn").blur(function(){
        $(this).hide();
        $(this).siblings("span").show();
        updateUserInformation($(this).prop("name"),$(this).val());
    });
    $(".changeBtn").click(function (){
        if($(this).siblings("span").attr("flag")){
            $(this).siblings(".inputBtn").show();
            $(this).siblings("span").hide();
            $(this).siblings(".inputBtn").focus();
            this.flag=false;
        }
    });
    
}

function loadUserTestRecord(){
    $.ajax({
        url : "records/queryByuserId",
        type : "get",
        data:{
        	userId:user.userId
        },
        success : function(result) {
            if(result!=null){
            	for(let i=0;i<result.length;i++){
            		if(i==0){
            			$("#recordTable").append($("<tr><td>试卷编号</td><td>试卷名称</td><td>考试时间</td><td>考试成绩</td></tr>"));
            		}
            		let node=$("<tr></tr>");
            		loadOneRecord(node,result[i]);
            		$("#recordTable").append(node);
            	}
            }
        }
    });
}

function loadOneRecord(node,data){
    let text="";
    text+="<td><span>"+data.paperId+"</span></td>";
    text+="<td><span>"+data.paperName+"</span></td>";
    text+="<td><span>"+data.testTime+"</span></td>";
    text+="<td><span>"+data.score+"</span></td>";
    node.html(text);
}

function updateUserInformation(iName,iValue){
    if(iValue!="" && iValue!=undefined && iValue!=""){
        let data={};
        data["_method"]="PUT";
        data["userId"]=user.userId;
        data[iName]=iValue;
        $.ajax({
            url : "user",
            type : "post",
            data:data,
            success : function(result) {
                if(result=="true"){
                    $(this).siblings("span").flag=true;
                    $(this).siblings("span").text(iValue);
                    flushUserInfor();
                }
            }
        });
    }
}

function loadUserInformation(){
    for (let key in user) {
        if(user[key] != undefined && user[key] != null){

            if(key == "headImg"){
                $("#headImg").attr("src","img/headImg/"+user.headImg);
            }else if(key =="passWord"){
                let str="";
                for(let i=0;i<user[key].length;i++){
                    str+="*";
                }
                $("#"+key).text(str);
            }else if(key =="roleId"){
            	let str="";
            	let path="login.html";
                if(user[key]==1){
                	str="学生";
                	path="examWeb/index.jsp";
                    $("#recordDiv").html($("<h6>近期考试</h6><table id='recordTable'></table>"));
                    loadUserTestRecord();
                }else if(user[key]==2){
                	str="教师";
                	path="menu/main.jsp";
                }else if(user[key]==3){
                	str="管理员";
                	path="menu/main.jsp";
                }
                $("#returnHome").attr("href",path);
                $("#role").text(str);
            }else{
                $("#"+key).text(user[key]);
            }
        }
    }
}