import androidx.compose.ui.window.ComposeUIViewController
import paulo.jorge.app.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    return ComposeUIViewController { App() }
}
