package com.igrow.mall.common.payment.alipay.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;

import com.igrow.mall.common.payment.alipay.config.AlipayConfig;
import com.igrow.mall.common.payment.alipay.sign.MD5;
import com.igrow.mall.common.payment.alipay.sign.RSA;
import com.igrow.mall.common.util.DateUtils;

/**
* @ClassName AlipayWapNotify
* @Description TODO【支付宝通知处理类】
* @Author Brights
* @Date 2013-11-15 上午10:03:42
*/ 
public class AlipayWapNotify {

    /**
     * 支付宝消息验证地址
     */
    private static final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";
    

    /**
     * 验证消息是否是支付宝发出的合法消息，验证服务器异步通知
     * @param params 通知返回来的参数数组
     * @return 验证结果
     */
    public static boolean verifyNotify(Map<String, String> params,Map<String,String> alipayParam,String signType) throws Exception {
    
    	//获取是否是支付宝服务器发来的请求的验证结果
    	String responseTxt = "true";
    	try {
        	//XML解析notify_data数据，获取notify_id
	    	Document document = DocumentHelper.parseText(params.get("notify_data"));
	    	String notify_id = document.selectSingleNode( "//notify/notify_id" ).getText();
			responseTxt = verifyResponse(notify_id,alipayParam);
    	} catch(Exception e) {
    		responseTxt = "false";
    	}
    	
    	//获取返回时的签名验证结果
	    String sign = "";
	    if(params.get("sign") != null) {sign = params.get("sign");}
	    boolean isSign = getSignVeryfy(params, sign,alipayParam,signType);

        //写日志记录（若要调试，请取消下面两行注释）
        String sWord = "responseTxt=" + responseTxt + "\n isSign=" + isSign + "\n 返回回来的参数：" + AlipayCore.createLinkStringNoSort(params);
	    AlipayCore.logResult(sWord);

        //判断responsetTxt是否为true，isSign是否为true
        //responsetTxt的结果不是true，与服务器设置问题、合作身份者ID、notify_id一分钟失效有关
        //isSign不是true，与安全校验码、请求时的参数格式（如：带自定义参数等）、编码格式有关
        if (isSign && responseTxt.equals("true")) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * 解密
     * @param inputPara 要解密数据
     * @return 解密后结果
     */
    public static Map<String, String> decrypt(Map<String, String> inputPara,Map<String,String> alipayParam ) throws Exception {
    	inputPara.put("notify_data", RSA.decrypt(inputPara.get("notify_data"), alipayParam.get(AlipayConfig.PRIVATE_KEY), AlipayConfig.input_charset));
    	return inputPara;
    }

    /**
     * 根据反馈回来的信息，生成签名结果
     * @param Params 通知返回来的参数数组
     * @param sign 比对的签名结果
     * @param isSort 是否排序
     * @return 生成的签名结果
     */
	private static boolean getSignVeryfy(Map<String, String> Params, String sign,Map<String,String> alipayParam,String signType) {
    	//过滤空值、sign与sign_type参数
    	Map<String, String> sParaNew = AlipayCore.paraFilter(Params);
        //获取待签名字符串
    	String preSignStr = AlipayCore.createLinkStringNoSort(sParaNew);
    	System.out.println("preSignStr="+preSignStr);
        //获得签名验证结果
        boolean isSign = false;
        if(signType.equals(AlipayConfig.wap_sign_type_md5) ) {
        	isSign = MD5.verify(preSignStr, sign, alipayParam.get(AlipayConfig.KEY), AlipayConfig.input_charset);
        }
        if(signType.equals(AlipayConfig.wap_sign_type_rsa)){
        	//isSign = RSA.verify(preSignStr, sign, AlipayConfig.ALI_PUBLIC_KEY, AlipayConfig.input_charset);
        	isSign = RSA.verify(preSignStr, sign, AlipayConfig.WAP_ALI_PUBLIC_KEY, AlipayConfig.input_charset);
        }
        return isSign;
    }

    /**
    * 获取远程服务器ATN结果,验证返回URL
    * @param notify_id 通知校验ID
    * @return 服务器ATN结果
    * 验证结果集：
    * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 
    * true 返回正确信息
    * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
    */
    private static String verifyResponse(String notify_id,Map<String,String> alipayParam) {
        //获取远程服务器ATN结果，验证是否是支付宝服务器发来的请求
        String veryfy_url = HTTPS_VERIFY_URL + "partner=" + alipayParam.get(AlipayConfig.PARTNER) + "&notify_id=" + notify_id;
        return checkUrl(veryfy_url);
    }

    /**
    * 获取远程服务器ATN结果
    * @param urlvalue 指定URL路径地址
    * @return 服务器ATN结果
    * 验证结果集：
    * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 
    * true 返回正确信息
    * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
    */
    private static String checkUrl(String urlvalue) {
        String inputLine = "";
        try {
            URL url = new URL(urlvalue);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection
                .getInputStream()));
            inputLine = in.readLine().toString();
        } catch (Exception e) {
            e.printStackTrace();
            inputLine = "";
        }

