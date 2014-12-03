package com.igrow.mall.common.constant;


/**
 * @ClassName WchatConstant
 * @Description TODO【微信常量定义】
 * @Author brights
 * @Date 2014年8月14日 下午3:05:47
 */
public class WchatConstant {
	
	//测试环境地址
	public final static  String wchat_login_user = "191657671@qq.com";
	public final static  String wchat_login_password = "what12345";
	public final static  String wchat_id = "gh_a706b2ebc29a";
	public final static  String wchat_appid_server_url = "http://115.29.232.103:8080/borMall/common/wchat.do";
	public final static  String wchat_appid_server_Token = "abcdefghijklmnopqrstuvwxyz";
	public final static  String wchat_appid = "wx8a865f88c23ec791";
	public final static  String wchat_appsecret = "daf3f91530d8b66b92f6243aee9643de"; 
	
	public static String PREFIX_QRSCENE= "qrscene_";
	public static String H5_PRODUCT_IMAGE_URL = "http://115.29.232.103:9000/";
	public static String H5_PRODUCT_LIST_URL = "http://115.29.232.103:8080/boraMallH5T/views/front/product/plist.html?hid=";
	public static String H5_PRODUCT_URL = "http://115.29.232.103:8080/boraMallH5T/views/front/product/product.html?pid=";
	public static String wchat_get_qrcode_url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";
	
	//关注欢迎语
	public static String  subscribe_replay_words = "即刻起，跟一克拉一起玩创意。\n"
																				+"让创意改变你的生活。-->每周一扒";
	
	//微信服务器配置
	public final static  String wchat_server_https_url = "https://api.weixin.qq.com/cgi-bin"; //微信公众平台API服务器
	public final static  String wchat_server_http_url = "http://api.weixin.qq.com/cgi-bin"; //微信公众平台API服务器
	public final static  String wchat_server_file_http_url = "http://file.api.weixin.qq.com/cgi-bin"; //微信公众平台文件-API服务器
	
	public final static  String wchat_token_uri = "/token";  //获取token-uri
	public final static  String wchat_token_request_type = "GET";  //请求方式
	public final static  String wchat_token_request_params_key = "wchat_token_request_params_key";  //获取token请求参数模板key
	public final static  String wchat_token_request_params_template = "grant_type=client_credential&appid=${appid}&secret=${secret}";  //获取token请求参数模板
	
	public final static  String wchat_media_upload_uri = "/media/upload";  //上传多媒体url
	public final static  String wchat_media_upload_request_type = "POST";  //请求方式
	public final static  String wchat_media_upload_request_params_key = "wchat_media_upload_request_params_key";  //上传多媒体请求参数模板key
	public final static  String wchat_media_upload_request_params_template = "access_token=${accesstoken}&type=${type}";  //上传多媒体请求参数模板
	
	public final static  String wchat_media_dowload_uri = "/media/get";  //下载多媒体url
	public final static  String wchat_media_dowload_type = "GET";  //请求方式
	public final static  String wchat_media_dowload_request_params_key = "wchat_media_dowload_request_params_key";  //下载多媒体请求参数模板key
	public final static  String wchat_media_dowload_request_params_template = "access_token=${accesstoken}&media_id=${mediaid}";  //下载多媒体请求参数模板
	
	public final static  String wchat_menu_create_uri = "/menu/create"; //创建菜单
	public final static  String wchat_menu_create_request_type = "POST";  //请求方式
	public final static  String wchat_menu_create_request_params_key = "wchat_menu_create_request_params_key";  //创建菜单请求参数模板key
	public final static  String wchat_menu_create_request_params_template = "access_token=${accesstoken}";  //创建菜单请求参数模板
	
	public final static  String wchat_menu_query_uri = "/menu/get"; //查询菜单
	public final static  String wchat_menu_query_request_type = "GET";  //请求方式
	public final static  String wchat_menu_query_request_params_key = "wchat_menu_query_request_params_key";  //查询创建菜单请求参数模板key
	public final static  String wchat_menu_query_request_params_template = "access_token=${accesstoken}";  //查询创建菜单请求参数模板
	
