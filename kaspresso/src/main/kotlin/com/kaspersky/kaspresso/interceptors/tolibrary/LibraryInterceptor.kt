package com.kaspersky.kaspresso.interceptors.tolibrary

import com.kaspersky.kaspresso.kaspresso.Kaspresso

/**
 * The base class of libraries interceptors (Kakao/UiAutomatorDsl) for Kaspresso's implementations
 */
internal abstract class LibraryInterceptor<INTERACTION, ASSERTION, ACTION>(
    protected val kaspresso: Kaspresso
) {
    abstract fun interceptCheck(interaction: INTERACTION, assertion: ASSERTION)

    abstract fun interceptPerform(interaction: INTERACTION, action: ACTION)
}