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
.fixed-width{ width:126px; text-align:right;}
</style>
<script type="text/javascript">
   var path = '${contextPath}';
   $(function(){
      	first();
      	
      	var isAudit ="${(result.productInfo.isAudit)!}";
      	if(isAudit != null){
	      	var status =  "${(result.productInfo.isAudit.value)!}";
	    	if(status != null && status == 2){
			  $(".not_approved").show(500)
			  //t=setTimeout(function(){$(".not_approved").hide(500)}, 3000);
			}
      	}
	});
       
  function selectHotel(){
    $("#hotelshow").show();
    $("#hotelshowBox").show();
  }
 
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
    // $("#PropertyName").prev().hide();
    // $("#PropertyName").show();
    // $("#PropertyName").select();
  }
  function recodeProName(t){
    // $("#PropertyName").hide();
    // $(t).parent().find("span").html($("#PropertyName").val());
    // $(t).parent().find("span").show();
  }
  //保存或者更新
  function save(){
   //配送方式
    var modesStr =new Array();
    $(".checkboxChange").find(".checkbox").each(function(index) {
  	          if($(this).attr("checked")){
  	             modesStr.push($(this).attr("title"));
  	          }
	 });
	 if(modesStr == ""){
         alert("请选择配送方式");
         return;
    }
    $("#deliveryModesStr").val(modesStr);
  
    var pdefSysCommRate = $("#PdefSysCommRate").val();
    if(pdefSysCommRate==""){
       $("#PdefSysCommRate").val(0);
    }
    
      //商品规格
      var specNames =new Array();
      var specIds =new Array();
      $(".specMameTable").find("tr:gt(0)").each(function(index) {
              if(index<$(".specMameTable").children().find("tr").length-2){
                specNames.push($(this).find(".text-put-here").html());
                specIds.push($(this).find(".text-put-here").attr("name"));
              }
		});
      if(specNames == ""){
         alert("请填写商品规格");
         return;
     }
     $("#specNames").val(specNames);
     $("#specIds").val(specIds);
      //商品属性
      var proNames =new Array();
      var proNameIds =new Array();
      $(".proMameTable").find("tr:gt(0)").each(function(index) {
              if(index<$(".proMameTable").children().find("tr").length-2){
                proNames.push($(this).find(".text-put-here").html());
                proNameIds.push($(this).find(".text-put-here").attr("name"));
              }
		});
      if(proNames == ""){
         alert("请填写商品属性");
         return;
     }
     $("#proNames").val(proNames);
     $("#proNameIds").val(proNameIds);
     
      var proIds = new Array();
      var proValues =new Array();
      var marketPrices =new Array();
      var productPrices =new Array();
      var totalStocks =new Array();
      var addStocks =new Array();
      var imgUrlsm =new Array();
     //商品配置
      $(".outTable").find(".ppropertyValue").each(function(index) {
             proValues.push($(this).find(".empty15").html());
             proIds.push($(this).attr("name"));
      });  
      $(".outTable").find(".pmarketPrice").each(function(index) {
             if($(this).val() != ""){
                marketPrices.push($(this).val());
             }else{
                marketPrices.push(0);
             }
      }); 
      $(".outTable").find(".pproductPrice").each(function(index) {
              if($(this).val() != ""){
                productPrices.push($(this).val());
             }else{
                productPrices.push(0);
             }
      }); 
      $(".outTable").find(".ptotalStock").each(function(index) {
              if($(this).val() != ""){
                totalStocks.push($(this).val());
             }else{
                totalStocks.push(0);
             }
      }); 
      $(".outTable").find(".paddStock").each(function(index) {
              if($(this).val() != ""){
                addStocks.push($(this).val());
             }else{
                addStocks.push(0);
             }
      }); 
      $(".outTable").find(".pimgUrls").each(function(index) {
              if($(this).val() != ""){
                imgUrlsm.push($(this).val());
             }else{
                imgUrlsm.push(0);
             }
      }); 
      $("#proIds").val(proIds);
      $("#proValues").val(proValues);
	  $("#marketPrices").val(marketPrices);
	  $("#productPrices").val(productPrices);
	  $("#totalStocks").val(totalStocks);
	  $("#addStocks").val(addStocks);
	  $("#imgUrlsm").val(imgUrlsm);
	  //$("#saveForm").submit();
      var vform= $("#saveForm").Validform({
				tiptype:2,
				showAllError:false,
				ajaxPost:true,
				callback:function(data){
					if(data.status=="y"){ //返回成功
						$.Hidemsg();
						tip_show(data.status, data.info);
						$("#fisrtId").val(data.value);
						//延迟1秒加载页面
						setTimeout(function(){
								list(); 
						},1000);
					}else if(data.status=="n"){ //返回失败
						$.Hidemsg();
						tip_show(data.status, data.info);
						//延迟8秒隐藏页面
						setTimeout(function(){
								tip_hide(); 
						},8000);
						return false;
					}else{ //返回未知错误
					    $.Hidemsg();
						tip_show('n', '保存处理失败');
						//延迟8秒隐藏页面
						setTimeout(function(){
								tip_hide(); 
						},8000);
						return false;
					}
				}
			});
	 
			$("#saveForm").submit();
			if(vform.getStatus() == 'posting'){
				tip_show('w', "正在处理中...");
			}
    
  }
  
   function showProduvtImg(imgUrl){
      //$("#productImgShow").attr("src",imgUrl);
      //$("#hotelshows").show();
      //$("#hotelshowBoxs").show();
   }
   
  function checkPlatPrice(obj){
      $(obj).val($(obj).val().replace(/[^0-9.]+/,''));
      if(parseInt($(obj).val().replace(/[^0-9.]+/,''))>10000 || parseInt($(obj).val().replace(/[^0-9.]+/,''))<0){
        $(obj).val(0);
      }
  }
      
  function showDetail(id){
      var serachId = $("#serachId").val();
	  if(serachId != null){
	       if(window.confirm("保存商品需要重新审核,是否继续操作?")){
	           var url = "${contextPath}/admin/productshe/detail.do?id="+id;
		       loadRightPage(url);
	      }
	   }
  }
