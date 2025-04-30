package com.wangxingxing.videocollectionscompose.ui.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.wangxingxing.videocollectionscompose.R
import com.wangxingxing.videocollectionscompose.navigation.LocalNavController
import com.wangxingxing.videocollectionscompose.navigation.NavGraph
import com.wangxingxing.videocollectionscompose.navigation.Route

/**
 * author : 王星星
 * date : 2025/4/16 16:56
 * email : 1099420259@qq.com
 * description :
 */
@Composable
fun MainScreen() {
    val navHostController = LocalNavController.current
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val destination = navBackStackEntry?.destination

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            // 除去几个navBarItems其他页面不展示BottomBar
            if (destination?.hierarchy?.any { hierarchyItem ->
                    navBarItems?.any { navBarItem -> navBarItem.route == hierarchyItem.route } == true
                } == true) {
                BottomBar(destination)
            }
        }
    ) {
        NavGraph(paddingValues = it)
    }
}

val navBarItems = listOf(
    NavBarItem.Home,
    NavBarItem.Community,
    NavBarItem.Upload,
    NavBarItem.Notification,
    NavBarItem.Mine
)

@Composable
fun BottomBar(navDestination: NavDestination) {
    val navHostController = LocalNavController.current
    BottomNavigation(
        backgroundColor = Color.White
    ) {
        navBarItems.forEachIndexed() { index, item ->
            val selected = navDestination?.hierarchy?.any { it.route == item.route } == true
            BottomNavigationItem(
                selected = selected,
                icon = {
                    Icon(
                        painter = painterResource(id = if (selected) item.selectIcon else item.normalIcon),
                        contentDescription = item.route,
                        modifier = Modifier
                            .size(if (index == 2) 33.dp else 22.dp)
                            .padding(bottom = 4.dp)
                            .then(if (index == 2) Modifier.offset(x = 0.dp, y = 10.dp) else Modifier) // 调整垂直偏移量
                    )

                },
//                selectedContentColor = MaterialTheme.colorScheme.onPrimary,
//                unselectedContentColor = MaterialTheme.colorScheme.onPrimary.copy(0.3f),
                label = {
                    Text(
                        text = stringResource(id = item.label),
                        fontSize = 12.sp
                    )
                },
                onClick = {
                    navHostController.navigate(item.route) {
                        // 这里让多个Tab下返回时，不是回到首页，而是直接退出
                        navDestination?.id?.let {
                            popUpTo(it) {
                                // 跳转时保存页面状态
                                saveState = true
                                // 回退到栈顶时，栈顶页面是否也关闭
                                inclusive = true
                            }
                        }
                        // 栈顶复用，避免重复点击同一个导航按钮，回退栈中多次创建实例
                        launchSingleTop = true
                        // 回退时恢复页面状态
                        restoreState = true
                    }
                })
        }
    }
}

sealed class NavBarItem(@StringRes val label: Int, @DrawableRes val normalIcon: Int, @DrawableRes val selectIcon: Int, val route: String) {
    object Home : NavBarItem(R.string.tab_home, R.drawable.btn_home_page_normal, R.drawable.btn_home_page_selected, Route.HOME)
    object Community : NavBarItem(R.string.tab_community, R.drawable.btn_community_normal, R.drawable.btn_community_selected, Route.COMMUNITY)
    object Upload : NavBarItem(R.string.tab_upload, R.drawable.btn_release_normal, R.drawable.btn_release_normal, Route.UPLOAD)
    object Notification : NavBarItem(R.string.tab_inform, R.drawable.btn_notification_normal, R.drawable.btn_notification_selected, Route.NOTIFICATION)
    object Mine : NavBarItem(R.string.tab_mine, R.drawable.btn_mine_normal, R.drawable.btn_mine_selected, Route.MINE)
}