$(function(){
	first();
	$(".top05 .pageColm a").eq($(".top05 .pageColm a").length-1).css("margin-right","2px");
	$(".operating a").live("click", function(){
		$(this).parent().parent().parent().addClass("change_bg_tr").siblings().removeClass("change_bg_tr");
	});
	$(".content-left tr").live("click", function(){
		$(this).addClass("change_bg_tr").siblings().removeClass("change_bg_tr");
	}).live("mouseenter", function(){
		$(this).addClass("change_bg_yelow").siblings().removeClass("change_bg_yelow");
	}).live("mouseleave", function(){
		$(this).removeClass("change_bg_yelow");
	});
	$(".userName").live("click", function(){
		$(".elastic_layer_header").first().stop().show();
		$(".ly").show();
	}).mouseleave(function(){
		$(".elastic_layer_header").hide();
		$(".ly").hide();
	});
	$(".ly").live("click", function(){
		$(".elastic_layer_header").hide();
		$(".ly").hide();
	});
	$(".bottomBlock").live("click", function(){
		$(".layer").hide();
	});
	$(".unprocessed-order").live("click", function () {
		$(this).toggleClass("open_two");
		if(!$(this).hasClass("open_two")){
			$(".unprocessed-orders-block").css("display","none");
		}else{
			$(".unprocessed-orders-block").css("display","block");
		}
	});
	$(".nav ul:first").children("li").bind("mouseenter", function(){
		$(this).addClass("currse").siblings().removeClass("currse");
		$(".currseBlock ul.slideNav").css("display","none");
		$("ul.slideNav").css("display","none");
		$(".currse ul.slideNav").css("display","block");
	}).mouseleave(function(){
		$(this).removeClass("currse");
		$("ul.slideNav").css("display","none");
		$(".currseBlock ul.slideNav").css("display","block");
		$(".currse ul.slideNav").css("display","none");
	});

	$("ul.slideNav li").bind("mouseenter", function(){
		$(this).addClass("currseSideNav").siblings().removeClass("currseSideNav");
	}).mouseleave(function(){
		$(this).removeClass("currseSideNav");
	});
	$(".bottomBlock").live("click", function(){
		$("#productShow").hide();
	});

	
	$(".send-btn").live("click", function () {
		$(this).parent().parent().hide();
		$(this).parent().parent().siblings(".delivery").fadeIn();
	});
	$(".closed").live("click", function(){
		$(".layer").hide();
	});
	$(".form-staff-pro").live("click", function(){
		$(".layer-content").hide();
		$(".layerBox").show();
	});
	
	$(".bg_Sort").live("mouseenter", function(){
		$(this).children(".sort_li").show();	
	}).live("mouseleave", function(){
		$(this).children(".sort_li").hide();
	});
	$(".sort_li").live("mouseenter", function(){
		$(this).children(".sort_li").show();	
	}).live("mouseleave", function(){
		$(this).children(".sort_li").hide();
	});
	$(".operating a").live("click", function(){
		$(".operating a").removeClass("seeThisLine");
		$(this).addClass("seeThisLine");
	})
});

$(".deleteThisCole").live("click", function(){
	var  length = $(this).parent().parent().parent().parent().children().length;
	var deleteValue = ($(this).parent().parent().parent().find(".text-put-here").html());
	if($(this).attr("name") == 1){
		$(".outTable").find("tr:gt(0)").each(function(index) {
             if($(this).find("td:eq(0) .empty15").html() == deleteValue){
            	 $(this).remove();
             }
		});
	}
	if($(this).attr("name") == 2){
		$(".innerTable").find("tr").each(function(index) {
             if($(this).find("td:eq(0) .empty15").html() == deleteValue){
            	 $(this).remove();
             }
		});
	}
	if(length-1>1){
        $(this).parent().parent().parent().remove();
	}
	$("tr").find("td").each(function(){
		if($(this).hasClass("Nunb")){
			var _index = $(this).parent().index();
			$(this).html("<span class='empty15'>"+_index+"</span>");
		};
	});
	first();
});

