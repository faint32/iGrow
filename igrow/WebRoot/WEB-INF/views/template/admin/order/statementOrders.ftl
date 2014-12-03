<script type="text/javascript">
	//订单
   function searchForminner(){
        var url = "${contextPath}/admin/order/statementOrders.do?id=${(id)!}&idx=${(idx)!}&type=${(type)!}";
        var productType = $("#productType").val();
        if(productType != null && productType !="" && productType != "undefined"){
        	url = url +  "&search.productType="+productType;
        }
        var orderSn = $.trim($("#subOrderSn").val());
        if(orderSn != null && orderSn !="" && orderSn != "undefined" && orderSn != "请输入订单号"){
        	url = url +  "&search.name="+encodeURI(encodeURI(orderSn));
        }
        var pageSize = $("#pageSizeinner").val();
        if(pageSize != null && pageSize !="" && pageSize != "undefined"){
        	url = url +  "&pager.pageSize="+pageSize;
        }
        var pageNumber = $("#pageNumberinner").val();
        if(pageNumber != null && pageNumber !="" && pageNumber != "undefined"){
        	url = url +  "&pager.pageNumber="+pageNumber;
        }
        var endDate = $("#endDate").val();
         if(endDate != null && endDate !="" && endDate != "undefined"){
        	url = url +  "&search.endDate="+encodeURI(endDate);
        }
        var startDate =  $("#startDate").val();
          if(startDate != null && startDate !="" && startDate != "undefined"){
        	url = url +  "&search.startDate="+encodeURI(startDate);
        }
        $.ajaxSetup ({ cache: false });
        $("#OrderTableList").load(url);
   }
   
   //文本框回车搜索方法
