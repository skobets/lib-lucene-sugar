package com.gilt.lucene

import java.nio.file.{Files, Path, Paths}
import javax.annotation.Nonnull

/**
 * Base trait that provides a path to an FSLuceneDirectory
 */
trait LuceneIndexPathProvider {
  /**
   * Provides the index directory path to the function f
   */
  protected def withIndexPath[T](f: (Path) => T): T
}

/**
 * A LuceneIndexPathProvider that provides a directory path that is the
 * `index` sub-folder relative to the root of the service.
 * The sub-folder is created if it doesn't exist already.
 */
trait ServiceRootLucenePathProvider extends LuceneIndexPathProvider {
  private lazy val INDEX_DIRECTORY = "index"
  private lazy val serviceRootPath = System.getProperty("user.dir")
  private lazy val indexPath = Paths.get(serviceRootPath, INDEX_DIRECTORY)

  @Nonnull
  protected def withIndexPath[T](@Nonnull f: (Path) => T): T = {
    Files.createDirectories(indexPath)
    f(indexPath)
  }

}