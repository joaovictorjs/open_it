package preferences

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.FrameWindowScope
import java.io.FileInputStream
import java.util.Properties
import java.util.prefs.Preferences

class ApplicationPreferences {
    companion object {
        lateinit var windowScope: FrameWindowScope
        private val name = this::class.simpleName
        private val preferences = Preferences.userRoot().node(name)

        //TODO: resolver 'gradle.properties not found' após gerar release
//        private val gradleProps = Properties().apply {
//            load(FileInputStream("gradle.properties"))
//        }
//        private var _appVersion by mutableStateOf(gradleProps["application.version"] as String)

        private var _appVersion by mutableStateOf("1.0.0")

        val appVersion by derivedStateOf { _appVersion }
        private var _useLightTheme by mutableStateOf(preferences.getBoolean("use-light-theme", true))
        val useLightTheme by derivedStateOf { _useLightTheme }

        fun changeTheme(useLightTheme: Boolean) {
            _useLightTheme = useLightTheme
            preferences.node(name).putBoolean("use-light-theme", useLightTheme)
            preferences.flush()
        }
    }
}