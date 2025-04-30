package com.wangxingxing.videocollectionscompose.ui.splash

import android.view.animation.AlphaAnimation
import android.view.animation.ScaleAnimation
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Animation
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wangxingxing.videocollectionscompose.R
import com.wangxingxing.videocollectionscompose.util.FontManager

/**
 * author : 王星星
 * date : 2025/4/14 17:18
 * email : 1099420259@qq.com
 * description :
 */
@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onFinish: () -> Unit
) {
    val alpha = remember { Animatable(0.5f) }
    val scale = remember { Animatable(1f) }

    val animDuration = 3000

    // 使用 FontManager 加载 Lobster 字体
    val lobsterFont = FontManager.loadFontFromAssets(LocalContext.current, FontManager.FONT_LOBSTER)

    // 启动淡入和缩放动画
    LaunchedEffect(Unit) {
        // 同时启动两个动画
        alpha.animateTo(
            targetValue = 1.0f, // 目标透明度
            animationSpec = tween(
                durationMillis = animDuration,
                easing = FastOutSlowInEasing // 先快后慢的插值器
            )
        )
        scale.animateTo(
            targetValue = 1.2f, // 目标缩放比例
            animationSpec = tween(
                durationMillis = animDuration,
                easing = FastOutSlowInEasing // 先快后慢的插值器
            )
        )
        onFinish() // 动画结束后调用onFinish
    }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.bg_splash),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    scaleX = scale.value
                    scaleY = scale.value
                    this.alpha = alpha.value
                }
        )

        Image(
            painter = painterResource(R.drawable.ic_logo_slogan),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 236.dp)
        )

        Text(
            text = stringResource(R.string.txt_splash_slogan),
            style = MaterialTheme.typography.bodySmall,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 36.dp)
        )

        Text(
            text = stringResource(R.string.txt_splash_slogan_en),
            style = MaterialTheme.typography.bodySmall.copy(
                fontFamily = lobsterFont
            ),
            color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 56.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(
        onFinish = {}
    )
}