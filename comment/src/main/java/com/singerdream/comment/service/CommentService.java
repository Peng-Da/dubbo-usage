package com.singerdream.comment.service;

import com.gtan.singerdream.api.TextDetectionServiceApi;
import com.singerdream.comment.api.modle.CommentModel;
import com.singerdream.comment.dao.CommentCustomDao;
import com.singerdream.comment.tables.daos.CommentDao;
import com.singerdream.comment.tables.pojos.Comment;
import com.singerdream.comment.tables.records.CommentRecord;
import org.apache.dubbo.config.annotation.DubboReference;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.meta.jaxb.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {

    @DubboReference
    TextDetectionServiceApi textDetectionServiceApi;

    @Autowired
    CommentCustomDao commentDao;
    @Autowired
    DefaultConfiguration configuration;

    public CommentModel addComment(String content, long publisherId, long pid, long targetId, String targetSource) {
        /*String safeContent = textDetectionServiceApi.replaceSensitive(content, "*");
        CommentRecord record = new CommentRecord();
        record.setContent(safeContent);
        record.setPublisherId(publisherId);
        record.setPid(pid);
        record.setTargetId(targetId);
        record.setTargetSource(targetSource);
        record.attach(configuration);
        record.insert();
        System.out.println("new id---------------" + record.getId());*/
//        return "null";
//        return textDetectionServiceApi.containsSensitiveWords(content)?"forbidden:包含敏感词":"succeed";


        String c=textDetectionServiceApi.replaceSensitive(content,"*");
        CommentRecord record = new CommentRecord();
        record.setContent(c);
        record.setPublisherId(publisherId);
        record.setPid(pid);
        record.setTargetId(targetId);
        record.setTargetSource(targetSource);
        return commentDao.insert(record).into(CommentModel.class);
    }


}
