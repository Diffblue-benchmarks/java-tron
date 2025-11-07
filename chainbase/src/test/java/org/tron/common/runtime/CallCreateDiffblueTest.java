package org.tron.common.runtime;

import static org.junit.Assert.assertSame;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class CallCreateDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CallCreate#CallCreate(byte[], byte[], byte[], byte[])}
   *   <li>{@link CallCreate#getData()}
   *   <li>{@link CallCreate#getDestination()}
   *   <li>{@link CallCreate#getEnergyLimit()}
   *   <li>{@link CallCreate#getValue()}
   * </ul>
   */
  @Test
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

    // Assert
    assertSame(data, actualData);
    assertSame(destination, actualDestination);
    assertSame(energyLimit, actualEnergyLimit);
    assertSame(value, actualCallCreate.getValue());
  }
}
