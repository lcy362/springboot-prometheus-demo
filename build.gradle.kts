plugins {
    id("org.springframework.boot") version "2.5.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("java")
    kotlin("jvm") version "1.4.20"
}

group = "top.sand"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.alibaba:fastjson:1.1.25")
    implementation("org.apache.commons:commons-lang3:3.0")
    compileOnly ("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("org.aspectj:aspectjweaver")
    implementation("org.apache.httpcomponents:httpclient:4.5")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("io.micrometer:micrometer-registry-prometheus")
    implementation("com.lmax:disruptor:3.4.2")
    implementation("com.google.guava:guava:11.0.2")
}

tasks.withType<Test>{
    useJUnitPlatform()
}


