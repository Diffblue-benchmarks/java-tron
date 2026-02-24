package org.tron.core.zen.address;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ExpandedSpendingKeyDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExpandedSpendingKey#ExpandedSpendingKey()}
   *   <li>{@link ExpandedSpendingKey#setAsk(byte[])}
   *   <li>{@link ExpandedSpendingKey#setNsk(byte[])}
   *   <li>{@link ExpandedSpendingKey#setOvk(byte[])}
   *   <li>{@link ExpandedSpendingKey#getAsk()}
   *   <li>{@link ExpandedSpendingKey#getNsk()}
   *   <li>{@link ExpandedSpendingKey#getOvk()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExpandedSpendingKey.<init>()",
    "void ExpandedSpendingKey.<init>(byte[], byte[], byte[])",
    "byte[] ExpandedSpendingKey.getAsk()",
    "byte[] ExpandedSpendingKey.getNsk()",
    "byte[] ExpandedSpendingKey.getOvk()",
    "void ExpandedSpendingKey.setAsk(byte[])",
    "void ExpandedSpendingKey.setNsk(byte[])",
    "void ExpandedSpendingKey.setOvk(byte[])"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    ExpandedSpendingKey actualExpandedSpendingKey = new ExpandedSpendingKey();
    byte[] ask = "AXAXAXAX".getBytes("UTF-8");
    actualExpandedSpendingKey.setAsk(ask);
    byte[] nsk = "AXAXAXAX".getBytes("UTF-8");
    actualExpandedSpendingKey.setNsk(nsk);
    byte[] ovk = "AXAXAXAX".getBytes("UTF-8");
    actualExpandedSpendingKey.setOvk(ovk);
    byte[] actualAsk = actualExpandedSpendingKey.getAsk();
    byte[] actualNsk = actualExpandedSpendingKey.getNsk();
    byte[] actualOvk = actualExpandedSpendingKey.getOvk();

    // Assert
    assertSame(ask, actualAsk);
    assertSame(nsk, actualNsk);
    assertSame(ovk, actualOvk);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualAsk);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualNsk);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualOvk);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExpandedSpendingKey#ExpandedSpendingKey(byte[], byte[], byte[])}
   *   <li>{@link ExpandedSpendingKey#setAsk(byte[])}
   *   <li>{@link ExpandedSpendingKey#setNsk(byte[])}
   *   <li>{@link ExpandedSpendingKey#setOvk(byte[])}
   *   <li>{@link ExpandedSpendingKey#getAsk()}
   *   <li>{@link ExpandedSpendingKey#getNsk()}
   *   <li>{@link ExpandedSpendingKey#getOvk()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExpandedSpendingKey.<init>()",
    "void ExpandedSpendingKey.<init>(byte[], byte[], byte[])",
    "byte[] ExpandedSpendingKey.getAsk()",
    "byte[] ExpandedSpendingKey.getNsk()",
    "byte[] ExpandedSpendingKey.getOvk()",
    "void ExpandedSpendingKey.setAsk(byte[])",
    "void ExpandedSpendingKey.setNsk(byte[])",
    "void ExpandedSpendingKey.setOvk(byte[])"
  })
  public void testGettersAndSetters_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    ExpandedSpendingKey actualExpandedSpendingKey =
        new ExpandedSpendingKey(
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"),
            "AXAXAXAX".getBytes("UTF-8"));
    byte[] ask = "AXAXAXAX".getBytes("UTF-8");
    actualExpandedSpendingKey.setAsk(ask);
    byte[] nsk = "AXAXAXAX".getBytes("UTF-8");
    actualExpandedSpendingKey.setNsk(nsk);
    byte[] ovk = "AXAXAXAX".getBytes("UTF-8");
    actualExpandedSpendingKey.setOvk(ovk);
    byte[] actualAsk = actualExpandedSpendingKey.getAsk();
    byte[] actualNsk = actualExpandedSpendingKey.getNsk();
    byte[] actualOvk = actualExpandedSpendingKey.getOvk();

    // Assert
    assertSame(ask, actualAsk);
    assertSame(nsk, actualNsk);
    assertSame(ovk, actualOvk);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualAsk);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualNsk);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualOvk);
  }
}
