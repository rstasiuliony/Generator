package testGenerator;

import handlers.enums.Coefficient;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GeneratorTest {

    private Generator generatorSmallCoefficient;
    private Generator generatorBigCoefficient;
    private List<Long> correctValues;
    private List<Long> generatedList;

    @Before
    public void setUp() throws Exception {

        generatorSmallCoefficient = new Generator(65, Coefficient.SMALL.getCoefficient(), 4);
        generatorBigCoefficient = new Generator(8921, Coefficient.BIG.getCoefficient(), 4);
    }

    @Test
    public void testGetListOfGeneratedValuesWithSmallCoefficient() {

        correctValues = new ArrayList<>();
        correctValues.add(1092455L);
        correctValues.add(1181022009L);
        correctValues.add(245556042L);
        correctValues.add(1744312007L);

        generatedList = generatorSmallCoefficient.getListOfGeneratedValues();

        assertEquals(correctValues, generatedList);
    }

    @Test
    public void testGetListOfGeneratedValuesWithBigCoefficient() {

        correctValues = new ArrayList<>();
        correctValues.add(430625591L);
        correctValues.add(1233683848L);
        correctValues.add(1431495498L);
        correctValues.add(137874439L);

        generatedList = generatorBigCoefficient.getListOfGeneratedValues();

        assertEquals(correctValues, generatedList);
    }
}
