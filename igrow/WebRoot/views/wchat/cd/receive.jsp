<meta charset="UTF-8">
<meta http-equiv="Cache-control" />
<meta name="format-detection" content="telephone=no" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<meta name="viewport" content="width=device-width; maximum-scale=1.0;  user-scalable=no; initial-scale=1.0" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.igrow.mall.bean.card.jsapi.WchatJsapiBean"%>
<%
//=================================
//jsapi接口
//=================================
	String cardId = request.getParameter("id");
	String code = request.getParameter("code");
	String openid = request.getParameter("openid");
	String balance = request.getParameter("balance");
	String reqData = WchatJsapiBean.getWchatBatchAddCardReqData(cardId, code, openid, balance);
%>
<html>
	<head>
	 <script type="text/javascript" src="/borMall/js/jquery-1.7.2.min.js"></script>
		<script language="javascript">
		 $(function () {
			 //触发按钮事件
			 alert(navigator.userAgent);
			 //
			 //alert(<%= reqData %>);
			 readyFunc();
			 $('#receive').trigger("click");
			
         });  
		 //定义加载方法
		 var readyFunc = function onBridgeReady() {
			 //$('#receive').addEventListener('click',
			 function(e) {
				 alert(1111);
				 <%-- WeixinJSBridge.invoke('batchAddCard',<%= reqData %>,
						  function(res){
						    if(res.err_msg == "batch_add_card:ok") {
						    	alert("领取成功");
						    }else if(res.err_msg == "batch_add_card:fail"){
						    	alert("领取失败");
						    }else if(res.err_msg == "batch_add_card:cancel"){
						    	alert("取消");
						    }else{
						    	alert("未知");   
						    }
						  }
				); --%>
				 
			 }
			 //); 
			 //}
		 
		if (typeof WeixinJSBridge === "undefined") {
			document.addEventListener('WeixinJSBridgeReady', readyFunc, false);
		} else {
			readyFunc(); 
		}
		</script>
	</head>
  <body>
    <div style="display:black;">
        <button id="receive" type="button"  >wx card receive test</button>
    </div>  
  </body>
</html>
