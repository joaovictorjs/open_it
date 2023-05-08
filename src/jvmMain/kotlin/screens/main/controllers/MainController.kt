package screens.main.controllers

import androidx.compose.runtime.*
import androidx.compose.ui.window.FrameWindowScope
import java.awt.Desktop
import java.awt.FileDialog
import java.io.File
import java.net.URI

class MainController {
    fun openRepository() {
        Desktop.getDesktop().browse(URI("https://github.com/joaovictorjs/open_it"))
    }

    fun openFilePicker(w: FrameWindowScope, callback: (filenames: List<String>) -> Unit) {
        val picker = FileDialog(w.window, "Selecione seus arquivos")
        picker.isMultipleMode = true
        picker.isVisible = true
        callback(picker.files.map { it.absolutePath })
    }

    fun openFiles(files: List<String>) {
        files.forEach {
            Desktop.getDesktop().open(File(it))
        }
    }
}