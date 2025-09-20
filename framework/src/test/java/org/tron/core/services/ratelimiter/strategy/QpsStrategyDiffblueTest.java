package org.tron.core.services.ratelimiter.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.services.ratelimiter.strategy.Strategy.ParamItem;

public class QpsStrategyDiffblueTest {
  /**
   * Test {@link QpsStrategy#QpsStrategy(String)}.
   *
   * <p>Method under test: {@link QpsStrategy#QpsStrategy(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QpsStrategy.<init>(String)"})
  public void testNewQpsStrategy() {
    // Arrange, Act and Assert
    Map<String, ParamItem> mapParams = new QpsStrategy("qps=42").getMapParams();
    assertEquals(1, mapParams.size());
    ParamItem getResult = mapParams.get(QpsStrategy.STRATEGY_PARAM_QPS);
    assertEquals(42.0d, ((Double) getResult.value).doubleValue(), 0.0);
    Class<Double> expectedResultClass = Double.class;
    assertEquals(expectedResultClass, getResult.type);
  }

  /**
   * Test {@link QpsStrategy#acquire()}.
   *
   * <p>Method under test: {@link QpsStrategy#acquire()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QpsStrategy.acquire()"})
  public void testAcquire() {
    // Arrange, Act and Assert
    assertTrue(new QpsStrategy("qps=42").acquire());
  }
}
