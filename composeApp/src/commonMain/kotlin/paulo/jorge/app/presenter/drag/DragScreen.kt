package paulo.jorge.app.presenter.drag

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalViewConfiguration

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

internal val LocalDragTargetInfo = compositionLocalOf { DragTargetInfo() }


@Composable
fun MainScreen(mainViewModel: DragViewModel) {


    val screenWidth = LocalViewConfiguration.current.minimumTouchTargetSize.width

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            mainViewModel.items.forEach { person ->
                DragTarget(
                    dataToDrop = person,
                    viewModel = mainViewModel,
                ) {
                    Box(
                        modifier = Modifier
                            .size(screenWidth)
                            .clip(RoundedCornerShape(15.dp))
                            .shadow(5.dp, RoundedCornerShape(15.dp))
                            .background(person.backgroundColor, RoundedCornerShape(15.dp)),
                        contentAlignment = Alignment.Center,
                    ){
                        Text(
                            text = person.name,
                            style = MaterialTheme.typography.body1,
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }

        AnimatedVisibility(
            mainViewModel.isCurrentlyDragging,
            enter = slideInHorizontally (initialOffsetX = {it})
        ) {
            DropItem<PersonUiItem>(
                modifier = Modifier
                    .size(300.dp)
            ) { isInBound, personItem ->
                if(personItem != null){
                    LaunchedEffect(key1 = personItem){
                        mainViewModel.addPerson(personItem)
                    }
                }
                if(isInBound){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .border(
                                1.dp,
                                color = Color.Red,
                                shape = RoundedCornerShape(15.dp)
                            )
                            .background(Color.Gray.copy(0.5f), RoundedCornerShape(15.dp))
                        ,
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = "Add Person",
                            style = MaterialTheme.typography.body1,
                            color = Color.Black
                        )
                    }
                }else{
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .border(
                                1.dp,
                                color = Color.White,
                                shape = RoundedCornerShape(15.dp)
                            )
                            .background(
                                Color.Black.copy(0.5f),
                                RoundedCornerShape(15.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = "Add Person",
                            style = MaterialTheme.typography.body1,
                            color = Color.White
                        )
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(
                    topStart = 15.dp,
                    topEnd = 15.dp
                )).background(Color.Black)
                .fillMaxSize()
                .padding(top = 10.dp)
            ,
            contentAlignment = Alignment.Center
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .padding(bottom = 100.dp)
                ,
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ){
                Text(
                    text = "Added Persons",
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start
                )
                mainViewModel.addedPersons.forEach { person ->
                    Text(
                        text = person.name,
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}