/**
* @FileName WchatCardCodeProcessServiceImpl.java
* @Package com.igrow.mall.service.wchat.card.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午4:01:38
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.card.impl;

import java.io.IOException;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.stereotype.Service;

import com.igrow.mall.bean.card.request.WchatCardCodeConsumeReq;
import com.igrow.mall.bean.card.request.WchatCardCodeEncryptReq;
import com.igrow.mall.bean.card.request.WchatCardCodeGetReq;
import com.igrow.mall.bean.card.request.WchatCardCodeUnavailableReq;
import com.igrow.mall.bean.card.request.WchatCardCodeUpdateReq;
import com.igrow.mall.bean.card.response.WchatCardCodeConsumeRes;
import com.igrow.mall.bean.card.response.WchatCardCodeEncryptRes;
import com.igrow.mall.bean.card.response.WchatCardCodeGetRes;
import com.igrow.mall.bean.card.response.WchatCardCodeUnavailableRes;
import com.igrow.mall.bean.card.response.WchatCardCodeUpdateRes;
import com.igrow.mall.common.httpClient.HttpsRequestHandler;
import com.igrow.mall.common.wchat.WchatCore;
import com.igrow.mall.service.wchat.card.intf.WchatCardCodeProcessService;
import com.igrow.mall.service.wchat.intf.WchatAccessTokenProcess;

/**
 * @ClassName WchatCardCodeProcessServiceImpl
 * @Description TODO【微信卡券code处理服务接口】
 * @Author brights
 * @Date 2014年10月22日 下午4:01:38
 */
