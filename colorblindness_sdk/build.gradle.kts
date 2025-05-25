plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("maven-publish")
}

android {
    namespace = "com.colorblindness.sdk.jh"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.runtime.android)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.material3.android)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "com.github.haegemanjasper"
            artifactId = "ColorBlindnessSDK"
            version = "2.1"
            artifact("$buildDir/libs/colorblindness_sdk-release.aar")
        }
    }
}

// ✅ Deze taak kopieert het .aar bestand naar waar JitPack het verwacht
tasks.register<Copy>("copyAarToLibs") {
    dependsOn("bundleReleaseAar")
    from("$buildDir/outputs/aar/")
    include("colorblindness_sdk-release.aar")
    into("$buildDir/libs/")
}

// ✅ Dit zorgt dat publish pas gebeurt NADAT het .aar is gekopieerd
tasks.withType<PublishToMavenRepository> {
    dependsOn("copyAarToLibs")
}
