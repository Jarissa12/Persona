package com.example.personas
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.personas.ui.theme.PersonasTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.app.DatePickerDialog
import android.util.Log
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import java.util.*
import androidx.compose.material.Button
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.toSize


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersonasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                  View()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun View(){
    Column {
        TextoPersona()
        Nombres()
        Telefono()
        Celular()
        Email()
        Direccion()
        FechaNacimiento()
        ComboBox()
        Boton()
    }
}
@Composable
fun TextoPersona (){

    Text("Registro de Personas  ",
        Modifier
            .padding(40.dp)
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center),fontSize = 25.sp)
}

@Composable
fun Nombres(){

    var selectedText by remember { mutableStateOf("") }
    var textfieldSize by remember { mutableStateOf(Size.Zero)}

    TextField(
        value = selectedText,
        onValueChange = { selectedText = it },
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .onGloballyPositioned { coordinates ->
                //This value is used to assign to the DropDown the same width
                textfieldSize = coordinates.size.toSize()
            },
        label = { Text("Nombres", fontSize = 19.sp) },
    )

}


@Composable
fun Telefono(){

    var selectedText by remember { mutableStateOf("") }
    var textfieldSize by remember { mutableStateOf(Size.Zero)}

    var text by remember()
    {
        mutableStateOf("")

    }

    TextField(
        value = selectedText,
        onValueChange = { selectedText=it },
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .onGloballyPositioned { coordinates ->
                //This value is used to assign to the DropDown the same width
                textfieldSize = coordinates.size.toSize()
            },
        label = {Text("Telefono", fontSize = 19.sp)},
    )
}

@Composable
fun ComboBox(){

    val Ocupaciones = listOf("Abogada ", "Profesor "," Obrero","Ingeniero" )
    var OcupacionSelecionada by remember { mutableStateOf("") }
    var expandido by remember { mutableStateOf( false) }

    Column(modifier = Modifier.fillMaxWidth()){

       TextField(

           label ={ Text ("Ocupacion ")},
           trailingIcon = {

               Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)

           },
           value = OcupacionSelecionada, onValueChange = { OcupacionSelecionada ==it },
       readOnly = true,enabled = false ,
       modifier = Modifier
           .clickable {
               expandido = true
               Log.e("tag", "expandido ")

           }
           .fillMaxWidth().wrapContentSize(Alignment.Center)


       )


        DropdownMenu(
            expanded = expandido,
            onDismissRequest = { expandido = false },
            modifier = Modifier.fillMaxWidth()
        )
        {

            Ocupaciones.forEach { item ->
                DropdownMenuItem(onClick = {
                    expandido = false
                    OcupacionSelecionada = item
                }) {

                    Text(text = item)

                }
            }

        }


    }
}

@Composable
fun Celular (){

    var selectedText by remember { mutableStateOf("") }
    var textfieldSize by remember { mutableStateOf(Size.Zero)}

    TextField(
        value = selectedText,
        onValueChange = { selectedText=it },
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .onGloballyPositioned { coordinates ->
                //This value is used to assign to the DropDown the same width
                textfieldSize = coordinates.size.toSize()
            },
        label = {Text("Celular", fontSize = 19.sp)},
    )
}


@Composable
fun Email(){
    var selectedText by remember { mutableStateOf("") }
    var textfieldSize by remember { mutableStateOf(Size.Zero)}

    TextField(
        value = selectedText,
        onValueChange = { selectedText=it },
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .onGloballyPositioned { coordinates ->
                //This value is used to assign to the DropDown the same width
                textfieldSize = coordinates.size.toSize()
            },
        label = {Text("Email", fontSize = 19.sp)},
    )

}



@Composable
fun Direccion (){
    var selectedText by remember { mutableStateOf("") }
    var textfieldSize by remember { mutableStateOf(Size.Zero)}


    TextField(

        value = selectedText,
        onValueChange = { selectedText=it },
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .onGloballyPositioned { coordinates ->
                //This value is used to assign to the DropDown the same width
                textfieldSize = coordinates.size.toSize()
            },
        label = {Text("Dirección", fontSize = 19.sp)},
    )


}
@Composable
fun FechaNacimiento (){

    var fecha by rememberSaveable { mutableStateOf("") }
    val anio:Int
    val mes:Int
    val dia:Int

    val mCalendar = Calendar.getInstance()
    anio = mCalendar.get(Calendar.YEAR)
    mes = mCalendar.get(Calendar.MONTH)
    dia = mCalendar.get(Calendar.DAY_OF_MONTH)

    val mDatePickerDialog = DatePickerDialog(
        LocalContext.current,
        {
                _ :DatePicker, anio:Int, mes:Int, dia:Int ->
            fecha = "$dia/${mes+1}/$anio"
        },anio,mes,dia
    )

    TextField(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center),
        value = fecha,
        onValueChange = {fecha = it},
        readOnly = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.DateRange,
                contentDescription = null,
                modifier = Modifier
                    .size(33.dp)
                    .padding(4.dp)
                    .clickable {
                        mDatePickerDialog.show()
                    }
            )
        },
        label = {Text(text = "Fecha de nacimiento", fontSize = 19.sp)}
    )
}


@Composable
fun Boton() {
    Button(
        onClick = { },
        modifier = Modifier
            .height(64.dp)
            .padding(5.dp)
            .fillMaxSize()
            .width(50.dp),
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFD5A20AA),
            contentColor = Color.White,
            disabledContentColor = Color.White,
        )
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_save_alt_24),
            contentDescription = "Header",
            modifier = Modifier
        )

        Text(
            text = " Guardar",
            fontSize = 15.sp,
            textAlign = TextAlign.Center, modifier = Modifier
        )

    }
    @Composable
    fun showDatePicker(modifier: Modifier) {

        var fecha by rememberSaveable { mutableStateOf("") }
        val anio: Int
        val mes: Int
        val dia: Int

        val mCalendar = Calendar.getInstance()
        anio = mCalendar.get(Calendar.YEAR)
        mes = mCalendar.get(Calendar.MONTH)
        dia = mCalendar.get(Calendar.DAY_OF_MONTH)

        val mDatePickerDialog = DatePickerDialog(
            LocalContext.current,
            { _: DatePicker, anio: Int, mes: Int, dia: Int ->
                fecha = "$dia/${mes + 1}/$anio"
            }, anio, mes, dia
        )

        Row() {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(5.dp),
                value = fecha,
                onValueChange = { fecha = it },
                readOnly = true,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.DateRange,
                        contentDescription = null,
                        modifier = Modifier
                            .size(33.dp)
                            .padding(4.dp)
                            .clickable {
                                mDatePickerDialog.show()
                            }
                    )
                },
                label = { Text(text = "Fecha de nacimiento", fontSize = 19.sp) }
            )
        }

    }
}