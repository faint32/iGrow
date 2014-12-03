<script type="text/javascript">
    //搜索、分页
    function searchForminner(){
         var searchHotelProName = $.trim($("#searchHotelProName").val());
         if(searchHotelProName != null && searchHotelProName !="" && searchHotelProName != "undefined" && searchHotelProName != "请输入商品名称"){
    		   searchHotelProName = encodeURI(encodeURI(searchHotelProName));
   		 }else{
	       searchHotelProName = "";
	     }
        var url = "${contextPath}/admin/product/shlist.do?supplier.id="+${(supplier.id)!}+"&pager.pageNumber="+$("#pageNumberinner").val()+"&pager.pageSize="+$("#pageSizeinner").val()+"&searchHotelPro.name="+searchHotelProName+"&searchHotelPro.isAdd="+$("#hotelAddproductType").val();
        $(".content-right").load(url);
	} 
	//全选、反选
	function checkAllBox(){
	     if($("#checkAllBox").attr("checked")){
	          $(".OrderBottom").find(".partcheckbox").each(function(){
	                if($(this).parent().parent().parent().children().find(".isAddType").html()=="未添加"){
	                	$(this).attr("checked",true);
	                }
	          });
	     }else{
	          $(".OrderBottom").find(".partcheckbox").each(function(){
	                $(this).attr("checked",false);
	          });
	     }
	}
	
	//添加单个
	function addProductToHotel(id,obj,hotelCommRate,systemCommRate){
	  var add = $(obj).parent().prev().find(".empty15").html();
	  var supplierId = ${(supplier.id)!""};
	  if(add=="已添加"){
	     alert("该商品已添加,不能重复添加");
	  }else if(add=="未添加"){
	       var formParam={
	         "shelves.productId":id,
	         "supplier.id":supplierId,
	         "form.defHotelCommRate":hotelCommRate,
	         "form.defSysCommRate":systemCommRate
	       };
	        tip_show('w', "添加中,请稍后...");
	       	$.ajax({    
	                  type:'POST',        
	                  url:'${contextPath}/admin/productshe/addProduct.do',    
	                  data:formParam,    
	                  cache:false,    
	                  dataType:'json',
	                  type:'post',    
	                  success:function(data){ 
	                  	  if(data.flag){
	                  	      tip_show(0, "添加成功");
								  setTimeout(function(){
										tip_hide_w();
								  },1000);
	                  	       $(obj).parent().prev().find(".empty15").html("已添加");
	                  	    // $(".productSheTable tr:eq(1)").before("<tr><td><span class='empty15'>"+data.obj.productSn+"</span></td><td><span class='empty15'>"+data.obj.name+"</span></td><td><span class='empty15'>代售商品</span></td><td class='operating'><span class='empty15 removeSeeThis'><a class='editThis' onclick='edit("+data.obj.id+");'></a><a class='deleteThis' onclick='del("+data.obj.id+","+data.obj.productId+");'></a><a class='two-di' href='${imagePath}"+data.obj.scanUrl+"' target='blank'></a></span></td></tr>");
	                  	       $(".content-left").load("${contextPath}/admin/productsheimage/listo.do");
	                  	       $(obj).parent().parent().children().find(".partcheckbox").attr("checked",false); 
				               $(obj).parent().parent().children().find(".partcheckbox").attr("disabled",true); 
	                  	  }else{
	                  	      tip_show(0, "添加失败");
								  setTimeout(function(){
										tip_hide_w();
								  },1000);
	                  	  }
	                  }    
	            });
	 }
	}
	//添加多个
	function addMoreProductToHotel(){
	  var addMoreProduct = $("#addMoreProduct").val();
	  if(addMoreProduct == 1){
	     $("#addMoreProduct").val(0);
	     var supplierId = ${(supplier.id)!""};
	     var flag = false;  
	     var ids =new Array();
	     var hotelCommRates = new Array();
	     var systemCommRates = new Array();
         $(".OrderBottom").find(".partcheckbox").each(function(){
                if($(this).attr("checked")){
                	flag = true;
                	ids.push($(this).attr("name"));  
                	hotelCommRates.push($(this).parent().parent().parent().children().find(".productHotelCommRate").html());  
                	systemCommRates.push($(this).parent().parent().parent().children().find(".productSystemCommRate").html());  
                }
         });
         
         if(!flag){
             alert("请选择要添加的商品");
         }else{ 
           var formParam={
	         "pids":ids.join(","),
	         "supplier.id":supplierId,
	         "defHotelCommRates":hotelCommRates.join(","),
	         "defSystemCommRates":systemCommRates.join(",")
	       };
	        tip_show('w', "添加中,请稍后...");
	       	$.ajax({    
	                  type:'POST',        
	                  url:'${contextPath}/admin/productshe/addAllProduct.do',    
	                  data:formParam,    
	                  cache:false,    
	                  dataType:'json',
	                  type:'post',    
	                  success:function(data){ 
	                  	  if(data.flag){
	                  	     tip_show(0, "添加成功");
								  setTimeout(function(){
										tip_hide_w();
								  },1000);
	                  	     $(".content-left").load("${contextPath}/admin/productsheimage/listo.do");
	                  	     $("#addMoreProduct").val(1);
							 $(".OrderBottom").find(".partcheckbox").each(function(){
				                if($(this).attr("checked")){
				                	$(this).attr("checked",false); 
				                	$(this).attr("disabled",true); 
				                	$(this).parent().parent().parent().children().find(".isAddType").html("已添加")
				                }
							 });
	                  	     
	                  	  }else{
	                  	     tip_show(0, "添加失败");
	                  	     $("#addMoreProduct").val(1);
								  setTimeout(function(){
										tip_hide_w();
								  },1000);
	                  	  }
	                  }    
	            });
	       }
	    }
	}
