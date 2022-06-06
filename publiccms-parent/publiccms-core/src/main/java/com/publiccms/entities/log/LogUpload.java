package com.publiccms.entities.log;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.publiccms.common.database.CmsUpgrader;
import com.publiccms.common.generator.annotation.GeneratorColumn;

/**
 * LogUpload generated by hbm2java
 */
@Entity
@Table(name = "log_upload")
@DynamicUpdate
public class LogUpload implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @GeneratorColumn(title = "ID")
    private Long id;
    @GeneratorColumn(title = "站点", condition = true)
    @JsonIgnore
    private short siteId;
    /**
     * user id<p>
     * 用户id
     */
    @GeneratorColumn(title = "用户", condition = true)
    private long userId;
    /**
     * operate channel<p>
     * 操作渠道
     */
    @GeneratorColumn(title = "渠道", condition = true)
    private String channel;
    /**
     * original name<p>
     * 原文件名
     */
    @GeneratorColumn(title = "原文件名", condition = true, like = true)
    private String originalName;
    /**
     * file type<p>
     * 文件类型
     */
    @GeneratorColumn(title = "文件类型", condition = true)
    private String fileType;
    /**
     * file size<p>
     * 文件大小
     */
    @GeneratorColumn(title = "文件大小", order = true)
    private long fileSize;
    /**
     * image width<p>
     * 图片宽度
     */
    @GeneratorColumn(title = "宽度")
    private Integer width;
    /**
     * image height<p>
     * 图片高度
     */
    @GeneratorColumn(title = "高度")
    private Integer height;
    /**
     * ip
     */
    @GeneratorColumn(title = "IP")
    private String ip;
    /**
     * upload date<p>
     * 上传日期
     */
    @GeneratorColumn(title = "操作日期", order = true)
    private Date createDate;
    /**
     * file path<p>
     * 文件路径
     */
    @GeneratorColumn(title = "文件路径", condition = true, like = true)
    private String filePath;

    public LogUpload() {
    }

    public LogUpload(short siteId, long userId, String channel, String fileType, long fileSize, Date createDate,
            String filePath) {
        this.siteId = siteId;
        this.userId = userId;
        this.channel = channel;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.createDate = createDate;
        this.filePath = filePath;
    }

    public LogUpload(short siteId, long userId, String channel, String originalName, String fileType, long fileSize,
            Integer width, Integer height, String ip, Date createDate, String filePath) {
        this.siteId = siteId;
        this.userId = userId;
        this.channel = channel;
        this.originalName = originalName;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.width = width;
        this.height = height;
        this.ip = ip;
        this.createDate = createDate;
        this.filePath = filePath;
    }

    @Id
    @GeneratedValue(generator = "cmsGenerator")
    @GenericGenerator(name = "cmsGenerator", strategy = CmsUpgrader.IDENTIFIER_GENERATOR)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "site_id", nullable = false)
    public short getSiteId() {
        return this.siteId;
    }

    public void setSiteId(short siteId) {
        this.siteId = siteId;
    }

    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "channel", nullable = false, length = 50)
    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    @Column(name = "original_name")
    public String getOriginalName() {
        return this.originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    @Column(name = "file_type", nullable = false, length = 20)
    public String getFileType() {
        return this.fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Column(name = "file_size")
    public Long getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    @Column(name = "width")
    public Integer getWidth() {
        return this.width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Column(name = "height")
    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Column(name = "ip", length = 130)
    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false, length = 19)
    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name = "file_path", nullable = false, length = 500)
    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}
