package com.qyl.pojo.PO;

import com.qyl.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: qyl
 * @Date: 2021/2/9 22:14
 * @Description: token 与 user 包装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenPO {

    private String token;

    private User user;
}
