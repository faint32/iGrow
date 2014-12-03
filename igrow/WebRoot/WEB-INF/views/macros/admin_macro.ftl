<#macro header title>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>${action.getText("ui.title")}-后台管理</title>
    <link href="${contextPath}/css/masterPage.css" rel="stylesheet" />
    <link href="${contextPath}/css/commodity.css" rel="stylesheet" />
    <link href="${contextPath}/css/settlement.css" rel="stylesheet" /> 
    <link href="${contextPath}/css/orderManag.css" rel="stylesheet" />
    <link href="${contextPath}/css/hotelManag.css" rel="stylesheet" />
    <link href="${contextPath}/css/sample.css"  rel="stylesheet">
    <link href="${contextPath}/css/style.css" rel="stylesheet" />
    <link href="${contextPath}/css/alertLayer.css" rel="stylesheet" />
    <script src="${contextPath}/js/jquery-1.7.2.min.js"></script>
    <script src="${contextPath}/js/j_page.js"></script>
    <script src="${contextPath}/js/ckeditor/ckeditor.js"></script>
    <script src="${contextPath}/js/Validform_v5.3.2.js"></script>
    <script src="${contextPath}/js/passwordStrength-min.js"></script>
    <script src="${contextPath}/js/alertLayer.js"></script>
    <script src="${contextPath}/js/nowTime.js"></script>
    <script src="${contextPath}/js/common.js"></script>
    <script src="${contextPath}/js/password.js"></script>
    <script src="${contextPath}/common/My97DatePicker/WdatePicker.js"></script>
    <script src="${contextPath}/js/Placeholders.js"></script>
    <link href="${contextPath}/favicon.ico" rel="shortcut icon" type="image/x-icon" />
    <script>
    function showErweimah(name,imgSrc){
             $("#erweimaNames").html(name);
             $("#erweimaImgs").attr("src",imgSrc);
             var erweimaImgStr = "${imagePath}"+imgSrc;
             imgSrc = encodeURI(encodeURI(imgSrc));
             $("#erweimaSaves").attr("href","${contextPath}/common/download.do?attachname="+imgSrc);
             $("#erweimashows").show();
             $(".layer-content").show();
	        
	  }  
     function erweimaCloseh(){
	 		 $("#erweimashows").hide();
	  }
	 function switching(){
	 	$("#switching").show();
	  	$(".layerBox").show();
	 }
	 function hide_switch(){
	 	$("#switching").hide();
	 }
	  </script>
	  <#nested/>
</head>
</#macro>

