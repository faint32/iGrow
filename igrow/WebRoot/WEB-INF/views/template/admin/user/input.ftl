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
    	 var vform= $("#saveForm").Validform({
				tiptype:2,
				showAllError:false,
				ajaxPost:true,
				usePlugin:{
					passwordstrength:{
						minLen:6,
						maxLen:18
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
  
</script>
<style type="text/css">
.fixed-width{ width:126px; text-align:right;}
</style>
<div class="titleH2 font14"><#if isAddAction>${action.getText("button.addnew")}<#else><#if result??>${action.getText("button.edit")}<#else>${action.getText("button.addnew")}</#if></#if>${action.getText("user.label")}${action.getText("label.detail")}</div>
	  <div class="OrderTable">
				    <form id="saveForm" method="post" action="${contextPath}/admin/user/<#if isAddAction>save<#else><#if result??>update<#else>save</#if></#if>.do">
				    <input type="hidden" name="form.id" value="${(result.id)!}" />
                	<div class="products-vesting">
                    	<ul>
                        	<li class="lineHeight34"><label class="fixed-width">${action.getText("user.userName")}</label><span><input type="text" class="hotelInput" name="form.userName" value="${(result.userName)!}" tip="请在这里输入管理员账号!" altercss="gray"  datatype="*4-20" errormsg="管理员账号格式错误，必须为4-20位字符!" nullmsg="请输入管理员账号!" ajaxurl="${contextPath}/admin/user/findByUn.do?id=${(id)!}" /></span><span class="Validform_checktip" ></span></li>
                        	<li class="lineHeight34"><label class="fixed-width">${action.getText("user.name")}</label><span><input type="text" class="hotelInput" name="form.name" value="${(result.name)!}" tip="请在这里输入管理员姓名!" altercss="gray"  datatype="*1-20" errormsg="管理员姓名格式错误，必须为20位以内字符!" nullmsg="请输入管理员姓名!"  /></span><span class="Validform_checktip"></span></li>
                        	<#if isAddAction>
                        	<li class="lineHeight34">
                        		<label class="fixed-width">${action.getText("user.password")}</label>
                        		<span><input type="password" class="hotelInput" name="form.password"  plugin="passwordStrength"  datatype="*6-18" errormsg="密码至少6个字符,最多18个字符！" nullmsg="请输入登录密码!"/></span><span class="Validform_checktip"></span></li>
                        	<li class="lineHeight34"><label class="fixed-width"></label><span class="passwordStrength"><span>弱</span><span>中</span><span class="last">强</span></span></li>
                        	<li class="lineHeight34">
                        		<label class="fixed-width">确认密码</label>
                        		<span><input type="password" class="hotelInput" name="repassword"  datatype="*" recheck="form.password" errormsg="您两次输入的账号密码不一致！" nullmsg="请输入确认密码!"/></span><span class="Validform_checktip"></span>
                        		</li>
                        	</#if>
                       	    <li class="lineHeight34"><label class="fixed-width">${action.getText("user.email")}</label><span><input type="text" class="hotelInput" name="form.email" value="${(result.email)!}" tip="请在这里输入电子邮箱!" altercss="gray"  datatype="e,*1-50" errormsg="电子邮箱格式错误,必须50位以内的字符" nullmsg="请输入电子邮箱！"/></span><span class="Validform_checktip"></span></li>
                            <li class="lineHeight34"><label class="fixed-width">${action.getText("user.mobile")}</label><span><input type="text" class="hotelInput" name="form.mobile" value="${(result.mobile)!}" tip="请在这里输入手机号码!" altercss="gray"  datatype="m" errormsg="手机号码错误!" nullmsg="请输入手机号码！"/></span><span class="Validform_checktip"></span></li>
                            <li><label class="fixed-width">${action.getText("member.status")}</label>
                            	<span>
                            		<input type="radio" value="1" name="form.accountEnabled" id="accountEnabled"  <#if result?exists&&(result.isAccountEnabled)?exists&&(result.isAccountEnabled)??&&result.isAccountEnabled.value==1>checked="checked"</#if>/>
                            	<label class="someKG">启用</label>
                            	</span>
                            	<span>
                            		<input type="radio" value="0" name="form.accountEnabled" id="accountEnabled" <#if result?exists&&(result.isAccountEnabled)?exists&&(result.isAccountEnabled)??&&result.isAccountEnabled.value==0>checked="checked"</#if> />
                            	<label class="someKG">禁用</label>
                            	</span>
                            	<span class="Validform_checktip"></span>
                            </li>
                        </ul>
                    </div>
                    <div class="OrderBottom">
                        <div class="order-status-btn btn_hasPassed">
                            <span class="can-send-btn">
                            	<a class="confirm-save" onclick="save(true,${(id)!'0'})">${action.getText("button.save")}</a>
                               <a class="cancel-btn"  onclick="resetSaveForm()">${action.getText("button.reset")}</a>
                            </span>
                        </div>
                        </form>
                    </div>
                    <div class="clear"></div>
                </div>