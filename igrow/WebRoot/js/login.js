$(function () {
    validate();
});

function validate(){
	 $("input[validate!=true]").each(function (){
		 if($(this).val() == $(this).attr("message")){
			 $(this).css({color:"#cccccc", "font-size": "14px"});
		 }
		 if($(this).val() == ''){
		     $(this).val($(this).attr('message'));
		 }
		 $(this).live("focus", function(){
			 if(this.value==$(this).attr('message')){
				 this.value="";$(this).css({color:"#666666", "font-size": "16px"});
			 }
			 
		 }).live("blur", function(){
			 if(this.value ==""){
				 this.value=$(this).attr('message');
				 $(this).css({color:"#cccccc", "font-size": "14px"});
			 }
			 if($(this).val()!==$(this).attr("message")){
				$(this).css({color:"#666666", "font-size": "16px"});
			}
		 });
	 })
}
 

function tip_show(operating, text){
	$(".elastic_layer").css("display", "block");
	if(operating == "y"){
		$(".show_tip_infor").css("background-image", "url(../../css/images/savesuccess.png)");
	}else if(operating == "n"){
		$(".show_tip_infor").css("background-image", "url(../../css/images/saveWrong.png)");
	}else if(operating == "w"){
		$(".show_tip_infor").css("background-image", "url(../../css/images/saveWait.gif)");
	}else{
		$(".show_tip_infor").css("background-image", "url(../../css/images/savesuccess.png)");
	}
	$(".tip_text").text(text);
}

function tip_hide(){
	$(".elastic_layer").css("display", "none");
}