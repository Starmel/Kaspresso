package com.kaspersky.kaspresso.interceptors.behaviorkautomator.impl.autoscroll

import com.kaspersky.components.kautomator.intercepting.interaction.UiObjectInteraction
import com.kaspersky.components.kautomator.intercepting.operation.UiObjectAction
import com.kaspersky.components.kautomator.intercepting.operation.UiObjectAssertion
import com.kaspersky.kaspresso.autoscroll.AutoScrollProvider
import com.kaspersky.kaspresso.autoscroll.ObjectAutoScrollProviderImpl
import com.kaspersky.kaspresso.interceptors.behaviorkautomator.ObjectBehaviorInterceptor
import com.kaspersky.kaspresso.logger.UiTestLogger

/**
 * The implementation of [ObjectBehaviorInterceptor] and [AutoScrollProvider] interfaces.
 * Provides autoscroll on failure functionality for [UiObjectInteraction.perform] and [UiObjectInteraction.check] calls.
 */
class AutoScrollObjectBehaviorInterceptor(
    logger: UiTestLogger
) : ObjectBehaviorInterceptor,
    AutoScrollProvider<UiObjectInteraction> by ObjectAutoScrollProviderImpl(logger) {

    /**
     * Wraps the given [assertion] invocation with the autoscrolling on failure.
     *
     * @param interaction the intercepted [UiObjectInteraction].
     * @param assertion the assertion to invoke.
     */
    override fun <T> interceptCheck(
        interaction: UiObjectInteraction,
        assertion: UiObjectAssertion,
        activity: () -> T
    ): T = withAutoScroll(interaction, activity)

    /**
     * Wraps the given [action] invocation with the autoscrolling on failure.
     *
     * @param interaction the intercepted [UiObjectInteraction].
     * @param action the assertion to invoke.
     */
    override fun <T> interceptPerform(
        interaction: UiObjectInteraction,
        action: UiObjectAction,
        activity: () -> T
    ): T = withAutoScroll(interaction, activity)
}