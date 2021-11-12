package com.qzqd.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhengWenxin
 * on 2020/9/14 14:44
 * Describe:
 */
public class Node {
    //"<"节点转义
    private static String toStart(String name) {
        return "<" + name + ">";
    }

    //">"节点转义
    private static String toEnd(String name) {
        return "</" + name + ">";
    }

    //请求参数拼接
    public static String getRequestParams(String namespace, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        StringBuffer sbf = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sbf.append(Node.toStart(entry.getKey()));
            sbf.append(entry.getValue());
            sbf.append(Node.toEnd(entry.getKey()));
        }


        String str = "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " +
                "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" " +
                "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <" + namespace + " xmlns=\"http://tempuri.org/\">\n" +
                sbf.toString() +
                "    </" + namespace + ">\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>";
        LogUtils.e("WEBSERVICE入参-- "+str);
        return str;
    }
}