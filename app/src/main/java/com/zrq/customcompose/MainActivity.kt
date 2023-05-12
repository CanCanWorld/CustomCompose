package com.zrq.customcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zrq.customcompose.entity.RoutePoint
import com.zrq.customcompose.ui.theme.CustomComposeTheme
import com.zrq.customcompose.widget.NodeChartView
import com.zrq.customcompose.widget.RouteChatView
import com.zrq.customcompose.widget.RouteChatView2

class MainActivity : ComponentActivity() {

    private var points by mutableStateOf(
        listOf(
            1, 2, 3, 4, 5, 51, 22, 56, 73, 123
        )
    )
    private var routePoints by mutableStateOf(
        listOf(
            RoutePoint(1, 1),
            RoutePoint(2, 2),
            RoutePoint(3, 3),
            RoutePoint(4, 4),
            RoutePoint(5, 5),
            RoutePoint(6, 1),
            RoutePoint(7, 13),
            RoutePoint(8, 13),
            RoutePoint(34, 10),
            RoutePoint(28, 10),
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomComposeTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    LazyColumn {
                        item {
                            Text(text = "节点类型")
                            //节点类图
                            NodeChartView(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(1.55f)
                                    .padding(10.dp),
                                points = points,
                            )
                        }
                        item {
                            //回路类图
                            Text(text = "回路类型")
                            RouteChatView(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(1.5f)
                                    .padding(10.dp),
                                points = routePoints,
                            )
                        }
                        item {
                            //直控盘注册回路类图
                            Text(text = "直控盘注册回路类型")
                            RouteChatView2(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(1.5f)
                                    .padding(10.dp),
                                num = 1
                            )
                        }
                    }
                }
            }
        }
    }
}