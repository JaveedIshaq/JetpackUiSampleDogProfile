package com.javeedishaq.dogprofilepage
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import kotlin.math.ceil

@Composable
fun  ProfilePageConstraints(){




    Card (
        elevation= 6.dp,
        modifier = Modifier.padding(40.dp)

    )  {

     BoxWithConstraints() {
         val constraintsVal = if(minWidth < 600.dp){
             portraitConstraints(margin = 16.dp)
     }   else{
             landscapeConstraints(margin = 16.dp)
     }


    //Content of our Card including Dog Profile content
    ConstraintLayout(constraintsVal) {


        Image(painter = painterResource(id =  R.drawable.portrait_husky_dog_24934987),
         contentDescription = "Huski",
         modifier = Modifier
             .size(200.dp)
             .clip(CircleShape)
             .border(
                 width = 2.dp,
                 color = Color.Red,
                 shape = CircleShape
             )
             .layoutId("image"),
         contentScale = ContentScale.Crop,

     )
     Text(text = "Siberian Huski",
         modifier = Modifier
             .padding(10.dp)
             .layoutId("nameText")
     )
     Text(
         text = "Germany",
         modifier = Modifier
             .padding(10.dp)
             .layoutId("locationText")
     )
     Row (
         horizontalArrangement = Arrangement.SpaceEvenly,
         modifier = Modifier
             .fillMaxWidth()
             .padding(top = 16.dp)
             .layoutId("statRow")
             ){
         ProfileStatsConstraints("150", "Followers")
         ProfileStatsConstraints("100", "Following")
         ProfileStatsConstraints("30", "Posts")
     }
        Row (
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .layoutId("buttonsRow")
        ){
            Button(onClick = {}) {
                Text(text = "Follow User")
            }
            Button(onClick = {}) {
                Text(text = "Direct Message")
            }
        }

        inputWithState("",
            Modifier
                .fillMaxWidth()
                .layoutId("commentInput"))


    }
     }
    }
}


private fun portraitConstraints(margin: Dp): ConstraintSet{
    return ConstraintSet{
        val image = createRefFor("image")
        val nameText = createRefFor("nameText")
        val locationText = createRefFor("locationText")
        val statRow = createRefFor("statRow")
        val buttonsRow = createRefFor("buttonsRow")
        val commentInput = createRefFor("commentInput")

        constrain(image){
            top.linkTo(parent.top, margin)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(nameText){
            top.linkTo(image.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(locationText){
            top.linkTo(nameText.top, margin)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(statRow){
            top.linkTo(locationText.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(buttonsRow){
            top.linkTo(statRow.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(commentInput){
            top.linkTo(buttonsRow.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

    }
}

private fun landscapeConstraints(margin: Dp): ConstraintSet{
    return ConstraintSet{
        val image = createRefFor("image")
        val nameText = createRefFor("nameText")
        val locationText = createRefFor("locationText")
        val statRow = createRefFor("statRow")
        val buttonsRow = createRefFor("buttonsRow")

        constrain(image){
            top.linkTo(parent.top, margin)
            start.linkTo(parent.start, margin)
        }

        constrain(nameText){
            top.linkTo(parent.top)
            start.linkTo(image.start)
            end.linkTo(parent.end)
        }

        constrain(locationText){
            top.linkTo(nameText.bottom)
            start.linkTo(image.start)
            end.linkTo(parent.end)
        }

        constrain(statRow){
            top.linkTo(locationText.bottom)
            start.linkTo(image.end)
            end.linkTo(parent.end)
        }

        constrain(buttonsRow){
            top.linkTo(statRow.bottom)
            start.linkTo(image.end)
            end.linkTo(parent.end)
        }

    }
}

@Composable
fun inputWithState(name:String, modifier: Modifier){

    var inputState by remember {
        mutableStateOf("")
    }


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(20.dp)) {
        TextField(value = inputState, onValueChange = {
            inputState = it
        } )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Hello $inputState")
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Display")
        }

    }
}

@Composable
fun ProfileStatsConstraints(count:String, title:String){
    Column(horizontalAlignment = Alignment.CenterHorizontally,) {
        Text(text = count)
        Text(text = title, fontWeight = FontWeight.Bold)
    }
}