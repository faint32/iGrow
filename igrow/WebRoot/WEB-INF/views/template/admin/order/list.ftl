<@a.header "${action.getText('ui.manage')}">
	<script>
		//页面初始化
		$(function(){
			//初始化编辑页面
			edit(${(pager.fisrtId)!''});
			$("#searchStatus").change(function(){
             	commonSearch();
		    });
		    $("#productType").change(function(){
             	commonSearch();
		    });
		});
		 //查询
	     function list(){
	        $("#searchForm").attr("action","${contextPath}/admin/order/list.do");
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
	     	if($.trim($("#searchBox").val()) != "" && $("#searchBox").val() != "品名/订单号/酒店名称"){
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
	     	var url = "${contextPath}/admin/order/edit.do?id="+id;
	        loadRightPage(url);
	     }
	     
	     function loadRightPage(url){
	     	tip_show('w', "数据加载中...");
	     	$.ajaxSetup ({ cache: false });
	        $(".content-right").load(url,function(resTxt,status,xhr){
	        	if(status == "success"){
	        		setTimeout(function(){
						tip_hide_w(); 
						if($("#pagerTotalCount").html() == 0 ){
					            $(".content-right .OrderTable").html("<div class='noData'><p>暂无订单</p></div>");
					     }
					},300);
	        	}
			}); 
	     }
	</script>
	<style type="text/css">
	.searchOrderDiv{ *width:157px;}
	.searchBox{ width:69px;}
	.searchOrderBtn{ margin-left:10px;}
	</style>
</@a.header >
<body>
	<@a.menu />
	<div id="Contenter">
        <div class="contentBody">
           <!-- start content-left -->
            <div class="content-left">
                <div class="titleH2 font14">${action.getText("order.label")}${action.getText("label.list")}</div>
                <div class="OrderTable">
                    <div class="OrderTop">
                       <form action="${contextPath}/admin/order/list.do" method="post" id="searchForm">
                       <select class="selct01" name="search.searchStatus" id="searchStatus">
                            <option value="">全部</option>
                            <#list status as allStatuss>
                              <option value="${(allStatuss.value)!""}" <#if search.searchStatus==allStatuss.value>selected="selected"</#if>>${(allStatuss.desc)!""}</option>
                            </#list>
                        </select>
                        <select class="selct02" name="search.productType" id="productType" <#if admin != null && admin.roleGroupId ==3>style="display:none;"</#if>>
                            <#if admin != null && admin.roleGroupId ==3><option value="1">全部</option><#else><option value="">全部</option></#if>
                            <#list productTypes as proType>
                              <option value="${(proType.value)!""}" <#if search.productType==proType.value>selected="selected"</#if>>${(proType.desc)!""}订单</option>
                            </#list>
                        </select>
                        <input type="text" class="timeInput" placeholder="…" <#if search.startDate?exists>value="${(search.startDate)?string("yy-MM-dd")}"</#if> name="startDate" readonly="true" onclick="WdatePicker({dateFmt:'yy-MM-dd',vel:'startDate'})"/><label class="customiseLabel">至</label><input type="text" <#if search.endDate?exists>value="${(search.endDate)?string("yy-MM-dd")}"</#if> placeholder="…" name="endDate" id="promotionendTime"  readonly="true" class="timeInput empty13" onclick="WdatePicker({dateFmt:'yy-MM-dd',vel:'endDate'})"/>
                        <input type="hidden" id="startDate" name="search.startDate" <#if search.startDate?exists>value="${(search.startDate)?string("yyyy-MM-dd")}"</#if> />
                        <input type="hidden" id="endDate" name="search.endDate" <#if search.endDate?exists>value="${(search.endDate)?string("yyyy-MM-dd")}"</#if> />
                        <div class="searchOrderDiv">
                            <input type="text" class="searchBox" id="searchBox" value="${(search.name)!}" placeholder="品名/订单号/酒店名称" onkeydown="keydownsearch(event)"/>
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
                        <table width="558">
                            <tr>
                            	<th width="119"><span class="empty15">${action.getText("order.number")}</span></th>
                            	<th width="141"><span class="empty15">${action.getText("product.name")}</th>
                                <th width="88"><span class="empty15">${action.getText("order.amount")}</th>
                                <th width="135"><span class="empty15">${action.getText("order.type")}</th>
                                <th width="95"><span class="empty15">支付</th>
                                <th width="75"><span class="empty15">${action.getText("label.action")}</th>
                            </tr>
                            <#if (pager.results)??>
	                            <#list pager.results as obj>
		                            <tr <#if obj.id == pager.fisrtId> class="change_bg_tr"</#if> onclick="edit(${(obj.id)!});">
		                                <td><span class="empty15 ellipsis pro_name" title="${(obj.orderSn)!""}">${(obj.orderSn)!""}</span></td>
		                                <td><span class="pro_name ellipsis empty15" title="${(obj.productName)!""}">${(obj.productName)!""}</span></td>
		                                <td><span class="empty15">${(obj.totalAmount)!}</span></td>
		                                <td><span class="empty15"><span <#if obj.status.value==4>class="redColor"<#elseif obj.status.value==1>class="blurColor"</#if> ><#if (obj.deliveryMode)??&&obj.deliveryMode.value == 0><#if (obj.status)??&&obj.status.value == 2>前台已领<#else>${(obj.status.desc)!}</#if><#else>${(obj.status.desc)!}</#if><#if (obj.orderPayment.paymentOrg.orgName)??><br>[${(obj.orderPayment.paymentOrg.orgName)!'-'}]</#if></span></span></td>
		                                <td><span class="empty15"><#if obj.paymentType != null && obj.paymentType.value != 1>在线<#else>线下</#if></span></td>
		                                <td class="operating"><span class="empty15"><a class="zoomThis" onclick="edit(${(obj.id)!});"></a></span></td>
		                            </tr>
	                            </#list>
	                        <#else>
	                        	    <tr>
		                             	<td colspan="5"><span class="empty15">${action.getText("msg.no.data")}</span></td>
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