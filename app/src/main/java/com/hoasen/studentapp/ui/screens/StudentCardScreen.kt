package com.hoasen.studentapp.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hoasen.studentapp.R
import com.hoasen.studentapp.ui.theme.BgGray
import com.hoasen.studentapp.ui.theme.HoaSenBlue
import com.hoasen.studentapp.ui.theme.HoaSenGreen
import com.hoasen.studentapp.ui.theme.HoaSenRed
import com.hoasen.studentapp.ui.theme.HoaSenYellow
import com.hoasen.studentapp.ui.theme.TextPrimary
import com.hoasen.studentapp.ui.theme.TextSecondary
import kotlin.random.Random

@Composable
fun StudentCardScreen(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BgGray)
    ) {
        TopBar(onBack = onBack)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Surface(
                color = Color.White,
                shape = RoundedCornerShape(8.dp),
                shadowElevation = 2.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    PixelBorder()
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        HoaSenLogo()
                        Spacer(Modifier.height(16.dp))
                        Text(
                            "Thẻ sinh viên",
                            fontSize = 14.sp,
                            color = TextPrimary
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(
                            "ĐỖ THÀNH NGUYÊN",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary,
                            textAlign = TextAlign.Center
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(
                            "22122349",
                            fontSize = 15.sp,
                            color = TextPrimary
                        )
                        Spacer(Modifier.height(14.dp))
                        Image(
                            painter = androidx.compose.ui.res.painterResource(id = R.drawable.student_photo),
                            contentDescription = "Ảnh sinh viên",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(140.dp)
                                .height(180.dp)
                        )
                        Spacer(Modifier.height(14.dp))
                        Text(
                            "Kinh doanh Quốc tế",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = TextPrimary
                        )
                        Spacer(Modifier.height(12.dp))
                        InfoRow("Ngày sinh", "19-03-2003")
                        Spacer(Modifier.height(6.dp))
                        InfoRow("Khoá", "2021 - 2027")
                        Spacer(Modifier.height(16.dp))
                        Barcode()
                        Spacer(Modifier.height(4.dp))
                    }
                    PixelBorder()
                }
            }
            Spacer(Modifier.height(24.dp))
        }
    }
}

@Composable
private fun TopBar(onBack: () -> Unit) {
    Surface(color = HoaSenBlue) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsPadding(WindowInsets.statusBars)
                .height(52.dp)
                .padding(horizontal = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Quay lại",
                    tint = Color.White
                )
            }
            Spacer(Modifier.width(4.dp))
            Text(
                "Thẻ sinh viên",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
private fun HoaSenLogo() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = androidx.compose.ui.res.painterResource(id = R.mipmap.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Spacer(Modifier.width(6.dp))
            Column {
                Text(
                    "ĐẠI HỌC",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = HoaSenBlue
                )
                Text(
                    "HOA SEN",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = HoaSenBlue
                )
            }
        }
        Spacer(Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .background(HoaSenRed)
                .padding(horizontal = 10.dp, vertical = 3.dp)
        ) {
            Text(
                "TÔN TRỌNG SỰ KHÁC BIỆT",
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun InfoRow(label: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            label,
            fontSize = 13.sp,
            color = TextPrimary,
            modifier = Modifier.weight(1f)
        )
        Text(
            value,
            fontSize = 13.sp,
            color = TextPrimary,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun PixelBorder() {
    // Decorative pixel-art border using small colored squares
    val palette = listOf(HoaSenYellow, HoaSenRed, HoaSenBlue, HoaSenGreen, Color.White, Color.White)
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(18.dp)
    ) {
        val sq = size.height / 2.2f
        val cols = (size.width / sq).toInt() + 1
        val rows = 2
        val rng = Random(42) // deterministic
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (rng.nextFloat() > 0.45f) {
                    val color = palette[rng.nextInt(palette.size)]
                    drawRect(
                        color = color,
                        topLeft = Offset(c * sq, r * sq),
                        size = Size(sq, sq)
                    )
                }
            }
        }
    }
}

@Composable
private fun Barcode() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
        ) {
            val rng = Random(22122673)
            var x = 0f
            while (x < size.width) {
                val w = (rng.nextInt(1, 5)).toFloat()
                if (rng.nextBoolean()) {
                    drawRect(
                        color = Color.Black,
                        topLeft = Offset(x, 0f),
                        size = Size(w, size.height)
                    )
                }
                x += w + 1f
            }
        }
        Spacer(Modifier.height(2.dp))
        Text(
            "22122673",
            fontSize = 12.sp,
            letterSpacing = 2.sp,
            color = TextPrimary
        )
    }
}
