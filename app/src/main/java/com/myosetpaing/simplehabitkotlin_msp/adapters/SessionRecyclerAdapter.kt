package com.myosetpaing.simplehabitkotlin_msp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.myosetpaing.simplehabitkotlin_msp.R
import com.myosetpaing.simplehabitkotlin_msp.data.vos.SessionVO
import com.myosetpaing.simplehabitkotlin_msp.views.holders.SessionViewHolder

class SessionRecyclerAdapter : BaseRecyclerViewAdapter<SessionViewHolder, SessionVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item_session, parent, false)
        return SessionViewHolder(view)
    }

}