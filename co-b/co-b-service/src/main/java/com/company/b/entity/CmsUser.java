package com.company.b.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 *
 * @author Jerry
 * @date 2023/04/06 17:01:48
 */
@Data
public class CmsUser implements Serializable {
    private static final long serialVersionUID = -39226806846164777L;
    
    private Integer id;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 性别 1男 2女
     */
    private Integer sex;
    /**
     * 余额
     */
    private Double money;
    /**
     * 状态 1正常 2禁用
     */
    private Integer status;
    /**
     * 身份证
     */
    private String idCard;
    /**
     * 身份证秘钥数据id
     */
    private Long idCardCipherId;
    /**
     * 身份证秘钥
     */
    private String idCardCipherText;
    /**
     * 是否删除 1是，0否
     */
    private Integer isDeleted;
    /**
     * 创建人
     */
    private Integer createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后修改人
     */
    private Integer updateBy;
    /**
     * 最后修改时间
     */
    private Date updateTime;


}