<#macro menu>
    <div id="Header">
    	<div class="headerMain">
	        <div class="logo">
	            <img src="${contextPath}/css/images/logo.png">
	            <span class="font14"><label>【</label><b class="ellipsis logo_Detail_name"<#if  admin.roleGroupId==1>	onclick="switching()"</#if> title="${systemName}">${systemName}</b><label>】</label><#if  admin.roleGroupId==2 ||(admin.roleGroupId==1 && admin.hotelId!=0)><i class="code_new" onclick="showErweimah('${systemName}','${imagePath}${(realHotelUrl)!}')"><img src="${contextPath}/css/images/er.png" width="17px" height="17px" /></i></#if><#if  admin.roleGroupId==1><b class="switching" onclick="switching()">【切换】</b></#if><div class="clear"></div></span>
	        </div>
	        <div class="nav">
	            <ul>
	            	<#list (mainPurviews)! as pur>
			   			<#assign flag=false/><#list userPurviews as up><#if pur.id==up.id><#assign flag=true/><#break/></#if></#list>
			   			<#if flag&&(pur.isMenu.value)! == 1>
						<li <#if idx?substring(0,2)==pur.code> class="currseBlock"</#if>><a class="${(pur.style)!}" href="${contextPath}${(pur.linkurl)!}"><span class="disapperBorderbottom"></span></a>
							<#if (pur.subPurviews)??&&(pur.subPurviews)?exists>
			                    <ul class="slideNav">
			                    	<#list (pur.subPurviews)! as child>
			                    		<#assign flag=false/><#list userPurviews as up><#if child.id==up.id><#assign flag=true/><#break/></#if></#list>
			                       	 	<#if flag&&(child.isMenu.value)! == 1>	
			                       	 		<li <#if idx==child.code> class="currseSideNavBlock"</#if>><a href="${contextPath}${(child.linkurl)!}?idx=${(child.code)!}">${(child.name)!}</a><span class="picIcon"></span></li>
			                        	</#if>
			                        </#list>
			                    </ul>
							</#if>
						</li>
						</#if>
		       		</#list>
	            </ul>
	        </div>
	         <div class="userName">
	            <img src="${contextPath}/css/images/admin_${(admin.roleGroupId)!}.png" width="55" height="55" />
	            <div class="userNameDetail">
	                <p class="font14">管理员：${(admin.name)!}</p>
	                <p class="nowTime"></p>
	            </div>
	            <div class="elastic_layer_header">
	            	<span class="disapper_top"></span>
	                <ul>
	                	<li><a href="${contextPath}/admin/welcome/logout.do"><img src="${contextPath}/css/images/loginOut.png" width="20" height="20" />退出登录</a></li>
	                    <li><a onClick="passwordLayerShow();"><img src="${contextPath}/css/images/rePwd.png" width="20" height="20" />修改密码</a></li>
	                </ul>
	            </div>
	        </div>
        </div>
    </div>
    <!-- end Header -->
    <div class="nav05SideNav">
    	<div class="nav05SideNav_in">
    	</div>
    </div>
    <div class="layer_switching" id="switching">
    	<div class="bottomBlock" onclick="hide_switch()"></div>
	    <div class="layerBox">
	    	<div class="content_in">
	            <h2><span>请选择切换管理系统</span><a class="btn_closedPage" onclick="closeChanger_l()"></a></h2>
	            <div class="summaryBox">
	                <div class="search-out">
	                    <ul>
	                        <li>
	                            <span>系统管理员</span>
	                            <ul class="productsName-here">
		                            <li><a href="${contextPath}/admin/welcome/toggle.do?type=0&id=0" title="系统超级管理员">超级管理员</a></li>
								</ul>
	                        </li>
	                        <!--
		                        <li>
		                            <span>酒店列表</span>
		                            <ul class="productsName-here">
		                            	<#list (hotelAdminUsers)! as h>
			                                <li><a href="${contextPath}/admin/welcome/toggle.do?type=1&id=${(h.id)!}" title="${(h.name)!}">${(h.name)!}</a></li>
			                            </#list>                        		
									</ul>
		                        </li>
	                        -->
	                    </ul>
	                </div>
	            </div>
	        </div>
	    </div>
    </div>
    
    
</#macro>


<#macro menucount>
    <div id="Header">
        <div class="logo">
            <img src="${contextPath}/css/images/logo.png">
            <span class="font14"><label>【</label><b class="ellipsis logo_Detail_name" title="${systemName}">${systemName}</b><label>】</label><#if  admin.roleGroupId==2><i class="code_new" onclick="showErweimah('${admin.hotel.name}','${imagePath}${(admin.hotel.getRealHotelUrl())!}')"><img src="${contextPath}/css/images/er.png" width="17px" height="17px" /></i></#if><div class="clear"></div></span>
        </div>
        <div class="nav">
            <ul>
            	<#list (mainPurviews)! as pur>
		   			<#assign flag=false/><#list userPurviews as up><#if pur.id==up.id><#assign flag=true/><#break/></#if></#list>
		   			<#if flag&&(pur.isMenu.value)! == 1>
					<li <#if idx?substring(0,2)==pur.code> class="currseBlock"</#if>><a class="${(pur.style)!}" href="${contextPath}${(pur.linkurl)!}"><span class="disapperBorderbottom"></span></a>
						<#if (pur.subPurviews)??&&(pur.subPurviews)?exists>
		                    
						</#if>
					</li>
					</#if>
	       		</#list>
            </ul>
        </div>
         <div class="userName">
            <img src="${contextPath}/css/images/admin_${(admin.roleGroupId)!}.png" width="55" height="55" />
            <div class="userNameDetail">
                <p class="font14">管理员：${(admin.name)!}</p>
                <p class="nowTime"></p>
            </div>
            <div class="elastic_layer_header">
            	<span class="disapper_top"></span>
                <ul>
                	<li><a href="${contextPath}/admin/welcome/logout.do"><img src="${contextPath}/css/images/loginOut.png" width="20" height="20" />退出登录</a></li>
                    <li><a onClick="passwordLayerShow();"><img src="${contextPath}/css/images/rePwd.png" width="20" height="20" />修改密码</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="nav05SideNav">
    	<div class="nav05SideNav_in">
    	</div>
    </div>
</#macro>

