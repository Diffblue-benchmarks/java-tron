package org.tron.core.db.api;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.ChainBaseManager;

public class EnergyPriceHistoryLoaderDiffblueTest {
  /**
   * Test {@link EnergyPriceHistoryLoader#parseProposalsToStr()}.
   * <p>
   * Method under test: {@link EnergyPriceHistoryLoader#parseProposalsToStr()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String EnergyPriceHistoryLoader.parseProposalsToStr()"})
  public void testParseProposalsToStr() {
    // Arrange, Act and Assert
    assertEquals("0:100", (new EnergyPriceHistoryLoader(ChainBaseManager.getChainBaseManager())).parseProposalsToStr());
  }
}
