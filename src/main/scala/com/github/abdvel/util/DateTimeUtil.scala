package com.github.abdvel.util

object DateTimeUtil {
  def now: Long         = System.currentTimeMillis() / 1000L
  def nowInMillis: Long = System.currentTimeMillis()
}
