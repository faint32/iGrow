<@a.header "${action.getText('ui.manage')}">
	<script>
		//页面初始化
		$(function(){
			//初始化编辑页面
			edit(${(pager.fisrtId)!''});
			$("#productType").change(function(){
             	commonSearch();
		    });
		});
		 //查询
	     function list(){
	        $("#searchForm").attr("action","${contextPath}/admin/productshe/list.do");
	        $("#searchForm").submit();
	     }
	       //搜索
	     function commonSearch(){
	      	//设置每页第一条记录值
	     	$("#fisrtId").val('');
	     	//设置当前页码为默认页码
	     	$("#pageNumber").val('');
	     	//设置当前页面数量为默认数量
	     	$("#pageSize").val('');
	     	//设置搜索文本框的值
	     	if($("#searchBox").val() != "品名/编号/供应商"){
	     		$("#searchName").val($("#searchBox").val());
	     	}else{
	     		$("#searchName").val("");
	     	}
	     	//提交查询
	     	list();
	     }
	     //添加
	     function add(){
	        //设置每页第一条记录值
	     	$("#fisrtId").val('');
	     	//初始列表化样式
	     	$(".content-left table").find("tr").each(function(){
	     		$(this).removeClass("change_bg_tr");
	     	})
	     	var url = "${contextPath}/admin/productshe/add.do";
	        loadRightPage(url);
	     }
	     //编辑
	     function edit(id){
	        //设置每页第一条记录值
	     	$("#fisrtId").val(id);
	     	var url = "${contextPath}/admin/productshe/edit.do?id="+id+"&tmp="+Math.round(Math.random()*100000);  
	        loadRightPage(url);
	     }
	     //删除
	     function del(id,productId,preId){
	      if(confirm("确定删除？")){
		     $.ajax({    
		        type:'POST',        
		        url:'${contextPath}/admin/productshe/delete.do?id='+id+'&shelves.productId='+productId,    
		        data:null,    
		        cache:false,    
		        dataType:'json',    
		        success:function(data){ 
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
		        		tip_show('n', '删除操作失败');
						return false;
		        	}
		        }    
		     });    
		   }
	     }
	     
	     //加载页面
	     function loadRightPage(url){
	        $.ajaxSetup ({ cache: false });
	        $(".content-right").html("");
	        tip_show('w', "数据加载中...");
	     	$.ajaxSetup ({ cache: false });
	        $(".content-right").load(url,function(resTxt,status,xhr){
	        	first();
	        	if(status == "success"){
	        		setTimeout(function(){
						tip_hide_w(); 
					},300);
	        	}
			}); 
	     }
	     //选择酒店名称
	     function setHotelName(name,id){
	        $("#hotelId").val(id);
	        $("#hotelNameShow").val(name);
	        $("#hotelshow").hide();
            $("#hotelshowBox").hide();
	     }
	     //搜索酒店名称
	     function searchHotelName(){
	         var serachHotelName =  $.trim($("#serachHotelName").val());
         	 var url = "${contextPath}/admin/productshe/serachHotelName.do?hotel.name="+serachHotelName;
          	 $("#hotelshow").load(url);
	     }
	     
	     //搜索供应商名称
	     function searchSupplierName(){
	         var serachProductName = $.trim($("#serachProductName").val());
	         if(serachProductName != null && serachProductName !="" && serachProductName != "undefined" && serachProductName != "请输入供应商名称"){
        		   serachProductName = encodeURI(encodeURI(serachProductName));
       		 }else{
   		       serachProductName = "";
   		     }
       		 var url = "${contextPath}/admin/productshe/serachSupplierName.do?supplier.name="+serachProductName;
             $("#productShow").load(url);
	     }
	     
	     //选择添加商品
	     function addProducts(){
	        $("#hotelshow").hide();
            $("#hotelshowBox").hide();
		    $("#productShow").show();
		    $(".layer-content").show();
		    $("#productShowBox").hide();
	     }
	     //选择供应商商品库的商品
	     function setsupplierName(name,id){
	        $("#hotelshow").hide();
            $("#hotelshowBox").hide();
		    $("#productShow").hide();
		    $(".layer-content").hide();
		    $("#productShowBox").hide();
		    var url = "${contextPath}/admin/product/shlist.do?supplier.id="+id;
	        loadRightPage(url);
	     }
	   //新建自售商品
	   function addSellProduct(){
	        $("#hotelshow").hide();
            $("#hotelshowBox").hide();
		    $("#productShow").hide();
		    $(".layer-content").hide();
		    $("#productShowBox").hide();
		    var url = "${contextPath}/admin/productshe/add.do";
	        loadRightPage(url);
	   }
	   
	   function showErweima(name,imgSrc){
	         $("#erweimaName").html(name);
             $("#erweimaImg").attr("src",imgSrc);
             var erweimaImgStr = "${imagePath}"+imgSrc;
    		 imgSrc = encodeURI(encodeURI(imgSrc));
             $("#erweimaSave").attr("href","${contextPath}/common/download.do?attachname="+imgSrc);
             $("#erweimashow").show();
             $(".layer-content").show();
	   }  
	   
	   function erweimaClose(){
	 		 $("#erweimashow").hide();
	   }
	   
	   
	$(function(){
		$(".content-left tr").live("mouseenter", function(){
			$(this).addClass("change_bg_yelow").siblings().removeClass("change_bg_yelow");
		}).live("mouseleave", function(){
			$(this).removeClass("change_bg_yelow");
		});
	});
	
	
	function saveOrderNumEnter(id,obj,event){
	       $(obj).val($(obj).val().replace(/\D/g,''));
	       if(event.keyCode == 13){
               saveOrderNum(id,obj);
           }
	}
	
	function saveOrderNum(id,obj){
	 if($(obj).val() != $(obj).parent().attr("name")){
       if(confirm("确定要修改该商品的排列序号吗？")){    
              var obj = {
                    "shelves.id":id,
                    "shelves.orderNum":$(obj).val(),
                    "shelves.oldOrderNum":$(obj).parent().attr("name")
              };
              $.ajax({
    			url : '${contextPath}/admin/productshe/saveOrderNum.do',
    			type : 'POST',
    			async : false,
    			dataType : "json",
    			async : false,
    			data : obj,
    			success : function(data) {
    				   if(data.status == "y"){
    				       //window.location.reload();
    				       location.reload(true);
    				   }else{
    				      alert("修改失败");
    				   }
    				}
        	    });
    	  }else{
    	     $(obj).val($(obj).parent().attr("name"));
    	  } 
    	}
	}
