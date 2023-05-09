import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "com.github.joaovictorjs"
version = "1.0.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    jvm {
        jvmToolchain(11)
        withJava()
    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
        val jvmTest by getting
    }
}

compose.desktop {
    application {
        args += listOf("version=$version")
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.AppImage)
            packageName = "Open It"
            version = "$version"
            description = "A software to open files"
            copyright = "© 2023 João Victor Justino de Souza. Todos os direitos reservados."
            vendor = "joaovictorjs"
            licenseFile.set(project.file("LICENSE"))
            packageVersion = "$version"

            windows {
                iconFile.set(project.file("logo.ico"))
                menuGroup = "Open It"
                menu = true
            }

            linux {
                iconFile.set(project.file("logo.png"))
            }
        }
    }
}
