var _winH = document.documentElement.clientHeight, n, h = 0, j = 0, t, a=0;
$(function(){
	//_newSize();
	auto();
	picIn();
	bannerAuto_ex();
	ex_area01();
	$(".mac_area ul li:first-child").css("left",0);
	$(".mac_area_ex05 ul li:first-child").css("left",0);
	setInterval(function(){
		bannerAuto_ex();
	},4000);
});
t = setTimeout(function(){$(".core_area").css("display","none");})
function btn_show(thisv){
	$(thisv).children(".core_area").css("display","block");
}
function btn_hide(thisv){
	$(thisv).children(".core_area").css("display","none");
}
function setPage(val0){
	//_winH = document.documentElement.clientHeight;
	n = val0;
	var topV = n * _winH;
	$(".contenter").animate({"top": -topV +"px"},100);
	setTimeout(function(){$("#Coin ul li:eq("+ n +")").addClass("curror").siblings().removeClass("curror")},500);
	_change_ex(n);
	//$("#Coin ul li:eq("+ n +")").addClass("curror").siblings().removeClass("curror");
}
var bannerAuto_ex = function(){
	var _lengthL = $(".banner_cont ul").children().length;
	$(".banner_cont li:eq("+ j +")").animate({opacity:1}).siblings().animate({opacity:0});
		j ++;
		if( j == _lengthL){
			j = 0;
		}
}
var auto = function(){
	//var winH = document.documentElement.clientHeight;
	var winW = document.documentElement.clientWidth;
	var contLength = $(".contenter").children().length - 1;
	$(".area_cont").css("height", _winH +"px");
	$("body").css("height",_winH+"px");
	//$(".contenter").css("height", contLength*winH +"px");
	//$("#Contenter").css("height", contLength*winH + winH +"px");
	//experience page
	$(".banner_left").css("left", (winW - 1120)/2/winW*100 +"%");
}
var picIn = function(){
	//var wHeight = document.documentElement.clientHeight;
	var wWidth = document.documentElement.clientWidth;
	if( wWidth/_winH < 1920/1000 ){
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
	}else if(top - 2*_winH > _winH && top - 3*_winH < _winH){
		return 3;
	}
	else if(top - 3*_winH > _winH && top - 4*_winH < _winH){
		return 4;
	}
	else if(top - 4*_winH > _winH && top - 5*_winH < _winH){
		return 5;
	}else{
		return 6;
	}
}
var _change_ex = function(){
	if(parseInt(n) == 0){

		ex_area02Hide();
		ex_area03Hide();
		ex_area04Hide();
		ex_area05Hide();
	}else if(parseInt(n) == 1){
		ex_area02();
		ex_area03Hide();
		ex_area04Hide();
		ex_area05Hide();
	}else if(parseInt(n) == 2){
		ex_area03();
		ex_area02Hide();
		ex_area04Hide();
		ex_area05Hide();

	}else if(parseInt(n) == 3){
		ex_area04();
		ex_area02Hide();
		ex_area03Hide();
		ex_area05Hide();

	}else if(parseInt(n) == 4){
		ex_area05();
		ex_area04Hide();
		ex_area03Hide();
		ex_area02Hide();

	}else{
		var valueTop = _winH * 4 + 220;
		$(".contenter").stop(true).animate({"top": - valueTop +"px"},500);

	}
	$("#Coin ul li:eq("+ n +")").addClass("curror").siblings().removeClass("curror");
}

