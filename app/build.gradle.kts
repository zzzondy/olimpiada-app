plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinSerialization)
    id(Plugins.kapt)
    id(Plugins.daggerHilt)
}

android {
    namespace = "com.olimpiadaapp"
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField(
                "String",
                "API_URL",
                "\"https://mobile-olympiad-trajectory.hb.bizmrg.com/\""
            )
        }

        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField(
                "String",
                "API_URL",
                "\"https://mobile-olympiad-trajectory.hb.bizmrg.com/\""
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.composeVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Lifecycle
    implementation(Dependencies.Lifecycle.core)
    implementation(Dependencies.Lifecycle.activity)
    implementation(Dependencies.Lifecycle.lifecycleRuntime)
    implementation(Dependencies.Lifecycle.splashScreen)

    // Compose
    implementation(platform(Dependencies.Compose.bom))
    androidTestImplementation(platform(Dependencies.Compose.bom))

    // Ui
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.material3)


    // Landscapist
    implementation(Dependencies.Landscapist.bom)
    implementation(Dependencies.Landscapist.coil)

    //Navigation
    implementation(Dependencies.Compose.navigation)

    // Compose tooling
    debugImplementation(Dependencies.Compose.composeTooling)
    implementation(Dependencies.Compose.composeToolingPreview)
    debugImplementation(Dependencies.Compose.testManifest)

    // Serialization
    implementation(Dependencies.Serialization.kotlinSerializationJson)

    // OkHttp3
    implementation(Dependencies.OkHttp3.okhttp)
    debugImplementation(Dependencies.OkHttp3.loggingInterceptor)

    // Retrofit
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.serialization)

    // Hilt
    kapt(Dependencies.Hilt.hiltCompiler)
    kapt(Dependencies.Hilt.hiltAndroidCompiler)
    implementation(Dependencies.Hilt.hiltCompose)
    implementation(Dependencies.Hilt.hilt)

    // Testing
    testImplementation(Dependencies.Testing.junit)
    androidTestImplementation(Dependencies.Testing.androidJUnit)
    androidTestImplementation(Dependencies.Testing.espresso)
    androidTestImplementation(Dependencies.Testing.composeTests)
    testImplementation(Dependencies.Testing.mockito)
    testImplementation(Dependencies.Testing.coroutines)
}