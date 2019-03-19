package com.kaspersky.uitest_framework.kakaoext

import android.support.test.espresso.ViewAction
import android.view.View
import android.widget.TextView
import android.support.test.espresso.UiController
import android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom
import com.agoda.kakao.text.TextViewActions

/**
 * @return a [String] descriotion of [TextViewActions].
 */
fun TextViewActions.getText(): String {

    var stringHolder = "_"

    view.perform(object : ViewAction {

        override fun getConstraints() = isAssignableFrom(TextView::class.java)

        override fun getDescription() = "getting text from a TextView"

        override fun perform(uiController: UiController?, view: View?) {
            val tv = view as TextView
            stringHolder = tv.text.toString()
        }
    })

    return stringHolder
}