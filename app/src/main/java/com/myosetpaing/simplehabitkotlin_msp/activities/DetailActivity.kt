package com.myosetpaing.simplehabitkotlin_msp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myosetpaing.simplehabitkotlin_msp.R
import com.myosetpaing.simplehabitkotlin_msp.adapters.SessionRecyclerAdapter
import com.myosetpaing.simplehabitkotlin_msp.data.vos.CategoryProgramVO
import com.myosetpaing.simplehabitkotlin_msp.data.vos.CurrentProgramVO
import com.myosetpaing.simplehabitkotlin_msp.data.vos.SessionVO
import com.myosetpaing.simplehabitkotlin_msp.mvp.presenters.impl.DetailPresenterImpl
import com.myosetpaing.simplehabitkotlin_msp.mvp.views.DetailView
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity(), DetailView {


    private val sessionAdapter: SessionRecyclerAdapter = SessionRecyclerAdapter()
    private lateinit var mDetailPresenter: DetailPresenterImpl
    private var position = 0
    private var itemId = ""
    private lateinit var type: String

    companion object {
        const val NAME_CURRENT = "current"
        const val NAME_CATEGORY_PROGRAM = "category_program"
        const val POSITION = "position"
        const val ITEM_ID = "category_id"

        fun newIntent(context: Context): Intent {
            return Intent(context, DetailActivity::class.java)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(tbActivityDetail)

        mDetailPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mDetailPresenter.initPresenter(this)

        rvDetailSession.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvDetailSession.adapter = sessionAdapter
        init()
        if (type == NAME_CURRENT) {
            mDetailPresenter.onUIReady(this, type)
        } else if (type == NAME_CATEGORY_PROGRAM) {
            mDetailPresenter.onUIReady(this, type, itemId)
        }

    }

    private fun init() {
        retrieveExtra()
    }

    private fun retrieveExtra() {
        val intent = intent
        type = intent.getStringExtra(NAME_CATEGORY_PROGRAM)
        position = intent.getIntExtra(POSITION, 0)
        itemId = intent.getStringExtra(ITEM_ID)

    }

    override fun showCategoryProgramDetail(categoryProgram: CategoryProgramVO) {
        tvDetailDescription.text = categoryProgram.programs!![position].programTitle
        collapsingToolBar.title = categoryProgram.programs!![position].programTitle
        sessionAdapter.setNewData(categoryProgram.programs!![position].session as MutableList<SessionVO>)
    }

    override fun showCurrentProgramDetail(currentProgram: CurrentProgramVO) {

        tvDetailDescription.text = currentProgram.description
        collapsingToolBar.title = currentProgram.currentProgramTitle
        sessionAdapter.setNewData(currentProgram.session as MutableList<SessionVO>)

    }

    override fun showNoData(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun getMyContext(): Context {
        return this
    }

}
