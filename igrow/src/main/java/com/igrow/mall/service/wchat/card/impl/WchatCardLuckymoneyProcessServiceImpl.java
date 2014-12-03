/**
* @FileName WchatCardLuckymoneyProcessServiceImpl.java
* @Package com.igrow.mall.service.wchat.card.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午4:02:29
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

import com.igrow.mall.bean.card.request.WchatCardLuckymoneyUpdateuserbalanceReq;
import com.igrow.mall.bean.card.response.WchatCardLuckymoneyUpdateuserbalanceRes;
import com.igrow.mall.common.httpClient.HttpsRequestHandler;
import com.igrow.mall.common.wchat.WchatCore;
import com.igrow.mall.service.wchat.card.intf.WchatCardLuckymoneyProcessService;
import com.igrow.mall.service.wchat.intf.WchatAccessTokenProcess;

/**
 * @ClassName WchatCardLuckymoneyProcessServiceImpl
 * @Description TODO【微信卡券红包处理服务接口】
 * @Author brights
 * @Date 2014年10月22日 下午4:02:29
 */
@Service("wchatCardLuckymoneyProcessServiceImpl")
public class WchatCardLuckymoneyProcessServiceImpl implements
		WchatCardLuckymoneyProcessService {
    private ObjectMapper objectMapper = new  ObjectMapper(); 
	@Resource(name = "wchatAccessTokenProcessImpl")
	private WchatAccessTokenProcess wchatAccessTokenProcess;

	/**
	 * @Title updateuserbalance
	 * @Description 
	 * @param req
	 * @return
	 * @see com.igrow.mall.service.wchat.card.intf.WchatCardLuckymoneyProcessService#updateuserbalance(com.igrow.mall.bean.card.request.WchatCardLuckymoneyUpdateuserbalanceReq)
	 */
	@Override
	public WchatCardLuckymoneyUpdateuserbalanceRes updateuserbalance(
			WchatCardLuckymoneyUpdateuserbalanceReq req) {
		try {
			//获取请求地址
			String requestUrl = WchatCore.getTokenReqUrl(req.req_url,wchatAccessTokenProcess.getAccessToken());
			//生成请求POST数据
			//序列化，忽略空值
			objectMapper.setSerializationInclusion(Inclusion.NON_NULL);  
			String requestData =objectMapper.writeValueAsString(req);
			System.out.println(requestData);
			//请求处理
			String responseData = HttpsRequestHandler.sendPost(requestUrl,requestData);
			System.out.println(responseData);
			WchatCardLuckymoneyUpdateuserbalanceRes res = objectMapper.readValue(responseData, WchatCardLuckymoneyUpdateuserbalanceRes.class);
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
