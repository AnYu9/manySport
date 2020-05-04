	$(function(){
		$.ajax({
			url:'../user/attr/total',
			type:'get',
			success:function(result){
				$("p:first>span").text(result);
			}
		});
		
		$.ajax({
			url:'../paper/getPaperCount',
			type:'get',
			success:function(result){
				$("p:last>span").text(result);
			}
		});
	}) ;
// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById("main"));
    // 指定图表的配置项和数据
    var option = {
        // 标题
        title: {
            text: '各科目题库',
            subtext:'不区分题型',
            left:'left',
            borderColor:'red',
            borderWidth:3
        },
        // 工具箱
        toolbox: {
            show: true,
            feature:{
                saveAsImage:{
                    show:true
                },
                restore:{
                    show:true
                },
                dataView:{
                    show:true
                },
                dataZoom:{
                    show:true
                },
                magicType:{
                    type:['line','bar']
                }

            }
        },
        tooltip:{
            trigger:'axis'
        },
        // 图例
        legend: {
            data: ['试题数量']
        },
        // x轴
        xAxis: {
            data: ["c语言", "java", "英语", "数学", "语文", "html"]
        },
        yAxis: {},
        // 数据
        series: [{
            name: '数量',
            type: 'bar',
            data: [35, 42, 36, 30, 10, 20],
            markPoint:{
                data:[
                    {type:'max',name:'最大值'},
                    {type:'min',name:'最小值',symbol:'arrow'}
                ]
            },
            markLine:{
                data:[
                    {type: 'average',name:'平均值'}
                ]
            }
        }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
	
	
	var myChart2 = echarts.init(document.getElementById('main2'));

	myChart2.setOption({
		series : [ {
			name : '访问来源',
			type : 'pie', // 设置图表类型为饼图
			radius : '55%', // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
			data : [ // 数据数组，name 为数据项名称，value 为数据项值
			{
				value : 35,
				name : '选择题'
			}, {
				value : 40,
				name : '填空题'
			}, {
				value : 5,
				name : '判断题'
			}, {
				value : 12,
				name : '多选题'
			} ]
		} ]
	});
	
	