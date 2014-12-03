<@a.header "${action.getText('ui.manage')}">
	<script>
		//页面初始化
		$(function(){
			//初始化编辑页面
			var fisrtId= "${(pager.fisrtId)!'0'}";
			if(fisrtId ==""){fisrtId=0;}
			edit(fisrtId,0);
		});
		 //查询
	     function list(){
	        $("#searchForm").attr("action","${contextPath}/admin/productimage/audit.do");
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
	     	if($("#searchBox").val() != "品名/编号/发布方"){
	     		$("#searchName").val($("#searchBox").val());
	     	}else{
	     		$("#searchName").val("");
	     	}
	     	//提交查询
	     	list();
	     }
	     //编辑
	     function edit(id,preId){
	        //设置每页第一条记录值
	     	$("#fisrtId").val(id);
	     	var url = "${contextPath}/admin/productimage/auditDetail.do?id="+id+"&preId="+preId;
	        loadRightPage(url);
	     }
	     //加载页面
	     function loadRightPage(url){
	        tip_show('w', "数据加载中...");
	     	$.ajaxSetup ({ cache: false });
	        $(".content-right").load(url,function(resTxt,status,xhr){
	        	if(status == "success"){
	        		setTimeout(function(){
						tip_hide_w(); 
					},300);
	        	}
			}); 
	     }
	     function closeAudit(){
	         $("#closeAudit").hide();
	     }
	</script>
</@a.header >
<body>
	<@a.menu />
	<div id="Contenter">
        <div class="contentBody">
           <!-- start content-left -->
            <div class="content-left">
                <div class="titleH2 font14">待审核商品列表</div>
                <div class="OrderTable">
                    <div class="OrderTop">
                        <div class="searchOrderDiv">
                         <form action="${contextPath}/admin/productimage/audit.do" method="post" id="searchForm">
	                        <select class="selct01" name="search.productType" onchange="commonSearch()">
	                            <option value="">全部</option>
	                            <option value="0" <#if search.productType==0>selected="selected"</#if>>酒店自建商品</option>
	                            <option value="1" <#if search.productType==1>selected="selected"</#if>>供应商商品</option>
	                        </select>
	                        <select class="selct02" name="search.searchStatus" onchange="commonSearch()">
	                            <option value="10">审核状态</option>
	                            <#list auditStatuss as auditStatus>
	                              <option value="${(auditStatus.value)!""}" <#if search.searchStatus==auditStatus.value>selected="selected"</#if>>${(auditStatus.desc)!""}</option>
	                            </#list>
	                        </select>
                        
                            <input type="text" class="searchBox" id="searchBox" value="${(search.name)!}" placeholder="品名/编号/发布方" onkeydown="keydownsearch(event)"/>
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
                                <th width="15%"><span class="empty15">商品编号</span></th>
                            	<th width="20%"><span class="empty15">${action.getText("product.name")}</span></th>
                            	<th width="15%"><span class="empty15">售价</span></th>
                                <th width="20%"><span class="empty15">发布方</span></th>
                                <th width="15%"><span class="empty15">状态</span></th>
                                <th width="15%"><span class="empty15">${action.getText("label.action")}</span></th>
                            </tr>
                            <#if (pager.results)??>
	                            <#list pager.results as obj>
	                                <#if obj_index == 0>
	                            		<#assign preId=0/>
	                            	</#if>
		                            <tr <#if obj.id == pager.fisrtId> class="change_bg_tr"</#if> onclick="edit(${(obj.id)!},${(preId)!});">
		                                <td><span class="empty15">${(obj.productSn)!""}</span></td>
		                                <td><span class="empty15 order_Number ellipsis" title="${(obj.name)!""}">${(obj.name)!""}</span></td>
		                                <td><span class="empty15">${(obj.productPrice)!0}</span></td>
		                                <td><span class="empty15 pro_name ellipsis" title="<#if obj.productType == 0>${(obj.hotelName)!""}<#else>${(obj.supplierInfo.name)!""}</#if>"><#if obj.productType == 0>${(obj.hotelName)!""}<#else>${(obj.supplierInfo.name)!""}</#if></span></td>
		                                <td><span class="empty15">${(obj.isAudit.desc)!}</span></td>
		                                <td class="operating"><span class="empty15">
		                                	<a class="editThis" onclick="edit(${(obj.id)!},${(preId)!});"></a>
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
            <div class="content-right null_padding">
                <!-- input -->
            </div>
            <!-- end content-right -->
            <div class="clear"></div>
        </div>
    </div>
    <!-- end Contenter -->
 <@a.footer />  
 <div class="layer" id="closeAudit">
    <div class="bottomBlock"></div>
    <div class="layer-content tip_why_this write_why">
    	<div class="why_tip">
            <b class="layer_title">未通过原因</b>
            <textarea class="layer_textarea" id="layer_textarea" maxlength="140"></textarea>
            <p class="font_right_tip">限140字以内</p>
            <div class="order-status-btn">
                <span class="can-send-btn">
                	<a class="confirm-save" onclick="save(2)">保 存</a>
                    <a class="cancel-btn" onclick="closeAudit()">关 闭</a>
                </span>
            </div>
        </div>
    </div>
    <!-- end layerBox -->
</div>