package com.zrq.customcompose.widget

import android.graphics.Point
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke

@Composable
fun NodeChartView(
    modifier: Modifier = Modifier,
    rowCount: Int = 20,
    columnCount: Int = 13,
    points: List<Int>,
) {

    Canvas(
        modifier = modifier
    ) {
        val itemHeight = size.height / columnCount
        val itemWidth = size.width / rowCount

        for (index in 0..columnCount) {
            val y = itemHeight * index
            drawLine(
                Color.Black,
                start = Offset(0f, y),
                end = Offset(size.width, y),
                strokeWidth = 3f
            )
        }
        for (index in 0..rowCount) {
            val x = itemWidth * index
            drawLine(
                Color.Black,
                start = Offset(x, 0f),
                end = Offset(x, size.height),
                strokeWidth = 3f
            )
        }
        points.forEach {
            val mX = it % rowCount
            val mY = it / rowCount
            val x = mX * itemWidth + itemWidth / 2
            val y = mY * itemHeight + itemHeight / 2
            drawCircle(
                color = Color.Green,
                radius = itemWidth / 3,
                center = Offset(x, y),
                style = Stroke(width = 6f)
            )
        }
    }
}