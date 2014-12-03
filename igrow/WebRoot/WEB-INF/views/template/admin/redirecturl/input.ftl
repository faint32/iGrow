<link href="${contextPath}/css/sample.css"  rel="stylesheet">
<style type="text/css">
.fixed-width{ width:126px; text-align:right;}
</style>
<script type="text/javascript">
   var path = '${contextPath}';
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
				datatype:{
						"productsn":function(gets,obj,curform,regxp){
							var reg1 = /^[^\s]{12,12}$/;
							if(gets == "" || gets == null || gets == "undefined"){ //为空通过验证
								return true;
							}else{
								if(reg1.test(gets)){ //必须为12位字符串
									return true;
								}
							}
							return false;
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
				$.Hidemsg();
				tip_show('w', "正在处理中...");
			}
		}
    	return true;
	}
</script>
  <div class="titleH2 font14"><#if isAddAction>${action.getText("button.addnew")}<#else><#if result??>${action.getText("button.edit")}<#else>${action.getText("button.addnew")}</#if></#if>url详情</div>
                <div class="OrderTable">
                    <form id="saveForm" method="post" action="${contextPath}/admin/redirecturl/<#if isAddAction>save<#else><#if result??>update<#else>save</#if></#if>.do" >
				    <input type="hidden" name="form.id" value="${(result.id)!}" />
				    <input type="hidden" name="form.url" value="${(result.url)!}" />
				     <input type="hidden" name="form.sn" value="${(result.sn)!}" />
                	<div class="products-vesting">
                    	<ul>
                        	<li class="lineHeight34"><label class="fixed-width">名称</label><span><input type="text" class="hotelInput" style="width:300px;" name="form.name" tip="请在这里输入名称!" altercss="gray" title="${(result.name)!}" value="${(result.name)!}" datatype="*1-50" errormsg="请输入1到50位字符" nullmsg="请输入名称！"/></span><span class="Validform_checktip"></span></li>
                          	<li><label class="fixed-width">url</label><span>${(systemMallUrl)!}${(result.url)!}</span><span class="Validform_checktip"></span></li>
                            <li class="lineHeight34"><label class="fixed-width">重定向url</label><span><input type="text" class="hotelInput" style="width:300px;" name="form.redirectUrl" tip="请在这里输入URL!" altercss="gray" value="${(result.redirectUrl)!}" id="resultActiveUrl" datatype="*6-100,url" errormsg="请输入6-100位的url地址" nullmsg="请输入url！"/></span><span class="Validform_checktip"></span></li>
                            <li>
	                         	<label class="fixed-width">备注</label>
	                         	<span><textarea cols="10" name="form.remark" class="cont_textarea gray" style="width:72%" id="resultActiveContent" rows="6"  tip="请在这里输入介绍!" altercss="gray" errormsg="请输入1000位以内字符串" nullmsg="请输入备注!"  datatype="*1-1000" >${(result.remark)!''}</textarea></span><span class="Validform_checktip"></span>
	                         </li>
                        </ul>
                    </div>
                        <div class="order-status-btn btn_hasPassed">
                            <span class="can-send-btn">
                            	<a class="confirm-save" onclick="save(true,${(id)!'0'})">${action.getText("button.save")}</a>
                               <a class="cancel-btn" style="display:none;" onclick="cancel()">${action.getText("button.cancel")}</a>
                            </span>
                        </div>
                        </form>
                    <div class="clear"></div>
                </div>
