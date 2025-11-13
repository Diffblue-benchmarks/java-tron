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
   * Test {@link
   * DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(ByteString)}.
   *
   * <p>Method under test: {@link
   * DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(ByteString)"})
  public void testNewDelegatedResourceAccountIndexCapsule() {
    // Arrange
    ByteString address = mock(ByteString.class);

    // Act
    DelegatedResourceAccountIndexCapsule actualDelegatedResourceAccountIndexCapsule =
        new DelegatedResourceAccountIndexCapsule(address);

    // Assert
    DelegatedResourceAccountIndex instance =
        actualDelegatedResourceAccountIndexCapsule.getInstance();
    assertEquals("", instance.getInitializationErrorString());
    assertEquals(0, instance.getFromAccountsCount());
    assertEquals(0, instance.getToAccountsCount());
    assertEquals(0L, actualDelegatedResourceAccountIndexCapsule.getTimestamp());
    assertEquals(0L, instance.getTimestamp());
    assertEquals(1, instance.getAllFields().size());
    assertEquals(2, instance.getSerializedSize());
    assertTrue(instance.findInitializationErrors().isEmpty());
    List<ByteString> fromAccountsList =
        actualDelegatedResourceAccountIndexCapsule.getFromAccountsList();
    assertTrue(fromAccountsList.isEmpty());
    assertSame(fromAccountsList, actualDelegatedResourceAccountIndexCapsule.getToAccountsList());
    assertSame(fromAccountsList, instance.getFromAccountsList());
    assertSame(fromAccountsList, instance.getToAccountsList());
    assertSame(address, actualDelegatedResourceAccountIndexCapsule.getAccount());
    assertSame(address, instance.getAccount());
    assertArrayEquals(new byte[] {'\n', 0}, actualDelegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   *
   * <p>Method under test: {@link
   * DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule2() {
    // Arrange and Act
    DelegatedResourceAccountIndexCapsule actualDelegatedResourceAccountIndexCapsule =
        new DelegatedResourceAccountIndexCapsule(new byte[] {});

    // Assert
    DelegatedResourceAccountIndex instance =
        actualDelegatedResourceAccountIndexCapsule.getInstance();
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
    List<ByteString> fromAccountsList =
        actualDelegatedResourceAccountIndexCapsule.getFromAccountsList();
    assertTrue(fromAccountsList.isEmpty());
    assertTrue(instance.getAllFields().isEmpty());
    DelegatedResourceAccountIndex actualDefaultInstanceForType =
        instance.getDefaultInstanceForType();
    assertEquals(instance, actualDefaultInstanceForType);
    assertSame(account, instance.getAccount());
    assertSame(fromAccountsList, actualDelegatedResourceAccountIndexCapsule.getToAccountsList());
    assertSame(fromAccountsList, instance.getFromAccountsList());
    assertSame(fromAccountsList, instance.getToAccountsList());
    assertArrayEquals(new byte[] {}, actualDelegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A A A A} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenAAAAAAAABytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new DelegatedResourceAccountIndexCapsule("A\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"))
            .getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A A A} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenAAAAAAABytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new DelegatedResourceAccountIndexCapsule("\n\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"))
            .getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and lf.
   * </ul>
   *
   * <p>Method under test: {@link
   * DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenArrayOfByteWithAAndLf() {
    // Arrange and Act
    DelegatedResourceAccountIndexCapsule actualDelegatedResourceAccountIndexCapsule =
        new DelegatedResourceAccountIndexCapsule(
            new byte[] {
              'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 0, '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualDelegatedResourceAccountIndexCapsule.getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and lf.
   * </ul>
   *
   * <p>Method under test: {@link
   * DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenArrayOfByteWithEighteenAndLf() {
    // Arrange and Act
    DelegatedResourceAccountIndexCapsule actualDelegatedResourceAccountIndexCapsule =
        new DelegatedResourceAccountIndexCapsule(
            new byte[] {
              18, '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualDelegatedResourceAccountIndexCapsule.getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenArrayOfByteWithEighteenAndX() {
    // Arrange and Act
    DelegatedResourceAccountIndexCapsule actualDelegatedResourceAccountIndexCapsule =
        new DelegatedResourceAccountIndexCapsule(
            new byte[] {18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualDelegatedResourceAccountIndexCapsule.getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with eighteen and zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenArrayOfByteWithEighteenAndZero() {
    // Arrange and Act
    DelegatedResourceAccountIndexCapsule actualDelegatedResourceAccountIndexCapsule =
        new DelegatedResourceAccountIndexCapsule(new byte[] {18, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualDelegatedResourceAccountIndexCapsule.getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenArrayOfByteWithMinusOneAndX() {
    // Arrange and Act
    DelegatedResourceAccountIndexCapsule actualDelegatedResourceAccountIndexCapsule =
        new DelegatedResourceAccountIndexCapsule(
            new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualDelegatedResourceAccountIndexCapsule.getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and lf.
   * </ul>
   *
   * <p>Method under test: {@link
   * DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenArrayOfByteWithTwentySixAndLf() {
    // Arrange and Act
    DelegatedResourceAccountIndexCapsule actualDelegatedResourceAccountIndexCapsule =
        new DelegatedResourceAccountIndexCapsule(
            new byte[] {
              26, '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n'
            });

    // Assert
    assertNull(actualDelegatedResourceAccountIndexCapsule.getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenArrayOfByteWithTwentySixAndX() {
    // Arrange and Act
    DelegatedResourceAccountIndexCapsule actualDelegatedResourceAccountIndexCapsule =
        new DelegatedResourceAccountIndexCapsule(
            new byte[] {26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualDelegatedResourceAccountIndexCapsule.getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenArrayOfByteWithTwentySixAndZero() {
    // Arrange and Act
    DelegatedResourceAccountIndexCapsule actualDelegatedResourceAccountIndexCapsule =
        new DelegatedResourceAccountIndexCapsule(new byte[] {26, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualDelegatedResourceAccountIndexCapsule.getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenArrayOfByteWithZeroAndX() {
    // Arrange and Act
    DelegatedResourceAccountIndexCapsule actualDelegatedResourceAccountIndexCapsule =
        new DelegatedResourceAccountIndexCapsule(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualDelegatedResourceAccountIndexCapsule.getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new DelegatedResourceAccountIndexCapsule("AXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenXaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new DelegatedResourceAccountIndexCapsule(" XAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DelegatedResourceAccountIndexCapsule#DelegatedResourceAccountIndexCapsule(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.<init>(byte[])"})
  public void testNewDelegatedResourceAccountIndexCapsule_whenXxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new DelegatedResourceAccountIndexCapsule("XXAXAXAX".getBytes("UTF-8")).getInstance());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#getAccount()}.
   *
   * <p>Method under test: {@link DelegatedResourceAccountIndexCapsule#getAccount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ByteString DelegatedResourceAccountIndexCapsule.getAccount()"})
  public void testGetAccount() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule =
        new DelegatedResourceAccountIndexCapsule(mock(ByteString.class));

    // Act
    delegatedResourceAccountIndexCapsule.getAccount();

    // Assert
    DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    List<FieldDescriptor> fields = instance.getDescriptorForType().getFields();
    assertEquals(4, fields.size());
    ByteString byteString = ByteString.EMPTY;
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, instance.getDefaultInstanceForType().getAccount());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#setAccount(ByteString)}.
   *
   * <p>Method under test: {@link DelegatedResourceAccountIndexCapsule#setAccount(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.setAccount(ByteString)"})
  public void testSetAccount() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule =
        new DelegatedResourceAccountIndexCapsule(mock(ByteString.class));
    ByteString address = mock(ByteString.class);

    // Act
    delegatedResourceAccountIndexCapsule.setAccount(address);

    // Assert
    assertSame(address, delegatedResourceAccountIndexCapsule.getAccount());
    assertSame(address, delegatedResourceAccountIndexCapsule.getInstance().getAccount());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#getFromAccountsList()}.
   *
   * <p>Method under test: {@link DelegatedResourceAccountIndexCapsule#getFromAccountsList()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DelegatedResourceAccountIndexCapsule.getFromAccountsList()"})
  public void testGetFromAccountsList() {
    // Arrange, Act and Assert
    assertTrue(
        new DelegatedResourceAccountIndexCapsule(mock(ByteString.class))
            .getFromAccountsList()
            .isEmpty());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#setAllFromAccounts(List)}.
   *
   * <p>Method under test: {@link DelegatedResourceAccountIndexCapsule#setAllFromAccounts(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.setAllFromAccounts(List)"})
  public void testSetAllFromAccounts() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule =
        new DelegatedResourceAccountIndexCapsule(mock(ByteString.class));

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
   *
   * <p>Method under test: {@link DelegatedResourceAccountIndexCapsule#addFromAccount(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.addFromAccount(ByteString)"})
  public void testAddFromAccount() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule =
        new DelegatedResourceAccountIndexCapsule(mock(ByteString.class));
    ByteString fromAccount = mock(ByteString.class);

    // Act
    delegatedResourceAccountIndexCapsule.addFromAccount(fromAccount);

    // Assert
    List<ByteString> fromAccountsList = delegatedResourceAccountIndexCapsule.getFromAccountsList();
    assertEquals(1, fromAccountsList.size());
    DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(1, instance.getFromAccountsCount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertTrue(toAccountsList.isEmpty());
    DelegatedResourceAccountIndex defaultInstanceForType = instance.getDefaultInstanceForType();
    assertSame(toAccountsList, defaultInstanceForType.getFromAccountsList());
    assertSame(toAccountsList, instance.getToAccountsList());
    assertSame(toAccountsList, defaultInstanceForType.getToAccountsList());
    assertSame(fromAccount, fromAccountsList.get(0));
    assertArrayEquals(new byte[] {'\n', 0, 18, 0}, delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#getToAccountsList()}.
   *
   * <p>Method under test: {@link DelegatedResourceAccountIndexCapsule#getToAccountsList()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DelegatedResourceAccountIndexCapsule.getToAccountsList()"})
  public void testGetToAccountsList() {
    // Arrange, Act and Assert
    assertTrue(
        new DelegatedResourceAccountIndexCapsule(mock(ByteString.class))
            .getToAccountsList()
            .isEmpty());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#setAllToAccounts(List)}.
   *
   * <p>Method under test: {@link DelegatedResourceAccountIndexCapsule#setAllToAccounts(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.setAllToAccounts(List)"})
  public void testSetAllToAccounts() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule =
        new DelegatedResourceAccountIndexCapsule(mock(ByteString.class));

    // Act
    delegatedResourceAccountIndexCapsule.setAllToAccounts(new ArrayList<>());

    // Assert
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertTrue(toAccountsList.isEmpty());
    assertSame(
        toAccountsList, delegatedResourceAccountIndexCapsule.getInstance().getToAccountsList());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#addToAccount(ByteString)}.
   *
   * <p>Method under test: {@link DelegatedResourceAccountIndexCapsule#addToAccount(ByteString)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.addToAccount(ByteString)"})
  public void testAddToAccount() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule =
        new DelegatedResourceAccountIndexCapsule(mock(ByteString.class));
    ByteString toAccount = mock(ByteString.class);

    // Act
    delegatedResourceAccountIndexCapsule.addToAccount(toAccount);

    // Assert
    List<ByteString> toAccountsList = delegatedResourceAccountIndexCapsule.getToAccountsList();
    assertEquals(1, toAccountsList.size());
    DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(1, instance.getToAccountsCount());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertSame(toAccountsList, instance.getToAccountsList());
    assertSame(toAccount, toAccountsList.get(0));
    assertArrayEquals(new byte[] {'\n', 0, 26, 0}, delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#setTimestamp(long)}.
   *
   * <p>Method under test: {@link DelegatedResourceAccountIndexCapsule#setTimestamp(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DelegatedResourceAccountIndexCapsule.setTimestamp(long)"})
  public void testSetTimestamp() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule =
        new DelegatedResourceAccountIndexCapsule(mock(ByteString.class));

    // Act
    delegatedResourceAccountIndexCapsule.setTimestamp(10L);

    // Assert
    assertEquals(10L, delegatedResourceAccountIndexCapsule.getTimestamp());
    DelegatedResourceAccountIndex instance = delegatedResourceAccountIndexCapsule.getInstance();
    assertEquals(10L, instance.getTimestamp());
    assertEquals(2, instance.getAllFields().size());
    assertEquals(4, instance.getSerializedSize());
    assertArrayEquals(
        new byte[] {'\n', 0, ' ', '\n'}, delegatedResourceAccountIndexCapsule.getData());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#getTimestamp()}.
   *
   * <p>Method under test: {@link DelegatedResourceAccountIndexCapsule#getTimestamp()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DelegatedResourceAccountIndexCapsule.getTimestamp()"})
  public void testGetTimestamp() {
    // Arrange, Act and Assert
    assertEquals(
        0L, new DelegatedResourceAccountIndexCapsule(mock(ByteString.class)).getTimestamp());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#createDbKey()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceAccountIndexCapsule#createDbKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DelegatedResourceAccountIndexCapsule.createDbKey()"})
  public void testCreateDbKey_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualCreateDbKeyResult =
        new DelegatedResourceAccountIndexCapsule(address).createDbKey();

    // Assert
    verify(address).toByteArray();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCreateDbKeyResult);
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#createDbKey()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceAccountIndexCapsule#createDbKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DelegatedResourceAccountIndexCapsule.createDbKey()"})
  public void testCreateDbKey_thenReturnEmptyArrayOfByte() {
    // Arrange
    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule =
        new DelegatedResourceAccountIndexCapsule(new byte[] {});

    // Act and Assert
    assertArrayEquals(new byte[] {}, delegatedResourceAccountIndexCapsule.createDbKey());
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#createReadableString()}.
   *
   * <ul>
   *   <li>Then return {@code 4158415841584158}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceAccountIndexCapsule#createReadableString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DelegatedResourceAccountIndexCapsule.createReadableString()"})
  public void testCreateReadableString_thenReturn4158415841584158()
      throws UnsupportedEncodingException {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualCreateReadableStringResult =
        new DelegatedResourceAccountIndexCapsule(address).createReadableString();

    // Assert
    verify(address).toByteArray();
    assertEquals("4158415841584158", actualCreateReadableStringResult);
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#getData()}.
   *
   * <p>Method under test: {@link DelegatedResourceAccountIndexCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DelegatedResourceAccountIndexCapsule.getData()"})
  public void testGetData() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule =
        new DelegatedResourceAccountIndexCapsule(mock(ByteString.class));
    delegatedResourceAccountIndexCapsule.setTimestamp(-1L);
    delegatedResourceAccountIndexCapsule.setAccount(address);

    // Act
    byte[] actualData = delegatedResourceAccountIndexCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[] {' ', -1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, actualData);
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#getData()}.
   *
   * <p>Method under test: {@link DelegatedResourceAccountIndexCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DelegatedResourceAccountIndexCapsule.getData()"})
  public void testGetData2() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule =
        new DelegatedResourceAccountIndexCapsule(mock(ByteString.class));
    delegatedResourceAccountIndexCapsule.setTimestamp(Long.MAX_VALUE);
    delegatedResourceAccountIndexCapsule.setAccount(address);

    // Act
    byte[] actualData = delegatedResourceAccountIndexCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[] {' ', -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, actualData);
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#getData()}.
   *
   * <ul>
   *   <li>Given {@link ByteString} {@link ByteString#size()} return zero.
   *   <li>Then return array of {@code byte} with lf and zero.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceAccountIndexCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DelegatedResourceAccountIndexCapsule.getData()"})
  public void testGetData_givenByteStringSizeReturnZero_thenReturnArrayOfByteWithLfAndZero() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.size()).thenReturn(0);
    when(address.isEmpty()).thenReturn(false);

    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule =
        new DelegatedResourceAccountIndexCapsule(mock(ByteString.class));
    delegatedResourceAccountIndexCapsule.setAccount(address);

    // Act
    byte[] actualData = delegatedResourceAccountIndexCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    verify(address, atLeast(1)).size();
    assertArrayEquals(new byte[] {'\n', 0}, actualData);
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with space and lf.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceAccountIndexCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DelegatedResourceAccountIndexCapsule.getData()"})
  public void testGetData_thenReturnArrayOfByteWithSpaceAndLf() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule =
        new DelegatedResourceAccountIndexCapsule(mock(ByteString.class));
    delegatedResourceAccountIndexCapsule.setTimestamp(10L);
    delegatedResourceAccountIndexCapsule.setAccount(address);

    // Act
    byte[] actualData = delegatedResourceAccountIndexCapsule.getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[] {' ', '\n'}, actualData);
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#getData()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link DelegatedResourceAccountIndexCapsule#getData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DelegatedResourceAccountIndexCapsule.getData()"})
  public void testGetData_thenReturnEmptyArrayOfByte() {
    // Arrange
    ByteString address = mock(ByteString.class);
    when(address.isEmpty()).thenReturn(true);

    // Act
    byte[] actualData = new DelegatedResourceAccountIndexCapsule(address).getData();

    // Assert
    verify(address, atLeast(1)).isEmpty();
    assertArrayEquals(new byte[] {}, actualData);
  }

  /**
   * Test {@link DelegatedResourceAccountIndexCapsule#getInstance()}.
   *
   * <p>Method under test: {@link DelegatedResourceAccountIndexCapsule#getInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DelegatedResourceAccountIndex DelegatedResourceAccountIndexCapsule.getInstance()"
  })
  public void testGetInstance() {
    // Arrange and Act
    DelegatedResourceAccountIndex actualInstance =
        new DelegatedResourceAccountIndexCapsule(mock(ByteString.class)).getInstance();

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
    assertSame(fromAccountsList, actualInstance.getToAccountsList());
  }
}
