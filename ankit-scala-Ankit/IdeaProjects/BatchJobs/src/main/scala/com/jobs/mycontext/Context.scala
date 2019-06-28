package com.jobs.mycontext

import org.apache.spark.sql.SparkSession

trait Context {

  lazy val sc = SparkSession.builder().appName("Jobs").master("local").getOrCreate()
}
