@file:Suppress("UnstableApiUsage")

pluginManagement {

    /**
     * The pluginManagement.repositories block configures the
     * repositories Gradle uses to search or download the Gradle plugins and
     * their transitive dependencies. Gradle pre-configures support for remote
     * repositories such as JCenter, Maven Central, and Ivy. You can also use
     * local repositories or define your own remote repositories. The code below
     * defines the
     *
     *  - Gradle Plugin Portal [https://plugins.gradle.org/],
     *  - Google's Maven repository [https://maven.google.com/],
     *  - Maven Central Repository [https://search.maven.org/]
     *
     *  as the repositories Gradle should use to look for its dependencies.
     */
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    /**
     * The dependencyResolutionManagement.repositories
     * block is where you configure the repositories and dependencies used by
     * all modules in your project, such as libraries that you are using to
     * create your application. However, you should configure module-specific
     * dependencies in each module-level build.gradle file. For new projects,
     * Android Studio includes Google's Maven repository and the Maven Central
     * Repository by default, but it does not configure any dependencies (unless
     * you select a template that requires some).
     */
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "CalorieTracker"

include(":app")
include(":core")
include(":core-ui")
include(":onboarding")
include(":onboarding:onboarding_presentation")
include(":onboarding:onboarding_domain")
include(":tracker")
include(":tracker:tracker_data")
include(":tracker:tracker_domain")
include(":tracker:tracker_presentation")
