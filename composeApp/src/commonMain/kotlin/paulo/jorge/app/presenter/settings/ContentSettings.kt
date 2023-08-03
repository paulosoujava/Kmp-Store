package paulo.jorge.app.presenter.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class SettingItem(val title: String, val description: String)

@Composable
fun ContentSettings() {
    val settingsList = listOf(
        SettingItem("Notificações", "Habilitar notificações"),
        SettingItem("Som", "Habilitar som de notificações"),
        SettingItem("Modo noturno", "Habilitar modo noturno"),
        SettingItem("Idioma", "Selecionar idioma"),
    )

    SettingsList(settingsList)
}

@Composable
fun SettingsList(settings: List<SettingItem>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(settings) { setting ->
            SettingItemCard(setting)
        }
    }
}

@Composable
fun SettingItemCard(setting: SettingItem) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = setting.title,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = setting.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}