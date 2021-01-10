package com.richy.conditions;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * TODO
 * 如果系统是包含windows就返回true
 * @author Richy
 * @date 2021-01-10 20:52
 */
public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //获取系统环境信息
        Environment environment = conditionContext.getEnvironment();
        String osName = environment.getProperty("os.name");
        if(StringUtils.contains(osName,"Windows")){
            return true;
        }
        return false;
    }
}
