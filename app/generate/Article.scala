package generate

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.codegen.SourceCodeGenerator

/**
 * Created by nobesawa on 15/05/01.
 */
object Article {

  def generate = {
    val slickDriver = "scala.slick.driver.MySQLDriver"
    val jdbcDriver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost/keijiban"
    val outputFolder = "app/model"
    val pkg = "model"
    val user = "root"
    val password = ""
    SourceCodeGenerator.main(
      Array(slickDriver, jdbcDriver, url, outputFolder, pkg, user, password)
    )

  }

}