</script>
                <div class="titleH2 font14">${(supplier.name)!""}</div>
                <div class="OrderTable">
                    <div class="OrderTop">
                        <form action="" method="post" id="searchForm">
                            <select class="selct02" id="hotelAddproductType">
                                <option value="">全部</option>
                                <option value="1" <#if searchHotelPro.isAdd == 1>selected="selected"</#if> >已添加</option>
                                <option value="0" <#if searchHotelPro.isAdd == 0>selected="selected"</#if>>未添加</option>
                            </select>
                            <div class="searchOrderDiv">
                                <input type="text" class="searchBox" id="searchHotelProName" placeholder="请输入商品名称" value="${searchHotelPro.name}"/>
                                <input type="hidden" id="pageNumberinner" name="pager.pageNumber" value="1" />
                                <input type="hidden" id="pageSizeinner" name="pager.pageSize" value="${(pager.pageSize)!}" />
                                <a class="searchOrderBtn" onclick="searchForminner();"></a>
                            </div>
                            <input type="submit" value="" style="display:none"/>
                            <div class="clear"></div>
                        </form>
                    </div>
                    <div class="select_all_andAdd">
                    	<input type="checkbox" id="checkAllBox" onclick="checkAllBox()"><label>全选</label><a class="addProducts add_new_pro" onclick="addMoreProductToHotel()"><img src="${contextPath}/css/images/white_add_icon.png">添加</a>
                        <input type="hidden"  id="addMoreProduct" value="1"/>
                    </div>
                    <div class="OrderBottom">
                        <table width="760">
                        <tr>
                            	<th width="42"></th>
                                <th width="173"><span class="empty15">商品图片</span></th>
                                <th width="158"><span class="empty15">商品名称</span></th>
                                <th width="115"><span class="empty15">售价</span></th>
                                <th width="81"><span class="empty15">佣金</span></th>
                                <th width="91"><span class="empty15">状态</span></th>
                                <th width="100"><span class="empty15">操作</span></th>
                        </tr>
                        <#if (pager.results)??>
                            <#list pager.results as obj>
	                           <tr>
	                            	<td><span class="empty15"><input type="checkbox" <#if obj.isAdd != null && obj.isAdd == 1>disabled="true"<#else></#if> class="partcheckbox" name="${(obj.id)!"0"}"></span></td>
	                                <td><span class="empty15"><span class="put_img_area"><img src="${imagePath}${(obj.getRealImgUrl())!""}" width="143" height="92"></span></span></td>
	                                <td title="${(obj.name)!""}"><a href="#" target="_blank"><span class="pro_name ellipsis empty15">${(obj.name)!""}</span></a></td>
	                                <td><span class="empty15">${(obj.productPrice)!0}</span></td>
	                                <td><span class="empty15"><#if obj!=null && obj.hotelCommRate != null && obj.hotelCommRate != 0>${(obj.productPriceFirst*obj.hotelCommRate/100)!"0"}元</br>(${(obj.hotelCommRate)!0}%)<#else>${(obj.productPriceFirst*obj.defHotelCommRate/100)!"0"}元</br>(${(obj.defHotelCommRate)!0}%)</#if></span></td>
	                                <td><span class="empty15 isAddType"><#if obj.isAdd != null && obj.isAdd == 1>已添加<#else>未添加</#if></span></td>
	                                <td class="operating"><span class="empty15 removeSeeThis" <#if obj.isAdd != null && obj.isAdd == 1>onclick="addProductToHotel(${(obj.id)!""},this,<#if obj.hotelCommRate != null && obj.hotelCommRate != 0>${(obj.hotelCommRate)!0}<#else>${(obj.defHotelCommRate)!0}</#if>,<#if obj.sysCommRate != null && obj.sysCommRate != 0>${(obj.sysCommRate)!0}<#else>${(obj.defSysCommRate)!0}</#if>)"<#else>onclick="addProductToHotel(${(obj.id)!""},this,${(obj.defHotelCommRate)!0},${(obj.defSysCommRate)!0})"</#if>><a class="add_pro_btn width30">添加</a></span></td>
	                                <td style="display:none;"><span class="productHotelCommRate"><#if obj.hotelCommRate != null && obj.hotelCommRate != 0>${(obj.hotelCommRate)!0}<#else>${(obj.defHotelCommRate)!0}</#if></span><td>
	                                <td style="display:none;"><span class="productSystemCommRate"><#if obj.sysCommRate != null && obj.sysCommRate != 0>${(obj.sysCommRate)!0}<#else>${(obj.defSysCommRate)!0}</#if></span><td>
	                          </tr>
                            </#list>
                            <#else>
	                        	    <tr>
		                             	<td colspan="7"><span class="empty15">${action.getText("msg.no.data")}</span></td>
		                            </tr>
	                        </#if>
                        </table>
                    </div>
                    <@a.paginationBottominner />
            </div>
            <!-- end content-right -->
            <div class="clear"></div>
 
