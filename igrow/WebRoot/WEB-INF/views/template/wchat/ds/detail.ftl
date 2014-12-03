<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta charset="utf-8">
    <meta http-equiv="Cache-control" />
    <meta name="format-detection" content="telephone=no" />
    <meta content="yes" name="apple-mobile-web-app-capable" />
    <meta content="black" name="apple-mobile-web-app-status-bar-style" />
    <meta content="telephone=no" name="format-detection" />
    <meta name="viewport" content="width=device-width; maximum-scale=1.0;  user-scalable=no; initial-scale=1.0" />
    <title>商品规格</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/css/wchat/masterPage.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/css/wchat/designDetail.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/css/wchat/idangerous.swiper.css">
    <script type="text/javascript" src="${contextPath}/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${contextPath}/js/idangerous.swiper-1.8.min.js"></script>
    <script type="text/javascript" src="${contextPath}/js/load.js"></script>
    <script type="text/javascript">
        var sUserAgent = navigator.userAgent.toLowerCase();
        var bIsAndroid = sUserAgent.match(/android/i) == "android";
        if (bIsAndroid) {
            document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
                var docH = document.documentElement.clientHeight;
                if ($("body").height() - 1 < docH) {
                    $("#contenter").animate({ "height": docH + "px" }, 500);
                }
                WeixinJSBridge.call('hideToolbar');
            });

        }
        function peo_detail_div(a) {
            $(a).toggleClass("show_child");
            if ($(a).hasClass("show_child")) {
                scrollTopV = $(".pro_detail_title").offset().top;
                $("html, body").animate({ scrollTop: scrollTopV }, 500);
                $(".selectSpecification").show();
                $("#pro_detail_cont").slideDown();
            } else {
                $(".selectSpecification").fadeOut();
                $("#pro_detail_cont").slideUp();
                scrollTopV = $(".pro_detail_title").offset().top;
                $("html, body").animate({ scrollTop: scrollTopV }, 500);
            }
        }
    </script>
    <script type="text/javascript">
        function tip_success() {
            $(".wrong_layer").hide();
        }
    </script>
    <script type="text/javascript">
        function tip_share() {
            if (window.WeixinJSBridge) {
                $("#toFriendArea").css("display", "block");
            }
        }
        function closeThisLayer() {
            $(".black_layer_payAfter").hide();
        }
    </script>
</head>
<body>
    <input type="hidden" id="shareUrl" />
    <input type="hidden" id="pro_titlehidden" />
    <input type="hidden" id="imageShow" />
    <div id="contenter">
        <div class="contBody">
        	<div class="design_detail_summary">
        		<p class="design_Avatar"><img src="/boraMallH5T/cssn/images/Designimg_icon.jpg" width="64"></p>
        		<p class="design_name">一宅一朴</p>
        		<p class="design_simple">木迹制品，做喜欢的事，发现生活...</p>
        		<p class="design_shareNum"><i id="BuyNum">3000</i>人分享<br /><i id="BuyNum">200</i>人购买</p>
        		<div class="designStyle">
        			<span class="rest"><img src="/boraMallH5T/cssn/images/rest_icon.png" width="16">TA在休息</span>
        			<span class="contactHe"><img src="/boraMallH5T/cssn/images/contactHe_icon.png" width="16">联系TA</span>
        		</div>
        	</div>
            <div class="spe_infor_n">
                <div class="pro_detail_addNew">
                    <div class="s-detail">
                        <div class="pro_detail_title" onclick="peo_detail_div(this)">
                            <h4>
                                <label class="name_label">TA的简介</label>
                            </h4>
                        </div>
                    </div>
                    <div id="pro_detail_cont">
                        <div class="Interspace">
                            <div class="selectSpecification">
                            	<img src="/boraMallH5T/cssn/images/designer_img.jpg" width="100%">
                            	<p>徐白、Rica和玫三位店主是媒体行业的多年伙伴兼好朋友，她们因为对手作器皿及生活器物的共同爱好。她们摒弃了常规的以地域划分的方式，只要是她们认为的“NOZA”（北欧设计Nordic Style和日本杂货Zakka的集合体）风格，便是好的选择。</p>
                            </div>
                            <div class="clear"></div>
                        </div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="contenter">
	            <ul class="designList">
	            	<a>
		            	<li>
		            		<div class="fontShowD Interspace">
			                    <div class="font_left width100Css">
			                        <h2>[2014-10-14]原木创意-乾鹊摆件</h2>
			                        <p class="pro_price">
			                            <span class="now_price">￥<i class="p_price" id="top_Price_now">499</i></span>
			                        </p>
			                    </div>
			                    <div class="clear"></div>
			                </div>
			                <div class="roomDetailShow">
			                    <img width="100%" height="100%" src="http://115.29.232.103:9000/product/38/6/20140306062223.jpg">
			                </div>
			                <div class="fontShowD_out_border">
			                     <p class="buyNum"><i id="BuyNum">0</i>人已购买</p>
			                     <p class="shareNum"><i id="ShareNum">0</i>人已分享</p>
			                     <div class="clear"></div>
			                </div>
		            	</li>
	            	</a>
	            	<a>
		            	<li>
		            		<div class="fontShowD Interspace">
			                    <div class="font_left width100Css">
			                        <h2>[2014-10-14]原木创意-乾鹊摆件</h2>
			                        <p class="pro_price">
			                            <span class="now_price">￥<i class="p_price" id="top_Price_now">499</i></span>
			                        </p>
			                    </div>
			                    <div class="clear"></div>
			                </div>
			                <div class="roomDetailShow">
			                    <img width="100%" height="100%" src="http://115.29.232.103:9000/product/38/6/20140306062223.jpg">
			                </div>
			                <div class="fontShowD_out_border">
			                     <p class="buyNum"><i id="BuyNum">0</i>人已购买</p>
			                     <p class="shareNum"><i id="ShareNum">0</i>人已分享</p>
			                     <div class="clear"></div>
			                </div>
		            	</li>
	            	</a>
	            </ul>
            </div>
        </div>
        <style type="text/css">
            body {
                background-color: #fff;
            }
        </style>
</body>
</html>

