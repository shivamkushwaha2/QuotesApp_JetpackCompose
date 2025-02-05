package com.insoft.firstcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Thin
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.insoft.firstcompose.R
import com.insoft.firstcompose.models.QuotesModel


@Composable
fun QuoteListItem(quotesModel: QuotesModel, onItemClick:()->Unit = {}) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.padding(8.dp).clickable{
            onItemClick()
        },
    ) {
        Row(
            modifier = Modifier
                .background(Color.White)
                .padding(8.dp)
        ) {
            Image(
                Icons.Filled.FormatQuote,
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 5.dp, top = 4.dp, end = 10.dp)
                    .size(48.dp)
                    .rotate(180f)
            )
            Column(modifier = Modifier.fillMaxWidth(1f)) {
                Text(
                    text = quotesModel.text,
                    fontSize = 18.sp,
                    fontWeight = Thin,
                    color = Color.Black,
                    modifier = Modifier.padding(0.dp, 8.dp, 8.dp, 8.dp)
                )
                Box(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth(.6f)
                        .background(Color.Gray)
                )
                Text(
                    text = quotesModel.author,
                    fontSize = 14.sp,
                    fontWeight = Thin,
                    modifier = Modifier.padding(0.dp, 8.dp, 8.dp, 8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun prev() {
    QuoteListItem(quotesModel = QuotesModel("This is a quote", "This is a author"))
}

