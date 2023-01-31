package com.sanskar.theater.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "cloud.aws")
data class AWSCloudProperties(val region: String,
                              val reportSQSUrl: ReportSqsUrl)

data class ReportSqsUrl(val premium: String, val all: String)