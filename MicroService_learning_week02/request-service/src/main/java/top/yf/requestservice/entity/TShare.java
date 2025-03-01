package top.yf.requestservice.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 分享表
 * </p>
 *
 * @author author
 * @since 2025-02-28
 */
@TableName("t_share")
public class TShare implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 发布人id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 标题
     */
    @TableField("title")
    private String title;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 是否原创 0:否 1:是
     */
    @TableField("is_original")
    private Boolean isOriginal;

    /**
     * 作者
     */
    @TableField("author")
    private String author;

    /**
     * 封面
     */
    @TableField("cover")
    private String cover;

    /**
     * 概要信息
     */
    @TableField("summary")
    private String summary;

    /**
     * 价格（需要的积分）
     */
    @TableField("price")
    private Integer price;

    /**
     * 下载地址
     */
    @TableField("download_url")
    private String downloadUrl;

    /**
     * 下载数 
     */
    @TableField("buy_count")
    private Integer buyCount;

    /**
     * 是否显示 0:否 1:是
     */
    @TableField("show_flag")
    private Boolean showFlag;

    /**
     * 审核状态 NOT_YET: 待审核 PASSED:审核通过 REJECTED:审核不通过
     */
    @TableField("audit_status")
    private String auditStatus;

    /**
     * 审核不通过原因
     */
    @TableField("reason")
    private String reason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    public Boolean getOriginal() {
        return isOriginal;
    }

    public void setOriginal(Boolean isOriginal) {
        this.isOriginal = isOriginal;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }
    public Boolean getShowFlag() {
        return showFlag;
    }

    public void setShowFlag(Boolean showFlag) {
        this.showFlag = showFlag;
    }
    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "TShare{" +
            "id=" + id +
            ", userId=" + userId +
            ", title=" + title +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", isOriginal=" + isOriginal +
            ", author=" + author +
            ", cover=" + cover +
            ", summary=" + summary +
            ", price=" + price +
            ", downloadUrl=" + downloadUrl +
            ", buyCount=" + buyCount +
            ", showFlag=" + showFlag +
            ", auditStatus=" + auditStatus +
            ", reason=" + reason +
        "}";
    }
}
