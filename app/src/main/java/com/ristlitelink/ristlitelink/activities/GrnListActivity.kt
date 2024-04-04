package com.ristlitelink.ristlitelink.activities

import android.app.Activity
import android.content.Intent
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
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.Icon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
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
import androidx.compose.ui.unit.sp
import com.ristlitelink.ristlitelink.R
import com.ristlitelink.ristlitelink.UserProfileHeader
import com.ristlitelink.ristlitelink.classes.GridItem
import com.ristlitelink.ristlitelink.classes.GrnModel
import com.ristlitelink.theme.RISTLiteLinkTheme


class GrnListActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            RISTLiteLinkTheme {
                GrnListScreen()


            }

        }
    }

}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        UserProfileHeader(
            userName = "Lionel Messi", loginTime = "02:33 PM",
            branchName = "Manama", branchLocation = "Bahrain"
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.grn_ic_small),
                contentDescription = "Icon",
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = stringResource(R.string.grn_list),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        SupplierListScreen()

    }
}


@Composable
fun GridScreen(items: List<GridItem>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        contentPadding = PaddingValues(8.dp),
        content = {
            items(items.size) { index ->
                GridItemCard(gridItem = items[index])
            }
        }
    )
}

@Composable
fun GridItemCard(gridItem: GridItem) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = gridItem.backgroundColor,
        ),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .aspectRatio(1f), // Makes the card square

    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = gridItem.imageIcon, contentDescription = gridItem.text)
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text(
                text = gridItem.text,
                color = if (gridItem.id == "12") Color.White else Color.Black
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    RISTLiteLinkTheme {
        GrnListScreen()


    }
}


@Composable
fun listItemList(): List<GridItem> {
    return listOf(
        GridItem(
            id = "1",
            backgroundColor = colorResource(id = R.color.gray),
            imageIcon = painterResource(
                id = R.drawable.ic_grn
            ),
            text = stringResource(R.string.grn)
        ),
        GridItem(
            id = "2",
            backgroundColor = colorResource(id = R.color.gray),
            imageIcon = painterResource(R.drawable.ic_damaged_item),
            text = stringResource(R.string.purchase_return)
        ),
        GridItem(
            id = "3",
            backgroundColor = colorResource(id = R.color.gray),
            imageIcon = painterResource(R.drawable.ic_invoice),
            text = stringResource(R.string.invoice)
        ),


        GridItem(
            id = "4",
            backgroundColor = colorResource(id = R.color.gray),
            imageIcon = painterResource(
                id = R.drawable.ic_quotation
            ),
            text = stringResource(R.string.quotation)
        ),
        GridItem(
            id = "5",
            backgroundColor = colorResource(id = R.color.gray),
            imageIcon = painterResource(R.drawable.ic_request_item),
            text = stringResource(R.string.request_item)
        ),
        GridItem(
            id = "6",
            backgroundColor = colorResource(id = R.color.gray),
            imageIcon = painterResource(R.drawable.ic_transfer),
            text = stringResource(R.string.transfer)
        ),
        GridItem(
            id = "7", colorResource(id = R.color.gray), imageIcon = painterResource(
                id = R.drawable.ic_adjustment
            ), text = stringResource(R.string.adjustment)
        ),
        GridItem(
            id = "8",
            backgroundColor = colorResource(id = R.color.gray),
            imageIcon = painterResource(R.drawable.ic_damaged_item),
            text = stringResource(R.string.damaged_item)
        ),
        GridItem(
            id = "9",
            backgroundColor = colorResource(id = R.color.gray),
            imageIcon = painterResource(R.drawable.ic_stock_details),
            text = stringResource(R.string.stock_details)
        ),
        GridItem(
            id = "10",
            backgroundColor = colorResource(id = R.color.gray),
            imageIcon = painterResource(
                id = R.drawable.ic_price_checker
            ),
            text = stringResource(R.string.price_checker)
        ),
        GridItem(
            id = "11",
            backgroundColor = colorResource(id = R.color.gray),
            imageIcon = painterResource(R.drawable.ic_transfer_receipt),
            text = stringResource(R.string.transfer_receipt)
        ),
        GridItem(
            id = "12",
            backgroundColor = Color.Red,
            imageIcon = painterResource(R.drawable.ic_close),
            text = stringResource(R.string.close)
        ),
    )


}


