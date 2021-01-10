package richy.admin;

import com.richy.RichyAdminApplication;
import com.richy.dto.Person;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TODO
 * 测试自定义Condition
 * @author Richy
 * @date 2021-01-10 20:58
 */
public class TestCondition {

    private static final Logger logger = LoggerFactory.getLogger(TestCondition.class);

    /**
     * @desc:
     * Idea设置系统参数：
     *  VM Options: -Dos.name=linux
     * @method: testCondition
     * @param:	:
     * @date:   2021-01-10 21:05
     * @return: void
     */
    @Test
    public void testCondition(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RichyAdminApplication.class);
        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        for(String name:beanNamesForType){
            logger.info("----------"+name);
        }
    }
}
