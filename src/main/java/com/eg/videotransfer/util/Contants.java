package com.eg.videotransfer.util;

import org.apache.commons.lang3.SystemUtils;

import java.io.File;

/**
 * @time 2020-01-20 23:40
 */
public class Contants {
    static {
        DOWNLOAD_LOCATION = SystemUtils.getUserHome().getPath() + "/download-cache";
        File downloadFolder = new File(Contants.DOWNLOAD_LOCATION);
        if (downloadFolder.exists() == false) {
            downloadFolder.mkdirs();
        }
    }

    //默认下载视频的，缓存位置
    public static String DOWNLOAD_LOCATION;

}
