<@a.header "${title}">
	<script>
		//页面初始化
		$(function(){
			//初始化编辑页面
			stocks(${(pager.fisrtId)!''});
		});
		 //列表
	     function list(){
	        $("#searchForm").attr("action","${contextPath}/admin/productshe/barcode.do");
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
	     	if($("#searchBox").val() != "请输入酒店名称"){
	     		$("#searchName").val($("#searchBox").val());
	     	}else{
	     		$("#searchName").val("");
	     	}
	     	//提交查询
	     	list();
	     }
	     
	     //发货记录列表
	     function stocks(id){
	     	//设置每页第一条记录值
	     	$("#fisrtId").val(id);
	     	var url = "${contextPath}/admin/productshe/barCodeInput.do?id="+id;
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
                <div class="titleH2 font14">${action.getText("hotel.label")}${action.getText("label.list")}</div>
                <div class="OrderTable">
                    <div class="OrderTop">
                        <div class="searchOrderDiv">
                         <form action="${contextPath}/admin/hotel/list.do" method="post" id="searchForm">
        					<input type="text" class="searchBox" id="searchBox"  value="${(search.name)!}" placeholder="${action.getText("msg.please.input")}${action.getText("hotel.label.name")}" onkeydown="keydownsearch(event)" />
        					<input type="hidden" id="pageNumber" name="pager.pageNumber" value="${(pager.pageNumber)!}" />
                            <input type="hidden" id="pageSize" name="pager.pageSize" value="${(pager.pageSize)!}" />
                            <input type="hidden" id="fisrtId" name="pager.fisrtId" value="${(pager.fisrtId)!}" />
                            <input type="hidden" id="searchName" name="search.name" value="${(search.name)!}" />
                            <a class="searchOrderBtn" onclick="commonSearch();"></a>
                            <input type="submit" value="" style="display:none"/>
                         </form>
                        </div>
                    </div>
                    <@a.paginationTop />
                    <div class="OrderBottom">
                        <table width="558">
                            <tr>
                            	<th width="20%"><span class="empty15">${action.getText("label.sn")}</span></th>
                                <th width="60%"><span class="empty15">${action.getText("hotel.label.name")}</span></th>
                                <th width="20%"><span class="empty15">${action.getText("label.action")}</span></th>
                            </tr>
                            <#if (pager.results)??>
	                            <#list pager.results as obj>
	                            	<#if obj_index == 0>
	                            		<#assign preId=0/>
	                            	</#if>
		                            <tr<#if obj.id == pager.fisrtId> class="change_bg_tr"</#if> >
		                             	<td onclick="stocks(${(obj.id)!});"><span class="empty15">${obj_index + 1}</span></td>
		                                <td onclick="stocks(${(obj.id)!});"><span class="empty15 pro_name_l ellipsis" title="${obj.name}">${obj.name}</span></td>
		                                <td class="operating"><span class="empty15">
		                                	<a class="barcode_icon" onclick="stocks(${(obj.id)!});" title="商品条码"></a>
		                                 </span>
		                                </td>
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
 
<div class="layer" id="erweimashow">
<div class="bottomBlock"></div>
<div class="layer-content tip_why_this">
    <div class="why_tip">
        <h3 class="layer_title"><span id="erweimaName"></span><a class="btn_closedPage" onclick="hideCodeLNoshows()"></a></h3>
        <span class="two_di_l"><img id="erweimaImg" width="100%" height="100%"/></span>
        <div class="order-status-btn btn_centerTo">
            <span class="can-send-btn">
            	<a class="confirm-save" id="erweimaSave">保 存</a>
                <a class="cancel-btn" onclick="erweimaClose()">关 闭</a>
            </span>
        </div>
    </div>
</div>
</div>
<style type="text/css">
.pro_name_l{ width:250px;}
</style>