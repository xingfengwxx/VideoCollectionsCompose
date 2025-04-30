package com.wangxingxing.videocollectionscompose.ui

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.blankj.utilcode.util.ToastUtils
import com.btpj.lib_base.base.BaseActivity
import com.wangxingxing.videocollectionscompose.R
import com.wangxingxing.videocollectionscompose.navigation.AppScreen
import com.wangxingxing.videocollectionscompose.navigation.LocalNavController
import com.wangxingxing.videocollectionscompose.ui.theme.VideoCollectionsComposeTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * author : 王星星
 * date : 2025/4/29 15:06
 * email : 1099420259@qq.com
 * description :
 */
@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var navHostController: NavHostController

    /** 上一次点击返回键的时间 */
    private var lastBackMills: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            navHostController = rememberNavController()
            CompositionLocalProvider(LocalNavController provides navHostController) {
                AppScreen()
            }
        }
    }


    /** 返回监听回调 */
    private val mBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (System.currentTimeMillis() - lastBackMills > 2000) {
                lastBackMills = System.currentTimeMillis()
                ToastUtils.showShort(R.string.toast_double_back_exit)
            } else {
                finish()
            }
        }
    }
}
