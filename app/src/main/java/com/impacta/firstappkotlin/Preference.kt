package com.impacta.firstappkotlin

import com.orhanobut.hawk.Hawk

private const val IS_SIGNED = "isSigned"

var isSigned: Boolean
    get() = Hawk.get(IS_SIGNED) ?: false
    set(isSigned) {
        Hawk.put(IS_SIGNED, isSigned)
    }
