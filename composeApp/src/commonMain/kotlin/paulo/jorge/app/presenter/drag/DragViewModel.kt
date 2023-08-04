package paulo.jorge.app.presenter.drag

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import dev.icerock.moko.mvvm.viewmodel.ViewModel

class DragViewModel: ViewModel()  {

    var isCurrentlyDragging by mutableStateOf(false)
        private set

    var items by mutableStateOf(emptyList<PersonUiItem>())
        private set

    var addedPersons = mutableStateListOf<PersonUiItem>()
        private set

    init {
        items = listOf(
            PersonUiItem("Paulo","1", Color.Gray),
            PersonUiItem("Malu","2", Color.Blue),
            PersonUiItem("Bruna","3", Color.Green),
        )
    }

    fun startDragging(){
        isCurrentlyDragging = true
    }
    fun stopDragging(){
        isCurrentlyDragging = false
    }

    fun addPerson(personUiItem: PersonUiItem){
        println("Added Person")
        addedPersons.add(personUiItem)
    }


}