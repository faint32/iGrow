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
<style type="text/css">
.fixed-width{ width:126px; text-align:right;}
.products-vesting li span{ display:inline-block; width:600px;}
</style>
<script type="text/javascript">
   var path = '${contextPath}';
   $(function(){
      	first();
        var isAudit ="${(result.isAudit)!}";
        var isAuditReason ="${(result.auditReason)!}";
      	if(isAudit != null){
	      	var status =  "${(result.isAudit.value)!}";
	    	if(status != null && status == 2){
			   $(".not_approved").show(500);
			  //t=setTimeout(function(){$(".not_approved").hide(500)}, 3000);
			}else if(status ==1 && isAuditReason != "" ){
			   $(".not_approved").show(500);
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
    // $("#PropertyName").prev().hide();
     //$("#PropertyName").show();
    // $("#PropertyName").select();
  }
  function recodeProName(t){
    // $("#PropertyName").hide();
    // $(t).parent().find("span").html($("#PropertyName").val());
    // $(t).parent().find("span").show();
  }
	     
  //保存或者更新
 function save(){
	       var pdefSysCommRate = $("#PdefSysCommRate").val();
		   if(pdefSysCommRate==""){
		        alert("请填写平台佣金");
		        return;
		   }
           var PdefHotelCommRate = $("#PdefHotelCommRate").val();
		   if(PdefHotelCommRate==""){
		       $("#PdefHotelCommRate").val(0);
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
  
  function checkPlatPrice(obj){
      $(obj).val($(obj).val().replace(/[^0-9.]+/,''));
      if(parseInt($(obj).val().replace(/[^0-9.]+/,''))>10000 || parseInt($(obj).val().replace(/[^0-9.]+/,''))<0){
        $(obj).val(0);
      }
  }
  function showDetail(id){
      var serachId = $("#formId").val();
	  if(serachId != null){
	       if(window.confirm("保存商品需要重新审核,是否继续操作?")){
	           var url = "${contextPath}/admin/productimage/detail.do?id="+id;
		       loadRightPage(url);
	      }
	   }
  }
  function clearNoNum(obj){
	//先把非数字的都替换掉，除了数字和小数点
	obj.value = obj.value.replace(/[^\d.]/g,"");
	//必须保证第一个为数字而不是小数点	
	obj.value = obj.value.replace(/^\./g,"");
	//保证只有出现一个小数点而没有多个.
	obj.value = obj.value.replace(/\.{2,}/g,".");
	//保证小数点只出现一次，而不能出现两次以上
	obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");

  //把小数点后面超过两位的数字替换掉，也就是保留两位小数
   var strs = "";
   var midd = "";
   var count = 0;
	  for(var i=0;i<obj.value.length;i++){
		  if(obj.value.charAt(i) == "."){
		     midd = "start";
		  }
		  if(midd == "start"){
		    count++;
		  }
		  if(count == 4){
		     break;
		  }
		  strs += obj.value.charAt(i);
		}
		obj.value = strs;
 }
 
 
 function editSaceCount(){
       $("#salecountspan").hide();
       $("#salecountipput").show();
 }
 
 function saveSaleCount(id){
     var salecount = 0;
     if($("#salecountipputValue").val() != ""){
    	 salecount = parseInt($("#salecountipputValue").val());
     }
     if(confirm("确定要修改该商品的默认销量吗？")){    
              var obj = {
                    "form.id":id,
                    "form.defSalesCount":salecount
              };
              $.ajax({
    			url : '${contextPath}/admin/productimage/saveDefSaleCount.do',
    			type : 'POST',
    			async : false,
    			dataType : "json",
    			async : false,
    			data : obj,
    			success : function(data) {
    				   if(data.status == "y"){
						      tip_show('w', "修改成功");
						      $("#salecountspan").html(salecount).show();
	      					  $("#salecountipput").hide();
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

<div class="titleH2 font14"><#if isAddAction>${action.getText("button.addnew")}<#else><#if result??>${action.getText("button.edit")}<#else>${action.getText("button.addnew")}</#if></#if>${action.getText("product.label")}${action.getText("label.detail")}
<#if result != null && result.isAudit != null && result.isAudit.value != 0><a class="addProducts paddingL13" onclick="showDetail('${(result.id)!}')">编辑</a></#if>
</div>
	  <div class="tip_save_success"><img src="${contextPath}/css/images/tip_save_success.png" width="46" height="60"><span class="tip_font_save"><span class="font16"><b>保存成功!</b></span><cite>请耐心等待审核</cite></span></div>
	  <div class="not_approved">
	        <p class="tip_approved"><img src="${contextPath}/css/images/not_approved.png" width="35" height="36"><b class="font16">未通过审核</b></p>
	        <p class="why_approved">原因：${(result.auditReason)!}</p>
	  </div>
	  <div class="OrderTable">
				    <form id="saveForm" method="post" action="${contextPath}/admin/productimage/<#if isAddAction>save<#else><#if result??>savedetail<#else>save</#if></#if>.do" enctype="multipart/form-data">
				    <input type="hidden" name="form.id" id="formId" value="${(result.id)!}" />
				    <input type="hidden" name="form.productSn" value="${(result.productSn)!}" />
				    <input type="hidden" id="formOldName" value="${(result.name)!}" />
					<input type="hidden" id="formNameSpanError" value="0" />
					<input type="hidden" name="form.salesCount" id="form" value="${(result.salesCount)!}" />
                	<div class="products-vesting">
                    	<ul>
                        	<li><label class="fixed-width">${action.getText("product.name")}</label>
                        		<span>${(result.name)!}<input type="hidden" class="hotelInput" name="form.name" value="${(result.name)!}" id="resultName" maxlength="50" /></span>
                        		<!--<span id="resultNameSpan" class="resultNameSpan Validform_checktip"></span>-->
                    		</li>
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
                            
                            <li class="lineHeight34"><label class="fixed-width">默认销量</label>
                        		<span id="salecountspan">${(result.defSalesCount)!}&nbsp;&nbsp;&nbsp;<a onclick="editSaceCount()">编辑</a></span>
                        		<span style="display:none;" id="salecountipput"><input  id="salecountipputValue" class="hotelInput shortInput" name="form.defSalesCount" value="${(result.defSalesCount)!0}"  maxlength="10" onkeyup="this.value=this.value.replace(/\D/g,'')" onblur="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/[^0-9.]+/,'')"/>&nbsp;&nbsp;&nbsp;<a onclick="saveSaleCount('${(result.id)!}')">保存</a></span>
                        	</li>
                            
                            <li style="display:none;"><label class="fixed-width">平台佣金</label><span>${(result.defSysCommRate)!0}<input type="hidden" class="hotelInput shortInput" name="form.defSysCommRate" value="${(result.defSysCommRate)!0}" id="PdefSysCommRate" maxlength="10" onkeyup="checkPlatPrice(this)" onafterpaste="this.value=this.value.replace(/[^0-9.]+/,'')"/>%</span><label class="tip_commission">*平台收取佣金</label></li>
                            <li style="display:none;"><label class="fixed-width">酒店佣金</label><span>${(result.defHotelCommRate)!0}<input type="hidden" class="hotelInput shortInput" name="form.defHotelCommRate" value="${(result.defHotelCommRate)!0}" id="PdefHotelCommRate" maxlength="10" onkeyup="checkPlatPrice(this)" onafterpaste="this.value=this.value.replace(/[^0-9.]+/,'')"/>%</span></li>
                            <li class="updateImgWeb"><label class="fixed-width">${action.getText("product.image")}</label> 
                             <a class="file_update_area" style="display:none;">
                            	<div class="updateLayer"><span id="spanButtonPlaceholder"  onmousedown ="clearId(this)"></span>
	                       		  <input id="btnCancel" type="button" value="取消上传" onclick="cancelQueue(upload1);" disabled="disabled" style="margin-left: 2px; height: 22px; font-size: 8pt; display:none" />
	                         	</div>
                             </a>
                             <input type="hidden" id="productImg" name="form.imageUrl" value="${(result.imageUrl)!}" style="display:none;"/></li>
                             <#if result !=null && result.imageUrl !=null>
                             <li id="imageSrcDiv" class="updateImgWeb">
                             	<label class="fixed-width"></label><span class="reviewPic"><img id="imageSrc" width="100%" height="100%"  src="${imagePath}${(result.imageUrl)!}"></span>
                             </li>
                             <#else> 
                             <li id="imageSrcDiv" class="updateImgWeb" style="display:none;">
                             	<label class="fixed-width"></label><span class="reviewPic"><img id="imageSrc" width="100%" height="100%"></span>
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
								<span class="empty15"><a onclick="editSpec(this)"></a></span>
								</th>
                            </tr>
                            <#if result??&&result.productSpec?exists && result.productSpec??>
                                <#list result.productSpec as productSpec>
                                 <tr>
	                                <td width="95" class="Nunb"><span class="empty15">${(productSpec_index+1)!}</span></td>
	                                <td width="290"><span class="empty15"><span class="text-put-here"   name="${(productSpec.id)!}">${(productSpec.value)!}</span><span style="display:none;"></span></span></td>
	                                <td width="217"><span class="empty15"><a class=""></a><a class="deleteThisCole" name="1"></a></span></td>
                                  </tr>
                               </#list>
                            </#if>
                            <tr style="display:none;">
                                <td width="95" class="Nunb"><span class="empty15"><#if result??&&result.productSpec?exists && result.productSpec??>${(result.productSpec?size+1)!}<#else>1</#if></span></td>
                                <td width="290"><span class="empty15"><span class="text-put-here"   name="0"></span><span style="display:none;"><input type="text" onblur="saveProductProperty(this,2)" maxlength="20"/></span><span class="fillNameinput"><input type="text" placeholder="请输入商品规格名称" class="fillName" maxlength="20" /></span></span></td>
                                <td width="217" class="show-two-btn"><span class="empty15"><a class="addTd" name="1">添加</a><a class="toUp">上移</a></span></td>
                            </tr>
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
	                                <td width="290"><span class="empty15"><span class="text-put-here"   name="${(productProperty.id)!}">${(productProperty.value)!}</span><span style="display:none;"><input type="text" onblur="saveProductProperty(this,1)" maxlength="20"/></span></span></td>
	                                <td width="217"><span class="empty15"><a class=""></a><a class="deleteThisCole" name="2"></a></span></td>
                                  </tr>
                               </#list>
                            </#if>
                            <tr style="display:none;">
                                <td width="95" class="Nunb"><span class="empty15"><#if result??&&result.productProperty?exists && result.productProperty??>${(result.productProperty?size+1)!}<#else>1</#if></span></td>
                                <td width="290"><span class="empty15"><span class="text-put-here" name="0"></span><span style="display:none;"><input type="text" onblur="saveProductProperty(this)" maxlength="20"/></span><span class="fillNameinput"><input type="text" placeholder="请输入商品属性名称" class="fillName"  maxlength="20"/></span></span></td>
                                <td width="217" class="show-two-btn"><span class="empty15"><a class="addTd" name="2">添加</a><a class="toUp">上移</a></span></td>
                            </tr>
                        </table>
                        <table width="759" class="blockTableBottom outTable" cellpadding="0" cellspacing="0">
                            <tr>
                                <th width="95"><span class="empty15">${action.getText("product.guige")}</span></th>
                                <th width="664">
                                	<table width="664"  class="no_border left_border">
                                		<tr>
                                			<th width="77"><span class="empty15">${action.getText("product.shuxing")}</span></th>
                                			<th width="76"><span class="empty15">${action.getText("product.shichangjiage")}</span></th>
			                                <th width="76"><span class="empty15">进货价格</span></th>
			                                <th width="76" style="display:none;"><span class="empty15">${action.getText("product.kucun")}</span></th>
			                                <th width="76" style="display:none;"><span class="empty15">${action.getText("product.tianjiakucun")}</span></th>
			                                <th width="158"><span class="empty15">商品图片</span></th>
			                                <th width="125" style="display:none;"><span class="empty15">${action.getText("label.action")}</span></th>
                                		</tr>
                                	</table>
                                </th>
                                
                            </tr>
                            <#if result??&&result.productSpec?exists && result.productSpec??>
                                <#assign configIndex = 0 > 
                                <#list result.productSpec as productSpec>
                                <tr>
                                <td class="productSpecNameShow"><span class="empty15">${(productSpec.value)!}</span></td>
                                <td> 
	                                <table  cellspacing="0" cellpadding="0" class="innerTable no_border left_border" width="664">
                                     <#if productSpec.productConfigInfo?exists && productSpec.productConfigInfo??>
	                                     <#list productSpec.productConfigInfo as productConfigInfo>
	                                       <#assign configIndex = configIndex+1 >
	                                       <tr>
							                <td width="77" class="ppropertyValue" name="${(productConfigInfo.id)!}" onclick="showProduvtImg('${imagePath}${(productConfigInfo.imageUrl)!}')"><span class="empty15">${(productConfigInfo.propertyValue)!}</td>
										    <td width="76"><span class="empty15">${(productConfigInfo.marketPrice)!}<input type="hidden" style="width:50px;" value="${(productConfigInfo.marketPrice)!}" maxlength="8" class="pmarketPrice" onkeyup="clearNoNum(this)"/></span></td>
										    <td width="76"><span class="empty15">${(productConfigInfo.productPrice)!}<input type="hidden" style="width:50px;" value="${(productConfigInfo.productPrice)!}" maxlength="8" class="pproductPrice" onkeyup="clearNoNum(this)"/></span></td> 
										    <td width="76" style="display:none;"><span class="empty15">${(productConfigInfo.totalStock-productConfigInfo.lockedStock)!}<input type="hidden" style="width:50px;" value="${(productConfigInfo.totalStock-productConfigInfo.lockedStock)!}" maxlength="8" class="ptotalStock" <#if result.id != null>readonly="readonly" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" </#if>/></span></td> 
										    <td width="76" style="display:none;"><span class="empty15"><input type="text" style="width:50px;" value="0" maxlength="8"  class="paddStock" onkeyup="this.value=this.value.replace(/[^0-9-]+/,'')" onafterpaste="this.value=this.value.replace(/[^0-9-]+/,'')" onblur="addkucun(this)"/></td>
										    <td width="158"><span class="empty15"><img id="productConfigImg${configIndex}" <#if productConfigInfo != null && productConfigInfo.imageUrl != null>src="${imagePath}${(productConfigInfo.imageUrl)!}" <#else> src="${contextPath}/css/images/no_pic.png"</#if> width="143" height="92"></span></td>
										    <td width="125" style="display:none;"><span class="empty15 ">
										    <a class="file_update_area">
										    	<div class="updateLayer_pro"><span id="spanButtonPlaceholder${configIndex}"  onmousedown ="clearId(this)"></span>
										    <input id="btnCancel${configIndex}" type="button" value="取消上传" onclick="cancelQueue(upload1);" disabled="disabled" style="margin-left: 2px; height: 22px; font-size: 8pt; display:none" /></div>
										    </a><span>
	                       		            <input type="hidden" class="pimgUrls" id="pimgUrls${configIndex}"/>
	                       		            </span>
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
                        <ul style="display:none;">
                        	<li><label class="fixed-width">商品url</label><span><input type="text" id="formContent" name="form.content" readonly="readonly" value="${(result.content)!}" style="width:500px;"maxlength="50"/></span><span class="formContentSpan Validform_checktip"></span></li>
                        </ul>
                        <div class="textEditArea blockTableBottom25">
                        	<div class="pro_title_top">
                        		<div class="tabCont" id="tab">
							        <ul id="tabwarp">
							            <li class="selectTag" onclick="selectTag(0)"><b>商品介绍</b></li>
							            <li onclick="selectTag(1)"><b>体验后</b></li>
							        </ul>
							    </div>
							    <div class="content-table contenter_summary blockActiveList" id="tagContent">
							        <div id="tagContent0" class="tagContent selectTag">
			                             	${(result.detail)!}
							        </div>
							        <div id="tagContent1" class="tagContent">
			                             	${(result.experienceAfter)!}
							        </div>
							    </div>
	                        	<div class="clear"></div>
                        	</div>
                        </div>
                        <div class="order-status-btn btn_hasPassed98">
                            <span class="can-send-btn">
                            	<a class="confirm-save" style="display:none;" onclick="save()">${action.getText("button.save")}</a>
                               <a class="cancel-btn" style="display:none;" onclick="cancel()">${action.getText("button.cancel")}</a>
                            </span>
                        </div>
                        </form>
                    </div>
                    <div class="clear"></div>
                </div>
 <div id="configImghidden"></div>
 <div class="layer" id="hotelshow">
	<div class="bottomBlock"></div>
    <div class="layerBox" id="hotelshowBox">
        <div class="closed"></div>
        <div class="summaryBox">
	         <img src="" id="productImgShow" />
        </div>
    </div>
    <!-- end layerBox -->
</div>           
   <script type="text/javascript" defer="defer">    
   function showProduvtImg(imgUrl){
     // $("#productImgShow").attr("src",imgUrl);
     // $("#hotelshow").show();
     // $("#hotelshowBox").show();
   }
            
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
	   // $(obj).hide();
	   // $(obj).next().find("input").val($(obj).html());
	   // $(obj).next().show();
	
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
<style type="text/css">
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