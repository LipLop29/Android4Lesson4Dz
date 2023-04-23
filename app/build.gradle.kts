plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    //Kapt
    kotlin ("kapt")
    //Hilt
    id ("com.google.dagger.hilt.android")
    //Safe args
    id ("androidx.navigation.safeargs")
}

android {
    namespace = "com.example.android4lesson4dz"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.android4lesson4dz"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    //Core
    implementation ("androidx.core:core-ktx:1.10.0")
    //AppCompat
    implementation ("androidx.appcompat:appcompat:1.6.1")
    //Material Design
    implementation ("com.google.android.material:material:1.8.0")
    //Ui Components
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")

    //Live Cycle
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    // Fragment
    val fragment_version = "1.5.5"
    //noinspection GradleDependency
    implementation ("androidx.fragment:fragment-ktx:$fragment_version")

    //Retrofit 2
    val retrofitVersion = "2.9.0"
    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    //Gson
    implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")

    // OkHttp
    implementation ("com.squareup.okhttp3:okhttp-bom:5.0.0-alpha.6")
    implementation ("com.squareup.okhttp3:okhttp")
    implementation ("com.squareup.okhttp3:logging-interceptor")

    // ViewBindingPropertyDelegate
    val view_binding_property_delegate = "1.5.3"
    // To use only without reflection variants of viewBinding
    //noinspection GradleDependency
    implementation ("com.github.kirich1409:viewbindingpropertydelegate-noreflection:$view_binding_property_delegate")

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.15.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.15.0")

    // Navigation
    val navVersion = "2.5.3"
    //   implementation
    implementation ("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation ("androidx.navigation:navigation-ui-ktx:$navVersion")

    //hilt
    val hilt_version = "2.45"
    implementation ("com.google.dagger:hilt-android:$hilt_version")
    kapt ("com.google.dagger:hilt-compiler:$hilt_version")

    // paging 3
    val paging_version = "3.1.1"
    implementation ("androidx.paging:paging-runtime:$paging_version")
}