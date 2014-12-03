/**
* @FileName CommonAction.java
* @Package com.igrow.mall.web.action.core
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-20 上午8:53:53
* @Version V1.0.1
*/
package com.igrow.mall.web.action.core;

import java.io.InputStream;

import com.igrow.mall.bean.common.Pager;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @ClassName CommonAction
 * @Description TODO【CommonAction】
 * @Author Brights
 * @Date 2013-10-20 上午8:53:53
 */
public class CommonAction extends ActionSupport {
	private static final long serialVersionUID = -8919782947557939133L;
	
	protected static final String HEADER_ENCODING = "UTF-8";
	protected static final boolean HEADER_NO_CACHE = true;
	protected static final String HEADER_TEXT_CONTENT_TYPE = "text/plain";
	protected static final String HEADER_JSON_CONTENT_TYPE = "text/plain";
	
	protected static final String STATUS_PARAMETER_NAME = "status";// 操作状态参数名称
	protected static final String MESSAGE_PARAMETER_NAME = "info";// 操作消息参数名称
	protected static final String PASSWORD_WRONG_PARAMETER_NAME = "count";// 操作消息密码错误次数
	protected static final String VALUE_PARAMETER_NAME = "value";// 操作消息密码错误次数
	public static final String LOGIN_ADMIN_USER = "login_admin_user";//登陆管理员用户
	
	protected static final String INDEX = "index";
	protected static final String LIST = "list";
	protected static final String ADD = "add";
	protected static final String EDIT = "edit";
	protected static final String DELETE = "delete";
	protected static final String UPDATE = "update";
	protected static final String SAVE = "save";
	protected static final String DETAIL = "detail";
	protected static final String RELOAD = "reload";
	
	protected static final String ENABLE = "enable";
	protected static final String AUDIT = "audit";
	
	protected static final String MODIFY = "modify";
	protected static final String FINISH = "finish";
	protected static final String PUBLISH = "publish";
	protected static final String REFUND = "refund";
	protected static final String PROCESS = "process";
	protected static final String EXPORT = "export";
	protected static final String JSONPG = "jsonpg";
	protected static final String REDIRECT = "redirect";
	
	
	protected int statusCode = 200;
	protected String message = null;
	protected String redirectUrl;// 跳转URL
	
	protected Pager pager = new Pager();
	protected int[] pageSizes = {30,50,100};
	
	protected String id;
	protected String[] ids;
	protected String value;
	protected String[] values;
	protected String backurl;
	protected String keys;
	protected InputStream inputStream;
	protected String downloadFileName;
	
	protected String idx;
	protected String type;
	protected String typeId;
	protected String name; //名称
	protected String param; //参数
	protected String code; //操作码



	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	/**
	 * @return the pager
	 */
	public Pager getPager() {
		return pager;
	}
	/**
	 * @param pager the pager to set
	 */
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the ids
	 */
	public String[] getIds() {
		return ids;
	}
	/**
	 * @param ids the ids to set
	 */
	public void setIds(String[] ids) {
		this.ids = ids;
	}
	public int[] getPageSizes() {
		return pageSizes;
	}
	public String[] getValues() {
		return values;
	}
	public void setValues(String[] values) {
		this.values = values;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getRedirectUrl() {
		return redirectUrl;
	}
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public String getParam() {
		return param;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the downloadFileName
	 */
	public String getDownloadFileName() {
		return downloadFileName;
	}
	/**
	 * @param downloadFileName the downloadFileName to set
	 */
	public void setDownloadFileName(String downloadFileName) {
		this.downloadFileName = downloadFileName;
	}
	/**
	 * @return the inputStream
	 * @throws Exception 
	 */
	public InputStream getInputStream() throws Exception {
		return inputStream;
	}
	/**
	 * @param inputStream the inputStream to set
	 */
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}


}
