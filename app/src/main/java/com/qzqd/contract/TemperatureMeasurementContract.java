//package com.qzqd.contract;
//
//import com.qzqd.base.BaseView;
//
//import io.reactivex.Observable;
//import okhttp3.ResponseBody;
//
///**
// * Created by ZhengWenxin
// * on 2020/9/14 10:33
// * Describe:
// */
//public class TemperatureMeasurementContract {
//    public interface Model {
//        Observable<ResponseBody> sendBinging(String pondNO,String tagNO);
//    }
//
//    public interface View extends BaseView {
//        @Override
//        void showLoading();
//
//        @Override
//        void hideLoading();
//
//        @Override
//        void onError(Throwable throwable);
//
//        void onSuccess(ResponseBody bean);
//
//    }
//
//    interface Presenter {
//        /**
//         *
//         */
//        void sendBinging(String pondNO,String tagNO);
//
//
//    }
//}
