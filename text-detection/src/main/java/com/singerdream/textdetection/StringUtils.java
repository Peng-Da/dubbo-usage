package com.singerdream.textdetection;

import java.util.HashMap;
import java.util.Map;

public class StringUtils {
    private static final Map<String, String> regNeedEscapeStrMap; //正则匹配需转义的字符Map

    static {
        regNeedEscapeStrMap = new HashMap<String, String>();
        regNeedEscapeStrMap.put("$", "\\$");//正则匹配$ 需要转义 \$  java中 \需要写成\\ 所以为\\$ ,
        regNeedEscapeStrMap.put("(", "\\(");
        regNeedEscapeStrMap.put(")", "\\)");
        regNeedEscapeStrMap.put("*", "\\*");
        regNeedEscapeStrMap.put("+", "\\+");
        regNeedEscapeStrMap.put(".", "\\.");
        regNeedEscapeStrMap.put("[", "\\[");
        regNeedEscapeStrMap.put("]", "\\]");
        regNeedEscapeStrMap.put("?", "\\?");
        regNeedEscapeStrMap.put("\\", "\\\\");
        regNeedEscapeStrMap.put("^", "\\^");
        regNeedEscapeStrMap.put("{", "\\{");
        regNeedEscapeStrMap.put("}", "\\}");
        regNeedEscapeStrMap.put("|", "\\|");
    }

    /**
     * 将字符串中包含的在正则中使用的特殊字符转义,eg: + 改成 \+
     */
    public static String changeRegNeedEscapeStr(String str) {
        char[] chars = str.toCharArray();
        StringBuffer tmpStr = new StringBuffer();
        for (char c : chars) {
            String charStr = String.valueOf(c);
            tmpStr.append(regNeedEscapeStrMap.getOrDefault(charStr, charStr));//包含则替换,不包含则保留原字符
        }
        return tmpStr.toString();
    }
}
