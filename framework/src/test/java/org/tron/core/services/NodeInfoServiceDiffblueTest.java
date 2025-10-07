package org.tron.core.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.common.entity.NodeInfo;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.db.Manager;
import org.tron.core.services.WitnessProductBlockService.CheatWitnessInfo;

@RunWith(MockitoJUnitRunner.class)
public class NodeInfoServiceDiffblueTest {
  @Mock private ChainBaseManager chainBaseManager;

  @Mock private Manager manager;

  @InjectMocks private NodeInfoService nodeInfoService;

  @Mock private WitnessProductBlockService witnessProductBlockService;

  /**
   * Test {@link NodeInfoService#setBlockInfo(NodeInfo)}.
   *
   * <p>Method under test: {@link NodeInfoService#setBlockInfo(NodeInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NodeInfoService.setBlockInfo(NodeInfo)"})
  public void testSetBlockInfo() {
    // Arrange
    when(chainBaseManager.getSolidBlockId()).thenReturn(new BlockId());
    when(chainBaseManager.getHeadBlockId()).thenReturn(new BlockId());
    when(manager.fetchSyncBeginNumber()).thenReturn(1L);
    NodeInfo nodeInfo = new NodeInfo();

    // Act
    nodeInfoService.setBlockInfo(nodeInfo);

    // Assert
    verify(chainBaseManager).getHeadBlockId();
    verify(chainBaseManager).getSolidBlockId();
    verify(manager).fetchSyncBeginNumber();
    assertEquals(
        "Num:0,ID:0000000000000000000000000000000000000000000000000000000000000000",
        nodeInfo.getBlock());
    assertEquals(
        "Num:0,ID:0000000000000000000000000000000000000000000000000000000000000000",
        nodeInfo.getSolidityBlock());
    assertEquals(1L, nodeInfo.getBeginSyncNum());
  }

  /**
   * Test {@link NodeInfoService#setBlockInfo(NodeInfo)}.
   *
   * <p>Method under test: {@link NodeInfoService#setBlockInfo(NodeInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NodeInfoService.setBlockInfo(NodeInfo)"})
  public void testSetBlockInfo2() {
    // Arrange
    BlockId blockId = mock(BlockId.class);
    when(blockId.getString()).thenReturn("String");
    when(chainBaseManager.getSolidBlockId()).thenReturn(blockId);
    when(chainBaseManager.getHeadBlockId()).thenReturn(new BlockId());
    when(manager.fetchSyncBeginNumber()).thenReturn(1L);
    NodeInfo nodeInfo = new NodeInfo();

    // Act
    nodeInfoService.setBlockInfo(nodeInfo);

    // Assert
    verify(chainBaseManager).getHeadBlockId();
    verify(chainBaseManager).getSolidBlockId();
    verify(blockId).getString();
    verify(manager).fetchSyncBeginNumber();
    assertEquals(
        "Num:0,ID:0000000000000000000000000000000000000000000000000000000000000000",
        nodeInfo.getBlock());
    assertEquals("String", nodeInfo.getSolidityBlock());
    assertEquals(1L, nodeInfo.getBeginSyncNum());
  }

  /**
   * Test {@link NodeInfoService#setBlockInfo(NodeInfo)}.
   *
   * <ul>
   *   <li>Then {@link NodeInfo} (default constructor) Block is {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link NodeInfoService#setBlockInfo(NodeInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NodeInfoService.setBlockInfo(NodeInfo)"})
  public void testSetBlockInfo_thenNodeInfoBlockIsString() {
    // Arrange
    BlockId blockId = mock(BlockId.class);
    when(blockId.getString()).thenReturn("String");

    BlockId blockId2 = mock(BlockId.class);
    when(blockId2.getString()).thenReturn("String");
    when(chainBaseManager.getSolidBlockId()).thenReturn(blockId2);
    when(chainBaseManager.getHeadBlockId()).thenReturn(blockId);
    when(manager.fetchSyncBeginNumber()).thenReturn(1L);
    NodeInfo nodeInfo = new NodeInfo();

    // Act
    nodeInfoService.setBlockInfo(nodeInfo);

    // Assert
    verify(chainBaseManager).getHeadBlockId();
    verify(chainBaseManager).getSolidBlockId();
    verify(blockId2).getString();
    verify(blockId).getString();
    verify(manager).fetchSyncBeginNumber();
    assertEquals("String", nodeInfo.getBlock());
    assertEquals("String", nodeInfo.getSolidityBlock());
    assertEquals(1L, nodeInfo.getBeginSyncNum());
  }

  /**
   * Test {@link NodeInfoService#setCheatWitnessInfo(NodeInfo)}.
   *
   * <p>Method under test: {@link NodeInfoService#setCheatWitnessInfo(NodeInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NodeInfoService.setCheatWitnessInfo(NodeInfo)"})
  public void testSetCheatWitnessInfo() {
    // Arrange
    HashMap<String, CheatWitnessInfo> stringCheatWitnessInfoMap = new HashMap<>();
    stringCheatWitnessInfoMap.put("foo", new CheatWitnessInfo());
    when(witnessProductBlockService.queryCheatWitnessInfo()).thenReturn(stringCheatWitnessInfoMap);
    NodeInfo nodeInfo = new NodeInfo();

    // Act
    nodeInfoService.setCheatWitnessInfo(nodeInfo);

    // Assert
    verify(witnessProductBlockService).queryCheatWitnessInfo();
    Map<String, String> cheatWitnessInfoMap = nodeInfo.getCheatWitnessInfoMap();
    assertEquals(1, cheatWitnessInfoMap.size());
    assertEquals(
        "{times=0, time=0, latestBlockNum=0, blockCapsuleSet=[]}", cheatWitnessInfoMap.get("foo"));
  }

  /**
   * Test {@link NodeInfoService#setCheatWitnessInfo(NodeInfo)}.
   *
   * <ul>
   *   <li>Then {@link NodeInfo} (default constructor) CheatWitnessInfoMap containsKey {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link NodeInfoService#setCheatWitnessInfo(NodeInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NodeInfoService.setCheatWitnessInfo(NodeInfo)"})
  public void testSetCheatWitnessInfo_thenNodeInfoCheatWitnessInfoMapContainsKeyFoo() {
    // Arrange
    HashMap<String, CheatWitnessInfo> stringCheatWitnessInfoMap = new HashMap<>();
    stringCheatWitnessInfoMap.put("foo", mock(CheatWitnessInfo.class));
    when(witnessProductBlockService.queryCheatWitnessInfo()).thenReturn(stringCheatWitnessInfoMap);
    NodeInfo nodeInfo = new NodeInfo();

    // Act
    nodeInfoService.setCheatWitnessInfo(nodeInfo);

    // Assert
    verify(witnessProductBlockService).queryCheatWitnessInfo();
    Map<String, String> cheatWitnessInfoMap = nodeInfo.getCheatWitnessInfoMap();
    assertEquals(1, cheatWitnessInfoMap.size());
    assertTrue(cheatWitnessInfoMap.containsKey("foo"));
  }

  /**
   * Test {@link NodeInfoService#setCheatWitnessInfo(NodeInfo)}.
   *
   * <ul>
   *   <li>When {@link NodeInfo} (default constructor).
   *   <li>Then {@link NodeInfo} (default constructor) CheatWitnessInfoMap Empty.
   * </ul>
   *
   * <p>Method under test: {@link NodeInfoService#setCheatWitnessInfo(NodeInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NodeInfoService.setCheatWitnessInfo(NodeInfo)"})
  public void testSetCheatWitnessInfo_whenNodeInfo_thenNodeInfoCheatWitnessInfoMapEmpty() {
    // Arrange
    when(witnessProductBlockService.queryCheatWitnessInfo()).thenReturn(new HashMap<>());
    NodeInfo nodeInfo = new NodeInfo();

    // Act
    nodeInfoService.setCheatWitnessInfo(nodeInfo);

    // Assert that nothing has changed
    verify(witnessProductBlockService).queryCheatWitnessInfo();
    assertTrue(nodeInfo.getCheatWitnessInfoMap().isEmpty());
  }
}
