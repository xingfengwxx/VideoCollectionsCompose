package com.wangxingxing.videocollectionscompose.ui.main.home.discovery

import com.btpj.lib_base.base.BaseViewModel
import com.wangxingxing.videocollectionscompose.logic.data.bean.Discovery
import com.wangxingxing.videocollectionscompose.logic.data.remote.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * author : 王星星
 * date : 2025/5/9 9:23
 * email : 1099420259@qq.com
 * description :
 */
@HiltViewModel
class DiscoveryViewModel @Inject constructor() : BaseViewModel<List<Discovery.Item>>() {

    private val _discoveryData = MutableStateFlow(Discovery(listOf(), 0, 0, "", false))
    val discoveryData = _discoveryData.asStateFlow()

    fun fetchDiscoveryData() {
        launch ({
            _discoveryData.value = DataRepository.getDiscovery()
            emitUiState(false)
        })
    }
}