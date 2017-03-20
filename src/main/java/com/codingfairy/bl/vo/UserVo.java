package com.codingfairy.bl.vo;


import com.codingfairy.data.entity.UserEntity;
import com.codingfairy.util.enums.Gender;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;

@Data
public class UserVo {
    private int id;
    private String name;
    private String avatar;
    private String phone;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer valid;
    private Gender gender;

    public UserVo(UserEntity userEntity) {
        BeanUtils.copyProperties(userEntity,this,"deletedAt","password");
    }
}
