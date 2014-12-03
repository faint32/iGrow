<style type="text/css">
body{ min-width: inherit; background-color:#F5F5F5;}
.blockActiveList{ float:left; width:100%; font-size:13px; background-color:#f6f6f6;}
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
img{ font-size:0;}
.pro_newDetail img{
   padding:0px;
}
</style>
<script type="text/javascript">
    document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
        WeixinJSBridge.call('hideToolbar');
    });
	$(function(){
	    $("img").parent("p").css({"line-height":"0px", "padding-bottom":"0px"});
	    setTimeout("tt()",5000);
	    setTimeout("delayTwo()",100);
	})
	function tt(){
		$("body").css({"height": "auto", "min-width": "inherit"});
	}
	function delayTwo(){
		$(".blockActiveList img, .blockActiveList  img").css({"width": "100%", "height":"auto"});
		//$(".blockActiveList img, .blockActiveList  img").attr("width", "100%");
	}
 
</script>
 
<body>
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
	</#if>
</div>
</body>