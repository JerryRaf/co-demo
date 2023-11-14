package com.company.b.dto;

import com.raf.framework.autoconfigure.spring.valid.Flag;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author Jerry
 * @date 2021/10/11
 */
@Data
public class CmsUserReq implements Serializable {
    private static final long serialVersionUID=-1;

    @Email(message = "email格式不对")
    @NotBlank(message = "内容不能为空")
    public String email;

    @NotBlank(message = "密码不能为空")
    @Pattern(regexp ="(?!^\\d+$)(?!^[A-Za-z]+$)(?!^[^A-Za-z0-9]+$)(?!^.*[\\u4E00-\\u9FA5].*$)^\\S{6,20}$", message = "6-20位，并且包含数字，字母，符号中的两项,除空格")
    private String password;

    @Flag(values = "1,2", message = "请输入正确的性别")
    private Integer sex;

    @NotBlank
    public String name;

    public Integer type;
}
