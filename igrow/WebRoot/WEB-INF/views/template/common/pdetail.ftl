<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>${(result.productInfo.name)!}</title>
    <link href="${contextPath}/css/masterPage.css" rel="stylesheet" />
    <link href="${contextPath}/css/commodity.css" rel="stylesheet" />
    <link href="${contextPath}/css/settlement.css" rel="stylesheet" /> 
    <link href="${contextPath}/css/orderManag.css" rel="stylesheet" />
    <link href="${contextPath}/css/hotelManag.css" rel="stylesheet" />
    <link href="${contextPath}/css/sample.css"  rel="stylesheet">
    <link href="${contextPath}/css/style.css" rel="stylesheet" />
    <link href="${contextPath}/css/alertLayer.css" rel="stylesheet" />
    <script src="${contextPath}/js/jquery-1.7.2.min.js"></script>
    <script src="${contextPath}/js/j_page.js"></script>
    <script src="${contextPath}/js/ckeditor/ckeditor.js"></script>
    <script src="${contextPath}/js/Validform_v5.3.2.js"></script>
    <script src="${contextPath}/js/passwordStrength-min.js"></script>
    <script src="${contextPath}/js/alertLayer.js"></script>
    <script src="${contextPath}/js/nowTime.js"></script>
    <script src="${contextPath}/js/common.js"></script>
    <script src="${contextPath}/common/My97DatePicker/WdatePicker.js"></script>
    <link href="${contextPath}/favicon.ico" rel="shortcut icon" type="image/x-icon" />
