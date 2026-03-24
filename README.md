# KMP-Starter

A Kotlin Multiplatform application targeting **Android** and **iOS**, built with Compose Multiplatform for shared UI.

---

## Tech Stack

| Layer | Library | Version |
|-------|---------|---------|
| Build | AGP | 9.0.1 |
| Language | Kotlin | 2.3.20 |
| UI | Compose Multiplatform | 1.10.3 |
| DI | Koin + Koin Annotations | 4.2.0 / 2.3.1 |
| Networking | Ktorfit + Ktor | 2.7.2 / 3.3.3 |
| Database | Room + SQLite | 2.8.4 / 2.6.2 |
| Code Gen | KSP | 2.3.6 |

---

## Project Structure

```
Newsy/
├── androidApp/          # Android application entry point (com.android.application)
│   └── src/main/
│       ├── kotlin/      # MainActivity — launches the shared Compose UI
│       └── res/         # Launcher icons, strings
│
├── composeApp/          # Shared KMP library (com.android.kotlin.multiplatform.library)
│   └── src/
│       ├── commonMain/  # Shared UI, business logic, data layer
│       ├── androidMain/ # Android-specific implementations
│       └── iosMain/     # iOS-specific implementations
│
└── iosApp/              # Xcode project — iOS application entry point
```

### Module responsibilities

- **`androidApp`** — thin shell. Owns `applicationId`, version, launcher icons, and `MainActivity`. Has no business logic; delegates everything to `composeApp`.
- **`composeApp`** — all shared code: Compose UI, ViewModels, Room database, Ktorfit API clients, and platform `expect`/`actual` declarations.
- **`iosApp`** — Swift entry point that loads the `ComposeApp` framework produced by `composeApp`.

---

* [/iosApp](./iosApp/iosApp) contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform,
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

```
androidApp / iosApp
      │
      ▼
  composeApp (commonMain)
  ├── UI          Compose Multiplatform screens & components
  ├── ViewModel   Lifecycle-aware state holders (androidx.lifecycle)
  ├── Network     Ktorfit interfaces → Ktor HTTP client
  └── Database    Room DAOs + entities (SQLite bundled driver)
```

Dependency injection is handled by **Koin** with compile-time safety via **Koin Annotations** processed by **KSP**.

---

## Build & Run

### Android

To build and run the development version of the Android app, use the run configuration from the run widget
in your IDE’s toolbar or build it directly from the terminal:
- on macOS/Linux
  ```shell
  ./gradlew :composeApp:assembleDebug
  ```
- on Windows
  ```shell
  .\gradlew.bat :composeApp:assembleDebug
  ```
### iOS

Open `iosApp/iosApp.xcodeproj` in Xcode and run on a simulator or device.

The Xcode build triggers Gradle to compile `composeApp` into the `ComposeApp.framework` automatically via the `embedAndSignAppleFrameworkForXcode` task.
To build and run the development version of the iOS app, use the run configuration from the run widget
in your IDE’s toolbar or open the [/iosApp](./iosApp) directory in Xcode and run it from there.

---

## Requirements

- Android Studio Meerkat (2024.3.1) or newer
- JDK 11+
- Xcode 16+ (for iOS builds)
- Android compile SDK 36, min SDK 24
  Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
