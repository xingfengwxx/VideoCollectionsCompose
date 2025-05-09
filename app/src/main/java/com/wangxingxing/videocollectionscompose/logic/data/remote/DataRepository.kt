package com.wangxingxing.videocollectionscompose.logic.data.remote

import com.btpj.lib_base.data.bean.ApiResponse
import com.btpj.lib_base.http.RetrofitManager
import com.wangxingxing.videocollectionscompose.logic.data.bean.Discovery

/**
 * author : 王星星
 * date : 2025/5/9 9:44
 * email : 1099420259@qq.com
 * description : 数据仓库
 */
object DataRepository : Api {

    private val service by lazy { RetrofitManager.getService(Api::class.java)}

    override suspend fun getDiscovery(): ApiResponse<Discovery> {
        return service.getDiscovery()
    }
}