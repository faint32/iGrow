<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Cache-control" />
    <meta name="format-detection" content="telephone=no" />
    <meta content="yes" name="apple-mobile-web-app-capable" />
    <meta content="black" name="apple-mobile-web-app-status-bar-style" />
    <meta content="telephone=no" name="format-detection" />
    <meta name="viewport" content="width=device-width; maximum-scale=1.0;  user-scalable=no; initial-scale=1.0" />
    <title>微信公众号菜单管理</title>
    <link href="${contextPath}/css/wchat/menu_list.css" rel="stylesheet" type="text/css" />
    <script src="${contextPath}/js/jquery-1.7.2.min.js"></script>
    <script src="${contextPath}/js/Validform_v5.3.2.js"></script>
    <script type="text/javascript">
        function selectTag(indexs) {
            //alert(indexs);
        	if(indexs == '0'){
        	 	$("#actionEvent").val('4');
        	}else if(indexs == '1'){
        	 	$("#actionEvent").val('5');
        	}else if(indexs == '2'){
        		$("#actionEvent").val('4');
        	}
            var tags = document.getElementById("tabwarp").getElementsByTagName("li");
            ids = "tagContent";
            ids = ids + "" + indexs;
            var idtabs = document.getElementById(ids);
            //初始化
            for (i = 0; i < 3; i++) {
                tags[i].className = "";
                document.getElementById("tagContent" + i).style.display = "none";
            }
            //改内容
            tags[indexs].className = "selectTag";
            document.getElementById(ids).style.display = "block";
        }
		function pop_closed(){
			$(".dialog_wrp").fadeOut(500);
		}
		   $(function(){
			$("#addBt, .jsAddBt, .jsEditBt, .jsSubEditBt").live("click",function(){
				$("#parentId").val(''); //清空父id
				$("#id").val(''); //清空id
				$(".frm_input").val(''); //清空文本框
				//弹出添加框
				$(".dialog_wrp").fadeIn(500);
				if($(this).hasClass("jsAddBt")){
					//alert($(this).parent().prev("strong").attr("id"));
					//获取id，设置父id
					$("#parentId").val($(this).parent().prev("strong").attr("id"));
					$(".valueNull").val($(this).parent().parent().parent().index()+"-"+$(this).parent().parent().index()+"-add");
				}
				if($(this).hasClass("jsSubEditBt")|| $(this).hasClass("jsEditBt")){
					//alert($(this).parent().prev("strong").attr("id"));
					//获取id，设置id
					$("#id").val($(this).parent().prev("strong").attr("id"));
					//设置名称
					$(".frm_input").val($(this).parent().prev("strong").html());
					$(".valueNull").val($(this).parent().parent().parent().index()+"-"+$(this).parent().parent().index()+"-edit");
				}
				if($(this).attr("id") == "addBt"){
					$(".valueNull").val("00")
				}
			});
			//排序
			$("#sortBt").live("click", function(){
				$(".wx_right").hide();
				$(".show_s").show();
				$(".sort_input").show();
			});
			
			//确定
			var firstNode;
			var lastNode;
			$(".confirm").live("click", function(){
				var parentId = $("#parentId").val();
				var name = $("#name").val();
				//alert(parentId);
				//alert(name);
				var stringV = $(".valueNull").val();
				var sArr = stringV.split("-");
				firstNode = parseInt(sArr[0]);
				lastNode = parseInt(sArr[1]);
				var fontNode = sArr[2];
				//修改菜单
				if( lastNode != null && fontNode == "edit"){
					$(".dialog_wrp").fadeOut(500);
					//修改菜单名称
					editMenu();
					return false;
				}
				//添加二级菜单
				if( firstNode != null && fontNode == "add"){
					$(".dialog_wrp").fadeOut(500);
					if($("#menuList").children().eq(firstNode).children().length>5){
						alert("二级菜单不能超过5个!");
						return false;
					}
					//保存操作二级菜单
					addMenu(2);
					return false;
				}
				//添加一级菜单
				if( firstNode == "00"){
					$(".dialog_wrp").fadeOut(500);
					if($("#menuList").children().length>=3){
						alert("一级菜单不能超过3个!");
						return false;
					}
					//保存操作
					addMenu(1);
					//成功显示
					return false;
				}
			});
			//取消
			$(".cancel").live("click", function(){
				$(".dialog_wrp").fadeOut(500);
			});
			//一级删除
			$(".jsDelBt").live("click",function(){
				alert($(this).parent().prev("strong").attr("id"));
				var id = $(this).parent().prev("strong").attr("id");
				var name = $(this).parent().prev("strong").html();
				//删除菜单
				var isSucc = del(id,name);
				alert(isSucc);
				if(isSucc){
					$(this).parent().parent().parent().remove();
				}
				
			});
			//二级删除
			$(".jsSubDelBt").live("click",function(){
				alert($(this).parent().prev("strong").attr("id"));
				var id = $(this).parent().prev("strong").attr("id");
				var name = $(this).parent().prev("strong").html();
				var isSucc = del(id,name);
				alert(isSucc);
				if(isSucc){
					$(this).parent().parent().remove();
				}
			});
			//排序完成
			$("#finishBt, #cancleBt").live("click",function(){
				$(".wx_right").show();
				$(".show_s").hide();
				$(".sort_input").hide();
			});
			//菜单添加保存
			function addMenu(lev){
				$("#saveForm").attr("action","${contextPath}/wchat/mn/save.do");
				var vform= $("#saveForm").Validform({
						tiptype:2,
						showAllError:false,
						ajaxPost:true,
						callback:function(data){
							$.Hidemsg();
							if(data.status=="y"){ //返回成功
								//成功显示
								//alert(data.value);
								if(lev == '1'){ //添加1级菜单
									//alert("一级菜单添加成功");
									$("#menuList").append("<ul class='wx_list'><h2 class='h2_title'><input type='text' class='sort_input' /><strong id='"+data.value+"'  onclick='loadAction("+data.value+",this,2)'>"+$('.frm_input').val()+"</strong><span class='wx_icon_right'><a class='btn_addChlidWx jsAddBt'></a><a class='btn_editWx jsEditBt'></a><a class='btn_deleteWx jsDelBt'></a></span></h2>");
								}else if(lev == '2'){ //添加2级菜单
									//alert("二级菜单添加成功");
									$("#menuList").children().eq(firstNode).append("<li><input type='text' class='sort_input' /><strong id='"+data.value+"' onclick='loadAction("+data.value+",this,2)'>"+$('.frm_input').val()+"</strong><span class='wx_icon_right'><a class='btn_editWx jsSubEditBt'></a><a class='btn_deleteWx jsSubDelBt'></a></span></li>");
								}
								return false;
							}else if(data.status=="n"){ //返回失败
								//alert("失败");
								return false;
							}else{ //返回未知错误
								return false;
							}
						}
					});
				//提交
				$("#saveForm").submit();
			}
			//菜单修改保存
			function editMenu(){
				$("#saveForm").attr("action","${contextPath}/wchat/mn/save.do");
				var vform= $("#saveForm").Validform({
						tiptype:2,
						showAllError:false,
						ajaxPost:true,
						callback:function(data){
							$.Hidemsg();
							if(data.status=="y"){ //返回成功
								//成功显示
								//alert("菜单名称修改成功");
								//显示新菜单名称
								$("#menuList").children().eq(firstNode).children().eq(lastNode).children("strong").html($(".frm_input").val());
								return;
							}else if(data.status=="n"){ //返回失败
								alert("菜单名称修改失败");
								return;
							}else{ //返回未知错误
								return;
							}
						}
					});
				//提交
				$("#saveForm").submit();
			}
			
			 //删除
		    function del(id,name){
		      var isSucc = false;
		      if(confirm("确定要删除该菜单:【"+name+"】吗？")){
			     $.ajax({    
			        type:'POST',        
			        url:'${contextPath}/wchat/mn/delete.do?id='+id,    
			        data:null,    
			        cache:false,  
			        async:false,   
			        dataType:'json',    
			        success:function(data){ 
			        	if(data.status=="y"){
			        		//alert(data.status);
			        		isSucc = true;
			        	}else if(data.status=="n"){
			        		isSucc = false;
			        	}else{
							isSucc = false;
			        	}
			        }    
			     });    
			   }
			   return isSucc;
		     }
		   
		});
		 //设置动作
		function loadAction(id,obj,lev){
		     var url = '${contextPath}/wchat/mn/input.do?id='+id;
		     //alert(url);
		   	 //alert(id);
		   	// alert($(obj).parent().parent().children().length);
		   	 $(".wx_right_cont").html('');
		   	 if(lev == '1'){
			   	 var len = $(obj).parent().parent().children().length;
			   	 if(len > 1){
			   	 	$(".wx_right_cont").append("<p class='action_tips'>已有子菜单，无法设置动作</p>");
			   	 	return;
			   	 }else{ //加载页面
			   	     $.ajaxSetup ({ cache: false });
			         $(".wx_right_cont").load(url,function(resTxt,status,xhr){}); 
			   	 }
		   	 }else if(lev == '2'){ //加载页面
		   	      $.ajaxSetup ({ cache: false });
		   	 	  $(".wx_right_cont").load(url,function(resTxt,status,xhr){}); 
		   	 }
		}
		//生成数据
		 function generate(){
		      if(confirm("确定要对菜单的数据进行生成吗？")){
			     $.ajax({    
			        type:'POST',        
			        url:'${contextPath}/wchat/mn/generate.do',    
			        data:null,    
			        cache:false,  
			        async:false,   
			        dataType:'json',    
			        success:function(data){ 
			        	if(data.status=="y"){
			        		alert('菜单数据生成成功!');
			        		return;
			        	}else if(data.status=="n"){
			        		alert('菜单数据生成失败!');
			        		return;
			        	}else{
							return;
			        	}
			        }    
			     });    
			   }
			   return ;
		  }
		  
		  //发布菜单
		 function publish(){
		      if(confirm("确定要发布菜单到公众号上吗？")){
			     $.ajax({    
			        type:'POST',        
			        url:'${contextPath}/wchat/mn/publish.do',    
			        data:null,    
			        cache:false,  
			        async:false,   
			        dataType:'json',    
			        success:function(data){ 
			        	if(data.status=="y"){
			        		alert('菜单发布成功!');
			        		return;
			        	}else if(data.status=="n"){
			        		alert('菜单发布失败!');
			        		return;
			        	}else{
							return;
			        	}
			        }    
			     });    
			   }
			   return;
		  }
		     
    </script>
