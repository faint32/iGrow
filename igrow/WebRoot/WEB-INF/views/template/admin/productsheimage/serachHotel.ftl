<script type="text/javascript">
    $(function(){
	    $("#hotelshow").show();
	    $("#hotelshowBox").show();
	    
	    $(".closed").bind("click", function(){
		   $(".layer").hide();
	    });
    });
</script>
	<div class="bottomBlock"></div>
    <div class="layer-content">
    </div>
    <div class="layerBox" id="hotelshowBox">
        <h2><span>选择酒店</span>
            <div class="closed"></div>
        </h2>
        <div class="summaryBox">
			<div class="OrderTop">
                <div class="searchOrderDiv">
                    <input type="text" class="searchBox" id="serachHotelName" value="${(hotel.name)!}" placeholder="请输入酒店名称" />
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
    <!-- end layerBox -->
 