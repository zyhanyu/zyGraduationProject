package com.ithanyu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName File
 * @Description: TODO
 * @Author:1276046082@qq.com
 */

@Data
@TableName("sys_file")
public class Files {
    @TableId(type = IdType.AUTO)
    private String id;
    private String name;
    private String type;
    private Long size;
    private String url;
    private String md5;
    private Boolean isDelete;
    private Boolean enable;
}
