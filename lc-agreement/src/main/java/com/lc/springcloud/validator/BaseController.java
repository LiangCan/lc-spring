package com.lc.springcloud.validator;

import com.lc.springcloud.Constants;
import com.lc.springcloud.ResultCodeEnum;
import com.lc.springcloud.exception.CustomRunTimeException;
import com.lc.springcloud.validator.ValidatorUtils;
import org.springframework.validation.BindingResult;


public class BaseController extends ValidatorUtils {

    public  void validataBind(BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new CustomRunTimeException(ResultCodeEnum.PARAM_VALUE_INVALID, bindingResult.getFieldError().getDefaultMessage(), new Object[]{bindingResult.getFieldError().getField()});
        }
    }

    public <T>  void validataBind(BindingResult bindingResult, T t){
        if (bindingResult.hasErrors()) {
            throw new CustomRunTimeException(ResultCodeEnum.PARAM_VALUE_INVALID, bindingResult.getFieldError().getDefaultMessage(), new Object[]{bindingResult.getFieldError().getField()});
        }
        CustomRunTimeException.checkNull(t,"hG");
    }

}