var innerTableNum = 100;
var innerTableNums = 100;
var outTableNum = 50;
var outTableNums = 50;
function add_tr(obj){
	var alertStr = "";
	if($(obj).attr("name")==1){
		alertStr = "请输入商品规格名称";
	}else if($(obj).attr("name")==2){
		alertStr = "请输入商品属性名称";
	}
	var inputValue = $.trim($(obj).parent().parent().parent().find(".fillName").val());
	if(inputValue==""){
		alert(alertStr);
		return;
	}else{
		var specFlag = true;
		var proFlag = true;
		if($(obj).attr("name")==1){
			$(".specMameTable").find("tr:gt(0)").each(function(index) {
				if($(this).find(".text-put-here").html() == inputValue){
					specFlag = false;
				}
			});
			if(!specFlag){
				alert("该规格名称已存在!");
				return;
			}
		}else if($(obj).attr("name")==2){
			$(".proMameTable").find("tr:gt(0)").each(function(index) {
				if($(this).find(".text-put-here").html() == inputValue){
					proFlag = false;
				}
			});
			if(!proFlag){
				alert("该属性名称已存在!");
				return;
			}
		}
	}
	//防止上移箭头消失
	/*$(this).parent().parent().parent().children().find("a").each(function(index, element) {
		if($(this).hasClass("toUp")){
			$(this).show();
		}
	});
	$(this).parent().parent().parent().children().eq(1).find("a").each(function(index, element) {
		if($(this).hasClass("toUp")){
			$(this).hide();
		}
	});*/
	$(obj).parent().parent().parent().parent().children("tr:gt(1)").addClass("show_up_btn");
	//赋值
	$(obj).parent().parent().prev().find(".text-put-here").html($(obj).parent().parent().prev().children().find(".fillName").val());
	$(obj).parent().parent().prev().children().find(".fillNameinput").hide().html("");
	$(obj).parent().parent().prev().find(".text-put-here").next().find("input").val($(this).parent().parent().prev().children().find(".fillName").val());
	$(obj).parent().parent().append("<span class='empty15'><a class='toUp' onclick='move_up(this)'>上移</a><a class='deleteThisCole' name="+$(obj).attr("name")+">删除</a></span>");
	$(obj).parent().parent().removeClass("show-two-btn");
	var _length = $(obj).parent().parent().parent().parent().children().length;
	var this_name = $(obj).attr("name");
	$(obj).parent().parent().parent().parent().append("<tr><td width='95' class='Nunb'><span class='empty15'>"+ _length +"</span></td><td width='290'><span class='empty15'><span class='text-put-here' name='0'></span><span style='display:none;'><input type='text' onblur='saveProductProperty(this)' maxlength='20'/></span><span class='fillNameinput'><input class='fillName' type='text' placeholder='"+alertStr+"' maxlength='20'></span></span></td><td class='show-two-btn' width='217'><span class='empty15'><a class='addTd' name="+ this_name +"  onclick='add_tr(this)'>添加</a><a class='toUp' onclick='move_up(this)'>上移</a></span></td></tr>");
	$(obj).parent().remove();
	if($(obj).attr("name") == 1){
		 var outTable1 = $(".proMameTable").children().find("tr").length-2;
		 var outTable2 = $(".specMameTable").children().find("tr").length-2;
		 var outTable = outTable1 * outTable2;
		 
		/* var contentHtml = "";
		 $(".proMameTable").find("tr:gt(0)").each(function(index) {
			if(index<$(".proMameTable").children().find("tr").length-2){
					contentHtml += "<tr><td width='77' class='ppropertyValue' name='0' class='productSpecNameShow'><span class='empty15'>"+$(this).find(".text-put-here").html()+"</span></td><td width='76'><span class='empty15'><input type='text' class='pmarketPrice' style='width:50px;' value='' maxlength='8' onkeyup=\"clearNoNum(this)\"/></span></td><td width='76'><span class='empty15'><input type='text' class='pproductPrice' style='width:50px;' value='' maxlength='8' onkeyup=\"clearNoNum(this)\"/></span></td>"+
					"<td width='76' class='ptotalStock'><span class='empty15'>0<input type='hidden' class='ptotalStock' style='width:50px;' value='0' maxlength='8' onkeyup=\"this.value=this.value.replace(\/\\D/g,'')\" onafterpaste=\"this.value=this.value.replace(\/\\D/g,'')\"/></span></td><td width='76'><span class='empty15'><input type='text' class='paddStock' style='width:50px;' value='' maxlength='8' onkeyup=\"this.value=this.value.replace(\/[^0-9-]+/,'')\" onafterpaste=\"this.value=this.value.replace(\/[^0-9-]+/,'')\" onblur='addkucun(this)'/></span></td>" +
					"<td width='158'><span class='empty15'><img id='productConfigImg"+(index+outTableNums+outTable)+"' src='../../css/images/no_pic.png' width='143' height='92'></span></td>"+
					"<td width='125'><span class='empty15'><a class='file_update_area'></a><div class='updateLayer_pro'><span id='spanButtonPlaceholder"+(index+outTableNums+outTable)+"'  onmousedown ='clearId(this)'></span><input id='btnCancel"+(index+outTableNums+outTable)+"' type='button' value='取消上传' onclick='cancelQueue(upload1);' disabled='disabled' style='margin-left: 2px; height: 22px; font-size: 8pt; display:none'/></div><span><input type='hidden' class='pimgUrls' id='pimgUrls"+(index+outTableNums+outTable)+"'/></td></tr>";
					outTableNums++;
			}
		 });*/
		 var contentHtml = "";
		 $(".proMameTable").find("tr:gt(0)").each(function(index) {
			if(index<$(".proMameTable").children().find("tr").length-2){
					contentHtml += "<tr><td width='77' class='ppropertyValue' name='0' class='productSpecNameShow'><span class='empty15'>"+$(this).find(".text-put-here").html()+"</span></td><td width='76'><span class='empty15'><input type='text' class='pmarketPrice' style='width:50px;' value='' maxlength='8' onkeyup=\"clearNoNum(this)\"/></span></td><td width='76'><span class='empty15'><input type='text' class='pproductPrice' style='width:50px;' value='' maxlength='8' onkeyup=\"clearNoNum(this)\"/></span></td>"+
					"<td width='76' class='ptotalStock' style='display:none;'><span class='empty15'>0<input type='hidden' class='ptotalStock' style='width:50px;' value='0' maxlength='8' onkeyup=\"this.value=this.value.replace(\/\\D/g,'')\" onafterpaste=\"this.value=this.value.replace(\/\\D/g,'')\"/></span></td><td width='76' style='display:none;'><span class='empty15'><input type='text' class='paddStock' style='width:50px;' value='' maxlength='8' onkeyup=\"this.value=this.value.replace(\/[^0-9-]+/,'')\" onafterpaste=\"this.value=this.value.replace(\/[^0-9-]+/,'')\" onblur='addkucun(this)'/></span></td>" +
					"<td width='158'><span class='empty15'><img id='productConfigImg"+(index+outTableNums+outTable)+"' src='../../css/images/no_pic.png' width='143' height='92'></span></td>"+
					"<td width='125'><span class='empty15'><a class='file_update_area'></a><div class='updateLayer_pro' onclick=\"loadimage('pimgUrls"+(index+outTableNums+outTable)+"','productConfigImg"+(index+outTableNums+outTable)+"')\"></div><span><input type='hidden' class='pimgUrls' id='pimgUrls"+(index+outTableNums+outTable)+"'/></td></tr>";
					outTableNums++;
			}
		 });
		// var outTable3 = $(".outTable").children().find(".productSpecNameShow").length;
		 var outTable3 = $(".proMameTable").children().find("tr").length-2;
		 for(var z= 0 ;z<outTable3;z++){
			 if(contentHtml != null && contentHtml != ""){
					//var url = "../product/configImg.do?imgIndex="+(z+outTableNum+outTable);
					outTableNum++;
			      //  $("#configImghidden").load(url);
			 }
		 }
		 outTableNums ++;
		 outTableNum ++;
		$(".outTable").append("<tr><td class='productSpecNameShow'><span class='empty15'>"+inputValue+"</span></td><td><table  cellspacing='0' cellpadding='0' class='innerTable  no_border left_border' width='664'>"+contentHtml+"</table></td></tr>");
	}else if($(obj).attr("name") == 2){
		 var innerTable1 = $(".proMameTable").children().find("tr").length-2;
		 var innerTable2 = $(".specMameTable").children().find("tr").length-2;
		 var innerTable = innerTable1 * innerTable2;
		/* $(".innerTable").each(function(index) {
			$(this).append("<tr><td width='77' class='ppropertyValue' name='0'><span class='empty15'>"+inputValue+"</span></td><td width='76'><span class='empty15'><input type='text' class='pmarketPrice' style='width:50px;' value='' maxlength='8' onkeyup=\"clearNoNum(this)\"/></span></td>" +
					"<td width='76'><span class='empty15'><input type='text' class='pproductPrice' style='width:50px;' value='' maxlength='8' onkeyup=\"clearNoNum(this)\" /></td><td width='76'><span class='empty15'>0<input type='hidden' class='ptotalStock' style='width:50px;' value='0' maxlength='8' onkeyup=\"this.value=this.value.replace(\/\\D/g,'')\" onafterpaste=\"this.value=this.value.replace(\/\\D/g,'')\"/></span></td>" +
					"<td width='76'><span class='empty15'><input type='text' class='paddStock' style='width:50px;' value='' maxlength='8' onkeyup=\"this.value=this.value.replace(\/[^0-9-]+/,'')\" onafterpaste=\"this.value=this.value.replace(\/[^0-9-]+/,'')\" onblur='addkucun(this)' /></span></td>"+
					"<td width='158'><span class='empty15'><img  id='productConfigImg"+(innerTableNums+index+innerTable)+"' src='../../css/images/no_pic.png' width='143' height='92'></span></td>"+
			        "<td width='125'><span class='empty15'><a class='file_update_area'></a><div class='updateLayer_pro'><span id='spanButtonPlaceholder"+(innerTableNums+index+innerTable)+"'  onmousedown ='clearId(this)'></span><input id='btnCancel"+(innerTableNums+index+innerTable)+"' type='button' value='取消上传' onclick='cancelQueue(upload1);' disabled='disabled' style='margin-left: 2px; height: 22px; font-size: 8pt; display:none'/></div><span><input type='hidden' class='pimgUrls' id='pimgUrls"+(innerTableNums+index+innerTable)+"'/></td></tr>");
			        innerTableNums ++;
		 });*/
		 $(".innerTable").each(function(index) {
				$(this).append("<tr><td width='77' class='ppropertyValue' name='0'><span class='empty15'>"+inputValue+"</span></td><td width='76'><span class='empty15'><input type='text' class='pmarketPrice' style='width:50px;' value='' maxlength='8' onkeyup=\"clearNoNum(this)\"/></span></td>" +
						"<td width='76'><span class='empty15'><input type='text' class='pproductPrice' style='width:50px;' value='' maxlength='8' onkeyup=\"clearNoNum(this)\" /></td><td width='76' style='display:none;'><span class='empty15'>0<input type='hidden' class='ptotalStock' style='width:50px;' value='0' maxlength='8' onkeyup=\"this.value=this.value.replace(\/\\D/g,'')\" onafterpaste=\"this.value=this.value.replace(\/\\D/g,'')\"/></span></td>" +
						"<td width='76' style='display:none;'><span class='empty15'><input type='text' class='paddStock' style='width:50px;' value='' maxlength='8' onkeyup=\"this.value=this.value.replace(\/[^0-9-]+/,'')\" onafterpaste=\"this.value=this.value.replace(\/[^0-9-]+/,'')\" onblur='addkucun(this)' /></span></td>"+
						"<td width='158'><span class='empty15'><img  id='productConfigImg"+(innerTableNums+index+innerTable)+"' src='../../css/images/no_pic.png' width='143' height='92'></span></td>"+
				        "<td width='125'><span class='empty15'><a class='file_update_area'></a><div class='updateLayer_pro' onclick=\"loadimage('pimgUrls"+(innerTableNums+index+innerTable)+"','productConfigImg"+(innerTableNums+index+innerTable)+"')\"></div><span><input type='hidden' class='pimgUrls' id='pimgUrls"+(innerTableNums+index+innerTable)+"'/></td></tr>");
				        innerTableNums ++;
			 });
		 var innerTable3 = $(".innerTable").length;
		 for(var j= 0 ;j<innerTable3;j++){
			// var url = "../product/configImg.do?imgIndex="+(j+innerTableNum+innerTable);
			 innerTableNum ++;
		    // $("#configImghidden").load(url);
		 }
		 innerTableNums ++;
		 innerTableNum ++;
	}
	first();
}
function move_up(obj){
	//如果是第一个，没有向上的按钮
	//@TODO: After AJAX Callback...
	/*$(this).parent().parent().parent().parent().children().find("a").each(function(index, element) {
		if($(this).hasClass("toUp")){
			$(this).hide();
		}
	});
	$(this).parent().parent().parent().parent().children().find("a").each(function(index, element) {
		if($(this).hasClass("deleteThisCole")){
			$(this).show();
		}
	});*/
	var _this = $(obj).parent().parent().parent();
	//alert(_this.html())
	_this.prev().before(_this);
	$(obj).parent().parent().parent().parent().children().eq(1).addClass("hideDelete").siblings().removeClass("hideDelete");;
	$(obj).parent().parent().parent().parent().children("tr:gt(1)").addClass("show_up_btn");
	var _this_index = $(obj).parent().parent().parent().index();
	if( _this_index == 1){
		//$(".deleteThisCole").show();
		$(obj).parent().parent().parent().addClass("hideDelete");
	}
	//$(".hideDelete .deleteThisCole").hide();    //hide first delete
	$(".show_up_btn .toUp").show();
	$(".hideDelete .toUp").hide();
	$(".show-two-btn .toUp").hide();
	$("tr").find("td").each(function(){
		if($(this).hasClass("Nunb")){
			var _index = $(this).parent().index();
			$(this).html("<span class='empty15'>"+_index+"</span>");
		};
	});
	
	var deleteValue = $(obj).parent().parent().parent().find(".text-put-here").html();
	if($(obj).next().attr("name") == 1){
		$(".outTable").find("tr:gt(0)").each(function(index) {
            if($(this).find("td:eq(0) .empty15").html() == deleteValue){
           	   var _this = $(this);
        	   _this.prev().before(_this);
            }
		 });
	}
	if($(obj).next().attr("name") == 2){
		$(".innerTable").find("tr").each(function(index) {
             if($(this).find("td:eq(0) .empty15").html() == deleteValue){
              var _this = $(this);
          	   _this.prev().before(_this);
             }
		});
	}
}
function first(){
	$(".OrderBottom").find("table").each(function(){
		$(this).children("tbody").children("tr").removeClass("show_up_btn");
		$(this).children("tbody").children("tr:gt(1)").addClass("show_up_btn");
	});
	$(".show-two-btn .toUp").css("display", "none");
	$(this).parent().parent().parent().parent().children("tr:gt(1)").addClass("show_up_btn");
	$("table").each(function(index, element) {
		if($(this).hasClass("blockTableBottom")){
			$(this).children().children().eq(1).find("a").each(function(index, element) {
				if($(this).hasClass("toUp")){
					$(this).hide();
				}
				/*if($(this).hasClass("deleteThisCole")){
					$(this).hide();
				}*/
			});
		}
	});
}