<#macro footer>
 <div id="Footer">
 <div class="copyright">Copyright&copy2011-2013　iGrow　浙ICP备******号-*</div>
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
<!--修改密码-->
<div class="layer_PWD">
 <div class="layer_black_bg"></div>
	<div class="fwd_content">
		<form id="passwordForm" method="post" action="${contextPath}/admin/user/password.do" >
		 <input type="hidden" name="id" value="${(admin.id)!}" />
		<div class="settlement_overview">
	    	<div class="titleH2 font14"><span>修改密码</span><a class="btn_closedPage" onclick="hidechangePsd()"></a></div>
	        <ul class="write_in_list">
	            <p id="errmsg" class="tip_psd_list redColor"></p>
	        	<li><span class="fwd_left">当前密码</span><input type="password"  class="fwd_input" id="password" name="password"  datatype="*6-18"  nullmsg="请输入当前密码!" errormsg="当前密码至少6个字符,最多18个字符！" onFocus="passwordFocus();"/></li>
	            <li><span class="fwd_left">新密码</span><input type="password"  class="fwd_input" id="newPassword" name="newPassword" plugin="passwordStrength"  datatype="*6-18" errormsg="新密码至少6个字符,最多18个字符！" nullmsg="请输入新密码!" onFocus="passwordFocus();"/></li>
	            <li class="psd_level"><span class="fwd_left">&nbsp;</span><span class="passwordStrength"><span>弱</span><span>中</span><span class="last">强</span></span></li>
	            <li><span class="fwd_left">确认密码</span><input type="password"  class="fwd_input" id="repassword" name="repassword"  datatype="*" recheck="newPassword" errormsg="您两次输入的密码不一致！" nullmsg="请输入确认密码!" onFocus="passwordFocus();"/></li>
	            <div class="clear"></div>
	        </ul>
	        <div class="order-status-btn btn_pwd btn_centerTo">
	            <span class="can-send-btn">
	            	<a class="confirm-save" onClick="modifyPassword(true,0);">保 存</a>
	                <a class="cancel-order-btn cancel-btn" onclick="passwordLayerHide()" >取 消</a>
	                <div class="clear"></div>
	            </span>
	            <div class="clear"></div>
	        </div>
	    </div>
	    </form>
	</div>
	<div class="clear"></div>
  </div>
</div>

</html>

<div class="layer_code" id="erweimashows">
	<div class="bottomBlock"></div>
	<div class="layer-content tip_why_this">
	    <div class="why_tip">
	        <h3 class="layer_title"><span id="erweimaNames"></span><a class="btn_closedPage" onclick="hideCodeL()"></a></h3>
	        <span class="two_di_l"><img id="erweimaImgs" width="100%" height="100%"/></span>
	        <div class="order-status-btn btn_centerTo">
	            <span class="can-send-btn">
	            	<a class="confirm-save" id="erweimaSaves">保 存</a>
	                <a class="cancel-btn" onclick="erweimaCloseh()">关 闭</a>
	            </span>
	        </div>
	    </div>
	</div>
</div>




</#macro>

<#macro paginationTop>
    <div class="page top05">
       	<div class="pageQuantity">
        	<label>合计</label>
        		<span id="pagerTotalCount">${(pager.totalCount)!'0'}</span>
        	<label>条,</label>
        	<label>每页</label>
        		<#list pageSizes as pgs>
  					<a <#if pgs == pager.pageSize>class="heightLight"</#if> >${pgs}</a>
  				</#list>
        	<label>条</label>
        </div>
        <div class="pageColm">
         	<a class="firstPage"></a>
	        <a class="prevPage"></a>
	        <a class="showPage">${(pager.pageNumber)!'1'}/${(pager.pageCount)!'1'}</a>
	        <a class="nextPage"></a>
	        <a class="lastPage"></a>
        </div>
        <div class="clear"></div>
     </div>
</#macro>

<#macro paginationTopinner>
    <div class="pageinner">
       	<div class="pageQuantityinner">
        	<label>合计</label>
        		${(pager.totalCount)!'0'}
        	<label>条,</label>
        	<label>每页</label>
        		<#list pageSizes as pgs>
  					<a <#if pgs == pager.pageSize>class="heightLightinner"</#if> >${pgs}</a>
  				</#list>
        	<label>条</label>
        </div>
        <div class="pageColminner">
         	<a class="firstPageinner"></a>
	        <a class="prevPageinner"></a>
	        <a class="showPageinner">${(pager.pageNumber)!'1'}/${(pager.pageCount)!'1'}</a>
	        <a class="nextPageinner"></a>
	        <a class="lastPageinner"></a>
        </div>
        <div class="clear"></div>
     </div>
</#macro>

