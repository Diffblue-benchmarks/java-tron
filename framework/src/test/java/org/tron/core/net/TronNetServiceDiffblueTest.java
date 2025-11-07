package org.tron.core.net;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.common.overlay.message.Message;
import org.tron.core.net.message.adv.TransactionMessage;
import org.tron.core.net.message.keepalive.PingMessage;
import org.tron.core.net.service.adv.AdvService;

@RunWith(MockitoJUnitRunner.class)
public class TronNetServiceDiffblueTest {
  @Mock
  private AdvService advService;

  @InjectMocks
  private TronNetService tronNetService;

  /**
   * Test {@link TronNetService#broadcast(Message)}.
   * <p>
   * Method under test: {@link TronNetService#broadcast(Message)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TronNetService.broadcast(Message)"})
  public void testBroadcast() {
    // Arrange
    doNothing().when(advService).broadcast(Mockito.<Message>any());

    // Act
    tronNetService.broadcast(new PingMessage());

    // Assert
    verify(advService).broadcast(isA(Message.class));
  }

  /**
   * Test {@link TronNetService#fastBroadcastTransaction(TransactionMessage)}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronNetService#fastBroadcastTransaction(TransactionMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TronNetService.fastBroadcastTransaction(TransactionMessage)"})
  public void testFastBroadcastTransaction_thenReturnOne() {
    // Arrange
    when(advService.fastBroadcastTransaction(Mockito.<TransactionMessage>any())).thenReturn(1);

    // Act
    int actualFastBroadcastTransactionResult = tronNetService.fastBroadcastTransaction(null);

    // Assert
    verify(advService).fastBroadcastTransaction(isNull());
    assertEquals(1, actualFastBroadcastTransactionResult);
  }

  /**
   * Test {@link TronNetService#hasIpv4Stack(Set)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronNetService#hasIpv4Stack(Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronNetService.hasIpv4Stack(Set)"})
  public void testHasIpv4Stack_given42_whenLinkedHashSetAdd42_thenReturnTrue() {
    // Arrange
    LinkedHashSet<String> ipSet = new LinkedHashSet<>();
    ipSet.add("42");

    // Act and Assert
    assertTrue(TronNetService.hasIpv4Stack(ipSet));
  }

  /**
   * Test {@link TronNetService#hasIpv4Stack(Set)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.</li>
   *   <li>Then calls {@link InetAddress#getByName(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronNetService#hasIpv4Stack(Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronNetService.hasIpv4Stack(Set)"})
  public void testHasIpv4Stack_givenFoo_whenHashSetAdd42_thenCallsGetByName() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(mock(InetAddress.class));

      HashSet<String> ipSet = new HashSet<>();
      ipSet.add("42");
      ipSet.add("foo");

      // Act
      boolean actualHasIpv4StackResult = TronNetService.hasIpv4Stack(ipSet);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      assertFalse(actualHasIpv4StackResult);
    }
  }

  /**
   * Test {@link TronNetService#hasIpv4Stack(Set)}.
   * <ul>
   *   <li>Given {@link InetAddress} {@link InetAddress#getByName(String)} return {@link InetAddress}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronNetService#hasIpv4Stack(Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronNetService.hasIpv4Stack(Set)"})
  public void testHasIpv4Stack_givenInetAddressGetByNameReturnInetAddress() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(mock(InetAddress.class));

      LinkedHashSet<String> ipSet = new LinkedHashSet<>();
      ipSet.add("Ip Set");

      // Act
      boolean actualHasIpv4StackResult = TronNetService.hasIpv4Stack(ipSet);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      assertFalse(actualHasIpv4StackResult);
    }
  }

  /**
   * Test {@link TronNetService#hasIpv4Stack(Set)}.
   * <ul>
   *   <li>Given {@link InetAddress} {@link InetAddress#getByName(String)} throw {@link UnknownHostException#UnknownHostException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronNetService#hasIpv4Stack(Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronNetService.hasIpv4Stack(Set)"})
  public void testHasIpv4Stack_givenInetAddressGetByNameThrowUnknownHostExceptionWithFoo() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenThrow(new UnknownHostException("foo"));

      LinkedHashSet<String> ipSet = new LinkedHashSet<>();
      ipSet.add("Ip Set");

      // Act
      boolean actualHasIpv4StackResult = TronNetService.hasIpv4Stack(ipSet);

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      assertFalse(actualHasIpv4StackResult);
    }
  }

  /**
   * Test {@link TronNetService#hasIpv4Stack(Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronNetService#hasIpv4Stack(Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TronNetService.hasIpv4Stack(Set)"})
  public void testHasIpv4Stack_whenHashSet_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(TronNetService.hasIpv4Stack(new HashSet<>()));
  }
}
