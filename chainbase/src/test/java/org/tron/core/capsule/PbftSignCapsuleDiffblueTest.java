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
   * <ul>
   *   <li>Given {@link ByteString}.</li>
   *   <li>Then return Instance SignatureList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftSignCapsule#PbftSignCapsule(ByteString, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftSignCapsule.<init>(ByteString, List)"})
  public void testNewPbftSignCapsule_givenByteString_thenReturnInstanceSignatureListSizeIsOne() {
    // Arrange
    ByteString data = mock(ByteString.class);

    ArrayList<ByteString> signList = new ArrayList<>();
    signList.add(mock(ByteString.class));

    // Act
    PbftSignCapsule actualPbftSignCapsule = new PbftSignCapsule(data, signList);

    // Assert
    PBFTCommitResult instance = actualPbftSignCapsule.getInstance();
    assertEquals(1, instance.getSignatureList().size());
    assertEquals(1, instance.getSignatureCount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0}, actualPbftSignCapsule.getData());
  }

  /**
   * Test {@link PbftSignCapsule#PbftSignCapsule(byte[])}.
   * <ul>
   *   <li>Then return Instance InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftSignCapsule.<init>(byte[])"})
  public void testNewPbftSignCapsule_thenReturnInstanceInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule = new PbftSignCapsule(new byte[]{});

    // Assert
    PBFTCommitResult instance = actualPbftSignCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0, instance.getSerializedSize());
    assertEquals(0, instance.getSignatureCount());
    assertTrue(instance.findInitializationErrors().isEmpty());
    assertTrue(instance.getSignatureList().isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    assertTrue(instance.isInitialized());
    assertEquals(instance, instance.getDefaultInstanceForType());
    assertSame(instance, actualPbftSignCapsule.getPbftCommitResult());
    assertArrayEquals(new byte[]{}, actualPbftSignCapsule.getData());
  }

  /**
   * Test {@link PbftSignCapsule#PbftSignCapsule(ByteString, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Instance SignatureCount is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftSignCapsule#PbftSignCapsule(ByteString, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftSignCapsule.<init>(ByteString, List)"})
  public void testNewPbftSignCapsule_whenArrayList_thenReturnInstanceSignatureCountIsZero() {
    // Arrange
    ByteString data = mock(ByteString.class);
    ArrayList<ByteString> signList = new ArrayList<>();

    // Act
    PbftSignCapsule actualPbftSignCapsule = new PbftSignCapsule(data, signList);

    // Assert
    PBFTCommitResult instance = actualPbftSignCapsule.getInstance();
    assertEquals(0, instance.getSignatureCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertTrue(instance.getSignatureList().isEmpty());
    assertEquals(signList, instance.getDescriptorForType().toProto().getReservedNameList());
    assertArrayEquals(new byte[]{'\n', 0}, actualPbftSignCapsule.getData());
  }

  /**
   * Test {@link PbftSignCapsule#PbftSignCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftSignCapsule.<init>(byte[])"})
  public void testNewPbftSignCapsule_whenArrayOfByteWithEighteenAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule = new PbftSignCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualPbftSignCapsule.getInstance());
    assertNull(actualPbftSignCapsule.getPbftCommitResult());
  }

  /**
   * Test {@link PbftSignCapsule#PbftSignCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftSignCapsule.<init>(byte[])"})
  public void testNewPbftSignCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule = new PbftSignCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualPbftSignCapsule.getInstance());
    assertNull(actualPbftSignCapsule.getPbftCommitResult());
  }

  /**
   * Test {@link PbftSignCapsule#PbftSignCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftSignCapsule.<init>(byte[])"})
  public void testNewPbftSignCapsule_whenArrayOfByteWithLfAndZero_thenReturnInstanceIsNull() {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule = new PbftSignCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualPbftSignCapsule.getInstance());
    assertNull(actualPbftSignCapsule.getPbftCommitResult());
  }

  /**
   * Test {@link PbftSignCapsule#PbftSignCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftSignCapsule.<init>(byte[])"})
  public void testNewPbftSignCapsule_whenArrayOfByteWithMinusOneAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule = new PbftSignCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualPbftSignCapsule.getInstance());
    assertNull(actualPbftSignCapsule.getPbftCommitResult());
  }

  /**
   * Test {@link PbftSignCapsule#PbftSignCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftSignCapsule.<init>(byte[])"})
  public void testNewPbftSignCapsule_whenArrayOfByteWithZeroAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule = new PbftSignCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualPbftSignCapsule.getInstance());
    assertNull(actualPbftSignCapsule.getPbftCommitResult());
  }

  /**
   * Test {@link PbftSignCapsule#PbftSignCapsule(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
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
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftSignCapsule.<init>(byte[])"})
  public void testNewPbftSignCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange and Act
    PbftSignCapsule actualPbftSignCapsule = new PbftSignCapsule("\nXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualPbftSignCapsule.getInstance());
    assertNull(actualPbftSignCapsule.getPbftCommitResult());
  }

  /**
   * Test {@link PbftSignCapsule#PbftSignCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftSignCapsule#PbftSignCapsule(byte[])}
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
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftSignCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] PbftSignCapsule.getData()"})
  public void testGetData_givenA_thenReturnArrayOfByteWithAAndX() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        (new PbftSignCapsule(
            new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}))
                .getData());
  }

  /**
   * Test {@link PbftSignCapsule#getData()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftSignCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] PbftSignCapsule.getData()"})
  public void testGetData_givenA_thenReturnArrayOfByteWithAAndX2() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'},
        (new PbftSignCapsule(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', -1, 'X'}))
            .getData());
  }

  /**
   * Test {@link PbftSignCapsule#getData()}.
   * <ul>
   *   <li>Given {@link ByteString} {@link ByteString#isEmpty()} return {@code true}.</li>
   *   <li>Then calls {@link ByteString#isEmpty()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftSignCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] PbftSignCapsule.getData()"})
  public void testGetData_givenByteStringIsEmptyReturnTrue_thenCallsIsEmpty() {
    // Arrange
    ByteString data = mock(ByteString.class);
    when(data.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new PbftSignCapsule(data, new ArrayList<>())).getData();

    // Assert
    verify(data, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{}, actualData);
  }

  /**
   * Test {@link PbftSignCapsule#getData()}.
   * <ul>
   *   <li>Given {@link PbftSignCapsule#PbftSignCapsule(byte[])} with data is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftSignCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] PbftSignCapsule.getData()"})
  public void testGetData_givenPbftSignCapsuleWithDataIsEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new PbftSignCapsule(new byte[]{})).getData());
  }

  /**
   * Test {@link PbftSignCapsule#getData()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAXAAAXAXAXAXXAXAXA} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftSignCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] PbftSignCapsule.getData()"})
  public void testGetData_thenReturnAxaxaxaxaaaxaxaxaxxaxaxaBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualData = (new PbftSignCapsule("AXAXAXAXAXAXAXAAAXAXAXAX".getBytes("UTF-8"))).getData();

    // Assert
    assertArrayEquals("AXAXAXAXAAAXAXAXAXXAXAXA".getBytes("UTF-8"), actualData);
  }

  /**
   * Test {@link PbftSignCapsule#getInstance()}.
   * <p>
   * Method under test: {@link PbftSignCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PBFTCommitResult PbftSignCapsule.getInstance()"})
  public void testGetInstance() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new PbftSignCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link PbftSignCapsule#getPbftCommitResult()}.
   * <p>
   * Method under test: {@link PbftSignCapsule#getPbftCommitResult()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PBFTCommitResult PbftSignCapsule.getPbftCommitResult()"})
  public void testGetPbftCommitResult() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new PbftSignCapsule("AXAXAXAX".getBytes("UTF-8"))).getPbftCommitResult());
  }
}
