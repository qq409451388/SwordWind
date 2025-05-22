package com.poethan.sw.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName(value = "users")
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
}
