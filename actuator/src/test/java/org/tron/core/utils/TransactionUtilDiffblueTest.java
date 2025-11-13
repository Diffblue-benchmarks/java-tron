package org.tron.core.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.api.GrpcAPI;
import org.tron.api.GrpcAPI.TransactionSignWeight;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.exception.PermissionException;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Permission;
import org.tron.protos.Protocol.Transaction;
import org.tron.protos.Protocol.Transaction.Contract;
import org.tron.protos.Protocol.Transaction.Result;
import org.tron.protos.Protocol.Transaction.Result.contractResult;

public class TransactionUtilDiffblueTest {
  /**
   * Test {@link TransactionUtil#validAccountName(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#validAccountName(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransactionUtil.validAccountName(byte[])"})
  public void testValidAccountName_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(TransactionUtil.validAccountName("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionUtil#validAccountName(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#validAccountName(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransactionUtil.validAccountName(byte[])"})
  public void testValidAccountName_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertTrue(TransactionUtil.validAccountName(new byte[] {}));
  }

  /**
   * Test {@link TransactionUtil#validAccountName(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#validAccountName(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransactionUtil.validAccountName(byte[])"})
  public void testValidAccountName_whenNull() {
    // Arrange, Act and Assert
    assertTrue(TransactionUtil.validAccountName(null));
  }

  /**
   * Test {@link TransactionUtil#validAssetDescription(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#validAssetDescription(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransactionUtil.validAssetDescription(byte[])"})
  public void testValidAssetDescription_whenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(TransactionUtil.validAssetDescription("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionUtil#validAssetDescription(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#validAssetDescription(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransactionUtil.validAssetDescription(byte[])"})
  public void testValidAssetDescription_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertTrue(TransactionUtil.validAssetDescription(new byte[] {}));
  }

  /**
   * Test {@link TransactionUtil#validAssetDescription(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#validAssetDescription(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransactionUtil.validAssetDescription(byte[])"})
  public void testValidAssetDescription_whenNull() {
    // Arrange, Act and Assert
    assertTrue(TransactionUtil.validAssetDescription(null));
  }

  /**
   * Test {@link TransactionUtil#validUrl(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#validUrl(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransactionUtil.validUrl(byte[])"})
  public void testValidUrl_whenAxaxaxaxBytesIsUtf8_thenReturnTrue()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(TransactionUtil.validUrl("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionUtil#validUrl(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#validUrl(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransactionUtil.validUrl(byte[])"})
  public void testValidUrl_whenEmptyArrayOfByte_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(TransactionUtil.validUrl(new byte[] {}));
  }

  /**
   * Test {@link TransactionUtil#validUrl(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#validUrl(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransactionUtil.validUrl(byte[])"})
  public void testValidUrl_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(TransactionUtil.validUrl(null));
  }

  /**
   * Test {@link TransactionUtil#validAccountId(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#validAccountId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransactionUtil.validAccountId(byte[])"})
  public void testValidAccountId_whenAAAAAAAABytesIsUtf8_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(TransactionUtil.validAccountId("A A A A A A A A ".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionUtil#validAccountId(byte[])}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#validAccountId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransactionUtil.validAccountId(byte[])"})
  public void testValidAccountId_whenA_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        TransactionUtil.validAccountId(
            new byte[] {Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionUtil#validAccountId(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#validAccountId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransactionUtil.validAccountId(byte[])"})
  public void testValidAccountId_whenAxaxaxaxBytesIsUtf8_thenReturnTrue()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(TransactionUtil.validAccountId("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionUtil#validAccountId(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#validAccountId(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransactionUtil.validAccountId(byte[])"})
  public void testValidAccountId_whenEmptyArrayOfByte_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(TransactionUtil.validAccountId(new byte[] {}));
  }

  /**
   * Test {@link TransactionUtil#validAssetName(byte[])}.
   *
   * <ul>
   *   <li>When {@code A A A A A A A A} Bytes is {@code UTF-8}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#validAssetName(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransactionUtil.validAssetName(byte[])"})
  public void testValidAssetName_whenAAAAAAAABytesIsUtf8_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(TransactionUtil.validAssetName("A A A A A A A A ".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionUtil#validAssetName(byte[])}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#validAssetName(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransactionUtil.validAssetName(byte[])"})
  public void testValidAssetName_whenA_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        TransactionUtil.validAssetName(
            new byte[] {Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionUtil#validAssetName(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#validAssetName(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransactionUtil.validAssetName(byte[])"})
  public void testValidAssetName_whenAxaxaxaxBytesIsUtf8_thenReturnTrue()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(TransactionUtil.validAssetName("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionUtil#validAssetName(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#validAssetName(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransactionUtil.validAssetName(byte[])"})
  public void testValidAssetName_whenEmptyArrayOfByte_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(TransactionUtil.validAssetName(new byte[] {}));
  }

  /**
   * Test {@link TransactionUtil#validTokenAbbrName(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#validTokenAbbrName(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransactionUtil.validTokenAbbrName(byte[])"})
  public void testValidTokenAbbrName_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(TransactionUtil.validTokenAbbrName("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionUtil#validTokenAbbrName(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#validTokenAbbrName(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransactionUtil.validTokenAbbrName(byte[])"})
  public void testValidTokenAbbrName_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertFalse(TransactionUtil.validTokenAbbrName(new byte[] {}));
  }

  /**
   * Test {@link TransactionUtil#getTransactionId(Transaction)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return not ByteString Empty.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#getTransactionId(Protocol.Transaction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sha256Hash TransactionUtil.getTransactionId(Protocol.Transaction)"})
  public void testGetTransactionId_whenDefaultInstance_thenReturnNotByteStringEmpty() {
    // Arrange and Act
    Sha256Hash actualTransactionId =
        TransactionUtil.getTransactionId(Transaction.getDefaultInstance());

    // Assert
    ByteString byteString = actualTransactionId.getByteString();
    assertFalse(byteString.isEmpty());
    ByteIterator iteratorResult = byteString.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals((byte) -29, iteratorResult.next().byteValue());
    assertEquals((byte) -80, iteratorResult.next().byteValue());
    assertEquals((byte) -60, iteratorResult.next().byteValue());
    assertEquals("��B��\u001c\u0014���șo�$'�A�d��L���\u001bxR�U", byteString.toStringUtf8());
    assertArrayEquals(
        new byte[] {
          -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82,
          'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'
        },
        actualTransactionId.getBytes());
    BigInteger toBigIntegerResult = actualTransactionId.toBigInteger();
    assertEquals(0, toBigIntegerResult.getLowestSetBit());
    assertEquals(1, toBigIntegerResult.signum());
    assertArrayEquals(
        new byte[] {
          0, -29, -80, -60, 'B', -104, -4, 28, 20, -102, -5, -12, -56, -103, 'o', -71, '$', '\'',
          -82, 'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'
        },
        toBigIntegerResult.toByteArray());
    assertEquals(
        "102987336249554097029535212322581322789799900648198034993379397001115665086549",
        toBigIntegerResult.toString());
  }

  /**
   * Test {@link TransactionUtil#getContractRet(Transaction)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>Then calls {@link Protocol.Transaction#getRetCount()}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#getContractRet(Protocol.Transaction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"contractResult TransactionUtil.getContractRet(Protocol.Transaction)"})
  public void testGetContractRet_givenZero_thenCallsGetRetCount() {
    // Arrange
    Transaction transaction = mock(Transaction.class);
    when(transaction.getRetCount()).thenReturn(0);

    // Act
    contractResult actualContractRet = TransactionUtil.getContractRet(transaction);

    // Assert
    verify(transaction).getRetCount();
    assertNull(actualContractRet);
  }

  /**
   * Test {@link TransactionUtil#getContractRet(Transaction)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#getContractRet(Protocol.Transaction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"contractResult TransactionUtil.getContractRet(Protocol.Transaction)"})
  public void testGetContractRet_whenDefaultInstance_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TransactionUtil.getContractRet(Transaction.getDefaultInstance()));
  }

  /**
   * Test {@link TransactionUtil#getCallTokenValue(Contract)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#getCallTokenValue(Protocol.Transaction.Contract)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long TransactionUtil.getCallTokenValue(Protocol.Transaction.Contract)"})
  public void testGetCallTokenValue_whenDefaultInstance() {
    // Arrange, Act and Assert
    assertEquals(0L, TransactionUtil.getCallTokenValue(Contract.getDefaultInstance()));
  }

  /**
   * Test {@link TransactionUtil#getCallTokenValue(Contract)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#getCallTokenValue(Protocol.Transaction.Contract)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long TransactionUtil.getCallTokenValue(Protocol.Transaction.Contract)"})
  public void testGetCallTokenValue_whenNull() {
    // Arrange, Act and Assert
    assertEquals(0L, TransactionUtil.getCallTokenValue(null));
  }

  /**
   * Test {@link TransactionUtil#generateContractAddress(byte[], byte[])} with {@code ownerAddress},
   * {@code txRawDataHash}.
   *
   * <p>Method under test: {@link TransactionUtil#generateContractAddress(byte[], byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TransactionUtil.generateContractAddress(byte[], byte[])"})
  public void testGenerateContractAddressWithOwnerAddressTxRawDataHash()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualGenerateContractAddressResult =
        TransactionUtil.generateContractAddress(
            "AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[] {
          'A', '{', -23, 'i', -48, -7, -113, -47, '4', -19, -90, -77, -105, -79, '@', 'I', 'w', -34,
          '1', 'F', 16
        },
        actualGenerateContractAddressResult);
  }

  /**
   * Test {@link TransactionUtil#generateContractAddress(byte[], long)} with {@code
   * transactionRootId}, {@code nonce}.
   *
   * <p>Method under test: {@link TransactionUtil#generateContractAddress(byte[], long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TransactionUtil.generateContractAddress(byte[], long)"})
  public void testGenerateContractAddressWithTransactionRootIdNonce()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          'A', '<', '>', '0', 24, 23, 'F', -11, -104, 'F', 'M', 'h', 't', -120, -36, 'I', 't', -46,
          -43, 'D', '9'
        },
        TransactionUtil.generateContractAddress("AXAXAXAX".getBytes("UTF-8"), 1L));
  }

  /**
   * Test {@link TransactionUtil#checkPermissionOperations(Permission, Contract)}.
   *
   * <ul>
   *   <li>Given {@link ByteString} {@link ByteString#byteAt(int)} return {@code A}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#checkPermissionOperations(Permission,
   * Protocol.Transaction.Contract)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TransactionUtil.checkPermissionOperations(Permission, Protocol.Transaction.Contract)"
  })
  public void testCheckPermissionOperations_givenByteStringByteAtReturnA_thenReturnTrue()
      throws PermissionException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.byteAt(anyInt())).thenReturn((byte) 'A');
    when(byteString.size()).thenReturn(ZenChainParams.ZC_JUBJUB_POINT_SIZE);

    Permission permission = mock(Permission.class);
    when(permission.getOperations()).thenReturn(byteString);

    // Act
    boolean actualCheckPermissionOperationsResult =
        TransactionUtil.checkPermissionOperations(permission, Contract.getDefaultInstance());

    // Assert
    verify(byteString).byteAt(0);
    verify(byteString).size();
    verify(permission).getOperations();
    assertTrue(actualCheckPermissionOperationsResult);
  }

  /**
   * Test {@link TransactionUtil#checkPermissionOperations(Permission, Contract)}.
   *
   * <ul>
   *   <li>Given {@link ByteString} {@link ByteString#size()} return three.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#checkPermissionOperations(Permission,
   * Protocol.Transaction.Contract)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TransactionUtil.checkPermissionOperations(Permission, Protocol.Transaction.Contract)"
  })
  public void testCheckPermissionOperations_givenByteStringSizeReturnThree()
      throws PermissionException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.size()).thenReturn(3);

    Permission permission = mock(Permission.class);
    when(permission.getOperations()).thenReturn(byteString);

    // Act and Assert
    assertThrows(
        PermissionException.class,
        () -> TransactionUtil.checkPermissionOperations(permission, Contract.getDefaultInstance()));
    verify(byteString).size();
    verify(permission).getOperations();
  }

  /**
   * Test {@link TransactionUtil#checkPermissionOperations(Permission, Contract)}.
   *
   * <ul>
   *   <li>Given forty-two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#checkPermissionOperations(Permission,
   * Protocol.Transaction.Contract)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TransactionUtil.checkPermissionOperations(Permission, Protocol.Transaction.Contract)"
  })
  public void testCheckPermissionOperations_givenFortyTwo_thenReturnFalse()
      throws PermissionException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.byteAt(anyInt())).thenReturn((byte) 'A');
    when(byteString.size()).thenReturn(ZenChainParams.ZC_JUBJUB_POINT_SIZE);

    Permission permission = mock(Permission.class);
    when(permission.getOperations()).thenReturn(byteString);

    Contract contract = mock(Contract.class);
    when(contract.getTypeValue()).thenReturn(42);

    // Act
    boolean actualCheckPermissionOperationsResult =
        TransactionUtil.checkPermissionOperations(permission, contract);

    // Assert
    verify(byteString).byteAt(5);
    verify(byteString).size();
    verify(permission).getOperations();
    verify(contract).getTypeValue();
    assertFalse(actualCheckPermissionOperationsResult);
  }

  /**
   * Test {@link TransactionUtil#checkPermissionOperations(Permission, Contract)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then throw {@link PermissionException}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#checkPermissionOperations(Permission,
   * Protocol.Transaction.Contract)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TransactionUtil.checkPermissionOperations(Permission, Protocol.Transaction.Contract)"
  })
  public void testCheckPermissionOperations_whenDefaultInstance_thenThrowPermissionException()
      throws PermissionException {
    // Arrange, Act and Assert
    assertThrows(
        PermissionException.class,
        () ->
            TransactionUtil.checkPermissionOperations(
                Permission.getDefaultInstance(), Contract.getDefaultInstance()));
  }

  /**
   * Test {@link TransactionUtil#makeUpperCamelMethod(String)}.
   *
   * <ul>
   *   <li>When {@code get}.
   *   <li>Then return {@code getGet}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#makeUpperCamelMethod(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TransactionUtil.makeUpperCamelMethod(String)"})
  public void testMakeUpperCamelMethod_whenGet_thenReturnGetGet() {
    // Arrange, Act and Assert
    assertEquals("getGet", TransactionUtil.makeUpperCamelMethod("get"));
  }

  /**
   * Test {@link TransactionUtil#makeUpperCamelMethod(String)}.
   *
   * <ul>
   *   <li>When {@code Origin Name}.
   *   <li>Then return {@code getOrigin name}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#makeUpperCamelMethod(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TransactionUtil.makeUpperCamelMethod(String)"})
  public void testMakeUpperCamelMethod_whenOriginName_thenReturnGetOriginName() {
    // Arrange, Act and Assert
    assertEquals("getOrigin name", TransactionUtil.makeUpperCamelMethod("Origin Name"));
  }

  /**
   * Test {@link TransactionUtil#makeUpperCamelMethod(String)}.
   *
   * <ul>
   *   <li>When {@code __}.
   *   <li>Then return {@code get}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#makeUpperCamelMethod(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TransactionUtil.makeUpperCamelMethod(String)"})
  public void testMakeUpperCamelMethod_whenUnderscoreUnderscore_thenReturnGet() {
    // Arrange, Act and Assert
    assertEquals("get", TransactionUtil.makeUpperCamelMethod("__"));
  }

  /**
   * Test {@link TransactionUtil#makeUpperCamelMethod(String)}.
   *
   * <ul>
   *   <li>When {@code _}.
   *   <li>Then return {@code get}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#makeUpperCamelMethod(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TransactionUtil.makeUpperCamelMethod(String)"})
  public void testMakeUpperCamelMethod_whenUnderscore_thenReturnGet() {
    // Arrange, Act and Assert
    assertEquals("get", TransactionUtil.makeUpperCamelMethod("_"));
  }

  /**
   * Test {@link TransactionUtil#getTransactionSignWeight(Transaction)}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link TransactionUtil#getTransactionSignWeight(Protocol.Transaction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GrpcAPI.TransactionSignWeight TransactionUtil.getTransactionSignWeight(Protocol.Transaction)"
  })
  public void testGetTransactionSignWeight_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    TransactionSignWeight actualTransactionSignWeight =
        new TransactionUtil().getTransactionSignWeight(Transaction.getDefaultInstance());

    // Assert
    assertEquals("", actualTransactionSignWeight.getInitializationErrorString());
    assertEquals(0, actualTransactionSignWeight.getApprovedListCount());
    assertEquals(0L, actualTransactionSignWeight.getCurrentWeight());
    assertEquals(2, actualTransactionSignWeight.getAllFields().size());
    assertEquals(86, actualTransactionSignWeight.getSerializedSize());
    assertFalse(actualTransactionSignWeight.hasPermission());
    assertTrue(actualTransactionSignWeight.findInitializationErrors().isEmpty());
    assertTrue(actualTransactionSignWeight.getApprovedListList().isEmpty());
    assertTrue(actualTransactionSignWeight.hasResult());
    assertTrue(actualTransactionSignWeight.hasTransaction());
  }

  /**
   * Test {@link TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long TransactionUtil.estimateConsumeBandWidthSize(DynamicPropertiesStore, long)"
  })
  public void testEstimateConsumeBandWidthSize_givenFalse() {
    // Arrange
    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.supportMaxDelegateLockPeriod()).thenReturn(false);

    // Act
    long actualEstimateConsumeBandWidthSizeResult =
        TransactionUtil.estimateConsumeBandWidthSize(dps, 42L);

    // Assert
    verify(dps).supportMaxDelegateLockPeriod();
    assertEquals(275L, actualEstimateConsumeBandWidthSizeResult);
  }

  /**
   * Test {@link TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}.
   *
   * <ul>
   *   <li>Given {@link Long#MAX_VALUE}.
   *   <li>Then return two hundred eighty-five.
   * </ul>
   *
   * <p>Method under test: {@link
   * TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long TransactionUtil.estimateConsumeBandWidthSize(DynamicPropertiesStore, long)"
  })
  public void testEstimateConsumeBandWidthSize_givenMax_value_thenReturnTwoHundredEightyFive() {
    // Arrange
    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.getMaxDelegateLockPeriod()).thenReturn(Long.MAX_VALUE);
    when(dps.supportMaxDelegateLockPeriod()).thenReturn(true);

    // Act
    long actualEstimateConsumeBandWidthSizeResult =
        TransactionUtil.estimateConsumeBandWidthSize(dps, 42L);

    // Assert
    verify(dps).getMaxDelegateLockPeriod();
    verify(dps).supportMaxDelegateLockPeriod();
    assertEquals(285L, actualEstimateConsumeBandWidthSizeResult);
  }

  /**
   * Test {@link TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>Then return two hundred eighty-six.
   * </ul>
   *
   * <p>Method under test: {@link
   * TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long TransactionUtil.estimateConsumeBandWidthSize(DynamicPropertiesStore, long)"
  })
  public void testEstimateConsumeBandWidthSize_givenMinusOne_thenReturnTwoHundredEightySix() {
    // Arrange
    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.getMaxDelegateLockPeriod()).thenReturn(-1L);
    when(dps.supportMaxDelegateLockPeriod()).thenReturn(true);

    // Act
    long actualEstimateConsumeBandWidthSizeResult =
        TransactionUtil.estimateConsumeBandWidthSize(dps, 42L);

    // Assert
    verify(dps).getMaxDelegateLockPeriod();
    verify(dps).supportMaxDelegateLockPeriod();
    assertEquals(286L, actualEstimateConsumeBandWidthSizeResult);
  }

  /**
   * Test {@link TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return two hundred seventy-seven.
   * </ul>
   *
   * <p>Method under test: {@link
   * TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long TransactionUtil.estimateConsumeBandWidthSize(DynamicPropertiesStore, long)"
  })
  public void testEstimateConsumeBandWidthSize_givenOne_thenReturnTwoHundredSeventySeven() {
    // Arrange
    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.getMaxDelegateLockPeriod()).thenReturn(1L);
    when(dps.supportMaxDelegateLockPeriod()).thenReturn(true);

    // Act
    long actualEstimateConsumeBandWidthSizeResult =
        TransactionUtil.estimateConsumeBandWidthSize(dps, 42L);

    // Assert
    verify(dps).getMaxDelegateLockPeriod();
    verify(dps).supportMaxDelegateLockPeriod();
    assertEquals(277L, actualEstimateConsumeBandWidthSizeResult);
  }

  /**
   * Test {@link TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return two hundred seventy-five.
   * </ul>
   *
   * <p>Method under test: {@link
   * TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long TransactionUtil.estimateConsumeBandWidthSize(DynamicPropertiesStore, long)"
  })
  public void testEstimateConsumeBandWidthSize_whenZero_thenReturnTwoHundredSeventyFive() {
    // Arrange
    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.getMaxDelegateLockPeriod()).thenReturn(1L);
    when(dps.supportMaxDelegateLockPeriod()).thenReturn(true);

    // Act
    long actualEstimateConsumeBandWidthSizeResult =
        TransactionUtil.estimateConsumeBandWidthSize(dps, 0L);

    // Assert
    verify(dps).getMaxDelegateLockPeriod();
    verify(dps).supportMaxDelegateLockPeriod();
    assertEquals(275L, actualEstimateConsumeBandWidthSizeResult);
  }
}
