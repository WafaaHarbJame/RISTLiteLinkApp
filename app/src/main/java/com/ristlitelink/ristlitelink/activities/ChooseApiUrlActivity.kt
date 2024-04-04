package com.ristlitelink.ristlitelink.activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ristlitelink.ristlitelink.MainActivity
import com.ristlitelink.ristlitelink.R
import com.ristlitelink.ristlitelink.SplashActivity

import com.ristlitelink.theme.RISTLiteLinkTheme

class ChooseApiUrlActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RISTLiteLinkTheme {
                ChooseApiUrlScreen()
            }

        }
    }


    @Composable
    fun ChooseApiUrlScreen() {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Spacer(Modifier.height(70.dp)) // Adjust the height as per your UI

                Image(
                    painter = painterResource(R.drawable.ic_logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .padding(16.dp)
                        .size(width = 150.dp, height = 70.dp)
                )
                Spacer(Modifier.height(50.dp)) // Adjust the height as per your UI


                Image(
                    painter = painterResource(R.drawable.ic_api),
                    contentDescription = "api",
                    modifier = Modifier
                        .padding(16.dp)
                        .size(width = 150.dp, height = 70.dp)
                )

                Text(
                    "API URL",
                    style = MaterialTheme.typography.h4,
                    color = colorResource(id = R.color.red), fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(16.dp)) // Space between title and text field

                var key by remember { mutableStateOf("") }
                var apiUrl by remember { mutableStateOf("") }

                CustomOutlinedTextField(
                    valueState = apiUrl,
                    onValueChange = {apiUrl=it},
                    label = stringResource(id = R.string.apiUrl),
                    imeAction = ImeAction.Next,
                    isUrl = true,
                    leadingIcon =

                    {
                        Image(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .size(24.dp),
                            painter = painterResource(R.drawable.ic_api_url),
                            contentDescription = "Api Url"
                        )
                    }, isPassword = false
                )

                CustomOutlinedTextField(
                    valueState = key,
                    onValueChange = {key=it},
                    label = stringResource(id = R.string.License),
                    imeAction = ImeAction.Done,
                    leadingIcon = {
                        Image(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .size(24.dp),
                            painter = painterResource(R.drawable.ic_key),
                            contentDescription = "License Key"
                        )
                    }, isPassword = false, isText = true
                )




                Spacer(Modifier.height(30.dp)) // Space before the submit button

                SubmitButton()


            }
        }




    @Preview(showBackground = true)
    @Composable
    fun PreviewSplashScreen() {
        ChooseApiUrlScreen()
    }

    @Composable
    fun SubmitButton() {
        val context = LocalContext.current
        androidx.compose.material3.Button(

            onClick = {
                context.startActivity(Intent(context, SplashActivity::class.java))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 10.dp)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.red)), // Customize background color
            shape = androidx.compose.material3.MaterialTheme.shapes.medium.copy(CornerSize(16.dp)) // Customize corner radius
        ) {
            Row(verticalAlignment =Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.ic_submit), // Replace with your icon resource
                    contentDescription = stringResource(R.string.submit),
                    modifier = Modifier.size(ButtonDefaults.IconSize) // Default Material icon size
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing)) // Space between icon and text
                androidx.compose.material3.Text(text = stringResource(R.string.submit))
            }
        }
    }






}
