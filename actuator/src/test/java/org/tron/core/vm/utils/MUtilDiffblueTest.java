package org.tron.core.vm.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;
import org.tron.protos.Protocol;

public class MUtilDiffblueTest {
  /**
   * Method under test: {@link MUtil#transferAllToken(Repository, byte[], byte[])}
   */
  @Test
  public void testTransferAllToken() throws UnsupportedEncodingException {
    // Arrange
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAssetMapV2()).thenReturn(new HashMap<>());
    doNothing().when(accountCapsule).importAllAsset();
    when(accountCapsule.getInstance()).thenReturn(Protocol.Account.getDefaultInstance());
    RepositoryImpl deposit = mock(RepositoryImpl.class);
    doNothing().when(deposit).putAccountValue(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(deposit.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    byte[] fromAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    MUtil.transferAllToken(deposit, fromAddress, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(accountCapsule).getAssetMapV2();
    verify(accountCapsule, atLeast(1)).getInstance();
    verify(accountCapsule).importAllAsset();
    verify(deposit, atLeast(1)).getAccount(Mockito.<byte[]>any());
    verify(deposit, atLeast(1)).putAccountValue(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
  }

  /**
   * Method under test: {@link MUtil#transferAllToken(Repository, byte[], byte[])}
   */
  @Test
  public void testTransferAllToken2() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, Long> stringResultLongMap = new HashMap<>();
    stringResultLongMap.put("foo", 2L);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAssetMapV2()).thenReturn(stringResultLongMap);
    doNothing().when(accountCapsule).importAllAsset();
    when(accountCapsule.getInstance()).thenReturn(Protocol.Account.getDefaultInstance());
    RepositoryImpl deposit = mock(RepositoryImpl.class);
    doNothing().when(deposit).putAccountValue(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(deposit.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    byte[] fromAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    MUtil.transferAllToken(deposit, fromAddress, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(accountCapsule).getAssetMapV2();
    verify(accountCapsule, atLeast(1)).getInstance();
    verify(accountCapsule).importAllAsset();
    verify(deposit, atLeast(1)).getAccount(Mockito.<byte[]>any());
    verify(deposit, atLeast(1)).putAccountValue(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
  }

  /**
   * Method under test: {@link MUtil#transferAllToken(Repository, byte[], byte[])}
   */
  @Test
  public void testTransferAllToken3() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, Long> stringResultLongMap = new HashMap<>();
    stringResultLongMap.put("42", 1L);
    stringResultLongMap.put("foo", 2L);
    AccountCapsule accountCapsule = mock(AccountCapsule.class);
    when(accountCapsule.getAssetMapV2()).thenReturn(stringResultLongMap);
    doNothing().when(accountCapsule).importAllAsset();
    when(accountCapsule.getInstance()).thenReturn(Protocol.Account.getDefaultInstance());
    RepositoryImpl deposit = mock(RepositoryImpl.class);
    doNothing().when(deposit).putAccountValue(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
    when(deposit.getAccount(Mockito.<byte[]>any())).thenReturn(accountCapsule);
    byte[] fromAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act
    MUtil.transferAllToken(deposit, fromAddress, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(accountCapsule).getAssetMapV2();
    verify(accountCapsule, atLeast(1)).getInstance();
    verify(accountCapsule).importAllAsset();
    verify(deposit, atLeast(1)).getAccount(Mockito.<byte[]>any());
    verify(deposit, atLeast(1)).putAccountValue(Mockito.<byte[]>any(), Mockito.<AccountCapsule>any());
  }

  /**
   * Method under test: {@link MUtil#isNullOrEmpty(String)}
   */
  @Test
  public void testIsNullOrEmpty() {
    // Arrange, Act and Assert
    assertFalse(MUtil.isNullOrEmpty("Str"));
    assertTrue(MUtil.isNullOrEmpty(null));
    assertTrue(MUtil.isNullOrEmpty(""));
  }

  /**
   * Method under test: {@link MUtil#isNotNullOrEmpty(String)}
   */
  @Test
  public void testIsNotNullOrEmpty() {
    // Arrange, Act and Assert
    assertTrue(MUtil.isNotNullOrEmpty("Str"));
    assertFalse(MUtil.isNotNullOrEmpty(null));
    assertFalse(MUtil.isNotNullOrEmpty(""));
  }
}
