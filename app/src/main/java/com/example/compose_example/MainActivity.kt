package com.example.compose_example

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_example.ui.theme.Compose_ExampleTheme


private  val messages:List<MyMessage> = listOf(
    MyMessage("titulo 1","Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen. No sólo sobrevivió 500 años, sin"),
    MyMessage("titulo 2","Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen. No sólo sobrevivió 500 años, sin"),
    MyMessage("titulo 3","Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen. No sólo sobrevivió 500 años, sin"),
    MyMessage("titulo 4","Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido "),
    MyMessage("titulo 5","usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen. No sólo sobrevivió 500 años, sin"),
    MyMessage("titulo 6","usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen. No sólo sobrevivió 500 años, sin"),
    MyMessage("titulo 7"," ingresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas \"Letraset\", las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, el cual incluye versiones de Lorem Ipsum."),
    MyMessage("titulo 8"," ingresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas \"Letraset\", las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, el cual incluye versiones de Lorem Ipsum."),
    MyMessage("titulo 9"," ingresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas \"Letraset\", las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, el cual incluye versiones de Lorem Ipsum."),
    MyMessage("titulo 10"," ingresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas \"Letraset\", las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, el cual incluye versiones de Lorem Ipsum."),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Compose_ExampleTheme {
                MyMessages(messages)
            }

        }
    }
}

data class  MyMessage(val title:String, val body:String)



@Composable 
fun MyMessages(messages:List<MyMessage>) {
    
    LazyColumn{
        items(messages){
            message -> MyComponet(message = message)
        }
    }
}

@Composable
fun MyComponet(message: MyMessage){
    Row(modifier = Modifier
        .padding(8.dp)
        .background(MaterialTheme.colors.background)
    ) {
        MyImage()
        MyTexts(message)
    }
}

@Composable
fun MyImage(){
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground)
        , contentDescription ="Imagen",
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp, bottom = 8.dp, top = 8.dp)
            .size(64.dp)
            .clip(CircleShape)
            .background(Color.Gray)
    )
}


@Composable
fun MyTexts(message:MyMessage){
    var expanded by remember { mutableStateOf(false)}

    Column(modifier = Modifier.clickable {

        expanded =!expanded
    }) {
        MyText(text = message.title,
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.caption)
        Spacer(modifier = Modifier.height(20.dp))
        MyText(text = message.body,
            color = MaterialTheme.colors.secondary,
        style = MaterialTheme.typography.body2,
            if(expanded) Int.MAX_VALUE else 1)
    }

}

@Composable
fun MyText(text:String,
           color:Color,
           style: TextStyle,
           line:Int = Int.MAX_VALUE)
{
    Text(text = text,
        color= color,
        style= style,
        maxLines = line)
}


@Preview(showSystemUi = true)
@Composable
fun PreviewComponet2() {
    Compose_ExampleTheme {

        MyMessages(messages = messages)

    }
}


