<script type="text/javascript">
   var path = '${contextPath}';
   $(function(){
      	first();
      	/*try{clearTimeout(t);}
		catch(e)
		{
		}*/
      	var isAudit ="${(result.isAudit)!}";
      	if(isAudit != null){
	      	var status =  "${(result.isAudit.value)!}";
	    	if(status != null && status == 2){
			  $(".not_approved").show(500)
			  //t=setTimeout(function(){$(".not_approved").hide(500)}, 3000);
			}
      	}
      	
   	window.setTimeout("chushihua()", 500 );
   	
	
      	$(".n_calculators input, #n_calculatorsValue").show();
      	$(".n_calculators input").bind("keyup", function(){
			var _val1 = $.trim($("#n_list_price").val());
			var _val3 = $.trim($("#n_hotel_price").val());
			var _val2 = $.trim($("#n_system_price").val());
			if(_val1 == null || _val1 == "" || _val1 == "原价" ||  typeof(_val1) == "undefined"){_val1 =0;}
			if(_val2 == "" || _val2 == null || _val2 == "平台佣金" ||  typeof(_val2) == "undefined" ){_val2 =0;}
			if(_val3 == null || _val3 == "" || _val3 == "酒店佣金" ||  typeof(_val3) == "undefined"){_val3 =0;}
			var _val4 = parseFloat(_val1)+parseFloat(_val2)+parseFloat(_val3);
			if( _val1 == 0 && _val2 == 0 && _val3 == 0){
				$("#n_calculatorsValue").html("售价："+ 0 +"元" );
				return;
			}
			$("#n_calculatorsValue").html("售价："+ _val4 +"元" );
			
			$("#sysdefSysCommRateyuan").html(_val2+"元" );
			$("#sysdefHotelCommRateyuan").html(_val3+"元" );
			
			var _val5 = ((_val2) / _val1 ) * 100;
			var _valAfter = _val5.toFixed(10);
			var _val6 = ((_val3) / _val1 ) * 100;
			var _valAfter2 = _val6.toFixed(10);
			$("#sysdefSysCommRate").html(_valAfter +"%" );
			$("#sysdefHotelCommRate").html(_valAfter2 +"%" );
			$("#sysdefSysCommRateval").val(_valAfter);
			$("#sysdefHotelCommRateval").val(_valAfter2);
		})
	});
 
   function chushihua(){
	    var _val11 = $("#n_list_price").val();
		var _val31 = $("#n_hotel_price").val();
		var _val21 = $("#n_system_price").val();
		if(_val11 == null || _val11 == "" || _val11 == "原价"){_val11 =0;}
		if(_val21 == null || _val21 == "" || _val21 == "平台佣金"){_val21 =0;}
		if(_val31 == null || _val31 == "" || _val31 == "酒店佣金"){_val31 =0;}
		var all_list_price = parseFloat(_val11) + parseFloat(_val21) + parseFloat(_val31);
		$("#n_calculatorsValue").html("售价："+ all_list_price.toFixed(2) +"元" );
	}

 //审核通过或者不通过
 function save(type){
       var preId = "${(preId)!0}";
	   var auditReason = $("#layer_textarea").val();
	   if(type == 2 && auditReason ==""){
	       alert("请输入未通过原因");
	       return;
	   }else{
	      var alertStr = "";
	      if(type == 2){
	        alertStr = "拒绝该商品审核?";
	      }else{
	        alertStr = "确定该商品审核通过?";
	      }
	      if(window.confirm(alertStr)){
              var formParam={
		         "search.id":$("#formId").val(),
		         "search.searchStatus":type,
		         "search.auditReason":auditReason
		       };
		       	$.ajax({    
		                  type:'POST',        
		                  url:'${contextPath}/admin/product/auditSave.do',    
		                  data:formParam,    
		                  cache:false,    
		                  dataType:'json',
		                  type:'post',    
		                  success:function(data){ 
		                  	 //window.location.reload();
					            if(data.status=="y"){
					        		 tip_show(data.status, data.info);
					        		 if(preId != 0){ 
					      	 				$("#fisrtId").val(preId);
					      			 }else{
					      	 				$("#fisrtId").val('');
					      	 		 }
					      	 		 //重新加载列表
				      	 			 list();
					        	}else if(data.status=="n"){
					        		tip_show(data.status, data.info);
					        		return false;
					        	}else{
					        		tip_show('n', '审核失败');
									return false;
					        	}
		                  }    
		            });
	      }
	   }
 }
 
   function checkPlatPrice(obj){
      //$(obj).val($(obj).val().replace(/[^0-9.]+/,''));
      if(parseInt($(obj).val().replace(/[^0-9.]+/,''))>10000 || parseInt($(obj).val().replace(/[^0-9.]+/,''))<0){
        $(obj).val(0);
      }
   }
   function editDefSysCommRate(obj){
        $(obj).prev().show();
        $(obj).prev().prev().hide();
        $(obj).hide();
        $(obj).next().show();
   }
   
   function saveDefSysCommRate(obj,id){
         if(confirm("确定要修改该商品的平台佣金比例吗？")){    
              $(obj).prev().show();
		      $(obj).prev().prev().hide();
		      $(obj).hide();
		      $(obj).prev().prev().prev().html($(obj).prev().prev().val()+" %").show();
						      
              var obj = {
                    "form.id":id,
                    "form.defSysCommRate":$(obj).prev().prev().val()
              };
              $.ajax({
    			url : '${contextPath}/admin/product/saveDefSysCommRate.do',
    			type : 'POST',
    			async : false,
    			dataType : "json",
    			async : false,
    			data : obj,
    			success : function(data) {
    				   if(data.status == "y"){
						      tip_show('w', "修改成功");
    				          setTimeout(function(){
							 		tip_hide_w(); 
							  },1000);
							 //location.reload();
						 	var url = "${contextPath}/admin/product/auditDetail.do?id="+id;
	        				loadRightPage(url);
    				   }else{
    				      alert("修改失败");
    				   }
    				}
        	    });
    	  }else{
    	     
    	  }  
   }
   
   function saveHotelCommRate(obj,id,type,sphotelConfId){
         if(confirm("确定要修改该商品的酒店佣金比例吗？")){    
              $(obj).prev().show();
		      $(obj).prev().prev().hide();
		      $(obj).hide();
		      $(obj).prev().prev().prev().html($(obj).prev().prev().val()+" %").show();
						      
              var obj = {
                    "form.id":id,
                    "form.defHotelCommRate":$(obj).prev().prev().val()
              };
              $.ajax({
    			url : '${contextPath}/admin/product/saveHotelCommRate.do',
    			type : 'POST',
    			async : false,
    			dataType : "json",
    			async : false,
    			data : obj,
    			success : function(data) {
    				   if(data.status == "y"){
						      tip_show('w', "修改成功");
    				          setTimeout(function(){
									tip_hide_w(); 
							  },1000);
							 var url = "${contextPath}/admin/product/auditDetail.do?id="+id;
	        				 loadRightPage(url);
    				   }else{
    				      alert("修改失败");
    				   }
    				}
        	    });
    	  }else{
    	     
    	  }  
   }
   
  function saveHotelSysCommRate(obj,id){
	    var _val1 = $("#n_list_price").val();
		var _val3 = $("#n_hotel_price").val();
		var _val2 = $("#n_system_price").val();
		if(_val1 == null || _val1 == "" || _val1 == "原价"){_val1 =0 ;}
		if(_val2 == null || _val2 == "" || _val2 == "平台佣金"){_val2 =0 ;}
		if(_val3 == null || _val3 == "" || _val3 == "酒店佣金"){_val3 =0 ;}
		var _val5 = ((_val2) / _val1 ) * 100;
		var _valAfter = _val5.toFixed(10);
		var _val6 = ((_val3) / _val1 ) * 100;
		var _valAfter2 = _val6.toFixed(10);
			
			
        if(confirm("确定要修改该商品的佣金比例吗？")){    
              var obj = {
                    "form.id":id,
                    "form.defSysCommRate":_valAfter,
                    "form.defHotelCommRate":_valAfter2
              };
              $.ajax({
    			url : '${contextPath}/admin/product/saveHotelSysCommRate.do',
    			type : 'POST',
    			async : false,
    			dataType : "json",
    			async : false,
    			data : obj,
    			success : function(data) {
    				   if(data.status == "y"){
						      tip_show('w', "修改成功");
    				          setTimeout(function(){
									tip_hide_w(); 
							  },1000);
							 var url = "${contextPath}/admin/product/auditDetail.do?id="+id;
	        				 loadRightPage(url);
    				   }else{
    				      alert("修改失败");
    				   }
    				}
        	    });
        }
  }
  
