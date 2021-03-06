package com.jd.dao.beans;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Good {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.goods_sn
     *
     * @mbg.generated
     */
    private String goodsSn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.category_id
     *
     * @mbg.generated
     */
    private Integer categoryId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.brand_id
     *
     * @mbg.generated
     */
    private Integer brandId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.gallery
     *
     * @mbg.generated
     */
    private String[] gallery;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.keywords
     *
     * @mbg.generated
     */
    private String keywords;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.brief
     *
     * @mbg.generated
     */
    private String brief;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.is_on_sale
     *
     * @mbg.generated
     */
    private Boolean isOnSale;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.sort_order
     *
     * @mbg.generated
     */
    private Short sortOrder;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.pic_url
     *
     * @mbg.generated
     */
    private String picUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.share_url
     *
     * @mbg.generated
     */
    private String shareUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.is_new
     *
     * @mbg.generated
     */
    private Boolean isNew;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.is_hot
     *
     * @mbg.generated
     */
    private Boolean isHot;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.unit
     *
     * @mbg.generated
     */
    private String unit;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.counter_price
     *
     * @mbg.generated
     */
    private BigDecimal counterPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.retail_price
     *
     * @mbg.generated
     */
    private BigDecimal retailPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.add_time
     *
     * @mbg.generated
     */
    private LocalDateTime addTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.update_time
     *
     * @mbg.generated
     */
    private LocalDateTime updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.browse
     *
     * @mbg.generated
     */
    private Integer browse;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.sales
     *
     * @mbg.generated
     */
    private Integer sales;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.deleted
     *
     * @mbg.generated
     */
    private Boolean deleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.commpany
     *
     * @mbg.generated
     */
    private String commpany;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.wholesale_price
     *
     * @mbg.generated
     */
    private BigDecimal wholesalePrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dts_goods.detail
     *
     * @mbg.generated
     */
    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String[] getGallery() {
        return gallery;
    }

    public void setGallery(String[] gallery) {
        this.gallery = gallery;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Boolean getOnSale() {
        return isOnSale;
    }

    public void setOnSale(Boolean onSale) {
        isOnSale = onSale;
    }

    public Short getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Short sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public Boolean getHot() {
        return isHot;
    }

    public void setHot(Boolean hot) {
        isHot = hot;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getCounterPrice() {
        return counterPrice;
    }

    public void setCounterPrice(BigDecimal counterPrice) {
        this.counterPrice = counterPrice;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getBrowse() {
        return browse;
    }

    public void setBrowse(Integer browse) {
        this.browse = browse;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getCommpany() {
        return commpany;
    }

    public void setCommpany(String commpany) {
        this.commpany = commpany;
    }

    public BigDecimal getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(BigDecimal wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
