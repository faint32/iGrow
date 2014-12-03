<@a.header "${action.getText('ui.manage')}">
	<script>
		//页面初始化(会员管理)
		$(function(){
			//初始化编辑页面
			edit(${(pager.fisrtId)!''});
		});
		 //查询
	     function list(){
	        $("#searchForm").attr("action","${contextPath}/admin/member/list.do");
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
	     	if($("#searchBox").val() != "会员账号/真实姓名"){
	     		$("#searchName").val($("#searchBox").val());
	     	}else{
	     		$("#searchName").val("");
	     	}
	     	//提交查询
	     	list();
	     }
	     //编辑
	     function edit(id){
	        //设置每页第一条记录值
	     	$("#fisrtId").val(id);
	     	var url = "${contextPath}/admin/member/edit.do?id="+id;
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
        <div class="bottom_layer_see"></div>
           <!-- start content-left -->
            <div class="content-left">
                <div class="titleH2 font14">${action.getText("member.label")}${action.getText("label.list")}</div>
                <div class="OrderTable">
                    <div class="OrderTop">
                       <form action="${contextPath}/admin/member/list.do" method="post" id="searchForm" >
                        <input type="text" class="timeInput total-consumption nobg" placeholder="累计消费" name="search.minAmount" value="${(search.minAmount)!}" onkeyup="this.value=this.value.replace(/[^0-9.]+/,'')" onafterpaste="this.value=this.value.replace(/[^0-9.]+/,'')" onkeydown="keydownsearch(event)"/>
                        <label>至</label>
                        <input type="text" class="timeInput total-consumption nobg empty13" placeholder="累计消费" name="search.maxAmount" value="${(search.maxAmount)!}" onkeyup="this.value=this.value.replace(/[^0-9.]+/,'')" onafterpaste="this.value=this.value.replace(/[^0-9.]+/,'')" onkeydown="keydownsearch(event)"/>
                        <div class="searchOrderDiv">
                            <input type="text" class="searchBox" id="searchBox" value="${(search.name)!}" placeholder="${action.getText("member.mobile")}/${action.getText("member.name")}" onkeydown="keydownsearch(event)" />
                            <input type="hidden" id="pageNumber" name="pager.pageNumber" value="${(pager.pageNumber)!}" />
                            <input type="hidden" id="pageSize" name="pager.pageSize" value="${(pager.pageSize)!}" />
                            <input type="hidden" id="fisrtId" name="pager.fisrtId" value="${(pager.fisrtId)!}" />
                            <input type="hidden" id="searchName" name="search.name" value="${(search.name)!}" />
                            <a class="searchOrderBtn" onclick="commonSearch();"></a>
                            <input type="submit" value="" style="display:none"/>
                        </div>
                        </form>
                    </div>
                    <@a.paginationTop />
                    <div class="OrderBottom">
                        <table width="558">
                            <tr>
                                <th width="106"><span class="empty15">${action.getText("member.mobile")}</span></th>
                                <th width="76"><span class="empty15">${action.getText("member.totalSpendAmount")}</span></th>
                                <th width="76"><span class="empty15">${action.getText("member.status")}</span></th>
                                <th width="76"><span class="empty15">${action.getText("label.action")}</span></th>
                            </tr>
                            <#if (pager.results)??>
	                            <#list pager.results as obj>
		                            <tr<#if obj.id == pager.fisrtId> class="change_bg_tr"</#if> onclick="edit(${(obj.id)!});">
		                                <td><span class="empty15">${(obj.mobile)!}</span></td>
		                                <td><span class="empty15">${(obj.memberAccount.totalSpendAmount)!"0"}</span></td>
		                                <td><span class="empty15"><#if (obj.isAccountEnabled)?exists && obj.isAccountEnabled.value==1>正常<#else>停用</#if></span></td>
		                                <td class="operating"><span class="empty15"><a class="zoomThis" onclick="edit(${(obj.id)!});"></a></span></td>
		                            </tr>
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
