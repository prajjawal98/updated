# Selenium Test in Azure Pipelines
This template will help you to have a data driven framework and Selenium test in azure pipelines.Here we are using apache POI to read data from a excel file. 
## Why we need Azure pipelines for integration:-
we can have an automated way of running our regression test.  Whenever we have any changes to our VCS repo and we can have our test run in parallel along with the project build.So that we can identify  any bugs or defects even when there is a small change of functionality or code.
#### I was using - 
* Java as the programming language
* TestNG as the assertion framework
* Maven as the build tool
* WebDriver as the browser automation tool
* IntelliJ as the IDE

Create new maven project and give the project name - Headless chrome framework

Add the dependency in pom file.

####Add the plugins - TestNG and Maven Helper.
####Type of framework - 
Data driven framework.
###Packages- 
We have a separate package for Com and TestCase and Listeners. All web page related class  under in Com package and all test cases  in under TestCase and ExtentReport content class under in Listeners. 
##Com package--
####Content class
This class is responsible for loading the test cases from excel sheet.
* Download Apache POI libraries dependency in pom files.
* XSSF(XML Spreadsheet Format) this is the interface using for read and write the data from excel sheet using XSSFWorkbook workbook.

