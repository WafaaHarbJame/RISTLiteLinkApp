package com.ristlitelink.ristlitelink.activities

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ristlitelink.ristlitelink.R
import com.ristlitelink.ristlitelink.UserProfileHeader
import com.ristlitelink.ristlitelink.classes.GrnModel
import com.ristlitelink.ristlitelink.classes.Product
import com.ristlitelink.theme.RISTLiteLinkTheme

class GrnTransactionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RISTLiteLinkTheme {
                GrnTransactionListScreen()


            }

        }
    }

    @Composable
    fun GrnTransactionListScreen() {
        Scaffold(
            topBar = {
//                TopAppBar(
//                    title = { Text(text = "GRN_List") }
//                    // You can add actions if needed
//                )
            },
            bottomBar = {
                val activity = LocalContext.current as? Activity

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Absolute.SpaceAround
                ) {

                    Button(
                        onClick = {

                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(
                                id = R.color.green_dark
                            )
                        ), // Customize background color
                        shape = MaterialTheme.shapes.medium.copy(CornerSize(16.dp)) // Customize corner radius
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_create),
                            contentDescription = stringResource(R.string.add),
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                        )
                        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                        Text(stringResource(R.string.save))
                    }


                    Spacer(modifier = Modifier.width(8.dp))

                    Button(

                        onClick = {
                            activity?.finish()
                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.red)), // Customize background color
                        shape = MaterialTheme.shapes.medium.copy(CornerSize(16.dp)) // Customize corner radius
                    ) {
                        // Add the icon to the button
                        Icon(
                            painter = painterResource(R.drawable.ic_back), // Replace with your icon resource
                            contentDescription = stringResource(R.string.back),
                            modifier = Modifier.size(ButtonDefaults.IconSize) // Default Material icon size
                        )
                        Spacer(Modifier.size(ButtonDefaults.IconSpacing)) // Space between icon and text
                        Text(stringResource(R.string.back))
                    }

                }
            }
        ) { innerPadding ->
            BodyContentTransList(Modifier.padding(innerPadding))
        }

    }

    @Composable
    fun BodyContentTransList(modifier: Modifier = Modifier) {
        Column(modifier = modifier.fillMaxSize()) {
            UserProfileHeader(
                userName = "Lionel Messi", loginTime = "02:33 PM",
                branchName = "Manama,", branchLocation = "Bahrain"
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.grn_no),
                textAlign = TextAlign.End, modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.grn_ic_small),
                    contentDescription = "Icon",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = stringResource(R.string.grn_trans),
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.green_dark),
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "001895343",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.End,
                    color = colorResource(id = R.color.red),
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            SearchCard(onSearchClicked = {})
            ProductList(
                products = listOf(
                    Product(
                        lineNumber = "LN-1",
                        name = "Pepsi 150 ML",
                        barcode = "2576393729839373883",
                        itemCode = "0001937298",
                        reference = "99373883",
                        packId = "PCsv",
                        packing = "150 ML",
                        quantity = "12.000",
                        price = "0.250",
                        amount = "3.000"
                    ),
                    Product(
                        lineNumber = "LN-1",
                        name = "Pepsi 150 ML",
                        barcode = "2576393729839373883",
                        itemCode = "0001937298",
                        reference = "99373883",
                        packId = "PCsv",
                        packing = "150 ML",
                        quantity = "12.000",
                        price = "0.250",
                        amount = "3.000"
                    ),
                    Product(
                        lineNumber = "LN-1",
                        name = "Pepsi 150 ML",
                        barcode = "2576393729839373883",
                        itemCode = "0001937298",
                        reference = "99373883",
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
            GrnTransactionListScreen()


        }
    }




    @Composable
    fun ProductList(products: List<Product>) {
        LazyColumn {
            items(products) { product ->
                ProductCard(product)
            }
        }
    }


    @Composable
    fun ProductCard(product: Product) {
        Card(
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
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(
                                text = product.lineNumber,
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = product.name,
                                style = MaterialTheme.typography.headlineSmall,
                                color = colorResource(id = R.color.red),
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 8.dp)
                            )
                        }
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
                                    label = stringResource(R.string.barcode),
                                    value = product.barcode,
                                    color = colorResource(
                                        id = R.color.green_dark
                                    )
                                )


                                ProductDetail(
                                    label = stringResource(R.string.item_code),
                                    value = product.itemCode,
                                    color = colorResource(
                                        id = R.color.green_dark
                                    )
                                )

                                ProductDetail(
                                    label = stringResource(R.string.reference),
                                    value = product.reference,
                                    color = colorResource(
                                        id = R.color.green_dark
                                    )
                                )

                                ProductDetail(
                                    label = stringResource(R.string.packId),
                                    value = product.packId,
                                    color = colorResource(
                                        id = R.color.green_dark
                                    )
                                )

                                ProductDetail(
                                    label = stringResource(R.string.packing),
                                    value = product.packing,
                                    color = colorResource(
                                        id = R.color.green_dark
                                    )
                                )


                            }
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxSize()
                            ) {
                                ProductDetail(
                                    label = stringResource(R.string.Quantity),
                                    value = product.quantity,
                                    color = colorResource(
                                        id = R.color.red
                                    )
                                )

                                ProductDetail(
                                    label = stringResource(R.string.Price),
                                    value = product.price,
                                    color = colorResource(
                                        id = R.color.red
                                    )
                                )

                                ProductDetail(
                                    label = stringResource(R.string.Amount),
                                    value = product.amount,
                                    color = colorResource(
                                        id = R.color.red
                                    )
                                )
                            }


                        }


                    }


                }


                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(topEnd = 12.dp, bottomEnd = 12.dp))
                            .background(Color.Red)
                            .fillMaxHeight()
                            .clickable(onClick = {}),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_edit),
                                contentDescription = "Edit",
                                tint = Color.White,
                                modifier = Modifier.size(24.dp)
                            )

                            Spacer(
                                modifier = Modifier
                                    .width(20.dp)
                                    .height(1.dp)
                                    .background(color = Color.White)
                            )

                            Icon(
                                painter = painterResource(
                                    id = R.drawable.ic_delete
                                ),
                                contentDescription = "delete",
                                tint = Color.White,
                                modifier = Modifier.size(24.dp)
                            )


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
                color = colorResource(id = R.color.green_dark)
            )
            Text(
                value,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = color,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }


}