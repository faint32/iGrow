<@a.header "${action.getText('ui.manage')}">
	<script>
		//页面初始化
		$(function(){
			//初始化编辑页面
			dayDetails('${(pager.fisrtId)!''}');
			$("#searchStatus").change(function(){
             	commonSearch();
		    });
		    $("#productType").change(function(){
             	commonSearch();
		    });
		});
		 //查询
	     function list(){
	        $("#searchForm").attr("action","${contextPath}/admin/order/dayList.do");
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
	     	//提交查询
	     	list();
	     }
	     //编辑
	     function dayDetails(id){
	        //设置每页第一条记录值
	     	$("#fisrtId").val(id);
	     	var url = "${contextPath}/admin/order/dayDetails.do?id="+id;
	        loadRightPage(url);
	     }
	     
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
	     }
	</script>
	<style type="text/css">
	.searchOrderDiv{ *width:157px;}
	.searchBox{ width:77px;}
	.searchOrderBtn{ margin-left:10px;}
	</style>
</@a.header >
<body>
	<@a.menu />
	<div id="Contenter">
        <div class="contentBody">
           <!-- start content-left -->
            <div class="content-left">
                <div class="titleH2 font14">单日订单</div>
                <div class="OrderTable">
                    <div class="OrderTop">
                       <form action="${contextPath}/admin/order/dayList.do" method="post" id="searchForm">
                        <input type="text" class="timeInput" placeholder="…" <#if search.startDate?exists>value="${(search.startDate)?string("yy-MM-dd")}"</#if> name="startDate" readonly="true" onclick="WdatePicker({dateFmt:'yy-MM-dd',vel:'startDate'})"/><label class="customiseLabel">至</label><input type="text" <#if search.endDate?exists>value="${(search.endDate)?string("yy-MM-dd")}"</#if> placeholder="…" name="endDate" id="promotionendTime"  readonly="true" class="timeInput empty13" onclick="WdatePicker({dateFmt:'yy-MM-dd',vel:'endDate'})"/>
                        <input type="hidden" id="startDate" name="search.startDate" <#if search.startDate?exists>value="${(search.startDate)?string("yyyy-MM-dd")}"</#if> />
                        <input type="hidden" id="endDate" name="search.endDate" <#if search.endDate?exists>value="${(search.endDate)?string("yyyy-MM-dd")}"</#if> />
                        <div class="searchOrderDiv">
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
                            	<th width="100"><span class="empty15">日期</span></th>
                            	<th width="110"><span class="empty15">订单量</th>
                                <th width="141"><span class="empty15">总成交金额</th>
                                <th width="115"><span class="empty15">${action.getText("label.action")}</th>
                            </tr>
                            <#if (pager.results)??>
	                            <#list pager.results as obj>
		                            <tr <#if obj.orderDate == pager.fisrtId> class="change_bg_tr"</#if> onclick="dayDetails('${(obj.orderDate)!}');">
		                                <td><span class="empty15 ellipsis pro_name" title="${(obj.orderDate)!""}">${(obj.orderDate)!""}</span></td>
		                                <td><span class="pro_name ellipsis empty15" title="${(obj.orderTotalQuantity)!""}">${(obj.orderTotalQuantity)!""}</span></td>
		                                <td><span class="empty15">${(obj.orderTotalAmount)!}</span></td>
		                                <td class="operating"><span class="empty15"><a class="zoomThis" onclick="dayDetails('${(obj.orderDate)!}');"></a></span></td>
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