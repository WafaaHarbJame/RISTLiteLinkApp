package com.ristlitelink.ristlitelink.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ristlitelink.ristlitelink.R
import com.ristlitelink.ristlitelink.classes.Constants
import com.ristlitelink.ristlitelink.models.SupplierInfo
import com.ristlitelink.theme.RISTLiteLinkTheme

class SuppliersActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RISTLiteLinkTheme {

                SupplierScreen()
            }

        }
    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {

        RISTLiteLinkTheme {
            SupplierScreen()

        }
    }


}


@Composable
fun SupplierItem(info: SupplierInfo, onCardClick: (SupplierInfo) -> Unit) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = { onCardClick(info) })
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = info.supplierName,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.green_dark), fontSize = 15.sp
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                TextWithMultipleColors(
                    label = stringResource(R.string.currency_code),
                    value = info.currencyCode,
                    labelColor = colorResource(id = R.color.green_dark),
                    valueColor = Color.Red,
                    modifier = Modifier.alignByBaseline()
                )
                Spacer(Modifier.weight(1f))

                TextWithMultipleColors(
                    label = stringResource(R.string.code),
                    value = info.code,
                    labelColor = colorResource(id = R.color.green_dark),
                    valueColor = Color.Red,
                    modifier = Modifier
                )
            }
            Spacer(modifier = Modifier.height(4.dp))

            Row {
                TextWithMultipleColors(
                    label = stringResource(R.string.currency_rate),
                    value = info.currencyRate,
                    labelColor = colorResource(id = R.color.green_dark),
                    valueColor = Color.Red, modifier = Modifier.alignByBaseline()
                )
                Spacer(Modifier.weight(1f))

                TextWithMultipleColors(
                    label = stringResource(R.string.vat_no),
                    value = info.vatNo,
                    labelColor = colorResource(id = R.color.green_dark),
                    valueColor = Color.Red, Modifier.alignByBaseline()
                )
            }
        }
    }
}


@Composable
fun SupplierEditItem(info: SupplierInfo) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = info.supplierName,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.green_dark), fontSize = 15.sp
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                TextWithMultipleColors(
                    label = stringResource(R.string.currency_code),
                    value = info.currencyCode,
                    labelColor = colorResource(id = R.color.green_dark),
                    valueColor = Color.Red,
                    modifier = Modifier.alignByBaseline()
                )
                Spacer(Modifier.weight(1f))

                TextWithMultipleColors(
                    label = stringResource(R.string.code),
                    value = info.code,
                    labelColor = colorResource(id = R.color.green_dark),
                    valueColor = Color.Red,
                    modifier = Modifier
                )
            }
            Spacer(modifier = Modifier.height(4.dp))

            Row {
                TextWithMultipleColors(
                    label = stringResource(R.string.currency_rate),
                    value = info.currencyRate,
                    labelColor = colorResource(id = R.color.green_dark),
                    valueColor = Color.Red, modifier = Modifier.alignByBaseline()
                )
                Spacer(Modifier.weight(1f))

                TextWithMultipleColors(
                    label = stringResource(R.string.vat_no),
                    value = info.vatNo,
                    labelColor = colorResource(id = R.color.green_dark),
                    valueColor = Color.Red, Modifier.alignByBaseline()
                )
            }
        }
    }
}

@Composable
fun TextWithMultipleColors(
    label: String,
    value: String,
    labelColor: Color,
    valueColor: Color,
    modifier: Modifier
) {
    Row {
        Text(
            text = label,
            color = labelColor,
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = value,
            color = valueColor,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun SupplierScreen() {
    // This should come from your ViewModel or a similar data source
    val suppliers = listOf(
        SupplierInfo(
            "Rist Information systems and Technology Co W.L.L",
            "BHD",
            "SU0001",
            "1.000",
            "2050000217"
        ), SupplierInfo(
            "Rist Information systems and Technology Co W.L.L",
            "BHD",
            "SU0001",
            "1.000",
            "2050000217"
        ),
        SupplierInfo(
            "Rist Information systems and Technology Co W.L.L",
            "BHD",
            "SU0001",
            "1.000",
            "2050000217"
        ),
        SupplierInfo(
            "Rist Information systems and Technology Co W.L.L",
            "BHD",
            "SU0001",
            "1.000",
            "2050000217"
        )
        // Add more SupplierInfo objects...
    )

    // This function is called when the search icon is clicked
    val handleSearchClicked = {
        // Handle search icon click
    }

    // This function is called when the close icon is clicked
    val handleCloseClicked = {
        // Handle close icon click
    }

    Column {
        SupplierDetailsHeader(
            onSearchClicked = handleSearchClicked,
            onCloseClicked = handleCloseClicked
        )
        SearchCard(onSearchClicked = {})
        SuppliersList(suppliers = suppliers)
    }

}

@Composable
fun SupplierDetailsHeader(onSearchClicked: () -> Unit, onCloseClicked: () -> Unit) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = stringResource(id = R.string.supplier_details),
                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.weight(1f))

            IconButton(onClick = onCloseClicked) {
                Image(
                    painterResource(id = R.drawable.ic_close_supplier),
                    contentDescription = "Close",

                    )
            }
        }
    }
}


@Composable
fun SearchCard(onSearchClicked: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Search Here",
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold)
            )
            IconButton(
                onClick = onSearchClicked,
                modifier = Modifier.size(24.dp) // adjust the size of the IconButton if needed
            ) {
                Image(
                    painterResource(id = R.drawable.ic_search),
                    contentDescription = "Search",

                    )
            }
        }
    }
}


@Composable
fun SuppliersList(suppliers: List<SupplierInfo>) {
    val context = LocalContext.current

    LazyColumn {
        items(suppliers) { supplier ->
            SupplierItem(info = supplier, onCardClick = { selectedSupplier ->
                val intent = Intent(context, CreateGrnActivity::class.java).apply {
                    putExtra(Constants.supplier_data, selectedSupplier)
                }
                context.startActivity(intent)

            })
        }
    }
}






