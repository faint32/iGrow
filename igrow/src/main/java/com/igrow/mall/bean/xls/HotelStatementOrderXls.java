/**
* @FileName HotelStatementOrderXls.java
* @Package com.igrow.mall.bean.xls
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年9月10日 下午4:58:57
* @Version V1.0.1
*/
package com.igrow.mall.bean.xls;

/**
 * @ClassName HotelStatementOrderXls
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author brights
 * @Date 2014年9月10日 下午4:58:57
 */
public class HotelStatementOrderXls implements Exportable {
	
	 //订单编号
	 private String orderSn;
	 //商品名称
	 private String productName;
	 
	 //订单金额
	 private String orderAmount;
	 
	 //佣金率
	 private String commRate;
	 
	 //佣金额
	 private String commAmount;
	 
	 //商品数
	 private String quantity;

	 //状态
	 private String status;
	 //下单时间
	 private String createDate;
	 
	 //单价
	 private String productPrice;
	
	 //单价
	 private String productType;
	
	
	
	 //表标题
	 private String[] columnNames = 
			 new String[]{"订单编号","商品名称","类型","订单金额","酒店佣金率","酒店佣金额","商品数","状态","下单时间"};
	 //表内容
	 private String[] columnMethods = 
			 new String[]{"getOrderSn","getProductName","getProductType","getOrderAmount","getCommRate","getCommAmount","getQuantity","getStatus","getCreateDate"};

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
	 * @return the commRate
	 */
	public String getCommRate() {
		return commRate;
	}

	/**
	 * @param commRate the commRate to set
	 */
	public void setCommRate(String commRate) {
		this.commRate = commRate;
	}

	/**
	 * @return the commAmount
	 */
	public String getCommAmount() {
		return commAmount;
	}

	/**
	 * @param commAmount the commAmount to set
	 */
	public void setCommAmount(String commAmount) {
		this.commAmount = commAmount;
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
	 * @return the productType
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * @param productType the productType to set
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}

}
