<@a.header "${title}">
<script type="text/javascript">
      $(function () {
            first();
			$(".userName").live("click", function(){
				$(".elastic_layer_header").first().stop().show();
				$(".ly").show();
			}).mouseleave(function(){
				$(".elastic_layer_header").hide();
				$(".ly").hide();
			});
			$(".ly").live("click", function(){
				$(".elastic_layer_header").hide();
				$(".ly").hide();
			});
			$(".bottomBlock").live("click", function(){
				$(".layer").hide();
			});
			$(".confirm-save").live("click", function(){
				$(".tip_save_success").show();
				$("html,body").animate({scrollTop : '0px'}, 800);
				setTimeout(function(){$(".tip_save_success").slideUp(1000)}, 3000)
			})
        });
 
</script>
</@a.header >
<body>
	<@a.menu />
  <div id="Contenter">
    <div class="contentBody noLeft">
        <div class="content-right">
	    <div class="titleH2 font14"><span class="leftText">商品条码列表</span><span class="rightText barcordUpdate"><a class="printBarcode"  href="${contextPath}/admin/productsheimage/barcodePrint.do" target="_blank">打 印</a><#if (stockDto.hotel.printUpdatingFlag)??><#if stockDto.hotel.printUpdatingFlag.value==1><span class="tip_update">更新<img src="${contextPath}/css/images/red_downArrow.png"></span></#if></#if></span></div>
		<form action="${contextPath}/admin/productsheimage/barcode.do" method="post" id="searchForm">
		<input type="hidden" id="pageNumber" name="pager.pageNumber" value="${(pager.pageNumber)!}" style="display:none" />
		<input type="hidden" id="pageSize" name="pager.pageSize" value="${(pager.pageSize)!}"  style="display:none"/>
		<input type="text" id="order" name="pager.order" value="${(pager.order)!}"  style="display:none"/>
		<input type="text" id="orderBy" name="search.orderBy" value="${(search.orderBy)!}"  style="display:none"/>
		</form>
			<div class="OrderTable">
	                <div class="n_hotelName_summary">
                    	<span class="n_hotelName">${(stockDto.hotel.name)!}</span>
                        <span class="n_hotelProductAccount">商品总件数：<i class="redColor">${(pager.totalCount)!'0'}</i></span>
                    </div>
	            <@a.paginationTop />
                    <div class="OrderBottom">
                        <table width="760">
                            <tr>
				                <th width="99"><span class="empty15">序号</span></th>
                                <th width="343"><span class="empty15">商品名称</span></th>
                                <th width="140"><span class="empty15">商品价格</span></th>
                                <th width="176"><span class="empty15 empty28">商品条码</span></th>
                            </tr>
 							<#if (pager.results)??>
	                            <#list pager.results as obj>
		                            <tr>
		                            <td><span class="empty15">${obj_index + 1}</span></td>
		                            <td><span class="empty15  pro_name_l353 ellipsis">${(obj.productShelves.productInfo.name)!""}(${(obj.specificationValue)!""}*${(obj.propertyValue)!""})</span></td>
		                            <td><span class="empty15"><i class="RMB">￥</i>${(obj.price)!}</span></td>
		                            <td><span class="empty15"><span class="barcordTop"><img src="http://www.1ct.cc:8080/borMall/barcode?msg=1<#if (obj.id)?length ==1>00000${(obj.id)}<#elseif (obj.id)?length ==2>0000${(obj.id)}<#elseif (obj.id)?length ==3>000${(obj.id)}<#elseif (obj.id)?length ==4>00${(obj.id)}<#elseif (obj.id)?length ==5>0${(obj.id)}<#else>${(obj.id)}</#if>9&type=code39" width="160" /></span></span></td>
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
          <div class="clear"></div>
        </div>
    </div>              
   </div>                	
<script type="text/javascript">
window.onload = function(){
	$(".n_statement_amount tr").css({"background-color":"#fff"})
	}
</script>

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