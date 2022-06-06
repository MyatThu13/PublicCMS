package com.publiccms.entities.visit;
// Generated 2021-8-6 14:20:45 by Hibernate Tools 5.4.32.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.publiccms.common.generator.annotation.GeneratorColumn;

/**
 * VisitItemId generated by hbm2java
 */
@Embeddable
public class VisitItemId implements java.io.Serializable {

    /**
    * 
    */
    private static final long serialVersionUID = 1L;
    @JsonIgnore
    @GeneratorColumn(title = "站点", condition = true)
    private short siteId;
    /**
     * visit date<p>
     * 访问日期
     */
    @GeneratorColumn(title = "访问日期", condition = true)
    private Date visitDate;
    /**
     * item type<p>
     * 项目类型
     */
    @GeneratorColumn(title = "项目类型", condition = true)
    private String itemType;
    /**
     * item id<p>
     * 项目id
     */
    @GeneratorColumn(title = "项目ID", condition = true)
    private String itemId;

    public VisitItemId() {
    }

    public VisitItemId(short siteId, Date visitDate, String itemType, String itemId) {
        this.siteId = siteId;
        this.visitDate = visitDate;
        this.itemType = itemType;
        this.itemId = itemId;
    }

    @Column(name = "site_id", nullable = false)
    public short getSiteId() {
        return this.siteId;
    }

    public void setSiteId(short siteId) {
        this.siteId = siteId;
    }

    @Column(name = "visit_date", nullable = false, length = 10)
    public Date getVisitDate() {
        return this.visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    @Column(name = "item_type", nullable = false, length = 50)
    public String getItemType() {
        return this.itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    @Column(name = "item_id", nullable = false, length = 50)
    public String getItemId() {
        return this.itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof VisitItemId))
            return false;
        VisitItemId castOther = (VisitItemId) other;

        return (this.getSiteId() == castOther.getSiteId())
                && ((this.getVisitDate() == castOther.getVisitDate()) || (this.getVisitDate() != null
                        && castOther.getVisitDate() != null && this.getVisitDate().equals(castOther.getVisitDate())))
                && ((this.getItemType() == castOther.getItemType()) || (this.getItemType() != null
                        && castOther.getItemType() != null && this.getItemType().equals(castOther.getItemType())))
                && ((this.getItemId() == castOther.getItemId()) || (this.getItemId() != null && castOther.getItemId() != null
                        && this.getItemId().equals(castOther.getItemId())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getSiteId();
        result = 37 * result + (getVisitDate() == null ? 0 : this.getVisitDate().hashCode());
        result = 37 * result + (getItemType() == null ? 0 : this.getItemType().hashCode());
        result = 37 * result + (getItemId() == null ? 0 : this.getItemId().hashCode());
        return result;
    }

}
