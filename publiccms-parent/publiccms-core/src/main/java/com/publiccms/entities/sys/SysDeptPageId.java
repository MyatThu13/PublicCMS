package com.publiccms.entities.sys;
// Generated 2016-11-19 15:33:56 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.publiccms.common.generator.annotation.GeneratorColumn;

/**
 * SysDeptPageId generated by hbm2java
 */
@Embeddable
public class SysDeptPageId implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * dept id<p>
     * 部门id
     */
    @GeneratorColumn(title = "部门", condition = true)
    private int deptId;
    /**
     * page<p>
     * 页面
     */
    @GeneratorColumn(title = "页面", condition = true)
    private String page;

    public SysDeptPageId() {
    }

    public SysDeptPageId(int deptId, String page) {
        this.deptId = deptId;
        this.page = page;
    }

    @Column(name = "dept_id", nullable = false)
    public int getDeptId() {
        return this.deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    @Column(name = "page", nullable = false, length = 100)
    public String getPage() {
        return this.page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof SysDeptPageId))
            return false;
        SysDeptPageId castOther = (SysDeptPageId) other;

        return (this.getDeptId() == castOther.getDeptId()) && ((this.getPage() == castOther.getPage())
                || (this.getPage() != null && castOther.getPage() != null && this.getPage().equals(castOther.getPage())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getDeptId();
        result = 37 * result + (getPage() == null ? 0 : this.getPage().hashCode());
        return result;
    }

}
