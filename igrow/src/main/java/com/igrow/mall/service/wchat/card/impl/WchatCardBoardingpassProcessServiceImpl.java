/**
* @FileName WchatCardBoardingpassProcessServiceImpl.java
* @Package com.igrow.mall.service.wchat.card.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午4:01:10
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

import com.igrow.mall.bean.card.request.WchatCardBoardingpassCheckinReq;
import com.igrow.mall.bean.card.response.WchatCardBoardingpassCheckinRes;
import com.igrow.mall.common.httpClient.HttpsRequestHandler;
import com.igrow.mall.common.wchat.WchatCore;
import com.igrow.mall.service.wchat.card.intf.WchatCardBoardingpassProcessService;
import com.igrow.mall.service.wchat.intf.WchatAccessTokenProcess;

/**
 * @ClassName WchatCardBoardingpassProcessServiceImpl
 * @Description TODO【微信卡券-飞机票】
 * @Author brights
 * @Date 2014年10月22日 下午4:01:10
 */
@Service("wchatCardBoardingpassProcessServiceImpl")
public class WchatCardBoardingpassProcessServiceImpl implements
		WchatCardBoardingpassProcessService {
    private ObjectMapper objectMapper = new  ObjectMapper();  
	@Resource(name = "wchatAccessTokenProcessImpl")
	private WchatAccessTokenProcess wchatAccessTokenProcess;
	/**
	 * @Title checkin
	 * @Description 
	 * @param req
	 * @return
	 * @see com.igrow.mall.service.wchat.card.intf.WchatCardBoardingpassProcessService#checkin(com.igrow.mall.bean.card.request.WchatCardBoardingpassCheckinReq)
	 */
	@Override
	public WchatCardBoardingpassCheckinRes checkin(
			WchatCardBoardingpassCheckinReq req) {
		try {
			//获取请求地址
			String accessToken = wchatAccessTokenProcess.getAccessToken();
			String requestUrl = WchatCore.getTokenReqUrl(req.req_url,accessToken);
			//生成请求POST数据
			//序列化，忽略空值
			objectMapper.setSerializationInclusion(Inclusion.NON_NULL);  
			String requestData =objectMapper.writeValueAsString(req);
			System.out.println(requestData);
			//请求处理
			String responseData = HttpsRequestHandler.sendPost(requestUrl,requestData);
			System.out.println(responseData);
			WchatCardBoardingpassCheckinRes res = objectMapper.readValue(responseData, WchatCardBoardingpassCheckinRes.class);
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
