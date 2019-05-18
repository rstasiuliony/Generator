package converter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryConverterTest {

    private BinaryConverter binaryConverter;

    @Before
    public void setUp() throws Exception {

        binaryConverter = new BinaryConverter();
    }

    @Test
    public void getConvertedValue() {

        String result = binaryConverter.getConvertedValue(500);
        assertEquals("111110100", result);
    }
}