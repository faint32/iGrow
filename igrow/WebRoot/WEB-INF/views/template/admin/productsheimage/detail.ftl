 <script src="${contextPath}/js/jquery-1.7.2.min.js"></script>
 <script src="${contextPath}/js/Validform_v5.3.2.js"></script>
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
     if($("#specName").val() != ""){
     	 $(t).parent().find("span").html($("#specName").val());
     }else{
     	 $("#specName").val($(t).parent().find("span").html());
     }
     $(t).parent().find("span").show();
  }
  function editProperty(t){
     $("#propertyName").prev().hide();
     $("#propertyName").show();
     $("#propertyName").select();
  }
  function recodeProName(t){
     $("#propertyName").hide();
     if($("#propertyName").val() != ""){
     	  $(t).parent().find("span").html($("#propertyName").val());
     }else{
     	 $("#propertyName").val($(t).parent().find("span").html());
     }
     $(t).parent().find("span").show();
  }
  	 
function save(){
	      $(document.getElementsByTagName("iframe")[0].contentWindow.document.body).find("img").each(function(){
                 if($.trim($(this).attr("data-cke-saved-src").substring(0,10)) == "data:image"){
                       $(this).attr("data-cke-saved-src","");
                 }else if($.trim($(this).attr("src").substring(0,10)) == "data:image"){
                       $(this).attr("src","");
                 }   
           });
		   setTimeout("saveOther()",1000);
	}    	 
	     
	     
 //保存或者更新
 function saveOther(){
    $(document.getElementsByTagName("iframe")[0].contentWindow.document.body).find("img").css({"width":"100%", "height":"auto"})
          $(document.getElementsByTagName("iframe")[0].contentWindow.document.body).find("img").each(function(){
                 if($.trim($(this).attr("data-cke-saved-src").substring(0,10)) == "data:image"){
                       $(this).attr("data-cke-saved-src","");
                 }else if($.trim($(this).attr("src").substring(0,10)) == "data:image"){
                       $(this).attr("src","");
                 }   
           });
           
    var content2=$(document.getElementsByTagName("iframe")[0].contentWindow.document.body).html();
    $("#editor1").val(content2);
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
        alert("请填写佣金比例");
        return;
    }
    
    if($("#productImg").val() == ""){
       alert("请上传默认图片!");
       return;
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
      var marketPriceFlag = true;
      var marketPriceobj;
      $(".outTable").find(".pmarketPrice").each(function(index) {
             if($(this).val() != ""){
                marketPrices.push($(this).val());
             }else{
                marketPrices.push(0);
                marketPriceFlag = false;
                marketPriceobj = this;
                return false;
             }
      }); 
      if(!marketPriceFlag){
          alert("市场价格不能为空!");
          $(marketPriceobj).focus();
          return;
      }
      var productPriceFlag = true;
      var productPriceobj;
      $(".outTable").find(".pproductPrice").each(function(index) {
              if($(this).val() != ""){
                productPrices.push($(this).val());
             }else{
                productPrices.push(0);
                productPriceFlag = false;
                productPriceobj = this;
                return false;
             }
      }); 
      if(!productPriceFlag){
          alert("销售价格不能为空!");
          $(productPriceobj).focus();
          return;
      }
      $(".outTable").find(".ptotalStock").each(function(index) {
              if($(this).val() != ""){
                totalStocks.push($(this).val());
             }else{
                totalStocks.push(0);
             }
      }); 
      var formId = "${(result.id)!}";
      if(formId == ""){
	      var addStocksFlag = true;
	      var addStocksobj;
	      $(".outTable").find(".paddStock").each(function(index) {
	              if($(this).val() != ""){
	                addStocks.push($(this).val());
	             }else{
	                addStocks.push(0);
	                addStocksFlag = false;
	                addStocksobj = this;
	                return false;
	             }
	      }); 
	  }else{
	   	  $(".outTable").find(".paddStock").each(function(index) {
	              if($(this).val() != ""){
	                addStocks.push($(this).val());
	             }else{
	                addStocks.push(0);
	             }
	      }); 
	  }
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
     // $("#hotelshows").show();
     // $("#hotelshowBoxs").show();
   }
   
  function checkPlatPrice(obj){
      $(obj).val($(obj).val().replace(/[^0-9.]+/,''));
      if(parseInt($(obj).val().replace(/[^0-9.]+/,''))>10000 || parseInt($(obj).val().replace(/[^0-9.]+/,''))<0){
        $(obj).val(0);
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
 
 
 
 function loadimage(productImg,imageSrcshow){
      var imgSrc = $("#"+imageSrcshow+"").attr("src");
      if(typeof(imgSrc) == "undefined"){
           imgSrc = "../../css/images/no_pic.png";
      }
      var href = "${contextPath}/common/image.do?imageIdshow="+productImg+"&imgSrc="+imgSrc+"&imageSrcshow="+imageSrcshow;
      $(".content-right").hide();
      $("#imageload").show();
      $("#imageload").load(href);
 }
</script>

<!--
<#if result?? && result.productInfo?? && result.productInfo.productSpec?exists && result.productInfo.productSpec??>
     <#assign configIndex = 0 >  
     <#list result.productInfo.productSpec as productSpec>
         <#if productSpec.productConfigInfo?exists && productSpec.productConfigInfo??>
             <#list productSpec.productConfigInfo as productConfigInfo>
               <#assign configIndex=configIndex+1> 
               <@i.uploadImg true,'productConfigImg','${configIndex}'/>
            </#list>
        </#if>
     </#list>
</#if>
-->

<div class="titleH2 font14">${action.getText("product.label")}${action.getText("label.detail")}</div>
      <div class="tip_save_success"><img src="${contextPath}/css/images/tip_save_success.png" width="46" height="60"><span class="tip_font_save"><span class="font16"><b>保存成功!</b></span><cite>请耐心等待审核</cite></span></div>
	  <div class="not_approved">
	        <p class="tip_approved"><img src="${contextPath}/css/images/not_approved.png" width="35" height="36"><b class="font16">未通过审核</b></p>
	        <p class="why_approved">原因：${(result.productInfo.auditReason)!}</p>
	  </div>
	  <div class="OrderTable">
				    <form id="saveForm" method="post" action="${contextPath}/admin/productsheimage/<#if isAddAction>save<#else><#if result??>update<#else>save</#if></#if>.do" enctype="multipart/form-data">
				    <input type="hidden" name="shelves.id" value="${(result.id)!}" id="serachId" />
				    <input type="hidden" name="shelves.isDelete" value="0" />
				    <input type="hidden" id="formId"  name="form.id" value="${(result.productInfo.id)!}" />
				    <input type="hidden" name="form.productSn" value="${(result.productInfo.productSn)!}" />
				    <input type="hidden" id="formOldName" value="${(result.name)!}" />
					<input type="hidden" id="formNameSpanError" value="0" />
					<input type="hidden" name="shelves.orderSort" value="${(result.orderSort)!}" />
					<input type="hidden" name="shelves.productSn" value="${(result.productSn)!}" />
                	<div class="products-vesting">
                    	<ul>
                        	<li style="display:none;"><label class="fixed-width">${action.getText("product.hotelName")}</label><span><input type="text" class="hotelInput"  onclick="selectHotel()" readonly="readonly"  style="width:400px;"  value="${(result.hotelName)!}" id="hotelNameShow"/><input type="hidden" id="hotelId" value="${(result.hotelId)!}" name="shelves.hotelId"/></span></li>
                            <li><label class="fixed-width">${action.getText("product.productTypeName")}</label><#if result??>${(result.productTypes.desc)!}<#else>自售</#if>商品</span></li>
                            <li class="lineHeight34"><label class="fixed-width">${action.getText("product.name")}</label><span><input type="text" class="hotelInput" name="form.name" style="width:300px;" value="${(result.name)!}" datatype="*1-50" id="resultName"/></span><span id="resultNameSpan" class="resultNameSpan Validform_checktip"></span></li>
                            <li><label class="fixed-width">${action.getText("product.deliveryModes")}</label><span>
                            	<ul class="checkboxChange">
                            	 <#list deliveryTypes as deliveryType>
                            	 	 <#assign flag=false/>
                            	 	 <#if result??&&result?exists&&(result.deliveryMode)??&&(result.deliveryMode)?exists>
                            	 	 	<#list result.deliveryMode as d><#if d.value==deliveryType.value><#assign flag=true/><#break/></#if></#list>
                                     </#if>
                                     <li><input type="checkbox" title="${(deliveryType.value)!""}" <#if flag>checked="checked" </#if>class="checkbox" />${(deliveryType.desc)!""}</li>
                                 </#list>
                                </ul>
                                </span>
                                <input type="hidden" name="shelves.deliveryModes" id="deliveryModesStr" style="display:none;"/>
                            </li>
                            <li class="lineHeight34"><label class="fixed-width">佣金比例</label><span><input type="text" class="hotelInput shortInput" name="form.defSysCommRate" value="${(result.productInfo.defSysCommRate)!0}" id="PdefSysCommRate" maxlength="10" onkeyup="checkPlatPrice(this)" onafterpaste="this.value=this.value.replace(/[^0-9.]+/,'')"/><i class="empty6">%</i></span><label class="tip_commission">*平台收取佣金</label></li>
                            <li class="updateImgWeb"><label class="fixed-width">${action.getText("product.image")}</label>
                            <a class="file_update_area" onclick="loadimage('productImg','imageSrcshow')">
                            	 
                            </a>
                             <input type="hidden" id="productImg" name="form.imageUrl" value="${(result.productInfo.imageUrl)!}" style="display:none;"/></li>
                             <#if result !=null && result.id != null && result.productInfo?? && result.productInfo != null && result.productInfo.imageUrl !=null>
                             <li id="imageSrcDiv">
                             	<label class="fixed-width"></label><span class="reviewPic"><img id="imageSrcshow"  src="${imagePath}${(result.productInfo.imageUrl)!}"></span>
                             </li>
                             <#else> 
                             <li id="imageSrcDiv" style="display:none;">
                             	<label class="fixed-width"></label><span class="reviewPic"><img id="imageSrcshow"></span>
                             </li>
                             </#if>
                            <#if result!=null&&result.productInfo!=null&&result.productInfo.isAudit!=null&&result.productInfo.isAudit.value ==1> 
                            <li><label class="fixed-width"></label><span><a href="${imagePath}${(result.getRealScanUrl())!}" target="blank">查看扫描二维码</a></span>&nbsp;&nbsp;<span><a href="${contextPath}/common/download.do?attachname=${imagePath}${(result.getRealScanUrl())!}">下载扫描二维码</a></span>&nbsp;&nbsp;<span><a href="${imagePath}${(result.getRealShareUrl())!}" target="blank">查看分享二维码</a></span>&nbsp;&nbsp;<span><a href="${contextPath}/common/download.do?attachname=${imagePath}${(result.getRealShareUrl())!}">下载分享二维码</a></span></li>
                            </#if>
                        </ul>
                    </div>
                    <div class="OrderBottom">
                        <table width="760" class="blockTableBottom specMameTable" cellpadding="0" cellspacing="0">
                            <tr>
                            	<th width="95"></th>
								<th width="290">
									<span class="empty15"><span>${(result.productInfo.specName)!'商品规格'}</span><input id="specName" name="form.specName" value="${(result.productInfo.specName)!'商品规格'}" maxlength="20" onblur="recodeSpecName(this)" style="display:none;"/></span>
								</th>
								<th width="217">
								<span class="empty15"><a onclick="editSpec(this)">编辑</a></span>
								</th>
                            </tr>
                            <#if result?? && result.productInfo?? && result.productInfo.productSpec?exists && result.productInfo.productSpec??>
                                <#list result.productInfo.productSpec as productSpec>
                                 <tr>
	                                <td width="95" class="Nunb"><span class="empty15">${(productSpec_index+1)!}</span></td>
	                                <td width="290"><span class="empty15"><span class="text-put-here" onclick="editProductProperty(this)" name="${(productSpec.id)!}">${(productSpec.value)!}</span><span style="display:none;"><input type="text" onblur="saveProductProperty(this,2)" maxlength="20"/></span></span></td>
	                                <td width="217"><span class="empty15"><a class="toUp" onclick="move_up(this)">上移</a><a class="deleteThisCole" onclick="deletetetee(obj)" name="1">删除</a></span></td>
                                  </tr>
                               </#list>
                            </#if>
                            <tr>
                                <td  width="95" class="Nunb"><span class="empty15"><#if result?? && result.productInfo?? && result.productInfo.productSpec?exists && result.productInfo.productSpec??>${(result.productInfo.productSpec?size+1)!}<#else>1</#if></span></td>
                                <td width="290"><span class="empty15"><span class="text-put-here"  onclick="editProductProperty(this)"  name="0"></span><span style="display:none;"><input type="text" onblur="saveProductProperty(this,2)" maxlength="20"/></span><span class="fillNameinput"><input type="text" placeholder="请输入商品规格名称" class="fillName" maxlength="20" /></span></span></td>
                                <td  width="217" class="show-two-btn"><span class="empty15"><a class="addTd" name="1" onclick="add_tr(this)">添加</a><a class="toUp">上移</a></span></td>
                            </tr>
                        </table>
                        <table width="760" class="blockTableBottom proMameTable" cellpadding="0" cellspacing="0">
                            <tr>
                            	<th width="95"></th>
								<th width="290">
									<span class="empty15"><span>${(result.productInfo.proMame)!'其他属性'}</span><input id="propertyName" name="form.proMame" value="${(result.productInfo.proMame)!'其他属性'}" maxlength="20" onblur="recodeProName(this)" style="display:none;"/></span>
								</th>
								<th width="217">
								<span class="empty15"><a onclick="editProperty(this)">编辑</a></span>
								</th>
                            </tr>
                            <#if result?? && result.productInfo?? && result.productInfo.productProperty?exists && result.productInfo.productProperty??>
                                <#list result.productInfo.productProperty as productProperty>
                                 <tr>
	                                <td width="95" class="Nunb"><span class="empty15">${(productProperty_index+1)!}</span></td>
	                                <td width="290"><span class="empty15"><span class="text-put-here" onclick="editProductProperty(this)" name="${(productProperty.id)!}">${(productProperty.value)!}</span><span style="display:none;"><input type="text" onblur="saveProductProperty(this,1)" maxlength="20"/></span></span></td>
	                                <td width="217"><span class="empty15"><a class="toUp" onclick="move_up(this)">上移</a><a class="deleteThisCole" name="2">删除</a></span></td>
                                  </tr>
                               </#list>
                            </#if>
                            <tr>
                                <td width="95" class="Nunb"><span class="empty15"><#if result?? && result.productInfo?? && result.productInfo.productProperty?exists && result.productInfo.productProperty??>${(result.productInfo.productProperty?size+1)!}<#else>1</#if></span></td>
                                <td width="290"><span class="empty15"><span class="text-put-here" onclick="editProductProperty(this)" name="0"></span><span style="display:none;"><input type="text" onblur="saveProductProperty(this,1)" maxlength="20"/></span><span class="fillNameinput"><input type="text" placeholder="请输入商品属性名称" class="fillName"  maxlength="20"/></span></span></td>
                                <td width="217" class="show-two-btn"><span class="empty15"><a class="addTd" name="2" onclick="add_tr(this)">添加</a><a class="toUp" onclick="move_up(this)">上移</a></span></td>
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
			                                <th width="158"><span class="empty15">商品图片</span></th>
			                                <th width="125"><span class="empty15">${action.getText("label.action")}</span></th>
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
										    <td width="76"><span class="empty15"><input type="text" style="width:50px;" value="${(productConfigInfo.marketPrice)!}" maxlength="8" class="pmarketPrice"  onkeyup="clearNoNum(this)"/></span></td>
										    <td width="76"><span class="empty15"><input type="text" style="width:50px;" value="${(productConfigInfo.productPrice)!}" maxlength="8" class="pproductPrice"  onkeyup="clearNoNum(this)"/></span></td> 
										    <td width="76"><span class="empty15">${(productConfigInfo.totalStock-productConfigInfo.lockedStock)!0}<input type="hidden" style="width:50px;" value="${(productConfigInfo.totalStock)!}" maxlength="8" class="ptotalStock" <#if result.id != null>readonly="readonly"</#if> onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/></span></td> 
										    <td width="76"><span class="empty15"><input type="text" style="width:50px;" value="" maxlength="8"  class="paddStock" onkeyup="this.value=this.value.replace(/[^0-9-]+/,'')" onafterpaste="this.value=this.value.replace(/[^0-9-]+/,'')" onblur="addkucun(this)"/></span></td> 
										    <td width="158"><span class="empty15"><img id="productConfigImg${configIndex}" <#if productConfigInfo != null && productConfigInfo.imageUrl != null>src="${imagePath}${(productConfigInfo.imageUrl)!}" <#else> src="${contextPath}/css/images/no_pic.png"</#if> width="143" height="92"></span></td>
						                    <td width="125"><span class="empty15"><a class="file_update_area" onclick="loadimage('pimgUrls${configIndex}','productConfigImg${configIndex}')">
						                    <div class="updateLayer_pro">  </div>
						                    </a>
						                    <span>
	                       		            <input type="hidden" class="pimgUrls" id="pimgUrls${configIndex}" value="${(productConfigInfo.imageUrl)!}"/>
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
						<ul class="products-vesting"  style="display:none;">
                        <li><label class="fixed-width">商品url</label><span><input type="text" id="formContent" name="form.content" style="width:500px;" readonly="readonly" value="${(result.productInfo.content)!}" maxlength="50"/></span><span class="formContentSpan Validform_checktip"></span></li>
                        </ul>
                        <div class="textEditArea blockTableBottom25">
                        	<div class="pro_title_top">
	                        	<b>商品介绍</b>
	                        	<div class="blockActiveList">
		                        	<textarea cols="80" id="editor1" name="form.detail"  rows="10">
		                             ${(result.productInfo.detail)!}
		                            </textarea>
	                            </div>
	                            <div class="clear"></div>
                        	</div>
                            <script>
								CKEDITOR.replace( 'editor1' );
								$(function(){
									setTimeout("delay5()", 500);
								});
								function delay5(){
									$("#cke_1_path").html("");
								}
							</script>
                        </div>
                        <div class="order-status-btn btn_hasPassed98">
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
	    $(obj).hide();
	    $(obj).next().find("input").val($(obj).html());
	    $(obj).next().show();
	
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
