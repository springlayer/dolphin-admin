package com.orange.mo.admin.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "sys_user")
public class SysUser {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 登录名称
     */
    private String loginName;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户类型
     */
    private String userType;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phonenumber;

    /**
     * 用户性别
     */
    private String sex;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐加密
     */
    private String salt;

    /**
     * 帐号状态（0正常 1停用）
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    private String remark;

    private String createTime;

    public SysUser(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;
    }

    public static boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }
}