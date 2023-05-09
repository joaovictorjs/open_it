package preferences

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.FrameWindowScope
import java.util.prefs.Preferences

class ApplicationPreferences {
    companion object {
        lateinit var windowScope: FrameWindowScope
        private val _name = ApplicationPreferences::javaClass.name
        private val preferences = Preferences.userRoot().node(_name)

        private var _appVersion by mutableStateOf("")

        val appVersion by derivedStateOf { _appVersion }
        private var _useLightTheme by mutableStateOf(preferences.node(_name).getBoolean("use-light-theme", true))
        val useLightTheme by derivedStateOf { _useLightTheme }

        fun changeTheme(useLightTheme: Boolean) {
            preferences.node(_name).putBoolean("use-light-theme", useLightTheme)
            preferences.flush()
            _useLightTheme = useLightTheme
        }

        fun version(value: String?) {
            _appVersion = (value ?: "development version").replace("version=", "")
        }
    }
}