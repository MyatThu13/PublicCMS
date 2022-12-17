package com.publiccms.logic.component.interaction;

import java.io.ByteArrayOutputStream;

import org.apache.tools.zip.ZipOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.publiccms.common.handler.PageHandler;
import com.publiccms.entities.cms.CmsDictionary;
import com.publiccms.entities.cms.CmsDictionaryData;
import com.publiccms.entities.cms.CmsDictionaryExclude;
import com.publiccms.entities.cms.CmsDictionaryExcludeValue;
import com.publiccms.logic.service.cms.CmsDictionaryDataService;
import com.publiccms.logic.service.cms.CmsDictionaryExcludeService;
import com.publiccms.logic.service.cms.CmsDictionaryExcludeValueService;
import com.publiccms.logic.service.cms.CmsDictionaryService;
import com.publiccms.views.pojo.interaction.Dictionary;

/**
 * DictionaryInteractionComponent 数据字典导入导出组件
 * 
 */
@Component
public class DictionaryInteractionComponent extends InteractionComponent<CmsDictionary, Dictionary> {
    @Autowired
    private CmsDictionaryService service;
    @Autowired
    private CmsDictionaryDataService dataService;
    @Autowired
    private CmsDictionaryExcludeService excludeService;
    @Autowired
    private CmsDictionaryExcludeValueService excludeValueService;

    public void exportAll(short siteId, String directory, ZipOutputStream zipOutputStream) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        service.batchWork(siteId, (list, i) -> {
            for (CmsDictionary entity : list) {
                exportEntity(siteId, directory, entity, out, zipOutputStream);
            }
        }, PageHandler.MAX_PAGE_SIZE);
    }

    public void exportEntity(short siteId, String directory, CmsDictionary entity, ByteArrayOutputStream out,
            ZipOutputStream zipOutputStream) {
        Dictionary data = new Dictionary();
        data.setEntity(entity);
        data.setDataList(dataService.getList(siteId, entity.getId().getId()));
        data.setExcludeList(excludeService.getList(siteId, entity.getId().getId(), null));
        data.setExcludeValueList(excludeValueService.getList(siteId, entity.getId().getId(), null));
        export(directory, out, zipOutputStream, data, entity.getId().getId() + ".json");
    }

    public void save(short siteId, long userId, boolean overwrite, Dictionary data) {
        CmsDictionary entity = data.getEntity();
        entity.getId().setSiteId(siteId);
        CmsDictionary oldentity = service.getEntity(entity.getId());
        if (null == oldentity || overwrite) {
            service.delete(entity.getId());
            service.save(entity);
            if (null != data.getDataList()) {
                for (CmsDictionaryData temp : data.getDataList()) {
                    temp.getId().setSiteId(siteId);
                }
                dataService.save(data.getDataList());
            }
            if (null != data.getExcludeList()) {
                for (CmsDictionaryExclude temp : data.getExcludeList()) {
                    temp.getId().setSiteId(siteId);
                }
                excludeService.save(data.getExcludeList());
            }
            if (null != data.getExcludeValueList()) {
                for (CmsDictionaryExcludeValue temp : data.getExcludeValueList()) {
                    temp.getId().setSiteId(siteId);
                }
                excludeValueService.save(data.getExcludeValueList());
            }
        }
    }
}
