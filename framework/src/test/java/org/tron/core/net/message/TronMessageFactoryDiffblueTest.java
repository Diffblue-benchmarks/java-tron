package org.tron.core.net.message;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.P2pException;

public class TronMessageFactoryDiffblueTest {
  /**
   * Test {@link TronMessageFactory#create(byte[])} with {@code data}.
   *
   * <ul>
   *   <li>When array of {@code byte} with one and {@code X}.
   *   <li>Then throw {@link P2pException}.
   * </ul>
   *
   * <p>Method under test: {@link TronMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.core.net.message.TronMessage TronMessageFactory.create(byte[])"})
  public void testCreateWithData_whenArrayOfByteWithOneAndX_thenThrowP2pException()
      throws Exception {
    // Arrange, Act and Assert
    assertThrows(
        P2pException.class,
        () -> TronMessageFactory.create(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TronMessageFactory#create(byte[])} with {@code data}.
   *
   * <ul>
   *   <li>When array of {@code byte} with three and {@code X}.
   *   <li>Then throw {@link P2pException}.
   * </ul>
   *
   * <p>Method under test: {@link TronMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.core.net.message.TronMessage TronMessageFactory.create(byte[])"})
  public void testCreateWithData_whenArrayOfByteWithThreeAndX_thenThrowP2pException()
      throws Exception {
    // Arrange, Act and Assert
    assertThrows(
        P2pException.class,
        () -> TronMessageFactory.create(new byte[] {3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TronMessageFactory#create(byte[])} with {@code data}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   *   <li>Then throw {@link P2pException}.
   * </ul>
   *
   * <p>Method under test: {@link TronMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.core.net.message.TronMessage TronMessageFactory.create(byte[])"})
  public void testCreateWithData_whenArrayOfByteWithZeroAndX_thenThrowP2pException()
      throws Exception {
    // Arrange, Act and Assert
    assertThrows(
        P2pException.class,
        () -> TronMessageFactory.create(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TronMessageFactory#create(byte[])} with {@code data}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link P2pException}.
   * </ul>
   *
   * <p>Method under test: {@link TronMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.tron.core.net.message.TronMessage TronMessageFactory.create(byte[])"})
  public void testCreateWithData_whenAxaxaxaxBytesIsUtf8_thenThrowP2pException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(P2pException.class, () -> TronMessageFactory.create("AXAXAXAX".getBytes("UTF-8")));
  }
}