function keydownsearchRight(evt){
			evt = (evt) ? evt : ((window.event) ? window.event : "")
			keyCode = evt.keyCode ? evt.keyCode : (evt.which ? evt.which : evt.charCode);
			if (keyCode == 13) {
				searchForminner();//搜索事件
			}
} 
</script>
                    <#if (type?exists&&type??&&type==1)||((admin.roleGroupId)??&&admin.roleGroupId == 2) || ((admin.roleGroupId)??&&admin.roleGroupId == 1 && admin.hotelId != 0) >
	                    <div class="tab_ul">
	                    	<ul>
	                    		<li onClick="show(this,1)" name="tab2" <#if (search.productType)?exists&&(search.productType)??&&search.productType==1>class="default clickThis_ext"</#if>>代售订单<span class="bottomBorder"></span></li>
	                        	<li onClick="show(this,0)" name="tabl" <#if (search.productType)?exists&&(search.productType)??&&search.productType==0>class="default clickThis_ext"</#if>>自售订单<span class="bottomBorder"></span></li>
	                        	<div class="clear"></div>
	                        </ul>
	                    </div>
                    </#if>
	                    <div class="page n_satementArea">
	                        <div class="time_in_out">
	                         <form action="${contextPath}/admin/statement/statementOrders.do" method="post" id="searchOrderForm">
	                        	<input type="hidden" id="subId" name="subId" value="${(id)!}" />
	                            <input type="text" class="timeInput" placeholder="…" <#if search.startDate?exists>value="${(search.startDate)?string("yy-MM-dd")}"</#if> name="startDate" readonly="true" onclick="WdatePicker({dateFmt:'yy-MM-dd',vel:'startDate'})"/><label class="customiseLabel">至</label><input type="text" <#if search.endDate?exists>value="${(search.endDate)?string("yy-MM-dd")}"</#if> placeholder="…" name="endDate" id="promotionendTime"  readonly="true" class="timeInput empty13" onclick="WdatePicker({dateFmt:'yy-MM-dd',vel:'endDate'})"/>
	                        	<input type="hidden" id="startDate" name="search.startDate" <#if search.startDate?exists>value="${(search.startDate)?string("yyyy-MM-dd")}"</#if> />
	                        	<input type="hidden" id="endDate" name="search.endDate" <#if search.endDate?exists>value="${(search.endDate)?string("yyyy-MM-dd")}"</#if> />
	                            <div class="searchOrderDiv">
	                                <input type="text" class="searchBox" id="subOrderSn" name="search.orderSn" value="${(search.name)!}" placeholder="请输入订单号" onkeydown="keydownsearchRight(event)"/>
	                                <input type="hidden" id="pageNumberinner" name="pager.pageNumber" value="${(pager.pageNumber)!}" />
	                                <input type="hidden" id="pageSizeinner" name="pager.pageSize" value="${(pager.pageSize)!}" />
	                                <a class="searchOrderBtn" onclick="searchForminner();"></a>
	                            </div>
	                         </form>
	                        </div>
	                        <#if id?exists&&id??&&id != 0>
		                        <span class="rightText">
						          		<a class="printBarcode" href="${contextPath}/admin/statement/orderExport.do?id=${(id)!}" target="_blank">导 出</a>
						        </span>
					        </#if>
	                        <div class="clear"></div>
	                    </div>
                      <@a.paginationTopinner />
                        <div class="OrderBottom">
                            <table width="760" class="inheritBorder">
                                <tr>
                                    <th width="128"><span class="empty15">订单编号</span></th>
                                    <th width="130"><span class="empty15">商品</span></th>
                                    <th width="80"><span class="empty15">订单金额</span></th>
                                    <#if admin.roleGroupId == 1>
                                    	<#if admin.hotelId != 0>
		                                    		<#if search.productType == 0>
			            								<th width="150"><span class="empty15">平台佣金率</span></th>
			            							</#if>
			            							<#if search.productType == 1>
			            								<th width="100"><span class="empty15">酒店佣金率</span></th>
			            								<th width="100"><span class="empty15">佣金额</span></th>
			            							</#if>
		                                <#elseif admin.supplierId != 0>
		                                    		<th width="100"><span class="empty15">平台佣金率</span></th>
		            								<th width="100"><span class="empty15">酒店佣金率</span></th>
		                                <#else>
	                                       <#if type == 1>
		                                    	<#if search.productType == 0>
		            								<th width="150"><span class="empty15">平台佣金率</span></th>
		            							</#if>
		            							<#if search.productType == 1>
		            								<th width="100"><span class="empty15">酒店佣金率</span></th>
		            								<th width="100"><span class="empty15">佣金额</span></th>
		            							</#if>
	            							</#if>
	            							 <#if type == 2>
		                                    	<th width="100"><span class="empty15">平台佣金率</span></th>
	            								<th width="100"><span class="empty15">酒店佣金率</span></th>
	            							</#if>
	            						</#if>
            						</#if>
            						<#if admin.roleGroupId == 2>
            							<#if search.productType == 0>
            								<th width="100"><span class="empty15">平台佣金率</span></th>
            							</#if>
            							<#if search.productType == 1>
            								<th width="100"><span class="empty15">酒店佣金率</span></th>
            								<th width="100"><span class="empty15">佣金额</span></th>
            							</#if>
            						</#if>
            						<#if admin.roleGroupId == 3>
            							<th width="100"><span class="empty15">平台佣金率</span></th>
            							<th width="100"><span class="empty15">酒店佣金率</span></th>
            						</#if>
                                    <th width="154"><span class="empty15">下单时间</span></th>
                                    <th width="100"><span class="empty15">结算状态</span></th>
                                </tr>
                                <#if (pager.results)??>
	                            	<#list pager.results as obj>
		                                <tr>
		                                    <td title="${(obj.orderSn)!}"><span class="order_Number ellipsis empty15">${(obj.orderSn)!}</span></td>
		                                    <td title="${(obj.productShelves.name)!}"><span class="pro_name115 ellipsis empty15">${(obj.productShelves.name)!}</span></td>
		                                    <td><span class="blurColor empty15 bi_price_14">￥${(obj.totalAmount)!}</span></td>
		                                    <#if admin.roleGroupId == 1>
		                                    	<#if admin.hotelId != 0>
		                                    		<#if search.productType == 0>
			            								<td><span class="empty15 redColor">${(obj.orderItems[0].sysCommRate)!}%</span></td>
			            							</#if>
			            							<#if search.productType == 1>
			            								<td><span class="empty15 redColor">${(obj.orderItems[0].hotelCommRate)!}%</span></td>
			            								<td><span class="empty15 redColor">${(obj.orderItems[0].productPrice)!*(obj.orderItems[0].productQuantity)*(obj.orderItems[0].hotelCommRate)/100}</span></td>
			            							</#if>
		                                    	<#elseif admin.supplierId != 0>
		                                    		<td><span class="empty15 redColor">${(obj.orderItems[0].sysCommRate)!}%</span></td>
				            						<td><span class="empty15 redColor">${(obj.orderItems[0].hotelCommRate)!}%</span></td>
		                                    	<#else>
			                                        <#if type == 1>
				                                    	<#if search.productType == 0>
				            								<td><span class="empty15 redColor">${(obj.orderItems[0].sysCommRate)!}%</span></td>
				            							</#if>
				            							<#if search.productType == 1>
				            								<td><span class="empty15 redColor">${(obj.orderItems[0].hotelCommRate)!}%</span></td>
				            								<td><span class="empty15 redColor">${(obj.orderItems[0].productPrice)!*(obj.orderItems[0].productQuantity)*(obj.orderItems[0].hotelCommRate)/100}</span></td>
				            							</#if>
			            							</#if>
			            							 <#if type == 2>
				                                    	<td><span class="empty15 redColor">${(obj.orderItems[0].sysCommRate)!}%</span></td>
				            							<td><span class="empty15 redColor">${(obj.orderItems[0].hotelCommRate)!}%</span></td>
			            							</#if>
		            							</#if>
		            						</#if>
		            						<#if admin.roleGroupId == 2>
		            							<#if search.productType == 0>
		            								<td><span class="empty15 redColor">${(obj.orderItems[0].sysCommRate)!}%</span></td>
		            							</#if>
		            							<#if search.productType == 1>
			            							<td><span class="empty15 redColor">${(obj.orderItems[0].hotelCommRate)!}%</span></td>
			            							<td><span class="empty15 redColor">${(obj.orderItems[0].productPrice)!*(obj.orderItems[0].productQuantity)*(obj.orderItems[0].hotelCommRate)/100}</span></td>
		            							</#if>
		            						</#if>
		            						<#if admin.roleGroupId == 3>
		            							<td><span class="empty15 redColor">${(obj.orderItems[0].sysCommRate)!}%</span></td>
			            						<td><span class="empty15 redColor">${(obj.orderItems[0].hotelCommRate)!}%</span></td>
		            						</#if>
		                                    <td><span class="empty15"><#if obj.createDate?exists>${obj.createDate?string("yyyy-MM-dd HH:mm")}</#if></span></td>
		                                     <#if admin.roleGroupId == 1>
			                                     <#if admin.hotelId != 0>
			                                    		<td class="operating"><span class="empty15">${(obj.hotelStatementStatus.desc)!}</span></td>
			                                	 <#elseif admin.supplierId != 0>
			                                    		<td class="operating"><span class="empty15">${(obj.supplierStatementStatus.desc)!}</span></td>
			                                     <#else>
			                                        <#if type == 1>
				                                    	 <td class="operating"><span class="empty15">${(obj.hotelStatementStatus.desc)!}</span></td>
			            							</#if>
			            							 <#if type == 2>
				                                    	 <td class="operating"><span class="empty15">${(obj.supplierStatementStatus.desc)!}</span></td>
			            							</#if>
			            						 </#if>
		            						</#if>
		            						<#if admin.roleGroupId == 2>
		            							<td class="operating"><span class="empty15">${(obj.hotelStatementStatus.desc)!}</span></td>
		            						</#if>
		            						<#if admin.roleGroupId == 3>
		            							<td class="operating"><span class="empty15">${(obj.supplierStatementStatus.desc)!}</span></td>
		            						</#if>
		                                </tr>
	                                </#list>
                                <#else>
	                        	    <tr>
		                             	<td colspan="6"><span class="empty15">${action.getText("msg.no.data")}</span></td>
		                            </tr>
	                        	</#if>
                            </table>
                        </div>
                        <@a.paginationBottominner />
