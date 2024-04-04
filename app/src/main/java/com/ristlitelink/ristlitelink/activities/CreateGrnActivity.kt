package com.ristlitelink.ristlitelink.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import com.ristlitelink.ristlitelink.R
import com.ristlitelink.ristlitelink.UserProfileHeader
import com.ristlitelink.ristlitelink.Utils.DateHandler
import com.ristlitelink.ristlitelink.Utils.NumberHandler
import com.ristlitelink.ristlitelink.apiHandler.DataFetcherCallBack
import com.ristlitelink.ristlitelink.classes.Constants
import com.ristlitelink.ristlitelink.classes.DiscountType
import com.ristlitelink.ristlitelink.dialogs.MyDatePickerDialog
import com.ristlitelink.ristlitelink.models.SupplierInfo
import com.ristlitelink.theme.RISTLiteLinkTheme
import kotlinx.coroutines.launch


class CreateGrnActivity : ComponentActivity() {
    var datePickerDialog: MyDatePickerDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RISTLiteLinkTheme {
                val supplier = intent.getSerializableExtra(Constants.supplier_data) as? SupplierInfo

                CreateGrnScreen()


            }

        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CreateGrnScreen() {
        Scaffold(
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
                        androidx.compose.material3.Icon(
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
        ) { innerPadding ->
            BodyContentCreate(Modifier.padding(innerPadding))
        }
    }

    @Composable
    fun BodyContentCreate(modifier: Modifier = Modifier) {
        Column(modifier = modifier.fillMaxSize()) {
            UserProfileHeader(
                userName = "Lionel Messi", loginTime = "02:33 PM",
                branchName = "Manama,", branchLocation = "Bahrain"
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
                    text = stringResource(R.string.grn_create),
                    textAlign = TextAlign.Center
                )
            }

            // Divider()
            CreateItem()


        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {

        RISTLiteLinkTheme {
            CreateGrnScreen()


        }
    }

    @Composable
    fun CreateItem() {
        var poDate by remember { mutableStateOf("") }
        val context = LocalContext.current

        val focusManager = LocalFocusManager.current

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            SupplierDetailsCard(onCardClick = { context.startActivity(Intent(context, SuppliersActivity::class.java))})
            Spacer(modifier = Modifier.height(6.dp))

            var checkedState by remember { mutableStateOf(true) }

            CustomCheckbox(
                checked = checkedState,
                onCheckedChange = { checkedState = it },
                label = "PO"
            )

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                var poText by remember { mutableStateOf("") }

                CustomOutlinedTextField(
                    value = poText,
                    onValueChange = { poText = it },
                    label = stringResource(id = R.string.po_no),
                    onClick = {},
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Next) } // Moves focus to the next focusable item
                    ),
                    modifier = Modifier.weight(1f), readOnly = false
                )
                Spacer(modifier = Modifier.width(16.dp))

