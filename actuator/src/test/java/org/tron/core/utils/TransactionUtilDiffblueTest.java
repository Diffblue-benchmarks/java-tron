package org.tron.core.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.api.GrpcAPI;
import org.tron.api.GrpcAPI.TransactionSignWeight;
import org.tron.core.exception.PermissionException;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Permission;
import org.tron.protos.Protocol.Transaction;
import org.tron.protos.Protocol.Transaction.Contract;

@RunWith(MockitoJUnitRunner.class)
public class TransactionUtilDiffblueTest {
  @InjectMocks
  private TransactionUtil transactionUtil;

  /**
   * Test {@link TransactionUtil#validAccountName(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#validAccountName(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionUtil.validAccountName(byte[])"})
  public void testValidAccountName_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(TransactionUtil.validAccountName("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionUtil#validAccountName(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#validAccountName(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionUtil.validAccountName(byte[])"})
  public void testValidAccountName_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertTrue(TransactionUtil.validAccountName(new byte[]{}));
  }

  /**
   * Test {@link TransactionUtil#validAccountName(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#validAccountName(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionUtil.validAccountName(byte[])"})
  public void testValidAccountName_whenNull() {
    // Arrange, Act and Assert
    assertTrue(TransactionUtil.validAccountName(null));
  }

  /**
   * Test {@link TransactionUtil#validAssetDescription(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#validAssetDescription(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionUtil.validAssetDescription(byte[])"})
  public void testValidAssetDescription_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(TransactionUtil.validAssetDescription("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionUtil#validAssetDescription(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#validAssetDescription(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionUtil.validAssetDescription(byte[])"})
  public void testValidAssetDescription_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertTrue(TransactionUtil.validAssetDescription(new byte[]{}));
  }

  /**
   * Test {@link TransactionUtil#validAssetDescription(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#validAssetDescription(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionUtil.validAssetDescription(byte[])"})
  public void testValidAssetDescription_whenNull() {
    // Arrange, Act and Assert
    assertTrue(TransactionUtil.validAssetDescription(null));
  }

  /**
   * Test {@link TransactionUtil#validUrl(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#validUrl(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionUtil.validUrl(byte[])"})
  public void testValidUrl_whenAxaxaxaxBytesIsUtf8_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(TransactionUtil.validUrl("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionUtil#validUrl(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#validUrl(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionUtil.validUrl(byte[])"})
  public void testValidUrl_whenEmptyArrayOfByte_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(TransactionUtil.validUrl(new byte[]{}));
  }

  /**
   * Test {@link TransactionUtil#validUrl(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#validUrl(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionUtil.validUrl(byte[])"})
  public void testValidUrl_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(TransactionUtil.validUrl(null));
  }

  /**
   * Test {@link TransactionUtil#validAccountId(byte[])}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#validAccountId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionUtil.validAccountId(byte[])"})
  public void testValidAccountId_whenA_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(TransactionUtil.validAccountId(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionUtil#validAccountId(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#validAccountId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionUtil.validAccountId(byte[])"})
  public void testValidAccountId_whenAxaxaxaxBytesIsUtf8_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(TransactionUtil.validAccountId("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionUtil#validAccountId(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#validAccountId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionUtil.validAccountId(byte[])"})
  public void testValidAccountId_whenEmptyArrayOfByte_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(TransactionUtil.validAccountId(new byte[]{}));
  }

  /**
   * Test {@link TransactionUtil#validAccountId(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#validAccountId(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionUtil.validAccountId(byte[])"})
  public void testValidAccountId_whenXaxaxaxBytesIsUtf8_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(TransactionUtil.validAccountId(" XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionUtil#validAssetName(byte[])}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#validAssetName(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionUtil.validAssetName(byte[])"})
  public void testValidAssetName_whenA_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(TransactionUtil.validAssetName(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TransactionUtil#validAssetName(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#validAssetName(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionUtil.validAssetName(byte[])"})
  public void testValidAssetName_whenAxaxaxaxBytesIsUtf8_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(TransactionUtil.validAssetName("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionUtil#validAssetName(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#validAssetName(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionUtil.validAssetName(byte[])"})
  public void testValidAssetName_whenEmptyArrayOfByte_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(TransactionUtil.validAssetName(new byte[]{}));
  }

  /**
   * Test {@link TransactionUtil#validAssetName(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#validAssetName(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionUtil.validAssetName(byte[])"})
  public void testValidAssetName_whenXaxaxaxBytesIsUtf8_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(TransactionUtil.validAssetName(" XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionUtil#validTokenAbbrName(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#validTokenAbbrName(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionUtil.validTokenAbbrName(byte[])"})
  public void testValidTokenAbbrName_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(TransactionUtil.validTokenAbbrName("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionUtil#validTokenAbbrName(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#validTokenAbbrName(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionUtil.validTokenAbbrName(byte[])"})
  public void testValidTokenAbbrName_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertFalse(TransactionUtil.validTokenAbbrName(new byte[]{}));
  }

  /**
   * Test {@link TransactionUtil#getContractRet(Transaction)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#getContractRet(Transaction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Transaction.Result.contractResult TransactionUtil.getContractRet(Transaction)"})
  public void testGetContractRet_whenDefaultInstance_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TransactionUtil.getContractRet(Transaction.getDefaultInstance()));
  }

  /**
   * Test {@link TransactionUtil#getCallTokenValue(Contract)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#getCallTokenValue(Transaction.Contract)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TransactionUtil.getCallTokenValue(Transaction.Contract)"})
  public void testGetCallTokenValue_whenDefaultInstance() {
    // Arrange, Act and Assert
    assertEquals(0L, TransactionUtil.getCallTokenValue(Contract.getDefaultInstance()));
  }

  /**
   * Test {@link TransactionUtil#getCallTokenValue(Contract)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#getCallTokenValue(Transaction.Contract)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TransactionUtil.getCallTokenValue(Transaction.Contract)"})
  public void testGetCallTokenValue_whenNull() {
    // Arrange, Act and Assert
    assertEquals(0L, TransactionUtil.getCallTokenValue(null));
  }

  /**
   * Test {@link TransactionUtil#generateContractAddress(byte[], byte[])} with {@code ownerAddress}, {@code txRawDataHash}.
   * <p>
   * Method under test: {@link TransactionUtil#generateContractAddress(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TransactionUtil.generateContractAddress(byte[], byte[])"})
  public void testGenerateContractAddressWithOwnerAddressTxRawDataHash() throws UnsupportedEncodingException {
    // Arrange
    byte[] ownerAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertArrayEquals(new byte[]{'A', '{', -23, 'i', -48, -7, -113, -47, '4', -19, -90, -77, -105, -79, '@', 'I', 'w',
        -34, '1', 'F', 16}, TransactionUtil.generateContractAddress(ownerAddress, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TransactionUtil#generateContractAddress(byte[], long)} with {@code transactionRootId}, {@code nonce}.
   * <p>
   * Method under test: {@link TransactionUtil#generateContractAddress(byte[], long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TransactionUtil.generateContractAddress(byte[], long)"})
  public void testGenerateContractAddressWithTransactionRootIdNonce() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'A', '<', '>', '0', 24, 23, 'F', -11, -104, 'F', 'M', 'h', 't', -120, -36, 'I', 't',
        -46, -43, 'D', '9'}, TransactionUtil.generateContractAddress("AXAXAXAX".getBytes("UTF-8"), 1L));
  }

  /**
   * Test {@link TransactionUtil#generateContractAddress(byte[], long)} with {@code transactionRootId}, {@code nonce}.
   * <p>
   * Method under test: {@link TransactionUtil#generateContractAddress(byte[], long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] TransactionUtil.generateContractAddress(byte[], long)"})
  public void testGenerateContractAddressWithTransactionRootIdNonce2() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'A', 't', -12, -77, '=', -82, -120, -19, 'h', 29, 'D', 'L', -110, -93, 'G', -68, 3, 4,
        -103, 'F', 'W'}, TransactionUtil.generateContractAddress(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1L));
  }

  /**
   * Test {@link TransactionUtil#checkPermissionOperations(Permission, Contract)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then throw {@link PermissionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#checkPermissionOperations(Permission, Transaction.Contract)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TransactionUtil.checkPermissionOperations(Permission, Transaction.Contract)"})
  public void testCheckPermissionOperations_whenDefaultInstance_thenThrowPermissionException()
      throws PermissionException {
    // Arrange
    Permission permission = Permission.getDefaultInstance();

    // Act and Assert
    assertThrows(PermissionException.class,
        () -> TransactionUtil.checkPermissionOperations(permission, Contract.getDefaultInstance()));
  }

  /**
   * Test {@link TransactionUtil#makeUpperCamelMethod(String)}.
   * <ul>
   *   <li>When {@code Origin Name}.</li>
   *   <li>Then return {@code getOrigin name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#makeUpperCamelMethod(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TransactionUtil.makeUpperCamelMethod(String)"})
  public void testMakeUpperCamelMethod_whenOriginName_thenReturnGetOriginName() {
    // Arrange, Act and Assert
    assertEquals("getOrigin name", TransactionUtil.makeUpperCamelMethod("Origin Name"));
  }

  /**
   * Test {@link TransactionUtil#makeUpperCamelMethod(String)}.
   * <ul>
   *   <li>When {@code __}.</li>
   *   <li>Then return {@code get}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#makeUpperCamelMethod(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TransactionUtil.makeUpperCamelMethod(String)"})
  public void testMakeUpperCamelMethod_whenUnderscoreUnderscore_thenReturnGet() {
    // Arrange, Act and Assert
    assertEquals("get", TransactionUtil.makeUpperCamelMethod("__"));
  }

  /**
   * Test {@link TransactionUtil#makeUpperCamelMethod(String)}.
   * <ul>
   *   <li>When {@code _}.</li>
   *   <li>Then return {@code get}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#makeUpperCamelMethod(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TransactionUtil.makeUpperCamelMethod(String)"})
  public void testMakeUpperCamelMethod_whenUnderscore_thenReturnGet() {
    // Arrange, Act and Assert
    assertEquals("get", TransactionUtil.makeUpperCamelMethod("_"));
  }

  /**
   * Test {@link TransactionUtil#getTransactionSignWeight(Transaction)}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#getTransactionSignWeight(Transaction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TransactionSignWeight TransactionUtil.getTransactionSignWeight(Transaction)"})
  public void testGetTransactionSignWeight_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    TransactionSignWeight actualTransactionSignWeight = transactionUtil
        .getTransactionSignWeight(Transaction.getDefaultInstance());

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
    assertTrue(actualTransactionSignWeight.isInitialized());
  }

  /**
   * Test {@link TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TransactionUtil.estimateConsumeBandWidthSize(DynamicPropertiesStore, long)"})
  public void testEstimateConsumeBandWidthSize_givenFalse() {
    // Arrange
    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.supportMaxDelegateLockPeriod()).thenReturn(false);

    // Act
    long actualEstimateConsumeBandWidthSizeResult = TransactionUtil.estimateConsumeBandWidthSize(dps, 42L);

    // Assert
    verify(dps).supportMaxDelegateLockPeriod();
    assertEquals(275L, actualEstimateConsumeBandWidthSizeResult);
  }

  /**
   * Test {@link TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}.
   * <ul>
   *   <li>Given {@link Long#MAX_VALUE}.</li>
   *   <li>Then return two hundred eighty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TransactionUtil.estimateConsumeBandWidthSize(DynamicPropertiesStore, long)"})
  public void testEstimateConsumeBandWidthSize_givenMax_value_thenReturnTwoHundredEightyFive() {
    // Arrange
    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.getMaxDelegateLockPeriod()).thenReturn(Long.MAX_VALUE);
    when(dps.supportMaxDelegateLockPeriod()).thenReturn(true);

    // Act
    long actualEstimateConsumeBandWidthSizeResult = TransactionUtil.estimateConsumeBandWidthSize(dps, 42L);

    // Assert
    verify(dps).getMaxDelegateLockPeriod();
    verify(dps).supportMaxDelegateLockPeriod();
    assertEquals(285L, actualEstimateConsumeBandWidthSizeResult);
  }

  /**
   * Test {@link TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}.
   * <ul>
   *   <li>Given minus one.</li>
   *   <li>Then return two hundred eighty-six.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TransactionUtil.estimateConsumeBandWidthSize(DynamicPropertiesStore, long)"})
  public void testEstimateConsumeBandWidthSize_givenMinusOne_thenReturnTwoHundredEightySix() {
    // Arrange
    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.getMaxDelegateLockPeriod()).thenReturn(-1L);
    when(dps.supportMaxDelegateLockPeriod()).thenReturn(true);

    // Act
    long actualEstimateConsumeBandWidthSizeResult = TransactionUtil.estimateConsumeBandWidthSize(dps, 42L);

    // Assert
    verify(dps).getMaxDelegateLockPeriod();
    verify(dps).supportMaxDelegateLockPeriod();
    assertEquals(286L, actualEstimateConsumeBandWidthSizeResult);
  }

  /**
   * Test {@link TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return two hundred seventy-seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TransactionUtil.estimateConsumeBandWidthSize(DynamicPropertiesStore, long)"})
  public void testEstimateConsumeBandWidthSize_givenOne_thenReturnTwoHundredSeventySeven() {
    // Arrange
    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.getMaxDelegateLockPeriod()).thenReturn(1L);
    when(dps.supportMaxDelegateLockPeriod()).thenReturn(true);

    // Act
    long actualEstimateConsumeBandWidthSizeResult = TransactionUtil.estimateConsumeBandWidthSize(dps, 42L);

    // Assert
    verify(dps).getMaxDelegateLockPeriod();
    verify(dps).supportMaxDelegateLockPeriod();
    assertEquals(277L, actualEstimateConsumeBandWidthSizeResult);
  }

  /**
   * Test {@link TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return two hundred seventy-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransactionUtil#estimateConsumeBandWidthSize(DynamicPropertiesStore, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long TransactionUtil.estimateConsumeBandWidthSize(DynamicPropertiesStore, long)"})
  public void testEstimateConsumeBandWidthSize_whenZero_thenReturnTwoHundredSeventyFive() {
    // Arrange
    DynamicPropertiesStore dps = mock(DynamicPropertiesStore.class);
    when(dps.getMaxDelegateLockPeriod()).thenReturn(1L);
    when(dps.supportMaxDelegateLockPeriod()).thenReturn(true);

    // Act
    long actualEstimateConsumeBandWidthSizeResult = TransactionUtil.estimateConsumeBandWidthSize(dps, 0L);

    // Assert
    verify(dps).getMaxDelegateLockPeriod();
    verify(dps).supportMaxDelegateLockPeriod();
    assertEquals(275L, actualEstimateConsumeBandWidthSizeResult);
  }
}
