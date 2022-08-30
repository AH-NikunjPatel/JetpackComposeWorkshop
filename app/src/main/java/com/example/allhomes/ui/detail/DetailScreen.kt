package com.example.allhomes.ui.detail

import android.telecom.Call
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import androidx.navigation.NavController
import com.example.allhomes.R
import org.w3c.dom.Text

@Composable
fun DetailScreen(navController: NavController) {

    BoxWithConstraints {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Column {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(this@BoxWithConstraints.maxHeight)
                        .verticalScroll(rememberScrollState())
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.property),
                        contentDescription = "Image",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(this@BoxWithConstraints.maxHeight)
                            .padding(horizontal = 16.dp)
                    ) {

                        Text(
                            modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            text = "1 Eyre street, Canberra ACT 2020",
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
                                .fillMaxWidth()
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
                                        append("Bed 2")
                                    }
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
                                        append("Bath 2")
                                    }
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
                                        append("Car 2")
                                    }
                                },
                                fontSize = 14.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Text(
                            modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            text = "Description",
                            fontSize = 20.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                            fontSize = 14.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Light,
                            textAlign = TextAlign.Justify
                        )

                        Text(
                            modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            text = "Features",
                            fontSize = 20.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold
                        )

                        val list = listOf(
                            "Allocated Car Spaces",
                            "Air Conditioning",
                            "Garden Shed",
                            "Outdoor Entertaining"
                        )
                        LazyColumn {
                            itemsIndexed(
                                list
                            ) { index, item ->
                                Text(
                                    modifier =
                                    Modifier
                                        .fillMaxWidth()
                                        .padding(top = 8.dp),
                                    text = "- ${list.get(index)}",
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight.Light,
                                    textAlign = TextAlign.Justify
                                )
                            }
                        }

                        Text(
                            modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            text = "Agents",
                            fontSize = 20.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween

                        ) {
                            Text(
                                modifier = Modifier.fillMaxWidth(0.5f),
                                text = "LJ Hooker",
                                fontSize = 14.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Justify
                            )
                            Button(
                                onClick = {

                                },
                                modifier = Modifier.fillMaxWidth(0.5f),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color.Red,
                                    contentColor = Color.White
                                )
                            ) {
                                Text(text = "Call")

                            }
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween

                        ) {
                            Text(
                                modifier = Modifier.fillMaxWidth(0.5f),
                                text = "LJ Hooker",
                                fontSize = 14.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Justify
                            )
                            Button(
                                onClick = {

                                },
                                modifier = Modifier.fillMaxWidth(0.5f),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color.Red,
                                    contentColor = Color.White
                                )
                            ) {
                                Text(text = "Call")

                            }
                        }
                        Text(
                            modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            text = "Thank you",
                            fontSize = 20.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )

                    }
                }
            }
        }
    }
}


@Composable
@Preview
fun DefaultPreview() {

    Column() {
        repeat(4) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(0.5f),
                    text = "LJ Hooker",
                    fontSize = 14.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Justify
                )
                Button(
                    onClick = {

                    },
                    modifier = Modifier.fillMaxWidth(0.5f),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Red,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Call")

                }
            }
        }
    }