function out_notBy(){
	$(".layer").show();
}

function show_order_detail(t){
	var idV = $(t).attr("id");
	$(t).toggleClass("have");
	 if($(t).hasClass("have")){
		 $("tr td").find("div[name="+idV+"]").css({"display":"block"});
	 }
	 else{
		 $("tr td").find("div[name="+idV+"]").css({"display":"none"}).attr("class","");
	 }
}

function audit(this_audit){
	$(".not_approved").show(500);
	setTimeout(function(){$(".not_approved").hide(500);}, 3000);
}
function selectTag(indexs, url) {
    var tags = document.getElementById("tabwarp").getElementsByTagName("li");
    var tagsLength = document.getElementById("tabwarp").getElementsByTagName("li").length;
    ids = "tagContent";
    ids = ids + "" + indexs;
  //  var idtabs = document.getElementById(ids);
    //初始化
    for (var i = 0; i < tagsLength; i++) {
        tags[i].className = "";
        document.getElementById("tagContent" + i).style.display = "none";
    }
    //改内容
    tags[indexs].className = "selectTag";
    document.getElementById(ids).style.display = "block";

}
function h_r(this_sort){
	$(".bg_Sort").removeClass("r_h");
	$(".bg_Sort").removeClass("h_r");
	$(this_sort).parent().parent().parent().parent().addClass("h_r");
}
function r_h(this_sort){
	$(".bg_Sort").removeClass("r_h");
	$(".bg_Sort").removeClass("h_r");
	$(this_sort).parent().parent().parent().parent().addClass("r_h");
}
function statity(url, thisD) {
	$(thisD).parent().addClass("selectTag_nav").siblings().removeClass("selectTag_nav");
	$("#tagContent_box").html("");
    $("#tagContent_box").load(url);
}
function out_notBy(){
	$(".layer").show();
}


