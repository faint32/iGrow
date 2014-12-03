 <link href="${contextPath}/css/system.css"  rel="stylesheet">
 <script type="text/javascript">
   $(function(){
       var  orderNum = $("#orderNumHide").html();
       if(orderNum == 0){
          $(".unprocessed-order").hide();
       }
       $("#orderNum").html(orderNum);
   });
 </script>  
 <span id="orderNumHide" style="display:none;"><#if orderList??&&orderList!=null>${orderList?size}<#else>0</#if></span>
 <#if orderList??&&orderList!=null>
                       <#list orderList as order>
                                    <div class="orderBlock">
			                            <div class="orderD">
										    <ul class="order_li">
					                			<li><span class="empty15 ellipsis" title="${(order.orderSn)!}">${action.getText("order.number")}：${(order.orderSn)!}</span></li>
					                			<li><span class="empty15 ellipsis">${action.getText("order.leibie")}：${(order.productShelves.productTypes.desc)!}${action.getText("order.label")}</span></li>
					                			<li><span class="empty15 ellipsis">${action.getText("order.type")}：<span class="redColor fontBold orderType">${(order.status.desc)!}</span></span></li>
					                			<li><span class="empty15 ellipsis">${action.getText("order.createDate")}：${(order.createDate?string("yyyy-MM-dd HH:mm:ss"))!}</span></li>
					                			<li><span class="empty15 ellipsis">${action.getText("order.payDate")}：<#if order?exists && order.orderPayment!=null>${(order.orderPayment.createDate?string("yyyy-MM-dd HH:mm:ss"))!}</#if></span></li>
					                			<li><span class="empty15 ellipsis">会员账号：${(order.member.mobile)!""}</span></li>
					                			<div class="clear"></div>
					                		</ul>
					                    </div>
			                            <div class="OrderBottom bigTd">
			                                <table width="100%">
			                                    <tr>
			                                        <th width="99"><span class="empty15">${action.getText("productshe.productSn")}</span></th>
					                                <th width="149"><span class="empty15">${action.getText("product.name")}</span></th>
					                                <th width="129"><span class="empty15">${action.getText("product.guige")}</span></th>
					                                <th width="149"><span class="empty15">${action.getText("order.hotel")}</span></th>
					                                <th width="145"><span class="empty15">${action.getText("order.amount")}</span></th>
			                                    </tr>
			                                    <tr>
			                                        <td><span class="empty15">${(order.productShelves.productSn)!}</span></td>
			                                        <td><span class="empty15">${(order.productShelves.name)!}</span></td>
			                                        <td><span class="empty15">
													<#if order.orderItems??&&order.orderItems!=null>
					                                   <#list order.orderItems as orderItem>
					                                         <#if orderItem.specificationValue??&&orderItem.specificationValue!=null>${(orderItem.specificationValue)!"无"}<#else>${(orderItem.productConfig.specValue)!"无"}</#if>，<#if orderItem.specificationValue??&&orderItem.specificationValue!=null>${(orderItem.propertyValue)!"无"}<#else>${(orderItem.productConfig.propertyValue)!"无"}</#if>(${(orderItem.productQuantity)!"0"})</br>
					                                   </#list>
					                                </#if>
					                                </span>
													</td>
			                                        <td><span class="empty15">${order.hotel.name}<br>
			                                            ${action.getText("order.contactName")}：${order.hotel.contactName}<br>
                                   						${order.hotel.phone}</span>
			                                        </td>
			                                        <td><span class="empty15">${(order.totalProductPrice)!}</span></td>
			                                    </tr>
			                                    <tr class="amount_price">
			                                        <td colspan="5"><span class="rightText">${action.getText("order.totalamount")}：<span class="redColor fontBold font19px">${(order.totalAmount)!}</span>元<b>（${(order.deliveryMode.desc)!}）</b></span></td>
			                                    </tr>
			                                </table>
			                            </div>
			                            <p class="receipt_way_title">
											<b>收货方式</b>
										</p>
										<div class="receipt_way" id="receipt_way${order_index+1}">
			                                <!--${action.getText("order.shipAddress")}：--><#if order??&&order.deliveryMode??&&order.deliveryMode!=null&&order.deliveryMode.value==0><#if order.orderShip != null><br>${(order.orderShip.deliverySn)!}<br>${(order.shipPhone)!}<#else><br>${(result.member.mobile)!}</#if><#else>${(order.shipArea)!}${(order.shipAddress)!}<br></#if>${(order.shipName)!}<br>${(order.shipPhone)!}
			                            </div>
			                            <#if order??&& order.orderShip != null>
                    						<p class="receipt_way_title"><b>物流信息</b><br><span class="order_logistics">${(order.orderShip.deliverySn)!""}(${(order.orderShip.deliveryCorpName)!""})</span></p>
                    				    </#if>
			                            <p class="receipt_way_title">
			                            	<b>发票信息</b><br>
			                            	<span class="order_logistics">
			                            		<#if order!=null&&order.invoiceTopType??><#if order.invoiceTopType.value==2>${(order.invoiceTopName)!}<#else>${(order.invoiceTopType.desc)!}</#if><#else>无</#if>
			                            	</span>
			                            <p>
			                            <div class="order-status-btn" <#if order!=null&&order.productShelves!=null&&order.productShelves.productTypes!=null&& order.productShelves.productTypes.value == 0> <#elseif  admin != null && admin.roleGroupId ==2></#if>>
			                                <span class="can-send-btn">
			                                 <#if order??&& order.status.value==1>
						                                 <#if order.productShelves.productTypes.value==1>
						                                    <#if order.deliveryMode.value == 0 && admin != null && (admin.roleGroupId ==1 || admin.roleGroupId == 2)>
							                                      <#if admin.roleGroupId ==1 && admin.hotelId != 0>
							                                      <#else>
								                                  <a class="send-btn confirm-save">发  货</a>
								                                  </#if>
							                                <#elseif order.deliveryMode.value == 1 && admin != null && (admin.roleGroupId ==1 || admin.roleGroupId == 3)>  
							                                      <#if admin.roleGroupId ==1 && admin.hotelId != 0>
							                                      <#else>
								                                  <a class="send-btn confirm-save">发  货</a>
								                                  </#if>
							                                </#if>
						                                 <#else>  
						                                 </#if>
						                       </#if>
						                       <#if order??&& order.status.value==0 && result.paymentType.value == 1 && admin != null && admin.roleGroupId != 3><a class="confirm-delivery" name="${(order.id)!}" onclick="orderPay(this,0)">已支付</a></#if>
			                                   <#if order??&& order.status.value==4><a class="confirm-save" name="${(order.id)!}" onclick="acceptApplicate(this)">接受退货</a><a class="cancel-btn" name="${(order.id)!}" onclick="cancelApplicate(this)">取消申请</a></#if>
			                                   <#if order??&& (order.status.value==0 || order.status.value==1)>
					                               <#if order.status.value==1 && admin != null && admin.roleGroupId ==1 && admin.hotelId != 0>
					                               <#elseif order.status.value==1 && admin != null && admin.roleGroupId ==1 && admin.hotelId == 0>
					                                <a class="cancel-order-btn cancel-btn" name="${(order.id)!}" onclick="cancelOrder(this,0)">取消订单</a>
					                               <#elseif order.status.value==1 && admin != null && admin.roleGroupId ==2>
					                               <#elseif order.status.value==0>
					                                <a class="cancel-order-btn cancel-btn" name="${(order.id)!}" onclick="cancelOrder(this,0)">取消订单</a>
					                               </#if>
					                            </#if>
			                                    </span>
			                            </div>
			                            <div class="clear"></div>
			                            <div class="delivery">
			                                <select style="width:100px">
			                                    <#list deliveryCompanys as deliveryCompany>
					                                   <#if order?? &&order.deliveryMode != null && order.deliveryMode.value == 0>
						                                       <#if deliveryCompany_index==0>
						                                         <option value="${(deliveryCompany.value)!""}">${(deliveryCompany.desc)!""}</option>
						                                       </#if>
						                               <#elseif order?? &&order.deliveryMode != null && order.deliveryMode.value == 1>   
						                              		   <#if deliveryCompany_index gt 0>
						                                         <option value="${(deliveryCompany.value)!""}">${(deliveryCompany.desc)!""}</option>
						                                       </#if>     
						                               </#if>
					                            </#list>
			                                </select>
			                                <input type="text" class="express-orders" placeholder="请输入快递单号或领取人姓名…" style="width:200px" maxlength="30"/>
			                                <div class="clear"></div>
			                                <div class="can-send-btn confirmDiv">
			                                    <a class="confirm-delivery confirm-save" name="${(order.id)!}"  onclick="delivery(this,${order_index+1})">确认发货</a>
			                                </div>
			                                <div class="clear"></div>
			                            </div>
			                            <div class="clear"></div>
			                        </div>
                       </#list>
                    </#if>
