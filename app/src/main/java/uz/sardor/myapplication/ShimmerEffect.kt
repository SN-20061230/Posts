package uz.sardor.myapplication

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedShimmer() {
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f)
    )
    val transition = rememberInfiniteTransition(label = "")
    val alpha  = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000,
                easing = FastOutSlowInEasing,
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "",
    ).value

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end  = Offset(x = alpha, y =alpha)
    )
    ShimmerCard2(brush = brush)
}


@Composable
fun AnimatedShimmer1() {
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f)
    )
    val transition = rememberInfiniteTransition(label = "")
    val alpha  = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000,
                easing = FastOutSlowInEasing,
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "",
    ).value

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end  = Offset(x = alpha, y =alpha)
    )
    ShimmerCard(brush = brush)
}
@Composable
fun ShimmerCard2(brush: Brush){

    Column(modifier = Modifier.fillMaxWidth().padding(all = 10.dp)){
        Spacer(modifier = Modifier.fillMaxWidth().height(30.dp).clip(CircleShape).background(brush))

        Spacer(modifier = Modifier.height(10.dp))

        Spacer(modifier = Modifier.fillMaxWidth().background(brush).height(30.dp))


//        Column( verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
//            Spacer(
//                modifier = Modifier.height(20.dp).fillMaxWidth(fraction = 0.8f).background(brush).clip(RoundedCornerShape(10.dp))
//            )
//            Spacer(modifier = Modifier.padding(5.dp))
//            Spacer(
//                modifier = Modifier.height(20.dp).fillMaxWidth(fraction = 0.5f).background(brush)
//                    .clip(RoundedCornerShape(10.dp))
//
//            )
//        }

    }
}

@Composable
fun ShimmerCard(brush: Brush) {
    Column(
        modifier = Modifier.fillMaxHeight().padding(all = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(120.dp).clip(CircleShape).background(brush))
    }
}