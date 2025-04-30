package com.wangxingxing.videocollectionscompose.util

import android.content.Context
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import java.io.File

/**
 * author : 王星星
 * date : 2025/4/30 17:09
 * email : 1099420259@qq.com
 * description : 字体管理类
 */
object FontManager {

    const val FONT_LOBSTER = "Lobster-1.4.otf"
    const val FZLanTingHeiS_L = "FZLanTingHeiS-L-GB-Regular.TTF"
    const val FZLanTingHeiS_DB = "FZLanTingHeiS-DB1-GB-Regular.TTF"
    const val FONT_FUTURA = "Futura-CondensedMedium.ttf"
    const val FONT_DIN = "DIN-Condensed-Bold.ttf"

    /**
     * 从 assets/fonts/ 目录加载字体文件
     *
     * @param context 上下文
     * @param fontFileName 字体文件名（如 "Lobster-1.4.otf"）
     * @return FontFamily 对象
     */
    fun loadFontFromAssets(context: Context, fontFileName: String): FontFamily {
        val assetManager = context.assets
        val file = File.createTempFile("font", null, context.cacheDir)
        assetManager.open("fonts/$fontFileName").use { inputStream ->
            file.outputStream().use { outputStream ->
                inputStream.copyTo(outputStream)
            }
        }
        return FontFamily(Font(file))
    }
}

