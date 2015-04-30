package model.article

// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = scala.slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: scala.slick.driver.JdbcProfile
  import profile.simple._
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import scala.slick.jdbc.{GetResult => GR}
  
  /** DDL for all tables. Call .create to execute. */
  lazy val ddl = Article.ddl
  
  /** Entity class storing rows of table Article
   *  @param id Database column id DBType(INT), AutoInc, PrimaryKey
   *  @param title Database column title DBType(VARCHAR), Length(30,true), Default(None)
   *  @param body Database column body DBType(TEXT), Length(65535,true), Default(None) */
  case class ArticleRow(id: Int, title: Option[String] = None, body: Option[String] = None)
  /** GetResult implicit for fetching ArticleRow objects using plain SQL queries */
  implicit def GetResultArticleRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[ArticleRow] = GR{
    prs => import prs._
    ArticleRow.tupled((<<[Int], <<?[String], <<?[String]))
  }
  /** Table description of table article. Objects of this class serve as prototypes for rows in queries. */
  class Article(_tableTag: Tag) extends Table[ArticleRow](_tableTag, "article") {
    def * = (id, title, body) <> (ArticleRow.tupled, ArticleRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, title, body).shaped.<>({r=>import r._; _1.map(_=> ArticleRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id DBType(INT), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column title DBType(VARCHAR), Length(30,true), Default(None) */
    val title: Column[Option[String]] = column[Option[String]]("title", O.Length(30,varying=true), O.Default(None))
    /** Database column body DBType(TEXT), Length(65535,true), Default(None) */
    val body: Column[Option[String]] = column[Option[String]]("body", O.Length(65535,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Article */
  lazy val Article = new TableQuery(tag => new Article(tag))
}