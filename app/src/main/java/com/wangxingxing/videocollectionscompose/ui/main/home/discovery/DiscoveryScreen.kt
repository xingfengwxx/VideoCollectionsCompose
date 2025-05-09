package com.wangxingxing.videocollectionscompose.ui.main.home.discovery

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.blankj.utilcode.util.LogUtils
import com.btpj.lib_base.ui.widgets.Banner
import com.btpj.lib_base.ui.widgets.RefreshList
import com.wangxingxing.wanandroidcompose.Const

/**
 * author : 王星星
 * date : 2025/5/8 16:50
 * email : 1099420259@qq.com
 * description : 发现
 */
@Composable
fun DiscoveryScreen(
    viewModel: DiscoveryViewModel = hiltViewModel(),
    lazyListState: LazyListState,
    onBannerClick: (String) -> Unit = {}
) {
    val data by viewModel.discoveryData.collectAsState()

    RefreshList(
        uiState = viewModel.uiState.collectAsState().value,
        lazyListState = lazyListState,
        onRefresh = { viewModel.fetchDiscoveryData() },
        headerContent = {
            if (data.itemList.isNotEmpty()) {
                val bannerData = data.itemList.filter { it.type == Const.HomePageType.Banner.type }
                val bannerList = bannerData[0].data.itemList
                LogUtils.json(bannerList)
                // 接口返回的图片地址已失效，使用固定地址替代
                val imgList = bannerList.mapIndexed { index, item ->
                    item.data.image = Const.Config.IMG_URL_LIST[index]
                }
                LogUtils.d(imgList)
                Banner(
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth(),
                    images = imgList
                ) {
                    bannerData[it].data.actionUrl?.let { url -> onBannerClick(url) }
                }
            }
        },
        itemContent = { item ->

        }
    )
}