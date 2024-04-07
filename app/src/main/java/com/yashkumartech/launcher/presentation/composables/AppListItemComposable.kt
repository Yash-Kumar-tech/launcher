package com.yashkumartech.launcher.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import com.yashkumartech.launcher.models.AppIcon

@Composable
fun AppListItemComposable(app: AppIcon, launchApp: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.0.dp, horizontal = 8.0.dp)
            .clip(RoundedCornerShape(8.0.dp))
            .background(
                MaterialTheme
                    .colorScheme
                    .tertiaryContainer
                    .copy(0.2f)
            )
            .clickable {
                launchApp()
            }
            .padding(vertical = 4.0.dp, horizontal = 8.0.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .height(36.0.dp)
                .width(36.0.dp)
        ) {
            Image(painter = rememberDrawablePainter(drawable = app.icon), contentDescription = null)
        }
        Spacer(modifier = Modifier.width(8.0.dp))
        Text(app.label)
    }
}