package com.igrow.mall.bean.weixin;

import java.io.IOException;


import net.sf.json.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Weixin {
	private final static Log log = LogFactory.getLog(Weixin.class);
	public final static String HOST = "http://mp.weixin.qq.com";
	public final static String LOGIN_URL = "https://mp.weixin.qq.com/cgi-bin/login";
	public final static String INDEX_URL = "http://mp.weixin.qq.com/cgi-bin/indexpage?t=wxm-index&lang=zh_CN";
	public final static String SENDMSG_URL ="https://mp.weixin.qq.com/cgi-bin/singlesend";
	public final static String FANS_URL = "http://mp.weixin.qq.com/cgi-bin/contactmanagepage?t=wxm-friend&lang=zh_CN&pagesize=10&pageidx=0&type=0&groupid=0";
	public final static String LOGOUT_URL = "https://mp.weixin.qq.com/cgi-bin/logout?t=wxm-logout&lang=zh_CN";
	public final static String DOWNLOAD_URL = "http://mp.weixin.qq.com/cgi-bin/downloadfile?";
	public final static String VERIFY_CODE = "http://mp.weixin.qq.com/cgi-bin/verifycode?";
	public final static String POST_MSG = "https://mp.weixin.qq.com/cgi-bin/masssend?t=ajax-response";
	public final static String VIEW_HEAD_IMG = "http://mp.weixin.qq.com/cgi-bin/viewheadimg";
	public final static String GET_IMG_DATA = "http://mp.weixin.qq.com/cgi-bin/getimgdata";
	public final static String GET_REGIONS = "http://mp.weixin.qq.com/cgi-bin/getregions";
	public final static String GET_MESSAGE = "http://mp.weixin.qq.com/cgi-bin/getmessage";
	public final static String OPER_ADVANCED_FUNC = "http://mp.weixin.qq.com/cgi-bin/operadvancedfunc";
	public final static String MASSSEND_PAGE = "http://mp.weixin.qq.com/cgi-bin/masssendpage";
	public final static String FILE_MANAGE_PAGE = "http://mp.weixin.qq.com/cgi-bin/filemanagepage";
	public final static String OPERATE_APPMSG = "https://mp.weixin.qq.com/cgi-bin/operate_appmsg?token=416919388&lang=zh_CN&sub=edit&t=wxm-appmsgs-edit-new&type=10&subtype=3&ismul=1";
	public final static String FMS_TRANSPORT = "http://mp.weixin.qq.com/cgi-bin/fmstransport";
	//public final static String CONTACT_MANAGE_PAGE = "http://mp.weixin.qq.com/cgi-bin/contactmanagepage";
	public final static String CONTACT_MANAGE_PAGE = "http://mp.weixin.qq.com/cgi-bin/contactmanage";
	public final static String OPER_SELF_MENU = "http://mp.weixin.qq.com/cgi-bin/operselfmenu";
	public final static String REPLY_RULE_PAGE = "http://mp.weixin.qq.com/cgi-bin/replyrulepage";
	public final static String SINGLE_MSG_PAGE = "http://mp.weixin.qq.com/cgi-bin/singlemsgpage";
	public final static String USER_INFO_PAGE = "http://mp.weixin.qq.com/cgi-bin/userinfopage";
	public final static String DEV_APPLY = "http://mp.weixin.qq.com/cgi-bin/devapply";
	public final static String UPLOAD_MATERIAL = "https://mp.weixin.qq.com/cgi-bin/uploadmaterial?cgi=uploadmaterial&type=2&token=416919388&t=iframe-uploadfile&lang=zh_CN&formId=1";

	public final static String USER_AGENT_H = "User-Agent";
	public final static String REFERER_H = "Referer";
	public final static String USER_AGENT = "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.172 Safari/537.22";
	public final static String UTF_8 = "UTF-8";

	private HttpClient client = new HttpClient();

	private Cookie[] cookies;
	private String cookiestr;

	private String token;
	private int loginErrCode;
	private String loginErrMsg;
	private int msgSendCode;
	private String msgSendMsg;
	private String loginUser;
	private String loginPwd;
	public boolean isLogin = false;

	public Weixin(String user, String pwd) {
		this.loginUser = user;
		this.loginPwd = pwd;
	}

	public Cookie[] getCookies() {
		return cookies;
	}

	public void setCookies(Cookie[] cookies) {
		this.cookies = cookies;
	}

	public String getCookiestr() {
		return cookiestr;
	}

	public void setCookiestr(String cookiestr) {
		this.cookiestr = cookiestr;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getLoginErrCode() {
		return loginErrCode;
	}

	public void setLoginErrCode(int loginErrCode) {
		this.loginErrCode = loginErrCode;
	}

	public String getLoginErrMsg() {
		return loginErrMsg;
	}

	public void setLoginErrMsg(String loginErrMsg) {
		this.loginErrMsg = loginErrMsg;
	}

	public int getMsgSendCode() {
		return msgSendCode;
	}

	public void setMsgSendCode(int msgSendCode) {
		this.msgSendCode = msgSendCode;
	}

	public String getMsgSendMsg() {
		return msgSendMsg;
	}

	public void setMsgSendMsg(String msgSendMsg) {
		this.msgSendMsg = msgSendMsg;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}


	/**
	 * 登录,登录失败会重复请求登录
	 */
	public void login() {
		boolean bool = _login();
		while (!bool) {
			String info = "【登录失败】【错误代码：" + this.loginErrMsg + "】【账号："
					+ this.loginUser + "】正在尝试重新登录....";
			log.debug(info);
			System.out.println(info);
			bool = _login();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				bool = _login();
			}

		}
		System.out.println("登陆成功：");
	}

	/**
	 * 发送登录信息,记录cookie，登录状态，token等信息
	 *
	 * @return
	 */
	private boolean _login() {
		try {
			PostMethod post = new PostMethod(LOGIN_URL);
			post.setRequestHeader("Referer", "https://mp.weixin.qq.com/");
			post.setRequestHeader(USER_AGENT_H, USER_AGENT);
			NameValuePair[] params = new NameValuePair[]{
					new NameValuePair("username", this.loginUser),
					new NameValuePair("pwd", DigestUtils.md5Hex(this.loginPwd.getBytes())), 
					new NameValuePair("f", "json"),
					new NameValuePair("imagecode", "")};
			post.setQueryString(params);
			int status = client.executeMethod(post);
			if (status == HttpStatus.SC_OK) {
				String ret = post.getResponseBodyAsString();
				System.out.println(ret);
				JSONObject jsonObj = JSONObject.fromObject(ret);
				Integer retCode =  jsonObj.getJSONObject("base_resp").getInt("ret");
				String errMsg = jsonObj.getJSONObject("base_resp").getString("err_msg");
				String redirectUrl = jsonObj.getString("redirect_url");
				if (retCode == 0 && errMsg.equals("ok")) {
					this.cookies = client.getState().getCookies();
					StringBuffer cookie = new StringBuffer();
					for (Cookie c : client.getState().getCookies()) {
						cookie.append(c.getName()).append("=")
						.append(c.getValue()).append(";");
					}
					this.cookiestr = cookie.toString();
					this.isLogin = true;
					this.token = getToken(redirectUrl);
					System.out.println("token="+token);
					return true;
				}
				int errCode = retCode;
				this.loginErrCode = errCode;
				switch (errCode) {

				case -1:
					this.loginErrMsg = "系统错误";
					return false;
				case -2:
					this.loginErrMsg = "帐号或密码错误";
					return false;
				case -3:
					this.loginErrMsg = "密码错误";
					return false;
				case -4:
					this.loginErrMsg = "不存在该帐户";
					return false;
				case -5:
					this.loginErrMsg = "访问受限";
					return false;
				case -6:
					this.loginErrMsg = "需要输入验证码";
					return false;
				case -7:
					this.loginErrMsg = "此帐号已绑定私人微信号，不可用于公众平台登录";
					return false;
				case -8:
					this.loginErrMsg = "邮箱已存在";
					return false;
				case -32:
					this.loginErrMsg = "验证码输入错误";
					return false;
				case -200:
					this.loginErrMsg = "因频繁提交虚假资料，该帐号被拒绝登录";
					return false;
				case -94:
					this.loginErrMsg = "请使用邮箱登陆";
					return false;
				case 10:
					this.loginErrMsg = "该公众会议号已经过期，无法再登录使用";
					return false;
				case 65201:
				case 65202:
					this.loginErrMsg = "成功登陆，正在跳转...";
					return true;
				case 0:
					this.loginErrMsg = "成功登陆，正在跳转...";
					return true;
				default:
					this.loginErrMsg = "未知的返回";
					return false;
				}
			}
		} catch (Exception e) {
			String info = "【登录失败】【发生异常：" + e.getMessage() + "】";
			System.err.println(info);
			log.debug(info);
			log.info(info);
			return false;
		}
		return false;
	}

	/**
	 * 从登录成功的信息中分离出token信息
	 *
	 * @param s
	 * @return
	 */
	private String getToken(String s) {
		try {
			if (StringUtils.isBlank(s))
				return null;
			String[] ss = StringUtils.split(s, "?");
			String[] params = null;
			if (ss.length == 2) {
				if (!StringUtils.isBlank(ss[1]))
					params = StringUtils.split(ss[1], "&");
			} else if (ss.length == 1) {
				if (!StringUtils.isBlank(ss[0]) && ss[0].indexOf("&") != -1)
					params = StringUtils.split(ss[0], "&");
			} else {
				return null;
			}
			for (String param : params) {
				if (StringUtils.isBlank(param))
					continue;
				String[] p = StringUtils.split(param, "=");
				if (null != p && p.length == 2
						&& StringUtils.equalsIgnoreCase(p[0], "token"))
					return p[1];

			}
		} catch (Exception e) {
			String info = "【解析Token失败】【发生异常：" + e.getMessage() + "】";
			System.err.println(info);
			log.debug(info);
			log.info(info);
			return null;
		}
		return null;
	}
	

	/**
	 * 注销操作
	 *
	 * @throws HttpException
	 * @throws IOException
	 */
	public void logout()  {
		GetMethod get = new GetMethod(LOGOUT_URL+"&token="+this.getToken());
		get.setRequestHeader(USER_AGENT_H, USER_AGENT);
		get.setRequestHeader("Cookie", this.cookiestr);
		int status;
		try {
			status = client.executeMethod(get);
			if (status == HttpStatus.SC_OK) {
				System.err.println("-----------注销登录成功-----------");
			}
		} catch (HttpException e) {
			e.printStackTrace();
			System.err.println("-----------注销登录失败-----------");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("-----------注销登录失败-----------");
		}
		
	}
	
	public  String dataGenerate(String url) throws IOException{
		GetMethod get = new GetMethod(url);
		get.setRequestHeader(USER_AGENT_H, USER_AGENT);
		get.setRequestHeader("Cookie", this.cookiestr);
		int status = client.executeMethod(get);
		if (status == HttpStatus.SC_OK) {
			String datas = get.getResponseBodyAsString();
			if(StringUtils.isNotBlank(datas)){
				 String temp = datas.split("infos =")[1];
				 if(StringUtils.isNotBlank(temp)){
					String data = temp.split("}},")[0] + "}}"; 
					System.err.println(data);
					return data;
				 }
			}
		}
		return null;
	}
	


	public static void main(String[] args) throws HttpException, IOException {
		String LOGIN_USER = "191657671@qq.com"; 
		String LOGIN_PWD = "what12345";
		Weixin wx = new Weixin(LOGIN_USER, LOGIN_PWD);
		wx.login();
		wx.getCookiestr();
		String url = "https://mp.weixin.qq.com/cgi-bin/appmsg?t=media/appmsg_edit&action=edit&lang=zh_CN&token=TOKEN&type=10&appmsgid=200704663&isMul=1";
		System.out.println("url1="+url);
		System.out.println("token1="+ wx.getToken());
		url = url.replaceAll("TOKEN", wx.getToken());
		System.out.println("url2="+url);
		wx.dataGenerate(url);
		wx.logout();
	}
}
