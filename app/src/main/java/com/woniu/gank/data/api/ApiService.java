package com.woniu.gank.data.api;

import com.fernandocejas.frodo.annotation.RxLogObservable;
import com.woniu.gank.data.bean.CommonBean;
import com.woniu.gank.data.bean.GankBean;
import com.woniu.gank.data.http.HttpResponse;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * @author woniu
 * @title ApiService
 * @description
 * @modifier
 * @date
 * @since 16/9/13 上午11:03
 */
public interface ApiService {

    /**
     * 分类数据: http://gank.io/api/data/数据类型/请求个数/第几页
     * •数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * •请求个数： 数字，大于0
     * •第几页：数字，大于0
     * <p>
     * 例：•http://gank.io/api/data/Android/10/1
     * •http://gank.io/api/data/福利/10/1
     * •http://gank.io/api/data/iOS/20/2
     * •http://gank.io/api/data/all/20/2
     * <p>
     * 每日数据： http://gank.io/api/day/年/月/日
     * <p>
     * 例：
     * •http://gank.io/api/day/2015/08/06
     * <p>
     * 随机数据：http://gank.io/api/random/data/分类/个数
     * •数据类型：福利 | Android | iOS | 休息视频 | 拓展资源 | 前端
     * •个数： 数字，大于0
     * <p>
     * 例：•http://gank.io/api/random/data/Android/20
     */

    String baseUrl = "http://gank.io/api/data/";

    @RxLogObservable
    @GET("all/{pageSize}/{pageNo}")
    Observable<HttpResponse<List<GankBean>>> getAll(@Path("pageSize") int pageSize, @Path("pageNo") int pageNo);

    @RxLogObservable
    @GET("Android/{pageSize}/{pageNo}")
    Observable<HttpResponse<List<CommonBean>>> getAndroid(@Path("pageSize") int pageSize, @Path("pageNo") int pageNo);

    @RxLogObservable
    @GET("iOS/{pageSize}/{pageNo}")
    Observable<HttpResponse<List<GankBean>>> getIOS(@Path("pageSize") int pageSize, @Path("pageNo") int pageNo);

    @RxLogObservable
    @GET("前端/{pageSize}/{pageNo}")
    Observable<HttpResponse<List<GankBean>>> getJs(@Path("pageSize") int pageSize, @Path("pageNo") int pageNo);

}
