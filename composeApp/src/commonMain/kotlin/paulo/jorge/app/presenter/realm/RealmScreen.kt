package paulo.jorge.app.presenter.realm

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import kotlinx.coroutines.runBlocking


@Composable
fun RealScreen(
    onBack: () -> Unit
) {
     val realmRepo = Repo()
    runBlocking {
        realmRepo.doAppSignIn()
    }

    val mainViewModel = getViewModel(
        key = "view-model-repo",
        factory = viewModelFactory {
            RealmViewModel()
        }
    )
    val paulo = User()
    paulo.name = "Paulo"
    paulo.twitterHandle = "jorge"
    Button(
        onClick = {
            mainViewModel.saveUserInfo(paulo)
        }
    ){
        Text("SAVE")
    }

}