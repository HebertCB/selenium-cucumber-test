/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.seleniumwebdrivertest.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/features/busqueda.feature", glue={"pe.edu.upeu.seleniumwebdrivertest.steps"},
        monochrome=true,
        plugin={"pretty","html:target/HtmlReports/TestReport.html"})
public class CucumberTestRunner extends AbstractTestNGCucumberTests{
    
}
