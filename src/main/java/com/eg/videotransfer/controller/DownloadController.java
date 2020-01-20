package com.eg.videotransfer.controller;

import com.eg.videotransfer.util.Contants;
import com.eg.videotransfer.util.DownloadUtil;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @time 2020-01-18 23:48
 */
@Controller
@RequestMapping("download")
public class DownloadController {

    @RequestMapping("newDownload")
    @ResponseBody
    public String index(@RequestParam("url") String url) {
        new Thread(() -> {
            try {
                DownloadUtil.downloadByUrl(url, Contants.DOWNLOAD_LOCATION);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        return "接到任务：" + url;
    }


}
