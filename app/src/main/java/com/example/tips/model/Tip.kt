package com.example.tips.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tip(
    @StringRes val dayName: Int,
    @StringRes val tipHeading: Int,
    @DrawableRes val tipImage: Int,
    @StringRes val tipBody: Int,
)
