pluginManagement {
    repositories {
        google()           // هذا ما كان ينقصك لتحميل Plugin الأندرويد
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "DevSplitAI"
include(":app")
