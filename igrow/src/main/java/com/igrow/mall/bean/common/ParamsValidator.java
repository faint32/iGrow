/**
* @FileName ParamsValidator.java
* @Package com.igrow.mall.bean.common
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-24 上午10:27:35
* @Version V1.0.1
*/
package com.igrow.mall.bean.common;

import org.apache.commons.lang.StringUtils;

import com.igrow.mall.common.constant.SystemConstants;
import com.igrow.mall.common.enums.IntfsReturn;
import com.igrow.mall.common.util.JsonValidatorUtil;

/**
 * @ClassName ParamsValidator
 * @Description TODO【请求参数验证】
 * @Author Brights
 * @Date 2013-10-24 上午10:27:35
 */
public class ParamsValidator {
	
	/**
	* @Title verify
	* @Description TODO【数据校验】
	* @param params
	* @return 
	* @Return IntfsReturn 返回类型
	* @Throws 
	*/ 
	public static IntfsReturn verify(String params,String actionMethod){
		if(StringUtils.isBlank(actionMethod)){
			return IntfsReturn.INTERFACE_NOT_EXIST;
		}
		//字符串是否为空
		if(StringUtils.isBlank(params)){
			return IntfsReturn.PARAM_BLANK;
		}
		/*//是否包含参数"para"
		if(!params.contains(SystemConstants.VERIFY_PARAMS)){
			return ResultCode.PARAM_WRONG;
		}*/
		//是否为json格式字符串
		JsonValidatorUtil json = new JsonValidatorUtil();
		if(!json.validate(params)){
			return IntfsReturn.PARAM_WRONG;
		}
		//进行安全校验
		if(params.contains(SystemConstants.VERIFY_AUTHS)){
			/*if(true){
				return ResultCode.AUTH_FAILURE;
			}*/
		}
		return IntfsReturn.SUCCESS;
	}

}
