package com.singerdream.comment.controller;

import com.singerdream.comment.api.modle.CommentModel;
import com.singerdream.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/comment/check")
    public CommentModel checkComment(String content){
        return commentService.addComment(content,1,-1,100,"QNA");
    }
}
