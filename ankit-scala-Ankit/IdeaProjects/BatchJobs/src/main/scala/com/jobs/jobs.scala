package com.jobs
import com.jobs.mycontext.Context



object jobs extends App with Context{

  val file1 = sc.read.option("header", "true").option("inferSchema", "true").csv("/home/ankit/IdeaProjects/BatchJobs/src/main/scala/com/jobs/csvfiles/acc.csv")
  val file2 = sc.read.option("header", "true").option("inferSchema", "true").csv("/home/ankit/IdeaProjects/BatchJobs/src/main/scala/com/jobs/csvfiles/accInfo.csv")


  file1.printSchema()
  file2.printSchema()

  file1.show(10)
  file2.show(10)

  val joinCsv = file1.join(file2, file1("acc_id").equalTo(file2("info_id")), "inner").selectExpr("acc_id","name","salary","dept_id","phone","address","email")

  joinCsv.printSchema()

  joinCsv.show(10)
}