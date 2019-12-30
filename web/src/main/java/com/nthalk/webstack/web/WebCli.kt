package com.nthalk.webstack.web

import org.docopt.Docopt
import org.springframework.boot.SpringApplication
import java.io.IOException
import java.util.*

object WebCli {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val docopt = Docopt(
                Objects.requireNonNull(
                        WebCli::class.java.classLoader.getResourceAsStream("WebCli.docopt")))
        docopt.withHelp(true)
        val build = Properties()
        build.load(WebCli::class.java.classLoader.getResourceAsStream("build.properties"))
        docopt.withVersion(build.getProperty("build.version"))
        val opts = docopt.parse(*args)
        System.setProperty("server.port", opts["--port"] as String?)
        System.setProperty("migrate", if ((opts["--migrate"] as Boolean?)!!) "true" else "false")
        val home = System.getProperty("home", "./home")
        System.setProperty(
                "spring.config.location",
                ""
                        + "classpath:application.properties,"
                        + "file:$home/application.properties,"
                        + "file:$home/secret.properties")
        SpringApplication.run(WebCli::class.java, *args)
    }
}
