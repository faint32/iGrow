function selectTag(indexs, url) {
    var tags = document.getElementById("tabwarp").getElementsByTagName("li");
    var tagsLength = document.getElementById("tabwarp").getElementsByTagName("li").length;
    ids = "tagContent";
    ids = ids + "" + indexs;
    var idtabs = document.getElementById(ids);
    //初始化
    for (i = 0; i < tagsLength; i++) {
        tags[i].className = "";
        document.getElementById("tagContent" + i).style.display = "none";
    }
    //改内容
    tags[indexs].className = "selectTag";
    document.getElementById(ids).style.display = "block";

}
$(function(){
	auto();
	picIn();
	if(document.documentElement.clientWidth<1120)$("#Contenter, .copyright").css("width","1120px")
});
var auto = function(){
	var winH = document.documentElement.clientHeight;
	var winW = document.documentElement.clientWidth;
	$("#Contenter").css("height", winH +"px");
	if(winH < 757){
		$("#Contenter").css("height", 757 +"px");
	}
}
var picIn = function(){
	var wHeight = document.documentElement.clientHeight;
	var wWidth = document.documentElement.clientWidth;
	if( wWidth/wHeight < 1920/1000 ){
		$(".img_area img").css({ height: "100%", width:"auto"});
	}else{
		$(".img_area img").css({ width: "100%", height:"auto"});
	}
} 
$(window).resize(function () {
	auto();
	picIn();

});