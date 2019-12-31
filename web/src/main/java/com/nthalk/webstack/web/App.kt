package com.nthalk.webstack.web

import org.docopt.Docopt
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import java.io.IOException
import java.util.*


@SpringBootApplication
@EnableAspectJAutoProxy
@EnableScheduling
@EnableAsync
@EnableWebMvc
@EnableTransactionManagement
class App {

    companion object {
        @Throws(IOException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val docopt = Docopt("""
                Web Cli
                
                Usage:
                    webcli
                    webcli start [--port=<port>] [--jdbcurl=<jdbcurl>] [--migrate]
                    webcli -h | --help
                    webcli --version
                
                Options:
                    -p --port=<port>        Port to listen on [default: 8080].
                    -d --jdbcurl=<jdbcurl>  Jdbc url to use [default: jdbc:h2:tcp://localhost:9092/mem:db].
                    -m --migrate            Migrate when starting [default: true].
                    -h --help               Show this screen.
                    --version               Show version.
                """.trimIndent())
            docopt.withHelp(true)
            val build = Properties()
            build.load(App::class.java.classLoader.getResourceAsStream("build.properties"))
            docopt.withVersion(build.getProperty("build.version"))
            val opts = docopt.parse(*args)
            System.setProperty("server.port", opts["--port"] as String)
            System.setProperty("migrate", if (opts["--migrate"] as Boolean) "true" else "false")
            val home = System.getProperty("home", "./home")
            System.setProperty(
                    "spring.config.location",
                    ""
                            + "classpath:application.properties,"
                            + "file:$home/application.properties,"
                            + "file:$home/secret.properties")
            SpringApplication.run(App::class.java, *args)
        }
    }
}
