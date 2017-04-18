package com.gilt.lucene

import java.io.File
import java.nio.file.Path
import javax.annotation.Nonnull

import com.google.common.base.Preconditions
import org.apache.lucene.store.{Directory, MMapDirectory, SimpleFSDirectory}


/**
 * Base trait that creates a Lucene filesystem Directory from a root path
 */
trait FSLuceneDirectoryCreator {
  protected def directoryConstructor: Path => Directory

  @Nonnull
  def luceneDirectoryFromPath(@Nonnull path: Path): Directory = {
    Preconditions.checkNotNull(path)
    directoryConstructor(path)
  }

}

/**
 * An FSLuceneDirectoryCreator that creates a SimpleFSDirectory
 */
trait SimpleFSLuceneDirectoryCreator extends FSLuceneDirectoryCreator {
  override protected def directoryConstructor = new SimpleFSDirectory(_)
}

/**
 * An FSLuceneDirectoryCreator that creates an MMapDirectory
 */
trait MMapFSLuceneDirectoryCreator extends FSLuceneDirectoryCreator {
  override protected def directoryConstructor = new MMapDirectory(_)
}