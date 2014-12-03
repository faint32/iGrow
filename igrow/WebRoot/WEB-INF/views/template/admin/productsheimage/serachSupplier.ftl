<script type="text/javascript">
    $(function(){
	    $("#productShow").show();
	    $("#productShowBox").show();
	    
	    $(".closed").bind("click", function(){
		   $(".layer").hide();
	    });
    });
</script>
	<div class="bottomBlock"></div>
    <div class="layer-content">
    	<div class="two-select">
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
	                    <input type="text" class="searchBox" id="serachProductName"  value="${(supplier.name)!}" placeholder="请输入供应商名称" />
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
 