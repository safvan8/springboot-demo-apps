

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import com.safvan.additiontest.CalculatorAdditionTest;
import com.safvan.multiplicationtest.CalculatorMultiplicationTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({ CalculatorMultiplicationTest.class, CalculatorAdditionTest.class })
public class SelectClassTest {

}
