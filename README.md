README:

Group Members:
Joseph Bally
Amedeo Furano
Daniel Chavez

UML Diagram:

<img width="2006" height="1151" alt="image" src="https://github.com/user-attachments/assets/2d626231-650b-41e9-b1cd-aefc35db9201" />




The Main class is used to run the program and manages the uses of all the other classes. It creates and groups Processor objects into topics and ArticleComparison objects and then handles the user's inputs in the UI.

The Processor class then takes that file and calls the FileToList class to get the files converted into collections. The Processor class then takes the ArrayList and removes stopwords and uses the modified list to calculate information on the article.
Processor Methods:
-statistics() takes the ArrayList of the article and creates statistics like word count, unique word count, and word frequency, which can be printed using boolean inputs based on the user's desire.
-articleScore() uses the lexicon HashMap from FileToList, and if a word is in the HashMap, it adds the score to the article.
-printArticle() and printStopWords() methods were put for testing, and they just print out the ArrayList elements of stopwords or the ArrayList elements of the article.
-getWordCount(), getUniqueWordCount(), get10Freq(), and get10Words() are all just getter methods so we can access the values from the ArticleComparison class.

The ArticleComparison class takes an ArrayList of Processor objects which represent each article and uses certain methods to compare each article or list the highest-performing article. It's the class that gets used whenever something needs to be done with multiple articles at once.
ArticleComparison Methods:
-richestVocab() - Prints the article with the most unique words, and how many it had.
-repeatedWord() - Prints the top 10 most repeated words for each article.
-articleAttitude() - Prints out the attitude score of each article based on their lexicon scores.

The FileToList class takes a path for a file and converts it into a collection (either ArrayList or HashMap) and outputs it back to the Processor class.
-readFileToList() - reads a txt file, removes punctuation, splits it into individual words, converts the words to lowercase, and returns it as an ArrayList of strings.
-readFileToHashMap() - reads the lexicon file, removes punctuation, splits it into individual words and a score, converts the words to lowercase, and returns it as a HashMap with strings as the keys and doubles                         as the values.

The FileManager class is responsible for handling files that the user wants to add to the system.
-AddFile() - moves a file from a user-inputted path into the project’s article folder. It also creates the target folder if it does not already exist.


Code Quality - 

All together our code demonstrates relatively high cohesion and low coupling between most Classes. The Processor Class is responsible for the task of managing and processing the data for each input file and only that, so it does have high cohesion. In terms of coupling, besides the FileToList Class, it doesn’t rely heavily on any other Classes to do its job, and still the FileToList Class should be responsible for handling what it does, so it has low coupling. The same holds true for the FileManager and FileToList, they both are responsible for a well-defined task and don’t rely upon any other Classes to be able to do that task, so they both have high cohesion and low coupling. The ArticleComparison Class does rely upon some of the Processor’s public methods, so it isn’t very low coupling, but the task of it is clear and its only task is to compare each Processor object, so it too has high cohesion. The Main Class does have higher coupling and lower cohesion compared to the rest of the Classes, though the tasks are slightly related, it does handle user interaction, creation of collection and files, and also the menu and flow of the menu. This makes it responsible for more than one task and reliant on the other Classes.
Some ways that we could improve upon our structure could be to refactor the Main Class into additional methods and Classes to improve the cohesion of the Class. This could be done by creating something like a Topic Class that is in charge of handling all of the topic and collection logic, and then having the actual Main Class run the user interface. Also, for the Processor Class, the two files that rely on the Processor and built into the code all the time were stop file and lexicon scores; instead of having the FileToList Class convert those every time, creating a dependency on FileToList, we could have added the path into a constructor to help reduce coupling between the Processor Class and FileToList Class. This would help with readability and code duplication, and make it easier to understand when trying to improve upon the code. Lastly, although it doesn’t have to do with refactoring Classes, improving variable naming could make the code easier to follow and understand; there were a lot of variables with similar or even the same names, and a lot of variables with non-descriptive names that could be changed for clarity. Overall, I think that these changes, although not major, would make a big impact on the quality of the code by improving the readability, reducing Class dependencies, and being clearer.

