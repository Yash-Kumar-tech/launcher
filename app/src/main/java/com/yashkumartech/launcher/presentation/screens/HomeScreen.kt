package com.yashkumartech.launcher.presentation.screens

import android.content.Intent
import android.content.pm.ResolveInfo
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.yashkumartech.launcher.models.AppIcon
import com.yashkumartech.launcher.presentation.composables.AppListItemComposable


@Composable
fun HomeScreen() {
    val appsList: MutableList<AppIcon> = mutableListOf()
    val context = LocalContext.current
    val packageManager = context.packageManager
    val mainIntent = Intent(Intent.ACTION_MAIN, null)
    mainIntent.addCategory(Intent.CATEGORY_LAUNCHER)
    val pkgAppsList: List<ResolveInfo> = context.packageManager.queryIntentActivities(mainIntent, 0)
    for (app in pkgAppsList) {
        appsList.add(
            AppIcon(
                label = app.loadLabel(packageManager).toString(),
                icon = app.loadIcon(packageManager),
                packageName = app.activityInfo.packageName
            )
        )

    }
    appsList.sortBy {
        it.label
    }
    LazyColumn(
        modifier = Modifier.padding(top = 48.dp)
    ) {
        items(appsList) {
            AppListItemComposable(
                app = it,
                launchApp = {
                    val intent = packageManager.getLaunchIntentForPackage(it.packageName)
                    context.startActivity(intent)
                }
            )
        }
    }
}