</script>
</@a.header >
<body>
	<@a.menu />
	<div id="Contenter">
        <div class="contentBody">
           <!-- start content-left -->
            <div class="content-left">
                <div class="titleH2 font14">${action.getText("product.label")}${action.getText("label.list")}<a class="addProducts" onclick="addProducts()" ><img src="${contextPath}/css/images/white_add_icon.png">${action.getText("productshe.title")}</a></div>
                <div class="OrderTable">
                    <div class="OrderTop">
                        <form action="${contextPath}/admin/productshe/list.do" method="post" id="searchForm">
                        <select class="selct01" name="search.productType" id="productType">
                            <option value="">全部</option>
                            <#list productTypes as proType>
                              <option value="${(proType.value)!""}" <#if search.productType==proType.value>selected="selected"</#if>>${(proType.desc)!""}商品</option>
                            </#list>
                        </select>
                        <select class="selct02" name="search.searchStatus" onchange="commonSearch()">
	                            <option value="10">审核状态</option>
	                            <#list auditStatuss as auditStatus>
	                              <option value="${(auditStatus.value)!""}" <#if search.searchStatus==auditStatus.value>selected="selected"</#if>>${(auditStatus.desc)!""}</option>
	                            </#list>
	                    </select>
                        <input type="hidden" class="timeInput nobg" name="search.minPrice" value="${(search.minPrice)!}" placeholder="售价" maxlength="8" onkeyup="this.value=this.value.replace(/[^0-9.]+/,'')" onafterpaste="this.value=this.value.replace(/[^0-9.]+/,'')" onkeydown="keydownsearch(event)"/>
                        <input type="hidden" class="timeInput nobg empty13" name="search.maxPrice" value="${(search.maxPrice)!}" placeholder="售价" maxlength="8" onkeyup="this.value=this.value.replace(/[^0-9.]+/,'')" onafterpaste="this.value=this.value.replace(/[^0-9.]+/,'')" onkeydown="keydownsearch(event)"/>
                      <div class="searchOrderDiv">
                            <input type="text" class="searchBox" id="searchBox" value="${(search.name)!}" placeholder="品名/编号/供应商" style="width:129px;" onkeydown="keydownsearch(event)"/>
                            <input type="hidden" id="pageNumber" name="pager.pageNumber" value="${(pager.pageNumber)!}" />
                            <input type="hidden" id="pageSize" name="pager.pageSize" value="${(pager.pageSize)!}" />
                            <input type="hidden" id="fisrtId" name="pager.fisrtId" value="${(pager.fisrtId)!}" />
                            <input type="hidden" id="searchName" name="search.name" value="${(search.name)!}" />
                            <a class="searchOrderBtn" onclick="commonSearch();"></a>
                        </div>
                        <input type="submit" value="" style="display:none"/>
                        </form>
                    </div>
                    <@a.paginationTop />
                    <div class="OrderBottom">
                        <table width="100%" class="productSheTable">
                            <tr>
	                            <th width="10%" class="n_null_cell"></th>
                                <th width="90%">
                                	<table width="100%" class="new_no_border">
                                		<th width="20%"><span class="empty15">${action.getText("productshe.productSn")}</span></th>
		                            	<th width="30%"><span class="empty15">${action.getText("product.name")}</span></th>
		                            	<th width="15%"><span class="empty15">${action.getText("product.productType")}</span></th>
		                            	<th width="12%"><span class="empty15">状态</span></th>
		                                <th width="23%"><span class="empty15">${action.getText("label.action")}</span></th>
                                	</table>
                                </th>
                            </tr>
                            <#if (pager.results)??>
	                            <#list pager.results as obj>
	                                <#if obj_index == 0>
	                            		<#assign preId=0/>
	                            	</#if>
		                            <tr <#if obj.id == pager.fisrtId> class="change_bg_tr"</#if>>
		                            	<td class="n_null_cell" width="10%"><span class="empty5" name="${((pager.pageNumber-1)*pager.pageSize+obj_index+1)!}"><input class="new_sort" readonly="readonly" onblur="saveOrderNum(${(obj.id)!},this)" value="${((pager.pageNumber-1)*pager.pageSize+obj_index+1)!}" maxlength="5" onkeyup="saveOrderNumEnter(${(obj.id)!},this,event)" onafterpaste="this.value=this.value.replace(/\D/g,'')" /></span></td>
		                                <td width="90%">
		                                	<table width="100%" class="new_no_border">
		                                		<tr onclick="edit(${(obj.id)!}, this)">
		                                			<td width="20%"><span class="empty15 ellipsis pro_name" title="${obj.productSn}">${obj.productSn}</span></td>
					                                <td width="30%"><span class="pro_name_lname_new ellipsis empty15" title="${obj.name}">${obj.name}</span></td>
					                                <td width="15%"><span class="empty15">${(obj.productTypes.desc)!}商品</span></td>
					                                <td width="12%"><span class="empty15">${(obj.productInfo.isAudit.desc)!}</span></td>
					                                <td width="23%" class="operating"><span class="empty15">
					                                	<a class="editThis" onclick="edit(${(obj.id)!});"></a>
					                                	<a class="deleteThis" onclick="del('${(obj.id)!}','${(obj.productId)!}',${(preId)!});"></a>
					                                	<a class="two-di" <#if obj!=null&&obj.productInfo!=null&&obj.productInfo.isAudit!=null&&obj.productInfo.isAudit.value ==1 >onclick="showErweima('${obj.name}','${imagePath}${(obj.getRealScanUrl())!}')"<#else>onclick="alert('该商品还未通过审核')"</#if>></a></span>
					                                </td>
		                                		</tr>
		                                	</table>
		                                </td>
		                            </tr>
		                            <#assign preId=obj.id/>
	                            </#list>
	                        <#else>
	                        	    <tr>
		                             	<td colspan="5"><span class="empty15">${action.getText("msg.no.data")}</span></td>
		                            </tr>
	                        </#if>
                        </table>
                    </div>
                    <@a.paginationBottom />
                </div>
            </div>
            <!-- end content-left -->
            <!-- start content-right -->
            <div class="content-right">
                <!-- input -->
            </div>
            <!-- end content-right -->
            <div class="clear"></div>
        </div>
    </div>
    <!-- end Contenter -->
 <@a.footer />  
 
 <div class="layer" id="productShow">
	<div class="bottomBlock"></div>
    <div class="layer-content">
    	<div class="two-select">
    		<a class="btn_closedPage" onclick="hideproductShow()"></a>
            <div class="leftStyle form-staff-pro">
                <a class="sendMessage">从供应商选取</a>
            </div>
            <div class="rightStyle" onclick="addSellProduct()">
                <a class="toWeb">
                	新建商品<span class="tip_font">（需要审核）</span>
                </a>
            </div>
        </div>
    </div>
    <div class="layerBox" id="productShowBox">
    	<div class="content_in">
	        <h2><span>选择供应商</span>
	            <a class="btn_closedPage" onclick="hideproductShow()"></a>
	        </h2>
	        <div class="summaryBox">
				<div class="OrderTop">
	                <div class="searchOrderDiv">
	                    <input type="text" class="searchBox" id="serachProductName" placeholder="请输入供应商名称" />
	                    <a class="searchOrderBtn" onclick="searchSupplierName()"></a>
	                </div>
	                <div class="easy-search">
		                <#if supplierInfo??&&supplierInfo?exists>
		                    <#list supplierInfo as supplier>
		                        <a <#if supplier.supplierInfo??&&supplier.supplierInfo!=null&&(supplier.supplierInfo?size>0)>class="redColor"</#if>>${(supplier.name)!}</a>
		                    </#list>
		                 </#if>
	                </div>
	            </div>
	            <div class="search-out">
	            	<ul>
	                	<#if supplierInfo??&&supplierInfo?exists>
	                    <#list supplierInfo as supplier>
	                         <#if supplier.supplierInfo??&&supplier.supplierInfo!=null&&(supplier.supplierInfo?size>0)>
	 						    <li><h2>${(supplier.name)!}</h2>
			                    	<ul class="productsName-here">
			                    	  <#list supplier.supplierInfo as info>
			                    	     <li onclick="setsupplierName('${(info.name)!}','${(info.id)!}')">${(info.name)!}</li>
			                    	  </#list>
			                        </ul>
			                    </li>
	                         </#if>
	                    </#list>
	                 </#if>
	                </ul>
	            </div>
            </div>
        </div>
    </div>
    <!-- end layerBox -->