</head>
<body>
    <div id="wxContent" class="wxContent">
    	<div class="block_title_wx">
        	<p>一：菜单管理</p>
        </div>
        <div class="menu_box">
            <div class="wx_left_cont">
                <div class="wx_title">
                    <label>菜单管理</label>
                    <span class="wx_right">
                        <a class="btn_addWx" id="addBt"></a><a class="btn_sortWx" id="sortBt"></a>
                    </span>
                    <span class="show_s">
                        <a class="btn_YWx" id="finishBt">确定</a><a class="btn_CWx" id="cancleBt">取消</a>
                    </span>
                </div>
                <div id="menuList">
                	<#list (menus)! as menu>
	                    <ul class="wx_list">
	                        <h2 class="h2_title"><input type="text" class="sort_input" value="${(menu.sort)!0}" /><strong id="${(menu.id)!}" onclick="loadAction(${(menu.id)!},this,'1')">${(menu.name)!}</strong><span class="wx_icon_right"><a class="btn_addChlidWx jsAddBt"></a><a class="btn_editWx jsEditBt"></a><a class="btn_deleteWx jsDelBt"></a></span></h2>
	                        <#if (menu.subMenus)??&&(menu.subMenus)?exists>
	                        	<#list (menu.subMenus)! as subMenu>
	                       	 		<li><input type="text" class="sort_input" value="${(menu.sort)!0}" /><strong id="${(subMenu.id)!}" onclick="loadAction(${(subMenu.id)!},this,'2')">${(subMenu.name)!}</strong><span class="wx_icon_right"><a class="btn_editWx jsSubEditBt"></a><a class="btn_deleteWx jsSubDelBt"></a></span></li>
	                    		</#list>
	                    	</#if>
	                    </ul>
                    </#list>
                </div>
            </div>
            <div class="wx_right_cont">
            <p class="action_tips">你可以先添加一个菜单，然后开始为其设置响应动作</p>
            </div>
            <div class="clear"></div>
        </div>
        <div class="block_title_wx">
        	<p>二：菜单图文数据生成</p>
            <span class="btnWX btn_01">
                <button class="js_btn" data-index="0" type="button" onclick="generate();">数据生成</button>
            </span>
            <p class="action_tipsFont_left">注意：设置菜单为图文信息为微信素材库图文信息，必须对菜单的数据进行生成</p>
        </div>
        <div class="block_title_wx">
        	<p>三：菜单发布到公众号</p>
            <span class="btnWX btn_02">
                <button class="js_btn" data-index="0" type="button" onclick="publish();">发 布</button>
            </span>
            <p class="action_tipsFont_left">注意：菜单发布成功后，在微信公众号上24小时生效</p>
        </div>
        
    </div>
    <div class="dialog_wrp">
    	<div class="block_layer"></div>
        <div class="dialog">
            <div class="dialog_hd">
                <h3>输入提示框</h3>
                <a class="pop_closed" onclick="pop_closed()" href="javascript:;">关闭</a>
            </div>
            <div class="dialog_bd">
                <div class="simple_dialog_content">
                    <form id="saveForm" class="form" action="${contextPath}/wchat/mn/save.do" method="post" novalidate="novalidate">
                    	<input type="hidden" id="id" name="id" value="" ><!--id-->
                    	<input type="hidden" id="parentId" name="form.parentId" value="" > <!--父id-->
                        <div class="frm_control_group">
                            <label class="frm_label">菜单名称名字不多于8个汉字或16个字母:</label>
                            <span class="frm_input_box">
                                <input class="frm_input" type="text" value=""  name="form.name" id="name" >
                                <input class="valueNull" style="display:none">
                            </span>
                        </div>
                        <div class="js_verifycode"></div>
                    </form>
                </div>
            </div>
            <div class="dialog_ft">
                <span class="btn btn_primary">
                    <button class="js_btn confirm" data-index="0" type="button">确认</button>
                </span>
                <span class="btn btn_default">
                    <button class="js_btn cancel" data-index="1" type="button">取消</button>
                </span>
            </div>
        </div>
    </div>
</body>
</html>
