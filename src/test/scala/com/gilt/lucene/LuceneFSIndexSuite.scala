package com.gilt.lucene

import java.nio.file.{Files, Path}

import org.scalatest.FlatSpec

class LuceneFSIndexSuite extends FlatSpec with LuceneIndexBehaviors {

  def fsIndex = {
    val directoryPath = Files.createTempDirectory("tmp")
    new ReadableLuceneIndex with WritableLuceneIndex with LuceneStandardAnalyzer with FSLuceneDirectory with SimpleFSLuceneDirectoryCreator with LuceneIndexPathProvider {
      protected def withIndexPath[T](f: (Path) => T): T = f(directoryPath)
    }
  }

  it should behave like emptyIndex(fsIndex)
  it should behave like writableIndex(fsIndex)
  it should behave like searchableIndex(fsIndex)

}
