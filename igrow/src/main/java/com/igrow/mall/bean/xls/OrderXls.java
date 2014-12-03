/**
* @FileName OrderXls.java
* @Package com.igrow.mall.bean.xls
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014-4-4 下午2:52:09
* @Version V1.0.1
*/
package com.igrow.mall.bean.xls;

/**
 * @ClassName OrderXls
 * @Description TODO【订单导出xls】
 * @Author Brights
 * @Date 2014-4-4 下午2:52:09
 */
public class OrderXls implements Exportable{
	 //订单编号
	 private String orderSn;
	 //订单类型
	 private String productTypes;
	 //状态
	 private String status;
	 //下单时间
	 private String createDate;
	 //支付时间
	 private String payDate;
	 //会员账号
	 private String member;
	 //商品编号
	 private String productSn;
	 //商品名称
	 private String productName;
	 //规格
	 private String specification;
	 //酒店
	 private String hotelName;
	 //价格
	 private String price;
	 //订单总金额
	 private String toatlAmount;
	 //收货方式
	 private String shipInfo;
	 //发票信息
	 private String invoiceInfo;
	 
	 
	 //表标题
	 private String[] columnNames = 
			 new String[]{"订单编号","类别","状态","下单时间","付款时间","会员账号","商品编号","商品名称","规格","酒店","价格",
			 "订单总金额","收货方式","发票信息"};
	 //表内容
	 private String[] columnMethods = 
			 new String[]{"getOrderSn","getProductTypes","getStatus","getCreateDate","getPayDate","getMember","getProductSn","getProductName","getSpecification","getHotelName","getPrice",
			 "getToatlAmount","getShipInfo","getInvoiceInfo"};
	/**
	 * @return the orderSn
	 */
	public String getOrderSn() {
		return orderSn;
	}
	/**
	 * @return the productTypes
	 */
	public String getProductTypes() {
		return productTypes;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @return the createDate
	 */
	public String getCreateDate() {
		return createDate;
	}
	/**
	 * @return the payDate
	 */
	public String getPayDate() {
		return payDate;
	}
	/**
	 * @return the member
	 */
	public String getMember() {
		return member;
	}
	/**
	 * @return the productSn
	 */
	public String getProductSn() {
		return productSn;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @return the specification
	 */
	public String getSpecification() {
		return specification;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @return the toatlAmount
	 */
	public String getToatlAmount() {
		return toatlAmount;
	}
	/**
	 * @return the shipInfo
	 */
	public String getShipInfo() {
		return shipInfo;
	}
	/**
	 * @return the invoiceInfo
	 */
	public String getInvoiceInfo() {
		return invoiceInfo;
	}
	/**
	 * @return the columnNames
	 */
	public String[] getColumnNames() {
		return columnNames;
	}
	/**
	 * @return the columnMethods
	 */
	public String[] getColumnMethods() {
		return columnMethods;
	}
	/**
	 * @param orderSn the orderSn to set
	 */
	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}
	/**
	 * @param productTypes the productTypes to set
	 */
	public void setProductTypes(String productTypes) {
		this.productTypes = productTypes;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	/**
	 * @param payDate the payDate to set
	 */
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	/**
	 * @param member the member to set
	 */
	public void setMember(String member) {
		this.member = member;
	}
	/**
	 * @param productSn the productSn to set
	 */
	public void setProductSn(String productSn) {
		this.productSn = productSn;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the hotelName
	 */
	public String getHotelName() {
		return hotelName;
	}
	/**
	 * @param hotelName the hotelName to set
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	/**
	 * @param specification the specification to set
	 */
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @param toatlAmount the toatlAmount to set
	 */
	public void setToatlAmount(String toatlAmount) {
		this.toatlAmount = toatlAmount;
	}
	/**
	 * @param shipInfo the shipInfo to set
	 */
	public void setShipInfo(String shipInfo) {
		this.shipInfo = shipInfo;
	}
	/**
	 * @param invoiceInfo the invoiceInfo to set
	 */
	public void setInvoiceInfo(String invoiceInfo) {
		this.invoiceInfo = invoiceInfo;
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
