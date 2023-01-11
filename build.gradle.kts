plugins {
  kotlin("jvm") version "1.8.0"
  java
  alias(libs.plugins.quilt.loom)
}

version = property("version")!!

repositories {
  maven("https://jitpack.io") // mixin extras
}

dependencies {
  minecraft(libs.minecraft)
  mappings(variantOf(libs.quilt.mappings) { classifier("intermediary-v2") })
  modImplementation(libs.quilt.loader)
  modImplementation(libs.quilted.fabric.api)
  modImplementation(libs.quilt.kotlin)

  implementation(libs.mixinextras)
  include(libs.mixinextras)
  annotationProcessor(libs.mixinextras)
}

tasks {

  processResources {
    inputs.property("version", project.version)
    filesMatching("quilt.mod.json") {
      expand(mutableMapOf("version" to project.version))
    }
  }

  jar {
    from("LICENSE")
  }

  compileKotlin {
    kotlinOptions.jvmTarget = "17"
  }
}

java {
  withSourcesJar()
}
