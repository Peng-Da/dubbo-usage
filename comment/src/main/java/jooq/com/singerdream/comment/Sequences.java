/*
 * This file is generated by jOOQ.
 */
package com.singerdream.comment;


import org.jooq.Sequence;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * Convenience access to all sequences in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>public.comment_id_seq</code>
     */
    public static final Sequence<Long> COMMENT_ID_SEQ = Internal.createSequence("comment_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);
}
