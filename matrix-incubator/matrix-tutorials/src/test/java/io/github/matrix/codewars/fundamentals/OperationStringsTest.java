package io.github.matrix.codewars.fundamentals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Noa Swartz
 * @date 2020/12/13
 */
public class OperationStringsTest {

    public static final Logger logger = LoggerFactory.getLogger(OperationStringsTest.class);

    @Test
    public void testSelfieAndRot() {
        String str = "abcd\nefgh\nijkl\nmnop";
        Assertions.assertEquals(OperationStrings.operation(OperationStrings::rot, str), "ponm\nlkji\nhgfe\ndcba");
        Assertions.assertEquals(OperationStrings.operation(OperationStrings::selfieAndRot, str), "abcd....\nefgh....\nijkl....\nmnop....\n....ponm\n....lkji\n....hgfe\n....dcba");
    }

}
