package org.tron.core.zen.address;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.core.exception.ZksnarkException;

public class DiversifierTDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DiversifierT#setData(byte[])}
   *   <li>{@link DiversifierT#getData()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    DiversifierT randomResult = DiversifierT.random();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    randomResult.setData(data);

    // Assert that nothing has changed
    assertSame(data, randomResult.getData());
  }

  /**
   * Method under test: {@link DiversifierT#random()}
   */
  @Test
  public void testRandom() throws ZksnarkException {
    // Arrange, Act and Assert
    assertEquals(11, DiversifierT.random().getData().length);
  }

  /**
   * Method under test: {@link DiversifierT#DiversifierT()}
   */
  @Test
  public void testNewDiversifierT() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, (new DiversifierT()).getData());
  }

  /**
   * Method under test: {@link DiversifierT#DiversifierT(byte[])}
   */
  @Test
  public void testNewDiversifierT2() throws UnsupportedEncodingException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertSame(data, (new DiversifierT(data)).getData());
  }
}
