/**
* @FileName WchatCardLocationProcessServiceImpl.java
* @Package com.igrow.mall.service.wchat.card.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午4:02:05
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

import com.igrow.mall.bean.card.request.WchatCardLocationBatchaddReq;
import com.igrow.mall.bean.card.request.WchatCardLocationBatchgetReq;
import com.igrow.mall.bean.card.response.WchatCardLocationBatchaddRes;
import com.igrow.mall.bean.card.response.WchatCardLocationBatchgetRes;
import com.igrow.mall.bean.card.response.Location.Location;
import com.igrow.mall.common.httpClient.HttpsRequestHandler;
import com.igrow.mall.common.wchat.WchatCore;
import com.igrow.mall.service.wchat.card.intf.WchatCardLocationProcessService;
import com.igrow.mall.service.wchat.intf.WchatAccessTokenProcess;

/**
 * @ClassName WchatCardLocationProcessServiceImpl
 * @Description TODO【微信卡券门店处理服务接口】
 * @Author brights
 * @Date 2014年10月22日 下午4:02:05
 */
@Service("wchatCardLocationProcessServiceImpl")
public class WchatCardLocationProcessServiceImpl implements
		WchatCardLocationProcessService {
	
    private ObjectMapper objectMapper = new  ObjectMapper();  
	@Resource(name = "wchatAccessTokenProcessImpl")
	private WchatAccessTokenProcess wchatAccessTokenProcess;

	/**
	 * @Title batchadd
	 * @Description 
	 * @param req
	 * @return
	 * @see com.igrow.mall.service.wchat.card.intf.WchatCardLocationProcessService#batchadd(com.igrow.mall.bean.card.request.WchatCardLocationBatchaddReq)
	 */
	@Override
	public WchatCardLocationBatchaddRes batchadd(
			WchatCardLocationBatchaddReq req) {
		try {
			//获取请求地址
			String requestUrl = WchatCore.getTokenReqUrl(req.req_url, wchatAccessTokenProcess.getAccessToken());
			//序列化，忽略空值
			objectMapper.setSerializationInclusion(Inclusion.NON_NULL);  
			String requestData =objectMapper.writeValueAsString(req);
			System.out.println(requestData);
			//请求处理
			String responseData = HttpsRequestHandler.sendPost(requestUrl,requestData);
			System.out.println(responseData);
			WchatCardLocationBatchaddRes res = objectMapper.readValue(responseData, WchatCardLocationBatchaddRes.class);
			if(res != null){
				System.out.println("*********************************result***********************************************");
				System.out.println("errcode="+res.getErrcode());
				System.out.println("errmsg="+res.getErrmsg());
				if(res.getLocationIdList() != null){
					System.out.println("len="+res.getLocationIdList().length);
				}else{
					System.out.println("len="+0);
				}
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
	 * @Title batchget
	 * @Description 
	 * @param req
	 * @return
	 * @see com.igrow.mall.service.wchat.card.intf.WchatCardLocationProcessService#batchget(com.igrow.mall.bean.card.request.WchatCardLocationBatchgetReq)
	 */
	@Override
	public WchatCardLocationBatchgetRes batchget(
			WchatCardLocationBatchgetReq req) {
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
			WchatCardLocationBatchgetRes res = objectMapper.readValue(responseData, WchatCardLocationBatchgetRes.class);
			if(res != null){
				System.out.println("*********************************result***********************************************");
				System.out.println("errcode="+res.getErrcode());
				System.out.println("errmsg="+res.getErrmsg());
				if(res.getCount()!= null){
					System.out.println("count="+res.getCount());
				}
				if(res.getLocationList()!= null ){
					System.out.println("locationList.size="+res.getLocationList().size());
					for(Location location : res.getLocationList()){
						System.out.println("location.name="+location.getName());
					}
				}else{
					System.out.println("locationList.size="+0);
				}
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
