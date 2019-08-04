# XeroDemo -
##Selenium with Cucumber(BDD framework)##

Pre-requisites:
1) Install Java -SDK 12 
2) Install Git 
3) Install IntelliJ
4) Make sure Google Chrome is present

# EnvironmentSetup:
1) Set JAVA_HOME, as per the platform user use.
2) As i used chrome as my browser for execution - Latest chrome driver is kept in src/drivers folder 
Note: All other required dependancies like Cucumber, Selenium, Gherkin, extent reports are placed in src/lib folder 

#Cloning the project:
Follow below Steps within command prompt to import the project 
1) cd to the path you want to download the framework - For example "cd C:/Users/"
2) mkdir to create a new directory with name “Automation_Projects”
3) cd Automation_Projects
4) git init to initialise empty git repository 
5) git clone https://github.com/jaiprashanth1992/XeroDemo.git - to clone the project framework 
6) cd XeroDemo

#IntelliJ Setup
1) Open the Cloned project in IntelliJ - File--> New --> Project from Existing Sources
2) Select the project directory from the pop up displayed
3) Proceed next few screen by selecting prepopulated libraries, dependancies and SDKs
4) Once imported, navigate to File--> Project Structures--> Modules and add the imported jars files in dependancies tab from src/lib folder
5) Make sure src folder is marked as Source Root
6) On top right corner click on add configuration and add a run/debug junit configuration with class as "Tets.testrunner"
7) Add another run/debug configuration - Cucumber java, with below fields updated
  a) Main Class - cucumber.api.cli.Main
  b) Feature File path - Xero_Demo/src/Tests/FeatureFile/AddAccount.feature
  c) Program Arguments -  --plugin org.jetbrains.plugins.cucumber.java.run.CucumberJvmSMFormatter --monochrome

#Executing the Tests
1) Navigate to "src/Tests/testrunner.java" class
2) Right click testrunner and select Run 'testrunner'

Google chrome pop ups and the execution begins!!

#Reporting
1) Extent reports will be generated in the project folder -"C:/Users/Automation_Projects Xero_Demo/HtmlOutput/
2) Open the latest html report generated using any browser of your choice