</head>
<style type="text/css">
body{ min-width: inherit; background-color:#fff;}
.blockActiveList{ float:left; padding-top:31px; width:100%; font-size:13px; background-color:#fff; padding:0 0 10px;}
.blockActiveList li{ padding-bottom:12px;}
.blockActiveList li h3{ padding-bottom:5px; text-indent: 2em; font-size:14px; color:#000; width:100%;}
.blockActiveList li p, .blockActiveList p{ line-height:24px; font-size:14px; color:#4c4c4c; width:100%; padding-bottom:5px}
.blockActiveList img{ width:100%; height:auto;}
.btnCheckoutNow {
    background-color: #FF5F1E;
    border: 1px solid #D33D00;
    border-radius: 5px;
    color: #FFFFFF;
    display: block;
    font-size: 16px;
    height: 42px;
    line-height: 42px;
    text-align: center;
    width: 100%;
}
.Interspace {
    padding: 8px 4%;
    width: 92%;
}
img{ font-size:0;}
.pro_newDetail img{
   padding:0px;
}
</style>
<script type="text/javascript">
	$(function(){
	    $("img").parent("p").css({"line-height":"0px", "padding-bottom":"0px"});
	    setTimeout("tt()",5000);
	    setTimeout("delayTwo()",100);
	})
	function tt(){
		$("body").css({height: "auto", "min-width": "inherit"});
	}
	function delayTwo(){
		$(".blockActiveList img, .blockActiveList  img").css({"width": "100%", "height":"auto"});
		//$(".blockActiveList img, .blockActiveList  img").attr("width", "100%");
	}
 
</script>
<script type="text/javascript">
$(function(){
	var regex = new RegExp("[?&]" + encodeURIComponent("download") + "\\=([^&#]+)");
	var value = (location.search.match(regex)||["",""])[1];
	if(value == "0"){
		$(".Interspace").css("display", "none");
	}
})

	//分享
	function shareFriend() {
		var inputValue = $("#title").val(); 
		var hotelTitle =  $("#pro_titlehidden").val();
		var $dddd = "我在"+hotelTitle+"发现一件宝贝，已亲自体验，分享给各位亲朋好友。";
		//re = new RegExp("<br>","g");  
	    WeixinJSBridge.invoke('sendAppMessage',{
	                           // "appid":window.shareData.appid,
	                            "img_url":$("#imageShow").val(),
	                            "img_width":"640",
	                            "img_height":"640",
	                            "link":window.location.href,
	                            "desc":$dddd,
	                            "title": inputValue,
	                            }, function(res) {
	                                if(res.err_msg == "send_app_msg:confirm" || res.err_msg == "send_app_msg:ok"){
		                            	 productShare(1);
		                            }
	                               _report('send_msg', res.err_msg);
	                            })
	}
	function shareTimeline() {
		var inputValue = $("#title").val(); 
		var hotelTitle =  $("#pro_titlehidden").val();
		var $dddd = "我在"+hotelTitle+"发现一件宝贝，已亲自体验，分享给各位亲朋好友。";
	    WeixinJSBridge.invoke('shareTimeline',{
	    	 					"img_url":$("#imageShow").val(),
	                            "img_width":"640",
	                            "img_height":"640",
	                            "link":window.location.href,
	                            "desc":$("#title").html(),
	                            "title": $dddd,
	                            }, function(res) {
	                            if(res.err_msg == "share_timeline:ok"){
		                            	 productShare(0);
		                            }
	                            	_report('timeline', res.err_msg);
	                            });
	}
	
	function shareWeibo(){
		var hotelTitle =  $("#pro_titlehidden").val();
		var $dddd = "我在"+hotelTitle+"发现一件宝贝，已亲自体验，分享给各位亲朋好友。";
	 	WeixinJSBridge.invoke('shareWeibo',{
	 							"img_url":$("#imageShow").val(),
					            "img_width":"640",
					            "img_height":"640",
					            "link":window.location.href,
					            "desc":$dddd,
					            "title": $dddd,
					            }, function(res) {
					            	if(res.err_msg == "share_weibo:ok"){
		                            	 productShare(2);
		                            }
					           		_report('timeline', res.err_msg);
					            });
	}
	
	// 当微信内置浏览器完成内部初始化后会触发WeixinJSBridgeReady事件。
	document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {

	        // 发送给好友
	        WeixinJSBridge.on('menu:share:appmessage', function(argv){
	            shareFriend();
	            });

	        // 分享到朋友圈
	        WeixinJSBridge.on('menu:share:timeline', function(argv){
	            shareTimeline();
	            });

	        // 分享到微博
	        WeixinJSBridge.on('menu:share:weibo', function(argv){
	            shareWeibo();
	            });
	        }, false)
	      
    function productShare(type){
	    var formParam={
				"pid":$("#productid").val(),             //商品编号    
				"stype":type                          //分享类型
		           };
			$.ajax({
				url : '${contextPath}/common/productShare.do',
				type : 'POST',
				async : false,
				dataType : "json",
				async : false,
				data:formParam,
				success : function(data) {
					 
				}
			});
	}      
</script>
<body>
 <input type="hidden" id="pro_titlehidden" value="${(result.hotelInfo.name)!""}"/>
 <input type="hidden" id="imageShow" value="${imagePath}${(result.productInfo.imageUrl)!""}"/>
 <input type="hidden" id="title" value="${(result.productInfo.name)!""}"/>
 <input type="hidden" id="productid" value="${(result.id)!""}"/>
<div class="blockActiveList">
	<#if result != null>
	<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
	<html>
	<head>
    <meta http-equiv="Cache-control" />
    <meta name="format-detection" content="telephone=no" />
    <meta content="yes" name="apple-mobile-web-app-capable" />
    <meta content="black" name="apple-mobile-web-app-status-bar-style" />
    <meta content="telephone=no" name="format-detection" />
    <meta name="viewport" content="width=device-width; maximum-scale=1.0;  user-scalable=no; initial-scale=1.0" />
    </head>
	 ${(result.productInfo.detail)!""}
	 <div class="Interspace">
    	<a class="btnCheckoutNow" href="${codeUrl}boraMallH5T/views/front/product/product.html?from=0&pid=${(result.productSn)!}">立即购买</a>
     </div>
	</#if>
</div>
</body>