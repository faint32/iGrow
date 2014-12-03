<link href="${contextPath}/css/system.css"  rel="stylesheet">
<script type="text/javascript">
   function searchForminner(){
       	var url = "${contextPath}/admin/order/dayDetails.do?id=${(id)!}";
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
<div class="titleH2 font14">${(id)!''}订单
<#if id!=null><a class="addProducts paddingL13" href="${contextPath}/admin/order/orderExport.do?id=${(id)!}"><img src="${contextPath}/css/images/btn_Export.png" width="14">导出</a></#if>
</div>
<input type="hidden" id="pageNumberinner" name="pager.pageNumber" value="${(pager.pageNumber)!}" />
<input type="hidden" id="pageSizeinner" name="pager.pageSize" value="${(pager.pageSize)!}" />
				<div class="pageTopinner">
					<@a.paginationTopinner />
				</div>
				<#if (pager.results)??>
	            <#list pager.results as obj>
	            	 <div class="OrderTable n_orderTabVal">
	                    <div class="orderD">
	                		<ul class="order_li">
	                			<li><span class="ellipsis"  title="${(result.orderSn)!}">${action.getText("order.number")}：${(obj.orderSn)!}</span></li>
	                			<li><span class="ellipsis">${action.getText("order.leibie")}：${(obj.productShelves.productTypes.desc)!}${action.getText("order.label")}</span></li>
	                			<li><span class="ellipsis">${action.getText("order.type")}：<span class="redColor fontBold">${(obj.status.desc)!}</span></span></li>
	                			<li><span class="ellipsis">${action.getText("order.createDate")}：${(obj.createDate?string("yyyy-MM-dd HH:mm:ss"))!}</span></li>
	                			<li><span class="ellipsis">${action.getText("order.payDate")}：<#if obj?exists && obj.orderPayment!=null>${(obj.orderPayment.createDate?string("yyyy-MM-dd HH:mm:ss"))!}</#if></span></li>
	                			<li><span class="ellipsis">会员账号：${(obj.member.mobile)!""}</span></li>
	                			<div class="clear"></div>
	                		</ul>
	                    </div>
	                    <div class="OrderBottom bigTd">
	                        <table width="760">
	                            <tr>
	                                <th width="126"><span class="empty15">${action.getText("productshe.productSn")}</span></th>
	                                <th width="174"><span class="empty15">${action.getText("product.name")}</th>
	                                <th width="141"><span class="empty15">${action.getText("product.guige")}</th>
	                                <th width="197"><span class="empty15">${action.getText("order.hotel")}</th>
	                                <th width="126"><span class="empty15">${action.getText("order.amount")}</th>
	                            </tr>
	                            <tr>
	                                <td><span class="empty15">${(obj.productShelves.productSn)!}</span></td>
	                                <td><span class="empty15">${(obj.productShelves.name)!}</span></td>
	                                <td><span class="empty15">
	                                <#if obj??&&obj.orderItems??&&obj.orderItems!=null>
	                                   <#list obj.orderItems as orderItem>
	                                          <#if orderItem.specificationValue??&&orderItem.specificationValue!=null>${(orderItem.specificationValue)!"无"}<#else>${(orderItem.productConfig.specValue)!"无"}</#if>，<#if orderItem.specificationValue??&&orderItem.specificationValue!=null>${(orderItem.propertyValue)!"无"}<#else>${(orderItem.productConfig.propertyValue)!"无"}</#if>(${(orderItem.productQuantity)!"0"})</br>
	                                   </#list>
	                                </#if>
	                                </span>
	                               </td>
	                                <td><span class="empty15">${(obj.hotel.name)!}<br>
	                                   ${action.getText("order.contactName")}：${(obj.hotel.contactName)!}<br>
	                                   ${(obj.hotel.phone)!}
	                                   </span>
	                                </td>
	                                <td><span class="empty15 blurColor fontBold">${(obj.totalProductPrice)!}</span></td>
	                            </tr>
	                            <tr class="amount_price">
	                                <td colspan="5"><span class="rightText">${action.getText("order.totalamount")}：<span class="redColor fontBold font19px">${(obj.totalAmount)!}</span>元<b>（${(obj.deliveryMode.desc)!}）</b></span></td>
	                            </tr>
	                        </table>
	                    </div>
	                    <p class="receipt_way_title"><b>收货方式</b></p>
	                    <div class="receipt_way" id="receipt_way0">
	                    	<!--${action.getText("order.shipAddress")}：--><#if obj??&&obj.deliveryMode??&&obj.deliveryMode!=null&&obj.deliveryMode.value==0>${(obj.deliveryMode.desc)!}<#if obj.orderShip != null><br />${(obj.orderShip.deliverySn)!}</#if><#else>${(obj.shipArea)!}${(obj.shipAddress)!}<br />${(obj.shipName)!}<br />${(obj.shipPhone)!}</#if>
	                    </div>
	                    <#if obj??&& obj.orderShip != null>
	                    <p class="receipt_way_title"><b>物流信息</b><br><span class="order_logistics">${(obj.orderShip.deliverySn)!""}(${(obj.orderShip.deliveryCorpName)!""})</span></p>
	                    </#if>
	                    <p class="receipt_way_title">
	                    	<b>发票信息</b>
	                    	<br>
	                    	<span class="order_logistics">
	                    		<#if obj!=null&&(obj.invoiceTopType)??><#if obj.invoiceTopType.value==2>${(obj.invoiceTopName)!}<#else>${(obj.invoiceTopType.desc)!}</#if><#else>无</#if>
	                    	</span>
	                    </p>
	                    <div class="clear"></div>
	                </div>
	            </#list>
	            <#else>
	                <div class="OrderTable n_orderTabVal">
	                    <div class="orderD">
	                		<ul class="order_li">
	                			<li><span class="ellipsis"  title="${(result.orderSn)!}">${action.getText("order.number")}：${(result.orderSn)!}</span></li>
	                			<li><span class="ellipsis">${action.getText("order.leibie")}：${(result.productShelves.productTypes.desc)!}${action.getText("order.label")}</span></li>
	                			<li><span class="ellipsis">${action.getText("order.type")}：<span class="redColor fontBold">${(result.status.desc)!}</span></span></li>
	                			<li><span class="ellipsis">${action.getText("order.createDate")}：${(result.createDate?string("yyyy-MM-dd HH:mm:ss"))!}</span></li>
	                			<li><span class="ellipsis">${action.getText("order.payDate")}：<#if result?exists && result.orderPayment!=null>${(result.orderPayment.createDate?string("yyyy-MM-dd HH:mm:ss"))!}</#if></span></li>
	                			<li><span class="ellipsis">会员账号：${(result.member.mobile)!""}</span></li>
	                			<div class="clear"></div>
	                		</ul>
	                    </div>
	                    <div class="OrderBottom bigTd">
	                        <table width="760">
	                            <tr>
	                                <th width="126"><span class="empty15">${action.getText("productshe.productSn")}</span></th>
	                                <th width="174"><span class="empty15">${action.getText("product.name")}</th>
	                                <th width="141"><span class="empty15">${action.getText("product.guige")}</th>
	                                <th width="197"><span class="empty15">${action.getText("order.hotel")}</th>
	                                <th width="126"><span class="empty15">${action.getText("order.amount")}</th>
	                            </tr>
	                            <tr>
	                                <td><span class="empty15">${(result.productShelves.productSn)!}</span></td>
	                                <td><span class="empty15">${(result.productShelves.name)!}</span></td>
	                                <td><span class="empty15">
	                                <#if result??&&result.orderItems??&&result.orderItems!=null>
	                                   <#list result.orderItems as orderItem>
	                                          <#if orderItem.specificationValue??&&orderItem.specificationValue!=null>${(orderItem.specificationValue)!"无"}<#else>${(orderItem.productConfig.specValue)!"无"}</#if>，<#if orderItem.specificationValue??&&orderItem.specificationValue!=null>${(orderItem.propertyValue)!"无"}<#else>${(orderItem.productConfig.propertyValue)!"无"}</#if>(${(orderItem.productQuantity)!"0"})</br>
	                                   </#list>
	                                </#if>
	                                </span>
	                               </td>
	                                <td><span class="empty15">${(result.hotel.name)!}<br>
	                                   ${action.getText("order.contactName")}：${(result.hotel.contactName)!}<br>
	                                   ${(result.hotel.phone)!}
	                                   </span>
	                                </td>
	                                <td><span class="empty15 blurColor fontBold">${(result.totalProductPrice)!}</span></td>
	                            </tr>
	                            <tr class="amount_price">
	                                <td colspan="5"><span class="rightText">${action.getText("order.totalamount")}：<span class="redColor fontBold font19px">${(result.totalAmount)!}</span>元<b>（${(result.deliveryMode.desc)!}）</b></span></td>
	                            </tr>
	                        </table>
	                    </div>
	                    <p class="receipt_way_title"><b>收货方式</b></p>
	                    <div class="receipt_way" id="receipt_way0">
	                    	<!--${action.getText("order.shipAddress")}：--><#if result??&&result.deliveryMode??&&result.deliveryMode!=null&&result.deliveryMode.value==0>${(result.deliveryMode.desc)!}<#if result.orderShip != null><br />${(result.orderShip.deliverySn)!}</#if><#else>${(result.shipArea)!}${(result.shipAddress)!}<br />${(result.shipName)!}<br />${(result.shipPhone)!}</#if>
	                    </div>
	                    <#if result??&& result.orderShip != null>
	                    <p class="receipt_way_title"><b>物流信息</b><br><span class="order_logistics">${(result.orderShip.deliverySn)!""}(${(result.orderShip.deliveryCorpName)!""})</span></p>
	                    </#if>
	                    <p class="receipt_way_title">
	                    	<b>物流信息</b>
	                    	<br>
	                    	<span class="order_logistics">
	                    	 <#if result!=null&&(result.invoiceTopType)??><#if result.invoiceTopType.value==2>${(result.invoiceTopName)!}<#else>${(result.invoiceTopType.desc)!}</#if><#else>无</#if>
	                    	</span>
	                    </p>
	                    <div class="order-status-btn" <#if result!=null&&result.productShelves!=null&&result.productShelves.productTypes!=null&& result.productShelves.productTypes.value == 0><#elseif admin != null && admin.roleGroupId ==2>style="display:none;"</#if>>
		                        <span class="can-send-btn">
		                            <#if result??&& (result.status.value==0 || result.status.value==1)><a class="cancel-order-btn cancel-btn" name="${(result.id)!}" onclick="cancelOrder(this,0)">取消订单</a></#if>
		                            <#if result??&& result.status.value==1><a class="send-btn confirm-save">发  货</a></#if>
		                            <#if result??&& result.status.value==4><a class="confirm-save" name="${(result.id)!}" onclick="acceptApplicate(this)">接受退货</a><a class="cancel-btn" name="${(result.id)!}" onclick="cancelApplicate(this)">取消申请</a></#if>
		                        </span>
	                    </div>
	                    <div class="clear"></div>
	                    <div class="delivery">
	                        <select style="width:100px">
	                            <#list deliveryCompanys as deliveryCompany>
	                              <option value="${(deliveryCompany.value)!""}">${(deliveryCompany.desc)!""}</option>
	                            </#list>
	                        </select>
	                        <input type="text" class="express-orders" placeholder="请输入快递单号或领取人姓名…" style="width:200px" maxlength="30"/>
	                        <div class="clear"></div>
	                        <div class="can-send-btn confirmDiv">
	                            <a class="confirm-delivery" name="${(result.id)!}" onclick="delivery(this,0)">确认发货</a>
	                        </div>
	                        <div class="clear"></div>
	                    </div>
	                    <a class="unprocessed-order" <#if result!=null && result.status != null && result.status.value == 1>style="display:block;"<#else>style="display:none;"</#if>">该用户还有<span id="orderNum"></span>个未处理订单</a>
	                    <div class="clear"></div>
	                </div>
                </#if>
                 <@a.paginationBottominner />
                