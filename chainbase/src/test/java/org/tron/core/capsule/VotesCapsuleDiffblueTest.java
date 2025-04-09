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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.DescriptorProtos.FeatureSet;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Vote;
import org.tron.protos.Protocol.Votes;

public class VotesCapsuleDiffblueTest {
  /**
   * Test {@link VotesCapsule#VotesCapsule(ByteString, List, List)}.
   * <ul>
   *   <li>Given DefaultInstance.</li>
   *   <li>Then return Instance NewVotesCount is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#VotesCapsule(ByteString, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(ByteString, List, List)"})
  public void testNewVotesCapsule_givenDefaultInstance_thenReturnInstanceNewVotesCountIsTwo() {
    // Arrange
    ByteString address = mock(ByteString.class);
    ArrayList<Vote> oldVotes = new ArrayList<>();

    ArrayList<Vote> newVotes = new ArrayList<>();
    newVotes.add(Vote.getDefaultInstance());
    newVotes.add(Vote.getDefaultInstance());

    // Act
    VotesCapsule actualVotesCapsule = new VotesCapsule(address, oldVotes, newVotes);

    // Assert
    assertEquals(2, actualVotesCapsule.getInstance().getNewVotesCount());
    assertEquals(newVotes, actualVotesCapsule.getNewVotes());
    assertArrayEquals(new byte[]{'\n', 0, 26, 0, 26, 0}, actualVotesCapsule.getData());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(ByteString, List)}.
   * <ul>
   *   <li>Given DefaultInstance.</li>
   *   <li>Then return OldVotes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#VotesCapsule(ByteString, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(ByteString, List)"})
  public void testNewVotesCapsule_givenDefaultInstance_thenReturnOldVotesSizeIsOne() {
    // Arrange
    ByteString address = mock(ByteString.class);

    ArrayList<Vote> oldVotes = new ArrayList<>();
    oldVotes.add(Vote.getDefaultInstance());

    // Act
    VotesCapsule actualVotesCapsule = new VotesCapsule(address, oldVotes);

    // Assert
    assertEquals(1, actualVotesCapsule.getOldVotes().size());
    Votes instance = actualVotesCapsule.getInstance();
    assertEquals(1, instance.getOldVotesCount());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0}, actualVotesCapsule.getData());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(ByteString, List, List)}.
   * <ul>
   *   <li>Given DefaultInstance.</li>
   *   <li>Then return OldVotes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#VotesCapsule(ByteString, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(ByteString, List, List)"})
  public void testNewVotesCapsule_givenDefaultInstance_thenReturnOldVotesSizeIsOne2() {
    // Arrange
    ByteString address = mock(ByteString.class);

    ArrayList<Vote> oldVotes = new ArrayList<>();
    oldVotes.add(Vote.getDefaultInstance());

    // Act
    VotesCapsule actualVotesCapsule = new VotesCapsule(address, oldVotes, new ArrayList<>());

    // Assert
    assertEquals(1, actualVotesCapsule.getOldVotes().size());
    Votes instance = actualVotesCapsule.getInstance();
    assertEquals(1, instance.getOldVotesCount());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0}, actualVotesCapsule.getData());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(ByteString, List)}.
   * <ul>
   *   <li>Given DefaultInstance.</li>
   *   <li>Then return OldVotes size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#VotesCapsule(ByteString, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(ByteString, List)"})
  public void testNewVotesCapsule_givenDefaultInstance_thenReturnOldVotesSizeIsTwo() {
    // Arrange
    ByteString address = mock(ByteString.class);

    ArrayList<Vote> oldVotes = new ArrayList<>();
    oldVotes.add(Vote.getDefaultInstance());
    Vote defaultInstance = Vote.getDefaultInstance();
    oldVotes.add(defaultInstance);

    // Act
    VotesCapsule actualVotesCapsule = new VotesCapsule(address, oldVotes);

    // Assert
    List<Vote> oldVotes2 = actualVotesCapsule.getOldVotes();
    assertEquals(2, oldVotes2.size());
    Votes instance = actualVotesCapsule.getInstance();
    assertEquals(2, instance.getOldVotesCount());
    assertEquals(6, instance.getSerializedSize());
    assertSame(defaultInstance, oldVotes2.get(1));
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, 18, 0}, actualVotesCapsule.getData());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(ByteString, List, List)}.
   * <ul>
   *   <li>Given DefaultInstance.</li>
   *   <li>Then return OldVotes size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#VotesCapsule(ByteString, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(ByteString, List, List)"})
  public void testNewVotesCapsule_givenDefaultInstance_thenReturnOldVotesSizeIsTwo2() {
    // Arrange
    ByteString address = mock(ByteString.class);

    ArrayList<Vote> oldVotes = new ArrayList<>();
    oldVotes.add(Vote.getDefaultInstance());
    Vote defaultInstance = Vote.getDefaultInstance();
    oldVotes.add(defaultInstance);

    // Act
    VotesCapsule actualVotesCapsule = new VotesCapsule(address, oldVotes, new ArrayList<>());

    // Assert
    List<Vote> oldVotes2 = actualVotesCapsule.getOldVotes();
    assertEquals(2, oldVotes2.size());
    assertEquals(2, actualVotesCapsule.getInstance().getOldVotesCount());
    assertSame(defaultInstance, oldVotes2.get(1));
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, 18, 0}, actualVotesCapsule.getData());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   * <ul>
   *   <li>Then return Instance InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_thenReturnInstanceInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    VotesCapsule actualVotesCapsule = new VotesCapsule(new byte[]{});

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
    assertEquals(instance, instance.getDefaultInstanceForType());
    assertSame(address, instance.getAddress());
    assertSame(newVotes, actualVotesCapsule.getOldVotes());
    assertSame(newVotes, instance.getNewVotesList());
    assertSame(newVotes, instance.getNewVotesOrBuilderList());
    assertSame(newVotes, instance.getOldVotesList());
    assertSame(newVotes, instance.getOldVotesOrBuilderList());
    assertArrayEquals(new byte[]{}, actualVotesCapsule.getData());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(ByteString, List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Instance AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#VotesCapsule(ByteString, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(ByteString, List, List)"})
  public void testNewVotesCapsule_whenArrayList_thenReturnInstanceAllFieldsSizeIsOne() {
    // Arrange
    ByteString address = mock(ByteString.class);
    ArrayList<Vote> oldVotes = new ArrayList<>();

    // Act
    VotesCapsule actualVotesCapsule = new VotesCapsule(address, oldVotes, new ArrayList<>());

    // Assert
    Votes instance = actualVotesCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    Descriptor descriptorForType = instance.getDescriptorForType();
    DescriptorProto toProtoResult = descriptorForType.toProto();
    Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    assertEquals(10, descriptorForType2.getFields().size());
    assertEquals(2, descriptorForType2.getNestedTypes().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(3, descriptorForType.getFields().size());
    FileDescriptor file = descriptorForType.getFile();
    assertEquals(45, file.toProto().getMessageTypeList().size());
    assertEquals(45, file.getMessageTypes().size());
    DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertArrayEquals(new byte[]{'\n', 0}, actualVotesCapsule.getData());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(ByteString, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Instance OldVotesCount is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#VotesCapsule(ByteString, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(ByteString, List)"})
  public void testNewVotesCapsule_whenArrayList_thenReturnInstanceOldVotesCountIsZero() {
    // Arrange
    ByteString address = mock(ByteString.class);
    ArrayList<Vote> oldVotes = new ArrayList<>();

    // Act
    VotesCapsule actualVotesCapsule = new VotesCapsule(address, oldVotes);

    // Assert
    Votes instance = actualVotesCapsule.getInstance();
    assertEquals(0, instance.getOldVotesCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    Descriptor descriptorForType = instance.getDescriptorForType();
    assertEquals(3, descriptorForType.getFields().size());
    FileDescriptor file = descriptorForType.getFile();
    assertEquals(3, file.getDependencies().size());
    assertEquals(45, file.getMessageTypes().size());
    assertTrue(actualVotesCapsule.getOldVotes().isEmpty());
    assertEquals(oldVotes, descriptorForType.toProto().getReservedNameList());
    assertArrayEquals(new byte[]{'\n', 0}, actualVotesCapsule.getData());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and two.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenArrayOfByteWithEighteenAndTwo_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule(new byte[]{18, 2, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenArrayOfByteWithEighteenAndX_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenArrayOfByteWithEighteenAndZero_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and two.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenArrayOfByteWithLfAndTwo_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule(new byte[]{'\n', 2, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenArrayOfByteWithLfAndZero_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenArrayOfByteWithMinusOneAndX_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenArrayOfByteWithTwentySixAndX_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and zero.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenArrayOfByteWithTwentySixAndZero_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule(new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with two and {@code X}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenArrayOfByteWithTwoAndX_thenReturnInstanceIsNull() {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenAxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenXaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule("\nXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link VotesCapsule#VotesCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Instance is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#VotesCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.<init>(byte[])"})
  public void testNewVotesCapsule_whenXxaxaxaxBytesIsUtf8_thenReturnInstanceIsNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link VotesCapsule#getAddress()}.
   * <p>
   * Method under test: {@link VotesCapsule#getAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString VotesCapsule.getAddress()"})
  public void testGetAddress() {
    // Arrange
    ByteString address = mock(ByteString.class);
    VotesCapsule votesCapsule = new VotesCapsule(address, new ArrayList<>());

    // Act
    ByteString actualAddress = votesCapsule.getAddress();

    // Assert
    Votes instance = votesCapsule.getInstance();
    List<FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(3, fields.size());
    ByteString byteString = actualAddress.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, instance.getDefaultInstanceForType().getAddress());
  }

  /**
   * Test {@link VotesCapsule#setAddress(ByteString)}.
   * <p>
   * Method under test: {@link VotesCapsule#setAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.setAddress(ByteString)"})
  public void testSetAddress() {
    // Arrange
    ByteString address = mock(ByteString.class);
    ArrayList<Vote> oldVotes = new ArrayList<>();
    VotesCapsule votesCapsule = new VotesCapsule(address, oldVotes);

    // Act
    votesCapsule.setAddress(mock(ByteString.class));

    // Assert
    assertEquals(oldVotes,
        votesCapsule.getInstance()
            .getDescriptorForType()
            .toProto()
            .getDescriptorForType()
            .toProto()
            .findInitializationErrors());
  }

  /**
   * Test {@link VotesCapsule#setAddress(ByteString)}.
   * <p>
   * Method under test: {@link VotesCapsule#setAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.setAddress(ByteString)"})
  public void testSetAddress2() {
    // Arrange
    VotesCapsule votesCapsule = new VotesCapsule(new byte[]{});

    // Act
    votesCapsule.setAddress(mock(ByteString.class));

    // Assert
    Votes instance = votesCapsule.getInstance();
    ByteString address = instance.getDefaultInstanceForType().getAddress();
    assertEquals("", address.toStringUtf8());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertFalse(address.iterator().hasNext());
    assertTrue(address.isEmpty());
    assertArrayEquals(new byte[]{'\n', 0}, votesCapsule.getData());
  }

  /**
   * Test {@link VotesCapsule#setAddress(ByteString)}.
   * <p>
   * Method under test: {@link VotesCapsule#setAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.setAddress(ByteString)"})
  public void testSetAddress3() {
    // Arrange
    ArrayList<Vote> oldVotes = new ArrayList<>();
    oldVotes.add(Vote.getDefaultInstance());
    VotesCapsule votesCapsule = new VotesCapsule(mock(ByteString.class), oldVotes);

    // Act
    votesCapsule.setAddress(mock(ByteString.class));

    // Assert that nothing has changed
    Votes instance = votesCapsule.getInstance();
    ByteString address = instance.getDefaultInstanceForType().getAddress();
    assertEquals("", address.toStringUtf8());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertFalse(address.iterator().hasNext());
    assertTrue(address.isEmpty());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0}, votesCapsule.getData());
  }

  /**
   * Test {@link VotesCapsule#setAddress(ByteString)}.
   * <p>
   * Method under test: {@link VotesCapsule#setAddress(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.setAddress(ByteString)"})
  public void testSetAddress4() {
    // Arrange
    VotesCapsule votesCapsule = new VotesCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    votesCapsule.setAddress(mock(ByteString.class));

    // Assert
    Votes instance = votesCapsule.getInstance();
    ByteString address = instance.getDefaultInstanceForType().getAddress();
    assertEquals("", address.toStringUtf8());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    assertFalse(address.iterator().hasNext());
    assertTrue(address.isEmpty());
    assertArrayEquals(
        new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        votesCapsule.getData());
  }

  /**
   * Test {@link VotesCapsule#getOldVotes()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#getOldVotes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List VotesCapsule.getOldVotes()"})
  public void testGetOldVotes_thenReturnEmpty() {
    // Arrange
    ByteString address = mock(ByteString.class);

    // Act and Assert
    assertTrue((new VotesCapsule(address, new ArrayList<>())).getOldVotes().isEmpty());
  }

  /**
   * Test {@link VotesCapsule#setOldVotes(List)}.
   * <p>
   * Method under test: {@link VotesCapsule#setOldVotes(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.setOldVotes(List)"})
  public void testSetOldVotes() {
    // Arrange
    ByteString address = mock(ByteString.class);
    VotesCapsule votesCapsule = new VotesCapsule(address, new ArrayList<>());

    // Act
    votesCapsule.setOldVotes(new ArrayList<>());

    // Assert that nothing has changed
    List<Vote> oldVotes = votesCapsule.getOldVotes();
    assertTrue(oldVotes.isEmpty());
    Votes instance = votesCapsule.getInstance();
    assertSame(oldVotes, instance.getOldVotesList());
    assertSame(oldVotes, instance.getOldVotesOrBuilderList());
  }

  /**
   * Test {@link VotesCapsule#setOldVotes(List)}.
   * <p>
   * Method under test: {@link VotesCapsule#setOldVotes(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.setOldVotes(List)"})
  public void testSetOldVotes2() {
    // Arrange
    ArrayList<Vote> oldVotes = new ArrayList<>();
    oldVotes.add(Vote.getDefaultInstance());
    VotesCapsule votesCapsule = new VotesCapsule(mock(ByteString.class), oldVotes);

    // Act
    votesCapsule.setOldVotes(new ArrayList<>());

    // Assert that nothing has changed
    List<Vote> oldVotes2 = votesCapsule.getOldVotes();
    assertEquals(1, oldVotes2.size());
    Votes instance = votesCapsule.getInstance();
    assertSame(oldVotes2, instance.getOldVotesList());
    assertSame(oldVotes2, instance.getOldVotesOrBuilderList());
  }

  /**
   * Test {@link VotesCapsule#setOldVotes(List)}.
   * <ul>
   *   <li>Then {@link VotesCapsule#VotesCapsule(byte[])} with data is array of {@code byte} with {@code A} and {@code X} OldVotes Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#setOldVotes(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.setOldVotes(List)"})
  public void testSetOldVotes_thenVotesCapsuleWithDataIsArrayOfByteWithAAndXOldVotesEmpty() {
    // Arrange
    VotesCapsule votesCapsule = new VotesCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    votesCapsule.setOldVotes(new ArrayList<>());

    // Assert
    List<Vote> oldVotes = votesCapsule.getOldVotes();
    assertTrue(oldVotes.isEmpty());
    Votes instance = votesCapsule.getInstance();
    assertSame(oldVotes, instance.getOldVotesList());
    assertSame(oldVotes, instance.getOldVotesOrBuilderList());
  }

  /**
   * Test {@link VotesCapsule#setOldVotes(List)}.
   * <ul>
   *   <li>Then {@link VotesCapsule#VotesCapsule(byte[])} with data is empty array of {@code byte} OldVotes Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#setOldVotes(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.setOldVotes(List)"})
  public void testSetOldVotes_thenVotesCapsuleWithDataIsEmptyArrayOfByteOldVotesEmpty() {
    // Arrange
    VotesCapsule votesCapsule = new VotesCapsule(new byte[]{});

    // Act
    votesCapsule.setOldVotes(new ArrayList<>());

    // Assert
    List<Vote> oldVotes = votesCapsule.getOldVotes();
    assertTrue(oldVotes.isEmpty());
    Votes instance = votesCapsule.getInstance();
    assertSame(oldVotes, instance.getOldVotesList());
    assertSame(oldVotes, instance.getOldVotesOrBuilderList());
  }

  /**
   * Test {@link VotesCapsule#getNewVotes()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#getNewVotes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List VotesCapsule.getNewVotes()"})
  public void testGetNewVotes_thenReturnEmpty() {
    // Arrange
    ByteString address = mock(ByteString.class);

    // Act and Assert
    assertTrue((new VotesCapsule(address, new ArrayList<>())).getNewVotes().isEmpty());
  }

  /**
   * Test {@link VotesCapsule#clearNewVotes()}.
   * <p>
   * Method under test: {@link VotesCapsule#clearNewVotes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.clearNewVotes()"})
  public void testClearNewVotes() {
    // Arrange
    ByteString address = mock(ByteString.class);
    ArrayList<Vote> oldVotes = new ArrayList<>();
    VotesCapsule votesCapsule = new VotesCapsule(address, oldVotes);

    // Act
    votesCapsule.clearNewVotes();

    // Assert
    assertEquals(oldVotes,
        votesCapsule.getInstance()
            .getDescriptorForType()
            .toProto()
            .getDescriptorForType()
            .toProto()
            .findInitializationErrors());
  }

  /**
   * Test {@link VotesCapsule#clearNewVotes()}.
   * <p>
   * Method under test: {@link VotesCapsule#clearNewVotes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.clearNewVotes()"})
  public void testClearNewVotes2() {
    // Arrange
    ArrayList<Vote> oldVotes = new ArrayList<>();
    oldVotes.add(Vote.getDefaultInstance());
    VotesCapsule votesCapsule = new VotesCapsule(mock(ByteString.class), oldVotes);

    // Act
    votesCapsule.clearNewVotes();

    // Assert that nothing has changed
    List<Vote> oldVotes2 = votesCapsule.getOldVotes();
    assertEquals(1, oldVotes2.size());
    Votes instance = votesCapsule.getInstance();
    assertSame(oldVotes2, instance.getOldVotesList());
    assertSame(oldVotes2, instance.getOldVotesOrBuilderList());
  }

  /**
   * Test {@link VotesCapsule#clearOldVotes()}.
   * <p>
   * Method under test: {@link VotesCapsule#clearOldVotes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.clearOldVotes()"})
  public void testClearOldVotes() {
    // Arrange
    ByteString address = mock(ByteString.class);
    ArrayList<Vote> oldVotes = new ArrayList<>();
    VotesCapsule votesCapsule = new VotesCapsule(address, oldVotes);

    // Act
    votesCapsule.clearOldVotes();

    // Assert
    assertEquals(oldVotes,
        votesCapsule.getInstance()
            .getDescriptorForType()
            .toProto()
            .getDescriptorForType()
            .toProto()
            .findInitializationErrors());
  }

  /**
   * Test {@link VotesCapsule#clearOldVotes()}.
   * <p>
   * Method under test: {@link VotesCapsule#clearOldVotes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.clearOldVotes()"})
  public void testClearOldVotes2() {
    // Arrange
    ArrayList<Vote> oldVotes = new ArrayList<>();
    oldVotes.add(Vote.getDefaultInstance());
    VotesCapsule votesCapsule = new VotesCapsule(mock(ByteString.class), oldVotes);

    // Act
    votesCapsule.clearOldVotes();

    // Assert
    Votes instance = votesCapsule.getInstance();
    assertEquals(0, instance.getOldVotesCount());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0}, votesCapsule.getData());
  }

  /**
   * Test {@link VotesCapsule#clearOldVotes()}.
   * <p>
   * Method under test: {@link VotesCapsule#clearOldVotes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.clearOldVotes()"})
  public void testClearOldVotes3() {
    // Arrange
    VotesCapsule votesCapsule = new VotesCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    votesCapsule.clearOldVotes();

    // Assert that nothing has changed
    Votes instance = votesCapsule.getInstance();
    assertEquals(0, instance.getOldVotesCount());
    assertTrue(instance.getAllFields().isEmpty());
    assertEquals(Short.SIZE, instance.getSerializedSize());
    assertArrayEquals(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        votesCapsule.getData());
  }

  /**
   * Test {@link VotesCapsule#addNewVotes(ByteString, long)}.
   * <p>
   * Method under test: {@link VotesCapsule#addNewVotes(ByteString, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.addNewVotes(ByteString, long)"})
  public void testAddNewVotes() {
    // Arrange
    ByteString address = mock(ByteString.class);
    VotesCapsule votesCapsule = new VotesCapsule(address, new ArrayList<>());

    // Act
    votesCapsule.addNewVotes(mock(ByteString.class), 3L);

    // Assert
    Votes instance = votesCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 26, 4, '\n', 0, 16, 3}, votesCapsule.getData());
  }

  /**
   * Test {@link VotesCapsule#addNewVotes(ByteString, long)}.
   * <p>
   * Method under test: {@link VotesCapsule#addNewVotes(ByteString, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.addNewVotes(ByteString, long)"})
  public void testAddNewVotes2() {
    // Arrange
    ArrayList<Vote> oldVotes = new ArrayList<>();
    Vote defaultInstance = Vote.getDefaultInstance();
    oldVotes.add(defaultInstance);
    VotesCapsule votesCapsule = new VotesCapsule(mock(ByteString.class), oldVotes);

    // Act
    votesCapsule.addNewVotes(mock(ByteString.class), 3L);

    // Assert
    List<Vote> newVotes = votesCapsule.getNewVotes();
    assertEquals(1, newVotes.size());
    assertEquals(1, votesCapsule.getOldVotes().size());
    Votes instance = votesCapsule.getInstance();
    assertEquals(10, instance.getSerializedSize());
    assertEquals(3, instance.getAllFields().size());
    Votes defaultInstanceForType = instance.getDefaultInstanceForType();
    List<Vote> newVotesList = defaultInstanceForType.getNewVotesList();
    assertTrue(newVotesList.isEmpty());
    assertSame(newVotesList, defaultInstanceForType.getNewVotesOrBuilderList());
    assertSame(newVotesList, defaultInstanceForType.getOldVotesList());
    assertSame(newVotesList, defaultInstanceForType.getOldVotesOrBuilderList());
    assertSame(defaultInstance, newVotes.get(0).getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, 26, 4, '\n', 0, 16, 3}, votesCapsule.getData());
  }

  /**
   * Test {@link VotesCapsule#addNewVotes(ByteString, long)}.
   * <ul>
   *   <li>Then {@link VotesCapsule#VotesCapsule(byte[])} with data is empty array of {@code byte} NewVotes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#addNewVotes(ByteString, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.addNewVotes(ByteString, long)"})
  public void testAddNewVotes_thenVotesCapsuleWithDataIsEmptyArrayOfByteNewVotesSizeIsOne() {
    // Arrange
    VotesCapsule votesCapsule = new VotesCapsule(new byte[]{});

    // Act
    votesCapsule.addNewVotes(mock(ByteString.class), 3L);

    // Assert
    assertEquals(1, votesCapsule.getNewVotes().size());
    Votes instance = votesCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    List<Vote> oldVotes = votesCapsule.getOldVotes();
    assertTrue(oldVotes.isEmpty());
    Votes defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(oldVotes, defaultInstanceForType.getNewVotesList());
    assertSame(oldVotes, defaultInstanceForType.getNewVotesOrBuilderList());
    assertSame(oldVotes, instance.getOldVotesList());
    assertSame(oldVotes, defaultInstanceForType.getOldVotesList());
    assertSame(oldVotes, instance.getOldVotesOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getOldVotesOrBuilderList());
    assertArrayEquals(new byte[]{26, 4, '\n', 0, 16, 3}, votesCapsule.getData());
  }

  /**
   * Test {@link VotesCapsule#addAllNewVotes(List)}.
   * <p>
   * Method under test: {@link VotesCapsule#addAllNewVotes(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.addAllNewVotes(List)"})
  public void testAddAllNewVotes() {
    // Arrange
    ArrayList<Vote> oldVotes = new ArrayList<>();
    oldVotes.add(Vote.getDefaultInstance());
    VotesCapsule votesCapsule = new VotesCapsule(mock(ByteString.class), oldVotes);

    // Act
    votesCapsule.addAllNewVotes(new ArrayList<>());

    // Assert
    Votes defaultInstanceForType = votesCapsule.getInstance().getDefaultInstanceForType();
    List<Vote> newVotesList = defaultInstanceForType.getNewVotesList();
    assertTrue(newVotesList.isEmpty());
    assertSame(newVotesList, defaultInstanceForType.getNewVotesOrBuilderList());
    assertSame(newVotesList, defaultInstanceForType.getOldVotesList());
    assertSame(newVotesList, defaultInstanceForType.getOldVotesOrBuilderList());
  }

  /**
   * Test {@link VotesCapsule#addAllNewVotes(List)}.
   * <ul>
   *   <li>Then {@link VotesCapsule#VotesCapsule(byte[])} with data is array of {@code byte} with {@code A} and {@code X} OldVotes Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#addAllNewVotes(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.addAllNewVotes(List)"})
  public void testAddAllNewVotes_thenVotesCapsuleWithDataIsArrayOfByteWithAAndXOldVotesEmpty() {
    // Arrange
    VotesCapsule votesCapsule = new VotesCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    votesCapsule.addAllNewVotes(new ArrayList<>());

    // Assert
    List<Vote> oldVotes = votesCapsule.getOldVotes();
    assertTrue(oldVotes.isEmpty());
    Votes instance = votesCapsule.getInstance();
    Votes defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(oldVotes, defaultInstanceForType.getNewVotesList());
    assertSame(oldVotes, defaultInstanceForType.getNewVotesOrBuilderList());
    assertSame(oldVotes, instance.getOldVotesList());
    assertSame(oldVotes, defaultInstanceForType.getOldVotesList());
    assertSame(oldVotes, instance.getOldVotesOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getOldVotesOrBuilderList());
  }

  /**
   * Test {@link VotesCapsule#addAllNewVotes(List)}.
   * <ul>
   *   <li>Then {@link VotesCapsule#VotesCapsule(byte[])} with data is empty array of {@code byte} OldVotes Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#addAllNewVotes(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.addAllNewVotes(List)"})
  public void testAddAllNewVotes_thenVotesCapsuleWithDataIsEmptyArrayOfByteOldVotesEmpty() {
    // Arrange
    VotesCapsule votesCapsule = new VotesCapsule(new byte[]{});

    // Act
    votesCapsule.addAllNewVotes(new ArrayList<>());

    // Assert
    List<Vote> oldVotes = votesCapsule.getOldVotes();
    assertTrue(oldVotes.isEmpty());
    Votes instance = votesCapsule.getInstance();
    Votes defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(oldVotes, defaultInstanceForType.getNewVotesList());
    assertSame(oldVotes, defaultInstanceForType.getNewVotesOrBuilderList());
    assertSame(oldVotes, instance.getOldVotesList());
    assertSame(oldVotes, defaultInstanceForType.getOldVotesList());
    assertSame(oldVotes, instance.getOldVotesOrBuilderList());
    assertSame(oldVotes, defaultInstanceForType.getOldVotesOrBuilderList());
  }

  /**
   * Test {@link VotesCapsule#addOldVotes(ByteString, long)}.
   * <p>
   * Method under test: {@link VotesCapsule#addOldVotes(ByteString, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.addOldVotes(ByteString, long)"})
  public void testAddOldVotes() {
    // Arrange
    ByteString address = mock(ByteString.class);
    VotesCapsule votesCapsule = new VotesCapsule(address, new ArrayList<>());

    // Act
    votesCapsule.addOldVotes(mock(ByteString.class), 3L);

    // Assert
    List<Vote> oldVotes = votesCapsule.getOldVotes();
    assertEquals(1, oldVotes.size());
    Votes instance = votesCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(8, instance.getSerializedSize());
    Vote getResult = oldVotes.get(0);
    Descriptor expectedDescriptorForType = getResult.getDescriptorForType();
    Vote defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertSame(expectedDescriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'\n', 0, 18, 4, '\n', 0, 16, 3}, votesCapsule.getData());
  }

  /**
   * Test {@link VotesCapsule#addOldVotes(ByteString, long)}.
   * <p>
   * Method under test: {@link VotesCapsule#addOldVotes(ByteString, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.addOldVotes(ByteString, long)"})
  public void testAddOldVotes2() {
    // Arrange
    ArrayList<Vote> oldVotes = new ArrayList<>();
    oldVotes.add(Vote.getDefaultInstance());
    VotesCapsule votesCapsule = new VotesCapsule(mock(ByteString.class), oldVotes);

    // Act
    votesCapsule.addOldVotes(mock(ByteString.class), 3L);

    // Assert
    Votes instance = votesCapsule.getInstance();
    assertEquals(10, instance.getSerializedSize());
    assertEquals(2, votesCapsule.getOldVotes().size());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(2, instance.getOldVotesCount());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, 18, 4, '\n', 0, 16, 3}, votesCapsule.getData());
  }

  /**
   * Test {@link VotesCapsule#addOldVotes(ByteString, long)}.
   * <ul>
   *   <li>Then {@link VotesCapsule#VotesCapsule(byte[])} with data is empty array of {@code byte} OldVotes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#addOldVotes(ByteString, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VotesCapsule.addOldVotes(ByteString, long)"})
  public void testAddOldVotes_thenVotesCapsuleWithDataIsEmptyArrayOfByteOldVotesSizeIsOne() {
    // Arrange
    VotesCapsule votesCapsule = new VotesCapsule(new byte[]{});

    // Act
    votesCapsule.addOldVotes(mock(ByteString.class), 3L);

    // Assert
    List<Vote> oldVotes = votesCapsule.getOldVotes();
    assertEquals(1, oldVotes.size());
    Votes instance = votesCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertSame(oldVotes, instance.getOldVotesList());
    assertSame(oldVotes, instance.getOldVotesOrBuilderList());
    assertArrayEquals(new byte[]{18, 4, '\n', 0, 16, 3}, votesCapsule.getData());
  }

  /**
   * Test {@link VotesCapsule#createDbKey()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#createDbKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] VotesCapsule.createDbKey()"})
  public void testCreateDbKey_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualCreateDbKeyResult = (new VotesCapsule(address, new ArrayList<>())).createDbKey();

    // Assert
    verify(address).toByteArray();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCreateDbKeyResult);
  }

  /**
   * Test {@link VotesCapsule#createReadableString()}.
   * <ul>
   *   <li>Then return {@code 4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#createReadableString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String VotesCapsule.createReadableString()"})
  public void testCreateReadableString_thenReturn4158415841584158() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualCreateReadableStringResult = (new VotesCapsule(address, new ArrayList<>())).createReadableString();

    // Assert
    verify(address).toByteArray();
    assertEquals("4158415841584158", actualCreateReadableStringResult);
  }

  /**
   * Test {@link VotesCapsule#getData()}.
   * <ul>
   *   <li>Given {@link ByteString} {@link ByteString#isEmpty()} return {@code true}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] VotesCapsule.getData()"})
  public void testGetData_givenByteStringIsEmptyReturnTrue_thenReturnEmptyArrayOfByte() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new VotesCapsule(address, new ArrayList<>())).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{}, actualData);
  }

  /**
   * Test {@link VotesCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with eighteen and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] VotesCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithEighteenAndZero() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    ArrayList<Vote> oldVotes = new ArrayList<>();
    oldVotes.add(Vote.getDefaultInstance());

    // Act
    byte[] actualData = (new VotesCapsule(address, oldVotes)).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{18, 0}, actualData);
  }

  /**
   * Test {@link VotesCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with twenty-six and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] VotesCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithTwentySixAndZero() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    ArrayList<Vote> votesToAdd = new ArrayList<>();
    votesToAdd.add(Vote.getDefaultInstance());

    VotesCapsule votesCapsule = new VotesCapsule(address, new ArrayList<>());
    votesCapsule.addAllNewVotes(votesToAdd);

    // Act
    byte[] actualData = votesCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{26, 0}, actualData);
  }

  /**
   * Test {@link VotesCapsule#getInstance()}.
   * <ul>
   *   <li>Given {@link VotesCapsule#VotesCapsule(byte[])} with data is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VotesCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Votes VotesCapsule.getInstance()"})
  public void testGetInstance_givenVotesCapsuleWithDataIsAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new VotesCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }
}
