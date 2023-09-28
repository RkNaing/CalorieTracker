@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id(Plugins.COMPOSE_LIB_MODULE)
}

android {
    namespace = "com.rkzmn.calorietracker.onboarding.presentation"
}

dependencies {

    implementation(projects.core)
    implementation(projects.coreUi)
    implementation(projects.onboarding.onboardingDomain)
}