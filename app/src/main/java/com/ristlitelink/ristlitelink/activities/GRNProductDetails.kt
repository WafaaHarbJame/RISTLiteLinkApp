package com.ristlitelink.ristlitelink.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ristlitelink.ristlitelink.R
import com.ristlitelink.ristlitelink.UserProfileHeader

import com.ristlitelink.theme.RISTLiteLinkTheme

class GRNProductDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            RISTLiteLinkTheme {
                GRNProductDetailsScreen()

            }
        }
    }

    @Composable
    fun GRNProductDetailsScreen() {
        Scaffold(

            bottomBar = {
                BottomBar()
            }
        ) { innerPadding ->
            BodyProductDetailContent(Modifier.padding(innerPadding))
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {

        RISTLiteLinkTheme {
            GRNProductDetailsScreen()


        }
    }

    @Composable
    fun BodyProductDetailContent(modifier: Modifier = Modifier) {
        Column(modifier = modifier.fillMaxSize()) {
            UserProfileHeader(
                userName = "Lionel Messi", loginTime = "02:33 PM",
                branchName = "Manama,", branchLocation = "Bahrain"
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.grn_no),
                textAlign = TextAlign.End,modifier= Modifier
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
                    textAlign = TextAlign.Center, color = colorResource(id = R.color.green_dark), fontWeight = FontWeight.Bold
                )

                Text(
                    text = "001895343",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.End, color = colorResource(id = R.color.red), fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            SupplierListScreen()

        }
    }

}


