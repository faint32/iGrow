<script type="text/javascript">
   var path = '${contextPath}';
   $(function(){
      	first();
      	$(".n_calculators_title").click(function(){
      		$(".n_calculators input, #n_calculatorsValue").show();
      	});
      	$(".n_calculators input").bind("keyup", function(){
			var _val1 = $("#n_list_price").val();
			var _val2 = $("#n_sell_price").val();
			var _val3 = ((_val2 - _val1) / _val1 ) * 100;
			var _valAfter = _val3.toFixed(2);
			if( _val1 == 0 || _val2 == 0){
				$("#n_calculatorsValue").html( 0 );
				return;
			}
			$("#n_calculatorsValue").html( _valAfter +"%" );
		})
	});
   function checkPlatPrice(obj){
      $(obj).val($(obj).val().replace(/[^0-9.]+/,''));
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
		      $(obj).prev().prev().prev().html($(obj).prev().prev().val()+"%").show();
						      
              var obj = {
                    "form.id":id,
                    "form.defSysCommRate":$(obj).prev().prev().val()
              };
              $.ajax({
    			url : '${contextPath}/admin/productshe/saveDefSysCommRate.do',
    			type : 'POST',
    			async : false,
    			dataType : "json",
    			async : false,
    			data : obj,
    			success : function(data) {
    				   if(data.status == "y"){
						      tip_show('w', "修改成功");
    				         // setTimeout(function(){
							 	//	tip_hide_w(); 
							 // },300);
							 location.reload();
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
		      $(obj).prev().prev().prev().html($(obj).prev().prev().val()+"%").show();
						      
              var obj = {
                    "form.id":id,
                    "shelves.sphotelConfId":sphotelConfId,
                    "shelves.sphotelConfType":type,
                    "form.hotelCommRate":$(obj).prev().prev().val()
              };
              $.ajax({
    			url : '${contextPath}/admin/productshe/saveHotelCommRate.do',
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
							  },300);
    				   }else{
    				      alert("修改失败");
    				   }
    				}
        	    });
    	  }else{
    	     
    	  }  
    	  
   
   }
