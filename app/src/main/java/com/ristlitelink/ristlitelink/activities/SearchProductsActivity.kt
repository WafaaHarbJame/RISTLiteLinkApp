package com.ristlitelink.ristlitelink.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ristlitelink.theme.RISTLiteLinkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.ristlitelink.ristlitelink.R
import com.ristlitelink.ristlitelink.classes.Product


class SearchProductsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RISTLiteLinkTheme {
                SearchProductsScreen()


            }

        }
    }

    @Composable
    fun SearchProductsScreen() {
        Scaffold(
        ) { innerPadding ->
            BodyContentSearchProducts(Modifier.padding(innerPadding))
        }

    }

     @Composable
    fun BodyContentSearchProducts(modifier: Modifier) {
         var searchText by remember { mutableStateOf("") }

         Column(modifier = Modifier
             .fillMaxSize()
             .padding(16.dp)) {

             Row(
                 modifier = Modifier
                     .fillMaxWidth(),
                 verticalAlignment = Alignment.CenterVertically
             ) {
                 Spacer(modifier = Modifier.weight(1f))
                 IconButton(onClick = { /* handle close action */ }) {
                     Image(
                         painter = painterResource(id = R.drawable.ic_close_supplier),
                         contentDescription = "Close"
                     )
                 }
             }

             Text(
                 text = stringResource(R.string.search_products),
                 style = MaterialTheme.typography.headlineSmall.copy(fontSize = 24.sp), fontWeight = FontWeight.Bold,
                 color = colorResource(id = R.color.green_dark),
                 modifier = Modifier.align(Alignment.CenterHorizontally)
             )
             Spacer(modifier = Modifier.height(32.dp))

            Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
             var descState by remember { mutableStateOf(true) }
             var barcodeState by remember { mutableStateOf(true) }

             CustomCheckbox(
                 modifier = Modifier.weight(1f),
                 checked = descState,
                 onCheckedChange = { descState = it },
                 label = stringResource(id = R.string.description)
             )

             CustomCheckbox(
                 modifier = Modifier.weight(1f),
                 checked = barcodeState,
                 onCheckedChange = { barcodeState = it },
                 label = stringResource(id = R.string.barcode)
             )

         }

             Spacer(modifier = Modifier.height(8.dp))
             SearchCard {
                 
             }

             ProductList(
                 products = listOf(
                     Product(
                         lineNumber = "LN-1",
                         name = "Pepsi 150 ML",
                         barcode = "#4567262772",
                         itemCode ="#4567262772",
                         reference = "#4567262772",
                         packId = "PCsv",
                         packing = "150 ML",
                         quantity = "12.000",
                         price = "0.250",
                         amount = "3.000"
                     ),
                     Product(
                         lineNumber = "LN-1",
                         name = "Pepsi 150 ML",
                         barcode = "#4567262772",
                         itemCode ="#4567262772",
                         reference = "#4567262772",
                         packId = "PCsv",
                         packing = "150 ML",
                         quantity = "12.000",
                         price = "0.250",
                         amount = "3.000"
                     ),
                     Product(
                         lineNumber = "LN-1",
                         name = "Pepsi 150 ML",
                         barcode = "#4567262772",
                         itemCode ="#4567262772",
                         reference = "#4567262772",
                         packId = "PCsv",
                         packing = "150 ML",
                         quantity = "12.000",
                         price = "0.250",
                         amount = "3.000"
                     )
                 )
                 ,


                 )


         }

    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {

        RISTLiteLinkTheme {
            SearchProductsScreen()


        }
    }


    @Composable
    fun CustomCheckbox(
        modifier: Modifier,
        checked: Boolean,
        onCheckedChange: (Boolean) -> Unit,
        label: String
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .clickable { onCheckedChange(!checked) }
                .padding(8.dp)


        ) {
            Image(
                painter = if (checked) painterResource(id = R.drawable.ic_checked) else painterResource(
                    id = R.drawable.ic_un_checked
                ),
                contentDescription = if (checked) "Checked" else "Unchecked",
                modifier = Modifier.size(30.dp)

            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black, modifier = Modifier.fillMaxWidth()
            )
        }
    }

    @Composable
    fun ProductList(products: List<Product>) {
        LazyColumn {
            items(products) { product ->
                ProductCardSearch(product)
            }
        }
    }

    @Composable
    fun ProductCardSearch(product: Product) {
        androidx.compose.material3.Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp),

            shape = RoundedCornerShape(8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.height(IntrinsicSize.Min)
            ) {
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .background(colorResource(id = R.color.gray)),

                    ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Text(
                            text = product.name,
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxSize()
                            ) {

                                ProductDetail(
                                    label = stringResource(R.string.Price),
                                    value = product.price,
                                    color = colorResource(
                                        id = R.color.red
                                    )
                                )


                                ProductDetail(
                                    label = stringResource(R.string.product_id),
                                    value = product.barcode,
                                    color = colorResource(
                                        id = R.color.red
                                    )
                                )

                                ProductDetail(
                                    label = stringResource(R.string.packId),
                                    value = product.packId,
                                    color = colorResource(
                                        id = R.color.red
                                    )
                                )




                            }

//                            Spacer(modifier =Modifier.width(8.dp) )
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxSize()
                            ) {
                                ProductDetail(
                                    label = stringResource(R.string.barcode),
                                    value = product.barcode,
                                    color = colorResource(
                                        id = R.color.red
                                    )
                                )

                                ProductDetail(
                                    label = stringResource(R.string.reference),
                                    value = product.reference,
                                    color = colorResource(
                                        id = R.color.red
                                    )
                                )

                                ProductDetail(
                                    label = stringResource(R.string.umUnit),
                                    value = product.quantity,
                                    color = colorResource(
                                        id = R.color.red
                                    )
                                )
                            }


                        }


                    }


                }




            }


        }
    }

    @Composable
    fun ProductDetail(label: String, value: String, color: Color) {
        Row {
            Text(
                "$label: ",
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                color = colorResource(id = R.color.green_dark)
            )
            Text(
                value,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = color,
                fontSize = 10.sp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }



}