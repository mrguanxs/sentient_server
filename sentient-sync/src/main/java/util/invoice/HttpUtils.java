//package util.invoice;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.io.UnsupportedEncodingException;
//import java.net.ConnectException;
//import java.net.SocketTimeoutException;
//import java.net.URL;
//import java.net.URLConnection;
//import java.nio.charset.StandardCharsets;
//import java.security.KeyManagementException;
//import java.security.NoSuchAlgorithmException;
//import java.security.cert.CertificateException;
//import java.security.cert.X509Certificate;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.UUID;
//
//import javax.net.ssl.HostnameVerifier;
//import javax.net.ssl.HttpsURLConnection;
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLSession;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;
//
//import nc.bs.framework.common.RuntimeEnv;
//import nc.jdbc.framework.processor.MapListProcessor;
//import nc.vo.cache.CacheManager;
//import nc.vo.cache.ICache;
//import nc.vo.cache.config.CacheConfig;
//import nc.vo.cache.config.CacheConfig.MemoryCacheLevel;
//import nc.vo.cache.exception.CacheException;
//import nc.vo.pub.BusinessException;
//import nc.vo.pubapp.AppContext;
//import nc.vo.pubapp.pattern.exception.ExceptionUtils;
//import net.sf.json.JSONObject;
//
//import org.apache.commons.lang.StringUtils;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
//import org.apache.http.ParseException;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.conn.scheme.Scheme;
//import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
//import org.apache.http.conn.ssl.SSLSocketFactory;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.protocol.HTTP;
//import org.apache.http.util.EntityUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * ͨ��http���ͷ���
// *
// * @author ruoyi
// */
//public class HttpUtils {
//    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);
//
//    /**
//     * ��ָ�� URL ����GET����������
//     *
//     * @param url ��������� URL
//     * @return ����Զ����Դ����Ӧ���
//     */
//    public static String sendGet(String url) {
//        return HttpUtils.sendGet(url, "");
//    }
//
//    /**
//     * ��ָ�� URL ����GET����������
//     *
//     * @param url ��������� URL
//     * @param param ��������������Ӧ���� name1=value1&name2=value2 ����ʽ��
//     * @return ����Զ����Դ����Ӧ���
//     */
//    public static String sendGet(String url, String param) {
//        return HttpUtils.sendGet(url, param, "UTF-8");
//    }
//
//    /**
//     * ��ָ�� URL ����GET����������
//     *
//     * @param url ��������� URL
//     * @param param ��������������Ӧ���� name1=value1&name2=value2 ����ʽ��
//     * @param contentType ��������
//     * @return ����Զ����Դ����Ӧ���
//     */
//    public static String sendGet(String url, String param, String contentType) {
//        StringBuilder result = new StringBuilder();
//        BufferedReader in = null;
//        try {
//            String urlNameString = StringUtils.isNotBlank(param) ? url + "?" + param : url;
//            HttpUtils.log.info("sendGet - {}", urlNameString);
//            URL realUrl = new URL(urlNameString);
//            URLConnection connection = realUrl.openConnection();
//            connection.setRequestProperty("accept", "*/*");
//            connection.setRequestProperty("connection", "Keep-Alive");
//            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            connection.connect();
//            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), contentType));
//            String line;
//            while ((line = in.readLine()) != null) {
//                result.append(line);
//            }
//            HttpUtils.log.info("recv - {}", result);
//        }
//        catch (ConnectException e) {
//            HttpUtils.log.error("����HttpUtils.sendGet ConnectException, url=" + url + ",param=" + param, e);
//        }
//        catch (SocketTimeoutException e) {
//            HttpUtils.log.error("����HttpUtils.sendGet SocketTimeoutException, url=" + url + ",param=" + param, e);
//        }
//        catch (IOException e) {
//            HttpUtils.log.error("����HttpUtils.sendGet IOException, url=" + url + ",param=" + param, e);
//        }
//        catch (Exception e) {
//            HttpUtils.log.error("����HttpsUtil.sendGet Exception, url=" + url + ",param=" + param, e);
//        }
//        finally {
//            try {
//                if (in != null) {
//                    in.close();
//                }
//            }
//            catch (Exception ex) {
//                HttpUtils.log.error("����in.close Exception, url=" + url + ",param=" + param, ex);
//            }
//        }
//        return result.toString();
//    }
//
//    /**
//     * ��ָ�� URL ����POST����������
//     *
//     * @param url ��������� URL
//     * @param param ��������������Ӧ���� name1=value1&name2=value2 ����ʽ��
//     * @return ����Զ����Դ����Ӧ���
//     */
//    public static String sendPost(String url, String param) {
//        PrintWriter out = null;
//        BufferedReader in = null;
//        StringBuilder result = new StringBuilder();
//        try {
//            HttpUtils.log.info("sendPost - {}", url);
//            URL realUrl = new URL(url);
//            URLConnection conn = realUrl.openConnection();
//            conn.setRequestProperty("accept", "*/*");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            conn.setRequestProperty("Accept-Charset", "utf-8");
//            conn.setRequestProperty("contentType", "utf-8");
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
//            out = new PrintWriter(conn.getOutputStream());
//            out.print(param);
//            out.flush();
//            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
//            String line;
//            while ((line = in.readLine()) != null) {
//                result.append(line);
//            }
//            HttpUtils.log.info("recv - {}", result);
//        }
//        catch (ConnectException e) {
//            HttpUtils.log.error("����HttpUtils.sendPost ConnectException, url=" + url + ",param=" + param, e);
//        }
//        catch (SocketTimeoutException e) {
//            HttpUtils.log.error("����HttpUtils.sendPost SocketTimeoutException, url=" + url + ",param=" + param, e);
//        }
//        catch (IOException e) {
//            HttpUtils.log.error("����HttpUtils.sendPost IOException, url=" + url + ",param=" + param, e);
//        }
//        catch (Exception e) {
//            HttpUtils.log.error("����HttpsUtil.sendPost Exception, url=" + url + ",param=" + param, e);
//        }
//        finally {
//            try {
//                if (out != null) {
//                    out.close();
//                }
//                if (in != null) {
//                    in.close();
//                }
//            }
//            catch (IOException ex) {
//                HttpUtils.log.error("����in.close Exception, url=" + url + ",param=" + param, ex);
//            }
//        }
//        return result.toString();
//    }
//
//    public static String sendSSLPost(String url, String param) {
//        StringBuilder result = new StringBuilder();
//        String urlNameString = url + "?" + param;
//        try {
//            HttpUtils.log.info("sendSSLPost - {}", urlNameString);
//            SSLContext sc = SSLContext.getInstance("SSL");
//            sc.init(null, new TrustManager[] {
//                new TrustAnyTrustManager()
//            }, new java.security.SecureRandom());
//            URL console = new URL(urlNameString);
//            HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();
//            conn.setRequestProperty("accept", "*/*");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            conn.setRequestProperty("Accept-Charset", "utf-8");
//            conn.setRequestProperty("contentType", "utf-8");
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
//
//            conn.setSSLSocketFactory(sc.getSocketFactory());
//            conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
//            conn.connect();
//            InputStream is = conn.getInputStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
//            String ret = "";
//            while ((ret = br.readLine()) != null) {
//                if (ret != null && !"".equals(ret.trim())) {
//                    result.append(new String(ret.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
//                }
//            }
//            HttpUtils.log.info("recv - {}", result);
//            conn.disconnect();
//            br.close();
//        }
//        catch (ConnectException e) {
//            HttpUtils.log.error("����HttpUtils.sendSSLPost ConnectException, url=" + url + ",param=" + param, e);
//        }
//        catch (SocketTimeoutException e) {
//            HttpUtils.log.error("����HttpUtils.sendSSLPost SocketTimeoutException, url=" + url + ",param=" + param, e);
//        }
//        catch (IOException e) {
//            HttpUtils.log.error("����HttpUtils.sendSSLPost IOException, url=" + url + ",param=" + param, e);
//        }
//        catch (Exception e) {
//            HttpUtils.log.error("����HttpsUtil.sendSSLPost Exception, url=" + url + ",param=" + param, e);
//        }
//        return result.toString();
//    }
//
//    private static class TrustAnyTrustManager implements X509TrustManager {
//        @Override
//        public void checkClientTrusted(X509Certificate[] chain, String authType) {
//        }
//
//        @Override
//        public void checkServerTrusted(X509Certificate[] chain, String authType) {
//        }
//
//        @Override
//        public X509Certificate[] getAcceptedIssuers() {
//            return new X509Certificate[] {};
//        }
//    }
//
//    private static class TrustAnyHostnameVerifier implements HostnameVerifier {
//        @Override
//        public boolean verify(String hostname, SSLSession session) {
//            return true;
//        }
//    }
//
//
//
//
//    public static HttpClient getHttpClient() {
//        HttpClient httpClient = new DefaultHttpClient(); // ����Ĭ�ϵ�httpClientʵ��
//        X509TrustManager xtm = new X509TrustManager() { // ����TrustManager
//                    @Override
//                    public void checkClientTrusted(X509Certificate[] chain, String authType)
//                            throws CertificateException {
//                    }
//
//                    @Override
//                    public void checkServerTrusted(X509Certificate[] chain, String authType)
//                            throws CertificateException {
//                    }
//
//                    @Override
//                    public X509Certificate[] getAcceptedIssuers() {
//                        return null;
//                    }
//                };
//
//        // TLS1.0��SSL3.0����û��̫��Ĳ�𣬿ɴ������ΪTLS��SSL�ļ̳��ߣ�������ʹ�õ�����ͬ��SSLContext
//        // SSLContext ctx = SSLContext.getInstance("TLS");
//        try {
//            SSLContext ctx = SSLContext.getInstance("TLSv1.2");
//            // ʹ��TrustManager����ʼ���������ģ�TrustManagerֻ�Ǳ�SSL��Socket��ʹ��
//            ctx.init(null, new TrustManager[] {
//                xtm
//            }, null);
//
//            // ����SSLSocketFactory
//            SSLSocketFactory socketFactory = new SSLSocketFactory(ctx);
//            SSLSocketFactory.getSocketFactory().setHostnameVerifier(new AllowAllHostnameVerifier());
//            // ͨ��SchemeRegistry��SSLSocketFactoryע�ᵽ���ǵ�HttpClient��
//            httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", 443, socketFactory));
//        }
//        catch (KeyManagementException e) {
//            ExceptionUtils.wrappException(e);
//        }
//        catch (NoSuchAlgorithmException e) {
//            ExceptionUtils.wrappException(e);
//        }
//        return httpClient;
//    }
//
//    public static HttpPost getHttpPost(String reqURL, String json) {
//        // ����HttpPost
//        HttpPost httpPost = new HttpPost(reqURL);
//        httpPost.setHeader("Content-Type", "application/json");
//        httpPost.setHeader("Connection", "keep-alive");
//
//        if (StringUtils.isNotBlank(json)) {
//            httpPost.setEntity(new StringEntity(json, "utf-8"));
//        }
//        return httpPost;
//    }
//
//    public static String postSSL(String url, Map<String, String> headers, Map<String, Object> params) {
//        long responseLength = 0; // ��Ӧ����
//        String responseContent = null; // ��Ӧ����
//        HttpClient httpClient = HttpUtils.getHttpClient(); // ����Ĭ�ϵ�httpClientʵ��
//        HttpPost httpPost = new HttpPost(url);
//        httpPost.setHeader("Content-Type", "application/json");
//        httpPost.setHeader("Connection", "keep-alive");
//        RequestConfig requestConfig =
//                RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(5000).setSocketTimeout(5000)
//                        .build();
//        httpPost.setConfig(requestConfig);
//        if (null != headers) {
//            for (Map.Entry<String, String> entry : headers.entrySet()) {
//                httpPost.addHeader(entry.getKey(), entry.getValue());
//            }
//        }
//        List<BasicNameValuePair> nvps = new LinkedList<BasicNameValuePair>();
//        if (null != params) {
//            Set<String> keySet = params.keySet();
//            for (String key : keySet) {
//                nvps.add(new BasicNameValuePair(key, params.get(key).toString()));
//            }
//        }
//        try {
//            httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
//            HttpResponse response = httpClient.execute(httpPost); // ִ��POST����
//            HttpEntity entity = response.getEntity(); // ��ȡ��Ӧʵ��
//            if (null != entity) {
//                responseLength = entity.getContentLength();
//                responseContent = EntityUtils.toString(entity, "UTF-8");
//                EntityUtils.consume(entity); // Consume response content
//            }
//        }
//        catch (IOException e) {
//            ExceptionUtils.wrappException(e);
//        }
//        return responseContent;
//    }
//
//    private static final String CLIENT_ID = "ichengjian_server";
//    private static final String CLIENT_SECRET = "e6c574fe1ff443a8996387849174565e";
//    //测试
////    private static final String PARAMS_SIGN_KEY = "286KUGyuIUgJHMhv7iIYvkWHeoW";
//    private static final String PARAMS_SIGN_KEY = " 876dUdSuIwUeJhUhBVGvBNJ";
////    测试
////    private static final String NC_BASE_URL = "http://ii.bucg.com";
////    private static final String NC_BASE_URL = "https://ms.bucg.com";
//    private static final String NC_BASE_URL = "http://localhost:9999";
//    private static final String CLIENT_ACCESS_TOKEN_CACHE_KEY = "CJCLIENT_ACCESS_TOKEN_CACHE_KEY";
//
//    public static String innerPostJsonRequest(String reqURL, Map<String, Object> paramMap) {
//    	return innerPostJsonRequest(reqURL, paramMap, null);
//    }
//    @SuppressWarnings("deprecation")
//	public static String innerPostJsonRequest(String reqURL, Map<String, Object> paramMap, Integer timeout) {
//        String responseContent = null;
//        HttpClient httpClient = HttpUtils.getHttpClient();
//        try {
//            HttpPost httpPost = HttpUtils.getHttpPost(reqURL, JSONObject.fromObject(paramMap).toString());
//            if(timeout != null){
//            	if (timeout < 5000) {
//                    timeout = 5000;
//                }
//            	 RequestConfig requestConfig =
//                         RequestConfig.custom().setConnectTimeout(timeout).setConnectionRequestTimeout(timeout)
//                                 .setSocketTimeout(timeout).build();
//            	 httpPost.setConfig(requestConfig);
//            }
//            String accessToken = getCacheAccessToken();
//            Map<String, String> headers = getHeaders(accessToken, paramMap);
//            for (String key : headers.keySet()) {
//                httpPost.addHeader(key, headers.get(key));
//            }
//
//            HttpResponse response = httpClient.execute(httpPost);
//            HttpEntity entity = response.getEntity();
//
//            if (null != entity) {
//                responseContent = EntityUtils.toString(entity, "UTF-8");
//                EntityUtils.consume(entity);
//            }
//        } catch (ParseException | IOException e) {
//            ExceptionUtils.wrappException(e);
//        } finally {
//            httpClient.getConnectionManager().shutdown();
//        }
//        return responseContent;
//    }
//
//    public static String getCacheAccessToken() {
//        // 1Сʱ֮���Զ�ˢ�£����ӻ�����Ƽ������� ��
//        long flushInterval = 60 * 60 * 1000;
//        ICache cache = null;
//        if (RuntimeEnv.getInstance().isRunningInServer()) {
//            CacheConfig config = new CacheConfig(CLIENT_ACCESS_TOKEN_CACHE_KEY, false, flushInterval, 10, CacheConfig.CacheType.LRU, MemoryCacheLevel.STRONG);
//            cache = CacheManager.getInstance().getCache(config);
//        }else {
//            CacheConfig config = new CacheConfig(CLIENT_ACCESS_TOKEN_CACHE_KEY, false, flushInterval, 10, CacheConfig.CacheType.DYNAMIC_FILE, MemoryCacheLevel.STRONG);
//            cache = CacheManager.getInstance().getCache(config);
//        }
//
//        String accessToken = (String) cache.get("access_token");
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        if (StringUtils.isEmpty(accessToken)) {
//        	JSONObject tokenInfoJo = getTokenInfoJO();
//
//        	cache.put("access_token", tokenInfoJo.get("access_token"));
//        	cache.put("expires_in", tokenInfoJo.get("expires_in"));
//        	Date now = new Date();
//        	String beginTime = dateFormat.format(now);
//        	cache.put("beginTime", beginTime);
//
//        } else{
//        	//���ڴ���
//        	try {
//        		Integer expires_in = (Integer)cache.get("expires_in");
//				Date beginDate = dateFormat.parse((String)cache.get("beginTime"));
//				Calendar calendar = Calendar.getInstance();
//				calendar.setTime(beginDate);
//				calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND)+expires_in - 300);
//				Date endTime = calendar.getTime();
//				if(endTime.compareTo(new Date())<0){
//					JSONObject tokenInfoJo = getTokenInfoJO();
//
//		        	cache.put("access_token", tokenInfoJo.get("access_token"));
//		        	cache.put("expires_in", tokenInfoJo.get("expires_in"));
//		        	Date now = new Date();
//		        	String beginTime = dateFormat.format(now);
//		        	cache.put("beginTime", beginTime);
//				}
//
//			} catch (CacheException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (java.text.ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//        }
//        return (String)cache.get("access_token");
//    }
//
//	private static JSONObject getTokenInfoJO(){
//    	String tokenResult = getClientAccessToken();
//    	JSONObject jo = JSONObject.fromObject(tokenResult);
//    	Object resultData = jo.get("resultdata");
//    	JSONObject resultDataJo = JSONObject.fromObject(resultData);
//    	Object tokenInfo = resultDataJo.get("tokenInfo");
//    	JSONObject tokenInfoJo = JSONObject.fromObject(tokenInfo);
//    	return tokenInfoJo;
//    }
//
//    /**
//     * ��ȡtoken
//     * @return {"resultcode":0,"success":true,"resultdata":{"tokenInfo":{"access_token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsib2F1dGgiXSwic2NvcGUiOlsiYWxsIl0sImV4cCI6MTY4NTU2MjU3NywianRpIjoiMjdhZWNjZDUtZmQ1Mi00OTgzLWJlZDktNTg0MjgyNjZkYjhlIiwiY2xpZW50X2lkIjoiY2xpZW50XzIifQ.ZKrH1nR-vM-O1dCj22UEL7FObnuy5zii_2cIlGFw-DE","token_type":"bearer","expires_in":43199,"scope":"all","jti":"27aeccd5-fd52-4983-bed9-58428266db8e"},"ts":"2023-05-31 15:49:37"},"msg":"�û���¼��֤�ɹ�"}
//     * */
//    public static String getClientAccessToken() {
//        String responseContent = null;
//        HttpClient httpClient = HttpUtils.getHttpClient();
//        try {
//            StringBuilder urlBuilder = new StringBuilder(NC_BASE_URL);
//            urlBuilder.append("/oauth2/oauth/token");
//            //HttpPost
//            HttpPost httpPost = new HttpPost(urlBuilder.toString());
//            HashMap<String, Object> paramMap = new HashMap<>();
//            paramMap.put("grant_type", "client_credentials");
//            paramMap.put("scope", "all");
//            paramMap.put("client_id", CLIENT_ID);
//            paramMap.put("client_secret", CLIENT_SECRET);
//            //����header
//            Map<String, String> headers = getHeaders("", paramMap);
//            for (Map.Entry<String, String> entry : headers.entrySet()) {
//                httpPost.setHeader(entry.getKey(),entry.getValue());
//            }
//            //��֯�������
//            List<NameValuePair> paramList = new ArrayList <NameValuePair>();
//            if(paramMap != null && paramMap.size() > 0){
//                Set<String> keySet = paramMap.keySet();
//                for(String key : keySet) {
//                    paramList.add(new BasicNameValuePair(key, paramMap.get(key).toString()));
//                }
//            }
//            httpPost.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
//
//            HttpResponse response = httpClient.execute(httpPost);
//            HttpEntity entity = response.getEntity();
//
//            if (null != entity) {
//                responseContent = EntityUtils.toString(entity, "UTF-8");
//                EntityUtils.consume(entity);
//            }
//        } catch (ParseException | IOException e) {
//            ExceptionUtils.wrappException(e);
//        } finally {
//            httpClient.getConnectionManager().shutdown();
//        }
//        return responseContent;
//    }
//
//    private static Map<String, String> getHeaders(String accessToken, Map<String, Object> paramMap){
//        String timestamp = System.currentTimeMillis() + "";
//        String rid = UUID.randomUUID().toString();
//        StringBuilder suffixSb = new StringBuilder();
//        suffixSb.append(accessToken).append("&").append(timestamp).append("&").append(CLIENT_ID).append("&").append(rid).append("&").append(PARAMS_SIGN_KEY);
//        String sign = SignUtils.sign(paramMap, suffixSb.toString());
//
//        HashMap<String, String> headers = new HashMap<>();
//        headers.put("timestamp", timestamp);
//        headers.put("rid", rid);
//        headers.put("clientId", CLIENT_ID);
//        headers.put("sign", sign);
//        if(StringUtils.isNotBlank(accessToken)) {
//            headers.put("Authorization", "bearer " + accessToken);
//        }
//
//        return headers;
//    }
//
//
//    public static void main(String[] args){
//    	String cacheAccessToken = getCacheAccessToken();
//    	System.out.println(cacheAccessToken);
////
////    	String url = NC_BASE_URL + "/file/expenses/queryInvoiceFolderPicInfos";
////
////        HashMap<String, Object> paramsMap = new HashMap<>();
////        paramsMap.put("attchstype", "invoice");
////        paramsMap.put("businesstype", "query");
////        paramsMap.put("data", "{\"1001A4100000009STSNV\":\"2023-05-30 11:24:49\"}");
////
////
////        String s = innerPostJsonRequest(url, paramsMap);
////        System.out.println(s);
//    }
//}
