$(function(){
	init();
	//数据验证
	//checkItem();
	myaddSe();
	//提交表单位
	commitItem();
});
/****************获得焦点********************/
function init() {
	$("#dkd").focus();
	
	//得到下拉框的值 
	
	$.ajax({
		url:'http://localhost:8088/web_example_war_exploded/area?type=findall',
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


function myaddSe()
{
	$("#aid").bind("change",function(){
		var aid=$(this).val();
		  $("#hid").empty();
		if(aid!=0)
			{
			      
					$.ajax({
					url:'http://localhost:8088/web_example_war_exploded/house?type=findall',
					dataType:'json',
					type:'post',
					data:{aid:aid},
					async : false,
					success:function(mydata)
					{
			
					   $.each(mydata,function(index,xx){
						   $("#hid").append("<option value="+xx.hid+">"+xx.hAddress+"</option>");
					   });
					}
				});
			}
		else
			{
			     $("#hid").append("<option value=0>---请选择房屋---</option>"); 
			}
		
	});
}

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
	var hid = $("#hid").val();
	var bremark = $("#bremark").val();

	if(hid.length==0)
		{
		   layer.tips('房子名称不能为空！','#hid',{tips:[2,'red']});
		   $("#hid").focus();
		   return false;
		}
	else if(hid==0)
		{
		   layer.tips('房子名称不能为空！','#hid',{tips:[2,'red']});
		   $("#hid").focus();
		   return false;
		}
	else if(bremark.length==0)
		{
		  layer.tips('备注不能为空！','#bremark',{tips:[2,'red']});
		  $("#bremark").focus();
		  return false;
		}
	
	else
		{
		   var mypart = "bs.hid="+hid+"&bs.bremark="+bremark;
		   var i = layer.load(0);
		   $.post('http://localhost:8088/web_example_war_exploded/mybs?type=add',mypart,function(mydata){
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