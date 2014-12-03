var _lengthV, _wpFontLength, _wpCoinLength, _hdHeight, _winW, _length, winH,  n=0;
$(function(){
	_winH = document.documentElement.clientHeight;
	_winW = document.documentElement.clientWidth;
	if( _winW < 1024){
		_winW = 1024;
	}
	_length = $(".layer_top").children().length;
	_hdHeight = $("#Header").height() + 1;
	$(".cont_box_1, .banner_bottom, #Banner").css({"height": _winH - 86 +"px"});
	$(".wp_font ul li:first-child").css({"left": - parseInt( _winW * 0.43 ) +"px", "opacity":1});
	_wpFontLength = $(".wp_font_layer ul").children().length;
	_wpImgLength = $(".wp_img_layer ul").children().length;
	_wpCoinLength = $(".wp_coin").children().length;
	auto_home();
	ac_wrapper();
	if ( _wpFontLength !== _wpImgLength) {
		return;
	};
	$(".wp_coin li").bind("click", function(){
		$(this).addClass("wp_currse").siblings().removeClass("wp_currse");
		ac_wrapper();
	});
	$(".iphone, .android").bind("mouseover", function(){
		clearInterval(t);
		$(this).children(".code_area_box").stop(true).show();
	}).bind("mouseout", function(){
		t = setInterval("auto_wrapper()",2000);
		$(this).children(".code_area_box").stop(true).hide();
	});;

	t = setInterval("auto_wrapper()",4000);
	if( parseInt(_winW * 0.155) > 224 ){
		$(".ban_btn div").css({"width": "224px", "height": "80px"});
		$(".ban_btn table td img").css("width", "152px")
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
});

function auto_home(){
	//var _winW = document.documentElement.clientWidth;
	var _winH = document.documentElement.clientHeight;
	//var wp_img_width = parseInt(_winW * 0.2666);
	//var wp_img_height = parseInt(parseInt(_winW * 0.2666) / 0.52);

	//屏幕手机
	var marginTop = parseInt(( _winW * 888 / 1903 - 86 ) * 0.1);
	var _nImgHeight = parseInt( _winW * 888 / 1903) - 86 - marginTop;
	var _nImgWidth = parseInt(_nImgHeight * 573 / 1101);
	
	
	$(".wp_img").css({"height": _nImgHeight +"px", "width": _nImgWidth +"px", "margin-top": marginTop +"px"});
	$(".wp_bottom").css({"height": _nImgHeight +"px", "width": _nImgWidth +"px"});
	$(".wp_font").css({"width": _winW - _nImgWidth - parseInt(_winW*0.14) - 10 +"px"})
	_padTop = parseInt( _nImgHeight * (178/1101));
	_padLeft = parseInt( _nImgWidth * ( 50 / 573));
	_wpImgWidth = parseInt( _nImgWidth * (480/573));
	_wpImgHeight = parseInt( _wpImgWidth * 852 / 480);
	$(".wp_img_layer").css({"padding": _padTop +"px 0 0 "+ _padLeft +"px", "width": _wpImgWidth +"px", "height": _wpImgHeight +"px" });
	$(".cont_box_1, #Banner").css({"height": _nImgHeight + marginTop +"px"});
	$(".banner_bottom").css({"height": _nImgHeight + marginTop +"px"});
	$(".cont_02_left").css({"width": parseInt(_winW * 0.395) +"px", "height": parseInt(parseInt(_winW * 0.395) / (852/993))+"px"});
	$(".cont_03_right").css({ "width": parseInt(_winW * 0.34) +"px", "height": parseInt(parseInt(_winW * 0.34) / (1164/1032))+"px"});
	$(".cont_03_left").css({"width":  parseInt(_winW * 0.46) +"px"})
	$(".cont_03_null").css({ "height": parseInt(parseInt(_winW * 0.34) / (1062/1044))+"px"});
	$(".cont_04_left").css({"width": parseInt(_winW * 0.54) +"px", "height": parseInt(parseInt(_winW * 0.54) / (1167/800))+"px"});
	
	//banner font
	$(".wp_font ul").css({"left": parseInt( _winW * 0.53 ) +"px", "top": parseInt(_wpImgHeight * (202/815))+"px"});
	$(".wp_font").css({"width": parseInt( _winW * 0.55 ) +"px", "height": _nImgHeight + marginTop +"px"});
	$(".wp_font ul li").css({"width": parseInt( _winW * 0.43 ) +"px", "height": parseInt( _winW * 0.43 ) * 383 / 930 + "px"});
	$(".wp_font_layer ul").children().eq(_lengthV).css({"opacity":1, "left": - parseInt(_winW * 0.43) +"px"});
	$(".wp_font_layer ul li:lt("+ _lengthV +")").stop(true).css({"opacity":"0", "left": - parseInt(_winW * 0.43) +"px"});
	$(".wp_font_layer ul li:gt("+ _lengthV +")").stop(true).css({"opacity":"0", "left":"0"});
	
	//btn
	$(".ban_btn div").css({"width": parseInt(_winW * 0.155) + "px", "height": parseInt( _winW * 0.155 * 80 / 224) +"px"});
	if(parseInt(_winW * 0.155) < 224){
		$(".ban_btn table td img").css("width", parseInt(_winW * 0.155 * 0.68))
	}
	$(".ban_btn").css({ "width": parseInt(_winW * 0.50) + "px"});
	$(".iphone").css({"margin-right": parseInt( _winW * 0.02) +"px"})
	
	// 二维码
	$(".code_area_box").css({"width": parseInt( _winW * 0.1) +"px", "height": parseInt( _winW * 0.1 * 169 / 150) +"px", "bottom": - parseInt( _winW * 0.1 * 169 / 150) +"px", "margin-left": - parseInt( _winW * 0.1 / 2) +"px"})
	$(".put_area").css({ "width": parseInt( _winW * 0.0625) +"px", "height": parseInt( _winW * 0.0625) +"px", "margin":  - parseInt( _winW * 0.0625 / 2 + 3) +"px 0 0 "+ - parseInt( _winW * 0.0625 / 2 + 3) +"px"});
	
}
$(window).resize(function () {
	_winH = document.documentElement.clientHeight;
	_winW = document.documentElement.clientWidth;
	if(_winW < 1024){
		_winW = 1024;
	}
	$(".cont_box_1, .banner_bottom, #Banner").css({"height": _winH - 86 +"px", "width": "100%"});
	auto_home();
	if( parseInt(_winW * 0.155) > 224 ){
		$(".ban_btn div").css({"width": "224px", "height": "80px"});
		$(".ban_btn table td img").css("width", "152px")
	}
	
}); 

function ac_wrapper(){
	$(".wp_coin").find("li").each(function(){
		if($(this).hasClass("wp_currse")){
			_lengthV = $(this).index();
		}
	});
	$(".wp_font_layer ul").children().eq(_lengthV).animate({"opacity":1, "left": - parseInt(_winW * 0.43) +"px"},500);
	$(".wp_font_layer ul li:lt("+ _lengthV +")").stop(true).animate({"opacity":"0", "left":- parseInt(_winW * 0.43 + 100) +"px"},500);
	$(".wp_font_layer ul li:gt("+ _lengthV +")").stop(true).animate({"opacity":"0", "left":"0"},500);
	
	$(".wp_img_layer ul").children().eq(_lengthV).animate({"left": "0"});
	$(".wp_img_layer ul li:lt("+ _lengthV +")").stop(true).animate({"left":"0"});
	$(".wp_img_layer ul li:gt("+ _lengthV +")").stop(true).animate({"left": _wpImgHeight +"px"});
}
function auto_wrapper(){
	$(".wp_coin").find("li").each(function(){
		if($(this).hasClass("wp_currse")){
			_lengthV = $(this).index();
		}
	});
	var h = _lengthV;
	if( h < _wpCoinLength){
		$(".wp_coin").children().eq(n).addClass("wp_currse").siblings().removeClass("wp_currse");
		ac_wrapper();
		n = n+1;
	}
	if( n == _wpCoinLength){
		n = 0;
	}
}