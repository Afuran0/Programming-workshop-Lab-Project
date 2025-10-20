README:

Group Members:
Joseph Bally
Amedeo Furano
Daniel Chavez




+--------------------+
|      Main          |
+--------------------+
|                    |
+--------------------+
| + main(args: String[]) |
+--------------------+
          |
          v
+--------------------+
|    Processor       |
+--------------------+
| - article: ArrayList<String> |
| - stopwords: ArrayList<String> |
| - STOPFILENAME: String        |
| - file: String                |
+--------------------+
| + Processor(file: String)    |
| - statistics(wordsInArticle: ArrayList<String>) |
| + printArticle()             |
| + printStopWords()           |
+--------------------+
          |
          v
+--------------------+
|    FileToList      |
+--------------------+
|                    |
+--------------------+
| + readFileToList(path: String): ArrayList<String> |
+--------------------+

+--------------------+
|  WordFrequency     |
+--------------------+
| - words: ArrayList<String>       |
| - frequencyMap: HashMap<String,Integer> |
+--------------------+
| + WordFrequency(words: ArrayList<String>) |
| - calculateFrequencies()                  |
| + getRankedWords(): List<Map.Entry<String,Integer>> |
| + printTopWords(n: int)                  |
+--------------------+
