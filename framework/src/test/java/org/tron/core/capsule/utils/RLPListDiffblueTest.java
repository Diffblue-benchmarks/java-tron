package org.tron.core.capsule.utils;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class RLPListDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RLPList}
   *   <li>{@link RLPList#setRLPData(byte[])}
   *   <li>{@link RLPList#getRLPData()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    RLPList actualRlpList = new RLPList();
    byte[] rlpData = "AXAXAXAX".getBytes("UTF-8");
    actualRlpList.setRLPData(rlpData);

    // Assert that nothing has changed
    assertSame(rlpData, actualRlpList.getRLPData());
  }

  /**
   * Method under test: {@link RLPList#recursivePrint(RLPElement)}
   */
  @Test
  public void testRecursivePrint() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> RLPList.recursivePrint(null));
  }

  /**
   * Method under test: {@link RLPList#recursivePrint(RLPElement)}
   */
  @Test
  public void testRecursivePrint2() throws UnsupportedEncodingException {
    // Arrange
    RLPElement element = mock(RLPElement.class);
    when(element.getRLPData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    RLPList.recursivePrint(element);

    // Assert
    verify(element).getRLPData();
  }

  /**
   * Method under test: {@link RLPList#recursivePrint(RLPElement)}
   */
  @Test
  public void testRecursivePrint3() {
    // Arrange
    RLPElement element = mock(RLPElement.class);
    when(element.getRLPData()).thenReturn(null);

    // Act
    RLPList.recursivePrint(element);

    // Assert
    verify(element).getRLPData();
  }

  /**
   * Method under test: {@link RLPList#recursivePrint(RLPElement)}
   */
  @Test
  public void testRecursivePrint4() {
    // Arrange
    RLPElement element = mock(RLPElement.class);
    when(element.getRLPData()).thenThrow(new RuntimeException(", "));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> RLPList.recursivePrint(element));
    verify(element).getRLPData();
  }

  /**
   * Method under test: {@link RLPList#recursivePrint(RLPElement)}
   */
  @Test
  public void testRecursivePrint5() throws UnsupportedEncodingException {
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
   * Method under test: {@link RLPList#recursivePrint(RLPElement)}
   */
  @Test
  public void testRecursivePrint6() throws UnsupportedEncodingException {
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
}
