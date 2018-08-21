package com.lc.springcloud.log;



import com.lc.springcloud.ResultCodeEnum;
import com.lc.springcloud.config.MessageConfig;
import com.lc.springcloud.config.ServiceConfig;
import com.lc.springcloud.http.dto.ReqBaseDTO;
import com.lc.springcloud.http.logserver.ServiceLogService;
import com.lc.springcloud.pojo.ServiceLog;
import com.lc.springcloud.service.UserInfoService;
import com.lc.springcloud.utils.GsonUtils;
import com.lc.springcloud.utils.MessageUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.util.TextUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Aspect
@Component
public class WebLogAspect {
    Log log= LogFactory.getLog(WebLogAspect.class);

    @Autowired
    ServiceLogService serviceLogService;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    ServiceConfig serviceConfig;


    @Pointcut("execution(public * com.lc.springcloud.service..*.*(..))")
    public void serverLog() {
    }


    @Pointcut("execution(public * com.lc.springcloud.controller..*.*(..))")
    public void reqLog() {
    }

    @Before("reqLog()")
    /**请求拦截处理 用于拦截service层记录异常日志 */
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //设置语言
        String lang = request.getHeader("Accept-Languag");
        String Languag = MessageConfig.map.get("zh");
        if(!TextUtils.isEmpty(lang) && MessageConfig.map.containsKey(lang)){
            Languag = MessageConfig.map.get(lang);
        }else{
            lang = "zh";
        }
        MessageUtils.setLanguage(new Locale(lang, Languag));

        //创建请求记录，日志
        ServiceLog serviceLog = new ServiceLog();
        serviceLog.setCreateTime(System.currentTimeMillis());
        serviceLog.setReqIp(request.getRemoteAddr());
        serviceLog.setItfName(request.getRequestURI());
        ReqBaseDTO reqBaseDTO = null;
        if( serviceLog.getItfName().indexOf("upload") > -1 ){
            reqBaseDTO =  new ReqBaseDTO();
            reqBaseDTO.sethA((String) joinPoint.getArgs()[0]);
            reqBaseDTO.sethB((Long) joinPoint.getArgs()[1]);
            reqBaseDTO.sethC((String) joinPoint.getArgs()[2]);
            reqBaseDTO.sethD((String) joinPoint.getArgs()[3]);
            reqBaseDTO.sethE((Short) joinPoint.getArgs()[4]);
            reqBaseDTO.sethF((String) joinPoint.getArgs()[5]);
            reqBaseDTO.sethH((String) joinPoint.getArgs()[6]);
        }else{
            reqBaseDTO = (ReqBaseDTO) joinPoint.getArgs()[0];
        }

        // 记录下请求内容
        log.info("REQ_URL : " + request.getRequestURL().toString() + "\n  " + GsonUtils.toJSON(joinPoint.getArgs()[0]));

        //记录日志信息
        serviceLog.setReqTime(reqBaseDTO.gethB());
        serviceLog.setOs(reqBaseDTO.gethE());
        serviceLog.setReqData(joinPoint.getArgs()[0].toString());
        serviceLog.setKey(String.valueOf(reqBaseDTO.gethA()));

//        //获取用户token
//        if(!TextUtils.isEmpty(reqBaseDTO.gethC())){
//            UserLogin userLogin = userInfoService.getTokenInfo(reqBaseDTO.gethC(), false);
//            if(userLogin != null){
//                serviceLog.setUserId(userLogin.getUserId());
//            }
//        }

        request.setAttribute(serviceConfig.getSERVICE_LOG(), serviceLog);
    }

    /**
     * 返回正常 用于拦截service层记录异常日志
     */
    @AfterReturning(returning = "ret", pointcut = "reqLog()")
    public void doAfterReturning (Object ret){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        ServiceLog serviceLog = (ServiceLog) request.getAttribute(serviceConfig.getSERVICE_LOG());
        serviceLog.setHandelStatus(ResultCodeEnum.SUCCESS.getIntKey());
        serviceLog.setReturnData(ret.toString());
        serviceLog.setReturnTime(System.currentTimeMillis());
        log.info("RESPONSE : " + serviceLog.getItfName() + " \n " + ret);
        serviceLogService.addServiceLog(serviceLog);
    }
}