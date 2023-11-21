// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.3" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("io.spring.dependency-management") version "1.0.6.RELEASE"
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.security:spring-security-bom:5.8.0")
    }
}