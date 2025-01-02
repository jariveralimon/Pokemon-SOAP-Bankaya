package com.example.pokemon;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features") // Ruta de tus archivos .feature
@ConfigurationParameter(key = "cucumber.glue", value = "com.example.pokemon.steps") // Ruta de tus pasos
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty, html:target/cucumber-reports.html") // Reporte HTML
@SuppressWarnings("java:S2187")
public class CucumberTest {
}