@Composable
fun BottomBar() {
    val activity = LocalContext.current as? Activity

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.SpaceAround
    ) {
        val   context= LocalContext.current

        Button(
            onClick = {
                context.startActivity(Intent(context, CreateGrnActivity::class.java))

            },
            modifier = Modifier
                .weight(1f)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.green_dark)), // Customize background color
            shape = MaterialTheme.shapes.medium.copy(CornerSize(16.dp)) // Customize corner radius
        ) {
            androidx.compose.material3.Icon(
                painter = painterResource(R.drawable.ic_create),
                contentDescription = stringResource(R.string.create),
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text(stringResource(R.string.create))
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
            androidx.compose.material3.Icon(
                painter = painterResource(R.drawable.ic_back), // Replace with your icon resource
                contentDescription = stringResource(R.string.back),
                modifier = Modifier.size(ButtonDefaults.IconSize) // Default Material icon size
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing)) // Space between icon and text
            Text(stringResource(R.string.back))
        }

    }
}

@Composable
fun GrnListScreen() {
    Scaffold(
        bottomBar = {
            BottomBar()
        }
    ) { innerPadding ->
        BodyContent(Modifier.padding(innerPadding))
    }
}

@Composable
fun SupplierListScreen() {
val context= LocalContext.current
    val supplierList = listOf(
        GrnModel("Rist Information Technology", "200.000", "001895343", "23/12/2024"),
        GrnModel("Rist Information Technology", "200.000", "001895343", "23/12/2024"),
        GrnModel("Rist Information Technology", "200.000", "001895343", "23/12/2024"),
        GrnModel("Rist Information Technology", "200.000", "001895343", "23/12/2024"),
        GrnModel("Rist Information Technology", "200.000", "001895343", "23/12/2024"),
    )
    LazyColumn(modifier = Modifier.padding(4.dp)) {
        items(supplierList) { supplier ->
            GrnListItem(supplier, onClick = {
                context.startActivity(Intent(context, CreateGrnActivity::class.java))

            })
        }
    }
}

@Composable
fun ProductData(label: String, value: String) {
    Row {
        Text(
            "$label ",
            color = colorResource(id = R.color.black)
        )
        Text(
            value,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleSmall,
            color = colorResource(id = R.color.black),
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}


@Composable
fun GrnListItem(grnModel: GrnModel, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 8.dp, vertical = 4.dp),

        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .height(IntrinsicSize.Min)
                .background(colorResource(id = R.color.gray)),

            ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Supplier Name:",
                    color = Color.Black,
                    style = MaterialTheme.typography.titleSmall,
                )
                Text(
                    text = grnModel.name,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.green_dark),
                    style = MaterialTheme.typography.titleSmall
                )
                ProductData(stringResource(id = R.string.Amount), grnModel.amount)
                ProductData(stringResource(id = R.string.grn_no), grnModel.grnNo)
                ProductData(stringResource(id = R.string.date), grnModel.date)

            }

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
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_edit),
                        contentDescription = "Edit",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp) // Adjust icon size as needed
                    )
                    Spacer(modifier = Modifier.width(4.dp)) // Space between icon and text
                    Text(
                        text = stringResource(R.string.edit),
                        color = Color.White,
                        fontWeight = FontWeight.Bold, fontSize = 10.sp
                    )
                    Spacer(modifier = Modifier.height(12.dp)) // Space between icon and text

//                    Divider(
//                        color = colorResource(id = R.color.gray),
//                        modifier = Modifier
//                            .height(1.dp).width(80.dp) // Specify the height of the divider
//                    )
                    Spacer(modifier = Modifier.height(12.dp)) // Space between icon and text

                    Icon(
                        // Replace with your edit icon resource ID
                        painter = painterResource(id = R.drawable.ic_details),
                        contentDescription = "Edit",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp) // Adjust icon size as needed
                    )
                    Spacer(modifier = Modifier.width(4.dp)) // Space between icon and text
                    Text(
                        text = stringResource(R.string.DETAIL),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp
                    )

                }
            }

        }


    }
}






