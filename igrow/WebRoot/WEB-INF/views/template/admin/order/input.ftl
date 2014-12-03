<link href="${contextPath}/css/system.css"  rel="stylesheet">
<script type="text/javascript">
    
   $(function(){
        var url = "${contextPath}/admin/order/unpro.do?result.member.id="+${(result.member.id)!0}+"&result.id="+${(result.id)!0};
        $(".unprocessed-orders-block").load(url);
	});
	//取消订单
	function cancelOrder(obj,index){
	   if(confirm("确定取消订单吗？")){
		         var orderId = $(obj).attr("name");
		           $.ajax({    
			        type:'POST',        
			        url:'${contextPath}/admin/order/cancel.do?id='+orderId,    
			        data:null,    
			        cache:false,    
			        dataType:'json',    
			        success:function(data){ 
			        	if(data.status=="y"){
			        		tip_show(data.status, data.info);
			        		setTimeout(function(){
										tip_hide_w();
								  },1000);
				        	$(obj).parent().parent().parent().children().find(".orderType").html("已取消");
				        	var orderNum = $("#orderNum").html();
				        	if(parseInt(orderNum) > 0 && index == 1){
				        	   $("#orderNum").html(parseInt(orderNum)-1)
				        	}
				        	$.ajaxSetup ({ cache: false });
				        	var url = "${contextPath}/admin/order/lists.do?search.id="+${(result.id)!0}+"&search.searchStatus="+$("#searchStatus").val()+"&search.productType="+$("#productType").val()+"&search.startDate="+$("#startDate").val()+"&search.endDate="+$("#endDate").val()+"&pager.pageNumber="+$("#pageNumber").val()+"&pager.pageSize="+$("#pageSize").val()+"&search.name="+$("#searchName").val();
			        	    $(".content-left").load(url);
			        	}else{
			        		tip_show(data.status, data.info);
			        		setTimeout(function(){
										tip_hide_w();
								  },1000);
			        		return false;
			        	}
			        	$(obj).parent().parent().hide();
			        }    
			     }); 
		    }
	}
	//订单发货
	function delivery(obj,index){
	       var deliverySn = $(obj).parent().parent().children(".express-orders").val();
           if(deliverySn == "" || deliverySn == "请输入快递单号或领取人姓名…"){
              alert("请输入快递单号或领取人姓名");
              return;
           }
		    if(confirm("是否确认发货吗？")){
		           var deliveryCorp = $(obj).parent().parent().children().find("option:selected").val();
		           var deliveryCorpName = $(obj).parent().parent().children().find("option:selected").text();
		           var orderId = $(obj).attr("name");
		           var formParam={
		             "id":orderId,
		             "deliveryCorp":deliveryCorp,
		             "orderShip.deliverySn":deliverySn
		           };
		           $.ajax({    
			        type:'POST',        
			        url:'${contextPath}/admin/order/delivery.do',    
			        data:formParam,    
			        cache:false,    
			        dataType:'json',    
			        success:function(data){ 
			        	if(data.status=="y"){
			        	    tip_show(data.status, data.info);
			        	    setTimeout(function(){
										tip_hide_w();
								  },1000);
			        	    $(obj).parent().parent().parent().children().find(".orderType").html("待收货");
			        	    $("#receipt_way"+index).after("<p class='receipt_way_title'><b>物流信息</b><span class='order_logistics'>"+deliverySn+"("+deliveryCorpName+")</span></p>");
			        	    var orderNum = $("#orderNum").html();
				        	if(parseInt(orderNum) > 0 && index > 0){
				        	   $("#orderNum").html(parseInt(orderNum)-1)
				        	}
			        	   // var url = "${contextPath}/admin/order/lists.do?search.id="+${(result.id)!0};
			        	    $.ajaxSetup ({ cache: false });
			        	    var url = "${contextPath}/admin/order/lists.do?search.id="+${(result.id)!0}+"&search.searchStatus="+$("#searchStatus").val()+"&search.productType="+$("#productType").val()+"&search.startDate="+$("#startDate").val()+"&search.endDate="+$("#endDate").val()+"&pager.pageNumber="+$("#pageNumber").val()+"&pager.pageSize="+$("#pageSize").val()+"&search.name="+$("#searchName").val();
			        	    $(".content-left").load(url);
			        	}else{
			        		tip_show(data.status, data.info);
			        		setTimeout(function(){
										tip_hide_w();
								  },1000);
			        		return false;
			        	}
			        	$(obj).parent().parent().hide();
		               // $(obj).parent().parent().siblings(".order-status-btn").fadeIn();
			        }    
			     }); 
		    }
	}
	//取消退货申请
	function cancelApplicate(obj){
	   if(confirm("确定取消该订单的退货申请吗？")){
		         var orderId = $(obj).attr("name");
		           $.ajax({    
			        type:'POST',        
			        url:'${contextPath}/admin/order/cancelApplicate.do?id='+orderId,    
			        data:null,    
			        cache:false,    
			        dataType:'json',    
			        success:function(data){ 
			        	if(data.status=="y"){
			        		tip_show(data.status, data.info);
			        	    setTimeout(function(){
										tip_hide_w();
								  },1000);
				        	commonSearch();
			        	}else{
			        		tip_show(data.status, data.info);
			        	    setTimeout(function(){
										tip_hide_w();
								  },1000);
			        		return false;
			        	}
			        }    
			     }); 
		    }
	}
	
	//接受退货申请
	function acceptApplicate(obj){
	   if(confirm("确定接受该订单的退货申请吗？")){
		         var orderId = $(obj).attr("name");
		           $.ajax({    
			        type:'POST',        
			        url:'${contextPath}/admin/order/acceptApplicate.do?id='+orderId,    
			        data:null,    
			        cache:false,    
			        dataType:'json',    
			        success:function(data){ 
			        	if(data.status=="y"){
			        		tip_show(data.status, data.info);
			        	    setTimeout(function(){
										tip_hide_w();
								  },1000);
				        	commonSearch();
			        	}else{
			        		tip_show(data.status, data.info);
			        	    setTimeout(function(){
										tip_hide_w();
								  },1000);
			        		return false;
			        	}
			        }    
			     }); 
		    }
	}
	
