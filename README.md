# Integratie van de Colorblindness SDK

Deze README beschrijft de stappen voor programmeurs om de Colorblindness SDK in een Android-project te integreren.

## Installatie

1.  **Include de SDK module in `settings.gradle.kts`:**
    ```kotlin
    rootProject.name = "{project-name}"
    include(":app", ":sdk_colorblindness")
    ```

2.  **Voeg de SDK implementatie toe aan het `build.gradle.kts` bestand van je app module:**
    ```kotlin
    dependencies {
        implementation(project(":sdk_colorblindness"))
        // andere dependencies 
    }
    ```

3.  **Voeg de benodigde repositories toe aan het `settings.gradle.kts` bestand op root niveau:**
    ```kotlin
    pluginManagement {
        repositories {
            google()
            mavenCentral()
            gradlePluginPortal()
        }
    }

    dependencyResolutionManagement {
        repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
        repositories {
            mavenCentral()
            maven("[https://jitpack.io](https://jitpack.io)")
            google()
        }
    }
    ```