package richy.admin;

import com.richy.RichyAdminApplication;
import com.richy.config.JWTConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TODO
 *
 * @author Richy
 * @date 2021-01-10 20:47
 */
public class TestIOC {

    @Test
    public void testIOC(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RichyAdminApplication.class);
        String[] beanNamesForType = context.getBeanNamesForType(JWTConfig.class);
        for(String beanName:beanNamesForType){
            System.out.println(beanName);
        }
    }
}
