@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class
)

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.activity5.R

@Composable
fun HalamanSatu(
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    onBackButtonClicked: () -> Unit
){
    var namaText by remember { mutableStateOf("") }
    var alamatText by remember { mutableStateOf("") }
    var noTlpText by remember { mutableStateOf("") }

    var listData : MutableList<String> = mutableListOf(namaText,alamatText, noTlpText)

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ){
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Text(text = "Data Pelanggan", fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = namaText,
            onValueChange = {namaText = it},
            label = { Text(text = stringResource(id = R.string.nama)) }
        )

        OutlinedTextField(
            value = alamatText,
            onValueChange = {alamatText = it},
            label = { Text(text = stringResource(id = R.string.alamat)) }
        )

        OutlinedTextField(
            value = noTlpText,
            onValueChange = {noTlpText = it},
            label = { Text(text = stringResource(id = R.string.notlp)) }
        )

        Spacer(modifier = Modifier.padding(10.dp))


        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding_medium))
            .weight(1f, false),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            verticalAlignment = Alignment.Bottom
        ){
            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = onBackButtonClicked

            ){
                Text(stringResource(R.string.btn_back))
            }
            Button(
                modifier = Modifier.weight(1f),
                onClick = {onSubmitButtonClicked(listData)}
            ){
                Text(stringResource(R.string.next))
            }
        }

    }
}

@Preview
@Composable
fun HalamanSatuPreview(){
    HalamanSatu(onSubmitButtonClicked = {}) {}
}