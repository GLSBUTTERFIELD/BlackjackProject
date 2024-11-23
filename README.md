# BlackjackProject

# Overview
This program models a single player, one deck Blackjack game. The Aces are hard-coded to 11 but if a hand containing an Ace will go over 21, the Ace will be refactored to a value of 1. There are no splits, double downs, or other variations baked in. 

When the user enters into the game they are dealt a round of cards by the dealer. The player can see both of their cards and total value and one of the dealer cards; the other dealer card remains hidden from the player. The game unfolds in different directions based on player choice and the dealer's cards: <ol><li>If the player has blackjack (21 on the first deal), the dealer's turn begins.</li><li>If they player does not have blackjack, they can choose to hit (add another card to their hand) until they choose to stay (stand) or if their total exceeds 21 (they bust).</li><li>The dealer's turn begins once the player stays. If the dealer's hand value is less than 17, they must hit until they reach 17 or more.</li><li>If the dealer's hand value is between 17 and 21, it is compared against the player's hand value to determine who wins.</li><li>If the player and dealer both have blackjack, both bust, or have the same hand value, they push (tie).</li></ol>

The player may choose to play another game at which time the loop will begin again. When there are 17 or less cards remaining in the deck, the current hand finishes and the dealer clears and reshuffles, starting again with a fresh deck.

# Technologies & Concepts Used
<li>Java</li><ul>
	<li>enums</li>
	<li>abstract classes & methods</li>
	<li>polymorphism & overrides</li>
	<li>inheritance</li>
	<li>encapsulation & getters</li>
	<li>naming methods by their behaviors</li>
	<li>lists & arraylists</li>
	<li>exceptions & try/catch blocks</li>
	<li>calling methods from different classes</li>
	<li>iterating over arrays with for & for each loops</li>
	<li>if/else statements</li>
	<li>while loops</li></ul>
<li>Eclipse</li><ul>
	<li>keyboard shortcuts</li>
	<li>source menu commands</li></ul>
<li>Object oriented design</li><ul>
	<li>UML diagrams</li></ul>
<li>Sublime</li>
<li>Git/GitHub</li>
<li>Unix CommandLine</li>
<li>MacOS Terminal</li>
</ul>

# Lessons Learned
#### 11/23/24 Updates:
I updated my program to account for the soft and hard Ace values and also moved all of the game logic out of the player and dealer turns and into the checkWinner(). I kept the Ace hard-coded to 11 but added conditional statements in the getHandValue() to count up the amount of Aces in hand and then minus 10 when the hand value exceeds 21 (making the Ace a "soft Ace"). I added hasAce() to both the BlackjackHand and Dealer classes, since the dealer must hit when they have 17 and an Ace. My first pass at adding logic into the getHandValue() had a nested If statement, which meant the Ace never became "soft" unless the hand contained two Aces. Anthony helped me use the Debugger and we went line by line to uncover that the second If statement should be contained in the For loop but separate from the first If statement and from there, the code worked!

#### Overall:
This program was definitely an exercise in OOP - from designing the different classes and methods, following the inherited methods and fields, and uncoupling things from each other to create more streamlined classes and methods. Setting up the Card and Deck classes together helped because it gave me a starting place to build from. The pattern of creating multiple classes without main methods and only one where everything happens is becoming more familiar and helps reinforce the concept of OOP where everything has one function each. 

After coding the NBA Lottery project with Leslie this week, I felt like everything I knew had gone out the window and I was feeling down. When I'm coding by myself, things seem to flow more naturally but I found myself doubting everything and feeling like I couldn't articulate what I wanted to say with my partner. This project helped build my confidence back up a little but I am still feeling shaky about my skills and coding knowledge. I'm worried that I'm just good at recognizing patterns and translating that into my code, but each week I gain more experience which helps solidify these concepts in my brain.

#### Challenges:
At first I did not understand the isBust and isBlackjack methods - I was using them to determine the value of the hand and printing out statements like "Player bust," but the return values weren't being used anywhere. Anthony helped me reconceptualize how they needed to be used - returning a boolean - which made so much more sense. Now they are being used in the BlackjackApp class to determine who wins each round in the checkWinner method.

Differentiating between blackjack and 21 was challenging because to the computer, the values were both 21. At first I relied on the order of the methods but found that when the player hit 21, the dealer wasn't given the chance to also hit 21. Adding another conditional where the size of the hand was only 2 helped differentiate between the two.

The hardest thing about this project was figuring out how everything went together and trying to keep my code DRY. The program ran smoothly the first few games, but then I would try to stay and the dealer dealt me another card. I had methods calling other methods but they were never popping off the stack and causing internal confusion to the point where I couldn't figure out where the code was leading or coming from. I also had multiple methods calling the same method, making it difficult to figure out where they were coming from and how to unwind them. Creating more methods with only one function helped me unravel my "spaghetti code" and piece things together in a more comprehensive and less confusing way but it took a lot of time and trial and error to figure out the flow of the program. Thinking about the actual actions and relationships of a blackjack game did help but also made it difficult since each class and method had to have a specific function.

Toward the end I created a getHand method in the Player class and changed a bunch of code in my BlackjackApp class, and then realized that we were explicitly told not to have a getHand method, so I had to go and changes things back to how they were before. That was frustrating because I thought I was simplifying things but instead I ended up causing more work for myself.

#### Successes:
I am proud that I was got my program to work and I like the formatting of the output of my code to the user. I think it is readable and emulates how a real Blackjack game is played. I stayed a few hours after class ended Friday night and got most of my code to work, and then used office hours Saturday and more time Sunday to review, rework, rearrange, and refine my code.

Being familiar with Blackjack and the inner workings of the game helped me decide which fields, methods, and functions should exist in each class and how they should work together. It also helped with naming my methods so they made more sense - like a Player HAS-A blackjack, while a blackjack hand can be/IS-A blackjack, and the Dealer class contains the dealCards and shuffleCards methods but are only used when they are called by the BlackjackApp class.

I like that the loop I built allowing the user to continue playing is working and that I added a try/catch block in the playAgain method for user input errors. I didn't attempt the stretch goal of having soft or hard values for Aces, but I was able to build in isBlackjack method in the Player class as well as a shouldReshuffle method in the Dealer class that when called in the BlackjackApp class, resets the deck in between rounds once 1/3 of the deck is left. I am proud of the level of detail in my README and I enjoyed playing and having others test out my code.