package com.runcow.adapter.ktx.lib

import kotlin.reflect.KClass

/**
 *
 *
 * @author runcow
 * @time 2021/8/25 16:29
 */
data class DtoStyle (
    var dtoClazz: KClass<out BaseDto<*>>,
    var layoutId: Int,
    var holderClazz: KClass<out BaseHolder<out BaseDto<*>>>
)