                CustomOutlinedTextField(
                    value = poDate,
                    onValueChange = { poDate = it },
                    label = stringResource(id = R.string.po_date),
                    onClick = {
                        datePickerDialog =
                            MyDatePickerDialog(context, object : DataFetcherCallBack {
                                override fun Result(obj: Any?, func: String?, otherData: Any?) {
                                    val date = obj as String
                                    Log.i("TAG", "Log Date value $date")
                                    poDate = NumberHandler.arabicToDecimal(
                                        DateHandler.FormatDate4(
                                            date,
                                            "yyyy-MM-dd",
                                            "yyyy-MM-dd"
                                        )
                                    )
                                }
                            })
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Next) } // Moves focus to the next focusable item

                    ),
                    modifier = Modifier.weight(1f),
                    readOnly = true
                )
            }


            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                var invoiceNo by remember { mutableStateOf("") }

                CustomOutlinedTextField(
                    value = invoiceNo,
                    onValueChange = { invoiceNo = it },
                    label = stringResource(id = R.string.Invoice_No),
                    onClick = {},
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Next) } // Moves focus to the next focusable item

                    ),
                    modifier = Modifier.weight(1f), readOnly = false
                )

                Spacer(modifier = Modifier.width(16.dp))
                var invoiceDate by remember { mutableStateOf("") }

                CustomOutlinedTextField(
                    value = invoiceDate,
                    onValueChange = { invoiceDate = it },
                    label = stringResource(id = R.string.Invoice_Date),
                    onClick = {
                        datePickerDialog =
                            MyDatePickerDialog(context, object : DataFetcherCallBack {
                                override fun Result(obj: Any?, func: String?, otherData: Any?) {
                                    val date = obj as String
                                    Log.i("TAG", "Log invoiceDate value $date")
                                    invoiceDate = NumberHandler.arabicToDecimal(
                                        DateHandler.FormatDate4(
                                            date,
                                            "yyyy-MM-dd",
                                            "yyyy-MM-dd"
                                        )
                                    )
                                }
                            })

                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Next) } // Moves focus to the next focusable item

                    ),
                    modifier = Modifier.weight(1f),
                    readOnly = true
                )


            }

            Spacer(modifier = Modifier.height(6.dp))

            val discountTypes = listOf(DiscountType(1, "Invoice"), DiscountType(2, "Items wise"))
            var totalAmount by remember { mutableStateOf("") }

            CustomDropdownMenu(discountTypes, stringResource(id = R.string.DISCOUNT_TYPE))

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                CustomOutlinedTextField(
                    value = totalAmount,
                    onValueChange = { totalAmount = it },
                    label = stringResource(id = R.string.Total_Amount),
                    onClick = {},
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Next) } // Moves focus to the next focusable item

                    ),
                    modifier = Modifier.weight(1f), readOnly = false
                )
                Spacer(modifier = Modifier.width(16.dp))

                var discountAmount by remember { mutableStateOf("") }

                CustomOutlinedTextField(
                    value = discountAmount,
                    onValueChange = { discountAmount = it },
                    label = stringResource(id = R.string.Discount_Amount),
                    onClick = {},
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Next) } // Moves focus to the next focusable item

                    ),
                    modifier = Modifier.weight(1f), readOnly = false
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
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
                        onNext = { focusManager.moveFocus(FocusDirection.Next) } // Moves focus to the next focusable item
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
                        onNext = { focusManager.clearFocus() } // Moves focus to the next focusable item
                    ),
                    modifier = Modifier.weight(1f), readOnly = false
                )
            }


        }
    }


    @Composable
    fun CustomCheckbox(
        checked: Boolean,
        onCheckedChange: (Boolean) -> Unit,
        label: String
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable { onCheckedChange(!checked) }
                .padding(8.dp)
                .fillMaxWidth()

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
//                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black, modifier = Modifier.fillMaxWidth()
            )
        }
    }

    @Composable
    fun SupplierDetailsCard(onCardClick: () -> Unit) {
        var supplierInfo by remember { mutableStateOf<SupplierInfo?>(null) }

        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = 4.dp,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .clickable(onClick = onCardClick)
        ) {
            Row(
                Modifier
                    .fillMaxSize()
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically
            ) {
//                Box(
//                    modifier = Modifier
//                        .weight(1f)
//                        .padding(start = 16.dp)
//                ) {
//                    Text(
//                        text = stringResource(id = R.string.supplier_details),
//                        style = MaterialTheme.typography.titleMedium,
//                        color = Color.Black
//                    )
//                }
                Column(
                    modifier = Modifier.padding(16.dp).weight(1f)
                ) {
                    androidx.compose.material.Text(
                        text = supplierInfo?.supplierName?:"",
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.green_dark), fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        TextWithMultipleColors(
                            label = stringResource(R.string.currency_code),
                            value = supplierInfo?.currencyCode?:"",
                            labelColor = colorResource(id = R.color.green_dark),
                            valueColor = Color.Red,
                            modifier = Modifier.alignByBaseline()
                        )
                        Spacer(Modifier.weight(1f))

                        TextWithMultipleColors(
                            label = stringResource(R.string.code),
                            value = supplierInfo?.code?:"",
                            labelColor = colorResource(id = R.color.green_dark),
                            valueColor = Color.Red,
                            modifier = Modifier
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))

                    Row {
                        TextWithMultipleColors(
                            label = stringResource(R.string.currency_rate),
                            value = supplierInfo?.currencyRate?:"",
                            labelColor = colorResource(id = R.color.green_dark),
                            valueColor = Color.Red, modifier = Modifier.alignByBaseline()
                        )
                        Spacer(Modifier.weight(1f))

                        TextWithMultipleColors(
                            label = stringResource(R.string.vat_no),
                            value = supplierInfo?.vatNo?:"",
                            labelColor = colorResource(id = R.color.green_dark),
                            valueColor = Color.Red, Modifier.alignByBaseline()
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .background(
                            Color.Red,
                            RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)
                        )
                        .fillMaxHeight()
                        .wrapContentWidth(Alignment.End)
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_down_white),
                        contentDescription = "Select",

                        )
                }
            }
        }
    }

    @Composable
    fun CustomDropdownMenu(discountTypes: List<DiscountType>, label: String) {
        val scope = rememberCoroutineScope()
        var expanded by remember { mutableStateOf(false) }
        val selectedType = remember { mutableStateOf(discountTypes.first()) }
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = label,
                fontSize = 12.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(BorderStroke(1.dp, Color.Gray))
                    .background(color = colorResource(id = R.color.white))
                    .padding(16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = " ${selectedType.value.name}",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expanded = true } // Make the entire Box clickable
                        .padding(end = 48.dp) // Make padding for the end to avoid text overlap with the icon
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic__dropdown), // Use the arrow icon drawable
                    contentDescription = "Dropdown",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .clickable { expanded = !expanded } // Icon also toggles the dropdown
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = colorResource(id = R.color.white)) // Set the background to white
                ) {
                    discountTypes.forEach { type ->
                        DropdownMenuItem(text = {
                            Text(
                                text = type.name, // Assuming the name includes the identifier
                                color = Color.Black,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            )
                        }, onClick = {
                            scope.launch {
                                selectedType.value = type
                                expanded = false
                            }

                        })

                    }
                }
            }
        }
    }