</script>
<style type="text/css">
.new429_tap li{ float:left; padding-right:15px;}
.new429_tap li.selectTag{ color:#000; font-size:18px;}
.tagContent{display:none;}
.selectTag{display:block;}
.fixed-width{ width:126px; text-align:right;}
</style>
<div class="content_in_cont">
<div class="titleH2 font14" id="tab">
	<span class="leftText">
		<ul id="tabwarp" class="new429_tap">
		  <#if newresult == null>
		    <li>${action.getText("product.label")}${action.getText("label.detail")}</li>
		  <#else>
		    <li class="selectTag"><a onclick="selectTag(0)">新数据${action.getText("product.label")}${action.getText("label.detail")}</a></li>
	        <li><a onclick="selectTag(1)">老数据</a></li>
		  </#if>
	    </ul>
    </span>
    <span class="rightText">
    	<div class="order-status-btn order-status-btn_top" <#if result != null && result.isAudit != null && result.isAudit.value == 0><#else>style="display:none;"</#if>>
	        <span class="can-send-btn">
	        	<a class="confirm-save" onclick="save(1)">通过审核</a>
	            <a class="cancel-btn" onClick="out_notBy()">不通过</a>
	        </span>
	        <div class="clear"></div>
	    </div>
    </span>
</div>
<div id="tagContent0" class="tagContent selectTag">
    <div class="tip_save_success"><img src="${contextPath}/css/images/tip_save_success.png" width="46" height="60"><span class="tip_font_save"><span class="font16"><b>保存成功!</b></span><cite>请耐心等待审核</cite></span></div>
    <div class="not_approved">
        <p class="tip_approved"><img src="${contextPath}/css/images/not_approved.png" width="35" height="36"><b class="font16">未通过审核</b></p>
        <p class="why_approved"><cite>原因：</cite><cite class="detail_w_f">${(result.auditReason)!}</cite><div class="clear"></div></p>
    </div>
	  <div class="OrderTable">
				    <form id="saveForm" method="post" action="${contextPath}/admin/product/<#if isAddAction>save<#else><#if result??>update<#else>save</#if></#if>.do" enctype="multipart/form-data">
				    <input type="hidden" name="form.id" id="formId" value="${(result.id)!}" />
				    <input type="hidden" name="form.productSn" value="${(result.productSn)!}" />
				    <input type="hidden" id="formOldName" value="${(result.name)!}" />
					<input type="hidden" id="formNameSpanError" value="0" />
                	<div class="products-vesting">
                    	<ul>
                        	<li><label class="fixed-width">${action.getText("product.name")}</label><span>${(result.name)!}</span><span id="resultNameSpan" class="resultNameSpan Validform_checktip"></span></li>
                            <li><label class="fixed-width">${action.getText("product.productTypeName")}</label><span>${(result.productTypes.desc)!}商品</span></li>
	                        <li>
	                        	<label class="fixed-width">${action.getText("product.deliveryModes")}</label>
	                        	<span>
	                            	<ul class="checkboxChange">
	                            	 <#list deliveryTypes as deliveryType>
	                            	 	 <#assign flag=false/>
	                            	 	 <#if result??&&result?exists&&(result.deliveryMode)??&&(result.deliveryMode)?exists>
	                            	 	 	<#list result.deliveryMode as d>
	                            	 	 	<#if d.value==deliveryType.value>
	                            	 	 	<#assign flag=true/>
	                            	 	 	<#break/>
	                            	 	 	</#if>
	                            	 	 	</#list>
	                                     </#if>
	                                     <li style="display:none;">
	                                     	<input type="checkbox" title="${(deliveryType.value)!""}" <#if flag>checked="checked" </#if>class="checkbox" />
	                                     	${(deliveryType.desc)!""}</li>
	                                     <li><#if flag>${(deliveryType.desc)!""}</#if></li>
	                                 </#list>
	                                </ul>
                                	<input type="hidden" name="form.deliveryModes" id="deliveryModesStr" />
                                </span>
                            </li>
                            <li class="lineHeight34"><label class="fixed-width">默认销量</label>
                        		<span>${(result.defSalesCount)!}</span>
                        	</li>
                            <#if result!=null &&  result.productType != null && result.productType == 1>
	                        <li><label class="fixed-width">发布方</label><span>${(result.supplierInfo.name)!""}</span></li>
	                        </#if>
	                        <#if result!=null &&  result.productType != null && result.productType == 0 && result.hotelName != "">
	                        <li><label class="fixed-width">所属酒店</label><span>${(result.hotelName)!""}</span></li>
	                        </#if>
                            <li>
                            	<label class="fixed-width">平台佣金</label><#if result!=null && result.productPriceFirst != null>
                            	<span id="sysdefSysCommRateyuan">${(result.productPriceFirst*result.defSysCommRate/100)!"0"}元</span>
                            	<span id="sysdefSysCommRate" style="display:none;">${(result.defSysCommRate)!0}%</span>
                            	<input id="sysdefSysCommRateval" type="text" class="n_calculators_input" value="${(result.defSysCommRate)!0}"  maxlength="10" style="display:none;"/>
                            	<a href="#" onclick="editDefSysCommRate(this)" class="new_edit_font" style="display:none;">编辑</a>
                            	<a href="#" onclick="saveDefSysCommRate(this,'${(result.id)!}')" style="display:none; padding-left:5px;">保存</a>
                            	<!--<span class="n_calculators">进价：${(result.productPriceFirst)!0}
                            	<input type="hidden" style="display:none;" placeholder="原价" readonly="readonly" value="${(result.productPriceFirst)!0}" class="n_calculators_input" id="n_list_price" onkeyup="this.value=this.value.replace(/[^0-9-]+/,'')" onafterpaste="this.value=this.value.replace(/[^0-9-]+/,'')"/>
                            	&nbsp;&nbsp;平台：<input type="text" placeholder="平台佣金" value="<#if result.defSysCommRate !=null && result.productPriceFirst != null>${(result.productPriceFirst*result.defSysCommRate/100)!"0"}
                            	<#else>0</#if>" class="n_calculators_input" id="n_system_price" />
                            	酒店：<input type="text" placeholder="酒店佣金" <#if result!=null &&  result.productType != null && result.productType == 0>readonly="readonly"</#if> value="<#if result.defHotelCommRate != null>${(result.productPriceFirst*result.defHotelCommRate/100)!0}
                            	<#else>0</#if>" class="n_calculators_input" id="n_hotel_price"/>
                            	<span id="n_calculatorsValue">
                            	<#if result!=null &&  result.productType != null && result.productType == 0>
                            	${(result.productPriceFirst+result.productPriceFirst*result.defSysCommRate/100)!0}
                            	<#else>
                            	${(result.productPriceFirst+result.productPriceFirst*result.defSysCommRate/100+result.productPriceFirst*result.defHotelCommRate/100)!0}
                            	</#if>元</span>
                            	</span>
                            	<a href="#" onclick="saveHotelSysCommRate(this,'${(result.id)!}')" class="new_edit_font">保存</a>-->
                            	
                            	
                            	
                            	<div class="ratioCalculation">
		                         	<span class="n_calculators" style="width:519px">
		                         		<i class="n_calculators_title" style="display:none;">计算器</i>
		                         		<table cellspacing="0" cellpadding="0" width="519">
		                         			<tr>
		                         				<td width="36%">
		                         				进价：${(result.productPriceFirst)!0}
		                         		        <input type="hidden" style="display:none;" placeholder="原价" readonly="readonly" value="${(result.productPriceFirst)!0}" class="n_calculators_input" id="n_list_price" onkeyup="this.value=this.value.replace(/[^0-9-]+/,'')" onafterpaste="this.value=this.value.replace(/[^0-9-]+/,'')"/>
		                         				</td>
		                         				<td width="37%">
		                         				<cite id="n_calculatorsValue">
				                            	<#if result!=null &&  result.productType != null && result.productType == 0>
				                            	${(result.productPriceFirst+result.productPriceFirst*result.defSysCommRate/100)!0}
				                            	<#else>
				                            	${(result.productPriceFirst+result.productPriceFirst*result.defSysCommRate/100+result.productPriceFirst*result.defHotelCommRate/100)!0}
				                            	</#if>元
				                            	</cite>
		                         				</td>
		                         				<td width="27%">
		                         				</td>
		                         			</tr>
		                         			<tr>
		                         				<td>
		                         					平台：<input type="text" placeholder="平台佣金" value="<#if result.defSysCommRate !=null && result.productPriceFirst != null>${(result.productPriceFirst*result.defSysCommRate/100)!"0"}<#else>0</#if>" class="n_calculators_input" id="n_system_price" />
                        						</td>
		                         				<td>
		                         					酒店：
		                         					<input type="text" placeholder="酒店佣金" <#if result!=null &&  result.productType != null && result.productType == 0>readonly="readonly"</#if> value="<#if result.defHotelCommRate != null>${(result.productPriceFirst*result.defHotelCommRate/100)!0}<#else>0</#if>" class="n_calculators_input" id="n_hotel_price"/>
	                         					</td>
		                         				<td>
		                         					<a href="#" onclick="saveHotelSysCommRate(this,'${(result.id)!}')" class="new_edit_font">保存</a>
		                         				</td>
		                         			</tr>
		                         		</table>
		                         	</span>
		                            </div>
                            	
                            	
                            	
                            	</#if></li>
                            <#if result!=null &&  result.productType != null && result.productType == 1 && result.productPriceFirst != null>
                                 <li><label class="fixed-width">酒店佣金</label><span id="sysdefHotelCommRateyuan">${(result.productPriceFirst*result.defHotelCommRate/100)!"0"}元</span><span id="sysdefHotelCommRate" style="display:none;">${(result.defHotelCommRate)!0}%</span><input id="sysdefHotelCommRateval" type="text" class="n_calculators_input" value="${(result.defHotelCommRate)!0}"  maxlength="10" onkeyup="checkPlatPrice(this)" onafterpaste="this.value=this.value.replace(/[^0-9.]+/,'')" style="display:none;"/><a href="#" onclick="editDefSysCommRate(this)" class="new_edit_font" style="display:none;">编辑</a><a href="#" onclick="saveHotelCommRate(this,'${(result.id)!}')" style="display:none; padding-left:5px;">保存</a></li>
                            </#if>
                            <#if result != null && result.imageUrl !=null>
                            <li id="imageSrcDiv" class="updateImgWeb">
                             	<label class="fixed-width">默认图片</label><span class="reviewPic"><img id="imageSrc" width="100%" height="100%"  src="${imagePath}${(result.imageUrl)!}"></span>
                            </li>
                            <#else> 
                            <li id="imageSrcDiv" class="updateImgWeb" style="display:none;">
                             	<label class="fixed-width">默认图片</label><span class="reviewPic"><img id="imageSrc" width="100%" height="100%"></span>
                            </li>
                            </#if>
                        </ul>
                    </div>
                    <div class="OrderBottom">
                        <table width="760" class="blockTableBottom specMameTable" cellpadding="0" cellspacing="0">
                            <tr>
                            	<th width="95"></th>
								<th width="290">
									<span class="empty15"><span>${(result.specName)!'商品规格'}</span><input id="specName" name="form.specName" value="${(result.specName)!'商品规格'}" onblur="recodeSpecName(this)" maxlength="20" style="display:none;"/></span>
								</th>
								<th width="217">
								<span class="empty15"><a onclick="editSpec(this)"> </a></span>
								</th>
                            </tr>
                            <#if result??&&result.productSpec?exists && result.productSpec??>
                                <#list result.productSpec as productSpec>
                                 <tr>
	                                <td width="95" class="Nunb"><span class="empty15">${(productSpec_index+1)!}</span></td>
	                                <td><span class="empty15"><span class="text-put-here" onclick="editProductProperty(this)" name="${(productSpec.id)!}">${(productSpec.value)!}</span><span style="display:none;"><input type="text" onblur="saveProductProperty(this)" maxlength="20"/></span></span></td>
                                  <td width="217"><span class="empty15"></span></td>
                                  </tr>
                               </#list>
                            </#if>
                        </table>
                        <table width="760" class="blockTableBottom proMameTable" cellpadding="0" cellspacing="0">
                            <tr>
                            	<th width="95"></th>
								<th width="290">
									<span class="empty15"><span>${(result.proMame)!'其他属性'}</span><input id="PropertyName" name="form.proMame" value="${(result.proMame)!'其他属性'}" onblur="recodeProName(this)" maxlength="20" style="display:none;"/></span>
								</th>
								<th width="217">
								<span class="empty15"><a onclick="editProperty(this)"></a></span>
								</th>
                            </tr>
                            <#if result??&&result.productProperty?exists && result.productProperty??>
                                <#list result.productProperty as productProperty>
                                 <tr>
	                                <td width="95" class="Nunb"><span class="empty15">${(productProperty_index+1)!}</span></td>
	                                <td><span class="empty15"><span class="text-put-here" onclick="editProductProperty(this)" name="${(productProperty.id)!}">${(productProperty.value)!}</span><span style="display:none;"><input type="text" onblur="saveProductProperty(this)" maxlength="20"/></span></span></td>
                                  	<td width="217"><span class="empty15"></span></td>
                                  </tr>
                               </#list>
                            </#if>
                        </table>
                        <table width="100%" class="blockTableBottom outTable" cellpadding="0" cellspacing="0">
                            <tr>
                                <th width="95"><span class="empty15">${action.getText("product.guige")}</span></th>
                                <th width="655">
                                	<table width="100%"  class="no_border left_border">
                                		<tr>
                                			<th width="132"><span class="empty15">${action.getText("product.shuxing")}</span></th>
                                			<th width="105"><span class="empty15">${action.getText("product.shichangjiage")}</span></th>
			                                <th width="130"><span class="empty15">进价(售价)</span></th>
			                                <th width="130" style="display:none;"><span class="empty15">${action.getText("product.kucun")}</span></th>
			                                <th width="158"><span class="empty15">商品图片</span></th>
                                		</tr>
                                	</table>
                                </th>
                                
                            </tr>
                            <#if result??&&result.productSpec?exists && result.productSpec??>
                                 <#list result.productSpec as productSpec>
                                  <tr>
                                <td class="productSpecNameShow"><span class="empty15">${(productSpec.value)!}</span></td>
                                <td width="655"> 
	                                <table  cellspacing="0" cellpadding="0" class="innerTable no_border left_border" width="100%">
                                     <#if productSpec.productConfigInfo?exists && productSpec.productConfigInfo??>
	                                     <#list productSpec.productConfigInfo as productConfigInfo>
	                                       <tr>
							                <td width="132" class="ppropertyValue" name="${(productConfigInfo.id)!}" onclick="showProduvtImg('${imagePath}${(productConfigInfo.imageUrl)!}')"><span class="empty15">${(productConfigInfo.propertyValue)!}</span></td>
										    <td width="105"><span class="empty15">${(productConfigInfo.marketPrice)!0}</span></td>
										    <td width="130"><span class="empty15">${(productConfigInfo.productPrice)!0}(${(productConfigInfo.psalePrice)!0})</span></td> 
										    <td width="130"  style="display:none;"><span class="empty15">${(productConfigInfo.totalStock-productConfigInfo.lockedStock)!0}</span></td> 
										    <td width="158"><span class="empty15"><img <#if productConfigInfo != null && productConfigInfo.imageUrl != null>src="${imagePath}${(productConfigInfo.imageUrl)!}" <#else> src="${contextPath}/css/images/no_pic.png"</#if> width="143" height="92"></span></td>
						                   </tr>
		                                </#list>
	                                </#if>
	                                  </table>
                                </td>
                            </tr>
                                 </#list>
                            </#if>
                            
                        </table>
                        <input type="hidden" name="specNames" id="specNames" />
                        <input type="hidden" name="proNames" id="proNames" />
                        <input type="hidden" name="proIds" id="proIds" />
                        <input type="hidden" name="proValues" id="proValues" />
                        <input type="hidden" name="marketPrices" id="marketPrices" />
                        <input type="hidden" name="productPrices" id="productPrices" />
                        <input type="hidden" name="totalStocks" id="totalStocks" />
                        <input type="hidden" name="addStocks" id="addStocks" />
                        <input type="hidden" name="imgUrlsm" id="imgUrlsm" />
                        
                        <input type="hidden" name="specIds" id="specIds" />
                        <input type="hidden" name="proNameIds" id="proNameIds" />
                        <ul style="display:none;">
                        <li><label class="fixed-width">商品url</label><span><input type="text" id="formContent" name="form.content" readonly="readonly" value="${(result.content)!}" style="width:500px;"maxlength="50"/></span><span class="formContentSpan Validform_checktip"></span></li>
                        </ul>
                        <div class="textEditArea blockTableBottom25">
                            <div class="pro_title_top">
                        		<div class="tabCont" id="tab_n">
							        <ul id="tabwarp_n">
							            <li class="selectTag" onclick="selectTag_n(0)"><b>商品介绍</b></li>
							            <li onclick="selectTag_n(1)"><b>体验后</b></li>
							        </ul>
							    </div>
							    <div class="content-table contenter_summary blockActiveList">
							        <div id="tagContent00" class="tagContent selectTag">
			                             	${(result.detail)!}
							        </div>
							        <div id="tagContent01" class="tagContent">
			                             	${(result.experienceAfter)!}
							        </div>
							    </div>
	                        	<div class="clear"></div>
                        	</div>
                        </div>
                        </form>
                    </div>
                    <div class="clear"></div>
                </div>
</div><!-- id1 -->
<div id="tagContent1" class="tagContent">
      <div class="order-status-btn order-status-btn_top btn_hasPassed"<#if result != null && result.isAudit != null && result.isAudit.value == 0><#else>style="display:none;"</#if>>
	        <span class="can-send-btn">
	        	<a class="confirm-save" onclick="save(1)">通过审核</a>
	            <a class="cancel-btn" onClick="out_notBy()">不通过</a>
	        </span>
	        <div class="clear"></div>
	    </div>
      
	  <div class="OrderTable">
                	<div class="products-vesting">
                    	<ul>
                        	<li><label class="fixed-width">${action.getText("product.name")}</label><span>${(newresult.name)!}</span></li>
                            <li><label class="fixed-width">${action.getText("product.productTypeName")}</label><span>${(newresult.productTypes.desc)!}商品</span></li>
	                        <li><label class="fixed-width">${action.getText("product.deliveryModes")}</label><span>
                            	<ul class="checkboxChange">
                            	 <#list deliveryTypes as deliveryType>
                            	 	 <#assign flag=false/>
                            	 	 <#if newresult??&&newresult?exists&&(newresult.deliveryMode)??&&(newresult.deliveryMode)?exists>
                            	 	 	<#list newresult.deliveryMode as d><#if d.value==deliveryType.value><#assign flag=true/><#break/></#if></#list>
                                     </#if>
                                     <li style="display:none;"><input type="checkbox" title="${(deliveryType.value)!""}" <#if flag>checked="checked" </#if>class="checkbox" />${(deliveryType.desc)!""}</li>
                                     <li><#if flag>${(deliveryType.desc)!""}</#if></li>
                                 </#list>
                                </ul>
                                <input type="hidden" name="form.deliveryModes" id="deliveryModesStr" />
                                </span>
                            </li>
                            <li class="lineHeight34"><label class="fixed-width">默认销量</label>
                        		<span>${(newresult.defSalesCount)!}</span>
                        	</li>
	                        <#if newresult!=null &&  newresult.productType != null && newresult.productType == 1>
	                        <li><label class="fixed-width">发布方</label><span>${(newresult.supplierInfo.name)!""}</span></li>
	                        </#if>
	                        <#if newresult!=null &&  newresult.productType != null && newresult.productType == 0 && newresult.hotelName != "">
	                        <li><label class="fixed-width">所属酒店</label><span>${(newresult.hotelName)!""}</span></li>
	                        </#if>
                            <li><label class="fixed-width">平台佣金</label><span>${(newresult.productPriceFirst*newresult.defSysCommRate/100)!"0"}元</span></li>
                             <#if newresult!=null &&  newresult.productType != null && newresult.productType == 1>
                                 <li><label class="fixed-width">酒店佣金</label><span>${(newresult.productPriceFirst*newresult.defHotelCommRate/100)!"0"}元</span></li>
                            </#if>
                            <#if newresult != null && newresult.imageUrl !=null>
                            <li  class="updateImgWeb">
                             	<label class="fixed-width">默认图片</label><span class="reviewPic"><img  width="100%" height="100%"  src="${imagePath}${(newresult.imageUrl)!}"></span>
                            </li>
                            <#else> 
                            <li  class="updateImgWeb" style="display:none;">
                             	<label class="fixed-width">默认图片</label><span class="reviewPic"><img  width="100%" height="100%"></span>
                            </li>
                            </#if>
                        </ul>
                    </div>
                    <div class="OrderBottom">
                        <table width="760" class="blockTableBottom specMameTable" cellpadding="0" cellspacing="0">
                            <tr>
                            	<th width="95"></th>
								<th width="290">
									<span class="empty15"><span>${(newresult.specName)!'商品规格'}</span></span>
								</th>
								<th width="217">
								<span class="empty15"></span>
								</th>
                            </tr>
                            <#if newresult??&&newresult.productSpec?exists && newresult.productSpec??>
                                <#list newresult.productSpec as productSpec>
                                 <tr>
	                                <td width="95" class="Nunb"><span class="empty15">${(productSpec_index+1)!}</span></td>
	                                <td><span class="empty15"><span class="text-put-here" onclick="editProductProperty(this)" name="${(productSpec.id)!}">${(productSpec.value)!}</span></span></td>
                                  <td width="217"><span class="empty15"></span></td>
                                  </tr>
                               </#list>
                            </#if>
                        </table>
                        <table width="760" class="blockTableBottom proMameTable" cellpadding="0" cellspacing="0">
                            <tr>
                            	<th width="95"></th>
								<th width="290">
									<span class="empty15"><span>${(newresult.proMame)!'其他属性'}</span></span>
								</th>
								<th width="217">
								<span class="empty15"></a></span>
								</th>
                            </tr>
                            <#if newresult??&&newresult.productProperty?exists && newresult.productProperty??>
                                <#list newresult.productProperty as productProperty>
                                 <tr>
	                                <td width="95" class="Nunb"><span class="empty15">${(productProperty_index+1)!}</span></td>
	                                <td><span class="empty15"><span class="text-put-here" name="${(productProperty.id)!}">${(productProperty.value)!}</span></span></td>
                                  	<td width="217"><span class="empty15"></span></td>
                                  </tr>
                               </#list>
                            </#if>
                        </table>
                        <table width="100%" class="blockTableBottom outTable" cellpadding="0" cellspacing="0">
                            <tr>
                                <th width="95"><span class="empty15">${action.getText("product.guige")}</span></th>
                                <th width="655">
                                	<table width="100%"  class="no_border left_border">
                                		<tr>
                                			<th width="132"><span class="empty15">${action.getText("product.shuxing")}</span></th>
                                			<th width="105"><span class="empty15">${action.getText("product.shichangjiage")}</span></th>
			                                <th width="130"><span class="empty15">进价(售价)</span></th>
			                                <th width="130"><span class="empty15">${action.getText("product.kucun")}</span></th>
			                                <th width="158"><span class="empty15">商品图片</span></th>
                                		</tr>
                                	</table>
                                </th>
                                
                            </tr>
                            <#if newresult??&&newresult.productSpec?exists && newresult.productSpec??>
                                 <#list newresult.productSpec as productSpec>
                                  <tr>
                                <td><span class="empty15">${(productSpec.value)!}</span></td>
                                <td width="655"> 
	                                <table  cellspacing="0" cellpadding="0" class="innerTable no_border left_border" width="100%">
                                     <#if productSpec.productConfigInfo?exists && productSpec.productConfigInfo??>
	                                     <#list productSpec.productConfigInfo as productConfigInfo>
	                                       <tr>
							                <td width="132"><span class="empty15">${(productConfigInfo.propertyValue)!}</span></td>
										    <td width="105"><span class="empty15">${(productConfigInfo.marketPrice)!0}</span></td>
										    <td width="130"><span class="empty15">${(productConfigInfo.productPrice)!0}(${(productConfigInfo.psalePrice)!0})</span></td> 
										    <td width="130"><span class="empty15">${(productConfigInfo.totalStock-productConfigInfo.lockedStock)!0}</span></td> 
										    <td width="158"><span class="empty15"><img <#if productConfigInfo != null && productConfigInfo.imageUrl != null>src="${imagePath}${(productConfigInfo.imageUrl)!}" <#else> src="${contextPath}/css/images/no_pic.png"</#if> width="143" height="92"></span></td>
						                   </tr>
		                                </#list>
	                                </#if>
	                                  </table>
                                </td>
                            </tr>
                                 </#list>
                            </#if>
                            
                        </table>
                        <div class="textEditArea blockTableBottom25">
                        	<div class="pro_title_top">
                        		<div class="tabCont" id="tab_n1">
							        <ul id="tabwarp_n1">
							            <li class="selectTag" onclick="selectTag_n1(0)"><b>商品介绍</b></li>
							            <li onclick="selectTag_n1(1)"><b>体验后</b></li>
							        </ul>
							    </div>
							    <div class="content-table contenter_summary blockActiveList">
							        <div id="tagContent_n0" class="tagContent selectTag">
			                             	${(newresult.detail)!}
							        </div>
							        <div id="tagContent_n1" class="tagContent">
			                             	${(newresult.experienceAfter)!}
							        </div>
							    </div>
	                        	<div class="clear"></div>
                        	</div>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
</div><!-- id2 -->
                </div>
                <div class="n_borderBotLine"></div>
                <div class="order-status-btn order-status-btn_bot btn_hasPassed98" <#if result != null && result.isAudit != null && result.isAudit.value == 0><#else>style="display:none;"</#if>>
                    <span class="can-send-btn">
                    	<a class="confirm-save" onclick="save(1)">通过审核</a>
                        <a class="cancel-btn" onClick="out_notBy()">不通过</a>
                    </span>
                    <div class="clear"></div>
                </div> 
               
<script type="text/javascript">
	$(function(){
	    setTimeout("tt()",5000);
	    setTimeout("delayTwo()",100);
	})
	function tt(){
		$("body").css({height: "auto", "min-width": "inherit"});
	}
	function delayTwo(){
		$(".blockActiveList img, .blockActiveList  img").css({"width": "100%", "height":"auto"});
		//$(".blockActiveList img, .blockActiveList  img").attr("width", "100%");
	}
  function selectTag_n(indexs) {
		var tags = document.getElementById("tabwarp_n").getElementsByTagName("li");
		ids = "tagContent";
		ids = ids + "0" + indexs;
		var idtabs = document.getElementById(ids);
		//初始化
		for (var i = 0; i < 2; i++) {
			tags[i].className = "";
			document.getElementById("tagContent0"+(i)).style.display = "none";
		}
		//改内容
	
		tags[indexs].className = "selectTag";
		document.getElementById(ids).style.display = "block";
	}
	function selectTag_n1(indexs) {
		var tags = document.getElementById("tabwarp_n1").getElementsByTagName("li");
		ids = "tagContent";
		ids = ids + "_n" + indexs;
		var idtabs = document.getElementById(ids);
		//初始化
		for (var i = 0; i < 2; i++) {
			tags[i].className = "";
			document.getElementById("tagContent_n"+(i)).style.display = "none";
		}
		//改内容
	
		tags[indexs].className = "selectTag";
		document.getElementById(ids).style.display = "block";
	}
</script>
<style type="text/css">
/*body{ min-width: inherit; background-color:#fff;}*/
.blockActiveList{ float:left; padding-top:31px; width:92%; font-size:13px; background-color:#fff; padding:10px 4%;}
.blockActiveList li{ padding-bottom:12px;}
.blockActiveList li h3{ padding-bottom:5px; text-indent: 2em; font-size:14px; color:#000; width:100%;}
.blockActiveList li p, .blockActiveList p{ line-height:24px; font-size:14px; color:#4c4c4c; width:100%; padding-bottom:5px}
.blockActiveList img{ width:100%; height:auto; padding-top:5px;}


/*********tab tab切换********/
.tagContent{ display:none;}
.tabCont {
    position: relative;
    width:93px;
    float:left;
}
.tabCont ul {
	width:100%;
}
.selectTag {
    display: block;
}
.tabCont ul li {
    float: left;
    height: 20px;
    line-height: 20px;
    text-align: center;
    width:100%;
	cursor:pointer;
	padding-bottom:10px;
	color:#bbb;
}
#tabwarp_n a, #tabwarp_n1 a{ display:block;}
.tabCont ul li.selectTag {
    font-size: 14px;
    text-align: center;
	height:20px;
	color:#555;
	color:#000;

}
.tabCont ul li a{ display:block; height:20px; color:#bbb;}
.tabCont ul li:last-child a{ border-right:none;}
.tabCont ul li.selectTag a{ color:#000;}
.selectTag {
    display: block;
}
</style>