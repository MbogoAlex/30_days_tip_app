import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tips.data.DataSource
import com.example.tips.model.Tip
import com.example.tips.ui.theme.TipsTheme

@Composable
fun TipApp(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TipsAppBar()
        }
    ) {
        LazyColumn(contentPadding = it) {
            items(DataSource.tips) {
                TipItem(tip = it)
            }
        }
    }
}

@Composable
fun TipItem(
    tip: Tip,
    modifier: Modifier = Modifier
) {
    Card (
        modifier = Modifier
            .padding(10.dp)
    ) {
        TipInformation(
            dayName = tip.dayName,
            tipHeading = tip.tipHeading,
            tipImage = tip.tipImage,
            tipBody = tip.tipBody,

        )
    }
}

@Composable
fun TipInformation(
    @StringRes dayName: Int,
    @StringRes tipHeading: Int,
    @DrawableRes tipImage: Int,
    @StringRes tipBody: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = dayName),
            style = MaterialTheme.typography.labelMedium
        )
        Text(
            text = stringResource(id = tipHeading),
            style = MaterialTheme.typography.displayMedium
        )
        Image(
            painter = painterResource(id = tipImage),
            contentDescription = "Image of a ${stringResource(id = tipHeading)}",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(
                    top = 5.dp,
                    bottom = 5.dp
                )
        )
        Text(
            text = stringResource(id = tipBody),
            style = MaterialTheme.typography.bodyLarge
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipsAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "30 Days Of Wellness",
                style = MaterialTheme.typography.displayMedium
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TipsTheme(true) {
        TipApp()
    }
}

