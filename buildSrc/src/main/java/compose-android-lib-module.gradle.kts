plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    compileSdk = ProjectConfigs.COMPILE_SDK

    defaultConfig {
        minSdk = ProjectConfigs.MIN_SDK

        testInstrumentationRunner = ProjectConfigs.TEST_RUNNER
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = ProjectConfigs.MINIFY_ENABLED
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true

        val javaVersion = JavaVersion.toVersion(ProjectConfigs.javaSourceCodeCompatibilityVersion)
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    kotlinOptions {
        jvmTarget = ProjectConfigs.javaSourceCodeCompatibilityVersion.toString()
    }

    kotlin {
        jvmToolchain(ProjectConfigs.javaToolchainVersion)
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}

dependencies {
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)

    setupJetpackCompose()

    setupTestingDependencies()
}

fun DependencyHandlerScope.setupJetpackCompose() {
    val composeBom = platform(libs.compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation(libs.compose.ui)

    // Material 3
    implementation(libs.compose.material)
    implementation(libs.compose.material.icons.extended)
    implementation(libs.compose.material.window.size)

    implementation(libs.activity.compose) // Integration with activities
    implementation(libs.viewmodel.compose) // Integration with ViewModels
    implementation(libs.lifecycle.runtime.compose)

    implementation(libs.hilt.navigation.compose)

    implementation(libs.navigation.compose)
    androidTestImplementation(libs.navigation.compose.test)

    implementation(libs.coil.compose)

    // Android Studio Preview support
    implementation(libs.compose.ui.tooling.preview)
    debugImplementation(libs.compose.ui.tooling)

    // UI Tests
    androidTestImplementation(libs.compose.junit4)
    debugImplementation(libs.compose.test.manifest)

    /* Accompanist Libraries */
    implementation(libs.accompanist.material.placeholder)
    implementation(libs.accompanist.systemuicontroller)
}

fun DependencyHandlerScope.setupTestingDependencies(){
    testImplementation(libs.junit)
    testImplementation(libs.junit.android)
    testImplementation(libs.truth)
    testImplementation(libs.truth.android)
    testImplementation(libs.turbine)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.mockk.android)
    testImplementation(libs.mockk.agent)
    testImplementation(libs.mockwebserver)

    androidTestImplementation(libs.junit)
    androidTestImplementation(libs.junit.android)
    androidTestImplementation(libs.truth)
    androidTestImplementation(libs.truth.android)
    androidTestImplementation(libs.turbine)
    androidTestImplementation(libs.kotlinx.coroutines.test)
    androidTestImplementation(libs.mockk.android)
    androidTestImplementation(libs.mockk.agent)
    androidTestImplementation(libs.mockwebserver)
    androidTestImplementation(libs.hilt.android.testing)
    kspAndroidTest(libs.hilt.android.compiler)
}


