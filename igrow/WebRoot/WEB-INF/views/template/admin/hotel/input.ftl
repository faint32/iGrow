<style type="text/css">
	.fixed-width{ width:126px; text-align:right;}
</style>
<script type="text/javascript">
   $(function(){
   		//input获取焦点验证
        $(":input").blur(function(){
              save(false,0);
        });
        //失去焦点验证
        $(":input").focus(function(){
              save(false,0);
        });
    })
   //保存
   function save(flag,id){
        //配送方式
	    var modesStr =new Array();
	    $(".checkboxChangedeliveryModesStr").find(".checkbox").each(function(index) {
	  	          if($(this).attr("checked")){
	  	             modesStr.push($(this).attr("title"));
	  	          }
		 });
		
	    $("#deliveryModesStr").val(modesStr);
    
    	 var vform= $("#saveForm").Validform({
				tiptype:2,
				showAllError:false,
				ajaxPost:true,
				datatype:{
						"phone":function(gets,obj,curform,regxp){
							var reg1=/^(\d{3,4}-)\d{5,11}$/;
							var reg2=/^(\d{3,4}-)\d{5,11}?(-\d{1,4})$/;
							if(reg1.test(gets)){return true;};
							if(reg2.test(gets)){return true;};
							return false;
						},
						"deliveryModes":function(gets,obj,curform,regxp){
							if(gets == ""){
							   alert("请选择配送方式");
							   return false;
							 };
							return true;
						}
				},
				callback:function(data){
					if(data.status=="y"){ //返回成功
						$.Hidemsg();
						tip_show(data.status, data.info);
						$("#fisrtId").val(data.value);
						//延迟1秒加载页面
						setTimeout(function(){
								list(); 
						},1000);
					}else if(data.status=="n"){ //返回失败
						$.Hidemsg();
						tip_show(data.status, data.info);
						//延迟8秒隐藏页面
						setTimeout(function(){
								tip_hide(); 
						},5000);
						return false;
					}else{ //返回未知错误
						$.Hidemsg();
						tip_show('n', '保存处理失败');
						//延迟8秒隐藏页面
						setTimeout(function(){
								tip_hide(); 
						},5000);
						return false;
					}
				}
			});
		if(flag){
			$("#saveForm").submit();
			if(vform.getStatus() == 'posting'){
				tip_show('w', "正在处理中...");
			}
		}
    	return true;
	}
 //重置密码
  function resettingPW(){
    if(confirm("确定要重置该酒店账户密码吗？")){
		     $.ajax({    
		        type:'POST',        
		        url:'${contextPath}/admin/user/resetpwd.do?id=${(sadmin.id)!}',    
		        data:null,    
		        cache:false,    
		        dataType:'json',    
		        success:function(data){ 
		        	if(data.status=="y"){
		        		 tip_show(data.status, data.info);
		        		 //延迟1秒加载页面
						setTimeout(function(){
								list(); 
						},1000);
		        		 return false;
		        	}else if(data.status=="n"){
		        		tip_show(data.status, data.info);
			        	setTimeout(function(){
							tip_hide_w(); 
						},1000);
		        		return false;
		        	}else{
		        		tip_show('n', '删除操作失败');
						return false;
		        	}
		        }    
		     });    
		   }
  }
