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
I am using MVC design pattern. In this view takes data and send it to  controller. Controller attract with model and validate the data and send response to view. On view side I am using Live data library to observe data change in controller which observer belong to control data change in ui according to data.
For navigation component I am using jetpack library navigation and also singleton pattern so only once time object can be initialize. Also using hilt library for dependency injection as dagger and manual need write to much code.
For Card validate by luhn and use  regex to check card type.
I am using A regular expression is a sequence of characters that specifies a search pattern in text to validate data.
For CVV just shoe the error and reference of info in bottom sheet.
For expiry date u can use three format like 12/12/2021, 12-12-2021, 12.12.2021.
