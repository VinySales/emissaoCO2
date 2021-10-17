plugins {
    java
    application
}

repositories {
    jcenter()
}

dependencies {
    // Use JUnit test framework
    testImplementation("junit:junit:4.12")
    compile(group="com.google.code.gson", name="gson", version="2.8.5")
    compile(group="com.google.guava", name="guava", version="27.1-jre")
}

application {
    mainClassName = "br.unip.aps.cc2.App"
}
