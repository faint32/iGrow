<@a.header "APP数据交互协议接口">
	<script>
		//页面初始化
		$(function(){
			//初始化编辑页面
			edit(1);
		});
	    function edit(id){
	     	var url = "${contextPath}/demo/intf/edit.do?id="+id;
	        loadRightPage(url);
	     }
	     //保存或者更新
	     function save(){
	     	var actionName = $("#actionName").val();
	     	var mappingUrl = $("#mappingUrl").val();
	     	var postData = $("#postData").val();
	        var url = "${contextPath}" + mappingUrl + actionName +".ac";
	       	$.ajax({    
		        type:'POST',        
		        url:url,    
		        data:postData,    
		        cache:false,    
		        dataType:'text',    
		        success:function(data){
		       	 	$("#responseData").val(data);
		        }    
		     });    
	     }
	     //加载页面
	     function loadRightPage(url){
	        tip_show('w', "数据加载中...");
	     	$.ajaxSetup ({ cache: false });
	        $(".content-right").load(url,function(resTxt,status,xhr){
	        	if(status == "success"){
	        		setTimeout(function(){
						tip_hide_w(); 
					},1000);
	        	}
			}); 
	     }
	     function cancel(){
			$("textarea").val(''); 
	     }
	</script>
</@a.header >
<body>
	<div id="Contenter">
        <div class="contentBody">
           <!-- start content-left -->
            <div class="content-left">
                <div class="titleH2 font14">【APP数据交互协议接口列表】</div>
                <div class="OrderTable">
                    <div class="OrderBottom">
                        <table width="100%">
                            <tr>
                            	<th width="12%"><span class="empty15">${action.getText("label.sn")}</span></th>
                                <th width="31%"><span class="empty15">数据接口名称</span></th>
                                <th width="27%"><span class="empty15">请求方法名称</span></th>
                                <th width="15%"><span class="empty15">状态</span></th>
                                <th width="15%"><span class="empty15">操作</span></th>
                            </tr>
                            <#if (Intfs)??>
	                            <#list Intfs as obj>
		                            <tr>
		                             	<td><span class="empty15">${obj_index + 1}</span></td>
		                                <td><span class="empty15">${obj.desc}</span></td>
		                                <td><span class="empty15">${obj.action}</span></td>
		                                <td><span class="empty15"><#if (obj.status)??><#if obj.status == 0>demo<#elseif obj.status == -1>停用<#elseif obj.status == 1>开发中<#elseif obj.status == 2>测试中<#elseif obj.status == 3>已完成<#else>未知</#if><#else>未知</#if></span></td>
		                                <td class="operating">
		                                	<span class="empty15"><a class="zoomThis" onclick="edit(${(obj.value)!});"></a></span>
		                                </td>
		                            </tr>
	                            </#list>
	                        <#else>
	                        	    <tr>
		                             	<td colspan="5"><span class="empty15">${action.getText("msg.no.data")}</span></td>
		                            </tr>
	                        </#if>
                        </table>
                    </div>
                     <div class="page">
				       	<div class="pageQuantity">
				        </div>
				        <div class="pageColm">
				        </div>
				        <div class="clear"></div>
     				</div>
                </div>
            </div>
            <!-- end content-left -->
            <!-- start content-right -->
            <div class="content-right">
                <!-- input -->
            </div>
            <!-- end content-right -->
            <div class="clear"></div>
        </div>
    </div>
    <!-- end Contenter -->
 <@a.footer />  