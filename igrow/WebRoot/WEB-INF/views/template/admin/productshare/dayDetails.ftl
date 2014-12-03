<link href="${contextPath}/css/system.css"  rel="stylesheet">
<script type="text/javascript">
   function searchForminner(){
       	var url = "${contextPath}/admin/productshare/dayDetails.do?id=${(id)!''}";
       	//alert(url);
        var pageSize = $("#pageSizeinner").val();
        if(pageSize != null && pageSize !="" && pageSize != "undefined"){
        	url = url +  "&pager.pageSize="+pageSize;
        }
        var pageNumber = $("#pageNumberinner").val();
        if(pageNumber != null && pageNumber !="" && pageNumber != "undefined"){
        	url = url +  "&pager.pageNumber="+pageNumber;
        }
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
<div class="titleH2 font14">${(id)!''}分享记录</div>
<input type="hidden" id="pageNumberinner" name="pager.pageNumber" value="${(pager.pageNumber)!}" />
<input type="hidden" id="pageSizeinner" name="pager.pageSize" value="${(pager.pageSize)!}" />
				<@a.paginationTopinner />
	             	<div class="OrderBottom">
                        <table width="100%">
                            <tr>
                            	<th width="170"><span class="empty15">分享时间</span></th>
                            	<th width="180"><span class="empty15">分享订单号【订单额】</th>
                            	<th width="180"><span class="empty15">分享用户【累计销售】</th>
                            	<th width="229"><span class="empty15">分享商品名称</th>
                                <!--<th width="115"><span class="empty15">${action.getText("label.action")}</th>-->
                            </tr>
                            <#if (pager.results)??>
	                            <#list pager.results as obj>
		                            <tr  onclick="##">
		                                <td><span class="empty15" title="${(obj.createDate?string("yyyy-MM-dd HH:mm:ss"))!}">${(obj.createDate?string("yyyy-MM-dd HH:mm:ss"))!}</span></td>
		                                <td><span class="empty15">${(obj.order.orderSn)!'-'}【<#if (obj.order.totalAmount)??&& (obj.order.totalAmount)?exists>${(obj.order.totalAmount)?string("0")}<#else>0</#if>】</span></td>
		                                <td><span class="empty15">${(obj.order.member.mobile)!'-'}【<#if (obj.order.member.memberAccount.totalSpendAmount)??&&(obj.order.member.memberAccount.totalSpendAmount)?exists>${(obj.order.member.memberAccount.totalSpendAmount)?string("0")}<#else>0</#if>】</span></td>
		                                <td><span class="empty15">${(obj.productShelves.name)!'-'}</span></td>
		                                <!--<td class="operating"><span class="empty15"><a class="zoomThis" onclick="##"></a></span></td>-->
		                            </tr>
	                            </#list>
	                        <#else>
	                        	    <tr>
		                             	<td colspan="4"><span class="empty15">${action.getText("msg.no.data")}</span></td>
		                            </tr>
	                        </#if>
                        </table>
                    </div>
                 <@a.paginationBottominner />
                