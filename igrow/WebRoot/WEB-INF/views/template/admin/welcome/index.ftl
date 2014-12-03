<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>${action.getText("ui.company")}${action.getText("ui.title")}管理中心 - Powered By BORABORA</title>
<link href="${contextPath}/favicon.ico" rel="shortcut icon" type="image/x-icon" />
<link href="${contextPath}/css/login.css" rel="stylesheet" type="text/css" />
<link href="${contextPath}/css/alertLayer.css" rel="stylesheet" />
<script type="text/javascript" src="${contextPath}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/login.js"></script>
<script src="${contextPath}/js/Validform_v5.3.2.js"></script>
<script type="text/javascript">
	$(function(){
		// 刷新验证码
		 $("#captchaImage").click(function(){
			var timestamp = (new Date()).valueOf();
			var imageSrc = $("#captchaImage").attr("src");
			if(imageSrc.indexOf("?") >= 0) {
				imageSrc = imageSrc.substring(0, imageSrc.indexOf("?"));
			}
			imageSrc = imageSrc + "?timestamp=" + timestamp;
			$("#captchaImage").attr("src", imageSrc);
		});
		
		
		// 登陆按钮
		 $(".login_btn").click(function(){
			  if($("#userName").val()==''|| $("#userName").val()=='请输入用户名'){
			  		$(".notice_wrong").text("")
				  	$(".notice_wrong").text("请输入用户名！");
				  	$("#userName").addClass("red_box").siblings("input").removeClass("red_box");
				  	//$("#userName").select();
				  	return;
			  }
			  if($("#pwd").val()==''|| $("#pwd").val()=='密码'){
				  	$(".notice_wrong").text("")
				  	$(".notice_wrong").text("请输入密码！");
				    //$("#tx").select();
				    $("#tx").addClass("red_box").siblings("input").removeClass("red_box");
				  	return;
			  }
		  
			 var vform= $("#loginForm").Validform({
				tiptype:4,
				ajaxPost:true,
				callback:function(data){
					if(data.status=="y"){
						//加载成功页面
						setTimeout(function(){
							tip_hide(); 
						},2000);
						document.location.href="${contextPath}/admin/welcome/main.do?redirectUrl=${redirectUrl}";
					}else{
						//alert(data.info);
						setTimeout(function(){
							tip_hide(); 
						},500);
						$(".notice_wrong").text("")
				  		$(".notice_wrong").text(data.info);
				  		if(data.count > '2'){
				  		  $(".captcha_box").show(); 
				  		}
						if(data.info=="验证码错误!"){
						    $(".captcha").parent().addClass("red_box").siblings().removeClass("red_box");
						}else if(data.info=="管理员用户不存在!"){
							$("#userName").addClass("red_box").siblings().removeClass("red_box");
						}else if(data.info=="您的密码错误!"){
							$("#pwd").addClass("red_box").siblings().removeClass("red_box");
						}
						$("#captcha").val(""); 
						$("#captchaImage").trigger("click");
						return false;
					}
				}
			 });
			 tip_show('w','正在登录中...');
	 		 $("#loginForm").submit();
			 return false;
		});
				
				
		/*
			picIn();
			function picIn(){
				var wHeight = document.documentElement.clientHeight;
				var wWidth = document.documentElement.clientWidth;
				if( wWidth/wHeight < 1680/906){
					//alert(1)
					$("body").css({ "background-size":"auto auto"});
				}else{
					//alert(2)
					$("body").css({ "background-size":"100% inherit"});
				}
			}
			$(window).resize(function () {
				picIn();
			});
		*/
		$("#tx").focus(function(){
			$(this).hide();
			$("#pwd").show().val("").select();
		});
		$("#pwd").blur(function(){
			if($(this).val() == "" || $(this).val() == "undefined"){
				$(this).hide();
				$("#tx").show();
			}
		})
	});
	//回车
    $(document).keypress(function(event) {  
 		var keyCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode; 
	     if(keyCode==13){//按回车键
	     	$(".login_btn").trigger("click");
         }
	}); 
</script>
</head>
<body>
	<div class="bg_login">
		<img src="${contextPath}/css/images/bg_city.png" width="1920">
		<div class="cloud"><img src="${contextPath}/css/images/y.png" width="1398"></div>
		<div class="load">
			<span class="car">
				<img src="${contextPath}/css/images/che.png" width="116">
			</span>
		</div>
	</div>
    <div id="Login_box">
       <form id="loginForm" class="loginForm" method="post" action="${contextPath}/admin/welcome/login.do" >
       <input type="hidden" name="redirectUrl" value="${redirectUrl}" />
        <div class="login_top">
            <img src="${contextPath}/css/images/logo_login.png" width="334" />
        </div>
        <div class="logon_bottom">
        	<div class="bottom_top"></div>
        	<div class="bottom_center">
        	<span class="notice_wrong"></span>
            <input type="text" class="input_box" name="userName" id="userName" value="请输入用户名" message="请输入用户名" />
            <input type="text" class="input_box"  value="密码" id="tx" message="密码" /><input type="password" class="input_box" id="pwd" name="password" value="" style="display:none" />
	           	<div class="captcha_box" style="display:none">
	                <input type="text" class="input_box captcha" id="captcha" name="captcha" value="请输入验证码" message="请输入验证码" />
	                <span class="captcha_area"><img id="captchaImage" alt="换一张" src="${contextPath}/captcha.jpeg" width="66" height="30" /></span>
	            </div>
            <a class="login_btn"></a>
            <div class="clear"></div>
        </div>
        <div class="bottom_bot"></div>
        </div>
       </form>
    </div>
<!--弹出提示-->
 <div class="elastic_layer">
 	<input type="hidden" id="erroCode" value="" />
	<div class="black_Bg">
    </div>
    <div class="show_tip_infor">
        <span class="null_text">
        </span>
        <span class="tip_text">
        </span>
    </div>
</div>
<div class="copyright">Copyright&copy2011-2013　iGrow　浙ICP备*******号-*</div>
</body>
</html>
