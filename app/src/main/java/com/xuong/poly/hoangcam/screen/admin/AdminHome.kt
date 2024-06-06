package com.xuong.poly.hoangcam.screen.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xuong.poly.hoangcam.component.HeaderWithAvatar
import com.xuong.poly.hoangcam.model.OrderModel
import com.xuong.poly.hoangcam.navigation.BottomNavigation
import com.xuong.poly.hoangcam.ui.theme.primary1
import com.xuong.poly.hoangcam.ui.theme.primary2



@Composable
private fun OrderListItem(modifier: Modifier, order: OrderModel){
    Row(
        modifier
            .fillMaxWidth()
            .height(110.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(primary2)
            .padding(start = 30.dp, end = 30.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column (
            modifier
                .fillMaxWidth()
                .weight(0.6f)
        ){
            Text(
                text = "Đơn hàng 1",
                fontSize = 22.sp,
                color = Color.White,
                fontWeight = FontWeight(600)
            )
            Text(
                text = "Trạng thái: ",
                fontSize = 22.sp,
                color = Color.White,
                fontWeight = FontWeight(600)
            )
        }
        Column (
            modifier
                .fillMaxWidth()
                .weight(0.4f),
            horizontalAlignment = Alignment.End
        ){
            Text(
                text = String.format("%.0f", order.total) + "K",
                fontSize = 22.sp,
                color = Color.White,
                fontWeight = FontWeight(600)
            )
            Text(
                text = if(order.status) "Chấp nhận" else "Từ chối",
                fontSize = 22.sp,
                color = if(order.status) Color.Green else Color.Red,
                fontWeight = FontWeight(600)
            )
        }
    }
}

val Orders = mutableListOf<OrderModel>()

@Composable
fun AdminHomeView(modifier: Modifier){

    for (nums in 1..10){
        Orders.add(OrderModel(nums.toString(), 10f, true))
    }

    Scaffold(
        topBar = {
            HeaderWithAvatar(modifier = modifier, username = "Test")
        },
        bottomBar = {
            BottomNavigation()
        },
        containerColor = primary1
    ) {paddingValues ->
        LazyColumn (
            modifier.padding(10.dp),
            contentPadding = paddingValues,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            content = {
                items(Orders, key = {item -> item.id}){item ->
                    OrderListItem(modifier = modifier, item)
                }
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Previewing3(){
    AdminHomeView(modifier = Modifier)
//    Header(modifier = Modifier, title = "Placeholder")
//    OrderListItem(modifier = Modifier)
}
