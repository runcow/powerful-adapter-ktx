package com.runcow.adapter.ktx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.runcow.adapter.ktx.databinding.ActivityMainBinding
import com.runcow.adapter.ktx.databinding.ItemABinding
import com.runcow.adapter.ktx.databinding.ItemBBinding
import com.runcow.adapter.ktx.lib.BaseAdapter
import com.runcow.adapter.ktx.lib.BaseDto
import com.runcow.adapter.ktx.lib.BaseHolder
import com.runcow.adapter.ktx.lib.DtoStyle

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: BaseAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mAdapter = BaseAdapter(
            this, listOf(
                DtoStyle(ADto::class, R.layout.item_a, AHolder::class),
                DtoStyle(BDto::class, R.layout.item_b, BHolder::class)
            )
        )
        binding.recyclerView.adapter = mAdapter
        mAdapter.update(
            listOf(
                ADto("this is item A"),
                BDto("this is item B"),
                ADto("this is item A"),
                BDto("this is item B"),
                ADto("this is item A"),
                ADto("this is item A"),
                BDto("this is item B"),
                BDto("this is item B"),
            )
        )
    }

    class ADto(s: String) : BaseDto<String>(s) {
    }

    class AHolder(itemView: View, adapter: RecyclerView.Adapter<*>) :
        BaseHolder<ADto>(itemView, adapter) {
        var binding: ItemABinding = ItemABinding.bind(holderView)
        override fun setData(data: BaseDto<*>) {
            val dto: ADto = data as ADto
            binding.tvNumber.text = dto.data
        }
    }

    class BDto(s: String) : BaseDto<String>(s) {
    }

    class BHolder(itemView: View, adapter: RecyclerView.Adapter<*>) :
        BaseHolder<BDto>(itemView, adapter) {
        var binding: ItemBBinding = ItemBBinding.bind(holderView)
        override fun setData(data: BaseDto<*>) {
            val dto: BDto = data as BDto
            binding.tvNumber.text = dto.data
        }
    }
}