package paulo.jorge.app.presenter.store

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import paulo.jorge.app.presenter.store.account.ContentAccount
import paulo.jorge.app.presenter.store.coupons.Coupons
import paulo.jorge.app.presenter.store.home.ContentHome
import paulo.jorge.app.presenter.store.home.components.Header
import paulo.jorge.app.presenter.store.search.ContentSearch
import paulo.jorge.app.presenter.store.settings.ContentSettings

enum class Action {
    HOME, ACCOUNT, SEARCH, SETTINGS, COUPON
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBottomNavigation(
    onBack: () -> Unit
) {

    var action by remember { mutableStateOf(Action.HOME) }
    var isNewUser by remember { mutableStateOf(false) }
    var oldAction: Action? = null

    Scaffold(
        content = {
            Box(
                modifier = Modifier
                    .padding(
                        top = 58.dp,
                    )
            ) {
                when (action) {
                    Action.HOME -> ContentHome()
                    Action.ACCOUNT -> ContentAccount(isNewUser)
                    Action.SEARCH -> ContentSearch()
                    Action.SETTINGS -> ContentSettings()
                    Action.COUPON -> Box {}
                }
                AnimatedVisibility(
                    visible = action == Action.COUPON,
                    enter = expandVertically(
                        // Expand from the top.
                        expandFrom = Alignment.Top
                    ) + fadeIn(
                        // Fade in with the initial alpha of 0.3f.
                        initialAlpha = 0.3f
                    ),
                    exit = slideOutVertically() + shrinkVertically() + fadeOut()
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxSize(70f),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        item {
                            Coupons("MAX10", "Digite MAX10 para ganhar 10% de desconto",
                                Color(0xFF442c2E)
                            )
                            Spacer(Modifier.height(10.dp))
                            Coupons("MAX20", "Digite MAX20 para ganhar 20% de desconto", Color.Blue)
                            Spacer(Modifier.height(10.dp))
                            Coupons("MAX30", "Digite MAX30 para ganhar 30% de desconto", Color.Black)
                        }
                    }
                }
            }
        },
        floatingActionButton = {
            AnimatedVisibility(
                visible = action != Action.SEARCH && action != Action.ACCOUNT,
                enter = expandVertically(
                    // Expand from the top.
                    expandFrom = Alignment.Top
                ) + fadeIn(
                    // Fade in with the initial alpha of 0.3f.
                    initialAlpha = 0.3f
                ),
                exit = slideOutVertically() + shrinkVertically() + fadeOut()
            ) {
                FloatingActionButton(
                    onClick = {
                        if (oldAction != null) {
                            action = oldAction!!
                            oldAction = null
                        } else {
                            oldAction = action
                            action = Action.COUPON
                        }

                    },
                    modifier = Modifier.clip(
                        RoundedCornerShape(
                            topStart = 30.dp,
                            topEnd = 30.dp,
                            bottomEnd = 0.dp,
                            bottomStart = 30.dp
                        )
                    ),
                    containerColor = if (oldAction != null) Color.Red else Color(0xFF442c2E),
                ) {
                    Icon(
                        imageVector = if (oldAction != null) Icons.Filled.Close else Icons.Filled.MoreVert,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        },
        topBar = {
            AnimatedVisibility(
                visible = action == Action.SEARCH,
                enter = expandVertically(
                    // Expand from the top.
                    expandFrom = Alignment.Top
                ) + fadeIn(
                    // Fade in with the initial alpha of 0.3f.
                    initialAlpha = 0.3f
                ),
                exit = slideOutVertically() + shrinkVertically() + fadeOut()
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth().padding(10.dp),
                    placeholder = {
                        Text(text = "Search here...")
                    },
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null
                        )
                    }
                )
            }
            AnimatedVisibility(
                visible = action != Action.SEARCH && action != Action.ACCOUNT,
                enter = expandVertically(
                    // Expand from the top.
                    expandFrom = Alignment.Top
                ) + fadeIn(
                    // Fade in with the initial alpha of 0.3f.
                    initialAlpha = 0.3f
                ),
                exit = slideOutVertically() + shrinkVertically() + fadeOut()
            ) {
                Header(){
                    onBack()
                }
            }
            AnimatedVisibility(
                visible = action == Action.ACCOUNT,
                enter = expandVertically(
                    // Expand from the top.
                    expandFrom = Alignment.Top
                ) + fadeIn(
                    // Fade in with the initial alpha of 0.3f.
                    initialAlpha = 0.3f
                ),
                exit = slideOutVertically() + shrinkVertically() + fadeOut()
            ) {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(Color(0xFFFEDBD0))
                        .fillMaxWidth(),

                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "ACCOUNT",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(10.dp)
                    )
                    IconButton(
                        onClick = {
                            isNewUser = !isNewUser
                        },
                    ) {

                        Icon(
                            imageVector = if (isNewUser) {
                                Icons.Filled.Refresh
                            } else {
                                Icons.Filled.AddCircle
                            },
                            contentDescription = null
                        )
                    }
                }
            }
        },
        bottomBar = {
            BottomNavigation(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)),
                backgroundColor = Color(0xFFFEDBD0),
                contentColor = Color(0xFF442c2E)
            ) {
                BottomNavigationItem(
                    selected = action == Action.HOME,
                    onClick = { action = Action.HOME },
                    label = { Text(text = "Home") },
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) }
                )

                BottomNavigationItem(
                    selected = action == Action.ACCOUNT,
                    onClick = { action = Action.ACCOUNT },
                    label = { Text(text = "Account") },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = null
                        )
                    }
                )
                BottomNavigationItem(
                    selected = action == Action.SEARCH,
                    onClick = { action = Action.SEARCH },
                    label = { Text(text = "Search") },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null
                        )
                    }
                )
                BottomNavigationItem(
                    selected = action == Action.SETTINGS,
                    onClick = { action = Action.SETTINGS },
                    label = { Text(text = "Setting") },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = null
                        )
                    }
                )

            }
        }
    )
}
