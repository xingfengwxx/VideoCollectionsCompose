package com.wangxingxing.videocollectionscompose.navigation

import com.btpj.lib_base.base.BaseViewModel
import com.wangxingxing.videocollectionscompose.logic.data.local.CacheManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * author : 王星星
 * date : 2025/4/14 17:01
 * email : 1099420259@qq.com
 * description :
 */
@HiltViewModel
class AppScreenViewModel @Inject constructor() : BaseViewModel<Unit>() {

    private val _isFirstUse = MutableStateFlow(CacheManager.isFirstUse())
    val isFirstUse: StateFlow<Boolean> = _isFirstUse.asStateFlow()

    private val _showSplash = MutableStateFlow(true)
    val showSplash = _showSplash.asStateFlow()

    fun emitFirstUse(isFirstUse: Boolean) {
        _isFirstUse.value = isFirstUse
        CacheManager.saveFirstUse(isFirstUse)
    }

    fun emitShowSplash(showSplash: Boolean) {
        _showSplash.value = showSplash
    }
}