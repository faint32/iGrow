    <div class="titleH2 font14">${action.getText("product.label")}${action.getText("label.list")}
    <div class="btn_add_area">
            	<a class="addProducts btn_new_bg marginR113 paddingR13" onclick="btn_click_sort()">排序</a>
   </div>
   <a class="addProducts" onclick="addProducts()" ><img src="${contextPath}/css/images/white_add_icon.png">${action.getText("productshe.title")}</a></div>
    <div class="OrderTable">
        <div class="OrderTop">
            <form action="${contextPath}/admin/productsheimage/listo.do" method="post" id="searchForm">
            <select class="selct01" name="search.productType">
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
            <input type="hidden" class="timeInput nobg" name="search.minPrice" value="${(search.minPrice)!}" placeholder="售价" maxlength="8" onkeyup="this.value=this.value.replace(/[^0-9.]+/,'')" onafterpaste="this.value=this.value.replace(/[^0-9.]+/,'')" />
            <input type="hidden" class="timeInput nobg empty13" name="search.maxPrice" value="${(search.maxPrice)!}" placeholder="售价" maxlength="8" onkeyup="this.value=this.value.replace(/[^0-9.]+/,'')" onafterpaste="this.value=this.value.replace(/[^0-9.]+/,'')"/>
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
                   <th width="5%" class="new_hidden n_null_cell"></th>
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
		                            	<td class="new_hidden n_null_cell" width="5%"><span class="empty5" name="${((pager.pageNumber-1)*pager.pageSize+obj_index+1)!}"><input class="new_sort" onblur="saveOrderNum(${(obj.id)!},this)" value="${((pager.pageNumber-1)*pager.pageSize+obj_index+1)!}" maxlength="5" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" /></span></td>
		                                <td width="95%">
		                                	<table width="100%" class="new_no_border">
		                                		<tr onclick="edit(${(obj.id)!}, this)">
		                                			<td width="23%"><span class="empty15 ellipsis pro_name" title="${obj.productSn}">${obj.productSn}</span></td>
					                                <td width="20%"><span class="pro_name_lname_new ellipsis empty15" title="${obj.name}">${obj.name}</span></td>
					                                <td width="9%"><span class="empty15">${(obj.productTypes.desc)!}</span></td>
					                                <td width="18%"><span class="empty15"><#if obj.status == 0>已下架<#else>${(obj.productInfo.isAudit.desc)!}</#if><#if obj.isAuditFlag == 1>(待审)</#if></span></td>
					                                <td width="30%" class="operating"><span class="empty15">
					                                	<a class="editThis" onclick="edit(${(obj.id)!});"></a>
					                                	<a class="deleteThis" onclick="del('${(obj.id)!}','${(obj.productId)!}',${(preId)!});"></a>
					                                	<a class="two-di" <#if obj!=null&&obj.productInfo!=null&&obj.productInfo.isAudit!=null&&(obj.productInfo.isAudit.value ==1 || obj.productInfo.isAudit.value == 3)>onclick="showErweima('${obj.name}','${imagePath}${(obj.getRealScanUrl())!}')"<#else>onclick="alert('该商品还未通过审核')"</#if>></a>
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
                         	<td colspan="5"><span class="empty15">${action.getText("msg.no.data")}</span></td>
                        </tr>
                </#if>
            </table>
        </div>
        <@a.paginationBottom />
    </div>