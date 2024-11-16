package com.example.shoppinglistapp

import android.Manifest
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.navigation.NavController
import com.example.shoppinglistapp.DataClass.ShoppingItem
import com.example.shoppinglistapp.Utils.LocationUtils
import com.example.shoppinglistapp.ViewModels.LocationViewModal


@Composable
fun ShoppingListApp(
    locationUtils: LocationUtils,
    viewModel: LocationViewModal,
    navController: NavController,
    context: Context,
    address: String
) {
    var shoppingItems by remember { mutableStateOf(listOf<ShoppingItem>()) }
    var itemName by remember { mutableStateOf<String>("") }
    var itemQty by remember { mutableStateOf<String>("") }
    var showDialog by remember { mutableStateOf(false) }


    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult = { permissions ->
            if (permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
                && permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true
            ) {
                locationUtils.requestLocationUpdates(viewModel = viewModel)
            } else {
                val rationalRequired = ActivityCompat.shouldShowRequestPermissionRationale(
                    context as MainActivity,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) || ActivityCompat.shouldShowRequestPermissionRationale(
                    context as MainActivity,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
                if (rationalRequired) {
                    Toast.makeText(
                        context,
                        "Location Permission is required for this feature to work.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        context,
                        "Location Permission is required. Please enable it in the android settings.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff354f52))
            .padding(5.dp, 5.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Button(
            onClick = { showDialog = true },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(50.dp, 5.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xffcad2c5))

        ) {
            Text(
                text = "Add Item", modifier = Modifier.wrapContentSize(), color = Color(0xff354f52)
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(shoppingItems) { item ->
                if (item.isEditing) {
                    ShoppingItemEditor(item = item, onEditComplete = { editedName, editedQuantity ->
                        shoppingItems = shoppingItems.map { it.copy(isEditing = false) }
                        val editedItem = shoppingItems.find { it.id == item.id }
                        editedItem?.let {
                            it.itemName = editedName
                            it.quantity = editedQuantity
                            it.address = address
                        }
                    })
                } else {
                    ShoppingListItem(item = item, onEditClick = {
                        shoppingItems = shoppingItems.map { it.copy(isEditing = it.id == item.id) }
                    },
                        onDeleteClick = {
                            shoppingItems = shoppingItems - item
                        }
                    )
                }
            }
        }
    }

    if (showDialog) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .background(
                        Color(0xff84a98c),
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Add Shopping Item",
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(0.dp, 25.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray
                )
                OutlinedTextField(
                    value = itemName,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(0.dp, 15.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color(0xffd8e2dc), focusedBorderColor = Color(0xffd8e2dc)
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    onValueChange = { newText ->
                        itemName = newText
                    },
                    label = {
                        Text(
                            text = "Shopping Item",
                            modifier = Modifier.wrapContentSize(),
                            color = Color(0xffd8e2dc)
                        )
                    },
                )
                OutlinedTextField(value = itemQty,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(0.dp, 15.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color(0xffd8e2dc), focusedBorderColor = Color(0xffd8e2dc)
                    ),
                    onValueChange = { newText ->
                        itemQty = newText
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = {
                        Text(
                            text = "Shopping Item Quantity",
                            modifier = Modifier.wrapContentSize(),
                            color = Color(0xffd8e2dc)
                        )
                    })
                Button(onClick = {
                    if(locationUtils.hasLocationPermission(context)){
                        locationUtils.requestLocationUpdates(viewModel)
                        navController.navigate("locationscreen"){
                            this.launchSingleTop
                        }
                    }else{
                        requestPermissionLauncher.launch(arrayOf(
                            Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION
                        ))
                    }
                },
                    modifier = Modifier.wrapContentSize(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xffcad2c5))
                ) {
                    Text(
                        text = "Get Location",
                        modifier = Modifier.wrapContentSize(),
                        color = Color(0xff354f52)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp, 0.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Button(
                        onClick = {
                            var idx: Int = shoppingItems.size + 1
                            if (itemQty.toInt() > 0 && itemName.isNotBlank()) {
                                val shoppingItem = ShoppingItem(
                                    id = idx, itemName = itemName, quantity = itemQty.toInt(), address = address
                                )
                                shoppingItems = shoppingItems + shoppingItem
                                showDialog = false
                                itemName = ""
                                itemQty = ""

                            }
                        },
                        modifier = Modifier.wrapContentSize(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xffcad2c5))

                    ) {
                        Text(
                            text = "Add",
                            modifier = Modifier.wrapContentSize(),
                            color = Color(0xff354f52)
                        )
                    }
                    Button(
                        onClick = { showDialog = false },
                        modifier = Modifier.wrapContentSize(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xffcad2c5))
                    ) {
                        Text(
                            text = "Cancel",
                            modifier = Modifier.wrapContentSize(),
                            color = Color(0xff354f52)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ShoppingListItem(
    item: ShoppingItem,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit,
) {
    val width = LocalConfiguration.current.screenWidthDp * .9
    Row(
        modifier = Modifier
            .requiredWidth(width.dp)
            .border(
                border = BorderStroke(1.dp, Color(0xffd8e2dc)), shape = RoundedCornerShape(10)
            ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
        ) {
            Row() {
                Text(
                    text = item.itemName,
                    modifier = Modifier.padding(8.dp),
                    color = Color(0xffcad2c5)
                )
                Text(
                    text = "Qty: ${item.quantity.toString()}",
                    modifier = Modifier.padding(8.dp),
                    color = Color(0xffcad2c5)
                )
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Icon(
                    tint = Color(0xffcad2c5),
                    imageVector = Icons.Default.LocationOn, contentDescription = null)
                Text(
                    modifier = Modifier.padding(8.dp),
                    color = Color(0xffcad2c5),
                    text = item.address)
            }
        }
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            IconButton(onClick = onEditClick) {
                Icon(
                    tint = Color(0xffcad2c5),
                    imageVector = Icons.Default.Edit, contentDescription = null
                )
            }
            IconButton(
                onClick = onDeleteClick
            ) {
                Icon(
                    tint = Color(0xffcad2c5),
                    imageVector = Icons.Default.Delete, contentDescription = null,
                    modifier = Modifier.padding(0.dp),
                )
            }
        }
    }

}

@Composable
fun ShoppingItemEditor(item: ShoppingItem, onEditComplete: (String, Int) -> Unit) {
    var editedName by remember { mutableStateOf(item.itemName) }
    var editedQty by remember { mutableStateOf(item.quantity.toString()) }
    var isEditing by remember { mutableStateOf(item.isEditing) }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xffcad2c5))
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column() {
            BasicTextField(
                value = editedName,
                onValueChange = { editedName = it },
                singleLine = true,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            )

            BasicTextField(
                value = editedQty,
                onValueChange = { editedQty = it },
                singleLine = true,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            )
        }
        Button(
            onClick = {
                isEditing = false
                onEditComplete(editedName, editedQty.toIntOrNull() ?: 1)
            }
        ) {
            Text(text = "Save")
        }
    }
}
