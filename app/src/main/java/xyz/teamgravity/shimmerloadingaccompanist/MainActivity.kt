package xyz.teamgravity.shimmerloadingaccompanist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.fade
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer
import kotlinx.coroutines.delay
import xyz.teamgravity.shimmerloadingaccompanist.ui.theme.ShimmerLoadingAccompanistTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShimmerLoadingAccompanistTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var loading by remember { mutableStateOf(true) }

                    LaunchedEffect(key1 = true) {
                        delay(5_000L)
                        loading = false
                    }

                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(20) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Home,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(100.dp)
                                        .placeholder(
                                            visible = loading,
                                            highlight = PlaceholderHighlight.shimmer()
                                        )
                                )
                                Spacer(modifier = Modifier.width(16.dp))
                                Text(
                                    text = stringResource(id = R.string.dummy_text),
                                    modifier = Modifier.placeholder(
                                        visible = loading,
                                        highlight = PlaceholderHighlight.shimmer()
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}