 	//修改密码
   function modifyPassword(flag,id){
    	 var vform= $("#passwordForm").Validform({
				tiptype:function(msg,o,cssctl){
					var objtip=$("#errmsg");
					if(o.type == "2"){ //成功
					    objtip.css("display","none");
					}else{
						objtip.css("display","block");
						cssctl(objtip,o.type);
						objtip.text(msg);
					}
				},
				showAllError:false,
				ajaxPost:true,
				usePlugin:{
					passwordstrength:{
						minLen:6,
						maxLen:18
					}
				},
				callback:function(data){
					var objtip=$("#errmsg");
					if(data.status=="y"){ //返回成功
						//objtip.css("display","block").addClass("Validform_checktip Validform_right");
						//objtip.text(data.info);
						passwordLayerHide();
						tip_show(data.status, data.info);
						//延迟5秒加载页面
						setTimeout(function(){
								tip_hide_pwd(); 
						},1000);
						return false;
					}else if(data.status=="n"){ //返回失败
						objtip.css("display","block").addClass("Validform_checktip Validform_wrong");
						objtip.text(data.info);
						return false;
					}else{ //返回未知错误
						objtip.css("display","block").addClass("Validform_checktip Validform_wrong");
						objtip.text("密码修改失败!");
						return false;
					}
				}
			});
		if(flag){
			$("#passwordForm").submit();
			if(vform.getStatus() == 'posting'){
				//tip_show('w', "正在处理中...");
			}
		}
    	return true;
	}
	 //密码失去焦点
	 function passwordFocus(){
		 modifyPassword(false,0);
	 }
 
   