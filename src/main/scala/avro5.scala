import org.apache.spark.sql.SparkSession

object avro5 {
  def main(args: Array[String]) = {
    val spark = SparkSession.builder()
      .master("local")
      .appName("Making Avro File")
      .getOrCreate()


    val df = spark.createDataFrame(Seq(
      (2012, 8, "Batman", 9.8),
      (2012, 8, "Hero", 8.7),
      (2012, 7, "Robot", 5.5),
      (2011, 7, "Git", 2.0))
    ).toDF("year", "month", "title", "rating")


    import com.databricks.spark.avro._
    df.write.format("avro").save("/home/amulya/Desktop/ask5.avro")
  }
}
// org.apache.spark.sql.AnalysisException: Failed to find data source: avro. Avro is built-in but external data source module since Spark 2.4. Please deploy the application as per the deployment section of "Apache Avro Data Source Guide".;