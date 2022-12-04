package com.example.dune_dict.ui.screens.detail_word_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CopyAll
import androidx.compose.material.icons.outlined.VolumeUp
import androidx.compose.material.icons.rounded.StarOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dune_dict.util.Constants.HIGH_PADDING
import com.example.dune_dict.util.Constants.MEDIUM_PADDING
import com.example.dune_dict.util.Constants.SMALL_PADDING

val dividerWidth = 152.dp
val dividerHeight = 2.dp

@Composable
fun DetailIconsTab(
    modifier: Modifier = Modifier,
    onClickVolume: () -> Unit = {},
    onClickFavourite: () -> Unit = {},
    onClickCopy: () -> Unit = {},
    volumeButtonState: Boolean = true,
    favouriteButtonState: Boolean = true,
    copyButtonState: Boolean = true,
) {
    Column(
        modifier = Modifier.padding(bottom = MEDIUM_PADDING)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = SMALL_PADDING),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            DetailVolumeIcon(
                imageVector = Icons.Outlined.VolumeUp,
                contentDescription = "Listen the word",
                onClickVolume = onClickVolume,
                volumeButtonState = volumeButtonState
            )
            Spacer(modifier = Modifier.width(MEDIUM_PADDING))
            DetailFavouriteIcon(
                imageVector = Icons.Rounded.StarOutline,
                contentDescription = "Save the word",
                onClickFavourite = onClickFavourite,
                favouriteButtonState = favouriteButtonState
            )
            Spacer(modifier = Modifier.width(MEDIUM_PADDING))
            DetailCopyIcon(
                imageVector = Icons.Outlined.CopyAll,
                contentDescription = "Copy the word",
                onClickCopy = onClickCopy,
                copyButtonState = copyButtonState
            )

        }
        Divider(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(dividerWidth)
                .height(dividerHeight)
                .clip(RoundedCornerShape(MEDIUM_PADDING))
                .background(
                    Color.LightGray.copy(alpha = 0.3f)
                )
                .shadow(HIGH_PADDING)
        )
    }

}

@Composable
fun DetailCopyIcon(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    contentDescription: String = "",
    onClickCopy: () -> Unit = {},
    copyButtonState: Boolean = true
) {
    IconButton(
        onClick = {
            onClickCopy()
        },
        enabled = copyButtonState
    ) {
        DetailIconBox(
            imageVector = imageVector,
            contentDescription = contentDescription
        )
    }
}

@Composable
fun DetailFavouriteIcon(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    contentDescription: String = "",
    onClickFavourite: () -> Unit = {},
    favouriteButtonState: Boolean = true
) {
    IconButton(
        onClick = {
            onClickFavourite()
        },
        enabled = favouriteButtonState
    ) {
        DetailIconBox(
            imageVector = imageVector,
            contentDescription = contentDescription
        )
    }
}

@Composable
fun DetailVolumeIcon(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    contentDescription: String = "",
    onClickVolume: () -> Unit = {},
    volumeButtonState: Boolean = true
) {
    IconButton(
        onClick = {
            onClickVolume()
        },
        enabled = volumeButtonState
    ) {
        DetailIconBox(
            imageVector = imageVector,
            contentDescription = contentDescription
        )
    }
}

@Composable
fun DetailIconBox(
    imageVector: ImageVector,
    contentDescription: String = "",
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(MEDIUM_PADDING))
            .background(Color.LightGray.copy(alpha = 0.3f)) // TODO: Handle in color.kt for dark palette
            .shadow(HIGH_PADDING)
            .padding(MEDIUM_PADDING)
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription,
        )
    }
}

@Composable
fun DetailIcon(
    modifier: Modifier = Modifier,
    onClickVolume: (Boolean) -> Unit = {},
    volumeButtonState: Boolean = false
) {
    IconButton(
        onClick = {

        },
    ) {

    }
}


@Preview(showBackground = true)
@Composable
fun DetailIconsTabPreview() {
    DetailIconsTab()
}