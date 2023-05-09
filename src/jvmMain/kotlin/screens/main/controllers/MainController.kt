package screens.main.controllers

import androidx.compose.ui.window.FrameWindowScope
import java.awt.Desktop
import java.awt.FileDialog
import java.io.File
import java.io.IOException
import java.net.URI
import java.net.URLDecoder

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

    fun openFile(path: String) {
        val decoded = URLDecoder.decode(File(path).normalize().absolutePath, "UTF-8")
        try {
            Desktop.getDesktop().open(File(decoded))
        } catch (_: IOException) {

        }
    }

    fun openFiles(files: List<String>) = files.forEach(::openFile)
}