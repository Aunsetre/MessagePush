package com.aunsetre.messagepush.pojo;

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
public class ScheduledMessage implements Serializable {
    private static final long serialVersionUID=1L;
    private int id;
    private String title;
    private String content;
    private Date createDate;
    private String createAuthor;

    public ScheduledMessage(int id, String title, String content, Date createDate, String createAuthor) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.createAuthor = createAuthor;
    }
}
