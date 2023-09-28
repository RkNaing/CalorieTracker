@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id(Plugins.COMMON_LIB_MODULE)
}

android {
    namespace = "com.rkzmn.calorietracker.tracker.domain"
}

dependencies {
    implementation(projects.core)
}