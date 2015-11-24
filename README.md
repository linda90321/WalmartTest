# WalmartTest

### Description 
Automate an end-to-end user e-commerce transaction flow using any open source tool for www.walmart.com with an existing customer on Chrome or Safari browser.

Scenario to automate:
-  1. Login using existing account
-  2. Perform a search on home page from a pool of key words given below
-  3. Identify an item from the result set that you can add to cart
-  4. Add the item to cart
-  5. Validate that item added is present in the cart and is the only item in the cart

Test Data:
-  1.Account: nali.nyupoly@gmail.com 
     Password: lina19880809
-  2. Search terms: tv, socks, dvd, toys, iPhone

### Software Installation
The following tools must install before you running the code. 
- JDK
- Eclipse Standard/SDK
- Selenium:selenium-java-2.48.2.zip (All files have been download and installed in the project. Do not do this step again.)
- TestNG (Install TestNG plugin on eclipse from http://testng.org/doc/download.html .)
- WebDriver(chromedrive for mac have been download and installed in the project. Do not do this step again. )

### Import and run the Project
-   Download the project from GitHub
-   Open Eclipse -> File -> Import -> Existing Projects Into Workspace -> Select root directory -> Select All in Projects -> Finish
-	Now the project in workspace.
-   Run "TestInMac.java" as TestNG
 

### Assumptions
-    1. By defalut, it runs in Mac platform, and for windows user please update the driver location in "Constant.java" file.
-    2. Shopping cart is empty at beginning
-    3. User need to sign in before search
-    4. User need to remove items before sign out

### Test procedure
-    1. Open www.walmart.com website.
-    2. Sign in use username and password
-    3. Search the items from data provider
-    4. Select the item from item list
-    5. Store the item id used to identify an item
-    6. Add item to shopping cart
-    7. Validate that item added is present in the cart and is the only item in the cart
-    8. Remove the item from shopping cart
-    9. Sign out 

### Technical choices
-    1. "TestInMac.java" is main TestNG file control the test flow.
-    2. "TestMethod.java" define the method of the test in module,such as click sign in in navigation bar, input usename and password,     click the sign in button, enter the search text etc.
-    3. "WebElementHelper.java" define the method of the web element, such as wait for page load, get element by xpath etc.
-    4. "Constant.java" store the xpath, username, password, webdriver location etc. used in project. 
-    5. This project use Mac and Windows platform to perform the automation test. (chromedriver.exe is webdriver for Windows and it is in chromeDrive folder, and user need update the driver location in "Constant.java" file.)

### Trade-offs
-    1. Seperate constants and method in two files improve readability and clarity of intent.
-    2. Rewrite get the element by Xpath etc. to eliminate duplication.

### Improvement
-    1. Enlarge the key word in data provider 
-    2. Set up some specile key word in data provider, such as search for an item which doesn't exist.
-    3. Select the product variables like color, size etc. before add to cart.
-    4. Deal with the case that the item sold out.
-    5. Test more than one items in the cart.
-    7. Run the test on mobile platform
-    8. Run the test on different browser
