$(function(){
	init();
	//数据验证
	checkItem();
	//提交表单位
	commitItem();
});
/****************获得焦点********************/
function init() {
	$("#sname").focus();
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
				   url:'/',
				   dataType:'json',
				   type:'post',
				   data:{sname:sname},
				   async : true,
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
	var sname = $("#sname").val();
	if(sname.length==0)
		{
		   layer.tips('类型名称不能为空！','#sname',{tips:[2,'red']});
		   $("#sname").focus();
		   return false;
		}
	else if($("#botao").val()>0)
		{
		  layer.tips('对不起类型已存在！','#sname',{tips:[2,'red']});
		  $("#sname").focus();
		  return false;
		}
	else
			{
		   var mypart = "sort.sname=" + sname +  "";
		   var i = layer.load(0);
		   $.post('http://localhost:8088/web_example_war_exploded/sort?type=add',mypart,function(mydata){
			 layer.close(i);
			 if(mydata>0)
				 {
				   parent.layer.msg('添加成功！', {icon : 6,time : 3000});
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