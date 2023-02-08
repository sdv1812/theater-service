import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.time.format.DateTimeFormatter
import java.time.LocalDateTime

plugins {
	id("org.springframework.boot") version "3.0.1"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
	kotlin("plugin.noarg") version "1.7.22"
	kotlin("plugin.jpa") version "1.7.22"
}

group = "com.sanskar"

val dateTime: LocalDateTime = LocalDateTime.now()
val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-hh-mm-ss")
version = dateTime.format(dateTimeFormatter)

java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.postgresql:postgresql")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.10")
	implementation("aws.sdk.kotlin:sqs:0.19.4-beta")
	implementation("com.google.code.gson:gson:2.8.5")
	implementation("com.amazonaws.secretsmanager:aws-secretsmanager-jdbc:1.0.8")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.getByName<Jar>("jar") {
	enabled = false
}

