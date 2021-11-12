# 上海麒至智能制造系统Android端


本项目采用MVP架构开发，简化安卓系统与Java后台接口数据交互。  
使用Okhttp3、Retrofit2、Rxjava2 ，AutoDispose解决RxJava内存泄漏。  


本项目使用的第三方库:  
    implementation fileTree(dir: 'libs', include: ['*.jar'])  
    implementation 'com.android.support:appcompat-v7:27.1.1'  
    implementation 'com.android.support:support-v4:27.1.1'  
    implementation 'com.android.support:design:27.1.1'  
    androidTestImplementation group: 'junit', name: 'junit', version: '4.+'  
    androidTestImplementation 'com.android.support.test:runner:1.0.2'  
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'  
    //butterknife view注入框架  
    implementation 'com.jakewharton:butterknife:8.8.1'  
    annotationProcessor 'com.jakewharton:butterknife-compiler:8.8.1'  
    //okhttp3 网络请求框架  
    implementation 'com.squareup.okhttp3:okhttp:3.10.0'  
    implementation "com.squareup.okhttp3:logging-interceptor:3.10.0"  
    //retrofit2 网络请求适配器框架  
    implementation 'com.squareup.retrofit2:retrofit:2.4.0'  
    implementation 'com.squareup.retrofit2:converter-gson:2.4.0'  
    implementation 'com.squareup.retrofit2:adapter-rxjava2:2.4.0'  
    //rxjava2 异步开发框架  
    implementation "io.reactivex.rxjava2:rxjava:2.1.examplepic"  
    implementation 'io.reactivex.rxjava2:rxandroid:2.0.2'  
    //AutoDispose解决RxJava内存泄漏  
    implementation 'com.uber.autodispose:autodispose:0.7.0'  
    implementation 'com.uber.autodispose:autodispose-android:0.7.0'  
    implementation 'com.uber.autodispose:autodispose-android-archcomponents:0.7.0'  
    //Material-dialogs  
    implementation 'com.afollestad.material-dialogs:core:0.9.6.0'  
    //jetbrains 注解  
    implementation 'org.jetbrains:annotations-java5:15.0'  
    implementation 'com.android.support.constraint:constraint-layout:1.1.3'  
    implementation 'com.orhanobut:logger:2.2.0' //Logger日志框架  
    implementation 'org.aspectj:aspectjrt:1.8.9'//在安卓上进行AOP编程依赖的Aspectj包  
    implementation 'com.google.code.gson:gson:2.8.5'  
    implementation 'android.arch.work:work-runtime:1.0.1'//Gson解析json框架  
    //zxing google  
    implementation files('libs/zxing-3.2.1.jar')  
    implementation 'com.journeyapps:zxing-android-embedded:3.0.2@aar'  
    implementation 'com.github.bumptech.glide:glide:4.8.0'  
    annotationProcessor 'com.github.bumptech.glide:compiler:4.8.0'  
