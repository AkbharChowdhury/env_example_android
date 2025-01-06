import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties


plugins {
    alias(libs.plugins.android.application)
}

val apiKey: String = gradleLocalProperties(rootDir,providers)
    .getProperty("api","No API Key found")


android {
    namespace = "com.myapp.env_android_example"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.myapp.env_android_example"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        resValue("string", "api", String.format("%s", apiKey))

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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}


//
//resValue("string", "api",Str.""
//    "\"" + api +  "\""
//)
//
//defaultConfig {
//    resValue "string", "prod_name", ""
//    resValue "string", "beta_name", ""
//}

