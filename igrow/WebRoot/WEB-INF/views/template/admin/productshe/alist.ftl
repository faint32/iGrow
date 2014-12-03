<@a.header "${action.getText('ui.manage')}">
	<script>
		//页面初始化
		$(function(){
			//初始化编辑页面
			edit(${(pager.fisrtId)!''});
		});
		 //查询
	     function list(){
	        $("#searchForm").attr("action","${contextPath}/admin/productshe/alist.do");
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
	        if($("#searchBox").val() != "品名/编号/酒店"){
	     		$("#searchName").val($("#searchBox").val());
	     	}else{
	     		$("#searchName").val("");
	     	}
	     	//提交查询
	     	list();
	     }
	     //编辑
	     function edit(id){
	        if(typeof(id) != "undefined"){
		        //设置每页第一条记录值
		     	$("#fisrtId").val(id);
		     	var url = "${contextPath}/admin/productshe/auditDetail.do?id="+id;
		        loadRightPage(url);
	        }
	     }
	     //加载页面
	     function loadRightPage(url){
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
	     
	       //删除
	     function del(id,preId){
	      if(confirm("确定删除？")){
		     $.ajax({    
		        type:'POST',        
		        url:'${contextPath}/admin/productshe/delete.do?id='+id,    
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
	   function showErweima(name,imgSrc){
	         $("#erweimaName").html(name);
             $("#erweimaImg").attr("src",imgSrc);
             imgSrc = encodeURI(encodeURI(imgSrc));
             $("#erweimaSave").attr("href","${contextPath}/common/download.do?attachname="+imgSrc);
             $("#erweimashow").show();
	   }  
	   function erweimaClose(){
	 		 $("#erweimashow").hide();
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
		        		 }else{
		        		     $(obj).removeClass("grounding").addClass("undercarriage noSeeThisIcon");
		        		     $(obj).attr('title','商品下架');
		        		     $(obj).attr('name','0');
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
	<style type="text/css">
	.searchOrderDiv{ *width:270px;}
	.order_Number{ width:105px;}
	</style>
</@a.header >
<body>
	<@a.menu />
	<div id="Contenter">
        <div class="contentBody">
           <!-- start content-left -->
            <div class="content-left">
                <div class="titleH2 font14">商品列表</div>
                <div class="OrderTable">
                    <div class="OrderTop">
                         <form action="${contextPath}/admin/productshe/alist.do" method="post" id="searchForm">
	                       <select class="selct01" name="search.productType" onchange="list()">
                            <option value="">全部</option>
                            <#list productTypes as proType>
                              <option value="${(proType.value)!""}" <#if search.productType==proType.value>selected="selected"</#if>>${(proType.desc)!""}商品</option>
                            </#list>
	                        </select>
	                        <input type="hidden" class="timeInput nobg" name="search.minPrice" value="${(search.minPrice)!}" placeholder="售价" maxlength="8" onkeyup="this.value=this.value.replace(/[^0-9.]+/,'')" onafterpaste="this.value=this.value.replace(/[^0-9.]+/,'')"  onkeydown="keydownsearch(event)"/>
	                        <input type="hidden" class="timeInput nobg empty13" name="search.maxPrice" value="${(search.maxPrice)!}" placeholder="售价" maxlength="8" onkeyup="this.value=this.value.replace(/[^0-9.]+/,'')" onafterpaste="this.value=this.value.replace(/[^0-9.]+/,'')" onkeydown="keydownsearch(event)"/>
	                        <div class="searchOrderDiv">
	                            <input type="text" class="searchBox" id="searchBox" value="${(search.name)!}" placeholder="品名/编号/酒店" style="width:160px;" onkeydown="keydownsearch(event)"/>
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
                        <table width="100%">
                            <tr>
                                <th width="20%"><span class="empty15">${action.getText("productshe.productSn")}</span></th>
                            	<th width="20%"><span class="empty15">${action.getText("product.name")}</span></th>
                            	<th width="17%"><span class="empty15">进价</span></th>
                                <th width="15%"><span class="empty15">类型</span></th>
                                <th width="28%"><span class="empty15">${action.getText("label.action")}</span></th>
                            </tr>
                            <#if (pager.results)??>
	                            <#list pager.results as obj>
		                            <#if obj_index == 0>
	                            		<#assign preId=0/>
	                            	</#if>
		                            <tr <#if obj.id == pager.fisrtId> class="change_bg_tr"</#if> onclick="edit(${(obj.id)!});">
		                                <td><span class="empty15 order_Number ellipsis" title="${(obj.productSn)!""}">${(obj.productSn)!""}</span></td>
		                                <td><span class="empty15 pro_name ellipsis" title="${(obj.name)!""}">${(obj.name)!""}</span></td>
		                                <td><span class="empty15" title="${(obj.productPrice)!0}">${(obj.productPrice)!0}</span></td>
		                                <td><span class="empty15">${(obj.productTypes.desc)!}商品</span></td>
		                                <td class="operating"><span class="empty15">
		                                	<a class="detailThis_h" onclick="edit(${(obj.id)!});"></a>
		                                	<a class="deleteThis" onclick="del('${(obj.id)!}',${(preId)!});"></a>
		                                   	<a class="two-di" onclick="showErweima('${obj.name}','${imagePath}${(obj.getRealScanUrl())!}')"></a>
		                                	<#if obj.status = 1><a class="undercarriage noSeeThisIcon" title="商品下架" name="0" onclick="productStatue(this,'${(obj.id)!}')"></a><#else>
		                                	<a class="grounding" title="商品上架" name="1" onclick="productStatue(this,'${(obj.id)!}')"></a></#if>
		                                	</span>
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
            <div class="content-right null_padding">
                <!-- input -->
            </div>
            <!-- end content-right -->
            <div class="clear"></div>
        </div>
    </div>
    <!-- end Contenter -->
 <@a.footer />  
 
 
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
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
</div>            