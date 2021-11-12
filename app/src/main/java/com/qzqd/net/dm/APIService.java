package com.qzqd.net.dm;


import io.reactivex.Completable;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * @author zhengwenxin
 * @date 2020/2/14.
 * Email：naja2@qq.com
 * Description：
 * 版本：v0.0.1
 * 上线日期:2020/2/20
 * 安卓与后台访问的API
 */
public interface APIService {
    @Headers({
            "Content-Type: text/xml; charset=utf-8",
            "Content-Length: length",
            "SOAPAction: http://tempuri.org/Binding"
    })
    @POST("CeWenWebService1.asmx")
    Observable<ResponseBody> sendBinging(@Body String str);

    @Headers({
            "Content-Type: text/xml; charset=utf-8",
            "Content-Length: length",
            "SOAPAction: http://tempuri.org/Untying"
    })
    @POST("CeWenWebService1.asmx")
    Observable<ResponseBody> sendUntying(@Body String str);


}