</div>

<div class="layer" id="hotelshow">
	<div class="bottomBlock"></div>
    <div class="layerBox" id="hotelshowBox">
    	<div class="content_in">
	        <h2><span>选择酒店</span>
	            <div class="closed"></div>
	        </h2>
	        <div class="summaryBox">
				<div class="OrderTop">
	                <div class="searchOrderDiv">
	                    <input type="text" class="searchBox" id="serachHotelName" placeholder="请输入酒店名称" />
	                    <a class="searchOrderBtn" onclick="searchHotelName()"></a>
	                </div>
	                <div class="easy-search">
	                 <#if hotelInfo??&&hotelInfo?exists>
	                    <#list hotelInfo as hotel>
	                        <a <#if hotel.hotelInfo??&&hotel.hotelInfo!=null&&(hotel.hotelInfo?size>0)>class="redColor"</#if>>${(hotel.name)!}</a>
	                    </#list>
	                 </#if>
	                </div>
	            </div>
	            <div class="search-out">
	            	<ul>
	            	 <#if hotelInfo??&&hotelInfo?exists>
	                    <#list hotelInfo as hotel>
	                         <#if hotel.hotelInfo??&&hotel.hotelInfo!=null&&(hotel.hotelInfo?size>0)>
	 						    <li><h2>${(hotel.name)!}</h2>
			                    	<ul class="productsName-here">
			                    	  <#list hotel.hotelInfo as info>
			                    	     <li onclick="setHotelName('${(info.name)!}','${(info.id)!}')">${(info.name)!}</li>
			                    	  </#list>
			                        </ul>
			                    </li>
	                         </#if>
	                    </#list>
	                 </#if>
	                </ul>
	            </div>
	        </div>
        </div>
    </div>
    <!-- end layerBox -->
</div>

<div class="layer" id="erweimashow">
	<div class="bottomBlock"></div>
    <div class="layer-content tip_why_this">
        <div class="why_tip">
            <h3 class="layer_title"><span id="erweimaName"></span><a class="btn_closedPage" onclick="hideCodeLNoshows()"></a></h3>
            <span class="two_di_l"><img id="erweimaImg" width="100%" height="100%"/></span>
            <div class="order-status-btn btn_centerTo">
                <span class="can-send-btn">
                	<a class="confirm-save" id="erweimaSave">保 存</a>
                    <a class="cancel-btn" onclick="erweimaClose()">关 闭</a>
                </span>
            </div>
        </div>
</div>
