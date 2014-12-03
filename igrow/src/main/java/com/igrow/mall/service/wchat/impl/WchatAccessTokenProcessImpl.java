/**
* @FileName WchatAccessTokenProcessImpl.java
* @Package com.igrow.mall.service.wchat.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月28日 下午5:15:06
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.WchatOctConfInfo;
import com.igrow.mall.common.wchat.WchatCore;
import com.igrow.mall.service.admin.intf.WchatOctConfService;
import com.igrow.mall.service.wchat.intf.WchatAccessTokenProcess;

/**
 * @ClassName WchatAccessTokenProcessImpl
 * @Description TODO【获取AccessToken】
 * @Author brights
 * @Date 2014年10月28日 下午5:15:06
 */
@Service("wchatAccessTokenProcessImpl")
public class WchatAccessTokenProcessImpl implements WchatAccessTokenProcess {
	@Resource(name = "wchatOctConfServiceImpl")
	private WchatOctConfService wchatOctConfService;
	private static final String wchat_access_token_sn = "999999" ; //请勿修改

	/**
	* @Title getAccessToken
	* @Description 
	* @return
	* @see com.igrow.mall.service.wchat.intf.WchatAccessTokenProcess#getAccessToken()
	*/ 
	@Override
	public String getAccessToken() {
		WchatOctConfInfo  woc = wchatOctConfService.findBySn(wchat_access_token_sn);
		if(woc != null && StringUtils.isNotBlank(woc.getValue())){
			Date limitDate = DateUtils.addMinutes(woc.getModifyDate(), 100); //100分钟内有效
			if(limitDate.after(new Date())){  //
				System.out.println( woc.getValue());
				return woc.getValue();
			}
		}
		String token = WchatCore.getAccessToken();
		System.out.println(""+token);
		if(StringUtils.isBlank(token)){
			token = WchatCore.getAccessToken();
		}
		System.out.println(token);
		if(woc == null){
			woc = new WchatOctConfInfo();
			woc.setSn(wchat_access_token_sn);
			woc.setValue(token);
			woc.setParam("access_token");
			woc.setRemark("access_token");
			woc.setCreateDate(new Date());
			woc.setModifyDate(new Date());
			wchatOctConfService.insert(woc);
		}else{
			woc.setValue(token);
			//woc.setModifyDate(new Date());
			wchatOctConfService.update(woc);
		}
		return token;
	}

}
