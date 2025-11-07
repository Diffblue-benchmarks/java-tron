package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.junit.Test;

public class PbftSignCapsuleDiffblueTest {
  /**
   * Method under test: {@link PbftSignCapsule#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange, Act and Assert
    assertEquals(0, (new PbftSignCapsule(new byte[]{})).getData().length);
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        (new PbftSignCapsule(
            new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}))
                .getData());
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'},
        (new PbftSignCapsule(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'}))
            .getData());
  }

  /**
   * Method under test: {@link PbftSignCapsule#getData()}
   */
  @Test
  public void testGetData2() {
    // Arrange
    ByteString data = mock(ByteString.class);
    when(data.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new PbftSignCapsule(data, new ArrayList<>())).getData();

    // Assert
    verify(data, atLeast(1)).isEmpty();
    assertEquals(0, actualData.length);
  }

  /**
   * Method under test: {@link PbftSignCapsule#getData()}
   */
  @Test
  public void testGetData3() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualData = (new PbftSignCapsule("AXAXAXAXAXAXAXAAAXAXAXAX".getBytes("UTF-8"))).getData();

    // Assert
    assertArrayEquals("AXAXAXAXAAAXAXAXAXXAXAXA".getBytes("UTF-8"), actualData);
  }

  /**
   * Method under test: {@link PbftSignCapsule#getInstance()}
   */
  @Test
  public void testGetInstance() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new PbftSignCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Method under test: {@link PbftSignCapsule#getPbftCommitResult()}
   */
  @Test
  public void testGetPbftCommitResult() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new PbftSignCapsule("AXAXAXAX".getBytes("UTF-8"))).getPbftCommitResult());
  }

  /**
   * Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  public void testNewPbftSignCapsule() throws UnsupportedEncodingException {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule = new PbftSignCapsule("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualPbftSignCapsule.getInstance());
    assertNull(actualPbftSignCapsule.getPbftCommitResult());
  }

  /**
   * Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  public void testNewPbftSignCapsule2() throws UnsupportedEncodingException {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule = new PbftSignCapsule("\nXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualPbftSignCapsule.getInstance());
    assertNull(actualPbftSignCapsule.getPbftCommitResult());
  }

  /**
   * Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  public void testNewPbftSignCapsule3() {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule = new PbftSignCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualPbftSignCapsule.getInstance());
    assertNull(actualPbftSignCapsule.getPbftCommitResult());
  }

  /**
   * Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  public void testNewPbftSignCapsule4() {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule = new PbftSignCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualPbftSignCapsule.getInstance());
    assertNull(actualPbftSignCapsule.getPbftCommitResult());
  }

  /**
   * Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  public void testNewPbftSignCapsule5() throws UnsupportedEncodingException {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule = new PbftSignCapsule("XXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualPbftSignCapsule.getInstance());
    assertNull(actualPbftSignCapsule.getPbftCommitResult());
  }

  /**
   * Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  public void testNewPbftSignCapsule6() {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule = new PbftSignCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualPbftSignCapsule.getInstance());
    assertNull(actualPbftSignCapsule.getPbftCommitResult());
  }

  /**
   * Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  public void testNewPbftSignCapsule7() {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule = new PbftSignCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualPbftSignCapsule.getInstance());
    assertNull(actualPbftSignCapsule.getPbftCommitResult());
  }

  /**
   * Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  public void testNewPbftSignCapsule8() {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule = new PbftSignCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualPbftSignCapsule.getInstance());
    assertNull(actualPbftSignCapsule.getPbftCommitResult());
  }
}
