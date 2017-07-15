package io.github.tonnyl.mango.data.repository

import io.github.tonnyl.mango.data.Shot
import io.github.tonnyl.mango.data.datasource.ShotsDataSource
import io.github.tonnyl.mango.retrofit.ApiConstants
import io.github.tonnyl.mango.retrofit.FollowerService
import io.github.tonnyl.mango.retrofit.RetrofitClient
import io.github.tonnyl.mango.retrofit.ShotsService
import io.github.tonnyl.mango.main.shots.ShotsPagePresenter
import io.github.tonnyl.mango.util.AccountManager
import io.reactivex.Observable
import retrofit2.Response

/**
 * Created by lizhaotailang on 2017/6/30.
 */

object ShotsRepository: ShotsDataSource {

    private val mShotsService: ShotsService = RetrofitClient.createService(ShotsService::class.java, AccountManager.accessToken)
    private val mFollowerService: FollowerService = RetrofitClient.createService(FollowerService::class.java, AccountManager.accessToken)

    override fun listFollowingShots(): Observable<Response<List<Shot>>> {
        return mFollowerService.listFollowingShots(ApiConstants.PER_PAGE)
    }

    override fun listShots(type: Int, page: Int): Observable<Response<List<Shot>>> {
        val timeframe: String? = null
        val date: String? = null

        val sort: String? = if (type == ShotsPagePresenter.TYPE_RECENT) {
            "recent"
        } else {
            null
        }

        val queryList: String? = if (type == ShotsPagePresenter.TYPE_DEBUTS) {
            "debuts"
        } else {
            null
        }

        return mShotsService.listShots(queryList, timeframe, date, sort, page = page)
    }

}