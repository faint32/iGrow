<@a.header "${action.getText('ui.manage')}">
	<script>
		//页面初始化
		$(function(){
			//初始化编辑页面
			edit(${(pager.fisrtId)!''});
		});
		 //查询
	     function list(){
	        $("#searchForm").attr("action","${contextPath}/admin/product/list.do");
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
	     	if($("#searchBox").val() != "品名/编号"){
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
	     	var url = "${contextPath}/admin/product/add.do";
	        loadRightPage(url);
	     }
	     //编辑
	     function edit(id){
	        //设置每页第一条记录值
	     	$("#fisrtId").val(id);
	     	var url = "${contextPath}/admin/product/edit.do?id="+id+"&tmp="+Math.round(Math.random()*100000);  
	        loadRightPage(url);
	     }
	     //删除
	     function del(id,name,preId){
	      if(confirm("该商品数据及添加过此商品的酒店的关联商品也将被删除，是否继续操作？")){
		     $.ajax({    
		        type:'POST',        
		        url:'${contextPath}/admin/product/delete.do?id='+id,    
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
	        $(".content-right").load(url,function(resTxt,status,xhr){
	        	first();
	        	if(status == "success"){
	        		setTimeout(function(){
						tip_hide_w(); 
					},300);
	        	}
			}); 
	     }
	</script>
</@a.header >
<body>
	<@a.menu />
	<div id="Contenter">
        <div class="contentBody">
           <!-- start content-left -->
            <div class="content-left">
                <div class="titleH2 font14">${action.getText("product.label")}${action.getText("label.list")}<a class="addProducts" onclick="add();" ><img src="${contextPath}/css/images/white_add_icon.png">${action.getText("product.title")}</a></div>
                <div class="OrderTable">
                    <div class="OrderTop">
                        <div class="searchOrderDiv">
                         <form action="${contextPath}/admin/product/list.do" method="post" id="searchForm">
                            <input type="text" class="searchBox" id="searchBox" value="${(search.name)!}" placeholder="品名/编号" onkeydown="keydownsearch(event)"/>
                            <select class="selct02" name="search.searchStatus" onchange="commonSearch()">
	                            <option value="10">审核状态</option>
	                            <#list auditStatuss as auditStatus>
	                              <option value="${(auditStatus.value)!""}" <#if search.searchStatus==auditStatus.value>selected="selected"</#if>>${(auditStatus.desc)!""}</option>
	                            </#list>
	                        </select>
                            <input type="hidden" id="pageNumber" name="pager.pageNumber" value="${(pager.pageNumber)!}" />
                            <input type="hidden" id="pageSize" name="pager.pageSize" value="${(pager.pageSize)!}" />
                            <input type="hidden" id="fisrtId" name="pager.fisrtId" value="${(pager.fisrtId)!}" />
                            <input type="hidden" id="searchName" name="search.name" value="${(search.name)!}" />
                            <a class="searchOrderBtn" onclick="commonSearch();"></a>
                            <input type="submit" value="" style="display:none"/>
                         </form>
                        </div>
                    </div>
                    <@a.paginationTop />
                    <div class="OrderBottom">
                        <table width="100%">
                            <tr>
                                <th width="15%"><span class="empty15">${action.getText("productshe.productSn")}</span></th>
                            	<th width="20%"><span class="empty15">${action.getText("product.name")}</span></th>
                            	<th width="17%"><span class="empty15">售价</span></th>
                                <th width="15%"><span class="empty15">平台佣金</span></th>
                                <th width="15%"><span class="empty15">状态</span></th>
                                <th width="18%"><span class="empty15">${action.getText("label.action")}</span></th>
                            </tr>
                            <#if (pager.results)??>
	                            <#list pager.results as obj>
	                                <#if obj_index == 0>
	                            		<#assign preId=0/>
	                            	</#if>
		                            <tr <#if obj.id == pager.fisrtId> class="change_bg_tr"</#if> onclick="edit(${(obj.id)!});">
		                                <td><span class="empty15" title="${(obj.productSn)!""}">${(obj.productSn)!""}</span></td>
		                                <td><span class="pro_name ellipsis empty15" title="${(obj.name)!""}">${(obj.name)!""}</span></td>
		                                <td><span class="empty15">${(obj.productPrice)!0}</span></td>
		                                <td><span class="empty15">${(obj.defSysCommRate)!0}%</span></td>
		                                <td><span class="empty15">${(obj.isAudit.desc)!}</span></td>
		                                <td class="operating"><span class="empty15">
		                                	<a class="editThis" onclick="edit(${(obj.id)!});"></a>
		                                	<a class="deleteThis" onclick="del('${(obj.id)!}','${(obj.name)!}',${(preId)!});"></a></span>
		                                </td>
		                            </tr>
		                            <#assign preId=obj.id/>
	                            </#list>
	                        <#else>
	                        	    <tr>
		                             	<td colspan="6"><span class="empty15">${action.getText("msg.no.data")}</span></td>
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
