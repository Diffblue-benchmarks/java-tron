package org.tron.core.net;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
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
import org.tron.core.net.peer.PeerConnection;
import org.tron.core.net.service.adv.AdvService;
import org.tron.p2p.P2pConfig;
import org.tron.p2p.P2pService;
import org.tron.p2p.stats.P2pStats;

@RunWith(MockitoJUnitRunner.class)
public class TronNetServiceDiffblueTest {
  @Mock private AdvService advService;

  @InjectMocks private TronNetService tronNetService;

  /**
   * Test {@link TronNetService#broadcast(Message)}.
   *
   * <ul>
   *   <li>Given {@link AdvService} {@link AdvService#broadcast(Message)} does nothing.
   *   <li>When {@code null}.
   *   <li>Then calls {@link AdvService#broadcast(Message)}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetService#broadcast(Message)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TronNetService.broadcast(Message)"})
  public void testBroadcast_givenAdvServiceBroadcastDoesNothing_whenNull_thenCallsBroadcast() {
    // Arrange
    doNothing().when(advService).broadcast(Mockito.<Message>any());

    // Act
    tronNetService.broadcast(null);

    // Assert
    verify(advService).broadcast(isNull());
  }

  /**
   * Test {@link TronNetService#hasIpv4Stack(Set)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetService#hasIpv4Stack(Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link InetAddress} {@link InetAddress#getByName(String)} return {@link
   *       InetAddress}.
   *   <li>Then calls {@link InetAddress#getByName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetService#hasIpv4Stack(Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TronNetService.hasIpv4Stack(Set)"})
  public void testHasIpv4Stack_givenInetAddressGetByNameReturnInetAddress_thenCallsGetByName()
      throws UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenReturn(mock(InetAddress.class));

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
   *
   * <ul>
   *   <li>Given {@link InetAddress} {@link InetAddress#getByName(String)} throw {@link
   *       UnknownHostException#UnknownHostException()}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetService#hasIpv4Stack(Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TronNetService.hasIpv4Stack(Set)"})
  public void testHasIpv4Stack_givenInetAddressGetByNameThrowUnknownHostException()
      throws UnknownHostException {
    // Arrange
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      mockInetAddress
          .when(() -> InetAddress.getByName(Mockito.<String>any()))
          .thenThrow(new UnknownHostException());

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
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TronNetService#hasIpv4Stack(Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TronNetService.hasIpv4Stack(Set)"})
  public void testHasIpv4Stack_whenHashSet_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(TronNetService.hasIpv4Stack(new HashSet<>()));
  }
}
