package com.singerdream.comment.service;

import com.singerdream.comment.api.CommentInterface;
import com.singerdream.comment.api.modle.CommentModel;
import com.singerdream.comment.dao.CommentCustomDao;
import com.singerdream.comment.tables.pojos.Comment;
import com.singerdream.comment.tables.records.CommentRecord;
import com.singerdream.textdetection.api.TextDetectionInterface;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static com.singerdream.comment.Tables.COMMENT;

@DubboService
public class CommentServiceImp implements CommentInterface {

    @DubboReference
    TextDetectionInterface textDetectionServiceApi;
    @Autowired
    CommentCustomDao commentDao;

    @Override
    public CommentModel add(CommentModel comment) {
        String content=textDetectionServiceApi.replaceSensitive(comment.getContent(),"*");
        comment.setContent(content);
        CommentRecord record = new CommentRecord();
        record.setContent(comment.getContent());
        record.setPublisherId(comment.getPublisherId());
        record.setPid(comment.getPid());
        record.setTargetId(comment.getTargetId());
        record.setTargetSource(comment.getTargetSource());
        return commentDao.insert(record).into(CommentModel.class);
    }

    @Override
    public void delete(long commentId) {
        commentDao.deleteById(commentId);
    }

    @Override
    public void update(CommentModel commentModel) {
        Comment comment = commentDao.fetchOneById(commentModel.getId());
        comment.setActive(commentModel.isActive());
        comment.setContent(commentModel.getContent());
        commentDao.insert(comment);
    }

    @Override
    public List<CommentModel> queryActiveByTargetId(long targetId) {
        return commentDao.fetchByCondition(COMMENT.ACTIVE.isTrue().and(COMMENT.TARGET_ID.eq(targetId)))
                .stream().map(r->r.into(CommentModel.class)).collect(Collectors.toList());
    }

    @Override
    public List<CommentModel> queryActiveByPid(long pid) {
        return commentDao.fetchByCondition(COMMENT.ACTIVE.isTrue().and(COMMENT.PID.eq(pid)))
                .stream().map(r->r.into(CommentModel.class)).collect(Collectors.toList());
    }
}
