package com.wangxingxing.videocollectionscompose

import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.Utils
import com.btpj.lib_base.BaseApp
import com.btpj.lib_base.BuildConfig
import com.tencent.bugly.Bugly
import com.wangxingxing.wanandroidcompose.Const
import dagger.hilt.android.HiltAndroidApp

/**
 * author : 王星星
 * date : 2025/4/29 16:17
 * email : 1099420259@qq.com
 * description :
 */
@HiltAndroidApp
class App : BaseApp() {

    companion object {
        const val TAG = "wxx"

        lateinit var appViewModel: AppViewModel

        lateinit var instance: App
            private set

        fun isDebug() = BuildConfig.DEBUG
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        appViewModel = getAppViewModelProvider()[AppViewModel::class.java]

        // bugly初始化
        Bugly.init(applicationContext, Const.Config.BUGLY_APP_ID, false)

        initLog()
    }

    private fun initLog() {
        Utils.init(instance)
        LogUtils.getConfig()
            .setLogSwitch(isDebug())
            .setGlobalTag(TAG)
            .setBorderSwitch(true)
    }
}