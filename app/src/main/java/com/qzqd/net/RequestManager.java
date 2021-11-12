//package com.qzqd.net;
//
//import com.qzqd.net.dm.APIService;
//
//import org.simpleframework.xml.Serializer;
//import org.simpleframework.xml.convert.AnnotationStrategy;
//import org.simpleframework.xml.core.Persister;
//import org.simpleframework.xml.strategy.Strategy;
//
//import java.util.concurrent.TimeUnit;
//
//import okhttp3.OkHttpClient;
//import retrofit2.Retrofit;
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
//import retrofit2.converter.gson.GsonConverterFactory;
//import retrofit2.converter.scalars.ScalarsConverterFactory;
//import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
//
///**
// * Created by ZhengWenxin
// * on 2020/9/14 11:58
// * Describe:
// */
//public class RequestManager {
//    public final static int CONNECT_TIMEOUT = 10;
//    public final static int READ_TIMEOUT = 20;
//    public final static int WRITE_TIMEOUT = 10;
//
//    private final String WEBSERVICE_URL2  = "http://10.10.201.56:8081/";//webservice请求地址 今世缘内网地址
//    private final String WEBSERVICE_URL  = "http://192.168.1.108:8087/";//webservice请求地址
//
//    public Retrofit mRetrofit;
//
//    private static RequestManager mRequestManager;//管理者实例
//    public OkHttpClient mClient;//OkHttpClient实例
//    public APIService mServiceStore;//请求接口
//    private RequestManager() {
//        init();
//    }
//    //单例模式，对提供管理者实例
//    public static RequestManager getInstance() {
//        if (mRequestManager == null) {
//            synchronized (RequestManager.class) {
//                if (mRequestManager == null) {
//                    mRequestManager = new RequestManager();
//                }
//            }
//        }
//        return mRequestManager;
//    }
//    private void init(){
//        Strategy strategy = new AnnotationStrategy();
//        Serializer serializer = new Persister(strategy);
//        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS);
//        builder.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS);
//        builder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS);
//        builder.retryOnConnectionFailure(true);
//        mClient = builder.build();
//        mRetrofit = new Retrofit.Builder()
//                .baseUrl(WEBSERVICE_URL)
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
//                .client(mClient)
//                .build();
//        mServiceStore=mRetrofit.create(APIService.class);
//    }
//
//    public interface onRequestCallBack{
//        void onSuccess(String msg);
//        void onError(String msg);
//    }
//
//}
