package com.richy.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Tolerate;

/**
 * TODO
 *
 * @author Richy
 * @date 2021-01-10 20:52
 */
@Data
@ToString
@Builder
public class Person {

    private String name;
    private Integer age;

    @Tolerate
    public Person(){}
}
