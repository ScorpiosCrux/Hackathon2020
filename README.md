# Hackathon2020
#### How To Run

<strong>Client-side:</strong><br/>
Description: User interface for inputing major, concentration and courses taken. We planned to bundle the information into encrypted JWT being sent to a middleware. That object will be uncrypted and be used for analysis then a resultant object will be sent back to the user to display all analytical data.
```java
javac *.java
java DegreeNavigatorParentWindow
```

<strong>Server-side:</strong> <br/>
Description: To update job relevancy in the current market. The `obtain.go` acts as an information gathering device that in theory (ie. if we have more time to upgrade) would be websocket real time updates of jobs in the market. `compute.go` acts as the computing machinery behind the structure to calulate and analyze statistics for the information gathered. We used a `.txt` file to act as the database. Our theory in mind is of microservices communications. We prosed that the microservices will communicate with one another via encrypted JWT.
- Install Golang
- `go get https://github.com/gocolly/colly`
- `go get -d ./...`
- `cd` into `~/Download/Hackathon2020/PseudoCloud`
- `go build compute.go`
- `go build obtain.go`
- `./obtain`

#### At A Glance
The purpose of this program is to take in the courses someone has taken and give back a list of recommended courses to look out for with recommendation of languages and technogoly stack to learn in advance to prepare for the constantly innovating job market.

#### What does this do for students at the university?
Class registration is, without a doubt, one of the most important aspects in ensuring that your
university experience goes as swimmingly as possible. Unfortunately, many students face the issue of having 
too much choice in their classes, and it's quite easy to get lost in the options.
The degree navigator is meant to make the registration process easier for students who suffer 
from this issue or simply wish to reaffirm
if their choices are in line with the program or not.
It's true that advisors can provide much of the same information, but advisors also take longer to respond
and they aren't as accessible. This program attempts to remedy that.

#### Behind the GUI
The program takes in an input and sorts out the courses that the person can take.
Upon spitting the list of classes back out, the selected courses will be chosen in a way such that a course
will have the most priority if it is required by
a degree, and then a concentration (if chosen). 
After these priorities are sorted, the navigator will even give preferential treatment to classes that occur
more often as a prerequisite, so that students have more options when it comes to upper years.
The program checks the input that the user has,
and then determines what courses the user has the prerequisite for
while determining the classes that the user has taken by extension 
(if they click the box for a course but don't click the prerequisite for that course, this is covered.) 

#### The Client's Perspective
The program offers a simple to use, easy to follow GUI which is incredibly user friendly, 
unsusceptible to answers designed to break the program, and pleasing to the eye. It ensures that
choosing your classes is an accessible, easy aspect of your academic career so that you don't feel
overwhelmed by choices.

#### The Future
This is more of a proof of concept than anything; Development of this revamped degree navigator
would expand to include every major, class and concentration, while ideally being promoted enough that
students have no trouble finding it. The degree navigator would also expand to not only prioritize the
classes that occur most often as prerequisites, but it would also combine this with classes in the concentration
of choice so that classes which are in the concentration and are also "unlocked", so to speak, by any given class.
