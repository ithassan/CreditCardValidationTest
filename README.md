# CreditCardValidationTest
BST Test
i am using MVC deisghn pattern.
CardController -> comnuicate model and view and validate it.
CardModel -> Bussiness Logic & Data.
View ->PayFragments.
Live data -> JetPack library for oberve data on UI
Hilt -> using for Dependncy injection
Singletion Pattern -> PatternUtil
Navigation ->  jetPack library fro navigation
com.intuit.sdp:sdp : library for handle diffrent size according to screen.
view give data to controller and controller send data to model and after validating the data controller take the data and send to view in digit response.
Explanation 
MVC
I am using MVC design pattern in Card Validation Test.
It is model View Controller
Model: Model mange the data and hold the business logic
Controller: which control task user performs it and create attraction between model and view.
View: It’s UI Design.
Controller takes the data from view give to model and validate it give back to view.
For attraction I am using live data library of jetpack. This is easily to use and remove bipolar code.
Delegation
Static relationship between classes and inheritance. In Kotlin we achieve delegation pattern using by keyword.
Some delegations provide by Kotlin standard library are:
Lazy: it initialize when needed
Observable: using when observe the data is change.
UI and Navigation
Your app's user interface is everything that the user can see and interact with. Android provides a variety of pre-built UI components such as structured layout objects and UI controls that allow you to build the graphical user interface for your app
Navigation I am using the jetpack library navigation.
Json Parsing and fetching
JSON is an open standard file format and data interchange format that uses human-readable text to store and transmit data objects consisting of attribute–value pairs and arrays.
We can use JSONarry and JSONObject.
In retrofit library we just use data to class in volley we use JSONArry and JSONObject.

Git is distributed version control system every one have copy of repo. 
Git is software for tracking changes in any set of files, usually used for coordinating work among programmers collaboratively developing source code during software development. Its goals include speed, data integrity, and support for distributed, non-linear workflows
We can create multiple branches and it is good when you working in team and individually.
We can make branches according to our feature in project.

