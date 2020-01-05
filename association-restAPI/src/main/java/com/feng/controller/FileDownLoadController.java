package com.feng.controller;

import com.feng.entity.ResponseResult;
import com.feng.enums.ErrorEnum;
import com.feng.util.ResponseResultUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by rf on 2019/5/5.
 */
@RestController
@Api(tags = "系统前台文件下载接口")
public class FileDownLoadController {
    @GetMapping("/download")
    public ResponseResult downloadFile(HttpServletRequest request,
                                       HttpServletResponse response, String fileName, String relativePath) throws UnsupportedEncodingException {
        if (fileName != null) {
            File file = new File(relativePath, fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                //response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                //response.setContentType("multipart/form-data;charset=UTF-8");也可以明确的设置一下UTF-8，测试中不设置也可以。
                response.setHeader("Content-Disposition", "attachment;fileName=" + new String(fileName.getBytes("GB2312"), "ISO-8859-1"));
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return ResponseResultUtil.renderError(ErrorEnum.DOWNLOAD_FILE_FAIL);
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return ResponseResultUtil.renderSuccess("下载文件成功");
    }
}
