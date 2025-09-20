package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Vote;
import org.tron.protos.Protocol.Votes;

public class VotesCapsuleDiffblueTest {
  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   *
   * <ul>
   *   <li>Then return Instance InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_thenReturnInstanceInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    VotesCapsule actualVotesCapsule = new VotesCapsule(new byte[] {});

    // Assert
    Votes instance = actualVotesCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    ByteString address = actualVotesCapsule.getAddress();
    assertEquals("", address.toStringUtf8());
    assertEquals(0, instance.getNewVotesCount());
    assertEquals(0, instance.getOldVotesCount());
    assertEquals(0, instance.getSerializedSize());
    assertFalse(address.iterator().hasNext());
    assertTrue(address.isEmpty());
    assertTrue(instance.findInitializationErrors().isEmpty());
    List<Vote> newVotes = actualVotesCapsule.getNewVotes();
    assertTrue(newVotes.isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    assertTrue(instance.isInitialized());
    Votes actualDefaultInstanceForType = instance.getDefaultInstanceForType();
    assertEquals(instance, actualDefaultInstanceForType);
    assertSame(address, instance.getAddress());
    assertSame(newVotes, actualVotesCapsule.getOldVotes());
    assertSame(newVotes, instance.getNewVotesList());
    assertSame(newVotes, instance.getNewVotesOrBuilderList());
    assertSame(newVotes, instance.getOldVotesList());
    assertSame(newVotes, instance.getOldVotesOrBuilderList());
    assertArrayEquals(new byte[] {}, actualVotesCapsule.getData());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenArrayOfByteWithAAndMinusOne_thenReturnInstanceIsNull() {
    // Arrange and Act
    VotesCapsule actualVotesCapsule =
        new VotesCapsule(
            new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Assert
    assertNull(actualVotesCapsule.getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and lf.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenArrayOfByteWithEighteenAndLf_thenReturnInstanceIsNull() {
    // Arrange and Act
    VotesCapsule actualVotesCapsule =
        new VotesCapsule(
            new byte[] {18, '\n', 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Assert
    assertNull(actualVotesCapsule.getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and minus one.
   * </ul>
   *
   * <p>Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenArrayOfByteWithEighteenAndMinusOne() {
    // Arrange and Act
    VotesCapsule actualVotesCapsule =
        new VotesCapsule(
            new byte[] {18, -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Assert
    assertNull(actualVotesCapsule.getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and two.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenArrayOfByteWithEighteenAndTwo_thenReturnInstanceIsNull() {
    // Arrange and Act
    VotesCapsule actualVotesCapsule =
        new VotesCapsule(new byte[] {18, 2, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualVotesCapsule.getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and two.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenArrayOfByteWithEighteenAndTwo_thenReturnInstanceIsNull2() {
    // Arrange and Act
    VotesCapsule actualVotesCapsule =
        new VotesCapsule(new byte[] {18, 2, 16, 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualVotesCapsule.getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and two.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenArrayOfByteWithEighteenAndTwo_thenReturnInstanceIsNull3() {
    // Arrange and Act
    VotesCapsule actualVotesCapsule =
        new VotesCapsule(new byte[] {18, 2, 0, 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualVotesCapsule.getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenArrayOfByteWithEighteenAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    VotesCapsule actualVotesCapsule =
        new VotesCapsule(new byte[] {18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualVotesCapsule.getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenArrayOfByteWithEighteenAndZero_thenReturnInstanceIsNull() {
    // Arrange and Act
    VotesCapsule actualVotesCapsule =
        new VotesCapsule(new byte[] {18, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualVotesCapsule.getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and two.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenArrayOfByteWithLfAndTwo_thenReturnInstanceIsNull() {
    // Arrange and Act
    VotesCapsule actualVotesCapsule =
        new VotesCapsule(new byte[] {'\n', 2, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualVotesCapsule.getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenArrayOfByteWithLfAndZero_thenReturnInstanceIsNull() {
    // Arrange and Act
    VotesCapsule actualVotesCapsule =
        new VotesCapsule(new byte[] {'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualVotesCapsule.getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenArrayOfByteWithMinusOneAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    VotesCapsule actualVotesCapsule =
        new VotesCapsule(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualVotesCapsule.getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenArrayOfByteWithTwentySixAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    VotesCapsule actualVotesCapsule =
        new VotesCapsule(new byte[] {26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualVotesCapsule.getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and zero.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenArrayOfByteWithTwentySixAndZero_thenReturnInstanceIsNull() {
    // Arrange and Act
    VotesCapsule actualVotesCapsule =
        new VotesCapsule(new byte[] {26, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualVotesCapsule.getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with two and {@code X}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenArrayOfByteWithTwoAndX_thenReturnInstanceIsNull() {
    // Arrange and Act
    VotesCapsule actualVotesCapsule =
        new VotesCapsule(new byte[] {2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualVotesCapsule.getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new VotesCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   *
   * <ul>
   *   <li>When lf.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenLf_thenReturnInstanceIsNull() {
    // Arrange and Act
    VotesCapsule actualVotesCapsule =
        new VotesCapsule(new byte[] {18, 2, '\n', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualVotesCapsule.getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Instance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(new VotesCapsule("\nXAXAXAX".getBytes("UTF-8")).getInstance());
  }
}
