import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import preferences.ApplicationPreferences
import screens.main.MainScreen
import ui.ApplicationTheme
import ui.color.DarkColorSchema
import ui.color.LightColorSchema
import ui.typography.Typography
import java.awt.Dimension
import java.awt.FileDialog

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        state = rememberWindowState(
            placement = WindowPlacement.Floating,
            position = WindowPosition(Alignment.Center),
            size = DpSize(600.dp, 450.dp)
        ),
        resizable = false,
        title = "Open It",
        icon = painterResource("logo.svg")
    ) {
        ApplicationPreferences.windowScope = this

        this.window.minimumSize = Dimension(600, 450)

        val schema = if (ApplicationPreferences.useLightTheme) LightColorSchema() else DarkColorSchema()
        val type = Typography(fontColor = schema.text)

        ApplicationTheme(schema, type) {
            MainScreen()
        }
    }
}
