package com.myosetpaing.simplehabitkotlin_msp.views.holders

import android.view.View
import com.myosetpaing.simplehabitkotlin_msp.data.vos.SessionVO
import kotlinx.android.synthetic.main.view_item_session.view.*
import java.text.SimpleDateFormat
import java.util.*

class SessionViewHolder(itemView: View) : BaseViewHolder<SessionVO>(itemView) {

    override fun setData(data: SessionVO) {
        itemView.tvSessionNo.text = (adapterPosition + 1).toString()
        itemView.tvSessionName.text = data.sessionTitle
        itemView.tvSessionDuration.text = setDuration(data.lengthInSeconds)

    }

    private fun setDuration(second: Int): String {
        val d = Date(second * 1000L)
        val df = SimpleDateFormat("mm:ss")
        df.timeZone = TimeZone.getTimeZone("GMT")
        return df.format(d)
    }


}
