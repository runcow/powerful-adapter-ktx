package com.runcow.adapter.ktx.lib

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlin.reflect.KClass

/**
 *
 *
 * @author runcow
 * @time 2021/8/26 10:27
 */
class BaseAdapter(val context: Context, val styles: List<DtoStyle>): RecyclerView.Adapter<BaseHolder<out BaseDto<*>>>() {
    private var mData: List<BaseDto<*>>? = null
    private var layoutInflater: LayoutInflater = LayoutInflater.from(context)
    fun update(data: List<BaseDto<*>>?){
        mData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder<out BaseDto<*>> {
        val dtoStyle: DtoStyle = styles[viewType]
        val clazz: KClass<out BaseHolder<out BaseDto<*>>>  = dtoStyle.holderClazz
        val itemView: View = layoutInflater.inflate(dtoStyle.layoutId,parent,false)
        clazz.constructors.forEach(){
            if (it.parameters.size == 2){
                return it.call(itemView,this@BaseAdapter)
            }
        }
        //不允许返回null
        return object : BaseHolder<BaseDto<*>>(itemView,this@BaseAdapter){
            override fun setData(data: BaseDto<*>) {
            }
        }
    }

    override fun onBindViewHolder(holder: BaseHolder<out BaseDto<*>>, position: Int) {
        holder.setData(mData!![position])
    }

    override fun getItemCount(): Int {
        return mData?.size ?: 0
    }

    override fun getItemViewType(position: Int): Int {
        for (item in styles.indices){
            if (styles[item].dtoClazz == mData!![position]::class){
                return item
            }
        }
        return 0
    }
}