<#macro paginationBottom>
    <div class="page">
    	<div class="pageQuantity">
    		<label>合计</label>
        		${(pager.totalCount)!'0'}
        	<label>条,</label>
        	<label>每页</label>
        		<#list pageSizes as pgs>
  					<a <#if pgs == pager.pageSize>class="heightLight"</#if> >${pgs}</a>
  				</#list>
        	<label>条</label>
        </div>
        <div class="pageColm">
         	<a class="firstPage"></a>
	        <a class="prevPage"></a>
	        <a class="showPage">${(pager.pageNumber)!'1'}/${(pager.pageCount)!'1'}</a>
	        <a class="nextPage"></a>
	        <a class="lastPage"></a>
        </div>
        <div class="clear"></div>
     </div>
     <script>
		$(function(){
		 	$(".firstPage").click(function(){
		     	if(${(pager.pageNumber)!1} - 1 == 0){
            		return false;
        		}else{
          			jumpPage(1);
       			}
		    });
		    
		    $(".prevPage").click(function(){
       			if(${(pager.pageNumber)!1} - 1 == 0){
            		return false;
        		}else{
          			jumpPage(${(pager.pageNumber)!1} - 1);
       			}
		    });
		    
		    $(".nextPage").click(function(){
       			if(${(pager.pageNumber)!1} + 1 > ${(pager.pageCount)!1}){
            		return false;
        		}else{
          			jumpPage(${(pager.pageNumber)!1} + 1);
       			}
		    });
		    
		    $(".lastPage").click(function(){
       			if(${(pager.pageNumber)!1} + 1 > ${(pager.pageCount)!1}){
            		return false;
        		}else{
          			jumpPage(${(pager.pageCount)!1});
       			}
		    });
		    
		   $(".pageQuantity").find("a").each(function(index){
	        	$(this).click(function(){
		            clearClass();
		            $(this).addClass("heightLight");
		            $("#pageSize").val($(this).text());
		            jumpPage(1);
	        	});
     		});
		    
		});
		//清除样式
		function clearClass(){
		     $(".pageQuantity").find("a").each(function(index){
		         $(this).removeClass("heightLight");
		     });
		}
		//页面跳转
		function jumpPage(curPage){
		  	$("#pageNumber").val(curPage);
		   	$("#searchForm").submit();
		   	//commonSearch();
		}
	</script>
</#macro>


<#macro paginationBottominner>
    <div class="pageinner">
    	<div class="pageQuantityinner">
    		<label>合计</label>
        		${(pager.totalCount)!'0'}
        	<label>条,</label>
        	<label>每页</label>
        		<#list pageSizes as pgs>
  					<a <#if pgs == pager.pageSize>class="heightLightinner"</#if> >${pgs}</a>
  				</#list>
        	<label>条</label>
        </div>
        <div class="pageColminner">
         	<a class="firstPageinner"></a>
	        <a class="prevPageinner"></a>
	        <a class="showPageinner">${(pager.pageNumber)!1}/${(pager.pageCount)!1}</a>
	        <a class="nextPageinner"></a>
	        <a class="lastPageinner"></a>
        </div>
        <div class="clear"></div>
     </div>
     <script>
		$(function(){
		 	$(".firstPageinner").click(function(){
		     	if(${(pager.pageNumber)!1} - 1 == 0){
            		return false;
        		}else{
          			jumpPageinner(1);
       			}
		    });
		    
		    $(".prevPageinner").click(function(){
       			if(${(pager.pageNumber)!1} - 1 == 0){
            		return false;
        		}else{
          			jumpPageinner(${(pager.pageNumber)!1} - 1);
       			}
		    });
		    
		    $(".nextPageinner").click(function(){
       			if(${(pager.pageNumber)!1} + 1 > ${(pager.pageCount)!1}){
            		return false;
        		}else{
          			jumpPageinner(${(pager.pageNumber)!1} + 1);
       			}
		    });
		    
		    $(".lastPageinner").click(function(){
       			if(${(pager.pageNumber)!1} + 1 > ${(pager.pageCount)!1}){
            		return false;
        		}else{
          			jumpPageinner(${(pager.pageCount)!1});
       			}
		    });
		    
		   $(".pageQuantityinner").find("a").each(function(index){
	        	$(this).click(function(){
		            clearClass();
		            $(this).addClass("heightLightinner");
		            $("#pageSizeinner").val($(this).text());
		            jumpPageinner(1);
	        	});
     		});
		    
		});
		//清除样式
		function clearClass(){
		     $(".pageQuantityinner").find("a").each(function(index){
		         $(this).removeClass("heightLightinner");
		     });
		}
		//页面跳转
		function jumpPageinner(curPage){
		  	$("#pageNumberinner").val(curPage);
		   	searchForminner();
		}
	</script>
</#macro>
