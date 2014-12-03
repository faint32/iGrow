<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>${action.getText("ui.title")}-后台管理</title>
    <link href="${contextPath}/css/masterPage.css" rel="stylesheet" />
    <link href="${contextPath}/css/commodity.css" rel="stylesheet" />
    <link href="${contextPath}/css/settlement.css" rel="stylesheet" /> 
    <link href="${contextPath}/css/orderManag.css" rel="stylesheet" />
    <link href="${contextPath}/css/hotelManag.css" rel="stylesheet" />
    <link href="${contextPath}/css/sample.css"  rel="stylesheet">
    <link href="${contextPath}/css/style.css" rel="stylesheet" />
    <link href="${contextPath}/css/alertLayer.css" rel="stylesheet" />
    <script src="${contextPath}/js/jquery-1.7.2.min.js"></script>
    <script src="${contextPath}/js/j_page01.js"></script>
    <script src="${contextPath}/js/ckeditor/ckeditor.js"></script>
    <script src="${contextPath}/js/Validform_v5.3.2.js"></script>
    <script src="${contextPath}/js/passwordStrength-min.js"></script>
    <script src="${contextPath}/js/alertLayer.js"></script>
    <script src="${contextPath}/js/nowTime.js"></script>
    <script src="${contextPath}/js/common.js"></script>
    <script src="${contextPath}/js/password.js"></script>
    <script src="${contextPath}/common/My97DatePicker/WdatePicker.js"></script>
    <script src="${contextPath}/js/Placeholders.js"></script>
    <link href="${contextPath}/favicon.ico" rel="shortcut icon" type="image/x-icon" />
    <script>
    function showErweimah(name,imgSrc){
             $("#erweimaNames").html(name);
             $("#erweimaImgs").attr("src",imgSrc);
             var erweimaImgStr = "${imagePath}"+imgSrc;
             imgSrc = encodeURI(encodeURI(imgSrc));
             $("#erweimaSaves").attr("href","${contextPath}/common/download.do?attachname="+imgSrc);
             $("#erweimashows").show();
             $(".layer-content").show();
             
	        
	  }  
  	function erweimaCloseh(){
	 		 $("#erweimashows").hide();
	  }
	 function switching(){
	 	$("#switching").show();
	  	$(".layerBox").show();
	 }
	 function hide_switch(){
	 	$("#switching").hide();
	 }
	  
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
	        $("#searchForm").attr("action","${contextPath}/admin/productsheimage/list.do");
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
	     	var url = "${contextPath}/admin/productsheimage/add.do";
	        loadRightPage(url);
	        $(".content-right").show();
      		$("#imageload").html("").hide();
	     }
	     //编辑
	     function edit(id, a){
	        //设置每页第一条记录值
	     	$("#fisrtId").val(id);
	     	var url = "${contextPath}/admin/productsheimage/edit.do?id="+id+"&tmp="+Math.round(Math.random()*100000);  
	        loadRightPage(url);
	        $(a).parent().parent().parent().parent().addClass("change_bg_tr").siblings().removeClass("change_bg_tr");
	        $(".content-right").show();
      		$("#imageload").html("").hide();
	     }
	     //删除
	     function del(id,productId,preId){
	      if(confirm("确定删除？")){
		     $.ajax({    
		        type:'POST',        
		        url:'${contextPath}/admin/productsheimage/delete.do?id='+id+'&shelves.productId='+productId,    
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
							if($("#pagerTotalCount").html() == 0 && url.indexOf("shlist") < 0 ){
					            $(".content-right .OrderTable").html("<div class='noData'><p>暂无商品</p></div>");
					        }
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
         	 var url = "${contextPath}/admin/productsheimage/serachHotelName.do?hotel.name="+serachHotelName;
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
       		 var url = "${contextPath}/admin/productsheimage/serachSupplierName.do?supplier.name="+serachProductName;
             $("#productShow").load(url);
	     }
	     
	     //选择添加商品
	     function addProducts(){
	  	    $(".content-right").show();
     	    $("#imageload").hide();
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
		    var url = "${contextPath}/admin/productsheimage/add.do";
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
	   function btn_click_sort(){
	   		$(".n_null_cell").css("display","table-cell");
	   		$(".new_sort").css("border","1px solid #ccc");
	   }
	</script>
 
<script>
	$(function(){
		$(".operating a").live("click", function(){
		$(this).parent().parent().parent().parent().parent().parent().parent().addClass("change_bg_tr").siblings().removeClass("change_bg_tr");
	});
	$(".content-left tr").live("mouseenter", function(){
		$(this).addClass("change_bg_yelow").siblings().removeClass("change_bg_yelow");
	}).live("mouseleave", function(){
		$(this).removeClass("change_bg_yelow");
	});
	});
	
	var flag = true;
	function saveOrderNumEnter(id,obj,event){
	       $(obj).val($(obj).val().replace(/\D/g,''));
	       if(event.keyCode == 13){
                saveOrderNum(id,obj);
           }
	}
	
	function saveOrderNum(id,obj){
	 if($(obj).val() != $(obj).parent().attr("name") && flag){
	   flag = false;
       if(confirm("确定要修改该商品的排列序号吗？")){    
              var obj = {
                    "shelves.id":id,
                    "shelves.orderNum":$(obj).val(),
                    "shelves.oldOrderNum":$(obj).parent().attr("name")
              };
              $.ajax({
    			url : '${contextPath}/admin/productsheimage/saveOrderNum.do',
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
	
	 //上下架
 	   function productStatue(obj,id){
 	   		var status = $(obj).attr("name");
            var comstr;
	        if(status == 0){
	           comstr = "您确定要下架该商品吗？";
	        }else{
	           comstr = "您确定要上架该商品吗？";
	        }    
	      if(confirm(comstr)){
	          $.ajax({    
		        type:'POST',        
		        url:'${contextPath}/admin/productshe/pullon.do?form.id='+id+'&form.status='+status,    
		        data:null,    
		        cache:false,    
		        dataType:'json',    
		        success:function(data){ 
	        		if(data.status=="y"){
		        		 tip_show(data.status, data.info);
		        		 if(status == 0){
		        		     $(obj).removeClass("undercarriage noSeeThisIcon").addClass("grounding");
		        		     $(obj).attr('title','商品上架');
		        		     $(obj).attr('name','1');
		        		     $(obj).parent().parent().prev().find(".empty15").html("已下架");
		        		 }else{
		        		     $(obj).removeClass("grounding seeThisLine").addClass("undercarriage noSeeThisIcon");
		        		     $(obj).attr('title','商品下架');
		        		     $(obj).attr('name','0');
		        		     $(obj).parent().parent().prev().find(".empty15").html("在售");
		        		 }
		        	}else if(data.status=="n"){
		        		tip_show(data.status, data.info);
		        		return false;
		        	}else{
		        		tip_show('n', '操作失败');
						return false;
		        	}
		        }    
		     });
	      }
	   }
	   
</script>
</head>
<body>
	<@a.menu />
	<div id="Contenter">
        <div class="contentBody">
           <!-- start content-left -->
            <div class="content-left">
                <div class="titleH2 font14"><label class="n_left_font54">${action.getText("product.label")}${action.getText("label.list")}</label>
                <div class="btn_add_area">
                	<a class="addProducts btn_new_bg marginR113 paddingR13" onclick="btn_click_sort()">排序</a>
                </div>
                <a class="addProducts" onclick="addProducts()" ><img src="${contextPath}/css/images/white_add_icon.png">${action.getText("productshe.title")}</a></div>
                <div class="OrderTable">
                    <div class="OrderTop">
                        <form action="${contextPath}/admin/productsheimage/list.do" method="post" id="searchForm">
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
                            	<th width="5%" class="n_null_cell"></th>
                                <th width="95%">
                                	<table width="100%" class="new_no_border">
                                		<tr>
                                			<th width="23%"><span class="empty15">${action.getText("productshe.productSn")}</span></th>
			                            	<th width="25%"><span class="empty15">${action.getText("product.name")}</span></th>
			                            	<th width="12%"><span class="empty15">${action.getText("product.productType")}</span></th>
			                            	<th width="12%"><span class="empty15">状态</span></th>
			                                <th width="28%"><span class="empty15">${action.getText("label.action")}</span></th>
                                		</tr>
                                	</table>
                                </th>
                            </tr>
                            <#if (pager.results)??>
	                            <#list pager.results as obj>
	                                <#if obj_index == 0>
	                            		<#assign preId=0/>
	                            	</#if>
		                            <tr <#if obj.id == pager.fisrtId> class="change_bg_tr"</#if>>
		                            	<td class="n_null_cell" width="5%"><span class="empty5" name="${((pager.pageNumber-1)*pager.pageSize+obj_index+1)!}"><input class="new_sort" onblur="saveOrderNum(${(obj.id)!},this)" value="${((pager.pageNumber-1)*pager.pageSize+obj_index+1)!}" maxlength="5" onkeyup="saveOrderNumEnter(${(obj.id)!},this,event)" onafterpaste="this.value=this.value.replace(/\D/g,'')" /></span></td>
		                                <td width="95%">
		                                	<table width="100%" class="new_no_border">
		                                		<tr onclick="edit(${(obj.id)!}, this)">
		                                			<td width="23%"><span class="empty15 ellipsis pro_name" title="${obj.productSn}">${obj.productSn}</span></td>
					                                <td width="25%"><span class="pro_name_lname_new ellipsis empty15" title="${obj.name}">${obj.name}</span></td>
					                                <td width="12%"><span class="empty15">${(obj.productTypes.desc)!}</span></td>
					                                <td width="12%"><span class="empty15"><#if obj.status == 0>已下架<#else>${(obj.productInfo.isAudit.desc)!}</#if><#if obj.isAuditFlag == 1>(待审)</#if></span></td>
					                                <td width="28%" class="operating"><span class="empty15">
					                                	<a class="editThis" onclick="edit(${(obj.id)!});"></a>
					                                	<a class="deleteThis" onclick="del('${(obj.id)!}','${(obj.productId)!}',${(preId)!});"></a>
					                                	<a class="two-di" <#if obj != null && obj.productInfo != null && obj.productInfo.isAudit != null && (obj.productInfo.isAudit.value ==1 || obj.productInfo.isAudit.value == 3)>onclick="showErweima('${obj.name}','${imagePath}${(obj.getRealScanUrl())!}')"<#else>onclick="alert('该商品还未通过审核')"</#if>></a>
					                                	<#if obj.status == 0 || obj.productInfo.isAudit.value == 3>
		                                             	<a class="grounding" title="商品上架" name="1" onclick="productStatue(this,'${(obj.id)!}')"></a>
		                                             	<#elseif obj.status == 1 && obj.productInfo.isAudit.value == 1><a class="undercarriage noSeeThisIcon" title="商品下架" name="0" onclick="productStatue(this,'${(obj.id)!}')"></a>
		                                             	</#if>
					                                	</span>
					                                </td>
		                                		</tr>
		                                	</table>
		                                </td>
		                            </tr>
		                            <#assign preId=obj.id/>
	                            </#list>
	                        <#else>
	                        	    <tr>
		                             	<td colspan="2"><span class="empty15">${action.getText("msg.no.data")}</span></td>
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
            <div   id="imageload">
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
	 						    <li><span>${(supplier.name)!}</span>
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
