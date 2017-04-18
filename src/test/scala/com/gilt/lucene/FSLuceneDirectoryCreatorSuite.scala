package com.gilt.lucene

import java.nio.file.{Files, Path}

import org.apache.lucene.store.{MMapDirectory, SimpleFSDirectory}
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{BeforeAndAfter, FunSuite, Matchers}

class FSLuceneDirectoryCreatorSuite extends FunSuite with Matchers with BeforeAndAfter with MockitoSugar {

  var directoryFile: Path = _

  before {
    directoryFile = Files.createTempDirectory("temp")
  }

  /* test("FSLuceneDirectoryCreator should check path nullity") {
     a[NullPointerException] should be thrownBy {
       new FSLuceneDirectoryCreator {
         override protected def directoryConstructor = { file: Path =>
           mock[Directory]
         }
       }.luceneDirectoryFromPath(null)
     }
   }*/

  test("SimpleFSLuceneDirectoryCreator should create a SimpleFSDirectory") {
    val directory = new SimpleFSLuceneDirectoryCreator {
    }.luceneDirectoryFromPath(directoryFile)
    directory should not equal null
    directory.isInstanceOf[SimpleFSDirectory] should equal(true)
  }

  test("MMapFSLuceneDirectoryCreator should create a SimpleFSDirectory") {
    val directory = new MMapFSLuceneDirectoryCreator {
    }.luceneDirectoryFromPath(directoryFile)
    directory should not equal null
    directory.isInstanceOf[MMapDirectory] should equal(true)
  }

}
