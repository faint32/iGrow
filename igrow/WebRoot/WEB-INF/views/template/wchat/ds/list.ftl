<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Cache-control" />
    <meta name="format-detection" content="telephone=no" />
    <meta content="yes" name="apple-mobile-web-app-capable" />
    <meta content="black" name="apple-mobile-web-app-status-bar-style" />
    <meta content="telephone=no" name="format-detection" />
    <meta name="viewport" content="width=device-width; maximum-scale=1.0;  user-scalable=no; initial-scale=1.0" />
    <title>大咖来了</title>
    <link href="${contextPath}/css/wchat/design_list.css" rel="stylesheet" type="text/css" />
    <script src="${contextPath}/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="/boraMallH5T/js/load.js"></script>
</head>

<script type="text/javascript">
	document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
	    WeixinJSBridge.call('hideToolbar');
	});
	var listCount = 0;
	var en_length;
	$(function(){
		$("#listCount").val("1");
		start_execution();
	})
	$(window).resize(function (){
		start_execution();
	})
	function start_execution(){
		var winW = document.documentElement.clientWidth;
		//var pro_img_width = parseInt(winW * 0.5);
		var pro_img_height = parseInt(winW/1.5714);
		$(".pro_img").css({"height": pro_img_height+"px",});
		//$(".pro_name").css("height", pro_img_height - 25 - 20 + "px");
		//$(".right_box").css("width", winW - winW * 0.08 - pro_img_width - 10 +"px")
		var _picHN = parseInt(winW * 410 / 640);
		$(".n_first_cont").css({"width": winW +"px", "height":_picHN +"px"})
		
	}
	$(window).scroll(function() {  
	    var o = $('#pincontainer');  
	    if(o!=null && o.length !=0){  
	    var hght= document.documentElement.scrollHeight;
	    var clientHeight = document.documentElement.clientHeight;  
	    var top= window.pageYOffset ||   
	                      (document.compatMode == 'CSS1Compat' ?    
	                      document.documentElement.scrollTop :   
	                      document.body.scrollTop);
	    var browserName=navigator.userAgent.toLowerCase();
		if(/webkit/i.test(browserName) &&!(/chrome/i.test(browserName) && /webkit/i.test(browserName) && /mozilla/i.test(browserName))){
			if(top + 100 >=(parseInt(hght)-clientHeight)){
			   	  if($("#listCount").val()==0){
			   		  $(".load_new_list").css("display","none");
			   		  return;
			     	  }else{
			     		//此处为新加载的列loadNewList();
			     	  }
			     }
		 
		}else{
			if(top>=(parseInt(hght)-clientHeight)){
			 	  if($("#listCount").val()==0){
			 		  $(".load_new_list").css("display","none");
			 		  return;
			   	  }else{
			   		//此处为新加载的列loadNewList();
			   	  }
			}      
			}
	    }
	});
	//分享
	function shareFriend() {
		var sharurl = localStorage.l_plistUrl+"&a=1";
		var inputValue = $("#hotelName").html()+"热销商品";
		$("#hotelNames").val(inputValue);
		var hotelTitle =  $("#pro_titlehidden").val();
		var $dddd = "我在"+$("#hotelName").html()+"发现一些宝贝，已亲自体验，分享给各位亲朋好友。";
		//re = new RegExp("<br>","g");  
	    WeixinJSBridge.invoke('sendAppMessage',{
	                           // "appid":window.shareData.appid,
	                            "img_url":$("#shareImg").val(),
	                            "img_width":"640",
	                            "img_height":"640",
	                            "link":sharurl,
	                            "desc":$dddd,
	                            "title":$("#hotelNames").val(),
	                            }, function(res) {
	                            _report('send_msg', res.err_msg);
	                            })
	}
	function shareTimeline() {
		var sharurl = localStorage.l_plistUrl+"&a=1";
		var inputValue = $("#hotelName").html()+"热销商品";
		$("#hotelNames").val(inputValue);
		var hotelTitle =  $("#hotelName").html();
		var $dddd = "我在"+hotelTitle+"发现一些宝贝，已亲自体验，分享给各位亲朋好友。";
	    WeixinJSBridge.invoke('shareTimeline',{
	    	 					"img_url":$("#shareImg").val(),
	                            "img_width":"640",
	                            "img_height":"640",
	                            "link":sharurl,
	                            "desc":$dddd,
	                            "title":inputValue,
	                            }, function(res) {
	                            _report('timeline', res.err_msg);
	                            });
	}
	
	function shareWeibo(){
		var sharurl = localStorage.l_plistUrl+"&a=1";
		var hotelTitle =  $("#hotelName").html();
		var $dddd = "我在"+hotelTitle+"发现一件宝贝，已亲自体验，分享给各位亲朋好友。";
	 	WeixinJSBridge.invoke('shareWeibo',{
	 							"img_url":$("#shareImg").val(),
					            "img_width":"640",
					            "img_height":"640",
					            "link":sharurl,
					            "desc":$dddd,
					            "title": $dddd,
					            }, function(res) {
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
	        
</script>
<body  id="pincontainer">
<div id="Header" style="display:none;">
	<h2><span id="hotelName">数据加载中</span></h2>
</div>
<div class="no_hotel_pro"></div>
<input type="hidden" id="hotelNames" />
<input type="hidden" id="shareImg" />

<div id="Contenter">   
<input type="hidden" id="listCount" value="1"/>
<input type="hidden" id="listNum"/>
	<ul class="product_list">
		<a href="product.html?pid=PD_0001_0393&hid=0001">
			<li>
				<h2 class="design_title"><img src="/boraMallH5T/cssn/images/Designimg_icon.jpg" width="33">一宅一朴<span class="tip_designStyle"></span></h2>
				<div class="summery_box">
					<p class="pro_name">[2014-10-14]原木创意-乾鹊摆件</p>
					<p class="pro_price">
						<b class="now_price">
						￥
						<i class="p_price">398.00</i>
						</b>
					</p>
					<p class="pro_img" style="height: 1211px;">
						<img width="100%" height="100%" src="http://115.29.232.103:9000/product/38/6/20140306062223.jpg">
					</p>
					<div class="howMuchPeo">
						<p class="buyNum">
							<i id="BuyNum">0</i>人已购买
						</p>
						<p class="shareNum">
							<i id="ShareNum">0</i>人已分享
						</p>
						<div class="clear"></div>
					</div>
				</div>
			</li>
		</a>
		<a href="product.html?pid=PD_0001_0393&hid=0001">
			<li>
				<h2 class="design_title"><img src="/boraMallH5T/cssn/images/Designimg_icon.jpg" width="33">一宅一朴<span class="tip_designStyle tip_designOffline"></span></h2>
				<div class="summery_box">
					<p class="pro_name">[2014-10-14]原木创意-乾鹊摆件</p>
					<p class="pro_price">
						<b class="now_price">
						￥
						<i class="p_price">398.00</i>
						</b>
					</p>
					<p class="pro_img" style="height: 1211px;">
						<img width="100%" height="100%" src="http://115.29.232.103:9000/product/38/6/20140306062223.jpg">
					</p>
					<div class="howMuchPeo">
						<p class="buyNum">
							<i id="BuyNum">0</i>人已购买
						</p>
						<p class="shareNum">
							<i id="ShareNum">0</i>人已分享
						</p>
						<div class="clear"></div>
					</div>
				</div>
			</li>
		</a>
    </ul>
    <div class="clear"></div>
    <div class="load_new_list"><img src ="/boraMallH5T/cssn/images/loading.gif" width="30px" height="30px" />加载中...</div>
</div>
</body>
</html>
