package ui.color

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val ColorSchemaProvider = staticCompositionLocalOf<ColorSchema> { LightColorSchema() }

abstract class ColorSchema {
    open val primary: Color = Color.Transparent
    open val background: Color = Color.Transparent
    open val icon: Color = Color.Transparent
    open val text: Color = Color.Transparent
    open val surface: Color = Color.Transparent
    open val disabled: Color = Color.Transparent
    open val border: Color = Color.Transparent
    open val hover: Color = Color.Transparent
}

class LightColorSchema : ColorSchema() {
    override val primary: Color = Color(0xFF0247FE)
    override val background: Color = Color(0xFFFFFFFF)
    override val icon: Color = Color(0xFF212121)
    override val text: Color = Color(0xFF212121)
    override val surface: Color = Color(0xFFEEEEEE)
    override val disabled: Color = Color(0xFFC6C6C6)
    override val border: Color = Color(0xFFA6A6A6)
    override val hover: Color = Color(0xFFD9D9D9)
}

class DarkColorSchema : ColorSchema() {
    override val primary: Color = Color(0xFF2F68FE)
    override val background: Color = Color(0xFF242424)
    override val icon: Color = Color(0xFFD6D6D6)
    override val text: Color = Color(0xFFD6D6D6)
    override val surface: Color = Color(0xFF161616)
    override val disabled: Color = Color(0xFF727272)
    override val border: Color = Color(0xFF727272)
    override val hover: Color = Color(0xFF727272)
}