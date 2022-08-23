package com.example.allhomes.ui.dashboard

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSavedStateRegistryOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.allhomes.R
import com.example.allhomes.model.PropertyResult
import com.example.allhomes.navigation.Screen

@Composable
fun DashboardScreen(navController: NavController) {
    val dashboardViewModel = viewModel(modelClass = DashboardViewModel::class.java)
    dashboardViewModel.getPropertyList()
    val state by dashboardViewModel.state.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Red
                            )
                        ){
                            append("allhome")
                        }
                        append(" - ")
                        withStyle(
                            style = SpanStyle(
                                color = Color.Green
                            )
                        ){
                            append("Domain Group")
                        }
                    })
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.List, "backIcon")
                    }
                },
                backgroundColor = Color.White,
                contentColor = Color.Black,
                elevation = 10.dp
            )
        }, content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                LazyColumn(
                ) {
                    itemsIndexed(
                        state
                    ) { _, item ->
                        PropertyListingCard(
                            navController = navController,
                            item = item
                        )
                    }

                }
            }

        })
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PropertyListingCard(navController: NavController,item: PropertyResult) {
    Box() {
        Surface(
            onClick = {
                navController.navigate(Screen.DetailScreen.route)
            }
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
            ) {
                Card(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(),
                    elevation = 4.dp,
                    shape = RoundedCornerShape(10.dp)
                ) {

                    val painter = rememberAsyncImagePainter(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(item.media.first().image_url)
                            .size(Size.ORIGINAL)
                            .build(),
                        contentScale = ContentScale.Inside
                    )
                    if (painter.state is AsyncImagePainter.State.Loading) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .height(10.dp),
                            color = Color.Red
                        )
                    }
                    Image(
                        painter = painter,
                        contentDescription = "Image",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }

                Text(
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    text = item.price,
                    fontSize = 14.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    text = item.address,
                    fontSize = 14.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Medium
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(top = 8.dp),
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.Black
                                    )
                                ) {
                                    append("Bed ${item.getBedCount()}")
                                }
                            },
                            fontSize = 14.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
                        Text(
                            modifier = Modifier
                                .padding(top = 8.dp),
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.Black
                                    )
                                ) {
                                    append("Bath ${item.getBathCount()}")
                                }
                            },
                            fontSize = 14.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
                        Text(
                            modifier = Modifier
                                .padding(top = 8.dp),
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.Black
                                    )
                                ) {
                                    append("Car ${item.getCarCount()}")
                                }
                            },
                            fontSize = 14.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    val image = rememberAsyncImagePainter(model = item.advertiser.images.logo_url)
                    Image(
                        alignment = Alignment.BottomStart,
                        painter = image,
                        contentDescription = "Agency Logo"
                    )
                }
                Divider(
                    color = Color.Gray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .width(10.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Box() {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            Card(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                elevation = 4.dp,
                shape = RoundedCornerShape(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.property),
                    contentDescription = "Image",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
            Text(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                text = "Unit 9/30-32 Meehan Street, Granville 2142",
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                text = "$100000",
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .height(80.dp),
                horizontalArrangement = Arrangement.Start
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(top = 8.dp),
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Red
                                )
                            ) {
                                append("Bed")
                            }
                            append(" 2")
                        },
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        modifier = Modifier
                            .padding(top = 8.dp),
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Red
                                )
                            ) {
                                append("Bath")
                            }
                            append(" 2")
                        },
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        modifier = Modifier
                            .padding(top = 8.dp),
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Red
                                )
                            ) {
                                append("Car")
                            }
                            append(" 2")
                        },
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold
                    )
                }
                Image(
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp),
                    painter = painterResource(id = R.drawable.property),
                    contentDescription = "Agency Logo")
            }
            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(5.dp)
            )
        }
    }
    Box() {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            Card(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                elevation = 4.dp,
                shape = RoundedCornerShape(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.property),
                    contentDescription = "Image",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
            Text(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                text = "Unit 9/30-32 Meehan Street, Granville 2142",
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                text = "$100000",
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .height(80.dp),
                horizontalArrangement = Arrangement.Start
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(top = 8.dp),
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Red
                                )
                            ) {
                                append("Bed")
                            }
                            append(" 2")
                        },
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        modifier = Modifier
                            .padding(top = 8.dp),
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Red
                                )
                            ) {
                                append("Bath")
                            }
                            append(" 2")
                        },
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        modifier = Modifier
                            .padding(top = 8.dp),
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Red
                                )
                            ) {
                                append("Car")
                            }
                            append(" 2")
                        },
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold
                    )
                }
                Image(
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp),
                    painter = painterResource(id = R.drawable.property),
                    contentDescription = "Agency Logo")
            }
            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .width(10.dp)
            )
        }
    }
}