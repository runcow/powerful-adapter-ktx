package com.runcow.adapter.ktx.lib

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.runcow.adapter.ktx.lib.BaseDto

/**
 *
 *
 * @author runcow
 * @time 2021/8/25 16:21
 */
abstract class BaseHolder<T: BaseDto<*>>(val itemView: View, val adapter: RecyclerView.Adapter<*>): RecyclerView.ViewHolder(itemView) {
    val holderView: View = itemView
    abstract fun setData(data: BaseDto<*>)
}