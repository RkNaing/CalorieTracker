plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    compileOnly(gradleApi())

    implementation(libs.gradle.plugin.android)
    implementation(libs.gradle.plugin.kotlin)
    implementation(libs.hilt.gradle.plugin)
    implementation(libs.gradle.plugin.ksp)
//    implementation(libs.google.services.plugin)
//    implementation(libs.firebase.crashlytics.gradle.plugin)
//    implementation(libs.detekt.gradle.plugin)
    implementation(libs.kotlinx.serialization.plugin)


    // Make version catalog available in precompiled scripts
    // https://github.com/gradle/gradle/issues/15383#issuecomment-1567461389
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))

//    implementation("com.android.tools.build:gradle:${libs.versions.androidGradlePlugin.get()}")
//    implementation(kotlin("gradle-plugin", libs.versions.kotlin.asProvider().get()))
//    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.versions.kotlin.asProvider().get()}")
}