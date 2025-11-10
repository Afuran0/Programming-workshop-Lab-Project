README:

Group Members:
Joseph Bally
Amedeo Furano
Daniel Chavez

UML Diagram:


<img width="2053" height="1151" alt="image" src="https://github.com/user-attachments/assets/921b329e-ff37-4f4b-b739-43c1d69ca527" />




- The Main class is used to run the program and create a processor object and input a file path into the processor instance.

- The Processor class then takes that file and calls the FiletoList class to take the file and break it down word by word and add each word as an element in an ArrayList, it also takes the lexicon score file and turns it into a Hashmap with each word being a key and each number being a value.

The Processor Class then takes the ArrayList and removes stopwords
Processor Methods:
- statistics() takes the ArrayList of the article and prints out statistics like workcount, uniquewordcount and wordfrequency
- articleScore() takes a hashmap created from FileToList of the lexicon scores and if a word is in the hashmap it adds the score to the article
- printArticle() and printStopWords() methods were put for testing and they just print out the ArrayList elements of stopwords or the ArrayList elements of the article
- getWordCount(), getUniqueWordCount(), get10Freq(), and get10Words(), are all just getter methods so we can access the values from the ArticleComparison Class

The ArticleComparison Class takes an arrayList of Processor objects which represent each article and uses certain methods to compare each article or list the highest preforming article. Its the class that gets used whenever something needs to be done with multiple articles at once.
ArticleComparison Methods:
- richestVocab() - Prints the article with the most unique words, and how many it had
- repeatedWord() - Prints the top 10 most repeated words for each article
- articleAttitude() - Prints out the attitude score of each article based on their lexicon scores
