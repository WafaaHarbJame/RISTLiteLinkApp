package com.ristlitelink.ristlitelink.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ristlitelink.ristlitelink.MainActivity
import com.ristlitelink.ristlitelink.R
import com.ristlitelink.ristlitelink.SplashActivity
import com.ristlitelink.theme.RISTLiteLinkTheme

class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RISTLiteLinkTheme {
                LoginScreen()
            }

        }

    }
}


@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())

    ) {
        Image(
            painter = painterResource(R.drawable.signin_back),
            contentDescription = null, modifier = Modifier
                .fillMaxWidth()
                .height(150.dp), contentScale = ContentScale.FillWidth

        )

        Image(
            painter = painterResource(R.drawable.ic_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .padding(16.dp)
                .size(width = 150.dp, height = 70.dp)
        )

        CustomTextTitle(text = stringResource(R.string.hello))
        CustomTextTitle(text = stringResource(R.string.login_for_continue))

        Spacer(modifier = Modifier.height(10.dp))

        TwoStyleInText(
            text1 = stringResource(id = R.string.sign_in),
            text2 = stringResource(id = R.string.signup)
        )

        Spacer(modifier = Modifier.height(10.dp))

        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        CustomOutlinedTextField(
            valueState = username,
            onValueChange = { username = it },
            label = stringResource(id = R.string.user_name),
            imeAction = ImeAction.Next,
            leadingIcon =

            {
                Icon(
                    painter = painterResource(R.drawable.ic_at_symbol),
                    modifier = Modifier.size(24.dp),
                    contentDescription = "User Name"
                )
            },
        )

        CustomOutlinedTextField(
            valueState = password,
            onValueChange = { password = it },
            label = stringResource(id = R.string.password),
            imeAction = ImeAction.Done,
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_password),
                    contentDescription = "Password", modifier = Modifier.size(24.dp)
                )
            }, isPassword = true
        )



        TwoStyleInText(
            text1 = stringResource(id = R.string.forgot_account),
            text2 = stringResource(id = R.string.reset)
        )

        LoginButton()

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        ) {
            Text(stringResource(R.string.just_skip), modifier = Modifier.clickable {})
            Divider(
                color = Color.Gray, modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            TextWithIcon()
//            Text(stringResource(R.string.arabic), modifier = Modifier.clickable {
//            })
        }
    }
}


@Composable
fun TwoStyleInText(modifier: Modifier = Modifier, text1: String, text2: String) {
    val text = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black)) {
            append(text1)
        }
        withStyle(style = SpanStyle(color = Color.Gray)) {
            append(" / $text2")
        }
    }

    Text(
        text = text,
        modifier = modifier
            .padding(16.dp)
            .clickable { },
        style = MaterialTheme.typography.titleSmall,
    )
}

@Composable
fun CustomTextTitle(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier = modifier.padding(start = 16.dp), // Apply padding here
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold
    )
}


@Composable
fun CustomOutlinedTextField(
    valueState: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    imeAction: ImeAction = ImeAction.Next,
    leadingIcon: @Composable() (() -> Unit)? = null,
    isPassword: Boolean = false,
    isEmail: Boolean = false,
    isText: Boolean = false,
    isUrl: Boolean = false,

    ) {
    var passwordVisible by remember { mutableStateOf(false) }

    val keyboardType = when {
        isPassword -> KeyboardType.Password
        isEmail -> KeyboardType.Email
        isText -> KeyboardType.Text
        isUrl -> KeyboardType.Uri
        else -> KeyboardType.Text // Default to text if none is specified
    }


    OutlinedTextField(
        value = valueState,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.red),
            unfocusedBorderColor = Color.Gray,
            focusedTextColor = colorResource(id = R.color.black),
            unfocusedLabelColor = colorResource(id = R.color.hint_gray)

        ),

        onValueChange = onValueChange,
        label = {
            Text(text = label, style = TextStyle(color = colorResource(id = R.color.gray3)))
        },


        modifier = modifier
            .fillMaxWidth()
//            .background(Color.White)
//            .height(80.dp)
            .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),

        leadingIcon = {
            if (leadingIcon != null) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    leadingIcon()
                    Divider(
                        color = colorResource(id = R.color.gray2),
                        modifier = Modifier
                            .height(30.dp)
                            .width(17.dp)
                            .padding(horizontal = 8.dp)
                    )
                }
            }
        },
        visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,

        trailingIcon = {
            if (isPassword) {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                        contentDescription = "Toggle Password Visibility"
                    )
                }
            }
        }
    )
}


@Composable
fun LoginButton() {
    val context = LocalContext.current
    Button(

        onClick = {
            context.startActivity(Intent(context, MainActivity::class.java))
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 10.dp)
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.red)), // Customize background color
        shape = androidx.compose.material3.MaterialTheme.shapes.medium.copy(CornerSize(16.dp)) // Customize corner radius
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.ic_login_icon), // Replace with your icon resource
                contentDescription = stringResource(R.string.login),
                modifier = Modifier.size(ButtonDefaults.IconSize) // Default Material icon size
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing)) // Space between icon and text
            Text(text = stringResource(R.string.login))
        }
    }
}

@Composable
fun TextWithIcon() {
    Row(

        modifier = Modifier
            .clickable { /* Handle click */ }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center

    ) {

        Image(
            painter = painterResource(R.drawable.ic_change_lang),
            contentDescription = "Logo",
            modifier = Modifier
                .padding(8.dp)
                .size(width = 24.dp, height = 24.dp)
        )
        Text(stringResource(R.string.arabic))


    }
}


@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    MaterialTheme {
        LoginScreen()
    }


}


