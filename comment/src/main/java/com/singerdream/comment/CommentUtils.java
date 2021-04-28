package com.singerdream.comment;

import com.singerdream.comment.api.modle.CommentModel;
import com.singerdream.comment.tables.pojos.Comment;

public class CommentUtils {

    public static Comment model2pojo(CommentModel model){
        return new Comment(
                model.getId(),
                model.getContent(),
                model.getPublisherId(),
                model.isActive(),
                model.getCreatedAt(),
                model.getPid(),
                model.getTargetId(),
                model.getTargetSource()
        );
    }
}
