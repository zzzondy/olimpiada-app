object Dependencies {
    object Compose {
        const val composeVersion = "1.4.2"
        private const val composeBomVersion = "2023.01.00"

        // UI
        const val bom = "androidx.compose:compose-bom:$composeBomVersion"
        const val ui = "androidx.compose.ui:ui"
        const val material3 = "androidx.compose.material3:material3:1.1.0-alpha06"

        // Tooling
        const val composeToolingPreview = "androidx.compose.ui:ui-tooling-preview"
        const val composeTooling = "androidx.compose.ui:ui-tooling"
        const val testManifest = "androidx.compose.ui:ui-test-manifest"

        // Navigation
        const val navigation = "androidx.navigation:navigation-compose:2.5.1"
    }

    object Lifecycle {
        const val core = "androidx.core:core-ktx:1.9.0"
        const val activity = "androidx.activity:activity-compose:1.6.1"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
        const val splashScreen = "androidx.core:core-splashscreen:1.0.0"
    }

    object Testing {
        const val junit = "junit:junit:4.13.2"
        const val androidJUnit = "androidx.test.ext:junit:1.1.3"
        const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
        const val composeTests = "androidx.compose.ui:ui-test-junit4:1.2.1"
        const val mockito = "org.mockito.kotlin:mockito-kotlin:4.1.0"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4"
    }

    object Landscapist {
        // Image loading
        private const val landscapistVersion = "2.1.0"

        const val bom = "com.github.skydoves:landscapist-bom:$landscapistVersion"
        const val coil = "com.github.skydoves:landscapist-coil"
    }

    object Serialization {
        const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:1.8.10"
        const val kotlinSerializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1"
    }

    object OkHttp3 {
        private const val okHttpVersion = "4.9.0"

        const val okhttp = "com.squareup.okhttp3:okhttp:$okHttpVersion"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$okHttpVersion"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val serialization = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
    }

    object Hilt {
        private const val hiltVersion = "2.44"

        const val daggerHiltProject = "com.google.dagger:hilt-android-gradle-plugin:$hiltVersion"

        const val hilt = "com.google.dagger:hilt-android:$hiltVersion"
        const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:$hiltVersion"
        const val hiltCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"
        const val hiltCompiler = "androidx.hilt:hilt-compiler:1.0.0"
    }
}