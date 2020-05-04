$("#header").load("../header.jsp");
var data = {
    menu: [{
        name: "用户管理",
        path: "#",
        subMenu: [{
            name: "用户列表",
            path: "userList.html",
            subMenu: []
        }]
    },{
        name: "科目管理",
        path: "#",
        subMenu: [{
            name: "科目列表",
            path: "../subject/subjectList.jsp",
            subMenu: []
        }]
    }, {
        name: "题库管理",
        path: "#",
        subMenu: [{
            name: "题库列表",
            path: "../topic/topicList.jsp",
            subMenu: []
        }]
    }, {
        name: "试卷管理",
        path: "",
        subMenu: [{
            name: "试卷列表",
            path: "../paper/paper.jsp",
            subMenu: []
        }]
    }, {
        name: "班级管理",
        path: "#",
        subMenu: [{
            name: "班级列表",
            path: "../grade/grade.jsp",
            subMenu: []
        }]
    }, {
        name: "错题审核",
        path: "#",
        subMenu: [{
            name: "错题列表",
            path: "../error/error.jsp",
            subMenu: []
        }]
    }, {
        name: "成绩",
        path: "#",
        subMenu: [{
            name: "成绩列表",
            path: "../record/record.jsp",
            subMenu: []
        }]
    }, {
        name: "日志",
        path: "#",
        subMenu: [{
            name: "日志列表",
            path: "../log/log.jsp",
            subMenu: []
        }]
    }]
};

$(function () {
    loadMenu(data)
});

function loadMenu(data) {
    for (var i = 0; i < data.menu.length; i++) {
        var menuBar = data.menu[i];
        var text = "";
        for (var j = 0; j < menuBar.subMenu.length; j++) {
            var subMenuBar = menuBar.subMenu[j];

            var funText = "showLinkPath(\"" + subMenuBar.name + "\",\"" + subMenuBar.path + "\")";

            var subText = "<p class='menubar' title='" + subMenuBar.name + "' onclick='" + funText + "'>" + subMenuBar.name + "</p>";

            text += subText;
        }
        $("#menu").accordion("add", {
            title: menuBar.name,
            content: text,
            selected: false
        });
    }
}

function showLinkPath(title, path) {
    if ($("#tabs").tabs("exists", title)) {// 如果该面板项已被打开则直接显示该面板项
        $("#tabs").tabs("select", title);
    } else {// 否则给中间面板添加一个对应地址的面板项并显示
        var content = "<iframe src='" + path + "'style='width:100%;height:98%;border:hidden'></iframe>";
        $("#tabs").tabs("add", {
            title: title,
            content: content,
            closable: true
        });
    }
}
