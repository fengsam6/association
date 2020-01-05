package com.feng.controller;

import com.feng.entity.ResponseResult;
import com.feng.enums.ErrorEnum;
import com.feng.enums.FileEnum;
import com.feng.exception.BusinessException;
import com.feng.service.FileService;
import com.feng.util.ResponseResultUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
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
@Api(tags = "文件上传接口")
public class FileUploadController {
    @Autowired
    private FileService fileService;
    @Value("${file.uploadPath}")
    private String fileSaveBasePath ;

    @PostMapping("/upload")
    @ResponseBody
    public ResponseResult upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        String fileExt[] = {"doc", "docx"};
        checkFileExt(file, fileExt, "请上传doc,docx格式文件");
        String relativePath = "/files/";
        String fileName = file.getOriginalFilename();
        String fileSavePath = getFileSavePath(relativePath);
        relativePath = relativePath + fileName;
        File dest = new File(fileSavePath + fileName);
        try {
            file.transferTo(dest);
            com.feng.entity.File fileObj = new com.feng.entity.File(fileName, relativePath, FileEnum.CLUB_FILE.getFileId());
            fileService.insert(fileObj);
            log.info("上传成功");
            return ResponseResultUtil.renderSuccess(fileObj);
        } catch (IOException e) {
            log.error(e.toString(), e);
        }
        return ResponseResultUtil.renderError(ErrorEnum.FILE_UPLOAD_FAIL);
    }

    @PostMapping("/uploadImg")
    @ResponseBody
    public ResponseResult uploadImg(@RequestParam("file") MultipartFile file,String relativePath, HttpServletRequest request) throws IOException {
        String fileExt[] = {"jpg", "png"};
        checkFileExt(file, fileExt, "请上传jpg,png格式图片");
//        String relativePath = "/images/";
        if(StringUtils.isEmpty(relativePath)){
            relativePath = "/images/";
        }
        String fileName = file.getOriginalFilename();
        String absolutePath = getFileSavePath(relativePath)+"/"+ fileName;
       String imgRelativePath = relativePath +"/"+ fileName;
        System.out.println(imgRelativePath);
        File dest = new File(absolutePath);
        try {
            file.transferTo(dest);
//            fileService.insert(new com.feng.entity.File(fileName, relativePath, FileEnum.COMMON_IMG.getFileId()));
            log.info("上传成功");
            return ResponseResultUtil.renderSuccess(imgRelativePath);
        } catch (IOException e) {
            log.error(e.toString(), e);
        }
        return ResponseResultUtil.renderError(ErrorEnum.FILE_UPLOAD_FAIL);
    }
    @PostMapping("/uploadCarouselImg")
    @ResponseBody
    public ResponseResult uploadIndexCarouselImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        String fileExt[] = {"jpg", "png"};
        checkFileExt(file, fileExt, "请上传jpg,png格式图片");
        String relativePath = "/carousel-img/";
        String fileName = file.getOriginalFilename();
        String imgSavePath = getFileSavePath(relativePath);
        relativePath = relativePath + fileName;
        File dest = new File(imgSavePath + fileName);
        try {
            file.transferTo(dest);
            fileService.insert(new com.feng.entity.File(fileName, relativePath, FileEnum.CAROUSEL_IMG.getFileId()));
            log.info("上传成功");
            return ResponseResultUtil.renderSuccess(relativePath);
        } catch (IOException e) {
            log.error(e.toString(), e);
        }
        return ResponseResultUtil.renderError(ErrorEnum.FILE_UPLOAD_FAIL);
    }
    private void checkFileExt(MultipartFile file, String fileExt[], String msg) {
        boolean checkResultError = true;
        if (file.isEmpty()) {
            throw new BusinessException(ErrorEnum.FILE_NULL);
        }

        String fileName = file.getOriginalFilename();
        String uploadFileExt = fileName.substring(fileName.indexOf('.') + 1);
        if (fileExt == null || fileExt.length == 0) {
            checkResultError = false;
        } else {
            for (String s : fileExt) {
                if (uploadFileExt.equals(s)) {
                    checkResultError = false;
                    break;
                }
            }
        }


        if (checkResultError) {
            throw new BusinessException(ErrorEnum.FILE_FORMAT_ERROR.setMsg(msg));
        }
    }


    private String getFileSavePath(String relativePath) {
        String filePath = fileSaveBasePath + relativePath;
        System.out.println(filePath);
        File fileSave = new File(filePath);
        if (!fileSave.exists()) {
            fileSave.mkdirs();
        }
        return filePath;
    }
}
