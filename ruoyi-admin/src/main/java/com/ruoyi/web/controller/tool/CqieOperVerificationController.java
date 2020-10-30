package com.ruoyi.web.controller.tool;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 重工乐跑操作验证
 *
 * @author wangkang
 * @date 2020/10/29
 */
public class CqieOperVerificationController {
    private static final String Signature = "CqieRuanYun410";

    /**
     * 获得MD5验证码
     *
     * @param parameters 参数
     * @return MD5验证码
     */
    public static String generateSign(Map<String, Object> parameters) {
        try {
            List<String> names = new ArrayList<>();
            parameters.forEach((k, v) -> {
                if (v != null && !Objects.equals(v, "")
                        && !Objects.equals(k, "sign")) {
                    names.add(k);
                }
            });
            List sortedNames = names.stream().sorted().collect(Collectors.toList());
            StringBuffer sb = new StringBuffer();
            sortedNames.forEach(n ->
                    sb.append(String.format("%s=%s", n, parameters.get(n))));
            String sign = md5(sb.toString() + Signature);
            return sign;
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 加密
     *
     * @param inputString
     * @return MD5
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    private static String md5(String inputString) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(inputString.getBytes("UTF-8"));
        byte[] digest = messageDigest.digest();
        return convertByteToHex(digest);
    }

    private static String convertByteToHex(byte[] byteData) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return sb.toString();
    }
}
