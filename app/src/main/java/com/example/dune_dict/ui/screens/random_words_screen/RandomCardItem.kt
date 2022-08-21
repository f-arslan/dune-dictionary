package com.example.dune_dict.ui.screens.random_words_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.StarOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import com.example.dune_dict.Screens
import com.example.dune_dict.data.models.Word
import com.example.dune_dict.util.Constants.MEDIUM_HIGH_PADDING
import com.example.dune_dict.util.Constants.SMALL_MEDIUM_PADDING
import com.example.dune_dict.util.Constants.SMALL_PADDING

@Composable
fun RandomCardItem(
    modifier: Modifier = Modifier,
    navController: NavController,
    word: Word
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(SMALL_MEDIUM_PADDING)
            .clickable {
                navController.navigate(Screens.DetailWordScreen.passId(word.id))
            },
        elevation = SMALL_PADDING
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Column(
                modifier = Modifier
                    .padding(MEDIUM_HIGH_PADDING)
                    .weight(1f)
            ) {
                Text(
                    style = MaterialTheme.typography.body1,
                    text = word.term,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(SMALL_PADDING))
                Text(
                    style = MaterialTheme.typography.body2,
                    text = word.definition,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            IconButton(
                onClick = {}  // TODO: Implement after the complete detail screen.
            ) {
                Icon(
                    imageVector = Icons.Rounded.StarOutline,
                    contentDescription = null
                )
            }
        }
    }
}