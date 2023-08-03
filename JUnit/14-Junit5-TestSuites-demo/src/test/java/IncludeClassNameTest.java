

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.infosys")
@IncludeClassNamePatterns(".*Multiplication.*")
public class IncludeClassNameTest {

}
