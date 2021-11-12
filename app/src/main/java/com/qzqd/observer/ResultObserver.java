//package com.qzqd.observer;
//
//import com.qzqd.net.RequestManager;
//
//import java.io.IOException;
//
//import io.reactivex.Observer;
//import io.reactivex.annotations.NonNull;
//import io.reactivex.disposables.Disposable;
//import okhttp3.ResponseBody;
//
///**
// * Created by ZhengWenxin
// * on 2020/9/14 14:43
// * Describe:
// */
//public class ResultObserver implements Observer<ResponseBody> {
//    private RequestManager.onRequestCallBack callBack;
//    public ResultObserver( RequestManager.onRequestCallBack callBack){
//        this.callBack=callBack;
//    }
//
//    @Override
//    public void onSubscribe(@NonNull Disposable d) {
//
//    }
//
//    @Override
//    public void onNext(@NonNull ResponseBody responseBody) {
//
//        try {
//            String res = responseBody.string();
//            if (res == null) {
//                callBack.onError("请求发生未知错误");
//                return;
//            }
//            callBack.onSuccess(res);
////            if (res.contains("{") && res.contains("}")) {
////                int startIndex = res.indexOf("{");
////                int endIndex = res.lastIndexOf("}") + 1;
////                String json = res.substring(startIndex, endIndex);
////                callBack.onSuccess(json);
////            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            callBack.onError(e.toString());
//        }
//    }
//
//    @Override
//    public void onError(@NonNull Throwable e) {
//        callBack.onError(e.toString());
//    }
//    @Override
//    public void onComplete() {
//
//    }
//}
