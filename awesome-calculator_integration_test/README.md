# Awesome factorial application

[[_TOC_]]


## Basic Structure

Basic nature of the framework is Behavioural Driven Framework that taken features and scenarions in to account and steps defined by Serenity in the background.
Serenity uses Selenium for UI tests but wrapped in its own library. So knowledge about selenium library helps for faster automation and identify the correct element.
Also serenity has efficient waits that help us to create UI automation without any hard sleep.

Serenity also helps automation of REST APIs with Rest Assured that actually makes automation simpler and faster.
Cucumber BDD tool has been used on top of Serenity BDD. Central to the Cucumber BDD approach is its ordinary language parser called Gherkin. It allows expected software behaviors to be specified in a logical language that customers can understand.

Cucumber files are written in feature files can be found under Resources folder.
### How to Run the tests

clone the project, then run the sample test using jUnit or maven build.

Use maven configuration with command - goal - with chrome browser instance.

`clean verify -DAPI_PASSWORD=<<api_secret>> -DUSERNAME=<<MyUsername>> -DPASSWORD=<<MyPassword>> serenity:aggregate`

-D indicates (serenity) properties which means any properties can pass in the same way.

if JUnit configuration is used, you can use same parameters in 'VM options' section

`-Dwebdriver.driver=chrome -DUSERNAME=<<MyUsername>>  -DAPI_PASSWORD=<<api_secret>>`

Add another property to get the environment (default is Test environment)

`-Denvironment=Acceptance`

The same command can be used in CI CD maven build to run the tests.

### Reports

Once the tests run, report will be generated in the target folder of the respective module;
can be found target > site > serenity > index.html

### Logging Mechanism

Serenity has a nice logging mechanism and logging in 'main > java packages' is extended with 'logback-classic' logging mechanism.
Logging format and other parameters are based on xml available at 'src/main/resources/logback.xml'.

Usage;

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

Then just use;

`LOGGER.info("This info will be displayed in output");`

Info / warn / error / fatal types can be used as a log. Error and fatal log types will stop the test.

More information look at the logback documentation.

###Assertions

Along with j-unit assertions, serenity tests can make use of hamcrest assertions.

Usage;

    import static org.hamcrest.MatcherAssert.assertThat; 
    import static org.hamcrest.Matchers.*;
    
    assertThat("Actual", equalToIgnoringCase(Expected))

get more usages here: http://hamcrest.org/JavaHamcrest/tutorial
