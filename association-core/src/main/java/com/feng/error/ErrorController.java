//package com.feng.error;
//
//import org.springframework.boot.autoconfigure.web.ErrorProperties;
//import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
//import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//public class ErrorController extends BasicErrorController {
//
//    public ErrorController() {
//        super(new DefaultErrorAttributes(), new ErrorProperties());
//    }
//
//    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
//        Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
//        HttpStatus status = getStatus(request);
//        //自定义的错误信息类
//        //status.value():错误代码，
//      String msg =  body.get("message").toString();
//        //body.get("message").toString()错误信息
////        ResponseResult ret = ResponseResultUtil.renderError(status.value(), body.get("message").toString());
////        //TokenException Filter抛出的自定义错误类
////        if (!Strings.isNullOrEmpty((String) body.get("exception")) && body.get("exception").equals(TokenException.class.getName())) {
////            body.put("status", HttpStatus.FORBIDDEN.value());
////            status = HttpStatus.FORBIDDEN;
////        }
//        Map<String,Object> resultMap = new HashMap<>();
//        resultMap.put("code",status);
//        resultMap.put("msg",msg);
//        return new ResponseEntity<Map<String, Object>>(resultMap, status);
//    }
//
//    @Override
//    public String getErrorPath() {
//        return "error/error";
//    }
//
//}
