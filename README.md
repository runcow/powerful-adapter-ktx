# powerful-adapter-ktx
## 一个万能的RecyclerView adapter，轻松实现多itemViewType界面\A powerful adapter for RecyclerView written by kotlin
### 第一步：创建dto、holder（有几个itemViewType就创建几组 dto & holder）
```kotlin
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
```
### 第二步：创建adapter
```kotlin
    var mAdapter: BaseAdapter
    mAdapter = BaseAdapter(
            this, listOf(
                DtoStyle(ADto::class, R.layout.item_a, AHolder::class),
                DtoStyle(BDto::class, R.layout.item_b, BHolder::class)
        )
    )
    binding.recyclerView.adapter = mAdapter
```
### 第三步：update
```kotlin
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
```
![cut](https://user-images.githubusercontent.com/10667734/131433679-4427d31c-e30d-45ab-86be-7ad5e234c8bf.jpg)
