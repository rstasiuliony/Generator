package converter;

import java.lang.Long;

public class BinaryConverter implements ConverterInterface {

    private String convertedValue;

    @Override
    public String getConvertedValue(long value) {

        convertToBinary(value);
        return convertedValue;
    }

    private void convertToBinary(long valueToConvert) {

       convertedValue = Long.toBinaryString(valueToConvert);
    }
}
