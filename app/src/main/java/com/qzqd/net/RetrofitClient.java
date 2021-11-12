//package com.qzqd.net;
//
//
//import androidx.annotation.NonNull;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.qzqd.net.dm.APIService;
//import com.qzqd.util.LoginUserUtilsSP;
//
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
//import okhttp3.Interceptor;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//import okhttp3.logging.HttpLoggingInterceptor;
//import retrofit2.Retrofit;
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
//import retrofit2.converter.gson.GsonConverterFactory;
//
///**
// * @author zhengwenxin
// * @date 2020/2/14.
// * Email：naja2@qq.com
// * Description：
// * Retrofit 网络请求类
// */
//public class RetrofitClient {
//
//    private static volatile RetrofitClient instance;
//    private APIService apiService;
//    private String baseUrl  = "http://193.168.25.125:8201/";//珀莱雅
//    private String url = "http://39.104.201.97:8201/";//公网
//
//    private RetrofitClient() {
//    }
//
//    public static RetrofitClient getInstance() {
//        if (instance == null) {
//            synchronized (RetrofitClient.class) {
//                if (instance == null) {
//                    instance = new RetrofitClient();
//                }
//            }
//        }
//        return instance;
//    }
//
//    /**
//     * 设置Header
//     *
//     * @return
//     */
//    private Interceptor getHeaderInterceptor() {
//        return new Interceptor() {
//            @Override
//            public Response intercept(@NonNull Chain chain) throws IOException {
//                String token = "";
//                token = LoginUserUtilsSP.getToken();
//
//                Request original = chain.request();
//                Request.Builder requestBuilder = original.newBuilder()
//                        .header("token", token)
//                        .header("content-type","application/json;charset=UTF-8");
//                Request request = requestBuilder.build();
//                return chain.proceed(request);
//            }
//        };
//    }
//
//    /**
//     * 设置拦截器
//     *
//     * @return
//     */
//    private Interceptor getInterceptor() {
//
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//
//        //显示日志
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        return interceptor;
//    }
//
//    public APIService getApi() {
//        //初始化一个client,不然retrofit会自己默认添加一个
////        OkHttpClient client = new OkHttpClient().newBuilder()
////                //设置Header
////                .addInterceptor(getHeaderInterceptor())
////                //设置拦截器
////                .addInterceptor(getInterceptor())
////                .build();
//        OkHttpClient client = new OkHttpClient.Builder()
//                .addInterceptor(getHeaderInterceptor())
//                .addInterceptor(getInterceptor())
//                .connectTimeout(60, TimeUnit.SECONDS)
//                .readTimeout(60, TimeUnit.SECONDS)
//                .build();
//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .create();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .client(client)
//                //设置网络请求的Url地址
//                .baseUrl(baseUrl)
//                //设置数据解析器
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                //设置网络请求适配器，使其支持RxJava与RxAndroid
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();
//        //创建—— 网络请求接口—— 实例
//        apiService = retrofit.create(APIService.class);
//        return apiService;
//    }
//
//
//}
