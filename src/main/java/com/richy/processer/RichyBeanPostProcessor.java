package com.richy.processer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * TODO
 * 自定义后置处理器
 * @author Richy
 * @date 2020-12-27 21:27
 */
public class RichyBeanPostProcessor implements BeanPostProcessor {


    /**
     * @desc:
     * bean的前置处理器
     * @method: postProcessAfterInitialization
     * @param:	bean:
     * @param:	beanName:
     * @date:   2020-12-27 21:41
     * @return: java.lang.Object
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    /**
     * @desc:
     * bean的后置处理器
     * @method: postProcessBeforeInitialization
     * @param:	bean:
     * @param:	beanName:
     * @date:   2020-12-27 21:41
     * @return: java.lang.Object
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
