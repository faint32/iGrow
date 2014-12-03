<script type="text/javascript">
   var path = '${contextPath}';
   $(function(){
	    first();
	    var isAudit = "${(result.isAudit)!}";
	    
	    var productTypes = "${(result.productTypes.value)!}";
	    
      	if(isAudit != null && productTypes == 0){
	      	var status =  "${(result.isAudit.value)!}";
	    	if(status != null && status == 0){
			  	 $(".tip_save_success").show();
			 	 $("html,body").animate({scrollTop : '0px'}, 800);
			    // setTimeout(function(){$(".tip_save_success").slideUp(1000)}, 3000)
			}
      	}
	});
  
 function selectHotel(){
    $("#hotelshow").show();
    $("#hotelshowBox").show();
 }
  //保存或者更新
  function save(){
    var hotelId = $("#hotelId").val();
    if(hotelId==""){
       // alert("请选择所属酒店");
        return;
    }else{
 		$("#saveForm").submit();
 	}
  }
  
    function showProduvtImg(imgUrl){
     // $("#productImgShow").attr("src",imgUrl);
     // $("#hotelshows").show();
     // $("#hotelshowBoxs").show();
   }
       
</script>
<style type="text/css">
.fixed-width{ width:126px; text-align:right;}
</style>
<div class="titleH2 font14">${action.getText("product.label")}${action.getText("label.detail")}</div>
	  <div class="tip_save_success"><img src="${contextPath}/css/images/tip_save_success.png" width="46" height="60"><span class="tip_font_save"><span class="font16"><b>待审核状态不能编辑!</b></span><cite>请耐心等待审核</cite></span></div>
	  <div class="not_approved">
	        <p class="tip_approved"><img src="${contextPath}/css/images/not_approved.png" width="35" height="36"><b class="font16">未通过审核</b></p>
	        <p class="why_approved">原因：${(result.productInfo.auditReason)!}</p>
	  </div>
	  <div class="OrderTable">
				    <form id="saveForm" method="post" action="${contextPath}/admin/productshe/<#if result??&&result.id != null>updateo<#else>saveo</#if>.do">
				    <input type="hidden" name="shelves.id" value="${(result.id)!}" />
				    <input type="hidden" name="shelves.productId" value="${(result.productInfo.id)!}"/>
                	<div class="products-vesting">
                    	<ul>
                        	<li style="display:none;"><label class="fixed-width">${action.getText("product.hotelName")}</label><span><input type="text" class="hotelInput" value="${(result.hotelName)!}" onclick="selectHotel()" readonly="readonly" id="hotelNameShow" style="width:400px;"/><input type="hidden" value="${(result.hotelId)!}" id="hotelId" name="shelves.hotelId"/></span></li>
                            <li><label class="fixed-width">${action.getText("product.productTypeName")}</label><span>${(result.productTypes.desc)!}商品</span></li>
                            <li><label class="fixed-width">${action.getText("product.name")}</label><span>${(result.name)!}</span><input type="hidden" name="shelves.name" value="${(result.name)!}" /></li>
                            <#if result != null && result.productTypes != null && result.productTypes.value == 0>
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
                              </li>
                              </#if>
                            <#if result != null && result.productInfo != null && result.productInfo.supplierInfo != null>
                            <li><label class="fixed-width">供应商</label><span>${(result.productInfo.supplierInfo.name)!}</span></li>
                            </#if>
                            <li><label class="fixed-width">佣金率</label><span><#if result!=null && result.productInfo!=null && result.productInfo.productTypes != null && result.productInfo.productTypes.value == 1><#if result.productInfo.hotelCommRate != 0>${(result.productInfo.hotelCommRate)!0}<#else>${(result.productInfo.defHotelCommRate)!0}</#if><#else>${(result.productInfo.defSysCommRate)!5}</#if>%</span></li>
 						    <li><label class="fixed-width">二维码url</label><span>http://www.1ct.cc/boraMallH5T/views/front/product/product.html?from=1&pid=${(result.productSn)!}</span></li>
  							<li><label class="fixed-width">默认图片</label><span>
							 <#if result !=null && result.id != null && result.productInfo?? && result.productInfo != null && result.productInfo.imageUrl !=null>
                             	 <span class="reviewPic"><img id="imageSrc" width="100%" height="100%"  src="${imagePath}${(result.productInfo.imageUrl)!}"></span>
                             </#if>
							</span></li>
                            <#if result!=null&&result.productInfo!=null&&result.productInfo.isAudit!=null&&result.productInfo.isAudit.value ==1> 
                            <li><label class="fixed-width"></label><span><a href="${imagePath}${(result.getRealScanUrl())!}" target="blank">查看扫描二维码</a></span>&nbsp;&nbsp;<span><a href="${contextPath}/common/download.do?attachname=${imagePath}${(result.getRealScanUrl())!}">下载扫描二维码</a></span>&nbsp;&nbsp;<span><a href="${imagePath}${(result.getRealShareUrl())!}" target="blank">查看分享二维码</a></span>&nbsp;&nbsp;<span><a href="${contextPath}/common/download.do?attachname=${imagePath}${(result.getRealShareUrl())!}">下载分享二维码</a></span></li>
                            </#if>
                        </ul>
                    </div>
                    <div class="OrderBottom">
                        <table width="760" class="blockTableBottom specMameTable" cellpadding="0" cellspacing="0">
                            <tr>
                            	<th width="95"></th>
								<th width="507">
									<span class="empty15"><span>${(result.productInfo.specName)!'商品规格'}</span></span>
								</th>
                            </tr>
                            <#if result?? && result.productInfo?? && result.productInfo != null && result.productInfo.productSpec?exists && result.productInfo.productSpec??>
                                <#list result.productInfo.productSpec as productSpec>
                                 <tr>
	                                <td class="Nunb"><span class="empty15">${(productSpec_index+1)!}</span></td>
	                                <td class="text-put-here"><span class="empty15">${(productSpec.value)!}</span></td>
                                  </tr>
                               </#list>
                            </#if>
                        </table>
                        <table width="760" class="blockTableBottom proMameTable" cellpadding="0" cellspacing="0">
                            <tr>
                                <th width="95"></th>
								<th width="507">
									<span class="empty15"><span>${(result.productInfo.proMame)!'其他属性'}</span></span>
								</th>
                            </tr>
                            <#if result?? && result.productInfo?? && result.productInfo != null && result.productInfo.productProperty?exists && result.productInfo.productProperty??>
                                <#list result.productInfo.productProperty as productProperty>
                                 <tr>
	                                <td width="95" class="Nunb"><span class="empty15">${(productProperty_index+1)!}</span></td>
	                                <td class="text-put-here"><span class="empty15">${(productProperty.value)!}</span></td>
                                  </tr>
                               </#list>
                            </#if>
                        </table>
                        <table width="760" class="blockTableBottom outTable" cellpadding="0" cellspacing="0">
                            <tr>
                                <th width="95"><span class="empty15">${action.getText("product.guige")}</span></th>
                                <th width="655">
                                	<table width="100%" class="no_border left_border">
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
                            <#if result?? && result.productInfo?? && result.productInfo != null && result.productInfo.productSpec?exists && result.productInfo.productSpec??>
                                 <#list result.productInfo.productSpec as productSpec>
                                  <tr>
                                <td><span class="empty15">${(productSpec.value)!}</span></td>
                                <td> 
	                                <table  cellspacing="0" cellpadding="0" class="innerTable no_border left_border"  width="100%">
                                     <#if productSpec.productConfigInfo?exists && productSpec.productConfigInfo??>
	                                     <#list productSpec.productConfigInfo as productConfigInfo>
	                                       <tr>
							                <td width="132" class="ppropertyValue" onclick="showProduvtImg('${imagePath}${(productConfigInfo.imageUrl)!}')"><span class="empty15">${(productConfigInfo.propertyValue)!}</span></td>
										    <td width="105"><span class="empty15">${(productConfigInfo.marketPrice)!}</span></td>
										    <td width="130"><span class="empty15">${(productConfigInfo.productPrice)!}</span></td> 
										    <td width="130"><span class="empty15">${(productConfigInfo.totalStock-productConfigInfo.lockedStock)!}</span></td> 
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
						<ul class="products-vesting">
                        <li><label class="fixed-width">商品url</label><span>${(result.productInfo.content)!}</span></li>
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
                        <div class="order-status-btn btn_hasPassed"  style="display:none;">
                            <span class="can-send-btn">
                            	<a class="confirm-save" onclick="save()">${action.getText("button.save")}</a>
                               <a class="cancel-btn" style="display:none;" onclick="cancel()">${action.getText("button.cancel")}</a>
                            </span>
                        </div>
                        </form>
                    </div>
                    <div class="clear"></div>
                </div>

<div class="layer" id="hotelshows">
	<div class="bottomBlock"></div>
    <div class="layerBox" id="hotelshowBoxs">
        <div class="closed"></div>
        <div class="summaryBox">
	         <img src="" id="productImgShow" />
        </div>
    </div>
    <!-- end layerBox -->
</div> 
