<link href="${contextPath}/css/user.css"  rel="stylesheet">
<script type="text/javascript">
   $(function(){
        var url = "${contextPath}/admin/order/uorder.do?member.id="+${(result.id)!};
        $("#memberOrderPager").load(url);
        $(".bottom_layer_see").live("click", function(){
        	$("span.see_icon").removeClass("show_next_node");
        	$(".bottom_layer_see").css("display", "none");
        })
	});
	var i = 1;
	function show_childred(this_V){
		$(this_V).parent().parent().parent().siblings().find("span").each(function(){
			if($(this).hasClass("show_next_node")){
				$(this).removeClass("show_next_node")
			}
		})
		$(this_V).toggleClass("show_next_node");
		if($(this_V).hasClass("show_next_node")){
			$(".bottom_layer_see").css("display", "block");
			$(this_V).children(".detail_member_layer").css("z-index", i);
			return i++;
		}else{
			$(".bottom_layer_see").css("display", "none");
		}
	}
</script>
<div class="titleH2 font14">${action.getText("member.label")}${action.getText("label.detail")}</div>
<div class="member_detail">
            <span class="member_name_t"><#if result != null && result.name != null>${(result.name)!}<#else>${(result.mobile)!}</#if></span><br>
	                        会员账号：<span class="blurColor font16">${(result.mobile)!}</span><i>|</i>注册时间：<#if result??&&result?exists&&(result.createDate)??&&(result.createDate)?exists>${(result.createDate)?string("yyyy.MM.dd HH:mm:ss")}</#if><i>|</i>最后一次登录：<#if result??&&result?exists&&(result.modifyDate)??&&(result.modifyDate)?exists>${(result.modifyDate)?string("yyyy.MM.dd HH:mm:ss")}</#if>
	        	<br>累计消费: <b class="redColor price_b">${(result.memberAccount.totalSpendAmount)!0}</b>元
</div>
<div class="OrderTable">
        <div class="OrderBottom" id="memberOrderPager">
            
        </div>
        <div class="clear"></div>
</div>
