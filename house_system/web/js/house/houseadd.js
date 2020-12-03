$(function(){
	init();
	//数据验证
	//checkItem();
	//提交表单位
	commitItem();
});
/****************获得焦点********************/
function init() {
	$("#haddress").focus();
	
	//得到下拉框的值 
	$.ajax({
		url:'/web_example_war_exploded/sort?type=findall',
		dataType:'json',
		type:'post',
		data:'',
		async : false,
		success:function(mydata)
		{
		   $.each(mydata,function(index,xx){
			   $("#sid").append("<option value="+xx.sid+">"+xx.sname+"</option>");
		   });
		}
	});
	
	$.ajax({
		url:'/web_example_war_exploded/area?type=findall',
		dataType:'json',
		type:'post',
		data:'',
		async : false,
		success:function(mydata)
		{

		   $.each(mydata,function(index,xx){
			   $("#aid").append("<option value="+xx.aid+">"+xx.aname+"</option>");
		   });
		}
	});
};
/******************失去焦点事件****************************/
function checkItem()
{
	$("#sname").focusout(function(){
		var sname=$("#sname").val();
		if(sname.length==0)
			{
			   layer.tips('类型名称不能为空！','#sname',{tips:[2,'red']});
			}
		else
			{
			   $.ajax({
				   url:'sort_getAllName.action',
				   dataType:'json',
				   type:'post',
				   data:{sname:sname},
				   async : false,
				   success:function(mydata)
				   {
					   if(mydata==0)
						   {
						      $("#sname").addClass("newsuccess");
					          $("#sname").removeClass("newerror");
						   }
					   else
						   {
						       layer.tips('对不起类型已存在！','#sname',{tips:[2,'red']});
						   }
					   $("#botao").val(mydata);
				   }
			   });
			}
	});
}
/******************************提交表单********************************/
function commitItem()
{
	$(".btn").bind("click",function(){
	var sid = $("#sid").val();
	var aid = $("#aid").val();
	var haddress = $("#haddress").val();
	var hfh = $("#hfh").val();
	var hhx = $("#hhx").val();
	var hmj = $("#hmj").val();
	var hcx = $("#hcx").val();
	var hmoney = $("#hmoney").val();
	var hwf = $("#hwf").val();
	var hdx = $("#hdx").val();
	var hsf = $("#hsf").val();
	var hmq = $("#hmq").val();
	var dkd = $("#dkd").val();
	var skd = $("#skd").val();
	var mkd = $("#mkd").val();
	var hjp = $("#hjp").val();
	var hremark = $("#hremark").val();
	
	var x1=$("#doc1").val();
	var x2=$("#doc2").val();
	var x3=$("#doc3").val();
	
	// if(x1.length==0||x2.length==0||x3.length==0)
	// 	{
	//
	//     	     parent.layer.msg('必须上传三张相片！',{icon:2});
	// 	}
	// else
			{
			var mypart = "sid=" + sid + "&aid=" + aid+ "&haddress="+haddress+"&hfh="+hfh+"&hhx="+hhx+"&hmj="+hmj+"&hcx="+hcx+"&hmoney="+hmoney+
				"&hwf="+hwf+"&hdx="+hdx+"&hsf="+hsf+"&hmq="+hmq+"&dkd="+dkd+"&skd="+skd+"&mkd="+mkd+"&hjp="+hjp+"&hremark="+hremark;
			var i = layer.load(0);
			$.post('http://localhost:8088/web_example_war_exploded/house?type=add',mypart,function(mydata){
				layer.close(i);
				if(mydata==1)
				{
					parent.layer.msg('增加成功！', {icon : 6,time : 3000});
					var index = parent.layer.getFrameIndex(window.name); //获取窗口索引(真正的关 )
					parent.layer.close(index);
				}
				else
				{
					parent.layer.msg('增加失败', 2, 9);
				}
			},'json');
		}
	});
}