package com.wangxingxing.videocollectionscompose

import com.btpj.lib_base.base.BaseAppViewModel
import com.wangxingxing.videocollectionscompose.logic.data.bean.User
import com.wangxingxing.videocollectionscompose.logic.data.local.UserManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * author : 王星星
 * date : 2025/4/29 16:25
 * email : 1099420259@qq.com
 * description : App全局ViewModel可直接替代EventBus
 */
class AppViewModel : BaseAppViewModel() {

    /** 全局用户 */
    private val _user = MutableStateFlow(UserManager.getUser())
    val user: StateFlow<User?> = _user

}