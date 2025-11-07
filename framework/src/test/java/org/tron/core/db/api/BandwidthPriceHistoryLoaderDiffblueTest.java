package org.tron.core.db.api;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.ChainBaseManager;

public class BandwidthPriceHistoryLoaderDiffblueTest {
  /**
   * Test {@link BandwidthPriceHistoryLoader#parseProposalsToStr()}.
   * <p>
   * Method under test: {@link BandwidthPriceHistoryLoader#parseProposalsToStr()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String BandwidthPriceHistoryLoader.parseProposalsToStr()"})
  public void testParseProposalsToStr() {
    // Arrange, Act and Assert
    assertEquals("0:10",
        (new BandwidthPriceHistoryLoader(ChainBaseManager.getChainBaseManager())).parseProposalsToStr());
  }
}
