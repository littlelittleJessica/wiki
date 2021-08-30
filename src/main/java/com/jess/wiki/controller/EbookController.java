package com.jess.wiki.controller;

import com.jess.wiki.req.EbookQueryReq;
import com.jess.wiki.req.EbookSaveReq;
import com.jess.wiki.resp.CommonResp;
import com.jess.wiki.resp.EbookResp;
import com.jess.wiki.resp.PageResp;
import com.jess.wiki.service.EbookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/8/25
 */
@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp list(EbookQueryReq req) {
        CommonResp<PageResp<EbookResp>> resp = new CommonResp<>();
        PageResp<EbookResp> list = ebookService.list(req);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
        public CommonResp save(@RequestBody EbookSaveReq req) {
            CommonResp resp = new CommonResp<>();
            ebookService.save(req);
            return resp;
        }
}