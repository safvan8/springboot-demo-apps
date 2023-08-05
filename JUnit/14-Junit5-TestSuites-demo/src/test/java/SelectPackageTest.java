

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({ "com.safvan.additiontest", "com.safvan.multiplicationtest", "com.safvan.divisiontest" })
public class SelectPackageTest {

}
