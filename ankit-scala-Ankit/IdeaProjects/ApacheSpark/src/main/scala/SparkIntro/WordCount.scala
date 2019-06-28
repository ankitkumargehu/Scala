package SparkIntro
import org.apache.spark.sql
import org.apache.spark.sql.SparkSession




object WordCount extends App  {

    val sc = SparkSession.builder.appName("Counting words in File").master("local").getOrCreate() // creating spark Session
    var textFile = sc.read.textFile("/home/ankit/IdeaProjects/ApacheSpark/src/main/scala/SparkIntro/sample.txt").rdd // reading existing file.
    textFile.foreach(println) // printing the content of the file.
  textFile.saveAsTextFile("/home/ankit/IdeaProjects/ApacheSpark/src/main/scala/SparkIntro/output/")
  /*
  OUTPUT:
  hello world
  xenonstack a stack innovator
  Ankit Sharma
  Developer in Scala
  Implementing Apache Spark
  Lets' do it
  Completed the task
  Ankit
  Ankit Kumar
*/

    val mapFile = textFile.map(line=> (line, line.length)) // map function for counting character of each line
    mapFile.foreach(println) // printing number of character at each line present in the inputted file.
    /*
    OUTPUT:
    (hello world,11)
    (xenonstack a stack innovator,28)
    (Ankit Sharma,12)
    (Developer in Scala,18)
    (Implementing Apache Spark,25)
    (Lets' do it,11)
    (Completed the task,18)
    (Ankit,5)
    (Ankit Kumar,11)
    */

  //flatMap
  val flatmap = textFile.flatMap(lines => lines.split(" "))
  flatmap.foreach(println)
  /*
  OUTPUT:
    hello
    world
    xenonstack
    a
    stack
    innovator
    Ankit
    Sharma
    Developer
    in
    Scala
    Implementing
    Apache
    Spark
    Lets'
    do
    it
    Completed
    the
    task
    Ankit
    Ankit
    Kumar
    */
    
  var pattern = flatmap.filter(value => value=="Ankit")
  pattern.foreach(println)
  /*
  OUTPUT:
  Ankit
  Ankit
  Ankit
  */
  
  println("No of times pattern found", pattern.count()) //(No of times pattern found,3)

  //val upper = textFile.map(line =>  line.toUpperCase())
  // val lower = textFile.map(line=> line.toLowerCase())
  //upper.foreach(println)
  //lower.foreach(println)

  val upperLOWER = textFile.map(line => (line.toUpperCase, line.toLowerCase)) // converting the content of file into lower and upper case.
  upperLOWER.foreach(println)
  /*
  Output:
    (HELLO WORLD,hello world)
    (XENONSTACK A STACK INNOVATOR,xenonstack a stack innovator)
    (ANKIT SHARMA,ankit sharma)
    (DEVELOPER IN SCALA,developer in scala)
    (IMPLEMENTING APACHE SPARK,implementing apache spark)
    (LETS' DO IT,lets' do it)
    (COMPLETED THE TASK,completed the task)
    (ANKIT,ankit)
    (ANKIT KUMAR,ankit kumar)
*/

  //working of sortByKey function
  val sequence = sc.sparkContext.parallelize(Seq(("maths",52),("english",75),("science",82), ("computer",65),("maths",85))) // creating  a sequence with key and value.
  val sorted = sequence.sortByKey().foreach(println) // sorting and printing
  /*
  OUTPUT:
  (computer,65)
  (english,75)
  (maths,52)
  (maths,85)
  (science,82)

*/

  //working of parallelize function
  val  rdd = sc.sparkContext.parallelize(Array("jan","feb","mar","april","may","jun"),3) //number of slices of Array
  val result = rdd.coalesce(3) // partitioning the array to run parallel
  result.foreach(println)
  /*
  OUTPUT:
    jan
    feb

    mar
    april

    may
    jun
*/

  //working of sortBy function
  val words=sc.sparkContext.parallelize(Seq("the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"))
  val wordPair = words.map(w => (w.charAt(0), w)).sortBy(name=> name)
  wordPair.foreach(println)
  /*
  Output:
  (b,brown)
  (d,dog)
  (f,fox)
  (j,jumps)
  (l,lazy)
  (o,over)
  (q,quick)
  (t,the)
  (t,the)
  */



  //union function
  val rdd1 = sc.sparkContext.parallelize(Seq((5,"dec",2014),(5,"dec",2014),(1,"jan",2016),(3,"nov",2014),(16,"feb",2014)))

  val rdd2 = sc.sparkContext.parallelize(Seq((5,"dec",2014),(17,"sep",2015)))
  val rdd3 = sc.sparkContext.parallelize(Seq((6,"dec",2011),(16,"may",2015)))

  val union = rdd1.union(rdd2).union(rdd3)
  union.foreach(println)
  /*
  Output:
    (5,dec,2014)
  (5,dec,2014)
  (1,jan,2016)
  (3,nov,2014)
  (16,feb,2014)

  (5,dec,2014)
  (17,sep,2015)

  (6,dec,2011)
  (16,may,2015)
*/


  //intersection function as to get common elements.
  val common = rdd1.intersection(rdd2)
  common.foreach(println) // (5,dec,2014)

  //distinct function removes duplicate data
  val res = rdd1.distinct()
  println(res.collect().mkString(", ")) // (5,dec,2014), (3,nov,2014), (16,feb,2014), (1,jan,2016)

  //join function joins two different RDDs on the basis of key
  val j1 = sc.sparkContext.parallelize(Array(('A',1),('b',2),('c',3)))
  val j2 =sc.sparkContext.parallelize(Array(('A',4),('A',6),('b',7),('c',3),('c',8)))
  val resultJ = j1.join(j2)
  println(resultJ.collect().mkString(",")) // (b,(2,7)),(A,(1,4)),(A,(1,6)),(c,(3,3)),(c,(3,8))
}


