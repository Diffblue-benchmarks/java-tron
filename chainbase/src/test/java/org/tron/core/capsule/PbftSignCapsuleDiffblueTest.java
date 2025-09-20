package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.PBFTCommitResult;

public class PbftSignCapsuleDiffblueTest {
  /**
   * Test {@link PbftSignCapsule#PbftSignCapsule(ByteString, List)}.
   *
   * <ul>
   *   <li>Then return Instance InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link PbftSignCapsule#PbftSignCapsule(ByteString, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftSignCapsule.<init>(ByteString, List)"})
  public void testNewPbftSignCapsule_thenReturnInstanceInitializationErrorStringIsEmptyString() {
    // Arrange
    ByteString data = mock(ByteString.class);

    // Act
    PbftSignCapsule actualPbftSignCapsule = new PbftSignCapsule(data, new ArrayList<>());

    // Assert
    PBFTCommitResult instance = actualPbftSignCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0, instance.getSignatureCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertTrue(instance.findInitializationErrors().isEmpty());
    assertTrue(instance.getSignatureList().isEmpty());
    assertTrue(instance.isInitialized());
    assertSame(instance, actualPbftSignCapsule.getPbftCommitResult());
    assertSame(data, instance.getData());
    assertArrayEquals(new byte[] {'\n', 0}, actualPbftSignCapsule.getData());
  }

  /**
   * Test {@link PbftSignCapsule#PbftSignCapsule(byte[])}.
   *
   * <ul>
   *   <li>Then return Instance InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftSignCapsule.<init>(byte[])"})
  public void testNewPbftSignCapsule_thenReturnInstanceInitializationErrorStringIsEmptyString2() {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule = new PbftSignCapsule(new byte[] {});

    // Assert
    PBFTCommitResult instance = actualPbftSignCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0, instance.getSerializedSize());
    assertEquals(0, instance.getSignatureCount());
    assertTrue(instance.findInitializationErrors().isEmpty());
    assertTrue(instance.getSignatureList().isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    assertTrue(instance.isInitialized());
    PBFTCommitResult actualDefaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(instance, actualDefaultInstanceForType);
    assertSame(instance, actualPbftSignCapsule.getPbftCommitResult());
    assertArrayEquals(new byte[] {}, actualPbftSignCapsule.getData());
  }

  /**
   * Test {@link PbftSignCapsule#PbftSignCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftSignCapsule.<init>(byte[])"})
  public void testNewPbftSignCapsule_whenAAAAAAAABytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule =
        new PbftSignCapsule("A\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"));

    // Assert
    assertNull(actualPbftSignCapsule.getInstance());
    assertNull(actualPbftSignCapsule.getPbftCommitResult());
  }

  /**
   * Test {@link PbftSignCapsule#PbftSignCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftSignCapsule.<init>(byte[])"})
  public void testNewPbftSignCapsule_whenAAAAAAABytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule =
        new PbftSignCapsule("\n\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"));

    // Assert
    assertNull(actualPbftSignCapsule.getInstance());
    assertNull(actualPbftSignCapsule.getPbftCommitResult());
  }

  /**
   * Test {@link PbftSignCapsule#PbftSignCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and lf.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftSignCapsule.<init>(byte[])"})
  public void testNewPbftSignCapsule_whenArrayOfByteWithAAndLf_thenReturnInstanceIsNull() {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule =
        new PbftSignCapsule(
            new byte[] {
              'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 0, '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualPbftSignCapsule.getInstance());
    assertNull(actualPbftSignCapsule.getPbftCommitResult());
  }

  /**
   * Test {@link PbftSignCapsule#PbftSignCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and lf.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftSignCapsule.<init>(byte[])"})
  public void testNewPbftSignCapsule_whenArrayOfByteWithEighteenAndLf_thenReturnInstanceIsNull() {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule =
        new PbftSignCapsule(
            new byte[] {
              18, '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualPbftSignCapsule.getInstance());
    assertNull(actualPbftSignCapsule.getPbftCommitResult());
  }

  /**
   * Test {@link PbftSignCapsule#PbftSignCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftSignCapsule.<init>(byte[])"})
  public void testNewPbftSignCapsule_whenArrayOfByteWithEighteenAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule =
        new PbftSignCapsule(new byte[] {18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualPbftSignCapsule.getInstance());
    assertNull(actualPbftSignCapsule.getPbftCommitResult());
  }

  /**
   * Test {@link PbftSignCapsule#PbftSignCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.
   * </ul>
   *
   * <p>Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftSignCapsule.<init>(byte[])"})
  public void testNewPbftSignCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule =
        new PbftSignCapsule(new byte[] {18, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualPbftSignCapsule.getInstance());
    assertNull(actualPbftSignCapsule.getPbftCommitResult());
  }

  /**
   * Test {@link PbftSignCapsule#PbftSignCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftSignCapsule.<init>(byte[])"})
  public void testNewPbftSignCapsule_whenArrayOfByteWithMinusOneAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule =
        new PbftSignCapsule(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualPbftSignCapsule.getInstance());
    assertNull(actualPbftSignCapsule.getPbftCommitResult());
  }

  /**
   * Test {@link PbftSignCapsule#PbftSignCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftSignCapsule.<init>(byte[])"})
  public void testNewPbftSignCapsule_whenArrayOfByteWithZeroAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule =
        new PbftSignCapsule(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualPbftSignCapsule.getInstance());
    assertNull(actualPbftSignCapsule.getPbftCommitResult());
  }

  /**
   * Test {@link PbftSignCapsule#PbftSignCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftSignCapsule.<init>(byte[])"})
  public void testNewPbftSignCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule = new PbftSignCapsule("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualPbftSignCapsule.getInstance());
    assertNull(actualPbftSignCapsule.getPbftCommitResult());
  }

  /**
   * Test {@link PbftSignCapsule#PbftSignCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftSignCapsule.<init>(byte[])"})
  public void testNewPbftSignCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule = new PbftSignCapsule("XXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualPbftSignCapsule.getInstance());
    assertNull(actualPbftSignCapsule.getPbftCommitResult());
  }

  /**
   * Test {@link PbftSignCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link ByteString} {@link ByteString#isEmpty()} return {@code true}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link PbftSignCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] PbftSignCapsule.getData()"})
  public void testGetData_givenByteStringIsEmptyReturnTrue_thenReturnEmptyArrayOfByte() {
    // Arrange
    ByteString data = mock(ByteString.class);
    when(data.isEmpty()).thenReturn(true);
    PbftSignCapsule pbftSignCapsule = new PbftSignCapsule(data, new ArrayList<>());

    // Act
    byte[] actualData = pbftSignCapsule.getData();

    // Assert
    verify(data, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[] {}, actualData);
  }

  /**
   * Test {@link PbftSignCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link ByteString} {@link ByteString#size()} return zero.
   *   <li>Then return array of {@code byte} with lf and zero.
   * </ul>
   *
   * <p>Method under test: {@link PbftSignCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] PbftSignCapsule.getData()"})
  public void testGetData_givenByteStringSizeReturnZero_thenReturnArrayOfByteWithLfAndZero() {
    // Arrange
    ByteString data = mock(ByteString.class);
    when(data.size()).thenReturn(0);
    when(data.isEmpty()).thenReturn(false);
    PbftSignCapsule pbftSignCapsule = new PbftSignCapsule(data, new ArrayList<>());

    // Act
    byte[] actualData = pbftSignCapsule.getData();

    // Assert
    verify(data, atLeast(1)).isEmpty();
    verify(data, atLeast(1)).size();
    assertArrayEquals(new byte[] {'\n', 0}, actualData);
  }

  /**
   * Test {@link PbftSignCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link PbftSignCapsule#PbftSignCapsule(byte[])} with data is array of {@code byte}
   *       with {@code A} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link PbftSignCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] PbftSignCapsule.getData()"})
  public void testGetData_givenPbftSignCapsuleWithDataIsArrayOfByteWithAAndX() {
    // Arrange
    PbftSignCapsule pbftSignCapsule =
        new PbftSignCapsule(
            new byte[] {
              'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'
            });

    // Act and Assert
    assertArrayEquals(
        new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'},
        pbftSignCapsule.getData());
  }

  /**
   * Test {@link PbftSignCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link PbftSignCapsule#PbftSignCapsule(byte[])} with data is array of {@code byte}
   *       with {@link Byte#MIN_VALUE} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link PbftSignCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] PbftSignCapsule.getData()"})
  public void testGetData_givenPbftSignCapsuleWithDataIsArrayOfByteWithMin_valueAndMinusOne() {
    // Arrange
    PbftSignCapsule pbftSignCapsule =
        new PbftSignCapsule(
            new byte[] {
              Byte.MIN_VALUE,
              -1,
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              -1,
              'X'
            });

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X', Byte.MIN_VALUE, -1, 'A', 'X'
        },
        pbftSignCapsule.getData());
  }

  /**
   * Test {@link PbftSignCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link PbftSignCapsule#PbftSignCapsule(byte[])} with data is array of {@code byte}
   *       with {@link Byte#MIN_VALUE} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link PbftSignCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] PbftSignCapsule.getData()"})
  public void testGetData_givenPbftSignCapsuleWithDataIsArrayOfByteWithMin_valueAndX() {
    // Arrange
    PbftSignCapsule pbftSignCapsule =
        new PbftSignCapsule(
            new byte[] {
              Byte.MIN_VALUE,
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              -1,
              'X'
            });

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X', Byte.MIN_VALUE, 'X', 'A'
        },
        pbftSignCapsule.getData());
  }

  /**
   * Test {@link PbftSignCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link PbftSignCapsule#PbftSignCapsule(byte[])} with data is array of {@code byte}
   *       with {@code X} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link PbftSignCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] PbftSignCapsule.getData()"})
  public void testGetData_givenPbftSignCapsuleWithDataIsArrayOfByteWithXAndMinusOne() {
    // Arrange
    PbftSignCapsule pbftSignCapsule =
        new PbftSignCapsule(
            new byte[] {
              'X', -1, -1, 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'
            });

    // Act and Assert
    assertArrayEquals(
        new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, -1, 'X', 'X', -1, 'X'},
        pbftSignCapsule.getData());
  }

  /**
   * Test {@link PbftSignCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link PbftSignCapsule#PbftSignCapsule(byte[])} with data is empty array of {@code
   *       byte}.
   * </ul>
   *
   * <p>Method under test: {@link PbftSignCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] PbftSignCapsule.getData()"})
  public void testGetData_givenPbftSignCapsuleWithDataIsEmptyArrayOfByte() {
    // Arrange
    PbftSignCapsule pbftSignCapsule = new PbftSignCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {}, pbftSignCapsule.getData());
  }

  /**
   * Test {@link PbftSignCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code X} and {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link PbftSignCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] PbftSignCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithXAndA() {
    // Arrange
    PbftSignCapsule pbftSignCapsule =
        new PbftSignCapsule(
            new byte[] {
              Byte.MIN_VALUE, -1, -1, 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'
            });

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X', Byte.MIN_VALUE, -1, -1, 'X', 'A'
        },
        pbftSignCapsule.getData());
  }

  /**
   * Test {@link PbftSignCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code X} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link PbftSignCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] PbftSignCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithXAndMinusOne() {
    // Arrange
    PbftSignCapsule pbftSignCapsule =
        new PbftSignCapsule(
            new byte[] {
              'X', -1, -1, -1, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'
            });

    // Act and Assert
    assertArrayEquals(
        new byte[] {'X', -1, -1, -1, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'},
        pbftSignCapsule.getData());
  }

  /**
   * Test {@link PbftSignCapsule#getInstance()}.
   *
   * <p>Method under test: {@link PbftSignCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PBFTCommitResult PbftSignCapsule.getInstance()"})
  public void testGetInstance() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new PbftSignCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link PbftSignCapsule#getPbftCommitResult()}.
   *
   * <p>Method under test: {@link PbftSignCapsule#getPbftCommitResult()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PBFTCommitResult PbftSignCapsule.getPbftCommitResult()"})
  public void testGetPbftCommitResult() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new PbftSignCapsule("AXAXAXAX".getBytes("UTF-8")).getPbftCommitResult());
  }
}
