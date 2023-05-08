package screens.main

import androidx.compose.foundation.PointerMatcher
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.ComposeWindow
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import preferences.ApplicationPreferences
import screens.composables.BaseButton
import screens.composables.IconButton
import screens.main.controllers.MainController
import ui.color.ColorSchemaProvider
import ui.typography.TypographyProvider
import java.awt.datatransfer.DataFlavor
import java.awt.datatransfer.Transferable
import java.io.File

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MainScreen() {
    val bg = ColorSchemaProvider.current.background
    val surface = ColorSchemaProvider.current.surface
    val border = ColorSchemaProvider.current.border
    val icon = ColorSchemaProvider.current.icon
    val primary = ColorSchemaProvider.current.primary
    val disabled = ColorSchemaProvider.current.disabled

    val titleType = TypographyProvider.current.title
    val bodyType = TypographyProvider.current.body

    val controller = MainController()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bg)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().height(30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.End)
        ) {
            IconButton(icon = "icons/github.svg", callback = controller::openRepository)

            IconButton(icon = "icons/theme.svg") {
                ApplicationPreferences.changeTheme(!ApplicationPreferences.useLightTheme)
            }
        }

        Column(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .weight(1F)
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
                .background(surface)
                .drawWithContent {
                    drawContent()

                    drawRoundRect(
                        color = border,
                        cornerRadius = CornerRadius(4F, 4F),
                        size = size,
                        style = Stroke(
                            width = 2F,
                            pathEffect = PathEffect.dashPathEffect(intervals = floatArrayOf(5F, 5F))
                        )
                    )
                },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource("icons/folder.svg"),
                tint = primary,
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Arraste e solte", style = titleType)
            Text(text = "seus arquivos e documentos aqui", style = bodyType)

            Box(
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .height(16.dp).width(100.dp)
                    .drawWithContent {
                        val height = 2F
                        drawRect(
                            color = border,
                            size = Size(width = size.width, height = height),
                            topLeft = Offset(x = 0F, y = (size.height / 2) - (height / 2))
                        )
                        drawContent()
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "OU",
                    modifier = Modifier.background(surface).padding(horizontal = 5.dp),
                    style = bodyType.copy(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Center
                )
            }

            BaseButton(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(primary),
                callback = {
                    controller.openFilePicker(
                        ApplicationPreferences.windowScope,
                        callback = controller::openFiles
                    )
                }
            ) {
                Text(
                    text = "Procurar arquivos",
                    modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                    style = bodyType.copy(color = bg, fontWeight = FontWeight.Bold)
                )
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "© 2023 João Victor Justino de Souza. Todos os direitos reservados.",
                style = bodyType.copy(color = disabled, fontWeight = FontWeight.Bold),
                fontSize = 12.sp
            )

            Text(
                text = "Version: ${ApplicationPreferences.appVersion}",
                style = bodyType.copy(color = disabled, fontWeight = FontWeight.Bold),
                fontSize = 12.sp
            )
        }
    }
}