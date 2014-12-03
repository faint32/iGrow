<@a.header "${action.getText('ui.manage')}">
<style type="text/css">
.pimgUrls{
 filter:alpha(opacity=0);
 -moz-opacity:0;
 -khtml-opacity: 0;
 opacity: 0;
 font-family: Arial; 
 font-size: 8px; 
 cursor: pointer; 
}
</style>
<script type="text/javascript">
   var path = '${contextPath}';
   $(function(){
      	first();
      	
      	var isAudit ="${(result.isAudit)!}";
      	if(isAudit != null){
	      	var status =  "${(result.isAudit.value)!}";
	    	if(status != null && status == 0){
			  	 $(".tip_save_success").show();
			 	 $("html,body").animate({scrollTop : '0px'}, 800);
			     //setTimeout(function(){$(".tip_save_success").slideUp(1000)}, 3000)
			}
      	}
	});
  function editSpec(t){
     $("#specName").prev().hide();
     $("#specName").show();
     $("#specName").select();
  }
  function recodeSpecName(t){
     $("#specName").hide();
     $(t).parent().find("span").html($("#specName").val());
     $(t).parent().find("span").show();
  }
  function editProperty(t){
     $("#PropertyName").prev().hide();
     $("#PropertyName").show();
     $("#PropertyName").select();
  }
  function recodeProName(t){
     $("#PropertyName").hide();
     $(t).parent().find("span").html($("#PropertyName").val());
     $(t).parent().find("span").show();
  }
</script>
</@a.header >
<div class="titleH2 font14">${action.getText("product.label")}${action.getText("label.detail")}</div>
	  <div class="tip_save_success"><img src="${contextPath}/css/images/tip_save_success.png" width="46" height="60"><span class="tip_font_save"><span class="font16"><b>待审核状态不能编辑!</b></span><cite>请耐心等待审核</cite></span></div>
	  <div class="not_approved">
	        <p class="tip_approved"><img src="${contextPath}/css/images/not_approved.png" width="35" height="36"><b class="font16">未通过审核</b></p>
	        <p class="why_approved">原因：${(result.productInfo.auditReason)!}</p>
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
                            <li><label class="fixed-width" style="display:none;">平台佣金</label><span>${(result.defSysCommRate)!0}%</span><label class="tip_commission">*平台收取佣金</label></li>
                            <li><label class="fixed-width" style="display:none;">酒店佣金</label><span>${(result.defHotelCommRate)!0}%</span></li>
                            <li><label class="fixed-width">默认图片</label><span>
							 <#if result !=null && result.imageUrl !=null>
                             	 <span class="reviewPic"><img id="imageSrc" width="100%" height="100%"  src="${imagePath}${(result.imageUrl)!}"></span> 
                             </#if>
							</span></li>
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
	                                <td><span class="empty15"><span class="text-put-here" name="${(productSpec.id)!}">${(productSpec.value)!}</span><span style="display:none;"></span></span></td>
	                                <td width="217"></td>
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
	                                <td><span class="empty15"><span class="text-put-here" name="${(productProperty.id)!}">${(productProperty.value)!}</span><span style="display:none;"></span></span></td>
                                    <td width="217"></td>
                                  </tr>
                               </#list>
                            </#if>
                        </table>
                        <table width="100%" class="blockTableBottom outTable" cellpadding="0" cellspacing="0">
                            <tr>
                                <th width="95">${action.getText("product.guige")}</span></th>
                                <th width="655">
                                	<table width="655"  class="no_border left_border">
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
                            <#if result??&&result.productSpec?exists && result.productSpec??>
                                 <#list result.productSpec as productSpec>
                                  <tr>
                                <td class="productSpecNameShow"><span class="empty15">${(productSpec.value)!}</span></td>
                                <td width="655"> 
	                                <table  cellspacing="0" cellpadding="0" class="innerTable no_border left_border" width="655">
                                     <#if productSpec.productConfigInfo?exists && productSpec.productConfigInfo??>
	                                     <#list productSpec.productConfigInfo as productConfigInfo>
	                                       <tr>
							                <td width="132" class="ppropertyValue" name="${(productConfigInfo.id)!}" onclick="showProduvtImg('${imagePath}${(productConfigInfo.imageUrl)!}')"><span class="empty15">${(productConfigInfo.propertyValue)!}</td>
										    <td width="105"><span class="empty15">${(productConfigInfo.marketPrice)!0}</span></td>
										    <td width="130"><span class="empty15">${(productConfigInfo.productPrice)!0}</span></td> 
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
                        		<b>商品介绍</b>
                        		<div class="blockActiveList">
                        			${(result.detail)!}
                        		</div>
                        		<div class="clear"></div>
                        	</div>
                             
                        </div>
                        
                        <div class="order-status-btn btn_hasPassed" style="display:none;">
                            <span class="can-send-btn">
                            	<a class="confirm-save" onclick="save()">${action.getText("button.save")}</a>
                               <a class="cancel-btn" style="display:none;" onclick="cancel()">${action.getText("button.cancel")}</a>
                            </span>
                        </div>
                        </form>
                    </div>
                    <div class="clear"></div>
        </div>