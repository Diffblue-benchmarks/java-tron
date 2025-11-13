package org.tron.core.db.api;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.ChainBaseManager;
import org.tron.core.capsule.ContractCapsule;
import org.tron.core.store.AbiStore;
import org.tron.core.store.ContractStore;
import org.tron.core.store.DynamicPropertiesStore;

@RunWith(MockitoJUnitRunner.class)
public class MoveAbiHelperDiffblueTest {
  @Mock private ChainBaseManager chainBaseManager;

  @InjectMocks private MoveAbiHelper moveAbiHelper;

  /**
   * Test {@link MoveAbiHelper#doWork()}.
   *
   * <p>Method under test: {@link MoveAbiHelper#doWork()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MoveAbiHelper.doWork()"})
  public void testDoWork() {
    // Arrange
    ContractStore contractStore = mock(ContractStore.class);

    ArrayList<Entry<byte[], ContractCapsule>> entryList = new ArrayList<>();
    when(contractStore.iterator()).thenReturn(entryList.iterator());

    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    doNothing().when(dynamicPropertiesStore).saveAbiMoveDone(anyLong());
    when(chainBaseManager.getDynamicPropertiesStore()).thenReturn(dynamicPropertiesStore);
    when(chainBaseManager.getAbiStore()).thenReturn(mock(AbiStore.class));
    when(chainBaseManager.getContractStore()).thenReturn(contractStore);

    // Act
    moveAbiHelper.doWork();

    // Assert
    verify(chainBaseManager).getAbiStore();
    verify(chainBaseManager).getContractStore();
    verify(chainBaseManager).getDynamicPropertiesStore();
    verify(contractStore).iterator();
    verify(dynamicPropertiesStore).saveAbiMoveDone(1L);
  }
}
