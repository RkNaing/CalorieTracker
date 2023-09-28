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
}

dependencies {

    coreLibraryDesugaring(libs.core.desugar)

    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)

    setupTestingDependencies()
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


