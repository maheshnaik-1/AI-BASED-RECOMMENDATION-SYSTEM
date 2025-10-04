# AI-BASED-RECOMMENDATION-SYSTEM

*COMPANY*: CODTECH IT SOLUTIONS

*NAME*: SUGALI MAHESH NAIK

*INTERN ID*: CT04DY1974

*DOMAIN*: JAVA PROGRAMMING

*DURATION*: 4 WEEKS

*MENTOR*: NEELA SANTOSH

# Description of the Task:

I created an AI-Based Recommendation System using Java to understand how artificial intelligence can predict user preferences and suggest relevant items. The main goal of this task was to explore how recommendation systems work in real-world platforms such as Netflix, Amazon, and Spotify, where they help personalize the user experience.

The system's concept is straightforward but effective.  After comparing user ratings for various items, it makes predictions about what each user might like next.  Collaborative filtering is the term for this technique, which bases recommendations on how similar two users' interests are.  The application can suggest new products that the user hasn't rated yet but is probably going to like by looking at these similarities.

The number of users and items is the first thing the system asks for.  After that, it gathers user ratings, allowing a 0 to indicate an item that has not been rated.  It uses the Cosine Similarity formula to determine how similar users are to one another after compiling all ratings.  By treating user ratings as vectors in a multidimensional space, this formula calculates the degree to which two sets of preferences align.

The software predicts scores for items the target user hasn't rated yet using the similarities that have been computed.  After that, it shows the best suggestions after sorting these items according to their anticipated scores.  The likelihood that the user will favor that item increases with the predicted score.

I gained a better understanding of the inner workings of actual recommendation models by building this system.  It demonstrated to me how logic, data, and mathematics combine to create an intelligent system that gains knowledge from users and enhances the personalization experience.  I gained a greater understanding of how artificial intelligence can be used in useful and effective ways with basic programming concepts after writing the entire code by myself.

# Tools I've Used:

For this task, I mainly used:

Programming Language: Java (JDK 24)

Algorithm Used: Collaborative Filtering using Cosine Similarity

Concept is Based On: Apache Mahout’s Recommendation Engine

Used resources like GOOGLE, QUICKREF, YOUTUBE AND CHATGPT for quick reference and to know some info, they helped me complete tasks efficiently.

# Editor and Compiler Platforms Used:

I used the OnlineGDB and JDoodle platforms to compile and execute the Java program online.

Additionally, I tested the same code on VS Code (Visual Studio Code) and IntelliJ IDEA in my local system using JDK.

Because of Java's robust object-oriented structure and platform independence, which enable code portability across various environments, I went with it.  Because it works better with smaller datasets and makes insightful recommendations even when user ratings barely overlap, the cosine similarity algorithm was selected over Pearson correlation.

# How the Program Works:

The user is asked for the number of users and items when the program first launches.  After that, I made it so that it can take ratings from users for every user-item combination.  A user can enter 0 if they haven't rated anything.  After that, the application saves each rating in a HashMap structure, which serves as the dataset.

After entering the data, the user chooses which User ID should be used to generate recommendations and how many recommendations should be shown.  Using the cosine similarity formula, the program determines similarity scores between the chosen user and every other user.

By treating two users' ratings as vectors and calculating the cosine of the angle between them, cosine similarity calculates how similar two users' preferences are.  The users are more similar if the cosine value is higher (nearer to 1).

The application determines predicted scores for all items that the target user has not yet rated using a weighted sum method after identifying similarities.  Lastly, it shows the top suggestions along with the matching predicted preference values after sorting these items according to their predicted scores.

This method is very similar to the backend operations of popular AI-based recommendation systems like Netflix, Amazon, and Spotify, which examine user behavior, identify users who are similar to each other, and forecast what each user might enjoy next.

# Applications:

This program can be applied in a wide range of real-world applications such as:

E-commerce platforms: To recommend products to customers based on purchase or viewing history.

Online learning platforms: To suggest new courses or tutorials to students based on what similar learners have taken.

Streaming services: To recommend movies, music, or shows similar to the ones users have already enjoyed.

Content websites: To personalize news feeds or article suggestions according to user interests.

In short, this AI-based system improves user engagement, personalization, and satisfaction by providing intelligent suggestions.

# Output:

=== AI-Based Recommendation System ===

Enter number of users: 3

Enter number of items: 4

Enter ratings (enter 0 if user hasn't rated the item):

User 1, Item 1 rating: 4

User 1, Item 2 rating: 3

User 1, Item 3 rating: 0

User 1, Item 4 rating: 0

User 2, Item 1 rating: 5

User 2, Item 2 rating: 0

User 2, Item 3 rating: 4

User 2, Item 4 rating: 0

User 3, Item 1 rating: 0

User 3, Item 2 rating: 4

User 3, Item 3 rating: 5

User 3, Item 4 rating: 4

Enter the user ID to recommend for (1-3): 1

Enter number of recommendations to display: 2

--- Recommendations for User 1 ---

Item 3 | Predicted Score: 4.34

Item 4 | Predicted Score: 1.35

![Image](https://github.com/user-attachments/assets/b8b940c1-3447-4744-913b-516b2218065b)
