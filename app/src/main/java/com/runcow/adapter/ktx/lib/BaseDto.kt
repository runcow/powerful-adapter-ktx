package com.runcow.adapter.ktx.lib

/**
 *
 *
 * @author runcow
 * @time 2021/8/25 15:49
 */
open class BaseDto<T>(t: T) {
    var data = t

    /**
     * 表单提交的情况，可以通过此方法校验表单参数
     */
    open fun checkParam() {}
}