<@a.header "${action.getText('ui.manage')}">
	<script>
		//页面初始化
		$(function(){
			//初始化编辑页面
			edit(${(pager.fisrtId)!''});
		});
		 //列表
	     function list(){
	        $("#searchForm").attr("action","${contextPath}/admin/redirecturl/list.do");
	        $("#searchForm").submit();
	     }
	     //搜索
	     function commonSearch(){
	      	//设置每页第一条记录值
	     	$("#fisrtId").val('');
	     	//设置当前页码为默认页码
	     	$("#pageNumber").val('');
	     	//设置当前页面数量为默认数量
	     	$("#pageSize").val('');
	     	//设置搜索文本框的值
	     	if($("#searchBox").val() != "请输入名称"){
	     		$("#searchName").val($("#searchBox").val());
	     	}else{
	     		$("#searchName").val("");
	     	}
	     	//提交查询
	     	list();
	     }
	    //添加
	     function add(){
	    	 //设置每页第一条记录值
	     	$("#fisrtId").val('');
	     	//初始列表化样式
	     	$(".content-left table").find("tr").each(function(){
	     		$(this).removeClass("change_bg_tr");
	     	})
	     	//加载添加页面
	     	var url = "${contextPath}/admin/redirecturl/add.do";
	        loadRightPage(url);
	     }
	     //编辑
	     function edit(id){
	     	//设置每页第一条记录值
	     	if(id == null || id == ""){
	     		add();
	     	}else{
		     	$("#fisrtId").val(id);
		     	var url = "${contextPath}/admin/redirecturl/edit.do?id="+id;
		        loadRightPage(url);
	     	}
	     }
	     //加载页面
	     function loadRightPage(url){
	    	tip_show('w', "数据加载中...");
	     	$.ajaxSetup ({ cache: false });
	        $(".content-right").load(url,function(resTxt,status,xhr){
	        	if(status == "success"){
	        		setTimeout(function(){
						tip_hide_w(); 
					},1000);
	        	}
			}); 
			//resTxt:请求返回的内容
			//status:请求状态：success、error、notmodified、timeout这4种
			//xhr:XMLHttpRequest对象
	     }
	     //删除
	     function del(id,preId,name){
	      if(confirm("确定要删除该url:【"+name+"】吗？")){
		     $.ajax({    
		        type:'POST',        
		        url:'${contextPath}/admin/redirecturl/delete.do?id='+id,    
		        data:null,    
		        cache:false,    
		        dataType:'json',    
		        success:function(data){ 
		        	if(data.status=="y"){
		        		 tip_show(data.status, data.info);
		        		 if(preId != 0){ 
		      	 				$("#fisrtId").val(preId);
		      			 }else{
		      	 				$("#fisrtId").val('');
		      	 		 }
		      	 		//重新加载列表
	      	 			list();
		        	}else if(data.status=="n"){
		        		tip_show(data.status, data.info);
		        		return false;
		        	}else{
		        		tip_show('n', '删除操作失败');
						return false;
		        	}
		        }    
		     });    
		   }
	     }
	</script>
</@a.header >
<body>
	<@a.menu />
	<div id="Contenter">
        <div class="contentBody">
           <!-- start content-left -->
            <div class="content-left">
                <div class="titleH2 font14">URL${action.getText("label.list")}<a class="addProducts" onclick="add();" ><img src="${contextPath}/css/images/white_add_icon.png">添加URL</a></div>
                <div class="OrderTable">
                    <div class="OrderTop">
                       <form action="${contextPath}/admin/redirecturl/list.do" method="post" id="searchForm">
                        <div class="searchOrderDiv">
                            <input type="text" class="searchBox" id="searchBox"  value="${(search.name)!}" placeholder="请输入URL名称" onkeydown="keydownsearch(event)" />
                            <input type="hidden" id="pageNumber" name="pager.pageNumber" value="${(pager.pageNumber)!}" />
                            <input type="hidden" id="pageSize" name="pager.pageSize" value="${(pager.pageSize)!}" />
                            <input type="hidden" id="fisrtId" name="pager.fisrtId" value="${(pager.fisrtId)!}" />
                            <input type="hidden" id="searchName" name="search.name" value="${(search.name)!}" />
                            <a class="searchOrderBtn" onclick="commonSearch();"></a>
                        </div>
                        <input type="submit" value="" style="display:none"/>
                        </form>
                    </div>
                    <@a.paginationTop />
                    <div class="OrderBottom">
                        <table width="100%">
                            <tr>
                                <th><span class="empty15">url名称</span></th>
                                <th width="100"><span class="empty15">${action.getText("label.action")}</span></th>
                            </tr>
                            <#if (pager.results)??>
	                            <#list pager.results as obj>
	                            	<#if obj_index == 0>
	                            		<#assign preId=0/>
	                            	</#if>
		                            <tr<#if obj.id == pager.fisrtId> class="change_bg_tr"</#if> onclick="edit(${(obj.id)!});">
		                                <td><span class="empty15 pro_name_l ellipsis" title="${(obj.name)!}">${(obj.name)!}</span></td>
		                                <td class="operating"><span class="empty15"><a class="zoomThis" onclick="edit(${(obj.id)!});"></a><a class="deleteThis" onclick="del('${(obj.id)!}','${(preId)!}','${(obj.name)!}');"></a></span></td>
		                            </tr>
		                            <#assign preId=obj.id/>
	                            </#list>
	                        <#else>
	                        	    <tr>
		                             	<td colspan="3"><span class="empty15">${action.getText("msg.no.data")}</span></td>
		                            </tr>
	                        </#if>
                        </table>
                    </div>
                    <@a.paginationBottom />
                </div>
            </div>
            <!-- end content-left -->
            <!-- start content-right -->
            <div class="content-right">
                <!-- input -->
            </div>
            <!-- end content-right -->
            <div class="clear"></div>
        </div>
    </div>
    <!-- end Contenter -->
 <@a.footer />  