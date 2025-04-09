package org.tron.core.net.message;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.P2pException;

public class PbftMessageFactoryDiffblueTest {
  /**
   * Test {@link PbftMessageFactory#create(byte[])} with {@code data}.
   * <ul>
   *   <li>When array of {@code byte} with one and {@code X}.</li>
   *   <li>Then throw {@link P2pException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.consensus.pbft.message.PbftBaseMessage PbftMessageFactory.create(byte[])"})
  public void testCreateWithData_whenArrayOfByteWithOneAndX_thenThrowP2pException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(P2pException.class, () -> PbftMessageFactory.create(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link PbftMessageFactory#create(byte[])} with {@code data}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then throw {@link P2pException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.consensus.pbft.message.PbftBaseMessage PbftMessageFactory.create(byte[])"})
  public void testCreateWithData_whenArrayOfByteWithSevenAndX_thenThrowP2pException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(P2pException.class, () -> PbftMessageFactory.create(new byte[]{7, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link PbftMessageFactory#create(byte[])} with {@code data}.
   * <ul>
   *   <li>When array of {@code byte} with six and {@code X}.</li>
   *   <li>Then throw {@link P2pException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.consensus.pbft.message.PbftBaseMessage PbftMessageFactory.create(byte[])"})
  public void testCreateWithData_whenArrayOfByteWithSixAndX_thenThrowP2pException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(P2pException.class, () -> PbftMessageFactory.create(new byte[]{6, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link PbftMessageFactory#create(byte[])} with {@code data}.
   * <ul>
   *   <li>When array of {@code byte} with three and {@code X}.</li>
   *   <li>Then throw {@link P2pException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.consensus.pbft.message.PbftBaseMessage PbftMessageFactory.create(byte[])"})
  public void testCreateWithData_whenArrayOfByteWithThreeAndX_thenThrowP2pException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(P2pException.class, () -> PbftMessageFactory.create(new byte[]{3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link PbftMessageFactory#create(byte[])} with {@code data}.
   * <ul>
   *   <li>When array of {@code byte} with two and {@code X}.</li>
   *   <li>Then throw {@link P2pException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.consensus.pbft.message.PbftBaseMessage PbftMessageFactory.create(byte[])"})
  public void testCreateWithData_whenArrayOfByteWithTwoAndX_thenThrowP2pException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(P2pException.class, () -> PbftMessageFactory.create(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link PbftMessageFactory#create(byte[])} with {@code data}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link P2pException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.consensus.pbft.message.PbftBaseMessage PbftMessageFactory.create(byte[])"})
  public void testCreateWithData_whenAxaxaxaxBytesIsUtf8_thenThrowP2pException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(P2pException.class, () -> PbftMessageFactory.create("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link PbftMessageFactory#create(byte[])} with {@code data}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link P2pException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.consensus.pbft.message.PbftBaseMessage PbftMessageFactory.create(byte[])"})
  public void testCreateWithData_whenXaxaxaxBytesIsUtf8_thenThrowP2pException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(P2pException.class, () -> PbftMessageFactory.create("\bXAXAXAX".getBytes("UTF-8")));
  }
}
