package com.lc.springcloud.controller;


import com.lc.springcloud.exception.CustomRunTimeException;
import com.lc.springcloud.http.dto.ReqBaseDTO;
import com.lc.springcloud.http.dto.req.IdDTO;
import com.lc.springcloud.service.UserInfoService;
import com.lc.springcloud.utils.GsonUtils;
import com.lc.springcloud.validator.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by Administrator on 2017/6/28 0028.
 */
@RestController
@Api(description = "用户API")
@RequestMapping(value = "/auth/user/", method = RequestMethod.POST)
public class UserController extends BaseController {

    @Autowired
    UserInfoService userInfoService;
//
//    @ApiOperation(value="用户上传头像")
//    @RequestMapping(value="upload/head/image.do")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "hA", value = "请求Key, L(5)", example = "10000", required = true),
//            @ApiImplicitParam(name = "hB",example = "1560927290321", required =true, value="请求时间戳, L(13)"),
//            @ApiImplicitParam(name = "hC",value="用户token,  L(36)", example ="54d5f2b6-889c-40dd-bd62-2b16031ba474"),
//            @ApiImplicitParam(name = "hD",value="签名,密钥Key,  L(36)", example ="bc5b3d5eaec85e4ec52a15d556142e498c63"),
//            @ApiImplicitParam(name = "hE",required =true, value="请求类型,  S(1~4)" , example ="1"),
//            @ApiImplicitParam(name = "hF",  required =true, value="加密方式[0/AES/MD5/..],  L(1~16)" , example ="0"),
//            @ApiImplicitParam(name = "hH",  required =true, value="协议版本,  L(4~16)" , example ="0.0.1")
//    }
//    )
//    public String UploadHeadImage( String hA, Long hB, String hC, String hD, short hE, String hF, String hH, @RequestParam("userIcon") MultipartFile file)throws CustomRunTimeException {
//        return GsonUtils.toJSON(userInfoService.uploadHeadIcon(file));
//    }


    @ApiOperation(value="用户注册帐号")
    @RequestMapping(value="/register.do", method = RequestMethod.POST)
    public String userRgister(@RequestBody @Valid ReqBaseDTO<IdDTO> reqBaseDTO , BindingResult bindingResult) throws CustomRunTimeException {
        validataBind(bindingResult,reqBaseDTO.gethG());
        return GsonUtils.toJSON(userInfoService.updateInfo(reqBaseDTO.gethG()));
    }
}
