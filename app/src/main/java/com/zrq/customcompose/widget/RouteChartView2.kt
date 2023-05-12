package com.zrq.customcompose.widget

import android.graphics.Paint
import android.graphics.Point
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import com.zrq.customcompose.entity.RoutePoint
import com.zrq.customcompose.entity.TextPoint

@Composable
fun RouteChatView2(
    modifier: Modifier = Modifier,
    rowCount: Int = 8,
    columnCount: Int = 10,
    num: Int = 0,
) {
    val titlePoints = listOf(
        TextPoint(1, 1, "回路"),
        TextPoint(1, 2, "数量"),
        TextPoint(1, 3, "回路"),
        TextPoint(1, 4, "数量"),
        TextPoint(1, 5, "回路"),
        TextPoint(1, 6, "数量"),
        TextPoint(1, 7, "回路"),
        TextPoint(1, 8, "数量"),
        TextPoint(1, 9, "回路"),
        TextPoint(1, 10, "数量"),
    )

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

        val paint = Paint()
        val tSize = 45f

        titlePoints.forEach {
            val x = it.x * itemWidth - itemWidth / 2
            val y = it.y * itemHeight - itemHeight / 2 + tSize / 2
            drawIntoCanvas { canvas ->
                canvas.nativeCanvas.drawText(
                    it.title,
                    x,
                    y,
                    paint.apply {
                        textSize = tSize
                        textAlign = Paint.Align.CENTER
                    }
                )
            }
        }

        if (num != 0) {
            val mX = 1 * itemWidth + itemWidth / 2
            val mY = 4 * itemHeight * 2 + itemHeight / 2 + tSize / 2
            val x = 1 * itemWidth + itemWidth / 2
            val y = 4 * itemHeight * 2 + itemHeight / 2 * 3 + tSize / 2
            drawIntoCanvas { canvas ->
                canvas.nativeCanvas.drawText(
                    String.format("200"),
                    mX,
                    mY,
                    paint.apply {
                        textSize = tSize
                        textAlign = Paint.Align.CENTER
                    }
                )
            }
            drawIntoCanvas { canvas ->
                canvas.nativeCanvas.drawText(
                    String.format("%03d", num),
                    x,
                    y,
                    paint.apply {
                        textSize = tSize
                        textAlign = Paint.Align.CENTER
                    }
                )
            }
        }
    }
}