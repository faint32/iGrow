/**
* @FileName WchatCardMovieticketProcessServiceImpl.java
* @Package com.igrow.mall.service.wchat.card.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午4:03:15
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

import com.igrow.mall.bean.card.request.WchatCardMovieticketUpdateuserReq;
import com.igrow.mall.bean.card.response.WchatCardMovieticketUpdateuserRes;
import com.igrow.mall.common.httpClient.HttpsRequestHandler;
import com.igrow.mall.common.wchat.WchatCore;
import com.igrow.mall.service.wchat.card.intf.WchatCardMovieticketProcessService;
import com.igrow.mall.service.wchat.intf.WchatAccessTokenProcess;

/**
 * @ClassName WchatCardMovieticketProcessServiceImpl
 * @Description TODO【微信卡券-电影票处理服务接口】
 * @Author brights
 * @Date 2014年10月22日 下午4:03:15
 */
@Service("wchatCardMovieticketProcessServiceImpl")
public class WchatCardMovieticketProcessServiceImpl implements
		WchatCardMovieticketProcessService {
	 private ObjectMapper objectMapper = new  ObjectMapper();  
		@Resource(name = "wchatAccessTokenProcessImpl")
		private WchatAccessTokenProcess wchatAccessTokenProcess;
	/**
	 * @Title updateuser
	 * @Description 
	 * @param req
	 * @return
	 * @see com.igrow.mall.service.wchat.card.intf.WchatCardMovieticketProcessService#updateuser(com.igrow.mall.bean.card.request.WchatCardMovieticketUpdateuserReq)
	 */
	@Override
	public WchatCardMovieticketUpdateuserRes updateuser(
			WchatCardMovieticketUpdateuserReq req) {
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
			WchatCardMovieticketUpdateuserRes res = objectMapper.readValue(responseData, WchatCardMovieticketUpdateuserRes.class);
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
