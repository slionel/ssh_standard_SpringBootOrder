package com.zsj.utils;

import com.zsj.vo.ResultVo;

/**
 * @author zsj
 * @date 2019.9.30
 */
public class ResultVoUtil {
    public static ResultVo success(Object object){
        ResultVo resultVo = new ResultVo();
        resultVo.setBody(object);
        resultVo.setErrorCode(-1);
        resultVo.setMsg("成功");
        return resultVo;
    }

    public static ResultVo success(){
        return success(null);
    }

    public static ResultVo error(Integer code, String msg){
        ResultVo resultVo = new ResultVo();
        resultVo.setMsg(msg);
        resultVo.setErrorCode(code);
        return resultVo;
    }
}
