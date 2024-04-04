package com.ristlitelink.ristlitelink

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import com.ristlitelink.ristlitelink.activities.GrnListActivity
import com.ristlitelink.ristlitelink.classes.GridItem
import com.ristlitelink.theme.RISTLiteLinkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RISTLiteLinkTheme {
                MainScreen()
            }
        }
    }
}


@Composable
fun GridScreen(items: List<GridItem>) {
    val context = LocalContext.current

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        content = {
            items(items.size) { index ->
                GridItemCard(gridItem = items[index],onClick = {
                    if(items[index].id=="1"){
                        context.startActivity(Intent(context, GrnListActivity::class.java))

                    }

                })
            }
        }
    )
}

@Composable
fun GridItemCard(gridItem: GridItem,onClick: () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = gridItem.backgroundColor,
        ),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick)
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
//            modifier = Modifier.size(50.dp)
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
        MainScreen()


    }
}



    @Composable
fun UserProfileHeader(
        userName: String,
        loginTime: String,
        branchName: String,
        branchLocation: String
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // User profile and login time section
            Column(verticalArrangement = Arrangement.Center) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_username),
                        contentDescription = "User Avatar",
                        modifier = Modifier.size(30.dp),
                    )
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = userName,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(
                            text = "LOGIN TIME $loginTime",
                            fontSize = 12.sp
                        )
                    }
                }
            }

            // Branch section
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_branch),
                    contentDescription = "Branch Icon",
                    modifier = Modifier.size(30.dp),
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = stringResource(id = R.string.branch),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Text(
                        text = "$branchName,$branchLocation",
                        fontSize = 12.sp
                    )
                }
            }
        }
    }

//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(start = 16.dp, end = 16.dp),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        // User profile and login time section
//        Column(verticalArrangement = Arrangement.Center) {
//            Row(
//                horizontalArrangement = Arrangement.Center,
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.align(Alignment.CenterHorizontally)
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.ic_username),
//                    contentDescription = "User Avatar",
//                    modifier = Modifier.size(30.dp),
//
//                    )
//                Column(modifier = Modifier.padding(16.dp)) {
//                    Text(
//                        text = "Lionel Messi",
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 18.sp
//                    )
//                    Text(
//                        text = "LOGIN TIME 02:33 PM",
//                        fontSize = 12.sp
//                    )
//                }
//            }
//
//
//        }
//
//        // Branch section
//        Row(
//            horizontalArrangement = Arrangement.Center,
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier.align(Alignment.CenterVertically)
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.ic_branch),
//                contentDescription = "User Avatar",
//                modifier = Modifier.size(30.dp),
//
//                )
//            Column(modifier = Modifier.padding(16.dp)) {
//                Text(
//                    text = stringResource(id = R.string.branch),
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 18.sp
//                )
//                Text(
//                    text = "Manama, Bahrain",
//                    fontSize = 12.sp
//                )
//            }
//        }
//
//
//    }


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
fun MainScreen() {
    Column {
        UserProfileHeader(userName ="Lionel Messi", loginTime ="02:33 PM",
            branchName = "Manama", branchLocation = "Bahrain")
        GridScreen(items = listItemList())
    }

}



