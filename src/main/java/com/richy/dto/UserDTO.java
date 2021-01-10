package com.richy.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * TODO
 *
 * @author Richy
 * @date 2021-01-10 17:34
 */
@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = -7499515855922276948L;
    private String username;
}
