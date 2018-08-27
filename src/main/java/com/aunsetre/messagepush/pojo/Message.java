package com.aunsetre.messagepush.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 *
 * @author Aunsetre
 * @date 2018-08-21
 */
@Data
@Component
public class Message implements Serializable {
    private static final long serialVersionUID=1L;
    private int id;
    private String title;
    private String content;
    private Date createDate;
    private String createAuthor;


}
