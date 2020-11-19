package com.github.abdvel

import com.aliyun.openservices.log.Client
import com.aliyun.openservices.log.common.LogItem
import com.aliyun.openservices.log.response.PutLogsResponse
import com.github.abdvel.model.`type`.LogLevel
import com.github.abdvel.model.config.Config
import com.github.abdvel.util.DateTimeUtil.now

import scala.concurrent.{ExecutionContext, Future}

class LogIO(config: Config)(implicit ec: ExecutionContext) {
  val client = new Client(config.host, config.accessId, config.accessKey)

  def info(traceId: String, logs: Map[String, String]): Future[PutLogsResponse] = {
    val logGroup: java.util.ArrayList[LogItem] = new java.util.ArrayList[LogItem]
    val logItem                                = new LogItem(now.toInt)

    logItem.PushBack("traceId", traceId)
    logItem.PushBack("logLevel", LogLevel.Info.toString)
    logs.foreach { case (key, value) => logItem.PushBack(key, value) }
    logGroup.add(logItem)

    Future(client.PutLogs(config.project, config.logStore, config.topic, logGroup, ""))
  }

  def error(traceId: String, logs: Map[String, String]): Future[PutLogsResponse] = {
    val logGroup: java.util.ArrayList[LogItem] = new java.util.ArrayList[LogItem]
    val logItem                                = new LogItem(now.toInt)

    logItem.PushBack("traceId", traceId)
    logItem.PushBack("logLevel", LogLevel.Error.toString)
    logs.foreach { case (key, value) => logItem.PushBack(key, value) }
    logGroup.add(logItem)

    Future(client.PutLogs(config.project, config.logStore, config.topic, logGroup, ""))
  }
}
