/**
* @FileName ProductVo.java
* @Package com.igrow.mall.bean.vo
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-12-1 上午10:37:28
* @Version V1.0.1
*/
package com.igrow.mall.bean.vo;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName ProductVo
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Brights
 * @Date 2013-12-1 上午10:37:28
 */
public class ProductVo implements Serializable{
	private static final long serialVersionUID = 873817017638114425L;
	@XStreamAlias("pid")
	private String productSn;//货品编号
	@XStreamAlias("pname")
	private String productName;//商品名称
	@XStreamAlias("hname")
	private String hotelName;//酒店名称
	@XStreamAlias("hid")
	private String hid;//酒店id
	@XStreamAlias("hadds")
	private String hotelAddress;//酒店地址
	@XStreamAlias("imgs")
	//@XStreamConverter(MyMapConverter.class)
	private List<Object> images ;//图片
	@XStreamAlias("price")
	//@XStreamConverter(MyMapConverter.class)
	private List<Object> prices;//价格
	@XStreamAlias("ship")
	private String  ship;//发货方式
	@XStreamAlias("specification")
	private ProductSpecVo productSpec;//商品规格
	@XStreamAlias("property")
	private ProductPropVo productProp;//商品属性
	@XStreamAlias("qrcodeurl")
	private String shareUrl;//分享二维码图片
	@XStreamAlias("inventory")
	private List<Object> productStock ;//商品库存
	@XStreamAlias("details")
	private String content; //详情
	@XStreamAlias("phone")
	private String hotelPhone; //酒店联系电话
	@XStreamAlias("collection")
	private int isCollection; //0-未	收藏，1-已收藏
	@XStreamAlias("detail")
	private String detail;//详细介绍
	@XStreamAlias("source")
	private String fromBy;
	@XStreamAlias("img")
	private String defaultImage;
	@XStreamAlias("pullon")
	private int pullOn; //0-下架，1-上架
	@XStreamAlias("paytype")
	private int payType; //0-线上支付，1-线下支付，2线上和线下
	@XStreamAlias("stock")
	private int stock;//库存
	@XStreamAlias("shelf")
	private String  shelf; //柜子编号
	@XStreamAlias("grid")
	private String  grid; //格子号
	@XStreamAlias("sales")
	private long productSalesCount; //商品销售数量
	@XStreamAlias("share")
	private long productShareCount;//商品分享数
/*	@XStreamAlias("experafter")
	private String experienceAfter;//体验后
*/	
	@XStreamAlias("isexp")
	private int isExperience;//体验后  0 -未体验  1-体验
	@XStreamAlias("pdate")
	private String productdate; //商品发布时间
	
	
	
	
	/**
	 * @return the fromBy
	 */
	public String getFromBy() {
		return fromBy;
	}
	/**
	 * @param fromBy the fromBy to set
	 */
	public void setFromBy(String fromBy) {
		this.fromBy = fromBy;
	}
	/**
	 * @return the productSn
	 */
	public String getProductSn() {
		return productSn;
	}
	/**
	 * @param productSn the productSn to set
	 */
	public void setProductSn(String productSn) {
		this.productSn = productSn;
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
	public ProductSpecVo getProductSpec() {
		return productSpec;
	}
	public void setProductSpec(ProductSpecVo productSpec) {
		this.productSpec = productSpec;
	}
	public ProductPropVo getProductProp() {
		return productProp;
	}
	public void setProductProp(ProductPropVo productProp) {
		this.productProp = productProp;
	}
	public String getHotelAddress() {
		return hotelAddress;
	}
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
	public String getShip() {
		return ship;
	}
	public void setShip(String ship) {
		this.ship = ship;
	}
	public String getShareUrl() {
		return shareUrl;
	}
	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}
	/*public List getImages() {
		return images;
	}
	public void setImages(List images) {
		this.images = images;
	}*/
/*	public List getPrices() {
		return prices;
	}
	public void setPrices(List prices) {
		this.prices = prices;
	}
*/	
	public List<Object> getImages() {
		return images;
	}
	public void setImages(List<Object> images) {
		this.images = images;
	}
	/**
	 * @return the prices
	 */
	public List<Object> getPrices() {
		return prices;
	}
	/**
	 * @param prices the prices to set
	 */
	public void setPrices(List<Object> prices) {
		this.prices = prices;
	}
	public List<Object> getProductStock() {
		return productStock;
	}
	public void setProductStock(List<Object> productStock) {
		this.productStock = productStock;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the hotelPhone
	 */
	public String getHotelPhone() {
		return hotelPhone;
	}
	/**
	 * @return the shelf
	 */
	public String getShelf() {
		return shelf;
	}
	/**
	 * @return the productShareCount
	 */
	public long getProductShareCount() {
		return productShareCount;
	}
	/**
	 * @return the productdate
	 */
	public String getProductdate() {
		return productdate;
	}
	/**
	 * @param productdate the productdate to set
	 */
	public void setProductdate(String productdate) {
		this.productdate = productdate;
	}
	/**
	 * @return the isExperience
	 */
	public int getIsExperience() {
		return isExperience;
	}
	/**
	 * @param isExperience the isExperience to set
	 */
	public void setIsExperience(int isExperience) {
		this.isExperience = isExperience;
	}
	/**
	 * @param productShareCount the productShareCount to set
	 */
	public void setProductShareCount(long productShareCount) {
		this.productShareCount = productShareCount;
	}
	/**
	 * @return the experienceAfter
	 */
	/**
	 * @param shelf the shelf to set
	 */
	public void setShelf(String shelf) {
		this.shelf = shelf;
	}
	/**
	 * @return the productSalesCount
	 */
	public long getProductSalesCount() {
		return productSalesCount;
	}
	/**
	 * @param productSalesCount the productSalesCount to set
	 */
	public void setProductSalesCount(long productSalesCount) {
		this.productSalesCount = productSalesCount;
	}
	/**
	 * @return the grid
	 */
	public String getGrid() {
		return grid;
	}
	/**
	 * @param grid the grid to set
	 */
	public void setGrid(String grid) {
		this.grid = grid;
	}
	/**
	 * @param hotelPhone the hotelPhone to set
	 */
	public void setHotelPhone(String hotelPhone) {
		this.hotelPhone = hotelPhone;
	}
	public int getIsCollection() {
		return isCollection;
	}
	/**
	 * @return the defaultImage
	 */
	public String getDefaultImage() {
		return defaultImage;
	}
	/**
	 * @param defaultImage the defaultImage to set
	 */
	public void setDefaultImage(String defaultImage) {
		this.defaultImage = defaultImage;
	}
	public void setIsCollection(int isCollection) {
		this.isCollection = isCollection;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getPullOn() {
		return pullOn;
	}
	public void setPullOn(int pullOn) {
		this.pullOn = pullOn;
	}
	public int getPayType() {
		return payType;
	}
	public void setPayType(int payType) {
		this.payType = payType;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getHid() {
		return hid;
	}
	public void setHid(String hid) {
		this.hid = hid;
	}
	
	
}
