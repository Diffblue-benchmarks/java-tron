package org.tron.core.net.service.fetchblock;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.net.peer.PeerConnection;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class FetchBlockServiceDiffblueTest {
  @Mock
  private ChainBaseManager chainBaseManager;

  @InjectMocks
  private FetchBlockService fetchBlockService;

  /**
   * Test {@link FetchBlockService#fetchBlock(List, PeerConnection)}.
   * <ul>
   *   <li>Given {@link ChainBaseManager} {@link ChainBaseManager#getHeadBlockNum()} return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FetchBlockService#fetchBlock(List, PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FetchBlockService.fetchBlock(List, PeerConnection)"})
  public void testFetchBlock_givenChainBaseManagerGetHeadBlockNumReturnMinusOne() {
    // Arrange
    when(chainBaseManager.getHeadBlockNum()).thenReturn(-1L);

    ArrayList<Sha256Hash> sha256HashList = new ArrayList<>();
    sha256HashList.add(new BlockId());
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));

    // Act
    fetchBlockService.fetchBlock(sha256HashList, peer);

    // Assert
    verify(chainBaseManager).getHeadBlockNum();
    verify(peer, atLeast(1)).getInetAddress();
  }

  /**
   * Test {@link FetchBlockService#fetchBlock(List, PeerConnection)}.
   * <ul>
   *   <li>Then calls {@link ChainBaseManager#getHeadBlockNum()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FetchBlockService#fetchBlock(List, PeerConnection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FetchBlockService.fetchBlock(List, PeerConnection)"})
  public void testFetchBlock_thenCallsGetHeadBlockNum() {
    // Arrange
    when(chainBaseManager.getHeadBlockNum()).thenReturn(1L);

    ArrayList<Sha256Hash> sha256HashList = new ArrayList<>();
    sha256HashList.add(new BlockId());
    PeerConnection peer = mock(PeerConnection.class);
    when(peer.getInetAddress()).thenReturn(mock(InetAddress.class));

    // Act
    fetchBlockService.fetchBlock(sha256HashList, peer);

    // Assert
    verify(chainBaseManager).getHeadBlockNum();
    verify(peer).getInetAddress();
  }
}
