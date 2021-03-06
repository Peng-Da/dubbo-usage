/*
 * This file is generated by jOOQ.
 */
package com.singerdream.textdetection.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SensitiveWord implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long   id;
    private final String content;

    public SensitiveWord(SensitiveWord value) {
        this.id = value.id;
        this.content = value.content;
    }

    public SensitiveWord(
        Long   id,
        String content
    ) {
        this.id = id;
        this.content = content;
    }

    /**
     * Getter for <code>public.sensitive_word.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Getter for <code>public.sensitive_word.content</code>.
     */
    public String getContent() {
        return this.content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SensitiveWord (");

        sb.append(id);
        sb.append(", ").append(content);

        sb.append(")");
        return sb.toString();
    }
}
