package com.lc.springcloud.service;


import com.lc.springcloud.http.dto.ResponseDTO;
import com.lc.springcloud.http.dto.req.IdDTO;

/**
 * 用户的服务层
 */
public interface UserInfoService {

    /** API 用户修改信息 */
    ResponseDTO updateInfo(IdDTO nameDTO);
//
//    /** API 用户上传头像 */
//    ResponseDTO uploadHeadIcon(MultipartFile multipartFile);
//
//    /** API 校验手机号码 */
//    ResponseDTO checkAccount(AccountDTO acountDTO);
//
//    /** API 用户注册 */
//    ResponseDTO userRgister(UserRegisterDTO registerDTO);
//
//    /** API  获取校验码*/
//    ResponseDTO userGetCheckCOde(UserGetCheckCodeDTO userGetCheckCodeDTO);
//
//    /** API 用户登录 */
//    ResponseDTO userLogin(UserLoginDTO userLoginDTO);
//
//    /** API 用户退出登录 */
//    ResponseDTO userLoginOut(String token);
//
//    UserLogin getTokenInfo(String token, boolean checkNull);
//
//    Long getUserId(boolean checkNull);
//
//    ResponseDTO updatePassword(UserUpdatePasswdDTO userUpdatePasswdDTO);
//
//    ResponseDTO userResetPasswd(UserResetPasswdDTO userResetPasswdDTO);



}
