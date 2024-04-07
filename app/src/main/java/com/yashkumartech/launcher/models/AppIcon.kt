package com.yashkumartech.launcher.models

import android.graphics.drawable.Drawable

data class AppIcon(
    val label: String,
    val icon: Drawable?,
    val packageName: String,
)
