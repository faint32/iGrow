<@a.header "${action.getText('ui.manage')}">
<script>
		//页面初始化
		$(function(){
			//初始化编辑页面
			edit(${(pager.fisrtId)!''});
		});
		 //列表
	     function list(){
	        $("#searchForm").attr("action","${contextPath}/admin/user/list.do");
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
	     	if($("#searchBox").val() != "管理员账号/管理员姓名"){
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
	     	var url = "${contextPath}/admin/user/add.do";
	        loadRightPage(url);
	     }
	     //编辑
	     function edit(id){
	     	//设置每页第一条记录值
	     	$("#fisrtId").val(id);
	     	var url = "${contextPath}/admin/user/edit.do?id="+id;
	        loadRightPage(url);
	     }
	     //加载页面
	     function loadRightPage(url){
	     	tip_show('w', "数据加载中...");
	     	$.ajaxSetup ({ cache: false });
	        $(".content-right").load(url,function(resTxt,status,xhr){
	        	if(status == "success"){
	        		setTimeout(function(){
						tip_hide_w(); 
					},300);
	        	}
			}); 
	     }
	</script>
</@a.header >
<body>
	<@a.menu />
	<div id="Contenter">
        <div class="contentBody">
           <!-- start content-left -->
            <div class="content-left">
                <div class="titleH2 font14">${action.getText("user.label")}${action.getText("label.list")}<a class="addProducts" onclick="add();" ><img src="${contextPath}/css/images/white_add_icon.png">${action.getText("user.addname")}</a></div>
                <div class="OrderTable">
                    <div class="OrderTop">
                       <form action="${contextPath}/admin/user/list.do" method="post" id="searchForm">
                        <div class="searchOrderDiv">
                            <input type="text" class="searchBox" id="searchBox"  value="${(search.name)!}" placeholder="${action.getText("user.userName")}/${action.getText("user.name")}" onkeydown="keydownsearch(event)" />
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
                                <th width="106"><span class="empty15">${action.getText("user.userName")}</span></th>
                                <th width="101"><span class="empty15" style="width:86px;">${action.getText("user.name")}</span></th>
                                <th width="76"><span class="empty15">${action.getText("member.status")}</span></th>
                                <th width="76"><span class="empty15">${action.getText("label.action")}</span></th>
                            </tr>
                            <#if (pager.results)??>
	                            <#list pager.results as obj>
		                            <#if obj_index == 0>
	                            		<#assign preId=0/>
	                            	</#if>
		                            <tr<#if obj.id == pager.fisrtId> class="change_bg_tr"</#if> onclick="edit(${(obj.id)!});">
		                                <td><span class="empty15">${(obj.userName)!}</span></td>
		                                <td><span class="empty15">${(obj.name)!}</span></td>
		                                <td><span class="empty15"><#if obj?exists && obj.isAccountLocked?? && obj.isAccountLocked!=null && obj.isAccountLocked.value==0>
		                                <#if obj?exists&&(obj.isAccountEnabled)?exists&&(obj.isAccountEnabled)??&&obj.isAccountEnabled.value==0>禁用<#else>正常</#if>
		                                <#else>锁定</#if></span></td>
		                                <td class="operating">
		                                	<span class="empty15">
		                                		<a class="zoomThis" onclick="edit(${(obj.id)!});"></a></span>
		                                	</td>
		                            </tr>
		                            <#assign preId=obj.id/>
	                            </#list>
	                        <#else>
	                        	    <tr>
		                             	<td colspan="4"><span class="empty15">${action.getText("msg.no.data")}</span></td>
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
