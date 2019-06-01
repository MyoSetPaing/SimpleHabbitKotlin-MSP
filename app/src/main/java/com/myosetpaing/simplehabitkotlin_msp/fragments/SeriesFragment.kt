package com.myosetpaing.simplehabitkotlin_msp.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myosetpaing.simplehabitkotlin_msp.R
import com.myosetpaing.simplehabitkotlin_msp.activities.DetailActivity
import com.myosetpaing.simplehabitkotlin_msp.adapters.CategoryProgramAdapter
import com.myosetpaing.simplehabitkotlin_msp.adapters.CurrentProgramRecyclerAdapter
import com.myosetpaing.simplehabitkotlin_msp.adapters.TopicRecyclerAdapter
import com.myosetpaing.simplehabitkotlin_msp.data.vos.CategoryProgramVO
import com.myosetpaing.simplehabitkotlin_msp.data.vos.CurrentProgramVO
import com.myosetpaing.simplehabitkotlin_msp.data.vos.TopicVO
import com.myosetpaing.simplehabitkotlin_msp.mvp.presenters.impl.MainPresenterImpl
import com.myosetpaing.simplehabitkotlin_msp.mvp.views.MainView
import kotlinx.android.synthetic.main.fragment_series.*
import java.util.ArrayList

class SeriesFragment : BaseFragment(), MainView {


    private lateinit var mMainPresenter: MainPresenterImpl
    private lateinit var mCurrentProgramAdapter: CurrentProgramRecyclerAdapter
    private lateinit var mCategoryProgramAdapter: CategoryProgramAdapter
    private lateinit var mTopicRecyclerAdapter: TopicRecyclerAdapter

    companion object {
        fun newInstance() = SeriesFragment()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.fragment_series, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mMainPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mMainPresenter.initPresenter(this)
        mMainPresenter.onUIReady(this)
        mCurrentProgramAdapter = CurrentProgramRecyclerAdapter(mMainPresenter)
        mCategoryProgramAdapter = CategoryProgramAdapter(mMainPresenter)
        mTopicRecyclerAdapter = TopicRecyclerAdapter()


        rvFragmentSeriesCurrentProgram.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvFragmentSeriesCurrentProgram.adapter = mCurrentProgramAdapter

        rvFragmentSeriesCategories.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvFragmentSeriesCategories.adapter = mCategoryProgramAdapter

        rvFragmentSeriesTopic.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvFragmentSeriesTopic.adapter = mTopicRecyclerAdapter

        srlSeriesFragment.setOnRefreshListener { mMainPresenter.onRefreshPage(this) }

    }


    override fun showCurrentProgram(currentProgram: CurrentProgramVO) {
        if (srlSeriesFragment.isRefreshing) {
            srlSeriesFragment.isRefreshing = false
        }

        val programList = ArrayList<CurrentProgramVO>()
        programList.add(currentProgram)
        mCurrentProgramAdapter.setNewData(programList)
    }

    override fun showCategoryPrograms(categoryPrograms: List<CategoryProgramVO>) {
        if (srlSeriesFragment.isRefreshing) {
            srlSeriesFragment.isRefreshing = false
        }
        mCategoryProgramAdapter.setNewData(categoryPrograms as MutableList<CategoryProgramVO>)
    }

    override fun showTopic(topicList: List<TopicVO>) {
        if (srlSeriesFragment.isRefreshing) {
            srlSeriesFragment.isRefreshing = false
        }
        mTopicRecyclerAdapter.setNewData(topicList as MutableList<TopicVO>)
    }

    override fun showFailMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun showNoDataMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun getMyContext(): Context {
        return context!!
    }

    override fun showDetail(type: String, position: Int, itemId: String) {
        val intent = DetailActivity.newIntent(context!!)
        intent.putExtra(DetailActivity.NAME_CATEGORY_PROGRAM, type)
        intent.putExtra(DetailActivity.POSITION, position)
        intent.putExtra(DetailActivity.ITEM_ID, itemId)
        startActivity(intent)
    }

}