</script>
<div class="titleH2 font14"><#if isAddAction>${action.getText("button.addnew")}<#else><#if result??>${action.getText("button.edit")}<#else>${action.getText("button.addnew")}</#if></#if>${action.getText("hotel.label")}${action.getText("label.detail")}</div>
	<div class="OrderTable">
	<form id="saveForm" method="post" action="${contextPath}/admin/hotel/<#if isAddAction>save<#else><#if result??>update<#else>save</#if></#if>.do" >
	<input type="hidden" name="id" value="${(id)!}"  style="display:none" />
	<input type="hidden" id="formAdminId" name="sadmin.id" value="${(sadmin.id)!}" style="display:none" />
	<div class="products-vesting">
		<ul>
		<li class="lineHeight34">
			<label class="fixed-width">${action.getText("hotel.label.name")}</label><cite class="mi_red">*</cite><span><input type="text" class="hotelInput" style="width:300px;" name="form.name" value="${(result.name)!}"   tip="请在这里输入酒店名称!" altercss="gray"  datatype="*1-50" errormsg="请输入1到50位字符" nullmsg="请输入酒店名称！" ajaxurl="${contextPath}/admin/hotel/findByName.do?id=${(id)!}"/></span>
			<span class="Validform_checktip"></span>
		</li>
		<li class="lineHeight34"><label class="fixed-width">${action.getText("hotel.label.contactName")}</label><cite class="mi_red">*</cite><span><input type="text" class="hotelInput" style="width:300px;" name="form.contactName" value="${(result.contactName)!}"  tip="请在这里输入联系人姓名!" altercss="gray"  datatype="*1-50" errormsg="请输入1到50位字符" nullmsg="请输入联系人姓名！"/></span><span class="Validform_checktip"></span></li>
		<li class="lineHeight34"><label class="fixed-width">${action.getText("hotel.label.address")}</label><cite class="mi_red">*</cite><span><input type="text" class="hotelInput" style="width:300px;" name="form.address" value="${(result.address)!}"  tip="请在这里输入地址!" altercss="gray"  datatype="*1-100" errormsg="请输入1到100位字符" nullmsg="请输入地址！"/></span><span class="Validform_checktip"></span></li>
		<li class="lineHeight34"><label class="fixed-width">${action.getText("hotel.label.phone")}</label><cite class="mi_red">*</cite><span><input type="text" class="hotelInput" style="width:300px;" name="form.phone" value="${(result.phone)!}" tip="请在这里输入联系电话!" altercss="gray"  datatype="phone" errormsg="联系电话格式错误,如：021-10000-8888或0571-10000!" nullmsg="请输入联系电话！" /></span><span class="Validform_checktip"></span></li>
		<li class="lineHeight34"><label class="fixed-width">${action.getText("hotel.label.mobile")}</label><cite class="mi_red">*</cite><span><input type="text" class="hotelInput" style="width:300px;" name="form.mobile" value="${(result.mobile)!}" tip="请在这里输入手机号码!" altercss="gray"  datatype="m" errormsg="手机号码错误!" nullmsg="请输入手机号码！"/></span><span class="Validform_checktip"></span></li>
		<li class="reduceDis lineHeight34">
			<label class="fixed-width">${action.getText("hotel.label.email")}</label>
			<cite class="mi_red">*</cite>
			<span>
				<input type="text" class="hotelInput" style="width:300px;" name="form.email" value="${(result.email)!}"  tip="请在这里输入电子邮箱!" altercss="gray"  datatype="e,*1-50" errormsg="电子邮箱格式错误,必须50位以内的字符!" nullmsg="请输入电子邮箱！"/></span><span class="Validform_checktip">
			</span>
			<span class="btn_hasPassed_O toPadTop10">
				<ul class="checkboxChange">
					<li>
						<input type="checkbox" class="checkbox" name="value"<#if (result.isSmsRemind)??&&result.isSmsRemind.value==1> checked="checked"</#if> value="0"/>${action.getText("hotel.label.isSmsRemind")}
					</li>
					<li>
						<input type="checkbox" class="checkbox" name="value"<#if (result.isEmailRemind)??&&result.isEmailRemind.value==1> checked="checked"</#if> value="1"/>${action.getText("hotel.label.isEmailRemind")}
					</li>
				</ul>
			</span>
		</li>
		
		 <li><label class="fixed-width">${action.getText("product.deliveryModes")}</label><cite class="mi_red"></cite><span>
        	<ul class="checkboxChange  checkboxChangedeliveryModesStr">
        	 <#list deliveryTypes as deliveryType>
        	 	 <#assign flag=false/>
        	 	 <#if result??&&result?exists&&(result.deliveryMode)??&&(result.deliveryMode)?exists>
        	 	 	<#list result.deliveryMode as d><#if d.value==deliveryType.value><#assign flag=true/><#break/></#if></#list>
                 </#if>
                 <li><input type="checkbox" title="${(deliveryType.value)!""}" <#if flag>checked="checked" </#if>class="checkbox" />
                 ${(deliveryType.desc)!""}</li>
             </#list>
            </ul>
            <input type="hidden" name="form.deliveryModes" id="deliveryModesStr" style="display:none;" datatype="deliveryModes"/>
            </span>
         </li>
         <li class="n_borderBotLine"></li>              
		
		<li class="lineHeight34">
			<label class="fixed-width">支付宝账户</label>
			<cite class="mi_red">*</cite>
			<span><input type="text" class="hotelInput" style="width:300px;" name="form.alipayEmail" value="${(result.alipayEmail)!}"  tip="请在这里输入支付宝邮箱!" altercss="gray"  datatype="e,*1-50" errormsg="电子邮箱格式错误,必须50位以内的字符!" nullmsg="请输入电子邮箱！"/></span><span class="Validform_checktip"></span>
			<i class="empty6">(邮箱)</i>
		</li>
		<li class="lineHeight34">
			<label class="fixed-width">支付宝账户名</label>
			<cite class="mi_red">*</cite>
			<span><input type="text" class="hotelInput" style="width:300px;" name="form.alipayAccountName" value="${(result.alipayAccountName)!}"  tip="请在这里输入支付宝账户名!" altercss="gray"  datatype="*1-50" errormsg="请输入1到50位字符!" nullmsg="请输入支付宝账户名！"/></span><span class="Validform_checktip"></span>
			<i class="empty6">(真实姓名)</i>
			<span class="btn_hasPassed_O toPadTop10">
				<ul class="checkboxChange">
					<li>
						<input type="checkbox" class="checkbox" name="type"<#if (result.isOnline)??&&result.isOnline.value==1> checked="checked"</#if> value="0"/>在线支付
					</li>
					<li>
						<input type="checkbox" class="checkbox" name="type"<#if (result.isOffline)??&&result.isOffline.value==1> checked="checked"</#if> value="1"/>前台支付
					</li>
				</ul>
			</span>
		</li>
		<li class="n_borderBotLine"></li> 
		<li style="display:none;"><label class="fixed-width">${action.getText("hotel.label.alipayPid")}</label><cite class="mi_red">*</cite><span><input type="text" class="hotelInput" style="width:300px;" name="payment.paymentPid" value="2088011692572096" /></span><span class="Validform_checktip"></span></li>
		<li style="display:none;"><label class="fixed-width">${action.getText("hotel.label.alipayKey")}</label><cite class="mi_red">*</cite><span><input type="text" class="hotelInput" style="width:300px;" name="payment.paymentKey" value="u3ka57h3fchuhf6glf3ri2ba30selehk" /></span><span class="Validform_checktip"></span></li>
		<li style="display:none;"><label class="fixed-width">${action.getText("hotel.label.alipayName")}</label><cite class="mi_red">*</cite><span><input type="text" class="hotelInput" style="width:300px;" name="payment.paymentName" value="borabora@atbora.com" /></span><span class="Validform_checktip"></span></li>
		<li style="display:none;"><label class="fixed-width">${action.getText("hotel.label.alipayAccountId")}</label><cite class="mi_red">*</cite><span><input type="text" class="hotelInput" style="width:300px;" name="payment.paymentAccountId" value="borabora@atbora.com"  /></span><span class="Validform_checktip"></span></li>
		<li style="display:none;"><label class="fixed-width">${action.getText("hotel.label.publicKey")}</label><cite class="mi_red">*</cite><span><input type="password" class="hotelInput" style="width:500px;" name="payment.publicKey" value="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB" datatype="*" maxlength=1000/></span><span class="Validform_checktip"></span></li>
	    <li style="display:none;"><label class="fixed-width">${action.getText("hotel.label.privateKey")}</label><cite class="mi_red">*</cite><span><input type="password" class="hotelInput" style="width:500px;" name="payment.privateKey" value="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKEUqyv5DOb4pLNYrco1gs6jeXgeIgTULYiDT50ZtYZiVR0NKoqT0EXZF0dDtA11LtrdZ00Pgt32K/26mrdMdf6JiFNOY/XS67aVPFLKfS/C5uMe1cR5ZXOFZpwdsaBsQI3f9Fw05v83zzYYVsVmPzoUiX/seto73Rffi+9X2qGVAgMBAAECgYARQHBwvjS2jAy/tJCwZnjC/tkklz2XfM3/n+in77f0U5XADcfvnZMh1/VZSZQAGPvSrwHATBf9A7+EZjbpyMOeOr2rdYy7FBGrHSRzjlXhas5NybkcTu6E3bXMNF9w906LNm9u8t/4+K4ZwhuHskkTPv0S8zKJ4Vi6qdQcKM86oQJBANOlT4W2xsyOUDjErEJBIUKFoILCJphNa3eAp6IQimQI7Znd5d9wmGkOkmqPO86SxPtN6yVst4BUhZ0/kYDm0qkCQQDC1pIEtASBW+8tGwWDn4anMl8X+ihmaCs0kkD+8WLQ1WMJjnFKFgK0FqlvEqQwBv/DsXZZgrw2dbb3ZGb/RtcNAkAmTQA7HnyTgB2caFsUEl1GgJAvmZsKbNhJ5ApyFbQ1rjfxZGq5KNMsD+sHRax5Ea58G/m16Bq9Ko6TinF2dk8hAkEAnC5QAkEjU2aUhP2iH+5ii+gO3jOC6wQZjhymyTZJ1ckXiHOMUKzwIdgAna69uloB76ZzjjEEGkumDQ2Impz4iQJAGyW2fZFZRY8GNhJZTwe6TEg1jAQktktyFU7qrvX1F+MxpXjQK+zoFtmJ9GjBmKZfNNeyrtkCHbX1A2J4364zwQ==" datatype="*" maxlength=1000/></span><span class="Validform_checktip"></span></li>
		<li><label class="fixed-width">账号</label><cite class="mi_red">*</cite><span class="fontLeft"><input type="text" style="width:300px;" class="hotelInput"  name="sadmin.userName" value="${(sadmin.userName)!}" tip="请在这里输入酒店登录账户!" altercss="gray"  datatype="*4-20" errormsg="酒店登录账户名格式错误,必须为4-20位字符串!" nullmsg="请输入酒店登录账户！" ajaxurl="${contextPath}/admin/user/findByUn.do?id=${(sadmin.id)!}" /></span><span class="Validform_checktip" ></span></li>
        <li><label class="fixed-width">密码</label><cite class="mi_red"></cite><span class="fontLeft">默认密码123456，创建成功后请自行更改密码<a class="reset_pwd" onclick="resettingPW()">重置密码</a></span></li>
		<input type="hidden" name="payment.id" value="${(result.payment.id)!}" />
		<li><label class="fixed-width">备注</label><cite class="mi_red"></cite><span><textarea     rows="10" cols="50" name="form.remark">${(result.remark)!}</textarea></span></li>
		<li class="n_borderBotLine"></li> 
		<div class="clear"></div>
		</ul>
	</div>
	<div class="order-status-btn btn_hasPassed_O">
		<span class="can-send-btn">
			<a class="confirm-save" onclick="save(true,${(id)!'0'})">${action.getText("button.save")}</a>
			<a class="cancel-btn" onclick="cancel()" style="display:none;">${action.getText("button.cancel")}</a>
		</span>
	</div>
	</form>
	<div class="clear"></div>
</div>
