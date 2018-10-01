#KPCB Engineering Challenge Design Doc
Sidharth Raguraman - USC '20

**Running the Code**
1) git clone https://github.com/sraguraman/KPCBSupplement
2) Start from KPCBSupplement file
3) cd out/production/KPCBChallenge
4) java com.company.Blackjack

**Primary Language/Design Choices**

I picked the Java language to develop in because of the
ease of user input/output using Scanner. I also have
experience with JavaDoc from internships and class
projects. 

I also picked Java because I have experience writing
JUnit tests. I wrote a single test for the "getValueOfHand"
function because I wanted to make sure the values of 
Aces were calculated correctly. For instance, if 
a hand has a Queen and Jack (both value 10), and gets 
an Ace, the Ace's value should be 1, not 11. 

The biggest design decision I made was how to store 
the associated values of card faces and scores. I picked
a static hashmap for this problem because of its O(1)
time complexity for getting values in Java.

**Thank you!**