@Service("wchatCardCodeProcessServiceImpl")
public class WchatCardCodeProcessServiceImpl implements
		WchatCardCodeProcessService {
    private ObjectMapper objectMapper = new  ObjectMapper();  
	@Resource(name = "wchatAccessTokenProcessImpl")
	private WchatAccessTokenProcess wchatAccessTokenProcess;
	/**
	 * @Title consume
	 * @Description 
	 * @param req
	 * @return
	 * @see com.igrow.mall.service.wchat.card.intf.WchatCardCodeProcessService#consume(com.igrow.mall.bean.card.request.WchatCardCodeConsumeReq)
	 */
	@Override
	public WchatCardCodeConsumeRes consume(WchatCardCodeConsumeReq req) {
		try {
			//获取请求地址
			String requestUrl = WchatCore.getTokenReqUrl(req.req_url, wchatAccessTokenProcess.getAccessToken());
			//生成请求POST数据
			//序列化，忽略空值
			objectMapper.setSerializationInclusion(Inclusion.NON_NULL);  
			String requestData =objectMapper.writeValueAsString(req);
			System.out.println(requestData);
			//请求处理
			String responseData = HttpsRequestHandler.sendPost(requestUrl,requestData);
			System.out.println(responseData);
			WchatCardCodeConsumeRes res = objectMapper.readValue(responseData, WchatCardCodeConsumeRes.class);
			if(res != null){
				System.out.println("*********************************result***********************************************");
				System.out.println("errcode="+res.getErrcode());
				System.out.println("errmsg="+res.getErrmsg());
				System.out.println("*********************************result***********************************************");
				return res;
			}
		} catch (JsonGenerationException  e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @Title encrypt
	 * @Description 
	 * @param req
	 * @return
	 * @see com.igrow.mall.service.wchat.card.intf.WchatCardCodeProcessService#encrypt(com.igrow.mall.bean.card.request.WchatCardCodeEncryptReq)
	 */
	@Override
	public WchatCardCodeEncryptRes encrypt(WchatCardCodeEncryptReq req) {
		try {
			//获取请求地址
			String requestUrl = WchatCore.getTokenReqUrl(req.req_url, wchatAccessTokenProcess.getAccessToken());
			//生成请求POST数据
			//序列化，忽略空值
			objectMapper.setSerializationInclusion(Inclusion.NON_NULL);  
			String requestData =objectMapper.writeValueAsString(req);
			System.out.println(requestData);
			//请求处理
			String responseData = HttpsRequestHandler.sendPost(requestUrl,requestData);
			System.out.println(responseData);
			WchatCardCodeEncryptRes res = objectMapper.readValue(responseData, WchatCardCodeEncryptRes.class);
			if(res != null){
				System.out.println("*********************************result***********************************************");
				System.out.println("errcode="+res.getErrcode());
				System.out.println("errmsg="+res.getErrmsg());
				System.out.println("*********************************result***********************************************");
				return res;
			}
		} catch (JsonGenerationException  e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @Title get
	 * @Description 
	 * @param req
	 * @return
	 * @see com.igrow.mall.service.wchat.card.intf.WchatCardCodeProcessService#get(com.igrow.mall.bean.card.request.WchatCardCodeGetReq)
	 */
	@Override
	public WchatCardCodeGetRes get(WchatCardCodeGetReq req) {
		try {
			//获取请求地址
			String requestUrl = WchatCore.getTokenReqUrl(req.req_url, wchatAccessTokenProcess.getAccessToken());
			//生成请求POST数据
			//序列化，忽略空值
			objectMapper.setSerializationInclusion(Inclusion.NON_NULL);  
			String requestData =objectMapper.writeValueAsString(req);
			System.out.println(requestData);
			//请求处理
			String responseData = HttpsRequestHandler.sendPost(requestUrl,requestData);
			System.out.println(responseData);
			WchatCardCodeGetRes res = objectMapper.readValue(responseData, WchatCardCodeGetRes.class);
			if(res != null){
				System.out.println("*********************************result***********************************************");
				System.out.println("errcode="+res.getErrcode());
				System.out.println("errmsg="+res.getErrmsg());
				System.out.println("*********************************result***********************************************");
				return res;
			}
		} catch (JsonGenerationException  e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @Title unavailable
	 * @Description 
	 * @param req
	 * @return
	 * @see com.igrow.mall.service.wchat.card.intf.WchatCardCodeProcessService#unavailable(com.igrow.mall.bean.card.request.WchatCardCodeUnavailableReq)
	 */
	@Override
	public WchatCardCodeUnavailableRes unavailable(
			WchatCardCodeUnavailableReq req) {
		try {
			//获取请求地址
			String requestUrl = WchatCore.getTokenReqUrl(req.req_url, wchatAccessTokenProcess.getAccessToken());
			//生成请求POST数据
			//序列化，忽略空值
			objectMapper.setSerializationInclusion(Inclusion.NON_NULL);  
			String requestData =objectMapper.writeValueAsString(req);
			System.out.println(requestData);
			//请求处理
			String responseData = HttpsRequestHandler.sendPost(requestUrl,requestData);
			System.out.println(responseData);
			WchatCardCodeUnavailableRes res = objectMapper.readValue(responseData, WchatCardCodeUnavailableRes.class);
			if(res != null){
				System.out.println("*********************************result***********************************************");
				System.out.println("errcode="+res.getErrcode());
				System.out.println("errmsg="+res.getErrmsg());
				System.out.println("*********************************result***********************************************");
				return res;
			}
		} catch (JsonGenerationException  e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @Title update
	 * @Description 
	 * @param req
	 * @return
	 * @see com.igrow.mall.service.wchat.card.intf.WchatCardCodeProcessService#update(com.igrow.mall.bean.card.request.WchatCardCodeUpdateReq)
	 */
	@Override
	public WchatCardCodeUpdateRes update(WchatCardCodeUpdateReq req) {
		try {
			//获取请求地址
			String requestUrl = WchatCore.getTokenReqUrl(req.req_url, wchatAccessTokenProcess.getAccessToken());
			//生成请求POST数据
			//序列化，忽略空值
			objectMapper.setSerializationInclusion(Inclusion.NON_NULL);  
			String requestData =objectMapper.writeValueAsString(req);
			System.out.println(requestData);
			//请求处理
			String responseData = HttpsRequestHandler.sendPost(requestUrl,requestData);
			System.out.println(responseData);
			WchatCardCodeUpdateRes res = objectMapper.readValue(responseData, WchatCardCodeUpdateRes.class);
			if(res != null){
				System.out.println("*********************************result***********************************************");
				System.out.println("errcode="+res.getErrcode());
				System.out.println("errmsg="+res.getErrmsg());
				System.out.println("*********************************result***********************************************");
				return res;
			}
		} catch (JsonGenerationException  e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
