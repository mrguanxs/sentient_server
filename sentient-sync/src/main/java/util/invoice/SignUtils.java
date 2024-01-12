//package util.invoice;
//
//import org.apache.commons.codec.digest.DigestUtils;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.util.StringUtils;
//
//import java.util.*;
//
///**
// * @author guan
// * @date 2023/4/6
// */
//public class SignUtils {
//
//    public static String sign(Map<String, Object> paramMap, String suffixParam) {
//        String paramString = suffixParam;
//        if (paramMap != null && paramMap.size() > 0) {
//            SortedMap<String, Object> sortedMap = sortMap(paramMap);
//            paramString = buildParamString(sortedMap) + suffixParam;
//        }
//
//        String signString = DigestUtils.md5Hex(paramString.getBytes()).toUpperCase();
//        return signString;
//    }
//
//    private static SortedMap<String, Object> sortMap(Map<String, Object> paramMap) {
//        SortedMap<String, Object> result = new TreeMap();
//        if (paramMap != null) {
//            Iterator var2 = paramMap.entrySet().iterator();
//
//            while(var2.hasNext()) {
//                Map.Entry entry = (Map.Entry)var2.next();
//                result.put(entry.getKey().toString(), entry.getValue());
//            }
//        }
//
//        return result;
//    }
//
//    private static String buildParamString(Map<String, Object> paramMap) {
//        StringBuilder sb = new StringBuilder();
//        Iterator var2 = paramMap.entrySet().iterator();
//        while(var2.hasNext()) {
//            Map.Entry<String, Object> entry = (Map.Entry)var2.next();
//            if (!StringUtils.isEmpty(entry.getKey()) && entry.getValue() != null && !StringUtils.isEmpty(entry.getValue().toString())) {
//                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
//            }
//        }
//        return sb.toString();
//    }
//}