function selectTimeEvent() {
	   if($("#selectTime").val()==1){//昨天
		    $("#startDate").val(getDate(0)); 
		    $("#endDate").val(getDate(0));
	    }else if($("#selectTime").val()==2){//最近7天
	   		$("#startDate").val(getDate(-6)); 
	   		$("#endDate").val(getDate(0)); 
	    }else if($("#selectTime").val()==3){//最近30天
	        $("#startDate").val(getDate(-29)); 
	   		$("#endDate").val(getDate(0));
	    }else if($("#selectTime").val()==4){//最近1年
	        $("#startDate").val(getDate(-364)); 
	   		$("#endDate").val(getDate(0));
	    }
}
var n_imgWidth;
window.onload = function(){
	if($(".code_new").width() == null){
		n_imgWidth = 0;
	}else{
		n_imgWidth = $(".code_new").width() + 3
	}
	var n_val01n = $(".logo_Detail_name").width() + n_imgWidth + 90;
	$(".logo span").css("width", n_val01n +"px");
}
function closeChanger_l(){
	$("#switching").hide();
}
function hideCodeL(){
	$("#erweimashows").hide();
}
function hideCodeLNoshows(){
	$("#erweimashow").hide();
}
function hidechangePsd(){
	$(".layer_PWD").hide();
}
function hidecloseAudit(){
	$("#closeAudit").hide();
}
function hideproductShow(){
	$("#productShow").hide();
}
function hideswitching_selectHotels(){
	$("#switching_selectHotels").hide();
}
function n_deleteThis(t_cabinet){
	$(t_cabinet).parent().remove();
}