        return inputLine;
    }
    
    /**
     * @Title getLogResultTxt
     * @Description TODO【获取日志】
     * @return 
     * @Return String 返回类型
     * @Throws 
     */ 
     public static String getLogResultTxt(Map<String, String> params,HttpServletRequest request,String sn){
     	StringBuffer responseTxtBuffer = new StringBuffer();
     	responseTxtBuffer.append("[");
     	responseTxtBuffer.append(DateUtils.formatString(new Date(), "yyyy-MM-dd HH:mm:ss"));
     	responseTxtBuffer.append("]");
     	responseTxtBuffer.append("【");
     	responseTxtBuffer.append(params.get("out_trade_no"));
     	responseTxtBuffer.append("】");
     	responseTxtBuffer.append("(");
     	responseTxtBuffer.append(params.get("trade_status"));
     	responseTxtBuffer.append(",");
     	responseTxtBuffer.append(params.get("total_fee"));
     	responseTxtBuffer.append(")");
     	responseTxtBuffer.append(":");
     	responseTxtBuffer.append(request.getRequestURL());
     	responseTxtBuffer.append("?");
     	responseTxtBuffer.append(AlipayCore.createLinkStringNoSort(params));
     	return responseTxtBuffer.toString();
     }
     
     public static void main(String[] args) {
		String sign = "IOLT6ASscHSikbjKpp1Mnl/EuKcK35ZY3nS2TSSe/42dFlAKZ5p3uSyrF1nP+hhlc1QP457s/y4hwxLSSfM1kbv0vp5A0rUah5DIm+JYM2AEw18yDndaYDzOI6oou58/ppnXgHISMlBvbogmz6LZ6nripIx1u9AWo44Elcq6+TE=";
		String preSignStr = "service=alipay.wap.trade.create.direct&v=1.0&sec_id=0001&notify_data=<notify><payment_type>1</payment_type><subject>黑白象</subject><trade_no>2013120331922796</trade_no><buyer_email>15869126351@139.com</buyer_email><gmt_create>2013-12-03 17:34:54</gmt_create><notify_type>trade_status_sync</notify_type><quantity>1</quantity><out_trade_no>BR4996e9044df84168c0000153</out_trade_no><notify_time>2013-12-03 17:35:21</notify_time><seller_id>2088011692572096</seller_id><trade_status>TRADE_FINISHED</trade_status><is_total_fee_adjust>N</is_total_fee_adjust><total_fee>0.01</total_fee><gmt_payment>2013-12-03 17:35:21</gmt_payment><seller_email>borabora@atbora.com</seller_email><gmt_close>2013-12-03 17:35:21</gmt_close><price>0.01</price><buyer_id>2088202466862965</buyer_id><notify_id>beb44e938e1684c3bedd82630b3122b77c</notify_id><use_coupon>N</use_coupon></notify>";
		//String preSignStr = "sec_id=0001&v=1.0&notify_data=<notify><payment_type>1</payment_type><subject>黑白象</subject><trade_no>2013120331922796</trade_no><buyer_email>15869126351@139.com</buyer_email><gmt_create>2013-12-03 17:34:54</gmt_create><notify_type>trade_status_sync</notify_type><quantity>1</quantity><out_trade_no>BR4996e9044df84168c0000153</out_trade_no><notify_time>2013-12-03 17:35:21</notify_time><seller_id>2088011692572096</seller_id><trade_status>TRADE_FINISHED</trade_status><is_total_fee_adjust>N</is_total_fee_adjust><total_fee>0.01</total_fee><gmt_payment>2013-12-03 17:35:21</gmt_payment><seller_email>borabora@atbora.com</seller_email><gmt_close>2013-12-03 17:35:21</gmt_close><price>0.01</price><buyer_id>2088202466862965</buyer_id><notify_id>beb44e938e1684c3bedd82630b3122b77c</notify_id><use_coupon>N</use_coupon></notify>&service=alipay.wap.trade.create.direct";
		boolean isSign = RSA.verify(preSignStr, sign, AlipayConfig.WAP_ALI_PUBLIC_KEY, AlipayConfig.input_charset);
		System.out.println(isSign);
     }
}
