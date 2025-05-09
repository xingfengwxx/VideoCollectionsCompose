package com.wangxingxing.wanandroidcompose

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * author : 王星星
 * date : 2025/4/18 9:36
 * email : 1099420259@qq.com
 * description :
 */
object Const {

    object Config {
        const val BUGLY_APP_ID = "d60b18d191"

        const val PAGE_SIZE = 10

        const val URL_PROJECT_SOURCE_CODE = "https://github.com/xingfengwxx/WanAndroidCompose"
        const val URL_WAN_ANDROID = "https://www.wanandroid.com/"
        const val URL_INTEGRAL_HELP = "https://www.wanandroid.com/blog/show/2653"

        val IMG_URL_LIST = listOf(
            "https://www4.bing.com//th?id=OHR.DunluceIreland_ZH-CN2412229757_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp",
            "https://www4.bing.com//th?id=OHR.FlyoverNamibia_ZH-CN2114171516_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp",
            "https://www4.bing.com//th?id=OHR.BeginningofSummer25Y_ZH-CN2000519236_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp",
            "https://www4.bing.com//th?id=OHR.SevilleNaboo_ZH-CN1065227658_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp",
            "https://www4.bing.com//th?id=OHR.ArchesGalaxy_ZH-CN0954505086_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp",
            "https://www4.bing.com//th?id=OHR.BrazilHeron_ZH-CN7200229300_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp",
            "https://www4.bing.com//th?id=OHR.PinkPlumeria_ZH-CN3890147555_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp",
            "https://www4.bing.com//th?id=OHR.FozdoIguacu2025_ZH-CN3781165595_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp",
            "https://www4.bing.com//th?id=OHR.GardensVillandry_ZH-CN3660934263_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp",
            "https://www4.bing.com//th?id=OHR.OrangeImpala_ZH-CN3417660107_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp",
            "https://www4.bing.com//th?id=OHR.RedwoodGrove_ZH-CN3339576686_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp",
            "https://www4.bing.com//th?id=OHR.BrucePeninsula_ZH-CN3258296517_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp"
        )
    }

    object ParamKey {
        const val WEB_TYPE = "webType"
        const val COLLECTED_FLAG = "collectedFlag"
        const val URL = "url"
        const val STRUCTURE = "structure"
        const val PAGE_INDEX = "pageIndex"
        const val SEARCH_KEY = "searchKey"
    }

    sealed class HomePageType(open var type: String) {
        data object Banner : HomePageType("horizontalScrollCard")
    }

    sealed class ArticleType {
        object LatestProject : ArticleType()        // 最新项目
        object Project : ArticleType()    // 项目列表
        object Square : ArticleType()    // 广场 - 广场
        object Ask : ArticleType()    // 广场 - 每日一问
        object Wechat : ArticleType()    // 公众号
        object Collect : ArticleType()    // 我收藏的文章
        object Search : ArticleType()    // 搜索到的文章
        object SystemDetails : ArticleType()    // 搜索到的文章
    }

    @Parcelize
    sealed class WebType(open var link: String) : Parcelable {
        data class OnSiteArticle(val articleId: Int, override var link: String) : WebType(link)
        data class OutSiteArticle(
            val articleId: Int, val title: String, val author: String, override var link: String
        ) : WebType(link)

        data class Url(val id: Int? = null, val name: String, override var link: String) : WebType(link)
    }
}