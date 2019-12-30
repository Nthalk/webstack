package com.nthalk.workflow.db

import org.docopt.Docopt
import org.flywaydb.core.Flyway
import org.flywaydb.core.api.configuration.FluentConfiguration
import java.io.IOException
import java.util.*
import javax.sql.DataSource

object DbCli {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val docopt = Docopt("""
            Db Cli

            Usage:
              dbcli migrate [--jdbcurl=<jdbcurl>] [--user=<user>] [--pass=<pass>]
              dbcli -h | --help
              dbcli --version

            Options:
              -j --jdbcurl=<jdbcurl>  Database to use [default: jdbc:postgresql://localhost:5432/webstack].
              -u --user=<user>        Username [default: webstack].
              -p --pass=<pass>        Password [default: webstack].
              -h --help               Show this screen.
              --version               Show version.
        """.trimIndent())
        docopt.withHelp(true)
        val build = Properties()
        build.load(DbCli::class.java.classLoader.getResourceAsStream("build.properties"))
        docopt.withVersion(build.getProperty("build.version"))
        val opts = docopt.parse(*args)
        if ((opts["migrate"] as Boolean?)!!) {
            migrate(
                    opts["--jdbcurl"].toString(),
                    opts["--user"].toString(),
                    opts["--pass"].toString())
        }
    }

    fun migrate(jdbcurl: String?, user: String?, password: String?) {
        val flyway = Flyway(
                FluentConfiguration()
                        .dataSource(jdbcurl, user, password)
                        .locations("classpath:/db"))
        migrate(flyway)
    }

    fun migrate(dataSource: DataSource?) {
        val flyway = Flyway(FluentConfiguration().dataSource(dataSource).locations("classpath:/db"))
        migrate(flyway)
    }

    private fun migrate(flyway: Flyway) {
        print("Migrating database... ")
        flyway.migrate()
        println("Migrated.")
    }
}
