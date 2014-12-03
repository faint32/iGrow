var _winW;
$(window).resize(function () {
	_winW = document.documentElement.clientWidth;
	if( _winW < 1024){
		_winW = 1024;
	}
	auto_Img();
	if( parseInt(_winW * 0.155) > 224 ){
		$(".ban_btn div").css({"width": "224px", "height": "80px"});
		$(".ban_btn table td img").css("width", "152px")
	} 
});
auto_Img = function(){
	$("#Banner").css("height", parseInt( _winW * 685 / 1440 ) +"px");
	$(".content_table_in img").css("width", parseInt( _winW * 0.88) +"px");
	$("#tagContent0 .cont02 img").css("width", parseInt( _winW * 0.7277) +"px");
	$(".cont02_bottom img").css("width", "100%");
	$(".cont02").css("height", parseInt( _winW * 715 / 1440 ) +"px");
	var tel_width = parseInt( _winW * (377/1440));
	var tel_height = parseInt(tel_width * 602 / 377);
	var tel_width_font = parseInt( _winW * (567/1440));
	var tel_height_font = parseInt(tel_width_font * 225 / 855)
	$(".ban_bottom_img").css({"width": tel_width +"px", "height": tel_height +"px"});
	var font_mT =  parseInt( (_winW * 685 / 1440) * (180/700)) 
	$(".ban_bottom_img02").css({"width": tel_width_font +"px", "height": tel_height_font +"px", "margin-right": parseInt(_winW * 0.04) +"px", "margin-top": font_mT +"px"});
	
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
$(function(){
	_winW = document.documentElement.clientWidth;
	if( _winW < 1024){
		_winW = 1024;
	}
	auto_Img();
	$(".iphone, .android").bind("mouseover", function(){
		$(this).children(".code_area_box").stop(true).show();
	}).bind("mouseout", function(){
		$(this).children(".code_area_box").stop(true).hide();
	});
	if( parseInt(_winW * 0.155) > 224 ){
		$(".ban_btn div").css({"width": "224px", "height": "80px"});
		$(".ban_btn table td img").css("width", "152px")
	} 

});