//订单支付
function orderPay(obj,index,productTypes,deliveryMode,roleGroupId){
	   if(confirm("确定要把订单的状态改成已支付吗？")){
	             tip_show('w', "数据处理中...");
		         var orderId = $(obj).attr("name");
		           $.ajax({    
			        type:'POST',        
			        url:'${contextPath}/admin/order/orderPay.do?id='+orderId,    
			        data:null,    
			        cache:false,    
			        dataType:'json',    
			        success:function(data){ 
			        	if(data.status=="y"){
			        		tip_show(data.status, data.info);
			        		setTimeout(function(){
										tip_hide_w();
								  },1000);
				        	//$(obj).parent().parent().parent().children().find(".orderType").html("待收货");
				        	var orderNum = $("#orderNum").html();
				        	if(parseInt(orderNum) > 0 && index == 1){
				        	   $("#orderNum").html(parseInt(orderNum)-1)
				        	}
				        	$.ajaxSetup ({ cache: false });
				        	var url = "${contextPath}/admin/order/lists.do?search.id="+${(result.id)!0}+"&search.searchStatus="+$("#searchStatus").val()+"&search.productType="+$("#productType").val()+"&search.startDate="+$("#startDate").val()+"&search.endDate="+$("#endDate").val()+"&pager.pageNumber="+$("#pageNumber").val()+"&pager.pageSize="+$("#pageSize").val()+"&search.name="+$("#searchName").val();
			        	    setTimeout(function(){
										  $(".content-left").load(url);
							 },500);
			        	         if(productTypes == 1){
			                            if(deliveryMode == 0 && (roleGroupId ==1 || roleGroupId == 2)){
			                                	$(obj).addClass("send-btn confirm-save");
									        	$(obj).removeAttr("onclick");
									        	$(obj).html("发  货");
									        	$(obj).hide();//前台领取 默认发送成功
									        	$(obj).prev().hide();
									        	$(obj).parent().parent().parent().children().find(".orderType").html("前台已领");
			                            }else if(deliveryMode == 1 &&  (roleGroupId ==1 || roleGroupId == 3)){
			                                    $(obj).addClass("send-btn confirm-save");
									        	$(obj).removeAttr("onclick");
									        	$(obj).html("发  货");
									        	$(obj).parent().parent().parent().children().find(".orderType").html("待发货");
			                            }else{
			                                    $(obj).hide();
			                            }
			                        }else{
			                             if(deliveryMode == 0){
			                                   $(obj).hide();//前台领取 默认发送成功
			                                   $(obj).prev().hide();
			                                   $(obj).parent().parent().parent().children().find(".orderType").html("前台已领");
			                             }else{
			                                    $(obj).addClass("send-btn confirm-save");
									        	$(obj).removeAttr("onclick");
									        	$(obj).html("发  货");
									        	$(obj).parent().parent().parent().children().find(".orderType").html("待发货");
			                             }
			                        }
			                        $(".cancel-order-btn").hide();
							        $(".send-btn").hide();
                        
			        	}else{
			        		tip_show(data.status, data.info);
			        		setTimeout(function(){
										tip_hide_w();
								  },1000);
			        		return false;
			        	} 
			        }    
			     }); 
		    }
	}