	public final static  String wchat_menu_delete_uri = "/menu/delete"; //删除菜单
	public final static  String wchat_menu_delete_request_type = "GET";  //请求方式
	public final static  String wchat_menu_delete_request_params_key = "wchat_menu_delete_request_params_key";  //删除菜单请求参数模板key
	public final static  String wchat_menu_delete_request_params_template = "access_token=${accesstoken}";  //删除菜单请求参数模板
	
	public final static  String wchat_qrcode_create_uri = "/qrcode/create"; //创建二微码
	public final static  String wchat_qrcode_create_request_type = "POST";  //请求方式
	public final static  String wchat_qrcode_create_request_params_key = "wchat_qrcode_create_request_params_key";  //创建二微码请求参数模板key
	public final static  String wchat_qrcode_create_request_params_template = "access_token=${accesstoken}";  //创建二微码请求参数模板
	
	
    //用户同意授权，获取code
	//Scope为snsapi_base
	public final static  String wchat_connect_oauth2_url = "https://open.weixin.qq.com/connect/oauth2/authorize"; //二维码授权url
	//Scope为snsapi_base  不弹出授权页面，直接跳转，只能获取用户openid
	public final static  String wchat_connect_oauth2_url_request_params__snsapi_base_key = "wchat_connect_oauth2_url_request_params__snsapi_base_key";  //创建二微码请求参数模板
	public final static  String wchat_connect_oauth2_url_request_params__snsapi_base_template = "appid=${appid}&redirect_uri=${redirectUri}&response_type=code&scope=snsapi_base&state=${state}#wechat_redirect";  //创建二微码请求参数模板
	//Scope为snsapi_userinfo   弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息
	public final static  String wchat_connect_oauth2_url_request_params__snsapi_userinfo_key = "wchat_connect_oauth2_url_request_params__snsapi_userinfo_key";  //创建二微码请求参数模板
	public final static  String wchat_connect_oauth2_url_request_params__snsapi_userinfo_template = "appid=${appid}&redirect_uri=${redirectUri}&response_type=code&scope=snsapi_userinfo&state=${state}#wechat_redirect";  //创建二微码请求参数模板
	
	//通过code换取网页授权access_token
	public final static  String wchat_sns_oauth2_token_url  = "https://api.weixin.qq.com/sns/oauth2/access_token";
	public final static  String wchat_sns_oauth2_token_request_params_key  = "wchat_sns_oauth2_token_request_params_key";
	public final static  String wchat_sns_oauth2_token_request_params_template  = "appid=${appid}&secret=${secret}&code=${code}&grant_type=authorization_code";
	
	
	public final static  String wchat_custom_message_send_uri = "/message/custom/send"; //客服发送消息
	  //https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN
	public final static  String wchat_custom_message_send_request_type = "POST";  //请求方式
	public final static  String wchat_custom_message_send_request_params_key = "wchat_custom_message_send_request_params_key";  //客服发送消息请求参数模板key
	public final static  String wchat_custom_message_send_params_template = "access_token=${accesstoken}";  //客服发送消息请求参数模板
	
	public final static  String wchat_custom_service_getonlinekflist_uri = "/customservice/getonlinekflist"; //多客服在线列表
	  //https://api.weixin.qq.com/cgi-bin/customservice/getonlinekflist?access_token=%20ACCESS_TOKEN
	public final static  String wchat_custom_service_getonlinekflist_request_type = "POST";  //请求方式
	public final static  String wchat_custom_service_getonlinekflist_request_params_key = "wchat_custom_service_getonlinekflist_request_params_key";  //客服发送消息请求参数模板key
	public final static  String wchat_custom_service_getonlinekflist_params_template = "access_token=${accesstoken}";  //客服发送消息请求参数模板
	
	
	public final static  String wchat_message_template_send_uri  = "/message/template/send"; //消息模版发送
	public final static  String wchat_message_template_send_request_type = "POST";  //请求方式
	public final static  String wchat_message_template_send_request_params_key = "wchat_message_template_send_request_params_key";  //创建菜单请求参数模板key
	public final static  String wchat_message_template_send_request_params_template  = "access_token=${accesstoken}";  //创建菜单请求参数模板
	
	
	
	
	
	
	
	

}