</script>
<div class="titleH2 font14">${action.getText("product.label")}${action.getText("label.detail")}
<#if result != null && result.productInfo != null && result.productInfo.isAudit != null && result.productInfo.isAudit.value != 0><a class="addProducts paddingL13" onclick="showDetail('${(result.id)!}')">编辑</a></#if> 
</div>
      <div class="tip_save_success"><img src="${contextPath}/css/images/tip_save_success.png" width="46" height="60"><span class="tip_font_save"><span class="font16"><b>保存成功!</b></span><cite>请耐心等待审核</cite></span></div>
	  <div class="not_approved">
	        <p class="tip_approved"><img src="${contextPath}/css/images/not_approved.png" width="35" height="36"><b class="font16">未通过审核</b></p>
	        <p class="why_approved">原因：${(result.productInfo.auditReason)!}</p>
	  </div>
	  <div class="OrderTable">
				    <form id="saveForm" method="post" action="${contextPath}/admin/productshe/<#if isAddAction>save<#else><#if result??>savedetail<#else>save</#if></#if>.do" enctype="multipart/form-data">
				    <input type="hidden" name="shelves.id" value="${(result.id)!}" id="serachId" />
				    <input type="hidden" name="shelves.isDelete" value="0" />
				    <input type="hidden" id="formId"  name="form.id" value="${(result.productInfo.id)!}" />
				    <input type="hidden" name="form.productSn" value="${(result.productInfo.productSn)!}" />
				    <input type="hidden" id="formOldName" value="${(result.name)!}" />
					<input type="hidden" id="formNameSpanError" value="0" />
                	<div class="products-vesting">
                    	<ul>
                        	<li style="display:none;"><label class="fixed-width">${action.getText("product.hotelName")}</label><span><input type="text" class="hotelInput"  onclick="selectHotel()" readonly="readonly"  style="width:400px;"  value="${(result.hotelName)!}" id="hotelNameShow"/><input type="hidden" id="hotelId" value="${(result.hotelId)!}" name="shelves.hotelId"/></span></li>
                            <li><label class="fixed-width">${action.getText("product.productTypeName")}</label><#if result??>${(result.productTypes.desc)!}<#else>自售</#if>商品</span></li>
                            <li><label class="fixed-width">${action.getText("product.name")}</label><span>${(result.name)!}<input type="hidden" class="hotelInput" name="form.name" style="width:300px;" value="${(result.name)!}"  maxlength="50" id="resultName" onblur="findByName()"/></span><span id="resultNameSpan"></span></li>
                            <li><label class="fixed-width">${action.getText("product.deliveryModes")}</label><span>
                            	<ul class="checkboxChange">
                            	 <#list deliveryTypes as deliveryType>
                            	 	 <#assign flag=false/>
                            	 	 <#if result??&&result?exists&&(result.deliveryMode)??&&(result.deliveryMode)?exists>
                            	 	 	<#list result.deliveryMode as d><#if d.value==deliveryType.value><#assign flag=true/><#break/></#if></#list>
                                     </#if>
                                     <li style="display:none;"><input type="checkbox" title="${(deliveryType.value)!""}" <#if flag>checked="checked" </#if>class="checkbox" />${(deliveryType.desc)!""}</span></li>
                                     <li><#if flag>${(deliveryType.desc)!""}</#if></span></li>
                                 </#list>
                                </ul>
                                <input type="hidden" name="shelves.deliveryModes" id="deliveryModesStr" />
                                </span>
                            </li>
                            <li><label class="fixed-width">佣金比例</label><span>${(result.productInfo.defSysCommRate)!0}<input type="hidden" id="PdefSysCommRate" name="form.defSysCommRate" maxlength="10" value="${(result.productInfo.defSysCommRate)!0}" onkeyup="checkPlatPrice(this)" onafterpaste="this.value=this.value.replace(/[^0-9.]+/,'')"/>%</span><label class="tip_commission">*平台收取佣金</label></li>
                            <li><label class="fixed-width">二维码url</label><span>http://www.1ct.cc/boraMallH5T/views/front/product/product.html?from=1&pid=${(result.productSn)!}</span></li>
                            <li class="updateImgWeb"><label class="fixed-width">${action.getText("product.image")}</label>
                            <a class="file_update_area" style="display:none;">
                            	<div class="updateLayer"><span id="spanButtonPlaceholder"  onmousedown ="clearId(this)"></span>
	                       		  <input id="btnCancel" type="button" value="取消上传" onclick="cancelQueue(upload1);" disabled="disabled" style="margin-left: 2px; height: 22px; font-size: 8pt; display:none" />
	                         	</div>
                            </a>
                             <input type="hidden" id="productImg" name="form.imageUrl" value="${(result.productInfo.imageUrl)!}"/></li>
                             <#if result !=null && result.id != null && result.productInfo?? && result.productInfo != null && result.productInfo.imageUrl !=null>
                             <li id="imageSrcDiv" class="updateImgWeb">
                             	<label class="fixed-width"></label><span class="reviewPic"><img id="imageSrc" width="100%" height="100%"  src="${imagePath}${(result.productInfo.imageUrl)!}"></span>
                             </li>
                             <#else> 
                             <li id="imageSrcDiv" class="updateImgWeb" style="display:none;">
                             	<label class="fixed-width"></label><span class="reviewPic"><img id="imageSrc" width="100%" height="100%"></span>
                             </li>
                             </#if>
                             <#if result!=null && result.productInfo != null && result.productInfo.isAudit!=null&&result.productInfo.isAudit.value ==1> 
                             <li><label class="fixed-width"></label><span><a href="${imagePath}${(result.getRealScanUrl())!}" target="blank">查看扫描二维码</a></span>&nbsp;&nbsp;<span><a href="${contextPath}/common/download.do?attachname=${imagePath}${(result.getRealScanUrl())!}">下载扫描二维码</a></span>&nbsp;&nbsp;<span><a href="${imagePath}${(result.getRealShareUrl())!}" target="blank">查看分享二维码</a></span>&nbsp;&nbsp;<span><a href="${contextPath}/common/download.do?attachname=${imagePath}${(result.getRealShareUrl())!}">下载分享二维码</a></span></li>
                             </#if>
                        </ul>
                    </div>
                    <div class="OrderBottom">
                       <table width="760" class="blockTableBottom specMameTable" cellpadding="0" cellspacing="0">
                            <tr>
                            	<th width="95"></th>
								<th width="290">
									<span class="empty15"><span>${(result.productInfo.specName)!'商品规格'}</span><input id="specName" name="form.specName" value="${(result.productInfo.specName)!'商品规格'}" onblur="recodeSpecName(this)" style="display:none;"/></span>
								</th>
								<th width="217">
								<span class="empty15"><a onclick="editSpec(this)"></a></span>
								</th>
                            </tr>
                            <#if result?? && result.productInfo?? && result.productInfo.productSpec?exists && result.productInfo.productSpec??>
                                <#list result.productInfo.productSpec as productSpec>
                                 <tr>
	                                <td width="95" class="Nunb"><span class="empty15">${(productSpec_index+1)!}</span></td>
	                                <td width="290"><span class="empty15"><span class="text-put-here"  name="${(productSpec.id)!}">${(productSpec.value)!}</span><span style="display:none;"></span></span></td>
	                                <td width="217"><span class="empty15"><a class=""></a><a class="deleteThisCole" name="1"></a></span></td>
                                  </tr>
                               </#list>
                            </#if>
                            <tr style="display:none;">
                                <td  width="95" class="Nunb"><span class="empty15"><#if result?? && result.productInfo?? && result.productInfo.productSpec?exists && result.productInfo.productSpec??>${(result.productInfo.productSpec?size+1)!}<#else>1</#if></span></td>
                                <td width="290"><span class="empty15"><span class="text-put-here"   name="0"></span><span style="display:none;"><input type="text" onblur="saveProductProperty(this,2)" maxlength="20"/></span><span class="fillNameinput"><input type="text" placeholder="请输入商品规格名称" class="fillName" maxlength="20" /></span></span></td>
                                <td  width="217" class="show-two-btn"><span class="empty15"><a class="addTd" name="1">添加</a><a class="toUp">上移</a></span></td>
                            </tr>
                        </table>
                        <table width="760" class="blockTableBottom proMameTable" cellpadding="0" cellspacing="0">
                            <tr>
                            	<th width="95"></th>
								<th width="290">
									<span class="empty15"><span>${(result.productInfo.proMame)!'其他属性'}</span><input id="PropertyName" name="form.proMame" value="${(result.productInfo.proMame)!'其他属性'}" onblur="recodeProName(this)" style="display:none;"/></span>
								</th>
								<th width="217">
								<span class="empty15"><a onclick="editProperty(this)"></a></span>
								</th>
                            </tr>
                            <#if result?? && result.productInfo?? && result.productInfo.productProperty?exists && result.productInfo.productProperty??>
                                <#list result.productInfo.productProperty as productProperty>
                                 <tr>
	                                <td width="95" class="Nunb"><span class="empty15">${(productProperty_index+1)!}</span></td>
	                                <td width="290"><span class="empty15"><span class="text-put-here"  name="${(productProperty.id)!}">${(productProperty.value)!}</span><span style="display:none;"></span></span></td>
	                                <td width="217"><span class="empty15"><a class=""></a><a class="deleteThisCole" name="2"></a></span></td>
                                  </tr>
                               </#list>
                            </#if>
                            <tr style="display:none;">
                                <td width="95" class="Nunb"><span class="empty15"><#if result?? && result.productInfo?? && result.productInfo.productProperty?exists && result.productInfo.productProperty??>${(result.productInfo.productProperty?size+1)!}<#else>1</#if></span></td>
                                <td width="290"><span class="empty15"><span class="text-put-here" name="0"></span><span style="display:none;"><input type="text" onblur="saveProductProperty(this,1)" maxlength="20"/></span><span class="fillNameinput"><input type="text" placeholder="请输入商品属性名称" class="fillName"  maxlength="20"/></span></span></td>
                                <td  width="217" class="show-two-btn"><span class="empty15"><a class="addTd" name="2">添加</a><a class="toUp">上移</a></span></td>
                            </tr>
                        </table>
                        <table width="759" class="blockTableBottom outTable" cellpadding="0" cellspacing="0">
                            <tr>
                                <th width="95"><span class="empty15">${action.getText("product.guige")}</span></th>
                                <th width="664">
                                	<table width="100%"  class="no_border left_border">
                                		<tr>
                                			<th width="77"><span class="empty15">${action.getText("product.shuxing")}</span></th>
			                                <th width="76"><span class="empty15">${action.getText("product.shichangjiage")}</span></th>
			                                <th width="76"><span class="empty15">${action.getText("product.xiaoshoujiage")}</span></th>
			                                <th width="76"><span class="empty15">${action.getText("product.kucun")}</span></th>
			                                <th width="76"><span class="empty15">${action.getText("product.tianjiakucun")}</span></th>
			                                <th width="158"><span class="empty15">商品图片</span></th>
			                                <th width="125" style="display:none;"><span class="empty15">${action.getText("label.action")}</span></th>
                                		</tr>
                                	</table>
                                </th>
                                
                            </tr>
                            <#if result?? && result.productInfo?? && result.productInfo.productSpec?exists && result.productInfo.productSpec??>
                                 <#assign configIndex = 0 > 
                                 <#list result.productInfo.productSpec as productSpec>
                                  <tr>
                                <td class="productSpecNameShow"><span class="empty15">${(productSpec.value)!}</span></td>
                                <td> 
	                                <table  cellspacing="0" cellpadding="0" class="innerTable no_border left_border" width="100%">
                                     <#if productSpec.productConfigInfo?exists && productSpec.productConfigInfo??>
	                                     <#list productSpec.productConfigInfo as productConfigInfo>
	                                     <#assign configIndex = configIndex+1 >
	                                       <tr>
							                <td width="77" class="ppropertyValue" name="${(productConfigInfo.id)!}" onclick="showProduvtImg('${imagePath}${(productConfigInfo.imageUrl)!}')"><span class="empty15">${(productConfigInfo.propertyValue)!}</span></td>
										    <td width="76"><span class="empty15">${(productConfigInfo.marketPrice)!}<input type="hidden" style="width:50px;" value="${(productConfigInfo.marketPrice)!}" maxlength="8" class="pmarketPrice"  onkeyup="clearNoNum(this)"/></span></td>
										    <td width="76"><span class="empty15">${(productConfigInfo.productPrice)!}<input type="hidden" style="width:50px;" value="${(productConfigInfo.productPrice)!}" maxlength="8" class="pproductPrice"  onkeyup="clearNoNum(this)"/></span></td> 
										    <td width="76"><span class="empty15">${(productConfigInfo.totalStock-productConfigInfo.lockedStock)!}<input type="hidden" style="width:50px;" value="${(productConfigInfo.totalStock-productConfigInfo.lockedStock)!}" maxlength="8" class="ptotalStock" <#if result.id != null>readonly="readonly"</#if> onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/></span></td> 
										    <td width="76"><span class="empty15"><input type="text" style="width:50px;" value="0" maxlength="8"  class="paddStock" onkeyup="this.value=this.value.replace(/[^0-9-]+/,'')" onafterpaste="this.value=this.value.replace(/[^0-9-]+/,'')" onblur="addkucun(this)"/></span></td> 
										    <td width="158"><span class="empty15"><img id="productConfigImg${configIndex}" <#if productConfigInfo != null && productConfigInfo.imageUrl != null>src="${imagePath}${(productConfigInfo.imageUrl)!}" <#else> src="${contextPath}/css/images/no_pic.png"</#if> width="143" height="92"></span></td>
						                    <td width="125" style="display:none;"><span class="empty15"><a class="file_update_area">
						                    <div class="updateLayer_pro"><span id="spanButtonPlaceholder${configIndex}"  onmousedown ="clearId(this)"></span>
	                       		            <input id="btnCancel${configIndex}" type="button" value="取消上传" onclick="cancelQueue(upload1);" disabled="disabled" style="margin-left: 2px; height: 22px; font-size: 8pt; display:none" /></div>
	                       		            
						                    </a>
						                    <span>
	                       		            <input type="hidden" class="pimgUrls" id="pimgUrls${configIndex}"/>
	                       		            </td>
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
						<ul class="products-vesting" <#if result??><#else>style="display:none;"</#if>>
                        <li><label class="fixed-width">商品url</label><span>${(result.productInfo.content)!}<input type="hidden" id="formContent" name="form.content" style="width:500px;" readonly="readonly" value="${(result.productInfo.content)!}" maxlength="50"/></span><span class="formContentSpan Validform_checktip"></span></li>
                        </ul>
                        <div class="textEditArea blockTableBottom25">
                        	<div class="pro_title_top">
                        		<b>商品介绍</b>
	                        	<div class="blockActiveList">
	                        		${(result.productInfo.detail)!}
		                            <textarea cols="80" id="editor1" name="form.detail"  rows="10" style="display:none;">
		                             ${(result.productInfo.detail)!}
		                            </textarea>
	                        	</div>
	                        	<div class="clear"></div>
                        	</div>
                        </div>
                        <div class="order-status-btn btn_hasPassed">
                            <span class="can-send-btn">
                            	<a class="confirm-save" onclick="save()">${action.getText("button.save")}</a>
                               <a class="cancel-btn" style="display:none;" onclick="cancel()">${action.getText("button.cancel")}</a>
                            </span>
                        </div>
                        </form>
                    </div>
                    <div class="clear"></div>
                </div>
                
               <div id="configImghidden"></div>

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
   <script type="text/javascript" defer="defer">             
    function onUploadImgChange(sender){
		var filePath = sender.value;
		var fileExt = filePath.substring(filePath.lastIndexOf(".")).toLowerCase();
		if(!checkFileExt(fileExt))
		{
		alert("您上传的文件不是图片,请重新上传！");
		return false;
		}
	}
	
	function checkFileExt(ext)
	{
	    if (!ext.match(/.jpg|.gif|.png|.bmp/i)) {
	        return false;
	    }
	    return true;
	}
		
	function editProductProperty(obj){
	  //  $(obj).hide();
	  //  $(obj).next().find("input").val($(obj).html());
	  //  $(obj).next().show();
	
	}
	
	function saveProductProperty(obj,type){
	    var alertStr = "请输入名称";
		var inputValue = $.trim($(obj).val());
		var inputValues = $.trim($(obj).parent().prev().html());
		if(inputValue==""){
			alert(alertStr);
			return;
		}else{
			var specFlag = true;
			var proFlag = true;
			if(inputValue != inputValues) {
				$(obj).parent().parent().parent().parent().parent().find("tr:gt(0)").each(function(index) {
					if($(this).find(".text-put-here").html() == inputValue){
						specFlag = false;
					}
				});
				if(!specFlag){
					alert("该名称已存在!");
					return;
				}
			}
		}
		
		
	 if(type == 1){
		  $(".outTable").find(".ppropertyValue").each(function(index) {
	             if($(this).find(".empty15").html()==inputValues){
	                   $(this).find(".empty15").html(inputValue);
	             }
	      });  
	  }else if(type == 2 ){
		 $(".outTable").find(".productSpecNameShow").each(function(index) {
	             if($(this).find(".empty15").html()==inputValues){
	                   $(this).find(".empty15").html(inputValue);
	             }
	      });
      }  
      
		
	    $(obj).parent().hide();
	    $(obj).parent().prev().html($(obj).val());
	    $(obj).parent().prev().show();
	}
	
	
	function addkucun(obj){
	   var old = parseInt($(obj).parent().parent().prev().find("input").val());
	   var addold =  parseInt($(obj).val());
	   if(old+addold<0){
	       alert("添加库存超出库存范围");
	       $(obj).val(0);
	   }
	}
	</script>
