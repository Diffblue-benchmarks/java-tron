package org.tron.common.overlay.message;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.P2pException;

public class MessageDiffblueTest {
  /**
   * Test {@link Message#compareBytes(byte[], byte[])}.
   *
   * <p>Method under test: {@link Message#compareBytes(byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Message.compareBytes(byte[], byte[])"})
  public void testCompareBytes() throws UnsupportedEncodingException, P2pException {
    // Arrange, Act and Assert
    assertThrows(
        P2pException.class,
        () ->
            Message.compareBytes(
                "A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Message#compareBytes(byte[], byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then throw {@link P2pException}.
   * </ul>
   *
   * <p>Method under test: {@link Message#compareBytes(byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Message.compareBytes(byte[], byte[])"})
  public void testCompareBytes_whenEmptyArrayOfByte_thenThrowP2pException()
      throws UnsupportedEncodingException, P2pException {
    // Arrange, Act and Assert
    assertThrows(
        P2pException.class,
        () -> Message.compareBytes(new byte[] {}, "AXAXAXAX".getBytes("UTF-8")));
  }
}
