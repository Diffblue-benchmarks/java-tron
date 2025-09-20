package org.tron.core.zen.address;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.ZksnarkException;

public class DiversifierTDiffblueTest {
  /**
   * Test {@link DiversifierT#DiversifierT()}.
   *
   * <p>Method under test: {@link DiversifierT#DiversifierT()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DiversifierT.<init>()"})
  public void testNewDiversifierT() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new DiversifierT().getData());
  }

  /**
   * Test {@link DiversifierT#DiversifierT(byte[])}.
   *
   * <p>Method under test: {@link DiversifierT#DiversifierT(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DiversifierT.<init>(byte[])"})
  public void testNewDiversifierT2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"), new DiversifierT("AXAXAXAX".getBytes("UTF-8")).getData());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DiversifierT#setData(byte[])}
   *   <li>{@link DiversifierT#getData()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] DiversifierT.getData()", "void DiversifierT.setData(byte[])"})
  public void testGettersAndSetters() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    DiversifierT randomResult = DiversifierT.random();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    randomResult.setData(data);
    byte[] actualData = randomResult.getData();

    // Assert
    assertSame(data, actualData);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
  }
}
