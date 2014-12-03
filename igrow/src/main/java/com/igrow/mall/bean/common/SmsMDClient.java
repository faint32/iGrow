package com.igrow.mall.bean.common;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @ClassName SmsMDClient
* @Description TODO【漫道短信】
* @Author Brights
* @Date 2014-1-14 下午12:23:04
*/ 
public class SmsMDClient {
	
	private String pwd = "";// 密码
	private String serviceURL; 
	private String sn;// 序列号
	private String password;
	
	/**
	* @Title 
	* @Description 
	* @param sn
	* @param password
	* @param serviceurl
	* @throws UnsupportedEncodingException
	*/ 
	public SmsMDClient(String sn, String password, String serviceurl)
			throws UnsupportedEncodingException {
		this.sn = sn;
		this.password = password;
		this.pwd = this.getMD5(sn + password);
		this.serviceURL = serviceurl;
	}



	/**
	* @Title sendSMS
	* @Description TODO【短信发送】
	* @param mobiles
	* @param content
	* @return 
	* @Return int 返回类型
	* @Throws 
	*/ 
	public int sendSMS(String[] mobiles, String content,Integer priority){
		String result_mt = sendSms(getMobiles(mobiles), content, "", "", "");
		if(result_mt.startsWith("-")||result_mt.equals("")){//发送短信，如果是以负号开头就是发送失败。
			System.out.print("发送失败！返回值为："+result_mt+"请查看webservice返回值对照表");
			return -1;
		}else{//输出返回标识，为小于19位的正数，String类型的。记录您发送的批次。
			System.out.print("发送成功，返回值为："+result_mt);
			return 0;
		}
	}

