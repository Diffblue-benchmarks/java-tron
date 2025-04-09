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
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.DelegatedResourceAccountIndex;

public class DelegatedResourceAccountIndexCapsuleDiffblueTest {
  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(ByteString)}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(ByteString)"})
  public void testNewDelegatedResourceAccountIndexCapsule() {
    // Arrange
    ByteString address = mock(ByteString.class);

    // Act
    DelegatedResourceAccountIndexCapsule actualDelegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        address);

    // Assert
    DelegatedResourceAccountIndex instance = actualDelegatedResourceAccountIndexCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0, instance.getFromAccountsCount());
    assertEquals(0, instance.getToAccountsCount());
    assertEquals(0L, actualDelegatedResourceAccountIndexCapsule.getTimestamp());
    assertEquals(0L, instance.getTimestamp());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertTrue(instance.findInitializationErrors().isEmpty());
    List<ByteString> fromAccountsList = actualDelegatedResourceAccountIndexCapsule.getFromAccountsList();
    assertTrue(fromAccountsList.isEmpty());
    assertTrue(instance.isInitialized());
    assertSame(fromAccountsList, actualDelegatedResourceAccountIndexCapsule.getToAccountsList());
    assertSame(fromAccountsList, instance.getFromAccountsList());
    assertSame(fromAccountsList, instance.getToAccountsList());
    assertSame(address, actualDelegatedResourceAccountIndexCapsule.getAccount());
    assertSame(address, instance.getAccount());
    assertArrayEquals(new byte[]{'\n', 0}, actualDelegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule2() {
    // Arrange and Act
    DelegatedResourceAccountIndexCapsule actualDelegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{});

    // Assert
    DelegatedResourceAccountIndex instance = actualDelegatedResourceAccountIndexCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    ByteString account = actualDelegatedResourceAccountIndexCapsule.getAccount();
    assertEquals("", account.toStringUtf8());
    assertEquals(0, instance.getFromAccountsCount());
    assertEquals(0, instance.getSerializedSize());
    assertEquals(0, instance.getToAccountsCount());
    assertEquals(0L, actualDelegatedResourceAccountIndexCapsule.getTimestamp());
    assertEquals(0L, instance.getTimestamp());
    assertFalse(account.iterator().hasNext());
    assertTrue(account.isEmpty());
    assertTrue(instance.findInitializationErrors().isEmpty());
    List<ByteString> fromAccountsList = actualDelegatedResourceAccountIndexCapsule.getFromAccountsList();
    assertTrue(fromAccountsList.isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    assertTrue(instance.isInitialized());
    assertEquals(instance, instance.getDefaultInstanceForType());
    assertSame(account, instance.getAccount());
    assertSame(fromAccountsList, actualDelegatedResourceAccountIndexCapsule.getToAccountsList());
    assertSame(fromAccountsList, instance.getFromAccountsList());
    assertSame(fromAccountsList, instance.getToAccountsList());
    assertArrayEquals(new byte[]{}, actualDelegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenArrayOfByteWithEighteenAndX() {
    // Arrange, Act and Assert
    assertNull(
        (new DelegatedResourceAccountIndexCapsule(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange, Act and Assert
    assertNull(
        (new DelegatedResourceAccountIndexCapsule(new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenArrayOfByteWithLfAndZero() {
    // Arrange, Act and Assert
    assertNull(
        (new DelegatedResourceAccountIndexCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenArrayOfByteWithMinusOneAndX() {
    // Arrange, Act and Assert
    assertNull(
        (new DelegatedResourceAccountIndexCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenArrayOfByteWithTwentySixAndX() {
    // Arrange, Act and Assert
    assertNull(
        (new DelegatedResourceAccountIndexCapsule(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenArrayOfByteWithTwentySixAndZero() {
    // Arrange, Act and Assert
    assertNull(
        (new DelegatedResourceAccountIndexCapsule(new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenArrayOfByteWithZeroAndX() {
    // Arrange, Act and Assert
    assertNull(
        (new DelegatedResourceAccountIndexCapsule(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceAccountIndexCapsule("AXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenXaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceAccountIndexCapsule("\nXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenXaxaxaxBytesIsUtf82()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceAccountIndexCapsule(" XAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenXxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull((new DelegatedResourceAccountIndexCapsule("XXAXAXAX".getBytes("UTF-8"))).getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#getAccount()}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#getAccount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString DelegatedResourceAccountIndexCapsule.getAccount()"})
  public void testGetAccount() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));

    // Act
    ByteString actualAccount = delegatedResourceAccountIndexCapsule.getAccount();

    // Assert
    DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    List<FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(4, fields.size());
    ByteString byteString = actualAccount.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, instance.getDefaultInstanceForType().getAccount());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#setAccount(ByteString)}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#setAccount(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.setAccount(ByteString)"})
  public void testSetAccount() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));

    // Act
    delegatedResourceAccountIndexCapsule.setAccount(mock(ByteString.class));

    // Assert that nothing has changed
    DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    ByteString account = instance.getDefaultInstanceForType().getAccount();
    assertEquals("", account.toStringUtf8());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertFalse(account.iterator().hasNext());
    assertTrue(account.isEmpty());
    assertArrayEquals(new byte[]{'\n', 0}, delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#setAccount(ByteString)}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#setAccount(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.setAccount(ByteString)"})
  public void testSetAccount2() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));
    delegatedResourceAccountIndexCapsule.setTimestamp(10L);

    // Act
    delegatedResourceAccountIndexCapsule.setAccount(mock(ByteString.class));

    // Assert that nothing has changed
    DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    ByteString account = instance.getDefaultInstanceForType().getAccount();
    assertEquals("", account.toStringUtf8());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertFalse(account.iterator().hasNext());
    assertTrue(account.isEmpty());
    assertArrayEquals(new byte[]{'\n', 0, ' ', '\n'}, delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#setAccount(ByteString)}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#setAccount(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.setAccount(ByteString)"})
  public void testSetAccount3() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{});

    // Act
    delegatedResourceAccountIndexCapsule.setAccount(mock(ByteString.class));

    // Assert
    DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    ByteString account = instance.getDefaultInstanceForType().getAccount();
    assertEquals("", account.toStringUtf8());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertFalse(account.iterator().hasNext());
    assertTrue(account.isEmpty());
    assertArrayEquals(new byte[]{'\n', 0}, delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#setAccount(ByteString)}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#setAccount(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.setAccount(ByteString)"})
  public void testSetAccount4() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    delegatedResourceAccountIndexCapsule.setAccount(mock(ByteString.class));

    // Assert
    DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    ByteString account = instance.getDefaultInstanceForType().getAccount();
    assertEquals("", account.toStringUtf8());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    assertFalse(account.iterator().hasNext());
    assertTrue(account.isEmpty());
    assertArrayEquals(
        new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#getFromAccountsList()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#getFromAccountsList()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DelegatedResourceAccountIndexCapsule.getFromAccountsList()"})
  public void testGetFromAccountsList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new DelegatedResourceAccountIndexCapsule(mock(ByteString.class))).getFromAccountsList().isEmpty());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#setAllFromAccounts(List)}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#setAllFromAccounts(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.setAllFromAccounts(List)"})
  public void testSetAllFromAccounts() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));

    // Act
    delegatedResourceAccountIndexCapsule.setAllFromAccounts(new ArrayList<>());

    // Assert
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertTrue(toAccountsList.isEmpty());
    DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    DelegatedResourceAccountIndex defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(toAccountsList, defaultInstanceForType.getFromAccountsList());
    assertSame(toAccountsList, instance.getToAccountsList());
    assertSame(toAccountsList, defaultInstanceForType.getToAccountsList());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#setAllFromAccounts(List)}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#setAllFromAccounts(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.setAllFromAccounts(List)"})
  public void testSetAllFromAccounts2() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));
    delegatedResourceAccountIndexCapsule.setTimestamp(10L);

    // Act
    delegatedResourceAccountIndexCapsule.setAllFromAccounts(new ArrayList<>());

    // Assert
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertTrue(toAccountsList.isEmpty());
    DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    DelegatedResourceAccountIndex defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(toAccountsList, defaultInstanceForType.getFromAccountsList());
    assertSame(toAccountsList, instance.getToAccountsList());
    assertSame(toAccountsList, defaultInstanceForType.getToAccountsList());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#setAllFromAccounts(List)}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#setAllFromAccounts(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.setAllFromAccounts(List)"})
  public void testSetAllFromAccounts3() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{});

    // Act
    delegatedResourceAccountIndexCapsule.setAllFromAccounts(new ArrayList<>());

    // Assert
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertTrue(toAccountsList.isEmpty());
    DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    DelegatedResourceAccountIndex defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(toAccountsList, defaultInstanceForType.getFromAccountsList());
    assertSame(toAccountsList, instance.getToAccountsList());
    assertSame(toAccountsList, defaultInstanceForType.getToAccountsList());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#setAllFromAccounts(List)}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#setAllFromAccounts(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.setAllFromAccounts(List)"})
  public void testSetAllFromAccounts4() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    delegatedResourceAccountIndexCapsule.setAllFromAccounts(new ArrayList<>());

    // Assert
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertTrue(toAccountsList.isEmpty());
    DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    DelegatedResourceAccountIndex defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(toAccountsList, defaultInstanceForType.getFromAccountsList());
    assertSame(toAccountsList, instance.getToAccountsList());
    assertSame(toAccountsList, defaultInstanceForType.getToAccountsList());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#addFromAccount(ByteString)}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#addFromAccount(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.addFromAccount(ByteString)"})
  public void testAddFromAccount() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));

    // Act
    delegatedResourceAccountIndexCapsule.addFromAccount(mock(ByteString.class));

    // Assert
    DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0}, delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#addFromAccount(ByteString)}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#addFromAccount(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.addFromAccount(ByteString)"})
  public void testAddFromAccount2() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));
    delegatedResourceAccountIndexCapsule.setTimestamp(10L);

    // Act
    delegatedResourceAccountIndexCapsule.addFromAccount(mock(ByteString.class));

    // Assert
    DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 18, 0, ' ', '\n'}, delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#addFromAccount(ByteString)}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#addFromAccount(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.addFromAccount(ByteString)"})
  public void testAddFromAccount3() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{});

    // Act
    delegatedResourceAccountIndexCapsule.addFromAccount(mock(ByteString.class));

    // Assert
    DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertArrayEquals(new byte[]{18, 0}, delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#addFromAccount(ByteString)}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#addFromAccount(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.addFromAccount(ByteString)"})
  public void testAddFromAccount4() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    delegatedResourceAccountIndexCapsule.addFromAccount(mock(ByteString.class));

    // Assert
    assertEquals(18, delegatedResourceAccountIndexCapsule.getInstance().getSerializedSize());
    assertArrayEquals(
        new byte[]{18, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#getToAccountsList()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#getToAccountsList()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DelegatedResourceAccountIndexCapsule.getToAccountsList()"})
  public void testGetToAccountsList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new DelegatedResourceAccountIndexCapsule(mock(ByteString.class))).getToAccountsList().isEmpty());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#setAllToAccounts(List)}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#setAllToAccounts(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.setAllToAccounts(List)"})
  public void testSetAllToAccounts() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));

    // Act
    delegatedResourceAccountIndexCapsule.setAllToAccounts(new ArrayList<>());

    // Assert
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertTrue(toAccountsList.isEmpty());
    assertSame(toAccountsList, delegatedResourceAccountIndexCapsule.getInstance().getToAccountsList());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#setAllToAccounts(List)}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#setAllToAccounts(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.setAllToAccounts(List)"})
  public void testSetAllToAccounts2() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));
    delegatedResourceAccountIndexCapsule.setTimestamp(10L);

    // Act
    delegatedResourceAccountIndexCapsule.setAllToAccounts(new ArrayList<>());

    // Assert
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertTrue(toAccountsList.isEmpty());
    assertSame(toAccountsList, delegatedResourceAccountIndexCapsule.getInstance().getToAccountsList());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#setAllToAccounts(List)}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#setAllToAccounts(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.setAllToAccounts(List)"})
  public void testSetAllToAccounts3() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{});

    // Act
    delegatedResourceAccountIndexCapsule.setAllToAccounts(new ArrayList<>());

    // Assert
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertTrue(toAccountsList.isEmpty());
    assertSame(toAccountsList, delegatedResourceAccountIndexCapsule.getInstance().getToAccountsList());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#setAllToAccounts(List)}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#setAllToAccounts(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.setAllToAccounts(List)"})
  public void testSetAllToAccounts4() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    delegatedResourceAccountIndexCapsule.setAllToAccounts(new ArrayList<>());

    // Assert
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertTrue(toAccountsList.isEmpty());
    assertSame(toAccountsList, delegatedResourceAccountIndexCapsule.getInstance().getToAccountsList());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#addToAccount(ByteString)}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#addToAccount(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.addToAccount(ByteString)"})
  public void testAddToAccount() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));

    // Act
    delegatedResourceAccountIndexCapsule.addToAccount(mock(ByteString.class));

    // Assert
    DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getDescriptorForType().getFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 26, 0}, delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#addToAccount(ByteString)}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#addToAccount(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.addToAccount(ByteString)"})
  public void testAddToAccount2() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));
    delegatedResourceAccountIndexCapsule.setTimestamp(10L);

    // Act
    delegatedResourceAccountIndexCapsule.addToAccount(mock(ByteString.class));

    // Assert
    DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(3, instance.getAllFields().size());
    assertEquals(4, instance.getDescriptorForType().getFields().size());
    assertEquals(6, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, 26, 0, ' ', '\n'}, delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#addToAccount(ByteString)}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#addToAccount(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.addToAccount(ByteString)"})
  public void testAddToAccount3() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{});

    // Act
    delegatedResourceAccountIndexCapsule.addToAccount(mock(ByteString.class));

    // Assert
    DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(4, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{26, 0}, delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#addToAccount(ByteString)}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#addToAccount(ByteString)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.addToAccount(ByteString)"})
  public void testAddToAccount4() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    delegatedResourceAccountIndexCapsule.addToAccount(mock(ByteString.class));

    // Assert
    DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    assertEquals(4, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(
        new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#setTimestamp(long)}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#setTimestamp(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.setTimestamp(long)"})
  public void testSetTimestamp() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        mock(ByteString.class));

    // Act
    delegatedResourceAccountIndexCapsule.setTimestamp(10L);

    // Assert
    DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getDescriptorForType().getFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(new byte[]{'\n', 0, ' ', '\n'}, delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#setTimestamp(long)}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#setTimestamp(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.setTimestamp(long)"})
  public void testSetTimestamp2() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{});

    // Act
    delegatedResourceAccountIndexCapsule.setTimestamp(10L);

    // Assert
    DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertEquals(4, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{' ', '\n'}, delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#setTimestamp(long)}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#setTimestamp(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.setTimestamp(long)"})
  public void testSetTimestamp3() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Act
    delegatedResourceAccountIndexCapsule.setTimestamp(10L);

    // Assert
    DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(1, instance.getAllFields().size());
    assertEquals(18, instance.getSerializedSize());
    assertEquals(4, instance.getDescriptorForType().getFields().size());
    assertArrayEquals(new byte[]{' ', '\n', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A',
        Byte.MIN_VALUE, 'A', 'X'}, delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#getTimestamp()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#getTimestamp()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long DelegatedResourceAccountIndexCapsule.getTimestamp()"})
  public void testGetTimestamp_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new DelegatedResourceAccountIndexCapsule(mock(ByteString.class))).getTimestamp());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#createDbKey()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#createDbKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] DelegatedResourceAccountIndexCapsule.createDbKey()"})
  public void testCreateDbKey_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualCreateDbKeyResult = (new DelegatedResourceAccountIndexCapsule(address)).createDbKey();

    // Assert
    verify(address).toByteArray();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCreateDbKeyResult);
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#createDbKey()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#createDbKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] DelegatedResourceAccountIndexCapsule.createDbKey()"})
  public void testCreateDbKey_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new DelegatedResourceAccountIndexCapsule(new byte[]{})).createDbKey());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#createReadableString()}.
   * <ul>
   *   <li>Then return {@code 4158415841584158}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#createReadableString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DelegatedResourceAccountIndexCapsule.createReadableString()"})
  public void testCreateReadableString_thenReturn4158415841584158() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualCreateReadableStringResult = (new DelegatedResourceAccountIndexCapsule(address))
        .createReadableString();

    // Assert
    verify(address).toByteArray();
    assertEquals("4158415841584158", actualCreateReadableStringResult);
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#getData()}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] DelegatedResourceAccountIndexCapsule.getData()"})
  public void testGetData() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        address);
    delegatedResourceAccountIndexCapsule.setTimestamp(-1L);

    // Act
    byte[] actualData = delegatedResourceAccountIndexCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{' ', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#getData()}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] DelegatedResourceAccountIndexCapsule.getData()"})
  public void testGetData2() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        address);
    delegatedResourceAccountIndexCapsule.setTimestamp(Long.MAX_VALUE);

    // Act
    byte[] actualData = delegatedResourceAccountIndexCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{' ', -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, actualData);
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#getData()}.
   * <ul>
   *   <li>Given {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])} with data is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] DelegatedResourceAccountIndexCapsule.getData()"})
  public void testGetData_givenDelegatedResourceAccountIndexCapsuleWithDataIsEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new DelegatedResourceAccountIndexCapsule(new byte[]{})).getData());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#getData()}.
   * <ul>
   *   <li>Then return array of {@code byte} with space and lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] DelegatedResourceAccountIndexCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithSpaceAndLf() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule = new DelegatedResourceAccountIndexCapsule(
        address);
    delegatedResourceAccountIndexCapsule.setTimestamp(10L);

    // Act
    byte[] actualData = delegatedResourceAccountIndexCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{' ', '\n'}, actualData);
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#getData()}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] DelegatedResourceAccountIndexCapsule.getData()"})
  public void testGetData_thenReturnEmptyArrayOfByte() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = (new DelegatedResourceAccountIndexCapsule(address)).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[]{}, actualData);
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#getInstance()}.
   * <p>
   * Method under test: {@link DelegatedResourceAccountIndexCapsule#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DelegatedResourceAccountIndex DelegatedResourceAccountIndexCapsule.getInstance()"})
  public void testGetInstance() {
    // Arrange and Act
    DelegatedResourceAccountIndex actualInstance = (new DelegatedResourceAccountIndexCapsule(mock(ByteString.class)))
        .getInstance();

    // Assert
    assertEquals("", actualInstance.getInitializationErrorString());
    assertEquals(0, actualInstance.getFromAccountsCount());
    assertEquals(0, actualInstance.getToAccountsCount());
    assertEquals(0L, actualInstance.getTimestamp());
    assertEquals(1, actualInstance.getAllFields().size());
    assertEquals(2, actualInstance.getSerializedSize());
    assertTrue(actualInstance.findInitializationErrors().isEmpty());
    List<ByteString> fromAccountsList = actualInstance.getFromAccountsList();
    assertTrue(fromAccountsList.isEmpty());
    assertTrue(actualInstance.isInitialized());
    assertSame(fromAccountsList, actualInstance.getToAccountsList());
  }
}
