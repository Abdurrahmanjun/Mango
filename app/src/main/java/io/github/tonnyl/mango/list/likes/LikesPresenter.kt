package io.github.tonnyl.mango.list.likes

import io.github.tonnyl.mango.data.repository.ShotRepository
import io.github.tonnyl.mango.retrofit.ApiConstants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by lizhaotailang on 2017/7/8.
 */

class LikesPresenter(view: LikesContract.View, id: Long) : LikesContract.Presenter {

    private val mView = view
    private val mId = id
    private val mCompositeDisposable: CompositeDisposable

    private var mPageCount = 0
    private var mIsFirstLoad = true
    private var mHasMore = true

    init {
        mView.setPresenter(this)
        mCompositeDisposable = CompositeDisposable()
    }

    override fun subscribe() {
        fetchLikes()
    }

    override fun unsubscribe() {
        mCompositeDisposable.clear()
    }

    override fun fetchLikes() {
        if (mIsFirstLoad) {
            mView.setLoadingIndicator(true)
            mIsFirstLoad = false
        }

        if (!mHasMore) {
            return
        }

        val disposable = ShotRepository
                .listLikes(mId, mPageCount)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    mView.setLoadingIndicator(false)
                    response.body()?.let {
                        mView.showLikes(it.toMutableList())
                        mHasMore = (it.size % ApiConstants.PER_PAGE == 0)
                        if (!mHasMore) {
                            mPageCount = 0
                        } else {
                            mPageCount = (it.size / ApiConstants.PER_PAGE) + 1
                        }
                    } ?: run {
                        mView.showMessage(null)
                    }
                }, { error ->
                    mView.setLoadingIndicator(false)
                    mView.showMessage(error.message)
                })
        mCompositeDisposable.add(disposable)
    }

}