//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.property),
//                contentDescription = "Image",
//                contentScale = ContentScale.FillWidth,
//                modifier = Modifier
//                    .fillMaxWidth()
//            )
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 16.dp)
//            ) {
//
//                Text(
//                    modifier =
//                    Modifier
//                        .fillMaxWidth()
//                        .padding(top = 8.dp),
//                    text = "1 Eyre street, Canberra ACT 2020",
//                    fontSize = 14.sp,
//                    fontFamily = FontFamily.SansSerif,
//                    fontWeight = FontWeight.Bold
//                )
//
//                Text(
//                    modifier =
//                    Modifier
//                        .fillMaxWidth()
//                        .padding(top = 8.dp),
//                    text = "$100000",
//                    fontSize = 14.sp,
//                    fontFamily = FontFamily.SansSerif,
//                    fontWeight = FontWeight.Bold
//                )
//
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(50.dp)
//                ) {
//                    Text(
//                        modifier = Modifier
//                            .padding(top = 8.dp),
//                        text = buildAnnotatedString {
//                            withStyle(
//                                style = SpanStyle(
//                                    color = Color.Red
//                                )
//                            ) {
//                                append("Bed")
//                            }
//                            append(" 2")
//                        },
//                        fontSize = 14.sp,
//                        fontFamily = FontFamily.SansSerif,
//                        fontWeight = FontWeight.Bold
//                    )
//                    Spacer(modifier = Modifier.padding(5.dp))
//                    Text(
//                        modifier = Modifier
//                            .padding(top = 8.dp),
//                        text = buildAnnotatedString {
//                            withStyle(
//                                style = SpanStyle(
//                                    color = Color.Red
//                                )
//                            ) {
//                                append("Bath")
//                            }
//                            append(" 2")
//                        },
//                        fontSize = 14.sp,
//                        fontFamily = FontFamily.SansSerif,
//                        fontWeight = FontWeight.Bold
//                    )
//                    Spacer(modifier = Modifier.padding(5.dp))
//                    Text(
//                        modifier = Modifier
//                            .padding(top = 8.dp),
//                        text = buildAnnotatedString {
//                            withStyle(
//                                style = SpanStyle(
//                                    color = Color.Red
//                                )
//                            ) {
//                                append("Car")
//                            }
//                            append(" 2")
//                        },
//                        fontSize = 14.sp,
//                        fontFamily = FontFamily.SansSerif,
//                        fontWeight = FontWeight.Bold
//                    )
//                }
//
//                Text(
//                    modifier =
//                    Modifier
//                        .fillMaxWidth()
//                        .padding(top = 8.dp),
//                    text = "Description",
//                    fontSize = 20.sp,
//                    fontFamily = FontFamily.SansSerif,
//                    fontWeight = FontWeight.Bold
//                )
//                Text(
//                    modifier =
//                    Modifier
//                        .fillMaxWidth()
//                        .padding(top = 8.dp),
//                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
//                    fontSize = 14.sp,
//                    fontFamily = FontFamily.SansSerif,
//                    fontWeight = FontWeight.Light,
//                    textAlign = TextAlign.Justify
//                )
//
//                Text(
//                    modifier =
//                    Modifier
//                        .fillMaxWidth()
//                        .padding(top = 8.dp),
//                    text = "Features",
//                    fontSize = 20.sp,
//                    fontFamily = FontFamily.SansSerif,
//                    fontWeight = FontWeight.Bold
//                )
//
//                val list = listOf("Allocated Car Spaces", "Air Conditioning", "Garden Shed", "Outdoor Entertaining")
//                LazyColumn{
//                    itemsIndexed(
//                        list
//                    ){ index, item ->
//                        Text(
//                            modifier =
//                            Modifier
//                                .fillMaxWidth()
//                                .padding(top = 8.dp),
//                            text = "- ${list.get(index)}",
//                            fontSize = 14.sp,
//                            fontFamily = FontFamily.SansSerif,
//                            fontWeight = FontWeight.Light,
//                            textAlign = TextAlign.Justify
//                        )
//                    }
//                }
//
//                Text(
//                    modifier =
//                    Modifier
//                        .fillMaxWidth()
//                        .padding(top = 8.dp),
//                    text = "Key Details",
//                    fontSize = 20.sp,
//                    fontFamily = FontFamily.SansSerif,
//                    fontWeight = FontWeight.Bold
//                )
//                Text(
//                    modifier =
//                    Modifier
//                        .fillMaxWidth()
//                        .padding(top = 8.dp),
//                    text = "",
//                    fontSize = 14.sp,
//                    fontFamily = FontFamily.SansSerif,
//                    fontWeight = FontWeight.Light,
//                    textAlign = TextAlign.Justify
//                )
//            }
//
//
//            }
//        }

}