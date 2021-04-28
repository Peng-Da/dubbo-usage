/*
 * This file is generated by jOOQ.
 */
package com.singerdream.comment.tables.daos;


import com.singerdream.comment.tables.Comment;
import com.singerdream.comment.tables.records.CommentRecord;

import java.time.LocalDateTime;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class CommentDao extends DAOImpl<CommentRecord, com.singerdream.comment.tables.pojos.Comment, Long> {

    /**
     * Create a new CommentDao without any configuration
     */
    public CommentDao() {
        super(Comment.COMMENT, com.singerdream.comment.tables.pojos.Comment.class);
    }

    /**
     * Create a new CommentDao with an attached configuration
     */
    @Autowired
    public CommentDao(Configuration configuration) {
        super(Comment.COMMENT, com.singerdream.comment.tables.pojos.Comment.class, configuration);
    }

    @Override
    public Long getId(com.singerdream.comment.tables.pojos.Comment object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.singerdream.comment.tables.pojos.Comment> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Comment.COMMENT.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.singerdream.comment.tables.pojos.Comment> fetchById(Long... values) {
        return fetch(Comment.COMMENT.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.singerdream.comment.tables.pojos.Comment fetchOneById(Long value) {
        return fetchOne(Comment.COMMENT.ID, value);
    }

    /**
     * Fetch records that have <code>content BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.singerdream.comment.tables.pojos.Comment> fetchRangeOfContent(String lowerInclusive, String upperInclusive) {
        return fetchRange(Comment.COMMENT.CONTENT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>content IN (values)</code>
     */
    public List<com.singerdream.comment.tables.pojos.Comment> fetchByContent(String... values) {
        return fetch(Comment.COMMENT.CONTENT, values);
    }

    /**
     * Fetch records that have <code>publisher_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.singerdream.comment.tables.pojos.Comment> fetchRangeOfPublisherId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Comment.COMMENT.PUBLISHER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>publisher_id IN (values)</code>
     */
    public List<com.singerdream.comment.tables.pojos.Comment> fetchByPublisherId(Long... values) {
        return fetch(Comment.COMMENT.PUBLISHER_ID, values);
    }

    /**
     * Fetch records that have <code>active BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.singerdream.comment.tables.pojos.Comment> fetchRangeOfActive(Boolean lowerInclusive, Boolean upperInclusive) {
        return fetchRange(Comment.COMMENT.ACTIVE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>active IN (values)</code>
     */
    public List<com.singerdream.comment.tables.pojos.Comment> fetchByActive(Boolean... values) {
        return fetch(Comment.COMMENT.ACTIVE, values);
    }

    /**
     * Fetch records that have <code>created_at BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.singerdream.comment.tables.pojos.Comment> fetchRangeOfCreatedAt(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(Comment.COMMENT.CREATED_AT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>created_at IN (values)</code>
     */
    public List<com.singerdream.comment.tables.pojos.Comment> fetchByCreatedAt(LocalDateTime... values) {
        return fetch(Comment.COMMENT.CREATED_AT, values);
    }

    /**
     * Fetch records that have <code>pid BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.singerdream.comment.tables.pojos.Comment> fetchRangeOfPid(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Comment.COMMENT.PID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>pid IN (values)</code>
     */
    public List<com.singerdream.comment.tables.pojos.Comment> fetchByPid(Long... values) {
        return fetch(Comment.COMMENT.PID, values);
    }

    /**
     * Fetch records that have <code>target_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.singerdream.comment.tables.pojos.Comment> fetchRangeOfTargetId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Comment.COMMENT.TARGET_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>target_id IN (values)</code>
     */
    public List<com.singerdream.comment.tables.pojos.Comment> fetchByTargetId(Long... values) {
        return fetch(Comment.COMMENT.TARGET_ID, values);
    }

    /**
     * Fetch records that have <code>target_source BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.singerdream.comment.tables.pojos.Comment> fetchRangeOfTargetSource(String lowerInclusive, String upperInclusive) {
        return fetchRange(Comment.COMMENT.TARGET_SOURCE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>target_source IN (values)</code>
     */
    public List<com.singerdream.comment.tables.pojos.Comment> fetchByTargetSource(String... values) {
        return fetch(Comment.COMMENT.TARGET_SOURCE, values);
    }
}
