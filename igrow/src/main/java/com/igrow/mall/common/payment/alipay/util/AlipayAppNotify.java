package com.igrow.mall.common.payment.alipay.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.igrow.mall.common.payment.alipay.config.AlipayConfig;
import com.igrow.mall.common.payment.alipay.sign.RSA;
import com.igrow.mall.common.util.DateUtils;

/**
* @ClassName AlipayAppNotify
* @Description TODO【支付宝通知处理类】
* @Author Brights
* @Date 2013-11-15 上午10:02:49
*/ 
public class AlipayAppNotify {

    /**
     * 支付宝消息验证地址
     */
    private static final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";

    /**
     * 验证消息是否是支付宝发出的合法消息
     * @param params 通知返回来的参数数组
     * @return 验证结果
     */
    public static boolean verify(Map<String, String> params,Map<String, String> alipayParam) {

        //判断responsetTxt是否为true，isSign是否为true
        //responsetTxt的结果不是true，与服务器设置问题、合作身份者ID、notify_id一分钟失效有关
        //isSign不是true，与安全校验码、请求时的参数格式（如：带自定义参数等）、编码格式有关
    	String responseTxt = "true";
		if(params.get("notify_id") != null) {
			String notify_id = params.get("notify_id");
			responseTxt = verifyResponse(notify_id,alipayParam);
		}
	    String sign = "";
	    if(params.get("sign") != null) {sign = params.get("sign");}
	    boolean isSign = getSignVeryfy(params, sign,alipayParam);
        //写日志记录（若要调试，请取消下面两行注释）
        String sWord = "responseTxt=" + responseTxt + "\n isSign=" + isSign + "\n 返回回来的参数：" + AlipayCore.createLinkString(params);
	    AlipayCore.logResult(sWord);
	    System.out.println("isSign" +isSign);
	    System.out.println("responseTxt" +responseTxt);
        if (isSign && responseTxt.equals("true")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据反馈回来的信息，生成签名结果
     * @param Params 通知返回来的参数数组
     * @param sign 比对的签名结果
     * @return 生成的签名结果
     */
	private static boolean getSignVeryfy(Map<String, String> Params, String sign,Map<String, String> alipayParam) {
    	//过滤空值、sign与sign_type参数
    	Map<String, String> sParaNew = AlipayCore.paraFilter(Params);
        //获取待签名字符串
        String preSignStr = AlipayCore.createLinkString(sParaNew);
        System.out.println("preSignStr=" +preSignStr);
        //获得签名验证结果
        boolean isSign = false;
        if(AlipayConfig.app_sign_type.equals("RSA")){
        	isSign = RSA.verify(preSignStr, sign, AlipayConfig.APP_ALI_PUBLIC_KEY, AlipayConfig.input_charset);
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
    private static String verifyResponse(String notify_id,Map<String, String> alipayParam) {
        //获取远程服务器ATN结果，验证是否是支付宝服务器发来的请求

        //String partner = AlipayConfig.partner;
        String veryfy_url = HTTPS_VERIFY_URL + "partner=" + alipayParam.get(AlipayConfig.PARTNER) + "&notify_id=" + notify_id;
        System.out.println(veryfy_url);
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
    	responseTxtBuffer.append(AlipayCore.createLinkString(params));
    	return responseTxtBuffer.toString();
    }
}
