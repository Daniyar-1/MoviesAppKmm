plugins {
    id("com.android.application")
    kotlin("android") }

android {
    namespace = "com.example.moviesappkmm.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.example.moviesappkmm.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.4"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.4.0")
    implementation("androidx.compose.ui:ui-tooling:1.4.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.0")
    implementation("androidx.compose.foundation:foundation:1.4.0")
    implementation("androidx.compose.material:material:1.4.0")
    implementation("androidx.activity:activity-compose:1.7.0")

    //Koin
    val koinComposeVersion = "3.4.1"
    implementation("io.insert-koin:koin-androidx-compose:$koinComposeVersion")

    //Coil
    val coilVersion = "2.2.2"
    implementation("io.coil-kt:coil-compose:$coilVersion")

    val accompanistVersion = "0.28.0"
    implementation("com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion")

    //NavComponents
    val navVersion = "2.5.3"
    implementation("androidx.navigation:navigation-compose:$navVersion")

    //Material3
    implementation("androidx.compose.material3:material3:1.1.0")
    implementation("androidx.compose.material3:material3-window-size-class:1.1.0")

    //CollectAsFlow
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")

    //lottie animation
    implementation("com.airbnb.android:lottie-compose:4.2.0")

}