<link href="${contextPath}/css/user.css"  rel="stylesheet">
<script type="text/javascript">
    function searchForminner(){
        var url = "${contextPath}/admin/order/uorder.do?member.id="+${(member.id)!0}+"&pager.pageNumber="+$("#pageNumberinner").val()+"&pager.pageSize="+$("#pageSizeinner").val();
        $.ajaxSetup ({ cache: false });
        $("#memberOrderPager").load(url);
	} 
</script>
                     <input type="hidden" id="pageNumberinner" name="pager.pageNumber" value="${(pager.pageNumber)!}" />
                     <input type="hidden" id="pageSizeinner" name="pager.pageSize" value="${(pager.pageSize)!}" />   
                        <table width="100%">
                            <tr>
			                    <th width="144"><span class="empty15">历史订单编号</span></th>
                                <th width="150"><span class="empty15">商品名称</span></th>
                                <th width="110"><span class="empty15">订单金额</span></th>
                                <th width="176"><span class="empty15">下单时间</span></th>
                                <th width="90"><span class="empty15">状态</span></th>
                                <th width="88"><span class="empty15">操作</span></th>
                            </tr>
                            <#if (pager.results)??>
	                            <#list pager.results as obj>
		                            <tr>
		                                <td><span class="no_position"  title="${(obj.orderSn)!}">${(obj.orderSn)!}</span></td>
		                                <td><span class="no_position  pro_name ellipsis" title="${(obj.productShelves.name)!}">${(obj.productShelves.name)!}</span></td>
		                                <td><span class="no_position">${(obj.totalAmount)!}</span></td>
		                                <td><span class="no_position"><#if obj.createDate?exists>${obj.createDate?string("yyyy-MM-dd HH:mm")}</#if></span></td>
		                                <td><span class="no_position redColor">${(obj.status.desc)!}</span></span></td>
		                                <td class="operating"><span class="no_position"><span class="see_icon" onclick="show_childred(this)" id="${(obj.orderSn)!}"><span class="top_arrow_blue"></span>
		                                <div class="detail_member_layer">
                                    	<div class="d_m_l_cont">
		                                        <!--<div class="titleH2 font14">${action.getText("order.detail")}</div>-->
		                                        <div class="OrderTable">
		                                            	<ul class="order_li">
		                                            		<li><span class="  ellipsis">${action.getText("order.number")}：${(obj.orderSn)!}</span></li>
		                                            		<li><span class="empty15 ellipsis">${action.getText("order.leibie")}：${(obj.productShelves.productTypes.desc)!}${action.getText("order.label")}</span></li>
		                                            		<li><span class="empty15 ellipsis">${action.getText("order.type")}：<span class="redColor fontBold">${(obj.status.desc)!}</span></span></li>
		                                            		<div class="clear"></div>
		                                            	</ul>
		                                            <div class="OrderBottom bigTd">
		                                                <table width="100%">
		                                                    <tr>
		                                                        <th width="129"><span class="empty15">${action.getText("productshe.productSn")}</span></th>
								                                <th width="200"><span class="empty15">${action.getText("product.name")}</span></th>
								                                <th width="139"><span class="empty15">${action.getText("product.guige")}</span></th>
								                                <th width="190"><span class="empty15">${action.getText("order.hotel")}</span></th>
								                                <th width="100"><span class="empty15">${action.getText("order.amount")}</span></th>
		                                                    </tr>
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
								                                <td><span class="empty15">${(obj.totalProductPrice)!}</span></td>
								                            </tr>
								                            <tr class="amount_price">
								                                <td colspan="5"><span class="rightText">${action.getText("order.totalamount")}：<span class="redColor fontBold font19px">${(obj.totalAmount)!}</span>元<b>（${(obj.deliveryMode.desc)!}）</b></span></td>
								                            </tr>
		                                                </table>
		                                            </div>
		                                            <div class="operationIn">
		                                            <p class="receipt_way_title">
														<b>收货方式</b>
													</p>
													<div class="receipt_way">
		                                            	${action.getText("order.shipAddress")}：<#if obj??&&obj.deliveryMode??&&obj.deliveryMode!=null&&obj.deliveryMode.value==0>${(obj.deliveryMode.desc)!}<#if obj.orderShip != null>，${(obj.orderShip.deliverySn)!}<br>${(obj.shipPhone)!}<#else>，${(result.member.mobile)!}</#if><#else>${(obj.shipArea)!}${(obj.shipAddress)!}<br>${(obj.shipName)!}<br>${(obj.shipPhone)!}</#if>
		                                            </div>
		                                            <#if order??&& order.orderShip != null>
		                    							<p class="receipt_way_title"><b>物流信息</b><br><span class="order_logistics">${(order.orderShip.deliverySn)!""}(${(order.orderShip.deliveryCorpName)!""})</span></p>
		                    				        </#if>
			                      				    <p class="receipt_way_title">
			                      				    	<b>发票信息</b><br>
			                      				    	<span class="order_logistics">
			                      				    		 <#if obj!=null&&obj.invoiceTopType??><#if obj.invoiceTopType.value==2>${(obj.invoiceTopName)!}<#else>${(obj.invoiceTopType.desc)!}</#if><#else>无</#if>
			                      				    	</span>
			                      				    </p>
			                      				    </div>
		                                            <div class="clear"></div>
		                                        </div>
		                                    </div>
                                    	</div>
		                                </span></span></td>
		                            </tr> 
	                            </#list>
	                        <#else>
	                        	    <tr>
		                             	<td colspan="6"><span class="empty15">${action.getText("msg.no.data")}</span></td>
		                            </tr>
	                        </#if>
                        </table>
                    <@a.paginationBottominner />
                    
