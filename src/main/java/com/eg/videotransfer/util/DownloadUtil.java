package com.eg.videotransfer.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * 搞定下载
 *
 * @time 2020-01-19 00:21
 */
public class DownloadUtil {

    /**
     * 通过youtube-dl下载视频
     * 下载指定url的视频，保存到指定文件夹
     * <p>
     * youtube-dl --get-filename
     *
     * @param url
     * @param folder
     * @throws IOException
     */
    public static void downloadByUrl(String url, String folder) throws IOException {
        //先使用youtube-dl下载
        Process process = Runtime.getRuntime().exec(
                "youtube-dl -o " + folder + "/%(title)s.%(ext)s " + url
//                "youtube-dl -o D:\\%(title)s.%(ext)s https://www.youtube.com/watch?v=qa7kBFOwZN4"
//                "youtube-dl -o D:\\%(title)s.%(ext)s https://www.bilibili.com/video/av84118133"
        );
        try (InputStream fis = process.getInputStream();
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        //下载完成后，使用bypy上传
        System.out.println("开始用bypy上传");
        Process process1 = Runtime.getRuntime().exec(
                "bypy upload " + Contants.DOWNLOAD_LOCATION + " /youtube/"
        );
        try (InputStream fis = process1.getInputStream();
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        System.out.println("bypy上传完成");
    }

    public static void main(String[] args) {
        try {
            downloadByUrl("https://www.youtube.com/watch?v=qa7kBFOwZN4", "D:\\");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
