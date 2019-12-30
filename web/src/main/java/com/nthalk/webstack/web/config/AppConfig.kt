package com.nthalk.webstack.web.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean

@ConfigurationProperties(prefix = "app")
class AppConfig {
    @Bean
    fun home(): String {
        return System.getProperty("home", "./home")
    }

    data class ClusterNode(
            val id: String? = null,
            val host: String? = null,
            val port: Int = 5679
    )
}