</script>
<div class="content_in_cont">
<div class="titleH2 font14">${action.getText("product.label")}${action.getText("label.detail")}</div>
    <div class="tip_save_success"><img src="${contextPath}/css/images/tip_save_success.png" width="46" height="60"><span class="tip_font_save"><span class="font16"><b>保存成功!</b></span><cite>请耐心等待审核</cite></span></div>
    <div class="not_approved">
        <p class="tip_approved"><img src="${contextPath}/css/images/not_approved.png" width="35" height="36"><b class="font16">未通过审核</b></p>
        <p class="why_approved"><cite>原因：</cite><cite class="detail_w_f">${(result.auditReason)!}</cite><div class="clear"></div></p>
    </div>
        <div class="order-status-btn order-status-btn_top" <#if result != null && result.isAudit != null && result.isAudit.value == 0><#else>style="display:none;"</#if>>
	        <span class="can-send-btn">
	        	<a class="confirm-save" onclick="save(1)">通过审核</a>
	            <a class="cancel-btn" onClick="out_notBy()">不通过</a>
	        </span>
	        <div class="clear"></div>
	    </div>
      
	  <div class="OrderTable">
				    <form id="saveForm" method="post" action="${contextPath}/admin/product/<#if isAddAction>save<#else><#if result??>update<#else>save</#if></#if>.do" enctype="multipart/form-data">
				    <input type="hidden" name="form.id" id="formId" value="${(result.id)!}" />
				    <input type="hidden" name="form.productSn" value="${(result.productSn)!}" />
				    <input type="hidden" id="formOldName" value="${(result.name)!}" />
					<input type="hidden" id="formNameSpanError" value="0" />
					<input type="hidden" name="shelves.orderSort" value="${(result.orderSort)!}" />
                	<div class="products-vesting">
                    	<ul>
                        	<li><label class="fixed-width">${action.getText("product.name")}</label><span>${(result.name)!}</span><span id="resultNameSpan" class="resultNameSpan Validform_checktip"></span></li>
                            <li><label class="fixed-width">${action.getText("product.productTypeName")}</label><span>${(result.productTypes.desc)!}商品</span></li>
	                        <li><label class="fixed-width">${action.getText("product.deliveryModes")}</label><span>
                            	<ul class="checkboxChange">
                            	 <#list deliveryTypes as deliveryType>
                            	 	 <#assign flag=false/>
                            	 	 <#if result??&&result?exists&&(result.deliveryMode)??&&(result.deliveryMode)?exists>
                            	 	 	<#list result.deliveryMode as d><#if d.value==deliveryType.value><#assign flag=true/><#break/></#if></#list>
                                     </#if>
                                     <li style="display:none;"><input type="checkbox" title="${(deliveryType.value)!""}" <#if flag>checked="checked" </#if>class="checkbox" />${(deliveryType.desc)!""}</li>
                                     <li><#if flag>${(deliveryType.desc)!""}</#if></li>
                                 </#list>
                                </ul>
                                </span>
                                <input type="hidden" name="form.deliveryModes" id="deliveryModesStr" />
                            </li>
	                        <#if result!=null &&  result.productType != null && result.productType == 1>
	                        <li><label class="fixed-width">发布方</label><span>${(result.productInfo.supplierInfo.name)!""}</span></li>
	                        </#if>
	                        <#if result!=null &&  result.productType != null && result.hotelName != "">
	                        <li><label class="fixed-width">所属酒店</label><span>${(result.hotelName)!""}</span></li>
	                        </#if>
                            <li><label class="fixed-width">平台佣金</label><span>${(result.productInfo.defSysCommRate)!0}%</span><input type="text" value="${(result.productInfo.defSysCommRate)!0}"  maxlength="10" onkeyup="checkPlatPrice(this)" onafterpaste="this.value=this.value.replace(/[^0-9.]+/,'')" style="display:none;"/><a href="#" onclick="editDefSysCommRate(this)" class="new_edit_font">编辑</a><a href="#" onclick="saveDefSysCommRate(this,'${(result.id)!}')" style="display:none;">保存</a><span class="n_calculators"><i class="n_calculators_title">计算器</i><input type="text" placeholder="原价" class="n_calculators_input" id="n_list_price" /><input type="text" placeholder="售价" class="n_calculators_input" id="n_sell_price" /><span id="n_calculatorsValue"></span></span></li>
                            <#if result!=null &&  result.productType != null && result.productType == 1>
                              <#if result.productInfo.hotelCommRate != null && result.sphotelConfId != 0>
                                 <li><label class="fixed-width">酒店佣金</label><span>${(result.productInfo.hotelCommRate)!0}%</span><input type="text" value="${(result.productInfo.hotelCommRate)!0}"  maxlength="10" onkeyup="checkPlatPrice(this)" onafterpaste="this.value=this.value.replace(/[^0-9.]+/,'')" style="display:none;"/><a href="#" onclick="editDefSysCommRate(this)" class="new_edit_font">编辑</a><a href="#" onclick="saveHotelCommRate(this,'${(result.id)!}',1,'${(result.sphotelConfId)!}')" style="display:none;">保存</a></li>
                              <#else>
                                 <li><label class="fixed-width">酒店佣金</label><span>${(result.productInfo.defHotelCommRate)!0}%</span><input type="text" value="${(result.productInfo.defHotelCommRate)!0}"  maxlength="10" onkeyup="checkPlatPrice(this)" onafterpaste="this.value=this.value.replace(/[^0-9.]+/,'')" style="display:none;"/><a href="#" onclick="editDefSysCommRate(this)" class="new_edit_font">编辑</a><a href="#" onclick="saveHotelCommRate(this,'${(result.id)!}',2,'${(result.sphotelConfId)!}')" style="display:none;">保存</a></li>
                              </#if>
                            </#if>
                            <li><label class="fixed-width">二维码url</label><span>http://www.1ct.cc/boraMallH5T/views/front/product/product.html?from=1&pid=${(result.productSn)!}</span></li>
                            <#if result != null && result.productInfo != null && result.productInfo.imageUrl !=null>
                            <li id="imageSrcDiv" class="updateImgWeb">
                             	<label class="fixed-width">默认图片</label><span class="reviewPic"><img id="imageSrc" width="100%" height="100%"  src="${imagePath}${(result.productInfo.imageUrl)!}"></span>
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
									<span class="empty15"><span>${(result.productInfo.specName)!'商品规格'}</span><input id="specName" name="form.specName" value="${(result.productInfo.specName)!'商品规格'}" maxlength="20" style="display:none;"/></span>
								</th>
								<th width="217">
								<span class="empty15"><a onclick="editSpec(this)"> </a></span>
								</th>
                            </tr>
                            <#if result??&&result.productInfo!=null&&result.productInfo.productSpec?exists && result.productInfo.productSpec??>
                                <#list result.productInfo.productSpec as productSpec>
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
									<span class="empty15"><span>${(result.productInfo.proMame)!'其他属性'}</span><input id="PropertyName" name="form.proMame" value="${(result.productInfo.proMame)!'其他属性'}" maxlength="20" style="display:none;"/></span>
								</th>
								<th width="217">
								<span class="empty15"><a onclick="editProperty(this)"></a></span>
								</th>
                            </tr>
                            <#if result??&&result.productInfo!=null&&result.productInfo.productProperty?exists && result.productInfo.productProperty??>
                                <#list result.productInfo.productProperty as productProperty>
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
			                                <th width="130"><span class="empty15">${action.getText("product.xiaoshoujiage")}</span></th>
			                                <th width="130"><span class="empty15">${action.getText("product.kucun")}</span></th>
			                                <th width="158"><span class="empty15">商品图片</span></th>
                                		</tr>
                                	</table>
                                </th>
                                
                            </tr>
                            <#if result??&&result.productInfo!=null&&result.productInfo.productSpec?exists && result.productInfo.productSpec??>
                                 <#list result.productInfo.productSpec as productSpec>
                                  <tr>
                                <td class="productSpecNameShow"><span class="empty15">${(productSpec.value)!}</span></td>
                                <td width="655"> 
	                                <table  cellspacing="0" cellpadding="0" class="innerTable no_border left_border" width="100%">
                                     <#if productSpec.productConfigInfo?exists && productSpec.productConfigInfo??>
	                                     <#list productSpec.productConfigInfo as productConfigInfo>
	                                       <tr>
							                <td width="132" class="ppropertyValue" name="${(productConfigInfo.id)!}" onclick="showProduvtImg('${imagePath}${(productConfigInfo.imageUrl)!}')"><span class="empty15">${(productConfigInfo.propertyValue)!}</span></td>
										    <td width="105"><span class="empty15">${(productConfigInfo.marketPrice)!0}</span></td>
										    <td width="130"><span class="empty15">${(productConfigInfo.productPrice)!0}</span></td> 
										    <td width="130"><span class="empty15">${(productConfigInfo.totalStock)!0}</span></td> 
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
                        <li><label class="fixed-width">商品url</label><span><input type="text" id="formContent" name="form.content" readonly="readonly" value="${(result.productInfo.content)!}" style="width:500px;"maxlength="50"/></span><span class="formContentSpan Validform_checktip"></span></li>
                        </ul>
                        <div class="textEditArea blockTableBottom25">
                        	<div class="pro_title_top">
	                        	<b>商品介绍</b>
	                        	<div class="blockActiveList">
	                              ${(result.productInfo.detail)!}
	                            </div>
	                            <div class="clear"></div>
                        	</div>
                            
                        </div>
                        </form>
                    </div>
                    <div class="clear"></div>
                </div>
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
 
</script>
<style type="text/css">
/*body{ min-width: inherit; background-color:#fff;}*/
.blockActiveList{ float:left; padding-top:31px; width:92%; font-size:13px; background-color:#fff; padding:10px 4%;}
.blockActiveList li{ padding-bottom:12px;}
.blockActiveList li h3{ padding-bottom:5px; text-indent: 2em; font-size:14px; color:#000; width:100%;}
.blockActiveList li p, .blockActiveList p{ line-height:24px; font-size:14px; color:#4c4c4c; width:100%; padding-bottom:5px}
.blockActiveList img{ width:100%; height:auto; padding-top:5px;}
</style>