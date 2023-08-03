

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({ "com.infosys.additiontest", "com.infosys.multiplicationtest", "com.infosys.divisiontest" })
public class SelectPackageTest {

}
