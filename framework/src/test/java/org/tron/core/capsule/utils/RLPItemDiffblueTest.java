package org.tron.core.capsule.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class RLPItemDiffblueTest {
  /**
   * Method under test: {@link RLPItem#getRLPData()}
   */
  @Test
  public void testGetRLPData() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRLPData = (new RLPItem("AXAXAXAX".getBytes("UTF-8"))).getRLPData();

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualRLPData);
  }

  /**
   * Method under test: {@link RLPItem#getRLPData()}
   */
  @Test
  public void testGetRLPData2() {
    // Arrange, Act and Assert
    assertNull((new RLPItem(new byte[]{})).getRLPData());
  }

  /**
   * Method under test: {@link RLPItem#RLPItem(byte[])}
   */
  @Test
  public void testNewRLPItem() throws UnsupportedEncodingException {
    // Arrange
    byte[] rlpData = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertSame(rlpData, (new RLPItem(rlpData)).getRLPData());
  }
}
