package com.wangxingxing.videocollectionscompose.ui.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wangxingxing.videocollectionscompose.R
import com.wangxingxing.videocollectionscompose.ui.main.home.daily.DailyScreen
import com.wangxingxing.videocollectionscompose.ui.main.home.discovery.DiscoveryScreen
import com.wangxingxing.videocollectionscompose.ui.main.home.recommend.RecommendScreen
import com.wangxingxing.videocollectionscompose.ui.theme.C_FFFAFAFA
import kotlinx.coroutines.launch

/**
 * author : 王星星
 * date : 2025/4/29 17:09
 * email : 1099420259@qq.com
 * description : 首页
 */
@Composable
fun HomeScreen() {
    HomeTitleBar()
}

@Composable
fun HomeTitleBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(C_FFFAFAFA)
            .fillMaxWidth()
    ) {
        val context = LocalContext.current
        val titleList = context.resources.getStringArray(R.array.home_titles)
        val pagerState = rememberPagerState { titleList.size }
        val coroutineScope = rememberCoroutineScope()
        val lazyListStates = (1..titleList.size).map { rememberLazyListState() }

        Column {
            Row {
                Icon(
                    imageVector = Icons.Default.CalendarMonth,
                    contentDescription = null,
                    modifier = Modifier
                        .size(38.5.dp)
                        .padding(10.dp)
                )
                Box(
                    modifier = modifier
                        .padding(horizontal = 70.dp)
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                ) {
                    TabRow(
                        selectedTabIndex = pagerState.currentPage,
                        containerColor = C_FFFAFAFA,
                        contentColor = Color.Black,
                        divider = {},
                        modifier = Modifier.height(40.dp),
                        indicator = { tabPositions ->
                            TabRowDefaults.SecondaryIndicator(
                                Modifier
                                    .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                                    .padding(horizontal = 15.dp),
                                color = Color.Black
                            )
                        }) {
                        titleList.forEachIndexed { index, title ->
                            Tab(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .padding(bottom = 4.dp),
                                selected = pagerState.currentPage == index,
                                onClick = {
                                    coroutineScope.launch {
                                        pagerState.animateScrollToPage(index)
                                    }
                                }
                            ) {
                                Text(
                                    text = title,
                                    fontSize = 12.sp,
                                    color = Color.Black
                                )
                            }
                        }
                    }
                }
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier
                        .size(43.dp)
                        .padding(10.dp),
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.TopCenter
            ) {
                HorizontalPager(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top,
                    state = pagerState,
                    key = { index -> index }
                ) {
                    if (it == pagerState.currentPage) {
                        when (it) {
                            0 -> DiscoveryScreen()
                            1 -> RecommendScreen()
                            2 -> DailyScreen()
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeTitleBarPreview() {
    HomeTitleBar()
}

@Preview
@Composable
fun HomeScreenPreview() {
//    HomeScreen()
}