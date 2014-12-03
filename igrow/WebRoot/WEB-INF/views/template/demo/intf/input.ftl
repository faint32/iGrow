<style type="text/css">
.fixed-width{ width:77px;}
</style>
<div class="titleH2 font14">【${(result.value)!}.${(result.desc)!}】接口测试实例</div>
	<div class="OrderTable">
	<form id="saveForm" class="" method="post" action="" >
	<input type="hidden" id="mappingUrl" name="mappingUrl" value="${(mappingUrl)!}" />
	<div class="products-vesting blockTableBottom25">
		<ul>
		<li>
			<label class="fixed-width">接口名称：</label>
			<span>
				${(result.desc)!}(状态：<#if (result.status)??><#if result.status == 0>demo<#elseif result.status == 1>停用<#elseif result.status == 1>开发中<#elseif result.status == 2>测试中<#elseif result.status == 3>已完成<#else>未知</#if><#else>未知</#if>)
			</span>
			<span class="Validform_checktip"></span>
		</li>
		<li>
			<label class="fixed-width">请求名称：</label>
			<span>
				<input type="text" id="actionName" name="actionName" value="${(result.action)!}" datatype="*" />
			</span>
			<span class="Validform_checktip"></span>
		</li>
		<li>
			<label class="fixed-width">请求类型：</label>
			<span>
				POST
			</span>
			<span class="Validform_checktip"></span>
		</li>
		<li>
			<label class="fixed-width">请求地址：</label>
			<span>
				${(mappingUrl)!}${(result.action)!}.ac
			</span>
			<span class="Validform_checktip"></span>
		</li>
		<li>
			<label class="fixed-width">测试地址：</label>
			<span>
				${requestServer}${contextPath}${(mappingUrl)!}${(result.action)!}.ac
			</span>
			<span class="Validform_checktip"></span>
		</li>
		<li>
			<label class="fixed-width">请求数据：</label>
			<span>
			  <textarea cols="60" id="postData" name="postData" rows="5"></textarea>
			</span>
			<span class="Validform_checktip"></span>
		</li>
		<li>
			<label class="fixed-width">请求格式：</label>
			<span>
  				para={"s":"8asdg97s8dg9as7sd8f9a"}
			</span>
			<span class="Validform_checktip"></span>
		</li>
		<li>
			<label class="fixed-width">返回数据：</label>
			<span>
			<textarea cols="60" id="responseData" name="responseData" rows="6"></textarea>
			</span>
			<span class="Validform_checktip"></span>
		</li>
		<li>
			<label class="fixed-width">返回格式：</label>
			<span>
			{
  				"r": 0,
  				"ac": "****",
  				"m": "操作成功",
  				"d": {
  				}
			}
			</span>
			<span class="Validform_checktip"></span>
		</li>
		</ul>
	</div>
	<div class="order-status-btn">
		<span class="can-send-btn">
			<a class="confirm-save" onclick="save()">提交</a>
			<a class="cancel-btn" onclick="cancel()">重置</a>
		</span>
	</div>
	</form>
	<div class="clear"></div>
</div>
