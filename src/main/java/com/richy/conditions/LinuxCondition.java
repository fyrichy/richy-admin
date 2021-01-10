package com.richy.conditions;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * TODO
 *
 * @author Richy
 * @date 2021-01-10 20:54
 */
public class LinuxCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //获取系统环境信息
        Environment environment = conditionContext.getEnvironment();
        String osName = environment.getProperty("os.name");
        if(StringUtils.contains(osName,"linux")){
            return true;
        }
        return false;
    }
}