	/**
	* @Title send
	* @Description TODO【这里用一句话描述这个方法的作用】
	* @param mobile
	* @param content
	* @param ext
	* @param stime
	* @param rrid
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String sendSms(String mobile, String content, String ext, String stime,
			String rrid) {
		String result = "";
		String soapAction = "http://tempuri.org/mdSmsSend_u";
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
		xml += "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">";
		xml += "<soap:Body>";
		xml += "<mdSmsSend_u xmlns=\"http://tempuri.org/\">";
		xml += "<sn>" + sn + "</sn>";
		xml += "<pwd>" + pwd + "</pwd>";
		xml += "<mobile>" + mobile + "</mobile>";
		xml += "<content>" + content + "</content>";
		xml += "<ext>" + ext + "</ext>";
		xml += "<stime>" + stime + "</stime>";
		xml += "<rrid>" + rrid + "</rrid>";
		xml += "</mdSmsSend_u>";
		xml += "</soap:Body>";
		xml += "</soap:Envelope>";
		URL url;
		try {
			url = new URL(serviceURL);

			URLConnection connection = url.openConnection();
			HttpURLConnection httpconn = (HttpURLConnection) connection;
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			bout.write(xml.getBytes("GBK"));
			//如果您的系统是utf-8,这里请改成bout.write(xml.getBytes("GBK"));

			byte[] b = bout.toByteArray();
			httpconn.setRequestProperty("Content-Length", String
					.valueOf(b.length));
			httpconn.setRequestProperty("Content-Type",
					"text/xml; charset=gb2312");
			httpconn.setRequestProperty("SOAPAction", soapAction);
			httpconn.setRequestMethod("POST");
			httpconn.setDoInput(true);
			httpconn.setDoOutput(true);

			OutputStream out = httpconn.getOutputStream();
			out.write(b);
			out.close();

			InputStreamReader isr = new InputStreamReader(httpconn
					.getInputStream());
			BufferedReader in = new BufferedReader(isr);
			String inputLine;
			while (null != (inputLine = in.readLine())) {
				Pattern pattern = Pattern.compile("<mdSmsSend_uResult>(.*)</mdSmsSend_uResult>");
				Matcher matcher = pattern.matcher(inputLine);
				while (matcher.find()) {
					result = matcher.group(1);
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	* @Title register
	* @Description TODO【注册】
	* @param province
	* @param city
	* @param trade
	* @param entname
	* @param linkman
	* @param phone
	* @param mobile
	* @param email
	* @param fax
	* @param address
	* @param postcode
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String register(String province, String city, String trade,
			String entname, String linkman, String phone, String mobile,
			String email, String fax, String address, String postcode) {
		String result = "";
		String soapAction = "http://tempuri.org/Register";
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
		xml += "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">";
		xml += "<soap12:Body>";
		xml += "<Register xmlns=\"http://tempuri.org/\">";
		xml += "<sn>" + sn + "</sn>";
		xml += "<pwd>" + password + "</pwd>";
		xml += "<province>" + province + "</province>";
		xml += "<city>" + city + "</city>";
		xml += "<trade>" + trade + "</trade>";
		xml += "<entname>" + entname + "</entname>";
		xml += "<linkman>" + linkman + "</linkman>";
		xml += "<phone>" + phone + "</phone>";
		xml += "<mobile>" + mobile + "</mobile>";
		xml += "<email>" + email + "</email>";
		xml += "<fax>" + fax + "</fax>";
		xml += "<address>" + address + "</address>";
		xml += "<postcode>" + postcode + "</postcode>";
		xml += "</Register>";
		xml += "</soap12:Body>";
		xml += "</soap12:Envelope>";

		URL url;
		try {
			url = new URL(serviceURL);

			URLConnection connection = url.openConnection();
			HttpURLConnection httpconn = (HttpURLConnection) connection;
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			bout.write(xml.getBytes());
			//bout.write(xml.getBytes("GBK"));
			byte[] b = bout.toByteArray();
			httpconn.setRequestProperty("Content-Length", String
					.valueOf(b.length));
			httpconn.setRequestProperty("Content-Type",
					"text/xml; charset=gb2312");
			httpconn.setRequestProperty("SOAPAction", soapAction);
			httpconn.setRequestMethod("POST");
			httpconn.setDoInput(true);
			httpconn.setDoOutput(true);

			OutputStream out = httpconn.getOutputStream();
			out.write(b);
			out.close();

			InputStreamReader isr = new InputStreamReader(httpconn
					.getInputStream());
			BufferedReader in = new BufferedReader(isr);
			String inputLine;
			while (null != (inputLine = in.readLine())) {
				Pattern pattern = Pattern
						.compile("<RegisterResult>(.*)</RegisterResult>");
				Matcher matcher = pattern.matcher(inputLine);
				while (matcher.find()) {
					result = matcher.group(1);
				}
			}
			in.close();
			return new String(result.getBytes(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	* @Title getMD5
	* @Description TODO【Md5】
	* @param sourceStr
	* @return
	* @throws UnsupportedEncodingException 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String getMD5(String sourceStr) throws UnsupportedEncodingException {
		String resultStr = "";
		try {
			byte[] temp = sourceStr.getBytes();
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(temp);
			// resultStr = new String(md5.digest());
			byte[] b = md5.digest();
			for (int i = 0; i < b.length; i++) {
				char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
						'9', 'A', 'B', 'C', 'D', 'E', 'F' };
				char[] ob = new char[2];
				ob[0] = digit[(b[i] >>> 4) & 0X0F];
				ob[1] = digit[b[i] & 0X0F];
				resultStr += new String(ob);
			}
			return resultStr;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	* @Title getMobiles
	* @Description TODO【手机号码字符串】
	* @param mobiles
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String getMobiles(String[] mobiles){
		String result = "";
		if(mobiles != null && mobiles.length > 0){
			StringBuilder sbMobile = new StringBuilder();
			for(int i = 0;i<mobiles.length;i++)
			{
			    if(i != mobiles.length-1){
			    	sbMobile.append(mobiles[i]);
			    	sbMobile.append(",");
			    }else{
			    	sbMobile.append(mobiles[i]);
			    }
			}
			return sbMobile.toString();
		}
		return result;
	}
} 