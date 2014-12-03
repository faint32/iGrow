<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>${(result.name)!}</title>
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
.blockActiveList{ float:left; padding-top:31px; width:92%; font-size:13px; background-color:#fff; padding:10px 4%;}
.blockActiveList li{ padding-bottom:12px;}
.blockActiveList li h3{ padding-bottom:5px; text-indent: 2em; font-size:14px; color:#000; width:100%;}
.blockActiveList li p, .blockActiveList p{ line-height:24px; font-size:14px; color:#4c4c4c; width:100%; padding-bottom:5px}
.blockActiveList img{ width:100%; height:auto; padding-top:5px;}
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
    padding: 8px 0;
    width: 100%;
}
</style>
<script type="text/javascript">
	$(function(){
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
	 ${result.detail}
	   <#if result.productSn != "" || result.productShelves != null>
		 <div class="Interspace">
	    	<a class="btnCheckoutNow" href="${systemIp}boraMallH5T/views/front/product/product.html?pid=${(result.productSn)!}">立即参与活动</a>
	     </div>
	   <#elseif result.hotelSn != "">
	     <div class="Interspace">
	    	<a class="btnCheckoutNow" href="${systemIp}boraMallH5T/views/front/product/plist.html?hid=${(result.hotelSn)!}">立即参与活动</a>
	     </div>
       </#if>
	</#if>
</div>
</body>