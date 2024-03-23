plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)

}


kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }

    jvm()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    )

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.koin.core)
            implementation(libs.kotlinx.datetime)
            implementation(project(":shared:core-common"))
        }

        androidMain.dependencies {
            implementation(libs.androidx.lifecycle.viewmodel.ktx)
            implementation(libs.koin.android)
        }
    }
}


android {
    namespace = "com.dee.themovie.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}