<script type="text/javascript">
	   $(function(){
	   	});
   	
   	
   	  function sortSearch(id,obj){
   	      if($(obj).hasClass("desc_sort")){
   	      	 $("#orderinner").val("asc");
   	      	 $(obj).removeClass("desc_sort").addClass("asc_sort");
   	      }else{
   	      	 $("#orderinner").val("desc");
   	      	 $(obj).removeClass("asc_sort").addClass("desc_sort");
   	      }
	      $("#orderByinner").val(id)
	      searchForminner(); 
  		}
   	
   	   function searchForminner(){
	        var url = "${contextPath}/admin/productshe/barCodeInput.do?id=${(id)!}";
	        var pageSize = $("#pageSizeinner").val();
        	if(pageSize != null && pageSize !="" && pageSize != "undefined"){
        		url = url +  "&pager.pageSize="+pageSize;
        	}
	        var pageNumber = $("#pageNumberinner").val();
	        if(pageNumber != null && pageNumber !="" && pageNumber != "undefined"){
	        	url = url +  "&pager.pageNumber="+pageNumber;
	        }
	        var orderBy = $("#orderByinner").val();
	        if(orderBy != null && orderBy !="" && orderBy != "undefined"){
	        	url = url +  "&search.orderBy="+orderBy;
	        }
	        var order = $("#orderinner").val();
	        if(order != null && order !="" && order != "undefined"){
	        	url = url +  "&pager.order="+order;
	        }
	        //$.ajaxSetup ({ cache: false });
	        loadRightPage(url);
  		}
  		
  function printme(){
    document.body.innerHTML=$(".n_hotelName_summary").html();
    window.print();
}
 
</script>
<div class="titleH2 font14"><span class="leftText">商品条码列表</span><span class="rightText barcordUpdate"><a class="printBarcode" href="${contextPath}/admin/productshe/barcodePrint.do?id=${(id)!}" target="_blank">打 印</a></span></div>
 
<input type="hidden" id="pageNumberinner" name="pager.pageNumber" value="${(pager.pageNumber)!}" style="display:none" />
<input type="hidden" id="pageSizeinner" name="pager.pageSize" value="${(pager.pageSize)!}"  style="display:none"/>
<input type="text" id="orderinner" name="pager.order" value="${(pager.order)!}"  style="display:none"/>
<input type="text" id="orderByinner" name="search.orderBy" value="${(search.orderBy)!}"  style="display:none"/>
	<div class="OrderTable pageChange_n">
	
	<div class="n_hotelName_summary">
                    	<span class="n_hotelName"><b>${(stockDto.hotel.name)!}</b></span>
                        <span class="n_hotelProductAccount">商品总件数<i class="redColor">${(pager.totalCount)!'0'}</i></span>
                    </div>
	            <@a.paginationTopinner />
                    <div class="OrderBottom">
                        <table width="760">
                            <tr>
				                <th width="100"><span class="empty15">序号</span></th>
                                <th width="343"><span class="empty15">商品名称</span></th>
                                <th width="140"><span class="empty15">商品价格</span></th>
                                <th width="175"><span class="empty15 empty28">商品条码</span></th>
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
                    <@a.paginationBottominner />
</div> 
                
                	
<script type="text/javascript">
window.onload = function(){
	$(".n_statement_amount tr").css({"background-color":"#fff"})
	}
</script>