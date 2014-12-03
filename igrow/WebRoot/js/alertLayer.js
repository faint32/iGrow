function tip_show(operating, text){
	$(".elastic_layer").css("display", "block");
	$("#erroCode").val('');
	if(operating == "y"){
		$(".show_tip_infor").css("background-image", "url(../../css/images/savesuccess.png)");
	}else if(operating == "n"){
		$(".show_tip_infor").css("background-image", "url(../../css/images/saveWrong.png)");
	}else if(operating == "w"){
		$(".show_tip_infor").css("background-image", "url(../../css/images/saveWait.gif)");
	}else{
		$(".show_tip_infor").css("background-image", "url(../../css/images/savesuccess.png)");
	}
	$("#erroCode").val(operating);
	$(".tip_text").text(text);
}
$(function(){
	$(".elastic_layer").live("click", function(){
		if($("#erroCode").val() == 'n'){
			$(".elastic_layer").css("display", "none");
		}
	});
	$(".layer_black_bg").live("click", function(){
		passwordLayerHide();
	})
});
//修改密码层显示
function passwordLayerShow(){
	$("#errmsg").css("display","none");
	$(".layer_PWD").css("display", "block");
}
//修改密码层隐藏
function passwordLayerHide(){
	var objtip=$("#errmsg");
	objtip.css("display","none");
	var vpform= $("#passwordForm").Validform();
	vpform.resetForm();
	$(".layer_PWD").css("display", "none");
}
//隐藏方法
function tip_hide(){
	if($("#erroCode").val() == 'n'){
			$(".elastic_layer").css("display", "none");
	}
}

function tip_hide_pwd(){
	$(".elastic_layer").css("display", "none");
}

function tip_hide_w(){
	$(".elastic_layer").css("display", "none");
}

