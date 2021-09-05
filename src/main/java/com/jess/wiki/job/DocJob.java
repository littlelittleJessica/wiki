package com.jess.wiki.job;

import com.jess.wiki.service.DocService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/9/5
 */
@Component
public class DocJob {

    @Resource
    private DocService docService;

    private static final Logger LOG = LoggerFactory.getLogger(DocJob.class);

    /**
     * 每30s更新电子书信息
     */
    @Scheduled(cron = "5/30 * * * * ?")
    public void cron() {
        LOG.info("开始更新电子书下的文档数据");
        long start = System.currentTimeMillis();
        docService.updateEbookInfo();
        LOG.info("结束更新电子书下的文档数据，耗时：{}毫秒", System.currentTimeMillis() - start);
    }

}
