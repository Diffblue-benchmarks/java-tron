package org.tron.core.capsule.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RLPListDiffblueTest {
  /**
   * Test {@link RLPList#recursivePrint(RLPElement)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>When {@code A}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RLPList#recursivePrint(RLPElement)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RLPList.recursivePrint(RLPElement)"})
  public void testRecursivePrint_givenAxaxaxaxBytesIsUtf8_whenA_thenDoesNotThrow()
      throws UnsupportedEncodingException {
    // Arrange
    RLPList element = RLP.decode2(new byte[] {Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    element.setRLPData("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    RLPList.recursivePrint(element);
  }

  /**
   * Test {@link RLPList#recursivePrint(RLPElement)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link RLPElement#getRLPData()}.
   * </ul>
   *
   * <p>Method under test: {@link RLPList#recursivePrint(RLPElement)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RLPList.recursivePrint(RLPElement)"})
  public void testRecursivePrint_givenRuntimeException_thenCallsGetRLPData() {
    // Arrange
    RLPElement element = mock(RLPElement.class);
    when(element.getRLPData()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> RLPList.recursivePrint(element));
    verify(element).getRLPData();
  }

  /**
   * Test {@link RLPList#recursivePrint(RLPElement)}.
   *
   * <ul>
   *   <li>When decode2 {@code AXAXAXAX} Bytes is {@code UTF-8} RLPData is {@code AXAXAXAX} Bytes is
   *       {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link RLPList#recursivePrint(RLPElement)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RLPList.recursivePrint(RLPElement)"})
  public void testRecursivePrint_whenDecode2AxaxaxaxBytesIsUtf8RLPDataIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    RLPList element = RLP.decode2("AXAXAXAX".getBytes("UTF-8"));
    element.setRLPData("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    RLPList.recursivePrint(element);
  }

  /**
   * Test {@link RLPList#recursivePrint(RLPElement)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RLPList#recursivePrint(RLPElement)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RLPList.recursivePrint(RLPElement)"})
  public void testRecursivePrint_whenNull_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> RLPList.recursivePrint(null));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link RLPList}
   *   <li>{@link RLPList#setRLPData(byte[])}
   *   <li>{@link RLPList#getRLPData()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RLPList.<init>()",
    "byte[] RLPList.getRLPData()",
    "void RLPList.setRLPData(byte[])"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    RLPList actualRlpList = new RLPList();
    byte[] rlpData = "AXAXAXAX".getBytes("UTF-8");
    actualRlpList.setRLPData(rlpData);
    byte[] actualRLPData = actualRlpList.getRLPData();

    // Assert
    assertSame(rlpData, actualRLPData);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualRLPData);
  }
}
