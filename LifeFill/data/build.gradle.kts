plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.example.lifefill.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(project(":core"))
    implementation(libs.room.runtime)
    annotationProcessor(libs.room.compiler)
    implementation(libs.sqlcipher)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.appcompat)
    testImplementation(libs.junit)
}