package paulo.jorge.app.presenter.realm

import androidx.compose.runtime.collectAsState
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RealmViewModel: ViewModel() {
    private val realmRepo = Repo()

    /*val users: LiveData<List<User>> = liveData {
        emitSource(realmRepo.getUsersAsFlow().asLiveData(Dispatchers.Main))
    }*/

    val userList = MutableStateFlow<List<User>> (emptyList())

    val _users: MutableStateFlow<List<User>> = MutableStateFlow(emptyList())
    val users = _users.asStateFlow()



    suspend fun fetchUsers() {
        withContext(Dispatchers.Default) {
            realmRepo.getUsersAsFlow().onEach {
                _users.value = it
            }
        }
    }


    fun saveUserInfo(user: User) {
        viewModelScope.launch {
            realmRepo.saveUserInfo(user)
        }
    }

    fun getUsers() {
        viewModelScope.launch {
            val list = realmRepo.getUsersAsList()
            withContext(Dispatchers.Main) {
                userList.value = list
            }
        }
    }

}