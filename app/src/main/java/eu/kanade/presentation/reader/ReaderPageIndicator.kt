package eu.kanade.presentation.reader

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.sp
import eu.kanade.presentation.theme.TachiyomiPreviewTheme
import tachiyomi.i18n.MR
import tachiyomi.presentation.core.i18n.pluralStringResource

@Composable
fun ReaderPageIndicator(
    currentPage: Int,
    totalPages: Int,
    anchorPage: Int? = null,
    modifier: Modifier = Modifier,
) {
    if (currentPage <= 0 || totalPages <= 0) return

    val text = if (anchorPage != null && currentPage >= anchorPage) {
        val pagesReadDiff = currentPage - anchorPage
        val pagesRead = pluralStringResource(MR.plurals.action_pages_read, pagesReadDiff, pagesReadDiff)
        "$currentPage / $totalPages\n$pagesRead"
    } else {
        "$currentPage / $totalPages"
    }

    val style = TextStyle(
        color = Color(235, 235, 235),
        fontSize = MaterialTheme.typography.bodySmall.fontSize,
        fontWeight = FontWeight.Bold,
        letterSpacing = 1.sp,
    )
    val strokeStyle = style.copy(
        color = Color(45, 45, 45),
        drawStyle = Stroke(width = 4f),
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier,
    ) {
        Text(
            text = text,
            style = strokeStyle,
            textAlign = TextAlign.Center,
        )
        Text(
            text = text,
            style = style,
            textAlign = TextAlign.Center,
        )
    }
}

@PreviewLightDark
@Composable
private fun ReaderPageIndicatorPreview() {
    TachiyomiPreviewTheme {
        Surface {
            ReaderPageIndicator(currentPage = 10, totalPages = 69)
        }
    }
}
