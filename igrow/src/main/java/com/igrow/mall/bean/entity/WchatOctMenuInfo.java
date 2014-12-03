/**
* @FileName WchatOctMenuInfo.java
* @Package com.igrow.mall.bean.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月13日 下午12:01:24
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.igrow.mall.common.enums.Bool;
import com.igrow.mall.common.enums.wchat.Wevent;

/**
 * @ClassName WchatOctMenuInfo
 * @Description TODO【1克拉微信公众平台菜单】
 * @Author brights
 * @Date 2014年10月13日 下午12:01:24
 */
@Alias("TwchatOctMenuInfo")
public class WchatOctMenuInfo extends BaseEntity {
	private static final long serialVersionUID = -4597797169912022377L;
	
	private String name; //菜单名称
	private Wevent event;	 //事件 //目前支持：5-click  6-view
	private String key	; //事件KEY值
	private String srcUrl;	    //素材url
	private String srcData;	 //素材数据
	private String parentId;
	private Bool isDelete;//是否删除
	private Integer sort;//排序，值越大，越排前
	private List<WchatOctMenuInfo> subMenus; //子菜单

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the event
	 */
	public Wevent getEvent() {
		return event;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(Wevent event) {
		this.event = event;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the srcUrl
	 */
	public String getSrcUrl() {
		return srcUrl;
	}

	/**
	 * @param srcUrl the srcUrl to set
	 */
	public void setSrcUrl(String srcUrl) {
		this.srcUrl = srcUrl;
	}

	/**
	 * @return the srcData
	 */
	public String getSrcData() {
		return srcData;
	}

	/**
	 * @param srcData the srcData to set
	 */
	public void setSrcData(String srcData) {
		this.srcData = srcData;
	}


	/**
	 * @return the subMenus
	 */
	public List<WchatOctMenuInfo> getSubMenus() {
		return subMenus;
	}

	/**
	 * @param subMenus the subMenus to set
	 */
	public void setSubMenus(List<WchatOctMenuInfo> subMenus) {
		this.subMenus = subMenus;
	}

	/**
	 * @return the parent_id
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * @param parent_id the parent_id to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the sort
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * @return the isDelete
	 */
	public Bool getIsDelete() {
		return isDelete;
	}

	/**
	 * @param isDelete the isDelete to set
	 */
	public void setIsDelete(Bool isDelete) {
		this.isDelete = isDelete;
	}


}
