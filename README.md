# Hoa Sen Student App

Ứng dụng Android mô phỏng app sinh viên Đại học Hoa Sen, gồm 2 màn hình chính:

- **Trang chủ**: header thông tin sinh viên, lưới "Tính năng yêu thích", sự kiện sắp tới, bottom navigation 5 mục với FAB quét QR.
- **Thẻ sinh viên**: thẻ sinh viên đầy đủ logo Hoa Sen, ảnh, ngành, ngày sinh, khoá, mã vạch.

Tech: **Kotlin + Jetpack Compose**, `compileSdk 34`, `minSdk 24`.

---

## Cách build file APK (không cần cài gì trên máy)

### Bước 1 — Tạo repo trên GitHub
1. Đăng nhập https://github.com, bấm **New repository**.
2. Đặt tên repo (vd: `hoasen-student-app`), chọn **Public** (để được dùng GitHub Actions miễn phí), bấm **Create**.

### Bước 2 — Upload toàn bộ thư mục `Hoasenapp` lên repo
Cách dễ nhất (không cần dùng git CLI):
1. Trong repo vừa tạo, bấm **Add file → Upload files**.
2. Mở Explorer Windows, vào thư mục `Hoasenapp`, **chọn TẤT CẢ các file và thư mục bên trong** (Ctrl+A, gồm `.github`, `app`, `gradle`, `build.gradle.kts`, …) và **kéo thả** vào trang upload của GitHub.
3. Bấm **Commit changes**.

> 💡 Lưu ý: cần đảm bảo thư mục `.github/workflows/build.yml` được upload — đó là file kích hoạt build.

### Bước 3 — Chờ GitHub Actions build APK
- Sau khi commit, mở tab **Actions** trên repo → workflow **Build APK** sẽ tự chạy.
- Build mất ~3-5 phút. Khi hoàn tất sẽ có dấu ✓ xanh.

### Bước 4 — Tải file APK
- Bấm vào job đã chạy xong → cuộn xuống mục **Artifacts** → tải `HoaSenStudent-APK.zip`.
- Giải nén sẽ có 2 file:
  - `HoaSenStudent-debug.apk` ← **dùng file này**, cài đơn giản nhất
  - `HoaSenStudent-release.apk` (đã sign bằng debug key, cũng cài được)

### Bước 5 — Cài lên điện thoại Android
- Copy file `.apk` vào điện thoại (qua USB / Google Drive / Zalo gửi file cho chính mình).
- Trên điện thoại, mở file → cho phép **"Cài đặt từ nguồn không xác định"** nếu được hỏi → cài.
- Icon app sẽ hiển thị logo Đại học Hoa Sen, tên app là "Hoa Sen Sinh viên".

---

## Cấu trúc project

```
Hoasenapp/
├── app/
│   ├── build.gradle.kts
│   ├── proguard-rules.pro
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/hoasen/studentapp/
│       │   ├── MainActivity.kt
│       │   ├── ui/theme/Theme.kt
│       │   └── ui/screens/
│       │       ├── HomeScreen.kt
│       │       └── StudentCardScreen.kt
│       └── res/
│           ├── drawable-nodpi/student_photo.png
│           ├── mipmap-*/ic_launcher*.png
│           ├── mipmap-anydpi-v26/ic_launcher*.xml
│           └── values/{colors,strings,themes}.xml
├── .github/workflows/build.yml      # CI build APK
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
└── gradle/wrapper/gradle-wrapper.properties
```

## Build local (nếu sau này bạn cài Android Studio)

```bash
# Mở project bằng Android Studio (Open → chọn thư mục Hoasenapp)
# rồi bấm Build → Build APK(s)
# Hoặc CLI:
./gradlew assembleDebug
# APK ở: app/build/outputs/apk/debug/app-debug.apk
```
