package com.publiccms.views.directive.trade;

// Generated 2019-6-16 9:47:27 by com.publiccms.common.generator.SourceGenerator
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.publiccms.logic.service.trade.TradeAccountService;
import com.publiccms.common.base.AbstractTemplateDirective;
import com.publiccms.common.handler.RenderHandler;
import com.publiccms.common.handler.PageHandler;

/**
 *
 * tradeAccountList 账户列表查询指令
 * <p>
 * 参数列表
 * <ul>
 * <li><code>pageIndex</code> 页码
 * <li><code>pageSize</code> 每页条数
 * </ul>
 * <p>
 * 返回结果
 * <ul>
 * <li><code>page</code> {@link com.publiccms.common.handler.PageHandler}
 * <li><code>page.list</code> List类型 查询结果实体列表
 * {@link com.publiccms.entities.trade.TradeAccount}
 * </ul>
 * 使用示例
 * <p>
 * &lt;@trade.accountList pageSize=10&gt;&lt;#list page.list as
 * a&gt;${a.amount}&lt;#sep&gt;,&lt;/#list&gt;&lt;/@trade.accountList&gt;
 * 
 * <pre>
&lt;script&gt;
$.getJSON('//cms.publiccms.com/api/directive/trade/accountList?pageSize=10&amp;appToken=接口访问授权Token', function(data){    
 console.log(data.totalCount);
});
&lt;/script&gt;
 * </pre>
 */
@Component
public class TradeAccountListDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        PageHandler page = service.getPage(getSite(handler).getId(), handler.getInteger("pageIndex", 1),
                handler.getInteger("pageSize", 30));
        handler.put("page", page).render();
    }

    @Override
    public boolean needAppToken() {
        return true;
    }

    @Autowired
    private TradeAccountService service;

}