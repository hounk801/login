package com.hnk.login.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author naikuo
 * @Date 2020/3/1 7:42 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private String userId;
    private String userName;
    private String email;
    private String password;

    public UserInfo(String userId, String userName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
    }
}
