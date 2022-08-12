package org.example.domain;

/**
 * @author: ymm
 * @date: 2022/8/11
 * @version: 1.0.0
 * @description:
 */

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class QueryVo {
    private String keyword;
    private User user;
    private List<User> userList;
    private Map<String, User> userMap;
}
