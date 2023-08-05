package com.safvan.service.test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.safvan.service.test")
@IncludeTags("Success")
//@IncludeTags({ "Success", "Cloud" }) // uncomment to execute this tags
//@ExcludeTags("Failure")
class CalculatorTest {

}
