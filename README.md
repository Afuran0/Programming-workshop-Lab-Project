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

- The Main class is used to run the program and create a pocessor object and input a file path into the processor instance.
- The Processor class then takes that file and calls the FiletoList class to take the file and break it down word by word and add each word as an element in an ArrayList
- The Processor class then takes the ArrayList and removes stopwords
- statistics() in the processor class takes the ArrayList of the article and prints out statistics like workcount, uniquewordcount and wordfrequency
- the printArticle() and printStopWords() methods were put for testing and they just print out the ArrayList elements of stopwords or the ArrayList elements of the article
- The wordFrequency class was our original class used to calculate word frquency but we found it to be easier and simplier to make it a method in the Processor class
