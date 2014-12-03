/**
* @FileName XmlUtil.java
* @Package com.fwchat.util
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014年8月13日 下午4:39:23
* @Version V1.0.1
*/
package com.igrow.mall.common.wchat;

import java.io.Writer;
import java.util.HashMap;

import com.igrow.mall.common.enums.wchat.WmsgType;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * @ClassName XmlUtil
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Shiyz
 * @Date 2014年8月13日 下午4:39:23
 */
public class XmlUtil {
	
	public static String PREFIX_CDATA = "<![CDATA[";
	public static String SUFFIX_CDATA = "]]>";
	public static XStream xstream = null;
	
	public XmlUtil() {
			xstream = new XStream(new XppDriver() {
			public HierarchicalStreamWriter createWriter(Writer out) {
				return new PrettyPrintWriter(out) {
					protected void writeText(QuickWriter writer, String text) {
						if (text.startsWith(PREFIX_CDATA)
								&& text.endsWith(SUFFIX_CDATA)) {
							writer.write(text);
						} else {
							super.writeText(writer, text);
						}
					}
				};
			};
		});
	}
	
	/**
	* @Title beanToXml
	* @Description TODO【bean转XML】
	* @param object
	* @param objectClass
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String beanToXml(Object object) {
		//xstream.alias("xml", objectClass);
		xstream.processAnnotations(object.getClass()); //通过注解方式的，一定要有这句话
		xstream.autodetectAnnotations(true);
		return  xstream.toXML(object);
	}
	
	/**
	* @Title xmlToBean
	* @Description TODO【XML转 WchatRequestBean】
	* @param xml
	* @return 
	* @Return WchatRequestBean 返回类型
	* @Throws 
	*/ 
	public static WchatRequestBean xmlToBean(String xml) {
		///xstream.alias("xml", WchatRequestBean.class);
		xstream.autodetectAnnotations(true);
		WchatRequestBean weiChatGetDto = (WchatRequestBean) xstream.fromXML(xml);
		return weiChatGetDto;
	}
	
	 @SuppressWarnings("unchecked")
	public static <T> T  toBean(String xmlStr,Class<T> cls){
         //注意：不是new Xstream(); 否则报错：java.lang.NoClassDefFoundError: org/xmlpull/v1/XmlPullParserFactory
         XStream xstream=new XStream(new DomDriver());
         xstream.processAnnotations(cls);
         T obj=(T)xstream.fromXML(xmlStr);
         return obj;        
     } 
	 
	 public static String toXml(Object obj){
        // XStream xstream=new XStream();
		 XStream xstream = new XStream(new XppDriver() {
				public HierarchicalStreamWriter createWriter(Writer out) {
					return new PrettyPrintWriter(out) {
						protected void writeText(QuickWriter writer, String text) {
							if (text.startsWith(PREFIX_CDATA)
									&& text.endsWith(SUFFIX_CDATA)) {
								writer.write(text);
							} else {
								super.writeText(writer, text);
							}
						}
					};
				};
			});
		// XStream xstream=new XStream(new DomDriver()); //直接用jaxp dom来解释
//       XStream xstream=new XStream(new DomDriver("utf-8")); //指定编码解析器,直接用jaxp dom来解释
         ////如果没有这句，xml中的根元素会是<包.类名>；或者说：注解根本就没生效，所以的元素名就是类的属性
         xstream.processAnnotations(obj.getClass()); //通过注解方式的，一定要有这句话
         return xstream.toXML(obj);
     }
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		String xml ="<xml><ToUserName><![CDATA[gh_e0422302b692]]></ToUserName><FromUserName><![CDATA[o3yi8jmul5HfChjlOZaEY-rL6p4U]]></FromUserName><CreateTime>1407991011</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[1]]></Content><MsgId>6047275345507649110</MsgId></xml>";
		XStream xstream=new XStream();
		HashMap<String,String> hm =(HashMap<String, String>) xstream.fromXML(xml);
		System.out.println(hm.get("ToUserName"));
		System.out.println(hm.get("FromUserName"));
		System.out.println(hm.get(""));
		System.out.println(hm.get("MsgType"));
		System.out.println(hm.get("Content"));
		System.out.println(hm.get("MsgId"));
		WchatResponseBean wchatResponse = new WchatResponseBean();
		wchatResponse.setToUserName(XmlUtil.PREFIX_CDATA + "你好" + XmlUtil.SUFFIX_CDATA);
		wchatResponse.setFromUserName(XmlUtil.PREFIX_CDATA + "test" + XmlUtil.SUFFIX_CDATA);
		wchatResponse.setCreateTime(System.currentTimeMillis());
		wchatResponse.setMsgType(XmlUtil.PREFIX_CDATA + WmsgType.TEXT.getDesc()+ XmlUtil.SUFFIX_CDATA);
/*		wchatResponse.setContent(XmlUtil.PREFIX_CDATA 
												 + "欢迎关注! \n" 
												 +"点击<a href=\""+UrlConstant.server_url + UrlConstant.preorder_add_uri +"?id=12132132aaaaa\">【立即预定】</a>可快速预定\n"
												// + "\n请回复以下数字选择服务类型\n" 
												 //+ "【1】附近酒店\n【2】查询酒店\n【3】常住酒店\n【4】我的订单\n【5】我的积分\n【6】我的优惠券\n【7】热门活动\n【8】APP下载\n【?】"
												 + XmlUtil.SUFFIX_CDATA);*/
		//XmlUtil xu = new XmlUtil();
		System.out.println(toXml(wchatResponse));
	}
	
}
