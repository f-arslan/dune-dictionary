package com.example.dune_dict.ui.screens.dict_all_words

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dune_dict.ui.theme.DunedictTheme

@Composable
fun DuneCardItem(
    modifier: Modifier = Modifier,
    dictAllWordsViewModel: DictAllWordsViewModel
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 8.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            ) {
                Text(
                    style = MaterialTheme.typography.body1,
                    text = "hello",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    style = MaterialTheme.typography.body2,
                    text = "Description",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Outlined.ThumbUp, // It will be handled
                    contentDescription = null
                )
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun AllWordsScreenPreview() {
    DunedictTheme {
        // DuneCardItem()
    }
}
