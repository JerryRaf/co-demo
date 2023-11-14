package com.company.a.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 秘钥实体类
 *
 * @author Jerry
 * @date 2023/04/06 17:01:48
 */
@Data
public class CmsCipher implements Serializable {
    private static final long serialVersionUID = -21615147159974350L;
    
    private Integer id;
    /**
     * iv
     */
    private String iv;
    /**
     * 秘钥
     */
    private String secureKey;
    /**
     * 创建人
     */
    private Integer createBy;
    /**
     * 创建时间
     */
    private Date createTime;


}
