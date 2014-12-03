/**
* @FileName AuthConstant.java
* @Package com.igrow.mall.common.constant
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-14 上午10:06:50
* @Version V1.0.1
*/
package com.igrow.mall.common.constant;

/**
 * @ClassName AuthConstant
 * @Description TODO【权限注解编码定义】
 * @Author Brights
 * @Date 2013-11-14 上午10:06:50
 */
public class AuthConstant {
	/**
	* @Fields ORDER_LIST_AUTH TODO【订单权限注解】
	*/
	public static final String ORDER_AUTH = "01";
	//订单列表
	public static final String ORDER_LIST_AUTH = "0101";
	/**
	* @Fields ORDER_LIST_AUTH TODO【用户权限注解编码】
	*/
	public static final String MEMBER_AUTH = "02";
	//会员列表
	public static final String MEMBER_LIST_AUTH = "0201";
	/**
	* @Fields ORDER_LIST_AUTH TODO【商品权限注解编码】
	*/
	public static final String PRODUCTSHELVES_AUTH = "03";	
	//商品列表
	public static final String PRODUCTSHELVES_LIST_AUTH = "0301";
	
	/**
	* @Fields ORDER_LIST_AUTH TODO【财务注解编码】
	*/
	public static final String FINANCE_AUTH = "04";	
	/**
	* @Fields ORDER_LIST_AUTH TODO【系统注解编码】
	*/
	public static final String SYSTEM_AUTH = "05";	
	//酒店列表
	public static final String HOTLE_LIST_AUTH = "0501";
	//酒店添加
	public static final String HOTLE_ADD_AUTH = "050101";
	//酒店编辑
	public static final String HOTLE_EDIT_AUTH = "050102";
	//酒店添加保存
	public static final String HOTLE_SAVE_AUTH = "050103";
	//酒店编辑更新
	public static final String HOTLE_UPDATE_AUTH = "050104";
	//酒店删除
	public static final String HOTLE_DELETE_AUTH = "050104";
	//商品库列表
	public static final String PRODUCT_LIST_AUTH = "0503";
	//活动列表
	public static final String ACTIVE_LIST_AUTH = "0504";
	//管理员列表
	public static final String ADMINUSER_LIST_AUTH = "0505";
	//扫描管理列表
    public static final String SCAN_LIST_AUTH = "0507";
	//供应商添加酒店列表
	public static final String SUPPLIER_HOTLE_LIST_AUTH = "0701";
	//管理员商品待审核列表
	public static final String ADMIN_PRODUCT_LIST_AUTH = "0801";
	
}
