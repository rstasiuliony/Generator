package testGenerator;

import handlers.enums.Coefficient;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GeneratorTest {

    private Generator generatorSmallCoefficient;

    @Before
    public void setUp() throws Exception {

        generatorSmallCoefficient = new Generator(65, Coefficient.SMALL.getCoefficient(), 4);
    }

    @Test
    public void testGetListOfGeneratedValues() {

        List<Long> correctValues = new ArrayList<>();
        correctValues.add(1092455L);
        correctValues.add(1181022009L);
        correctValues.add(245556042L);
        correctValues.add(1744312007L);

        List<Long> generatedList = generatorSmallCoefficient.getListOfGeneratedValues();

        assertEquals(correctValues, generatedList);
    }
}
