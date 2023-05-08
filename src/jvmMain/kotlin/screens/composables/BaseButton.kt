package screens.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.input.pointer.pointerHoverIcon
import org.jetbrains.skiko.Cursor

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BaseButton(
    modifier: Modifier = Modifier,
    cursor: Int = Cursor.HAND_CURSOR,
    callback: () -> Unit,
    enabled: Boolean = true,
    content: @Composable (isHovering: Boolean) -> Unit
) {
    var isHovering by remember { mutableStateOf(false) }

    Box(modifier = modifier
        .onPointerEvent(PointerEventType.Enter) { isHovering = true }
        .onPointerEvent(PointerEventType.Exit) { isHovering = false }
        .pointerHoverIcon(PointerIcon(Cursor(cursor)))
        .clickable(
            indication = null,
            interactionSource = MutableInteractionSource(),
            onClick = callback,
            enabled = enabled
        )
    ) {
        content(isHovering)
    }
}