package com.singerdream.textdetection;

/**
 * Created by qiyang on 16-12-30.
 */
public class WordPosition {
    private int beginIndex;

    private String sensitiveWord;

    public WordPosition() {
    }

    public WordPosition(int beginIndex, String sensitiveWord) {
        this.beginIndex = beginIndex;
        this.sensitiveWord = sensitiveWord;
    }

    public int getBeginIndex() {
        return beginIndex;
    }

    public void setBeginIndex(int beginIndex) {
        this.beginIndex = beginIndex;
    }

    public String getSensitiveWord() {
        return sensitiveWord;
    }

    public void setSensitiveWord(String sensitiveWord) {
        this.sensitiveWord = sensitiveWord;
    }

    public int getEndIndex(){
        return beginIndex+sensitiveWord.length();
    }
}
