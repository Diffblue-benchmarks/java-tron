package org.tron.core.db.api;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.junit.Test;
import org.mockito.Mockito;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.ContractCapsule;
import org.tron.core.store.ContractStore;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.contract.SmartContractOuterClass;

public class MoveAbiHelperDiffblueTest {
  /**
   * Method under test: {@link MoveAbiHelper#doWork()}
   */
  @Test
  public void testDoWork() {
    // Arrange
    ArrayList<Map.Entry<byte[], ContractCapsule>> entryList = new ArrayList<>();
    entryList.add(new AbstractMap.SimpleEntry<>(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        new ContractCapsule(SmartContractOuterClass.SmartContract.getDefaultInstance())));
    Iterator<Map.Entry<byte[], ContractCapsule>> iteratorResult = entryList.iterator();
    ContractStore contractStore = mock(ContractStore.class);
    doNothing().when(contractStore).put(Mockito.<byte[]>any(), Mockito.<ContractCapsule>any());
    when(contractStore.iterator()).thenReturn(iteratorResult);
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveAbiMoveDone(anyLong());
    ChainBaseManager chainBaseManager = mock(ChainBaseManager.class);
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(chainBaseManager.getAbiStore()).thenReturn(null);
    when(chainBaseManager.getContractStore()).thenReturn(contractStore);

    // Act
    (new MoveAbiHelper(chainBaseManager)).doWork();

    // Assert
    verify(chainBaseManager).getAbiStore();
    verify(chainBaseManager).getContractStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(contractStore).iterator();
    verify(contractStore).put(isA(byte[].class), isA(ContractCapsule.class));
    verify(dynamicPropertiesStore).saveAbiMoveDone(eq(1L));
  }
}
