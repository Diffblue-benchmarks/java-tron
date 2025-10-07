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
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link RLPList#recursivePrint(RLPElement)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RLPList.recursivePrint(RLPElement)"})
  public void testRecursivePrint_givenRuntimeException() {
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
   * Test {@link RLPList#recursivePrint(RLPElement)}.
   *
   * <ul>
   *   <li>When {@link RLPElement} {@link RLPElement#getRLPData()} return {@code null}.
   *   <li>Then calls {@link RLPElement#getRLPData()}.
   * </ul>
   *
   * <p>Method under test: {@link RLPList#recursivePrint(RLPElement)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RLPList.recursivePrint(RLPElement)"})
  public void testRecursivePrint_whenRLPElementGetRLPDataReturnNull_thenCallsGetRLPData() {
    // Arrange
    RLPElement element = mock(RLPElement.class);
    when(element.getRLPData()).thenReturn(null);

    // Act
    RLPList.recursivePrint(element);

    // Assert
    verify(element).getRLPData();
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
