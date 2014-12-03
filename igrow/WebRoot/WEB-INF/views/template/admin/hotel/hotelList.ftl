<script type="text/javascript">
    function searchForminner(){
        var searchInnerName = $.trim($("#searchInnerName").val());
        if(searchInnerName != null && searchInnerName !="" && searchInnerName != "undefined" && searchInnerName != "请输入酒店名称"){
    		   searchInnerName = encodeURI(encodeURI(searchInnerName));
   		}else{
   		       searchInnerName = "";
   		}
        var url = "${contextPath}/admin/hotel/hotelList.do?search.name="+searchInnerName+"&pager.pageNumber="+$("#pageNumberinner").val()+"&pager.pageSize="+$("#pageSizeinner").val();
        $.ajaxSetup ({ cache: false });
        $(".content-right").load(url);
	} 
	//添加酒店
	function applayInvoice(type,hotelId,obj){
	    var isAdd = $(obj).parent().parent().prev().find(".empty15").html();
	    if(isAdd == "已添加"){//已添加
	         var url = "${contextPath}/admin/cooperate/edit.do?hotel.id="+hotelId;
             loadRightPage(url);
	    }else if(isAdd == "未添加"){//未添加
	       // var url = "${contextPath}/admin/cooperate/add.do?hotel.id="+hotelId;
           // loadRightPage(url);
             	   if(hotelId == ""){
				      return;
				   }
			       var formParam={
			         "hotel.id":hotelId,
			       };
			        tip_show('w', "添加中,请稍后...");
			       	$.ajax({    
			                  type:'POST',        
			                  url:'${contextPath}/admin/cooperate/addHotel.do',    
			                  data:formParam,    
			                  cache:false,    
			                  dataType:'json',
			                  type:'post',    
			                  success:function(data){ 
		                      	  tip_show(0, "添加成功");
								  setTimeout(function(){
										tip_hide_w();
								  },1000);
			                      $(obj).html("查看");
			                      $(obj).addClass("onlySeeThis");
			                      $(obj).parent().parent().prev().find(".empty15").html("已添加");
			                      var url = "${contextPath}/admin/cooperate/lists.do";
			                      $(".content-left").load(url);
			                  }    
			            });
	    }
	}
</script>
<style type="text/css">
</style>
<div class="titleH2 font14">酒店基本信息</div>
    <div class="tip_save_success"><img src="${contextPath}/css/images/tip_save_success.png" width="46" height="60"><span class="tip_font_save"><span class="font16 success_apply"><b>申请成功!</b></span></span></div>
    <div class="OrderTable">
        <div class="OrderTop hotel_right">
                <div class="searchOrderDiv" style="margin-bottom:3px;">
                    <input type="text" class="searchBox" name="search.name" id="searchInnerName" value="${(search.name)!""}" placeholder="请输入酒店名称" />
                    <input type="hidden" id="pageNumberinner" name="pager.pageNumber" value="${(pager.pageNumber)!}" />
                    <input type="hidden" id="pageSizeinner" name="pager.pageSize" value="${(pager.pageSize)!}" />
                    <a class="searchOrderBtn" onclick="searchForminner();"></a>
                </div>
                <div class="clear"></div>
        </div>
        <div class="OrderBottom n_toTop">
            <table width="760">
                <tr>
                    <th width="154"><span class="empty15">序号</span></th>
                    <th width="214"><span class="empty15">酒店名称</span></th>
                    <th width="200"><span class="empty15">状态</span></th>
                    <th width="190"><span class="empty15">操作</span></th>
                </tr>
				 <#if (pager.results)??>
                    <#list pager.results as obj>
                        <tr>
		                    <td><span class="empty15">${obj_index+1}</span></td>
		                    <td><span class="pro_name03 ellipsis empty15" title="${(obj.name)!}">${(obj.name)!}</span></td>
		                    <td><span class="empty15"><#if obj != null && obj.isAdd != null && obj.isAdd == 1>已添加<#else>未添加</#if></span></td>
		                    <td class="operating"><span class="empty15"><#if obj != null && obj.isAdd != null && obj.isAdd == 1><a class="add_pro_btn width30 onlySeeThis" onclick="applayInvoice(1,'${(obj.id)!0}',this)">查看</a><#else><a class="add_pro_btn width30" onclick="applayInvoice(0,'${(obj.id)!0}',this)">添加</a></#if></span></td>
		                </tr>
                    </#list>
                <#else>
                	    <tr>
                         	<td colspan="6"><span class="empty15">${action.getText("msg.no.data")}</span></td>
                        </tr>
                </#if>
            </table>
        </div>
        <@a.paginationBottominner />
</div>
<!-- end content-right -->
