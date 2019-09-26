package prod.GiveMeaWord

import org.junit.Test
import java.io.*


class ReformatWordsFile {

    val readFile = ""
    val writeFile = ""

    fun refToCorrectSyntax(){
        val stream: InputStream = File(readFile).inputStream()
        val outStream: BufferedWriter = File(writeFile).bufferedWriter()
        stream.bufferedReader().forEachLine {
            outStream.write(it.toLowerCase().capitalize())
            outStream.newLine()
        }
        outStream.close()
    }
}