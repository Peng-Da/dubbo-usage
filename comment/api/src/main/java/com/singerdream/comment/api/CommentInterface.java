package com.singerdream.comment.api;

import com.singerdream.comment.api.modle.CommentModel;

import java.util.List;

public interface CommentInterface {

    CommentModel add(CommentModel comment);

    void delete(long commentId);

    void update(CommentModel commentModel);

    List<CommentModel> queryActiveByTargetId(long targetId);

    List<CommentModel> queryActiveByPid(long pid);
}
