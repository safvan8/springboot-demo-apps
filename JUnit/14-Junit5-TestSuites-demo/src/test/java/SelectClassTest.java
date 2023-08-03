

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import com.infosys.additiontest.CalculatorAdditionTest;
import com.infosys.multiplicationtest.CalculatorMultiplicationTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({ CalculatorMultiplicationTest.class, CalculatorAdditionTest.class })
public class SelectClassTest {

}
