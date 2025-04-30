package com.wangxingxing.videocollectionscompose.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.wangxingxing.videocollectionscompose.ui.main.MainScreen
import com.wangxingxing.videocollectionscompose.ui.main.community.CommunityScreen
import com.wangxingxing.videocollectionscompose.ui.main.home.HomeScreen
import com.wangxingxing.videocollectionscompose.ui.main.mine.MineScreen
import com.wangxingxing.videocollectionscompose.ui.main.notification.NotificationScreen
import com.wangxingxing.videocollectionscompose.ui.main.upload.UploadScreen


/**
 * author : 王星星
 * date : 2025/4/15 17:52
 * email : 1099420259@qq.com
 * description :
 */
@Composable
fun NavGraph(paddingValues: PaddingValues) {
    val navHostController = LocalNavController.current // 隐式获取 NavHostController
    NavHost(
        navController = navHostController,
        startDestination = Route.HOME,
        modifier = Modifier.padding(paddingValues),
        // 禁用导航动画
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
    ) {
        composable(Route.MAIN) {
            MainScreen()
        }
        composable(Route.HOME) {
            HomeScreen()
        }
        composable(Route.COMMUNITY) {
            CommunityScreen()
        }
        composable(Route.UPLOAD) {
            UploadScreen()
        }
        composable(Route.NOTIFICATION) {
            NotificationScreen()
        }
        composable(Route.MINE) {
            MineScreen()
        }

    }
}

val LocalNavController = compositionLocalOf<NavHostController> {
    error("No NavHostController provided!") // 如果没有提供 NavHostController，抛出错误
}


object Route {
    const val SPLASH = "splash"
    const val MAIN = "main"
    const val HOME = "home"
    const val COMMUNITY = "community"
    const val UPLOAD = "upload"
    const val NOTIFICATION = "notification"
    const val PROJECT = "project"
    const val SQUARE = "square"
    const val WECHAT = "wechat"
    const val MINE = "mine"
    const val MY_COLLECT = "myCollect"
    const val SETTING = "setting"
    const val WEB = "web"
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val SHARE_LIST = "share_list"
    const val ADD_ARTICLE = "add_article"
    const val INTEGRAL_RANK = "integral_rank"
    const val INTEGRAL_RANK_RECORD = "integral_rank_record"
    const val SEARCH = "search"
    const val SEARCH_RECORD = "search_record"
    const val SYSTEM_DETAILS = "system_details"
}

