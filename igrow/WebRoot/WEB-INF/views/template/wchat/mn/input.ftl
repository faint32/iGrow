<script type="text/javascript">
   	//菜单动作更新
	function actionMenu(){
		$("#saveActionForm").attr("action","${contextPath}/wchat/mn/update.do");
		var vform= $("#saveActionForm").Validform({
				tiptype:2,
				showAllError:false,
				ajaxPost:true,
				callback:function(data){
					$.Hidemsg();
					if(data.status=="y"){ //返回成功
						//成功显示
						alert("菜单动作设置成功");
						//显示新菜单名称
						return;
					}else if(data.status=="n"){ //返回失败
						alert("菜单动作设置失败");
						return;
					}else{ //返回未知错误
						return;
					}
				}
			});
		//提交
		$("#saveActionForm").submit();
	}
</script>
<#assign event=(result.event.value)!'0'/>
<div class="tabCont_title">
   <p><b>设置菜单【${(result.name)!}】动作</b></p>
</div>
<div class="tabCont" id="tab">
    <ul id="tabwarp">
        <li <#if event==4||event== 0>class="selectTag"</#if> onclick="selectTag(0)"><a>图 文</a></li>
        <li <#if event==5>class="selectTag"</#if> onclick="selectTag(1)"><a>网 页</a></li>
        <li <#if event==99>class="selectTag"</#if> onclick="selectTag(2)"><a>文 本</a></li>
    </ul>
</div>
<div class="content-table contenter_summary" id="tagContent">
 <form id="saveActionForm" class="form" action="${contextPath}/wchat/mn/update.do" method="post" novalidate="novalidate">
    <input type="hidden" name="id" value="${(result.id)!}" ><!--id-->
    <input type="hidden" id="actionEvent" name="value" value="${(result.event.value)!'4'}" ><!--EVENT-->
    <div id="tagContent0" class="tagContent <#if event==4||event== 0>selectTag</#if>">
        <textarea class="inputUrl" name="form.srcUrl"><#if event==4||event== 0>${(result.srcUrl)!}</#if></textarea>
         <p class="action_tipsFont">请输入生成图文的微信素材地址</p>
    </div>
    <div id="tagContent1" class="tagContent	<#if event==5>selectTag</#if>">
         <textarea class="inputUrl" name="form.key"><#if event==5>${(result.key)!}</#if></textarea>
         <p class="action_tipsFont">请输入生成跳转地址</p>
    </div>
    <div id="tagContent2" class="tagContent <#if event==99>class="selectTag"</#if>">
         <textarea class="inputUrl" name="form.srcData"><#if event==99>${(result.srcData)!}</#if></textarea>
    </div>
    <div class="btn_save_wx">
    	<a class="btn_saveWX" onclick="actionMenu()">保 存</a>
    </div>
 </form> 
</div>