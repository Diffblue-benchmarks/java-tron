package org.tron.core.capsule.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RLPListDiffblueTest {
  /**
   * Test {@link RLPList#recursivePrint(RLPElement)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RLPList#recursivePrint(RLPElement)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RLPList.recursivePrint(RLPElement)"})
  public void testRecursivePrint_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    RLPElement element = mock(RLPElement.class);
    when(element.getRLPData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    RLPList.recursivePrint(element);

    // Assert
    verify(element).getRLPData();
  }

  /**
   * Test {@link RLPList#recursivePrint(RLPElement)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link RLPElement} {@link RLPElement#getRLPData()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RLPList#recursivePrint(RLPElement)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RLPList.recursivePrint(RLPElement)"})
  public void testRecursivePrint_givenNull_whenRLPElementGetRLPDataReturnNull() {
    // Arrange
    RLPElement element = mock(RLPElement.class);
    when(element.getRLPData()).thenReturn(null);

    // Act
    RLPList.recursivePrint(element);

    // Assert
    verify(element).getRLPData();
  }

  /**
   * Test {@link RLPList#recursivePrint(RLPElement)}.
   * <ul>
   *   <li>Given {@link RLPElement} {@link RLPElement#getRLPData()} return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RLPList#recursivePrint(RLPElement)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RLPList.recursivePrint(RLPElement)"})
  public void testRecursivePrint_givenRLPElementGetRLPDataReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    RLPElement rlpElement = mock(RLPElement.class);
    when(rlpElement.getRLPData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    RLPList element = new RLPList();
    element.add(rlpElement);

    // Act
    RLPList.recursivePrint(element);

    // Assert
    verify(rlpElement).getRLPData();
  }

  /**
   * Test {@link RLPList#recursivePrint(RLPElement)}.
   * <ul>
   *   <li>Given {@link RLPElement} {@link RLPElement#getRLPData()} throw {@link RuntimeException#RuntimeException(String)} with {@code ,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RLPList#recursivePrint(RLPElement)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RLPList.recursivePrint(RLPElement)"})
  public void testRecursivePrint_givenRLPElementGetRLPDataThrowRuntimeExceptionWithComma()
      throws UnsupportedEncodingException {
    // Arrange
    RLPElement rlpElement = mock(RLPElement.class);
    when(rlpElement.getRLPData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    RLPElement rlpElement2 = mock(RLPElement.class);
    when(rlpElement2.getRLPData()).thenThrow(new RuntimeException(", "));

    RLPList element = new RLPList();
    element.add(rlpElement2);
    element.add(rlpElement);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> RLPList.recursivePrint(element));
    verify(rlpElement2).getRLPData();
  }

  /**
   * Test {@link RLPList#recursivePrint(RLPElement)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code ,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RLPList#recursivePrint(RLPElement)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RLPList.recursivePrint(RLPElement)"})
  public void testRecursivePrint_givenRuntimeExceptionWithComma() {
    // Arrange
    RLPElement element = mock(RLPElement.class);
    when(element.getRLPData()).thenThrow(new RuntimeException(", "));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> RLPList.recursivePrint(element));
    verify(element).getRLPData();
  }

  /**
   * Test {@link RLPList#recursivePrint(RLPElement)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RLPList#recursivePrint(RLPElement)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RLPList.recursivePrint(RLPElement)"})
  public void testRecursivePrint_whenNull_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> RLPList.recursivePrint(null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RLPList}
   *   <li>{@link RLPList#setRLPData(byte[])}
   *   <li>{@link RLPList#getRLPData()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RLPList.<init>()", "byte[] RLPList.getRLPData()", "void RLPList.setRLPData(byte[])"})
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