</script>
<div class="titleH2 font14">${action.getText("order.detail")}</div>
                <div class="OrderTable">
                    <div class="orderD">
                		<ul class="order_li">
                			<li><span class="ellipsis"  title="${(result.orderSn)!}">${action.getText("order.number")}：${(result.orderSn)!}</span></li>
                			<li><span class="ellipsis">${action.getText("order.leibie")}：<#if result?exists && result.productShelves.productTypes != null>${(result.productShelves.productTypes.desc)!}</#if>${action.getText("order.label")}</span></li>
                			<li><span class="ellipsis">${action.getText("order.type")}：<span class="redColor fontBold orderType"><#if (result.deliveryMode)??&&result.deliveryMode.value == 0><#if (result.status)??&&result.status.value == 2>前台已领<#else>${(result.status.desc)!}</#if><#else>${(result.status.desc)!}</#if></span></span></li>
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
                                <td><span class="empty15">${(result.productName)!}</span></td>
                                <td><span class="empty15">
                                <#if result??&&result.orderItems??&&result.orderItems!=null>
                                   <#list result.orderItems as orderItem>
                                          <#if orderItem.specificationValue??&&orderItem.specificationValue!=null>${(orderItem.specificationValue)!"无"}<#else>${(orderItem.productConfig.specValue)!"无"}</#if>，<#if orderItem.specificationValue??&&orderItem.specificationValue!=null>${(orderItem.propertyValue)!"无"}<#else>${(orderItem.productConfig.propertyValue)!"无"}</#if>(${(orderItem.productQuantity)!"0"})</br>
                                   </#list>
                                </#if>
                                </span>
                               </td>
                                <td><span class="empty15"><#if result??&&result!=null>${(result.hotel.name)!}<br>
                                   ${action.getText("order.contactName")}：${(result.hotel.contactName)!}<br>
                                   ${(result.hotel.phone)!}</#if>
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
                    	<!--${action.getText("order.shipAddress")}：--><#if result??&&result.deliveryMode??&&result.deliveryMode!=null&&result.deliveryMode.value==0><#if result.orderShip != null><br />${(result.orderShip.deliverySn)!}</#if><#else>${(result.shipArea)!}${(result.shipAddress)!}<br></#if>${(result.shipName)!}<br />${(result.shipPhone)!}
                    </div>
                    <p class="receipt_way_title"><b>支付方式</b><br><span class="order_logistics"><#if result != null && result.paymentType != null && result.paymentType.value != 1>在线<#else>线下</#if></span></p>
                    <#if result??&& result.orderShip != null>
                    <p class="receipt_way_title"><b>物流信息</b><br><span class="order_logistics">${(result.orderShip.deliverySn)!""}(${(result.orderShip.deliveryCorpName)!""})</span></p>
                    </#if>
                    <p class="receipt_way_title">
                    	<b>发票信息</b>
                    	<br>
                    	<span class="order_logistics">
                    	<#if result!=null&&(result.invoiceTopType)??><#if result.invoiceTopType.value==2>${(result.invoiceTopName)!}<#else>${(result.invoiceTopType.desc)!}</#if><#else>无</#if>
                    	</span>
                	</p>
                    <div class="order-status-btn" <#if result!=null&&result.productShelves!=null&&result.productShelves.productTypes!=null&& result.productShelves.productTypes.value == 0><#elseif admin != null && admin.roleGroupId ==2></#if>>
	                        <span class="can-send-btn"> 
	                          <#if result??&& result.status.value==1>
	                                 <#if result.productShelves.productTypes.value==1>
	                                    <#if result.deliveryMode.value == 0 && admin != null && (admin.roleGroupId ==1 || admin.roleGroupId == 3)>
	                                        <#if admin.roleGroupId ==1 && admin.hotelId != 0>
	                                        <#else>
		                                    <a class="send-btn confirm-save">发  货</a>
		                                    </#if>
		                                <#elseif result.deliveryMode.value == 1 && admin != null && (admin.roleGroupId ==1 || admin.roleGroupId == 3)>  
		                                    <#if admin.roleGroupId ==1 && admin.hotelId != 0>
	                                        <#else>
		                                    <a class="send-btn confirm-save">发  货</a>
		                                    </#if>
		                                </#if>
	                                 <#else>  
	                                 </#if>
	                            </#if>
	                            <#if result??&& result.status.value==0 && result.paymentType.value == 1 && admin != null && admin.roleGroupId != 3><a class="confirm-delivery" name="${(result.id)!}" onclick="orderPay(this,0,'${result.productShelves.productTypes.value}','${result.deliveryMode.value}','${admin.roleGroupId}')">已支付</a></#if>
	                            <#if result??&& result.status.value==4><a class="confirm-save" name="${(result.id)!}" onclick="acceptApplicate(this)">接受退货</a><a class="cancel-btn" name="${(result.id)!}" onclick="cancelApplicate(this)">取消申请</a></#if>
	                            <#if result??&& (result.status.value==0 || result.status.value==1)>
	                               <#if result.status.value==1 && admin != null && admin.roleGroupId ==1 && admin.hotelId != 0>
	                               <#elseif result.status.value==1 && admin != null && admin.roleGroupId ==1 && admin.hotelId == 0>
	                                <a class="cancel-order-btn cancel-btn" name="${(result.id)!}" onclick="cancelOrder(this,0)">取消订单</a>
	                               <#elseif result.status.value==1 && admin != null && admin.roleGroupId ==2>
	                               <#elseif result.status.value==0>
	                                <a class="cancel-order-btn cancel-btn" name="${(result.id)!}" onclick="cancelOrder(this,0)">取消订单</a>
	                               </#if>
	                            </#if>
	                            </span>
                    </div>
                    <div class="clear"></div>
                    <div class="delivery">
                        <select style="width:100px">
                            <#list deliveryCompanys as deliveryCompany>
                               <#if result??&&result.deliveryMode.value == 0>
                                       <#if deliveryCompany_index==0>
                                         <option value="${(deliveryCompany.value)!""}">${(deliveryCompany.desc)!""}</option>
                                       </#if>
                               <#elseif result??&&result.deliveryMode.value == 1>     
                              		   <#if deliveryCompany_index gt 0>
                                         <option value="${(deliveryCompany.value)!""}">${(deliveryCompany.desc)!""}</option>
                                       </#if>     
                               </#if>
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
   <div class="unprocessed-orders-block">
              
   </div>
