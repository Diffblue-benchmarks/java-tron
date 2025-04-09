package org.tron.core.db;

import static org.junit.Assert.assertArrayEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TransactionTraceDiffblueTest {
  /**
   * Test {@link TransactionTrace#convertToTronAddress(byte[])}.
   * <p>
   * Method under test: {@link TransactionTrace#convertToTronAddress(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TransactionTrace.convertToTronAddress(byte[])"})
  public void testConvertToTronAddress() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualConvertToTronAddressResult = TransactionTrace.convertToTronAddress("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualConvertToTronAddressResult);
  }
}
