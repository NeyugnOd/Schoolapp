package com.hoasen.studentapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.EventAvailable
import androidx.compose.material.icons.filled.EventNote
import androidx.compose.material.icons.filled.FactCheck
import androidx.compose.material.icons.filled.Feedback
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Paid
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.outlined.Event
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hoasen.studentapp.R
import com.hoasen.studentapp.ui.theme.BgGray
import com.hoasen.studentapp.ui.theme.HoaSenBlue
import com.hoasen.studentapp.ui.theme.HoaSenBlueDark
import com.hoasen.studentapp.ui.theme.HoaSenGreen
import com.hoasen.studentapp.ui.theme.HoaSenRed
import com.hoasen.studentapp.ui.theme.HoaSenYellow
import com.hoasen.studentapp.ui.theme.TextPrimary
import com.hoasen.studentapp.ui.theme.TextSecondary

@Composable
fun HomeScreen(onOpenStudentCard: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BgGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            HeaderSection(onOpenStudentCard = onOpenStudentCard)
            Spacer(Modifier.height(16.dp))
            FavoriteFeaturesSection()
            Spacer(Modifier.height(20.dp))
            UpcomingEventsSection()
            Spacer(Modifier.height(120.dp))
        }
        BottomNavBar(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
private fun HeaderSection(onOpenStudentCard: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(HoaSenBlue)
            .windowInsetsPadding(WindowInsets.statusBars)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.student_photo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(52.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                )
                Spacer(Modifier.width(12.dp))
                Column {
                    Text(
                        "Hà Ngọc Tuyết Trinh",
                        color = Color.White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        "Kinh doanh Quốc tế",
                        color = Color.White.copy(alpha = 0.85f),
                        fontSize = 13.sp
                    )
                }
            }
            Spacer(Modifier.height(14.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(HoaSenBlueDark)
            ) {
                HeaderActionItem(
                    icon = Icons.Filled.History,
                    label = "Sự kiện đã tham ...",
                    modifier = Modifier.weight(1f)
                )
                Box(
                    Modifier
                        .width(1.dp)
                        .height(36.dp)
                        .background(Color.White.copy(alpha = 0.3f))
                        .align(Alignment.CenterVertically)
                )
                HeaderActionItem(
                    icon = Icons.Filled.Badge,
                    label = "Thẻ sinh viên",
                    modifier = Modifier
                        .weight(1f)
                        .clickable { onOpenStudentCard() }
                )
            }
        }
    }
}

@Composable
private fun HeaderActionItem(
    icon: ImageVector,
    label: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(vertical = 12.dp, horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            icon,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(18.dp)
        )
        Spacer(Modifier.width(8.dp))
        Text(label, color = Color.White, fontSize = 13.sp, maxLines = 1)
    }
}

private data class Feature(
    val icon: ImageVector,
    val label: String,
    val tint: Color = HoaSenBlue
)

