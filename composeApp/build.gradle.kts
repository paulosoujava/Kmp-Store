import org.jetbrains.kotlin.platform.jvm.JvmPlatforms

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.cocoapods)
    alias(libs.plugins.android.application)
    alias(libs.plugins.libres)
    alias(libs.plugins.buildConfig)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.sqlDelight)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        version = "1.0.0"
        summary = "Compose application framework"
        homepage = "empty"
        ios.deploymentTarget = "11.0"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.material3)
                implementation(libs.libres)
                implementation(libs.voyager.navigator)
                implementation(libs.composeImageLoader)
                implementation(libs.napier)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.insetsx)
                implementation(libs.composeIcons.featherIcons)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kotlinx.datetime)
                implementation(libs.koin.core)
                implementation(libs.realm.driver)

                implementation("media.kamel:kamel-image:0.7.1")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.appcompat)
                implementation(libs.androidx.activityCompose)
                implementation(libs.compose.uitooling)
                implementation(libs.kotlinx.coroutines.android)
                implementation(libs.sqlDelight.driver.android)
            }
        }

        val iosMain by getting {
            dependencies {
                implementation(libs.sqlDelight.driver.native)
            }
        }

    }
}

android {
    namespace = "paulo.jorge.app"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33

        applicationId = "paulo.jorge.app.androidApp"
        versionCode = 1
        versionName = "1.0.0"
    }

    sourceSets["main"].apply {
        manifest.srcFile("src/androidMain/AndroidManifest.xml")
        res.srcDirs("src/androidMain/resources")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
    packagingOptions {
        resources.excludes.add("META-INF/**")
    }
}


libres {
    // https://github.com/Skeptick/libres#setup
}

buildConfig {
  // BuildConfig configuration here.
  // https://github.com/gmazzo/gradle-buildconfig-plugin#usage-in-kts
}

sqldelight {
  databases {
    create("MyDatabase") {
      // Database configuration here.
      // https://cashapp.github.io/sqldelight
      packageName.set("paulo.jorge.app.db")
    }
  }
}
dependencies {
    implementation("androidx.core:core:1.10.1")
    commonMainApi("dev.icerock.moko:mvvm-core:0.16.1")
    commonMainApi("dev.icerock.moko:mvvm-compose:0.16.1")
    commonMainApi("dev.icerock.moko:mvvm-flow:0.16.1")
    commonMainApi("dev.icerock.moko:mvvm-flow-compose:0.16.1")
}
