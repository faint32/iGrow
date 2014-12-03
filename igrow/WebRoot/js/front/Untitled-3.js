var i = 1;
var _length, winH;
var _lengthV, _wpFontLength, _wpCoinLength, _hdHeight, _winW,  n=0;
$(function(){
	_winH = document.documentElement.clientHeight;
	_winW = document.documentElement.clientWidth;
	_length = $(".layer_top").children().length;
	_hdHeight = $("#Header").height() + 1;
	$(".cont_box_1, .banner_bottom").css({"height": _winH +"px"});
	//$("#Contenter, .layer_top").css("height", _winH * _length);
	$(".wp_font ul li:first-child").css({"left":"-460px", "opacity":1});
	//$(".wp_img_layer ul li:first-child").css("left", "0");
	_wpFontLength = $(".wp_font_layer ul").children().length;
	_wpImgLength = $(".wp_img_layer ul").children().length;
	_wpCoinLength = $(".wp_coin").children().length;
	auto_home();
	picIn();
	ac_wrapper();
	if ( _wpFontLength !== _wpImgLength) {
		return;
	};
	$(".wp_coin li").bind("click", function(){
		$(this).addClass("wp_currse").siblings().removeClass("wp_currse");
		ac_wrapper();
	});
	for(i=1; i < _lengthV + 1; i++){
		$(".cont_box_0"+i).css("z-index",i);
	}
	setInterval("auto_wrapper()",2000);
	
});
function picIn(){
	console.log(_winW);
	console.log(_winH);
	if( _winW / _winH < 2000/1250 ){
		$(".banner_bottom img").css({ "height": "100%", "width":"auto"});
	}else{
		$(".banner_bottom img").css({ "width": "100%", "height":"auto"});
	}
}
function auto_home(){
	var _winW = document.documentElement.clientWidth;
	var _winH = document.documentElement.clientHeight;
	var wp_img_width = parseInt(_winW * 0.2666);
	var wp_img_height = parseInt(parseInt(_winW * 0.2666) / 0.52);
	//console.log(wp_img_width);
	//console.log(wp_img_height);
	
	if(wp_img_width / wp_img_height < 0.5204){
		//console.log(1)
		$(".wp_img").css({"width": wp_img_width +"px", "height": wp_img_width / (573/1101) +"px"});
		$(".wp_font").css({"width": _winW - wp_img_width - parseInt(_winW*0.14) - 10 +"px"});
		_padTop = parseInt( wp_img_width / (573/1101) * (178/1101));
		_padLeft = parseInt( wp_img_width * ( 50 / 573));
		_wpImgWidth = parseInt( wp_img_width * (480/573));
		_wpImgHeight = parseInt( wp_img_width / (573/1101) * (853/1101));
		$(".wp_img_layer").css({"padding": _padTop +"px 0 0 "+ _padLeft +"px", "width": _wpImgWidth +"px", "height": _wpImgHeight +"px" });
	}else{
		//console.log(2)
		var _nImgHeight = _winH - 86 - ((_winH - 86)*0.1);
		var _nImgWidth = parseInt(_winH - 86 - ((_winH - 86)*0.1))*(573/1101);
		$(".wp_img").css({"height": _nImgHeight +"px", "width": _nImgWidth +"px", "margin-top": parseInt(( _winH - 86)*0.1) + 1 +"px"});
		$(".wp_font").css({"width": _winW - _nImgWidth - parseInt(_winW*0.14) - 10 +"px"})
		_padTop = parseInt(_nImgWidth / (573/1101) * (178/1101));
		_padLeft = parseInt(_nImgWidth * ( 50 / 573));
		_wpImgWidth = parseInt( _nImgWidth * (480/573));
		_wpImgHeight = parseInt( _nImgWidth / (573/1101) * (853/1101));
		$(".wp_img_layer").css({"padding": _padTop +"px 0 0 "+ _padLeft +"px", "width": _wpImgWidth +"px", "height": _wpImgHeight +"px" });
		
	}
	//alert(_winW)
	$(".cont_02_left").css({"width": parseInt(_winW * 0.395) +"px", "height": parseInt(parseInt(_winW * 0.395) / (852/993))+"px"});
	$(".cont_03_right").css({ "width": parseInt(_winW * 0.34) +"px", "height": parseInt(parseInt(_winW * 0.34) / (1062/1044))+"px"});
	$(".cont_03_null").css({ "height": parseInt(parseInt(_winW * 0.34) / (1062/1044))+"px"});
	
	
	
	
	
	
	
}
$(window).resize(function () {
	_winH = document.documentElement.clientHeight;
	_winW = document.documentElement.clientWidth;
	auto_home();
	picIn();
	
/*	if( document.documentElement.clientWidth < 950){
		$(".ver_mid ul li").animate({"fontSize":"16px"}, 100);
		$(".ver_mid").animate({"fontSize":"14px"}, 100);
		$(".title_header img").css({"width": parseInt(document.documentElement.clientWidth * 0.21) +"px"});
		$(".ver_mid ul li img").css({"width": parseInt(document.documentElement.clientWidth * 0.03) +"px"})
	}else{
		$(".ver_mid ul li").animate({"fontSize":"20px"}, 100);
		$(".title_header img").css({"width": "304px"});
		$(".ver_mid ul li img").css({"width": "46px"})
	}*/
	
}); 

function ac_wrapper(){
	$(".wp_coin").find("li").each(function(){
		if($(this).hasClass("wp_currse")){
			_lengthV = $(this).index();
		}
	});
	$(".wp_font_layer ul").children().eq(_lengthV).animate({"opacity":1, "left": "-460px"},500);
	$(".wp_font_layer ul li:lt("+ _lengthV +")").stop(true).animate({"opacity":"0", "left": "- 800px"},500);
	$(".wp_font_layer ul li:gt("+ _lengthV +")").stop(true).animate({"opacity":"0", "left":"0"},500);
	//console.log($(".wp_font_layer ul").children().eq(_lengthV).html())
	
	$(".wp_img_layer ul").children().eq(_lengthV).animate({"left": "0"});
	//$(".wp_img_layer ul").children().eq(_lengthV).animate({"left": "322px"});
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
		//console.log(n)
	}
	if( n == _wpCoinLength){
		n = 0;
	}
}