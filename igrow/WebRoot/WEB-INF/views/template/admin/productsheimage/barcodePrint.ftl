 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>打印条码</title>
<link href="${contextPath}/css/commodity.css" rel="stylesheet" />
<script src="${contextPath}/js/jquery-1.7.2.min.js"></script>
<script src="${contextPath}/js/nowTime.js"></script>
<style type="text/css">
*{ margin:0; padding:0;}
.clear{ clear:both;}
body{ font-size:9pt;font-family: arial,sans-serif;font-size: 9pt;line-height: 150%;}
/* new print */
#print_area{ clear:both;}
#p_main{margin: 0 auto;padding:5mm 13mm 15mm 15mm;text-align: left;width: 182mm;}
#p_main .titleH2 .rightText{ float:right; padding-bottom:20px;}
.barcord_area{margin-bottom: 7mm;display: inline-block;vertical-align:top; width:45%;}
.barcord_title{display: inline-block;padding-right:3%;vertical-align: middle; width:49%; word-break: break-all;}
.barcord_img {display: inline-block;height: 18mm;vertical-align: middle; width:46%;}
.second_barcord_area {padding-right:9%;}
</style>
<script type="text/javascript">
  function printme(){
	    document.body.innerHTML="<div id='p_main'>"+$("#print_area").html()+"</div>";
	    window.print();
	    
  }
</script>
</head>
<body>
<div id="p_main">
	<div class="titleH2 font14">
		<span class="rightText barcordUpdate"><a class="printBarcode" onclick="printme()">打 印</a>
		</span>
	</div>
<div id="print_area">
	${(stockDto.hotel.name)!}&nbsp;&nbsp;<span class="nowTime"></span>
	<p></p><br/>
	<#if (pager.results)??>
    <#list pager.results as obj>
		<div class="barcord_area <#if obj_index%2==0>second_barcord_area</#if>">
		    	<div class="barcord_title">${(obj.productShelves.productInfo.name)!""}<br>￥${(obj.price)!}<br>(${(obj.specificationValue)!""}*${(obj.propertyValue)!""})</div>
		        <div class="barcord_img"><img src="http://www.1ct.cc:8080/borMall/barcode?msg=1<#if (obj.id)?length ==1>00000${(obj.id)}<#elseif (obj.id)?length ==2>0000${(obj.id)}<#elseif (obj.id)?length ==3>000${(obj.id)}<#elseif (obj.id)?length ==4>00${(obj.id)}<#elseif (obj.id)?length ==5>0${(obj.id)}<#else>${(obj.id)}</#if>9&type=code39" width="100%" /></div>
				<div class="clear"></div>
		</div>
    </#list>
	<#else>
    <tr>
         ${action.getText("msg.no.data")} 
    </tr>
	</#if>
	<div class="clear"></div>
</div>
</div>
</body>
</html>