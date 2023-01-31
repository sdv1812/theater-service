package com.sanskar.theater.reporting

import aws.sdk.kotlin.services.sqs.SqsClient
import aws.sdk.kotlin.services.sqs.model.SendMessageRequest
import kotlinx.coroutines.runBlocking
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/reports")
class ReportsController {

    @RequestMapping("/generateReport/{report}")
    fun getReport(@PathVariable("report") report: String): ResponseEntity<String> {
        val (queueUrl, reportType) = when (report) {
            "all_bookings" -> listOf("theater-report-all-bookings-dev", "all_bookings")
            "premium_bookings" -> listOf("theater-report-premium-bookings-dev", "premium_bookings")
            else -> listOf("", "")
        }

        runBlocking {
            sendMessages(queueUrl, reportType)
        }
        return ResponseEntity.ok("Message sent")
    }

    suspend fun sendMessages(queueUrl: String, message: String) {
        println("Sending multiple messages to $queueUrl")
        println("\nSend message")
        val sendRequest = SendMessageRequest {
            this.queueUrl = queueUrl
            messageBody = message
            delaySeconds = 10
        }

        SqsClient { region = "ap-southeast-2" }.use { sqsClient ->
            sqsClient.sendMessage(sendRequest)
            println("A single message was successfully sent.")
        }
    }

}