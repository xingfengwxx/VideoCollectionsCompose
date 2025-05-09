package com.wangxingxing.videocollectionscompose.ui.main.home.discovery

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * author : 王星星
 * date : 2025/5/8 16:50
 * email : 1099420259@qq.com
 * description : 发现
 */
@Composable
fun DiscoveryScreen(
    viewModel: DiscoveryViewModel = hiltViewModel()
) {
    val data by viewModel.discoveryData.collectAsState()
    viewModel.fetchDiscoveryData()
}