//    @Composable
//    fun CustomDropdownMenu(discountTypes: List<DiscountType>) {
//        val scope = rememberCoroutineScope()
//        var expanded by remember { mutableStateOf(false) }
//        val selectedType = remember { mutableStateOf(discountTypes.first()) }
//
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .border(BorderStroke(1.dp, Color.Gray))
//                .background(color = colorResource(id = R.color.white))
//                .padding(16.dp),
//            contentAlignment = Alignment.CenterStart
//        ) {
//            Text(
//                modifier = Modifier.fillMaxWidth(),
////                ${selectedType.value.id}
//                text = " ${selectedType.value.name}",
//                fontSize = 16.sp,
//            )
//            IconButton(
//                onClick = { expanded = true },
//                modifier = Modifier.align(Alignment.CenterEnd)
//            ) {
//                Image(
//                    painterResource(id = R.drawable.ic__dropdown),
//                    contentDescription = "Dropdown"
//                )
//            }
//
//            DropdownMenu(
//                expanded = expanded,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                onDismissRequest = { expanded = false },
//                properties = PopupProperties(focusable = false)
//            ) {
//                discountTypes.forEach { type: DiscountType ->
//                    DropdownMenuItem(
//                        text = {
//                            Text(
//                                text = "${type.id} ${type.name}", modifier = Modifier
//                                    .fillMaxWidth()
//                                    .padding(8.dp),
//                                color = Color.Black
//                            )
//                        },
//                        onClick = {
//                            scope.launch {
//                                expanded = false
//                                selectedType.value = type
//                            }
//
//                        }, modifier = Modifier.fillMaxWidth()
//                    )
//                }
//
//            }
//        }
//
//    }


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








