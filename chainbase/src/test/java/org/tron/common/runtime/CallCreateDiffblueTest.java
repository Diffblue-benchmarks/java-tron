package org.tron.common.runtime;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CallCreateDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CallCreate#CallCreate(byte[], byte[], byte[], byte[])}
   *   <li>{@link CallCreate#getData()}
   *   <li>{@link CallCreate#getDestination()}
   *   <li>{@link CallCreate#getEnergyLimit()}
   *   <li>{@link CallCreate#getValue()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CallCreate.<init>(byte[], byte[], byte[], byte[])",
    "byte[] CallCreate.getData()",
    "byte[] CallCreate.getDestination()",
    "byte[] CallCreate.getEnergyLimit()",
    "byte[] CallCreate.getValue()"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    byte[] destination = "AXAXAXAX".getBytes("UTF-8");
    byte[] energyLimit = "AXAXAXAX".getBytes("UTF-8");
    byte[] value = "AXAXAXAX".getBytes("UTF-8");

    // Act
    CallCreate actualCallCreate = new CallCreate(data, destination, energyLimit, value);
    byte[] actualData = actualCallCreate.getData();
    byte[] actualDestination = actualCallCreate.getDestination();
    byte[] actualEnergyLimit = actualCallCreate.getEnergyLimit();
    byte[] actualValue = actualCallCreate.getValue();

    // Assert
    assertSame(data, actualData);
    assertSame(destination, actualDestination);
    assertSame(energyLimit, actualEnergyLimit);
    assertSame(value, actualValue);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualDestination);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualEnergyLimit);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualValue);
  }
}
