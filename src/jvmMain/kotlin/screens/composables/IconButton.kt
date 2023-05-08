package screens.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ui.color.ColorSchemaProvider

@Composable
fun IconButton(
    icon: String,
    modifier: Modifier = Modifier,
    iconColor: Color = ColorSchemaProvider.current.icon,
    hoverColor: Color = ColorSchemaProvider.current.surface,
    radius: Dp = 4.dp,
    callback: () -> Unit
) {
    BaseButton(callback = callback) {
        Icon(
            painter = painterResource(icon),
            modifier = modifier
                .clip(RoundedCornerShape(radius))
                .background(if (it) hoverColor else Color.Transparent)
                .padding(7.dp)
                .size(16.dp),
            tint = iconColor,
            contentDescription = null,
        )
    }
}