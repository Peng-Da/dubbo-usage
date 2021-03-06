/*
 * This file is generated by jOOQ.
 */
package com.singerdream.comment.tables;


import com.singerdream.comment.Keys;
import com.singerdream.comment.Public;
import com.singerdream.comment.tables.records.CommentRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row8;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Comment extends TableImpl<CommentRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.comment</code>
     */
    public static final Comment COMMENT = new Comment();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CommentRecord> getRecordType() {
        return CommentRecord.class;
    }

    /**
     * The column <code>public.comment.id</code>.
     */
    public final TableField<CommentRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.comment.content</code>.
     */
    public final TableField<CommentRecord, String> CONTENT = createField(DSL.name("content"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.comment.publisher_id</code>.
     */
    public final TableField<CommentRecord, Long> PUBLISHER_ID = createField(DSL.name("publisher_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.comment.active</code>.
     */
    public final TableField<CommentRecord, Boolean> ACTIVE = createField(DSL.name("active"), SQLDataType.BOOLEAN.defaultValue(DSL.field("true", SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>public.comment.created_at</code>.
     */
    public final TableField<CommentRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.comment.pid</code>.
     */
    public final TableField<CommentRecord, Long> PID = createField(DSL.name("pid"), SQLDataType.BIGINT.defaultValue(DSL.field("'-1'::integer", SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.comment.target_id</code>.
     */
    public final TableField<CommentRecord, Long> TARGET_ID = createField(DSL.name("target_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.comment.target_source</code>.
     */
    public final TableField<CommentRecord, String> TARGET_SOURCE = createField(DSL.name("target_source"), SQLDataType.VARCHAR, this, "");

    private Comment(Name alias, Table<CommentRecord> aliased) {
        this(alias, aliased, null);
    }

    private Comment(Name alias, Table<CommentRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.comment</code> table reference
     */
    public Comment(String alias) {
        this(DSL.name(alias), COMMENT);
    }

    /**
     * Create an aliased <code>public.comment</code> table reference
     */
    public Comment(Name alias) {
        this(alias, COMMENT);
    }

    /**
     * Create a <code>public.comment</code> table reference
     */
    public Comment() {
        this(DSL.name("comment"), null);
    }

    public <O extends Record> Comment(Table<O> child, ForeignKey<O, CommentRecord> key) {
        super(child, key, COMMENT);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<CommentRecord, Long> getIdentity() {
        return (Identity<CommentRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<CommentRecord> getPrimaryKey() {
        return Keys.COMMENT_PKEY;
    }

    @Override
    public List<UniqueKey<CommentRecord>> getKeys() {
        return Arrays.<UniqueKey<CommentRecord>>asList(Keys.COMMENT_PKEY);
    }

    @Override
    public Comment as(String alias) {
        return new Comment(DSL.name(alias), this);
    }

    @Override
    public Comment as(Name alias) {
        return new Comment(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Comment rename(String name) {
        return new Comment(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Comment rename(Name name) {
        return new Comment(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Long, String, Long, Boolean, LocalDateTime, Long, Long, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}