@Composable
private fun FavoriteFeaturesSection() {
    val features = listOf(
        Feature(Icons.Filled.CalendarMonth, "Thời khoá biểu"),
        Feature(Icons.Filled.CheckCircle, "Điểm danh"),
        Feature(Icons.Filled.FactCheck, "Chuyên cần"),
        Feature(Icons.Filled.EventNote, "Lịch thi"),
        Feature(Icons.Filled.Paid, "Học phí"),
        Feature(Icons.Filled.BarChart, "Điểm"),
        Feature(Icons.Filled.Feedback, "Sinh viên góp ý"),
        Feature(Icons.Filled.Add, "Xem thêm")
    )
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "Tính năng yêu thích",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextPrimary,
                modifier = Modifier.weight(1f)
            )
            Icon(
                Icons.Filled.Tune,
                contentDescription = null,
                tint = TextSecondary,
                modifier = Modifier.size(18.dp)
            )
        }
        Spacer(Modifier.height(12.dp))
        // Build a 4-column grid in two rows
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            features.chunked(4).forEach { row ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    row.forEach { feature ->
                        FeatureItem(
                            feature = feature,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun FeatureItem(feature: Feature, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(54.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(Color.White)
                .border(1.dp, Color(0xFFE5E7EB), RoundedCornerShape(14.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                feature.icon,
                contentDescription = feature.label,
                tint = feature.tint,
                modifier = Modifier.size(26.dp)
            )
        }
        Spacer(Modifier.height(6.dp))
        Text(
            feature.label,
            fontSize = 11.sp,
            color = TextPrimary,
            maxLines = 2
        )
    }
}

@Composable
private fun UpcomingEventsSection() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                "Sự kiện sắp tới",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextPrimary
            )
            Spacer(Modifier.width(4.dp))
            Text(">", fontSize = 16.sp, color = TextSecondary)
        }
        Spacer(Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            EventCard(
                title = "Workshop: Giới & Phát triển",
                subtitle = "Di sản & Du lịch — ISU x HSU"
            )
            EventCard(
                title = "Talkshow: Khởi nghiệp sáng tạo",
                subtitle = "Hoa Sen — 2026"
            )
            EventCard(
                title = "Hội thảo: AI trong giáo dục",
                subtitle = "ĐH Hoa Sen"
            )
        }
    }
}

@Composable
private fun EventCard(title: String, subtitle: String) {
    Column(
        modifier = Modifier
            .width(220.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp)
                .background(
                    Brush.linearGradient(
                        listOf(HoaSenBlue, HoaSenBlueDark)
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "GIAO LƯU\nSINH VIÊN",
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Column(modifier = Modifier.padding(10.dp)) {
            Text(
                title,
                fontSize = 13.sp,
                color = TextPrimary,
                fontWeight = FontWeight.SemiBold,
                maxLines = 2
            )
            Spacer(Modifier.height(4.dp))
            Text(
                subtitle,
                fontSize = 11.sp,
                color = TextSecondary,
                maxLines = 2
            )
        }
    }
}

@Composable
private fun BottomNavBar(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxWidth()) {
        Surface(
            color = Color.White,
            shadowElevation = 12.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .windowInsetsPadding(WindowInsets.navigationBars)
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                NavItem("Trang chủ", Icons.Filled.Home, selected = true, modifier = Modifier.weight(1f))
                NavItem("Sự kiện", Icons.Outlined.Event, selected = false, modifier = Modifier.weight(1f))
                Spacer(Modifier.weight(1f)) // space for FAB
                NavItem(
                    "Thông báo",
                    Icons.Filled.Notifications,
                    selected = false,
                    badgeText = "10",
                    modifier = Modifier.weight(1f)
                )
                NavItem("Tài khoản", Icons.Filled.Person, selected = false, modifier = Modifier.weight(1f))
            }
        }
        // QR Code FAB
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (-22).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(HoaSenBlue)
                    .border(4.dp, Color.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Filled.QrCodeScanner,
                    contentDescription = "QR Code",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
            }
            Spacer(Modifier.height(2.dp))
            Text("QR Code", fontSize = 10.sp, color = TextPrimary, fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
private fun NavItem(
    label: String,
    icon: ImageVector,
    selected: Boolean,
    badgeText: String? = null,
    modifier: Modifier = Modifier
) {
    val color = if (selected) HoaSenBlue else TextSecondary
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (badgeText != null) {
            BadgedBox(badge = {
                Badge(containerColor = HoaSenRed, contentColor = Color.White) {
                    Text(badgeText, fontSize = 9.sp)
                }
            }) {
                Icon(icon, contentDescription = label, tint = color, modifier = Modifier.size(22.dp))
            }
        } else {
            Icon(icon, contentDescription = label, tint = color, modifier = Modifier.size(22.dp))
        }
        Spacer(Modifier.height(2.dp))
        Text(label, fontSize = 10.sp, color = color, fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal)
    }
}
