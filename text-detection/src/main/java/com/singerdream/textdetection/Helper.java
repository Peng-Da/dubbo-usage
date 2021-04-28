package com.singerdream.textdetection;

import javaslang.Tuple2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * from linus 敏感词
 */
public class Helper {

    public static int checkSensitiveWord(String txt, int beginIndex, Map wordMap) {
        // 敏感词结束标识位：用于敏感词只有1位的情况
        boolean flag = false;
        // 匹配标识数默认为0
        int matchFlag = 0;
        Map nowMap = wordMap;
        for (int i = beginIndex; i < txt.length(); i++) {
            char word = txt.charAt(i);
            // 获取指定key
            nowMap = (Map) nowMap.get(word);
            // 存在，则判断是否为最后一个
            if (nowMap != null) {
                // 找到相应key，匹配标识+1
                matchFlag++;
                if("1".equals(nowMap.get("isEnd"))){       //如果为最后一个匹配规则,结束循环，返回匹配标识数
                    flag = true;       //结束标志位为true
                    break;
                }
            }
            // 不存在，直接返回
            else {
                break;
            }
        }
        // 长度必须大于等于1，为词
        if (!flag) {
            matchFlag = 0;
        }
        return matchFlag;
    }

    public static boolean isContaintSensitiveWord(String txt, Map wordMap) {
        boolean flag = false;
        for (int i = 0; i < txt.length(); i++) {
            // 判断是否包含敏感字符
            int matchFlag = checkSensitiveWord(txt, i, wordMap);
            // 大于0存在，返回true
            if (matchFlag > 0) {
                flag = true;
            }
        }
        return flag;
    }

    public static List<WordPosition> getSensitiveWord(String txt, Map wordMap) {
        List<WordPosition> sensitiveWordList = new ArrayList<>();
        for (int i = 0; i < txt.length(); i++) {
            // 判断是否包含敏感字符
            int length = checkSensitiveWord(txt, i, wordMap);
            // 存在,加入list中
            if (length > 0) {
                sensitiveWordList.add(new WordPosition(i, txt.substring(i, i + length)));
                // 减1的原因，是因为for会自增
                i = i + length - 1;
            }
        }
        return sensitiveWordList;
    }

    public static Map<String, Map> addSensitiveWordToHashMap(List<String> words) {
        Map wordMap = new HashMap(words.size());
        for (String word : words) {
            Map nowMap = wordMap;
            for (int i = 0; i < word.length(); i++) {
                char keyChar = word.charAt(i);
                Object tempMap = nowMap.get(keyChar);
                if (tempMap != null) {
                    nowMap = (Map) tempMap;
                } else {
                    Map<String, String> newMap = new HashMap<String, String>();
                    newMap.put("isEnd", "0");
                    nowMap.put(keyChar, newMap);
                    nowMap = newMap;
                }
                if (i == word.length() - 1) {
                    nowMap.put("isEnd", "1");
                }
            }
        }
        return wordMap;
    }

    public static String excludeWhiteWordAndReplaceSensitive(String txt, String replaceChar, Map whiteMap, Map sensitiveMap) {
        Tuple2<List<Tuple2<String, Integer>>, List<WordPosition>> tuple2 = excludeWhiteWords(txt, whiteMap);
        List<Tuple2<List<WordPosition>,String>> cleanTxt = tuple2._1().stream().map(
                s -> replaceSensitiveWord(s._1(),s._2(),replaceChar, sensitiveMap)
        ).collect(Collectors.toList());

        return getNewStr(cleanTxt.stream().map(Tuple2::_2).collect(Collectors.toList()), tuple2._2());
    }

    public static Tuple2<List<Tuple2<String,Integer>>, List<WordPosition>> excludeWhiteWords(String txt, Map whiteMap) {
        List<WordPosition> sensitiveWord = getSensitiveWord(txt, whiteMap);
        int begin = 0;
        List<Tuple2<String,Integer>> result = new ArrayList<>();
        for (WordPosition wordPosition : sensitiveWord) {
            result.add(new Tuple2<>(txt.substring(begin, wordPosition.getBeginIndex()), begin));
            begin = wordPosition.getEndIndex();
        }
        result.add(new Tuple2<>(txt.substring(begin),begin));
        return new Tuple2<>(result, sensitiveWord);
    }

    private static String getNewStr(List<String> cleanTxts, List<WordPosition> whiteWords) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cleanTxts.size(); i++) {
            builder.append(cleanTxts.get(i));
            if (whiteWords.size() > i) {
                builder.append(whiteWords.get(i).getSensitiveWord());
            }
        }
        return builder.toString();
    }

    private static Tuple2<List<WordPosition>,String> replaceSensitiveWord(String txt,int index, String replaceChar, Map wordMap) {

        String resultTxt = txt;

        // 获取所有的敏感词
        List<WordPosition> sensitiveWord = getSensitiveWord(txt, wordMap);
        Set<String> stringSet = sensitiveWord.stream().map(
                WordPosition::getSensitiveWord
        ).collect(Collectors.toSet());
        Iterator<String> iterator = stringSet.iterator();
        String word;
        String replaceString;
        while (iterator.hasNext()) {
            word = iterator.next();
            replaceString = getReplaceChars(replaceChar, word.length());
            resultTxt = resultTxt.replaceAll(StringUtils.changeRegNeedEscapeStr(word), replaceString);
        }

        return new Tuple2<>(
                sensitiveWord.stream().map(
                        wordPosition -> new WordPosition(wordPosition.getBeginIndex()+index,wordPosition.getSensitiveWord())
                ).collect(Collectors.toList()),
                resultTxt
        );
    }

    private static String getReplaceChars(String replaceChar, int length) {
        String resultReplace = replaceChar;
        for (int i = 1; i < length; i++) {
            resultReplace += replaceChar;
        }
        return resultReplace;
    }
}
