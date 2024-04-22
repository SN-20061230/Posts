package uz.sardor.myapplication

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
            animation = tween(1200,
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
fun ShimmerCard(brush: Brush){

    Column(modifier = Modifier.fillMaxWidth().padding(15.dp).border(
        BorderStroke(1.dp, Color.LightGray),
        shape = RoundedCornerShape(25.dp),
    ),){
        Spacer(modifier = Modifier.fillMaxWidth().padding(15.dp).height(40.dp).background(brush))

        Spacer(modifier = Modifier.fillMaxWidth().padding(15.dp).background(brush).height(120.dp))


    }
}