var ex_area01 = function(){

}
var ex_area02 = function(){
	$(" #Ex_area02").addClass("show");

}
var ex_area03 = function(){
	$(".high_img").addClass("animated swing").siblings().removeClass("animated swing");
}
var ex_area04 = function(){
	//$(".mark_hotel a.m_h_01").addClass("high_mark");
	$(" #Ex_area04").addClass("show_ex04");
	$(".show_ex04 .mark_hotel a.m_h_01").stop(true).animate({ left: "0", top:"0", opacity:"1"}, 800);
	$(".show_ex04 .mark_hotel a.m_h_02").stop(true).animate({ left: "130px", top:"0", opacity:"1"}, 1000);
	$(".show_ex04 .mark_hotel a.m_h_03").stop(true).animate({ left: "260px", top:"0", opacity:"1"}, 1200);
	$(".show_ex04 .mark_hotel a.m_h_04").stop(true).animate({ left: "390px", top:"0", opacity:"1"}, 1400);

}
var ex_area05 = function(){
	//$(".ex_area05_right a.m_s_01").addClass("high_supply");
	$(".ex_area05_right a.m_s_01").stop(true).animate({ left:"0", top:"0", opacity:"1"}, 1000);
	$(".ex_area05_right a.m_s_02").stop(true).animate({ left:"0", top:"93px", opacity:"1"}, 1300);
	$(".ex_area05_right a.m_s_03").stop(true).animate({ left:"0", top:"186px", opacity:"1"}, 1600);
	$(".ex_area05_right a.m_s_04").stop(true).animate({ left:"0", top:"279px", opacity:"1"}, 1900);
	$(".ex_area05_right a.m_s_05").stop(true).animate({ left:"0", top:"372px", opacity:"1"}, 2100);
	$(" #Ex_area05").addClass("show_ex05");
	

}
var ex_area01Hide = function(){

}
var ex_area02Hide = function(){
	$("#Ex_area02").removeClass("show");
}
var ex_area03Hide = function(){
	$(".high_img").removeClass("animated swing");

}
var ex_area04Hide = function(){
	$(".mark_hotel a.m_h_01").stop(true).animate({ left: "300px", top:"-250px", opacity:"0"}, 800);
	$(".mark_hotel a.m_h_02").stop(true).animate({ left: "300px", top:"-250px", opacity:"0"}, 1000);
	$(".mark_hotel a.m_h_03").stop(true).animate({ left: "300px", top:"-250px", opacity:"0"}, 1200);
	$(".mark_hotel a.m_h_04").stop(true).animate({ left: "300px", top:"-250px", opacity:"0"}, 1400);
	$("#Ex_area04").removeClass("show_ex04");
	
}
var ex_area05Hide = function(){
	$(".ex_area05_right a.m_s_01").stop(true).animate({ left: "-500px", top:"250px", opacity:"0"}, 800);
	$(".ex_area05_right a.m_s_02").stop(true).animate({ left: "-500px", top:"250px", opacity:"0"}, 1000);
	$(".ex_area05_right a.m_s_03").stop(true).animate({ left: "-500px", top:"250px", opacity:"0"}, 1200);
	$(".ex_area05_right a.m_s_04").stop(true).animate({ left: "-500px", top:"250px", opacity:"0"}, 1400);
	$(".ex_area05_right a.m_s_05").stop(true).animate({ left: "-500px", top:"250px", opacity:"0"}, 1600);
	$("#Ex_area05").removeClass("show_ex05");
	
}
var mark_hotel_show = function(hotel_index, d){
	$(d).addClass("hotel_hover").siblings().removeClass("high_mark hotel_hover");
	$(".mac_area ul li:eq("+hotel_index+")").stop(true).animate({"opacity":1,left:0},800);
	$(".mac_area ul li:lt("+ hotel_index +")").stop(true).animate({"opacity":"0", "left":"0"},500);
	$(".mac_area ul li:gt("+ hotel_index +")").stop(true).animate({"opacity":"0", "left":"0"},500);
}
var mark_supply_show = function(hotel_index, d){
	$(d).addClass("supply_hover").siblings().removeClass("supply_hover high_supply");
	$(".mac_area_ex05 ul li:eq("+hotel_index+")").stop(true).animate({"opacity":1,left:0},800);
	$(".mac_area_ex05 ul li:lt("+ hotel_index +")").stop(true).animate({"opacity":"0", "left":"0"},500);
	$(".mac_area_ex05 ul li:gt("+ hotel_index +")").stop(true).animate({"opacity":"0", "left":"0"},500);
}
var step_shop = function(step_index, thisV){
	$(thisV).addClass("high_img hover animated swing").siblings().removeClass("high_img hover animated swing");;
	$(thisV).stop(true).addClass("animated swing").siblings().removeClass("animated swing");
	$(".shoppingPro_left ul li:eq("+step_index+")").stop(true).animate({"opacity":"1"},800);
	$(".shoppingPro_left ul li:lt("+ step_index +")").stop(true).animate({"opacity":"0"},500);
	$(".shoppingPro_left ul li:gt("+ step_index +")").stop(true).animate({"opacity":"0"},500);
}
var times = 0, n=0;
var isOpera = navigator.userAgent.indexOf("Opera") > -1 
var isIE = navigator.userAgent.indexOf("compatible") > -1 && navigator.userAgent.indexOf("MSIE") > -1 && !isOpera;
var isMac = (navigator.platform == "Mac68K") || (navigator.platform == "MacPPC") || (navigator.platform == "MacIntel") || (navigator.platform == "Macintosh");  
var B = navigator.userAgent.match(/(iPhone|iPod|iPad|Android|BlackBerry|Windows Phone|isMac)/);
function mouscrolltop(event){
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
			if(n==5){
				$(".contenter").stop(true).animate({"top": -(_winH*4+220) +"px"},500);
				$("#Coin").hide();
				return;
			}
			if( n > 6){
				n=5;
				return;
			}
			$("#Coin li").eq(n).click();
			$("#Coin").show();
		}
		
		_change_ex(n);
/*		console.log(1)
		
		_winH = document.documentElement.clientHeight;
		//n = h_v();
		_change_ex();
		n++;*/
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
				if(n==5){
					$(".contenter").stop(true).animate({"top": -(_winH*4+220) +"px"},500);
					$("#Coin").hide();
					return;
				}
				if( n > 6){
					return;
				}
				$("#Coin li").eq(n).click();
				$("#Coin").show();
				_change_ex(n);
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
				_change_ex(n);
			}
            //alert("向下");
            break;
        default:           
    }  
}, false);
}





















