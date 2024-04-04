package com.ristlitelink.ristlitelink.activities

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ristlitelink.ristlitelink.R
import com.ristlitelink.ristlitelink.UserProfileHeader
import com.ristlitelink.ristlitelink.classes.DiscountType
import com.ristlitelink.theme.RISTLiteLinkTheme

class CreateTransactionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RISTLiteLinkTheme {
                CreateTransactionScreen()


            }

        }
    }

    @Composable
    fun CreateTransactionScreen() {
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
                        // Add the icon to the button
                        Icon(
                            painter = painterResource(R.drawable.ic_create),
                            contentDescription = stringResource(R.string.save),
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
            BodyContentCreateTrans(Modifier.padding(innerPadding))
        }

    }

    @Composable
    fun BodyContentCreateTrans(modifier: Modifier = Modifier) {
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
                    text = stringResource(R.string.add_trans),
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

            AddTransItem()


        }
    }

    @Composable
    fun AddTransItem() {
        var description by remember { mutableStateOf("") }

        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = { Text("Barcode") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            trailingIcon = {
                IconButton(
                    onClick = { },
                ) {
                    Row {
                        Image(
                            painterResource(id = R.drawable.ic_search),
                            contentDescription = "Dropdown",
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                        Image(
                            painterResource(id = R.drawable.ic_barcode),
                            contentDescription = "Dropdown",
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                    }
                }
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            var itemCode by remember { mutableStateOf("") }
            var itemReference by remember { mutableStateOf("") }

            CustomOutlinedTextField(
                value = itemCode,
                onValueChange = { itemCode = it },
                label = stringResource(id = R.string.Item_code),
                onClick = {},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {  } // Moves focus to the next focusable item
                ),
                modifier = Modifier.weight(1f), readOnly = false
            )
            Spacer(modifier = Modifier.width(16.dp))


            CustomOutlinedTextField(
                value = itemReference,
                onValueChange = { itemReference = it },
                label = stringResource(id = R.string.Item_Reference),
                onClick = {},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onNext = { } // Moves focus to the next focusable item
                ),
                modifier = Modifier.weight(1f), readOnly = false
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = { Text(stringResource(id = R.string.description)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),

        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            var packId by remember { mutableStateOf("") }
            var umUnit by remember { mutableStateOf("") }

            CustomOutlinedTextField(
                value = packId,
                onValueChange = { packId = it },
                label = stringResource(id = R.string.packId),
                onClick = {},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {  } // Moves focus to the next focusable item
                ),
                modifier = Modifier.weight(1f), readOnly = false
            )
            Spacer(modifier = Modifier.width(16.dp))


            CustomOutlinedTextField(
                value = umUnit,
                onValueChange = { umUnit = it },
                label = stringResource(id = R.string.umUnit),
                onClick = {},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onNext = { } // Moves focus to the next focusable item
                ),
                modifier = Modifier.weight(1f), readOnly = false
            )
        }

        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = { Text(stringResource(id = R.string.Packing)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),

            )

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            var quantity by remember { mutableStateOf("") }
            var FocQuantity by remember { mutableStateOf("") }

            CustomOutlinedTextField(
                value = quantity,
                onValueChange = { quantity = it },
                label = stringResource(id = R.string.Quantity),
                onClick = {},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {  } // Moves focus to the next focusable item
                ),
                modifier = Modifier.weight(1f), readOnly = false
            )
            Spacer(modifier = Modifier.width(16.dp))


            CustomOutlinedTextField(
                value = FocQuantity,
                onValueChange = { FocQuantity = it },
                label = stringResource(id = R.string.FOC_Quantity),
                onClick = {},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onNext = { } // Moves focus to the next focusable item
                ),
                modifier = Modifier.weight(1f), readOnly = false
            )
        }

        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = { Text(stringResource(id = R.string.Price)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),

            )

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            var discount by remember { mutableStateOf("") }
            var amount by remember { mutableStateOf("") }

            CustomOutlinedTextField(
                value = discount,
                onValueChange = { discount = it },
                label = stringResource(id = R.string.Discount),
                onClick = {},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {  } // Moves focus to the next focusable item
                ),
                modifier = Modifier.weight(1f), readOnly = false
            )
            Spacer(modifier = Modifier.width(8.dp))


            CustomOutlinedTextField(
                value = amount,
                onValueChange = { amount = it },
                label = stringResource(id = R.string.Amount),
                onClick = {},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onNext = { } // Moves focus to the next focusable item
                ),
                modifier = Modifier.weight(1f), readOnly = false
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            var taxAmount by remember { mutableStateOf("") }
            var netAmount by remember { mutableStateOf("") }

            CustomOutlinedTextField(
                value = taxAmount,
                onValueChange = { taxAmount = it },
                label = stringResource(id = R.string.Tax_Amount),
                onClick = {},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { FocusDirection.Next } // Moves focus to the next focusable item
                ),
                modifier = Modifier.weight(1f), readOnly = false
            )
            Spacer(modifier = Modifier.width(16.dp))


            CustomOutlinedTextField(
                value = netAmount,
                onValueChange = { netAmount = it },
                label = stringResource(id = R.string.Net_Amount),
                onClick = {},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onNext = { FocusDirection.Next} // Moves focus to the next focusable item
                ),
                modifier = Modifier.weight(1f), readOnly = false
            )
        }




    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {

        RISTLiteLinkTheme {
            CreateTransactionScreen()


        }
    }

    @Composable
    fun CustomOutlinedTextField(
        value: String,
        onValueChange: (String) -> Unit,
        label: String,
        onClick: () -> Unit, // Add an onClick parameter
        keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
        keyboardActions: KeyboardActions = KeyboardActions.Default,
        modifier: Modifier = Modifier,
        readOnly: Boolean = true // Add a readOnly parameter to control the interaction mode
    ) {
        Box(modifier = modifier.clickable(onClick = { onClick.invoke() })) {
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                label = { Text(text = label, color = Color.Black) },
                singleLine = true,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                readOnly = readOnly, // It should be readOnly to prevent keyboard from opening
                enabled = !readOnly, // Make the text field read-only if onClick is used
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = colorResource(id = R.color.red),
                    focusedTextColor = colorResource(id = R.color.black),
                    disabledBorderColor = colorResource(id = R.color.black),

                    )
            )
        }
    }



}