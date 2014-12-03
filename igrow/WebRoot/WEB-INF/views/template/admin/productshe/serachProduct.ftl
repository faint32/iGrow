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
                <a class="sendMessage"></a>
                <span>从商品库选取</span>
            </div>
            <div class="rightStyle" onclick="addSellProduct()">
                <a class="toWeb"></a>
                <span>新建商品</span>
            </div>
        </div>
    </div>
    <div class="layerBox" id="productShowBox">
        <h2><span>选择商品</span>
            <a class="btn_closedPage" onclick="hideproductShow()"></a>
        </h2>
        <div class="summaryBox">
			<div class="OrderTop">
                <div class="searchOrderDiv">
                    <input type="text" class="searchBox" id="serachProductName" value="${(search.name)!}" placeholder="请输入商品/商店名称" />
                    <a class="searchOrderBtn" onclick="searchProductName()"></a>
                </div>
                <div class="easy-search">
	                <#if productInfo??&&productInfo?exists>
	                    <#list productInfo as product>
	                        <a <#if product.productInfo??&&product.productInfo!=null&&(product.productInfo?size>0)>class="redColor"</#if>>${(product.name)!}</a>
	                    </#list>
	                 </#if>
                </div>
            </div>
            <div class="search-out">
            	<ul>
                	<#if productInfo??&&productInfo?exists>
                    <#list productInfo as product>
                         <#if product.productInfo??&&product.productInfo!=null&&(product.productInfo?size>0)>
 						    <li><h2>${(product.name)!}</h2>
		                    	<ul class="productsName-here">
		                    	  <#list product.productInfo as info>
		                    	     <li onclick="setproductName('${(info.name)!}','${(info.id)!}')">${(info.name)!}</li>
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
    <!-- end layerBox -->
 