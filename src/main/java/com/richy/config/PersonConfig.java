package com.richy.config;

import com.richy.conditions.LinuxCondition;
import com.richy.conditions.WindowsCondition;
import com.richy.dto.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author Richy
 * @date 2021-01-10 20:54
 */
@Configuration
public class PersonConfig {


    @Bean("bill")
    @Conditional({WindowsCondition.class})
    public Person bill(){
        return Person.builder().name("Bill Gates").age(66).build();
    }

    @Bean("linus")
    @Conditional({LinuxCondition.class})
    public Person linus(){
        return Person.builder().name("linus").age(48).build();
    }
}
