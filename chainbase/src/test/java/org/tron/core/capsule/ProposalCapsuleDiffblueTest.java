package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FeatureSet;
import com.google.protobuf.DescriptorProtos.FileOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.UnknownFieldSet;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Proposal;
import org.tron.protos.Protocol.Proposal.State;

public class ProposalCapsuleDiffblueTest {
  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ProposalCapsule("A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ProposalCapsule("2\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ProposalCapsule("\n\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule4() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ProposalCapsule("A\bA\bA\bA\bA\bA\bA\bA ".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule5() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ProposalCapsule("A\bA\bA\bA\bA\bA\bA\bA(".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule6() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ProposalCapsule("A\bA\bA\bA\bA\bA\bA\bA8".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code 2XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_when2xaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ProposalCapsule("2XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code 8XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_when8xaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ProposalCapsule("8XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code 2} and zero.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenArrayOfByteWith2AndZero_thenReturnInstanceIsNull() {
    // Arrange and Act
    ProposalCapsule actualProposalCapsule =
        new ProposalCapsule(new byte[] {'2', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualProposalCapsule.getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and backspace.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenArrayOfByteWithAAndBackspace_thenReturnInstanceIsNull() {
    // Arrange and Act
    ProposalCapsule actualProposalCapsule =
        new ProposalCapsule(
            new byte[] {
              'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', 26
            });

    // Assert
    assertNull(actualProposalCapsule.getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and backspace.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenArrayOfByteWithAAndBackspace_thenReturnInstanceIsNull2() {
    // Arrange and Act
    ProposalCapsule actualProposalCapsule =
        new ProposalCapsule(
            new byte[] {
              'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', -1
            });

    // Assert
    assertNull(actualProposalCapsule.getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and backspace.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenArrayOfByteWithEighteenAndBackspace() {
    // Arrange and Act
    ProposalCapsule actualProposalCapsule =
        new ProposalCapsule(
            new byte[] {
              18, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b'
            });

    // Assert
    assertNull(actualProposalCapsule.getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenArrayOfByteWithEighteenAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    ProposalCapsule actualProposalCapsule =
        new ProposalCapsule(new byte[] {18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualProposalCapsule.getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange and Act
    ProposalCapsule actualProposalCapsule =
        new ProposalCapsule(new byte[] {18, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualProposalCapsule.getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenArrayOfByteWithMinusOneAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    ProposalCapsule actualProposalCapsule =
        new ProposalCapsule(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualProposalCapsule.getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-seven and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenArrayOfByteWithTwentySevenAndX() {
    // Arrange and Act
    ProposalCapsule actualProposalCapsule =
        new ProposalCapsule(new byte[] {27, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualProposalCapsule.getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and backspace.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenArrayOfByteWithTwentySixAndBackspace() {
    // Arrange and Act
    ProposalCapsule actualProposalCapsule =
        new ProposalCapsule(
            new byte[] {
              26, '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b'
            });

    // Assert
    assertNull(actualProposalCapsule.getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenArrayOfByteWithTwentySixAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    ProposalCapsule actualProposalCapsule =
        new ProposalCapsule(new byte[] {26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualProposalCapsule.getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and zero.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenArrayOfByteWithTwentySixAndZero() {
    // Arrange and Act
    ProposalCapsule actualProposalCapsule =
        new ProposalCapsule(new byte[] {26, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualProposalCapsule.getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenArrayOfByteWithZeroAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    ProposalCapsule actualProposalCapsule =
        new ProposalCapsule(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualProposalCapsule.getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ProposalCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(ByteString, long)}.
   *
   * <ul>
   *   <li>When {@link ByteString}.
   *   <li>Then return ID is one.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(ByteString, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(ByteString, long)"})
  public void testNewProposalCapsule_whenByteString_thenReturnIdIsOne() {
    // Arrange and Act
    ProposalCapsule actualProposalCapsule = new ProposalCapsule(mock(ByteString.class), 1L);

    // Assert
    assertEquals(1L, actualProposalCapsule.getID());
    Proposal instance = actualProposalCapsule.getInstance();
    assertEquals(1L, instance.getProposalId());
    UnknownFieldSet unknownFields = instance.getUnknownFields();
    Proposal defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertArrayEquals(new byte[] {'\b', 1, 18, 0}, actualProposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return CreateTime is zero.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenEmptyArrayOfByte_thenReturnCreateTimeIsZero() {
    // Arrange and Act
    ProposalCapsule actualProposalCapsule = new ProposalCapsule(new byte[] {});

    // Assert
    assertEquals(0L, actualProposalCapsule.getCreateTime());
    assertEquals(0L, actualProposalCapsule.getExpirationTime());
    assertEquals(0L, actualProposalCapsule.getID());
    assertEquals(State.PENDING, actualProposalCapsule.getState());
    assertFalse(actualProposalCapsule.hasCanceled());
    assertFalse(actualProposalCapsule.hasProcessed());
    assertTrue(actualProposalCapsule.getApprovals().isEmpty());
    assertTrue(actualProposalCapsule.getParameters().isEmpty());
    assertArrayEquals(new byte[] {}, actualProposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(ByteString, long)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return ID is two.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(ByteString, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(ByteString, long)"})
  public void testNewProposalCapsule_whenTwo_thenReturnIdIsTwo() {
    // Arrange and Act
    ProposalCapsule actualProposalCapsule = new ProposalCapsule(mock(ByteString.class), 2L);

    // Assert
    assertEquals(2L, actualProposalCapsule.getID());
    Proposal instance = actualProposalCapsule.getInstance();
    assertEquals(2L, instance.getProposalId());
    UnknownFieldSet unknownFields = instance.getUnknownFields();
    Proposal defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertArrayEquals(new byte[] {'\b', 2, 18, 0}, actualProposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ProposalCapsule(" XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code (XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ProposalCapsule("(XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#ProposalCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#ProposalCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.<init>(byte[])"})
  public void testNewProposalCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ProposalCapsule("XXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link ProposalCapsule#calculateDbKey(long)}.
   *
   * <p>Method under test: {@link ProposalCapsule#calculateDbKey(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ProposalCapsule.calculateDbKey(long)"})
  public void testCalculateDbKey() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {0, 0, 0, 0, 0, 0, 0, 1}, ProposalCapsule.calculateDbKey(1L));
  }

  /**
   * Test {@link ProposalCapsule#getID()}.
   *
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(byte[])} with data is empty array of {@code
   *       byte}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#getID()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ProposalCapsule.getID()"})
  public void testGetID_givenProposalCapsuleWithDataIsEmptyArrayOfByte_thenReturnZero() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});

    // Act and Assert
    assertEquals(0L, proposalCapsule.getID());
  }

  /**
   * Test {@link ProposalCapsule#setID(long)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setID(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setID(long)"})
  public void testSetID() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});

    // Act
    proposalCapsule.setID(1L);

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1L, proposalCapsule.getID());
    assertEquals(1L, instance.getProposalId());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setID(long)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setID(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setID(long)"})
  public void testSetID2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.setID(1L);

    // Assert
    assertEquals(1L, proposalCapsule.getID());
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(1L, instance.getProposalId());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, '2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setID(long)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setID(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setID(long)"})
  public void testSetID3() {
    // Arrange
    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(1L, 1L);

    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setParameters(parameters);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.setID(1L);

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(10, instance.getSerializedSize());
    assertEquals(1L, proposalCapsule.getID());
    assertEquals(1L, instance.getProposalId());
    assertEquals(3, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {'\b', 1, 26, 4, '\b', 1, 16, 1, '2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setID(long)}.
   *
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(byte[])} with data is empty array of {@code
   *       byte} CreateTime is ten.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#setID(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setID(long)"})
  public void testSetID_givenProposalCapsuleWithDataIsEmptyArrayOfByteCreateTimeIsTen() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setCreateTime(10L);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.setID(1L);

    // Assert
    assertEquals(1L, proposalCapsule.getID());
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(1L, instance.getProposalId());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, '(', '\n', '2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setID(long)}.
   *
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(byte[])} with data is empty array of {@code
   *       byte} ExpirationTime is ten.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#setID(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setID(long)"})
  public void testSetID_givenProposalCapsuleWithDataIsEmptyArrayOfByteExpirationTimeIsTen() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setExpirationTime(10L);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.setID(1L);

    // Assert
    assertEquals(1L, proposalCapsule.getID());
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(1L, instance.getProposalId());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, ' ', '\n', '2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setID(long)}.
   *
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(byte[])} with data is empty array of {@code
   *       byte} State is {@code DISAPPROVED}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#setID(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setID(long)"})
  public void testSetID_givenProposalCapsuleWithDataIsEmptyArrayOfByteStateIsDisapproved() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setState(State.DISAPPROVED);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.setID(1L);

    // Assert
    assertEquals(1L, proposalCapsule.getID());
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(1L, instance.getProposalId());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, '2', 0, '8', 1}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#getProposalAddress()}.
   *
   * <p>Method under test: {@link ProposalCapsule#getProposalAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString ProposalCapsule.getProposalAddress()"})
  public void testGetProposalAddress() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});

    // Act
    ByteString actualProposalAddress = proposalCapsule.getProposalAddress();

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    Descriptor descriptorForType = instance.getDescriptorForType();
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(7, fields.size());
    ByteString byteString = ByteString.EMPTY;
    assertEquals(
        byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertSame(byteString, fields.get(1).getDefaultValue());
    assertSame(byteString, actualProposalAddress);
    assertSame(byteString, instance.getProposerAddress());
    assertSame(byteString, instance.getDefaultInstanceForType().getProposerAddress());
  }

  /**
   * Test {@link ProposalCapsule#setProposalAddress(ByteString)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setProposalAddress(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setProposalAddress(ByteString)"})
  public void testSetProposalAddress() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    ByteString address = mock(ByteString.class);

    // Act
    proposalCapsule.setProposalAddress(address);

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    ByteString proposerAddress = instance.getDefaultInstanceForType().getProposerAddress();
    assertEquals("", proposerAddress.toStringUtf8());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertFalse(proposerAddress.iterator().hasNext());
    assertTrue(proposerAddress.isEmpty());
    assertSame(address, proposalCapsule.getProposalAddress());
    assertSame(address, instance.getProposerAddress());
    assertArrayEquals(new byte[] {18, 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setProposalAddress(ByteString)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setProposalAddress(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setProposalAddress(ByteString)"})
  public void testSetProposalAddress2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.addApproval(mock(ByteString.class));
    ByteString address = mock(ByteString.class);

    // Act
    proposalCapsule.setProposalAddress(address);

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    ByteString proposerAddress = instance.getDefaultInstanceForType().getProposerAddress();
    assertEquals("", proposerAddress.toStringUtf8());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertFalse(proposerAddress.iterator().hasNext());
    assertTrue(proposerAddress.isEmpty());
    assertSame(address, proposalCapsule.getProposalAddress());
    assertSame(address, instance.getProposerAddress());
    assertArrayEquals(new byte[] {18, 0, '2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setProposalAddress(ByteString)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setProposalAddress(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setProposalAddress(ByteString)"})
  public void testSetProposalAddress3() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setID(1L);
    proposalCapsule.addApproval(mock(ByteString.class));
    ByteString address = mock(ByteString.class);

    // Act
    proposalCapsule.setProposalAddress(address);

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    ByteString proposerAddress = instance.getDefaultInstanceForType().getProposerAddress();
    assertEquals("", proposerAddress.toStringUtf8());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertFalse(proposerAddress.iterator().hasNext());
    assertTrue(proposerAddress.isEmpty());
    assertSame(address, proposalCapsule.getProposalAddress());
    assertSame(address, instance.getProposerAddress());
    assertArrayEquals(new byte[] {'\b', 1, 18, 0, '2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setProposalAddress(ByteString)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setProposalAddress(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setProposalAddress(ByteString)"})
  public void testSetProposalAddress4() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setExpirationTime(10L);
    proposalCapsule.addApproval(mock(ByteString.class));
    ByteString address = mock(ByteString.class);

    // Act
    proposalCapsule.setProposalAddress(address);

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    ByteString proposerAddress = instance.getDefaultInstanceForType().getProposerAddress();
    assertEquals("", proposerAddress.toStringUtf8());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertFalse(proposerAddress.iterator().hasNext());
    assertTrue(proposerAddress.isEmpty());
    assertSame(address, proposalCapsule.getProposalAddress());
    assertSame(address, instance.getProposerAddress());
    assertArrayEquals(new byte[] {18, 0, ' ', '\n', '2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setProposalAddress(ByteString)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setProposalAddress(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setProposalAddress(ByteString)"})
  public void testSetProposalAddress5() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setCreateTime(10L);
    proposalCapsule.addApproval(mock(ByteString.class));
    ByteString address = mock(ByteString.class);

    // Act
    proposalCapsule.setProposalAddress(address);

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    ByteString proposerAddress = instance.getDefaultInstanceForType().getProposerAddress();
    assertEquals("", proposerAddress.toStringUtf8());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertFalse(proposerAddress.iterator().hasNext());
    assertTrue(proposerAddress.isEmpty());
    assertSame(address, proposalCapsule.getProposalAddress());
    assertSame(address, instance.getProposerAddress());
    assertArrayEquals(new byte[] {18, 0, '(', '\n', '2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#getParameters()}.
   *
   * <p>Method under test: {@link ProposalCapsule#getParameters()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ProposalCapsule.getParameters()"})
  public void testGetParameters() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act and Assert
    assertTrue(proposalCapsule.getParameters().isEmpty());
  }

  /**
   * Test {@link ProposalCapsule#getParameters()}.
   *
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(byte[])} with data is empty array of {@code
   *       byte}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#getParameters()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ProposalCapsule.getParameters()"})
  public void testGetParameters_givenProposalCapsuleWithDataIsEmptyArrayOfByte_thenReturnEmpty() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});

    // Act and Assert
    assertTrue(proposalCapsule.getParameters().isEmpty());
  }

  /**
   * Test {@link ProposalCapsule#setParameters(Map)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setParameters(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setParameters(Map)"})
  public void testSetParameters() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    HashMap<Long, Long> parameters = new HashMap<>();

    // Act
    proposalCapsule.setParameters(parameters);

    // Assert that nothing has changed
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getParametersCount());
    assertEquals(0, instance.getSerializedSize());
    assertTrue(instance.getAllFields().isEmpty());
    assertTrue(proposalCapsule.getParameters().isEmpty());
    assertTrue(instance.getParameters().isEmpty());
    assertTrue(instance.getParametersMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(
        parameters, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(parameters, features.getAllFields());
    assertEquals(parameters, features.getAllFieldsRaw());
    assertArrayEquals(new byte[] {}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setParameters(Map)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setParameters(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setParameters(Map)"})
  public void testSetParameters2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.addApproval(mock(ByteString.class));
    HashMap<Long, Long> parameters = new HashMap<>();

    // Act
    proposalCapsule.setParameters(parameters);

    // Assert that nothing has changed
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getParametersCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertTrue(proposalCapsule.getParameters().isEmpty());
    assertTrue(instance.getParameters().isEmpty());
    assertTrue(instance.getParametersMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(
        parameters, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(parameters, features.getAllFields());
    assertEquals(parameters, features.getAllFieldsRaw());
    assertArrayEquals(new byte[] {'2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setParameters(Map)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setParameters(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setParameters(Map)"})
  public void testSetParameters3() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setID(1L);
    proposalCapsule.addApproval(mock(ByteString.class));
    HashMap<Long, Long> parameters = new HashMap<>();

    // Act
    proposalCapsule.setParameters(parameters);

    // Assert that nothing has changed
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getParametersCount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertTrue(proposalCapsule.getParameters().isEmpty());
    assertTrue(instance.getParameters().isEmpty());
    assertTrue(instance.getParametersMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(
        parameters, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(parameters, features.getAllFields());
    assertEquals(parameters, features.getAllFieldsRaw());
    assertArrayEquals(new byte[] {'\b', 1, '2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setParameters(Map)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setParameters(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setParameters(Map)"})
  public void testSetParameters4() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setExpirationTime(10L);
    proposalCapsule.addApproval(mock(ByteString.class));
    HashMap<Long, Long> parameters = new HashMap<>();

    // Act
    proposalCapsule.setParameters(parameters);

    // Assert that nothing has changed
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getParametersCount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertTrue(proposalCapsule.getParameters().isEmpty());
    assertTrue(instance.getParameters().isEmpty());
    assertTrue(instance.getParametersMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(
        parameters, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(parameters, features.getAllFields());
    assertEquals(parameters, features.getAllFieldsRaw());
    assertArrayEquals(new byte[] {' ', '\n', '2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setParameters(Map)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setParameters(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setParameters(Map)"})
  public void testSetParameters5() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setCreateTime(10L);
    proposalCapsule.addApproval(mock(ByteString.class));
    HashMap<Long, Long> parameters = new HashMap<>();

    // Act
    proposalCapsule.setParameters(parameters);

    // Assert that nothing has changed
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getParametersCount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertTrue(proposalCapsule.getParameters().isEmpty());
    assertTrue(instance.getParameters().isEmpty());
    assertTrue(instance.getParametersMap().isEmpty());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(
        parameters, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(parameters, features.getAllFields());
    assertEquals(parameters, features.getAllFieldsRaw());
    assertArrayEquals(new byte[] {'(', '\n', '2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setParameters(Map)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setParameters(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setParameters(Map)"})
  public void testSetParameters6() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});

    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(-1L, -1L);

    // Act
    proposalCapsule.setParameters(parameters);

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(1, instance.getParametersCount());
    assertEquals(24, instance.getSerializedSize());
    assertEquals(parameters, proposalCapsule.getParameters());
    assertEquals(parameters, instance.getParameters());
    assertEquals(parameters, instance.getParametersMap());
    assertArrayEquals(
        new byte[] {
          26, 22, '\b', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 16, -1, -1, -1, -1, -1, -1, -1, -1,
          -1, 1
        },
        proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#getExpirationTime()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#getExpirationTime()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ProposalCapsule.getExpirationTime()"})
  public void testGetExpirationTime_thenReturnZero() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});

    // Act and Assert
    assertEquals(0L, proposalCapsule.getExpirationTime());
  }

  /**
   * Test {@link ProposalCapsule#setExpirationTime(long)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setExpirationTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setExpirationTime(long)"})
  public void testSetExpirationTime() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});

    // Act
    proposalCapsule.setExpirationTime(10L);

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, proposalCapsule.getExpirationTime());
    assertEquals(10L, instance.getExpirationTime());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {' ', '\n'}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setExpirationTime(long)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setExpirationTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setExpirationTime(long)"})
  public void testSetExpirationTime2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.setExpirationTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getExpirationTime());
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getExpirationTime());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {' ', '\n', '2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setExpirationTime(long)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setExpirationTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setExpirationTime(long)"})
  public void testSetExpirationTime3() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setID(1L);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.setExpirationTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getExpirationTime());
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getExpirationTime());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, ' ', '\n', '2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setExpirationTime(long)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setExpirationTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setExpirationTime(long)"})
  public void testSetExpirationTime4() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setCreateTime(10L);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.setExpirationTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getExpirationTime());
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getExpirationTime());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {' ', '\n', '(', '\n', '2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setExpirationTime(long)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setExpirationTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setExpirationTime(long)"})
  public void testSetExpirationTime5() {
    // Arrange
    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(1L, 1L);

    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setParameters(parameters);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.setExpirationTime(10L);

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(10, instance.getSerializedSize());
    assertEquals(10L, proposalCapsule.getExpirationTime());
    assertEquals(10L, instance.getExpirationTime());
    assertEquals(3, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {26, 4, '\b', 1, 16, 1, ' ', '\n', '2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setExpirationTime(long)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setExpirationTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setExpirationTime(long)"})
  public void testSetExpirationTime6() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setState(State.DISAPPROVED);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.setExpirationTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getExpirationTime());
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getExpirationTime());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {' ', '\n', '2', 0, '8', 1}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#getCreateTime()}.
   *
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(byte[])} with data is empty array of {@code
   *       byte}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#getCreateTime()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long ProposalCapsule.getCreateTime()"})
  public void testGetCreateTime_givenProposalCapsuleWithDataIsEmptyArrayOfByte_thenReturnZero() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});

    // Act and Assert
    assertEquals(0L, proposalCapsule.getCreateTime());
  }

  /**
   * Test {@link ProposalCapsule#setCreateTime(long)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setCreateTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setCreateTime(long)"})
  public void testSetCreateTime() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});

    // Act
    proposalCapsule.setCreateTime(10L);

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(10L, proposalCapsule.getCreateTime());
    assertEquals(10L, instance.getCreateTime());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'(', '\n'}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setCreateTime(long)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setCreateTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setCreateTime(long)"})
  public void testSetCreateTime2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.setCreateTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getCreateTime());
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getCreateTime());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'(', '\n', '2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setCreateTime(long)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setCreateTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setCreateTime(long)"})
  public void testSetCreateTime3() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setID(1L);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.setCreateTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getCreateTime());
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getCreateTime());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'\b', 1, '(', '\n', '2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setCreateTime(long)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setCreateTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setCreateTime(long)"})
  public void testSetCreateTime4() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setExpirationTime(10L);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.setCreateTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getCreateTime());
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getCreateTime());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {' ', '\n', '(', '\n', '2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setCreateTime(long)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setCreateTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setCreateTime(long)"})
  public void testSetCreateTime5() {
    // Arrange
    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(1L, 1L);

    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setParameters(parameters);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.setCreateTime(10L);

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(10, instance.getSerializedSize());
    assertEquals(10L, proposalCapsule.getCreateTime());
    assertEquals(10L, instance.getCreateTime());
    assertEquals(3, instance.getAllFields().size());
    assertArrayEquals(
        new byte[] {26, 4, '\b', 1, 16, 1, '(', '\n', '2', 0}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#setCreateTime(long)}.
   *
   * <p>Method under test: {@link ProposalCapsule#setCreateTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.setCreateTime(long)"})
  public void testSetCreateTime6() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setState(State.DISAPPROVED);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.setCreateTime(10L);

    // Assert
    assertEquals(10L, proposalCapsule.getCreateTime());
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(10L, instance.getCreateTime());
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[] {'(', '\n', '2', 0, '8', 1}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#getApprovals()}.
   *
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(byte[])} with data is empty array of {@code
   *       byte}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#getApprovals()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ProposalCapsule.getApprovals()"})
  public void testGetApprovals_givenProposalCapsuleWithDataIsEmptyArrayOfByte_thenReturnEmpty() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});

    // Act and Assert
    assertTrue(proposalCapsule.getApprovals().isEmpty());
  }

  /**
   * Test {@link ProposalCapsule#removeApproval(ByteString)}.
   *
   * <p>Method under test: {@link ProposalCapsule#removeApproval(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.removeApproval(ByteString)"})
  public void testRemoveApproval() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.removeApproval(null);

    // Assert that nothing has changed
    assertTrue(
        proposalCapsule.getInstance().getDefaultInstanceForType().getApprovalsList().isEmpty());
  }

  /**
   * Test {@link ProposalCapsule#removeApproval(ByteString)}.
   *
   * <p>Method under test: {@link ProposalCapsule#removeApproval(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.removeApproval(ByteString)"})
  public void testRemoveApproval2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setExpirationTime(10L);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.removeApproval(null);

    // Assert that nothing has changed
    assertTrue(
        proposalCapsule.getInstance().getDefaultInstanceForType().getApprovalsList().isEmpty());
  }

  /**
   * Test {@link ProposalCapsule#removeApproval(ByteString)}.
   *
   * <p>Method under test: {@link ProposalCapsule#removeApproval(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.removeApproval(ByteString)"})
  public void testRemoveApproval3() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setState(State.DISAPPROVED);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.removeApproval(null);

    // Assert that nothing has changed
    assertTrue(
        proposalCapsule.getInstance().getDefaultInstanceForType().getApprovalsList().isEmpty());
  }

  /**
   * Test {@link ProposalCapsule#removeApproval(ByteString)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} one is one.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#removeApproval(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.removeApproval(ByteString)"})
  public void testRemoveApproval_givenHashMapOneIsOne() {
    // Arrange
    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(1L, 1L);

    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setParameters(parameters);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.removeApproval(null);

    // Assert that nothing has changed
    assertTrue(
        proposalCapsule.getInstance().getDefaultInstanceForType().getApprovalsList().isEmpty());
  }

  /**
   * Test {@link ProposalCapsule#removeApproval(ByteString)}.
   *
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(byte[])} with data is empty array of {@code
   *       byte}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#removeApproval(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.removeApproval(ByteString)"})
  public void testRemoveApproval_givenProposalCapsuleWithDataIsEmptyArrayOfByte() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});

    // Act
    proposalCapsule.removeApproval(null);

    // Assert
    assertTrue(
        proposalCapsule.getInstance().getDefaultInstanceForType().getApprovalsList().isEmpty());
  }

  /**
   * Test {@link ProposalCapsule#removeApproval(ByteString)}.
   *
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(byte[])} with data is empty array of {@code
   *       byte} CreateTime is ten.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#removeApproval(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.removeApproval(ByteString)"})
  public void testRemoveApproval_givenProposalCapsuleWithDataIsEmptyArrayOfByteCreateTimeIsTen() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setCreateTime(10L);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.removeApproval(null);

    // Assert that nothing has changed
    assertTrue(
        proposalCapsule.getInstance().getDefaultInstanceForType().getApprovalsList().isEmpty());
  }

  /**
   * Test {@link ProposalCapsule#removeApproval(ByteString)}.
   *
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(byte[])} with data is empty array of {@code
   *       byte} ID is one.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#removeApproval(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.removeApproval(ByteString)"})
  public void testRemoveApproval_givenProposalCapsuleWithDataIsEmptyArrayOfByteIdIsOne() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setID(1L);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.removeApproval(null);

    // Assert that nothing has changed
    assertTrue(
        proposalCapsule.getInstance().getDefaultInstanceForType().getApprovalsList().isEmpty());
  }

  /**
   * Test {@link ProposalCapsule#clearApproval()}.
   *
   * <p>Method under test: {@link ProposalCapsule#clearApproval()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.clearApproval()"})
  public void testClearApproval() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.clearApproval();

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getSerializedSize());
    assertTrue(instance.getAllFields().isEmpty());
    Proposal actualDefaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(instance, actualDefaultInstanceForType);
    assertArrayEquals(new byte[] {}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#clearApproval()}.
   *
   * <p>Method under test: {@link ProposalCapsule#clearApproval()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.clearApproval()"})
  public void testClearApproval2() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setID(1L);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.clearApproval();

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getApprovalsCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertTrue(instance.getDescriptorForType().toProto().getReservedNameList().isEmpty());
    List<ByteString> approvals = proposalCapsule.getApprovals();
    assertTrue(approvals.isEmpty());
    assertSame(approvals, instance.getDefaultInstanceForType().getApprovalsList());
    assertArrayEquals(new byte[] {'\b', 1}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#clearApproval()}.
   *
   * <p>Method under test: {@link ProposalCapsule#clearApproval()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.clearApproval()"})
  public void testClearApproval3() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setExpirationTime(10L);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.clearApproval();

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getApprovalsCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertTrue(instance.getDescriptorForType().toProto().getReservedNameList().isEmpty());
    List<ByteString> approvals = proposalCapsule.getApprovals();
    assertTrue(approvals.isEmpty());
    assertSame(approvals, instance.getDefaultInstanceForType().getApprovalsList());
    assertArrayEquals(new byte[] {' ', '\n'}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#clearApproval()}.
   *
   * <p>Method under test: {@link ProposalCapsule#clearApproval()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.clearApproval()"})
  public void testClearApproval4() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setCreateTime(10L);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.clearApproval();

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getApprovalsCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertTrue(instance.getDescriptorForType().toProto().getReservedNameList().isEmpty());
    List<ByteString> approvals = proposalCapsule.getApprovals();
    assertTrue(approvals.isEmpty());
    assertSame(approvals, instance.getDefaultInstanceForType().getApprovalsList());
    assertArrayEquals(new byte[] {'(', '\n'}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#clearApproval()}.
   *
   * <p>Method under test: {@link ProposalCapsule#clearApproval()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.clearApproval()"})
  public void testClearApproval5() {
    // Arrange
    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(1L, 1L);

    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setParameters(parameters);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.clearApproval();

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getApprovalsCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertTrue(instance.getDescriptorForType().toProto().getReservedNameList().isEmpty());
    List<ByteString> approvals = proposalCapsule.getApprovals();
    assertTrue(approvals.isEmpty());
    assertSame(approvals, instance.getDefaultInstanceForType().getApprovalsList());
    assertArrayEquals(new byte[] {26, 4, '\b', 1, 16, 1}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#clearApproval()}.
   *
   * <p>Method under test: {@link ProposalCapsule#clearApproval()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.clearApproval()"})
  public void testClearApproval6() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setState(State.DISAPPROVED);
    proposalCapsule.addApproval(mock(ByteString.class));

    // Act
    proposalCapsule.clearApproval();

    // Assert
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getApprovalsCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertTrue(instance.getDescriptorForType().toProto().getReservedNameList().isEmpty());
    List<ByteString> approvals = proposalCapsule.getApprovals();
    assertTrue(approvals.isEmpty());
    assertSame(approvals, instance.getDefaultInstanceForType().getApprovalsList());
    assertArrayEquals(new byte[] {'8', 1}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#clearApproval()}.
   *
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(byte[])} with data is empty array of {@code
   *       byte}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#clearApproval()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProposalCapsule.clearApproval()"})
  public void testClearApproval_givenProposalCapsuleWithDataIsEmptyArrayOfByte() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});

    // Act
    proposalCapsule.clearApproval();

    // Assert that nothing has changed
    Proposal instance = proposalCapsule.getInstance();
    assertEquals(0, instance.getApprovalsCount());
    assertEquals(0, instance.getSerializedSize());
    assertTrue(instance.getDescriptorForType().toProto().getReservedNameList().isEmpty());
    List<ByteString> approvals = proposalCapsule.getApprovals();
    assertTrue(approvals.isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    assertSame(approvals, instance.getDefaultInstanceForType().getApprovalsList());
    assertArrayEquals(new byte[] {}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#getState()}.
   *
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(byte[])} with data is empty array of {@code
   *       byte}.
   *   <li>Then return {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#getState()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"State ProposalCapsule.getState()"})
  public void testGetState_givenProposalCapsuleWithDataIsEmptyArrayOfByte_thenReturnPending() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});

    // Act and Assert
    assertEquals(State.PENDING, proposalCapsule.getState());
  }

  /**
   * Test {@link ProposalCapsule#getState()}.
   *
   * <ul>
   *   <li>Then return {@code APPROVED}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#getState()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"State ProposalCapsule.getState()"})
  public void testGetState_thenReturnApproved() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setState(State.APPROVED);

    // Act and Assert
    assertEquals(State.APPROVED, proposalCapsule.getState());
  }

  /**
   * Test {@link ProposalCapsule#getState()}.
   *
   * <ul>
   *   <li>Then return {@code CANCELED}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#getState()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"State ProposalCapsule.getState()"})
  public void testGetState_thenReturnCanceled() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setState(State.CANCELED);

    // Act and Assert
    assertEquals(State.CANCELED, proposalCapsule.getState());
  }

  /**
   * Test {@link ProposalCapsule#getState()}.
   *
   * <ul>
   *   <li>Then return {@code DISAPPROVED}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#getState()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"State ProposalCapsule.getState()"})
  public void testGetState_thenReturnDisapproved() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setState(State.DISAPPROVED);

    // Act and Assert
    assertEquals(State.DISAPPROVED, proposalCapsule.getState());
  }

  /**
   * Test {@link ProposalCapsule#hasProcessed()}.
   *
   * <p>Method under test: {@link ProposalCapsule#hasProcessed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProposalCapsule.hasProcessed()"})
  public void testHasProcessed() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setState(State.DISAPPROVED);

    // Act and Assert
    assertTrue(proposalCapsule.hasProcessed());
  }

  /**
   * Test {@link ProposalCapsule#hasProcessed()}.
   *
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(byte[])} with data is empty array of {@code
   *       byte} State is {@code APPROVED}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#hasProcessed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProposalCapsule.hasProcessed()"})
  public void testHasProcessed_givenProposalCapsuleWithDataIsEmptyArrayOfByteStateIsApproved() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setState(State.APPROVED);

    // Act and Assert
    assertTrue(proposalCapsule.hasProcessed());
  }

  /**
   * Test {@link ProposalCapsule#hasProcessed()}.
   *
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(byte[])} with data is empty array of {@code
   *       byte} State is {@code CANCELED}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#hasProcessed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProposalCapsule.hasProcessed()"})
  public void testHasProcessed_givenProposalCapsuleWithDataIsEmptyArrayOfByteStateIsCanceled() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setState(State.CANCELED);

    // Act and Assert
    assertFalse(proposalCapsule.hasProcessed());
  }

  /**
   * Test {@link ProposalCapsule#hasProcessed()}.
   *
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(byte[])} with data is empty array of {@code
   *       byte}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#hasProcessed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProposalCapsule.hasProcessed()"})
  public void testHasProcessed_givenProposalCapsuleWithDataIsEmptyArrayOfByte_thenReturnFalse() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});

    // Act and Assert
    assertFalse(proposalCapsule.hasProcessed());
  }

  /**
   * Test {@link ProposalCapsule#hasCanceled()}.
   *
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(byte[])} with data is empty array of {@code
   *       byte} State is {@code APPROVED}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#hasCanceled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProposalCapsule.hasCanceled()"})
  public void testHasCanceled_givenProposalCapsuleWithDataIsEmptyArrayOfByteStateIsApproved() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setState(State.APPROVED);

    // Act and Assert
    assertFalse(proposalCapsule.hasCanceled());
  }

  /**
   * Test {@link ProposalCapsule#hasCanceled()}.
   *
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(byte[])} with data is empty array of {@code
   *       byte} State is {@code DISAPPROVED}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#hasCanceled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProposalCapsule.hasCanceled()"})
  public void testHasCanceled_givenProposalCapsuleWithDataIsEmptyArrayOfByteStateIsDisapproved() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setState(State.DISAPPROVED);

    // Act and Assert
    assertFalse(proposalCapsule.hasCanceled());
  }

  /**
   * Test {@link ProposalCapsule#hasCanceled()}.
   *
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(byte[])} with data is empty array of {@code
   *       byte}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#hasCanceled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProposalCapsule.hasCanceled()"})
  public void testHasCanceled_givenProposalCapsuleWithDataIsEmptyArrayOfByte_thenReturnFalse() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});

    // Act and Assert
    assertFalse(proposalCapsule.hasCanceled());
  }

  /**
   * Test {@link ProposalCapsule#hasCanceled()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#hasCanceled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProposalCapsule.hasCanceled()"})
  public void testHasCanceled_thenReturnTrue() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setState(State.CANCELED);

    // Act and Assert
    assertTrue(proposalCapsule.hasCanceled());
  }

  /**
   * Test {@link ProposalCapsule#hasExpired(long)}.
   *
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(byte[])} with data is empty array of {@code
   *       byte}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#hasExpired(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProposalCapsule.hasExpired(long)"})
  public void testHasExpired_givenProposalCapsuleWithDataIsEmptyArrayOfByte_thenReturnTrue() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});

    // Act and Assert
    assertTrue(proposalCapsule.hasExpired(10L));
  }

  /**
   * Test {@link ProposalCapsule#hasExpired(long)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#hasExpired(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProposalCapsule.hasExpired(long)"})
  public void testHasExpired_whenMinusOne_thenReturnFalse() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});

    // Act and Assert
    assertFalse(proposalCapsule.hasExpired(-1L));
  }

  /**
   * Test {@link ProposalCapsule#createDbKey()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#createDbKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ProposalCapsule.createDbKey()"})
  public void testCreateDbKey_thenReturnArrayOfByteWithZeroAndZero() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {0, 0, 0, 0, 0, 0, 0, 0}, proposalCapsule.createDbKey());
  }

  /**
   * Test {@link ProposalCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link ByteString} {@link ByteString#size()} return zero.
   *   <li>Then return array of {@code byte} with {@code 2} and zero.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ProposalCapsule.getData()"})
  public void testGetData_givenByteStringSizeReturnZero_thenReturnArrayOfByteWith2AndZero() {
    // Arrange
    ByteString committeeAddress = mock(ByteString.class);
    when(committeeAddress.size()).thenReturn(0);

    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.addApproval(committeeAddress);

    // Act
    byte[] actualData = proposalCapsule.getData();

    // Assert
    verify(committeeAddress, atLeast(1)).size();
    assertArrayEquals(new byte[] {'2', 0}, actualData);
  }

  /**
   * Test {@link ProposalCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} one is one.
   *   <li>Then return array of {@code byte} with twenty-six and four.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ProposalCapsule.getData()"})
  public void testGetData_givenHashMapOneIsOne_thenReturnArrayOfByteWithTwentySixAndFour() {
    // Arrange
    ByteString committeeAddress = mock(ByteString.class);
    when(committeeAddress.size()).thenReturn(0);

    HashMap<Long, Long> parameters = new HashMap<>();
    parameters.put(1L, 1L);

    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setParameters(parameters);
    proposalCapsule.addApproval(committeeAddress);

    // Act
    byte[] actualData = proposalCapsule.getData();

    // Assert
    verify(committeeAddress, atLeast(1)).size();
    assertArrayEquals(new byte[] {26, 4, '\b', 1, 16, 1, '2', 0}, actualData);
  }

  /**
   * Test {@link ProposalCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code 2} and zero.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ProposalCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWith2AndZero() {
    // Arrange
    ByteString committeeAddress = mock(ByteString.class);
    when(committeeAddress.size()).thenReturn(0);

    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setState(State.DISAPPROVED);
    proposalCapsule.addApproval(committeeAddress);

    // Act
    byte[] actualData = proposalCapsule.getData();

    // Assert
    verify(committeeAddress, atLeast(1)).size();
    assertArrayEquals(new byte[] {'2', 0, '8', 1}, actualData);
  }

  /**
   * Test {@link ProposalCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with backspace and minus one.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ProposalCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithBackspaceAndMinusOne() {
    // Arrange
    ByteString committeeAddress = mock(ByteString.class);
    when(committeeAddress.size()).thenReturn(0);

    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setID(-1L);
    proposalCapsule.addApproval(committeeAddress);

    // Act
    byte[] actualData = proposalCapsule.getData();

    // Assert
    verify(committeeAddress, atLeast(1)).size();
    assertArrayEquals(new byte[] {'\b', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, '2', 0}, actualData);
  }

  /**
   * Test {@link ProposalCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with backspace and minus one.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ProposalCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithBackspaceAndMinusOne2() {
    // Arrange
    ByteString committeeAddress = mock(ByteString.class);
    when(committeeAddress.size()).thenReturn(0);

    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setID(Long.MAX_VALUE);
    proposalCapsule.addApproval(committeeAddress);

    // Act
    byte[] actualData = proposalCapsule.getData();

    // Assert
    verify(committeeAddress, atLeast(1)).size();
    assertArrayEquals(
        new byte[] {'\b', -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE, '2', 0}, actualData);
  }

  /**
   * Test {@link ProposalCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with backspace and one.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ProposalCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithBackspaceAndOne() {
    // Arrange
    ByteString committeeAddress = mock(ByteString.class);
    when(committeeAddress.size()).thenReturn(0);

    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setID(1L);
    proposalCapsule.addApproval(committeeAddress);

    // Act
    byte[] actualData = proposalCapsule.getData();

    // Assert
    verify(committeeAddress, atLeast(1)).size();
    assertArrayEquals(new byte[] {'\b', 1, '2', 0}, actualData);
  }

  /**
   * Test {@link ProposalCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code (} and lf.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ProposalCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithLeftParenthesisAndLf() {
    // Arrange
    ByteString committeeAddress = mock(ByteString.class);
    when(committeeAddress.size()).thenReturn(0);

    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setCreateTime(10L);
    proposalCapsule.addApproval(committeeAddress);

    // Act
    byte[] actualData = proposalCapsule.getData();

    // Assert
    verify(committeeAddress, atLeast(1)).size();
    assertArrayEquals(new byte[] {'(', '\n', '2', 0}, actualData);
  }

  /**
   * Test {@link ProposalCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with space and lf.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ProposalCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithSpaceAndLf() {
    // Arrange
    ByteString committeeAddress = mock(ByteString.class);
    when(committeeAddress.size()).thenReturn(0);

    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});
    proposalCapsule.setExpirationTime(10L);
    proposalCapsule.addApproval(committeeAddress);

    // Act
    byte[] actualData = proposalCapsule.getData();

    // Assert
    verify(committeeAddress, atLeast(1)).size();
    assertArrayEquals(new byte[] {' ', '\n', '2', 0}, actualData);
  }

  /**
   * Test {@link ProposalCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ProposalCapsule.getData()"})
  public void testGetData_thenReturnEmptyArrayOfByte() {
    // Arrange
    ProposalCapsule proposalCapsule = new ProposalCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {}, proposalCapsule.getData());
  }

  /**
   * Test {@link ProposalCapsule#getInstance()}.
   *
   * <ul>
   *   <li>Given {@link ProposalCapsule#ProposalCapsule(byte[])} with data is {@code AXAXAXAX} Bytes
   *       is {@code UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProposalCapsule#getInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Protocol.Proposal ProposalCapsule.getInstance()"})
  public void testGetInstance_givenProposalCapsuleWithDataIsAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new ProposalCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }
}
