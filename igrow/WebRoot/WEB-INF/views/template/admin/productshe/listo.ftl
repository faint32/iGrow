    <div class="titleH2 font14">${action.getText("product.label")}${action.getText("label.list")}<a class="addProducts" onclick="addProducts()" >${action.getText("productshe.title")}</a></div>
    <div class="OrderTable">
        <div class="OrderTop">
            <form action="${contextPath}/admin/productshe/listo.do" method="post" id="searchForm">
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
                    <th width="21%"><span class="empty15">${action.getText("productshe.productSn")}</span></th>
                	<th width="30%"><span class="empty15">${action.getText("product.name")}</span></th>
                	<th width="15%"><span class="empty15">${action.getText("product.productType")}</span></th>
                	<th width="12%"><span class="empty15">状态</span></th>
                    <th width="23%"><span class="empty15">${action.getText("label.action")}</span></th>
                </tr>
                <#if (pager.results)??>
                    <#list pager.results as obj>
                        <tr>
                            <td><span class="empty15">${obj.productSn}</span></td>
                            <td><span class="pro_name ellipsis empty15" title="${obj.name}">${obj.name}</span></td>
                            <td><span class="empty15">${(obj.productTypes.desc)!}商品</span></td>
                            <td><span class="empty15">${(obj.productInfo.isAudit.desc)!}</span></td>
                            <td class="operating"><span class="empty15">
                            	<a class="editThis" onclick="edit(${(obj.id)!});"></a>
                            	<a class="deleteThis" onclick="del('${(obj.id)!}','${(obj.productId)!}');"></a>
                                <a class="two-di" <#if obj!=null&&obj.productInfo!=null&&obj.productInfo.isAudit!=null&&obj.productInfo.isAudit.value ==1 >onclick="showErweima('${obj.name}','${imagePath}${(obj.getRealScanUrl())!}')"<#else>onclick="alert('该商品还未通过审核')"</#if>></a></span>
                            </td>
                        </tr>
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