package com.entertainment.test.controller;

import com.entertainment.test.base.BadParamsException;
import com.entertainment.test.base.RespEntity;
import com.entertainment.test.base.RespState;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class BaseWebController {

    /**
     * 日志记录器
     */
    protected Logger logger = Logger.getLogger(BaseWebController.class);

    /**
     * 错误日志循环输出
     *
     * @param ex 错误
     */
    protected void error(Exception ex, RespEntity respEntity) {
        if (ex.getClass() == BadParamsException.class) {
            respEntity.code = RespState.badParams;
            respEntity.message = ex.getMessage();
        } else {
            respEntity.code = RespState.exception;
            respEntity.message = ex.getMessage();
            ex.printStackTrace();
            logger.error(ex);
            StackTraceElement[] error = ex.getStackTrace();
            for (StackTraceElement stackTraceElement : error) {
                logger.error(stackTraceElement.toString());
            }
        }

    }
}
