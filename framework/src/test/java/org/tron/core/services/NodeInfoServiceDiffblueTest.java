package org.tron.core.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.common.entity.NodeInfo;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.db.Manager;

@RunWith(MockitoJUnitRunner.class)
public class NodeInfoServiceDiffblueTest {
  @Mock
  private ChainBaseManager chainBaseManager;

  @Mock
  private Manager manager;

  @InjectMocks
  private NodeInfoService nodeInfoService;

  @Mock
  private WitnessProductBlockService witnessProductBlockService;

  /**
   * Method under test: {@link NodeInfoService#setBlockInfo(NodeInfo)}
   */
  @Test
  public void testSetBlockInfo() {
    // Arrange
    when(chainBaseManager.getSolidBlockId()).thenReturn(new BlockCapsule.BlockId());
    when(chainBaseManager.getHeadBlockId()).thenReturn(new BlockCapsule.BlockId());
    when(manager.fetchSyncBeginNumber()).thenReturn(1L);
    NodeInfo nodeInfo = new NodeInfo();

    // Act
    nodeInfoService.setBlockInfo(nodeInfo);

    // Assert
    verify(chainBaseManager).getHeadBlockId();
    verify(chainBaseManager).getSolidBlockId();
    verify(manager).fetchSyncBeginNumber();
    assertEquals("Num:0,ID:0000000000000000000000000000000000000000000000000000000000000000", nodeInfo.getBlock());
    assertEquals("Num:0,ID:0000000000000000000000000000000000000000000000000000000000000000",
        nodeInfo.getSolidityBlock());
    assertEquals(1L, nodeInfo.getBeginSyncNum());
  }

  /**
   * Method under test: {@link NodeInfoService#setBlockInfo(NodeInfo)}
   */
  @Test
  public void testSetBlockInfo2() {
    // Arrange
    BlockCapsule.BlockId blockId = mock(BlockCapsule.BlockId.class);
    when(blockId.getString()).thenReturn("String");
    when(chainBaseManager.getSolidBlockId()).thenReturn(blockId);
    when(chainBaseManager.getHeadBlockId()).thenReturn(new BlockCapsule.BlockId());
    when(manager.fetchSyncBeginNumber()).thenReturn(1L);
    NodeInfo nodeInfo = new NodeInfo();

    // Act
    nodeInfoService.setBlockInfo(nodeInfo);

    // Assert
    verify(chainBaseManager).getHeadBlockId();
    verify(chainBaseManager).getSolidBlockId();
    verify(blockId).getString();
    verify(manager).fetchSyncBeginNumber();
    assertEquals("Num:0,ID:0000000000000000000000000000000000000000000000000000000000000000", nodeInfo.getBlock());
    assertEquals("String", nodeInfo.getSolidityBlock());
    assertEquals(1L, nodeInfo.getBeginSyncNum());
  }

  /**
   * Method under test: {@link NodeInfoService#setBlockInfo(NodeInfo)}
   */
  @Test
  public void testSetBlockInfo3() {
    // Arrange
    BlockCapsule.BlockId blockId = mock(BlockCapsule.BlockId.class);
    when(blockId.getString()).thenReturn("String");
    BlockCapsule.BlockId blockId2 = mock(BlockCapsule.BlockId.class);
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
   * Method under test: {@link NodeInfoService#setCheatWitnessInfo(NodeInfo)}
   */
  @Test
  public void testSetCheatWitnessInfo() {
    // Arrange
    when(witnessProductBlockService.queryCheatWitnessInfo()).thenReturn(new HashMap<>());
    NodeInfo nodeInfo = new NodeInfo();

    // Act
    nodeInfoService.setCheatWitnessInfo(nodeInfo);

    // Assert that nothing has changed
    verify(witnessProductBlockService).queryCheatWitnessInfo();
    assertTrue(nodeInfo.getCheatWitnessInfoMap().isEmpty());
  }

  /**
   * Method under test: {@link NodeInfoService#setCheatWitnessInfo(NodeInfo)}
   */
  @Test
  public void testSetCheatWitnessInfo2() {
    // Arrange
    HashMap<String, WitnessProductBlockService.CheatWitnessInfo> stringCheatWitnessInfoMap = new HashMap<>();
    stringCheatWitnessInfoMap.put("foo", new WitnessProductBlockService.CheatWitnessInfo());
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
   * Method under test: {@link NodeInfoService#setCheatWitnessInfo(NodeInfo)}
   */
  @Test
  public void testSetCheatWitnessInfo3() {
    // Arrange
    HashMap<String, WitnessProductBlockService.CheatWitnessInfo> stringCheatWitnessInfoMap = new HashMap<>();
    stringCheatWitnessInfoMap.put("foo", mock(WitnessProductBlockService.CheatWitnessInfo.class));
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
}
