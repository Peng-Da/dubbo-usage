package com.singerdream.textdetection.api;

public interface TextDetectionInterface {

    boolean containsSensitiveWords(String text);

    String replaceSensitive(String text,String symbol);

    String [] checkoutSensitive(String text);
}
