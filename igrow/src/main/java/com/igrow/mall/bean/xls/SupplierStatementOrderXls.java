/**
* @FileName SupplierStatementOrderXls.java
* @Package com.igrow.mall.bean.xls
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年9月10日 下午5:08:56
* @Version V1.0.1
*/
package com.igrow.mall.bean.xls;

/**
 * @ClassName SupplierStatementOrderXls
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author brights
 * @Date 2014年9月10日 下午5:08:56
 */
public class SupplierStatementOrderXls implements Exportable {

	
	 //订单编号
	 private String orderSn;
	 //商品名称
	 private String productName;
	 
	 //订单金额
	 private String orderAmount;
	 
	 //单价
	 private String productPrice;
	 
	 //系统佣金率
	 private String sysCommRate;
	 
	 //酒店佣金率
	 private String hotelCommRate;
	 
	 //商品数
	 private String quantity;

	 //状态
	 private String status;
	 
	 //下单时间
	 private String createDate;
	
	
	
	
	 //表标题
	 private String[] columnNames = 
			 new String[]{"订单编号","商品名称","订单金额","单价","系统佣金率","酒店佣金率","商品数","状态","下单时间"};
	 //表内容
	 private String[] columnMethods = 
			 new String[]{"getOrderSn","getProductName","getOrderAmount","getProductPrice","getSysCommRate","getHotelCommRate","getQuantity","getStatus","getCreateDate"};

	/**
	 * @Title getColumnNames
	 * @Description 
	 * @return
	 * @see com.igrow.mall.bean.xls.Exportable#getColumnNames()
	 */
	@Override
	public String[] getColumnNames() {
		return columnNames;
	}

	/**
	 * @Title getColumnMethods
	 * @Description 
	 * @return
	 * @see com.igrow.mall.bean.xls.Exportable#getColumnMethods()
	 */
	@Override
	public String[] getColumnMethods() {
		return columnMethods;
	}

	/**
	 * @return the orderSn
	 */
	public String getOrderSn() {
		return orderSn;
	}

	/**
	 * @param orderSn the orderSn to set
	 */
	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the orderAmount
	 */
	public String getOrderAmount() {
		return orderAmount;
	}

	/**
	 * @param orderAmount the orderAmount to set
	 */
	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	/**
	 * @return the productPrice
	 */
	public String getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * @return the sysCommRate
	 */
	public String getSysCommRate() {
		return sysCommRate;
	}

	/**
	 * @param sysCommRate the sysCommRate to set
	 */
	public void setSysCommRate(String sysCommRate) {
		this.sysCommRate = sysCommRate;
	}

	/**
	 * @return the hotelCommRate
	 */
	public String getHotelCommRate() {
		return hotelCommRate;
	}

	/**
	 * @param hotelCommRate the hotelCommRate to set
	 */
	public void setHotelCommRate(String hotelCommRate) {
		this.hotelCommRate = hotelCommRate;
	}

	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the createDate
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * @param columnNames the columnNames to set
	 */
	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	/**
	 * @param columnMethods the columnMethods to set
	 */
	public void setColumnMethods(String[] columnMethods) {
		this.columnMethods = columnMethods;
	}

}
