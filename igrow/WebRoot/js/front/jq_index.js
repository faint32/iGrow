var _winH = document.documentElement.clientHeight, n, h = 0, j = 0,a=0;
$(function(){
	//_newSize();
	auto();
	picIn();
	bannerAuto();
	_area01();
	$(".banner_img li:first-child").css("opacity",1);
	setInterval(function(){
		bannerAuto();
	},2000);
});
function setPage(val0){
	//_winH = document.documentElement.clientHeight;
	n = val0;
	//_change();
	//alert(_winH)
	var topV = n * _winH;
	$(".contenter").animate({"top": -topV +"px"},100);
	setTimeout(function(){$("#Coin ul li:eq("+ n +")").addClass("curror").siblings().removeClass("curror")},500);
	_change(n);
	//alert($("html, body").scrollTop());
	//h_v();
}
var bannerAuto = function(){
	$(".banner_img li:eq("+ h +")").animate({opacity:1},1000);
	$(".banner_img li:eq("+ h + 1 +")").animate({opacity:0},1000)
		h ++;
		if( h == 2){
			h = 0;
		}
}
var auto = function(){
	//var winH = document.documentElement.clientHeight;
	var winW = document.documentElement.clientWidth;
	var contLength = $(".contenter").children().length - 1;
	$(".area_cont").css("height", _winH +"px");
	$("body").css("height",_winH+"px");
	//$(".contenter").css("height", contLength*winH +"px");
	//$("#Contenter").css("height", winH +"px");
	$(".hotel_smart").css("margin-top", - parseInt((_winH - 620)/2 + 620 -40) +"px");
	$(".hotel_model").css("margin-top",  - parseInt((_winH - 608)/2 + 608 - 50) +"px");
}
var picIn = function(){
	//var wHeight = document.documentElement.clientHeight;
	var wWidth = document.documentElement.clientWidth;
	if( wWidth/_winH < 1920/1080 ){
		$(".img_area img").css({ height: "100%", width:"auto"});
	}else{
		$(".img_area img").css({ width: "100%", height:"auto"});
	}
} 
$(window).resize(function () {
	var sUserAgent = navigator.userAgent.toLowerCase();
	var bIsAndroid = sUserAgent.match(/android/i) == "android";
	if(bIsAndroid&&document.documentElement.clientWidth>document.documentElement.clientHeight){
		if(a==0){
			_winH = document.documentElement.clientHeight;
			a=1;
		}
		auto();
		picIn();
		setPage(n);
		return;
	}else if(bIsAndroid&&document.documentElement.clientWidth<document.documentElement.clientHeight){
		if(a==1){
			_winH = document.documentElement.clientHeight;
			a=0;
		}
		auto();
		picIn();
		setPage(n);
		return;
	}
	if(bIsAndroid){
		auto();
		picIn();
		setPage(n);
		return;
	}
	_winH = document.documentElement.clientHeight;
	auto();
	picIn();
	setPage(n);

});
var h_v = function(){
	var top= window.pageYOffset ||   
                      (document.compatMode == 'CSS1Compat' ?    
                      document.documentElement.scrollTop :   
                      document.body.scrollTop);
					 // alert(top)
	if( top - _winH <0){
		return 0;
	}else if(top - _winH >= 0 && top - _winH < _winH ){
		return 1;
	}else if(top - _winH > _winH && top - 2*_winH < _winH){
		return 2;
	}else{
		return 3;
	}
}
var _change = function(){
	if(parseInt(n) == 0){
		_area01();
		_area02Hide();
		_area03Hide();
	}else if(parseInt(n) == 1){
		_area02();
		_area03Hide();
		_area01Hide();
	}else if(parseInt(n) == 2){
		_area03();
		_area02Hide();
		_area01Hide();
	}else{
		_area02Hide();
		_area01Hide();
	}
	$("#Coin ul li:eq("+ n +")").addClass("curror").siblings().removeClass("curror");
}
var _area03 = function(){
	$(" #area03 .c_t_left img").stop(true).animate({"left":"242px", opacity:1}, 1000)
	$(" #area03 .c_t_right img").stop(true).animate({"right":"0px", opacity:1}, 1000)
	$(" #Images17_font img").stop(true).animate({"left":"101px", opacity:1}, 1000)
}
var _area02 = function(){
	$(" #area02 .c_t_left img").stop(true).animate({"left":"242px", opacity:1}, 1000)
	$(" #area02 .c_t_right img").stop(true).animate({"right":"0px", opacity:1}, 1000)
	$(" #Images16_font img").stop(true).animate({"top":"199px", opacity:1}, 1000)
}
var _area01 = function(){
	$(".hotel_smart").stop(true).animate({"left":"54px", opacity:1},1000);
}
var _area01Hide = function(){
	$(".hotel_smart").stop(true).animate({"left":"-500px", opacity:0},1000);
}
var _area03Hide = function(){
	$(" #area03 .c_t_left img").stop(true).animate({"left":"-500px", opacity:0}, 1000)
	$(" #area03 .c_t_right img").stop(true).animate({"right":"-500px", opacity:0}, 1000)
	$(" #Images17_font img").stop(true).animate({"left":"-500px", opacity:0}, 1000)
}
var _area02Hide = function(){
	$(" #area02 .c_t_left img").stop(true).animate({"left":"-500px", opacity:0}, 1000)
	$(" #area02 .c_t_right img").stop(true).animate({"right":"-500px", opacity:0}, 1000)
	$(" #Images16_font img").stop(true).animate({"top":"800px", opacity:0}, 1000)
}
var times = 0, n=0;
var isOpera = navigator.userAgent.indexOf("Opera") > -1 
var isIE = navigator.userAgent.indexOf("compatible") > -1 && navigator.userAgent.indexOf("MSIE") > -1 && !isOpera;
var isMac = (navigator.platform == "Mac68K") || (navigator.platform == "MacPPC") || (navigator.platform == "MacIntel") || (navigator.platform == "Macintosh");  
var B = navigator.userAgent.match(/(iPhone|iPod|iPad|Android|BlackBerry|Windows Phone|isMac)/);
function mouscrolltop(event){
	//console.log(navigator.platform)
	if(!isIE || B){
		event.preventDefault();
	}
	var event = window.event || event;
	var	Today = new Date(); 
	var timeStamp = Today.getTime(); 
	if(timeStamp-times>2500){
		times=timeStamp;
		if(event.wheelDelta>0 || event.detail<0){
			n--;
			if( n < 0){
				n=0;
				return;
			}
			$("#Coin li").eq(n).click();
			$("#Coin").show();
		}else if(event.wheelDelta<0 || event.detail>0){
			
			n++;
			if(n==3){
				$(".contenter").stop(true).animate({"top": -(_winH*2+220) +"px"},500);
				$("#Coin").hide();
				return;
			}
			if( n > 4){
				return;
			}
			$("#Coin li").eq(n).click();
			$("#Coin").show();
		}
		
		_change(n);
	}
	
};
document.addEventListener && document.addEventListener("DOMMouseScroll", mouscrolltop, false);
window.onmousewheel = document.onmousewheel = mouscrolltop;
(function(b) {
	b.fn.fullpage = function(c) {
		c = b.extend({
			autoScrolling: !0
		}, c);
		var isMac = (navigator.platform == "Mac68K") || (navigator.platform == "MacPPC") || (navigator.platform == "MacIntel") || (navigator.platform == "Macintosh");  
		var B = navigator.userAgent.match(/(iPhone|iPod|iPad|Android|BlackBerry|Windows Phone|isMac)/);
		b(document).on("touchmove", function(a) {
			if (c.autoScrolling && B) {
				a.preventDefault();
			}
		});
	}
})(jQuery);
//返回角度
if(!isIE || B){
function GetSlideAngle(dx, dy) {
    return Math.atan2(dy, dx) * 180 / Math.PI;
}
 
//根据起点和终点返回方向 1：向上，2：向下，3：向左，4：向右,0：未滑动
function GetSlideDirection(startX, startY, endX, endY) {
    var dy = startY - endY;
    var dx = endX - startX;
    var result = 0;
 
    //如果滑动距离太短
    if (Math.abs(dx) < 10 && Math.abs(dy) < 10) {
        return result;
    }
 
    var angle = GetSlideAngle(dx, dy);
    if (angle >= 0 && angle < 180) {
		result = 1;
	}else{
		result = 2;
	}
 
    return result;
}
 
//滑动处理
var startX, startY;
document.addEventListener('touchstart', function (ev) {
    startX = ev.touches[0].pageX;
    startY = ev.touches[0].pageY;  
}, false);
document.addEventListener('touchend', function (ev, event) {
    var endX, endY;
    endX = ev.changedTouches[0].pageX;
    endY = ev.changedTouches[0].pageY;
    var direction = GetSlideDirection(startX, startY, endX, endY);
    switch (direction) {
        case 0:
            //alert("没滑动");
            break;
        case 1:
			var	Today = new Date(); 
			var timeStamp = Today.getTime();
			if(timeStamp-times>2500){
				times=timeStamp;
				n++;
				if(n==3){
					$(".contenter").stop(true).animate({"top": -(_winH*2+220) +"px"},500);
					$("#Coin").hide();
					return;
				}
				if( n > 4){
					return;
				}
				$("#Coin li").eq(n).click();
				$("#Coin").show();
				_change(n);
			}
            //alert("向上");
            break;
        case 2:
			var	Today = new Date(); 
			var timeStamp = Today.getTime();
			if(timeStamp-times>2500){
				times=timeStamp;
				n--;
				if( n < 0){
					n=0;
					return;
				}
				$("#Coin li").eq(n).click();
				$("#Coin").show();
				_change(n);
			}
            //alert("向下");
            break;
        default:           
    }  
}, false);
}