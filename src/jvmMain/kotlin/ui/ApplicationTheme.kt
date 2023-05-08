package ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import ui.color.ColorSchema
import ui.color.ColorSchemaProvider
import ui.typography.Typography
import ui.typography.TypographyProvider

@Composable
fun ApplicationTheme(colorSchema: ColorSchema, typography: Typography, content: @Composable () -> Unit) {
    CompositionLocalProvider(
        ColorSchemaProvider provides colorSchema,
        TypographyProvider provides typography,
        content = content
    )
}