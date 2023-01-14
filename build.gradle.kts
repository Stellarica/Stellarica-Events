plugins {
  kotlin("jvm") version "1.8.0"
  java
  `maven-publish`
  alias(libs.plugins.quilt.loom)
}

version = property("mod_version")!!

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


publishing {
  repositories {
    maven {
      name = "Stellarica"
      url = uri("https://repo.stellarica.net/releases")
      credentials(PasswordCredentials::class)
      authentication {
        create<BasicAuthentication>("basic")
      }
    }
  }
  publications {
    create<MavenPublication>("maven") {
      groupId = "net.stellarica" // todo: move these to gradle properties
      artifactId = "oxidiser"
      version = project.version.toString()
      from(components["java"])
    }
  }
}
