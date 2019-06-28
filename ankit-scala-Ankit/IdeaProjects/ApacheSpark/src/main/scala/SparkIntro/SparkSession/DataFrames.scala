package SparkIntro.SparkSession

import org.apache.spark.sql.{SparkSession, functions}


trait Context{
  //creating spark Session
  lazy val sc = SparkSession.builder().appName("MyApp").master("local").getOrCreate()
}



object DataFrames extends App with Context {

  val dfTags = sc.read.option("header", "true").option("inferSchema", "true").option("dateFormat","MM/dd/yyyy").csv("src/main/scala/SparkIntro/SparkSession/100000 Sales Records.csv").toDF("Region","Country","Item_Type","Sales_Channel","Order_Priority","Order_Date","Order_ID","Ship_Date","Units_Sold","Unit_Price","Unit_Cost","Total_Revenue","Total_Cost","Total_Profit")


  dfTags.printSchema() // prints data-frame schema

  var dfTagsOwn = dfTags.select(dfTags.col("*"))
    /*(
    dfTags.col("Region").cast("string"),
    dfTags.col("Country").cast("string"),
    dfTags.col("Item_Type").cast("string"),
    dfTags.col("Sales_Channel").cast("string"),
    dfTags.col("Order_Priority").cast("string"),
    dfTags.col("Order_Date"),
    dfTags.col("Order_ID").cast("integer"),
    dfTags.col("Ship_Date"),
    dfTags.col("Units_Sold").cast("integer"),
    dfTags.col("Unit_Price").cast("double"),
    dfTags.col("Unit_Cost").cast("double"),
    dfTags.col("Total_Revenue").cast("double"),
    dfTags.col("Total_Cost").cast("double"),
    dfTags.col("Total_Profit").cast("double")
  )*/

  //explicit type-casting
  dfTagsOwn =  dfTagsOwn.withColumn("Ship_Date",functions.to_date(functions.col("Ship_Date"),"MM/dd/yyyy"))
  dfTagsOwn =  dfTagsOwn.withColumn("Order_Date",functions.to_date(functions.col("Order_Date"),"MM/dd/yyyy"))



  dfTagsOwn.printSchema()





  dfTags.show(10)
  dfTagsOwn.show(10)
  dfTags.select("Order_ID", "Units_Sold", "Sales_Channel").show(10)


      //counting
  println(s" Total number of Online sales: ${dfTags.filter("Sales_Channel == 'Online'").count()}")

  //sql like query
  dfTags.select("Country","Item_Type","Sales_Channel").filter("Item_Type like 'C%'").show(10)

  //multiple filter chaining
  dfTags.filter("Sales_Channel  == 'Online'").filter("Item_Type == 'Fruits'").filter("Total_Profit > 5000").show(10)

  //sql IN clause
  dfTags.filter("Order_ID in (121384179, 772153747)").show(10)

  //sql between clause
  dfTags.filter("Order_ID between 121384179 and 121384500").show(10)


  //sql groupBY() query
  dfTags.groupBy("Country").count().show(10)

//sql groupBy() with filter
  dfTags.groupBy("Country").count().filter("count > 550").show(10)


  //sql orderBy() query for sorting
  dfTags.groupBy("Country").count().filter("count > 550").orderBy("Country").show(10)


 // dfTagSubset.join(dfTags, "Order_ID").select("Region", "Country").show(10)
}
