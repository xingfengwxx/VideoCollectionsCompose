package com.wangxingxing.videocollectionscompose.logic.data.remote

import com.btpj.lib_base.data.bean.ApiResponse
import com.wangxingxing.videocollectionscompose.logic.data.bean.Discovery
import retrofit2.http.GET

/**
 * author : 王星星
 * date : 2025/5/9 9:33
 * email : 1099420259@qq.com
 * description :
 */
interface Api {

    /**
     * 首页-发现列表
     */
    @GET("api/v7/index/tab/discovery")
    suspend fun getDiscovery(): ApiResponse<Discovery>

}