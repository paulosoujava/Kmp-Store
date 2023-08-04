package paulo.jorge.app.presenter.nubank

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Nubank(
    onBack: () -> Unit
) {
    Scaffold(
        bottomBar = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .size(200.dp, 50.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(NuColors.purple.copy(alpha = 0.9f)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround

                ) {
                    NuIcons.Custom(
                        Icons.Default.AccountCircle,
                        color = NuColors.black
                    )
                    NuIcons.Custom(
                        Icons.Default.AccountCircle,
                        color = NuColors.black
                    )
                    NuIcons.Custom(
                        Icons.Default.AccountCircle,
                        color = NuColors.black
                    )
                }
            }

        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(NuColors.purple)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(modifier = Modifier.weight(2f)) {
                        NuImage.ProfileHome{
                            onBack()
                        }
                    }

                    NuIcons.Eyes(color = NuColors.white)
                    NuSpace.Small()
                    NuIcons.Info(color = NuColors.white)
                    NuSpace.Small()
                    NuIcons.PersonEmail(color = NuColors.white)
                }
                NuText.SubTitle(
                    "Ola, Paulo ",
                    color = NuColors.white,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
            }

            NuTile.TitleIconBrDescription(
                title = "Conta",
                description = "R$ 189.254,98 ",
                fontWeight = FontWeight.Bold

            )
            NuSpace.Medium()
            LazyRow {
                items(10) {
                    NuCircle.CircleIcon(
                        "Pix",
                        icon = Icons.Default.AccountCircle,
                        iconColor = NuColors.black
                    )
                    NuCircle.CircleIcon(
                        "Pagar",
                        icon = Icons.Default.AccountCircle,
                        iconColor = NuColors.black
                    )
                    NuCircle.CircleIcon(
                        "    Pegar\nEmpréstimo",
                        icon = Icons.Default.AccountCircle,
                        iconColor = NuColors.black,
                        value = "R$ 12.000"
                    )
                    NuCircle.CircleIcon(
                        "Transferir",
                        icon = Icons.Default.AccountCircle,
                        iconColor = NuColors.black
                    )
                    NuCircle.CircleIcon(
                        "Depositar",
                        icon = Icons.Default.AccountCircle,
                        iconColor = NuColors.black
                    )
                }
            }
            NuSpace.Medium()
            NuBoxes.IconText(Icons.Default.Call, "Meus Cartões")

            NuSpace.Medium()
            LazyRow {
                items(10) {
                    NuBoxes.FreeText("Novidade! Conheça a ferramente de controle de Gastos do Nubank.")
                }
            }

            NuDivider.Line()

            NuTile.TitleIconBrSubtitleBrValueBrFreeText(
                title = "Cartão de crédito",
                subtitle = "Fatura atual ",
                value = "R$ 9.254,98 ",
                freeText = "Limite disponivel de R$ 218.850,88\nLimite adiciona para Pix e boletos: R$25.000 "
            )

            NuDivider.Line()

            NuTile.TitleIconBrDescription(
                title = "Emprestimo",
                description = "Valor disponivel de até\nR$ 189.254,98 ",
            )

            NuDivider.Line()

            NuSpace.Large()
        }
    }
}