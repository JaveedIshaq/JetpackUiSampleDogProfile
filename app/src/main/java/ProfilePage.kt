package com.javeedishaq.dogprofilepage
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.ceil

@Composable
fun  ProfilePage(){
    Card (
        elevation= 6.dp,
        modifier = Modifier.padding(40.dp)

    ){

        //Content of our Card including Dog Profile content
    Column  (
        Modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
            ){
     Image(painter = painterResource(id =  R.drawable.portrait_husky_dog_24934987),
         contentDescription = "Huski",
         modifier = Modifier
             .size(200.dp)
             .clip(CircleShape)
             .border(width = 2.dp, color = Color.Red, shape = CircleShape),
         contentScale = ContentScale.Crop,

     )
     Text(text = "Siberian Huski", modifier = Modifier.padding(10.dp))
     Text(text = "Germany")
     Row (
         horizontalArrangement = Arrangement.SpaceEvenly,
         modifier = Modifier
             .fillMaxWidth()
             .padding(top = 16.dp)
             ){
         ProfileStats("150", "Followers")
         ProfileStats("100", "Following")
         ProfileStats("30", "Posts")
     }
        Row (
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ){
            Button(onClick = {}) {
                Text(text = "Follow User")
            }
            Button(onClick = {}) {
                Text(text = "Direct Message")
            }
        }
    }
    }
}

@Composable
fun ProfileStats(count:String, title:String){
    Column(horizontalAlignment = Alignment.CenterHorizontally,) {
        Text(text = count)
        Text(text = title, fontWeight = FontWeight.Bold)
    }
}