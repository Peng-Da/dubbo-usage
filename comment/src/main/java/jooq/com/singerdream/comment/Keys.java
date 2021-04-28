/*
 * This file is generated by jOOQ.
 */
package com.singerdream.comment;


import com.singerdream.comment.tables.Comment;
import com.singerdream.comment.tables.FlywaySchemaHistory;
import com.singerdream.comment.tables.records.CommentRecord;
import com.singerdream.comment.tables.records.FlywaySchemaHistoryRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in 
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CommentRecord> COMMENT_PKEY = Internal.createUniqueKey(Comment.COMMENT, DSL.name("comment_pkey"), new TableField[] { Comment.COMMENT.ID }, true);
    public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, DSL.name("flyway_schema_history_pk"), new TableField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK }, true);
}
