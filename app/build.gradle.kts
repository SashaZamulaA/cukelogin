plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}
//test
android {
    namespace = "com.example.cukelogin"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.cukelogin"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        // Cucumber runner
        testInstrumentationRunner = "io.cucumber.android.runner.CucumberAndroidJUnitRunner"
        testInstrumentationRunnerArguments += mapOf(
            "features" to "features",                         // папка в assets
            "glue"      to "com.example.cukelogin.steps",     // пакет зі step-ами
            "plugin"    to "pretty"                           // або "html:/sdcard/Download/cucumber.html"
            // за потреби: "tags" to "@happy_path"
        )
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
    kotlinOptions { jvmTarget = "11" }

    buildFeatures {
        compose = true
        viewBinding = true
    }

    // щоб .feature з assets підхоплювалися
    sourceSets["androidTest"].assets.srcDirs("src/androidTest/assets")

    testOptions { animationsDisabled = true }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.material)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    androidTestImplementation(libs.cucumber.android.v7140)
    androidTestImplementation(libs.cucumber.picocontainer.v7140)

    testImplementation(libs.junit)

    // AndroidX Test / Espresso
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Потрібно для launchActivity / ActivityScenario
    androidTestImplementation(libs.core.ktx)

//    // Cucumber Android
//    androidTestImplementation(libs.cucumber.android)
//    androidTestImplementation(libs.cucumber.picocontainer)
    // ВАЖЛИВО: анотації Given/When/Then
    androidTestImplementation(libs.cucumber.java)

    // Compose тестові (можуть лишатись)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
