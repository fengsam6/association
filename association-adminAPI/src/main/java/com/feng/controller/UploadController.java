package com.feng.controller;

import com.feng.conf.FileUploadConf;
import com.feng.entity.ResponseResult;
import com.feng.enums.ErroEnum;
import com.feng.enums.FileEnum;
import com.feng.exception.BusinessException;
import com.feng.service.FileService;
import com.feng.util.ResponseResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by rf on 2019/4/26.
 */
@RestController
@RequestMapping("/files")
@Slf4j
public class UploadController {
    @Autowired
    private FileService fileService;
    @Autowired
    private FileUploadConf fileUploadConf;

    @PostMapping("/upload")
    @ResponseBody
    public ResponseResult upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
       String fileExt[]={"doc","docx","jpg","png"};
        checkFileExt(file,fileExt,"请上传doc,docx,jpg,png格式文件");
        String relativePath = "fileUpload";
        String fileName = file.getOriginalFilename();
        String fileSavePath = getFileSavePath(relativePath);
        File dest = new File(fileSavePath);
        try {
            file.transferTo(dest);
            com.feng.entity.File fileObj = new com.feng.entity.File(fileName, relativePath+ "/", FileEnum.COMMON_FILE.getFileId());
            fileService.save(fileObj);
            log.info("上传成功");
            return ResponseResultUtil.renderSuccess(fileObj);
        } catch (IOException e) {
            log.error(e.toString(), e);
        }
        return ResponseResultUtil.renderError(ErroEnum.FALE_UPLOAD_FAIL);
    }

    @PostMapping("/uploadImg")
    @ResponseBody
    public ResponseResult uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        String fileExt[]={"jpg","png"};
        checkFileExt(file,fileExt,"请上传jpg,png格式图片");
        String relativePath = "fileUpload";
        String fileName = file.getOriginalFilename();
        String imgSavePath = getFileSavePath(relativePath);
        File dest = new File(imgSavePath);
        try {
            file.transferTo(dest);
            fileService.insert(new com.feng.entity.File(fileName, imgSavePath,FileEnum.COMMON_IMG.getFileId()));
            log.info("上传成功");
            String fileSaveUrl = request.getContextPath() + "/" + imgSavePath;
            return ResponseResultUtil.renderSuccess(fileSaveUrl);
        } catch (IOException e) {
            log.error(e.toString(), e);
        }
        return ResponseResultUtil.renderError(ErroEnum.FALE_UPLOAD_FAIL);
    }

    private void  checkFileExt(MultipartFile file,String fileExt[],String msg){
        boolean checkResultError = true;
        if (file.isEmpty()) {
            throw new BusinessException(ErroEnum.FILE_NULL);
        }
        String fileName = file.getOriginalFilename();
        String uploadFileExt = fileName.substring(fileName.indexOf('.'));
        for(String s : fileExt){
            if(s.equals(uploadFileExt)){
                checkResultError=false;
                break;
            }
        }
        if(fileExt==null||fileExt.length==0){
            checkResultError=false;
        }
        if (checkResultError ) {
            throw new BusinessException(ErroEnum.FILE_FORMAT_ERROR.setMsg(msg));
        }
    }
    private String  getFileSavePath(String relativePath){
        String filePath = this.getClass().getResource("/").getPath() + relativePath;
        File fileSave = new File(filePath);
        if (!fileSave.exists()) {
            fileSave.mkdirs();
        }
        System.out.println(this.getClass().getResource("/"));
        System.out.println(filePath);
        return filePath;
    }
}
